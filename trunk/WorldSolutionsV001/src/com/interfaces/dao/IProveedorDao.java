package com.interfaces.dao;

import java.util.List;

import com.entities.Proveedor;

public interface IProveedorDao {
	public List<Proveedor> listaProveedor(int pagInicio, int pagFin, Proveedor proveedor);
/*	public Proveedor buscarProveedor(int iProveedorId);
	public boolean insertarProveedor(Proveedor proveedor);
	public boolean actualizarProveedor(Proveedor proveedor);
	public boolean eliminarProveedor(String iProveedorId);
*/	
}
