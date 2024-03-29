package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.entities.Almacen;
import com.entities.Distalmacen;
import com.entities.Ordencompra;
import com.entities.Produccion;
import com.entities.Producciondetalle;
import com.entities.Producto;
import com.entities.Productoalmacen;
import com.interfaces.dao.IProductoDao;
import com.util.Constantes;



public  class ProductoDao  extends GenericaDao implements IProductoDao {
	
	@SuppressWarnings("unchecked")
	public List<Producto> listaProducto(int pagInicio, int pagFin, Producto producto, int iclasificacionId, int iSucursal) {
	  
		Query q ;
		List<Producto> listaProducto = null ;
		String where=""; 
	
		if (iSucursal > 0) {
			where += "LEFT JOIN p.productoAlmacendetallles a ";
		}

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
			/*if(iSucursal>0){
	        	where+= " and p.sucursal.iSucursalId LIKE '%"+iSucursal+"%'";
	        }
	        */
			if(producto.getcProductoCodigo()!=null){
	        	where+=" and  p.cProductoCodigo LIKE '%"+producto.getcProductoCodigo()+"%'";
	        }
			if(producto.getvProductoNombre()!=null){
	        	where+=" and  p.vProductoNombre LIKE '%"+producto.getvProductoNombre()+"%'";
	        }
	        if(producto.getiProductoStockTotal()>0){
	        	where+=" and  p.iProductoStockTotal LIKE '%"+producto.getiProductoStockTotal()+"%'";
	        }
	        if(producto.getUnidadMedida()!=null && producto.getUnidadMedida().getiUnidadMedidaId()>0){
	        	where+=" and  p.unidadMedida.iUnidadMedidaId LIKE '%"+producto.getUnidadMedida().getiUnidadMedidaId()+"%'";
	        }
	        
	        if(producto.getfProductoPrecioCompra()>0){
	        	where+=" and  p.fProductoPrecioCompra LIKE '%"+producto.getfProductoPrecioCompra()+"%'";
	        }
	        if(producto.getfProductoPrecioVenta()>0){
	        	where+=" and  p.fProductoPrecioVenta LIKE '%"+producto.getfProductoPrecioVenta()+"%'";
	        }
	        if (iSucursal > 0) {
				where += " and a.almacen.sucursal.iSucursalId = " + iSucursal;
			}
	        
	        System.out.println(" where ="+where);
	        q = getInstancia().createQuery("select  DISTINCT  p from Producto p   " + where +" order by p.vProductoNombre asc");/**/
	        q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	        listaProducto = q.setFirstResult(pagInicio)
						  .setMaxResults(pagFin)
						  .getResultList(); 
		
			}
		
