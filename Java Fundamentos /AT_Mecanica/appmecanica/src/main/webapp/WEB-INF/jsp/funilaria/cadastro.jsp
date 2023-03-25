<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
	<link href="${pageContext.request.contextPath}/resources/css/cadastro.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/menu.css" rel="stylesheet">
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/garage.png">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.10.2/umd/popper.min.js"></script>
	<title>Serviço de Funilaria - Cadastro</title>
	<style>
		body {
    		background-image: url("../../../resources/img/funilaria.jpg");
		}
	</style>
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
		<h3 class="text-center">Serviço de Funilaria - Cadastro</h3>
		<br>
		<form action="/funilaria/incluir" method="post">
			<div>
				<div class="form-group">
					<label for="servico">Serviço:</label> 
					<input type="text" name="servico" placeholder="Descreva o serviço" required>
				</div>
				<div class="form-group">
					<label for="codigoRegistro">Código de Registro do Veículo:</label> 
					<input type="number" name="codigoRegistro" placeholder="Digite o código númerico de registro do veículo" required>
				</div>
				<div class="form-group">
					<label for="material">Material:</label> 
					<input type="text" name="material" placeholder="Descreva os materiais utilizados" required>
				</div>
				<div class="form-group">
					<label for="orcamento">Orçamento:</label> 
					<input type="number" step="any" name="orcamento" placeholder="Valor do orçamento" required>
				</div>
				<h4 class="text-center mt-2">Selecione os Serviços Prestados</h4>
				<div class="form-group">
					<label for="martelinho">Martelinho</label> 
					<input type="checkbox" id="martelinho" name="martelinho" value="true" ${not empty checkboxChecked ? 'checked' : ''}>
					<input type="hidden" name="martelinho" value="false">
				</div>
				<div class="form-group">
					<label for="lanternagem">Lanternagem</label> 
					<input type="checkbox" id="lanternagem" name="lanternagem" value="true" ${not empty checkboxChecked ? 'checked' : ''}>
					<input type="hidden" name="lanternagem" value="false">
				</div>
				<div class="form-group">
					<label for="polimento">Polimento</label> 
					<input type="checkbox" id="polimento" name="polimento" value="true" ${not empty checkboxChecked ? 'checked' : ''}>
					<input type="hidden" name="polimento" value="false">
				</div>
				<div class="form-group">
					<label for="pintura">Pintura</label> 
					<input type="checkbox" id="pintura" name="pintura" value="true" ${not empty checkboxChecked ? 'checked' : ''}>
					<input type="hidden" name="pintura" value="false">
				</div>
				<button type="submit" class="btn btn-default">Cadastrar</button>
			</div>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>