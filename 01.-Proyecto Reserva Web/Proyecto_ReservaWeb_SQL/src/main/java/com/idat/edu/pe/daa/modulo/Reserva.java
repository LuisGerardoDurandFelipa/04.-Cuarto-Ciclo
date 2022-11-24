package com.idat.edu.pe.daa.modulo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@Table(name = "reserva")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Reserva.findAll", query = "SELECT c FROM Reserva c"),
		@NamedQuery(name = "Reserva.findById_Reserva", query = "SELECT c FROM Reserva c WHERE c.id_Reserva = :id_Reserva"),
		@NamedQuery(name = "Reserva.findByFecha", query = "SELECT c FROM Reserva c WHERE c.fecha = :fecha"),
		@NamedQuery(name = "Reserva.findByHora", query = "SELECT c FROM Reserva c WHERE c.hora = :hora"),
		@NamedQuery(name = "Reserva.findByHorasReservadas", query = "SELECT c FROM Reserva c WHERE c.horasReservadas = :horasReservadas"),
		@NamedQuery(name = "Reserva.findByestado_Reserva", query = "SELECT c FROM Reserva c WHERE c.estado_Reserva = :estado_Reserva")

})

public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_Reserva")
	private Long id_Reserva;

	@Basic(optional = false)
	@Column(name = "fecha")
	private String fecha;

	@Basic(optional = false)
	@Column(name = "hora")
	private String hora;

	@Basic(optional = false)
	@Column(name = "horasReservadas")
	private String horasReservadas;

	@Basic(optional = false)
	@Column(name = "estado_Reserva")
	private String estado_Reserva;
	
    @JoinColumn(name = "cliente", referencedColumnName = "id_Cliente")
    @ManyToOne(optional = false)
    private Cliente cliente;
    
    @JoinColumn(name = "campo", referencedColumnName = "id_Campo")
    @ManyToOne(optional = false)
    
    private Campo campo;

	public Reserva() {
	}
	
	public Campo getCampo() {
		return campo;
	}

	public void setCampo(Campo campo) {
		this.campo = campo;
	}

	public Reserva(Long id_Reserva) {
		this.id_Reserva = id_Reserva;
	}




	public Reserva(Long id_Reserva, String fecha, String hora, String horasReservadas, String estado_Reserva) {
		this.id_Reserva = id_Reserva;
		this.fecha = fecha;
		this.hora = hora;
		this.horasReservadas = horasReservadas;
		this.estado_Reserva = estado_Reserva;
	}

	public Long getId_Reserva() {
		return id_Reserva;
	}

	public void setId_Reserva(Long id_Reserva) {
		this.id_Reserva = id_Reserva;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getHorasReservadas() {
		return horasReservadas;
	}

	public void setHorasReservadas(String horasReservadas) {
		this.horasReservadas = horasReservadas;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getEstado_Reserva() {
		return estado_Reserva;
	}

	public void setEstado_Reserva(String estado_Reserva) {
		this.estado_Reserva = estado_Reserva;
	}
    
    
    
	
	

}
