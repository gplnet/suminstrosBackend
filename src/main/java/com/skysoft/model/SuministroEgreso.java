package com.skysoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="suministro_egreso")
public class SuministroEgreso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seg_ide;
	
	@Column(name = "seg_can", length = 3, nullable=false)
	private int seg_can;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sum_ide", nullable = false)
	private Suministro suministro;
	
	




	public int getSeg_ide() {
		return seg_ide;
	}




	public void setSeg_ide(int seg_ide) {
		this.seg_ide = seg_ide;
	}




	public int getSeg_can() {
		return seg_can;
	}




	public void setSeg_can(int seg_can) {
		this.seg_can = seg_can;
	}




	public Suministro getSuministro() {
		return suministro;
	}




	public void setSuministro(Suministro suministro) {
		this.suministro = suministro;
	}




	public int actualizarStock() {
		return suministro.getSum_cnt() - seg_can;
	}
	
	

}
