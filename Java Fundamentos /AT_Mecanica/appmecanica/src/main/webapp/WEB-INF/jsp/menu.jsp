<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-lg bg-dark">
	  <div class="container-fluid">
		<i class="fas fa-car me-3"></i> 				
	    <a class="navbar-brand gradient-text" href="/">AppMecânica</a>
		<i class="fas fa-wrench"></i>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse ms-5" id="navbarScroll">
	      <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
	      	<li class="nav-item ms-2">
	          <a class="nav-link active text-white" href="/home">Home</a>
	        </li>
	        
	        <c:if test="${not empty usuario}">
		        <li class="nav-item ms-2">
		          <a class="nav-link active text-white" aria-current="page" href="/usuario/lista">Usuário</a>
		        </li>
		        <li class="nav-item ms-2">
		          <a class="nav-link text-white" href="/cliente/lista">Cliente</a>
		        </li>
		         <li class="nav-item ms-2">
		          <a class="nav-link text-white" href="#">Atendimento</a>
		        </li>
		        <li class="nav-item dropdown ms-2">
		          <a class="nav-link dropdown-toggle text-white" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            Serviços
		          </a>
		          <ul class="dropdown-menu">
		            <li><a class="dropdown-item" href="/mecanica/lista">Mecânica</a></li>
		            <li><a class="dropdown-item" href="/funilaria/lista">Funilaria</a></li>
		            <li><a class="dropdown-item" href="/acessorios/lista">Acessórios</a></li>
		          </ul>
		        </li>
		    </c:if>
	      </ul>
	      <div class="d-flex">
        		<ul class="nav navbar-nav justify-content-end">
        			<c:if test="${empty usuario}">
			     		<li class="nav-item">
			        		<a class="nav-link text-white border border-warning border-2 rounded-pill" href="/login">
			        			<i class="fa-solid fa-user">
			        			</i>
			        			Login
			        		</a>
			      		</li>
			      		<li class="nav-item ms-2">
			        		<a class="nav-link text-white border border-2 rounded-pill" href="/usuario">
			        			<i class="fas fa-sign-in-alt">
			        			</i>
			        			Sign Up
			        		</a>
			      		</li>
		      		</c:if>
		      		
		      		<c:if test="${not empty usuario}">
			      		<li class="nav-item ms-2">
			        		<a class="nav-link text-white border border-2 rounded-pill" href="/logout">
			        			<i class="fa-sharp fa-solid fa-door-open">	   
			        			</i>
			        			Logout, ${usuario.nome}				     
			        		</a>
			      		</li>
		      		</c:if>
	    		</ul>
        	</div>
	    </div>
	  </div>
	</nav>