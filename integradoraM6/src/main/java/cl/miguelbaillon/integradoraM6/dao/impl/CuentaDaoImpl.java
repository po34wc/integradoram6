package cl.miguelbaillon.integradoraM6.dao.impl;

import java.sql.ResultSet;
import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.miguelbaillon.integradoraM6.dao.CuentaDao;
import cl.miguelbaillon.integradoraM6.model.Cuenta;

@Repository
public class CuentaDaoImpl implements CuentaDao {
	private final JdbcTemplate jdbcTemplate;
	
	public CuentaDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Cuenta> obtenerListadoCuentas(int id) {
		try {
			String sql = """
					SELECT
						idusuario AS id,
						nombre,
						apellido
					FROM usuario
					ORDER BY nombre, apellido
					""";
			List<Cuenta> cuentas = jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
				Cuenta cuenta = new Cuenta();
				if (rs.getInt("id") != id) {
					cuenta.setId(rs.getInt("id"));
					cuenta.setNombre(rs.getString("nombre"));
					cuenta.setApellido(rs.getString("apellido"));
				}
				return cuenta;
			}, new Object[] { });
			return cuentas;
		} catch(Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			return Collections.emptyList();
		}
	}
}
