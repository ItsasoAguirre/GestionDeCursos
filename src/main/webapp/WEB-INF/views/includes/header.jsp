<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page session="false" %>

<html lang="es">
<head>
	<meta charset="UTF-8">
	<title><spring:message code="nav.app.name" text="GestionCursos"/></title>
	<base href="/prueba/" />
	
	<link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	
	<!-- Custom -->
<!-- 	<link href="resources/css/custom.css?d=201702288v1" rel="stylesheet">	
	<link href="resources/css/detalle.css" rel="stylesheet"> -->	
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

			<c:if test="${not empty }">
				<h2>Detalle del curso: ${curso.nombre}</h2>
			</c:if>
						<!-- menu derecha -->  
            <ul class="nav navbar-nav navbar-right">
              <li class="active">
              	 <a href="admin">LOGIN</a>
              	</li>
            </ul>
            
                        
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        
      

   
	
	
	
	
	
	
	
	