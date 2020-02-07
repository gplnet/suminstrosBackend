package com.skysoft.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.skysoft.model.SuministroEgreso;

public interface ISuministroEgresoService {

	int registrar(SuministroEgreso seg);
	int modificar(SuministroEgreso seg);
	void eliminar(Integer Seg_Ide);
	SuministroEgreso listarId(int Seg_Ide);
	List<SuministroEgreso>listar();
	Page<SuministroEgreso> listAllByPage(Pageable pageable);
}
