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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skysoft.dao.IUsuarioDAO;
import com.skysoft.model.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping( value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> listar(){
		List<Usuario> listaUsuarios = new ArrayList<>();
		try {
			listaUsuarios = this.usuarioDAO.findAll();
			
		} catch (Exception e) {
			// TODO: handle exception
			new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Usuario>>(listaUsuarios, HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> registrar(@RequestBody Usuario usr){
		Usuario usuario = new Usuario();
		try {
			logger.info("sin encriptar"+usr.getPassword());
			usr.setPassword(bCryptPasswordEncoder.encode(usr.getPassword()));
			logger.info("encriptada"+usr.getPassword());
			usuario = this.usuarioDAO.save(usr);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Usuario>(usuario, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@GetMapping(value="/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> listarId(@PathVariable("id") Integer id) {
		
		Usuario user = new Usuario();
		try {
			user = this.usuarioDAO.findById(id).get();
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Usuario>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/listarByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> listarByName(@PathVariable("name") String name) {
		
		Usuario user = new Usuario();
		try {
			user = this.usuarioDAO.getUsuarioByNombre(name);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Usuario>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
		
	}
	
	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody Usuario usr){
		int resultado = 0;
		try {
			resultado = this.usuarioDAO.save(usr) != null ? usr.getIdUsuario() : 0;
			if(resultado > 0){ resultado = 1; }else{ resultado = 2;}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/listarPageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Usuario>> listar(Pageable pageable){
		Page<Usuario> usuarios = null;
		try {
			usuarios = this.usuarioDAO.findAll(pageable);
		} catch (Exception e) {
			// TODO: handle exception
			new ResponseEntity<Page<Usuario>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Page<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	@GetMapping(value="/max", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> maxId(){
		int respuesta = 0;
		try {
			respuesta = this.usuarioDAO.maxUsuarioCod();
					
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Integer>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(respuesta, HttpStatus.OK);
	}

}
