package com.skysoft.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skysoft.model.Egreso;

@Repository
public interface IEgresoDAO extends JpaRepository<Egreso, Integer>{
	
	@Query(value = "select egreso.*, departamento.*, suministro_egreso.seg_ide, suministro_egreso.seg_can, suministro.* from egreso inner join departamento on departamento.dpr_ide = egreso.departamento_dpr_ide inner join suministro_egreso on suministro_egreso.egr_ide= egreso.egr_ide inner join suministro on suministro.sum_ide=suministro_egreso.sum_ide where departamento.dpr_nom like %?1%", nativeQuery = true)
	public List<Object> listarPorDepartamento(String term);
	
	@Query(value = "select egreso.*, departamento.*, suministro_egreso.seg_ide, suministro_egreso.seg_can, suministro.* from egreso inner join departamento on departamento.dpr_ide = egreso.departamento_dpr_ide inner join suministro_egreso on suministro_egreso.egr_ide= egreso.egr_ide inner join suministro on suministro.sum_ide=suministro_egreso.sum_ide where suministro.sum_cod like %?1% or suministro.sum_col like %?1% or suministro.sum_mdl like %?1%", nativeQuery = true)
	public List<Object> listarPorSuministro(String term);
	
	@Query(value = "select egreso.*, departamento.*, suministro_egreso.seg_ide, suministro_egreso.seg_can, suministro.* from egreso inner join departamento on departamento.dpr_ide = egreso.departamento_dpr_ide inner join suministro_egreso on suministro_egreso.egr_ide= egreso.egr_ide inner join suministro on suministro.sum_ide=suministro_egreso.sum_ide where egreso.egr_fec >= ?1 and egreso.egr_fec <= ?2", nativeQuery = true)
	public List<Object> listarPorFechaEgreso(String desde, String hasta);
	

}
