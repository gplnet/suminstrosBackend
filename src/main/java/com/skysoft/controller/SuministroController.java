package com.skysoft.controller;

import java.util.ArrayList;
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

import com.skysoft.model.Suministro;
import com.skysoft.services.IEquipoService;
import com.skysoft.services.ISuministroService;



@RestController 
@RequestMapping("/suministro")
public class SuministroController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ISuministroService service;
	
	@Autowired
	private IEquipoService eServices;
	
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Suministro>> listar(){
		List<Suministro> suministros = new ArrayList<>();
		try {
			suministros = service.listar();
		} catch (Exception e) {
			// TODO: handle exception
			new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Suministro>>(suministros, HttpStatus.OK);		
	}
	
	@GetMapping(value = "/listarPageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Suministro>> listar(Pageable pageable){
		Page<Suministro> suministro = null;
		try {
			suministro = service.listAllistAllByPageDoslByPage(pageable);
		} catch (Exception e) {
			// TODO: handle exception
			new ResponseEntity<Page<Suministro>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Page<Suministro>>(suministro, HttpStatus.OK);		
	}
	
	
	@GetMapping(value="/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Suministro> listarId (@PathVariable("id") Integer id){
		//Hola jodida mia 
		Suministro suministro = new Suministro();
		try {
			suministro = service.listarId(id);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Suministro>(suministro, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Suministro>(suministro, HttpStatus.OK);	
		
	}
	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> registrar(@RequestBody Suministro sum ){
		//Equipo eq = new Equipo();
		int rpta = 0;
		try {
			rpta = service.registrar(sum);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
		
	}
	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody Suministro sum) {
		int resultado = 0;
		try {
			resultado = service.modificar(sum);
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
	
	@GetMapping(value = "/generarReporte/{nombre}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> generarReporte(@PathVariable("nombre") String nombre) {
		logger.info("nombre: "+nombre);
		byte[] data = null;
		try {
			data = service.generarReporteAllSuministros(nombre);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(""+e);
			return new ResponseEntity<byte[]>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}
}
