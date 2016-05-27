var mensagem = function (document, window) {
	var mensagem = {};
	mensagem.alerta = function(titulo, texto, id){
		var div_alerta = "<div class='modal fade bs-example-modal-sm' id='modalAlerta' tabindex='-1' role='dialog' aria-labelledby='myModalLabel' aria-hidden='true'><div class='modal-dialog modal-sm'><div class='modal-content'><div class='modal-header'><button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button><h4 class='modal-title' id='myModalLabel'>"+titulo+"</h4></div><div class='modal-body'>"+texto+"</div><div class='modal-footer'><button type='button' class='btn btn-primary' id='btn_ok' >Ok</button></div></div></div></div>";
		$("body").prepend(div_alerta);
		$("#modalAlerta").modal({backdrop: 'static'});
		$("#btn_ok").on('click', function() {
			$("#modalAlerta").modal('hide');
		});
	}

  return mensagem;
}(document, window);

