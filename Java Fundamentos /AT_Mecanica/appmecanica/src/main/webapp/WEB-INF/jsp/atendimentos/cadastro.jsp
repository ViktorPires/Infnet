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
				<select class="form-select" name="cliente.id">
  					<c:if test="${not empty clientes}">
  						<option selected disabled>Selecione o cliente:</option>
  						<c:forEach var="c" items="${clientes}">
  							<option value="${c.id}">${c.nome}</option>
  						</c:forEach>
  					</c:if>
  					<c:if test="${empty clientes}">
  						<option selected disabled>Não há clientes cadastrados!</option>
  					</c:if>
				</select>
				<h4 class="text-center mt-3">Selecione os Serviços Prestados</h4>
				<c:if test="${not empty servicos}">
					<div class="input-group d-flex flex-column justify-content-center align-items-center mt-3">
						<c:forEach var="s" items="${servicos}">
							<div class="form-check ms-2">
								<label class="form-check-label servico-label">
									<input type="checkbox" name="servicos" value="${s.id}" class="form-check-input"> ${s.servico}  
								</label>
							</div>
					    </c:forEach>
					</div>
				</c:if>
				<c:if test="${empty servicos}">
					<p class="h6 text-center mt-4">Não há serviços cadastrados!</p>
				</c:if>
				<c:if test="${empty clientes or empty servicos}">
					<button type="submit" class="btn btn-default mt-3" disabled>Cadastrar</button>
				</c:if>
				<c:if test="${not empty clientes and not empty servicos}">
					<button type="submit" class="btn btn-default mt-3">Cadastrar</button>
				</c:if>
			</div>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>