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

import com.idat.edu.pe.daa.modulo.Academia;

import com.idat.edu.pe.daa.servicio.AcademiaServicioImp;


@Controller
@RequestMapping("/academias")

public class AcademiaController {
	
	@Autowired
    private AcademiaServicioImp academiaServicioImp;
	
	
	 @GetMapping(value = {"/home","/"})
	    public String home(Model model) {
	        return "/Bienvenida/bienvenida";
	    }
	
	 @GetMapping("/academiaCliente")
	    public String academiaCliente(Model model) {
		 Academia academia = new Academia();
	 		model.addAttribute("academia", academia);
	 		return "/moduloAcademia/registroAcademia";
	    }
	 
	 @RequestMapping(value = "/guardarinscrip" , method = RequestMethod.POST)
	 	public String guardaInscripcion(@ModelAttribute("academia") Academia academia) {
		 academiaServicioImp.crearAcademia(academia);
	 		    return "redirect:/academias/academiaCliente";
	 	}
	 
	 
	 @RequestMapping("/listarTodo")
		public String listarAcademias(Model model) {
			List<Academia> listaAcademias = academiaServicioImp.buscarTodo();
			
			System.out.println("LISTA DE ACADEMIAS : " + listaAcademias);
			
			model.addAttribute("listaAcademias", listaAcademias);
			return "/moduloAcademia/listarTodo";
		}

	 @RequestMapping("/nuevo")
	 	public String nuevaAcademia(Model model) {
		 Academia academia = new Academia();
	 		model.addAttribute("academia", academia);
	 		return "/moduloAcademia/nuevoAcademia";
	 		
	 	}
	 
	 @RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	 	public String crearAcademia(@ModelAttribute("academia") Academia academia) {
		 academiaServicioImp.crearAcademia(academia);
	 		    return "redirect:/academias/listarTodo";
	 	}
	 
		@RequestMapping(value = "/actualizar/{id}")
		public ModelAndView editarAcademia(@PathVariable(name = "id") long id) {
		    ModelAndView mav = new ModelAndView("/moduloAcademia/editarAcademia");
		    Academia academia = academiaServicioImp.buscarPorId(id);
		    mav.addObject("academia", academia);
		    return mav;
		}
		
		@RequestMapping(value ="/eliminar/{id}")
		public String eliminarAcademia(@PathVariable(name = "id") long id) {
			academiaServicioImp.borrarPorId(id);
			 return "redirect:/academias/listarTodo";
			
		}
	 
	 
}
