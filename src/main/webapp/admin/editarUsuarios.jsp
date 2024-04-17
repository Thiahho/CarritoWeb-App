<%@page import="modelos.Usuario"%>
<%@page import="dao.UsuarioDaoImp"%>
<%@page import="modelos.Producto"%>
<%@page import="DB.DBConexion"%>
<%@page import="dao.ProductoDaoImp"%>
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
	<div class="container">
		<div class="row p-5">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Editar Usuario</h4>
			
				
						<%
							int idusuario=Integer.parseInt(request.getParameter("idusuario"));
							UsuarioDaoImp dao= new UsuarioDaoImp(DBConexion.getConnection());
							Usuario usu= dao.getUsuarioById(idusuario);
						%>
						
						<form action="../editarPerfil" method="post" >
							<input type="hidden" name="idusuario" value="<%=usu.getIdusuario()%>"> 
							<div class="form-group">
								<label for="nombre">Nombre:</label>
								<input name="nombre" type="text" class="form-control" aria-describedy="nombre" value="<%=usu.getNombre()%>">
							</div> 

							<div class="form-group">
								<label for="email">Email:</label>
								<input name="email" type="text" class="form-control" value="<%=usu.getEmail()%>">
							</div> 
							<div class="form-group">
								<label for="direccion">Direccion:</label>
								<input name="direccion" type="text" class="form-control" value="<%=usu.getDireccion()%>">
							</div> 
					
							<div class="form-group">
								<label for="password">Password</label>
								<input name="password" type="text" class="form-control" value="<%=usu.getPassword()%>">
							</div>
							 <div class="form-group">
								<label for="dinero">Dinero</label>
								<input name="dinero" type="number" class="form-control" value="<%=usu.getDinero()%>">
							</div>
							
							<button type="submit" class="btn btn-primary">Actualizar</button>
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