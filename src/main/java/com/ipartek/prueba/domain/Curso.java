package com.ipartek.prueba.domain;

import java.io.Serializable;

/**
 * Pojo del curso con sus atributos
 * @author Curso
 *
 */
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ATRIBUTOS
	private long id;

	private String nombre;

	private String codigo;
	
	  // CONSTRUCTORES

	  /**
	   * Contructor con parámetros vacios
	   */
	  public Curso() {
	    super();
	    this.id = -1;
	    this.nombre = "";
	    this.codigo="";
	  }
	  

	  /**
	   * Contructor pasando nombre y codigo
	   * @param nombre del curso
	   * @param codigo del curso
	   */
	  public Curso(String nombre, String codigo) {
		    super();
		    this.id = -1;
		    this.nombre = nombre;
		    this.codigo=codigo;
		  }


	  /**
	   * Getter del id
	   * 
	   * @return el id del curso
	   */
	public long getId() {
		return id;
	}

	/**
	 * setter del id
	 * @param id setea el id que le pasas al id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * getter del nombre
	 * @return el nombre del curso
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * setter del nombre del curso
	 * @param nombre que le pasas para el curso
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * getter del codigo del curso
	 * @return codigo del curso
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * setter del codigo
	 * @param codigo que le pasas para el curso
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + "]";
	}
	
}
