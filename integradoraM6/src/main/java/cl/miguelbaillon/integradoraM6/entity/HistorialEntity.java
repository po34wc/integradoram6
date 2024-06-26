package cl.miguelbaillon.integradoraM6.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Historial")
public class HistorialEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "fuente")
	public String fuente;
	
	@Column(name = "fecha")
	public Date fecha;
	
	@Column(name = "nombreOri")
	public String nombreOri;
	
	@Column(name = "apellidoOri")
	public String apellidoOri;
	
	@Column(name = "tipo")
	public String tipo;
	
	@Column(name = "monto")
	public Float monto;
	
	@Column(name = "nombreDes")
	public String nombreDes;
	
	@Column(name = "apellidoDes")
	public String apellidoDes;
	
	@Column(name = "idusuario_origen")
	public int idusuario_origen;
	
	@Column(name = "idusuario_destino")
	public int idusuario_destino;
}
