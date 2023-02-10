<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
		rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/cadastro.css" rel="stylesheet">
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/garage.png">
	<meta charset="UTF-8">
	<title>Cadastro de Usuário</title>
	<style>
		body {
    		background-image: url("../../../resources/img/ferramentas-unsplash.jpg");
		}
	</style>
</head>
<body>
	<div class="container">
		<h3 class="text-center">Cadastro de Usuário</h3>
		<br>
		<form action="/usuario/incluir" method="post">
			<div>
				<div class="form-group">
					<label for="nome">Nome:</label> <input type="text" name="nome"
						placeholder="Nome do usuário">
				</div>
				<div class="form-group">
					<label for="email">E-mail:</label> <input type="email" name="email"
						placeholder="E-mail do usuário">
				</div>
				<div class="form-group">
					<label for="senha">Senha:</label> <input type="password"
						name="senha">
				</div>
				<button type="submit" class="btn btn-default">Cadastrar</button>
			</div>
		</form>
	</div>
</body>
</html>
