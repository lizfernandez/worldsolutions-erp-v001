package com.interfaces.dao;

import java.text.ParseException;
import java.util.List;
import com.struts.form.EstadisticaForm;

public interface IEstadisticaDao {
	
	public List<Object[]> obtenerCompraEstadistica(EstadisticaForm objFom) throws ParseException;
	public List<Object[]> obtenerVentasEstadistica(EstadisticaForm objFom) throws ParseException;
	public List<Object[]> obtenerUtilidadesEstadistica(EstadisticaForm objFom)throws ParseException;
	public List<Object[]> obtenerEstadisticaMejoresClientes(EstadisticaForm objFom)throws ParseException;
	public List<Object[]> obtenerEstadisticaClientesDeudores(EstadisticaForm objFom)throws ParseException;
	
}
