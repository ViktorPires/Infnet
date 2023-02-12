<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/garage.png">
	<title>AppMecanica</title>
</head>
<body>
	<div class="container">
		<form action="/usuario" method="get">
			<h3>Listagem de Usuários</h3>
			
			<button type="submit">Novo</button>
		</form>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nome</th>
					<th>E-mail</th>
					<th>Senha</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Viktor Pires</td>
					<td>viktor@al.infnet.br</td>
					<td>123456</td>
				</tr>
				<tr>
					<td>Viktor Pires</td>
					<td>viktor@al.infnet.br</td>
					<td>123456</td>
				</tr>
				<tr>
					<td>Viktor Pires</td>
					<td>viktor@al.infnet.br</td>
					<td>123456</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>