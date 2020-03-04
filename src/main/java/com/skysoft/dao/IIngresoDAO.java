package com.skysoft.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skysoft.model.Ingreso;

@Repository
public interface IIngresoDAO extends JpaRepository<Ingreso, Integer> {
	
	@Query(value ="select ingreso.*, proceso.pcs_cod, proceso.pcs_fec, suministro_entrada.sen_ide, suministro_entrada.sen_can, suministro.* from ingreso  inner join proceso on proceso.pcs_ide = ingreso.pcs_ide inner join suministro_entrada on suministro_entrada.ing_ide= ingreso.ing_ide inner join suministro on suministro.sum_ide=suministro_entrada.sum_ide where proceso.pcs_cod like %?1%", nativeQuery = true)
	public List<Object> listarPorProceso(String term);
	
	@Query(value="select ingreso.*, proceso.pcs_cod, proceso.pcs_fec, suministro_entrada.sen_ide, suministro_entrada.sen_can, suministro.* from ingreso  inner join proceso on proceso.pcs_ide = ingreso.pcs_ide inner join suministro_entrada on suministro_entrada.ing_ide= ingreso.ing_ide inner join suministro on suministro.sum_ide=suministro_entrada.sum_ide  where suministro.sum_cod like %?1% or suministro.sum_col like %?1% or suministro.sum_mdl like %?1% ", nativeQuery = true)
	public List<Object> listarPorSuministro(String term);
	
	@Query(value="select ingreso.*, proceso.pcs_cod, proceso.pcs_fec, suministro_entrada.sen_ide, suministro_entrada.sen_can, suministro.* from ingreso  inner join proceso on proceso.pcs_ide = ingreso.pcs_ide inner join suministro_entrada on suministro_entrada.ing_ide= ingreso.ing_ide inner join suministro on suministro.sum_ide=suministro_entrada.sum_ide where ingreso.ing_fec >= ?1 and ingreso.ing_fec <= ?2", nativeQuery = true)
	public List<Object> listarPorFechaIngreso(String desde, String hasta);
	
	@Query(value="select ingreso.*, proceso.pcs_cod, proceso.pcs_fec, suministro_entrada.sen_ide, suministro_entrada.sen_can, suministro.* from ingreso  inner join proceso on proceso.pcs_ide = ingreso.pcs_ide inner join suministro_entrada on suministro_entrada.ing_ide= ingreso.ing_ide inner join suministro on suministro.sum_ide=suministro_entrada.sum_ide where ingreso.ing_ide = ?1", nativeQuery = true)
	public List<Object> searchByCodIngreso(int id);

}
