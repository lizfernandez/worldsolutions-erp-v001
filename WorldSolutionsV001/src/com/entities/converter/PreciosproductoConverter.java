package com.entities.converter;

import java.util.ArrayList;
import java.util.List;

import com.entities.Preciosproducto;
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

}
