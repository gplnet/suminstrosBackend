package com.skysoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.skysoft.dao.ISuministroEntradaDAO;
import com.skysoft.model.SuministroIngreso;
import com.skysoft.services.ISuministroEntradaService;

@Service
public class SuministroEntradaImpl implements ISuministroEntradaService {

	@Autowired
	private ISuministroEntradaDAO dao;
	
	@Override
	public int registrar(SuministroIngreso sen) {
		// TODO Auto-generated method stub
		int rpta = 0;
		rpta = dao.save(sen) != null ? sen.getSen_ide() : 0;
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public int modificar(SuministroIngreso sen) {
		// TODO Auto-generated method stub
		int rpta = 0;
		rpta = dao.save(sen) != null ? sen.getSen_ide() : 0;
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public void eliminar(Integer Sen_Ide) {
		// TODO Auto-generated method stub
		dao.deleteById(Sen_Ide);
	}

	@Override
	public SuministroIngreso listarId(int Sen_Ide) {
		// TODO Auto-generated method stub
		return dao.findById(Sen_Ide).get();
	}

	@Override
	public List<SuministroIngreso> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Page<SuministroIngreso> listAllByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return dao.findAll(pageable);
	}

}
