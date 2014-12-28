package com.dao;

import java.util.List;

import javax.persistence.Query;

import com.entities.Estadocuentaproveedor;
import com.interfaces.dao.IEstadoCuentaProveedorDao;
import com.util.Constantes;
import com.util.Fechas;

public class EstadoCuentaProveedorDao extends GenericaDao implements IEstadoCuentaProveedorDao {
	
	@Override
	public List<Estadocuentaproveedor> listaEstadocuentaproveedor(int pagInicio, int pagFin, Estadocuentaproveedor estadoCuentaProveedor) {
		Query q ;
		List<Estadocuentaproveedor> listaEstadocuentaproveedor = null ;
		String where="";
    	
		if(estadoCuentaProveedor!=null){
			if(estadoCuentaProveedor.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(estadoCuentaProveedor.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+estadoCuentaProveedor.getcEstadoCodigo()+"%'";
	        }
	         System.out.println(" where ="+ where);
	    	    q = getInstancia().createQuery("select p.ingresoproducto from Estadocuentaproveedor p " +
	    	    		 " JOIN FETCH p.ingresoproducto "+
	    	             " JOIN FETCH p.proveedor " + where);/**/
	    	    
	    	    listaEstadocuentaproveedor = q.setFirstResult(pagInicio)
							  .setMaxResults(pagFin)
							  .getResultList(); 

			
		}// lista con busqueda
		else{
			 q = getInstancia().createQuery("select p.ingresoproducto from Estadocuentaproveedor p " +
    	    		 " JOIN FETCH p.ingresoproducto "+
    	             " JOIN FETCH p.proveedor " + where);/**/
    	    
    	    listaEstadocuentaproveedor = q.setFirstResult(pagInicio)
						  .setMaxResults(pagFin)
						  .getResultList(); 
				
		 
		}//else , lista simple	        
 			
		
        return listaEstadocuentaproveedor;
	}

	public List<Object[]> listaIngredoProducto(int pagInicio,
			int pagFin,Estadocuentaproveedor estadoCuentaProveedor) {
		Query q ;
		List<Object[]> listaIngresoProducto = null ;
		String where="";
    	System.out.println("ingresoProducto ="+estadoCuentaProveedor);
		if(estadoCuentaProveedor!=null){
			if(estadoCuentaProveedor.getProveedor().getcProveedorCodigo()!=null){
				where+= " and c.cProveedorCodigo= '"+estadoCuentaProveedor.getProveedor().getcProveedorCodigo()+"'";
			}
			if(estadoCuentaProveedor.getIngresoproducto().getnIngresoProductoNumero()!=null){
				where+= " and v.nIngresoProductoNumero= '"+estadoCuentaProveedor.getIngresoproducto().getnIngresoProductoNumero()+"'";
	        }
			if(estadoCuentaProveedor.getIngresoproducto().getdIngresoProductoFecha()!=null){
				where+= " and v.dIngresoProductoFecha= '"+Fechas.fechaYYMMDD(estadoCuentaProveedor.getIngresoproducto().getdIngresoProductoFecha())+"'";
			}
			if(estadoCuentaProveedor.getIngresoproducto().getfIngresoProductoTotal()>0){
				where+= " and v.fIngresoProductoTotal= '"+estadoCuentaProveedor.getIngresoproducto().getfIngresoProductoTotal()+"'";
			}
			if(estadoCuentaProveedor.getIngresoproducto().getTipodocumento().getiTipoDocumentoGestionId()>0){
				where+= " and v.iTipoDocumentoId= '"+estadoCuentaProveedor.getIngresoproducto().getTipodocumento().getiTipoDocumentoGestionId()+"'";
			}
			if(estadoCuentaProveedor.getIngresoproducto().getFormaPago().getiFormaPago()>0){
				where+= " and v.iFormaPagoId= '"+estadoCuentaProveedor.getIngresoproducto().getFormaPago().getiFormaPago()+"'";
			}
			
			String sql= "SELECT v.iProveedorId AS ID, " +
					" c.cProveedorCodigo AS CODIDO, "+
	         		" c.vProveedorRazonSocial AS NOMBRES, "+
                    " (SELECT count(iIngresoProductoId) FROM ingresoproducto WHERE iProveedorId = v.iProveedorId  and vEstadoDocumento ='"+Constantes.estadoDocumentoDeuda+"' and cEstadoCodigo ='"+Constantes.estadoActivo+"' ) AS NROFACTURAS,"+
                    " (SELECT SUM(fIngresoProductoTotal) FROM ingresoproducto WHERE iProveedorId = v.iProveedorId and vEstadoDocumento ='"+Constantes.estadoDocumentoDeuda+"' and cEstadoCodigo ='"+Constantes.estadoActivo+"') AS MOTOTALVENTA,"+
                    " (min(v.dIngresoProductoFecha)) AS FVENTA,sum(e.fMontoPago) AS MOTOTALPAGO,"+
                    " (max(e.dFechaPago))AS FPAGO ,"+
                    " v.vEstadoDocumento AS ESTADO"+
                    " FROM ingresoproducto v"+
                    " LEFT JOIN estadocuentaproveedor e"+
                    " ON( e.iIngresoProductoId=v.iIngresoProductoId)"+
                    " INNER JOIN Proveedor c"+
                    " ON(v.iProveedorId=c.iProveedorId)"+
                    " WHERE (v.vEstadoDocumento ='"+Constantes.estadoDocumentoDeuda+"' and v.cEstadoCodigo ='"+Constantes.estadoActivo+"' and e.cEstadoCodigo ='"+Constantes.estadoActivo+"')"+ where+
                    " GROUP BY vProveedorRazonSocial ";
			 System.out.println("sql= "+sql);
			 System.out.println("where =" +where);
			 
	    	    q = getInstancia().createNativeQuery(sql);

	    	    
	    	    listaIngresoProducto = q.getResultList(); 
	
		}// lista con busqueda
		
        return listaIngresoProducto;
	}
	
	@Override
	public Estadocuentaproveedor buscarEstadocuentaproveedor(int iEstadocuentaproveedorId) {
		          
		Estadocuentaproveedor obj = (Estadocuentaproveedor) getInstancia().find(Estadocuentaproveedor.class, iEstadocuentaproveedorId);			     
	
        return obj;
	}

	/*@Override
	public boolean insertarEstadocuentaproveedor(Estadocuentaproveedor estadoCuentaProveedor) {
		// TODO Auto-generated method stub
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		boolean resultado = false;
		
	try {
		em.getTransaction().begin();
		em.persist(estadoCuentaProveedor);
		em.getTransaction().commit();	
		em.refresh(estadoCuentaProveedor);
		//em.flush();
		resultado = true;
		
	} catch (TransactionRequiredException e) {
		e.printStackTrace();
		// TODO: handle exception
	} 			
   return resultado;
	}

	@Override
	public boolean actualizarEstadocuentaproveedor(Estadocuentaproveedor estadoCuentaProveedor) {
		// TODO Auto-generated method stub
				factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
				EntityManager em = factory.createEntityManager();
				boolean resultado = false;
				
			try {
				em.getTransaction().begin();
				em.merge(estadoCuentaProveedor);
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
	public boolean eliminarEstadocuentaproveedor(String iEstadocuentaproveedorId) {
		// TODO Auto-generated method stub
				factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
				EntityManager em = factory.createEntityManager();
				boolean resultado = false;
				
			try {
				
				  Query q = em.createQuery("Update Estadocuentaproveedor p SET p.cEstadoCodigo = :EstadoCodigo " +
			                    " where p.iEstadoCuentaProveedor IN ("+iEstadocuentaproveedorId+")")
			                    .setParameter("EstadoCodigo", Constantes.estadoInactivo);
					           // .setParameter("iEstadocuentaproveedorId", iEstadocuentaproveedorId) 

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
			}



*/	
}
