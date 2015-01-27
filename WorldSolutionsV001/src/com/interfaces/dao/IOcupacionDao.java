package com.interfaces.dao;

import java.util.List;

import com.entities.Ocupacion;

public interface IOcupacionDao {
	public List<Ocupacion> listaOcupacion(int pagInicio, int pagFin, Ocupacion area);
}
