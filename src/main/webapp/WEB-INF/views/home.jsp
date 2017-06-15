<%@ include file="includes/header.jsp"%>

<h1>Listado Cursos</h1>

<!-- atributo request -->
<p>${msg}</p>
<!-- parametro request, ej: ?msg=Mensaje+para+el+usuario -->
<p>${param.msg}</p>

	<table class="tablePlugin fondo"  width="100%"><caption>Listado de los ultimos 10 cursos añadidos</caption>
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
		
				 ${c.nombre}			
					
		</td>
		<td>
			${c.codigo}
		</td>
	</tr>	
	</c:forEach>
	
	
	</tbody>
	</table>
	

	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="../../prueba/resources/js/cursos.js"></script>


<%@ include file="includes/footer.jsp" %> 