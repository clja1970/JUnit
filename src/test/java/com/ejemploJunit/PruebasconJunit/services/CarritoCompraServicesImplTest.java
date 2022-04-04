package com.ejemploJunit.PruebasconJunit.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ejemploJunit.PruebasconJunit.model.Articulo;

@RunWith(MockitoJUnitRunner.class)

public class CarritoCompraServicesImplTest {
	
	
	
	@InjectMocks
	private CarritoCompraServicesImpl carritoCompraServicesImpl = new CarritoCompraServicesImpl();
	
	@Mock
	private BaseDatosI baseDatos;
	
	
	@Test
	public void testLimpiarCesta() {
		
		carritoCompraServicesImpl.addArticulo(new Articulo("Camiseta", 15.99D));
		assertFalse(carritoCompraServicesImpl.getArticulos().isEmpty());
		carritoCompraServicesImpl.limpiarCesta();
		assertTrue(carritoCompraServicesImpl.getArticulos().isEmpty());	
	}

	@Test
	public void testAddArticulo() {
		
		carritoCompraServicesImpl.addArticulo(new Articulo("camiseta", 18.00D));
		carritoCompraServicesImpl.addArticulo(new Articulo ("pantalón", 25.00));
		assertFalse(carritoCompraServicesImpl.getArticulos().isEmpty());
		
	}

	@Test
	public void testGetNumArticulos() {
		
		carritoCompraServicesImpl.addArticulo(new Articulo("camiseta", 18.00D));
		carritoCompraServicesImpl.addArticulo(new Articulo ("pantalón", 25.00));
		Integer otros = carritoCompraServicesImpl.getNumArticulos();
		assertEquals(Integer.valueOf(2), otros);
	}

	@Test
	public void testGetArticulos() {
		
		carritoCompraServicesImpl.addArticulo(new Articulo("camiseta", 18.00D));
		carritoCompraServicesImpl.addArticulo(new Articulo ("pantalón", 25.00));
		carritoCompraServicesImpl.addArticulo(new Articulo ("calcetines", 5.25));
		
		List <Articulo> otros  = carritoCompraServicesImpl.getArticulos();
		assertEquals("calcetines", otros.get(2).getNombre());
		assertEquals(3, otros.size());
		
	}

	@Test
	public void testTotalPrice() {
		carritoCompraServicesImpl.addArticulo(new Articulo("camiseta", 18.00D));
		carritoCompraServicesImpl.addArticulo(new Articulo ("pantalón", 25.00));
		carritoCompraServicesImpl.addArticulo(new Articulo ("calcetines", 5.25));
		
		Double otros = carritoCompraServicesImpl.totalPrice();
		assertEquals(Double.valueOf(48.25D), otros);
	}

	@Test
	public void testCalculadorDescuento() {
		assertEquals(Double.valueOf(80D), carritoCompraServicesImpl.calculadorDescuento(100D, 20D));
	}
	@Test
	public void testAplicarDescuento() {
		
		Articulo articulo = new Articulo("camiseta", 20.00);
		when(baseDatos.buscarArticulo(2)).thenReturn(articulo);
		Double resultado = carritoCompraServicesImpl.aplicarDescuento(2, 10D);
		assertEquals(Double.valueOf(18D),resultado);			
	}
	@Test
	public void testInsertar() {
			
		Articulo aDos = new Articulo("pantalón", 25.00);
		when(baseDatos.insertarArticulo(aDos)).thenReturn(1);
		Integer resultado = carritoCompraServicesImpl.insertarArticulos(aDos);
		assertEquals(Integer.valueOf(1), resultado);
		
		assertEquals(carritoCompraServicesImpl.getArticulos().get(0).getNombre(), "pantalón");
		
		//Para la base de datos
		
		verify(baseDatos, times(1)).insertarArticulo(aDos);
		//verify(baseDatos, times(1)).insertarArticulo(1);
	}
}
