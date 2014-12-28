package com.dao;

import java.util.List;

import javax.persistence.Query;

import com.entities.Configuracion;
import com.entities.Ejerciciofiscal;
import com.entities.Impuesto;
import com.entities.Moneda;
import com.entities.Periodo;
import com.interfaces.dao.IConfiguracionDao;
import com.util.Constantes;
import com.util.Fechas;

public class ConfiguracionDao  extends GenericaDao implements IConfiguracionDao {
	
	@Override
	public List<Configuracion> listaConfiguracion(int pagInicio, int pagFin, Configuracion configuracion) {
		Query q ;
		List<Configuracion> listaConfiguracion = null ;
		String where="";
    	
		if(configuracion!=null){
			if(configuracion.getvConcepto()!=null){
	        	where+= " where p.vConcepto LIKE '%"+configuracion.getvConcepto()+"%'";
	        }
			
			    q = getInstancia().createQuery("select p from Configuracion p "+where+" order by p.cEstadoCodigo asc , p.iConfiguracionId asc" + where);/**/
	    	    
	    	    listaConfiguracion = q.setFirstResult(pagInicio)
							  .setMaxResults(pagFin)
							  .getResultList(); 

			
		}// lista con busqueda
		else{
				q= getInstancia().createQuery("select p from Configuracion p " +
		    	   		                    " where p.cEstadoCodigo = :EstadoCodigo");
				listaConfiguracion = q.setParameter("EstadoCodigo", Constantes. estadoActivo)
												  .setFirstResult(pagInicio)
												  .setMaxResults(pagFin)
												  .getResultList(); 
				
		 
		}//else , lista simple	        
 			
		
        return listaConfiguracion;
	}

	@Override
	public Configuracion buscarConfiguracion(String  vConcepto) {
	            
	
		 Query q =   getInstancia().createQuery("select p from Configuracion p  where p.vConcepto like '%"+vConcepto+"%' and p.cEstadoCodigo='"+Constantes.estadoActivo+"'");			     
		 Configuracion obj = (Configuracion) q.getSingleResult(); 
        return obj;
	}

	@Override
	public Moneda buscarMoneda(String vConcepto) {
		// TODO Auto-generated method stub
		Query q =   getInstancia().createQuery("select p from Moneda p  where p.vMonedaDescripcion like '%"+vConcepto+"%'");//find(Configuracion.class, vConcepto);			     
		Moneda obj = (Moneda) q.getSingleResult(); 
       return obj;
	}

	@Override
	public List<Ejerciciofiscal> listaEjercicioFiscal(int pagInicio,
			int pagFin, Ejerciciofiscal ejerccio) {
		Query q ;
		List<Ejerciciofiscal> listaConfiguracion = null ;
		String where="";
    	
		if(ejerccio!=null){
			if(ejerccio.getcCodigoEstado()!=null){
	        	where+= " where p.cCodigoEstado LIKE '%"+ejerccio.getcCodigoEstado()+"%'";
	        }
			if(ejerccio.getvCodigoEjercicio()!=null){
	        	where+= " and p.vCodigoEjercicio() LIKE '%"+ejerccio.getvCodigoEjercicio()+"%'";
	        }
			if(ejerccio.getvNombreEjercicio()!=null){
	        	where+= " and p.vNombreEjercicio LIKE '%"+ejerccio.getvNombreEjercicio()+"%'";
	        }
			if(ejerccio.getdFechaInicio()!=null){
	        	where+= " and p.dFechaInicio LIKE '%"+Fechas.fechaYYMMDD(ejerccio.getdFechaInicio())+"%'";
	        }
			if(ejerccio.getdFechaFin()!=null){
	        	where+= " and p.dFechaFin LIKE '%"+Fechas.fechaYYMMDD(ejerccio.getdFechaFin())+"%'";
	        }
		
		
			    q = getInstancia().createQuery("select p from Ejerciciofiscal p "+where);/**/
	    	    
	    	    listaConfiguracion = q.setFirstResult(pagInicio)
							  .setMaxResults(pagFin)
							  .getResultList(); 

			
		}// lista con busqueda
		else{
				q= getInstancia().createQuery("select p from Ejerciciofiscal p ");
				listaConfiguracion = q.setFirstResult(pagInicio)
												  .setMaxResults(pagFin)
												  .getResultList(); 
				
		 
		}//else , lista simple	        
 			
		
        return listaConfiguracion;
	}

