package com.idat.edu.pe.daa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.idat.edu.pe.daa.modulo.Reserva;

import com.idat.edu.pe.daa.servicio.ReservaServicioImp;

@Controller


@RequestMapping("/reservas")

public class ReservaController {

	
	@Autowired
	private ReservaServicioImp reservaServicioImp;
	

	  @GetMapping(value = {"/home","/"})
	    public String home(Model model) {
	        return "/Bienvenida/bienvenida";
	    }
	
	   @RequestMapping("/listarTodo")
		public String listarClientes(Model model) {
			List<Reserva> listaReservas = reservaServicioImp.buscarTodo();
			
			System.out.println("LISTA DE CINES : " + listaReservas);
			
			model.addAttribute("listaReservas", listaReservas);
			return "/moduloReserva/listarTodo";
		}
	   
		@RequestMapping("/nuevo")
	 	public String nuevaReserva(Model model) {
			Reserva reserva = new Reserva();
	 		model.addAttribute("reserva", reserva);
	 		return "/moduloReserva/nuevoReserva";
	 		
	 	}
	 	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	 	public String crearReserva(@ModelAttribute("reserva") Reserva reserva) {
	 		reservaServicioImp.crearReserva(reserva);
	 		    return "redirect:/reservas/listarTodo";
	 	}
	 	@RequestMapping(value = "/actualizar/{id}")
		public ModelAndView editarReserva(@PathVariable(name = "id") long id) {
		    ModelAndView mav = new ModelAndView("/moduloReserva/editarReserva");
		    Reserva reserva = reservaServicioImp.buscarPorId(id);
		    mav.addObject("reserva", reserva);
		    return mav;
		}
	 	

		@RequestMapping(value ="/eliminar/{id}")
		public String eliminarSede(@PathVariable(name = "id") long id) {
			reservaServicioImp.borrarPorId(id);
			 return "redirect:/reservas/listarTodo";
			
		}
	 	
	
}
