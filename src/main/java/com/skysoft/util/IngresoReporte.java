package com.skysoft.util;

public class IngresoReporte {
	
	private String codigo;
	private String descripcion;
	//private String proceso;
	private int cantidad;
	
	
	public IngresoReporte(String codigo, String descripcion, String proceso, int cantidad) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		//this.proceso = proceso;
		this.cantidad = cantidad;
	}


	public IngresoReporte() {		
		// TODO Auto-generated constructor stub
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


//	public String getProceso() {
//		return proceso;
//	}
//
//
//	public void setProceso(String proceso) {
//		this.proceso = proceso;
//	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
	
	

}
