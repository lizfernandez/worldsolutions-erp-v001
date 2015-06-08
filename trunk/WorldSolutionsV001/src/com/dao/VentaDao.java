package com.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.entities.Venta;
import com.entities.Ventadetalle;
import com.entities.Ventadevolucion;
import com.entities.vo.VentaVo;
import com.interfaces.dao.IVentaDao;
import com.util.Constantes;
import com.util.Fechas;

public class VentaDao  extends GenericaDao  implements IVentaDao {
	private static final String PERSISTENCE_UNIT_NAME = "Stuct12";
	private static EntityManagerFactory factory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Venta> listaVenta(int pagInicio, int pagFin, Venta venta) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();     
		Query q ;
		List<Venta> listaVenta = null ;
		String where="";
    	
		if(venta!=null){
			if(venta.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(venta.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+venta.getcEstadoCodigo()+"%'";
	        }
			if(venta.getiVentaId()>0){
	        	where+= " and p.iVentaId= "+venta.getiVentaId()+"";
	        }
			if(venta.getCliente()!=null && venta.getCliente().getvClienteCodigo()!=null){
	        	where+= " and p.cliente.vClienteCodigo LIKE '%"+venta.getCliente().getvClienteCodigo()+"%'";
	        }
			if(venta.getCliente()!=null && venta.getCliente().getvClienteRazonSocial()!=null){
	        	where+= " and p.cliente.vClienteRazonSocial LIKE '%"+venta.getCliente().getvClienteRazonSocial()+"%'";
	        }
			if(venta.getFormaPago()!=null && venta.getFormaPago().getiFormaPago()!=00){
	        	where+= " and p.formaPago.iFormaPago='"+venta.getFormaPago().getiFormaPago()+"'";
	        }
			if(venta.getTipoDocumento()!=null && venta.getTipoDocumento().getiTipoDocumentoGestionId()!=00){
	        	where+= " and p.tipoDocumento.iTipoDocumentoGestionId='"+venta.getTipoDocumento().getiTipoDocumentoGestionId()+"'";
	        }
			if(venta.getfVentaTotal()>0.0){
	        	where+= " and p.fVentaTotal>='"+venta.getfVentaTotal()+"'";
	        }
			if(venta.getnVentaNumero()!=null){
	        	where+= " and p.nVentaNumero LIKE '%"+venta.getnVentaNumero()+"%'";
	        }
			if(venta.getdVentaFecha()!=null && venta.getdFechaActualiza()!=null){
	        	where+= " and p.dVentaFecha BETWEEN '"+Fechas.fechaYYMMDD(venta.getdVentaFecha())+"' and '"+Fechas.fechaYYMMDD(venta.getdFechaActualiza())+"'";
	        } else if(venta.getdVentaFecha() != null) {
	        	where+= " and p.dVentaFecha = '"+Fechas.fechaYYMMDD(venta.getdVentaFecha())+"'";
	        }
			if (venta.getUsuario() != null) {
				where+= " and p.usuario.iUsuarioId = '"+venta.getUsuario().getiUsuarioId()+"'";
			}
			
			if (venta.getSucursal() != null) {
				where+= " and p.sucursal.iSucursalId = '"+venta.getSucursal().getiSucursalId() +"'";
			}
			
			
	          System.out.println(" where ="+ where);
	    	    q = em.createQuery("select p from Venta p " + where +" order by p.dVentaFecha desc");/**/
	    	    q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	    	    listaVenta = q.setFirstResult(pagInicio)
							  .setMaxResults(pagFin)
							  .getResultList(); 

			
		}// lista con busqueda
//		else{
//				q= em.createQuery("select p from Venta p " +
//		    	   		                    " where p.cEstadoCodigo = :EstadoCodigo");
//				listaVenta = q.setParameter("EstadoCodigo", Constantes. estadoActivo)
//												  .setFirstResult(pagInicio)
//												  .setMaxResults(pagFin)
//												  .getResultList(); 
//				
//		 
//		}//else , lista simple	        
 			
		
        return listaVenta;
	}
    
	@Override
	public List<Venta> listaEstadoCuentaPorCliente(int pagInicio, int pagFin, Venta venta, int iClienteId) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();     
		Query q ;
		List<Venta> listaVenta = null ;
		String where="";
    	
