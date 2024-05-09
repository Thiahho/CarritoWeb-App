<%@page import="modelos.Producto"%>
<%@page import="java.util.List"%>
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
<body>
	<%@include file="navbar.jsp" %>
	
	
	<c:if test="${empty userobj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	
	
	<h3 class="text-center">Todos los Productos</h3>
	
		<c:if test="${not empty successMsg}">
			<h5 class="text-center text-success">${successMsg}</h5>
			<c:remove var="successMsg" scope="session" />
		</c:if>	
					
		<c:if test="${not empty failedMsg}">
			<h5 class="text-center text-danger">${failedMsg}</h5>
			<c:remove var="failedMsg" scope="session" />
		</c:if>		
						
	<table class="table table-striped">
	  <thead class="bg-primary text-white">
	    <tr>
	    
	      <th scope="col">ID</th>
	      <th scope="col">Imagen</th>
	      <th scope="col">Nombre</th>
	      <th scope="col">Categoria</th>
	      <th scope="col">Stock</th>
	      <th scope="col">Precio</th>  
	      <th scope="col">Accion</th>
	    </tr>
	  </thead>
  <tbody>
  	
	<%
		ProductoDaoImp dao= new ProductoDaoImp(DBConexion.getConnection());
		List<Producto> list= dao.getAllProductos();
		for(Producto prod:list)
		{
	%>
	<tr>
      <td><%=prod.getIdprod()%></td>
      <td><img src="../img/<%=prod.getImagen()%>" style="width: 50px; height: 50px;"></td>
      <td><%=prod.getNombre()%></td>
      <td><%=prod.getCategoria()%></td>
      <td><%=prod.getStock()%></td>
      <td><%=prod.getPrecio()%></td>
      <td>
      	<a href="editarProductos.jsp?idprod=<%=prod.getIdprod()%>" class="btn btn-sm btn-primary"><i class="fa-solid fa-pen-to-square"></i> Editar</a>
     	<a href="../deleteprod?idprod=<%=prod.getIdprod()%>" class="btn btn-sm btn-danger"><i class="fa-solid fa-trash"></i> Eliminar</a>
      </td>
    </tr>
		<% 
		}
	%>  
   
    
  </tbody>
</table>
	
	<div style="margin-top:300px;">
	<%@include file="footer.jsp"%></div>
</body>
</html>