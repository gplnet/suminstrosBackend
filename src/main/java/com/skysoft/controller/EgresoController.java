package com.skysoft.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skysoft.model.Egreso;
import com.skysoft.model.Suministro;
import com.skysoft.model.SuministroEgreso;
import com.skysoft.services.IEgresoService;
import com.skysoft.services.ISuministroEgresoService;
import com.skysoft.services.ISuministroService;



@RestController 
@RequestMapping("/egreso")
public class EgresoController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IEgresoService service;
	@Autowired
	private ISuministroService ss;
	@Autowired
	private ISuministroEgresoService sE;
	
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Egreso>> listar(){
		List<Egreso> egreso = new ArrayList<>();
		try {
			egreso = service.listar();
		} catch (Exception e) {
			// TODO: handle exception
			new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Egreso>>(egreso, HttpStatus.OK);		
	}
	
	@GetMapping(value = "/listarByDepart/{depart}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Object>> listarByTerm(@PathVariable("depart") String depart){
		List<Object> egreso = new ArrayList<>();
		try {
			egreso = service.listarPorDepartamento(depart);
		} catch (Exception e) {
			// TODO: handle exception
			new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Object>>(egreso, HttpStatus.OK);		
	}
	@GetMapping(value = "/listarBySum/{suminist}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Object>> listarBySum(@PathVariable("suminist") String suminist){
		List<Object> egreso = new ArrayList<>();
		try {
			egreso = service.listarPorSuministro(suminist);
		} catch (Exception e) {
			// TODO: handle exception
			new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Object>>(egreso, HttpStatus.OK);		
	}
	
	@GetMapping(value = "/listarByFech/{desde}/{hasta}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Object>> listarByFech(@PathVariable("desde") String desde,@PathVariable("hasta") String hasta){
		List<Object> egreso = new ArrayList<>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(sdf.parse(desde).getTime());
			
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");			
			Date date2 = new Date(sdf2.parse(hasta).getTime());
			
			logger.info("error: "+sdf2.format(date));
			logger.info("error: "+sdf2.format(date2));
			egreso = service.listarPorFechaEgreso(desde, hasta);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("error: "+e);
			new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Object>>(egreso, HttpStatus.OK);		
	}
	
	@GetMapping(value = "/listarPageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Egreso>> listar(Pageable pageable){
		Page<Egreso> egreso = null;
		try {
			egreso = service.listAllByPage(pageable);
		} catch (Exception e) {
			// TODO: handle exception
			new ResponseEntity<Page<Egreso>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Page<Egreso>>(egreso, HttpStatus.OK);		
	}
	
	
	@GetMapping(value="/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Egreso> listarId (@PathVariable("id") Integer id){
		//Hola jodida mia 
		Egreso egreso = new Egreso();
		try {
			egreso = service.listarId(id);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Egreso>(egreso, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Egreso>(egreso, HttpStatus.OK);	
		
	}
	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Egreso> registrar(@RequestBody Egreso egr ){
		//Equipo eq = new Equipo();
		int rpta = 0;
		Egreso egLLeg= new Egreso();
		//logger.info(">---CANTIDAD--"+egr.getSuministroEgreso().get(0).getSeg_can());
		//logger.info(">-ID----"+egr.getSuministroEgreso().get(0).getSeg_ide());
		//logger.info(">-----"+egr.getSuministro().get(0).getSeg_can());
		//logger.info(">-----"+egr.getEgr_Fec());
		//logger.info(">-----"+egr.getEgr_Ide());
		//logger.info(">-----"+egr.getDepartamento().getDpr_Nom());
		try {
			
			egLLeg = service.registrar(egr);
			logger.info(">---Egreso- ID-"+egLLeg.getEgr_Ide());
			//logger.info(">---SS-ID-"+egLLeg.getSuministro().get(0).getSeg_ide());
			//logger.info(">--SE-ID--"+egLLeg.getSuministroEgreso().get(0).getSeg_ide());
			
			//egLLeg.getSuministro().get(0).setSeg_can();
			//egLLeg.getSuministroEgreso().get(0).actualizarStock();
			logger.info(">-Size---"+egLLeg.getSuministroEgreso().size());
			
			for (SuministroEgreso smEgrs : egLLeg.getSuministroEgreso()) {
				Suministro sum = ss.listarId(smEgrs.getSuministro().getSum_ide());//egLLeg.getSuministroEgreso().get(0).getSuministro();
				logger.info(">--For Egreso--"+smEgrs);
				int cal =  (sum.getSum_cnt()*1) - (smEgrs.getSeg_can()*1);
				logger.info(">-----"+cal);
				
				sum.setSum_cnt(cal);
				ss.modificar(sum);
				
				logger.info(">-sTOCK aCTUAL---"+sum.getSum_ide());
				logger.info(">-sTOCK aCTUAL---"+sum.getSum_cnt());
				
			}
			
			
			
			
			//logger.info(">--Cantidad--"+egLLeg.getSuministroEgreso().get(0).getSuministro().getSum_cnt());
			//logger.info(">---Desceunto--"+egLLeg.getSuministroEgreso().get(0).getSeg_can());
			
						
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Egreso>(egLLeg, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
		return new ResponseEntity<Egreso>(egLLeg, HttpStatus.OK);
		
	}
	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody Egreso egr) {
		int resultado = 0;
		try {
			resultado = service.modificar(egr);
			resultado = 1;
		} catch (Exception e) {
			return new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> eliminar(@PathVariable Integer id) {
		int resultado = 0;
		try {
			service.eliminar(id);
			resultado = 1;
		} catch (Exception e) {
			resultado = 0;
		}

		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}
	@GetMapping(value = "/generarReporte/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> generarReporte(@PathVariable("id") Integer id) {
		logger.info("ide: "+id);
		byte[] data = null;
		try {
			data = service.generarReporte(id);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(""+e);
			return new ResponseEntity<byte[]>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}
}
