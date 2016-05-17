<%@include file="cabecalho.jsp"%>
<main>
<div class="tilulo">
	<h1 class="descricao-titulo">Registrar emprestimo</h1>
</div>
<div class="container">
	<form class="form-horizontal">
		<div class="form-group">
			<label class="col-md-2 control-label" for="pesquisa">Titulo
				do item:</label>
			<div class="col-md-4">
				<div class="input-group">
					<input type="text" id="busca" name="busca" class="form-control">
					<span class="input-group-btn">
						<button class="btn btn-default" id="pesquisa" type="button">Pesquisar!</button>
					</span>
				</div>
			</div>
			<div class="col-md-3">
				<button class='btn btn-success btn-block'> Registrar emprestimo</button>
			</div>
			<div class="col-md-3 " >
				<ul id="itensSelecionados" class='list-group'></ul>
			</div>
		</div>
		<div class="row hidden" style="height: 600px;">
			<div class='col-md-12'>
				<table class='table'>
					<thead>
						<tr>
							<th>Nome</th>
							<th>Tipo</th>
							<th>Status</th>
							<th></th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
		</div>
		<script type="text/javascript" src="js/emprestimos.js"></script>
	</form>
</div>
</main>

<%@include file="footer.jsp"%>