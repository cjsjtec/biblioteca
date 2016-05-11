function requestServer(data) {
	
	$.ajax({
		url: '/biblioteca/RegistrarEmprestimosServlet',
		data:{'teste':'xpto'},
		type: 'POST',
		dataType: 'json',
		timeout: 5000,
		error: function(response) {
			console.log(response);
		},
		success: function(response) {
			console.log(reponse);
		}
	});
}
$('#pesquisa').on('click', function() {	
	requestServer();
})