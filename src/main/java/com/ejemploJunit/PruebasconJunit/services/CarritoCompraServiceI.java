package com.ejemploJunit.PruebasconJunit.services;

import java.util.List;

import com.ejemploJunit.PruebasconJunit.model.Articulo;

public interface CarritoCompraServiceI {

	public void limpiarCesta();
	
	public void addArticulo(Articulo articulo);
	
	public Integer getNumArticulos();
	
	public List <Articulo> getArticulos();
	
	public Double totalPrice();
	
	public Double calculadorDescuento(Double precio, Double porcentaje);
	
	public Integer insertarArticulos (Articulo articulo);
}