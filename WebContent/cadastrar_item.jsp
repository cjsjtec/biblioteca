<%@include file="cabecalho.jsp"%>
<form action="cadastrarItem" method="POST">
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<h1>Cadastrar ites</h1>

				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label for="nome">Nome:</label> <input id="id"
								class="form-control" type="text" />
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label for="status">Status:</label> <select class="form-control">
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
							<label for="revista">Revista <input type="radio" id="revista" name="tipo"></label>
							<label for="livro">Livro <input type="radio" id="livro" name="tipo"></label>
						</div>
					</div>
				</div>

			</div>
		</div>
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<input class="btn btn-primary" type="submit" value="Cadastrar" />
			</div>
		</div>
	</div>
</form>
<%@include file="footer.jsp"%>
