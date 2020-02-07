package com.skysoft.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "ingreso")
public class Ingreso implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int ing_ide;	
	
	@Column(name  = "ing_fec", length = 50, nullable = false)
	private String ing_fec;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch =FetchType.LAZY, orphanRemoval = true )
	@JoinColumn(name = "ing_ide")
	private List<SuministroIngreso>suministroIngreso;
	
	@ManyToOne
	@JoinColumn(name = "pcs_ide", nullable = false)
	private Proceso proceso;
	
	


	public List<SuministroIngreso> getSuministroIngreso() {
		return suministroIngreso;
	}

	public void setSuministroIngreso(List<SuministroIngreso> suministroIngreso) {
		this.suministroIngreso = suministroIngreso;
	}

	public int getIng_ide() {
		return ing_ide;
	}

	public void setIng_ide(int ing_ide) {
		this.ing_ide = ing_ide;
	}

	

	

	public String getIng_fec() {
		return ing_fec;
	}

	public void setIng_fec(String ing_fec) {
		this.ing_fec = ing_fec;
	}

	public Proceso getProceso() {
		return proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

	public Ingreso() {
		// TODO Auto-generated constructor stub
		this.suministroIngreso =  new ArrayList<SuministroIngreso>();
	}


		
	

}
