package com.idat.edu.pe.daa.modulo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "academia")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Academia.findAll", query = "SELECT c FROM Academia c"),
		@NamedQuery(name = "Academia.findById_Registro", query = "SELECT c FROM Academia c WHERE c.id_Registro = :id_Registro"),
		@NamedQuery(name = "Academia.findByNombre_tutor", query = "SELECT c FROM Academia c WHERE c.nombre_tutor = :nombre_tutor"),
		@NamedQuery(name = "Academia.findByApellido_tutor", query = "SELECT c FROM Academia c WHERE c.apellido_tutor = :apellido_tutor"),
		@NamedQuery(name = "Academia.findByDni_tutor", query = "SELECT c FROM Academia c WHERE c.dni_tutor = :dni_tutor"),
		@NamedQuery(name = "Academia.findByTelefono_tutor", query = "SELECT c FROM Academia c WHERE c.telefono_tutor = :telefono_tutor"),
		@NamedQuery(name = "Academia.findByEmail_tutor", query = "SELECT c FROM Academia c WHERE c.email_tutor = :email_tutor"),
		@NamedQuery(name = "Academia.findByFechanac_estudiante", query = "SELECT c FROM Academia c WHERE c.fechanac_estudiante = :fechanac_estudiante"),
		@NamedQuery(name = "Academia.findByNombre_estudiante", query = "SELECT c FROM Academia c WHERE c.nombre_estudiante = :nombre_estudiante"),
		@NamedQuery(name = "Academia.findByApellido_estudiante", query = "SELECT c FROM Academia c WHERE c.apellido_estudiante = :apellido_estudiante"),
		@NamedQuery(name = "Academia.findByDni_estudiante", query = "SELECT c FROM Academia c WHERE c.dni_estudiante = :dni_estudiante"),
		@NamedQuery(name = "Academia.findByDeporte", query = "SELECT c FROM Academia c WHERE c.deporte = :deporte") })

public class Academia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_Registro")
	private Long id_Registro;
	
	@Basic(optional = false)
	@Column(name = "nombre_tutor")
	private String nombre_tutor;
	
	
	@Basic(optional = false)
	@Column(name = "apellido_tutor")
	private String apellido_tutor;
	
	@Basic(optional = false)
	@Column(name = "dni_tutor")
	private String dni_tutor;
	
	
	@Basic(optional = false)
	@Column(name = "telefono_tutor")
	private String telefono_tutor;
	
	
	@Basic(optional = false)
	@Column(name = "email_tutor")
	private String email_tutor;
	
	
	@Basic(optional = false)
	@Column(name = "fechanac_estudiante")
	private String fechanac_estudiante;
	
	
	@Basic(optional = false)
	@Column(name = "nombre_estudiante")
	private String nombre_estudiante;
	
	
	@Basic(optional = false)
	@Column(name = "apellido_estudiante")
	private String apellido_estudiante;
	
	
	@Basic(optional = false)
	@Column(name = "dni_estudiante")
	private String dni_estudiante;
	
	
	@Basic(optional = false)
	@Column(name = "deporte")
	private String deporte;


	public Academia() {
	}


	public Academia(Long id_Registro) {
		this.id_Registro = id_Registro;
	}


	public Academia(Long id_Registro, String nombre_tutor, String apellido_tutor, String dni_tutor,
			String telefono_tutor, String email_tutor, String fechanac_estudiante, String nombre_estudiante,
			String apellido_estudiante, String dni_estudiante, String deporte) {
		this.id_Registro = id_Registro;
		this.nombre_tutor = nombre_tutor;
		this.apellido_tutor = apellido_tutor;
		this.dni_tutor = dni_tutor;
		this.telefono_tutor = telefono_tutor;
		this.email_tutor = email_tutor;
		this.fechanac_estudiante = fechanac_estudiante;
		this.nombre_estudiante = nombre_estudiante;
		this.apellido_estudiante = apellido_estudiante;
		this.dni_estudiante = dni_estudiante;
		this.deporte = deporte;
	}


	public Long getId_Registro() {
		return id_Registro;
	}


	public void setId_Registro(Long id_Registro) {
		this.id_Registro = id_Registro;
	}


	public String getNombre_tutor() {
		return nombre_tutor;
	}


	public void setNombre_tutor(String nombre_tutor) {
		this.nombre_tutor = nombre_tutor;
	}


	public String getApellido_tutor() {
		return apellido_tutor;
	}


	public void setApellido_tutor(String apellido_tutor) {
		this.apellido_tutor = apellido_tutor;
	}


	public String getDni_tutor() {
		return dni_tutor;
	}


	public void setDni_tutor(String dni_tutor) {
		this.dni_tutor = dni_tutor;
	}


	public String getTelefono_tutor() {
		return telefono_tutor;
	}


	public void setTelefono_tutor(String telefono_tutor) {
		this.telefono_tutor = telefono_tutor;
	}


	public String getEmail_tutor() {
		return email_tutor;
	}


	public void setEmail_tutor(String email_tutor) {
		this.email_tutor = email_tutor;
	}


	public String getFechanac_estudiante() {
		return fechanac_estudiante;
	}


	public void setFechanac_estudiante(String fechanac_estudiante) {
		this.fechanac_estudiante = fechanac_estudiante;
	}


	public String getNombre_estudiante() {
		return nombre_estudiante;
	}


	public void setNombre_estudiante(String nombre_estudiante) {
		this.nombre_estudiante = nombre_estudiante;
	}


	public String getApellido_estudiante() {
		return apellido_estudiante;
	}


	public void setApellido_estudiante(String apellido_estudiante) {
		this.apellido_estudiante = apellido_estudiante;
	}


	public String getDni_estudiante() {
		return dni_estudiante;
	}


	public void setDni_estudiante(String dni_estudiante) {
		this.dni_estudiante = dni_estudiante;
	}


	public String getDeporte() {
		return deporte;
	}


	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	
	
	

}
