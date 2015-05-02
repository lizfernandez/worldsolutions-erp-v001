package com.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.entities.Cajachica;
import com.entities.Cuenta;
import com.entities.Elementocuenta;
import com.entities.Ingresoproducto;
import com.entities.Kardex;
import com.entities.Librodiario;
import com.entities.Libromayor;
import com.entities.Planilla;

import com.entities.vo.LibroDiarioVo1;
import com.interfaces.dao.IContabilidadDao;
import com.util.Constantes;
import com.util.Fechas;

public class ContabilidadDao  extends GenericaDao  implements IContabilidadDao {
	
	@Override
	public List<Elementocuenta> listaElementoCuenta(String iElementoCuentasId) {
	
		Query q = getInstancia().createQuery("select p from Elementocuenta p where p.iElementoCuentasId in("+iElementoCuentasId+")");
		//List<Elementocuenta> lita = em.createNamedQuery("elementocuentas")
        //.setParameter("custName", "Smith")
       // .getResultList();
		
		//p where p.iElementoCuentasId in("+iElementoCuentasId+")"
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		List<Elementocuenta> lita = q.getResultList(); 
		
		return lita;
	}

	@Override
	public List<Cuenta> listaPartida(int iElementoCuentasId) {
		// TODO Auto-generated method stub
	
		Query q = getInstancia().createQuery("select p from Cuenta p where p.elementoCuenta.iElementoCuentasId="+iElementoCuentasId+" and  LENGTH(p.vCodigo)=2"); 
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		List<Cuenta> lita = q.getResultList(); 		
		return lita;
	}

	@Override
	public List<Cuenta> listaSubPartida(String iCuentasId) {
		// TODO Auto-generated method stub
		Cuenta cuenta = new Cuenta();
		Query q = getInstancia().createQuery("select p from Cuenta p where  p.iCuentasId="+iCuentasId);
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		cuenta= (Cuenta) q.getSingleResult();
		
		Query qs = getInstancia().createQuery("select p from Cuenta p where  p.vCodigo like '"+cuenta.getvCodigo()+"%' and  LENGTH(p.vCodigo) =" +(cuenta.getvCodigo().length()+1)); 
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		List<Cuenta> lita = qs.getResultList(); 		
		return lita;
	}
	
	@Override
	public List<Cuenta> listaSubPartidaCodigo(String vCodigo) {
		// TODO Auto-generated method stub
		
		Query qs = getInstancia().createQuery("select p from Cuenta p where  p.vCodigo like '"+vCodigo+"%' and  LENGTH(p.vCodigo) =" +(vCodigo.length()+1)); 
		qs.setHint(QueryHints.REFRESH, HintValues.TRUE);
		List<Cuenta> lita = qs.getResultList(); 		
		return lita;
	}

	@Override
	public Cuenta bucarCuenta(String vCodigo) {
		
		Query q = getInstancia().createQuery("select p from Cuenta p where p.vCodigo="+vCodigo); 
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		Cuenta lita = (Cuenta) q.getSingleResult(); 
		return lita;
	}

	

