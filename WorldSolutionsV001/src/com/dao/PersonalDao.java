package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.entities.Personal;
import com.interfaces.dao.IPersonalDao;
import com.util.Constantes;

public class PersonalDao extends GenericaDao implements IPersonalDao {
	private static final String PERSISTENCE_UNIT_NAME = "Stuct12";
	private static EntityManagerFactory factory;
	
	@Override
	public List<Personal> listaPersonal(int pagInicio, int pagFin,Personal personal) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();   	  
		Query q ;
		List<Personal> listapersonal = null ;
		String where="";
    	
		if(personal!=null){
			if(personal.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(personal.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+personal.getcEstadoCodigo()+"%'";
	        }
	        if(personal.getcPersonalCodigo()!=null){
	        	where+=" and  p.cPersonalCodigo LIKE '%"+personal.getcPersonalCodigo()+"%'";
	        }
	        if(personal.getvPersonalNombres()!=null){
	        	where+=" and  p.vPersonalNombres LIKE '%"+personal.getvPersonalNombres()+"%'";
	        }
	        if(personal.getvPersonalApellidoMaterno()!=null){
	        	where+=" and  p.vPersonalApellidoMaterno LIKE '%"+personal.getvPersonalApellidoMaterno()+"%'";
	        }
	        if(personal.getvPersonalApellidoPaterno()!=null){
	        	where+=" and  p.vPersonalApellidoPaterno LIKE '%"+personal.getvPersonalApellidoPaterno()+"%'";
	        }
	        if(personal.getTipodocumento()!=null && personal.getTipodocumento().getiTipoDocumentoId()>0){
	        	where+=" and  p.tipodocumento.iTipoDocumentoId="+personal.getTipodocumento().getiTipoDocumentoId();
	        }
	        if(personal.getnPersonalNumeroDocumento()!=null){
	        	where+=" and  p.nPersonalNumeroDocumento LIKE '%"+personal.getnPersonalNumeroDocumento()+"%'";
	        }
	        if(personal.getArea()!=null && personal.getArea().getiAreaId()>0){
	        	where+=" and  p.area.iAreaId="+personal.getArea().getiAreaId();
	        }
	        if(personal.getiSexoId()>0){
	        	where+=" and  p.iSexoId="+personal.getiSexoId();
	        }
	        System.out.println(" where ="+ where);
	    	    q = em.createQuery("select p from Personal p " + where);/**/
	    	    q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	    	    listapersonal = q.setFirstResult(pagInicio)
							  .setMaxResults(pagFin)
							  .getResultList(); 

			
		}// lista con busqueda
		else{
				q= em.createQuery("select p from Personal p " +
		    	   		                    " where p.cEstadoCodigo = :EstadoCodigo");
				q.setHint(QueryHints.REFRESH, HintValues.TRUE);
				listapersonal = q.setParameter("EstadoCodigo", Constantes.estadoActivo)
												  .setFirstResult(pagInicio)
												  .setMaxResults(pagFin)
												  .getResultList(); 
		 
		}//else , lista simple	       
    			
        return listapersonal;
	}
	
	/*
	@Override
	public boolean insertarPersonal(Personal personal) {
		// TODO Auto-generated method stub
				factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
				EntityManager em = factory.createEntityManager();
				boolean resultado = false;
				
			try {
				em.getTransaction().begin();
				em.persist(personal);
				em.getTransaction().commit();
				
			
				//em.flush();
				resultado = true;
				
			} catch (TransactionRequiredException e) {
				e.printStackTrace();
				// TODO: handle exception
			} 			
		   return resultado;
	}

	@Override
	public boolean actualizarPersonal(Personal personal) {
		// TODO Auto-generated method stub
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		boolean resultado = false;
		
	try {
		em.getTransaction().begin();
		em.merge(personal);
		em.getTransaction().commit();
		
	
		//em.flush();
		 resultado = true;
		
	} catch (TransactionRequiredException e) {
		e.printStackTrace();
		
		// TODO: handle exception
	}
		
		
		return resultado;
	}

	@Override
	public boolean eliminarPersonal(String iPersonalId) {
		// TODO Auto-generated method stub
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		boolean resultado = false;
		
	try {
		
		  Query q = em.createQuery("Update Personal p SET p.cEstadoCodigo = :EstadoCodigo " +
	                    " where p.iPersonalId IN ("+iPersonalId+")")
	                    .setParameter("EstadoCodigo", Constantes.estadoInactivo);
			            

       em.getTransaction().begin();
       int x= q.executeUpdate();       
       em.getTransaction().commit();
	
		//em.flush();
       
		 resultado = true;
		
	} catch (TransactionRequiredException e) {
		e.printStackTrace();
		
		// TODO: handle exception
	}
		
		
		return resultado;
	}*/

}
