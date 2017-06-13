package com.ipartek.prueba.controller;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.prueba.domain.Curso;
import com.ipartek.prueba.service.ServiceCurso;

import com.opencsv.CSVReader;

	/**
	 * Contolador para el admin
	 * 
	 * @author curso
	 *
	 */
	@Controller
	@RequestMapping(value = "/admin")
	public class AdminController {
	
	  public static final String SEPARATOR=";";
	  public static final String QUOTE="\"";

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
	  public String listarUser(Model model) {
	    LOG.info("listar");
	
	    model.addAttribute("cursos", this.serviceCurso.listarAdmin(null));
	
	    return "admin/index";
	  }
	
	  /**
	   * Para ir al formulario de un curso nuevo
	   * 
	   * @param model atributos del curso inicializado con el constructor con campos vacios y el index a -1
	   * @return form de curso nuevo
	   */
		@RequestMapping(value = "/edit", method = RequestMethod.GET)
		public String irFormularioNuevo(Model model) {
	
			model.addAttribute("curso", new Curso());
			return "admin/form";
		}
		
		/**
		 * Te lleva al formulario de editar un curso ya existente
		 * @param id del curso a editar
		 * @param model atributos del curso a modificar
		 * @return form de modificar curso
		 */
		@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
		public String irFormularioEditar(@PathVariable int id, Model model) {
	
			   Curso curso = this.serviceCurso.buscarPorID(id);
	
			    model.addAttribute("curso", curso);
			return "admin/form";
		}
	
		/**
		 * Crea un curso 
		 * @param curso datos del curso a insertar
		 * @param bindingResult 
		 * @param model mensajes para el usuario
		 * @return regresa al index de la pagina de gestion de cursos
		 */
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
		    model.addAttribute("cursos", this.serviceCurso.listarAdmin(null));
	
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
	
		/**
		 * Proceso de migracion desde un archivo .CSV a la base de datos
		 * 
		 * @param model mesaje para el usuario y la lista de todos los cursos
		 * @return vista de la lista de los cursos
		 */
		@RequestMapping(value = "/migrarCSV", method = RequestMethod.GET)
		public String migrarCSV(Model model) {

			LOG.info("migrar archivo ");
			String view = "redirect: ../";
			String msg = "Migracion no realizada";
			Curso c = null;
			ArrayList<Curso> noInsertados = new ArrayList<Curso>();
		

		     //"C:/Desarrollo/WorkSpaceExamen/GestionDeCursos/deploy/cursos.csv"
			CSVReader reader = null;
		      try {
		         reader = new CSVReader(new FileReader("C:/Desarrollo/WorkSpaceExamen/GestionDeCursos/deploy/cursos.csv"),';');
		         
		         List<String[]> texto = reader.readAll();
		         boolean primeraLinea=true;

			     for (String[] linea: texto) {
			    	 try{
			        	 if(!primeraLinea){
			        		 c=new Curso(linea[1],linea[8]);
			        		 this.serviceCurso.crear(c);
			        		 msg = "Creado nuevo curso";
			        	 }
			        	 primeraLinea=false;
			        	 msg = "Creado nuevo curso";
			        	 
			    	 }catch(DuplicateKeyException  e)
		        	 {
		        		 e.printStackTrace();
		        		 noInsertados.add(c);
		        	 }
				}
			     reader.close();
		        
			        	
		         
		      }//end primer try
		      catch(Exception e){
	        		 e.printStackTrace();
			        	
		      }finally 
		        	 {
	     		 if (null != reader) 
	     		 {
	     			 try {
	     				 reader.close();
	     				 
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	     		 } //end if
		     	}//end finally
		      	msg = "No han sido creados "+noInsertados.size()+" cursos por ya estar introducidos";
				model.addAttribute("msg", msg);
				model.addAttribute("cursos", this.serviceCurso.listarAdmin(null));
				return "admin/index";
		   
		}
}//end controller
		
