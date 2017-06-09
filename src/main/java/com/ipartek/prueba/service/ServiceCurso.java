package com.ipartek.prueba.service;

import java.util.List;

import com.ipartek.prueba.domain.Curso;



public interface ServiceCurso {
	
	/**
	 * Lista recetas sin ingredientes y sin usuario
	 * 
	 *
	 * @param filter
	 *            filtro por el nombre si viene rellenado, sino, lista todo.
	 * @return
	 */
	List<Curso> listar(String filter);

	Curso buscarPorID(long id);

	boolean crear(Curso c);

	boolean modificar(Curso c);

	boolean eliminar(long id);

}
