package com.idat.edu.pe.daa.servicio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.edu.pe.daa.modulo.Academia;

import com.idat.edu.pe.daa.repositorio.AcademiaRepositorio;


@Service
@Transactional

public class AcademiaServicioImp {

	@Autowired
	private AcademiaRepositorio academiaRepositorio;
	
	public AcademiaServicioImp() {

	}

	public List<Academia> buscarTodo() {
		// TODO Auto-generated method stub
		return (List<Academia>) academiaRepositorio.findAll();
	}
	
	
	public  Academia crearAcademia(Academia academia) {
		return academiaRepositorio.save(academia);
		
	}
	
	
	public Academia actualizar(Academia academiaActualizar) {
		Academia academiaActual = academiaRepositorio.findById(academiaActualizar.getId_Registro()).get();

		academiaActual.setNombre_tutor(academiaActualizar.getNombre_tutor());
		academiaActual.setApellido_tutor(academiaActualizar.getApellido_tutor());
		academiaActual.setDni_tutor(academiaActualizar.getDni_tutor());
		academiaActual.setTelefono_tutor(academiaActualizar.getTelefono_tutor());
		academiaActual.setEmail_tutor(academiaActualizar.getEmail_tutor());
		academiaActual.setFechanac_estudiante(academiaActualizar.getFechanac_estudiante());
		academiaActual.setNombre_estudiante(academiaActualizar.getNombre_estudiante());
		academiaActual.setApellido_estudiante(academiaActualizar.getApellido_estudiante());
		academiaActual.setDni_estudiante(academiaActualizar.getDni_estudiante());
		academiaActual.setDeporte(academiaActualizar.getDeporte());
		
		Academia acedemiaActualizado = academiaRepositorio.save(academiaActual);
		return acedemiaActualizado;
	}
	
	
	public Academia buscarPorId(Long id_Registro) {
		// TODO Auto-generated method stub
		return academiaRepositorio.findById(id_Registro).get();
	}
	
	
	public void borrarPorId(Long id_Registro) {
		academiaRepositorio.deleteById(id_Registro);
		
	}

	
	
	
}
