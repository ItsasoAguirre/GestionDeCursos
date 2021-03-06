package com.ipartek.prueba.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.prueba.domain.Curso;
/**
 * Mapper para el curso
 * @author Curso
 *
 */
public class CursoMapper implements RowMapper<Curso> {

	@Override()
	public Curso mapRow(ResultSet rs, int numRow) throws SQLException {

		Curso c = new Curso();

		c.setId(rs.getLong("id"));
		c.setNombre(rs.getString("nombreCurso"));
		c.setCodigo(rs.getString("codigoCurso"));


		return c;
	}
}
