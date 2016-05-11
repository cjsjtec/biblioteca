<%@include file="cabecalho.jsp" %>
<div class="alert alert-info">
	<h1 class="title text-center">Registrar emprestimo</h1>
</div>
<div class="container">
	<form class="form-horizontal" action="registrarDevolucao" method="POST" >
		<div class="form-group">
			<label class="col-md-2 control-label" for="pesquisa">Titulo do item:</label>
			<div class="col-md-4">
			<div class="input-group">
		    	<input type="text" id="pesquisa" name="pesquisa" class="form-control">
		        <span class="input-group-btn">
	    	  	  <button class="btn btn-default" type="button">Pesquisar!</button>
		      </span>
			</div>
			</div>
		</div>
	</form>
</div>

<%@include file="footer.jsp" %>