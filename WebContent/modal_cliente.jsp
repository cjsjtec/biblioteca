<input type='hidden' id='id_atual'	 >
<div class="modal fade abreModal" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="gridSystemModalLabel"></h4>
      </div>
      <div class="modal-body">
        <div class="row">
			<div class="col-md-12">
				<div class="form-group">
					<label> Nome: </label>
					<input type="text" class="form-control" id="nome" placeholder="Adiciona o nome do cliente desejado."/>
				</div>
			</div>
        </div>
        <div class="row">
			<div class="col-md-12">
				<div class="form-group">
					<label> CPF: </label>
					<input type="text" class="form-control" id="cpf" placeholder="Adiciona o CPF."/>
				</div>
			</div>
        </div>
        <div class="row">
			<div class="col-md-12">
				<div class="form-group">
					<label> Tipo: </label>
					<select id="tipo" class="form-control">
						<option value="">-- Selecione --</option>
						<option value="A">Aluno</option>
						<option value="P">Professor</option>
					</select>
				</div>
			</div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-primary " id="incluir_cliente" data-dismiss="modal">Cadastrar</button>
        <button type="button" class="btn btn-primary " id="alterar_cliente" data-dismiss="modal">Alterar</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->