	@Override
	public List<Librodiario> listaCajaChica(int pagInicio, int pagFin,
			Librodiario librodiario, int iPeriodoId) {
			String q ;
		List<Librodiario> listaCaja = null ;
		String where="";
    	
		if(librodiario!=null){
			if(librodiario.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(librodiario.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+librodiario.getcEstadoCodigo()+"%'";
	        }
			if(librodiario.getdFechaInserta()!=null){
	        	where+= " and p.dFechaInserta BETWEEN '"+Fechas.fechaYYMMDD(librodiario.getdFechaInserta())+"' and '"+Fechas.fechaYYMMDD(librodiario.getdFechaInserta())+"'";
	        }
			else{
				where+= " and p.iPeriodoId="+iPeriodoId;
			}
		
	       
			 q = "select p from Librodiario p " + where+" and p.cCajaBanco='1' " +
			 		" order by p.iLibroDiarioId desc , p.dFechaInserta desc";/**/
	    	     
	    	    listaCaja = listaEntidadPaginada(q, pagInicio, pagFin);

			
		}// lista con busqueda
		
		
        return listaCaja;
	}

	@Override
	public List<Librodiario> listaLibroDiario(int pagInicio, int pagFin,
			Librodiario libroDiario, int iPeriodoId) {
		List<Librodiario> listaLibroDiario = new ArrayList<Librodiario>() ;
		
		String where="";
		String q ;
		if(libroDiario!=null){
			if(libroDiario.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(libroDiario.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+libroDiario.getcEstadoCodigo()+"%'";
	        }
			if(libroDiario.getdFechaInserta()!=null){
	        	where+= " and p.dFechaInserta BETWEEN '"+Fechas.fechaYYMMDD(libroDiario.getdFechaInserta())+"' and '"+Fechas.fechaYYMMDD(libroDiario.getdFechaInserta())+"'";
	        }
			else{
				where+= " and p.iPeriodoId="+iPeriodoId;
			}
		
	    	    q = "select p from Librodiario p " + where
	    	    		//+"order by p.iLibroDiarioId desc , p.dFechaInserta desc";/**/
	    	    		+" order by p.dFechaInserta desc, p.cuenta.vCodigo asc";/**/
	    	    
	    	    listaLibroDiario = listaEntidadPaginada(q, pagInicio, pagFin);
	    	 /*   
	    	    GenericaDao genericaDao = new GenericaDao();
	    	    for (Object[] obj : listaObjeto){
	    	    	Librodiario libro = genericaDao.findEndidad(libroDiario, Integer.parseInt(obj[0].toString()));
	    	    	libro.setfMonto(Float.parseFloat(obj[1].toString()));
	    	    	listaLibroDiario.add(libro)	;
	    	    	
	    	    	
	    	        
	    	     }*/

			
		}// lista con busqueda
		
		
        return listaLibroDiario;
	}
	@Override
	public List<Librodiario> listaCuentas(int pagInicio, int pagFin,
			Librodiario libroDiario, int iPeriodoId) {
		List<Librodiario> listaLibroDiario = null ;
		String where="";
		String q ;
		if(libroDiario!=null){
			if(libroDiario.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(libroDiario.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+libroDiario.getcEstadoCodigo()+"%'";
	        }
			if(libroDiario.getdFechaInserta()!=null){
	        	where+= " and p.dFechaInserta BETWEEN '"+Fechas.fechaYYMMDD(libroDiario.getdFechaInserta())+"' and '"+Fechas.fechaYYMMDD(libroDiario.getdFechaInserta())+"'";
	        }
			else{
				where+= " and p.iPeriodoId="+iPeriodoId;
			}
		
	    	    q = "select p from Librodiario p " + where
	    	    		//+" order by p.iLibroDiarioId desc , p.dFechaInserta desc";/**/
	    	    		+" order by p.dFechaInserta desc, p.cuenta.vCodigo asc";/**/
	    	    listaLibroDiario = listaEntidadPaginada(q, pagInicio, pagFin);

			
		}// lista con busqueda
		
		
        return listaLibroDiario;
	}
	@Override
	public List<Libromayor> listaLibroMayor(int pagInicio, int pagFin,
			Librodiario libroDiario, int iPeriodoId) throws ParseException {
		List<Libromayor> listaLibroDiario = new ArrayList<Libromayor>() ;
		List<Object[]> listaObjeto = new ArrayList<Object[]>() ;
		int codigoGenerado = 0; 
   	 EntityTransaction ext = entityTransaction();
		   ext.begin();
		Query q ;
		q = getInstancia().createNativeQuery("{ CALL SP_GENERAR_LIBROMAYOR(?) }")
		        .setParameter(1,iPeriodoId);
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		listaObjeto =  q.setFirstResult(pagInicio)
			  .setMaxResults(pagFin)
			  .getResultList();  	           
         commitEndidad(ext);
       //  setIntancia();
       // refreshEndidad(Libromayor.class);
        /*    q = getInstancia().createQuery("select p from Libromayor p ");
    	    
    	    listaLibroDiario = q.setFirstResult(pagInicio)
						  .setMaxResults(pagFin)
						  .getResultList(); */
         int i=1;
       GenericaDao genericaDao = new GenericaDao();
		for(Object[] obj:listaObjeto){
			if(i<=pagFin){
			Libromayor libroMayor= new Libromayor();
			Cuenta cuenta = new Cuenta();
			libroMayor.setiLibroMayorId(Integer.parseInt(obj[0].toString()));
			libroMayor.setCuenta(genericaDao.findEndidad(cuenta, Integer.parseInt(obj[1].toString())));
			libroMayor.setfMontoDebe(Float.parseFloat(obj[2].toString()));
			libroMayor.setfMontoHaber(Float.parseFloat(obj[3].toString()));
			libroMayor.setiPeriodoId(Integer.parseInt(obj[4].toString()));
			listaLibroDiario.add(libroMayor);
			i++;
			}
			else break;
		}
		
        return listaLibroDiario;
	}
	@Override
	public List<Librodiario> listaBalanceGeneral(int pagInicio, int pagFin,
			Librodiario libroDiario, int iPeriodoId) {
		List<Librodiario> listaLibroDiario = null ;
		String where="";
		String q ;
		if(libroDiario!=null){
			if(libroDiario.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(libroDiario.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+libroDiario.getcEstadoCodigo()+"%'";
	        }
			if(libroDiario.getdFechaInserta()!=null){
	        	where+= " and p.dFechaInserta BETWEEN '"+Fechas.fechaYYMMDD(libroDiario.getdFechaInserta())+"' and '"+Fechas.fechaYYMMDD(libroDiario.getdFechaInserta())+"'";
	        }
			else{
				where+= " and p.iPeriodoId="+iPeriodoId;
			}
		
	    	    q = "select p from Librodiario p " + where
	    	    		+" order by p.iLibroDiarioId desc , p.dFechaInserta desc";/**/
	    	    
	    	    listaLibroDiario = listaEntidadPaginada(q, pagInicio, pagFin);

			
		}// lista con busqueda
		
		
        return listaLibroDiario;
	}

	@Override
	public void callCompraContabilidad( int iIngresoProductoId, Date fechaProximoPago,
			float fMontoAdelantado, int xiUsuarioId, int xnumeroLetras, int xnumeroDias, String mode, int iPeriodoId, int numeroLetra, int iFormaPagoId) {
		Query q ;
		       q = getInstancia().createNativeQuery("{ CALL SP_IDU_COMPRA_CONTABILIDAD(?,?,?,?,?,?,?,?,?,?) }")//createNamedQuery("SP_IDU_PERFIL_PERMISOS")           
	                    .setParameter(1,iIngresoProductoId)
	                    .setParameter(2,fechaProximoPago)
	    		        .setParameter(3,fMontoAdelantado)
	    		        .setParameter(4,xiUsuarioId)
	    		        .setParameter(5,xnumeroLetras)
	    		        .setParameter(6,xnumeroDias)
	    		        .setParameter(7,mode)
	    		        .setParameter(8,iPeriodoId)
	    		        .setParameter(9,numeroLetra)
	    		        .setParameter(10, iFormaPagoId);		            
	            q.getSingleResult();	           
	  }

	@Override
	public void callDevCompraContabilidad(int iIngresoProductoId,
			int xiUsuarioId, String mode,String estadoDoc, int iPeriodoId) {
		// TODO Auto-generated method stub
		Query q ;
	    
	            q = getInstancia().createNativeQuery("{ CALL SP_IDU_DEVCOMPRA_CONTABILIDAD(?,?,?,?,?) }")//createNamedQuery("SP_IDU_PERFIL_PERMISOS")           
	                    .setParameter(1,iIngresoProductoId)	                  
	    		        .setParameter(2,xiUsuarioId)	    		    
	    		        .setParameter(3,mode)
	    		        .setParameter(4,estadoDoc)
	    		        .setParameter(5,iPeriodoId);		            
	            q.getSingleResult();         
	    
	}

	@Override
	public void callVentaContabilidad(int iVentaId,
			Date fechaProximoPago, float fMontoAdelantado, int xiUsuarioId,
			int numeroLetras, int xnumeroDias, String mode, int iPeriodoId,int nNumeroLetra, int iFormaPagoId) {
		Query q ;
		
	          q = getInstancia().createNativeQuery("{ CALL SP_IDU_VENTA_CONTABILIDAD(?,?,?,?,?,?,?,?,?,?) }")//createNamedQuery("SP_IDU_PERFIL_PERMISOS")           
	                    .setParameter(1,iVentaId)
	                    .setParameter(2,fechaProximoPago)
	    		        .setParameter(3,fMontoAdelantado)
	    		        .setParameter(4,xiUsuarioId)
	    		        .setParameter(5,numeroLetras)
	    		        .setParameter(6,xnumeroDias)
	    		        .setParameter(7,mode)
	    		        .setParameter(8,iPeriodoId)
	    		        .setParameter(9,nNumeroLetra)
	    		        .setParameter(10, iFormaPagoId);
	          q.getSingleResult();     
	    
	}

	public void callDevVentaContabilidad(int iVentaId,
			int xiUsuarioId, String mode,String estadoDoc,  int iPeriodoId) {
		// TODO Auto-generated method stub
				Query q ;
				           q = getInstancia().createNativeQuery("{ CALL SP_IDU_DEVVENTA_CONTABILIDAD(?,?,?,?,?) }")//createNamedQuery("SP_IDU_PERFIL_PERMISOS")           
			                    .setParameter(1,iVentaId)	                  
			    		        .setParameter(2,xiUsuarioId)	    		    
			    		        .setParameter(3,mode)
			    		        .setParameter(4,estadoDoc)
			    		        .setParameter(5,iPeriodoId);		            
			              q.getSingleResult();           
			       
	}

	@Override
	public List<Planilla> listaPlanilla(int pagInicio, int pagFin,
			Planilla planilla, int iPeriodoId) {
		String q ;
		List<Planilla> listaPlanilla = null ;
		String where="";
    	
		if(planilla!=null){
			if(planilla.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(planilla.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+planilla.getcEstadoCodigo()+"%'";
	        }
			if(planilla.getdFechaInserta()!=null){
	        	where+= " and p.dFechaInserta BETWEEN '"+Fechas.fechaYYMMDD(planilla.getdFechaInserta())+"' and '"+Fechas.fechaYYMMDD(planilla.getdFechaInserta())+"'";
	        }
			else{
				where+= " and p.iPeriodoId="+iPeriodoId;
			}
		
	       
			 q = "select p from Planilla p " + where+
			 		" order by p.iPlanillaId desc , p.dFechaInserta desc";/**/
	    	     
	    	    listaPlanilla = listaEntidadPaginada(q, pagInicio, pagFin);

			
		}// lista con busqueda
		
		
        return listaPlanilla;
	}

	



}
