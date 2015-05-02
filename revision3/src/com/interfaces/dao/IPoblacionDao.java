package com.interfaces.dao;

import java.util.List;

import com.entities.Poblacion;

public interface IPoblacionDao {
	public List<Poblacion> listaDepartamento();
	public List<Poblacion> listaProvincia(String codigoPoblacion);
	public List<Poblacion> listaDistrito(String codigoPoblacion);
	public Poblacion bucarPoblacion(String codigoPoblacion);
	
}
