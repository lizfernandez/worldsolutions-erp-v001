package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.entities.Poblacion;
import com.interfaces.dao.IPoblacionDao;

public class PoblacionDao extends GenericaDao implements IPoblacionDao {
	
	@Override
	public List<Poblacion> listaDepartamento() {
		Query q = getInstancia().createQuery("select p from Poblacion p where SUBSTRING(p.cCodigo,3,4)='0000'" +
				                 " ORDER BY  p.vDescripcion asc"); 
		System.out.println("departemento 2");
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		List<Poblacion> lita = q.getResultList(); 
		
		return lita;
	}

	@Override
	public List<Poblacion> listaProvincia(String codigoPoblacion) {
		Query q = getInstancia().createQuery("select p from Poblacion p where SUBSTRING(p.cCodigo,1,2)= '"+codigoPoblacion+"'" +
				" AND SUBSTRING(p.cCodigo,5,2)='00' "+
                " AND SUBSTRING(p.cCodigo,3,2)!='00' "+
                "ORDER BY  p.vDescripcion asc;");                   
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		List<Poblacion> lita = q.getResultList(); 
		return lita;
	}

	@Override
	public List<Poblacion> listaDistrito(String codigoPoblacion) {
		Query q = getInstancia().createQuery("select p from Poblacion p where SUBSTRING(p.cCodigo,1,4)='"+codigoPoblacion+"'"+
				" AND SUBSTRING(p.cCodigo,5,2)!='00'"+
                " ORDER BY p.vDescripcion asc");                   
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		List<Poblacion> lita = q.getResultList(); 
		return lita;
	}
	
	@Override
	public Poblacion bucarPoblacion(String codigoPoblacion) {
		Query q = getInstancia().createQuery("select p from Poblacion p where p.cCodigo ='"+codigoPoblacion+"'");                   
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		Poblacion lita = (Poblacion) q.getSingleResult(); 
		return lita;
	}

}
