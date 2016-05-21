var global_id;
function requestServer(data) {
	return $.ajax({
		url: '/biblioteca/ClienteServlet',
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
$("#pesquisar_cliente").on('click',function() {
	var data = {acao: 'PESQUISA', busca: $('#busca').val()};
	var response = requestServer(data).responseJSON;
	console.warn(response);
	montarListacliente(response);
});

$("#incluir_cliente").on('click',function() {
	var data = {
				acao: 'INCLUIR',
				nome: $('#nome').val(),
				tipo: $('#tipo').val()
			};

	var response = requestServer(data);
	$("#gridSystemModalLabel").val("Cadastrar cliente");
});
function montarListacliente(data) {
	var html = "";
	for (var i in data) {
		html += "<tr id=" + data[i].id + ">" +
				"	<td id='id_" + data[i].id + "'       data-val='" + data[i].id       +"'>"+ data[i].id   +"</td>" +
		 		"	<td id='nome_" + data[i].id + "'     data-val='" + data[i].nome     +"'>"+ data[i].nome +"</td>" +
		 		"	<td id='tipo_" + data[i].id + "'     data-val='" + data[i].tipo     +"'>"+ data[i].tipo +"</td>" +
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
		
		$("#incluir_cliente").attr('id','alterar_cliente');
		$("#id_atual").val(id_atual);
		$("#nome").val($("#nome_"+id_atual).attr('data-val'));
		$("#tipo").val($("#tipo_"+id_atual).attr('data-val'));
		
		console.log('testexxxx');
		$("#modal_inclui_cliente").trigger('click');
		$("#incluir_cliente").attr('id','alterar_cliente');
	});



}
$("#modal_inclui_cliente").click(function() {
	$('.abreModal').modal();
});

$("#alterar_cliente").on('click',function() {
	
	$("#gridSystemModalLabel").html("Alterar cliente");
	var data = {
			acao: 'ALTERAR',
			id: $("#id_atual").val(),
			nome: $('#nome').val(),
			tipo: $('#tipo').val()
		};
	
	var response = requestServer(data);
	
});