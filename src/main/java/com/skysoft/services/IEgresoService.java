package com.skysoft.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.skysoft.model.Egreso;


public interface IEgresoService {

	Egreso registrar(Egreso egreso);
	int modificar(Egreso egreso);
	void eliminar(Integer Egr_Ide);
	Egreso listarId(int Egr_Ide);
	List<Egreso>listar();
	Page<Egreso> listAllByPage(Pageable pageable);
	byte[] generarReporte(int id, String idUsuario) throws Exception ;
	
	public List<Object> listarPorDepartamento(String term)  throws Exception ;
	public List<Object> listarPorSuministro(String term)  throws Exception ;
	public List<Object> listarPorFechaEgreso(String desde, String hasta)  throws Exception ;
}
