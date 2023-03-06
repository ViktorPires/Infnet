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
	<title>Atendimento - Cadastro</title>
	<style>
		body {
    		background-image: url("../../../resources/img/cliente.jpg");
		}
	</style>
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
		<h3 class="text-center">Atendimento - Cadastro</h3>
		<br>
		<form action="/atendimentos/incluir" method="post">
			<div>
				<div class="form-group">
					<label for="descricao">Descrição:</label> 
					<input type="text" name="descricao" placeholder="Descreva o atendimento" required>
				</div>
				<div class="form-group">
					<label for="mecanicoResponsavel">Mecânico Responsável:</label> 
					<input type="text" name="mecanicoResponsavel" placeholder="Mecânico responsável pelo atendimento" required>
				</div>
				<select class="form-select" aria-label="Default select example" name="cliente">
  					<c:if test="${not empty clientes}">
  						<option selected disabled>Selecione o cliente:</option>
  						<c:forEach var="cliente" items="${clientes}">
  							<option value="${cliente.getId()}">${cliente.getNome()}</option>
  						</c:forEach>
  					</c:if>
  					<c:if test="${empty clientes}">
  						<option selected disabled>Não há clientes cadastrados!</option>
  					</c:if>
				</select>
				<h4 class="text-center mt-2">Selecione os Serviços Prestados</h4>
				<div class="input-group mt-3">
					<select class="form-control rounded" id="mySelect" multiple>
						<option class="text-center" disabled>Mecânica</option>
						<c:forEach var="mecanica" items="${mecanicas}">
				      		<option value="${mecanica}">${mecanica.getServico()}</option>
				    	</c:forEach>
				  	</select>
					<span class="input-group-btn">
				    	<button class="btn btn-warning btn-sm mt-4 ms-1 me-2" type="button">Adicionar</button>
				  	</span>
				  	<select class="form-control rounded" id="mySelect" multiple>
				   		<option class="text-center" disabled>Funilaria</option>
				    	<c:forEach var="funilaria" items="${funilarias}">
				      		<option value="${funilaria}">${funilaria.getServico()}</option>
				    	</c:forEach>
				  	</select>
				  	<span class="input-group-btn">
				    	<button class="btn btn-warning btn-sm mt-4 ms-1 me-2" type="button">Adicionar</button>
				  	</span>
				   	<select class="form-control rounded" id="mySelect" multiple>
				   		<option class="text-center" disabled>Acessório</option>
				    	<c:forEach var="acessorio" items="${acessorios}">
				      		<option value="${acessorio}">${acessorio.getServico()}</option>
				    	</c:forEach>
				  	</select>
				  	<span class="input-group-btn">
				    	<button class="btn btn-warning btn-sm mt-4 ms-1 me-2" type="button">Adicionar</button>
				  	</span>
				</div>
				<div id="addedItems"></div>
					<button type="submit" class="btn btn-default mt-3">Cadastrar</button>
			</div>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>