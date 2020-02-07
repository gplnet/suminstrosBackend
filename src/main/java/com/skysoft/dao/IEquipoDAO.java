package com.skysoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skysoft.model.Equipo;

@Repository
public interface IEquipoDAO extends JpaRepository<Equipo, Integer> {

}
