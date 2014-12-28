package com.interfaces.dao;

import java.util.List;

import com.entities.Estadocuentaproveedor;

public interface IEstadoCuentaProveedorDao {
	public List<Estadocuentaproveedor> listaEstadocuentaproveedor(int pagInicio, int pagFin, Estadocuentaproveedor estadoCuentaProveedor);
	public Estadocuentaproveedor buscarEstadocuentaproveedor(int iEstadocuentaproveedorId);
	public List<Object[]> listaIngredoProducto(int pagInicio, int pagFin, Estadocuentaproveedor estadoCuentaProveedor);

}
