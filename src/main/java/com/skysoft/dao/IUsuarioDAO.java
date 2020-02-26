package com.skysoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skysoft.model.Usuario;

@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario, Integer> {
	
	Usuario findOneByUsername(String username);
	
	@Query(value="select max(id_usuario) as maximo from usuario", nativeQuery = true)
	public int maxUsuarioCod();
	
	@Query(value = "select * from usuario where nombre=?1", nativeQuery = true)
	public Usuario getUsuarioByNombre(String nombre);

}
