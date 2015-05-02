package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.entities.Estadocuentacliente;
import com.entities.Letracliente;
import com.entities.Letraproveedor;
import com.interfaces.dao.IEstadoCuentaClienteDao;
import com.util.Constantes;
import com.util.Fechas;

public class EstadoCuentaClienteDao extends GenericaDao implements IEstadoCuentaClienteDao {
	
	@Override
	public List<Estadocuentacliente> listaEstadocuentacliente(int pagInicio, int pagFin, Estadocuentacliente estadoCuentaCliente) {
		String q ;
		List<Estadocuentacliente> listaEstadocuentacliente = null ;
		String where="";
    	
		if(estadoCuentaCliente!=null){
			if(estadoCuentaCliente.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(estadoCuentaCliente.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+estadoCuentaCliente.getcEstadoCodigo()+"%'";
	        }
	         System.out.println(" where ="+ where);
	    	    q = "select p.venta from Estadocuentacliente p " +
	    	    		 " JOIN FETCH p.venta "+
	    	             " JOIN FETCH p.cliente " + where;/**/
	    	    
	    	    listaEstadocuentacliente = listaEntidadPaginada(q, pagInicio, pagFin);

			
	 
		}//else , lista simple	        
 			
		
        return listaEstadocuentacliente;
	}

	@Override
	public List<Object[]> listaVenta(int pagInicio,
			int pagFin ,Estadocuentacliente estadocuentacliente) {
		Query q ;
		List<Object[]> listaIngresoProducto = null ;
		String where="";
    	
		if(estadocuentacliente.getCliente().getvClienteCodigo()!=null){
			where+= " and c.vClienteCodigo = '"+estadocuentacliente.getCliente().getvClienteCodigo()+"'";
		}
		if(estadocuentacliente.getVenta().getnVentaNumero()!=null){
			where+= " and v.nVentaNumero= '"+estadocuentacliente.getVenta().getnVentaNumero()+"'";
        }
		if(estadocuentacliente.getVenta().getdVentaFecha()!=null){
			where+= " and v.dVentaFecha= '"+Fechas.fechaYYMMDD(estadocuentacliente.getVenta().getdVentaFecha())+"'";
		}
		if(estadocuentacliente.getVenta().getfVentaTotal()>0){
			where+= " and v.fVentaTotal= '"+estadocuentacliente.getVenta().getfVentaTotal()+"'";
		}
		if(estadocuentacliente.getVenta().getTipoDocumento().getiTipoDocumentoGestionId()>0){
			where+= " and v.iTipoDocumentoId= '"+estadocuentacliente.getVenta().getTipoDocumento().getiTipoDocumentoGestionId()+"'";
		}
		if(estadocuentacliente.getVenta().getFormaPago().getiFormaPago()>0){
			where+= " and v.iFormaPago= '"+estadocuentacliente.getVenta().getFormaPago().getiFormaPago()+"'";
		}
			String sql= "SELECT v.iClienteId AS ID, " +
					" c.vClienteCodigo AS CODIDO, "+
	         		" c.vClienteRazonSocial AS NOMBRES, "+
                    " (SELECT count(iVentaId) FROM venta WHERE iClienteId = v.iClienteId and vEstadoDocumento ='"+Constantes.estadoDocumentoDeuda+"' and cEstadoCodigo ='"+Constantes.estadoActivo+"') AS NROFACTURAS,"+
                    " (SELECT SUM(fVentaTotal) FROM venta WHERE iClienteId = v.iClienteId and vEstadoDocumento ='"+Constantes.estadoDocumentoDeuda+"' and cEstadoCodigo ='"+Constantes.estadoActivo+"') AS MOTOTALVENTA,"+
                    " (min(v.dVentaFecha)) AS FVENTA,sum(e.fMontoPago) AS MOTOTALPAGO,"+
                    " (max(e.dFechaPago))AS FPAGO ,"+
                    " v.vEstadoDocumento AS ESTADO"+
                    " FROM Venta v"+
                    " LEFT JOIN Estadocuentacliente e"+
                    " ON( e.iVentaId=v.iVentaId)"+
                    " INNER JOIN Cliente c"+
                    " ON(v.iClienteId=c.iClienteId)"+
                    " WHERE (v.vEstadoDocumento ='"+Constantes.estadoDocumentoDeuda+"' and v.cEstadoCodigo ='"+Constantes.estadoActivo+"' and e.cEstadoCodigo ='"+Constantes.estadoActivo+"')"+ where +
                    " GROUP BY vClienteRazonSocial ";
			 System.out.println("sql= "+sql);
	    	    q = getInstancia().createNativeQuery(sql);
	    	    q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	    	    
	    	    listaIngresoProducto = q.getResultList(); 
				
		 
	   
 			
		
        return listaIngresoProducto;
	}
	

	@Override
	public List<Letracliente> listaLetraCliente(int pagInicio, int pagFin,
			Letracliente letraCliente) {
		String q ;
		List<Letracliente> listaLetra= null ;
		String where="";
    	
		if(letraCliente!=null){
			if(letraCliente.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(letraCliente.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+letraCliente.getcEstadoCodigo()+"%'";
	        }
			if(letraCliente.getVenta()!=null && letraCliente.getVenta().getnVentaNumero()!=null ){
	        	where+= " and p.ingresoProducto.nIngresoProductoNumero LIKE '%"+letraCliente.getVenta().getnVentaNumero()+"%'";
	        }			
			if(letraCliente.getCliente()!=null  && letraCliente.getCliente().getvClienteCodigo()!=null){
	        	where+= " and p.proveedor.cProveedorCodigo LIKE '%"+letraCliente.getCliente().getvClienteCodigo()+"%'";
	        }
			if(letraCliente.getCliente()!=null  && letraCliente.getCliente().getvClienteRazonSocial()!=null){
	        	where+= " and p.proveedor.vProveedorRazonSocial LIKE '%"+letraCliente.getCliente().getvClienteRazonSocial()+"%'";
	        }
			if(letraCliente.getnNumeroLetra()>0){
	        	where+= " and p.nNumeroLetra>='"+letraCliente.getnNumeroLetra()+"'";
	        }
			if(letraCliente.getnNumeroUnico()!=null){
	        	where+= " and p.nNumeroUnico>='"+letraCliente.getnNumeroLetra()+"'";
	        }
			if(letraCliente.getnNumeroLetra()>0){
	        	where+= " and p.nNumeroLetra>='"+letraCliente.getnNumeroUnico()+"'";
	        }
			if(letraCliente.getnImporte()>0){
	        	where+= " and p.nImporte>='"+letraCliente.getnImporte()+"'";
	        }			
			if(letraCliente.getdFechaGiro()!=null ){
	        	where+= " and p.dFechaGiro LIKE '%"+Fechas.fechaYYMMDD(letraCliente.getdFechaGiro())+"%'";
	        }
			if(letraCliente.getdFechaGiro()!=null && letraCliente.getdFechaActualiza()!=null){
	        	where+= " and p.dFechaGiro BETWEEN '"+Fechas.fechaYYMMDD(letraCliente.getdFechaGiro())+"' and '"+Fechas.fechaYYMMDD(letraCliente.getdFechaActualiza())+"'";
	        }
			
	            q = "select p from Letracliente p "+ where +" order by p.dFechaVencimiento asc";/**/
	    	    
	    	    listaLetra = listaEntidadPaginada(q, pagInicio, pagFin);

			
		}// lista con busqueda
		
		
        return listaLetra;
	}

	
}
