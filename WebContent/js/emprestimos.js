var globalResponse;
function requestServer(data) {	
	$.ajax({
		url: '/biblioteca/RegistrarEmprestimosServlet',
		type: 'POST',
		data: {
			acao: 'PESQUISA', 
			busca: $('#busca').val()
		},
		dataType: 'json',
		timeout: 5000,
		async: false,
		error: function(response) {
			console.log(response);
		},
		success: function(response) {
			globalResponse = response;
			console.log(response);
		}
	});
}

$('#pesquisa').on('click', function() {
	requestServer();
});