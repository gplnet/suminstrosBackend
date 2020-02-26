package com.skysoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skysoft.model.Eliminado;


@Repository
public interface IEliminadoDAO extends JpaRepository<Eliminado, Integer> {

}
