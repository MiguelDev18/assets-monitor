<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pagina Principal</title>
<spring:url value="/resources" var="urlPublic" />
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Bienvenido</h1>
<jsp:include page="includes/navbar.jsp"></jsp:include>

    <main role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
        <div class="container">
          <h1 class="display-3">Administración</h1>
          <p>Bienvenido</p>
          <!-- <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p> -->
        </div>
      </div>

     </main>

    <jsp:include page="includes/footer.jsp"></jsp:include>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
  </body>
</body>
</html>