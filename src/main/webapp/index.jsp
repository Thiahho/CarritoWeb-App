<%@page import="modelos.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="modelos.Producto"%>
<%@page import="dao.ProductoDaoImp"%>
<%@page import="DB.DBConexion"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop Cart</title>
<%@include file="componentes/css.jsp"%>

<style type="text/css">
.back-img{
	
	heaight:50uh;
	width:100%;
	background-size:cover;
	background-repeat:no-repeat;
	
}
.card-bo:hover{
	bachground:#fcf7f7;
}


#toast{
	min-width: 300px;
	position: fixed;
	bottom: 30px;
	left: 50%;
	margin-left: -125px;
	background: #333;
	padding: 10px;
	color: white;
	text-align: center;
	z-index: 1;
	font-size: 18px;
	visibility: hidden;
	box-shadow: 0px 0px 100px #000;
}

#toast.display{
	visibility: visible;
	animation: fadeIn 0.5, fadeOut 0.5s 2.5s;
	
}

@keyframes fadeIn {from {botton:0;
	opacity: 0}
}
to{
	bottom: 30px;
	opacity: 1;
} 

@keyframes fadeOut{form{bottom: 30px;
	opacity: 1;
}
to{
	bottom: 0;
	opacity: 0;	
}
}

</style>
</head>
<body>
	
	 <%
		Usuario usuario= (Usuario)session.getAttribute("userobj");
	%>
	<c:choose>
    <c:when test="${requestScope.adminLoggedIn eq true}">
        <%@include file="../componentes/navbaradmin.jsp" %>
    </c:when>
    <c:otherwise>
        <%@include file="../componentes/navbar.jsp" %>
    </c:otherwise>
</c:choose>
	<c:if test="${not empty addCarrito}">
		
		<div id="toast"> ${addCarrito} </div>
		
		<script type="text/javascript">
			showToast();
			function showToast(content){
				$('#toast').addClass("display");
				$('#toast').html(content);
				setTimeout(()=>{
					$("#toast").removeClass("display");
				},2000)
			}
		</script>
		</c:if>
	<div class="container-fluid back-img">
		<h2 class="text-center text-danger">ShoopingCart</h2>
	</div>
	
	<!-- NIKE -->
	
	

	<div class="container" style="background-color:#f7f7f7;">
		
		<h3 class="text-center">Zapatillas</h3>
		<div class="row">
			
			<%
				ProductoDaoImp dao = new ProductoDaoImp(DBConexion.getConnection());
				
				List<Producto> list=dao.getByZapatillas();
				for(Producto prod:list)
				{%>
				<div class="col-md-3">
				<div class="card crd-ho">
				<div class="card-body text-center">
					<img src="img/<%=prod.getImagen() %>" style="width:150px; height: 200px;" class="img-prod">
					<p><%=prod.getNombre()%></p>
					<p>
						Marca:<%=prod.getCategoria()%></p> 
							
						<p>$<%=prod.getPrecio()%></p>
				  
						<div class="row">
						 <%
							if (usuario == null) {
							%>
							    <a href="login.jsp" class="btn btn-danger btn-sm ml-5">Agregar</a>
							
							<%
							} else {
							%>
								    <a href="carrito?idprod=<%=prod.getIdprod()%>&&idusuario=<%=usuario.getIdusuario()%>" class="btn btn-danger btn-sm ml-5">Agregar</a>
						
							<%
							}
							%>

							
							<a href="viewProductos.jsp?idprod=<%=prod.getIdprod()%>" class="btn btn-success btn-md ml-3">Ver</a>
						</div>
		
				</div>
			</div>
			</div>
				<%
				}
				%>
				
			
			</div>	
			<div class="text-center mt-1">
				<a href="allZapatillas.jsp" class="btn btn-danger btn-sm text-white">Ver Todos</a>
			</div>
		</div>

		<!-- NIKE -->
		
 	<!-- Remeras -->	
	<div class="container" style="background-color:#f7f7f7;">
		<h3 class="text-center">Remeras</h3>
		<div class="row">
			
			<%
				ProductoDaoImp dao2 = new ProductoDaoImp(DBConexion.getConnection());
				
				List<Producto> list2=dao2.getByRemeras();
				for(Producto prod:list2)
				{%>
				<div class="col-md-3">
				<div class="card crd-ho">
				<div class="card-body text-center">
					<img src="img/<%=prod.getImagen() %>" style="width:150px; height: 200px;" class="img-prod">
					<p><%=prod.getNombre()%></p>
					<p>
						Marca:<%=prod.getCategoria()%></p> 
							
						<p>$<%=prod.getPrecio()%></p>
				  
						<div class="row">
							 <%
							if (usuario == null) {
							%>
							    <a href="login.jsp" class="btn btn-danger btn-sm ml-5">Agregar</a>
							
							<%
							} else {
							%>
								    <a href="carrito?idprod=<%=prod.getIdprod()%>&&idusuario=<%=usuario.getIdusuario()%>" class="btn btn-danger btn-sm ml-5">Agregar</a>
						
							<%
							}
							%>


							<a href="viewProductos.jsp?idprod=<%=prod.getIdprod()%>" class="btn btn-success btn-md ml-3">Ver</a>
						</div>
		
				</div>
			</div>
			</div>
				<%
				}
				%>
				
			
			</div>	
			<div class="text-center mt-1">
				<a href="allRemeras.jsp" class="btn btn-danger btn-sm text-white">Ver Todos</a>
			</div>
		</div>

		<!-- Remeras -->
		
			<!-- Pantalones-->	
	<div class="container" style="background-color:#f7f7f7;">
		<h3 class="text-center">Pantalones</h3>
		<div class="row">
			
			<%
				ProductoDaoImp dao3 = new ProductoDaoImp(DBConexion.getConnection());
				
				List<Producto> list3=dao3.getByPantalones();
				for(Producto prod:list3)
				{%>
				<div class="col-md-3">
				<div class="card crd-ho">
				<div class="card-body text-center">
					<img src="img/<%=prod.getImagen() %>" style="width:150px; height: 200px;" class="img-prod">
					<p><%=prod.getNombre()%></p>
					<p>
						Marca:<%=prod.getCategoria()%></p> 
							
						<p>$<%=prod.getPrecio()%></p>
				  
						<div class="row">
							 <%
							if (usuario == null) {
							%>
							    <a href="login.jsp" class="btn btn-danger btn-sm ml-5">Agregar</a>
							
							<%
							} else {
							%>
								    <a href="carrito?idprod=<%=prod.getIdprod()%>&&idusuario=<%=usuario.getIdusuario()%>" class="btn btn-danger btn-sm ml-5">Agregar</a>
						
							<%
							}
							%>


							
							<a href="viewProductos.jsp?idprod=<%=prod.getIdprod()%>" class="btn btn-success btn-md ml-3">Ver</a>
					
						</div>
		
				</div>
			</div>
			</div>
				<%
				}
				%>
				
			
			</div>	
			<div class="text-center mt-1">
				<a href="allPantalones.jsp" class="btn btn-danger btn-sm text-white">Ver Todos</a>
			</div>
		</div>

		<!-- Pantalones -->
		
	
	<div style="margin-top:300px;">
	<%@include file="componentes/footer.jsp"%></div>
</body>
</html>
