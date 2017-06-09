<%@ include file="../includes/header.jsp" %> 
<h1>Listado Cursos</h1>

<a href="admin/edit">Crear Nuevo</a>

<!-- atributo request -->
<p>${msg}</p>
<!-- parametro request, ej: ?msg=Mensaje+para+el+usuario -->
<p>${param.msg}</p>

<table class="tablePlugin" cellspacing="0" width="100%">
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
		<a href="admin/edit/${c.id}">${c.codigo}</a>
	</td>
</tr>	
</c:forEach>

</tbody>
</table>



<%@ include file="../includes/footer.jsp" %> 