package com.ipartek.prueba.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.prueba.domain.Curso;
import com.ipartek.prueba.repository.mapper.CursoMapper;

@Repository("daoCurso")
public class DAOCursoImple implements DAOCurso {

	private final Log LOG = LogFactory.getLog(getClass());
	
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Override
	public void setDatasource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}
	
	private static final String SQL_GET_ALL = "SELECT `id`, `nombreCurso`, `codigoCurso` FROM `curso` ORDER BY `id` DESC LIMIT 1000;";

	@Override
	public List<Curso> getAll() {
		ArrayList<Curso> lista = new ArrayList<Curso>();

		try {

				lista = (ArrayList<Curso>) this.jdbcTemplate.query(SQL_GET_ALL, new CursoMapper());

		} catch (EmptyResultDataAccessException e) {

			this.LOG.warn("No existen cursos todavia");

		} catch (Exception e) {

			this.LOG.error(e.getMessage());

		}

		return lista;
	}

	@Override
	public Curso getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Curso r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Curso r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}
}
