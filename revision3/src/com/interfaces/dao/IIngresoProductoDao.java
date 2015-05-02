package com.interfaces.dao;

import java.util.List;

import com.entities.Ingresoproducto;
import com.entities.Ingresoproductodetalle;
import com.entities.Ingresoproductodevolucion;
import com.entities.Letraproveedor;

public interface IIngresoProductoDao {
	public List<Ingresoproducto> listaIngresoproducto(int pagInicio, int pagFin, Ingresoproducto ingresoproducto);
	public List<Ingresoproducto> listaEstadoCuentaPorProveedor(int pagInicio, int pagFin, Ingresoproducto ingresoproducto, int iProveedorId);
	public List<Ingresoproductodetalle>  buscarIngresoproductoDetalle(int iIngresoproductoId);	
	public List<Ingresoproductodevolucion> listaIngresoproductoDevolucion(int pagInicio, int pagFin, Ingresoproducto ingresoproductodev);
	public List<Letraproveedor> listaLetraProveedor(int pagInicio, int pagFin, Letraproveedor letraProveedor);
	
}
