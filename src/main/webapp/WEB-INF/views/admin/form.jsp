<%@ include file="../includes/header.jsp" %> 

<a href="admin">Volver</a>

<c:if test="${not empty curso.nombre}">
	<h2>Detalle del curso: ${curso.nombre}</h2>
</c:if>

<c:if test="${empty usuario.nombre}">
	<h2>Crear nuevo curso</h2>
</c:if>

${msg}

<div class="row">
	<div class="col-md-6">
		<form:form action="admin/crear" modelAttribute="curso">

			<form:hidden path="id" readonly="true" />
			<br>
			<form:label path="nombre">Nombre:</form:label>
			<form:input path="nombre" />
			<br>
			<form:errors path="nombre" cssStyle="color:red;" />
			<br>
			<form:label path="codigo">Codigo:</form:label>
			<form:input path="codigo" />
			<br>
			<form:errors path="codigo" cssStyle="color:red;" />
			<br>

			<c:choose>
				<c:when test="${curso.id == -1}">
					<form:button type="submit">Crear</form:button>
				</c:when>
				<c:otherwise>
					<form:button type="submit">Modificar</form:button>
				</c:otherwise>
			</c:choose>


		</form:form>
	</div>

</div>
<!-- <div class="row"> -->

<c:if test="${curso.id != -1}">
	<br>
	<a style="color: red;" href="admin/delete/${curso.id}">Eliminar</a>
</c:if>

<%@ include file="../includes/footer.jsp" %> 



