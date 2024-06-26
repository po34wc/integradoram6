package cl.miguelbaillon.integradoraM6.model;

import java.util.Date;

import lombok.Data;

@Data
public class Transaccion {
	private int idTransaccion;
	private Date fecha;
	private int idOrigen;
	private int idDestino;
	private String tipo;
	private Float monto;
}
