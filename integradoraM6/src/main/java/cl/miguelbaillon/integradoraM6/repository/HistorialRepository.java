package cl.miguelbaillon.integradoraM6.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.miguelbaillon.integradoraM6.entity.HistorialEntity;

@Repository
public interface HistorialRepository extends CrudRepository<HistorialEntity, Integer> {
	
}
