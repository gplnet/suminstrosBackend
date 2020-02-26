package com.skysoft.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.skysoft.dao.ISuministroDAO;
import com.skysoft.dao.IUsuarioDAO;
import com.skysoft.model.Suministro;
import com.skysoft.model.Usuario;
import com.skysoft.services.ISuministroService;
import com.skysoft.util.SuministosReporte;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class SuministroServiceImpl implements ISuministroService{

	@Autowired
	private ISuministroDAO dao;
	
	@Autowired
	private IUsuarioDAO userDAO;

	@Override
	public int registrar(Suministro suministro) {
		// TODO Auto-generated method stub
		int rpta= 0;
		rpta= dao.save(suministro) != null ? suministro.getSum_ide() : 0;
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public int modificar(Suministro suministro) {
		// TODO Auto-generated method stub
		int rpta= 0;
		rpta= dao.save(suministro) != null ? suministro.getSum_ide() : 0;
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public void eliminar(Integer Sum_Ide) {
		// TODO Auto-generated method stub
		dao.deleteById(Sum_Ide);
	}

	@Override
	public Suministro listarId(int Sum_Ide) {
		// TODO Auto-generated method stub
		
		return dao.findById(Sum_Ide).get();
	 }

	@Override
	public List<Suministro> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Page<Suministro> listAllByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return dao.findAll(pageable);
	}

	@Override
	public Suministro buscarById(Integer idSumEgreso, Integer idSuministro) throws Exception {
		// TODO Auto-generated method stub
		return dao.buscarById(idSumEgreso, idSuministro);
	}

	@Override
	public Page<Suministro> listAllistAllByPageDoslByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return dao.listAllByPageDos(pageable);
	}

	@Override
	public byte[] generarReporteAllSuministros(String nombre) throws Exception {
		// TODO Auto-generated method stub
		List<Suministro> listaSuminsitros = new ArrayList<>();
		Usuario usr = this.userDAO.findOneByUsername(nombre);
		listaSuminsitros = this.listar();
		List<SuministosReporte> listaReporte = new ArrayList<>();
		for (Suministro sum : listaSuminsitros) {
			SuministosReporte suministro =  new SuministosReporte();
			suministro.setCantidad(sum.getSum_cnt());
			suministro.setCodigo(sum.getSum_cod());
			suministro.setColor(sum.getSum_col());
			suministro.setModelo(sum.getSum_mdl());
			listaReporte.add(suministro);
		}
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaReporte);
		Map<String, Object> cabecera = new HashMap<>();
		cabecera.put("usuario", usr.getUsername());
		cabecera.put("ItemDataSource", dataSource);
		
		File file = new ClassPathResource("/reports/suministrosAll.jasper").getFile();
		
		
		JasperPrint print = JasperFillManager.fillReport(file.getPath(),cabecera, new JREmptyDataSource());
		return JasperExportManager.exportReportToPdf(print);
	}

	@Override
	public Suministro searchByCod(String codigo) throws Exception {
		// TODO Auto-generated method stub
		return dao.searchByCod(codigo);
	}
	
	
	
}
