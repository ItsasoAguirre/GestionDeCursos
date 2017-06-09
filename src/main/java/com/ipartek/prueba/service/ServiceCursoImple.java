package com.ipartek.prueba.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.prueba.domain.Curso;
import com.ipartek.prueba.repository.DAOCurso;

@Service("serviceCurso")
public class ServiceCursoImple implements ServiceCurso {

	private final Log LOG = LogFactory.getLog(getClass());
	@Autowired
	private DAOCurso daoCurso;

	@Override
	public List<Curso> listar(String filter) {
		LOG.trace("listar cursos");
		return daoCurso.getAll( filter);
	}

	@Override
	public Curso buscarPorID(long id) {
		LOG.trace("Buscamos curso por id: " + id);
		Curso curso = daoCurso.getById(id);
		return curso;
	}

	@Override
	public boolean crear(Curso c) {
		LOG.trace("Creando curso: " + c);
		return daoCurso.insert(c);
	}

	@Override
	public boolean modificar(Curso c) {
		LOG.trace("Modificando curso: " + c);
		return daoCurso.update(c);
	}

	@Override
	public boolean eliminar(long id) {
		LOG.trace("Eliminando por id: " + id);
		return daoCurso.delete(id);
	}
}
