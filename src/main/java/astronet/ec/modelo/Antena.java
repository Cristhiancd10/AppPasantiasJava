package astronet.ec.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "Antena")
public class Antena implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ant_id")
	@GeneratedValue(generator = "secuenciaAntena")
	@SequenceGenerator(name = "secuenciaAntena", initialValue = 14)
	@NotNull
	private int id;
	
	@Column(name = "ant_modelo")
	@NotNull
	private String modelo;
	
	@Column(name = "ant_serie")
	@NotNull
	private String serie;
	
	/*
	 * Relacion Antena con Cliente
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "antcliente_fk")
	@JsonIgnore
	private List<Cliente> cliente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Antena [id=" + id + ", modelo=" + modelo + ", serie=" + serie + "]";
	}
	
	
	

}
