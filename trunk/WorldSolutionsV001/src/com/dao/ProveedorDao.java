package com.dao;

import java.util.List;

import javax.persistence.Query;

import com.entities.Proveedor;
import com.interfaces.dao.IProveedorDao;
import com.util.Constantes;


public class ProveedorDao extends GenericaDao implements IProveedorDao {
	
	@Override
	public List<Proveedor> listaProveedor(int pagInicio, int pagFin, Proveedor proveedor) {
	     
		Query q ;
		List<Proveedor> listaProveedor = null ;
		String where="";
    	
		if(proveedor!=null){
			if(proveedor.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(proveedor.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+proveedor.getcEstadoCodigo()+"%'";
	        }
	        if(proveedor.getcProveedorCodigo()!=null){
	        	where+=" and  p.cProveedorCodigo LIKE '%"+proveedor.getcProveedorCodigo()+"%'";
	        }
	        if(proveedor.getvProveedorRazonSocial()!=null){
	        	where+=" and  p.vProveedorRazonSocial LIKE '%"+proveedor.getvProveedorRazonSocial()+"%'";
	        }
	        if(proveedor.getnProveedorNumeroDocumento()!=null){
	        	where+=" and  p.nProveedorNumeroDocumento LIKE '%"+proveedor.getnProveedorNumeroDocumento()+"%'";
	        }
	        if(proveedor.getvProveedorTelefono()!=null){
	        	where+=" and  p.vProveedorTelefono LIKE '%"+proveedor.getvProveedorTelefono()+"'";
	        }
	        if(proveedor.getvProveedorDireccion()!=null){
	        	where+=" and  p.vProveedorDireccion LIKE '%"+proveedor.getvProveedorDireccion()+"'";
	        }
	        if(proveedor.getiPoblacionId()!=null && !proveedor.getiPoblacionId().equals("00")){
	        	
	        	where+=" and  p.iPoblacionId= '"+proveedor.getiPoblacionId()+"'";
	        }
	       
	        System.out.println(" where ="+ where);
	    	    q = getInstancia().createQuery("select p from Proveedor p " + where);/**/
	    	    
	    	    listaProveedor = q.setFirstResult(pagInicio)
							  .setMaxResults(pagFin)
							  .getResultList(); 

			
		}// lista con busqueda
		else{
				q= getInstancia().createQuery("select p from Proveedor p " +
		    	   		                    " where p.cEstadoCodigo = :EstadoCodigo");
				listaProveedor = q.setParameter("EstadoCodigo", Constantes.estadoActivo)
												  .setFirstResult(pagInicio)
												  .setMaxResults(pagFin)
												  .getResultList(); 
		 
		}//else , lista simple	
		
        return listaProveedor;
	}

	/*@Override
	public Proveedor buscarProveedor(int iProveedorId) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();     
                 
		Proveedor proveedor = (Proveedor) em.find(Proveedor.class, iProveedorId);		     
	
        return proveedor;
	}

	@Override
	public boolean insertarProveedor(Proveedor proveedor) {
		// TODO Auto-generated method stub
				factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
				EntityManager em = factory.createEntityManager();
				boolean resultado = false;
				
			try {
				em.getTransaction().begin();
				em.persist(proveedor);
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
	public boolean actualizarProveedor(Proveedor proveedor) {
		// TODO Auto-generated method stub
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		boolean resultado = false;
		
	try {
		em.getTransaction().begin();
		em.merge(proveedor);
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
	public boolean eliminarProveedor(String iProveedorId) {
		// TODO Auto-generated method stub
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		boolean resultado = false;
		
	try {
		
		  Query q = em.createQuery("Update Proveedor p SET p.cEstadoCodigo = :EstadoCodigo " +
	                    " where p.iProveedorId IN ("+iProveedorId+")")
	                    .setParameter("EstadoCodigo", Constantes.estadoInactivo);
			           // .setParameter("iProveedorId", iProveedorId); 

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
