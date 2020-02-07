package com.skysoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skysoft.model.Departamento;

@Repository
public interface IDepartamentoDAO extends JpaRepository<Departamento, Integer> {
	

	//@Query("from ConsultaExamen ce where ce.consulta.idConsulta=:idConsulta and ce.examen.idExamen=:idExamen")
	//ConsultaExamen listarId(@Param("idConsulta") Integer idconsulta, @Param("idExamen") Integer idexamen);
	

}
