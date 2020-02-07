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
@Table(name = "departamento")
public class Departamento implements Serializable{
	/**
	 * Hola Estefa
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int dpr_ide;
	@Column(name  = "dpr_nom", length = 30, nullable = false)
	private String dpr_nom;
	@Column(name  = "dpr_res", length = 30, nullable = false)
	private String dpr_res;
	
	
	
	
	
	



	public int getDpr_Ide() {
		return dpr_ide;
	}



	public void setDpr_Ide(int dpr_Id) {
		dpr_ide = dpr_Id;
	}



	public String getDpr_Nom() {
		return dpr_nom;
	}



	public void setDpr_Nom(String dpr_No) {
		dpr_nom = dpr_No;
	}



	public String getDpr_Res() {
		return dpr_res;
	}



	public void setDpr_Res(String dpr_Re) {
		dpr_res = dpr_Re;
	}




	
	
	
	

}
