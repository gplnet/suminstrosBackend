package com.skysoft.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.skysoft.model.SuministroIngreso;
import com.skysoft.services.ISuministroEntradaService;


@RestController 
@RequestMapping("/sentrada")
public class SuministroEntradaController {

	@Autowired
	private ISuministroEntradaService service;
	
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SuministroIngreso>> listar(){
		List<SuministroIngreso> sentrada = new ArrayList<>();
		try {
			sentrada = service.listar();
		} catch (Exception e) {
			// TODO: handle exception
			new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<SuministroIngreso>>(sentrada, HttpStatus.OK);		
	}
	
	@GetMapping(value = "/listarPageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<SuministroIngreso>> listar(Pageable pageable){
		Page<SuministroIngreso> sentrada = null;
		try {
			sentrada = service.listAllByPage(pageable);
		} catch (Exception e) {
			// TODO: handle exception
			new ResponseEntity<Page<SuministroIngreso>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Page<SuministroIngreso>>(sentrada, HttpStatus.OK);		
	}
	
	
	@GetMapping(value="/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuministroIngreso> listarId (@PathVariable("id") Integer id){
		//Hola jodida mia 
		SuministroIngreso sentrada = new SuministroIngreso();
		try {
			sentrada = service.listarId(id);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<SuministroIngreso>(sentrada, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<SuministroIngreso>(sentrada, HttpStatus.OK);	
		
	}
	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> registrar(@RequestBody SuministroIngreso sen ){
		//Equipo eq = new Equipo();
		int rpta = 0;
		try {
			rpta = service.registrar(sen);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
		
	}
	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody SuministroIngreso sen) {
		int resultado = 0;
		try {
			resultado = service.modificar(sen);
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
