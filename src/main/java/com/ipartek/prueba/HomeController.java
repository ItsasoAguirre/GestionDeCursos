package com.ipartek.prueba;

import java.util.ArrayList;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.prueba.domain.Curso;
import com.ipartek.prueba.service.ServiceCurso;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private ServiceCurso serviceCurso;
	
	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Listado de los ultimos 10 cursos introducidos
	 * @param model listado de cursos
	 * @return vista a la pagina home
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
		LOG.info("Listando cursos");
		ArrayList<Curso> cursos = (ArrayList<Curso>) serviceCurso.listarUser(null);
		model.addAttribute("cursos", cursos);
		
		return "home";
	}
	
}
