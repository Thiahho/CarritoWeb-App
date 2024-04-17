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
	<c:choose>
    <c:when test="${requestScope.adminLoggedIn eq true}">
        <%@include file="../componentes/navbaradmin.jsp" %>
    </c:when>
    <c:otherwise>
        <%@include file="../componentes/navbar.jsp" %>
    </c:otherwise>
</c:choose>
	<c:if test="${empty userobj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<div class="container">
		<div class="row p-5">
			<div class="col-md-3">
			<a href="allProductos.jsp">
				<div class="card">
					<div class="card-body text-center">
						<i class="fa-solid fa-box fa-3x text-primary"></i><br>
						<h4>Productos</h4>
						--------------
					</div>
				</div>
			</a>
			</div>
			
			<div class="col-md-3">
			<a href="addProductos.jsp">
				<div class="card">
					<div class="card-body text-center">
						<i class="fas fa-plus-square fa-3x text-danger"></i><br>
						<h4>Agregar Nuevo</h4>
						--------------
					</div>
				</div>
			</a>
			</div>
			
			<div class="col-md-3">
			  <a href="pedidos.jsp">
				<div class="card">
					<div class="card-body text-center">
						<i class="fa-solid fa-truck-fast fa-3x text-warning"></i><br>
						<h4>Pedidos</h4>
						--------------
					</div>
				</div>
			  </a>
			</div>
			
				<div class="col-md-3">
			  <a href="allUsuarios.jsp">
				<div class="card">
					<div class="card-body text-center">
						<i class="fa-solid fa-money-bill fa-3x"></i><br>
						<h4>Usuarios</h4>
						--------------
					</div>
				</div>
			  </a>
			</div>
			
				<div class="col-md-3">
			  <a href="../index.jsp">
				<div class="card">
					<div class="card-body text-center">
						<i class="fa-solid fa-money-bill fa-3x"></i><br>
						<h4>Index</h4>
						--------------
					</div>
				</div>
			  </a>
			</div>
			
			
			<div class="col-md-3">
				<a data-toggle="modal" data-target="#exampleModalCenter" >
				
				<div class="card">
					<div class="card-body text-center">
						<i class="fa-solid fa-right-from-bracket fa-3x text-primary"></i><br>
						<h4>Logout</h4>
						--------------
					</div>
				</div>
				
				</a>
			</div>
		</div>
	</div>
	
<!-- LOGOUT MODAL -->

<!-- Vertically centered modal -->


<div class="modal fade" id="exampleModalCenter" tabindex="-1" aria-labelledby="exampleModalCenterTittle" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTittle">Titulo</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="text-center">
          <h4>¿Está seguro de que desea cerrar sesión?</h4>
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
          <a href="../logout" type="button" class="btn btn-primary text-white">Logout</a>
        
        </div>
      </div>
      <div class="modal-footer">
        
      </div>
    </div>
  </div>
</div>


<!-- END LOGOUT -->
	
	<div style="margin-top:480px;">
	<%@include file="footer.jsp" %></div>
</body>
</html>