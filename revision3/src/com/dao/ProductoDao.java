package com.dao;

import java.util.List;


import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.entities.Produccion;
import com.entities.Producciondetalle;
import com.entities.Producto;
import com.entities.Ventadetalle;
import com.interfaces.dao.IProductoDao;
import com.util.Constantes;



public  class ProductoDao  extends GenericaDao implements IProductoDao {
	
	public List<Producto> listaProducto(int pagInicio, int pagFin, Producto producto, int iclasificacionId) {
	  
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
	        q = getInstancia().createQuery("select p from Producto p " + where +" order by p.vProductoNombre asc");/**/
	        q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	        listaProducto = q.setFirstResult(pagInicio)
						  .setMaxResults(pagFin)
						  .getResultList(); 
		
			}
		
        return listaProducto;
	}

	@Override
	public List<Produccion> listaProduccion(int pagInicio, int pagFin,
			Produccion produccion) {
		// TODO Auto-generated method stub
		Query q ;
		List<Produccion> listaProduccion = null ;
		String where=""; 
	
		

		if(produccion!=null){
			if(produccion.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }			
			if(produccion.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+produccion.getcEstadoCodigo()+"%'";
	        }
			
			if(produccion.getiProduccionId()>0){
	        	where+= " and p.iProduccionId = '"+produccion.getiProduccionId()+"'";
	        }
			
	        System.out.println(" where ="+where);
	        q = getInstancia().createQuery("select p from Produccion p " + where );/**/
	        q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	        listaProduccion = q.setFirstResult(pagInicio)
						  .setMaxResults(pagFin)
						  .getResultList(); 
		
			}
		
        return listaProduccion;
	}

	@Override
	public List<Producciondetalle> buscarDetalleProduccion(int iProduccionId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Query q ;
		List<Producciondetalle> listaProduccionDetalle = null ;

        
  	    q = getInstancia().createQuery("select p from Producciondetalle p where p.produccion.iProduccionId="+iProduccionId);/**/
  	    q.setHint(QueryHints.REFRESH, HintValues.TRUE);
  	  listaProduccionDetalle = q.getResultList(); 
    
		return listaProduccionDetalle;
	}

	@Override
	public List<Producto> listaProductoStockMinimo(int pagInicio, int pagFin,
			int iclasificacionId) {
		Query q ;
		List<Producto> listaProducto = null ;
		String where=""; 
		
		 q = getInstancia().createQuery("select p from Producto p where p.iProductoStockCantidad<p.iProductoStockMinimo and p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'" + where );/**/
	        q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	        listaProducto = q.setFirstResult(pagInicio)
						  .setMaxResults(pagFin)
						  .getResultList(); 
		
		return listaProducto;
	}
	@Override
	public List<Producto> listaProductoStockMaximo(int pagInicio, int pagFin,
			int iclasificacionId) {
		Query q ;
		List<Producto> listaProducto = null ;
		String where=""; 
		
		 q = getInstancia().createQuery("select p from Producto p where p.iProductoStockCantidad>p.iProductoStockMaximo and p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'" + where );/**/
	        q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	        listaProducto = q.setFirstResult(pagInicio)
						  .setMaxResults(pagFin)
						  .getResultList(); 
		
		return listaProducto;
	}
	
	
}
