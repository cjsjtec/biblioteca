<%@include file="cabecalho.jsp"%>
<form action="CadastrarItem" method="POST">
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<h1>Cadastrar itens</h1>

				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label for="nome">Nome:</label> <input id="id" class="form-control" type="text" name="nome"/>
						</div>
					</div>
				</div>

aa

				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label for="tipo">Tipo:</label> <label> 
							<input type="radio" id="revista" name="tipo" value="r">Revista</label> 
							<label> <input type="radio" id="livro" name="tipo" value="l">Livro </label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label>Genero: </label>
							<label><input type="radio" name="genero" value="E">Especial</label>						
							<label><input type="radio" name="genero" value="N">Normal</label>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-12">
						<input class="btn btn-primary btn-block" type="submit"
							value="Cadastrar" />
					</div>
				</div>

			</div>
		</div>

	</div>
</form>
<%@include file="footer.jsp"%>
