package com.entities.converter;

import java.util.ArrayList;
import java.util.List;

import com.entities.Direccioncliente;
import com.entities.Estadocuentacliente;
import com.entities.Visitacliente;
import com.entities.vo.DireccionclienteVo;
import com.entities.vo.EstadocuentaclienteVo;
import com.entities.vo.VisitaclienteVo;

public class ClienteConverter {

	public static List<DireccionclienteVo> aListDireccionVo(List<Direccioncliente> direccionclientes) {
		List<DireccionclienteVo> lista = new ArrayList<DireccionclienteVo>();
		DireccionclienteVo vo;
		
		if (direccionclientes != null && direccionclientes.size() > 0) {
			
			for (Direccioncliente entidad : direccionclientes) {
				vo = new DireccionclienteVo(entidad);
				lista.add(vo);
			}
			return lista;
			
		}
		
		return null;
	}

	public static List<VisitaclienteVo> aListVisitaclienteVo(List<Visitacliente> visitaCliente) {
		List<VisitaclienteVo> lista = new ArrayList<VisitaclienteVo>();
		VisitaclienteVo vo;
		
		if (visitaCliente != null && visitaCliente.size() > 0) {
			
			for (Visitacliente entidad : visitaCliente) {
				vo = new VisitaclienteVo(entidad);
				lista.add(vo);
			}
			return lista;
			
		}
		
		return null;
	}

	public static List<EstadocuentaclienteVo> aListEstadocuentaclienteVo(List<Estadocuentacliente> estadocuentaclientes) {
		List<EstadocuentaclienteVo> lista = new ArrayList<EstadocuentaclienteVo>();
		EstadocuentaclienteVo vo;
		
		if (estadocuentaclientes != null && estadocuentaclientes.size() > 0) {
			
			for (Estadocuentacliente entidad : estadocuentaclientes) {
				vo = new EstadocuentaclienteVo(entidad);
				lista.add(vo);
			}
			return lista;
			
		}
		
		return null;
	}


}
