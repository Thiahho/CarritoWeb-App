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
		<div class="row p-5">
			<div class="col-md-4 offset-md-4">
			<div class="card">
				<div class="card-body">
				<h4 class="text-center">Login</h4>
				
				<c:if test="${not empty failMens}">
					<h5 class="text-center text-danger">${failMens}</h5>
					<c:remove var="failMens" scope="session"/>
				</c:if>
				
				<c:if test="${not empty successMsg}">
					<h5 class="text-center text-success">${successMsg}</h5>
					<c:remove var="successMsg" scope="session"/>
				</c:if>
				
					<form action="login" method="post">
					  <div class="mb-3">
					    <label for="email" class="form-label">Email</label>
					    <input type="email" class="form-control" id="email" name="email">
					  </div>
					  <div class="mb-3">
					    <label for="password" class="form-label">Password</label>
					    <input type="password" class="form-control" id="password" name="password" required="required">
					  </div>
					  <div class="text-center">
					  <button type="submit" class="btn btn-primary">Login</button><br>
					  <a href="registro.jsp" class="text center">Crear Usuario</a>
					</div>
					</form>
				</div>
			</div>
			</div>
		</div>
	</div>
	<div style="margin-top:300px;">
	<%@include file="componentes/footer.jsp"%></div>
</body>
</html>
