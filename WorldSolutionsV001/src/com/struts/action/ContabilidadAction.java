package com.struts.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import com.dao.EstadoDao;
import com.dao.GenericaDao;
import com.dao.IngresoProductoDao;
import com.dao.PerfilDao;
import com.dao.UsuarioDao;

import com.dao.ProductoDao;
import com.dao.VentaDao;
import com.entities.Configuracion;
import com.entities.Estadocuentacliente;
import com.entities.Estadocuentaproveedor;
import com.entities.Cuenta;
import com.entities.Elementocuenta;
import com.entities.Estado;
import com.entities.Ingresoproducto;
import com.entities.Ingresoproductodevolucion;
import com.entities.Kardex;
import com.entities.Librodiario;
import com.entities.Libromayor;
import com.entities.Perfil;
import com.entities.Periodo;
import com.entities.Personal;
import com.entities.Planilla;

import com.entities.Producto;

import com.entities.Usuario;
import com.entities.Venta;
import com.entities.Ventadevolucion;
import com.entities.vo.EstadoCuentaVo;
import com.entities.vo.LibroDiarioVo;
import com.google.gson.Gson;

import com.struts.form.ContabilidadForm;
import com.struts.form.IngresoProductoForm;
import com.struts.form.UsuarioForm;
import com.util.Constantes;
import com.util.Fechas;
import com.util.FormatosNumeros;
import com.util.Paginacion;
import com.util.Util;


