<%@ include file="../includes/header.jsp" %> 

<h1>Listado Cursos</h1>
<a href="admin/migrarCSV">Migrar cursos del archivo .CSV</a>
<br>
<br>
<a href="admin/edit">Crear Nuevo</a>


<!-- atributo request -->
<p>${msg}</p>
<!-- parametro request, ej: ?msg=Mensaje+para+el+usuario -->
<p>${param.msg}</p>

<table class="tablePlugin fondo"  width="100%"><caption>Listado de los ultimos 500 cursos a�adidos</caption>
  <thead>
      <tr>
          <th>Curso</th>
          <th>Codigo</th>
                 
      </tr>
  </thead>
  <tbody>        
<c:forEach items="${cursos}" var="c">
<tr>
	<td>		
		<a href="admin/edit/${c.id}">
			 ${c.nombre}			
		</a>		
	</td>
	<td>
		${c.codigo}
	</td>
</tr>	
</c:forEach>

</tbody>
</table>

<div class="circulo"><a href="admin/#anclaSuperior"><span class="fa fa-4x fa-arrow-circle-up" aria-hidden="true"></span></a></div>
<script src="../../prueba/resources/js/login.js"></script>
<%@ include file="../includes/footer.jsp" %> 