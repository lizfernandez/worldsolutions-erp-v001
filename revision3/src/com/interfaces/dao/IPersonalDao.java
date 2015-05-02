package com.interfaces.dao;

import java.util.List;

import com.entities.Personal;

public interface IPersonalDao {
	public List<Personal> listaPersonal(int pagInicio, int pagFin, Personal personal);
/*	public Personal buscarPersonal(int iPersonalId);
	public boolean insertarPersonal(Personal Personal);
	public boolean actualizarPersonal(Personal Personal);
	public boolean eliminarPersonal(String iPersonalId);*/
}
