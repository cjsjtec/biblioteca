<%@include file="cabecalho.jsp"%>
<form action="cadastrarItem" method="POST">
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<h1>Cadastrar Cliente</h1>

				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label>Nome:</label> <input id="nome_cliente" class="form-control" type="text" name="nome" />
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label >Status:</label> 
							<select class="form-control" name="status">
								<option selected>Selecione um Status</option>
								<option value="a">Ativo</option>
								<option value="i">Indisponível</option>
							</select>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label for="tipo">Tipo:</label> 
							<label> <input type="radio" id="revista" name="tipo" value="p">Professor</label>
							<label> <input type="radio" id="livro" name="tipo" value="a">Aluno </label>
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
