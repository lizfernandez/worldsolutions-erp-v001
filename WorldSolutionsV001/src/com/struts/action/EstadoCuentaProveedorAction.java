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
import com.dao.EstadoCuentaProveedorDao;
import com.dao.EstadoDao;
import com.dao.GenericaDao;
import com.dao.IngresoProductoDao;
import com.entities.Estado;
import com.entities.Estadocuentaproveedor;
import com.entities.Formapago;
import com.entities.Ingresoproducto;
import com.entities.Letraproveedor;
import com.entities.Tipodocumentogestion;
import com.entities.Usuario;
import com.entities.vo.EstadoCuentaVo;
import com.struts.form.EstadoCuentaProveedorForm;
import com.util.Constantes;
import com.util.Fechas;
import com.util.FormatosNumeros;
import com.util.Impresora;
import com.util.Paginacion;
import com.util.Util;

public class EstadoCuentaProveedorAction extends BaseAction {
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
		public ActionForward listaEstadoCuentaProveedor(ActionMapping mapping, ActionForm form,
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
		
			IngresoProductoDao ingresoproductoDao = new IngresoProductoDao();
			
		
			/** Instanciamos la Clase VentaForm **/
			EstadoCuentaProveedorForm objform = (EstadoCuentaProveedorForm) form;
	    //	IngresoProductoForm ingreso = (IngresoProductoForm) form;
			List<Ingresoproducto> listaIngresoproductoTotal = new ArrayList<Ingresoproducto>();
			List<Long> paginas = new ArrayList<Long>();
		
			 
		
		  	List<EstadoCuentaVo> listaEstadoCuenta = listaEstadoCuentaPorProveedor(objform.getIngresoproducto(), ingresoproductoDao, Paginacion.pagInicio(pagInicio), Paginacion.pagFin());
				/**Consultamos el total de registros segun criterio**/
				listaIngresoproductoTotal = ingresoproductoDao.listaEstadoCuentaPorProveedor(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getIngresoProducto(),0);
				
		        /**Obtenemos el total del paginas***/
				paginas = Paginacion.listPaginas((long)(listaIngresoproductoTotal.size()));
		 	     objform.setLista(listaEstadoCuenta);
				objform.setPaginas(paginas);
				objform.setPagInicio(pagina);
				 
				/***Redirecionamos  al ***/
				 msn ="showList";
				
					
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
		public ActionForward mantenimientoEstadoCuentaProveedor(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) {

			

			HttpSession sesion = request.getSession();			
			String mode = request.getParameter("mode");
			String msn="";
			
			
			/** Instantacia al EstadocuentaproveedorForm **/			
			EstadoCuentaProveedorForm estadoCuentaProveedorform = (EstadoCuentaProveedorForm) form;
			
			/** Instantacia a la capa Dao **/
			EstadoDao estadoDao = new EstadoDao();			 
			EstadoCuentaProveedorDao estadoCuentaProveedorDao = new EstadoCuentaProveedorDao();

			/** llamado de los metodos de la clase dao **/

			List<Estado> listaEstado = estadoDao.listEstado();
			
			estadoCuentaProveedorform.setMontoTotal(Float.parseFloat(request.getParameter("montoTotal")));
			estadoCuentaProveedorform.setPagoTotal(Float.parseFloat(request.getParameter("pagoTotal")));
				
			/**LLamamos al formulario mantenimientoEstadocuentaproveedor.jsp para la insercion de datos **/
			if(mode.equals("I")){
				estadoCuentaProveedorform.setiIngresoProductoId(Integer.parseInt(request.getParameter("iIngresoProductoId")));
				estadoCuentaProveedorform.setiProveedorId(Integer.parseInt(request.getParameter("iProveedorId")));				
				msn ="showEdit";
			}
			
			/**LLamamos al formulario mantenimientoEstadocuentaproveedor.jsp para mostrar los datos del UPDATE **/
			/** Seteamos el estadoCuentaProveedorform la clase Estadocuentaproveedor **/
			else if(mode.equals("U") || mode.equals("D")){
				
				int id = Integer.parseInt(request.getParameter("id"));
				estadoCuentaProveedorform.setEstadoCuentaProveedor(estadoCuentaProveedorDao.buscarEstadocuentaproveedor(id));
				
				msn ="showEdit";
				
			}
			/**LLamamos al formulario buscarMantenimientoPerfil.jsp para realizar la busqueda **/
			else if(mode.equals("F")){
				msn ="showFindEstadoCuentaProv";
				
			}
			
			estadoCuentaProveedorform.setMode(mode);

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
		public ActionForward iduEstadoCuentaProveedor(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IllegalArgumentException, SecurityException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
			
			/** Inicializamos las variables **/ 
			String msn = "";
			String mode = request.getParameter("mode");		
			String ids = request.getParameter("ids");		
			boolean resultado = false;
			HttpSession sesion = request.getSession();
			Usuario usu = (Usuario) sesion.getAttribute("Usuario");
			/** Instanciamos las clase EstadocuentaproveedorForm y EstadocuentaproveedorDao **/
			EstadoCuentaProveedorForm pForm = (EstadoCuentaProveedorForm) form;
			GenericaDao estadoCuentaProveedorDao = new GenericaDao();
			IngresoProductoDao ingresoProductoDao= new IngresoProductoDao();
			
			Estadocuentaproveedor obj = new Estadocuentaproveedor();
			
			
	        /**Instanciamos una transacion**/
			EntityTransaction transaction = null;
			try {
				transaction = ingresoProductoDao.entityTransaction();
				transaction.begin();
				if (pForm.getMode().equals("I")) {
					obj = pForm.getEstadoCuentaProveedor();
					obj.setdFechaInserta(Fechas.getDate());
					obj.setiUsuarioInsertaId(usu.getiUsuarioId());
					obj.setcEstadoCodigo(Constantes.estadoActivo);
					
					/** llamamos a listar Estadocuentaproveedor **/
					//listaEstadocuentaproveedor(mapping, pForm, request, response);
					/**Actualizamos el estado a Cancelado En la tabla Ingreso Producto**/
					if((double) pForm.getfMontoPago()>(pForm.getMontoTotal())||
					   (double) pForm.getfMontoPago()>((pForm.getMontoTotal())-(pForm.getPagoTotal()))||
					   FormatosNumeros.FormatoDecimalMonedaSum((double) pForm.getfMontoPago(), (double) (pForm.getPagoTotal())).equals(FormatosNumeros.FormatoDecimalMoneda((double) (pForm.getMontoTotal())))){
						
						obj.setfMontoPago((float) ((pForm.getMontoTotal())-(pForm.getPagoTotal())));
						
						estadoCuentaProveedorDao.persistEndidad(obj);
						Ingresoproducto ingresoproducto = ingresoProductoDao.findEndidad(obj.getIngresoproducto(), obj.getIngresoproducto().getiIngresoProductoId());
						ingresoproducto.setvEstadoDocumento(Constantes.estadoDocumentoCancelado);
						ingresoProductoDao.mergeEndidad(ingresoproducto);
					}
					
					else{
						estadoCuentaProveedorDao.persistEndidad(obj);
					}
					/** realizamos el commit del objeto estadocuenta proveedor**/
					resultado = estadoCuentaProveedorDao.commitEndidad(transaction);
					ingresoProductoDao.refreshEndidad(obj);
					
				}// fin mode I;
				else if (pForm.getMode().equals("U")) {
				   obj = estadoCuentaProveedorDao.findEndidad(pForm.getEstadoCuentaProveedor(), pForm.getEstadoCuentaProveedor().getiEstadoCuentaProveedor());
				   obj.setdFechaPago(pForm.getEstadoCuentaProveedor().getdFechaPago());
				   obj.setsVendedor(pForm.getsVendedor());
				   
				  
				   	/**Actualizamos el estado a Cancelado En la tabla Ingreso Producto**/
				   
				   double saldo = (pForm.getPagoTotal()) - (double) obj.getfMontoPago();
				
				    if((saldo+(double) pForm.getfMontoPago())>=(pForm.getMontoTotal())){
						
					   obj.setfMontoPago((float) ((pForm.getMontoTotal()) - saldo));
						
						estadoCuentaProveedorDao.mergeEndidad(obj);
						Ingresoproducto ingresoproducto = obj.getIngresoproducto();
						ingresoproducto.setvEstadoDocumento(Constantes.estadoDocumentoCancelado);
						ingresoProductoDao.mergeEndidad(ingresoproducto);
					}
				    else{
				    	obj.setfMontoPago(pForm.getfMontoPago());
						 estadoCuentaProveedorDao.mergeEndidad(obj);
						
						Ingresoproducto ingresoproducto = obj.getIngresoproducto();
						ingresoproducto.setvEstadoDocumento(Constantes.estadoDocumentoDeuda);
						ingresoProductoDao.mergeEndidad(ingresoproducto);
				    }
				    resultado = ingresoProductoDao.commitEndidad(transaction);
				    ingresoProductoDao.refreshEndidad(obj);
					
				}
				else if (mode.equals("D")) { 
					    obj = estadoCuentaProveedorDao.findEndidad(obj, Integer.parseInt(ids));
						estadoCuentaProveedorDao.eliminarUnaEndidad(obj, "iEstadoCuentaProveedor",ids);
						
						Ingresoproducto ingresoproducto = obj.getIngresoproducto();
						ingresoproducto.setvEstadoDocumento(Constantes.estadoDocumentoDeuda);
						ingresoProductoDao.mergeEndidad(ingresoproducto);
						resultado = ingresoProductoDao.commitEndidad(transaction);
						/**/
					
					}
			
			} catch (Exception ex) {
				ex.printStackTrace();
				ingresoProductoDao.limpiarInstancia();
			} finally {
				transaction = null;
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
		public ActionForward listaLetrasProveedor(ActionMapping mapping, ActionForm form,
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
		
			IngresoProductoDao ingresoproductoDao = new IngresoProductoDao();
			
		
			/** Instanciamos la Clase VentaForm **/
			EstadoCuentaProveedorForm objform = (EstadoCuentaProveedorForm) form;
	 
	    	List<Letraproveedor> listaLetraProveedor = new ArrayList<Letraproveedor>();
			List<Letraproveedor> listaLetraTotal = new ArrayList<Letraproveedor>();
			List<Long> paginas = new ArrayList<Long>();
		
			
			listaLetraProveedor = ingresoproductoDao.listaLetraProveedor(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getLetraProveedor());
					    
				/**Consultamos el total de registros segun criterio**/
			listaLetraTotal = ingresoproductoDao.listaLetraProveedor(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getLetraProveedor());
				
		        /**Obtenemos el total del paginas***/
				paginas = Paginacion.listPaginas((long)(listaLetraTotal.size()));
		 	     objform.setLista(listaLetraProveedor);
				objform.setPaginas(paginas);
				objform.setPagInicio(pagina);
				 
				/***Redirecionamos  al ***/
				 msn ="showListLetraProveedor";
				
					
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
		public ActionForward mantenimientoLetraProveedor(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws ParseException {

			

			HttpSession sesion = request.getSession();			
			String mode = request.getParameter("mode");
			String msn="";
			
			
			/** Instantacia al EstadocuentaproveedorForm **/			
			EstadoCuentaProveedorForm estadoCuentaProveedorform = (EstadoCuentaProveedorForm) form;
			
			/** Instantacia a la capa Dao **/
			EstadoDao estadoDao = new EstadoDao();			 
			EstadoCuentaProveedorDao estadoCuentaProveedorDao = new EstadoCuentaProveedorDao();
			List<Formapago> listaFormapago = estadoCuentaProveedorDao.listaEntidadGenericaSinCodigo("Formapago");
		    List<Tipodocumentogestion> listaTipoDoc = estadoCuentaProveedorDao.listaEntidadGenericaSinCodigo("Tipodocumentogestion");
		   
			/** llamado de los metodos de la clase dao **/

			List<Estado> listaEstado = estadoDao.listEstado();
				
			/**LLamamos al formulario mantenimientoEstadocuentaproveedor.jsp para la insercion de datos **/
			if(mode.equals("I")){
					msn ="showEditLetraProveedor";
			}
			
			/**LLamamos al formulario mantenimientoEstadocuentaproveedor.jsp para mostrar los datos del UPDATE **/
			/** Seteamos el estadoCuentaProveedorform la clase Estadocuentaproveedor **/
			else if(mode.equals("U") || mode.equals("D")){
				
				int id = Integer.parseInt(request.getParameter("id"));
				Letraproveedor letraProveedor=estadoCuentaProveedorDao.findEndidad(estadoCuentaProveedorform.getLetraProveedor(), id);
				estadoCuentaProveedorform.setLetraProveedor(letraProveedor);
				estadoCuentaProveedorform.setdFechaPagoLetra(Fechas.fechaDDMMYY(letraProveedor.getdFechaPago()));
				msn ="showEditLetraProveedor";
				
			}
			/**LLamamos al formulario buscarMantenimientoPerfil.jsp para realizar la busqueda **/
			else if(mode.equals("F")){
				msn ="showFindLetraProveedor";
				
			}
			
			estadoCuentaProveedorform.setMode(mode);

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
		public ActionForward iduLetraProveedor(ActionMapping mapping, ActionForm form,
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
			EstadoCuentaProveedorForm pForm = (EstadoCuentaProveedorForm) form;
		   ContabilidadDao contabilidadDao = new ContabilidadDao();
			IngresoProductoDao ingresoProductoDao= new IngresoProductoDao();
			
			Letraproveedor obj = pForm.getLetraProveedor();
			//obj.setIngresoProducto(pForm.getIngresoProducto());
			
	        /**Instanciamos una transacion**/
			EntityTransaction transaccion = null;
			
			try {
				transaccion= ingresoProductoDao.entityTransaction();
				transaccion.begin();
							
				if (pForm.getMode().equals("I") || pForm.getMode().equals("U")) {
					 Date fecha = Fechas.getDate();	
			            fecha =obj.getIngresoProducto().getFormaPago().getiFormaPago()==3?Fechas.fechaDate("30/"+(Fechas.mesFecha(fecha)+1)+"/"+Fechas.anioFecha(fecha)):obj.getdFechaVencimiento();
			         obj.setdFechaVencimiento(fecha);
			         obj.setiUsuarioInsertaId(usu.getiUsuarioId());
			         obj.setDfechaInserta(Fechas.getDate());
			         if(pForm.getdFechaPagoLetra()!=""){
			        	 obj.setdFechaPago(Fechas.fechaDate(pForm.getdFechaPagoLetra()));
			         }
			         
			         if(pForm.getMode().equals("I")){
			        	 int iFormaPagoId= obj.getIngresoProducto().getFormaPago().getiFormaPago();
						 contabilidadDao.callCompraContabilidad(obj.getIngresoProducto().getiIngresoProductoId(),fecha, pForm.getfMontoAdelantado(), usu.getiUsuarioId(), pForm.getiNumeroLetras(), pForm.getnPlazoLetra(),pForm.getMode(),iPeriodoId, obj.getnNumeroLetra(), iFormaPagoId);
			        	 resultado = ingresoProductoDao.commitEndidad(transaccion);		         
						 Ingresoproducto ingresoProducto =  ingresoProductoDao.findEndidad(obj.getIngresoProducto(), obj.getIngresoProducto().getiIngresoProductoId());
					
						 ingresoProducto.setFormaPago(obj.getIngresoProducto().getFormaPago());
						 ingresoProductoDao.mergeEndidad(ingresoProducto);
			        	 resultado = ingresoProductoDao.commitEndidad(transaccion);
						 ingresoProductoDao.refreshEndidad(ingresoProducto);
					
				}// fin mode I;
				else if (pForm.getMode().equals("U")) {
					    obj = ingresoProductoDao.findEndidad(pForm.getLetraProveedor(), pForm.getLetraProveedor().getIletraProveedorId());
					    obj.setiUsuarioActualizaId(usu.getiUsuarioId());
					    obj.setdFechaActualiza(Fechas.getDate());
					   if(pForm.getdFechaPagoLetra()!=""){
					       obj.setdFechaPago(Fechas.fechaDate(pForm.getdFechaPagoLetra()));
					    }
					   
					    if(pForm.getdFechaPagoLetra()!=""){
					     obj.setvEstadoLetra(Constantes.estadoDocumentoCancelado);				     
					    }
					    int cantLetrasPagadas=0;
					    List<Letraproveedor> listaLetra = new ArrayList<Letraproveedor>();
					    for(Letraproveedor letraPagada:obj.getIngresoProducto().getLetraproveedor()){
					    	if(letraPagada.getcEstadoCodigo().equalsIgnoreCase(Constantes.estadoActivo)){
					    		if(letraPagada.getvEstadoLetra().equals(Constantes.estadoDocumentoCancelado)){				    	
					    		cantLetrasPagadas++;				    		
					    		}
					    		listaLetra.add(letraPagada);
					    	}
					    }
					    if(cantLetrasPagadas==listaLetra.size()){
					    	Ingresoproducto ingresoproducto=obj.getIngresoProducto();
					    	ingresoproducto.setvEstadoDocumento(Constantes.estadoDocumentoCancelado);
					    	ingresoProductoDao.mergeEndidad(ingresoproducto);
					    }
					    obj= Util.comparar(obj, pForm.getLetraProveedor());
					    ingresoProductoDao.mergeEndidad(obj);
					    resultado = ingresoProductoDao.commitEndidad(transaccion);
					    ingresoProductoDao.refreshEndidad(obj);
					
				   }
				}
				else if (mode.equals("D")) { 
					    obj = ingresoProductoDao.findEndidad(obj, Integer.parseInt(ids));
					    ingresoProductoDao.eliminarUnaEndidad(obj, "iletraProveedorId",ids);
						
						Ingresoproducto ingresoproducto = obj.getIngresoProducto();
						ingresoproducto.setvEstadoDocumento(Constantes.estadoDocumentoDeuda);
						ingresoProductoDao.mergeEndidad(ingresoproducto);
						resultado = ingresoProductoDao.commitEndidad(transaccion);
						/**/
					
					}
								
			} catch (Exception ex) {
				ex.printStackTrace();
				ingresoProductoDao.limpiarInstancia();
			} finally {
				transaccion = null;
			}
				
			if (resultado == true) {
				msn = "msnOk";

			}
			else  {
				msn = "msnError";

			}
			return mapping.findForward(msn);
		}
		


	@Override
	public Map<String, Object> cargarContenidoExportar(ActionForm form, HttpServletRequest request, String plantilla) throws ParseException {

		EstadoCuentaProveedorForm objform = (EstadoCuentaProveedorForm) form;
		Map<String, Object> beans = new HashMap<String, Object>();

		if ("proveedor-estado-cuenta".equals(plantilla)) {
			IngresoProductoDao ingresoProductoDao = new IngresoProductoDao();
			List<EstadoCuentaVo> estadoCuentaProveedores = listaEstadoCuentaPorProveedor(
					objform.getIngresoproducto(), ingresoProductoDao, 0, 1000);
			beans.put("estadoCuentaProveedores", estadoCuentaProveedores);

		} else if ("proveedor-estado-cuenta-letra".equals(plantilla)) {
			IngresoProductoDao ingresoProductoDao = new IngresoProductoDao();
			List<Letraproveedor> listaLetraCliente = ingresoProductoDao
					.listaLetraProveedor(0, 1000, objform.getLetraProveedor());
			beans.put("estadoCuentaLetrasProveedores", listaLetraCliente);

		}

		return beans;
	}
	@Override
	public void cargarContenidoImprimir (ActionForm form, HttpServletRequest request, Impresora impresora) throws IllegalAccessException, IOException {
	}
}
