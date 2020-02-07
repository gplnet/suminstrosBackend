package com.skysoft.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.skysoft.model.Ingreso;

public interface IIngresoService {

	Ingreso registrar(Ingreso ingreso);
	int modificar(Ingreso ingreso);
	void eliminar(Integer Ing_Ide);
	Ingreso listarId(int Ing_Ide);
	List<Ingreso>listar();
	Page<Ingreso> listAllByPage(Pageable pageable);
	byte[] generarReporte(int id) throws Exception ;
	
	public List<Object> listarPorSuministro(String term)  throws Exception ;
	public List<Object> listarPorProceso(String term)  throws Exception ;
	public List<Object> listarPorFechaIngreso(String desde, String hasta)  throws Exception ;
}
