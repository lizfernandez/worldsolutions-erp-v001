package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.entities.Sucursal;
import com.interfaces.dao.ISucursalDao;
import com.util.Constantes;

public class SucursalDao extends GenericaDao  implements ISucursalDao{
	
	@Override
	public List<Sucursal> listaSucursal(int pagInicio, int pagFin, Sucursal area) {
		Query q ;
		List<Sucursal> listaSucursal = null ;
		String where="";
    	
		if(area!=null){
			if(area.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(area.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+area.getcEstadoCodigo()+"%'";
	        }
	        if(area.getcSucursalCodigo()!=null){
	        	where+=" and  p.cSucursalCodigo LIKE '%"+area.getcSucursalCodigo()+"%'";
	        }
	        if(area.getvSucursalNombre()!=null){
	        	where+=" and  p.vSucursalNombre LIKE '%"+area.getvSucursalNombre()+"%'";
	        }
	        System.out.println(" where ="+ where);
	    	    q = getInstancia().createQuery("select p from Sucursal p " + where);/**/
	    	    q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	    	    listaSucursal = q.setFirstResult(pagInicio)
							  .setMaxResults(pagFin)
							  .getResultList(); 

			
		}// lista con busqueda
		else{
				q= getInstancia().createQuery("select p from Sucursal p " +
		    	   		                    " where p.cEstadoCodigo = :EstadoCodigo");
				q.setHint(QueryHints.REFRESH, HintValues.TRUE);
				listaSucursal = q.setParameter("EstadoCodigo", Constantes. estadoActivo)
												  .setFirstResult(pagInicio)
												  .setMaxResults(pagFin)
												  .getResultList(); 
				
		 
		}//else , lista simple	        
 			
		
        return listaSucursal;
	}

	
}
