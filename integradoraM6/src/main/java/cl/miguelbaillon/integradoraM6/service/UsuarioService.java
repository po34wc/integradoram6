package cl.miguelbaillon.integradoraM6.service;

import java.util.List;

import cl.miguelbaillon.integradoraM6.model.Usuario;


public interface UsuarioService {
	Usuario getByUsername(String username);
	int crear(Usuario usuario);
	int editar(Usuario usuario);
	List<Usuario> listado();
	Usuario getById(int id);
	int actualizaSaldo(int id, int monto);
}
