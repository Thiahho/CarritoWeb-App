<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pedidos Existosos</title>
</head>
<body style="background-color: #f0f1f2">
<%@include file="componentes/css.jsp"%>
<%@include file="componentes/navbar.jsp" %>	


<div class="container text-center mt-3">
	<i class="fas fa-check-circle fa-5x text-success"></i>
	<h1>Gracias por la compra!</h1>
	<h2>Su orden esta siendo procesada...</h2>
	<h5>Se hara el envio a la direccion registrada.</h5>
	<a href="index.jsp" class="btn btn-primary mt-3">Inicio</a>
	<a href="pedidos.jsp" class="btn btn-danger mt-3">Ver Pedidos</a>
	
</div>
	
	
</body>
</html>