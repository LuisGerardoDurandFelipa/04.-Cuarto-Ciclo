package com.idat.edu.pe.daa.repositorio;

import org.springframework.data.repository.CrudRepository;


import com.idat.edu.pe.daa.modulo.Promociones;

public interface PromocionesRepositorio extends CrudRepository<Promociones, Long>{

	public Promociones findByNombre_promocion(String nombre_promocion);
	
}
