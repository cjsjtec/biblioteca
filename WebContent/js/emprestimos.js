var selecionados = [];
function requestServer(data) {
	return $.ajax({
		url: '/biblioteca/RegistrarEmprestimosServlet',
		type: 'POST',
		data: data,
		dataType: 'json',
		timeout: 5000,
		async: false,
		error: function(response) {
			console.log('ERRO AJAX - ', response);
		},
		success: function(resp) {
			return resp;
		}
	}).responseJSON;
}

$('.btn-default').on('click', function() {
	
	if($("input[type=radio][name=acao]:checked").val() == "E") {
		var data = {acao: 'PESQUISA',busca: $("#busca").val()};
		var response = requestServer(data);
		montarListaitem(response);
	} else {		
		var data = {acao: 'EMPRESTADOS',identificacao: $("#idCLiente").val()};
		var response = requestServer(data);
		console.log(response);
		
		montarListaEmprestados(response);
	}
});

function remontar() {
	var html = "";
	
	if(selecionados.length > 0){
		for(var i in selecionados) {
			html += "<li class='list-group-item'>"+selecionados[i].idItem+"<span class='pull-right'>"+selecionados[i].nome+"</span></li>";
		}
	}
	$('#itensSelecionados').html(html).show();
}

var addPopEmprestar = function (id, descricao, remover) {
	
	if(remover === false) {
		selecionados.splice(selecionados.length, 0, {idItem: id, nome: descricao});
	} else {
		for(var i in selecionados) {
			if(id === selecionados[i].idItem) {
				selecionados.splice(i, 1);
			}
		}
	}	
	remontar();
}

var addPopDevolver = function(id, idCliente,idItem,nome,remover) {
	
	if(remover === false) {
		selecionados.splice(selecionados.length, 0, {id: id, idCliente: idCliente, idItem: idItem, nome: nome});
	} else {
		for(var i in selecionados) {
			if(id === selecionados[i].id) {
				selecionados.splice(i, 1);
			}
		}
	}
	console.log(selecionados);
}

function montarListaitem(data) {
	var html = "<thead>"+
				 "<tr>"+
					 "<th>Nome</th>"+
					 "<th>Tipo</th>"+
					 "<th>Especial</th>"+
					 "<th></th>"+
				 "</tr>"+
				"</thead>"+
				"<tbody>";
	
	for (var i in data) {
		html += "<tr>" +
		 		"	<td>"+ data[i].nome +"</td>" +
		 		"	<td>"+ ((data[i].tipo == "R") ? "Revista" : "Livro") +"</td>" +
		 		"	<td>"+ ((data[i].especial == "S") ? "Sim" : "Nao" )+"</td>" +
		 		"	<td><input type='checkbox' name='chkEmprestar' data-desc='"+data[i].nome+"' data-id='" + data[i].id + "'></td>" +
				"</tr>";
	}
	
	html += "</tbody>";
	$("table.table").html(html).closest('.row').removeClass('hidden');

	$('input[type=checkbox][name=chkEmprestar]').click(function(event) {
		var elemento = $(this);
		
		if(elemento.is(':checked')) {
			if(selecionados.length === 3)  {
				modal.alerta("Aviso!", "Permitido somente 3 itens para emprestimo");
				return false;
			}
			
			elemento.closest('tr').addClass('success');	
			addPopEmprestar(elemento.data('id'), elemento.data('desc'), false);
		} else {
			elemento.closest('tr').removeClass('success');
			addPopEmprestar(elemento.data('id'), elemento.data('desc'), true);
		}
		
	});
}

var montarListaEmprestados = function(data) {
	console.log(data);
	var html = "<thead>"+
				 "<tr>"+
					 "<th>Nome do item</th>"+
					 "<th>Id do item</th>"+
					 "<th></th>"+
				 "</tr>"+
				"</thead>"+
				"<tbody>";
			
	for (var i in data) {
	html += "<tr>" +
		"	<td>"+ data[i].nome +"</td>" +
		"	<td>"+ data[i].idItem  +"</td>" +

		"	<td><input type='checkbox' data-id='"+data[i].id+"' data-idcliente='"+data[i].idCliente+"' data-iditem='"+data[i].idItem+"' data-nome='"+data[i].nome+"' name='chkDevolver'></td>" +
		"</tr>";
	}
	
	html += "</tbody>";
	$("table.table").html(html).closest('.row').removeClass('hidden');
	
	
	$('input[type=checkbox][name=chkDevolver]').click(function(event) {
		var elemento = $(this);
		
		if(elemento.is(':checked')) {
			elemento.closest('tr').addClass('success');
			addPopDevolver(elemento.data('id'), elemento.data('idcliente'), elemento.data('iditem'),elemento.data('nome'),false);
		} else {
			elemento.closest('tr').removeClass('success');
			addPopDevolver(elemento.data('id'), true);
		}
		
	});
	
}
var registrarEmprestimo = function() {
	montaPopUpEmprestimo();
}

var montaPopUpEmprestimo = function() {
	if(selecionados.length < 1) {
		modal.alerta("Aviso", "Selecione ao menos um item para efetuar o emprestimo");
		return false;
	}
	modal.registrar();
}
var devolver = function() {
	if(selecionados.length < 1) {
		modal.alerta("Aviso", "Selecione ao menos um item para efetuar a devolucao");
		return false;
	}
	var data = {acao: "DEVOLVER", selecionados: JSON.stringify(selecionados)};
	
	var response = requestServer(data)
	
	if(response.successo) {
		modal.alerta("Sucesso!", response.successo);
	}
	$('#idCLiente').val("");
	$("table.table").closest('.row').addClass('hidden');
	
	console.log(response);
}

$('#btn_registrar').on('click', montaPopUpEmprestimo);
$('#btn_registrar_devolucao').on('click', devolver);

var analisarEmprestimo = function() {
	if($("#documentoCliente").val() == "") {
		$('.modal-body .alert').remove()
		var erro = "<div class='alert alert-danger' >Preencha o documento</div>";
		$('.modal-body').prepend(erro)
		return false;
	}
	
	var data = {
		acao: 'ANALISAREMPRESTIMO',
		documento: $('#documentoCliente').val(),
		selecionados: JSON.stringify(selecionados)
	};
	
	var response = requestServer(data);
	
	if(response.intervencao) {
		var msg = "<div class='alert alert-danger'>"+response.intervencao+"</div>";
		$('.modal-body').prepend(msg);		
	} else if(response.recusados) {
		var msg = "<div class='alert alert-danger'>Itens recusados";
		
		for(i in response.recusados) {
			msg += "<li>"+response.recusados[i]+"</li>";
		}
		msg += "</div>";
		$('.modal-body').prepend(msg);
	} else {
		var msg = "<div class='alert alert-success'>Itens registrados com sucesso!</div>";
	
		$('.modal-body').prepend(msg);3
		
		setTimeout(function() {
			$("#modalRegistrar").modal('hide');
		}, 1500);
				
	}

	$("table.table").closest('.row').addClass('hidden');
	$("#busca").val("");
	
	selecionados = [];
	remontar();	
}

$('input[type=radio][name=acao]').on('click', function() {
	selecionados = [];
	$("table.table").closest('.row').addClass('hidden');
	if($(this).val() == "D") {
		$('#sessaoDevolve').removeClass("hidden");
		$('#sessaoEmprestar').addClass("hidden");
		$('.descricao-titulo').html("Registrar devolucao");
	} else {
		$('#sessaoEmprestar').removeClass("hidden");
		$('#sessaoDevolve').addClass("hidden");
		$('.descricao-titulo').html("Registrar emprestimo");
	}
});


