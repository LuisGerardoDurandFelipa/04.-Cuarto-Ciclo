package com.idat.edu.pe.daa.repositorio;

import org.springframework.data.repository.CrudRepository;


import com.idat.edu.pe.daa.modulo.Cliente;


public interface ClienteRepositorio extends CrudRepository<Cliente, Long> {
	public Cliente findByNombre(String nombre);
}
