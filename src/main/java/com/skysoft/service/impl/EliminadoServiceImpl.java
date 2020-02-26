package com.skysoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.skysoft.dao.IEliminadoDAO;
import com.skysoft.model.Eliminado;
import com.skysoft.services.IEliminadoService;

@Service
public class EliminadoServiceImpl implements IEliminadoService {
	
	@Autowired
	private IEliminadoDAO dao;

	@Override
	public int registrar(Eliminado eliminado) {
		// TODO Auto-generated method stub
		int rpta = 0;
		rpta = dao.save(eliminado) != null ? eliminado.getEli_ide() : 0;
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public int modificar(Eliminado eliminado) {
		// TODO Auto-generated method stub
		int rpta= 0;
		rpta = dao.save(eliminado) != null ? eliminado.getEli_ide() : 0;
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public void eliminar(Integer eli_ide) {
		// TODO Auto-generated method stub
		dao.deleteById(eli_ide);
	}

	@Override
	public Eliminado listarId(int eli_ide) {
		// TODO Auto-generated method stub
		return dao.findById(eli_ide).get();
	}

	@Override
	public List<Eliminado> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Page<Eliminado> listAllByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return dao.findAll(pageable);
	}

}
