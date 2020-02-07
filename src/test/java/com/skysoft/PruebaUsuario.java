package com.skysoft;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.skysoft.dao.IUsuarioDAO;
import com.skysoft.model.Usuario;



@RunWith(SpringRunner.class)
@SpringBootTest
public class PruebaUsuario {
	
	@Autowired
	private IUsuarioDAO service;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Test
	public void crearUsuario() {
		Usuario us = new Usuario();
		us.setIdUsuario('2');
		us.setUsername("CABA");
		us.setPassword(bCryptPasswordEncoder.encode("CESARBERMEO"));
		us.setAuthorithy("ROLE_ADMIN");
		us.setEnabled(true);
		
		Usuario retorno = service.save(us);
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));
	}

}
