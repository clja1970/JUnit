package com.ejemploJunit.PruebasconJunit.services;

import org.springframework.stereotype.Service;

import com.ejemploJunit.PruebasconJunit.model.Articulo;
@Service
public interface BaseDatosI {

	public void iniciar();
	
	public Integer insertarArticulo(Articulo articulo);
	
	public Articulo buscarArticulo(Integer identificador);
	
	public Double aplicarDescuento(Integer idArticulo, Double porcentaje);
		
	
}
