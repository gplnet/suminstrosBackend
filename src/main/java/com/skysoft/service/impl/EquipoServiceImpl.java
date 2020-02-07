package com.skysoft.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.skysoft.dao.IEquipoDAO;
import com.skysoft.model.Equipo;
import com.skysoft.services.IEquipoService;

@Service
public class EquipoServiceImpl implements IEquipoService{
	
	@Autowired
	private IEquipoDAO dao;
	

	@Override
	public int registrar(Equipo equipo) {
		// TODO Auto-generated method stub
		int rpta = 0;
		rpta = dao.save(equipo) != null ? equipo.getEqp_Ide() : 0;
		return rpta > 0 ? 1 : 0;
		
	}

	@Override
	public int modificar(Equipo equipo) {
		// TODO Auto-generated method stub
		int rpta = 0;
		rpta = dao.save(equipo) != null ? equipo.getEqp_Ide() : 0;
		return rpta > 0 ? 1 : 0;
		
	}

	
	@Override
	public List<Equipo> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void eliminar(Integer Eqp_Ide) {
		// TODO Auto-generated method stub
		dao.deleteById(Eqp_Ide);
	}

	
	@Override
	public Equipo listarId(int Eqp_Ide) {
		// TODO Auto-generated method stub
		return dao.findById(Eqp_Ide).get();
	}

	@Override
	public Page<Equipo> listAllByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return dao.findAll(pageable);
	}

}
