<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hogar</title>
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/hogar" var="urlHogar" />
<spring:url value="/energy" var="urlEnergia" />
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Bienvenido</h1>
<jsp:include page="../includes/navbar.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">
        <!-- Example row of columns -->
		<hr>
		<c:if test="${mensaje!=null }">
			<div class='alert alert-success' role="alert">${ mensaje}</div>
		</c:if>
		
        <hr>
        
        <a href="${urlHogar}/form" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Registrar Hogar</a>
        
        <hr>
        
        <table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Id Hogar</th>
      <th scope="col">Ciudad</th>
      <th scope="col">Dirección</th>
      <th scope="col">Propietario</th>
      <th scope="col">Consumo energético</th>
      <th scope="col">Opciones de Hogar</th>
    </tr>
  </thead>
  <tbody>
  
  <c:forEach items="${hogares}" var="hogar">
  <tr>
  <td>${hogar.id }</td>
  <td>${hogar.ciudad }</td>
  <td>${hogar.direccion }</td>
  <td>${hogar.usuario.nombre}</td>
   
  <td>
  <form action="${urlEnergia}/energyhogar" method="POST">
  <input type="hidden" name="idHogar" value="${hogar.id}"/>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  <button type="submit" class="btn  btn-info btn-sm" ><span>Consultar</span></button>
  </form>
  </td>
  
  <td>
  <div class="btn-group" role="group">
  <form action="${urlHogar}/edit" method="POST">
  <input type="hidden" name="idHogar" value="${hogar.id}"/>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  <button type="submit" class="btn btn-outline-primary btn-sm" ><span>Editar</span></button>
  </form>
  
  <form action="${urlHogar}/delete" method="POST">
  <input type="hidden" name="idHogar" value="${hogar.id}"/>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  <button type="submit" onclick='return confirm("¿Estas seguro?")' class="btn btn-outline-danger btn-sm" ><span>Eliminar</span></button>
  </form>
  </div>
  </td>

  <!-- 
  <td>
  <a href="${urlEnergia}/energyhogar/${hogar.id}" class="btn  btn-info btn-sm" role="button"><span>Consultar</span></a>
  </td>
   -->
  
  
  <!-- 
  <td>
	<a href="${urlHogar}/edit/${hogar.id}" class="btn btn-success btn-sm" role="button" title="Edit"><span>Editar</span></a>
	<a href="${urlHogar}/delete/${hogar.id}" onclick='return confirm("¿Estas seguro?")' class="btn btn-danger btn-sm" role="button" title="Eliminar"><span>Eliminar</span></a>
</td>
 -->
  
  </tr>
  </c:forEach>
  <!-- 
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>
      <td>@twitter</td>
    </tr>
     -->
  </tbody>
</table>
<!-- 
<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">#</th>
      <th scope="col">First</th>
      <th scope="col">Last</th>
      <th scope="col">Handle</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>
      <td>@twitter</td>
    </tr>
  </tbody>
</table>   -->

<hr>


<jsp:include page="../includes/footer.jsp"></jsp:include>
      </div> <!-- /container -->

    </main>

    

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
  </body>
</body>
</html>