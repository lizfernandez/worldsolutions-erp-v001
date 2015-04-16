package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.entities.Perfil;
import com.entities.Permiso;
import com.interfaces.dao.IPerfilDao;
import com.util.Constantes;


public class PerfilDao extends GenericaDao implements IPerfilDao {
	@Override
	public List<Perfil> listaPerfil(int pagInicio, int pagFin, Perfil perfil) {
		Query q ;
		List<Perfil> listaPerfil = null ;
		String where="";
    	
		if(perfil!=null){
			if(perfil.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(perfil.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+perfil.getcEstadoCodigo()+"%'";
	        }
	        if(perfil.getcPerfilCodigo()!=null){
	        	where+=" and  p.cPerfilCodigo LIKE '%"+perfil.getcPerfilCodigo()+"%'";
	        }
	        if(perfil.getvPerfilDescripcion()!=null){
	        	where+=" and  p.vPerfilDescripcion LIKE '%"+perfil.getvPerfilDescripcion()+"%'";
	        }
	        System.out.println(" where ="+ where);
	    	    q = getInstancia().createQuery("select p from Perfil p " + where);/**/
	    	    q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	    	    listaPerfil = q.setFirstResult(pagInicio)
							  .setMaxResults(pagFin)
							  .getResultList(); 

			
		}// lista con busqueda
//		else{
//				q= getInstancia().createQuery("select p from Perfil p " +
//		    	   		                    " where p.cEstadoCodigo = :EstadoCodigo");
//				listaPerfil = q.setParameter("EstadoCodigo", Constantes.estadoActivo)
//												  .setFirstResult(pagInicio)
//												  .setMaxResults(pagFin)
//												  .getResultList(); 
//		 
//		}//else , lista simple	
		
        return listaPerfil;
	}

	@Override
	public List<Permiso> listaPermiso(int pagInicio, int pagFin) {
		Query q ;
		List<Permiso> listaPermiso = null ;
		q = getInstancia().createNativeQuery("select * from Permisos p  group by p.iUsuarioId ", Permiso.class )//
				//createQuery("select p from Permiso p group by p.usuario.iUsuarioId")//where SUBSTRING(p.vCodigoMenu,2,3)='0' group by p.usuario.iUsuarioId// 
				.setFirstResult(pagInicio)
				.setMaxResults(pagFin);
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		listaPermiso = q.getResultList();
		return listaPermiso;
	}

	@Override
	public List<Permiso> listaFindPermiso(int iUsuarioId) {
		Query q ;
		List<Permiso> listaPermiso = null ;
		q = getInstancia().createQuery("select p from Permiso p where p.usuario.iUsuarioId="+iUsuarioId +" order by p.vCodigoMenu asc");
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		listaPermiso = q.getResultList();
		return listaPermiso;
	}

	@Override
	public boolean callProcedurePermiso(int iUsuarioId, String vCodigoPermiso, int cantidad) {
		Query q ;
		boolean resultado = true;
	    EntityManager em =getInstancia();  
	    int theBalance = 0;  
	        try {  
	    EntityTransaction etx = em.getTransaction();  
	            etx.begin();  
	            q = em.createNativeQuery("{ CALL SP_IDU_PERFIL_PERMISOS(?,?,?) }")//createNamedQuery("SP_IDU_PERFIL_PERMISOS")           
	                    .setParameter(1, iUsuarioId)
	                    .setParameter(2, vCodigoPermiso)
	    		        .setParameter(3, cantidad);	 
	            q.executeUpdate();// SOBRA, el getSingleResult lo hace por el  
	           // theBalance = (Integer)q.getSingleResult();  
	            etx.commit();  
	        } catch (Exception ex) {  
	        	System.out.println("ex :"+ex);
	        	em= null;
	//            Logger.getLogger(StoredProcedureJpaController.class.getName()).log(Level.SEVERE, null, ex);  
	        }  
	    
		
		
		return resultado;
	}

	public static void main(String[] args) {
		PerfilDao dao = new PerfilDao();
		List<Permiso> permisos = dao.listaPermiso(1, 10);
		System.out.println("Lista: " + permisos.size());
		
	}
	
}