public class ContabilidadAction extends DispatchAction {
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
		 */
		public ActionForward listaVenta(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
            
			/***Validamos la session activa y logeada***/
			String msn = "";						    
			HttpSession sesion = request.getSession();
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if(request.getParameter("pagina")!= null){
				 pagina = Integer.parseInt(request.getParameter("pagina"));
			}
			/** Instanciamos la Clase VentaForm **/
			ContabilidadForm objform = (ContabilidadForm) form;
			
			msn ="showListVentaContabilidad";
				/**Seteamos los valores en las listas**/
				List<Venta> listaVenta = new ArrayList<Venta>();
				List<Venta> listaVentaTotal = new ArrayList<Venta>();
				List<Long> paginas = new ArrayList<Long>();
				
				
				/** Instanciamos las clase Daos **/
				VentaDao ventaDao = new VentaDao();
				listaVenta = ventaDao.listaVenta(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getVenta());
		    
				/**Consultamos el total de registros segun criterio**/
				listaVentaTotal = ventaDao.listaVenta(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getVenta());
				
		        /**Obtenemos el total del paginas***/
				paginas = Paginacion.listPaginas((long)(listaVentaTotal.size()));
		 	     
				
				
		        double totalCompra=0;
				double subTotalCompra=0;
				double igvTotalCompra=0;
				for(Venta venta: listaVentaTotal){
					totalCompra=totalCompra+venta.getfVentaTotal();
					subTotalCompra=subTotalCompra+venta.getfVentaSubTotal();
					igvTotalCompra=igvTotalCompra+venta.getfVentaIGV();
				}
				 
			 objform.setLista(listaVenta);
					/** Seteamos las clase AreaForm **/
	         objform.setPaginas(paginas);
	         objform.setPagInicio(pagina);
			
			 objform.setTotalCompraVenta(totalCompra);
	         objform.setSubTotalCompraVenta(subTotalCompra);
	         objform.setIgvCompraVenta(igvTotalCompra);
	         objform.setIgvActual(sesion.getAttribute("IGVVentas").toString());
			
			
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
		 * @throws IOException 
		 */
		public ActionForward listaVentaDevolucion(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {

			/*** Validamos la session activa y logeada ***/
			String msn = "";
			

			/*** Inicializamos variables ***/
			
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if (request.getParameter("pagina") != null) {
				pagina = Integer.parseInt(request.getParameter("pagina"));
			}
			/** Seteamos los valores en las listas **/
			List<Ventadevolucion> listaVentaDevolucion = new ArrayList<Ventadevolucion>();
			List<Ventadevolucion> VentadevolucionTotal = new ArrayList<Ventadevolucion>();
			List<Long> paginas = new ArrayList<Long>();

			/** Instanciamos la Clase VentaForm **/
			ContabilidadForm ventaform = (ContabilidadForm) form;

			/** Instanciamos las clase Daos **/
			VentaDao ventaDao = new VentaDao();
			listaVentaDevolucion = ventaDao.listaVentaDevolucion(Paginacion.pagInicio(pagina),
							Paginacion.pagFin(), ventaform.getVenta());

			/** Consultamos el total de registros segun criterio **/
			VentadevolucionTotal = ventaDao.listaVentaDevolucion(Paginacion.pagInicio(pagInicio),
							Paginacion.pagFinMax(), ventaform.getVenta());

			/** Obtenemos el total del paginas ***/
			paginas = Paginacion.listPaginas((long) (VentadevolucionTotal.size()));

			ventaform.setLista(listaVentaDevolucion);

			/*** Redirecionamos al ***/
			msn = "showListVentaDevolucionContabilidad";

			/** Seteamos las clase VentaForm **/

			ventaform.setPaginas(paginas);
			ventaform.setPagInicio(pagina);
			// }// else
			return mapping.findForward(msn);
			}
		/**
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws ParseException
		 * @throws IOException
		 */
		public ActionForward listaEstadoCuentaCliente(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {

		/*** Validamos la session activa y logeada ***/
		String msn = "";
		

		/*** Inicializamos variables ***/
		
		int pagina = Paginacion.paginaInicial;
		int pagInicio = Paginacion.paginaInicial;
		if (request.getParameter("pagina") != null) {
			pagina = Integer.parseInt(request.getParameter("pagina"));
		}
		
		/** Instanciamos las clase Daos **/
	
		VentaDao ventaDao = new VentaDao();
		
	
		/** Instanciamos la Clase VentaForm **/
		ContabilidadForm objform = (ContabilidadForm) form;
    	
    	List<Venta> listaVenta = new ArrayList<Venta>();
		List<Venta> listaVentaTotal = new ArrayList<Venta>();
		List<Long> paginas = new ArrayList<Long>();
	
		 
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
		objform.setPagInicio(pagina);
		msn="showListEstadoCuentaCliente";
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
		 * @throws IOException 
		 */
		public ActionForward listaIngresoproducto(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {

			/***Validamos la session activa y logeada***/
		    String msn = "";
			HttpSession sesion = request.getSession();
			/*
			if(sesion.getId()!=(sesion.getAttribute("id"))){
				response.sendRedirect("login.do?metodo=logout");				
			}
			else{*/
				
			
			    /***Inicializamos variables***/

				int pagina = Paginacion.paginaInicial;
				int pagInicio = Paginacion.paginaInicial;
				if(request.getParameter("pagina")!= null){
					 pagina = Integer.parseInt(request.getParameter("pagina"));
				}
				int iPeriodoId = (Integer) sesion.getAttribute("iPeriodoId");
				
				/**Seteamos los valores en las listas**/
				List<Ingresoproducto> listaIngresoproducto = new ArrayList<Ingresoproducto>();
				List<Ingresoproducto> listaIngresoproductoTotal = new ArrayList<Ingresoproducto>();
				List<Long> paginas = new ArrayList<Long>();
				
				/** Instanciamos la Clase IngresoproductoForm **/
				ContabilidadForm objform = (ContabilidadForm) form;
				

				/** Instanciamos las clase Daos **/
			
				IngresoProductoDao ingresoproductoDao = new IngresoProductoDao();
				
					 listaIngresoproducto = ingresoproductoDao.listaIngresoproducto(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getIngresoProducto());
			    
					/**Consultamos el total de registros segun criterio**/
					listaIngresoproductoTotal = ingresoproductoDao.listaIngresoproducto(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getIngresoProducto());
					
			        /**Obtenemos el total del paginas***/
					paginas = Paginacion.listPaginas((long)(listaIngresoproductoTotal.size()));
			 	     
					double totalCompra=0;
					double subTotalCompra=0;
					double igvTotalCompra=0;
					for(Ingresoproducto ingresoProducto: listaIngresoproductoTotal){
						totalCompra=totalCompra+ingresoProducto.getfIngresoProductoTotal();
						subTotalCompra=subTotalCompra+ingresoProducto.getfIngresoProductoSubTotal();
						igvTotalCompra=igvTotalCompra+ingresoProducto.getfIngresoProductoIGV();
					}
					 
					/***Redirecionamos  al ***/
					 msn ="showListIngresoProductoContabilidad";
					
				
				/** Seteamos las clase IngresoproductoForm **/
				objform.setLista(listaIngresoproducto);
		        objform.setPaginas(paginas);
		        objform.setPagInicio(pagina);
		        objform.setTotalCompraVenta(totalCompra);
		        objform.setSubTotalCompraVenta(subTotalCompra);
		        objform.setIgvCompraVenta(igvTotalCompra);
		        objform.setIgvActual(sesion.getAttribute("IGVCompras").toString());
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
		 * @throws ParseException 
		 * @throws IOException 
		 */
		public ActionForward listaIngresoproductoDevolucion(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {

			/*** Validamos la session activa y logeada ***/
			String msn = "";
			

			/*** Inicializamos variables ***/
			
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if (request.getParameter("pagina") != null) {
				pagina = Integer.parseInt(request.getParameter("pagina"));
			}
			/** Seteamos los valores en las listas **/
			List<Ingresoproductodevolucion> listaIngresoproducto = new ArrayList<Ingresoproductodevolucion>();
			List<Ingresoproductodevolucion> listaIngresoproductoTotal = new ArrayList<Ingresoproductodevolucion>();
			List<Long> paginas = new ArrayList<Long>();

			/** Instanciamos la Clase IngresoproductoForm **/
			ContabilidadForm objform = (ContabilidadForm) form;

			/** Instanciamos las clase Daos **/
			IngresoProductoDao ingresoproductoDao = new IngresoProductoDao();
			listaIngresoproducto = ingresoproductoDao.listaIngresoproductoDevolucion(Paginacion.pagInicio(pagina),
							Paginacion.pagFin(), objform.getIngresoProducto());

			/** Consultamos el total de registros segun criterio **/
			listaIngresoproductoTotal = ingresoproductoDao.listaIngresoproductoDevolucion(Paginacion.pagInicio(pagInicio),
							Paginacion.pagFinMax(), objform.getIngresoProducto());

			/** Obtenemos el total del paginas ***/
			paginas = Paginacion.listPaginas((long) (listaIngresoproductoTotal.size()));

			objform.setLista(listaIngresoproducto);

			/*** Redirecionamos al ***/
			msn = "showListIngresoDevolucionContabilidad";

			/** Seteamos las clase IngresoproductoForm **/

			objform.setPaginas(paginas);
			objform.setPagInicio(pagina);
			// }// else
			return mapping.findForward(msn);
			}
		/**
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws ParseException
		 * @throws IOException
		 */
		public ActionForward listaEstadoCuentaProveedor(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {

		/*** Validamos la session activa y logeada ***/
		String msn = "";
		

		/*** Inicializamos variables ***/
		
		int pagina = Paginacion.paginaInicial;
		int pagInicio = Paginacion.paginaInicial;
		if (request.getParameter("pagina") != null) {
			pagina = Integer.parseInt(request.getParameter("pagina"));
		}
		
		/** Instanciamos las clase Daos **/
	
		IngresoProductoDao ingresoproductoDao = new IngresoProductoDao();
		
	
		/** Instanciamos la Clase VentaForm **/
		ContabilidadForm objform = (ContabilidadForm) form;
    	
    	List<Ingresoproducto> listaIngresoproducto = new ArrayList<Ingresoproducto>();
		List<Ingresoproducto> listaIngresoproductoTotal = new ArrayList<Ingresoproducto>();
		List<Long> paginas = new ArrayList<Long>();
	
		 
		 /**Seteamos los valores en las listas**/
			List<EstadoCuentaVo> listaEstadoCuenta = new ArrayList<EstadoCuentaVo>();
				
				
				/**Accedemos al Dao**/
				 listaIngresoproducto = ingresoproductoDao.listaEstadoCuentaPorProveedor(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getIngresoProducto(),0);
				    double montosTotales =  0.0;
				    double pagosTotales =  0.0;
				    double saldosTotales =  0.0;
				    int i=0;
				    
				    
				 for(Ingresoproducto obj:listaIngresoproducto)
				 {   double pagoTotal=0.0, saldoTotal = 0.0;
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
				     e.setPagoTotal(FormatosNumeros.FormatoDecimalMoneda(pagoTotal));
				     e.setSaldoTotal(FormatosNumeros.FormatoDecimalMoneda(saldoTotal));
			
					i++;
					
					if(i==listaIngresoproducto.size()){
						e.setMontosTotales((FormatosNumeros.FormatoDecimalMoneda(montosTotales)));
						e.setPagosTotales((FormatosNumeros.FormatoDecimalMoneda(pagosTotales)));
						e.setSaldosTotales((FormatosNumeros.FormatoDecimalMoneda(saldosTotales)));
						
					}
				     
				     listaEstadoCuenta.add(e);
				     
				 }
				 
			/**Consultamos el total de registros segun criterio**/
			listaIngresoproductoTotal = ingresoproductoDao.listaEstadoCuentaPorProveedor(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getIngresoProducto(),0);
			
	        /**Obtenemos el total del paginas***/
			paginas = Paginacion.listPaginas((long)(listaIngresoproductoTotal.size()));
	 	     objform.setLista(listaEstadoCuenta);
			objform.setPaginas(paginas);
			objform.setPagInicio(pagina);
			msn="showListEstadoCuentaProveedor";
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
		public ActionForward listaProducto(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {

			/***Validamos la session activa y logeada***/
			String msn = "";
			
		
			/***Inicializamos variables***/
			
			int  iclasificacionId = Integer.parseInt(request.getParameter("iclasificacionId"));
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if(request.getParameter("pagina")!= null){
				 pagina = Integer.parseInt(request.getParameter("pagina"));
			}
		
			/** Instanciamos la Clase ProductoForm **/
			
			ContabilidadForm productosForm = (ContabilidadForm) form;
			
		
			/** Instanciamos las clase Daos **/
			
			ProductoDao productoDao = new ProductoDao();
			//Producto producto = new Producto();
			
			
			/**
			 * iclasificacionId:
			 * 1: Mercaderia
			 * 2: Materia Prima
			 * 3: Suministros y Repuestos
			 * 4: Envases y embalajes
			 * 
			 * ***/
			switch (iclasificacionId) {
			 
	        case 1:  msn ="showListMercaderiaContabilidad";
	                 break;
	        case 2:  msn ="showListMateriaPrimaContabilidad";
	                 break;
	        case 3:  msn ="showListSuministrosContabilidad";
	                 break;
	        case 4:  msn ="showListEnvasesContabilidad";
	                 break;        
	       
	       } 
			
			/**Seteamos los valores en las listas**/
			List<Producto> listaProductos =  productoDao.listaProducto(Paginacion.pagInicio(pagina),Paginacion.pagFin(), productosForm.getProducto(),iclasificacionId);
			
			/**Consultamos el total de registros segun criterio**/
			List<Producto> listaPerfilTotal = productoDao.listaProducto(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(), productosForm.getProducto(),iclasificacionId);
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaPerfilTotal.size()));
			
			
			 
			 /** Seteamos las clase ProductoForm **/
			productosForm.setLista(listaProductos);
			productosForm.setPaginas(paginas);
			productosForm.setPagInicio(pagina);
			
			//}// else
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
		 */
		public ActionForward listaLibroDiario(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
            
			
			
			/***Validamos la session activa y logeada***/
			String msn = "";
			
		
			/***Inicializamos variables***/
			
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if(request.getParameter("pagina")!= null){
				 pagina = Integer.parseInt(request.getParameter("pagina"));
			}
			msn ="showListLibroDiario";
			/** Instanciamos la Clase ProductoForm **/
			
			ContabilidadForm contabilidadForm = (ContabilidadForm) form;
			
		
			/** Instanciamos las clase Daos **/
			
			ContabilidadDao contabilidadDao = new ContabilidadDao();
			//Producto producto = new Producto();
			
			HttpSession sesion = request.getSession();
			int iPeriodoId = (Integer) sesion.getAttribute("iPeriodoId");
			
			
			
			
			/**Seteamos los valores en las listas**/
			List<Librodiario> listaLibroDiario =  contabilidadDao.listaLibroDiario(Paginacion.pagInicio(pagina),Paginacion.pagFin(), contabilidadForm.getLibrodiario(),iPeriodoId);
			
			/**Consultamos el total de registros segun criterio**/
			List<Librodiario> listaLibroDiarioTotal = contabilidadDao.listaLibroDiario(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(), contabilidadForm.getLibrodiario(),iPeriodoId);
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaLibroDiarioTotal.size()));
			
			
			double totalDebe=0.0;
			double totalHaber =0.0;
			
			/****obtenermos los total del debe y haber***/
			for(Librodiario libro:listaLibroDiarioTotal){
			    if(libro.getvTipoConcepto().equals("D"))
					totalDebe= totalDebe+libro.getfMonto();
				if(libro.getvTipoConcepto().equals("H"))
					totalHaber= totalHaber+libro.getfMonto();
			
			}
			 /** Seteamos las clase ProductoForm **/
			contabilidadForm.setLista(listaLibroDiario);
			contabilidadForm.setPaginas(paginas);
			contabilidadForm.setPagInicio(pagina);
			contabilidadForm.setTotalDebe(totalDebe);
			contabilidadForm.setTotalHaber(totalHaber);
			
			
			//}// else
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
		public ActionForward listaLibroMayor(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
            
			
			
			/***Validamos la session activa y logeada***/
			String msn = "";
			
		
			/***Inicializamos variables***/
			
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if(request.getParameter("pagina")!= null){
				 pagina = Integer.parseInt(request.getParameter("pagina"));
			}
			msn ="showListLibroMayor";
			/** Instanciamos la Clase ProductoForm **/
			
			ContabilidadForm contabilidadForm = (ContabilidadForm) form;
			
		
			/** Instanciamos las clase Daos **/
			
			ContabilidadDao contabilidadDao = new ContabilidadDao();
			//Producto producto = new Producto();
			
			HttpSession sesion = request.getSession();
			int iPeriodoId = (Integer) sesion.getAttribute("iPeriodoId");
			
			
			
			
			/**Seteamos los valores en las listas**/
			List<Libromayor> listaLibroDiario =  contabilidadDao.listaLibroMayor(Paginacion.pagInicio(pagina),Paginacion.pagFin(), contabilidadForm.getLibrodiario(),iPeriodoId);
			
			/**Consultamos el total de registros segun criterio**/
			List<Libromayor> listaLibroDiarioTotal = contabilidadDao.listaLibroMayor(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(), contabilidadForm.getLibrodiario(),iPeriodoId);
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaLibroDiarioTotal.size()));
			
			double totalDebe=0.0;
			double totalHaber=0.0;
			
			for(Libromayor libromayor:listaLibroDiarioTotal){
				totalDebe=totalDebe+libromayor.getfMontoDebe();
				totalHaber=totalHaber+libromayor.getfMontoHaber();
			}
			
			 /** Seteamos las clase ProductoForm **/
			contabilidadForm.setLista(listaLibroDiario);
			contabilidadForm.setPaginas(paginas);
			contabilidadForm.setPagInicio(pagina);
			contabilidadForm.setTotalDebe(totalDebe);
			contabilidadForm.setTotalHaber(totalHaber);
			Periodo periodo = new Periodo();
			periodo=contabilidadDao.findEndidad(periodo, iPeriodoId);
			contabilidadForm.setMes(" mes: "+Util.mes(Fechas.mesFecha(periodo.getdFechaInicio()))+" ("+Fechas.fechaDDMMYY(periodo.getdFechaInicio())
					                        +" - "+Fechas.fechaDDMMYY(periodo.getdFechaFin())+")");
			
			
			//}// else
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
		public ActionForward listaBalanceGeneral(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
            
			
			
			/***Validamos la session activa y logeada***/
			String msn = "";
			
		
			/***Inicializamos variables***/
			
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if(request.getParameter("pagina")!= null){
				 pagina = Integer.parseInt(request.getParameter("pagina"));
			}
			msn ="showListBalanceGeneral";
			/** Instanciamos la Clase ProductoForm **/
			
			ContabilidadForm contabilidadForm = (ContabilidadForm) form;
			
		
			/** Instanciamos las clase Daos **/
			
			ContabilidadDao contabilidadDao = new ContabilidadDao();
			//Producto producto = new Producto();
			
			HttpSession sesion = request.getSession();
			int iPeriodoId = (Integer) sesion.getAttribute("iPeriodoId");
			
			
			
			
			/**Seteamos los valores en las listas**/
			List<Libromayor> listaLibroDiario =  contabilidadDao.listaLibroMayor(Paginacion.pagInicio(pagina),Paginacion.pagFin(), contabilidadForm.getLibrodiario(),iPeriodoId);
			
			/**Consultamos el total de registros segun criterio**/
			List<Libromayor> listaLibroDiarioTotal = contabilidadDao.listaLibroMayor(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(), contabilidadForm.getLibrodiario(),iPeriodoId);
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaLibroDiarioTotal.size()));
			
			
			double totalDebe=0.0;
			double totalHaber =0.0;
			double totalSaldoD=0.0;
			double totalSaldoH =0.0;
			double totalBalanceA=0.0;
			double totalBalanceP =0.0;
			
			
			
			List<LibroDiarioVo> libroBalance= new ArrayList<LibroDiarioVo>();
			/****obtenermos los total del debe y haber***/
			for(Libromayor libro:listaLibroDiarioTotal){
				LibroDiarioVo li= new LibroDiarioVo();
					if((libro.getfMontoDebe()-libro.getfMontoHaber())>0)
				{
					 li.setfMontoSaldoD(libro.getfMontoDebe()-libro.getfMontoHaber());
				}
				else{
					li.setfMontoSaldoH(-1*(libro.getfMontoDebe()-libro.getfMontoHaber()));
				}
				if(libro.getCuenta().getElementoCuenta().getiElementoCuentasId()==1 ||
				   libro.getCuenta().getElementoCuenta().getiElementoCuentasId()==2 ||
				   libro.getCuenta().getElementoCuenta().getiElementoCuentasId()==3){
					li.setfMontoBalanceA(li.getfMontoSaldoD());
				}
				if(libro.getCuenta().getElementoCuenta().getiElementoCuentasId()==4 ||
						   libro.getCuenta().getElementoCuenta().getiElementoCuentasId()==5){
							li.setfMontoBalanceP(li.getfMontoSaldoH());
			   }
				
			   totalDebe= totalDebe+libro.getfMontoDebe();				
			   totalHaber= totalHaber+libro.getfMontoHaber();
			 
			   totalSaldoD=totalSaldoD+li.getfMontoSaldoD();
			   totalSaldoH=totalSaldoH+li.getfMontoSaldoH();
			   
			   totalBalanceA= totalBalanceA+li.getfMontoBalanceA();
			   totalBalanceP= totalBalanceP+li.getfMontoBalanceP();
			
			
			}
			for(Libromayor libro:listaLibroDiario){
				LibroDiarioVo li= new LibroDiarioVo();
				li.setcEstadoCodigo(libro.getCuenta().getvCodigo());
				li.setvDescripcion(libro.getCuenta().getvDescripcion());
				li.setfMontoD(libro.getfMontoDebe());
				li.setfMontoH(libro.getfMontoHaber());
				if((libro.getfMontoDebe()-libro.getfMontoHaber())>=0)
				{
					 li.setfMontoSaldoD(libro.getfMontoDebe()-libro.getfMontoHaber());
				}
				else{
					li.setfMontoSaldoH(-1*(libro.getfMontoDebe()-libro.getfMontoHaber()));
				}
				if(libro.getCuenta().getElementoCuenta().getiElementoCuentasId()==1 ||
				   libro.getCuenta().getElementoCuenta().getiElementoCuentasId()==2 ||
				   libro.getCuenta().getElementoCuenta().getiElementoCuentasId()==3){
					li.setfMontoBalanceA(li.getfMontoSaldoD());
				}
				if(libro.getCuenta().getElementoCuenta().getiElementoCuentasId()==4 ||
						   libro.getCuenta().getElementoCuenta().getiElementoCuentasId()==5){
							li.setfMontoBalanceP(li.getfMontoSaldoH());
			   }				
			   
			   
			   libroBalance.add(li);
			
			}
			 /** Seteamos las clase ProductoForm **/
			contabilidadForm.setLista(libroBalance);
			contabilidadForm.setPaginas(paginas);
			contabilidadForm.setPagInicio(pagina);
			contabilidadForm.setTotalDebe(totalDebe);
			contabilidadForm.setTotalHaber(totalHaber);
			contabilidadForm.setTotalfMontoSaldoD(totalSaldoD);
			contabilidadForm.setTotalfMontoSaldoH(totalSaldoH);
			contabilidadForm.setTotalfMontoBalanceA(totalBalanceA);
			contabilidadForm.setTotalfMontoBalanceP(totalBalanceP);
			Periodo periodo = new Periodo();
			periodo=contabilidadDao.findEndidad(periodo, iPeriodoId);
			contabilidadForm.setMes(" mes: "+Util.mes(Fechas.mesFecha(periodo.getdFechaInicio()))+" ("+Fechas.fechaDDMMYY(periodo.getdFechaInicio())
					                        +" - "+Fechas.fechaDDMMYY(periodo.getdFechaFin())+")");
			
			
			
			
			//}// else
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
		public ActionForward listaEstadoFinanciero(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
            
			
			
			/***Validamos la session activa y logeada***/
			String msn = "";
			
		
			/***Inicializamos variables***/
			
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if(request.getParameter("pagina")!= null){
				 pagina = Integer.parseInt(request.getParameter("pagina"));
			}
			msn ="showListEstdadoFinanciero";
			/** Instanciamos la Clase ProductoForm **/
			
			ContabilidadForm contabilidadForm = (ContabilidadForm) form;
			
		
			/** Instanciamos las clase Daos **/
			
			ContabilidadDao contabilidadDao = new ContabilidadDao();
			//Producto producto = new Producto();
			
			HttpSession sesion = request.getSession();
			int iPeriodoId = (Integer) sesion.getAttribute("iPeriodoId");
			
			
			
			
			/**Seteamos los valores en las listas**/
			List<Libromayor> listaLibroDiario =  contabilidadDao.listaLibroMayor(Paginacion.pagInicio(pagina),Paginacion.pagFin(), contabilidadForm.getLibrodiario(),iPeriodoId);
			
			/**Consultamos el total de registros segun criterio**/
			List<Libromayor> listaLibroDiarioTotal = contabilidadDao.listaLibroMayor(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(), contabilidadForm.getLibrodiario(),iPeriodoId);
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaLibroDiarioTotal.size()));
			
			
			
			float totalbruto=0;
			
			
		
		    contabilidadForm.setLista(listaLibroDiario);
		    contabilidadForm.setPaginas(paginas);
			contabilidadForm.setPagInicio(pagina);
			
			Periodo periodo = new Periodo();
			periodo=contabilidadDao.findEndidad(periodo, iPeriodoId);
			contabilidadForm.setMes(" mes: "+Util.mes(Fechas.mesFecha(periodo.getdFechaInicio()))+" ("+Fechas.fechaDDMMYY(periodo.getdFechaInicio())
					                        +" - "+Fechas.fechaDDMMYY(periodo.getdFechaFin())+")");
			
			
			//}// else
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
		 */
		public ActionForward listaCajaBanco(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
            
			
			
			/***Validamos la session activa y logeada***/
			String msn = "";
			
			HttpSession sesion = request.getSession();
			int iPeriodoId = (Integer) sesion.getAttribute("iPeriodoId");
			
			/***Inicializamos variables***/
			
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if(request.getParameter("pagina")!= null){
				 pagina = Integer.parseInt(request.getParameter("pagina"));
			}
			msn ="showListCajaBancos";
			/** Instanciamos la Clase ProductoForm **/
			
			ContabilidadForm contabilidadForm = (ContabilidadForm) form;
			
		
			/** Instanciamos las clase Daos **/
			
			ContabilidadDao contabilidadDao = new ContabilidadDao();
			//Producto producto = new Producto();
			
			
			
			
			
			/**Seteamos los valores en las listas**/
			List<Librodiario> listaCajaBanco =  contabilidadDao.listaCajaChica(Paginacion.pagInicio(pagina),Paginacion.pagFin(), contabilidadForm.getLibrodiario(),iPeriodoId);
			
			/**Consultamos el total de registros segun criterio**/
			List<Librodiario> listaLibroDiarioTotal = contabilidadDao.listaCajaChica(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(), contabilidadForm.getLibrodiario(),iPeriodoId);
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaLibroDiarioTotal.size()));
			
			
			 
			 /** Seteamos las clase ProductoForm **/
			contabilidadForm.setLista(listaCajaBanco);
			contabilidadForm.setPaginas(paginas);
			contabilidadForm.setPagInicio(pagina);
			Periodo periodo = new Periodo();
			periodo=contabilidadDao.findEndidad(periodo, iPeriodoId);
			contabilidadForm.setMes(" mes: "+Util.mes(Fechas.mesFecha(periodo.getdFechaInicio()))+" ("+Fechas.fechaDDMMYY(periodo.getdFechaInicio())
					                        +" - "+Fechas.fechaDDMMYY(periodo.getdFechaFin())+")");
			double totalDebe=0.0;
			double totalHaber =0.0;
			/****obtenermos los total del debe y haber***/
			for (Librodiario libro:listaLibroDiarioTotal){
				if(libro.getvTipoConcepto().equals("D"))
					totalDebe= totalDebe+libro.getfMonto();
				if(libro.getvTipoConcepto().equals("H"))
					totalHaber= totalHaber+libro.getfMonto();
			}
			 
			 /** Seteamos las clase ProductoForm **/
			contabilidadForm.setTotalDebe(totalDebe);
			contabilidadForm.setTotalHaber(totalHaber);
		
				
			//}// else
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
		 */
		public ActionForward listaCuentas(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
            
			
			
			/***Validamos la session activa y logeada***/
			String msn = "";
			HttpSession sesion = request.getSession();
			int iPeriodoId = (Integer) sesion.getAttribute("iPeriodoId");
		
		
			/***Inicializamos variables***/
			
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if(request.getParameter("pagina")!= null){
				 pagina = Integer.parseInt(request.getParameter("pagina"));
			}
			msn ="showListCuentas";
			/** Instanciamos la Clase ProductoForm **/
			
			ContabilidadForm contabilidadForm = (ContabilidadForm) form;
			
		
			/** Instanciamos las clase Daos **/
			
			ContabilidadDao contabilidadDao = new ContabilidadDao();
			//Producto producto = new Producto();
			
			
			
			
			
			/**Seteamos los valores en las listas**/
			List<Librodiario> listaCuentas =  contabilidadDao.listaCuentas(Paginacion.pagInicio(pagina),Paginacion.pagFin(), contabilidadForm.getLibrodiario(),iPeriodoId);
			
			/**Consultamos el total de registros segun criterio**/
			List<Librodiario> listaLibroDiarioTotal = contabilidadDao.listaCuentas(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(), contabilidadForm.getLibrodiario(),iPeriodoId);
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaLibroDiarioTotal.size()));
			
			
			 
			 /** Seteamos las clase ProductoForm **/
			contabilidadForm.setLista(listaCuentas);
			contabilidadForm.setPaginas(paginas);
			contabilidadForm.setPagInicio(pagina);
			double totalDebe=0.0;
			double totalHaber =0.0;
			/****obtenermos los total del debe y haber***/
			for (Librodiario libro:listaLibroDiarioTotal){
				if(libro.getvTipoConcepto().equals("D"))
					totalDebe= totalDebe+libro.getfMonto();
				if(libro.getvTipoConcepto().equals("H"))
					totalHaber= totalHaber+libro.getfMonto();
			}
			 
			 /** Seteamos las clase ProductoForm **/
			contabilidadForm.setTotalDebe(totalDebe);
			contabilidadForm.setTotalHaber(totalHaber);
			Periodo periodo = new Periodo();
			periodo=contabilidadDao.findEndidad(periodo, iPeriodoId);
			contabilidadForm.setMes(" mes: "+Util.mes(Fechas.mesFecha(periodo.getdFechaInicio()))+" ("+Fechas.fechaDDMMYY(periodo.getdFechaInicio())
					                        +" - "+Fechas.fechaDDMMYY(periodo.getdFechaFin())+")");
			
			//}// else
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
		public ActionForward mantenimientoCuentas(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) {

			

			HttpSession sesion = request.getSession();			
			String mode = request.getParameter("mode");
			String caja = request.getParameter("caja");
			String msn="";
			
			
			/** Instantacia al AreaForm **/			
			ContabilidadForm contabilidadform = (ContabilidadForm) form;
			contabilidadform.setcCajaBanco(caja);
			
			
			/** Instantacia a la capa Dao **/
			EstadoDao estadoDao = new EstadoDao();
			GenericaDao genericaDao = new GenericaDao();
			ContabilidadDao contabilidadDao = new ContabilidadDao();

			/** llamado de los metodos de la clase dao **/

			List<Estado> listaEstado = estadoDao.listEstado();
			List<Elementocuenta> listaElementoCuenta = new ArrayList<Elementocuenta>();
			List<Cuenta> listaCuenta= new ArrayList<Cuenta>() ;
			List<Cuenta> listaCuenta1= new ArrayList<Cuenta>() ;
			List<Cuenta> listaCuenta2= new ArrayList<Cuenta>() ;
			List<Cuenta> listaCuenta3= new ArrayList<Cuenta>() ;
			List<Cuenta> listaCuenta4= new ArrayList<Cuenta>() ;
			Cuenta cuenta = new Cuenta();
					
			

			
			/**LLamamos al formulario mantenimientoCajaChica.jsp para la insercion de datos **/
			if(mode.equals("I")){
				msn ="showEditCuentas";
			}
			
			/**LLamamos al formulario mantenimientoCajaChica.jsp para mostrar los datos del UPDATE **/
			/** Seteamos el areaform la clase Area **/
			else if(mode.equals("U") || mode.equals("D")){
				String vCodigo ="";
				int id = Integer.parseInt(request.getParameter("id"));
				/** Instantacia al AreaForm **/			
				
				Librodiario librodiario = genericaDao.findEndidad(contabilidadform.getLibrodiario(), id);
				contabilidadform.setLibrodiario(librodiario);
				vCodigo = librodiario.getCuenta().getvCodigo();
				
				
				
				/**Lista de partidas***/
				for(int i=vCodigo.length(); i>=2; i--){
					cuenta = new Cuenta();
					cuenta = contabilidadDao.bucarCuenta(vCodigo.substring(0, i));
					if(i==2){						
						listaCuenta= contabilidadDao.listaPartida(librodiario.getCuenta().getElementoCuenta().getiElementoCuentasId());						
						contabilidadform.setiCuentasId1(cuenta.getiCuentasId());
					}
					if(i==3){
						listaCuenta1=  contabilidadDao.listaSubPartidaCodigo(String.valueOf(cuenta.getvCodigo()).substring(0,i-1));	
						contabilidadform.setiCuentasId2(cuenta.getiCuentasId());
					}	
					if(i==4){
						listaCuenta2=  contabilidadDao.listaSubPartidaCodigo(String.valueOf(cuenta.getvCodigo()).substring(0,i-1));	
						contabilidadform.setiCuentasId3(cuenta.getiCuentasId());
					}
					if(i==5){
						listaCuenta3=  contabilidadDao.listaSubPartidaCodigo(String.valueOf(cuenta.getvCodigo()).substring(0,i-1));	
						contabilidadform.setiCuentasId4(cuenta.getiCuentasId());
					}
					
				}
				
				int iElementoCuentaId =contabilidadform.getLibrodiario().getCuenta().getElementoCuenta().getiElementoCuentasId();
				/**Validamos que seaa el valor del egreso y asignamos en el tipo para su respectiva selección **/
				if(iElementoCuentaId==4 || iElementoCuentaId==6  || iElementoCuentaId==5){
					contabilidadform.setTipo(Constantes.egresoValor);					
					listaElementoCuenta= contabilidadDao.listaElementoCuenta(Constantes.egresoValor);	
					
					
					
				}
			        
				/**Validamos que seaa el valor del ingreso y asignamos en el tipo para su respectiva selección **/
				if(iElementoCuentaId==1 || iElementoCuentaId==2 || iElementoCuentaId==3 || iElementoCuentaId==7 ){
					 listaElementoCuenta= contabilidadDao.listaElementoCuenta(Constantes.ingresoValor);
					 contabilidadform.setTipo(Constantes.ingresoValor);
					 

				}
				
				msn ="showEditCuentas";
				
			}
			/**LLamamos al formulario buscarMantenimientoCajaChica.jsp para realizar la busqueda **/
			else if(mode.equals("F")){
				msn ="showFindCuentas";
			}
			
			contabilidadform.setMode(mode);

			/** Colocamos en session las listas **/

			sesion.setAttribute("listaEstado", listaEstado);
			sesion.setAttribute("listaElementoCuenta", listaElementoCuenta); 
			sesion.setAttribute("listaCuenta", listaCuenta);
			sesion.setAttribute("listaCuenta1", listaCuenta1);
			sesion.setAttribute("listaCuenta2", listaCuenta2);
			sesion.setAttribute("listaCuenta3", listaCuenta3);
			sesion.setAttribute("listaCuenta4", listaCuenta4);
			
			

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
		public ActionForward iduCuentas(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws IllegalArgumentException, SecurityException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException {

			

			HttpSession sesion = request.getSession();			
			String mode = request.getParameter("mode");
			String ids = request.getParameter("ids");		
			
			String msn="";
			boolean resultado = false;
			int iPeriodoId = (Integer) sesion.getAttribute("iPeriodoId");
			
			/** Instantacia al AreaForm **/			
			ContabilidadForm contabilidadform = (ContabilidadForm) form;
			Librodiario obj= contabilidadform.getLibrodiario();
			
			
			/** Instantacia a la capa Dao **/
			
			GenericaDao contabilidadDao = new GenericaDao();
             Usuario usu = (Usuario) sesion.getAttribute("Usuario");

			/***
			 * 
			 * 0: Entidad= Cuenta
			 * Ingresos (I):  Elemento 1,2,3,7..... "D" debe
			 * Egresos (E):   Elemento 4.6 .... "H" haber
			 * 
			 */
			obj.setcEstadoCodigo(Constantes.estadoActivo);
			obj.setiUsuarioInsertaId(usu.getiUsuarioId());
			if(contabilidadform.getTipo()!=null){
				
				if(contabilidadform.getTipo().equals(Constantes.egresoValor) || contabilidadform.getTipo().equals(Constantes.patrimonioValor)  ){
					obj.setvTipoConcepto("H");
					
				}
				if(contabilidadform.getTipo().equals(Constantes.ingresoValor)){
					obj.setvTipoConcepto("D");
					
				}
			}
			/**LLamamos al formulario mantenimientoCajaChica.jsp para la insercion de datos **/
			if(mode.equals("I")){
				/**Insertamos los datos en caja chica**/
				obj.setiPeriodoId(iPeriodoId);
				resultado = contabilidadDao.insertarUnaEndidad(obj);
				
				
			}
			
			else if (contabilidadform.getMode().equals("U")) {				
				obj.setdFechaActualiza(Fechas.getDate());
				resultado = contabilidadDao.actualizarUnaEndidad(obj);
				
			}
			else if (mode.equals("D")) { 
				    contabilidadDao.entityTransaction().begin();
					contabilidadDao.eliminarUnaEndidad(obj, "iLibroDiarioId",ids);/**/
					resultado = contabilidadDao.commitEndidad(contabilidadDao.entityTransaction());
				
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
		 */
		public ActionForward cambioPartida(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response) throws IOException{
			response.setContentType("text/json");
			
		  // Type collectionType = new TypeToken<Object>(){}.getType();
			PrintWriter pw;
			Gson gson = new Gson();			
			
			
			List<Cuenta> lista = new ArrayList<Cuenta>();
			
			String tipo = request.getParameter("tipo");
			String partida =request.getParameter("partida");
			String jsonOutput = "";
			ContabilidadDao contabilidadDao = new ContabilidadDao();
			/***
			 * 0: Entidad= Cuenta
			 * Ingresos (I):  Elemento 1,2,3,7
			 * Egresos (E):   Elemento 4.6
			 * 
			 */
			if(tipo.equals(Constantes.ingreso)||tipo.equals(Constantes.egreso) ||tipo.equals(Constantes.patrimonio)||tipo.equals(Constantes.saldos)){		          	           
				List<Elementocuenta> listas = contabilidadDao.listaElementoCuenta(partida);	
				 jsonOutput = gson.toJson(listas);
				
		        }
			else if(tipo.equals("0")){
	           int iElementoCuentasId = Integer.parseInt(partida);	           
	           lista = contabilidadDao.listaPartida(iElementoCuentasId);
	           jsonOutput = gson.toJson(lista);
	           
	        }
	        else{
	        	String idPartida = partida;           
	        	lista = contabilidadDao.listaSubPartida(idPartida);
	        	 jsonOutput = gson.toJson(lista);
	        	
	        }
			
		
						
			
			pw = response.getWriter();
			pw.write(jsonOutput);
			System.out.println( jsonOutput.toString() );
			pw.flush();
			pw.close();
				
			return null;
			
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
		 */
		public ActionForward listaPlanilla(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
            
			
			
			/***Validamos la session activa y logeada***/
			String msn = "";
			
			HttpSession sesion = request.getSession();
			int iPeriodoId = (Integer) sesion.getAttribute("iPeriodoId");
			
			/***Inicializamos variables***/
			
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if(request.getParameter("pagina")!= null){
				 pagina = Integer.parseInt(request.getParameter("pagina"));
			}
			msn ="showListPlanilla";
			/** Instanciamos la Clase ProductoForm **/
			
			ContabilidadForm contabilidadForm = (ContabilidadForm) form;
			
		
			/** Instanciamos las clase Daos **/
			
			ContabilidadDao contabilidadDao = new ContabilidadDao();
			//Producto producto = new Producto();
			
			
			
			
			
			/**Seteamos los valores en las listas**/
			List<Planilla> listaPlanilla =  contabilidadDao.listaPlanilla(Paginacion.pagInicio(pagina),Paginacion.pagFin(), contabilidadForm.getPlanilla(),iPeriodoId);
			
			/**Consultamos el total de registros segun criterio**/
			List<Planilla> listaPlanillaTotal = contabilidadDao.listaPlanilla(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(), contabilidadForm.getPlanilla(),iPeriodoId);
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaPlanillaTotal.size()));
			
			
			 
			 /** Seteamos las clase ProductoForm **/
			contabilidadForm.setLista(listaPlanilla);
			contabilidadForm.setPaginas(paginas);
			contabilidadForm.setPagInicio(pagina);
			Periodo periodo = new Periodo();
			periodo=contabilidadDao.findEndidad(periodo, iPeriodoId);
			contabilidadForm.setMes(" mes: "+Util.mes(Fechas.mesFecha(periodo.getdFechaInicio()))+" ("+Fechas.fechaDDMMYY(periodo.getdFechaInicio())
                    +" - "+Fechas.fechaDDMMYY(periodo.getdFechaFin())+")");
           
			/****obtenermos los total del debe y haber***/
			
				for (Configuracion planilla:Util.listaConfiguracion()){
				   if(planilla.getvConcepto().equals(Constantes.aportESSALUD)){
					   contabilidadForm.setfPorApoESSALUD( Float.parseFloat( planilla.getvValor()));
				   }
				   if(planilla.getvConcepto().equals(Constantes.aportIES)){
					   contabilidadForm.setfPorApoIES( Float.parseFloat( planilla.getvValor()));
				   }
				   if(planilla.getvConcepto().equals(Constantes.descAFP)){
					   contabilidadForm.setfPorDesAFP( Float.parseFloat( planilla.getvValor()));
				   }
				   if(planilla.getvConcepto().equals(Constantes.descCV)){
					   contabilidadForm.setfPorDesCV( Float.parseFloat( planilla.getvValor()));
				   }
				   if(planilla.getvConcepto().equals(Constantes.descPS)){
					   contabilidadForm.setfPorDesPS( Float.parseFloat( planilla.getvValor()));
				   }
				   if(planilla.getvConcepto().equals(Constantes.descSNP)){
					   contabilidadForm.setfPorDesSNP( Float.parseFloat( planilla.getvValor()));
				   }
				   
					
				}
			
					
			//}// else
			return mapping.findForward(msn);
		}
		
}
