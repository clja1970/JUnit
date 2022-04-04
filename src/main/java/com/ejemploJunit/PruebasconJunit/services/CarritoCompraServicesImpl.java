package com.ejemploJunit.PruebasconJunit.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ejemploJunit.PruebasconJunit.model.Articulo;

public class CarritoCompraServicesImpl implements CarritoCompraServiceI{
	
	@Autowired
	private BaseDatosI baseDatos;

	private List<Articulo> cesta = new ArrayList<>();
	
	@Override
	
	public void limpiarCesta() {
		
		cesta.clear();
	}

	@Override
	public void addArticulo(Articulo articulo) {
		
		
		cesta.add(articulo);
		
	}

	@Override
	public Integer getNumArticulos() {
		
		
		return cesta.size();
	}

	@Override
	public List<Articulo> getArticulos() {
		
		return cesta;
	}

	@Override
	public Double totalPrice() {
		Double total = 0D;
		for (Articulo articulo: cesta) {
			total = total + articulo.getPrecio();
		}
		return total;
	}

	@Override
	public Double calculadorDescuento(Double precio, Double porcentaje) {
		
		return precio - precio * porcentaje/100;
	}
	public Double aplicarDescuento(Integer idArticulo, Double porcentaje) {
		
		baseDatos.iniciar();
		
		Articulo articulo = baseDatos.buscarArticulo(idArticulo);
		
		if(Optional.ofNullable(articulo).isPresent())
		{
			return calculadorDescuento(articulo.getPrecio(), porcentaje);
		}
		else {
			System.out.println("no se han encontrado el articulo con Id; " + idArticulo);
		}
		return 0D;	
	}
	public Integer insertarArticulos (Articulo articulo) {
		
		Integer idArticulo = baseDatos.insertarArticulo(articulo);
		cesta.add(articulo);
		return idArticulo;
	}
}
