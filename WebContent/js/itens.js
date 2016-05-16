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
});

function montarListaitem(data) {
	var html = "";
	for (var i in data) {
		html += "<tr id=" + data[i].id + ">" +
		 		"	<td>"+ data[i].nome +"</td>" +
		 		"	<td>"+ data[i].tipo +"</td>" +
		 		"	<td>"+ data[i].status +"</td>" +
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
		
	});



}

