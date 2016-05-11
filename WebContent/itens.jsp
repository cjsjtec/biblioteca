<%@include file="cabecalho.jsp" %>
<main>
<form name="itens" id="itens"> 
<div class="alert alert-info">
	<h1>
		<span class="titulo">Itens</span>
		<button id="incluir-item" class="btn btn-default pull-right">Cadastrar item </button>
	</h1>
</div>
<div class="container">
		<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<div class="panel panel-primary">
				<div class="panel-body"> 	
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label>Qual e o tipo do item quer voce deseja consultar ?</label>
								<select name="tipo_item" class="form-control">
									<option value="">-- Selecione --</option>
									<option value="livro">Livro</option>
									<option value="revista">Revista</option>
								</select>
							</div>
							<div class="form-group">
								<label>O item que voce quer consultar e especial ? </label>
								<label><input type="radio" name="especial" value="sim">Sim</label>
								<label><input type="radio" name="especial" value="sim">Nao</label>
							</div>
							<div class="form-group">
								<label>Digite o nome do item desejado.</label>
							  
							  
							  uiy
							  	<input type="text"  class="form-control" name="descricao_item" placeholder="Digite uma breve descricao ou nome do item que deseja">
							</div>
							<div class="btn-group">
								<input type="button" id="pesquisar_item" class="btn btn-primary btn-block" value="Pesquisar">
							</div>		
						</div>	
					</div>
					
				</div>
			</div>
		</div>
	</div>
</div>
<div id="di"></div>
</form>
</main>
<script type="text/javascript">
$("#pesquisar_item").on('click',function() {
	/*$.ajax({
		url:"ListarItens",
		data: $("#itens").serialize(),
		type: 'post',
		dataType: 'json',
		timeout: 5000,
		error: function(erro) {
			alert('Erro no ajax -' + erro);
		},
	
		success: function(retorno) {
			console.log(retorno);
		}
	});*/
    $.get("/biblioteca/ListarItens/", 
	{ 	
    	especial: $("input[name=especial]").val(),
    	tipo_item: $("input[name=tipo_item]").val(),
    	descricao_item: $("input[name=descricao_item]").val() 
    	
	},
  	function(data){
	    $("#divRetorno").html(data);
	});
});

$("#incluir_item").on('click',function() {
	$("#itens").attr('action', 'IncluirItens');
});

$(".alterar_item").on('click', function() {
	$("#itens").attr('action', 'AlterarItens');
	$(this).attr('data-val');
});

</script>
<%@include file="footer.jsp" %>