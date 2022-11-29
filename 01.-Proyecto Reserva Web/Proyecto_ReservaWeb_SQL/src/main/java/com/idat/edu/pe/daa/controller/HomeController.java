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
	  
	

	  
	  @RequestMapping("/nuevo1{campo}")
	 	public String nuevaReserva1(Model model,Reserva reserva) {
			
	 		model.addAttribute("reserva", reserva);
	 		System.out.println("--------------------");
	 		System.out.println(reserva.getCampo());
	 		System.out.println("--------------------");
	 		return "/modulosCamposReservas/campo1";
	 		
	 	}
	  
	  
	  
	  @RequestMapping("/nuevo2{campo}")
	 	public String nuevaReserva2(Model model,Reserva reserva) {
			
	 		model.addAttribute("reserva", reserva);
	 		System.out.println("--------------------");
	 		System.out.println(reserva.getCampo());
	 		System.out.println("--------------------");
	 		return "/modulosCamposReservas/campo2";
	 		
	 	}
	  
	  @RequestMapping("/nuevo3{campo}")
	 	public String nuevaReserva3(Model model,Reserva reserva) {
			
	 		model.addAttribute("reserva", reserva);
	 		System.out.println("--------------------");
	 		System.out.println(reserva.getCampo());
	 		System.out.println("--------------------");
	 		return "/modulosCamposReservas/campo3";
	 		
	 	}
	  
	  @RequestMapping("/nuevo4{campo}")
	 	public String nuevaReserva4(Model model,Reserva reserva) {
			
	 		model.addAttribute("reserva", reserva);
	 		System.out.println("--------------------");
	 		System.out.println(reserva.getCampo());
	 		System.out.println("--------------------");
	 		return "/modulosCamposReservas/campo4";
	 		
	 	}
	  
	  
	  
	  @RequestMapping("/nuevo5{campo}")
	 	public String nuevaReserva5(Model model,Reserva reserva) {
			
	 		model.addAttribute("reserva", reserva);
	 		System.out.println("--------------------");
	 		System.out.println(reserva.getCampo());
	 		System.out.println("--------------------");
	 		return "/modulosCamposReservas/campo5";
	 		
	 	}
	  
	  @RequestMapping("/nuevo6{campo}")
	 	public String nuevaReserva6(Model model,Reserva reserva) {
			
	 		model.addAttribute("reserva", reserva);
	 		System.out.println("--------------------");
	 		System.out.println(reserva.getCampo());
	 		System.out.println("--------------------");
	 		return "/modulosCamposReservas/campo6";
	 		
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
