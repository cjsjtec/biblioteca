<%@include file="cabecalho.jsp" %>
<main>
<form name="itens" id="itens""> 
<div class="tilulo">
	<h1 class="descricao-titulo">
		<span class="titulo">Clientes</span>
		<input type="button" id="cadastrar_cliente" class="btn btn-default pull-right gap-top5"  value="Cadastrar cliente">
		<input type="button" id="modal" class="hidden" data-toggle="modal">
		<%@include file="modal_cliente.jsp" %>
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
								<label>Escolha uma opção para o filtro .</label>
							 	<select id="filtro" class="form-control" >
									<option value="">-- Selecione --</option>
									<option value="CPF">CPF</option>
									<option value="NOME">Nome</option>
									<option value="TIPO">Tipo</option>
									<option value="TODOS">Todos</option>						 		
							 	</select>
							 	
							</div>
								
						</div>	
					</div>
					
					<div class="row" >
						<div class="col-md-12">
							<div class="form-group">
								<label class="lb-busca"></label>
							 	<input type="text"  id="busca" class="form-control">
							</div>
						</div>	
					</div>
					<input type="button" id="pesquisar_cliente" class="btn btn-primary btn-block " value="Pesquisar">
				</div>
			</div>
		</div>
	</div>
		<div class="row hidden">
			<div class='col-md-12'>
				<table class='table'>
					<thead>
						<tr>
							<th>Id</th>
							<th>CPF</th>	
							<th>Nome</th>
							<th>Tipo</th>
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
<script type="text/javascript" src="js/clientes.js"></script>
<%@include file="footer.jsp" %>

