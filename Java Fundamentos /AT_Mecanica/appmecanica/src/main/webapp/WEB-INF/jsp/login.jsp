<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login.css">
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/garage.png">
	<title>AppMecanica</title>
	<style>
		body {
    		background-image: url("../../../resources/img/garagem-unsplash.jpg");
		}
	</style>
</head>
<body>
	<div class="container">
	<div class="form-container">
        <h2 class="text-center">Autenticação</h2>
        <form action="/login" method="post">
            <div class="form-group">
                <label>E-mail:</label>
                <input type="email" name="email" placeholder="Digite o seu e-mail"> 
            </div>
            <div class="form-group">
                <label>Senha:</label>
                <input type="password" name="senha" placeholder="Digite a sua senha">
            </div>
            <div class="form-group text-center">
               <button type="submit" class="btn btn-primary">Acessar</button>
            </div>
   		</form>
   	</div>
	</div>
</body>
</html>