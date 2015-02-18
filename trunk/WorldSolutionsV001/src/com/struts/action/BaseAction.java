package com.struts.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.actions.DispatchAction;

import com.dao.IngresoProductoDao;
import com.dao.VentaDao;
import com.entities.Estadocuentacliente;
import com.entities.Estadocuentaproveedor;
import com.entities.Ingresoproducto;
import com.entities.Venta;
import com.entities.vo.EstadoCuentaVo;
import com.struts.form.EstadoCuentaClienteForm;
import com.util.Constantes;
import com.util.Paginacion;

public class BaseAction  extends DispatchAction {

	protected List<EstadoCuentaVo> listarEstadoCuentaCliente(Venta venta, VentaDao ventaDao, int paginaInicio, int paginaFin) {

		List<EstadoCuentaVo> listaEstadoCuenta = new ArrayList<EstadoCuentaVo>();

		/** Accedemos al Dao **/
		List<Venta> listaVenta = ventaDao.listaEstadoCuentaPorCliente(paginaInicio, paginaFin, venta, 0);
		float montosTotales = 0;
		float pagosTotales = 0;
		float saldosTotales = 0;
		int i = 0;

		for (Venta obj : listaVenta) {
			float pagoTotal = 0;
			float saldoTotal = 0;
			EstadoCuentaVo estadoCuenta = new EstadoCuentaVo();

			estadoCuenta.setVenta(obj);
			if (obj.getEstadocuentaclientes().size() > 0) {

				for (Estadocuentacliente obje : obj.getEstadocuentaclientes()) {
					if (obje.getcEstadoCodigo().equals(Constantes.estadoActivo)) {
						pagoTotal += obje.getfMontoPago();
						pagosTotales += obje.getfMontoPago();
						// e.setEstadocuenta(obj.getEstadocuentaclientes());
					}
				} // for

			} // if

			saldoTotal = obj.getfVentaTotal() - pagoTotal;
			montosTotales += obj.getfVentaTotal();
			saldosTotales = (montosTotales - pagosTotales);
			estadoCuenta.setPagoTotal(pagoTotal);
			estadoCuenta.setSaldoTotal(saldoTotal);

			i++;

			if (i == listaVenta.size()) {
				estadoCuenta.setMontosTotales(montosTotales);
				estadoCuenta.setPagosTotales(pagosTotales);
				estadoCuenta.setSaldosTotales(saldosTotales);

			}

			listaEstadoCuenta.add(estadoCuenta);

		}
		return listaEstadoCuenta;

	}
	
	protected List<EstadoCuentaVo> listaEstadoCuentaPorProveedor(Ingresoproducto ingresoProducto, IngresoProductoDao ingresoproductoDao, int paginaInicio, int paginaFin) {

	

		 /**Seteamos los valores en las listas**/
		List<EstadoCuentaVo> listaEstadoCuenta = new ArrayList<EstadoCuentaVo>();
			
			
			/**Accedemos al Dao**/
		List<Ingresoproducto>  listaIngresoproducto = ingresoproductoDao.listaEstadoCuentaPorProveedor(paginaInicio,paginaFin,ingresoProducto,0);
			    float montosTotales =  0;
			    float pagosTotales =  0;
			    float saldosTotales = 0;
			    int i=0;
			    
			    
			 for(Ingresoproducto obj:listaIngresoproducto)
			 {   float pagoTotal=0;
			 float saldoTotal = 0;
				 EstadoCuentaVo e = new EstadoCuentaVo();
			     
	            	e.setIngresoProducto(obj);
			     if(obj.getEstadocuentaproveedors().size()>0){
			    	
			    	 
				     for(Estadocuentaproveedor obje:obj.getEstadocuentaproveedors()){
				    	if(obje.getcEstadoCodigo().equals(Constantes.estadoActivo)){
				    	 pagoTotal+= obje.getfMontoPago();						    	
				    	 pagosTotales+= obje.getfMontoPago();
				    	
				    	// listaEstaProve.add(pagoEsta);
				    	}
				       } // for
				     e.setEstadocuenta(obj.getEstadocuentaproveedors());
			     } // if
				   
					
		
			     saldoTotal = obj.getfIngresoProductoTotal() -pagoTotal;
			     montosTotales+= obj.getfIngresoProductoTotal();
				 saldosTotales=(montosTotales - pagosTotales);
			     e.setPagoTotal(pagoTotal);
			     e.setSaldoTotal(saldoTotal);
		
				i++;
				
				if(i==listaIngresoproducto.size()){
					e.setMontosTotales(montosTotales);
					e.setPagosTotales(pagosTotales);
					e.setSaldosTotales(saldosTotales);
					
				}
			     
			     listaEstadoCuenta.add(e);
			     
			 }
			return listaEstadoCuenta;

	}
}
