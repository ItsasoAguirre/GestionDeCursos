package com.ipartek.prueba.api;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipartek.prueba.domain.Curso;
import com.ipartek.prueba.service.ServiceCurso;
/**
 * Controlador para la Api de los cursos
 * @author Curso
 *
 */
@Controller()
@RequestMapping(value = "/api/curso/")
public class ApiCursoController {
	
	
	@Autowired()
	private ServiceCurso serviceCurso;
	
	/**
	 * Listado de los cursos con un filtro opcional o sin el
	 * @param filter filtro opcional que sirve para realizar una busqueda de un curso concreto a partir de su nombre
	 * @return retorna los cursos ya sean con filtro o no 
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody() ArrayList<Curso> listar(@RequestParam(value = "filter", required = false) String filter) {

		ArrayList<Curso> cursos = null;

		if (filter != null) {

			cursos = (ArrayList<Curso>) this.serviceCurso.listarAdmin(filter);

		} else {

			cursos = (ArrayList<Curso>) this.serviceCurso.listarAdmin(null);

		}

		return cursos;
	}

}
