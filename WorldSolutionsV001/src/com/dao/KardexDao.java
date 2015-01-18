package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.entities.Kardex;
import com.entities.Kardex;
import com.entities.Librodiario;
import com.entities.Producto;
import com.interfaces.dao.IKardexDao;
import com.util.Constantes;
import com.util.Fechas;

public class KardexDao extends GenericaDao implements IKardexDao {
	@Override
	public List<Kardex> listaKardex(int pagInicio, int pagFin, Producto producto,
			String cInsumo) {
		 
		Query q ;
		List<Kardex> listaKardex = null ;
		String where="";

		if(producto!=null){
		/*	if(producto.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }			
			if(producto.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+producto.getcEstadoCodigo()+"%'";
	        }*/
			if(producto.getiProductoId()>0){
	        	where+= " where  p.producto.iProductoId = '"+producto.getiProductoId()+"'";
	        }
			if(producto.getdFechaInserta()!=null && producto.getdFechaActualiza()!=null){
	        	where+= " and p.dFecha BETWEEN '"+Fechas.fechaYYMMDD(producto.getdFechaInserta())+"' and '"+Fechas.fechaYYMMDD(producto.getdFechaActualiza())+"'";
	        }
			System.out.println(" where ="+where);
	        q = getInstancia().createQuery("select p from Kardex p " + where +" order by p.dFechaInserta,p.vConcepto asc");/**/
	        q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	        listaKardex = q.setFirstResult(pagInicio)
						  .setMaxResults(pagFin)
						  .getResultList(); 
		
			}// lista con busqueda
			
		
        return listaKardex;
	}

	@Override
	public Kardex buscarKardex(int iKardexId) {
		// TODO Auto-generated method stub
		
		Kardex kardex = (Kardex) getInstancia().find(Kardex.class, iKardexId);		     
	
        return kardex;
	}
	
	@Override
	public List<Kardex> buscarKardexProducto(int iProductoId) {
		// TODO Auto-generated method stub
		Query q = getInstancia().createQuery("Select p from Kardex p where p.producto.iProductoId ='"+iProductoId+"' and p.cEstadoCodigo = :EstadoCodigo order by p.dFechaInserta,p.vConcepto asc");
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		List<Kardex> kardex = (List<Kardex>) q.setParameter("EstadoCodigo", Constantes.estadoActivo).getResultList(); //find(Kardex.class, iProductoId);		     
		
        return kardex;
	}
	@Override
	public List<Librodiario> buscarLibroDiarioKardex(int iKardexId) {
		// TODO Auto-generated method stub
		Query q = getInstancia().createQuery("Select p from Librodiario p where p.kardex.iKardexId ='"+iKardexId+"'");
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		List<Librodiario> libroDiario = (List<Librodiario>) q.getResultList(); //find(Kardex.class, iProductoId);		     
	
        return libroDiario;
	}

	

}
