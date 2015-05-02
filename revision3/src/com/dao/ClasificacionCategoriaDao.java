package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.entities.Clasificacioncategoria;
import com.interfaces.dao.IClasificacionCategoriaDao;

public class ClasificacionCategoriaDao extends GenericaDao implements IClasificacionCategoriaDao {
	
	public List<Clasificacioncategoria> listClasificacioncategorias() {
		// TODO Auto-generated method stub

		Query q = getInstancia().createQuery("select c from Clasificacioncategoria c where c.cEstadoCodigo = 'AC'");
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		List<Clasificacioncategoria> listaClasificacioncategoria = q.getResultList();

		return listaClasificacioncategoria;
	}

}
