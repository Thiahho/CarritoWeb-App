<%@page import="java.util.List"%>
<%@page import="modelos.Carrito"%>
<%@page import="modelos.Usuario"%>
<%@page import="DB.DBConexion"%>
<%@page import="dao.CarritoDaoImp"%>
<%@page import="dao.CarritoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carrito</title>
</head>
<body style="background-color: #f0f1f2;">
<%@include file="componentes/css.jsp"%>
	<%@include file="componentes/navbar.jsp" %>

	<c:if test="${empty userobj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>	
	
	<c:if test="${not empty successMsg }">
	<div class="alert alert-success text-center" role="alert">
	  ${successMsg}
	</div>
	<c:remove var="successMsg" scope="session"/>
	</c:if>

	<c:if test="${not empty failedsMsg }">
	<div class="alert alert-danger text-center" role="alert">
	 ${failedsMsg}
	</div>
	<c:remove var="failedsMsg" scope="session"/>
	</c:if>
	
	<div class="container">
		<div class="row p-2">
			<div class="col-md-6">
				<div class="card bg-white">
					<div class="card-body">
				<h3 class="text-center text-success">Items</h3>
 
						<table class="table table-stripped">
				  <thead>
				    <tr>
				     
				      <th scope="col">Nombre</th>
				      <th scope="col">Categoria</th>
				      <th scope="col">Precio</th>
					  <th scope="col">Accion</th>

				    </tr>
				  </thead>
				  <tbody>
				  
				  <%
					Usuario usu=(Usuario)session.getAttribute("userobj");
				  	CarritoDaoImp dao = new CarritoDaoImp(DBConexion.getConnection());
				  	List<Carrito> carrito= dao.getProductoByUsuario(usu.getIdusuario());
				  	Double preciototal=0.00;
				  	for(Carrito car:carrito)
				  	{
				  	 preciototal= car.getTotal();	
				  		
				  	%>
				  					  	
				    <tr>
				      <th scope="row"><%=car.getNombre()%></th>
				      <td><%=car.getCategoria()%></td>
				      <td><%=car.getPrecio()%></td>
				      <td>
				      	<a href="eliminarprod?idprod=<%=car.getIdprod()%>&&idusuario=<%=car.getIdusuario()%> &&idcarrito=<%=car.getIdcarrito()%>" class="btn btn-sm btn-danger">Eliminar</a>
				      
				      </td>
				    </tr>
				  	<%}
				  	
				  %>
				  <tr>
				  	<td>TOTAL</td>
				  	<td></td>
				  	<td></td>
				  	<td>$ <%=preciototal%></td>
				  </tr>
				 
				
				  </tbody>
				</table>
					</div>
				</div>
				
			</div>
			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
					<h3 class="text-center text-success">Detalles</h3>
						 <%-- <form action="pedido" method="post">
						
						<input type="hidden" value="${userobj.idusuario}" name=idusuario>
						<input type="hidden" value="${userobj.dinero}" name=dinero>
						<input type="hidden" value="<%=preciototal%>" name=idusuario>
						
						 <div class="form-row">
						    <div class="form-group col-md-6">
						      <label for="nombre">Nombre</label>
						      <input type="text" class="form-control" id="unombre" name="unombre" value="${userobj.nombre}" required>
						    </div>
						    <div class="form-group col-md-6">
						      <label for="email">Email</label>
						      <input type="email" class="form-control" id="uemail" name="uemail"value="${userobj.email}" required>
						    </div>
						  </div>
						 
						    <div class="form-row">
						    <div class="form-group col-md-12">
						      <label for="direccion">Direccion</label>
						      <input type="text" class="form-control" name="udireccion" value="${userobj.direccion }">
						    </div>
						  </div>
						  
						
						  <div class="text-center">
						  <input type="text" name="preciototal" value="<%=preciototal%>">
						  	<button class="btn btn-warning">Pagar</button>
						  	<a href="index.jsp" class="btn btn-success">Continuar Compra </a	>
						  </div>
						  
						</form>  --%>
						<form action="pedido" method="post">
						    <input type="hidden" value="${userobj.idusuario}" name="idusuario">
						    <input type="hidden" value="${userobj.dinero}" name="dinero">
						    <input type="hidden" value="<%=preciototal%>" name="preciototal">
						
						    <!-- Agregar campos para el nombre, email y dirección del usuario -->
						    <div class="form-row">
						        <div class="form-group col-md-6">
						            <label for="nombre">Nombre</label>
						            <input type="text" class="form-control" id="unombre" name="unombre" value="${userobj.nombre}" required>
						        </div>
						        <div class="form-group col-md-6">
						            <label for="email">Email</label>
						            <input type="email" class="form-control" id="uemail" name="uemail" value="${userobj.email}" required>
						        </div>
						    </div>
						    <div class="form-row">
						        <div class="form-group col-md-12">
						            <label for="direccion">Direccion</label>
						            <input type="text" class="form-control" name="udireccion" value="${userobj.direccion}">
						        </div>
						    </div>
						
						  
						    <!-- Campo para el total del pedido -->
						    <input type="hidden" name="preciototal" value="<%=preciototal%>">
						
						    <!-- Botones para enviar el formulario y continuar comprando -->
						    <div class="text-center">
						        <button type="submit" class="btn btn-warning">Pagar</button>
						        <a href="index.jsp" class="btn btn-success">Continuar Compra</a>
						    </div>
						</form>
						
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>