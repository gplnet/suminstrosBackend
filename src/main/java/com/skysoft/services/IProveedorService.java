package com.skysoft.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.skysoft.model.Proveedor;

public interface IProveedorService {

	int registrar(Proveedor proveedor);
	int modificar(Proveedor proveedor);
	void eliminar(Integer Prv_Ide);
	Proveedor listarId(int Prv_Ide);
	List<Proveedor>listar();
	Page<Proveedor> listAllByPage(Pageable pageable);
}
