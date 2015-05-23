package com.entities.converter;

import java.util.ArrayList;
import java.util.List;

import com.entities.Venta;
import com.entities.Ventadetalle;
import com.entities.vo.VentaVo;
import com.entities.vo.VentadetalleVo;

public class VentaConverter {

	public static List<VentadetalleVo> aListVentadetalleVo(List<Ventadetalle> ventadetalles) {
		List<VentadetalleVo> lista = new ArrayList<VentadetalleVo>();
		VentadetalleVo vo;
		if (ventadetalles != null && ventadetalles.size() > 0) {
			for (Ventadetalle ventadetalle : ventadetalles) {
				vo = new VentadetalleVo(ventadetalle);
				lista.add(vo);
			}
			return lista;
		}
		return null;
	}

	public static List<VentaVo> aListVentaVo(List<Venta> listaVenta) {
		List<VentaVo> list = new ArrayList<VentaVo>();
		VentaVo vo;
		if (listaVenta != null && listaVenta.size() > 0){
			for (Venta venta : listaVenta) {
				vo = new VentaVo(venta);
				list.add(vo);
			}
			return list;
			
		}		
		return null;
	}

}
