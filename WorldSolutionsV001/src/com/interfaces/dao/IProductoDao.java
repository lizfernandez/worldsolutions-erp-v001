package com.interfaces.dao;

import java.util.List;

import com.entities.Producto;

public interface IProductoDao {
	
	public List<Producto> listaProducto(int pagInicio, int pagFin, Producto producto, int iclasificacionId);
	/*public Producto buscarProducto(int iProductoId);
	public boolean insertarProducto(Producto producto);
	public boolean actualizarProducto(Producto producto);
	public boolean eliminarProducto(String iProductoId);
*/	
    
}
