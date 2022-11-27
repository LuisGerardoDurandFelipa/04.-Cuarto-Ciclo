package com.idat.edu.pe.daa.servicio;

import java.util.List;

import com.idat.edu.pe.daa.modulo.Cliente;

public interface ClienteServicio {
	
	public List<Cliente> buscarTodo();
	public Cliente crearCliente (Cliente cliente);
	public Cliente actualizar(Cliente cliente);
	public Cliente buscarPorId(Long id_Cliente);
	public void borrarPorId (Long id_Cliente);

	

	

}
