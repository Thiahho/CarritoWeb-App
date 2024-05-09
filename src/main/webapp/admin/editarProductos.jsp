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
						<h4 class="text-center">Editar Productos</h4>
			
				
						<%
						
							int idprod=Integer.parseInt(request.getParameter("idprod"));
							//int idprod=(request.getParameter("idprod")!=null)? Integer.parseInt(request.getParameter("idprod")):0;
							ProductoDaoImp dao= new ProductoDaoImp(DBConexion.getConnection());
							Producto prod= dao.getProductoById(idprod);
						%>
						
												
						
						<form action="../editarProductos" method="post">
							<input type="hidden" name="idprod" value="<%=prod.getIdprod()%>"> 
							
							<div class="form-group">
								<label for="nombre">Nombre:</label>
								<input name="nombre" type="text" class="form-control" value="<%=prod.getNombre()%>">
							</div> 
							<div class="form-group">
						    <label for="inputState">Categoria</label>
						    <select id="inputState" name="categoria" class="form-control">
						        <% if("Zapatilla".equals(prod.getCategoria())) { %>
						            <option value="Zapatilla" selected>Zapatilla</option>
						        <% } else { %>
						            <option value="Zapatilla">Zapatilla</option>
						        <% } %>
						
						        <% if("Remera".equals(prod.getCategoria())) { %>
						            <option value="Remera" selected>Remera</option>
						        <% } else { %>
						            <option value="Remera">Remeras</option>
						        <% } %>
						
						        <% if("Pantalon".equals(prod.getCategoria())) { %>
						            <option value="Pantalon" selected>Pantalon</option>
						        <% } else { %>
						            <option value="Pantalon">Pantalon</option>
						        <% } %>
						
						       
						    </select>
						</div>

							<div class="form-group">
								<label for="stock">Stock:</label>
								<input name="stock" type="number" class="form-control" value="<%=prod.getStock()%>">
							</div> 
							<div class="form-group">
								<label for="precio">Precio:</label>
								<input name="precio" type="number" class="form-control"value="<%=prod.getPrecio()%>">
							</div> 
					
							<%-- <div class="form-group">
								<label for="imagen">Imagen</label>
								<input name="imagen" type="file" class="form-control-file" value="<%=prod.getImagen()%>">
							</div> --%>
							
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