package com.struts.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dao.ContabilidadDao;
import com.dao.EstadoDao;
import com.dao.GenericaDao;
import com.dao.IngresoProductoDao;
import com.dao.KardexDao;
import com.entities.Estado;
import com.entities.Estadocuentaproveedor;
import com.entities.Formapago;
import com.entities.Ingresoproducto;
import com.entities.Ingresoproductodetalle;
import com.entities.Ingresoproductodevolucion;
import com.entities.Ingresoproductodevoluciondetalle;
import com.entities.Kardex;
import com.entities.Moneda;
import com.entities.Periodo;
import com.entities.Preciosproducto;
import com.entities.Producto;
import com.entities.Proveedor;
import com.entities.Tipodocumentogestion;
import com.entities.Usuario;
import com.entities.Ventadetalle;
import com.entities.vo.EstadoCuentaVo;
import com.entities.vo.PagoEstadoCuentaVo;
import com.google.gson.Gson;
import com.struts.form.IngresoProductoForm;
import com.util.Constantes;
import com.util.Fechas;
import com.util.FormatosNumeros;
import com.util.Impresora;
import com.util.Imprimir;
import com.util.Paginacion;
import com.util.Util;

public class IngresoProductoAction extends BaseAction {
	// --------------------------------------------------------- Instance
	// Variables
	// --------------------------------------------------------- Methods

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param requestidu
	 * 
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
		
		/*if(sesion.getId()!=(sesion.getAttribute("id"))){
			response.sendRedirect("login.do?metodo=logout");				
		}
		else{*/
			
		
		    /***Inicializamos variables***/
			String mode = request.getParameter("mode");
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if(request.getParameter("pagina")!= null){
				 pagina = Integer.parseInt(request.getParameter("pagina"));
			}
			
			/**Seteamos los valores en las listas**/
			List<Ingresoproducto> listaIngresoproducto = new ArrayList<Ingresoproducto>();
			List<Ingresoproducto> listaIngresoproductoTotal = new ArrayList<Ingresoproducto>();
			List<Long> paginas = new ArrayList<Long>();
			
			/** Instanciamos la Clase IngresoproductoForm **/
			IngresoProductoForm objform = (IngresoProductoForm) form;
			

