package cl.miguelbaillon.integradoraM6.dao;

import java.util.List;

import cl.miguelbaillon.integradoraM6.model.Historial;

public interface HistorialDao {
	List<Historial> obtenerListadoTransacciones(int id);
}
