package com.skysoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skysoft.model.SuministroIngreso;
@Repository
public interface ISuministroEntradaDAO extends JpaRepository<SuministroIngreso, Integer> {

}
