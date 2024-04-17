<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page isELIgnored="false" %>
<div class="container-fluid" style="heaigth:10px; background-color:#303f9f; "></div>

<div class="container-fluid p-3">
	<div class="row">
		<div class="col-md-3">
			<h3><i class="fa-solid fa-box-open"></i>ShoppingCart</h3>
		</div>
		<div class="col-md-6">
		
		  <form class="form-inline my-2 my-lg-0" action="search.jsp" method="post">
		    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search">
		    <button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
		  </form>
		</div>
		<c:if test="${not empty userobj }">
			<div class="col-md-3">
			
			<a href="${pageContext.request.contextPath}/carrito.jsp" ><i class="fa-solid fa-cart-shopping fa-2x"></i></a>
			
				<a href="${pageContext.request.contextPath}/home.jsp" class="btn btn-success"><i class="fa-solid fa-user"></i> ${userobj.nombre}</a>
				<a href="${pageContext.request.contextPath}/logout" class="btn btn-primary"><i class="fa-solid fa-right-from-bracket"></i> Cerrar Sesion</a>
			</div>
		
		
		</c:if>
	<c:if test="${empty userobj }">
			<div class="col-md-3">
				<a href="login.jsp" class="btn btn-success">Login</a>
				<a href="registro.jsp" class="btn btn-primary">Registro</a>
			</div>
		
		
	</c:if>
		
	</div>

</div>

<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
	<a class="navbar-brand" href="#"><i class="fas fa-home"></i></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active"><a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Home
        </a>
      </li>
      <li class="nav-item active">
        <!--  <a class="nav-link" href="../allZapatillas.jsp"><i class="fa-solid fa-shoe-prints"></i> Zapatillas</a>
      -->
      <a href="${pageContext.request.contextPath}/allZapatillas.jsp" class="nav-link"><i class="fa-solid fa-shoe-prints"></i> Zapatillas</a>
      
      </li>
      <li class="nav-item active">
<!--         <a class="nav-link" href="../allRemeras.jsp"><i class="fa-solid fa-shirt"></i> Remeras</a> -->
 <a href="${pageContext.request.contextPath}/allRemeras.jsp" class="nav-link"><i class="fa-solid fa-shirt"></i> Remeras</a>
      </li>
      <li class="nav-item active">
        <a href="${pageContext.request.contextPath}/allPantalones.jsp" class="nav-link">Pantalones</a>
      </li>
       <!-- <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li> -->
     
    </ul>
    
    <form class="form-inline my-2 my-lg-0">
    	<a href="${pageContext.request.contextPath}/perfil.jsp" class="btn btn-light my-2 my-sm-0" ><i class="fa-solid fa-user"></i> Perfil</a>
    	<a href="./admin/home.jsp" class="btn btn-light my-2 my-sm-0" ><i class="fa-solid fa-user"></i> Home</a>
    	
       	<!--  <button class="btn btn-light my-2 my-sm-0 ml-2" type="submit"><i class="fa-solid fa-phone"></i> Contacto</button>-->
    </form>
  
  </div>
</nav>
