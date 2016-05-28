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
			console.log(response);
		},
		success: function(resp) {
			return resp;
		}
	}).responseJSON;
}

$('#pesquisa').on('click', function() {
	var data = {acao: 'PESQUISA',busca: $('#busca').val()};
	var response = requestServer(data);
	montarListaitem(response);
});

function remontar() {
	var html = "";
	for(var i in selecionados) {
		html += "<li class='list-group-item'>"+selecionados[i].idItem+"<span class='pull-right'>"+selecionados[i].nome+"</span></li>";
	}
	$('#itensSelecionados').html(html).show();
}

var addPop = function (id, descricao, remover) {	
	
	if(remover === false) {
		selecionados.splice(selecionados.length, 0, {idItem: id, nome: descricao});
	} else {
		for(var i in selecionados) {
			if(id === selecionados[i].id) {
				selecionados.splice(i, 1);
			}
		}
	}
	
	remontar();
}

function montarListaitem(data) {
	var html = "";
	for (var i in data) {
		html += "<tr>" +
		 		"	<td>"+ data[i].nome +"</td>" +
		 		"	<td>"+ data[i].tipo +"</td>" +
		 		"	<td>"+ data[i].status +"</td>" +
		 		"	<td><input type='checkbox' class='checado' data-desc='"+data[i].nome+"' data-id='" + data[i].id + "'></td>" +
				"</tr>";
	}
	$("table.table tbody").html(html).closest('.row').removeClass('hidden');

	$('input[type=checkbox]').click(function(event) {		
		var test = event;
		var elemento = $(this);
		
		if(elemento.is(':checked')) {
			if(selecionados.length === 3) return false;
			
			elemento.closest('tr').addClass('success');	
			addPop(elemento.data('id'), elemento.data('desc'), false);
		} else {
			elemento.closest('tr').removeClass('success');
			addPop(elemento.data('id'), elemento.data('desc'), true);
		}
		
	});
}
var registrarEmprestimo = function() {
	montaPopEmprestimo();
}

var montaPopEmprestimo = function() {
	if(selecionados.length < 1) {
		modal.alerta("Aviso", "Selecione ao menos um item para efetuar o emprestimo");
		return false;
	}

	modal.registrar();
}

$('#btn_registrar').on('click', montaPopEmprestimo);

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
	
	requestServer(data);
	
	$("#modalRegistrar").modal('hide');
}


