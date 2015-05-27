package com.entities.converter;

import java.util.ArrayList;
import java.util.List;

import com.entities.Preciosproducto;
import com.entities.Producto;
import com.entities.vo.PreciosproductoVo;

public class PreciosproductoConverter {

	public static List<PreciosproductoVo> aListPreciosproductoVo(List<Preciosproducto> preciosproductodetallles) {
		List<PreciosproductoVo> list = new ArrayList<PreciosproductoVo>();
		PreciosproductoVo vo;
		if (preciosproductodetallles != null && preciosproductodetallles.size() > 0) {
			for (Preciosproducto preciosproducto : preciosproductodetallles) {
				vo = new PreciosproductoVo(preciosproducto);
				list.add(vo);
			}
			return list;
		}
		
		return null;
	}

	public static List<Preciosproducto> aListEntidad(List<PreciosproductoVo> preciosproductodetallles, Producto producto) {
		List<Preciosproducto> list = new ArrayList<Preciosproducto>();
		Preciosproducto entidad;
		if (preciosproductodetallles != null && preciosproductodetallles.size() > 0) {
			for (PreciosproductoVo vo : preciosproductodetallles) {
				entidad = new Preciosproducto(vo, producto);
				list.add(entidad);
			}
			return list;
		}
		
		return null;
	}

}
