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
	<title>Cliente - Cadastro</title>
	<style>
		html, body {
			height: 100%;
		}
	
		body {
    		background-image: url("../../../resources/img/cliente.jpg");
    		background-size: cover;
    		background-position: center;
  			background-repeat: no-repeat;
  			background-attachment: fixed;
		}
	</style>
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
		<h3 class="text-center">Cliente - Cadastro</h3>
		<br>
		<form action="/cliente/incluir" method="post">
			<div>
				<div class="form-group">
					<label for="nome">Nome:</label> 
					<input type="text" name="nome" placeholder="Digite o nome completo" required>
				</div>
				<div class="form-group">
					<label for="email">Email:</label> 
					<input type="email" name="email" placeholder="Digite o email do cliente" required>
				</div>
				<div class="form-group">
					<label for="telefone">Telefone:</label> 
					<input type="text" name="telefone" placeholder="Telefone de contato" required>
				</div>
				<div class="form-group">
					<label for="veiculo">Veículo:</label> 
					<input type="text" name="veiculo" placeholder="Digite o modelo do veículo" required>
				</div>
				<div class="form-group mb-3 mt-3">
					<label for="anoVeiculo">Ano do Veículo:</label> 
					<input type="number" name="anoVeiculo" required>
				</div>
				
				<c:import url="/WEB-INF/jsp/endereco/cadastro.jsp"/>
				
				<button type="submit" class="btn btn-default">Cadastrar</button>
			</div>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>