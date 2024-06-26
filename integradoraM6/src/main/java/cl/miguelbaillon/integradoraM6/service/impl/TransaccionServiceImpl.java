package cl.miguelbaillon.integradoraM6.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.miguelbaillon.integradoraM6.entity.TransaccionEntity;
import cl.miguelbaillon.integradoraM6.model.Transaccion;
import cl.miguelbaillon.integradoraM6.repository.TransaccionRepository;
import cl.miguelbaillon.integradoraM6.service.TransaccionService;
import lombok.extern.apachecommons.CommonsLog;


@Service
@CommonsLog
public class TransaccionServiceImpl implements TransaccionService {
	private final TransaccionRepository transaccionRepository;
	
	public TransaccionServiceImpl(TransaccionRepository transaccionRepository) {
		this.transaccionRepository = transaccionRepository;
	}


	@Override
	@Transactional
	public int crear(Transaccion transaccion) {
		try {
			TransaccionEntity transaccionEntity = new TransaccionEntity();
			
			Date date = new Date();
			
			transaccionEntity.setFecha(date);
			transaccionEntity.setIdOrigen(transaccion.getIdOrigen());
			transaccionEntity.setIdDestino(transaccion.getIdDestino());
			transaccionEntity.setTipo(transaccion.getTipo());
			transaccionEntity.setMonto(transaccion.getMonto());
			
			TransaccionEntity transaccionGuardado = transaccionRepository.save(transaccionEntity);
			return transaccionGuardado.getId();
		} catch(Exception ex) {
			log.error(ex.getMessage());
			throw ex;
		}
	}

	@Override
	public List<Transaccion> listado(int id) {
		try {
			List<Transaccion> listado = new ArrayList<>();
			Iterable<TransaccionEntity> listadoEntities = transaccionRepository.findAllById(id);
			
			for (TransaccionEntity transaccionEntity : listadoEntities) {
				Transaccion transaccion = new Transaccion();
				transaccion.setIdTransaccion(transaccionEntity.getId());
				transaccion.setFecha(transaccionEntity.getFecha());
				transaccion.setIdOrigen(transaccionEntity.getIdOrigen());
				transaccion.setIdDestino(transaccionEntity.getIdDestino());
				transaccion.setTipo(transaccionEntity.getTipo());
				transaccion.setMonto(transaccionEntity.getMonto());
				listado.add(transaccion);
			}
			return listado;
		} catch(Exception ex) {
			log.error(ex.getMessage());
			throw ex; 
		}
	}
}
