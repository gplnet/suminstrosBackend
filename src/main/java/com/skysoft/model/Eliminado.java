package com.skysoft.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "eliminados")
public class Eliminado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int eli_ide;
	
	@Column(name = "eli_des", nullable=true, length = 150)
	private String eli_des;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "eli_sys", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private Date eli_sys;
	
	@Column(name = "eli_tip", nullable=true, length = 150)
	private String eli_tip;
	
	@Column(name = "eli_dat", nullable=true, length = 650)
	private String eli_dat;
	
	@Column(name = "eli_usr", nullable=true, length = 650)
	private String eli_usr;

	public int getEli_ide() {
		return eli_ide;
	}

	public void setEli_ide(int eli_ide) {
		this.eli_ide = eli_ide;
	}

	public String getEli_des() {
		return eli_des;
	}

	public void setEli_des(String eli_des) {
		this.eli_des = eli_des;
	}

	public Date getEli_sys() {
		return eli_sys;
	}

	public void setEli_sys(Date eli_sys) {
		this.eli_sys = eli_sys;
	}

	public String getEli_tip() {
		return eli_tip;
	}

	public void setEli_tip(String eli_tip) {
		this.eli_tip = eli_tip;
	}

	public String getEli_dat() {
		return eli_dat;
	}

	public void setEli_dat(String eli_dat) {
		this.eli_dat = eli_dat;
	}

	public String getEli_usr() {
		return eli_usr;
	}

	public void setEli_usr(String eli_usr) {
		this.eli_usr = eli_usr;
	}

	
	
	
	
	

}
