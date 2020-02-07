package com.skysoft.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.skysoft.model.Departamento;

public interface IDepartamentoService{

	int registrar(Departamento depart);
	int modificar(Departamento depart);
	void eliminar(Integer Dpt_Ide);
	Departamento listarId(int Dpt_Ide);
	List<Departamento>listar();
	Page<Departamento> listAllByPage(Pageable pageable);
}
