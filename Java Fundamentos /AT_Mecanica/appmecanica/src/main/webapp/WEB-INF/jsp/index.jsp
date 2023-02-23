<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
	<link href="${pageContext.request.contextPath}/resources/css/index.css" rel="stylesheet">
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/garage.png">
	<style>
		body {
    		background-image: url("../../../resources/img/oficina-unsplash.jpg");
		}
		
		.gradient-text {
			background: linear-gradient(45deg, #e6e6e6, #a0a0a0);
  			-webkit-background-clip: text;
  			-webkit-text-fill-color: transparent;
  			border: none;
		}
		
		.gradient-text:hover {
			padding: 0;
		}
	
		.dropdown-menu .dropdown-item:hover {
  			background-color: rgba(255, 160, 0, 0.3);
		}
	</style>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.10.2/umd/popper.min.js"></script>
<title>AppMecânica</title>
</head>
<body>
	
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	
	<footer class="fixed-bottom">
		<div>
			<p>Desenvolvido por Viktor Oleksiuk Pires</p>
		</div>
	</footer>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>
