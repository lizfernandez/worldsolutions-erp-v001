package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.entities.Area;
import com.interfaces.dao.IAreaDao;
import com.util.Constantes;

public class AreaDao extends GenericaDao  implements IAreaDao{
	
	@Override
	public List<Area> listaArea(int pagInicio, int pagFin, Area area) {
		Query q ;
		List<Area> listaArea = null ;
		String where="";
    	
		if(area!=null){
			if(area.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(area.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+area.getcEstadoCodigo()+"%'";
	        }
	        if(area.getcAreaCodigo()!=null){
	        	where+=" and  p.cAreaCodigo LIKE '%"+area.getcAreaCodigo()+"%'";
	        }
	        if(area.getvAreaDescripcion()!=null){
	        	where+=" and  p.vAreaDescripcion LIKE '%"+area.getvAreaDescripcion()+"%'";
	        }
	        System.out.println(" where ="+ where);
	    	    q = getInstancia().createQuery("select p from Area p " + where);/**/
	    	    q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	    	    listaArea = q.setFirstResult(pagInicio)
							  .setMaxResults(pagFin)
							  .getResultList(); 

			
		}// lista con busqueda
		else{
				q= getInstancia().createQuery("select p from Area p " +
		    	   		                    " where p.cEstadoCodigo = :EstadoCodigo");
				q.setHint(QueryHints.REFRESH, HintValues.TRUE);
				listaArea = q.setParameter("EstadoCodigo", Constantes. estadoActivo)
												  .setFirstResult(pagInicio)
												  .setMaxResults(pagFin)
												  .getResultList(); 
				
		 
		}//else , lista simple	        
 			
		
        return listaArea;
	}

	
}
