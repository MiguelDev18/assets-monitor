<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Signin Template for Bootstrap</title>
    <spring:url value="/resources" var="urlPublic" />
    <spring:url value="/" var="urlRoot" />
    <!-- Bootstrap core CSS -->
    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${urlPublic}/bootstrap/css/signin.css" rel="stylesheet">
  </head>

  <body class="text-center">
    <form class="form-signin" action="${urlRoot}login" method="post">
      
      <h1 class="h3 mb-3 font-weight-normal">Iniciar Sesión</h1>
      <label for="username" class="sr-only">User</label>
      <input type="text" id="username" name="username" class="form-control" placeholder="Usuario" required autofocus>
      <label for="password" class="sr-only">Password</label>
      <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      <br>
      <jsp:include page="includes/footer.jsp"></jsp:include>
    </form>
    
  </body>
  
</html>
