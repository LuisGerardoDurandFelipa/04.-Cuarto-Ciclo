package com.idat.edu.pe.daa.servicio;

import java.util.List;
import javax.transaction.Transactional;

import com.idat.edu.pe.daa.modulo.Promociones;

import com.idat.edu.pe.daa.repositorio.PromocionesRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional	
public class PromocionesServicioImp {

	
	@Autowired
	private PromocionesRepositorio promocionesRepositorio;

	public PromocionesServicioImp() {

	}

	
	public List<Promociones> buscarTodo() {
		// TODO Auto-generated method stub
		return (List<Promociones>) promocionesRepositorio.findAll();
	}


	public  Promociones crearPromociones(Promociones promociones) {
		return promocionesRepositorio.save(promociones);
		
	}


	public Promociones actualizar(Promociones promocionesActualizar) {
		Promociones promocionesActual = promocionesRepositorio.findById(promocionesActualizar.getId_Promocion()).get();

		promocionesActual.setNombre_promocion(promocionesActualizar.getNombre_promocion());
		promocionesActual.setDescripcion_promocion(promocionesActualizar.getDescripcion_promocion());
		promocionesActual.setFecha_promo_inicio(promocionesActualizar.getFecha_promo_inicio());
		promocionesActual.setFecha_promo_final(promocionesActualizar.getFecha_promo_final());

	

		Promociones promocionesActualizado = promocionesRepositorio.save(promocionesActual);
		return promocionesActualizado;
	}

	
	public Promociones buscarPorId(Long id_Promociones) {
		// TODO Auto-generated method stub
		return promocionesRepositorio.findById(id_Promociones).get();
	}


	public void borrarPorId(Long id_Promociones) {
		promocionesRepositorio.deleteById(id_Promociones);
		
	}
	
	public void actualizar(Long id ,Promociones promocionesActualizar) {
		Promociones promocionesActual = promocionesRepositorio.findById(promocionesActualizar.getId_Promocion()).get();

		promocionesActual.setNombre_promocion(promocionesActualizar.getNombre_promocion());
		promocionesActual.setDescripcion_promocion(promocionesActualizar.getDescripcion_promocion());
		promocionesActual.setFecha_promo_inicio(promocionesActualizar.getFecha_promo_inicio());
		promocionesActual.setFecha_promo_final(promocionesActualizar.getFecha_promo_final());

		 promocionesRepositorio.save(promocionesActual);
		
	}

	
	
}