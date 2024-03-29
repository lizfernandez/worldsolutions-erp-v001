package com.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.entities.Ingresoproducto;
import com.entities.Ingresoproductodetalle;
import com.entities.Ingresoproductodevolucion;
import com.entities.Letraproveedor;
import com.entities.Ordencompra;
import com.interfaces.dao.IIngresoProductoDao;
import com.util.Constantes;
import com.util.Fechas;

public class IngresoProductoDao extends GenericaDao implements IIngresoProductoDao {
	
	
	private static final String PERSISTENCE_UNIT_NAME = "Stuct12";
	private static EntityManagerFactory factory;
	
	@Override
	public List<Ingresoproducto> listaIngresoproducto(int pagInicio, int pagFin, Ingresoproducto ingresoproducto) {
		/*factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();     */
		String q ;
		List<Ingresoproducto> listaIngresoproducto = null ;
		String where="";
    	
		if(ingresoproducto!=null){
			
			if(ingresoproducto.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(ingresoproducto.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+ingresoproducto.getcEstadoCodigo()+"%'";
	        }
			
			if(ingresoproducto.getiPeriodoId()>0){
	        	where+= " and p.iPeriodoId ='"+ingresoproducto.getiPeriodoId()+"'";
	        }
			if(ingresoproducto.getProveedor()!=null  && ingresoproducto.getProveedor().getcProveedorCodigo()!=null){
	        	where+= " and p.proveedor.cProveedorCodigo LIKE '%"+ingresoproducto.getProveedor().getcProveedorCodigo()+"%'";
	        }
			if(ingresoproducto.getProveedor()!=null  && ingresoproducto.getProveedor().getvProveedorRazonSocial()!=null){
	        	where+= " and p.proveedor.vProveedorRazonSocial LIKE '%"+ingresoproducto.getProveedor().getvProveedorRazonSocial()+"%'";
	        }
			if(ingresoproducto.getFormaPago()!=null && ingresoproducto.getFormaPago().getiFormaPago()!=00){
	        	where+= " and p.formaPago.iFormaPago='"+ingresoproducto.getFormaPago().getiFormaPago()+"'";
	        }
			if(ingresoproducto.getTipodocumento()!=null && ingresoproducto.getTipodocumento().getiTipoDocumentoGestionId()!=00){
	        	where+= " and p.tipodocumento.iTipoDocumentoGestionId='"+ingresoproducto.getTipodocumento().getiTipoDocumentoGestionId()+"'";
	        }
			if(ingresoproducto.getfIngresoProductoTotal()>0.0){
	        	where+= " and p.fIngresoProductoTotal>='"+ingresoproducto.getfIngresoProductoTotal()+"'";
	        }
			if(ingresoproducto.getnIngresoProductoNumero()!=null){
	        	where+= " and p.nIngresoProductoNumero LIKE '%"+ingresoproducto.getnIngresoProductoNumero()+"%'";
	        }
			if(ingresoproducto.getdIngresoProductoFecha()!=null ){
	        	where+= " and p.dIngresoProductoFecha LIKE '%"+Fechas.fechaYYMMDD(ingresoproducto.getdIngresoProductoFecha())+"%'";
	        }
			if(ingresoproducto.getdIngresoProductoFecha()!=null && ingresoproducto.getdFechaActualiza()!=null){
	        	where+= " and p.dIngresoProductoFecha BETWEEN '"+Fechas.fechaYYMMDD(ingresoproducto.getdIngresoProductoFecha())+"' and '"+Fechas.fechaYYMMDD(ingresoproducto.getdFechaActualiza())+"'";
	        }
			System.out.println(where);
	    	    q = "select p from Ingresoproducto p " + where + "order by p.dIngresoProductoFecha desc";/**/
	    	    
	    	    listaIngresoproducto = listaEntidadPaginada(q, pagInicio, pagFin);

			
		}// lista con busqueda
//		else{
//				q= getInstancia().createQuery("select p from Ingresoproducto p " +
//		    	   		                    " where p.cEstadoCodigo = :EstadoCodigo");
//				listaIngresoproducto = q.setParameter("EstadoCodigo", Constantes. estadoActivo)
//												  .setFirstResult(pagInicio)
//												  .setMaxResults(pagFin)
//												  .getResultList(); 
//				
//		 
//		}//else , lista simple	        

		
        return listaIngresoproducto;
	}
    
	@Override
	public List<Ingresoproducto> listaEstadoCuentaPorProveedor(int pagInicio, int pagFin, Ingresoproducto ingresoproducto, int iProveedorId) {
		/*factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();     */
		String q ;
		List<Ingresoproducto> listaIngresoproducto = null ;
		String where="";
    	
		if(ingresoproducto!=null){
			if(ingresoproducto.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(ingresoproducto.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+ingresoproducto.getcEstadoCodigo()+"%'";
	        }
			
			if(ingresoproducto.getvEstadoDocumento()!=null){
	        	where+= " and p.vEstadoDocumento LIKE '%"+ingresoproducto.getvEstadoDocumento()+"%'";
	        }
			if(ingresoproducto.getTipodocumento()!=null){
	        	where+= " and p.tipodocumento.iTipoDocumentoGestionId LIKE '%"+ingresoproducto.getTipodocumento().getiTipoDocumentoGestionId()+"%'";
	        }
			
			if(ingresoproducto.getProveedor()!=null  && ingresoproducto.getProveedor().getcProveedorCodigo()!=null){
	        	where+= " and p.proveedor.cProveedorCodigo LIKE '%"+ingresoproducto.getProveedor().getcProveedorCodigo()+"%'";
	        }
			if(ingresoproducto.getProveedor()!=null  && ingresoproducto.getProveedor().getvProveedorRazonSocial()!=null){
	        	where+= " and p.proveedor.vProveedorRazonSocial LIKE '%"+ingresoproducto.getProveedor().getvProveedorRazonSocial()+"%'";
	        }
			if(ingresoproducto.getFormaPago()!=null && ingresoproducto.getFormaPago().getiFormaPago()!=0){
	        	where+= " and p.formaPago.iFormaPago="+ingresoproducto.getFormaPago().getiFormaPago();
	        } else {
	        	where+= " and p.formaPago.vFormaPagoDescripcion LIKE '%"+Constantes.formaPagoCredito + "%'";
	        }
			if(ingresoproducto.getTipodocumento()!=null && ingresoproducto.getTipodocumento().getiTipoDocumentoGestionId()!=00){
	        	where+= " and p.tipodocumento.iTipoDocumentoGestionId='"+ingresoproducto.getTipodocumento().getiTipoDocumentoGestionId()+"'";
	        }
			if(ingresoproducto.getfIngresoProductoTotal()>0.0){
	        	where+= " and p.fIngresoProductoTotal>='"+ingresoproducto.getfIngresoProductoTotal()+"'";
	        }
			if(ingresoproducto.getnIngresoProductoNumero()!=null){
	        	where+= " and p.nIngresoProductoNumero LIKE '%"+ingresoproducto.getnIngresoProductoNumero()+"%'";
	        }
			if(ingresoproducto.getdIngresoProductoFecha()!=null ){
	        	where+= " and p.dIngresoProductoFecha LIKE '%"+Fechas.fechaYYMMDD(ingresoproducto.getdIngresoProductoFecha())+"%'";
	        }
			if(ingresoproducto.getdIngresoProductoFecha()!=null && ingresoproducto.getdFechaActualiza()!=null){
	        	where+= " and p.dIngresoProductoFecha BETWEEN '"+Fechas.fechaYYMMDD(ingresoproducto.getdIngresoProductoFecha())+"' and '"+Fechas.fechaYYMMDD(ingresoproducto.getdFechaActualiza())+"'";
	        }
			
			
	          System.out.println(" where ingreso Producto Estado Cuenta ="+ where);
	    	    q = "select p from Ingresoproducto p  JOIN FETCH p.proveedor " + where +" order by p.dIngresoProductoFecha desc";/**/
	    	    
	    	    listaIngresoproducto = listaEntidadPaginada(q, pagInicio, pagFin);

			
		}// lista con busqueda
		
		
        return listaIngresoproducto;
	}
	
	public List<Ingresoproductodevolucion> listaIngresoproductoDevolucion(
			int pagInicio, int pagFin,
			Ingresoproducto ingresoproductodev) {
		/*factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();*/     
		String q ;
		List<Ingresoproductodevolucion> listaIngresoproducto = null ;
		String where="";
    	
		if(ingresoproductodev!=null){
			if(ingresoproductodev.getcEstadoCodigo()==null){
	        	where+= " where p.vEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(ingresoproductodev.getcEstadoCodigo()!=null){
	        	where+= " where p.vEstadoCodigo LIKE '%"+ingresoproductodev.getcEstadoCodigo()+"%'";
	        }
			if(ingresoproductodev==null){
	        	where+= " and p.ingresoProducto.vEstadoDocumento  LIKE '%"+Constantes.estadoDocumentoDevuelto+"%'";
	        }
			if(ingresoproductodev.getProveedor()!=null){
	        	where+= " and p.ingresoProducto.proveedor.cProveedorCodigo='"+ingresoproductodev.getProveedor().getcProveedorCodigo()+"'";
	        }
			if(ingresoproductodev.getFormaPago()!=null && ingresoproductodev.getFormaPago().getiFormaPago()!=00){
	        	where+= " and p.ingresoProducto.formaPago.iFormaPago='"+ingresoproductodev.getFormaPago().getiFormaPago()+"'";
	        }
			if(ingresoproductodev.getTipodocumento()!=null && ingresoproductodev.getTipodocumento().getiTipoDocumentoGestionId()!=00){
	        	where+= " and p.ingresoProducto.tipodocumento.iTipoDocumentoGestionId='"+ingresoproductodev.getTipodocumento().getiTipoDocumentoGestionId()+"'";
	        }
			if(ingresoproductodev.getfIngresoProductoTotal()>0.0){
	        	where+= " and p.fIngresoProductoDev>='"+ingresoproductodev.getfIngresoProductoTotal()+"'";
	        }
			if(ingresoproductodev.getnIngresoProductoNumero()!=null){
	        	where+= " and p.ingresoProducto.nIngresoProductoNumero LIKE '%"+ingresoproductodev.getnIngresoProductoNumero()+"%'";
	        }
			if(ingresoproductodev.getdIngresoProductoFecha()!=null ){
	        	where+= " and p.dIngresoProductoDevFecha LIKE '%"+Fechas.fechaYYMMDD(ingresoproductodev.getdIngresoProductoFecha())+"%'";
	        }
			if(ingresoproductodev.getdIngresoProductoFecha()!=null && ingresoproductodev.getdFechaActualiza()!=null){
	        	where+= " and p.dIngresoProductoDevFecha BETWEEN '"+Fechas.fechaYYMMDD(ingresoproductodev.getdIngresoProductoFecha())+"' and '"+Fechas.fechaYYMMDD(ingresoproductodev.getdFechaActualiza())+"'";
	        }
	    	System.out.println(where);   
			q = "select p from Ingresoproductodevolucion p " + where + "order by p.dIngresoProductoDevFecha desc";/**/
	    	    
	    	    listaIngresoproducto = listaEntidadPaginada(q, pagInicio, pagFin);

			
		}// lista con busqueda
		return 	  listaIngresoproducto;
	}

	@Override
	public List<Ingresoproductodetalle> buscarIngresoproductoDetalle(
			int iIngresoproductoId) {
		// TODO Auto-generated method stub
		/*factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();     */
		Query q ;
		List<Ingresoproductodetalle> listaIngresoproducto = null ;

        
  	    q = getInstancia().createQuery("select p from Ingresoproductodetalle p where p.ingresoproducto.iIngresoProductoId="+iIngresoproductoId);/**/
  	    q.setHint(QueryHints.REFRESH, HintValues.TRUE);
  	    listaIngresoproducto = q.getResultList(); 
System.out.println("listado listaIngresoproducto "+listaIngresoproducto.size());
		return listaIngresoproducto;
	}

	@Override
	public List<Letraproveedor> listaLetraProveedor(int pagInicio, int pagFin,
			Letraproveedor letraProveedor) {
		Query q ;
		List<Letraproveedor> listaLetra= null ;
		String where="";
    	
		if(letraProveedor!=null){
			if(letraProveedor.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(letraProveedor.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+letraProveedor.getcEstadoCodigo()+"%'";
	        }
			if(letraProveedor.getIngresoProducto()!=null && letraProveedor.getIngresoProducto().getnIngresoProductoNumero()!=null ){
	        	where+= " and p.ingresoProducto.nIngresoProductoNumero LIKE '%"+letraProveedor.getIngresoProducto().getnIngresoProductoNumero()+"%'";
	        }			
			if(letraProveedor.getProveedor()!=null  && letraProveedor.getProveedor().getcProveedorCodigo()!=null){
	        	where+= " and p.proveedor.cProveedorCodigo LIKE '%"+letraProveedor.getProveedor().getcProveedorCodigo()+"%'";
	        }
			if(letraProveedor.getProveedor()!=null  && letraProveedor.getProveedor().getvProveedorRazonSocial()!=null){
	        	where+= " and p.proveedor.vProveedorRazonSocial LIKE '%"+letraProveedor.getProveedor().getvProveedorRazonSocial()+"%'";
	        }
			if(letraProveedor.getnNumeroLetra()>0){
	        	where+= " and p.nNumeroLetra>='"+letraProveedor.getnNumeroLetra()+"'";
	        }
			if(letraProveedor.getnNumeroUnico()>0){
	        	where+= " and p.nNumeroUnico>='"+letraProveedor.getnNumeroLetra()+"'";
	        }
			if(letraProveedor.getnNumeroLetra()>0){
	        	where+= " and p.nNumeroLetra>='"+letraProveedor.getnNumeroUnico()+"'";
	        }
			if(letraProveedor.getnImporte()>0){
	        	where+= " and p.nImporte>='"+letraProveedor.getnImporte()+"'";
	        }			
			if(letraProveedor.getdFechaGiro()!=null ){
	        	where+= " and p.dFechaGiro LIKE '%"+Fechas.fechaYYMMDD(letraProveedor.getdFechaGiro())+"%'";
	        }
			if(letraProveedor.getdFechaGiro()!=null && letraProveedor.getdFechaActualiza()!=null){
	        	where+= " and p.dFechaGiro BETWEEN '"+Fechas.fechaYYMMDD(letraProveedor.getdFechaGiro())+"' and '"+Fechas.fechaYYMMDD(letraProveedor.getdFechaActualiza())+"'";
	        }
			
	            q = getInstancia().createQuery("select p from Letraproveedor p "+ where +" order by p.dFechaVencimiento asc");/**/
	            q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	    	    listaLetra = q.setFirstResult(pagInicio)
							  .setMaxResults(pagFin)
							  .getResultList(); 

			
		}// lista con busqueda
		
		
        return listaLetra;
	}

	@Override
	public List<Ordencompra> listaOrdenCompra(int pagInicio, int pagFin,
			Ordencompra ordenCompra) {
		String q ;
		List<Ordencompra> listaIngresoproducto = null ;
		String where="";
    	
		if(ordenCompra!=null){
			
			if(ordenCompra.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(ordenCompra.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+ordenCompra.getcEstadoCodigo()+"%'";
	        }
			
			if(ordenCompra.getPeriodo()!=null){
	        	where+= " and p.iPeriodoId ='"+ordenCompra.getPeriodo().getiPeriodoId()+"'";
	        }
			if(ordenCompra.getProveedor()!=null  && ordenCompra.getProveedor().getcProveedorCodigo()!=null){
	        	where+= " and p.proveedor.cProveedorCodigo LIKE '%"+ordenCompra.getProveedor().getcProveedorCodigo()+"%'";
	        }
			if(ordenCompra.getProveedor()!=null  && ordenCompra.getProveedor().getvProveedorRazonSocial()!=null){
	        	where+= " and p.proveedor.vProveedorRazonSocial LIKE '%"+ordenCompra.getProveedor().getvProveedorRazonSocial()+"%'";
	        }
			
			if(ordenCompra.getTipoDocumento()!=null && ordenCompra.getTipoDocumento().getiTipoDocumentoGestionId()!=00){
	        	where+= " and p.tipoDocumento.iTipoDocumentoGestionId='"+ordenCompra.getTipoDocumento().getiTipoDocumentoGestionId()+"'";
	        }
			if(ordenCompra.getfTotal()>0.0){
	        	where+= " and p.fTotal>='"+ordenCompra.getfTotal()+"'";
	        }
			if(ordenCompra.getvNroOrden()!=null){
	        	where+= " and p.vNroOrden LIKE '%"+ordenCompra.getvNroOrden()+"%'";
	        }
			if(ordenCompra.getdFechaPedido()!=null ){
	        	where+= " and p.dFechaPedido LIKE '%"+Fechas.fechaYYMMDD(ordenCompra.getdFechaPedido())+"%'";
	        }
			if(ordenCompra.getdFechaPedido()!=null && ordenCompra.getdFechaActualiza()!=null){
	        	where+= " and p.dFechaPedido BETWEEN '"+Fechas.fechaYYMMDD(ordenCompra.getdFechaPedido())+"' and '"+Fechas.fechaYYMMDD(ordenCompra.getdFechaActualiza())+"'";
	        }
			System.out.println(where);
	    	    q = "select p from Ordencompra p " + where + "order by p.dFechaPedido desc";/**/
	    	    
	    	    listaIngresoproducto = listaEntidadPaginada(q, pagInicio, pagFin);

			
		}// lista con busqueda
//		else{
//				q= getInstancia().createQuery("select p from Ingresoproducto p " +
//		    	   		                    " where p.cEstadoCodigo = :EstadoCodigo");
//				listaIngresoproducto = q.setParameter("EstadoCodigo", Constantes. estadoActivo)
//												  .setFirstResult(pagInicio)
//												  .setMaxResults(pagFin)
//												  .getResultList(); 
//				
//		 
//		}//else , lista simple	        

		
        return listaIngresoproducto;
	}

	
	
}
