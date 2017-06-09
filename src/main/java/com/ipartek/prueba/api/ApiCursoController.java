package com.ipartek.prueba.api;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipartek.prueba.domain.Curso;
import com.ipartek.prueba.service.ServiceCurso;

@Controller
@RequestMapping(value = "/api/curso/")
public class ApiCursoController {
	private static final Logger LOG = LoggerFactory.getLogger(ApiCursoController.class);
	
	@Autowired
	ServiceCurso serviceCurso;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Curso> listar(@RequestParam(value = "filter", required = false) String filter) {

		ArrayList<Curso> cursos = null;

		if (filter != null) {

			cursos = (ArrayList<Curso>) this.serviceCurso.listar(filter);

		} else {

			// TODO Fallo seguridad mostrar informacion del usuario privada
			cursos = (ArrayList<Curso>) this.serviceCurso.listar(null);

		}

		return cursos;
	}

}
