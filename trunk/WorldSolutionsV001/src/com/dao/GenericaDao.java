package com.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.interfaces.dao.IGenerica;
import com.util.Constantes;

public class GenericaDao  implements IGenerica{
	private static final String PERSISTENCE_UNIT_NAME = "Stuct12";
	//private static EntityManagerFactory factory;
	private static EntityManager em;
	boolean resultado = true;
	
	@Override
	public EntityManager getInstancia() {
		if(em == null) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			em = factory.createEntityManager();
		}
		return em;
	}
	public EntityManager setIntancia(){
		em=null;
		return em;
	}
    public EntityTransaction entityTransaction() {
		EntityTransaction trx = null;
		if(trx == null) {
			trx = getInstancia().getTransaction();			
		}
		return trx;
	}
	
	public <E> Long totalLista(E entidad) {
		Query q = getInstancia().createQuery("select Count(p) from "+entidad.getClass().getSimpleName()+" p " +
                   " where p.cEstadoCodigo = :EstadoCodigo");
		Long total = (Long) q.setParameter("EstadoCodigo", Constantes.estadoActivo)
				  .getSingleResult(); 
		return total;
	}


	@Override
	public <G> List<G> listaEntidadGenerica(G entidad) {
		
			Query q =  getInstancia().createQuery("select p from "+ entidad.getClass().getSimpleName() +"  p"+
                   " where p.cEstadoCodigo = :EstadoCodigo");
		List<G> lita = q.setParameter("EstadoCodigo", Constantes.estadoActivo)
				  .getResultList(); 
		return lita;
	}
	@Override
	public <G> List<G> listaEntidadGenericaSinCodigo(String entidad) {
		Query q =  getInstancia().createQuery("select p from "+entidad +"  p");
		List<G> lita = q.getResultList(); 
		return lita;
	}


	@Override
	public <E> E findEndidad(E entidad, int iEntidadId) {
		E lita = (E) getInstancia().find(entidad.getClass(), iEntidadId);		
		return lita;
	}
	@Override
	public  boolean commitEndidad(EntityTransaction ext) {
		boolean resultado = true;
		try
	    {
	           ext.commit();
	          // ext= null;
	    }
	    catch (Exception re)
	    {
	    	resultado = false;
	        if (ext.isActive()){
	        	ext.rollback();
	        	//resultado = false;
	        	}  // or could attempt to fix error and retry
	        re.printStackTrace();
	    }
		finally{
			ext= null;
			//em=null;
		}
		return resultado;
	   
	}
	@Override
	public <E> void persistEndidad(E entidad) {
			getInstancia().persist(entidad);
	   
	}
	@Override
	public <E> boolean insertarUnaEndidad(E entidad) {
		// TODO Auto-generated method stub
		EntityTransaction ext = entityTransaction();
		ext.begin();
		getInstancia().persist(entidad);			
		resultado = commitEndidad(ext);
		
	   return resultado;
	}
	@Override
	public <E> void refreshEndidad(E entidad) {	
			getInstancia().refresh(entidad);
			em=null;

	}
	@Override
	public <E> void mergeEndidad(E entidad) {
		getInstancia().merge(entidad);		
	}
	
	@Override
	public <E> boolean actualizarUnaEndidad(E entidad) {
		EntityTransaction ext = entityTransaction();
		ext.begin();
			getInstancia().merge(entidad);
			resultado = commitEndidad(ext);	   
		return resultado;
	}
	@Override
	public <E> void eliminarUnaEndidad(E entidad, String sEntidadId,
			String iEntidadId) {
		Query q ;
		  q=  getInstancia().createQuery("Update "+entidad.getClass().getSimpleName()+" p SET p.cEstadoCodigo = :EstadoCodigo " +
		                    " where p."+sEntidadId+" IN ("+iEntidadId+")")
		                    .setParameter("EstadoCodigo", Constantes.estadoInactivo);
		    q.executeUpdate();
	}

	@Override
	public <E> String callSPCalculoCodigo(E entidad) {
		// TODO Auto-generated method stub
		Query q ;		
	   
	   String codigoGenerado = "";  
	   EntityTransaction ext = entityTransaction();
	   ext.begin();
	  
	            q = getInstancia().createNativeQuery("{ CALL SP_CALCULO_CODIGO(?) }")//createNamedQuery("SP_IDU_PERFIL_PERMISOS")           
	                    .setParameter(1, entidad.getClass().getSimpleName());	                   	 
	            //q.executeUpdate();// SOBRA, el getSingleResult lo hace por el  
	            codigoGenerado = (String)q.getSingleResult(); 	           
	            resultado= commitEndidad(ext); 
	        
		return codigoGenerado;
	}

	@Override
	public  int callSPPeriodoActual() {
	
		Query q ;		
	   
	    int  iPeriodoId = 0; 
	    EntityTransaction ext = entityTransaction();
		ext.begin();
		  
	             q = em.createNativeQuery("{ CALL SP_PERIODO_ACTUAL() }");	                   	 
	            //q.executeUpdate();// SOBRA, el getSingleResult lo hace por el  
	            iPeriodoId = (Integer)q.getSingleResult(); 	          
	            resultado= commitEndidad(ext); 
		return iPeriodoId;
	}
}




	



