<%@page import="modelos.Usuario"%>
<%@page import="modelos.Producto"%>
<%@page import="DB.DBConexion"%>
<%@page import="dao.ProductoDaoImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="componentes/css.jsp"%>

</head>
<body style="background-color: #f0f1f2">
	<%@include file="componentes/navbar.jsp" %>	

	<%
		int idprod=Integer.parseInt(request.getParameter("idprod"));	
		ProductoDaoImp dao = new ProductoDaoImp(DBConexion.getConnection());
		Producto prod= dao.getProductoById(idprod);
	%>
	
	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 text-center p-5 border bg-white">
		
				<img src="img/<%= prod.getImagen()%>" style="width:150px; height:150px"><br>
				<h4 class="mt-3">Nombre:<span class="text-success"> <%= prod.getNombre()%></span></h4>
				<h4>Categoria:<span class="text-success"> <%= prod.getCategoria()%></span></h4>
				<h4>Precio:<span class="text-success"> <%= prod.getPrecio() %></span></h4>
			
			</div>
			
			<div class="col-md-6 text-center p-5 border bg-white">
				<h2>Producto</h2>
				
				
					<h5 class="text-primary">Contactar al vendedor</h5>
					<h5 class="text-primary">
						<i class="far fa-envelope"></i> Email:
						<%=prod.getEmail() %>
					</h5>	
				
				<!-- <div class="row">
				<div class="col-md-4 text-danger text-center p-2">
						<i class="fa-solid fa-money-bill-wave fa-2x"></i>
				<p>Pagar</p>
				</div>
				<div class="col-md-4 text-danger text-center p-2">
					<i class="fa-solid fa-rotate-left fa-2x"></i>
					<p>Volver</p>
				</div>
				<div class="col-md-4 text-danger text-center p-2">
					<i class="fa-solid fa-truck fa-2x"></i>
					<p>Envio</p>
				</div>
				
				</div> -->
				<div class="text-center p-3">
			
					<a href="" class="btn btn-primary"><i class="fa-solid fa-cart-plus"></i> Agregar Carrito</a>
					<a href="" class="btn btn-danger"><i class="fa-solid fa-dollar-sign"></i> 342</a>
				</div>
		
			</div>
		</div>
	</div>
</body>
</html>