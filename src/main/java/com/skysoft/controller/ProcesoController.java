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

import com.skysoft.model.Proceso;
import com.skysoft.services.IProcesoService;

@RestController 
@RequestMapping("/procesos")
public class ProcesoController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IProcesoService service;
	
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Proceso>> listar(){
		List<Proceso> proceso = new ArrayList<>();
		try {
			proceso = service.listar();
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("error:" +e);
			new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Proceso>>(proceso, HttpStatus.OK);		
	}
	
	@GetMapping(value = "/listarPageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Proceso>> listar(Pageable pageable){
		Page<Proceso> proceso = null;
		try {
			proceso = service.listAllByPage(pageable);
		} catch (Exception e) {
			// TODO: handle exception
			new ResponseEntity<Page<Proceso>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Page<Proceso>>(proceso, HttpStatus.OK);		
	}
	
	
	@GetMapping(value="/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Proceso> listarId (@PathVariable("id") Integer id){
		//Hola jodida mia 
		Proceso proceso = new Proceso();
		try {
			proceso = service.listarId(id);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Proceso>(proceso, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Proceso>(proceso, HttpStatus.OK);	
		
	}
	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> registrar(@RequestBody Proceso proc ){
		//Equipo eq = new Equipo();
		int rpta = 0;
		try {
			rpta = service.registrar(proc);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
		
	}
	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody Proceso proc) {
		int resultado = 0;
		try {
			resultado = service.modificar(proc);
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
}
