<%@include file="cabecalho.jsp" %>
<form action="registrarDevolucao" method="POST">
<div class="container"> 
	<div class="row"> 
		<div class="col-md-8 col-md-offset-2">
			<div row>
				<div class="col-md-6 col-md-offset-3">
					<h1>Registar Emprestimo</h1>					
				</div> 
			</div>
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="form-group">
				    	<label for="item">Item:</label>
				    	<input id="item" class="form-control" type="text"/>
				    </div>					
				</div> 
			</div>
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="form-group">
		    			<label for="cliente">Cliente:</label>
		    			<input id="cliente" class="form-control" type="text"/>
		    		</div>
	    		</div>
	    	</div>
	    	<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="form-group">
		    			<label>Tipo Cliente:</label><br>
		    			<label><input type="radio" name="tipo_cliente" value="p" >Professor</label>
		    			<label><input type="radio" name="tipo_cliente" value="a" >Aluno</label>

		    		</div>
	    		</div>
	    	</div>
		</div>
	</div>
</div>
    <input class="btn btn-primary" type="submit" value="Cadastrar"/>
</form>

<%@include file="footer.jsp" %>