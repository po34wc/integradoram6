package cl.miguelbaillon.integradoraM6.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta {
	public int id;
	public String nombre;
	public String apellido;
}
