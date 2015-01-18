package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.entities.Usuario;
import com.interfaces.dao.IUsuarioDao;
import com.util.Constantes;

public class UsuarioDao extends GenericaDao implements IUsuarioDao {
	
	@Override
	public List<Usuario> listaUsuario(int pagInicio, int pagFin, Usuario usuario) {
		Query q ;
		List<Usuario> listaUsuario = null ;
		String where="";
    	
		if(usuario!=null){
			if(usuario.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(usuario.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+usuario.getcEstadoCodigo()+"%'";
	        }
	        if(usuario.getcUsuarioCodigo()!=null){
	        	where+=" and  p.cUsuarioCodigo LIKE '%"+usuario.getcUsuarioCodigo()+"%'";
	        }
	        if(usuario.getvUsuarioLogin()!=null){
	        	where+=" and  p.vUsuarioLogin LIKE '%"+usuario.getvUsuarioLogin()+"%'";
	        }
	        if(usuario.getPersonal()!=null && usuario.getPersonal().getiPersonalId()>0){
	        	where+=" and  p.personal.iPersonalId LIKE '%"+usuario.getPersonal().getiPersonalId()+"%'";
	        }
	        if(usuario.getPerfil()!=null && usuario.getPerfil().getiPerfilId()>0){
	        	where+=" and  p.perfil.iPerfilId LIKE '%"+usuario.getPerfil().getiPerfilId()+"%'";
	        }
	        System.out.println(" where ="+ where);
	    	    q = getInstancia().createQuery("select p from Usuario p " + where);/**/
	    	    q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	    	    listaUsuario = q.setFirstResult(pagInicio)
							  .setMaxResults(pagFin)
							  .getResultList(); 

			
		}// lista con busqueda
		
		
        return listaUsuario;
	}

	/*@Override
	public Usuario buscarUsuario(int iUsuarioId) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();     
                 
		Usuario obj = (Usuario) em.find(Usuario.class, iUsuarioId);			     
	
        return obj;
	}

	@Override
	public boolean insertarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		boolean resultado = false;
		
	try {
		em.getTransaction().begin();
		em.persist(usuario);
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
	public boolean actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
				factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
				EntityManager em = factory.createEntityManager();
				boolean resultado = false;
				
			try {
				em.getTransaction().begin();
				em.merge(usuario);
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
	public boolean eliminarUsuario(String iUsuarioId) {
		// TODO Auto-generated method stub
				factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
				EntityManager em = factory.createEntityManager();
				boolean resultado = false;
				
			try {
				
				  Query q = em.createQuery("Update Usuario p SET p.cEstadoCodigo = :EstadoCodigo " +
			                    " where p.iUsuarioId IN ("+iUsuarioId+")")
			                    .setParameter("EstadoCodigo", Constantes.estadoInactivo);
					           // .setParameter("iUsuarioId", iUsuarioId) 

		       em.getTransaction().begin();
		       int x= q.executeUpdate();       
		       em.getTransaction().commit();
			
				//em.flush();
		       System.out.println(" int x ="+x);
				 resultado = true;
				
			} catch (TransactionRequiredException e) {
				e.printStackTrace();
				
				// TODO: handle exception
			}
				
				
				return resultado;
			}*/

	@Override
	public List<Usuario> login(String usuario, String pass, String dni) {
		Query q ;
		String cadena = "";
		if(dni!=""){
			cadena = " and p.personal.nPersonalNumeroDocumento='"+dni+"'";
		}
		else{
			cadena = " and p.vUsuarioPassword='"+pass+"'";
		}
		List<Usuario> usua = new ArrayList<Usuario>();
		q= getInstancia().createQuery("select p from Usuario p " +
                   " where p.vUsuarioLogin ='"+usuario+"'"+cadena);
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
        usua =  (List<Usuario>) q.getResultList(); 
		return usua;
	}

	
	
}
