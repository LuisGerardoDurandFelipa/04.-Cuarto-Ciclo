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

import com.idat.edu.pe.daa.modulo.Reserva;
import com.idat.edu.pe.daa.servicio.ReservaServicioImp;

@RestController
@RequestMapping("/rest/reservas")

public class ReservaRestController {

	@Autowired
	private ReservaServicioImp reservaServicioImp;
	
	@GetMapping
	public  ResponseEntity<Object> buscarTodo(){
		List<Reserva> listaReserva =  reservaServicioImp.buscarTodo();
		
		System.out.println("LISTA DE RESERVA : " + listaReserva);
		
		return new ResponseEntity<>(listaReserva, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") Long id){
		
		Reserva reserva = reservaServicioImp.buscarPorId(id);
		if(reserva == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Reserva no encontrada, id  Reserva no es correcto");
			 return new ResponseEntity<Object>(reserva, HttpStatus.OK);

	}
	
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> crear (@RequestBody Reserva reserva){
		reservaServicioImp.crearReserva(reserva);
		   return new ResponseEntity<Object>("Reserva creada correctamente", HttpStatus.OK);
		
	}
	
	@PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> actualizar(@PathVariable("id") Long id, @RequestBody Reserva reserva){
		reservaServicioImp.actualizar(reserva);
		return new ResponseEntity<Object>("Reserva actualizada correctamente", HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Long id){
		reservaServicioImp.borrarPorId(id);
		return new ResponseEntity<Object>("Reserva eliminada correctamente", HttpStatus.OK);
		
	}
	
}
