<%@include file="cabecalho.jsp"%>
<main>
<div class="tilulo">
	<h1 class="descricao-titulo">Registrar emprestimo</h1>
</div>
<div class="container">
	<form class="form-horizontal">
		<div class="row gap-bottom10">
			<div class="col-md-12 text-center">
				<label><input type="radio" name="acao" checked value="E" checked>Emprestar</label>
				<label><input type="radio" name="acao" value="D" >Devolver</label>
			</div>
		</div>
		
		<div class="form-group" id="sessaoEmprestar">
			<label class="col-md-2 control-label" for="busca">Titulodo item:</label>
			<div class="col-md-4">
				<div class="input-group">
					<input type="text" id="busca" name="busca" class="form-control">
					<span class="input-group-btn">
						<button class="btn btn-default" id="pesquisa" type="button">Pesquisar!</button>
					</span>
				</div>
			</div>
			<div class="col-md-3">
				<button class='btn btn-success btn-block' type="button" id="btn_registrar" > Registrar emprestimo</button>
			</div>
			<div class="col-md-3 " >
				<ul id="itensSelecionados" class='list-group'></ul>
			</div>
		</div>
		
		<div class="form-group hidden" id="sessaoDevolve">
			<label class="col-md-2 control-label" for="busca">Identificacao do cliente:</label>
			<div class="col-md-4">
				<div class="input-group">
					<input type="text" id="idCLiente" class="form-control">
					<span class="input-group-btn">
						<button class="btn btn-default"  type="button">Pesquisar!</button>
					</span>
				</div>
			</div>
			<div class="col-md-3">
				<button class='btn btn-success btn-block' type="button" id="btn_registrar_devolucao" > Registrar devolucao</button>
			</div>
		</div>
		
		<div class="row hidden">
			<div class='col-md-12'>
				<table class='table'>
				<!-- content -->
				</table>
			</div>
		</div>
		
		<script type="text/javascript" src="js/modals.js"></script>
		<script type="text/javascript" src="js/emprestimos.js"></script>
	</form>
</div>
</main>

<%@include file="footer.jsp"%>