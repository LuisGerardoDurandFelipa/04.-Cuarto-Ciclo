package com.idat.edu.pe.daa.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.idat.edu.pe.daa.modulo.Academia;


public interface AcademiaRepositorio extends CrudRepository<Academia, Long>{
	//public Academia findByNombre_tutor(String nombre_tutor);
	public Academia  findByNombre_tutor(String nombre_tutor);
	
}
