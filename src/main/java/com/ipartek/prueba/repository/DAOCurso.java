package com.ipartek.prueba.repository;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.prueba.domain.Curso;

/**
 * Interfaz con los diferentes metodos para crear el CRUD de los curso
 * @author Curso
 *
 */
public interface DAOCurso {

	/**
	 * Datasourse para poder conectarte a la base de datos correspondiente
	 * @param ds datasource
	 */
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
	
	/**
	 * Recoge un curso a traves de su Id
	 * @param id del curso a buscar
	 * @return curso resultante
	 */
	Curso getById(long id);

	/**
	 * Inserta un curso en la base de datos
	 * @param r Datos del curso a introducir
	 * @return true si inserta el curso, false en caso contrario
	 */
	boolean insert(Curso r);

	/**
	 * Modifica un curso
	 * @param r curso con los datos a modificar
	 * @return true si inserta el curso, false en caso contrario
	 */
	boolean update(Curso r);

	/**
	 * Elimina un curso de la base de datos
	 * @param id del curso a eliminar
	 * @return true si inserta el curso, false en caso contrario
	 */
	boolean delete(long id);

}
