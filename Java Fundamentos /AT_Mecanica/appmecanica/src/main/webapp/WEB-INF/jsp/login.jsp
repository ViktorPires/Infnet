<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
	<link href="${pageContext.request.contextPath}/resources/css/index.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/garage.png">
	<title>AppMecânica</title>
	<style>
		body {
    		background-image: url("../../../resources/img/garagem-unsplash.jpg");
		}
	</style>
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	<div class="form-container">
        <h2 class="text-center">Autenticação</h2>
        
        <c:if test="${not empty mensagem}">
        	<div class="alert alert-danger">
    			<strong>Atenção</strong> ${mensagem}
    		</div>
        </c:if>
        
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
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>