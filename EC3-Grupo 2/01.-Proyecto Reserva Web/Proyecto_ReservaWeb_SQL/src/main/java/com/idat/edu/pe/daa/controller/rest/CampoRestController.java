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


import com.idat.edu.pe.daa.modulo.Campo;
import com.idat.edu.pe.daa.servicio.CampoServicioImp;

@RestController
@RequestMapping("/rest/campos")
public class CampoRestController {
	
	@Autowired
	private CampoServicioImp campoServicioImp;
	
	
	@GetMapping
	public  ResponseEntity<Object> buscarTodo(){
		List<Campo> listaCampo =  campoServicioImp.buscarTodo();
		
		System.out.println("LISTA DE CAMPO : " + listaCampo);
		
		return new ResponseEntity<>(listaCampo, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") Long id){
		
		Campo campo = campoServicioImp.buscarPorId(id);
		if(campo == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Campo no encontrodo, id  proporcionado no es correcto");
			 return new ResponseEntity<Object>(campo, HttpStatus.OK);

	}
	
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> crear (@RequestBody Campo campo){
		campoServicioImp.crearCampo(campo);
		   return new ResponseEntity<Object>("Campo creado correctamente", HttpStatus.OK);
		
	}
	
	@PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> actualizar(@PathVariable("id") Long id, @RequestBody Campo campo){
		campoServicioImp.actualizar(campo);
		return new ResponseEntity<Object>("Campo actualizado correctamente", HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Long id){
		campoServicioImp.borrarPorId(id);
		return new ResponseEntity<Object>("Campo eliminado correctamente", HttpStatus.OK);
		
	}
	
	
	
	

}
