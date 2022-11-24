package com.idat.edu.pe.daa.servicio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.edu.pe.daa.modulo.Campo;

import com.idat.edu.pe.daa.repositorio.CampoRepositorio;


@Service
@Transactional
public class CampoServicioImp {
	
	@Autowired
	private CampoRepositorio campoRepositorio;

	public CampoServicioImp() {

	}

	public List<Campo> buscarTodo() {
		// TODO Auto-generated method stub
		return (List<Campo>) campoRepositorio.findAll();
	}

	public  Campo crearCampo(Campo campo) {
		return campoRepositorio.save(campo);
		
	}
	

	public Campo actualizar(Campo campoActualizar) {
		Campo campoActual = campoRepositorio.findById(campoActualizar.getId_Campo()).get();

		campoActual.setCodigoCampo(campoActual.getCodigoCampo());
		campoActual.setNombreCampo(campoActual.getNombreCampo());
		campoActual.setEstado(campoActual.getEstado());
		campoActual.setTipoCampo(campoActual.getTipoCampo());
	
	

		Campo campoActualizado = campoRepositorio.save(campoActual);
		return campoActualizado;
	}
	

	
	public Campo buscarPorId(Long id_Campo) {
		// TODO Auto-generated method stub
		return campoRepositorio.findById(id_Campo).get();
	}


	public void borrarPorId(Long id_Campo) {
		campoRepositorio.deleteById(id_Campo);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
