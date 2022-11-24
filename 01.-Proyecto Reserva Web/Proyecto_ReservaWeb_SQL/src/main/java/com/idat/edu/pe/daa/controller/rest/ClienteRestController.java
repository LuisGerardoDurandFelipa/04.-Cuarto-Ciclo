package com.idat.edu.pe.daa.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.idat.edu.pe.daa.modulo.Cliente;
import com.idat.edu.pe.daa.servicio.ClienteServicioImp;




@RestController
@RequestMapping("/rest/clientes")
public class ClienteRestController {

	
	@Autowired
	private ClienteServicioImp clienteServicioImp;
	
	@GetMapping 
	public  ResponseEntity<Object> buscarTodo(){
		List<Cliente> listaClientes =  clienteServicioImp.buscarTodo();
		
		System.out.println("LISTA DE CLIENTES : " + listaClientes);
		
		return new ResponseEntity<>(listaClientes, HttpStatus.OK);
		
	}
	
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") long id){
		
		Cliente client = clienteServicioImp.buscarPorId(id);
		if(client == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"CLiente no encontrada, id  proporcionado no es correcto");
			 return new ResponseEntity<Object>(client, HttpStatus.OK);

	}
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> crear (@RequestBody Cliente cliente){
		clienteServicioImp.crearCliente(cliente);
		   return new ResponseEntity<Object>("Cliente creado correctamente", HttpStatus.OK);
		
	}
	
	

	@PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> actualizar(@PathVariable("id") long id, @RequestBody Cliente cliente){
		clienteServicioImp.actualizar(cliente);
		return new ResponseEntity<Object>("Cliente actualizado correctamente", HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") long id){
		clienteServicioImp.borrarPorId(id);
		return new ResponseEntity<Object>("Cliente eliminada correctamente", HttpStatus.OK);
		
	}
	
	
	
}
