package cl.miguelbaillon.integradoraM6.service;

import java.util.List;

import cl.miguelbaillon.integradoraM6.model.Cuenta;

public interface CuentaService {
	List<Cuenta> obtenerListadoCuentas(int id);
}
