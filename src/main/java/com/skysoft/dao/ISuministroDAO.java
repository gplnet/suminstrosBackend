package com.skysoft.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skysoft.model.Suministro;

@Repository
public interface ISuministroDAO extends JpaRepository<Suministro, Integer>{
	
	@Query("from SuministroEgreso se where se.seg_ide=:idSumEgreso and se.suministro.sum_ide=:idSuministro")
	Suministro buscarById(@Param("idSumEgreso") Integer idsumegreso, @Param("idSuministro") Integer idsuministro);
	
	@Query(value="select * from suministro \n" + 
			"inner join equipo on  equipo.eqp_ide = suministro.eqp_ide", nativeQuery = true)
	Page<Suministro> listAllByPageDos(Pageable pageable);
	
	@Query(value="select * from suministro where sum_cod=?1", nativeQuery = true)
	public Suministro searchByCod(String codigo);
}
