package com.idat.edu.pe.daa.repositorio;

import org.springframework.data.repository.CrudRepository;


import com.idat.edu.pe.daa.modulo.Reserva;

public interface ReservaRepositorio extends CrudRepository<Reserva, Long>{
	public Reserva findByFecha(String fecha);
}
