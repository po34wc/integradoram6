package cl.miguelbaillon.integradoraM6.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.miguelbaillon.integradoraM6.dao.HistorialDao;
import cl.miguelbaillon.integradoraM6.model.Historial;
import cl.miguelbaillon.integradoraM6.service.HistorialService;

@Service
public class HistorialServiceImpl implements HistorialService {
	private HistorialDao historialDao;
	
	public HistorialServiceImpl(HistorialDao historialDao) {
		this.historialDao = historialDao;
	}

	@Override
	public List<Historial> obtenerListadoTransacciones(int id) {
		return historialDao.obtenerListadoTransacciones(id);
	}
}
