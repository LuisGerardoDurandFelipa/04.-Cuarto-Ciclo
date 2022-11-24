package com.idat.edu.pe.daa.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.idat.edu.pe.daa.modulo.Campo;


public interface CampoRepositorio  extends CrudRepository<Campo, Long>{
	public Campo findByNombreCampo(String nombreCampo);
}
