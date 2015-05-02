package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.entities.Ocupacion;
import com.interfaces.dao.IOcupacionDao;
import com.util.Constantes;

public class OcupacionDao extends GenericaDao  implements IOcupacionDao{
	
	@Override
	public List<Ocupacion> listaOcupacion(int pagInicio, int pagFin, Ocupacion area) {
		Query q ;
		List<Ocupacion> listaOcupacion = null ;
		String where="";
    	
		if(area!=null){
			if(area.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(area.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+area.getcEstadoCodigo()+"%'";
	        }
	        if(area.getcOcupacionCodigo()!=null){
	        	where+=" and  p.cOcupacionCodigo LIKE '%"+area.getcOcupacionCodigo()+"%'";
	        }
	        if(area.getvOcupacionDescripcion()!=null){
	        	where+=" and  p.vOcupacionDescripcion LIKE '%"+area.getvOcupacionDescripcion()+"%'";
	        }
	        System.out.println(" where ="+ where);
	    	    q = getInstancia().createQuery("select p from Ocupacion p " + where);/**/
	    	    q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	    	    listaOcupacion = q.setFirstResult(pagInicio)
							  .setMaxResults(pagFin)
							  .getResultList(); 

			
		}// lista con busqueda
		else{
				q= getInstancia().createQuery("select p from Ocupacion p " +
		    	   		                    " where p.cEstadoCodigo = :EstadoCodigo");
				q.setHint(QueryHints.REFRESH, HintValues.TRUE);
				listaOcupacion = q.setParameter("EstadoCodigo", Constantes. estadoActivo)
												  .setFirstResult(pagInicio)
												  .setMaxResults(pagFin)
												  .getResultList(); 
				
		 
		}//else , lista simple	        
 			
		
        return listaOcupacion;
	}

	
}