        return listaProducto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produccion> listaProduccion(int pagInicio, int pagFin,
			Produccion produccion) {
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Producciondetalle> buscarDetalleProduccion(int iProduccionId) {
		Query q ;
		List<Producciondetalle> listaProduccionDetalle = null ;

        
  	    q = getInstancia().createQuery("select p from Producciondetalle p where p.produccion.iProduccionId="+iProduccionId);/**/
  	    q.setHint(QueryHints.REFRESH, HintValues.TRUE);
  	    listaProduccionDetalle = q.getResultList(); 
    
		return listaProduccionDetalle;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> listaProductoStockMinimo(int pagInicio, int pagFin,
			int iclasificacionId) {
		Query q ;
		List<Producto> listaProducto = null ;
		String where=""; 
		
		 q = getInstancia().createQuery("select p from Producto p where p.iProductoStockTotal<p.iProductoStockMinimo and p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'" + where );/**/
	        q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	        listaProducto = q.setFirstResult(pagInicio)
						  .setMaxResults(pagFin)
						  .getResultList(); 
		
		return listaProducto;
	}
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Producto> listaProductoStockMaximo(int pagInicio, int pagFin,
			int iclasificacionId) {
		Query q ;
		List<Producto> listaProducto = null ;
		String where=""; 
		
		 q = getInstancia().createQuery("select p from Producto p where p.iProductoStockTotal>p.iProductoStockMaximo and p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'" + where );/**/
	        q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	        listaProducto = q.setFirstResult(pagInicio)
						  .setMaxResults(pagFin)
						  .getResultList(); 
		
		return listaProducto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Distalmacen> listaDistAlmacen(int pagInicio, int pagFin,
			Distalmacen producto) {
		Query q ;
		List<Distalmacen> listaProducto = null ;
		String where=""; 
	
		

		if(producto!=null){
			if(producto.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }			
			if(producto.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+producto.getcEstadoCodigo()+"%'";
	        }
			
			if(producto.getiDistAlmacenId()>0){
	        	where+= " and p.iDistAlmacenId = '"+producto.getiDistAlmacenId()+"'";
	        }
			if(producto.getPeriodo()!=null && producto.getPeriodo().getiPeriodoId()>0){
	        	where+= " and p.periodo.iPeriodoId LIKE '%"+producto.getPeriodo().getiPeriodoId()+"%'";
	        }
			if(producto.getUsuarioRecepcion()!=null && producto.getUsuarioRecepcion().getiPersonalId()>0){
	        	where+= " and p.usuarioRecepcion.iPersonalId LIKE '%"+producto.getUsuarioRecepcion().getiPersonalId()+"%'";
	        }
			
	        System.out.println(" where ="+where);
	        q = getInstancia().createQuery("select  p from Distalmacen p   " + where +" order by p.dFechaIngreso asc");/**/
	        q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	        listaProducto = q.setFirstResult(pagInicio)
						  .setMaxResults(pagFin)
						  .getResultList(); 
		
			}
		
        return listaProducto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ordencompra> listaOrdenCompra(int pagInicio, int pagFin,
			Ordencompra producto) {
		Query q ;
		List<Ordencompra> listaProducto = null ;
		String where=""; 
	
		

		if(producto!=null){
			if(producto.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }			
			if(producto.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+producto.getcEstadoCodigo()+"%'";
	        }
			
			if(producto.getiOrdenCompraId()>0){
	        	where+= " and p.iOrdenCompraId = '"+producto.getiOrdenCompraId()+"'";
	        }
			if(producto.getPeriodo()!=null && producto.getPeriodo().getiPeriodoId()>0){
	        	where+= " and p.periodo.iPeriodoId LIKE '%"+producto.getPeriodo().getiPeriodoId()+"%'";
	        }
			if(producto.getvNroOrden()!=null ){
	        	where+= " and p.vNroOrden LIKE '%"+producto.getvNroOrden()+"%'";
	        }
			if(producto.getdFechaPedido()!=null ){
	        	where+= " and p.dFechaPedido LIKE '%"+producto.getdFechaPedido()+"%'";
	        }
			if(producto.getProveedor()!=null && producto.getProveedor().getiProveedorId()>0){
	        	where+= " and p.proveedor.iProveedorId LIKE '%"+ producto.getProveedor().getiProveedorId()+"%'";
	        }
	        System.out.println(" where ="+where);
	        q = getInstancia().createQuery("select  DISTINCT  p from Ordencompra p   " + where +" order by p.dFechaPedido asc");/**/
	        q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	        listaProducto = q.setFirstResult(pagInicio)
						  .setMaxResults(pagFin)
						  .getResultList(); 
		
			}
		
        return listaProducto;
	}

	@Override
	public Productoalmacen obtenerProductoAlmacen(int iProductoId, int iAlmacen) {
		// TODO Auto-generated method stub
		Query q ;
		Productoalmacen listaProducto = null ;
		String where="";
		q = getInstancia().createQuery("select  p from Productoalmacen p  where p.producto.iProductoId="+iProductoId+" and p.almacen.iAlmacenId="+iAlmacen);/**/
        q.setHint(QueryHints.REFRESH, HintValues.TRUE);
        listaProducto = (Productoalmacen) q.getSingleResult(); 
	
		
	
         return listaProducto;
		
	}

	@Override
	public List<Distalmacen> listaDistAlmacenvNroSalida(String vNroSalida) {
		// TODO Auto-generated method stub
		
		Query q ;
		 List<Distalmacen> listaProducto = null ;
		String where="";
		q = getInstancia().createQuery("select  p from Distalmacen p  where p.vNroSalida=:vNroSalida");/**/
        q.setHint(QueryHints.REFRESH, HintValues.TRUE);
        listaProducto = ( List<Distalmacen>) q.setParameter("vNroSalida", vNroSalida).getResultList(); 
	
		
	
         return listaProducto;
	}
	
	
}
