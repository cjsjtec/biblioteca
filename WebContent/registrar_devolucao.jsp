<%@include file="cabecalho.jsp" %>
<form action="RegistrarDevolucao" method="POST">
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
				    	<label for="item">Informe a identificação unica do cliente:</label>
				    	<input id="item" class="form-control" type="text" name="id_item"/>
				    </div>					
				</div> 
			</div>
			
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="form-group">
		    			<label for="cliente">Informe a identificação unica do cliente:</label>
		    			<input id="cliente" class="form-control" type="text" name="id_cliente"/>
		    		</div>
	    		</div>
	    	</div>
	    	
		</div>
	</div>
</div>
    <input class="btn btn-primary" type="submit" value="Cadastrar"/>
</form>

<%@include file="footer.jsp" %>