package com.interfaces.dao;

import java.util.List;


import com.entities.Ventadetalle;
import com.entities.Ventadevolucion;
import com.entities.Venta;
import com.entities.vo.VentaVo;


public interface IVentaDao {
	public List<Venta> listaVenta(int pagInicio, int pagFin, Venta venta);
	public List<Venta> listaVenta(int pagInicio, int pagFin, VentaVo venta);
	public List<Venta> listaEstadoCuentaPorCliente(int pagInicio, int pagFin, Venta venta, int iClienteId);
	public List<Ventadevolucion> listaVentaDevolucion(int pagInicio, int pagFin, Venta venta);
	public List<Ventadevolucion> listaVentaDevolucion(int pagInicio, int pagFin, VentaVo venta);
	public List<Ventadetalle>  buscarVentaDetalle(int iVentaId);
	public List<Venta> listaEstadoCuentaPorCliente(int pagInicio, int pagFin, VentaVo venta, int iClienteId);

	

	
	
}
