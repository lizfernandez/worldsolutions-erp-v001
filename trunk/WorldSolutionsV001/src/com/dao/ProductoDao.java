package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.entities.Producto;
import com.interfaces.dao.IProductoDao;
import com.util.Constantes;



public  class ProductoDao  extends GenericaDao implements IProductoDao {
	private static final String PERSISTENCE_UNIT_NAME = "Stuct12";
	private static EntityManagerFactory factory;
	
	public List<Producto> listaProducto(int pagInicio, int pagFin, Producto producto, int iclasificacionId) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();  
		Query q ;
		List<Producto> listaProducto = null ;
		String where=""; 
	
		

		if(producto!=null){
			if(producto.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }			
			if(producto.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+producto.getcEstadoCodigo()+"%'";
	        }
			
			if(producto.getiProductoId()>0){
	        	where+= " and p.iProductoId = '"+producto.getiProductoId()+"'";
	        }
			if(producto.getCategoria()!=null && producto.getCategoria().getiCategoriaId()>0){
	        	where+= " and p.categoria.iCategoriaId LIKE '%"+producto.getCategoria().getiCategoriaId()+"%'";
	        }
			if(iclasificacionId>0){
	        	where+= " and p.categoria.clasificacionCategoria.iClasificacionId LIKE '%"+iclasificacionId+"%'";
	        }
			if(producto.getcProductoCodigo()!=null){
	        	where+=" and  p.cProductoCodigo LIKE '%"+producto.getcProductoCodigo()+"%'";
	        }
			if(producto.getvProductoNombre()!=null){
	        	where+=" and  p.vProductoNombre LIKE '%"+producto.getvProductoNombre()+"%'";
	        }
	        if(producto.getiProductoStockCantidad()>0){
	        	where+=" and  p.iProductoStockCantidad LIKE '%"+producto.getiProductoStockCantidad()+"%'";
	        }
	        if(producto.getUnidadMedida()!=null && producto.getUnidadMedida().getiUnidadMedidaId()>0){
	        	where+=" and  p.unidadMedida.iUnidadMedidaId LIKE '%"+producto.getUnidadMedida().getiUnidadMedidaId()+"%'";
	        }
	        if(producto.getvProductoCapacidad()!=null){
	        	where+=" and  p.vProductoCapacidad LIKE '%"+producto.getvProductoCapacidad()+"%'";
	        }
	        if(producto.getiUnidadMedidadIdC()>0){
	        	where+=" and  p.iUnidadMedidadIdC LIKE '%"+producto.getiUnidadMedidadIdC()+"%'";
	        }
	        if(producto.getfProductoPrecioCompra()>0){
	        	where+=" and  p.fProductoPrecioCompra LIKE '%"+producto.getfProductoPrecioCompra()+"%'";
	        }
	        if(producto.getfProductoPrecioVenta()>0){
	        	where+=" and  p.fProductoPrecioVenta LIKE '%"+producto.getfProductoPrecioVenta()+"%'";
	        }
	        System.out.println(" where ="+where);
	        q = em.createQuery("select p from Producto p " + where +" order by p.vProductoNombre asc");/**/
	        q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	        listaProducto = q.setFirstResult(pagInicio)
						  .setMaxResults(pagFin)
						  .getResultList(); 
		
			}// lista con busqueda
//			else{
//				q= em.createQuery("select p from Producto p " +
//		                    " where p.cEstadoCodigo = :EstadoCodigo");
//				listaProducto = q.setParameter("EstadoCodigo", Constantes.estadoActivo)
//							  .setFirstResult(pagInicio)
//							  .setMaxResults(pagFin)
//							  .getResultList(); 
//
//             }//else , lista simple	
		
        return listaProducto;
	}
	
	
}
