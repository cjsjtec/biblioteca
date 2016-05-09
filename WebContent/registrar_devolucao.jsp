<%@include file="cabecalho.jsp" %>
<form action="registrarDevolucao" method="POST">
<div class="container"> 
	<div class="row"> 
		<div class="col-md-8 col-md-offset-2">
			<div row>
				<div class="col-md-6 col-md-offset-3">
					<h1>Registar Devolução</h1>					
				</div> 
			</div>
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="form-group">
				    	<label for="item">Item:</label>
				    	<input id="item" class="form-control" type="text" name="item"/>
				    </div>					
				</div> 
			</div>
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="form-group">
		    			<label for="cliente">Cliente:</label>
		    			<input id="cliente" class="form-control" type="text" name="cliente"/>
		    		</div>
	    		</div>
	    	</div>
		</div>
	</div>
</div>
    <input class="btn btn-primary" type="submit" value="Cadastrar"/>
</form>

<%@include file="footer.jsp" %>