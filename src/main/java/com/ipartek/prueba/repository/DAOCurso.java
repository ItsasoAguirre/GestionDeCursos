package com.ipartek.prueba.repository;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.prueba.domain.Curso;

public interface DAOCurso {

	void setDatasource(DataSource ds);
	/**
	 * Listado de los 500 ultimos cursos insertados
	 * 
	 * @param filter filtro que es opcional para realizar una consulta a la API y te de los datos de forma asincrona
	 * @return List<Curso> si hay datos, si no List inicializada not null
	 */
	List<Curso> getAllAdmin(String filter);
	
	/**
	 * Lista los ultimo 10 cursos
	 * @param filter filtro que es opcional para realizar una consulta a la API y te de los datos de forma asincrona
	 * @return List<Curso> si hay datos, si no List inicializada not null
	 */
	List<Curso> getAllUser(String filter);
	
	Curso getById(long id);

	boolean insert(Curso r);

	boolean update(Curso r);

	boolean delete(long id);

}
