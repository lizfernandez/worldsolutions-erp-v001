package com.dao;

import java.util.List;

import javax.persistence.Query;

import com.entities.Unidadmedida;
import com.interfaces.dao.IUnidadMedidaDao;

public class UnidadMedidaDao extends GenericaDao implements IUnidadMedidaDao {
	
 public List<Unidadmedida> listaUnidadMedida() {
	              
    	   Query q = getInstancia().createQuery("select u from Unidadmedida u");
			List<Unidadmedida> listaUnidadMedida = q.getResultList();      
		
        return listaUnidadMedida;
	}
	/*@Override
	public Unidadmedida buscarUnidadMedida(int iUnidadMedidaId) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();     
                 
		Unidadmedida obj = (Unidadmedida) em.find(Unidadmedida.class, iUnidadMedidaId);			     
	
        return obj;
	}
*/

}
