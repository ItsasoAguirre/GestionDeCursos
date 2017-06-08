package com.ipartek.prueba.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
@Controller()
public class AdminController {

  private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

  @Autowired()
  private ServiceCurso serviceCurso;

  /**
   * Listar cursos
   * 
   * @param model
   *          atributos
   * @return listado de usuarios
   */
  @RequestMapping(value = "/admin", method = RequestMethod.GET)
  public String listar(Model model) {
    LOG.info("listar");

    model.addAttribute("cursos", this.serviceCurso.listar());

    return "curso/index";
  }

  /**
   * Eliminar cursos
   * 
   * @param id
   *          selecciona el id del curso a eliminar
   * @param model
   *          atributos
   * @return a la vista de cursos con el usuario eliminado
   */
  @RequestMapping(value = "/admin/curso/delete/{id}", method = RequestMethod.GET)
  public String eliminarCurso(@PathVariable() int id, Model model) {

    LOG.info("eliminar curso " + id);
    String msg = "Curso no eliminado";

    try {
      if (this.serviceCurso.eliminar(id)) {
        msg = "Curso Eliminada con exito";
      }
    } catch (DataIntegrityViolationException e) {
      LOG.error("Integridad de datos violada en eliminar curso", e);

    }
    model.addAttribute("msg", msg);
    model.addAttribute("cursos", this.serviceCurso.listar());

    return "curso/index";
  }

  /**
   * Da de alta a un usuario dado de baja
   * 
   * @param id
   *          del usuario
   * @param model
   *          atributos de la JSP
   * @return Lista de usuarios actiualizada
   */
  @RequestMapping(value = "/admin/curso/crear/{id}", method = RequestMethod.GET)
  public String crearCurso(@PathVariable() Curso c, Model model) {

    LOG.info("crear curso " + c.getId());
    String msg = "Curso no creado";

    try {
      if (this.serviceCurso.crear(c))
        msg = "Curso creado con exito";
      
    } catch (DataIntegrityViolationException e) {
      LOG.error("Integridad de datos violada al crear un curso", e);
      msg = e.getMessage();
    }
    model.addAttribute("msg", msg);
    model.addAttribute("usuarios", this.serviceCurso.listar());

    return "usuario/index";
  }


}