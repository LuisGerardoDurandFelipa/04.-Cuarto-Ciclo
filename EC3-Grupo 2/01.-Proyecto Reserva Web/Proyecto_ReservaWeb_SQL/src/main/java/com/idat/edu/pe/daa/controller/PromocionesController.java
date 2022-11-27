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


import com.idat.edu.pe.daa.modulo.Promociones;

import com.idat.edu.pe.daa.servicio.PromocionesServicioImp;


@Controller


@RequestMapping("/promociones")
public class PromocionesController {
	
	
	@Autowired
    private PromocionesServicioImp promocionesServicioImp;
	
	
	  @GetMapping(value = {"/home","/"})
	    public String home(Model model) {
	        return "/Bienvenida/bienvenida";
	    }

	

   

    @RequestMapping("/listarTodo")
	public String listarPromociones(Model model) {
		List<Promociones> listaPromociones = promocionesServicioImp.buscarTodo();
		
		System.out.println("LISTA DE PROMOCIONES : " + listaPromociones);
		
		model.addAttribute("listaPromociones", listaPromociones);
		return "/moduloPromociones/listarTodo";
	}

    
 // Metodo Nuevo
	
 	@RequestMapping("/nuevo")
 	public String nuevaPromociones(Model model) {
 		Promociones promociones = new Promociones();
 		model.addAttribute("promociones", promociones);
 		return "/moduloPromociones/nuevoPromociones";
 		
 	}
 	
 	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
 	public String crearPromociones(@ModelAttribute("promociones") Promociones promociones) {
 		promocionesServicioImp.crearPromociones(promociones);
 		    return "redirect:/promociones/listarTodo";
 	}
   
 	 
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarPromociones(@PathVariable(name = "id") long id) {
	    ModelAndView mav = new ModelAndView("/moduloPromociones/editarPromociones");
	    Promociones promociones = promocionesServicioImp.buscarPorId(id);
	    mav.addObject("promociones", promociones);
	    return mav;
	}
	

	@RequestMapping(value ="/eliminar/{id}")
	public String eliminarPromociones(@PathVariable(name = "id") long id) {
		promocionesServicioImp.borrarPorId(id);
		 return "redirect:/promociones/listarTodo";
		
	}

}