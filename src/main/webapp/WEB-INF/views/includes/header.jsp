<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page session="false" %>

<html lang="es">
<head>
	<meta charset="UTF-8">
	<title><spring:message code="nav.app.name" text="GestionCursos"/></title>
	<base href="/prueba/" />
	<!-- FAVICON -->
		<link rel="apple-touch-icon" sizes="57x57" href="/prueba/resources/img/favicon/apple-icon-57x57.png">
		<link rel="apple-touch-icon" sizes="60x60" href="/prueba/resources/img/favicon/apple-icon-60x60.png">
		<link rel="apple-touch-icon" sizes="72x72" href="/prueba/resources/img/favicon/apple-icon-72x72.png">
		<link rel="apple-touch-icon" sizes="76x76" href="/prueba/resources/img/favicon/apple-icon-76x76.png">
		<link rel="apple-touch-icon" sizes="114x114" href="/prueba/resources/img/favicon/apple-icon-114x114.png">
		<link rel="apple-touch-icon" sizes="120x120" href="/prueba/resources/img/favicon/apple-icon-120x120.png">
		<link rel="apple-touch-icon" sizes="144x144" href="/prueba/resources/img/favicon/apple-icon-144x144.png">
		<link rel="apple-touch-icon" sizes="152x152" href="/prueba/resources/img/favicon/apple-icon-152x152.png">
		<link rel="apple-touch-icon" sizes="180x180" href="/prueba/resources/img/favicon/apple-icon-180x180.png">
		<link rel="icon" type="image/png" sizes="192x192"  href="/prueba/resources/img/favicon/android-icon-192x192.png">
		<link rel="icon" type="image/png" sizes="32x32" href="/prueba/resources/img/favicon/favicon-32x32.png">
		<link rel="icon" type="image/png" sizes="96x96" href="/prueba/resources/img/favicon/favicon-96x96.png">
		<link rel="icon" type="image/png" sizes="16x16" href="/prueba/resources/img/favicon/favicon-16x16.png">
		
		<link rel="manifest" href="/manifest.json">
		<meta name="msapplication-TileColor" content="#ffffff">
		<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
		<meta name="theme-color" content="#ffffff">
	<link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	
	<!-- Custom -->
 	<link href="resources/css/custom.css?v2.1" rel="stylesheet">		
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" crossorigin="anonymous">
	
</head>
<body>

	
	 <div class="container">

      <!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><spring:message code="nav.app.name" text="Inicio"/></a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">

          
          <!-- search -->

			<form class="navbar-form navbar-left">
				<div class="input-group">

					<label class="input-group-addon"for="buscar_curso"><span class=" glyphicon glyphicon-search "></span>Buscador</label>				
					<input id="buscar_curso" 
						       type="text" 
						       class="form-control" 
						       placeholder="Curso a buscar...">
				</div>				
			</form>

			<!-- menu derecha -->  
            <ul id="anclaSuperior" class="nav navbar-nav navbar-right">

					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<li class="active">
              	 			<a href="logout">LOGOUT</a>
              			</li>
					</c:if>
					<c:if test="${pageContext.request.userPrincipal.name == null}">
						<li class="active">
              	 			<a href="admin">LOGIN</a>
              			</li>
					</c:if>
            </ul>
            
                        
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        
      

   
	
	
	
	
	
	
	
	