		if(venta!=null){
			if(venta.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(venta.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+venta.getcEstadoCodigo()+"%'";
	        }
//			if(venta.getvEstadoDocumento()==null){
//	        	where+= " and p.vEstadoDocumento LIKE '%"+Constantes.estadoDocumentoDeuda+"%'";
//	        }
			if(venta.getvEstadoDocumento()!=null){
	        	where+= " and p.vEstadoDocumento LIKE '%"+venta.getvEstadoDocumento()+"%'";
	        }
			if(venta.getCliente()!=null && venta.getCliente().getvClienteCodigo()!=null){
	        	where+= " and p.cliente.vClienteCodigo LIKE '%"+venta.getCliente().getvClienteCodigo()+"%'";
	        }
			if(venta.getCliente()!=null && venta.getCliente().getvClienteRazonSocial()!=null){
	        	where+= " and p.cliente.vClienteRazonSocial LIKE '%"+venta.getCliente().getvClienteRazonSocial()+"%'";
	        }
			if(venta.getFormaPago()!=null && venta.getFormaPago().getiFormaPago()!=00){
	        	where+= " and p.formaPago.iFormaPago="+venta.getFormaPago().getiFormaPago();
	        } else {
	        	where+= " and p.formaPago.vFormaPagoDescripcion LIKE '%"+Constantes.formaPagoCredito + "%'";
	        }
			if(venta.getTipoDocumento()!=null && venta.getTipoDocumento().getiTipoDocumentoGestionId()!=00){
	        	where+= " and p.tipoDocumento.iTipoDocumentoGestionId='"+venta.getTipoDocumento().getiTipoDocumentoGestionId()+"'";
	        }
			if(venta.getfVentaTotal()>0.0){
	        	where+= " and p.fVentaTotal>='"+venta.getfVentaTotal()+"'";
	        }
			if(venta.getnVentaNumero()!=null){
	        	where+= " and p.nVentaNumero LIKE '%"+venta.getnVentaNumero()+"%'";
	        }
			if(venta.getdVentaFecha()!=null && venta.getdFechaActualiza()!=null){
	        	where+= " and p.dVentaFecha BETWEEN '"+Fechas.fechaYYMMDD(venta.getdVentaFecha())+"' and '"+Fechas.fechaYYMMDD(venta.getdFechaActualiza())+"'";
	        }

			if (venta.getSucursal() != null) {
				where+= " and p.sucursal.iSucursalId = '"+venta.getSucursal().getiSucursalId() +"'";
			}
	          System.out.println(" where ingreso Producto Estado Cuenta ="+ where);
	    	    q = em.createQuery("select p from Venta p " +
	    	    				   " JOIN FETCH p.cliente " + where);/**/
	    	    q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	    	    listaVenta = q.setFirstResult(pagInicio)
							  .setMaxResults(pagFin)
							  .getResultList(); 

			
		}// lista con busqueda
		
		
        return listaVenta;
	}
	
	@Override
	public List<Venta> listaEstadoCuentaPorCliente(int pagInicio, int pagFin, VentaVo venta, int iClienteId) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();     
		Query q ;
		List<Venta> listaVenta = null ;
		String where="";
    	
