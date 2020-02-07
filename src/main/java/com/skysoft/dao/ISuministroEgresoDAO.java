package com.skysoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skysoft.model.SuministroEgreso;

@Repository
public interface ISuministroEgresoDAO extends JpaRepository<SuministroEgreso, Integer>{

}
