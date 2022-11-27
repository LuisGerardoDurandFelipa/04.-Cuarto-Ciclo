package com.idat.edu.pe.daa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.idat.edu.pe.daa.modulo.Reserva;
import com.idat.edu.pe.daa.servicio.ReservaServicioImp;

@Controller


@RequestMapping("/home")

public class HomeController {
	@Autowired
	private ReservaServicioImp reservaServicioImp;
	
	
	  @GetMapping(value = {"/home","/"})
	    public String home(Model model) {
	        return "/Bienvenida/bienvenida";
	    }
	  
	  @GetMapping("/campo2")
	    public String campos2(Model model) {
	        return "/modulosCamposReservas/campo2";
	    }

	  
	  
	  @RequestMapping("/nuevo{campo}")
	 	public String nuevaReserva(Model model,Reserva reserva) {
			
	 		model.addAttribute("reserva", reserva);
	 		System.out.println("--------------------");
	 		System.out.println(reserva.getCampo());
	 		System.out.println("--------------------");
	 		return "/modulosCamposReservas/campo2";
	 		
	 	}
	  
	  
	 	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	 	public String crearReserva(@ModelAttribute("reserva") Reserva reserva) {
	 		System.out.println("--------------------");
	 		System.out.println(reserva.getCampo());
	 		System.out.println("--------------------");
	 		reservaServicioImp.crearReserva(reserva);
	 		    return "redirect:/reservas/listarTodo";
	 		    
	 	}

}
