package com.idat.edu.pe.daa.servicio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.idat.edu.pe.daa.modulo.Reserva;
import com.idat.edu.pe.daa.repositorio.ReservaRepositorio;

@Service
@Transactional

public class ReservaServicioImp {
	@Autowired
	private ReservaRepositorio reservaRepositorio;
	
	public ReservaServicioImp() {

	}

	
	public List<Reserva> buscarTodo() {
		// TODO Auto-generated method stub
		return (List<Reserva>) reservaRepositorio.findAll();
	}

	public  Reserva crearReserva(Reserva reserva) {
		return reservaRepositorio.save(reserva);
		
	}
	
	public Reserva actualizar(Reserva reservaActualizar) {
		Reserva reservaActual = reservaRepositorio.findById(reservaActualizar.getId_Reserva()).get();

		reservaActual.setFecha(reservaActual.getFecha());
		reservaActual.setHora(reservaActual.getHora());
		reservaActual.setHorasReservadas(reservaActual.getHorasReservadas());
		reservaActual.setEstado_Reserva(reservaActual.getEstado_Reserva());
	
	

		Reserva reservaActualizado = reservaRepositorio.save(reservaActual);
		return reservaActualizado;
	}
	
	public Reserva buscarPorId(Long id_Reserva) {
		// TODO Auto-generated method stub
		return reservaRepositorio.findById(id_Reserva).get();
	}
	

	public void borrarPorId(Long id_Cliente) {
		reservaRepositorio.deleteById(id_Cliente);
		
	}

	
	
}
