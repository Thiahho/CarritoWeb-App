<%@page import="modelos.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="componentes/css.jsp"%>
<style type="text/css">
	
a{
text-decoration: none;
color: black;
}

a:hover{
text-decoration: none;
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

<div class="container">
	<h3 class="text-center">Hola</h3>
	<div class="row p-5">
		<!-- <div class="col-md-6">
			<a href="editarperfil.jsp">
				<div class="card">
					<div class="card-body text-center">
						<div class="text-primary">
							<i class="fa-solid fa-pen-to-square fa-3x"></i>
						</div>
						<h3>Editar Perfil </h3>
					</div>
				</div>
			</a>
		</div> -->
		<div class="col-md-12" style="text-align: center">
			<a href="pedidos.jsp">
				<div class="card">
					<div class="card-body text-center">
						<div class="text-primary">
							<i class="fa-solid fa-box-open fa-3x"></i>
						</div>
						<h3>Mis Pedidos</h3>
					</div>
				</div>
			</a>
		</div>
		
		
	</div>
	
</div>
<div style="margin-top:406px;">
	<%@include file="componentes/footer.jsp"%></div>
</body>
</html>