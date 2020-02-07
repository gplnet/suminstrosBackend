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

import com.skysoft.model.Ingreso;
import com.skysoft.model.Suministro;
import com.skysoft.model.SuministroIngreso;
import com.skysoft.services.IIngresoService;
import com.skysoft.services.ISuministroService;


@RestController 
@RequestMapping("/ingreso")
public class IngresoController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IIngresoService service;
	
	@Autowired
	private ISuministroService ss;
	
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ingreso>> listar(){
		List<Ingreso> ingreso = new ArrayList<>();
		try {
			ingreso = service.listar();
		} catch (Exception e) {
			// TODO: handle exception
			new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Ingreso>>(ingreso, HttpStatus.OK);		
	}
	
	@GetMapping(value = "/listarPageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Ingreso>> listar(Pageable pageable){
		Page<Ingreso> ingreso = null;
		try {
			ingreso = service.listAllByPage(pageable);
		} catch (Exception e) {
			// TODO: handle exception
			new ResponseEntity<Page<Ingreso>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Page<Ingreso>>(ingreso, HttpStatus.OK);		
	}
	
	@GetMapping(value = "/listarByProceso/{proces}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Object>> listarByTerm(@PathVariable("proces") String proces){
		List<Object> ingreso = new ArrayList<>();
		try {
			ingreso = service.listarPorProceso(proces);
		} catch (Exception e) {
			// TODO: handle exception
			new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Object>>(ingreso, HttpStatus.OK);		
	}
	@GetMapping(value = "/listarBySum/{suminist}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Object>> listarBySum(@PathVariable("suminist") String suminist){
		List<Object> ingreso = new ArrayList<>();
		try {
			ingreso = service.listarPorSuministro(suminist);
		} catch (Exception e) {
			// TODO: handle exception
			new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Object>>(ingreso, HttpStatus.OK);		
	}
	
	@GetMapping(value = "/listarByFech/{desde}/{hasta}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Object>> listarByFech(@PathVariable("desde") String desde,@PathVariable("hasta") String hasta){
		List<Object> ingreso = new ArrayList<>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(sdf.parse(desde).getTime());
			
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");			
			Date date2 = new Date(sdf2.parse(hasta).getTime());
			
			logger.info("error: "+sdf2.format(date));
			logger.info("error: "+sdf2.format(date2));
			ingreso = service.listarPorFechaIngreso(desde, hasta);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("error: "+e);
			new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Object>>(ingreso, HttpStatus.OK);		
	}
	
	
	
	@GetMapping(value="/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ingreso> listarId (@PathVariable("id") Integer id){
		//Hola jodida mia 
		Ingreso ingreso = new Ingreso();
		try {
			ingreso = service.listarId(id);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Ingreso>(ingreso, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Ingreso>(ingreso, HttpStatus.OK);	
		
	}
	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ingreso> registrar(@RequestBody Ingreso ingr ){
		//Equipo eq = new Equipo();
		logger.info(">-Size1 ---"+ingr.toString());
		int rpta = 0;
		Ingreso ings = new Ingreso();
		try {
			logger.info(">-Size---"+ingr.getSuministroIngreso().size());
			ings = service.registrar(ingr);
			for (SuministroIngreso singr : ingr.getSuministroIngreso()) {
				Suministro sum =ss.listarId(singr.getSuministro().getSum_ide());
				int cal = (sum.getSum_cnt()*1) + (singr.getSen_can()*1);
				sum.setSum_cnt(cal);
				ss.modificar(sum);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Ingreso>(ings, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
		return new ResponseEntity<Ingreso>(ings, HttpStatus.OK);
		
	}
	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody Ingreso ingr) {
		int resultado = 0;
		try {
			resultado = service.modificar(ingr);
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
