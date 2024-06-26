package cl.miguelbaillon.integradoraM6.model;


import lombok.Data;

@Data
public class Usuario {
	private int id;
	private String username;
	private String password;
	private String nombre;
	private String apellido;
	private String email;
	private int saldo;
	private Rol rol;
}
