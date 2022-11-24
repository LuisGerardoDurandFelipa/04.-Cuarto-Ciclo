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
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "campo")
@XmlRootElement

@NamedQueries({ @NamedQuery(name = "Campo.findAll", query = "SELECT c FROM Campo c"),
	@NamedQuery(name = "Campo.findById_Campo", query = "SELECT c FROM Campo c WHERE c.id_Campo = :id_Campo"),
	@NamedQuery(name = "Campo.findByCodigoCampo", query = "SELECT c FROM Campo c WHERE c.codigoCampo = :codigoCampo"),
	@NamedQuery(name = "Campo.findByNombreCampo", query = "SELECT c FROM Campo c WHERE c.nombreCampo = :nombreCampo"),
	@NamedQuery(name = "Campo.findByEstado", query = "SELECT c FROM Campo c WHERE c.estado = :estado"),
	@NamedQuery(name = "Campo.findByTipoCampo", query = "SELECT c FROM Campo c WHERE c.tipoCampo = :tipoCampo")

})

public class Campo implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_Campo")
	private Long id_Campo;
	

	@Basic(optional = false)
	@Column(name = "codigoCampo")
	private String codigoCampo;

	@Basic(optional = false)
	@Column(name = "nombreCampo")
	private String nombreCampo;

	@Basic(optional = false)
	@Column(name = "estado")
	private String estado;

	@Basic(optional = false)
	@Column(name = "tipoCampo")
	private String tipoCampo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "campo")
	@JsonBackReference(value = "campo_reserva")
	private List<Reserva> reservaList;

	@XmlTransient
	public List<Reserva> getReservaList() {
		return reservaList;
	}
	 
	public void setReservaList(List<Reserva> reservaList) {
		this.reservaList = reservaList;
	}
	public Campo() {
	}
	public Campo(Long id_Campo) {
		this.id_Campo = id_Campo;
	}
	public Campo(Long id_Campo, String codigoCampo, String nombreCampo, String estado, String tipoCampo) {
		this.id_Campo = id_Campo;
		this.codigoCampo = codigoCampo;
		this.nombreCampo = nombreCampo;
		this.estado = estado;
		this.tipoCampo = tipoCampo;
	}
	public Long getId_Campo() {
		return id_Campo;
	}
	public void setId_Campo(Long id_Campo) {
		this.id_Campo = id_Campo;
	}
	public String getCodigoCampo() {
		return codigoCampo;
	}
	public void setCodigoCampo(String codigoCampo) {
		this.codigoCampo = codigoCampo;
	}
	public String getNombreCampo() {
		return nombreCampo;
	}
	public void setNombreCampo(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTipoCampo() {
		return tipoCampo;
	}
	public void setTipoCampo(String tipoCampo) {
		this.tipoCampo = tipoCampo;
	}
	   
	   
	   
	
	
	

}
