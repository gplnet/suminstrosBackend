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



@Entity
@Table(name="suministro_entrada")
public class SuministroIngreso  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sen_ide;
	@Column(name = "sen_can", length = 3, nullable=false)
	private int sen_can;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sum_ide", nullable = false)
	private Suministro suministro;
	
	
	public int getSen_ide() {
		return sen_ide;
	}
	public void setSen_ide(int sen_ide) {
		this.sen_ide = sen_ide;
	}
	public int getSen_can() {
		return sen_can;
	}
	public void setSen_can(int sen_can) {
		this.sen_can = sen_can;
	}
	public Suministro getSuministro() {
		return suministro;
	}
	public void setSuministro(Suministro suministro) {
		this.suministro = suministro;
	}
	
	
	
	

}
