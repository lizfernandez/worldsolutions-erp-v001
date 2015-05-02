package com.interfaces.dao;

import java.util.List;

import com.entities.Empresa;
import com.entities.Sucursal;

public interface ISucursalDao {
	public List<Sucursal> listaSucursal(int pagInicio, int pagFin, Sucursal sucursal);
	public List<Empresa> listaEmpresa(int pagInicio, int pagFin, Empresa empresa);
}
