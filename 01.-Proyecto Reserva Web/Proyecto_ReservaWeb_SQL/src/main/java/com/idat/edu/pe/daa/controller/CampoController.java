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

import com.idat.edu.pe.daa.modulo.Campo;
import com.idat.edu.pe.daa.modulo.Cliente;
import com.idat.edu.pe.daa.servicio.CampoServicioImp;
import com.idat.edu.pe.daa.servicio.ClienteServicioImp;

@Controller


@RequestMapping("/campos")

public class CampoController {
	
	@Autowired
	 private CampoServicioImp campoServicioImp;
	
	

	  @GetMapping(value = {"/home","/"})
	    public String home(Model model) {
	        return "/Bienvenida/bienvenida";
	    }

	
	  @RequestMapping("/listarTodo")
		public String listarCampos(Model model) {
			List<Campo> listaCampos = campoServicioImp.buscarTodo();
			
			System.out.println("LISTA DE CAMPOS : " + listaCampos);
			
			model.addAttribute("listaCampos", listaCampos);
			return "/moduloCampo/listarTodo";
		}
	  
	  
		@RequestMapping("/nuevo")
	 	public String nuevaCampos(Model model) {
			Campo campo = new Campo();
	 		model.addAttribute("campo", campo);
	 		return "/moduloCampo/nuevoCampo";
	 		
	 	}
	  
	  
		@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	 	public String crearCampo(@ModelAttribute("campo") Campo campo) {
			campoServicioImp.crearCampo(campo);
	 		    return "redirect:/campos/listarTodo";
	 	}
	   
		
		 
		@RequestMapping(value = "/actualizar/{id}")
		public ModelAndView editarCampo(@PathVariable(name = "id") long id) {
		    ModelAndView mav = new ModelAndView("/moduloCampo/editarCampo");
		    Campo campo = campoServicioImp.buscarPorId(id);
		    mav.addObject("campo", campo);
		    return mav;
		}
	  
		@RequestMapping(value ="/eliminar/{id}")
		public String eliminarSede(@PathVariable(name = "id") long id) {
			campoServicioImp.borrarPorId(id);
			 return "redirect:/campos/listarTodo";
			
		}
	    
	  
	  
	  
	
	
	
	
}
