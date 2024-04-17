<%@page import="modelos.Pedido"%>
<%@page import="java.util.List"%>
<%@page import="DB.DBConexion"%>
<%@page import="dao.PedidoDaoImp"%>
<%@page import="modelos.Usuario"%>
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
	
	
	
	<h3 class="text-center">Pedidos</h3>
	
	
	<table class="table table-striped">
  <thead class="bg-primary text-white">
    <tr>
      <th scope="col">Pedido Id</th>
      <th scope="col">Nombre</th>
      
      <th scope="col">Email</th>
      <th scope="col">Direccion</th>
      
      <th scope="col">Producto</th>
      <th scope="col">Precio</th>
      <th scope="col">Categoria</th>
<!--       <th scope="col">Stock</th> -->
      <th scope="col">Estado</th>
    </tr>
  </thead>
  <tbody>
   <%
  
  	PedidoDaoImp dao= new PedidoDaoImp(DBConexion.getConnection());
  	List<Pedido> plista= dao.getAllPedidos();  	
  	for(Pedido ped:plista)
  	{%>

    <tr>
      <th scope="row"><%=ped.getIdpedido()%></th>
      <td><%=ped.getUnombre()%></td>
      <td><%=ped.getUemail()%></td>
	  <td><%=ped.getUdireccion()%></td> 
      <td><%=ped.getPnombre()%></td>
      <td><%=ped.getPprecio()%></td>
      <td><%=ped.getPcategoria()%></td>
      <td><%=ped.getEstado()%></td>
    </tr>
    	<%}
  	
  %>
  </tbody>
</table>
	
	<div style="margin-top:300px;">
	<%@include file="footer.jsp"%></div>
</body>
</html>