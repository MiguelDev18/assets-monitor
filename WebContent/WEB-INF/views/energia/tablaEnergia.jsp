<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Energia</title>
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

        
        <table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Id Energia</th>
      <th scope="col">Energia Dia</th>
      <th scope="col">Fecha</th>
      <th scope="col">Hogar Id</th>
    </tr>
  </thead>
  <tbody>
  
  <c:forEach items="${energia}" var="energia">
  <tr>
  <td>${energia.id }</td>
  <td>${energia.energiaDia }</td>
  <td>${energia.dia }</td>
  <td>${energia.hogar.id}</td>

  
  
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