package com.skysoft.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.skysoft.model.Proceso;

public interface IProcesoService {

	int registrar(Proceso proceso);
	int modificar(Proceso proceso);
	void eliminar(Integer Pcs_Ide);
	Proceso listarId(int Pcs_Ide);
	List<Proceso>listar();
	Page<Proceso> listAllByPage(Pageable pageable);
	Proceso searchByCod(String codigo);
}
