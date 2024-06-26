package cl.miguelbaillon.integradoraM6.dao;

import java.util.List;

import cl.miguelbaillon.integradoraM6.model.Cuenta;

public interface CuentaDao {
	List<Cuenta> obtenerListadoCuentas(int id);
}
