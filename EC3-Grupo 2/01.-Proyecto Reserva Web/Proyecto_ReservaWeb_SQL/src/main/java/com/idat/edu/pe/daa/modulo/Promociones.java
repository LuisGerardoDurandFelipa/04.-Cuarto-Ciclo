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
@Table(name = "promociones")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Promociones.findAll", query = "SELECT c FROM Promociones c"),
		@NamedQuery(name = "Promociones.findById_Promocion", query = "SELECT c FROM Promociones c WHERE c.id_Promocion = :id_Promocion"),
		@NamedQuery(name = "Promociones.findByNombre_promocion", query = "SELECT c FROM Promociones c WHERE c.nombre_promocion = :nombre_promocion"),
		@NamedQuery(name = "Promociones.findByDescripcion_promocion", query = "SELECT c FROM Promociones c WHERE c.descripcion_promocion = :descripcion_promocion"),
		@NamedQuery(name = "Promociones.findByFecha_promo_inicio", query = "SELECT c FROM Promociones c WHERE c.fecha_promo_inicio = :fecha_promo_inicio"),
		@NamedQuery(name = "Promociones.findByFecha_promo_final", query = "SELECT c FROM Promociones c WHERE c.fecha_promo_final = :fecha_promo_final")
})


public class Promociones  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_Promocion")
	private Long id_Promocion;
	
	@Basic(optional = false)
	@Column(name = "nombre_promocion")
	private String nombre_promocion;
	
	@Basic(optional = false)
	@Column(name = "descripcion_promocion")
	private String descripcion_promocion;
	
	@Basic(optional = false)
	@Column(name = "fecha_promo_inicio")
	private String fecha_promo_inicio;
	
	@Basic(optional = false)
	@Column(name = "fecha_promo_final")
	private String fecha_promo_final;

	public Promociones() {
	}

	public Promociones(Long id_Promocion) {
		this.id_Promocion = id_Promocion;
	}

	public Promociones(Long id_Promocion, String nombre_promocion, String descripcion_promocion,
			String fecha_promo_inicio, String fecha_promo_final) {
		this.id_Promocion = id_Promocion;
		this.nombre_promocion = nombre_promocion;
		this.descripcion_promocion = descripcion_promocion;
		this.fecha_promo_inicio = fecha_promo_inicio;
		this.fecha_promo_final = fecha_promo_final;
	}

	public Long getId_Promocion() {
		return id_Promocion;
	}

	public void setId_Promocion(Long id_Promocion) {
		this.id_Promocion = id_Promocion;
	}

	public String getNombre_promocion() {
		return nombre_promocion;
	}

	public void setNombre_promocion(String nombre_promocion) {
		this.nombre_promocion = nombre_promocion;
	}

	public String getDescripcion_promocion() {
		return descripcion_promocion;
	}

	public void setDescripcion_promocion(String descripcion_promocion) {
		this.descripcion_promocion = descripcion_promocion;
	}

	public String getFecha_promo_inicio() {
		return fecha_promo_inicio;
	}

	public void setFecha_promo_inicio(String fecha_promo_inicio) {
		this.fecha_promo_inicio = fecha_promo_inicio;
	}

	public String getFecha_promo_final() {
		return fecha_promo_final;
	}

	public void setFecha_promo_final(String fecha_promo_final) {
		this.fecha_promo_final = fecha_promo_final;
	}
	
	
	
}
