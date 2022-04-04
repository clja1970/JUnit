package com.ejemploJunit.PruebasconJunit.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ejemploJunit.PruebasconJunit.model.Articulo;

@Service

public class BaseDatosImpl implements BaseDatosI{
	
	private Map<Integer, Articulo> basedatos;

	@Override
	public void iniciar() {
		basedatos = new HashMap<>();
		basedatos.put(1, new Articulo("camiseta", 20.00D));
		basedatos.put(2, new Articulo("pantalón", 21.99D));
		basedatos.put(3, new Articulo("jersey", 15.00D));
		basedatos.put(4, new Articulo("chaqueta", 35.00D));
		basedatos.put(5, new Articulo("falda", 40.00D));
	}

	@Override
	public Integer insertarArticulo(Articulo articulo) {
		// TODO Auto-generated method stub
		basedatos.put(basedatos.size()+1, articulo);
		
		return basedatos.size();
	}

	@Override
	public Articulo buscarArticulo(Integer identificador) {
		// TODO Auto-generated method stub
		
		return basedatos.get(identificador);
	}

	@Override
	public Double aplicarDescuento(Integer idArticulo, Double porcentaje) {
		// TODO Auto-generated method stub
		return null;
	}

}
