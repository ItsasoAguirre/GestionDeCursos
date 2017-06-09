package com.ipartek.prueba.repository;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.prueba.domain.Curso;

public interface DAOCurso {

	void setDatasource(DataSource ds);
	/**
	 * Listado de todas las Recetas sin Usuarios
	 * 
	 * @return List<Recetas> si hay datos, si no List inicializada not null
	 */
	List<Curso> getAll(String filter);
	
	Curso getById(long id);

	boolean insert(Curso r);

	boolean update(Curso r);

	boolean delete(long id);

}
