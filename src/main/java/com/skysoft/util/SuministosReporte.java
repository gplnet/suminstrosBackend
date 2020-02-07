package com.skysoft.util;

public class SuministosReporte {
	
	private String codigo;
	private String color;
	private int cantidad;
	private String modelo;
	
	
	public SuministosReporte(String codigo, String color, int cantidad, String modelo) {
		super();
		this.codigo = codigo;
		this.color = color;
		this.cantidad = cantidad;
		this.modelo = modelo;
	}


	public SuministosReporte() {		
		// TODO Auto-generated constructor stub
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	
	
	
	
	

}
