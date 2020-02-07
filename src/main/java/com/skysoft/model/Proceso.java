package com.skysoft.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name="proceso")
public class Proceso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pcs_ide;
	@Column(name = "pcs_cod", length = 60, nullable = false)
	private String pcs_cod;
	@Column(name = "pcs_fec", length = 60, nullable = true)
	private String pcs_fec;
	@Column(name = "pcs_est", length = 60, nullable = true)
	private String pcs_est;
	
	
	//@OneToMany(cascade = {CascadeType.ALL}, fetch =FetchType.LAZY, orphanRemoval = true )//
	//@JoinColumn(name = "Pcs_Ide")//
	
	@OneToOne
	@JoinColumn(name = "pcs_ide", nullable = false)
	private Proveedor proveedor;


	
	
	public String getPcs_est() {
		return pcs_est;
	}


	public void setPcs_est(String pcs_est) {
		this.pcs_est = pcs_est;
	}


	public int getPcs_ide() {
		return pcs_ide;
	}


	public void setPcs_ide(int pcs_ide) {
		this.pcs_ide = pcs_ide;
	}


	public String getPcs_cod() {
		return pcs_cod;
	}


	public void setPcs_cod(String pcs_cod) {
		this.pcs_cod = pcs_cod;
	}


	public String getPcs_fec() {
		return pcs_fec;
	}


	public void setPcs_fec(String pcs_fec) {
		this.pcs_fec = pcs_fec;
	}


	public Proveedor getProveedor() {
		return proveedor;
	}


	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	

	

}
