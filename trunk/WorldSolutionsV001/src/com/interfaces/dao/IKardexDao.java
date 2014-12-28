package com.interfaces.dao;

import java.util.List;

import com.entities.Kardex;
import com.entities.Librodiario;
import com.entities.Producto;

public interface IKardexDao {
	public List<Kardex> listaKardex(int pagInicio, int pagFin, Producto producto, String cInsumo);
	public Kardex buscarKardex(int iKardexId);
	public List<Kardex> buscarKardexProducto(int iProductoId);
	public List<Librodiario>  buscarLibroDiarioKardex(int iKardexId);
}
