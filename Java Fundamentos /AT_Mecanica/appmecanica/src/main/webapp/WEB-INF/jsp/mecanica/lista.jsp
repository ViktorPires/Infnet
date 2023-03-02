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
			<h3>Listagem - Mecânica</h3>
			
			 <c:if test="${not empty mensagem}">
        		<div class="alert alert-success">
    				<strong>Atenção!</strong> ${mensagem}
    			</div>
        	</c:if>
		
		<c:if test="${empty mecanicas}">
			<h5>Não há serviços de mecânica cadastrados!</h5>
		</c:if>
		
		<c:if test="${not empty mecanicas}">
			<h5>Quantidade de serviços de mecânica cadastrados: ${mecanicas.size()}</h5>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Código de Registro</th>
						<th>Serviço</th>
						<th>Peça</th>
						<th>Fabricante</th>
						<th>Quantidade</th>
						<th>Orçamento</th>
						<th>Peça Nova?</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="m" items="${mecanicas}">
						<tr>
							<td>${m.codigoRegistro}</td>
							<td>${m.servico}</td>
							<td>${m.peca}</td>
							<td>${m.fabricante}</td>
							<td>${m.quantidade}</td>
							<td>R$${m.orcamento}</td>
							<td>${m.getPecaNova()}</td>
							<td><a class="excluir" href="/mecanica/${m.codigoRegistro}/excluir"><i class="fa-solid fa-trash"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		
		<a class="button btn-primary" href="/mecanica">Cadastrar</a>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>