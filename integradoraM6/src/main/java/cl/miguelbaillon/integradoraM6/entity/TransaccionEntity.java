package cl.miguelbaillon.integradoraM6.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "transaccion")
@Data
public class TransaccionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtransaccion")
	private int id;
	
	@Column(name = "fecha")
	private Date fecha;

	@Column(name = "idusuario_origen")
	private int idOrigen;
	
	@Column(name = "idusuario_destino")
	private int idDestino;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "monto")
	private Float monto;
}