		if(venta!=null){
			if(venta.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(venta.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+venta.getcEstadoCodigo()+"%'";
	        }
//			if(venta.getvEstadoDocumento()==null){
//	        	where+= " and p.vEstadoDocumento LIKE '%"+Constantes.estadoDocumentoDeuda+"%'";
//	        }
			if(venta.getvEstadoDocumento()!=null){
	        	where+= " and p.vEstadoDocumento LIKE '%"+venta.getvEstadoDocumento()+"%'";
	        }
			if(venta.getCliente()!=null && venta.getCliente().getvClienteCodigo()!=null){
	        	where+= " and p.cliente.vClienteCodigo LIKE '%"+venta.getCliente().getvClienteCodigo()+"%'";
	        }
			if(venta.getCliente()!=null && venta.getCliente().getvClienteRazonSocial()!=null){
	        	where+= " and p.cliente.vClienteRazonSocial LIKE '%"+venta.getCliente().getvClienteRazonSocial()+"%'";
	        }
			if(venta.getFormaPago()!=null && venta.getFormaPago().getiFormaPago()!=00){
	        	where+= " and p.formaPago.iFormaPago="+venta.getFormaPago().getiFormaPago();
	        } else {
	        	where+= " and p.formaPago.vFormaPagoDescripcion LIKE '%"+Constantes.formaPagoCredito + "%'";
	        }
			if(venta.getTipoDocumento()!=null && venta.getTipoDocumento().getiTipoDocumentoGestionId()!=00){
	        	where+= " and p.tipoDocumento.iTipoDocumentoGestionId='"+venta.getTipoDocumento().getiTipoDocumentoGestionId()+"'";
	        }
			if(venta.getfVentaTotal()>0.0){
	        	where+= " and p.fVentaTotal>='"+venta.getfVentaTotal()+"'";
	        }
			if(venta.getnVentaNumero()!=null){
	        	where+= " and p.nVentaNumero LIKE '%"+venta.getnVentaNumero()+"%'";
	        }
			if(venta.getdVentaFecha()!=null && venta.getdFechaActualiza()!=null){
	        	where+= " and p.dVentaFecha BETWEEN '"+Fechas.fechaYYMMDD(venta.getdVentaFecha())+"' and '"+Fechas.fechaYYMMDD(venta.getdFechaActualiza())+"'";
	        }

			if (venta.getSucursal() != null) {
				where+= " and p.sucursal.iSucursalId = '"+venta.getSucursal().getiSucursalId() +"'";
			}
	          System.out.println(" where ingreso Producto Estado Cuenta ="+ where);
	    	    q = em.createQuery("select p from Venta p " +
	    	    				   " JOIN FETCH p.cliente " + where);/**/
	    	    q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	    	    listaVenta = q.setFirstResult(pagInicio)
							  .setMaxResults(pagFin)
							  .getResultList(); 

			
		}// lista con busqueda
		
		
        return listaVenta;
	}
	
	
	/*@Override
	public Venta buscarVenta(int iVentaId) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();     
                 
		Venta obj = (Venta) em.find(Venta.class, iVentaId);			     
	
        return obj;
	}

	@Override
	public boolean insertarVenta(Venta venta) {
		// TODO Auto-generated method stub
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		boolean resultado = false;
		
	try {
		em.getTransaction().begin();
		em.persist(venta);
		em.getTransaction().commit();
		//em.flush();
		em.refresh(venta);
		resultado = true;
		
	} catch (TransactionRequiredException e) {
		e.printStackTrace();
		// TODO: handle exception
	} 			
   return resultado;
	}

	@Override
	public boolean actualizarVenta(Venta venta) {
		// TODO Auto-generated method stub
				factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
				EntityManager em = factory.createEntityManager();
				boolean resultado = false;
				
			try {
				em.getTransaction().begin();
				em.merge(venta);
				em.getTransaction().commit();
			//	em.refresh(venta);
				
			
				//em.flush();
				 resultado = true;
				
			} catch (TransactionRequiredException e) {
				e.printStackTrace();
				
				// TODO: handle exception
			}
				
				
				return resultado;
	}

	@Override
	public boolean eliminarVenta(String iVentaId) {
		// TODO Auto-generated method stub
				factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
				EntityManager em = factory.createEntityManager();
				boolean resultado = false;
				
			try {
				
				  Query q = em.createQuery("Update Venta p SET p.cEstadoCodigo = :EstadoCodigo " +
			                    " where p.iVentaId IN ("+iVentaId+")")
			                    .setParameter("EstadoCodigo", Constantes.estadoInactivo);
					           // .setParameter("iVentaId", iVentaId) 

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
	@Override
	public List<Ventadevolucion> listaVentaDevolucion(int pagInicio,
			int pagFin, Venta venta) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();     
		Query q ;
		List<Ventadevolucion> listaVenta = null ;
		String where="";
    	
		if(venta!=null){
			if(venta.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(venta.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+venta.getcEstadoCodigo()+"%'";
	        }
			if(venta==null){
	        	where+= " and p.venta.vEstadoDocumento  LIKE '%"+Constantes.estadoDocumentoDevuelto+"%'";
	        }
			if(venta.getCliente()!=null){
	        	where+= " and p.venta.cliente.vClienteCodigo='"+venta.getCliente().getvClienteCodigo()+"'";
	        }
			if(venta.getFormaPago()!=null && venta.getFormaPago().getiFormaPago()!=00){
	        	where+= " and p.venta.formaPago.iFormaPago='"+venta.getFormaPago().getiFormaPago()+"'";
	        }
			if(venta.getTipoDocumento()!=null && venta.getTipoDocumento().getiTipoDocumentoGestionId()!=00){
	        	where+= " and p.venta.tipoDocumento.iTipoDocumentoGestionId='"+venta.getTipoDocumento().getiTipoDocumentoGestionId()+"'";
	        }
			if(venta.getfVentaTotal()>0.0){
	        	where+= " and p.venta.fVentaTotal>='"+venta.getfVentaTotal()+"'";
	        }
			if(venta.getnVentaNumero()!=null){
	        	where+= " and p.venta.nVentaNumero LIKE '%"+venta.getnVentaNumero()+"%'";
	        }
			if(venta.getdVentaFecha()!=null && venta.getdFechaActualiza()!=null){
	        	where+= " and p.venta.dVentaFecha BETWEEN '"+Fechas.fechaYYMMDD(venta.getdVentaFecha())+"' and '"+Fechas.fechaYYMMDD(venta.getdFechaActualiza())+"'";
	        }

			if (venta.getSucursal() != null) {
				where+= " and p.sucursal.iSucursalId = '"+venta.getSucursal().getiSucursalId() +"'";
			}
	          System.out.println(" where ="+ where);
	    	    q = em.createQuery("select p from Ventadevolucion p " + where +" order by p.dVentaDevFecha desc");/**/
	    	    q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	    	    listaVenta = q.setFirstResult(pagInicio)
							  .setMaxResults(pagFin)
							  .getResultList(); 

			
		}
		
        return listaVenta;
	}
