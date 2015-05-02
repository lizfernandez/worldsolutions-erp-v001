package com.dao;

import java.util.List;

import javax.persistence.Query;

import com.entities.Clasificacioncliente;
import com.entities.Cliente;
import com.interfaces.dao.IClienteDao;
import com.util.Constantes;


public class ClienteDao  extends GenericaDao implements IClienteDao {
	@Override
	public List<Cliente> listaCliente(int pagInicio, int pagFin, Cliente cliente) {
		String q ;
		List<Cliente> listaCliente = null ;
		String where="";
    	
		if(cliente!=null){
			if(cliente.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }			
			if(cliente.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+cliente.getcEstadoCodigo()+"%'";
	        }
			if(cliente.getiClienteId()>0){
	        	where+= " and p.iClienteId = "+cliente.getiClienteId()+"";
	        }
	        if(cliente.getvClienteCodigo()!=null){
	        	where+=" and  p.vClienteCodigo LIKE '%"+cliente.getvClienteCodigo()+"%'";
	        }
	        if(cliente.getvClienteRazonSocial()!=null){
	        	where+=" and  p.vClienteRazonSocial LIKE '%"+cliente.getvClienteRazonSocial()+"%'";
	        }
	        if(cliente.getnClienteNumeroDocumento()!=null){
	        	where+=" and  p.nClienteNumeroDocumento LIKE '%"+cliente.getnClienteNumeroDocumento()+"%'";
	        }
	        if(cliente.getnClienteTelefono()!=null){
	        	where+=" and  p.nClienteTelefono LIKE '%"+cliente.getnClienteTelefono()+"'";
	        }
	        if(cliente.getDireccionclientes()!=null){
	        	where+=" and  p.direccionclientes.vDireccion LIKE '%"+cliente.getDireccionclientes().get(0).getvDireccion()+"'";
	        }
	        if(cliente.getDireccionclientes()!=null){
	        	where+=" and  p.direccionclientes.iPoblacionId= '"+cliente.getDireccionclientes().get(0).getiPoblacionId()+"'";
	        }
	       
	        System.out.println(" where ="+ where);
	    	    q = "select p from Cliente p " + where;
	    	    
	    	    listaCliente = listaEntidadPaginada(q, pagInicio, pagFin);

			
		}
        return listaCliente;
	}


	@Override
	public List<Clasificacioncliente> listaClasificacionCliente(int pagInicio, int pagFin,
			Clasificacioncliente clasifcliente) {
			String q ;
			List<Clasificacioncliente> listaCliente = null ;
			String where="";
	    	
			if(clasifcliente!=null){
				if(clasifcliente.getcEstadoCodigo()==null){
		        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
		        }			
				if(clasifcliente.getcEstadoCodigo()!=null){
		        	where+= " where p.cEstadoCodigo LIKE '%"+clasifcliente.getcEstadoCodigo()+"%'";
		        }
				if(clasifcliente.getiClasificacionClienteId()>0){
		        	where+= " and p.iClasificacionClienteId = "+clasifcliente.getiClasificacionClienteId()+"";
		        }
		        
		        if(clasifcliente.getvNombre()!=null){
		        	where+=" and  p.vNombre LIKE '%"+clasifcliente.getvNombre()+"%'";
		        }
		        
		       
		        System.out.println(" where ="+ where);
		    	    q = "select p from Clasificacioncliente p " + where;
		    	    
		    	    listaCliente = listaEntidadPaginada(q, pagInicio, pagFin);

				
			}
	        return listaCliente;
	}
}
