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


import com.skysoft.dao.IIngresoDAO;
import com.skysoft.dao.IProcesoDAO;
import com.skysoft.dao.ISuministroDAO;
import com.skysoft.model.Ingreso;
import com.skysoft.model.Proceso;
import com.skysoft.model.Suministro;
import com.skysoft.model.SuministroIngreso;
import com.skysoft.services.IIngresoService;
import com.skysoft.util.IngresoReporte;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class IngresoServiceImpl implements IIngresoService {

	@Autowired
	private IIngresoDAO dao;
	
	@Autowired
	private IProcesoDAO procsDAO;
	
	@Autowired
	private ISuministroDAO sumDAO;
	
	@Override
	public Ingreso registrar(Ingreso ingreso) {
		// TODO Auto-generated method stub
		Ingreso ingres = new Ingreso();
		int rpta = 0;
		rpta = dao.save(ingreso) != null ? ingreso.getIng_ide() : 0;
		ingres= ingreso;
		//return rpta > 0 ? 1 : 0;
		return ingres;
	}

	@Override
	public int modificar(Ingreso ingreso) {
		// TODO Auto-generated method stub
		int rpta = 0;
		rpta = dao.save(ingreso) != null ? ingreso.getIng_ide() : 0;
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public void eliminar(Integer Ing_Ide) {
		// TODO Auto-generated method stub
		dao.deleteById(Ing_Ide);
	}

	@Override
	public Ingreso listarId(int Ing_Ide) {
		// TODO Auto-generated method stub
		return dao.findById(Ing_Ide).get();
	}

	@Override
	public List<Ingreso> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Page<Ingreso> listAllByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return dao.findAll(pageable);
	}

	@Override
	public byte[] generarReporte(int id) throws Exception {
		// TODO Auto-generated method stub
		Ingreso ingrs = this.listarId(id);
		Proceso pro = this.procsDAO.findById(ingrs.getProceso().getPcs_ide()).get();
		List<SuministroIngreso> consulta = new ArrayList<>();
		consulta = ingrs.getSuministroIngreso();
		List<IngresoReporte> listaReporte = new ArrayList<>();
		for (SuministroIngreso singrso : consulta) {
			IngresoReporte ingrRep = new IngresoReporte();
			Suministro sum = new Suministro();
			sum = this.sumDAO.findById(singrso.getSuministro().getSum_ide()).get();
			ingrRep.setCantidad(singrso.getSen_can());
			ingrRep.setCodigo(sum.getSum_cod());
			ingrRep.setDescripcion(sum.getSum_mdl());
			//ingrRep.setProceso(pro.getPcs_cod());
			listaReporte.add(ingrRep);			
		}
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaReporte);
		
		Map<String, Object> cabecera = new HashMap<>();
		cabecera.put("proceso", pro.getPcs_cod());
		cabecera.put("fecha", ingrs.getIng_fec().toString());
		cabecera.put("ItemDataSource", dataSource);
		
		File file = new ClassPathResource("/reports/ingreso.jasper").getFile();
		
		

		JasperPrint print = JasperFillManager.fillReport(file.getPath(),cabecera, new JREmptyDataSource());
		return JasperExportManager.exportReportToPdf(print);
	}

	@Override
	public List<Object> listarPorSuministro(String term) throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPorSuministro(term);
	}

	@Override
	public List<Object> listarPorProceso(String term) throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPorProceso(term);
	}

	@Override
	public List<Object> listarPorFechaIngreso(String desde, String hasta) throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPorFechaIngreso(desde, hasta);
	}

	@Override
	public List<Object> searchByCodIngreso(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.searchByCodIngreso(id);
	}

}
