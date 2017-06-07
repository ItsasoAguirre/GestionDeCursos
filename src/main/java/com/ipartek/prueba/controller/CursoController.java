package com.ipartek.prueba.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.prueba.domain.Curso;
import com.ipartek.prueba.service.ServiceCurso;

@Controller
@RequestMapping(value = "/curso")
public class CursoController {
	
	@Autowired
	private ServiceCurso serviceCurso;
	
	/**
	 * Listado de las ultimas 500 curso
	 * 
	 * @param model
	 *            "curso" ArrayList<Curso>
	 * @return vista "curso/index.jsp"
	 */
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String listar(Model model) {

		ArrayList<Curso> cursos = (ArrayList<Curso>) serviceCurso.listar();
		model.addAttribute("cursos", cursos);

		return "curso/index";
	}

}
