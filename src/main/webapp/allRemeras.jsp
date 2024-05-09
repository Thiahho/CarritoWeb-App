<%@page import="modelos.Usuario"%>
<%@page import="java.util.List"%>
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
<title>Remeras</title>
<%@include file="componentes/css.jsp"%>

<style type="text/css">

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

	
	<c:if test="${empty userobj }">
    <c:set var="addToCartUrl" value="login.jsp"/>
</c:if>
<c:if test="${not empty userobj }">
    <c:set var="addToCartUrl" value="carrito?idprod=${prod.getIdprod()}&idusuario=${usuario.getIdusuario()}"/>
</c:if>
	
<div class="container-fluid">
	<div class="row p-3">
	
			<%
			  ProductoDaoImp dao= new ProductoDaoImp(DBConexion.getConnection());
			  List<Producto> list= dao.getAllRemeras();
			  for(Producto prod: list)
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
</div>

</body>
</html>