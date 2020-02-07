package com.skysoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.skysoft.dao.IDepartamentoDAO;
import com.skysoft.model.Departamento;
import com.skysoft.services.IDepartamentoService;

@Service
public class DepartamentoServiceImpl implements IDepartamentoService{
	
	@Autowired
	private IDepartamentoDAO dao;

	@Override
	public int registrar(Departamento depart) {
		// TODO Auto-generated method stub	
		int rpta = 0;
		rpta = dao.save(depart) != null ? depart.getDpr_Ide() : 0;
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public int modificar(Departamento depart) {
		// TODO Auto-generated method stub
		int rpta = 0;
		rpta = dao.save(depart) != null ? depart.getDpr_Ide() : 0;
		return rpta > 0 ? 1 : 0;
		
	}

	@Override
	public void eliminar(Integer Dpt_Ide) {
		// TODO Auto-generated method stub
		dao.deleteById(Dpt_Ide);
		
	}

	@Override
	public Departamento listarId(int Dpt_Ide) {
		// TODO Auto-generated method stub
		return dao.findById(Dpt_Ide).get();
	}

	@Override
	public List<Departamento> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Page<Departamento> listAllByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return dao.findAll(pageable);
	}

}
