package astronet.ec.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Agendamiento {
	
	@Id
	@Column(name = "agd_id")
	@GeneratedValue
	@NotNull
	private int id;
	
	@Column(name = "agd_fechaH")
	@NotNull
	private String fecha;
	
	@Column(name = "agd_observaciones")
	@NotNull
	private String observaciones;
	
	@Column(name = "agd_tecAsigna")
	@NotNull
	private String tecnicoAsigna;
	
	@Column(name = "agd_tecResponsable")
	@NotNull
	private String tecnicoResponsable;
	
	
	@Transient
	private int codigoRegistroTemp;
	
	/*
	 * Relacion Agendamiento con Registro
	 */
	@OneToOne
	@JoinColumn(name="regagendamiento_fk")
	@JsonIgnore
	private Registro registro ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	

	public String getTecnicoAsigna() {
		return tecnicoAsigna;
	}

	public void setTecnicoAsigna(String tecnicoAsigna) {
		this.tecnicoAsigna = tecnicoAsigna;
	}

	public String getTecnicoResponsable() {
		return tecnicoResponsable;
	}

	public void setTecnicoResponsable(String tecnicoResponsable) {
		this.tecnicoResponsable = tecnicoResponsable;
	}

	public int getCodigoRegistroTemp() {
		return codigoRegistroTemp;
	}

	public void setCodigoRegistroTemp(int codigoRegistroTemp) {
		this.codigoRegistroTemp = codigoRegistroTemp;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	@Override
	public String toString() {
		return "Agendamiento [id=" + id + ", fecha=" + fecha + ", observaciones=" + observaciones + ", tecnicoAsigna="
				+ tecnicoAsigna + ", tecnicoResponsable=" + tecnicoResponsable + "]";
	}

	
	
	
	

}
