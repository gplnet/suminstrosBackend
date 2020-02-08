package com.skysoft.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.skysoft.dao.IDepartamentoDAO;
import com.skysoft.dao.IEgresoDAO;
import com.skysoft.dao.ISuministroDAO;
import com.skysoft.dao.IUsuarioDAO;
import com.skysoft.model.Departamento;
import com.skysoft.model.Egreso;
import com.skysoft.model.Suministro;
import com.skysoft.model.SuministroEgreso;
import com.skysoft.model.Usuario;
import com.skysoft.services.IEgresoService;
import com.skysoft.util.EgresoReporte;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class EgresoServiceImpl implements IEgresoService{

	@Autowired
	private IEgresoDAO dao;
	
	@Autowired
	private ISuministroDAO sumDAO;
	
	@Autowired
	private IDepartamentoDAO depDAO;
	
	@Autowired
	private IUsuarioDAO usrDAO;
	
	@Override
	public Egreso registrar(Egreso egreso) {
		Egreso egIns= new Egreso();
		int rpta = 0;
		rpta = dao.save(egreso) != null ? egreso.getEgr_Ide() : 0;
		egIns = egreso;
		//return rpta > 0 ? 1 : 0;
		return egIns;
	}

	@Override
	public int modificar(Egreso egreso) {
		int rpta = 0;
		rpta = dao.save(egreso) != null ? egreso.getEgr_Ide() : 0;
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public void eliminar(Integer Egr_Ide) {
		// TODO Auto-generated method stub
		dao.deleteById(Egr_Ide);
	}

	@Override
	public Egreso listarId(int Egr_Ide) {
		// TODO Auto-generated method stub
		return dao.findById(Egr_Ide).get();
	}

	@Override
	public List<Egreso> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Page<Egreso> listAllByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return dao.findAll(pageable);
	}

	@Override
	public byte[] generarReporte(int id, String idUsuario) throws Exception {
		// TODO Auto-generated method stub
		String logotipo="/img/machala.png";
		String logotipo2="/img/alcaldia.png";
		Egreso egrs = this.listarId(id);
		//Usuario usr = usrDAO.findById(idUsuario).get();
		
		Departamento dep = this.depDAO.findById(egrs.getDepartamento().getDpr_Ide()).get();
		
		List<SuministroEgreso> consulta = new ArrayList<>();
		consulta = egrs.getSuministroEgreso();
		List<EgresoReporte> listReporte = new ArrayList<>();
		for (SuministroEgreso sgre : consulta) {
			EgresoReporte rpEgr = new EgresoReporte();
			Suministro sum = new Suministro();
			sum = this.sumDAO.findById(sgre.getSuministro().getSum_ide()).get();
			
			rpEgr.setCantidad(sgre.getSeg_can());
			rpEgr.setCodigo(sum.getSum_cod());
			rpEgr.setDescripcion(sum.getSum_mdl());
			listReporte.add(rpEgr);
		}
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listReporte);
			
		Map<String, Object> cabecera = new HashMap<>();
		cabecera.put("departamento", dep.getDpr_Nom().concat(" - "+dep.getDpr_Res()));
		cabecera.put("usuario", idUsuario);
		cabecera.put("fecha", egrs.getEgr_fec().toString());
		cabecera.put("ItemDataSource", dataSource);
		cabecera.put("ide", " "+egrs.getEgr_ide());
		cabecera.put("machala", this.getClass().getResourceAsStream(logotipo));
		cabecera.put("alcaldia", this.getClass().getResourceAsStream(logotipo2));
		
		File file = new ClassPathResource("/reports/egreso.jasper").getFile();
		
		

		JasperPrint print = JasperFillManager.fillReport(file.getPath(),cabecera, new JREmptyDataSource());
		return JasperExportManager.exportReportToPdf(print);
	}

	@Override
	public List<Object> listarPorDepartamento(String term) throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPorDepartamento(term);
	}

	@Override
	public List<Object> listarPorSuministro(String term) throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPorSuministro(term);
	}

	@Override
	public List<Object> listarPorFechaEgreso(String desde, String hasta) throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPorFechaEgreso(desde, hasta);
	}

	
}
