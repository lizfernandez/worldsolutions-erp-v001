package com.interfaces.dao;

import java.util.List;

import com.entities.Sucursal;

public interface ISucursalDao {
	public List<Sucursal> listaSucursal(int pagInicio, int pagFin, Sucursal area);
}
