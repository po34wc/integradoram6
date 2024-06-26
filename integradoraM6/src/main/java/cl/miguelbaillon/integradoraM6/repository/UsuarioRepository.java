package cl.miguelbaillon.integradoraM6.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.miguelbaillon.integradoraM6.entity.UsuarioEntity;


@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Integer> {
	UsuarioEntity searchByUsername(String username);
}
