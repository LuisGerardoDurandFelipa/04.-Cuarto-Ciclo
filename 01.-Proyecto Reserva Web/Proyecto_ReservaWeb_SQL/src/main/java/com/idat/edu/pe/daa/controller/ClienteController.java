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

import com.idat.edu.pe.daa.modulo.Cliente;


import com.idat.edu.pe.daa.servicio.ClienteServicioImp;


@Controller


@RequestMapping("/clientes")
public class ClienteController {
	
	
	@Autowired
    private ClienteServicioImp clienteServicioImp;
	
	
	  @GetMapping(value = {"/home","/"})
	    public String home(Model model) {
	        return "/Bienvenida/bienvenida";
	    }

	

   

    @RequestMapping("/listarTodo")
	public String listarClientes(Model model) {
		List<Cliente> listaClientes = clienteServicioImp.buscarTodo();
		
		System.out.println("LISTA DE CINES : " + listaClientes);
		
		model.addAttribute("listaClientes", listaClientes);
		return "/moduloCliente/listarTodo";
	}

    
 // Metodo Nuevo
	
 	@RequestMapping("/nuevo")
 	public String nuevaCliente(Model model) {
 		Cliente cliente = new Cliente();
 		model.addAttribute("cliente", cliente);
 		return "/moduloCliente/nuevoCliente";
 		
 	}
 	
 	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
 	public String crearCliente(@ModelAttribute("cliente") Cliente cliente) {
 		clienteServicioImp.crearCliente(cliente);
 		    return "redirect:/clientes/listarTodo";
 	}
   
 	 
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarCliente(@PathVariable(name = "id") long id) {
	    ModelAndView mav = new ModelAndView("/moduloCliente/editarCliente");
	    Cliente cliente = clienteServicioImp.buscarPorId(id);
	    mav.addObject("cliente", cliente);
	    return mav;
	}
	

	@RequestMapping(value ="/eliminar/{id}")
	public String eliminarSede(@PathVariable(name = "id") long id) {
		clienteServicioImp.borrarPorId(id);
		 return "redirect:/clientes/listarTodo";
		
	}
    
    
 
    
}
