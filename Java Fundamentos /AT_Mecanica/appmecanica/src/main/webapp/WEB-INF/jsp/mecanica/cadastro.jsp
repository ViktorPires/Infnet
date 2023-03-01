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
	<title>Serviço de Mecânica - Cadastro</title>
	<style>
		body {
    		background-image: url("../../../resources/img/mecanica.jpg");
		}
	</style>
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
		<h3 class="text-center">Serviço de Mecânica - Cadastro</h3>
		<br>
		<form action="/mecanica/incluir" method="post">
			<div>
				<div class="form-group">
					<label for="servico">Serviço:</label> 
					<input type="text" name="servico" placeholder="Nome do serviço">
				</div>
				<div class="form-group">
					<label for="orcamento">Orçamento:</label> 
					<input type="number" step="any" name="orcamento" placeholder="Valor do orçamento">
				</div>
				<div class="form-group">
					<label for="peca">Peça:</label> 
					<input type="text" name="peca" placeholder="Nome da peça">
				</div>
				<div class="form-group">
					<label for="quantidade">Quantidade:</label> 
					<input type="number" name="quantidade" placeholder="Digite a quantidade">
				</div>
				<div class="form-group">
					<label for="fabricante">Fabricante:</label> 
					<input type="text" name="fabricante" placeholder="Digite o fabricante">
				</div>
				<div class="form-group form-check-inline">
					<p class="form-check-inline">Peça é nova?</p>
					<label for="sim">Sim</label> 
					<input type="radio" id="sim" name="pecaNova" value="true">
					<label for="nao">Não</label> 
					<input type="radio" id="nao" name="pecaNova" value="false">
				</div>
				<button type="submit" class="btn btn-default">Cadastrar</button>
			</div>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>
