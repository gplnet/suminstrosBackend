package com.skysoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.skysoft.dao.IProveedorDAO;
import com.skysoft.model.Proveedor;
import com.skysoft.services.IProveedorService;

@Service
public class ProveedorServiceImpl implements IProveedorService {
	@Autowired
	private IProveedorDAO dao;
	
	@Override
	public int registrar(Proveedor proveedor) {
		// TODO Auto-generated method stub
		int rpta=0;
		rpta= dao.save(proveedor) != null ? proveedor.getPrv_ide() :0;
		return rpta > 0 ? 1 :0 ;
	}

	@Override
	public int modificar(Proveedor proveedor) {
		// TODO Auto-generated method stub
		int rpta=0;
		rpta= dao.save(proveedor) != null ? proveedor.getPrv_ide() :0;
		return rpta > 0 ? 1 :0 ;
	}

	@Override
	public void eliminar(Integer Prv_Ide) {
		// TODO Auto-generated method stub
		dao.deleteById(Prv_Ide);
	}

	@Override
	public Proveedor listarId(int Prv_Ide) {
		// TODO Auto-generated method stub
		return dao.findById(Prv_Ide).get();
	}

	@Override
	public List<Proveedor> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Page<Proveedor> listAllByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return dao.findAll(pageable);
	}
	
	

}
