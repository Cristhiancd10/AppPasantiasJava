package astronet.ec.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cli_id")
	@GeneratedValue(generator = "secuenciaCliente")
	@SequenceGenerator(name = "secuenciaCliente", initialValue = 14)
	@NotNull
	private int id;
	
	@Column(name = "cli_cedula")
	@NotNull
	private String cedula;
	
	@Column(name = "cli_nombre")
	@NotNull
	private String nombre;
	
	@Column(name = "cli_email")
	@NotNull
	private String email;
	
	@Column(name = "cli_convencional")
	private String convencional;
	
	@Column(name = "cli_celular")
	private String celular;
	
	@Column(name = "cli_dirPrincipal")
	@NotNull
	private String direccionPrincipal;
	
	@Column(name = "cli_dirSecundaria")
	private String direccionSecundaria;
	
	@Column(name = "cli_dirReferencia")
	@NotNull
	private String direccionReferencia;
	
	@Column(name = "cli_latitud")
	@NotNull
	private String latitud;
	
	@Column(name = "cli_longitud")
	@NotNull
	private String longitud;
	
	/*
	 * Relacion Cliente con Servicio
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cliservicio_fk")
	private List<Servicio> servicio;
	
	/*
	 * Relacion Cliente con Registro
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cliregsitro_fk")
	@JsonIgnore
	private List<Registro> registro;
	
	/*
	 * Relacion cliente con antena
	 */
	@OneToOne
	@JoinColumn(name="antcliente_fk")
	//@JsonIgnore
	private Antena antena ;
	
	@Transient
	private int codigoAntenaTemp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConvencional() {
		return convencional;
	}

	public void setConvencional(String convencional) {
		this.convencional = convencional;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccionPrincipal() {
		return direccionPrincipal;
	}

	public void setDireccionPrincipal(String direccionPrincipal) {
		this.direccionPrincipal = direccionPrincipal;
	}

	public String getDireccionSecundaria() {
		return direccionSecundaria;
	}

	public void setDireccionSecundaria(String direccionSecundaria) {
		this.direccionSecundaria = direccionSecundaria;
	}

	public String getDireccionReferencia() {
		return direccionReferencia;
	}

	public void setDireccionReferencia(String direccionReferencia) {
		this.direccionReferencia = direccionReferencia;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public List<Servicio> getServicio() {
		return servicio;
	}

	public void setServicio(List<Servicio> servicio) {
		this.servicio = servicio;
	}

	public List<Registro> getRegistro() {
		return registro;
	}

	public void setRegistro(List<Registro> registro) {
		this.registro = registro;
	}

	public Antena getAntena() {
		return antena;
	}

	public void setAntena(Antena antena) {
		this.antena = antena;
	}
	
	
	public int getCodigoAntenaTemp() {
		return codigoAntenaTemp;
	}

	public void setCodigoAntenaTemp(int codigoAntenaTemp) {
		this.codigoAntenaTemp = codigoAntenaTemp;
	}



	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", email=" + email
				+ ", convencional=" + convencional + ", celular=" + celular + ", direccionPrincipal="
				+ direccionPrincipal + ", direccionSecundaria=" + direccionSecundaria + ", direccionReferencia="
				+ direccionReferencia + ", latitud=" + latitud + ", longitud=" + longitud + ", servicio=" + servicio
				+ ", antena=" + antena + "]";
	}

	public void addServicio(Servicio ser) {
		if(servicio==null) {
			servicio = new ArrayList<>();
		}
		this.servicio.add(ser);
	}
	
	public void addRegistro(Registro reg) {
		if(registro==null) {
			registro = new ArrayList<>();
		}
		this.registro.add(reg);
	}
	

}
