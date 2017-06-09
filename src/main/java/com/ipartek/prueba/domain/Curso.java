package com.ipartek.prueba.domain;

import java.io.Serializable;

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


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + "]";
	}
	
}
