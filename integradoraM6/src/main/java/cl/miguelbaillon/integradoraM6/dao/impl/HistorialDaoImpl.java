package cl.miguelbaillon.integradoraM6.dao.impl;

import java.sql.ResultSet;
import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.miguelbaillon.integradoraM6.dao.HistorialDao;
import cl.miguelbaillon.integradoraM6.model.Historial;

@Repository
public class HistorialDaoImpl implements HistorialDao {
	private final JdbcTemplate jdbcTemplate;
	
	public HistorialDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Historial> obtenerListadoTransacciones(int id) {
		try {
			String sql = """
					call procesahistorial(?);
					""";
			List<Historial> hists = jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
				Historial historial = new Historial();
				historial.setId(rs.getInt("id"));
				historial.setFuente(rs.getString("fuente"));
				historial.setFecha(rs.getDate("fecha"));
				historial.setNombreOri(rs.getString("nombreOri"));
				historial.setApellidoOri(rs.getString("apellidoOri"));
				historial.setTipo(rs.getString("tipo"));
				historial.setMonto(rs.getFloat("monto"));
				historial.setNombreDes(rs.getString("nombreDes"));
				historial.setApellidoDes(rs.getString("apellidoDes"));
				return historial;
			}, new Object[] { id });
			return hists;
		} catch(Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			return Collections.emptyList();
		}
	}
}
