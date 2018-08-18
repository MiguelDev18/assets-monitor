<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuarios</title>
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/hogar" var="urlHogar" />
<spring:url value="/usuario" var="urlUsuario" />
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Bienvenido</h1>
<jsp:include page="../includes/navbar.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">
        <!-- Example row of columns -->
        <br>
        
        <div class="col-md-8 order-md-1">

			<form:form action="${urlUsuario}/save" method="POST"
				modelAttribute="usuario">

				<div class="mb-3">
					<label for="nombre">Nombre </label>
					<form:hidden class="form-control" path="id" />
					<form:input type="text" class="form-control" path="nombre"
						id="nombre" required="required" />
				</div>

				<div class="mb-3">
					<label for="telefono">Teléfono </label>
					<form:input type="text" class="form-control" path="telefono"
						id="telefono" required="required" />
				</div>

				<div class="mb-3">
					<label for="email">Email </label>
					<form:input type="email" class="form-control" path="email"
						id="email" required="required" placeholder="you@example.com" />
				</div>

				<div class="mb-3">
					<label for="username">Nombre de Usuario </label>
					<form:input type="text" class="form-control" path="username"
						id="username" required="required" />
				</div>

				<div class="mb-3">
					<label for="password">Contraseña</label>
					<form:input type="password" class="form-control" path="password"
						id="password" required="required" />
				</div>

				<sec:authorize access="hasAnyAuthority('gerente')">
					<div class="form-check">
						<input type="checkbox" class="form-check-input" name="activo"
							value="true" id="activo" checked> <label
							class="form-check-label" for="defaultCheck1">Activar
							Usuario</label>
					</div>
				</sec:authorize>

				<hr class="mb-4">
				<button class="btn btn-primary btn-lg btn-block" type="submit">Registrar</button>
			</form:form>
		</div>
        
        <hr>
        
        

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