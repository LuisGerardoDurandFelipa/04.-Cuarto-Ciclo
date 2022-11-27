package com.idat.edu.pe.daa.modulo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
		@NamedQuery(name = "Cliente.findById_Cliente", query = "SELECT c FROM Cliente c WHERE c.id_Cliente = :id_Cliente"),
		@NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre"),
		@NamedQuery(name = "Cliente.findByApellido", query = "SELECT c FROM Cliente c WHERE c.apellido = :apellido"),
		@NamedQuery(name = "Cliente.findByDni", query = "SELECT c FROM Cliente c WHERE c.dni = :dni"),
		@NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono"),
		@NamedQuery(name = "Cliente.findByCorreo", query = "SELECT c FROM Cliente c WHERE c.correo = :correo")

})

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_Cliente")
	private Long id_Cliente;

	@Basic(optional = false)
	@Column(name = "nombre")
	private String nombre;
	@Basic(optional = false)
	@Column(name = "apellido")
	private String apellido;
	@Basic(optional = false)
	@Column(name = "dni")
	private String dni;
	@Basic(optional = false)
	@Column(name = "telefono")
	private String telefono;
	@Basic(optional = false)
	@Column(name = "correo")
	private String correo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	@JsonBackReference(value = "cliente_reserva")
	private List<Reserva> reservaList;
	
	
	
	

	public List<Reserva> getReservaList() {
		return reservaList;
	}

	

	public void setReservaList(List<Reserva> reservaList) {
		this.reservaList = reservaList;
	}



	public Cliente() {
	}



	public Cliente(Long id_Cliente) {
		this.id_Cliente = id_Cliente;
	}



	public Cliente(Long id_Cliente, String nombre, String apellido, String dni, String telefono, String correo) {
		this.id_Cliente = id_Cliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.correo = correo;
	}



	public Long getId_Cliente() {
		return id_Cliente;
	}



	public void setId_Cliente(Long id_Cliente) {
		this.id_Cliente = id_Cliente;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	
	
	
	
	
	
	

}
