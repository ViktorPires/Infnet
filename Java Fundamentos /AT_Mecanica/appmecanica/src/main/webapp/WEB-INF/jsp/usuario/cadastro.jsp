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
	<title>Cadastro de Usuário</title>
	<style>
		body {
    		background-image: url("../../../resources/img/ferramentas-unsplash.jpg");
		}
	</style>
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
		<h3 class="text-center">Cadastro de Usuário</h3>
		<br>
		<form action="/usuario/incluir" method="post">
			<div>
				<div class="form-group">
					<label for="nome">Nome:</label> 
					<input type="text" name="nome" placeholder="Nome do usuário" required>
				</div>
				<div class="form-group">
					<label for="email">E-mail:</label> 
					<input type="email" name="email" placeholder="E-mail do usuário" required>
				</div>
				<div class="form-group">
					<label for="senha">Senha:</label> <input type="password" name="senha" required>
				</div>
				<button type="submit" class="btn btn-default">Cadastrar</button>
			</div>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>
