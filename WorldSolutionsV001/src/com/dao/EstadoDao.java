package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;


import com.entities.Estado;
import com.interfaces.dao.IEstadoDao;

public class EstadoDao implements IEstadoDao {
	private static final String PERSISTENCE_UNIT_NAME = "Stuct12";
	private static EntityManagerFactory factory;
	
	public List<Estado> listEstado() {
		// TODO Auto-generated method stub
		
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();     
                 
    	   Query q = em.createQuery("select c from Estado c");
    	   q.setHint(QueryHints.REFRESH, HintValues.TRUE);
			List<Estado> listaEstado = q.getResultList();      
		
        return listaEstado;
	}

}
