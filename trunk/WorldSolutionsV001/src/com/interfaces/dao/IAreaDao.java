package com.interfaces.dao;

import java.util.List;

import com.entities.Area;
import com.entities.Unidadmedida;

public interface IAreaDao {
	public List<Area> listaArea(int pagInicio, int pagFin, Area area);
	public List<Unidadmedida> listaUnidadMedida(int pagInicio, int pagFin, Unidadmedida unidadmedida);
}