			/** Instanciamos las clase Daos **/
			GenericaDao generica = new GenericaDao();
			IngresoProductoDao ingresogenericaDao = new IngresoProductoDao();
			
			
			/**Lista de personal en Modal Popup***/
			if(mode!=null && mode.equals("LEP")){
				
				int idProveedor = Integer.parseInt(request.getParameter("id"));				
				objform.setProveedor(generica.findEndidad(objform.getProveedor(),idProveedor));
				 
				 
				 /**Seteamos los valores en las listas**/
					List<EstadoCuentaVo> listaEstadoCuenta = new ArrayList<EstadoCuentaVo>();
					
					
					/**Accedemos al Dao**/
					 listaIngresoproducto = ingresogenericaDao.listaEstadoCuentaPorProveedor(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getIngresoProducto(),idProveedor);
					    float montosTotales = 0;
					    float pagosTotales = 0;
					    float saldosTotales = 0;
					    int i=0;
					    
					    
					 for(Ingresoproducto obj:listaIngresoproducto)
					 {   float pagoTotal = 0;
					 float saldoTotal = 0;
						 EstadoCuentaVo e = new EstadoCuentaVo();
					     
				
					    // Tipodocumentogestion p = generica.findEndidad("Tipodocumentogestion", "iTipoDocumentoGestionId", obj.getiTipoDocumentoId()); 
					     e.setTipoDocumento(obj.getTipodocumento().getvTipoDocumentoDescripcion());
					     e.setNumeroDocumento(obj.getnIngresoProductoNumero().toString());
					     //Formapago f =  generica.findEndidad("Formapago", "iFormaPago", obj.getiFormaPagoId());
					     e.setFormaPago(obj.getFormaPago().getvFormaPagoDescripcion());
					     e.setPrimerFechaEmision(Fechas.fechaDDMMYY(obj.getdIngresoProductoFecha()));
					     e.setMontoTotal(obj.getfIngresoProductoTotal());
						 e.setcCodigoEstado(obj.getvEstadoDocumento());
					     e.setIdClienteProveedor(obj.getProveedor().getiProveedorId());
					     e.setIdDocumento(obj.getiIngresoProductoId());
					     e.setvPrincipal(obj.getvPrincipal());
					     e.setIdTipoDocumento(obj.getTipodocumento().getiTipoDocumentoGestionId());
					     if(obj.getEstadocuentaproveedors().size()>0){
					    	 List<PagoEstadoCuentaVo> listaEstaProve = new ArrayList<PagoEstadoCuentaVo>();
					    	 
						     for(Estadocuentaproveedor obje:obj.getEstadocuentaproveedors()){
						    	if(obje.getcEstadoCodigo().equals(Constantes.estadoActivo)){
						    	 PagoEstadoCuentaVo pagoEsta= new PagoEstadoCuentaVo(); 
						    	 pagoEsta.setiEstadoCuenta(obje.getiEstadoCuentaProveedor());
						    	 pagoEsta.setFechaPago(Fechas.fechaDDMMYY(obje.getdFechaPago()));
						    	 pagoEsta.setMontoPago(FormatosNumeros.FormatoDecimalMoneda(Double.parseDouble(String.valueOf(obje.getfMontoPago()))));
						    	 pagoEsta.setVendedor(obje.getsVendedor());
						    	 
						    	 pagoTotal+= obje.getfMontoPago();						    	
						    	 pagosTotales+= obje.getfMontoPago();
						    	
						    	 listaEstaProve.add(pagoEsta);
						    	}
						       } // for
						     e.setEstadocuenta(listaEstaProve);
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
					 
				/**Consultamos el total de registros segun criterio**/
				listaIngresoproductoTotal = ingresogenericaDao.listaEstadoCuentaPorProveedor(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getIngresoProducto(),idProveedor);
				
		        /**Obtenemos el total del paginas***/
				paginas = Paginacion.listPaginas((long)(listaIngresoproductoTotal.size()));
		 	     
				objform.setLista(listaEstadoCuenta);
				msn="showListEstadoCuentaPorProveedor";
				
			}
			/**Lista de compras en Modal Popup compras
			 * LP: lista popup para devoluciones de compras
			 * LPL: lista popup para cargar la factura la cual se generara la letra***/
			else if(mode!=null &&( mode.equals("LP") || mode.equals("LPL"))){
				   listaIngresoproducto = ingresogenericaDao.listaIngresoproducto(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getIngresoProducto());
				    
					/**Consultamos el total de registros segun criterio**/
					listaIngresoproductoTotal = ingresogenericaDao.listaIngresoproducto(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getIngresoProducto());
					
			        /**Obtenemos el total del paginas***/
					paginas = Paginacion.listPaginas((long)(listaIngresoproductoTotal.size()));
			 	     
					
					objform.setLista(listaIngresoproducto);				 
					msn ="showListPopupCompras";
				
			}
			else{
				 listaIngresoproducto = ingresogenericaDao.listaIngresoproducto(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getIngresoProducto());
		    
				/**Consultamos el total de registros segun criterio**/
				listaIngresoproductoTotal = ingresogenericaDao.listaIngresoproducto(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getIngresoProducto());
				
		        /**Obtenemos el total del paginas***/
				paginas = Paginacion.listPaginas((long)(listaIngresoproductoTotal.size()));
		 	     
				
				objform.setLista(listaIngresoproducto);
				 
				/***Redirecionamos  al ***/
				 msn ="showList";
				
			}
			/** Seteamos las clase IngresoproductoForm **/
	        
	        objform.setPaginas(paginas);
	        objform.setPagInicio(pagina);
	        objform.setMode(mode);
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
		IngresoProductoForm objform = (IngresoProductoForm) form;

		/** Instanciamos las clase Daos **/
		IngresoProductoDao ingresogenericaDao = new IngresoProductoDao();
		listaIngresoproducto = ingresogenericaDao.listaIngresoproductoDevolucion(Paginacion.pagInicio(pagina),
						Paginacion.pagFin(), objform.getIngresoProducto());

		/** Consultamos el total de registros segun criterio **/
		listaIngresoproductoTotal = ingresogenericaDao.listaIngresoproductoDevolucion(Paginacion.pagInicio(pagInicio),
						Paginacion.pagFinMax(), objform.getIngresoProducto());

		/** Obtenemos el total del paginas ***/
		paginas = Paginacion.listPaginas((long) (listaIngresoproductoTotal.size()));

		objform.setLista(listaIngresoproducto);

		/*** Redirecionamos al ***/
		msn = "showListIngresoDevolucion";

		/** Seteamos las clase IngresoproductoForm **/

		objform.setPaginas(paginas);
		objform.setPagInicio(pagina);
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
	public ActionForward mantenimientoIngresoproductoDevolucion(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession sesion = request.getSession();
		String mode = request.getParameter("mode");
		String msn = "";

		/** Instantacia al IngresoproductoForm **/
		IngresoProductoForm ingresoproductoform = (IngresoProductoForm) form;

		/** Instantacia a la capa Dao **/
		EstadoDao estadoDao = new EstadoDao();
		GenericaDao genericaDao = new GenericaDao();
		IngresoProductoDao ingresogenericaDao = new IngresoProductoDao();
		Usuario usu = (Usuario) sesion.getAttribute("Usuario");
		Moneda moneda = (Moneda)sesion.getAttribute("Moneda");
		

		/** llamado de los metodos de la clase dao **/

		List<Estado> listaEstado = estadoDao.listEstado();
		List<Ingresoproductodetalle> lista = new ArrayList<Ingresoproductodetalle>();
		List<Ingresoproductodetalle> listadev = new ArrayList<Ingresoproductodetalle>();
		List<Ingresoproductodevoluciondetalle> listadevOriginal = new ArrayList<Ingresoproductodevoluciondetalle>();
		List<Formapago> listaFormapago = genericaDao.listaEntidadGenericaSinCodigo("Formapago");
	    List<Tipodocumentogestion> listaTipoDoc = genericaDao.listaEntidadGenericaSinCodigo("Tipodocumentogestion");
        List<Estado> listaEstadoDocumento = Util.listaEstadoDocumento();
        ingresoproductoform.setTipoMoneda(moneda.getcModenaCodigo());
		ingresoproductoform.setIGVCompra(sesion.getAttribute("IGVCompras").toString());
		ingresoproductoform.setIGVPercepcion(sesion.getAttribute("IGVPercepcion").toString());
		
    //    List<Tipodocumentogestion> listaDocumentoGestion = Util.listaDocGest();
 		/**
		 * LLamamos al formulario mantenimientoIngresoproducto.jsp para la
		 * insercion de datos
		 **/
	    msn = "showEditIngresoProductoDevolucion";
		if (mode.equals("I")) {
			 /***LISTA DE DETALLE VENTA***/
			sesion.removeAttribute("listaIngresoProductoDetalle"); 
			sesion.removeAttribute("listaIngresoProductoDetalleCompra");
			sesion.removeAttribute("listaIngresoProductoDetalleOriginal");
			ingresoproductoform.getIngresoProductoDev().setnNroNotaDebito(ingresogenericaDao.callSPNro_Documento(8,"Ingresoproductodevolucion","nNroNotaDebito"));
		}
     
		/**
		 * LLamamos al formulario mantenimientoIngresoproducto.jsp para mostrar
		 * los datos del UPDATE
		 **/
		/** Seteamos el ingresoproductoform la clase Ingresoproducto **/
		else if (mode.equals("U")) {
			
		
			int id = Integer.parseInt(request.getParameter("id"));
			Ingresoproductodevolucion ingresoProductoDev = ingresogenericaDao.findEndidad(ingresoproductoform.getIngresoProductoDev(),id);			
			ingresoproductoform.setIngresoProductoDev(ingresoProductoDev);
			    
			/***COMPRAS FACTURA, BOLETA, NOTA DE PEDIDO***/				
				 /***LISTA DE DETALLE DE COMPRAS***/
				sesion.removeAttribute("listaIngresoProductoDetalleCompra");
				/**Agregamos a la session el detalle de la devolucion***/
				sesion.removeAttribute("listaIngresoProductoDetalle");
				sesion.removeAttribute("listaIngresoProductoDetalleOriginal");
				
				for(Ingresoproductodetalle e : ingresoProductoDev.getIngresoProducto().getIngresoproductodetalles()){					
					for(Ingresoproductodevoluciondetalle eobj: ingresoProductoDev.getIngresoproductodevoluciondetalles()){						
						if(e.getcEstadoCodigo().equals(Constantes.estadoActivo) && e.getProducto().getcProductoCodigo().equals(eobj.getProducto().getcProductoCodigo())){
							/**Agregamos a la Lista el detalle de la compra original**/
							Ingresoproducto ingresoproducto = new Ingresoproducto();
							e.getIngresoproducto().getProveedor().setEstadocuentaproveedors(null);
							e.getIngresoproducto().getProveedor().setSalidaproductos(null);
							e.getIngresoproducto().getProveedor().setIngresoproductos(null);
							
							ingresoproducto.setiIngresoProductoId(e.getIngresoproducto().getiIngresoProductoId());
							ingresoproducto.setfIngresoProductoIGV(e.getIngresoproducto().getfIngresoProductoIGV());
							ingresoproducto.setfIngresoProductoSubTotal(e.getIngresoproducto().getfIngresoProductoSubTotal());
							ingresoproducto.setfIngresoProductoTotal(e.getIngresoproducto().getfIngresoProductoTotal());
							ingresoproducto.setdIngresoProductoFecha(e.getIngresoproducto().getdIngresoProductoFecha());
							ingresoproducto.setnIngresoProductoNumero(e.getIngresoproducto().getnIngresoProductoNumero());
							ingresoproducto.setvEstadoDocumento(e.getIngresoproducto().getvEstadoDocumento());
							ingresoproducto.setFormaPago(e.getIngresoproducto().getFormaPago());
							ingresoproducto.setTipodocumento(e.getIngresoproducto().getTipodocumento());
							ingresoproducto.setProveedor(e.getIngresoproducto().getProveedor());
						
							
							e.setIngresoproducto(ingresoproducto);
							
							e.getProducto().setIngresoproductodetalles(null);
							e.getProducto().setVentadetalles(null);
							e.getProducto().setKardexs(null);	
							e.setcEstadoCodigo(eobj.getcEstadoCodigo());			
							lista.add(e);
							
							
							/**agregamos a la listadev el detalle de la devolucion de los productos**/
							ingresoproducto = new Ingresoproducto();
						    e  = new Ingresoproductodetalle();
							eobj.getIngresoproductodevolucion().getIngresoProducto().getProveedor().setEstadocuentaproveedors(null);
							eobj.getIngresoproductodevolucion().getIngresoProducto().getProveedor().setSalidaproductos(null);
							eobj.getIngresoproductodevolucion().getIngresoProducto().getProveedor().setIngresoproductos(null);
							
							ingresoproducto.setiIngresoProductoId(eobj.getIngresoproductodevolucion().getIngresoProducto().getiIngresoProductoId());
							ingresoproducto.setfIngresoProductoIGV(eobj.getIngresoproductodevolucion().getIngresoProducto().getfIngresoProductoIGV());
							ingresoproducto.setfIngresoProductoSubTotal(eobj.getIngresoproductodevolucion().getIngresoProducto().getfIngresoProductoSubTotal());
							ingresoproducto.setfIngresoProductoTotal(eobj.getIngresoproductodevolucion().getIngresoProducto().getfIngresoProductoTotal());
							ingresoproducto.setdIngresoProductoFecha(eobj.getIngresoproductodevolucion().getIngresoProducto().getdIngresoProductoFecha());
							ingresoproducto.setnIngresoProductoNumero(eobj.getIngresoproductodevolucion().getIngresoProducto().getnIngresoProductoNumero());
							ingresoproducto.setvEstadoDocumento(eobj.getIngresoproductodevolucion().getIngresoProducto().getvEstadoDocumento());
							ingresoproducto.setFormaPago(eobj.getIngresoproductodevolucion().getIngresoProducto().getFormaPago());
							ingresoproducto.setTipodocumento(eobj.getIngresoproductodevolucion().getIngresoProducto().getTipodocumento());
							ingresoproducto.setProveedor(eobj.getIngresoproductodevolucion().getIngresoProducto().getProveedor());
						
							
							e.setIngresoproducto(ingresoproducto);
							
							eobj.getProducto().setIngresoproductodetalles(null);
							eobj.getProducto().setVentadetalles(null);
							eobj.getProducto().setKardexs(null);	
							e.setProducto(eobj.getProducto());
							e.setfIngresoProductoDetallePrecio(eobj.getfIngresoProductoDevDetallePrecio());
							e.setfIngresoProductoDetalleTotal(eobj.getfIngresoProductoDevDetalleTotal());
							e.setiIngresoProductoDetalleCantidad(eobj.getiIngresoProductoDevDetalleCantidad());
							e.setiIngresoProductoDetalleId(eobj.getiIngresoProductoDevolucionDetalleId());
							e.setcEstadoCodigo(eobj.getcEstadoCodigo());
							
							listadev.add(e);
							listadevOriginal.add(eobj);
							
					  }//if
					}// for
				}// for
				
				ingresoproductoform.setIngresoProducto(ingresoProductoDev.getIngresoProducto());
				sesion.setAttribute("listaIngresoProductoDetalleCompra",lista);				
				sesion.setAttribute("listaIngresoProductoDetalle",listadev);
				sesion.setAttribute("listaIngresoProductoDetalleOriginal",listadevOriginal);
		   	    
				ingresoproductoform.setvProveedorDireccion(ingresoProductoDev.getIngresoProducto().getProveedor().getvProveedorDireccion());
				ingresoproductoform.setIngresoProductoDev(ingresoProductoDev);
			   	
		}
		/**
		 * LLamamos al formulario buscarMantenimientoPerfil.jsp para realizar la
		 * busqueda
		 **/
		else if (mode.equals("F")) {
			
			msn = "showFindDevolucionCompra";
			
		} 

		ingresoproductoform.setMode(mode);

		/** Colocamos en session las listas **/
		
		sesion.setAttribute("listaEstado", listaEstado);
		sesion.setAttribute("listaFormapago", listaFormapago);
		sesion.setAttribute("listaTipoDoc", listaTipoDoc);
		sesion.setAttribute("listaEstadoDocumento", listaEstadoDocumento);
		


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
		public ActionForward detalleIngresoProducto(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response) throws IOException{
      
			response.setContentType("text/json");	
			HttpSession sesion = request.getSession();
			
			Gson gson = new Gson();			
			GenericaDao genericaDao = new GenericaDao();
			IngresoProductoDao ingresoProductoDao = new IngresoProductoDao();
			
			int iProductoId = Integer.parseInt(request.getParameter("id"));
			String mode = request.getParameter("mode");
			
			/** Instanciamos la Clase VentaForm **/
		
			
			List<Ingresoproductodetalle> lista = (List<Ingresoproductodetalle>) sesion.getAttribute("listaIngresoProductoDetalle");
			Producto productoBean= new Producto();			
			Ingresoproductodetalle ingresodetalle  = new Ingresoproductodetalle();
			
			if(mode.equals("I")){
				
				int iCantidad = Integer.parseInt(request.getParameter("iCantidad"));	
				float fPrecioCompra = Float.parseFloat(request.getParameter("fPrecioCompra"));	
				float fDescuento = Float.parseFloat(request.getParameter("fDescuento"));
				float fGanancia = Float.parseFloat(request.getParameter("fGanancia"));
				float fPrecioVenta = Float.parseFloat(request.getParameter("fPrecioVenta"));
				float fTotal = Float.parseFloat(request.getParameter("fTotal"));
				
				Producto producto  = genericaDao.findEndidad(productoBean,iProductoId);	
				
				productoBean.setiProductoId(producto.getiProductoId());
				productoBean.setcProductoCodigo(producto.getcProductoCodigo());
				productoBean.setvProductoNombre(producto.getvProductoNombre());
				productoBean.setUnidadMedida(producto.getUnidadMedida());
				productoBean.setvProductoCapacidad(producto.getvProductoCapacidad());
				productoBean.setfProductoGanancia(fGanancia);
				productoBean.setfProductoPrecioVenta(fPrecioVenta);
				
				
				ingresodetalle.setProducto(productoBean);
				ingresodetalle.setcEstadoCodigo(Constantes.estadoActivo);
				ingresodetalle.setiIngresoProductoDetalleCantidad(iCantidad);
				ingresodetalle.setfIngresoProductoDetallePrecio(fPrecioCompra);
				ingresodetalle.setfIngresoProductoDetalleTotal(fTotal);
				ingresodetalle.setfDescuento(fDescuento);
				
				lista.add(ingresodetalle);
				sesion.setAttribute("listaIngresoProductoDetalle", lista);
			}
			 if(mode.equals("D")){
				 //  lista.remove(iProductoId);
				 if(lista.get(iProductoId).getcEstadoCodigo().equals(Constantes.estadoActivo))
					 lista.get(iProductoId).setcEstadoCodigo(Constantes.estadoInactivo);
				 else
					 lista.get(iProductoId).setcEstadoCodigo(Constantes.estadoActivo);
				   
				   sesion.setAttribute("listaIngresoProductoDetalle", lista);
				   
			}
			 if(mode.equals("U")){
				    int iCantidad = Integer.parseInt(request.getParameter("iCantidad"));	
					float fPrecioCompra = Float.parseFloat(request.getParameter("fPrecioCompra"));	
					float fDescuento = Float.parseFloat(request.getParameter("fDescuento"));					
					float fPrecioCompraFinal = (fPrecioCompra-fPrecioCompra*fDescuento/100);
					
				  
				   lista.get(iProductoId).setfIngresoProductoDetallePrecio(fPrecioCompra);
				   lista.get(iProductoId).setfIngresoProductoDetalleTotal((iCantidad*fPrecioCompraFinal));
				   lista.get(iProductoId).setiIngresoProductoDetalleCantidad(iCantidad);
				   lista.get(iProductoId).setfDescuento(fDescuento);
				   
			
				   sesion.setAttribute("listaIngresoProductoDetalle", lista);
			}
			/***consultamos el detalle de la compra para hacer la devolucion de la compra
			 * ID= Insercion de devolucion de compras**/
			if(mode.equals("ID")){
				 sesion.removeAttribute("listaIngresoProductoDetalle");
				 lista = new ArrayList<Ingresoproductodetalle>();
				 List<Ingresoproductodetalle> listas = ingresoProductoDao.buscarIngresoproductoDetalle(iProductoId);
				for(Ingresoproductodetalle e: listas){
					Ingresoproducto ingresoproducto = new Ingresoproducto();
					
					Ingresoproductodetalle ingresoProductoDet = new Ingresoproductodetalle();
					
					ingresoproducto.setiIngresoProductoId(e.getIngresoproducto().getiIngresoProductoId());
					ingresoproducto.setfIngresoProductoIGV(e.getIngresoproducto().getfIngresoProductoIGV());
					ingresoproducto.setfIngresoProductoSubTotal(e.getIngresoproducto().getfIngresoProductoSubTotal());
					ingresoproducto.setfIngresoProductoTotal(e.getIngresoproducto().getfIngresoProductoTotal());
					ingresoproducto.setdIngresoProductoFecha(e.getIngresoproducto().getdIngresoProductoFecha());
					ingresoproducto.setnIngresoProductoNumero(e.getIngresoproducto().getnIngresoProductoNumero());
					ingresoproducto.setvEstadoDocumento(e.getIngresoproducto().getvEstadoDocumento());
					ingresoproducto.setFormaPago(e.getIngresoproducto().getFormaPago());
					ingresoproducto.setTipodocumento(e.getIngresoproducto().getTipodocumento());
					
					Proveedor proveedorBean = new Proveedor();
					
					proveedorBean.setiProveedorId(e.getIngresoproducto().getProveedor().getiProveedorId());
					proveedorBean.setcProveedorCodigo(e.getIngresoproducto().getProveedor().getcProveedorCodigo());
					proveedorBean.setvProveedorRazonSocial(e.getIngresoproducto().getProveedor().getvProveedorRazonSocial());
					proveedorBean.setvProveedorDireccion(e.getIngresoproducto().getProveedor().getvProveedorDireccion());
					proveedorBean.setnProveedorNumeroDocumento(e.getIngresoproducto().getProveedor().getnProveedorNumeroDocumento());
					
					ingresoproducto.setProveedor(proveedorBean);
				 
					
					ingresoProductoDet.setIngresoproducto(ingresoproducto);
					ingresoProductoDet.setcEstadoCodigo(Constantes.estadoActivo);
					ingresoProductoDet.setiIngresoProductoDetalleCantidad(e.getiIngresoProductoDetalleCantidad());
					ingresoProductoDet.setfIngresoProductoDetallePrecio(e.getfIngresoProductoDetallePrecio());
					ingresoProductoDet.setfIngresoProductoDetalleTotal(e.getfIngresoProductoDetalleTotal());
					ingresoProductoDet.setfDescuento(e.getfDescuento());
					
					Producto productoVo = new Producto();
					productoVo.setiProductoId(e.getProducto().getiProductoId());
					productoVo.setcProductoCodigo(e.getProducto().getcProductoCodigo());
					productoVo.setvProductoNombre(e.getProducto().getvProductoNombre());
					productoVo.setUnidadMedida(e.getProducto().getUnidadMedida());
					productoVo.setvProductoCapacidad(e.getProducto().getvProductoCapacidad());
					
					
					ingresoProductoDet.setProducto(productoVo);
									
					
					lista.add(ingresoProductoDet);					
				 }
				sesion.setAttribute("listaIngresoProductoDetalle", lista);
			//	sesion.setAttribute("listaIngresoProductoDetalleDevol", lista);
				
			}
	     
			String jsonOutput = gson.toJson(lista);
			
			
			//response.getWriter().write(json);
			
			PrintWriter pw;
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
	 */
	public ActionForward mantenimientoIngresoproducto(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession sesion = request.getSession();
		String mode = request.getParameter("mode");
		String msn = "";

		/** Instantacia al IngresoproductoForm **/
		IngresoProductoForm ingresoproductoform = (IngresoProductoForm) form;

		/** Instantacia a la capa Dao **/
		EstadoDao estadoDao = new EstadoDao();
		
		IngresoProductoDao ingresogenericaDao = new IngresoProductoDao();
		Usuario usu = (Usuario) sesion.getAttribute("Usuario");
		Moneda moneda = (Moneda)sesion.getAttribute("Moneda");
		float tipoCambio = Float.parseFloat((String) sesion.getAttribute("TipoCambio"));
		
		

		/** llamado de los metodos de la clase dao **/

		List<Estado> listaEstado = estadoDao.listEstado();
		List<Ingresoproductodetalle> lista = new ArrayList<Ingresoproductodetalle>();	
		List<Formapago> listaFormapago = ingresogenericaDao.listaEntidadGenericaSinCodigo("Formapago");
	    List<Tipodocumentogestion> listaTipoDoc = ingresogenericaDao.listaEntidadGenericaSinCodigo("Tipodocumentogestion");
	    List<Periodo> listaPeriodo =  ingresogenericaDao.listaEntidadGenericaSinCodigo("Periodo");
	    
	    
		
	    /**
		 * LLamamos al formulario mantenimientoIngresoproducto.jsp para la
		 * insercion de datos
		 **/
		if (mode.equals("I")) {
			String tipoDocumento = request.getParameter("idTipoDocumento");
			
			 ingresoproductoform.setTipoMoneda(moneda.getcModenaCodigo());
			 ingresoproductoform.setIGVCompra(sesion.getAttribute("IGVCompras").toString());
			 ingresoproductoform.setIGVPercepcion(sesion.getAttribute("IGVPercepcion").toString());
			 ingresoproductoform.setvPersonalNombres(usu.getPersonal().getvPersonalNombres()+" "+usu.getPersonal().getvPersonalApellidoPaterno()); 
			 ingresoproductoform.setcPersonalCodigo(usu.getPersonal().getcPersonalCodigo());
				
			
			ingresoproductoform.setiTipoDocumentoId(Integer.parseInt(tipoDocumento));
			ingresoproductoform.setIclasificacionId(Integer.parseInt( request.getParameter("iclasificacionId")));
			ingresoproductoform.setfTipoCambio(tipoCambio);
			/***LISTA DE DETALLE VENTA***/
			sesion.removeAttribute("listaIngresoProductoDetalle");
			 
	 	     if(sesion.getAttribute("listaIngresoProductoDetalle")==null){				
								 sesion.setAttribute("listaIngresoProductoDetalle", lista);
			 }
			
			 
			 /*if(tipoDocumento.equals("1"))
					msn = "showEditFactura";			
			 if(tipoDocumento.equals("2"))
				  // msn = "showEditBoleta";
				 msn = "showEditFactura";
			 if(tipoDocumento.equals("3"))
				  // msn = "showEditNotaDebito";
				 msn = "showEditFactura";
			 if(tipoDocumento.equals("4"))
				 //  msn = "showEditGuiaRemision";
				 msn = "showEditFactura";
			 if(tipoDocumento.equals("5"))
				 //  msn = "showEditPedido";*/
				 msn = "showEditFactura";
		}
       else if (mode.equals("IE")) {
				msn = "showEstadoCuenta";
		}
      
		/**
		 * LLamamos al formulario mantenimientoIngresoproducto.jsp para mostrar
		 * los datos del UPDATE
		 **/
		/** Seteamos el ingresoproductoform la clase Ingresoproducto **/
		else if (mode.equals("U") || mode.equals("UE")) {
			
		
			int id = Integer.parseInt(request.getParameter("id"));
			String tipoDocumento = request.getParameter("idTipoDocumento");
			
			
			Ingresoproducto ingresoProducto = ingresogenericaDao.findEndidad(ingresoproductoform.getIngresoProducto(),id);
			
			ingresoproductoform.setIngresoProducto(ingresoProducto);
			ingresoproductoform.setTipoMoneda(ingresoProducto.getvTipoCompra());
			ingresoproductoform.setIGVCompra(ingresoProducto.getvPorcentajeIGV());
			
			if(mode.equals("UE")){
				
				/***INGRESO DE VENTAS MEDIANTE EL ESTADO DE CUENTA DEL CLIENTE***/		
				
					ingresoproductoform.setPagoTotal(Float.parseFloat(request.getParameter("pagoTotal")));
					ingresoproductoform.setvProveedorDireccion(ingresoProducto.getProveedor().getvProveedorDireccion());
												
						msn = "showEstadoCuenta";
						mode="UE";
				// Ingreso Estado cuenta Cliente a la tabla Ingreso Producto (Compras)
			}
			else{
				
				 /***COMPRAS FACTURA, BOLETA, NOTA DE PEDIDO***/				
				 /***LISTA DE DETALLE DE COMPRAS***/
				sesion.removeAttribute("listaIngresoProductoDetalle");					
				for(Ingresoproductodetalle obj : ingresoProducto.getIngresoproductodetalles()){
					if(obj.getcEstadoCodigo().equals(Constantes.estadoActivo)){
					    Ingresoproductodetalle ingresoDetalle = new Ingresoproductodetalle();
						//ventaDetalle.setVenta(obj.getVenta());
					    obj.getProducto().setIngresoproductodetalles(new ArrayList<Ingresoproductodetalle>());
					    obj.getProducto().setVentadetalles(new ArrayList<Ventadetalle>());
					    obj.getProducto().setKardexs(new ArrayList<Kardex>());
					
					    ingresoDetalle.setProducto(obj.getProducto());
					    ingresoDetalle.setiIngresoProductoDetalleId(obj.getiIngresoProductoDetalleId());
					    ingresoDetalle.setcEstadoCodigo(obj.getcEstadoCodigo());
					    ingresoDetalle.setfIngresoProductoDetallePrecio(obj.getfIngresoProductoDetallePrecio());
					    ingresoDetalle.setfIngresoProductoDetalleTotal(obj.getfIngresoProductoDetalleTotal());
					    ingresoDetalle.setiIngresoProductoDetalleCantidad(obj.getiIngresoProductoDetalleCantidad());
					    ingresoDetalle.setfDescuento(obj.getfDescuento());
						
						lista.add(ingresoDetalle);
					 }
				}
				
				sesion.setAttribute("listaIngresoProductoDetalle",lista);
				ingresoproductoform.setvProveedorDireccion(ingresoProducto.getProveedor().getvProveedorDireccion());
				ingresoproductoform.setiTipoDocumentoId(Integer.parseInt(tipoDocumento));
			//	ingresoproductoform.setIclasificacionId(Integer.parseInt( request.getParameter("iclasificacionId")));
				ingresoproductoform.setcPersonalCodigo(ingresoProducto.getUsuario().getPersonal().getcPersonalCodigo());
				ingresoproductoform.setvPersonalNombres(ingresoProducto.getUsuario().getPersonal().getvPersonalNombres()+" "+ ingresoProducto.getUsuario().getPersonal().getvPersonalApellidoPaterno());
				
				ingresoproductoform.setIngresoProducto(ingresoProducto);
			   	

				/* if(tipoDocumento.equals("1"))
						msn = "showEditFactura";			
				 if(tipoDocumento.equals("2"))
					 msn = "showEditFactura";
					// msn = "showEditBoleta";
				 if(tipoDocumento.equals("3"))
					 msn = "showEditFactura";
					// msn = "showEditNotaDebito";
				 if(tipoDocumento.equals("4"))
					 msn = "showEditFactura";
					// msn = "showEditGuiaRemision";
				 if(tipoDocumento.equals("5"))*/
					 msn = "showEditFactura";
					// msn = "showEditPedido";
			}
			

		}
		/**
		 * LLamamos al formulario buscarMantenimientoPerfil.jsp para realizar la
		 * busqueda
		 **/
		else if (mode.equals("F")) {
			
			msn = "showFind";
			
		} 

		ingresoproductoform.setMode(mode);

		/** Colocamos en session las listas **/
		
		sesion.setAttribute("listaEstado", listaEstado);
		sesion.setAttribute("listaFormapago", listaFormapago);
		sesion.setAttribute("listaTipoDoc", listaTipoDoc);
		sesion.setAttribute("listaPeriodo", listaPeriodo);


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
	public ActionForward iduIngresoproducto(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IllegalArgumentException, SecurityException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException, ParseException {

		/** Inicializamos las variables **/
		String msn = "";
		String mode = request.getParameter("mode");
		String ids = request.getParameter("ids");
		boolean resultado = false;
		int cantidadProducto = 0, cantidadProductoActual=0;
		float precioProducto =(float) 0.0;
		HttpSession sesion = request.getSession();

		/** Instanciamos las clase IngresoproductoForm y IngresogenericaDao **/
		IngresoProductoForm pForm = (IngresoProductoForm) form;
		IngresoProductoDao ingresogenericaDao = new IngresoProductoDao();
		 Usuario usu = (Usuario) sesion.getAttribute("Usuario");
		 int iPeriodoId = (Integer) sesion.getAttribute("iPeriodoId");
		
		
		List<Ingresoproductodetalle> ingresodetalles = new  ArrayList<Ingresoproductodetalle>();
		List<Kardex> listaKardex = new  ArrayList<Kardex>();
		List<Kardex> listaKardexActivo = new  ArrayList<Kardex>();
		ContabilidadDao contabilidadDao = new ContabilidadDao();
		KardexDao kardexDao = new KardexDao();
		Ingresoproducto obj = pForm.getIngresoProducto();
		 Date fecha = Fechas.getDate();	 
		 if(obj.getFormaPago()!=null)
            fecha = (obj.getFormaPago().getiFormaPago()==3?Fechas.fechaDate("30/"+(Fechas.mesFecha(fecha)+1)+"/"+Fechas.anioFecha(fecha)):obj.getdFechaProximoPago());
         obj.setdFechaProximoPago(fecha);
  
		/** Iniciamos instacia de transacion **/
         EntityTransaction transaccion = null;
         try {
         	transaccion = ingresogenericaDao.entityTransaction();
	        transaccion.begin();
	         
			if (pForm.getMode().equals("I") || pForm.getMode().equals("IE")) {
				
				/*** Informacion de la compra****/
			   obj.setdFechaInserta(Fechas.getDate());
	      	   obj.setvPrincipal(Constantes.vPrincipal);      	  
	      	   obj.setcEstadoCodigo(Constantes.estadoActivo);
	      	   obj.setUsuario(usu);
	      	   obj.setiPeriodoId(iPeriodoId);
	      	   obj.setSucursal(usu.getSucursal());
	           obj.setvPorcentajeIGV(sesion.getAttribute("IGVCompras").toString());
	      	   
	      	  	
	      	   /****Informacion de detalle compra****/
	      	   if(sesion.getAttribute("listaIngresoProductoDetalle")!=null){
		      	   for(Ingresoproductodetalle ingresoDetalle:(List<Ingresoproductodetalle>) sesion.getAttribute("listaIngresoProductoDetalle")){
		      		       
		      		   if(ingresoDetalle.getcEstadoCodigo().equals(Constantes.estadoActivo)){
		      			  ingresoDetalle.setIngresoproducto(obj);      			   
		      			  ingresoDetalle.setdFechaInserta(Fechas.getDate());
		      			  ingresoDetalle.setiUsuarioInsertaId(usu.getiUsuarioId());
				      	   
		      			  Producto producto = ingresogenericaDao.findEndidad(ingresoDetalle.getProducto(), ingresoDetalle.getProducto().getiProductoId());
		      			    
	      			    /******************************************/
						/**Insertamos detalle de lista de precios**/
						/******************************************/
		      			  int iAsignado =0;
		      			  for(Preciosproducto preciosProducto:producto.getPreciosproductodetallles()){
				      		  if(preciosProducto.getfPrecioCompra()==ingresoDetalle.getfIngresoProductoDetallePrecio()) {
				      		      			preciosProducto.setiCantidadStock(preciosProducto.getiCantidadStock()+ingresoDetalle.getiIngresoProductoDetalleCantidad());
					      		      		preciosProducto.setfPrecioVenta(FormatosNumeros.redondedoDecimal(ingresoDetalle.getProducto().getfProductoPrecioVenta()));
					      		      		preciosProducto.setfGanancia(ingresoDetalle.getProducto().getfProductoGanancia());
			      			              
				      		      		    iAsignado=1;
				      		      			break;		      		  
				      		  }			      		  
				      	  }
		      			  if(iAsignado==0){	      				
				      			Preciosproducto preciosProducto1 = new Preciosproducto();
				      			                preciosProducto1.setiCantidadStock(ingresoDetalle.getiIngresoProductoDetalleCantidad());
				      			                preciosProducto1.setfPrecioCompra(FormatosNumeros.redondedoDecimal(ingresoDetalle.getfIngresoProductoDetallePrecio()));
				      			                preciosProducto1.setfPrecioVenta(FormatosNumeros.redondedoDecimal(ingresoDetalle.getProducto().getfProductoPrecioVenta()));
				      			                preciosProducto1.setfGanancia(ingresoDetalle.getProducto().getfProductoGanancia());
				      			                preciosProducto1.setcEstadoCodigo(Constantes.estadoActivo);
				      			                preciosProducto1.setdFechaInserta(Fechas.getDate());
				      			                preciosProducto1.setProducto(producto);
				      			
				      	           producto.getPreciosproductodetallles().add(preciosProducto1);		      		 
				      		
		      			  }
		      			  
		      				  
			      			  /***********************************************************************************/
			      			  /***Actualizamos la cantidad del producto en stock, el precio de compra y venta*****/	 
			      			  /*** Segun metodologia FIFO- Primero en entrar, Primero en Salir                  **/
			      			  /***********************************************************************************/
			      			for(Preciosproducto objpreciosProducto:producto.getPreciosproductodetallles()){
			      				 if(objpreciosProducto.getiCantidadStock()>0 && objpreciosProducto.getcEstadoCodigo().equals(Constantes.estadoActivo)){
			      					   cantidadProducto =   producto.getiProductoStockCantidad() + ingresoDetalle.getiIngresoProductoDetalleCantidad();
					      			   precioProducto = objpreciosProducto.getfPrecioCompra();
							           producto.setiProductoStockCantidad(cantidadProducto);
							           producto.setfProductoPrecioVenta(FormatosNumeros.redondedoDecimal(objpreciosProducto.getfPrecioVenta()));
							           producto.setfProductoGanancia(objpreciosProducto.getfGanancia());     		      		
							           producto.setfProductoPrecioCompra(FormatosNumeros.redondedoDecimal(precioProducto));
							           break;
			      				 }
			      			}			           
				           ingresogenericaDao.mergeEndidad(producto); 
		      			 
				           /***Agregamos las actualizaciones en la lista ventadetalles****/  
				           ingresodetalles.add(ingresoDetalle);
				           
				           /***Agregamos al Kardex el movimiento de los productos***/
				           Kardex   kardex = new Kardex();
								kardex.setProducto(producto);
								kardex.setIngresoProducto(obj);
								kardex.setdFecha(Fechas.getDate());						
								kardex.setvConcepto(Constantes.conceptoCompra+ingresogenericaDao.findEndidad(pForm.getTipodocumentogestion(), pForm.getiTipoDocumentoId()).getvTipoDocumentoDescripcion()+Constantes.nro+obj.getnIngresoProductoNumero());						
								kardex.setiCantIngresoProducto(ingresoDetalle.getiIngresoProductoDetalleCantidad());
								kardex.setfPuIngresoProducto(ingresoDetalle.getfIngresoProductoDetallePrecio());
								kardex.setfTotalngresoProducto(ingresoDetalle.getfIngresoProductoDetalleTotal());						
								kardex.setiCantExistencia(ingresoDetalle.getiIngresoProductoDetalleCantidad());
								kardex.setfPuExistencia(ingresoDetalle.getfIngresoProductoDetallePrecio());
								kardex.setfTotalExistencia(ingresoDetalle.getfIngresoProductoDetalleTotal());
								kardex.setiUsuarioInsertaId(usu.getiUsuarioId());
								kardex.setdFechaInserta(Fechas.getDate());
								kardex.setiPeriodoId(iPeriodoId);
								kardex.setcEstadoCodigo(Constantes.estadoActivo);
								/** Colocamos inactivo a la lista anterior**/
								//
								 for(Kardex objKardex:kardexDao.buscarKardexProducto(ingresoDetalle.getProducto().getiProductoId())){							        
									if(objKardex.getfPuExistencia()==ingresoDetalle.getfIngresoProductoDetallePrecio()){
										kardex.setiCantExistencia(objKardex.getiCantExistencia()+ingresoDetalle.getiIngresoProductoDetalleCantidad());
										kardex.setfPuExistencia(ingresoDetalle.getfIngresoProductoDetallePrecio());
										kardex.setfTotalExistencia((objKardex.getiCantExistencia()+ingresoDetalle.getiIngresoProductoDetalleCantidad())*ingresoDetalle.getfIngresoProductoDetallePrecio());
										objKardex.setcEstadoCodigo(Constantes.estadoInactivo);
										break;
						            }		
								}
								
								
								/***Agregamos en la lista kardex****/  
								listaKardexActivo.add(kardex);
								
		      		   }// activo
		      		 		 
		      		
		      	   }// detalle compra
		      	   
		      	  
		      	    obj.setIngresoproductodetalles(ingresodetalles);
		      	    obj.setKardex(listaKardexActivo);
	      	   }// if
	      	   
	      	   /**IE: Ingreso de estado de cuenta de proveedor**/
	      	   if(pForm.getMode().equals("IE")){
	       	       obj.setfIngresoProductoIGV(0);		          	   
	         	   obj.setfIngresoProductoSubTotal(0);		          	   
	         	   obj.setvPrincipal(Constantes.vnPrincipal);
	             }
		      	
		         
		         ingresogenericaDao.persistEndidad(obj);
		         resultado = ingresogenericaDao.commitEndidad(transaccion);
		         ingresogenericaDao.refreshEndidad(obj);
		         if(resultado==true){
		        	 int iIngresoProductoId=obj.getiIngresoProductoId();
		        	 int iFormaPagoId= obj.getFormaPago().getiFormaPago();
		        	 transaccion= ingresogenericaDao.entityTransaction();
		        	 transaccion.begin();
		        	 int nNumeroLetra=1;
		        	 contabilidadDao.callCompraContabilidad(iIngresoProductoId,fecha, pForm.getfMontoAdelantado(), usu.getiUsuarioId(), pForm.getiNumeroLetras(), pForm.getiNumeroDias(),pForm.getMode(),iPeriodoId, nNumeroLetra,iFormaPagoId);
		        	 resultado = ingresogenericaDao.commitEndidad(transaccion);
		         }
	             //ingresogenericaDao.refreshEndidad(obj);
		         
				}// fin de insercion
			   
			/*****************************************************************************************/
			/** U: Actualizacion de la Entidad IngresoProducto                                      **/
			/** UE: Actualizacion de la IngresoProducto por medio del estado de cuenta del proveedor */
			/*****************************************************************************************/
			   else if (pForm.getMode().equals("U") || pForm.getMode().equals("UE")) {
				
			    obj = ingresogenericaDao.findEndidad(pForm.getIngresoProducto(),pForm.getIngresoProducto().getiIngresoProductoId()); 
				obj= Util.comparar(obj, pForm.getIngresoProducto());//pForm.getVenta();
				obj.setiUsuarioActualizaId(usu.getiUsuarioId());
				obj.setdFechaActualiza(Fechas.getDate());
				
				int i= 0;
					 
					 List<Ingresoproductodetalle>  listSession = (List<Ingresoproductodetalle>) sesion.getAttribute("listaIngresoProductoDetalle");			
					 
						  for(Ingresoproductodetalle ingresoDetalle:listSession){			       			
							  /***************************/
							  /** Obtenemos el producto */
							  /**************************/
							  Producto producto = ingresogenericaDao.findEndidad(ingresoDetalle.getProducto(), ingresoDetalle.getProducto().getiProductoId());
							
							  /*****************************************/
							  /** Registro nuevo del detalle de compra**/
							  /*****************************************/
							  if(ingresoDetalle.getiIngresoProductoDetalleId()==0 && ingresoDetalle.getcEstadoCodigo().equals(Constantes.estadoActivo)){
								    ingresoDetalle.setIngresoproducto(obj);			       			
					       			ingresoDetalle.setdFechaInserta(Fechas.getDate());
					       			ingresoDetalle.setiUsuarioInsertaId(0);
					       			
					      			    /******************************************/
										/**Insertamos detalle de lista de precios**/
										/******************************************/
						      			  int iAsignado =0;
						      			  for(Preciosproducto preciosProducto:producto.getPreciosproductodetallles()){
								      		  if(preciosProducto.getfPrecioCompra()==ingresoDetalle.getfIngresoProductoDetallePrecio()) {
								      		      			preciosProducto.setiCantidadStock(preciosProducto.getiCantidadStock()+ingresoDetalle.getiIngresoProductoDetalleCantidad());
								      		      		    preciosProducto.setfPrecioVenta(FormatosNumeros.redondedoDecimal(ingresoDetalle.getProducto().getfProductoPrecioVenta()));
						      			                    preciosProducto.setfGanancia(ingresoDetalle.getProducto().getfProductoGanancia());
						      			               
								      		      			iAsignado=1;
								      		      			break;		      		  
								      		  }			      		  
								      	  }
						      			  if(iAsignado==0){	      				
								      			Preciosproducto preciosProducto1 = new Preciosproducto();
								      			                preciosProducto1.setiCantidadStock(ingresoDetalle.getiIngresoProductoDetalleCantidad());
								      			                preciosProducto1.setfPrecioCompra(FormatosNumeros.redondedoDecimal(ingresoDetalle.getfIngresoProductoDetallePrecio()));
								      			                preciosProducto1.setfPrecioVenta(FormatosNumeros.redondedoDecimal(ingresoDetalle.getProducto().getfProductoPrecioVenta()));
								      			                preciosProducto1.setfGanancia(ingresoDetalle.getProducto().getfProductoGanancia());
								      			               
								      			                preciosProducto1.setcEstadoCodigo(Constantes.estadoActivo);
								      			                preciosProducto1.setdFechaInserta(Fechas.getDate());
								      			                preciosProducto1.setProducto(producto);
								      			
								      	           producto.getPreciosproductodetallles().add(preciosProducto1);		      		 
								      		
						      			  }
						      					
								           /***********************************************************************************/
							      		   /***Actualizamos la cantidad del producto en stock, el precio de compra y venta*****/	 
							      		   /*** Segun metodologia FIFO- Primero en entrar, Primero en Salir                  **/
							      		   /***********************************************************************************/
							      			for(Preciosproducto objpreciosProducto:producto.getPreciosproductodetallles()){
							      				 if(objpreciosProducto.getiCantidadStock()>0  && objpreciosProducto.getcEstadoCodigo().equals(Constantes.estadoActivo)){
							      					 cantidadProducto =   producto.getiProductoStockCantidad() + ingresoDetalle.getiIngresoProductoDetalleCantidad();
									      			   precioProducto = objpreciosProducto.getfPrecioCompra();
											           producto.setiProductoStockCantidad(cantidadProducto);
											           producto.setfProductoPrecioVenta(FormatosNumeros.redondedoDecimal(objpreciosProducto.getfPrecioVenta()));
											           producto.setfProductoGanancia(objpreciosProducto.getfGanancia());     		      		
											           producto.setfProductoPrecioCompra(FormatosNumeros.redondedoDecimal(precioProducto));
											           break;
							      				 }
							      			}
								           ingresogenericaDao.mergeEndidad(producto); 
						      			 
								           /***Agregamos las actualizaciones en la lista ventadetalles****/  
								           ingresodetalles.add(ingresoDetalle);
								           
								         
							      	
								           /***Agregamos al Kardex el movimiento de los productos***/
								            Kardex  kardex = new Kardex();
											kardex.setProducto(producto);
											kardex.setIngresoProducto(obj);
											kardex.setdFecha(Fechas.getDate());
											kardex.setvConcepto(Constantes.conceptoCompra+ingresogenericaDao.findEndidad(pForm.getTipodocumentogestion(), pForm.getiTipoDocumentoId()).getvTipoDocumentoDescripcion()+Constantes.nro+obj.getnIngresoProductoNumero());
											kardex.setiCantIngresoProducto(ingresoDetalle.getiIngresoProductoDetalleCantidad());
											kardex.setfPuIngresoProducto(ingresoDetalle.getfIngresoProductoDetallePrecio());
											kardex.setfTotalngresoProducto(ingresoDetalle.getfIngresoProductoDetalleTotal());
											
											kardex.setiCantExistencia(ingresoDetalle.getiIngresoProductoDetalleCantidad());
											kardex.setfPuExistencia(ingresoDetalle.getfIngresoProductoDetallePrecio());
											kardex.setfTotalExistencia(ingresoDetalle.getfIngresoProductoDetalleTotal());
											
											kardex.setiUsuarioInsertaId(usu.getiUsuarioId());
											kardex.setdFechaInserta(Fechas.getDate());
											kardex.setiPeriodoId(iPeriodoId);
											/***Agregamos en la lista kardex****/  
											listaKardex.add(kardex);
										    obj.setIngresoproductodetalles(ingresodetalles);
							      	
								  }// fin de nuevo producto
							  else{
								  /***Actualizamos la cantidad del producto en stock, el precio de compra y de venta*****/
								  if(ingresoDetalle.getcEstadoCodigo().equals(Constantes.estadoActivo)){
									   
									  if(ingresoDetalle.getiIngresoProductoDetalleCantidad()!=obj.getIngresoproductodetalles().get(i).getiIngresoProductoDetalleCantidad()||
											  ingresoDetalle.getfIngresoProductoDetallePrecio()!=obj.getIngresoproductodetalles().get(i).getfIngresoProductoDetallePrecio()){
										  
										   cantidadProductoActual =   ingresoDetalle.getiIngresoProductoDetalleCantidad() -  obj.getIngresoproductodetalles().get(i).getiIngresoProductoDetalleCantidad();
				      					   
										    /******************************************/
											/**Insertamos detalle de lista de precios**/
											/******************************************/
							      			  int iAsignado =0;
							      			  for(Preciosproducto preciosProducto:producto.getPreciosproductodetallles()){
									      		  if(preciosProducto.getfPrecioCompra()==ingresoDetalle.getfIngresoProductoDetallePrecio()) {
									      			            cantidadProducto =    preciosProducto.getiCantidadStock() + cantidadProductoActual;
									      		      			preciosProducto.setiCantidadStock(cantidadProducto);
									      		      		    preciosProducto.setfPrecioVenta(FormatosNumeros.redondedoDecimal(ingresoDetalle.getProducto().getfProductoPrecioVenta()));
							      			                    preciosProducto.setfGanancia(ingresoDetalle.getProducto().getfProductoGanancia());
							      			               
									      		      			iAsignado=1;
									      		      			break;		      		  
									      		  }			      		  
									      	  }
							      			  if(iAsignado==0){	      				
								      			                Preciosproducto preciosProducto1 = new Preciosproducto();
								      			                preciosProducto1.setiCantidadStock(ingresoDetalle.getiIngresoProductoDetalleCantidad());
								      			                preciosProducto1.setfPrecioCompra(FormatosNumeros.redondedoDecimal(ingresoDetalle.getfIngresoProductoDetallePrecio()));
								      			                preciosProducto1.setfPrecioVenta(FormatosNumeros.redondedoDecimal(ingresoDetalle.getProducto().getfProductoPrecioVenta()));
								      			                preciosProducto1.setfGanancia(ingresoDetalle.getProducto().getfProductoGanancia());							      			               
								      			                preciosProducto1.setcEstadoCodigo(Constantes.estadoActivo);
								      			                preciosProducto1.setdFechaInserta(Fechas.getDate());
								      			                preciosProducto1.setProducto(producto);
									      			
									      	           producto.getPreciosproductodetallles().add(preciosProducto1);		      		 
									      		
							      			  }
									   /***********************************************************************************/
						      		   /***Actualizamos la cantidad del producto en stock, el precio de compra y venta*****/	 
						      		   /*** Segun metodologia FIFO- Primero en entrar, Primero en Salir                  **/
						      		   /***********************************************************************************/
						      			for(Preciosproducto objpreciosProducto:producto.getPreciosproductodetallles()){
						      				 if(objpreciosProducto.getiCantidadStock()>0  && objpreciosProducto.getcEstadoCodigo().equals(Constantes.estadoActivo)){					      					  
						      					   cantidadProducto =    producto.getiProductoStockCantidad() + cantidadProductoActual;
						      					   precioProducto = objpreciosProducto.getfPrecioCompra();
										           producto.setiProductoStockCantidad(cantidadProducto);
										           producto.setfProductoPrecioVenta(FormatosNumeros.redondedoDecimal(objpreciosProducto.getfPrecioVenta()));
										           producto.setfProductoGanancia(objpreciosProducto.getfGanancia());     		      		
										           producto.setfProductoPrecioCompra(FormatosNumeros.redondedoDecimal(precioProducto));
										           break;
						      				 }
						      			}
							            
									  } //IF precios y cantidades diferentes
								    }// If el producto esta en la lista de forma activa
								  else{
									    /******************************************/
										/**Insertamos detalle de lista de precios**/
										/******************************************/
						      			 for(Preciosproducto preciosProducto:producto.getPreciosproductodetallles()){
								      		  if(preciosProducto.getfPrecioCompra()==ingresoDetalle.getfIngresoProductoDetallePrecio()) {
								      			            cantidadProducto =    preciosProducto.getiCantidadStock() - ingresoDetalle.getiIngresoProductoDetalleCantidad();
								      		      			preciosProducto.setiCantidadStock(cantidadProducto);
								      		      		    preciosProducto.setfPrecioVenta(FormatosNumeros.redondedoDecimal(ingresoDetalle.getProducto().getfProductoPrecioVenta()));
						      			                    preciosProducto.setfGanancia(ingresoDetalle.getProducto().getfProductoGanancia());					      			               
								      		      			break;		      		  
								      		  }			      		  
								      	  }
									  /***********************************************************************************/
						      		   /***Actualizamos la cantidad del producto en stock, el precio de compra y venta*****/	 
						      		   /*** Segun metodologia FIFO- Primero en entrar, Primero en Salir                  **/
						      		   /***********************************************************************************/
						      			for(Preciosproducto objpreciosProducto:producto.getPreciosproductodetallles()){
						      				 if(objpreciosProducto.getiCantidadStock()>0  && objpreciosProducto.getcEstadoCodigo().equals(Constantes.estadoActivo)){					      					   
						      					   cantidadProducto =    producto.getiProductoStockCantidad() - ingresoDetalle.getiIngresoProductoDetalleCantidad();
						      					   precioProducto = objpreciosProducto.getfPrecioCompra();
										           producto.setiProductoStockCantidad(cantidadProducto);
										           producto.setfProductoPrecioVenta(FormatosNumeros.redondedoDecimal(objpreciosProducto.getfPrecioVenta()));
										           producto.setfProductoGanancia(objpreciosProducto.getfGanancia());     		      		
										           producto.setfProductoPrecioCompra(FormatosNumeros.redondedoDecimal(precioProducto));
										           break;
						      				 }
						      			} // else, en caso el producto aya sido retidado de la lista						          
								  }
								  
								  /** Actualizamos el producto ***/
								  ingresogenericaDao.mergeEndidad(producto);
						           
								
								  /***Actualizamos el detalle de la compra ***/
								  obj.getIngresoproductodetalles().get(i).setdFechaActualiza(Fechas.getDate());
								  obj.getIngresoproductodetalles().get(i).setiUsuarioActualizaId(0);
								  obj.getIngresoproductodetalles().get(i).setfIngresoProductoDetallePrecio(ingresoDetalle.getfIngresoProductoDetallePrecio());
								  obj.getIngresoproductodetalles().get(i).setfIngresoProductoDetalleTotal(ingresoDetalle.getfIngresoProductoDetalleTotal());
								  obj.getIngresoproductodetalles().get(i).setiIngresoProductoDetalleCantidad(ingresoDetalle.getiIngresoProductoDetalleCantidad());
								  obj.getIngresoproductodetalles().get(i).setProducto(ingresoDetalle.getProducto());
								  obj.getIngresoproductodetalles().get(i).setcEstadoCodigo(ingresoDetalle.getcEstadoCodigo());
								  
								  /**Actualizamos el Kardex**/
								  obj.getKardex().get(i).setdFechaActualiza(Fechas.getDate());
								  obj.getKardex().get(i).setiUsuarioActualizaId(usu.getiUsuarioId());
								  obj.getKardex().get(i).setiCantIngresoProducto(ingresoDetalle.getiIngresoProductoDetalleCantidad());
								  obj.getKardex().get(i).setfPuIngresoProducto(ingresoDetalle.getfIngresoProductoDetallePrecio());
								  obj.getKardex().get(i).setfTotalngresoProducto(ingresoDetalle.getfIngresoProductoDetalleTotal());
								  obj.getKardex().get(i).setiCantExistencia(ingresoDetalle.getiIngresoProductoDetalleCantidad());
								  obj.getKardex().get(i).setfPuExistencia(obj.getKardex().get(i).getfPuExistencia());
								  obj.getKardex().get(i).setfTotalExistencia(obj.getKardex().get(i).getiCantExistencia()*obj.getKardex().get(i).getfPuExistencia());
									
								  
								 
								//  obj.getKardex().get(i).setcEstadoCodigo(ingresoDetalle.getcEstadoCodigo());
								  
							  }/// else detalleProducto existe;
							  
						        i++;
						  } // for 
						  
					 
					  // obj.setVentadetalles(ventadetalles);
				  
	
				/**UE: Ingreso de estado de cuenta de proveedor**/
		      	   if(pForm.getMode().equals("UE")){
		       	       obj.setfIngresoProductoIGV(0);		          	   
		         	   obj.setfIngresoProductoSubTotal(0);		          	   
		         	   obj.setvPrincipal(Constantes.vnPrincipal);
		            }
				
				/******************************************************/
				/** Actualizamos la entidad IngresoProducto           */
				/** Actualizamos los valores en la tabla libro diario */
				/******************************************************/
			
				ingresogenericaDao.persistEndidad(obj);	 
				int nNumeroLetra=1;
		        contabilidadDao.callCompraContabilidad(obj.getiIngresoProductoId(),fecha, pForm.getfMontoAdelantado(), usu.getiUsuarioId(), pForm.getiNumeroLetras(), pForm.getiNumeroDias(),pForm.getMode(),iPeriodoId,nNumeroLetra,obj.getFormaPago().getiFormaPago());
		        resultado = ingresogenericaDao.commitEndidad(transaccion);
	            ingresogenericaDao.refreshEndidad(obj);
	            
			      } // fin Actualizar 
			   
			else if (mode.equals("D")) {
	
				ingresogenericaDao.eliminarUnaEndidad(obj, "iIngresoProductoId",ids);/**/
				resultado = ingresogenericaDao.commitEndidad(transaccion);
	
			}
         } catch (Exception ex) {
        	 ex.printStackTrace();
        	 ingresogenericaDao.limpiarInstancia();
         } finally {
        	 transaccion = null;
         }
			
		if (resultado == true) {
			msn = "msnOk";

		} else {
			msn = "msnError";

		}
		/** llamamos a listar Ingresoproducto **/
		// listaIngresoproducto(mapping, pForm, request, response);

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
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 */
	
	public ActionForward iduIngresoproductoDevolucion(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ParseException, IllegalArgumentException, SecurityException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException  {

		/** Inicializamos las variables **/
		String msn = "";
		String mode = request.getParameter("mode");		
		boolean resultado = false;
		int cantidadProducto = 0;
		int cantidadProductoActual=0;
		float precioProducto =(float) 0.0;
		HttpSession sesion = request.getSession();
		

		/** Instanciamos las clase IngresoproductoForm y IngresogenericaDao **/
		IngresoProductoForm pForm = (IngresoProductoForm) form;
		IngresoProductoDao ingresogenericaDao = new IngresoProductoDao();		
		ContabilidadDao contabilidadDao = new ContabilidadDao();
		Usuario usu = (Usuario) sesion.getAttribute("Usuario");
		int iPeriodoId = (Integer) sesion.getAttribute("iPeriodoId");
		
		Ingresoproductodevolucion obj = pForm.getIngresoProductoDev();
		Ingresoproducto objIngresoProducto = new Ingresoproducto();
		List<Ingresoproductodevoluciondetalle> ingresoproductodevoluciondetalles = new ArrayList<Ingresoproductodevoluciondetalle>();
		List<Ingresoproductodevoluciondetalle> listaDetalle = new ArrayList<Ingresoproductodevoluciondetalle>();
		List<Kardex> listaKardex = new ArrayList<Kardex>();
		List<Ingresoproductodetalle> listaProductoDetalle=  new ArrayList<Ingresoproductodetalle>();
		
		/*** Informacion de la devolcuion de compra****/
		  obj.setdIngresoProductoDevFecha(Fechas.fechaDate(pForm.getdIngresoProductoDevFecha()));
		  EntityTransaction entityTransaction;
		  try {
			  entityTransaction= ingresogenericaDao.entityTransaction();
			  entityTransaction.begin();
			/** **/
			if (pForm.getMode().equals("I")) {
				obj.setdFechaInserta(Fechas.getDate());
		   	    obj.setiUsuarioInsertaId(usu.getiUsuarioId());
		   	    obj.setvEstadoCodigo(Constantes.estadoActivo);
		   	    obj.setiPeriodoId(iPeriodoId);
		   	    obj.setTipoDocumento(Util.listaDocGest().get(3));/* get(3)= 8: NOTA DE DEBITO **/
		   	    /****Informacion de detalle compra****/
	      	   if(sesion.getAttribute("listaIngresoProductoDetalle")!=null){
	      		    /**Actualizamos el estado de la Compra**/
	      		     listaProductoDetalle= (List<Ingresoproductodetalle>) sesion.getAttribute("listaIngresoProductoDetalle");
	    			 objIngresoProducto = ingresogenericaDao.findEndidad(listaProductoDetalle.get(0).getIngresoproducto(), listaProductoDetalle.get(0).getIngresoproducto().getiIngresoProductoId()) ;	      			
	    			 objIngresoProducto.setvEstadoDocumento(pForm.getvEstadoDocumento());
	    			
		      	   for(Ingresoproductodetalle ingresoDetalle:listaProductoDetalle){
		      		       
		      		 if(ingresoDetalle.getcEstadoCodigo().equals(Constantes.estadoActivo)){
		      			  
		      			 Ingresoproductodevoluciondetalle objDetalle= new Ingresoproductodevoluciondetalle();	      			 
		      			 
		      			 obj.setIngresoProducto(ingresoDetalle.getIngresoproducto());
		      			 
		      			objDetalle.setIngresoproductodevolucion(obj);
		      			objDetalle.setProducto(ingresoDetalle.getProducto());
		      		    objDetalle.setfIngresoProductoDevDetallePrecio(ingresoDetalle.getfIngresoProductoDetallePrecio());
		      			objDetalle.setiIngresoProductoDevDetalleCantidad(ingresoDetalle.getiIngresoProductoDetalleCantidad());
		      			objDetalle.setfIngresoProductoDevDetalleTotal(ingresoDetalle.getfIngresoProductoDetalleTotal());
		      			objDetalle.setdFechaInserta(Fechas.getDate());
		      			objDetalle.setcEstadoCodigo(ingresoDetalle.getcEstadoCodigo());
		      			
		      			 ingresoproductodevoluciondetalles.add(objDetalle);
		      			
		      			  /***************************/
						  /** Obtenemos el producto */
						  /**************************/
						  Producto producto = ingresogenericaDao.findEndidad(ingresoDetalle.getProducto(), ingresoDetalle.getProducto().getiProductoId());
											    
						    /******************************************/
							/**Insertamos detalle de lista de precios**/
							/******************************************/		      			
			      			  for(Preciosproducto preciosProducto:producto.getPreciosproductodetallles()){
					      		  if(preciosProducto.getfPrecioCompra()==ingresoDetalle.getfIngresoProductoDetallePrecio()) {
					      			            cantidadProducto =    preciosProducto.getiCantidadStock()- ingresoDetalle.getiIngresoProductoDetalleCantidad();
					      		      			preciosProducto.setiCantidadStock(cantidadProducto);
					      		      		    preciosProducto.setfPrecioVenta(FormatosNumeros.redondedoDecimal(ingresoDetalle.getProducto().getfProductoPrecioVenta()));
			      			                    preciosProducto.setfGanancia(ingresoDetalle.getProducto().getfProductoGanancia());		      			               
					      		      			break;		      		  
					      		  }			      		  
					      	  }
			      			 
						   /***********************************************************************************/
			      		   /***Actualizamos la cantidad del producto en stock, el precio de compra y venta*****/	 
			      		   /*** Segun metodologia FIFO- Primero en entrar, Primero en Salir                  **/
			      		   /***********************************************************************************/
			      			for(Preciosproducto objpreciosProducto:producto.getPreciosproductodetallles()){
			      				 if(objpreciosProducto.getiCantidadStock()>0  && objpreciosProducto.getcEstadoCodigo().equals(Constantes.estadoActivo)){					      					  
			      					   cantidadProducto =    producto.getiProductoStockCantidad() - ingresoDetalle.getiIngresoProductoDetalleCantidad();
			      					   precioProducto = objpreciosProducto.getfPrecioCompra();
							           producto.setiProductoStockCantidad(cantidadProducto);
							           producto.setfProductoPrecioVenta(FormatosNumeros.redondedoDecimal(objpreciosProducto.getfPrecioVenta()));
							           producto.setfProductoGanancia(objpreciosProducto.getfGanancia());     		      		
							           producto.setfProductoPrecioCompra(FormatosNumeros.redondedoDecimal(precioProducto));
							           break;
			      				 }
			      			}
			      			ingresogenericaDao.mergeEndidad(producto);	
				           
				           /***Agregamos al Kardex el movimiento de los productos***/
				            Kardex  kardex = new Kardex();
							kardex.setProducto(producto);
							kardex.setIngresoProducto(objIngresoProducto);
							kardex.setdFecha(Fechas.getDate());
							kardex.setvConcepto(Constantes.conceptoDevCompra+objIngresoProducto.getTipodocumento().getvTipoDocumentoDescripcion()+Constantes.nro+objIngresoProducto.getnIngresoProductoNumero());
							kardex.setiCantIngresoProducto(ingresoDetalle.getiIngresoProductoDetalleCantidad());
							kardex.setfPuIngresoProducto(ingresoDetalle.getfIngresoProductoDetallePrecio());
							kardex.setfTotalngresoProducto(ingresoDetalle.getfIngresoProductoDetalleTotal());						
							kardex.setiCantExistencia(ingresoDetalle.getiIngresoProductoDetalleCantidad());
							kardex.setfPuExistencia(ingresoDetalle.getfIngresoProductoDetallePrecio());
							kardex.setfTotalExistencia(ingresoDetalle.getfIngresoProductoDetalleTotal());						
							kardex.setiUsuarioInsertaId(usu.getiUsuarioId());
							kardex.setdFechaInserta(Fechas.getDate());
							kardex.setiPeriodoId(iPeriodoId);
							/***Agregamos en la lista kardex****/  
							listaKardex.add(kardex);
		      			 
							
			      		   }
			      	      objIngresoProducto.setKardex(listaKardex);
			      	      obj.setIngresoproductodevoluciondetalles(ingresoproductodevoluciondetalles);
			      		 }
		      	   
		      	   
			      	    ingresogenericaDao.mergeEndidad(objIngresoProducto);
			      	    ingresogenericaDao.persistEndidad(obj);		      	   
			      	    resultado=ingresogenericaDao.commitEndidad(entityTransaction);
			        	if(resultado==true){
			        		 int iIngresoProductoDevolucionId=obj.getiIngresoProductoDevolucionId();
				        	 ingresogenericaDao.entityTransaction().begin();
				        	 contabilidadDao.callDevCompraContabilidad(iIngresoProductoDevolucionId, usu.getiUsuarioId(), mode,obj.getnNroNotaDebito(), iPeriodoId);
				        	 resultado = ingresogenericaDao.commitEndidad(ingresogenericaDao.entityTransaction());
				         }
			        	//ingresogenericaDao.refreshEndidad(obj);
			        	
			      }// if insercion de la lista detalle activa
	      	   }
			if(pForm.getMode().equals("U")) {
				obj.setdFechaActualiza(Fechas.getDate());
		   	    obj.setiUsuarioActualizaId(usu.getiUsuarioId());
		   	    obj.setvEstadoCodigo(Constantes.estadoActivo);
		   	  
	      	   /****Informacion de detalle compra****/
		   	 listaDetalle = (List<Ingresoproductodevoluciondetalle>) sesion.getAttribute("listaIngresoProductoDetalleOriginal");
		   	 listaProductoDetalle =(List<Ingresoproductodetalle>) sesion.getAttribute("listaIngresoProductoDetalle");
		   	 int i=0;
				   if(sesion.getAttribute("listaIngresoProductoDetalle")!=null){
					     objIngresoProducto = ingresogenericaDao.findEndidad(listaProductoDetalle.get(0).getIngresoproducto(),listaProductoDetalle.get(0).getIngresoproducto().getiIngresoProductoId()) ;	      			
		    			 objIngresoProducto.setvEstadoDocumento(pForm.getvEstadoDocumento());
		    			 
			      	   for(Ingresoproductodetalle ingresoDetalle: listaProductoDetalle){
			      		      
			      		      /***************************/
							  /** Obtenemos el producto */
							  /**************************/
							  Producto producto = ingresogenericaDao.findEndidad(ingresoDetalle.getProducto(), ingresoDetalle.getProducto().getiProductoId());
							
			      		   
			      		 /***Actualizamos la cantidad del producto en stock, el precio de compra y venta*****/
				    	     
			      			 for(Ingresoproductodevoluciondetalle ingresoDetalles:listaDetalle){ //ingresoDetalle.getcEstadoCodigo().equals(Constantes.estadoActivo) && 
			      				 if(ingresoDetalle.getProducto().getcProductoCodigo().equals(ingresoDetalles.getProducto().getcProductoCodigo())){
			      					 
			      				   cantidadProductoActual =    ingresoDetalles.getiIngresoProductoDevDetalleCantidad() - ingresoDetalle.getiIngresoProductoDetalleCantidad(); 
			  	      			   
			  	      			     /******************************************/
									/**Insertamos detalle de lista de precios**/
									/******************************************/		      			
					      			  for(Preciosproducto preciosProducto:producto.getPreciosproductodetallles()){
							      		  if(preciosProducto.getfPrecioCompra()==ingresoDetalle.getfIngresoProductoDetallePrecio()) {
							      			            cantidadProducto =    preciosProducto.getiCantidadStock() + ingresoDetalle.getiIngresoProductoDetalleCantidad();						      			           
							      		      			preciosProducto.setiCantidadStock(cantidadProducto);
							      		      		    preciosProducto.setfPrecioVenta(FormatosNumeros.redondedoDecimal(ingresoDetalle.getProducto().getfProductoPrecioVenta()));
					      			                    preciosProducto.setfGanancia(ingresoDetalle.getProducto().getfProductoGanancia());		      			               
							      		      			break;		      		  
							      		  }			      		  
							      	  }
					      			 
								   /***********************************************************************************/
					      		   /***Actualizamos la cantidad del producto en stock, el precio de compra y venta*****/	 
					      		   /*** Segun metodologia FIFO- Primero en entrar, Primero en Salir                  **/
					      		   /***********************************************************************************/
					      			for(Preciosproducto objpreciosProducto:producto.getPreciosproductodetallles()){
					      				 if(objpreciosProducto.getiCantidadStock()>0 && objpreciosProducto.getcEstadoCodigo().equals(Constantes.estadoActivo)){					      					  
					      					   cantidadProducto =    producto.getiProductoStockCantidad() + ingresoDetalle.getiIngresoProductoDetalleCantidad();
					      					   precioProducto = objpreciosProducto.getfPrecioCompra();
									           producto.setiProductoStockCantidad(cantidadProducto);
									           producto.setfProductoPrecioVenta(FormatosNumeros.redondedoDecimal(objpreciosProducto.getfPrecioVenta()));
									           producto.setfProductoGanancia(objpreciosProducto.getfGanancia());     		      		
									           producto.setfProductoPrecioCompra(FormatosNumeros.redondedoDecimal(precioProducto));
									           break;
					      				 }
					      			} 
			  			           
			  	      			 break;
			      				 }// if
			      			 }// for
			      			/****/
			      		   /**Actualizamos el estado de la Compra**/
			      			 Ingresoproductodevoluciondetalle objDetalle= new Ingresoproductodevoluciondetalle();	      			 
			      			 obj.setIngresoProducto(ingresoDetalle.getIngresoproducto());
			      			 
			      			objDetalle.setiIngresoProductoDevolucionDetalleId(ingresoDetalle.getiIngresoProductoDetalleId());
			      			objDetalle.setIngresoproductodevolucion(obj);
			      			objDetalle.setProducto(ingresoDetalle.getProducto());
			      		    objDetalle.setfIngresoProductoDevDetallePrecio(ingresoDetalle.getfIngresoProductoDetallePrecio());
			      			objDetalle.setiIngresoProductoDevDetalleCantidad(ingresoDetalle.getiIngresoProductoDetalleCantidad());
			      			objDetalle.setfIngresoProductoDevDetalleTotal(ingresoDetalle.getfIngresoProductoDetalleTotal());
			      			objDetalle.setdFechaInserta(Fechas.getDate());
			      			objDetalle.setcEstadoCodigo(ingresoDetalle.getcEstadoCodigo());		      			
			      			ingresoproductodevoluciondetalles.add(objDetalle);	
			      			 
			      			  /**Actualizamos el Kardex**/
			      			objIngresoProducto.getKardex().get(i).setdFechaActualiza(Fechas.getDate());
			      			objIngresoProducto.getKardex().get(i).setiUsuarioActualizaId(usu.getiUsuarioId());
			      			objIngresoProducto.getKardex().get(i).setiCantIngresoProducto(ingresoDetalle.getiIngresoProductoDetalleCantidad());
			      			objIngresoProducto.getKardex().get(i).setfPuIngresoProducto(ingresoDetalle.getfIngresoProductoDetallePrecio());
			      			objIngresoProducto.getKardex().get(i).setfTotalngresoProducto(ingresoDetalle.getfIngresoProductoDetalleTotal());
			      			objIngresoProducto.getKardex().get(i).setiCantExistencia(producto.getiProductoStockCantidad());
			      			objIngresoProducto.getKardex().get(i).setfPuExistencia(producto.getfProductoPrecioCompra());
			      			objIngresoProducto.getKardex().get(i).setfTotalExistencia(objIngresoProducto.getKardex().get(i).getiCantExistencia()*objIngresoProducto.getKardex().get(i).getfPuExistencia());
								
			      	      }
			      	 obj.setIngresoproductodevoluciondetalles(ingresoproductodevoluciondetalles);
		      		 }
	    	   
	    	    ingresogenericaDao.mergeEndidad(objIngresoProducto);
	        	ingresogenericaDao.persistEndidad(obj);        	
	        	resultado=ingresogenericaDao.commitEndidad(entityTransaction);   
	        	/*if(resultado==true){
	        		int iIngresoProductoDevolucionId=obj.getiIngresoProductoDevolucionId();
		        	 ingresogenericaDao.entityTransaction().begin();
		        	 contabilidadDao.callDevCompraContabilidad(iIngresoProductoDevolucionId, usu.getiUsuarioId(), mode, iPeriodoId);
		        	 resultado = ingresogenericaDao.commitEndidad(ingresogenericaDao.entityTransaction());
		         }
			      	  
			      	*/
			}
			
		  } catch (Exception ex) {
			  ex.printStackTrace();
			  ingresogenericaDao.limpiarInstancia();
		  } finally {
			  entityTransaction = null;
		  }
			
		if (resultado == true) {
			msn = "msnOk";

		} else {
			msn = "msnError";

		}
		return mapping.findForward(msn);
	 }
	

	@Override
	public Map<String, Object> cargarContenidoExportar(ActionForm form, HttpServletRequest request, String plantilla) throws ParseException {
		
		IngresoProductoForm objform = (IngresoProductoForm) form;
		IngresoProductoDao ingresogenericaDao = new IngresoProductoDao();
		Map<String, Object> beans = new HashMap<String, Object>();
		
		if ("compra".equals(plantilla)) {
			List<Ingresoproducto> listaIngresoproducto = ingresogenericaDao.listaIngresoproducto(0,1000,objform.getIngresoProducto());
			beans.put("compras", listaIngresoproducto);
		
		} else if ("compra-devolucion".equals(plantilla)) {
			List<Ingresoproductodevolucion> listaIngresoproducto = ingresogenericaDao.listaIngresoproductoDevolucion(0,1000, objform.getIngresoProducto());
			beans.put("devolucionCompras", listaIngresoproducto);
		}
		
		return beans;
	}
	@Override
	public void cargarContenidoImprimir (ActionForm form, HttpServletRequest request, Impresora impresora) throws IllegalAccessException, IOException {
		
		IngresoProductoDao ingresoProDao = new IngresoProductoDao();
		int id = Integer.parseInt(request.getParameter("id"));
		Ingresoproducto ingreso=ingresoProDao.findEndidadBD(new Ingresoproducto(), "iIngresoProductoId", id);
		
		impresora.agregarLinea("Ticket    :" + ingreso.getnIngresoProductoNumero());             
		impresora.agregarLinea("Fecha     :" + ingreso.getdFechaInserta());
		impresora.agregarLinea("Ven   : " + ingreso.getUsuario().getPersonal().getvPersonalNombres());
		impresora.agregarSeparacion();
    
		impresora.agregarLinea("Sr(a)     :" + ingreso.getProveedor().getvProveedorRazonSocial());
		impresora.agregarLinea(ingreso.getTipodocumento().getvTipoDocumentoDescripcion()+"     :" + ingreso.getProveedor().getnProveedorNumeroDocumento());
		
		impresora.agregarSeparacion();
        impresora.agregarLinea("Cant     " + "Descripcion" + "             " + "P.U        ");
        impresora.agregarSeparacion();
        
               
        // aqui recorro mis productos y los imprimo
        for(Ingresoproductodetalle detalle: ingreso.getIngresoproductodetalles()){
        	impresora.agregarLinea(detalle.getiIngresoProductoDetalleCantidad()+"  "+detalle.getProducto().getvProductoNombre()+"  "+detalle.getfIngresoProductoDetallePrecio());
        }
        
        impresora.agregarSeparacion();
        //Descuentos
        impresora.agregarLinea("TOTAL        : "+ingreso.getvTipoCompra()+" " + ingreso.getfIngresoProductoTotalReal());
        impresora.agregarLinea("DESCUENTO    : "+ingreso.getvTipoCompra()+" " + ingreso.getfDescuento());
        impresora.agregarSeparacion();
        impresora.agregarLinea("SUBTOTAL     : "+ingreso.getvTipoCompra()+" " + ingreso.getfIngresoProductoSubTotal());
        impresora.agregarLinea("IGV          : "+ingreso.getvTipoCompra()+" " + ingreso.getfIngresoProductoIGV());
        impresora.agregarLinea("TOTAL FINAL  : "+ingreso.getvTipoCompra()+" " + ingreso.getfIngresoProductoTotal());
        impresora.agregarSaltoLinea(1);
    
		
	}
	
}
