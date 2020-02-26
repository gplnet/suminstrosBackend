package com.skysoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skysoft.model.Proceso;

@Repository
public interface IProcesoDAO extends JpaRepository<Proceso, Integer>{
	
	@Query(value="select * from proceso where pcs_cod=?1", nativeQuery = true)
	public Proceso searchByCod(String codigo);

}
