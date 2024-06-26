package cl.miguelbaillon.integradoraM6.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.miguelbaillon.integradoraM6.entity.TransaccionEntity;



@Repository
public interface TransaccionRepository extends CrudRepository<TransaccionEntity, Integer> {
	List<TransaccionEntity> findAllById(int id);
}
