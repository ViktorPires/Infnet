<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <div class="form-group">
		<label for="cep">Cep:</label> 
		<input type="text" name="cep" value="${endereco.cep}" class="form-control" required>
	</div>
	
	<div class="form-group">
		<label for="logradouro">Logradouro:</label> 
		<input type="text" name="logradouro" value="${endereco.logradouro}"  class="form-control" required>
	</div>
	
	<div class="form-group">
		<label for="complemento">Complemento:</label> 
		<input type="text" name="complemento" value="${endereco.complemento}" class="form-control" required>
	</div>
	
	<div class="form-group">
		<label for="bairro">Bairro:</label> 
		<input type="text" name="bairro" value="${endereco.bairro}" class="form-control" required>
	</div>
	
	<div class="form-group">
		<label for="localidade">Localidade:</label> 
		<input type="text" name="localidade" value="${endereco.localidade}" class="form-control" required>
	</div>
	
	<div class="form-group">
		<label for="uf">UF:</label> 
		<input type="text" name="uf" value="${endereco.uf}" class="form-control" required>
	</div>