	@Override
	public List<Periodo> listaPeriodo(int pagInicio, int pagFin, Periodo periodo) {
		Query q ;
		List<Periodo> listaConfiguracion = null ;
		String where="";
    	
		if(periodo!=null){
			if(periodo.getcCodigoEstado()!=null){
	        	where+= " where p.cCodigoEstado LIKE '%"+periodo.getcCodigoEstado()+"%'";
	        }
			if(periodo.getvCodigoPeriodo()!=null){
	        	where+= " and p.vCodigoPeriodo LIKE '%"+periodo.getvCodigoPeriodo()+"%'";
	        }
			if(periodo.getvNombrePeriodo()!=null){
	        	where+= " where p.vNombrePeriodo LIKE '%"+periodo.getvNombrePeriodo()+"%'";
	        }
			if(periodo.getEjerciciofiscal()!=null){
	        	where+= " where p.ejerciciofiscal.vNombreEjercicio LIKE '%"+periodo.getEjerciciofiscal().getvNombreEjercicio()+"%'";
	        }
			if(periodo.getvNombrePeriodo()!=null){
	        	where+= " where p.vNombrePeriodo LIKE '%"+periodo.getvNombrePeriodo()+"%'";
	        }
			if(periodo.getdFechaInicio()!=null){
	        	where+= " and p.dFechaInicio LIKE '%"+Fechas.fechaYYMMDD(periodo.getdFechaInicio())+"%'";
	        }
			if(periodo.getdFechaFin()!=null){
	        	where+= " and p.dFechaFin LIKE '%"+Fechas.fechaYYMMDD(periodo.getdFechaFin())+"%'";
	        }
		
			    q = getInstancia().createQuery("select p from Periodo p "+where+" order by p.dFechaInicio asc ");/**/
	    	    
	    	    listaConfiguracion = q.setFirstResult(pagInicio)
							  .setMaxResults(pagFin)
							  .getResultList(); 

			
		}// lista con busqueda
		else{
				q= getInstancia().createQuery("select p from Periodo p " );
				listaConfiguracion = q.setFirstResult(pagInicio)
												  .setMaxResults(pagFin)
												  .getResultList(); 
				
		 
		}//else , lista simple	        
 			
		
        return listaConfiguracion;
	}

	@Override
	public List<Impuesto> listaImpuestos(int pagInicio, int pagFin,
			Impuesto impuesto) {
		Query q ;
		List<Impuesto> listaConfiguracion = null ;
		String where="";
    	
		if(impuesto!=null){
			if(impuesto.getcCodigoEstado()!=null){
	        	where+= " where p.cCodigoEstado LIKE '%"+impuesto.getcCodigoEstado()+"%'";
	        }
			
		
			    q = getInstancia().createQuery("select p from Impuesto p "+where);/**/
	    	    
	    	    listaConfiguracion = q.setFirstResult(pagInicio)
							  .setMaxResults(pagFin)
							  .getResultList(); 

			
		}// lista con busqueda
		else{
				q= getInstancia().createQuery("select p from Impuesto p " );
				listaConfiguracion = q.setFirstResult(pagInicio)
												  .setMaxResults(pagFin)
												  .getResultList(); 
				
		 
		}//else , lista simple	        
 			
		
        return listaConfiguracion;
	}

	@Override
	public Impuesto buscarImpuesto(String vConcepto) {
		 Query q =   getInstancia().createQuery("select p from Impuesto p  where p.vNombreImpuesto like '%"+vConcepto+"%' and p.cCodigoEstado='"+Constantes.estadoActivo+"'");			     
		System.out.println("select p from Impuesto p  where p.vNombreImpuesto like '%"+vConcepto+"%' and p.cCodigoEstado='"+Constantes.estadoActivo+"'");
		 Impuesto obj = (Impuesto) q.getSingleResult(); 
       return obj;
	}

	
}
