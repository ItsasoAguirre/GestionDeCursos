package com.ipartek.prueba.service;

import java.util.List;

import com.ipartek.prueba.domain.Curso;



public interface ServiceCurso {
	
	/**
	 * Lista cursos maximo 500
	 * 
	 *
	 * @param filter
	 *            filtro por el nombre si viene rellenado, sino, lista todo.
	 * @return
	 */
	List<Curso> listarAdmin(String filter);
	
	/**
	 * Lista de los ultimos 10 cursos
	 * @param filter
	 * @return
	 */
	List<Curso> listarUser(String filter);

	Curso buscarPorID(long id);

	boolean crear(Curso c);

	boolean modificar(Curso c);

	boolean eliminar(long id);

}
