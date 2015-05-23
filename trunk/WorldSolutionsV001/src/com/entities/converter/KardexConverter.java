package com.entities.converter;

import java.util.ArrayList;
import java.util.List;

import com.entities.Kardex;
import com.entities.vo.KardexVo;

public class KardexConverter {

	public static List<KardexVo> aListKardexVo(List<Kardex> kardexs) {
		List<KardexVo> lista = new ArrayList<KardexVo>();
		KardexVo vo;
		if (kardexs != null && kardexs.size() > 0) {
			for (Kardex kardex : kardexs) {
				vo = new KardexVo(kardex);
				lista.add(vo);
			}
			return lista;
		}
		return null;
	}
	
}
