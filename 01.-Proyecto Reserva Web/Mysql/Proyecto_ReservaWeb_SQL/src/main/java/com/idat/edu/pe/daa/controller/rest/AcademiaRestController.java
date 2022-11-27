package com.idat.edu.pe.daa.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.idat.edu.pe.daa.modulo.Academia;
import com.idat.edu.pe.daa.servicio.AcademiaServicioImp;

import org.springframework.http.MediaType;

@RestController
@RequestMapping("/rest/academias")
public class AcademiaRestController {

	@Autowired
	private AcademiaServicioImp servicio;
	
	@GetMapping
	public  ResponseEntity<Object> buscarTodo(){
		List<Academia> listaAcademia =  servicio.buscarTodo();
		
		System.out.println("LISTA DE ACADEMIA : " + listaAcademia);
		
		return new ResponseEntity<>(listaAcademia, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") Long id){
		
		Academia academia = servicio.buscarPorId(id);
		if(academia == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Academia no encontrada, id  proporcionado no es correcto");
			 return new ResponseEntity<Object>(academia, HttpStatus.OK);

	}
	
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> crear (@RequestBody Academia academia){
		   servicio.crearAcademia(academia);
		   return new ResponseEntity<Object>("Academia creada correctamente", HttpStatus.OK);
		
	}
	
	@PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> actualizar(@PathVariable("id") Long id, @RequestBody Academia academia){
		servicio.actualizar(academia);
		return new ResponseEntity<Object>("Academia actualizada correctamente", HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Long id){
		servicio.borrarPorId(id);
		return new ResponseEntity<Object>("Academia eliminada correctamente", HttpStatus.OK);
		
	}
	
	
}
