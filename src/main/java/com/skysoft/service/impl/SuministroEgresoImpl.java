package com.skysoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.skysoft.dao.ISuministroEgresoDAO;
import com.skysoft.model.SuministroEgreso;
import com.skysoft.services.ISuministroEgresoService;

@Service
public class SuministroEgresoImpl implements ISuministroEgresoService{

	@Autowired
	private ISuministroEgresoDAO dao;
	
	@Override
	public int registrar(SuministroEgreso seg) {
		// TODO Auto-generated method stub
		int rpta = 0;
		rpta = dao.save(seg) != null ? seg.getSeg_ide() : 0;
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public int modificar(SuministroEgreso seg) {
		// TODO Auto-generated method stub
		int rpta = 0;
		rpta = dao.save(seg) != null ? seg.getSeg_ide() : 0;
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public void eliminar(Integer Seg_Ide) {
		// TODO Auto-generated method stub
		dao.deleteById(Seg_Ide);
	}

	@Override
	public SuministroEgreso listarId(int Seg_Ide) {
		// TODO Auto-generated method stub
		return dao.findById(Seg_Ide).get();
	}

	@Override
	public List<SuministroEgreso> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Page<SuministroEgreso> listAllByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return dao.findAll(pageable);
	}

}
