<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
<%@include file="componentes/css.jsp"%>

<style type="text/css">


</style>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="componentes/navbar.jsp" %>
	
	<div class="container p-2">
		<div class="row">
			<div class="col-md-4 offset-md-4">
			<div class="card">
				<div class="card-body">
				<h4 class="text-center">Pagina de Registro</h4>
					<c:if test="${not empty successMsg}">
						<p class="text-center text-success">${successMsg}</p>
						<c:remove var="successMsg" scope="session"/>
					</c:if>
					
					<c:if test="${not empty failMens }">
						<p class="text-center text-danger">${failMens}</p>
						<c:remove var="failMens" scope="session"/>				
					</c:if>
					
					<form action="registro" method="post">
					  <div class="mb-3">
					    <label for="nombre" class="form-label">Nombre</label>
					    <input type="text" class="form-control" id="nombre" name="nombre">
					  </div>	
					  <div class="mb-3">
					    <label for="email" class="form-label">Email</label>
					    <input type="email" class="form-control" id="email" name="email">
					  </div>
					  <div class="mb-3">
					    <label for="direccion" class="form-label">Direccion</label>
					    <input type="text" class="form-control" id="direccion" name="direccion">
					  </div>
					  <div class="mb-3">
					    <label for="password" class="form-label">Password</label>
					    <input type="password" class="form-control" id="password" name="password">
					  </div>
					  
					  <div class="form-check">
					  	<input type="checkbox" class="form-check-input" name="check" id="check"><label class="form-check-label">Agree terms & Conditions</label>
					  </div>
					  <div class="text-center p-2">
					  <button type="submit" class="btn btn-primary">Submit</button>
					</div>
					</form>
				</div>
			</div>
			</div>
		</div>
	</div>
	
	<%@include file="componentes/footer.jsp"%>
</body>
</html>
