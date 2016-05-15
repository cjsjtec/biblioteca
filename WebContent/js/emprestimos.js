//var globalResponse;
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

function montarListaitem(data) {
	var html = "";
	for (var i in data) {
		html += "<tr>" +
		 		"	<td>"+ data[i].nome +"</td>" +
		 		"	<td>"+ data[i].tipo +"</td>" +
		 		"	<td>"+ data[i].status +"</td>" +
		 		"	<td><input type='checkbox' class='checado' data-id='" + data[i].id + "'></td>" +
				"</tr>";
	}
	$("table.table tbody").html(html).closest('.row').removeClass('hidden');

	$('input[type=checkbox]').click(function() {
		var elemento = $(this);
		
		elemento.closest('tr').removeClass('success');
		
		if(elemento.is(':checked')) {
			elemento.closest('tr').addClass('success');	
		}
		
	});
}


