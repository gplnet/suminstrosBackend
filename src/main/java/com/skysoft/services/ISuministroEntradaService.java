package com.skysoft.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.skysoft.model.SuministroIngreso;

public interface ISuministroEntradaService {

	int registrar(SuministroIngreso sen);
	int modificar(SuministroIngreso sen);
	void eliminar(Integer Sen_Ide);
	SuministroIngreso listarId(int Sen_Ide);
	List<SuministroIngreso>listar();
	Page<SuministroIngreso> listAllByPage(Pageable pageable);
}
