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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;




@Entity
@Table(name = "egreso")
public class Egreso implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int egr_ide;
	
	@Column(name  = "egr_fec", length = 50, nullable = false)
	private String egr_fec;
	
	
		
	@OneToMany(cascade = {CascadeType.ALL}, fetch =FetchType.LAZY, orphanRemoval = true )
	@JoinColumn(name = "egr_ide")
	private List<SuministroEgreso> suministroEgreso;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Departamento departamento;
	
	

	public int getEgr_ide() {
		return egr_ide;
	}

	public void setEgr_ide(int egr_ide) {
		this.egr_ide = egr_ide;
	}

	
	public void setEgr_fec(String egr_fec) {
		this.egr_fec = egr_fec;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<SuministroEgreso> getSuministroEgreso() {
		return suministroEgreso;
	}

	public void setSuministroEgreso(List<SuministroEgreso> suministroEgreso) {
		this.suministroEgreso = suministroEgreso;
	}

	public Egreso() {
		
		// TODO Auto-generated constructor stub
		this.suministroEgreso = new ArrayList<SuministroEgreso>();
	}

	public int getEgr_Ide() {
		return egr_ide;
	}

	public void setEgr_Ide(int egr_Ide) {
		egr_ide = egr_Ide;
	}

	


	

	public String getEgr_fec() {
		return egr_fec;
	}

	public List<SuministroEgreso> getSuministro() {
		return suministroEgreso;
	}

	public void setSuministro(List<SuministroEgreso> suministro) {
		this.suministroEgreso = suministro;
	}
	
	
	
	

}
