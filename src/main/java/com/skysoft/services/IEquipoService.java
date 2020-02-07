package com.skysoft.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.skysoft.model.Equipo;

public interface IEquipoService {
	
	int registrar(Equipo equipo);
	int modificar(Equipo equipo);
	void eliminar(Integer Eqp_Ide);
	Equipo listarId(int Eqp_Ide);
	List<Equipo>listar();
	Page<Equipo> listAllByPage(Pageable pageable);
	

}
