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

	/**
	 * Busca un curso a traves de su Id
	 * @param id del curso
	 * @return Curso resultante
	 */
	Curso buscarPorID(long id);

	/**
	 * Crea un nuevo curso
	 * @param c datos del curso a insertar
	 * @return true si se realiza con exito, false en caso contrario
	 */
	boolean crear(Curso c);

	/**
	 *  Modifica un curso ya existente
	 * @param c Curso con los datos actualizados
	 * @return true si se realiza con exito, false en caso contrario
	 */
	boolean modificar(Curso c);

	/**
	 * Elimina un curso
	 * @param id del curso a eliminar
	 * @return true si se realiza con exito, false en caso contrario
	 */
	boolean eliminar(long id);

}
