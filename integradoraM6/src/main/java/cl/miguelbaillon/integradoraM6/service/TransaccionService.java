package cl.miguelbaillon.integradoraM6.service;

import java.util.List;

import cl.miguelbaillon.integradoraM6.model.Transaccion;

public interface TransaccionService {
	int crear(Transaccion transaccion);
	List<Transaccion> listado(int id);
}
