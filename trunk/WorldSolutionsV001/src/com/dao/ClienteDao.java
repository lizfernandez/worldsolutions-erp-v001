package com.dao;

import java.util.List;

import javax.persistence.Query;

import com.entities.Cliente;
import com.interfaces.dao.IClienteDao;
import com.util.Constantes;


public class ClienteDao  extends GenericaDao implements IClienteDao {
	@Override
	public List<Cliente> listaCliente(int pagInicio, int pagFin, Cliente cliente) {
		Query q ;
		List<Cliente> listaCliente = null ;
		String where="";
    	
		if(cliente!=null){
			if(cliente.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }			
			if(cliente.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+cliente.getcEstadoCodigo()+"%'";
	        }
			if(cliente.getiClienteId()>0){
	        	where+= " and p.iClienteId = "+cliente.getiClienteId()+"";
	        }
	        if(cliente.getvClienteCodigo()!=null){
	        	where+=" and  p.cClienteCodigo LIKE '%"+cliente.getvClienteCodigo()+"%'";
	        }
	        if(cliente.getvClienteRazonSocial()!=null){
	        	where+=" and  p.vClienteRazonSocial LIKE '%"+cliente.getvClienteRazonSocial()+"%'";
	        }
	        if(cliente.getnClienteNumeroDocumento()!=null){
	        	where+=" and  p.nClienteNumeroDocumento LIKE '%"+cliente.getnClienteNumeroDocumento()+"%'";
	        }
	        if(cliente.getnClienteTelefono()!=null){
	        	where+=" and  p.nClienteTelefono LIKE '%"+cliente.getnClienteTelefono()+"'";
	        }
	        if(cliente.getDireccionclientes()!=null){
	        	where+=" and  p.direccionclientes.vDireccion LIKE '%"+cliente.getDireccionclientes().get(0).getvDireccion()+"'";
	        }
	        if(cliente.getDireccionclientes()!=null){
	        	where+=" and  p.direccionclientes.iPoblacionId= '"+cliente.getDireccionclientes().get(0).getiPoblacionId()+"'";
	        }
	       
	        System.out.println(" where ="+ where);
	    	    q = getInstancia().createQuery("select p from Cliente p " + where);/**/
	    	    
	    	    listaCliente = q.setFirstResult(pagInicio)
							  .setMaxResults(pagFin)
							  .getResultList(); 

			
		}// lista con busqueda
		else{
				q= getInstancia().createQuery("select p from Cliente p " +
		    	   		                    " where p.cEstadoCodigo = :EstadoCodigo");
				listaCliente = q.setParameter("EstadoCodigo", Constantes.estadoActivo)
												  .setFirstResult(pagInicio)
												  .setMaxResults(pagFin)
												  .getResultList(); 
		 
		}//else , lista simple	
		
        return listaCliente;
	}
/*
	@Override
	public Cliente buscarCliente(int iClienteId) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();     
                 
		Cliente cliente = (Cliente) em.find(Cliente.class, iClienteId);		     
	
        return cliente;
	}

	@Override
	public boolean insertarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
				factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
				EntityManager em = factory.createEntityManager();
				boolean resultado = false;
				
			try {
				em.getTransaction().begin();
				em.persist(cliente);
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
	public boolean insertarDireccionCliente(Direccioncliente cliente) {
		// TODO Auto-generated method stub
				factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
				EntityManager em = factory.createEntityManager();
				boolean resultado = false;
				
			try {
				em.getTransaction().begin();
				em.persist(cliente);
				em.getTransaction().commit();
				em.refresh(cliente);
				
			
				//em.flush();
				resultado = true;
				
			} catch (TransactionRequiredException e) {
				e.printStackTrace();
				// TODO: handle exception
			} 			
		   return resultado;
	}

	@Override
	public boolean actualizarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		boolean resultado = false;
		
	try {
		em.getTransaction().begin();
		em.merge(cliente);
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
	public boolean actualizarDireccionCliente(Direccioncliente cliente) {
		// TODO Auto-generated method stub
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		boolean resultado = false;
		
	try {
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
	//    em.refresh(cliente);
		
		
	
		//em.flush();
		 resultado = true;
		
	} catch (TransactionRequiredException e) {
		e.printStackTrace();
		
		// TODO: handle exception
	}
		
		
		return resultado;
	}

	@Override
	public boolean eliminarCliente(String iClienteId) {
		// TODO Auto-generated method stub
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		boolean resultado = false;
		
	try {
		
		  Query q = em.createQuery("Update Cliente p SET p.cEstadoCodigo = :EstadoCodigo " +
	                    " where p.iClienteId IN ("+iClienteId+")")
	                    .setParameter("EstadoCodigo", Constantes.estadoInactivo);
			           // .setParameter("iClienteId", iClienteId); 

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
	}
*/
}
