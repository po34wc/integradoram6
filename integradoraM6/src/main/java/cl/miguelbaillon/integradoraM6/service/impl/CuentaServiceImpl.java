package cl.miguelbaillon.integradoraM6.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.miguelbaillon.integradoraM6.dao.CuentaDao;
import cl.miguelbaillon.integradoraM6.model.Cuenta;
import cl.miguelbaillon.integradoraM6.service.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService {
	private CuentaDao cuentaDao;
	
	public CuentaServiceImpl(CuentaDao cuentaDao) {
		this.cuentaDao = cuentaDao;
	}

	@Override
	public List<Cuenta> obtenerListadoCuentas(int id) {
		return cuentaDao.obtenerListadoCuentas(id);
	}
}
