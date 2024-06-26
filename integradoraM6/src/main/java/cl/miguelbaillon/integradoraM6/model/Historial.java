package cl.miguelbaillon.integradoraM6.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Historial {
	public int id;
	public String fuente;
	public Date fecha;
	public String nombreOri;
	public String apellidoOri;
	public String tipo;
	public Float monto;
	public String nombreDes;
	public String apellidoDes;
	public int idusuario_origen;
	public int idusuario_destino;
}