/*
	@Override
	public boolean insertarVentaDevolucion(
			Ventadevolucion ventadevolucion) {
		// TODO Auto-generated method stub
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		boolean resultado = false;
		
	try {
		em.getTransaction().begin();
		em.persist(ventadevolucion);
		em.getTransaction().commit();
		em.refresh(ventadevolucion);
	
	
		//em.flush();
		resultado = true;
		
	} catch (TransactionRequiredException e) {
		e.printStackTrace();
		// TODO: handle exception
	} 			
   return resultado;
	}

	@Override
	public boolean actualizarVentaDevolucion(
			Ventadevolucion ventadevolucion) {
		// TODO Auto-generated method stub
		// 
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		boolean resultado = false;
		
	try {
		em.getTransaction().begin();
		em.merge(ventadevolucion);
		em.getTransaction().commit();
	//	em.refresh(venta);
		
	
		//em.flush();
		 resultado = true;
		
	} catch (TransactionRequiredException e) {
		e.printStackTrace();
		
		// TODO: handle exception
	}
		
		
		return resultado;
	}
	
	@Override
	public Ventadevolucion buscarVentaDevoluvion(int iVentaDevolucionId) {
		// TODO Auto-generated method stub
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();     
                 
		Ventadevolucion obj = (Ventadevolucion) em.find(Ventadevolucion.class, iVentaDevolucionId);			     
	
        return obj;
	}
*/
	@Override
	public List<Ventadetalle> buscarVentaDetalle(int iVentaId) {
	
		// TODO Auto-generated method stub
				Query q ;
				List<Ventadetalle> listaIngresoproducto = null ;

		        
		  	    q = getInstancia().createQuery("select p from Ventadetalle p where p.venta.iVentaId="+iVentaId);/**/
		  	    q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		  	    listaIngresoproducto = q.getResultList(); 
		    
				return listaIngresoproducto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Venta> listaVenta(int pagInicio, int pagFin, VentaVo venta) {
	
		Query q ;
		List<Venta> listaVenta = null ;
		String where="";
    	
		if(venta!=null){
			if(venta.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(venta.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+venta.getcEstadoCodigo()+"%'";
	        }
			if(venta.getiVentaId()>0){
	        	where+= " and p.iVentaId= "+venta.getiVentaId()+"";
	        }
			if(venta.getCliente()!=null && venta.getCliente().getvClienteCodigo()!=null){
	        	where+= " and p.cliente.vClienteCodigo LIKE '%"+venta.getCliente().getvClienteCodigo()+"%'";
	        }
			if(venta.getCliente()!=null && venta.getCliente().getvClienteRazonSocial()!=null){
	        	where+= " and p.cliente.vClienteRazonSocial LIKE '%"+venta.getCliente().getvClienteRazonSocial()+"%'";
	        }
			if(venta.getFormaPago()!=null && venta.getFormaPago().getiFormaPago()!=00){
	        	where+= " and p.formaPago.iFormaPago='"+venta.getFormaPago().getiFormaPago()+"'";
	        }
			if(venta.getTipoDocumento()!=null && venta.getTipoDocumento().getiTipoDocumentoGestionId()!=00){
	        	where+= " and p.tipoDocumento.iTipoDocumentoGestionId='"+venta.getTipoDocumento().getiTipoDocumentoGestionId()+"'";
	        }
			if(venta.getfVentaTotal()>0.0){
	        	where+= " and p.fVentaTotal>='"+venta.getfVentaTotal()+"'";
	        }
			if(venta.getnVentaNumero()!=null){
	        	where+= " and p.nVentaNumero LIKE '%"+venta.getnVentaNumero()+"%'";
	        }
			if(venta.getdVentaFecha()!=null && venta.getdFechaActualiza()!=null){
	        	where+= " and p.dVentaFecha BETWEEN '"+Fechas.fechaYYMMDD(venta.getdVentaFecha())+"' and '"+Fechas.fechaYYMMDD(venta.getdFechaActualiza())+"'";
	        } else if(venta.getdVentaFecha() != null) {
	        	where+= " and p.dVentaFecha = '"+Fechas.fechaYYMMDD(venta.getdVentaFecha())+"'";
	        }
			if (venta.getUsuario() != null) {
				where+= " and p.usuario.iUsuarioId = '"+venta.getUsuario().getiUsuarioId()+"'";
			}
			
			if (venta.getSucursal() != null && venta.getSucursal().getiSucursalId() > 0) {
				where+= " and p.sucursal.iSucursalId = '"+venta.getSucursal().getiSucursalId() +"'";
			}

			System.out.println(" where =" + where);
			q = getInstancia().createQuery("select p from Venta p " + where + " order by p.dVentaFecha desc");/**/
			q.setHint(QueryHints.REFRESH, HintValues.TRUE);
			listaVenta = q.setFirstResult(pagInicio).setMaxResults(pagFin).getResultList(); 
	
		}
		
        return listaVenta;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ventadevolucion> listaVentaDevolucion(int pagInicio, int pagFin, VentaVo venta) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();     
		Query q ;
		List<Ventadevolucion> listaVenta = null ;
		String where="";
    	
		if(venta!=null){
			if(venta.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(venta.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+venta.getcEstadoCodigo()+"%'";
	        }
			if(venta.getCliente()!=null){
	        	where+= " and p.venta.cliente.vClienteCodigo='"+venta.getCliente().getvClienteCodigo()+"'";
	        }
			if(venta.getFormaPago()!=null && venta.getFormaPago().getiFormaPago()!=00){
	        	where+= " and p.venta.formaPago.iFormaPago='"+venta.getFormaPago().getiFormaPago()+"'";
	        }
			if(venta.getTipoDocumento()!=null && venta.getTipoDocumento().getiTipoDocumentoGestionId()!=00){
	        	where+= " and p.venta.tipoDocumento.iTipoDocumentoGestionId='"+venta.getTipoDocumento().getiTipoDocumentoGestionId()+"'";
	        }
			if(venta.getfVentaTotal()>0.0){
	        	where+= " and p.venta.fVentaTotal>='"+venta.getfVentaTotal()+"'";
	        }
			if(venta.getnVentaNumero()!=null){
	        	where+= " and p.venta.nVentaNumero LIKE '%"+venta.getnVentaNumero()+"%'";
	        }
			if(venta.getdVentaFecha()!=null && venta.getdFechaActualiza()!=null){
	        	where+= " and p.venta.dVentaFecha BETWEEN '"+Fechas.fechaYYMMDD(venta.getdVentaFecha())+"' and '"+Fechas.fechaYYMMDD(venta.getdFechaActualiza())+"'";
	        }

			if (venta.getSucursal() != null) {
				where+= " and p.sucursal.iSucursalId = '"+venta.getSucursal().getiSucursalId() +"'";
			}
	          System.out.println(" where ="+ where);
	    	    q = em.createQuery("select p from Ventadevolucion p " + where +" order by p.dVentaDevFecha desc");/**/
	    	    q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	    	    listaVenta = q.setFirstResult(pagInicio)
							  .setMaxResults(pagFin)
							  .getResultList(); 

			
		}
		
        return listaVenta;
	}

	public List<Ventadetalle> listarServicioPersonal(int pagInicio, int pagFin, Date fechaInicio, Date fechaFin) {
		
		String where = "and p.venta.dVentaFecha BETWEEN '" + 
							Fechas.fechaYYMMDD(fechaInicio) + "' and '" + Fechas.fechaYYMMDD(fechaFin) + "'";
		if (fechaInicio.compareTo(fechaFin) == 0) {
			where = "and p.venta.dVentaFecha = '" + 
					Fechas.fechaYYMMDD(fechaInicio) + "' ";
		}
		
		String sentencia = "select p from Ventadetalle p where p.personal.iPersonalId > 0 " + where + " order by p.venta.dVentaFecha asc";
		
		List<Ventadetalle> lista = listaEntidadPaginada(sentencia, pagInicio, pagFin);
		
		return lista;
	}
	
}
