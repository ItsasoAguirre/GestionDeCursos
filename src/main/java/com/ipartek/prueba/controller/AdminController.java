package com.ipartek.prueba.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.prueba.domain.Curso;
import com.ipartek.prueba.service.ServiceCurso;

/**
 * Contolador para el admin
 * 
 * @author curso
 *
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

  private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

  @Autowired()
  private ServiceCurso serviceCurso;

  /**
   * Listar cursos
   * 
   * @param model
   *          atributos
   * @return listado de cursos
   */
  @RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
  public String listar(Model model) {
    LOG.info("listar");

    model.addAttribute("cursos", this.serviceCurso.listar());

    return "admin/index";
  }

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String irFormularioNuevo(Model model) {

		model.addAttribute("curso", new Curso());
		return "admin/form";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String irFormularioEditar(@PathVariable int id, Model model) {

		   Curso curso = this.serviceCurso.buscarPorID(id);

		    model.addAttribute("curso", curso);
		return "admin/form";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Valid Curso curso, BindingResult bindingResult, Model model) {

	    LOG.info("recibimos datos del formulario " + curso);
	    String msg = null;

	    // validar datos del formulario
	    if (!bindingResult.hasErrors()) {

	      if (curso.getId() == -1) {

	        this.serviceCurso.crear(curso);
	        msg = "Creado nuevo curso";

	      } else {

	        this.serviceCurso.modificar(curso);
	        msg = "Curso modificado";

	      }

	    } else {

	      LOG.info("formulario con datos no validos");

	    }

	    model.addAttribute("msg", msg);
	    model.addAttribute("cursos", this.serviceCurso.listar());

		return "admin/index";
	}

	/**
	 * Elimina curso
	 * 
	 * @param idCurso
	 *            identificador del curso
	 * @param model
	 *            <ol>
	 *            <li>msg: Mensaje para el usuario</li>
	 *            </ol>
	 * @return Si se elimina curso llamamos a la accion "listar".<br>
	 * 
	 * 
	 */
	@RequestMapping(value = "/delete/{idCurso}", method = RequestMethod.GET)
	public String eliminar(@PathVariable int idCurso, Model model) {

		LOG.info("eliminar curso " + idCurso);
		String view = "redirect: ../";
		String msg = "Curso no eliminado";

		if (serviceCurso.eliminar(idCurso)) {
			msg = "Curso eleminado con exito";

		} else {

			view = "redirect: ../edit/" + idCurso;
		}
		model.addAttribute("msg", msg);
		return view;
	}


}