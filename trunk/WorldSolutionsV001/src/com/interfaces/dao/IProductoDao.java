package com.interfaces.dao;

import java.util.List;

import com.entities.Produccion;
import com.entities.Producciondetalle;
import com.entities.Producto;

public interface IProductoDao {
	
	public List<Producto> listaProducto(int pagInicio, int pagFin, Producto producto, int iclasificacionId);
	public List<Producto> listaProductoStockMinimo(int pagInicio, int pagFin, int iclasificacionId);
	public List<Produccion> listaProduccion(int pagInicio, int pagFin, Produccion produccion);
	public List<Producciondetalle> buscarDetalleProduccion(int iProduccionId);
	/*public Producto buscarProducto(int iProductoId);
	public boolean insertarProducto(Producto producto);
	public boolean actualizarProducto(Producto producto);
	public boolean eliminarProducto(String iProductoId);
*/	
    
}
