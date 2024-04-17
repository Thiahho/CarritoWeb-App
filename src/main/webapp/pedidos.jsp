<%@page import="java.util.List"%>
<%@page import="modelos.Pedido"%>
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
<title>Pedidos</title>

</head>
<body style="background-color: #f0f1f2">
<%@include file="componentes/css.jsp"%>

	<%@include file="componentes/navbar.jsp" %>	
	
	<c:if test="${empty userobj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>	
	
	<div class="container p-1 ">
	<h3 class="text-center text-primary">Tus pedidos</h3>
		<table class="table table-striped mt-3">
  <thead class="bg-primary text-white">
    <tr>
      <th scope="col">Pedido ID</th>
      <th scope="col">Nombre</th>
      <th scope="col">Producto</th>
      <th scope="col">Categoria</th>
      <th scope="col">Precio</th>
<!--       <th scope="col">Estado</th> -->
    </tr>
  </thead>
  <tbody>
  <%
  
  	Usuario usu=(Usuario)session.getAttribute("userobj");
  	PedidoDaoImp dao= new PedidoDaoImp(DBConexion.getConnection());
  	List<Pedido> plista= dao.getPedido(usu.getEmail());
  	
  	for(Pedido ped:plista)
  	{%>
  		<tr>
      <th scope="row"><%=ped.getIdpedido()%></th>
      <td><%=ped.getUnombre()%></td>
      <td><%=ped.getPnombre()%></td>
      <td><%=ped.getPcategoria()%></td>
      <td><%=ped.getPprecio()%></td>
<%--       <td><%=ped.getEstado() %></td> --%>
    </tr>
    
  	<%}
  	
  %>
    
  </tbody>
</table>
	</div>

</body>
</html>

