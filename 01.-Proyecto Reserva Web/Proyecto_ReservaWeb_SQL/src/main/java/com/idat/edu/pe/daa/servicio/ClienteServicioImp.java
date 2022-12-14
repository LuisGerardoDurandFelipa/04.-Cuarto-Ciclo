package com.idat.edu.pe.daa.servicio;

import java.util.List;

import javax.transaction.Transactional;

import com.idat.edu.pe.daa.modulo.Cliente;
import com.idat.edu.pe.daa.repositorio.ClienteRepositorio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
@Transactional
public class ClienteServicioImp  {

	
	@Autowired
	private ClienteRepositorio clienteRepositorio;

	public ClienteServicioImp() {

	}

	
	public List<Cliente> buscarTodo() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteRepositorio.findAll();
	}


	public  Cliente crearCliente(Cliente cliente) {
		return clienteRepositorio.save(cliente);
		
	}


	public Cliente actualizar(Cliente clienteActualizar) {
		Cliente clienteActual = clienteRepositorio.findById(clienteActualizar.getId_Cliente()).get();

		clienteActual.setNombre(clienteActualizar.getNombre());
		clienteActual.setApellido(clienteActualizar.getApellido());
		clienteActual.setDni(clienteActualizar.getDni());
		clienteActual.setTelefono(clienteActualizar.getTelefono());
		clienteActual.setCorreo(clienteActualizar.getCorreo());

		Cliente clienteActualizado = clienteRepositorio.save(clienteActual);
		return clienteActualizado;
	}

	
	public Cliente buscarPorId(Long id_Cliente) {
		// TODO Auto-generated method stub
		return clienteRepositorio.findById(id_Cliente).get();
	}


	public void borrarPorId(Long id_Cliente) {
		clienteRepositorio.deleteById(id_Cliente);
		
	}

	public void  actualizar(Long id ,Cliente clienteActualizar) {
		Cliente clienteActual = clienteRepositorio.findById(clienteActualizar.getId_Cliente()).get();

		clienteActual.setNombre(clienteActualizar.getNombre());
		clienteActual.setApellido(clienteActualizar.getApellido());
		clienteActual.setDni(clienteActualizar.getDni());
		clienteActual.setTelefono(clienteActualizar.getTelefono());
		clienteActual.setCorreo(clienteActualizar.getCorreo());
	
        clienteRepositorio.save(clienteActual);
		
	}
	
	
	

	
	
	
}
