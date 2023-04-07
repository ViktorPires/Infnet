<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
	<link href="${pageContext.request.contextPath}/resources/css/index.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/lista.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/menu.css" rel="stylesheet">
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/garage.png">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.10.2/umd/popper.min.js"></script>
	<title>AppMecânica</title>
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	
	<div class="container mt-3">
			<h3>Listagem - Funilaria</h3>
			
			 <c:if test="${not empty mensagem}">
        		<div class="alert alert-success">
    				<strong>Atenção!</strong> ${mensagem}
    			</div>
        	</c:if>
		
		<c:if test="${empty funilarias}">
			<h5>Não há serviços de funilaria cadastrados!</h5>
		</c:if>
		
		<c:if test="${not empty funilarias}">
			<h5>Quantidade de serviços de funilaria cadastrados: ${funilarias.size()}</h5>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Código de Registro</th>
						<th>Serviço</th>			
						<th>Material</th>
						<th>Orçamento</th>
						<th>Martelinho</th>
						<th>Lanternagem</th>
						<th>Polimento</th>
						<th>Pintura</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="f" items="${funilarias}">
						<tr>
							<td>${f.id}</td>
							<td>${f.codigoRegistro}</td>
							<td>${f.servico}</td>
							<td>${f.material}</td>
							<td>R$${f.orcamento}</td>
							<td>${f.getMartelinho()}</td>
							<td>${f.getLanternagem()}</td>
							<td>${f.getPolimento()}</td>
							<td>${f.getPintura()}</td>
							<td><a class="excluir" href="/funilaria/${f.id}/excluir"><i class="fa-solid fa-trash"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		
		<a class="button btn-primary mt-3" href="/funilaria">Cadastrar</a>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>