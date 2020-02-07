package com.skysoft.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "proveedor")
public class Proveedor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int prv_ide;
	@Column(name  = "prv_nom", length = 30, nullable = false)
	private String prv_nom;
	@Column(name  = "prv_cro", length = 30, nullable = false)
	private String prv_cro;
	@Column(name  = "prv_tlf", length = 30, nullable = false)
	private String prv_tlf;
	
	
//	@OneToOne(mappedBy = "proveedor", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval=true)
//	@JsonIgnore
//	private Ingreso ingreso;


	public int getPrv_ide() {
		return prv_ide;
	}


	public void setPrv_ide(int prv_ide) {
		this.prv_ide = prv_ide;
	}


	public String getPrv_nom() {
		return prv_nom;
	}


	public void setPrv_nom(String prv_nom) {
		this.prv_nom = prv_nom;
	}


	public String getPrv_cro() {
		return prv_cro;
	}


	public void setPrv_cro(String prv_cro) {
		this.prv_cro = prv_cro;
	}


	public String getPrv_tlf() {
		return prv_tlf;
	}


	public void setPrv_tlf(String prv_tlf) {
		this.prv_tlf = prv_tlf;
	}


//	public Ingreso getIngreso() {
//		return ingreso;
//	}
//
//
//	public void setIngreso(Ingreso ingreso) {
//		this.ingreso = ingreso;
//	}
	
	
	
	
	
	
	
	

}
