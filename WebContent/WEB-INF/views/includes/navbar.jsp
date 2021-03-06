<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<spring:url value="/" var="urlRoot"/>  
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#">Monitor de bienes</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="${urlRoot}">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="#">Disabled</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="${urlRoot}hogar/index" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Hogar</a>
            <div class="dropdown-menu" aria-labelledby="dropdown01">
              <a class="dropdown-item" href="${urlRoot}hogar/index">Hogar</a>
              <a class="dropdown-item" href="${urlRoot}hogar/consumoh">Consumo Hogar</a>
              <a class="dropdown-item" href="${urlRoot}hogar/seguridadh">Seguridad Hogar</a>
              
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Rastreo</a>
            <div class="dropdown-menu" aria-labelledby="dropdown01">
              <a class="dropdown-item" href="#">Bicicletas</a>
              <a class="dropdown-item" href="#">Motos</a>
              <a class="dropdown-item" href="#">Carros</a>
            </div>
          </li>

			<sec:authorize access="isAnonymous()">
				<li class="nav-item active"><a class="nav-link"
					href="${urlRoot}loginUser">Iniciar Sesi�n </a></li>
					
				<li class="nav-item active"><a class="nav-link"
					href="${urlRoot}usuario/form">Registrarse </a></li>
			</sec:authorize>

			<sec:authorize access="hasAnyAuthority('gerente')">
				<li class="nav-item active"><a class="nav-link"
					href="${urlRoot}usuario/index">Usuarios</a>
				</li>

				<li class="nav-item active"><a class="nav-link"
					href="${urlRoot}usuario/logout">Salir </a></li>
			</sec:authorize>
			
			<sec:authorize access="hasAnyAuthority('usuario')">
				<li class="nav-item active"><a class="nav-link"
					href="${urlRoot}hogar/hogarusuario">Hogares </a>
				</li>
				<li class="nav-item active"><a class="nav-link"
					href="${urlRoot}usuario/logout">Salir </a></li>
			</sec:authorize>
		</ul>
        <!-- 
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
         -->
      </div>
    </nav>