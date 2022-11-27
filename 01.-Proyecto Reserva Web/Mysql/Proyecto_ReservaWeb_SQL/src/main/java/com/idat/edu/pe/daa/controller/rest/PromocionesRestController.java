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

import com.idat.edu.pe.daa.modulo.Promociones;
import com.idat.edu.pe.daa.servicio.PromocionesServicioImp;

import org.springframework.http.MediaType;

@RestController
@RequestMapping("/rest/promociones")
public class PromocionesRestController {

	@Autowired
	private PromocionesServicioImp servicio;
	
	@GetMapping
	public  ResponseEntity<Object> buscarTodo(){
		List<Promociones> listaPromociones =  servicio.buscarTodo();
		
		System.out.println("LISTA DE PROMOCIONES : " + listaPromociones);
		
		return new ResponseEntity<>(listaPromociones, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") Long id){
		
		Promociones promociones = servicio.buscarPorId(id);
		if(promociones == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Promocion no encontrada, id  proporcionado no es correcto");
			 return new ResponseEntity<Object>(promociones, HttpStatus.OK);

	}
	
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> crear (@RequestBody Promociones promociones){
		   servicio.crearPromociones(promociones);
		   return new ResponseEntity<Object>("Promocion creada correctamente", HttpStatus.OK);
		
	}
	
	@PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> actualizar(@PathVariable("id") Long id, @RequestBody Promociones promociones){
		servicio.actualizar(promociones);
		return new ResponseEntity<Object>("Promociones actualizada correctamente", HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Long id){
		servicio.borrarPorId(id);
		return new ResponseEntity<Object>("Promocion eliminada correctamente", HttpStatus.OK);
		
	}
	
	
}
