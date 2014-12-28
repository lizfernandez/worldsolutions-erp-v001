package com.interfaces.dao;

import java.util.List;

import com.entities.Area;

public interface IAreaDao {
	public List<Area> listaArea(int pagInicio, int pagFin, Area area);
}
