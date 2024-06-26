package cl.miguelbaillon.integradoraM6.service;

import java.util.List;

import cl.miguelbaillon.integradoraM6.model.Historial;

public interface HistorialService {
	List<Historial> obtenerListadoTransacciones(int id);
}
