package com.interfaces.dao;

import java.util.List;

import com.entities.Almacen;
import com.entities.Empresa;
import com.entities.Sucursal;

public interface ISucursalDao {
	public List<Sucursal> listaSucursal(int pagInicio, int pagFin, Sucursal sucursal);
	public List<Empresa> listaEmpresa(int pagInicio, int pagFin, Empresa empresa);
	public List<Almacen> listaAlmacen(int pagInicio, int pagFin, Almacen almacen);
}
