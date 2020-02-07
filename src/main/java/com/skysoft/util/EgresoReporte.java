package com.skysoft.util;

public class EgresoReporte {
	
	private String codigo;
	private String descripcion;
	private int cantidad;
	
	
	public EgresoReporte(String codigo, String descripcion, int cantidad) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
	}


	public EgresoReporte() {		
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


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
	
	

}
