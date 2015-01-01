package com.dao;

import java.util.List;

import javax.persistence.Query;

import com.entities.Clasificacioncategoria;
import com.interfaces.dao.IClasificacionCategoriaDao;

public class ClasificacionCategoriaDao extends GenericaDao implements IClasificacionCategoriaDao {
	
	public List<Clasificacioncategoria> listClasificacioncategorias() {
		// TODO Auto-generated method stub

		Query q = getInstancia().createQuery("select c from Clasificacioncategoria c where c.cEstadoCodigo = 'AC'");
		List<Clasificacioncategoria> listaClasificacioncategoria = q.getResultList();

		return listaClasificacioncategoria;
	}

}
