<%@include file="cabecalho.jsp" %>
<main>
<form name="itens" id="itens""> 
<div class="tilulo">
	<h1 class="descricao-titulo">
		<span class="titulo">Itens</span>

		<!-- <button id="incluir-itemx" class="btn btn-default pull-right gap-top5">Cadastrar item </button> -->
		
<!-- Large modal -->
<input type="button" id="modal_inclui_item" class="btn btn-default pull-right gap-top5" data-toggle="modal"  value="Cadastrar item">

<%@include file="modal.jsp" %>

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
								<label>Digite o nome do item desejado.</label>
							 	<input type="text"  class="form-control" id="busca" name="busca" placeholder="Digite uma breve descricao ou nome do item que deseja">
							</div>
								<input type="button" id="pesquisar_item" class="btn btn-primary btn-block" value="Pesquisar">
						</div>	
					</div>
					
				</div>
			</div>
		</div>
	</div>
		<div class="row hidden">
			<div class='col-md-12'>
				<table class='table'>
					<thead>
						<tr>
							<th>Nome</th>
							<th>Tipo</th>
							<th>Status</th>
							<th>Especial</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</div>
		</div>
</div>
</form>
</main>
<script type="text/javascript" src="js/itens.js"></script>


</script>
<%@include file="footer.jsp" %>