package com.skysoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.skysoft.dao.IProcesoDAO;
import com.skysoft.model.Proceso;
import com.skysoft.services.IProcesoService;

@Service
public class ProcesoServiceImpl implements IProcesoService {

	@Autowired
	private IProcesoDAO dao;
	
	@Override
	public int registrar(Proceso proceso) {
		// TODO Auto-generated method stub
		int rpta = 0;
		rpta = dao.save(proceso) != null ? proceso.getPcs_ide() : 0;
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public int modificar(Proceso proceso) {
		// TODO Auto-generated method stub
		int rpta = 0;
		rpta = dao.save(proceso) != null ? proceso.getPcs_ide() : 0;
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public void eliminar(Integer Pcs_Ide) {
		// TODO Auto-generated method stub
		dao.deleteById(Pcs_Ide);
	}

	@Override
	public Proceso listarId(int Pcs_Ide) {
		// TODO Auto-generated method stub
		return dao.findById(Pcs_Ide).get();
	}

	@Override
	public List<Proceso> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Page<Proceso> listAllByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return dao.findAll(pageable);
	}

	@Override
	public Proceso searchByCod(String codigo) {
		// TODO Auto-generated method stub
		return dao.searchByCod(codigo);
	}

}
