package com.skysoft.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.skysoft.model.Eliminado;



public interface IEliminadoService {
	int registrar(Eliminado eliminado);
	int modificar(Eliminado eliminado);
	void eliminar(Integer eli_ide);
	Eliminado listarId(int eli_ide);
	List<Eliminado>listar();
	Page<Eliminado> listAllByPage(Pageable pageable);

}
