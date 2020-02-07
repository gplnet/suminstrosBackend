package com.skysoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skysoft.model.Proveedor;

@Repository
public interface IProveedorDAO extends JpaRepository<Proveedor, Integer>{

}
