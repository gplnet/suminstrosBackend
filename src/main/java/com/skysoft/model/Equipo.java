package com.skysoft.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "equipo")
public class Equipo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int eqp_ide;
	@Column(name  = "eqp_mrc", length = 50, nullable = false)
    private String eqp_mrc;
	@Column(name  = "eqp_mdl", length = 50, nullable = false)
    private String eqp_mdl;
	@Column(name  = "eqp_est", length = 1, nullable = false)
    private String eqp_est;
	@Column(name  = "eqp_ser", length = 20, nullable = false)
    private String eqp_ser;
	
	@ManyToOne()
	@JoinColumn(name = "dpr_ide", nullable = false)
	private Departamento departamento;
	
	//@OneToOne(mappedBy = "equipo", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval=true)
	//@JsonIgnore
	//private Suministro suministro;
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eqp_ide;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		if (eqp_ide != other.eqp_ide)
			return false;
		return true;
	}


	public int getEqp_Ide() {
		return eqp_ide;
	}


	public void setEqp_Ide(int eqp_Ide) {
		this.eqp_ide = eqp_Ide;
	}




	public String getEqp_mrc() {
		return eqp_mrc;
	}


	public void setEqp_mrc(String eqp_mrc) {
		this.eqp_mrc = eqp_mrc;
	}


	public String getEqp_mdl() {
		return eqp_mdl;
	}


	public void setEqp_mdl(String eqp_mdl) {
		this.eqp_mdl = eqp_mdl;
	}




	public String getEqp_ser() {
		return eqp_ser;
	}


	public void setEqp_ser(String eqp_ser) {
		this.eqp_ser = eqp_ser;
	}


	public int getEqp_ide() {
		return eqp_ide;
	}


	public void setEqp_ide(int eqp_ide) {
		this.eqp_ide = eqp_ide;
	}


	public String getEqp_est() {
		return eqp_est;
	}


	public void setEqp_est(String eqp_est) {
		this.eqp_est = eqp_est;
	}


	public Departamento getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	


	/*
	 * public Suministro getSuministro() { return suministro; }
	 * 
	 * 
	 * public void setSuministro(Suministro suministro) { this.suministro =
	 * suministro; }
	 */

	
	
	
	
	
        

}
