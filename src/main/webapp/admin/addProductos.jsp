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
<body style="background-color: #f0f2f2;">
	<%@include file="navbar.jsp" %>	
	
	<c:if test="${empty userobj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	
	<div class="container">
		<div class="row p-5">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Agregar Producto</h4>
			
						<c:if test="${not empty successMsg}">
							<p class="text-center text-success">${successMsg}</p>
							<c:remove var="successMsg" scope="session" />
						</c:if>	
					
							<c:if test="${not empty failedMsg}">
							<p class="text-center text-danger">${failedMsg}</p>
							<c:remove var="failedMsg" scope="session" />
						</c:if>	
						<form action="../addProductos" method="post"  enctype="multipart/form-data">
							<div class="form-group">
								<label for="nombre">Nombre:</label>
								<input name="nombre" type="text" class="form-control" aria-describedy="nombre">
							</div> 
							<div class="form-group">
								<label for="inputState">Categoria</label>
								<select id="inputState" name="categoria" class="form-control">
								<option selected>--seleccione--</option>
								<option value="Zapatilla">Zapatilla</option>
								<option value="Remeras">Remeras</option>
								<option value="Pantalones">Pantalones</option>
								</select>
							</div>
							<div class="form-group">
								<label for="stock">Stock:</label>
								<input name="stock" type="number" class="form-control">
							</div> 
							<div class="form-group">
								<label for="precio">Precio:</label>
								<input name="precio" type="number" class="form-control">
							</div> 
					
							<div class="form-group">
								<label for="imagen">Imagen</label>
								<input name="imagen" type="file" class="form-control-file">
							</div>
							
							<button type="submit" class="btn btn-primary">Agregar</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
		
	<div style="margin-top:100px;">
	<%@include file="footer.jsp"%></div>
</body>
</html>