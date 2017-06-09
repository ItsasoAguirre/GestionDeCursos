
/*** Autocomplete ***/
	$(function() {	
		console.log ('autocomplete cursos');
		$("#buscar_curso").autocomplete({
			source: function( request, response){
				var url = "/prueba/api/curso/?filter=" + $("#buscar_curso").val().trim() + "";
				
				//console.log("url para autocomplete: %s", url);
				
				$.ajax( {
					"url" : url,
					"type" : "GET",
					"dataType": "json",					
					"success" : function(data) {
						
						var cursos = [];
						
						$.each(data, function(i, v){
							cursos.push(v.nombre)	;
						});
						
						response (cursos);
						
						console.log("Llego el contenido %o y no hubo error", cursos);
						
					}
					
				});
			},
			
			minLength: 2
			
		});
	});

