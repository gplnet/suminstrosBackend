package com.skysoft.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.skysoft.model.Suministro;


public interface ISuministroService {

	int registrar(Suministro suministro);
	int modificar(Suministro suministro);
	void eliminar(Integer Sum_Ide);
	Suministro listarId(int Sum_Ide);
	List<Suministro>listar();
	Page<Suministro> listAllByPage(Pageable pageable);
	Page<Suministro> listAllistAllByPageDoslByPage(Pageable pageable);
	Suministro buscarById(Integer idSumEgreso, Integer idSuministro) throws Exception;
	byte[] generarReporteAllSuministros(String nombre) throws Exception ;
}
