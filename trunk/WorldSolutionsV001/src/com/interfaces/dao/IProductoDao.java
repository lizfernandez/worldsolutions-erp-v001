package com.interfaces.dao;

import java.util.List;

import com.entities.Distalmacen;
import com.entities.Ordencompra;
import com.entities.Produccion;
import com.entities.Producciondetalle;
import com.entities.Producto;

public interface IProductoDao {
	
	public List<Producto> listaProducto(int pagInicio, int pagFin, Producto producto, int iclasificacionId, int iSucursalId);
	public List<Producto> listaProductoStockMinimo(int pagInicio, int pagFin, int iclasificacionId);
	public List<Producto> listaProductoStockMaximo(int pagInicio, int pagFin, int iclasificacionId);
	
	public List<Produccion> listaProduccion(int pagInicio, int pagFin, Produccion produccion);
	public List<Producciondetalle> buscarDetalleProduccion(int iProduccionId);
	public List<Distalmacen> listaDistAlmacen (int pagInicio, int pagFin, Distalmacen distAlmacen);
	public List<Ordencompra> listaOrdenCompra (int pagInicio, int pagFin, Ordencompra ordencompra);
    
}
