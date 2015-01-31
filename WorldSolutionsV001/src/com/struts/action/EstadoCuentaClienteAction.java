package com.struts.action;

import java.io.IOException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.dao.ContabilidadDao;
import com.dao.EstadoCuentaClienteDao;
import com.dao.EstadoCuentaClienteDao;
import com.dao.EstadoDao;
import com.dao.GenericaDao;
import com.dao.IngresoProductoDao;

import com.dao.VentaDao;

import com.entities.Estado;
import com.entities.Estadocuentacliente;
import com.entities.Formapago;
import com.entities.Ingresoproducto;
import com.entities.Letracliente;
import com.entities.Tipodocumentogestion;
import com.entities.Usuario;
import com.entities.Venta;
import com.entities.vo.EstadoCuentaVo;
import com.struts.form.EstadoCuentaClienteForm;
import com.struts.form.EstadoCuentaClienteForm;
import com.util.Constantes;
import com.util.Fechas;
import com.util.FormatosNumeros;
import com.util.Paginacion;
import com.util.Util;


public class EstadoCuentaClienteAction extends DispatchAction {
	   // --------------------------------------------------------- Instance
		// Variables
		// --------------------------------------------------------- Methods

		/**
		 * Method execute
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return ActionForward
		 * @throws IOException 
		 * @throws ParseException 
		 */
		public ActionForward listaEstadoCuentaCliente(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {

			
			/***Validamos la session activa y logeada***/
			String msn = "";
			/*HttpSession sesion = request.getSession();
			
			if(sesion.getId()!=(sesion.getAttribute("id"))){
				response.sendRedirect("login.do?metodo=logout");				
			}
			else{
				*/
			
			/***Inicializamos variables***/
				
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if(request.getParameter("pagina")!= null){
				 pagina = Integer.parseInt(request.getParameter("pagina"));
			}
			String  vClienteCodigo = request.getParameter("vClienteCodigo");
			String  iTipoDocumentoId = request.getParameter("iTipoDocumentoId");
			String  nVentaNumero = request.getParameter("nVentaNumero");
			String  dVentaFecha = request.getParameter("dVentaFecha");
			String  fVentaTotal = request.getParameter("fVentaTotal");
			String  iFormaPago = request.getParameter("iFormaPago");   
			
			List<Long> paginas = null;
			/** Instanciamos la Clase EstadocuentaclienteForm **/
			EstadoCuentaClienteForm objform = (EstadoCuentaClienteForm) form;

	    	List<Venta> listaVenta = new ArrayList<Venta>();
			List<Venta> listaVentaTotal = new ArrayList<Venta>();
			VentaDao ventaDao = new VentaDao();
		
			 
			 /**Seteamos los valores en las listas**/
				List<EstadoCuentaVo> listaEstadoCuenta = new ArrayList<EstadoCuentaVo>();
				
				
				/**Accedemos al Dao**/
				 listaVenta = ventaDao.listaEstadoCuentaPorCliente(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getVenta(),0);
				    double montosTotales =  0.0;
				    double pagosTotales =  0.0;
				    double saldosTotales =  0.0;
				    int i=0;
				    
				    
				 for(Venta obj:listaVenta)
				 {   double pagoTotal=0.0, saldoTotal = 0.0;
					 EstadoCuentaVo e = new EstadoCuentaVo();
				     
			
				   	 e.setVenta(obj);
				     if(obj.getEstadocuentaclientes().size()>0){
			   	 
					     for(Estadocuentacliente obje:obj.getEstadocuentaclientes()){
					    	if(obje.getcEstadoCodigo().equals(Constantes.estadoActivo)){
					    	 pagoTotal+= obje.getfMontoPago();						    	
					    	 pagosTotales+= obje.getfMontoPago();
					    	// e.setEstadocuenta(obj.getEstadocuentaclientes());
					    	}
					       } // for				    
					     
				     } // if
					   
						
			
				     saldoTotal = obj.getfVentaTotal() -pagoTotal;
				     montosTotales+= obj.getfVentaTotal();
					 saldosTotales=(montosTotales - pagosTotales);
				     e.setPagoTotal(FormatosNumeros.FormatoDecimalMoneda(pagoTotal));
				     e.setSaldoTotal(FormatosNumeros.FormatoDecimalMoneda(saldoTotal));
			
					i++;
					
					if(i==listaVenta.size()){
						e.setMontosTotales((FormatosNumeros.FormatoDecimalMoneda(montosTotales)));
						e.setPagosTotales((FormatosNumeros.FormatoDecimalMoneda(pagosTotales)));
						e.setSaldosTotales((FormatosNumeros.FormatoDecimalMoneda(saldosTotales)));
						
					}
				     
				     listaEstadoCuenta.add(e);
				     
				 }
				 
			/**Consultamos el total de registros segun criterio**/
			listaVentaTotal = ventaDao.listaEstadoCuentaPorCliente(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getVenta(),0);
			
	        /**Obtenemos el total del paginas***/
			paginas = Paginacion.listPaginas((long)(listaVentaTotal.size()));
	 	     
			objform.setLista(listaEstadoCuenta);
			objform.setPaginas(paginas);
			objform.setPagInicio(pagina);;
				 
				/***Redirecionamos  al ***/
			 msn ="showList";
				
			
		  // }// else
			return mapping.findForward(msn);
		}
	
		/**
		 * Method execute
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return ActionForward
		 */
		public ActionForward mantenimientoEstadoCuentaCliente(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) {

			

			HttpSession sesion = request.getSession();			
			String mode = request.getParameter("mode");
			String msn="";
			
			
			/** Instantacia al EstadocuentaclienteForm **/			
			EstadoCuentaClienteForm estadoCuentaClienteform = (EstadoCuentaClienteForm) form;
			Estadocuentacliente obj= estadoCuentaClienteform.getEstadoCuentaCliente();
			
			/** Instantacia a la capa Dao **/
			EstadoDao estadoDao = new EstadoDao();
			GenericaDao estadoCuentaClienteDao = new GenericaDao();

			/** llamado de los metodos de la clase dao **/

			List<Estado> listaEstado = estadoDao.listEstado();
			
			estadoCuentaClienteform.setMontoTotal(Float.parseFloat(request.getParameter("montoTotal")));
			estadoCuentaClienteform.setPagoTotal(Float.parseFloat(request.getParameter("pagoTotal")));
			
			/**LLamamos al formulario mantenimientoEstadocuentacliente.jsp para la insercion de datos **/
			if(mode.equals("I")){
				estadoCuentaClienteform.setiVentaId(Integer.parseInt(request.getParameter("iVentaId")));
				estadoCuentaClienteform.setiClienteId(Integer.parseInt(request.getParameter("iClienteId")));				
				msn ="showEdit";
			}
			
			/**LLamamos al formulario mantenimientoEstadocuentacliente.jsp para mostrar los datos del UPDATE **/
			/** Seteamos el estadoCuentaClienteform la clase Estadocuentacliente **/
			else if(mode.equals("U") || mode.equals("D")){
				
				int id = Integer.parseInt(request.getParameter("id"));
				estadoCuentaClienteform.setEstadoCuentaCliente(estadoCuentaClienteDao.findEndidad(obj, id));
				
				msn ="showEdit";
				
			}
			/**LLamamos al formulario buscarMantenimientoPerfil.jsp para realizar la busqueda **/
			else if(mode.equals("F")){
				msn ="showFind";
			}
			
				estadoCuentaClienteform.setMode(mode);

			/** Colocamos en session las listas **/

			sesion.setAttribute("listaEstado", listaEstado);

			return mapping.findForward(msn);
		}

		/**
		 * Method execute
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return ActionForward
		 * @throws NoSuchFieldException 
		 * @throws IllegalAccessException 
		 * @throws ClassNotFoundException 
		 * @throws SecurityException 
		 * @throws IllegalArgumentException 
		 */
		public ActionForward iduEstadoCuentaCliente(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IllegalArgumentException, SecurityException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
			
			/** Inicializamos las variables **/ 
			String msn = "";
			String mode = request.getParameter("mode");		
			String ids = request.getParameter("ids");		
			boolean resultado = false;
		
			/** Instanciamos las clase EstadocuentaclienteForm y EstadocuentaclienteDao **/
			EstadoCuentaClienteForm pForm = (EstadoCuentaClienteForm) form;
			Estadocuentacliente obj =pForm.getEstadoCuentaCliente();
			GenericaDao estadoCuentaClienteDao = new GenericaDao();
			VentaDao ingresoProductoDao= new VentaDao();
			
			
			
	        /** Iniciamos Transacion **/

			EntityTransaction transaction = estadoCuentaClienteDao.entityTransaction();
			transaction.begin();
			if (pForm.getMode().equals("I")) {
				

				
					obj.setdFechaInserta(Fechas.getDate());
					obj.setcEstadoCodigo(Constantes.estadoActivo);
					
					/** llamamos a listar Estadocuentacliente **/
					//listaEstadocuentacliente(mapping, pForm, request, response);
					/**Actualizamos el estado a Cancelado En la tabla Ingreso Producto**/
					if((double) pForm.getfMontoPago()>(pForm.getMontoTotal())||
					   (double) pForm.getfMontoPago()>((pForm.getMontoTotal())-(pForm.getPagoTotal()))||
					   FormatosNumeros.FormatoDecimalMonedaSum((double) pForm.getfMontoPago(), (double) (pForm.getPagoTotal())).equals(FormatosNumeros.FormatoDecimalMoneda((double) (pForm.getMontoTotal())))){
						
						obj.setfMontoPago((float) ((pForm.getMontoTotal())-(pForm.getPagoTotal())));						
						estadoCuentaClienteDao.persistEndidad(obj);
						
						Venta venta = obj.getVenta();
						venta.setvEstadoDocumento(Constantes.estadoDocumentoCancelado);
						ingresoProductoDao.mergeEndidad(venta);
					}
					
					else{
						estadoCuentaClienteDao.persistEndidad(obj);
					}					
					estadoCuentaClienteDao.commitEndidad(transaction);
					estadoCuentaClienteDao.refreshEndidad(obj);
			   
				
				
			}// fin mode I;
			else if (pForm.getMode().equals("U")) {
				
			   obj = estadoCuentaClienteDao.findEndidad(obj,obj.getiEstadoCuentaCliente());
			   obj.setdFechaPago(obj.getdFechaPago());
			  
				/** llamamos a listar Estadocuentacliente **/
				//listaEstadocuentacliente(mapping, pForm, request, response);
				/**Actualizamos el estado a Cancelado En la tabla Ingreso Producto**/
			   
			   double saldo = (pForm.getPagoTotal()) - (double) obj.getfMontoPago();
			
			    if((saldo+(double) pForm.getfMontoPago())>=(pForm.getMontoTotal())){
					
				   obj.setfMontoPago((float) ((pForm.getMontoTotal()) - saldo));
					
					estadoCuentaClienteDao.mergeEndidad(obj);
					Venta venta = obj.getVenta();
					venta.setvEstadoDocumento(Constantes.estadoDocumentoCancelado);
					ingresoProductoDao.mergeEndidad(venta);
				}
			    else{
			    	obj.setfMontoPago(pForm.getfMontoPago());
					estadoCuentaClienteDao.mergeEndidad(obj);
					
					Venta venta = obj.getVenta();
					venta.setvEstadoDocumento(Constantes.estadoDocumentoDeuda);
					ingresoProductoDao.mergeEndidad(venta);
			    }
				
				ingresoProductoDao.commitEndidad(transaction);
			}
			else if (mode.equals("D")) { 
				obj = estadoCuentaClienteDao.findEndidad(obj,Integer.parseInt(ids));
					 estadoCuentaClienteDao.eliminarUnaEndidad(obj, "iEstadoCuentaCliente", ids);
					
					Venta venta = obj.getVenta();
					venta.setvEstadoDocumento(Constantes.estadoDocumentoDeuda);
					ingresoProductoDao.mergeEndidad(venta);
					resultado = ingresoProductoDao.commitEndidad(transaction);
					/**/
				
				}
							
	
			
			if (resultado == true) {
				msn = "msnOk";

			}
			else  {
				msn = "msnError";

			}
			return mapping.findForward(msn);
		}
		/**
		 * Method execute
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return ActionForward
		 * @throws IOException 
		 * @throws ParseException 
		 */
		public ActionForward listaLetrasCliente(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {

			/*** Validamos la session activa y logeada ***/
			String msn = "";
			

			/*** Inicializamos variables ***/
			
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if (request.getParameter("pagina") != null) {
				pagina = Integer.parseInt(request.getParameter("pagina"));
			}
			
			/** Instanciamos las clase Daos **/
		
			EstadoCuentaClienteDao letraClienteDao = new EstadoCuentaClienteDao();
			
		
			/** Instanciamos la Clase VentaForm **/
			EstadoCuentaClienteForm objform = (EstadoCuentaClienteForm) form;
	 
	    	List<Letracliente> listaLetraCliente = new ArrayList<Letracliente>();
			List<Letracliente> listaLetraTotal = new ArrayList<Letracliente>();
			List<Long> paginas = new ArrayList<Long>();
		
			
			listaLetraCliente = letraClienteDao.listaLetraCliente(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getLetracliente());
					    
				/**Consultamos el total de registros segun criterio**/
			listaLetraTotal = letraClienteDao.listaLetraCliente(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getLetracliente());
				
		        /**Obtenemos el total del paginas***/
				paginas = Paginacion.listPaginas((long)(listaLetraTotal.size()));
		 	     objform.setLista(listaLetraCliente);
				objform.setPaginas(paginas);
				objform.setPagInicio(pagina);
				 
				/***Redirecionamos  al ***/
				 msn ="showListLetraCliente";
				
					
			return mapping.findForward(msn);
		}
		/**
		 * Method execute
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return ActionForward
		 * @throws ParseException 
		 */
		public ActionForward mantenimientoLetraCliente(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws ParseException {

			

			HttpSession sesion = request.getSession();			
			String mode = request.getParameter("mode");
			String msn="";
			
			
			/** Instantacia al EstadocuentaproveedorForm **/			
			EstadoCuentaClienteForm estadoCuentaClienteform = (EstadoCuentaClienteForm) form;
			
			/** Instantacia a la capa Dao **/
			EstadoDao estadoDao = new EstadoDao();			 
			EstadoCuentaClienteDao estadoCuentaClienteDao = new EstadoCuentaClienteDao();
			List<Formapago> listaFormapago = estadoCuentaClienteDao.listaEntidadGenericaSinCodigo("Formapago");
		    List<Tipodocumentogestion> listaTipoDoc = estadoCuentaClienteDao.listaEntidadGenericaSinCodigo("Tipodocumentogestion");
		   
			/** llamado de los metodos de la clase dao **/

			List<Estado> listaEstado = estadoDao.listEstado();
				
			/**LLamamos al formulario mantenimientoEstadocuentaproveedor.jsp para la insercion de datos **/
			if(mode.equals("I")){
					msn ="showEditLetraCliente";
			}
			
			/**LLamamos al formulario mantenimientoEstadocuentaproveedor.jsp para mostrar los datos del UPDATE **/
			/** Seteamos el estadoCuentaClienteform la clase Estadocuentaproveedor **/
			else if(mode.equals("U") || mode.equals("D")){
				
				int id = Integer.parseInt(request.getParameter("id"));
				Letracliente letraCliente=estadoCuentaClienteDao.findEndidad(estadoCuentaClienteform.getLetracliente(), id);
				estadoCuentaClienteform.setLetracliente(letraCliente);
				estadoCuentaClienteform.setdFechaPago(Fechas.fechaDDMMYY(letraCliente.getdFechaPago()));
				msn ="showEditLetraCliente";
				
			}
			/**LLamamos al formulario buscarMantenimientoPerfil.jsp para realizar la busqueda **/
			else if(mode.equals("F")){
				msn ="showFindLetraCliente";
				
			}
			
			estadoCuentaClienteform.setMode(mode);

			/** Colocamos en session las listas **/

			sesion.setAttribute("listaEstado", listaEstado);
			sesion.setAttribute("listaFormapago", listaFormapago);
			sesion.setAttribute("listaTipoDoc", listaTipoDoc);

			return mapping.findForward(msn);
		}
		/**
		 * Method execute
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return ActionForward
		 * @throws NoSuchFieldException 
		 * @throws IllegalAccessException 
		 * @throws ClassNotFoundException 
		 * @throws SecurityException 
		 * @throws IllegalArgumentException 
		 * @throws ParseException 
		 */
		public ActionForward iduLetraCliente(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IllegalArgumentException, SecurityException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException, ParseException {
			
			/** Inicializamos las variables **/ 
			String msn = "";
			String mode = request.getParameter("mode");		
			String ids = request.getParameter("ids");		
			boolean resultado = false;
			HttpSession sesion = request.getSession();

			 Usuario usu = (Usuario) sesion.getAttribute("Usuario");
			 int iPeriodoId = (Integer) sesion.getAttribute("iPeriodoId");
			
		
			/** Instanciamos las clase EstadocuentaproveedorForm y EstadocuentaproveedorDao **/
			EstadoCuentaClienteForm pForm = (EstadoCuentaClienteForm) form;
		   ContabilidadDao contabilidadDao = new ContabilidadDao();
			IngresoProductoDao ingresoProductoDao= new IngresoProductoDao();
			
			Letracliente obj = pForm.getLetracliente();			
			obj.getVenta().setFormaPago(pForm.getFormaPago());
			//obj.setIngresoProducto(pForm.getIngresoProducto());
			
	        /**Instanciamos una transacion**/
			EntityTransaction trx= ingresoProductoDao.entityTransaction();
			trx.begin();
			
			
			if (pForm.getMode().equals("I") || pForm.getMode().equals("U")) {
				 Date fecha = Fechas.getDate();	
		            fecha =obj.getVenta().getFormaPago().getiFormaPago()==3?Fechas.fechaDate("30/"+(Fechas.mesFecha(fecha)+1)+"/"+Fechas.anioFecha(fecha)):obj.getdFechaVencimiento();
		         obj.setdFechaVencimiento(fecha);
		         if(pForm.getdFechaPago()!=""){
		        	 obj.setdFechaPago(Fechas.fechaDate(pForm.getdFechaPago()));
		         }
		         
		         if(pForm.getMode().equals("I")){
					 contabilidadDao.callVentaContabilidad(obj.getVenta().getiVentaId(),fecha, pForm.getfMontoAdelantado(), usu.getiUsuarioId(), pForm.getiNumeroLetras(), pForm.getnPlazoLetra(),pForm.getMode(),iPeriodoId, obj.getnNumeroLetra(),obj.getVenta().getFormaPago().getiFormaPago());
		        	 resultado = ingresoProductoDao.commitEndidad(trx);		         
					 Venta venta =  ingresoProductoDao.findEndidad(obj.getVenta(), obj.getVenta().getiVentaId());
				
					 venta.setFormaPago(obj.getVenta().getFormaPago());
					 ingresoProductoDao.mergeEndidad(venta);
		        	 resultado = ingresoProductoDao.commitEndidad(trx);
					 ingresoProductoDao.refreshEndidad(venta);
				
			}// fin mode I;
			else if (pForm.getMode().equals("U")) {
				    obj = ingresoProductoDao.findEndidad(pForm.getLetracliente(), pForm.getLetracliente().getiLetraClienteId());
				   if(pForm.getdFechaPago()!=""){
				       obj.setdFechaPago(Fechas.fechaDate(pForm.getdFechaPago()));
				    }
				   
				    if(pForm.getdFechaPago()!=""){
				     obj.setvEstadoLetra(Constantes.estadoDocumentoCancelado);				     
				    }
				    int cantLetrasPagadas=0;
				    List<Letracliente> listaLetra = new ArrayList<Letracliente>();
				    for(Letracliente letraPagada:obj.getVenta().getLetracliente()){
				    	if(letraPagada.getcEstadoCodigo().equalsIgnoreCase(Constantes.estadoActivo)){
				    		if(letraPagada.getvEstadoLetra().equals(Constantes.estadoDocumentoCancelado)){				    	
				    		cantLetrasPagadas++;				    		
				    		}
				    		listaLetra.add(letraPagada);
				    	}
				    }
				    if(cantLetrasPagadas==listaLetra.size()){
				    	Venta venta=obj.getVenta();
				    	venta.setvEstadoDocumento(Constantes.estadoDocumentoCancelado);
				    	ingresoProductoDao.mergeEndidad(venta);
				    }
				    obj= Util.comparar(obj, pForm.getLetracliente());
				    ingresoProductoDao.mergeEndidad(obj);
				    resultado = ingresoProductoDao.commitEndidad(trx);
				    ingresoProductoDao.refreshEndidad(obj);
				
			   }
			}
			else if (mode.equals("D")) { 
				    obj = ingresoProductoDao.findEndidad(obj, Integer.parseInt(ids));
				    ingresoProductoDao.eliminarUnaEndidad(obj, "iLetraClienteId",ids);
					
					Venta venta = obj.getVenta();
					venta.setvEstadoDocumento(Constantes.estadoDocumentoDeuda);
					ingresoProductoDao.mergeEndidad(venta);
					resultado = ingresoProductoDao.commitEndidad(trx);
					/**/
				
				}
							
	
			
			if (resultado == true) {
				msn = "msnOk";

			}
			else  {
				msn = "msnError";

			}
			return mapping.findForward(msn);
		}
}
