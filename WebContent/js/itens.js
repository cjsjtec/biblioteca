var global_id;
function requestServer(data) {
	return $.ajax({
		url: '/biblioteca/ListarItensServlet',
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
	});
}
$("#pesquisar_item").on('click',function() {
	var data = {acao: 'PESQUISA', busca: $('#busca').val()};
	var response = requestServer(data).responseJSON;
	montarListaitem(response);
});

$("#incluir_item").on('click',function() {
	var data = {
				acao: 'INCLUIR',
				nome: $('#nome').val(),
				tipo: $('#tipo').val(),
				status: $('#status').val(),
				especial: $('#especial').val()
			};
	
	var response = requestServer(data);
	$("#gridSystemModalLabel").val("Cadastrar Item");
});
function montarListaitem(data) {
	var html = "";
	for (var i in data) {
		html += "<tr id=" + data[i].id + ">" +
		 		"	<td id='nome_" + data[i].id + "'     data-val='" + data[i].nome     +"'>"+ data[i].nome     +"</td>" +
		 		"	<td id='tipo_" + data[i].id + "'     data-val='" + data[i].tipo     +"'>"+ data[i].tipo     +"</td>" +
		 		"	<td id='status_" + data[i].id + "'   data-val='" + data[i].status   +"'>"+ data[i].status   +"</td>" +
		 		"	<td id='especial_" + data[i].id + "' data-val='" + data[i].especial +"'>"+ data[i].especial +"</td>" +
		 		"	<td><span class='glyphicon glyphicon-pencil'></span> <span class='glyphicon glyphicon-trash pull-right'></span></td>" +
				"</tr>";
	}
	
	$("table.table tbody").html(html).closest('.row').removeClass('hidden');
	
	$(".glyphicon-trash").click( function() {
		var $elem = $(this);
		var data = {
			acao: "REMOVER",
			id: $elem.closest('tr').attr('id')
		};
		var response = requestServer(data);	
		$elem.closest('tr').remove();
	});
	
	$(".glyphicon-pencil").on('click', function() {
		$elm = $(this);
		var id_atual = $elm.closest('tr').attr('id');
		
		$("#incluir_item").attr('id','alterar_item');
		$("#id_atual").val(id_atual);
		$("#nome").val($("#nome_"+id_atual).attr('data-val'));
		$("#tipo").val($("#tipo_"+id_atual).attr('data-val'));
		$("#status").val($("#status_"+id_atual).attr('data-val'));
		$("#especial").val($("#especial_"+id_atual).attr('data-val'));
		
		console.log('teste');
		$("#modal_inclui_item").trigger('click');
		$("#incluir_item").attr('id','alterar_item');
	});



}
$("#modal_inclui_item").click(function() {
	$('.abreModal').modal();
});

$("#alterar_item").on('click',function() {
	console.log('teste_2');
	$("#gridSystemModalLabel").html("Alterar Item");
	var data = {
			acao: 'ALTERAR',
			id: $("#id_atual").val(),
			nome: $('#nome').val(),
			tipo: $('#tipo').val(),
			status: $('#status').val(),
			especial: $('#especial').val()
		};
	
	var response = requestServer(data);
	
});