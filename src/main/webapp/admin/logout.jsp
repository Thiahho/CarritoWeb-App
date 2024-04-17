<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin:Home</title>
<%@include file="css.jsp" %>
<style type="text/css">

a{
text-decoration: none;
color: black;
}

a:hover{
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>
	<%@include file="navbar.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
			<a href="allProductos.jsp">
				<div class="card">
					<div class="card-body text-center">
						<i class="fa-solid fa-box fa-3x text-primary"></i><br>
						<h4>Productos</h4>
						--------------
					</div>
				</div>
			</a>
			</div>
			
			<div class="col-md-3">
			<a href="addProducto.jsp">
				<div class="card">
					<div class="card-body text-center">
						<i class="fas fa-plus-square fa-3x text-danger"></i><br>
						<h4>Agregar Nuevo</h4>
						--------------
					</div>
				</div>
			</a>
			</div>
			
			<div class="col-md-3">
			  <a href="pedidos.jsp">
				<div class="card">
					<div class="card-body text-center">
						<i class="fa-solid fa-truck-fast fa-3x text-warning"></i><br>
						<h4>Pedidos</h4>
						--------------
					</div>
				</div>
			  </a>
			</div>
			
			<div class="col-md-3">
			<a href="logout.jsp">
				<div class="card">
					<div class="card-body text-center">
						<i class="fa-solid fa-right-from-bracket fa-3x text-primary"></i><br>
						<h4>Logout</h4>
						--------------
					</div>
				</div>
			</a>	
			</div>
		</div>
	</div>
</body>
</html>