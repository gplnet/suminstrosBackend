package com.skysoft.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "suministro")
public class Suministro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private  int sum_ide;
	@Column(name  = "sum_mdl", length = 50, nullable = false)
    private String sum_mdl;
	@Column(name  = "sum_cod", length = 50, nullable = false)
    private String sum_cod;
	@Column(name  = "sum_col", length = 50, nullable = false)
    private String sum_col;
	@Column(name = "sum_cnt", length = 4, nullable = false)
    private Integer sum_cnt;
	@Column(name = "sum_vol", length = 4, nullable = false)
    private Integer sum_vol;
	//Uno a uno
	@OneToOne
	@JoinColumn(name="eqp_ide", nullable = false)
	//@JsonIgnore
	private Equipo equipo;
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sum_ide;
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
		Suministro other = (Suministro) obj;
		if (sum_ide != other.sum_ide)
			return false;
		return true;
	}
	public int getSum_ide() {
		return sum_ide;
	}
	public void setSum_ide(int sum_ide) {
		this.sum_ide = sum_ide;
	}
	public String getSum_mdl() {
		return sum_mdl;
	}
	public void setSum_mdl(String sum_mdl) {
		this.sum_mdl = sum_mdl;
	}
	public String getSum_cod() {
		return sum_cod;
	}
	public void setSum_cod(String sum_cod) {
		this.sum_cod = sum_cod;
	}
	public String getSum_col() {
		return sum_col;
	}
	public void setSum_col(String sum_col) {
		this.sum_col = sum_col;
	}
	public Integer getSum_cnt() {
		return sum_cnt;
	}
	public void setSum_cnt(Integer sum_cnt) {
		this.sum_cnt = sum_cnt;
	}
	public Integer getSum_vol() {
		return sum_vol;
	}
	public void setSum_vol(Integer sum_vol) {
		this.sum_vol = sum_vol;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	
	
	


    
    

}
