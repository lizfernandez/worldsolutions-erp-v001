package com.struts.action;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.dao.ConfiguracionDao;
import com.dao.EstadoDao;
import com.dao.GenericaDao;

import com.entities.Configuracion;
import com.entities.Ejerciciofiscal;
import com.entities.Estado;
import com.entities.Impuesto;
import com.entities.Periodo;
import com.entities.Tipodocumentogestion;
import com.struts.form.ConfiguracionForm;

import com.util.Constantes;
import com.util.Fechas;
import com.util.Paginacion;
import com.util.Util;

public class ConfiguracionAction extends DispatchAction {
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
		public ActionForward listaConfiguracion(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
            
			/***Validamos la session activa y logeada***/
			String msn = "";
			
			msn ="showList";			    
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if(request.getParameter("pagina")!= null){
				 pagina = Integer.parseInt(request.getParameter("pagina"));
			}
		
			
			
			/** Instanciamos la Clase ConfiguracionForm **/
			ConfiguracionForm objform = (ConfiguracionForm) form;
			

			/** Instanciamos las clase Daos **/
			
			ConfiguracionDao configuracionDao = new ConfiguracionDao();
			
			/**Seteamos los valores en las listas**/
			List<Configuracion> listaConfiguracion = configuracionDao.listaConfiguracion(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getConf());
			
	    
			/**Consultamos el total de registros segun criterio**/
			List<Configuracion> listaConfiguracionTotal = configuracionDao.listaConfiguracion(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getConf());
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaConfiguracionTotal.size()));
	 	      
			/** Seteamos las clase ConfiguracionForm **/
	        objform.setLista(listaConfiguracion);
	        objform.setPaginas(paginas);
	        objform.setPagInicio(pagina);			
			//}
			
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
		public ActionForward mantenimientoConfiguracion(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) {

			

			HttpSession sesion = request.getSession();			
			String mode = request.getParameter("mode");
			String msn="";
			
			
			/** Instantacia al ConfiguracionForm **/			
			ConfiguracionForm configuracionform = (ConfiguracionForm) form;
			
			/** Instantacia a la capa Dao **/
			EstadoDao estadoDao = new EstadoDao();
			List<Estado> listaEstado = estadoDao.listEstado();
			GenericaDao genericaDao = new GenericaDao();

		
			
			/**LLamamos al formulario mantenimientoConfiguracion.jsp para la insercion de datos **/
			if(mode.equals("I")){
				msn ="showEdit";
			}
			/**LLamamos al formulario mantenimientoConfiguracion.jsp para la insercion de datos **/
			if(mode.equals("U")){
				int id = Integer.parseInt(request.getParameter("id"));
				configuracionform.setConf((Configuracion)genericaDao.findEndidad(configuracionform.getConf(), id));
				msn ="showEdit";
			}
			
			/**LLamamos al formulario buscarMantenimientoPerfil.jsp para realizar la busqueda **/
			else if(mode.equals("F")){
				msn ="showFind";
			}
			
				configuracionform.setMode(mode);
				sesion.setAttribute("listaEstado", listaEstado);
				sesion.setAttribute("listaConfiguracion", Util.listaConfiguracion());
						

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
		public ActionForward iduConfiguracion(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) {
			
			/** Inicializamos las variables **/ 
			String msn = "";
			boolean resultado = false;
		
			/** Instanciamos las clase ConfiguracionForm y ConfiguracionDao **/
			ConfiguracionForm pForm = (ConfiguracionForm) form;
			GenericaDao configuracionDao = new GenericaDao();
			
			
	        /** **/
			if (pForm.getMode().equals("I")) {
				Configuracion obj =pForm.getConf();
				obj.setdFechaInserta(Fechas.getDate());
				obj.setcEstadoCodigo(Constantes.estadoActivo);			
				resultado = configuracionDao.insertarUnaEndidad(obj);
				
				
			} else if (pForm.getMode().equals("U")) {
				Configuracion obj =pForm.getConf();
				obj.setdFechaInserta(Fechas.getDate());
				obj.setcEstadoCodigo(obj.getcEstadoCodigo());
				resultado = configuracionDao.actualizarUnaEndidad(obj);
				
			}
			
				
			if (resultado == true) {
				msn = "msnOk";

			}
			else  {
				msn = "msnError";

			}
			/** llamamos a listar Configuracion **/
			//listaConfiguracion(mapping, pForm, request, response);
			
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
		public ActionForward listaEjercicioFiscal(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
            
			/***Validamos la session activa y logeada***/
			String msn = "";
			
			msn ="showListEjercicioFiscal";			    
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if(request.getParameter("pagina")!= null){
				 pagina = Integer.parseInt(request.getParameter("pagina"));
			}
			
			
			/** Instanciamos la Clase ConfiguracionForm **/
			ConfiguracionForm objform = (ConfiguracionForm) form;
			

			/** Instanciamos las clase Daos **/
			
			ConfiguracionDao configuracionDao = new ConfiguracionDao();
			
			/**Seteamos los valores en las listas**/
			List<Ejerciciofiscal> listaConfiguracion = configuracionDao.listaEjercicioFiscal(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getEjercicio());
			
	    
			/**Consultamos el total de registros segun criterio**/
			List<Ejerciciofiscal> listaConfiguracionTotal = configuracionDao.listaEjercicioFiscal(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getEjercicio());
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaConfiguracionTotal.size()));
	 	      
			/** Seteamos las clase ConfiguracionForm **/
	        objform.setLista(listaConfiguracion);
	        objform.setPaginas(paginas);
	        objform.setPagInicio(pagina);			
			//}
			
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
		public ActionForward mantenimientoEjercicioFiscal(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) {

			

			HttpSession sesion = request.getSession();			
			String mode = request.getParameter("mode");
			String msn="";
			
			
			/** Instantacia al ConfiguracionForm **/			
			ConfiguracionForm configuracionform = (ConfiguracionForm) form;
			
			/** Instantacia a la capa Dao **/
			
			List<Estado> listaEstado = Util.listaEstadoFiscal();
			GenericaDao genericaDao = new GenericaDao();

		
			
			/**LLamamos al formulario mantenimientoConfiguracion.jsp para la insercion de datos **/
			if(mode.equals("I")){
				msn ="showEditEjercicioFiscal";
			}
			/**LLamamos al formulario mantenimientoConfiguracion.jsp para la insercion de datos **/
			if(mode.equals("U")){
				int id = Integer.parseInt(request.getParameter("id"));
				Ejerciciofiscal ejercicio = (Ejerciciofiscal)genericaDao.findEndidad(configuracionform.getEjercicio(), id);
				configuracionform.setEjercicio(ejercicio);
				configuracionform.setcEstadoCodigo(ejercicio.getcCodigoEstado());
				configuracionform.setLista(ejercicio.getPeriodos());
				msn ="showEditEjercicioFiscal";
			}
			
			/**LLamamos al formulario buscarMantenimientoPerfil.jsp para realizar la busqueda **/
			else if(mode.equals("F")){
				msn ="showFindEjercicioFiscal";
			}
			
				configuracionform.setMode(mode);
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
		 * @throws ParseException 
		 */
		public ActionForward iduEjercicioFiscal(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws ParseException {
			
			/** Inicializamos las variables **/ 
			String msn = "";
			boolean resultado = false;
		
			/** Instanciamos las clase ConfiguracionForm y ConfiguracionDao **/
			ConfiguracionForm pForm = (ConfiguracionForm) form;
			GenericaDao configuracionDao = new GenericaDao();
			Configuracion conf= pForm.getConf();
			List<Periodo> periodos = new ArrayList<Periodo>();
			
	        /** **/
			if (pForm.getMode().equals("I")) {
				Ejerciciofiscal obj =pForm.getEjercicio();				
				obj.setdFechaInserta(Fechas.getDate());
				obj.setcCodigoEstado(conf.getcEstadoCodigo());
				
				int anio = Fechas.anioFecha(obj.getdFechaInicio());
				
				for(int i=Fechas.mesFecha(obj.getdFechaInicio()); i<=Fechas.mesFecha(obj.getdFechaFin());i++){
					Periodo e= new Periodo();
					String fechaInicio = "1/"+i+"/"+anio;
					String fechaFin = Fechas.diasMes(i, anio)+"/"+i+"/"+anio;			
					
					e.setdFechaInicio(Fechas.fechaDate(fechaInicio));
					e.setdFechaFin(Fechas.fechaDate(fechaFin));
					e.setvCodigoPeriodo(i+"/"+anio);
					e.setvNombrePeriodo("X "+i+"/"+anio);
					e.setcCodigoEstado(conf.getcEstadoCodigo());
					e.setEjerciciofiscal(obj);
				
					periodos.add(e);
				}
				
				obj.setPeriodos(periodos);
				obj.getPeriodos().get(0).setdFechaInicio(obj.getdFechaInicio());
				resultado = configuracionDao.insertarUnaEndidad(obj);
				/** Insertamos los periodos para el Ejercicio Fiscal**/
				
				
				
				
				
			} else if (pForm.getMode().equals("U")) {
				Ejerciciofiscal obj =pForm.getEjercicio();
				obj.setdFechaActualiza(Fechas.getDate());
				obj.setcCodigoEstado(conf.getcEstadoCodigo());
				resultado = configuracionDao.actualizarUnaEndidad(obj);
				
			}
			
				
			if (resultado == true) {
				msn = "msnOk";

			}
			else  {
				msn = "msnError";

			}
			/** llamamos a listar Configuracion **/
			//listaConfiguracion(mapping, pForm, request, response);
			
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
		public ActionForward listaPeriodo(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
            
			/***Validamos la session activa y logeada***/
			String msn = "";
			
			msn ="showListPeriodo";			    
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if(request.getParameter("pagina")!= null){
				 pagina = Integer.parseInt(request.getParameter("pagina"));
			}
			
			
			/** Instanciamos la Clase ConfiguracionForm **/
			ConfiguracionForm objform = (ConfiguracionForm) form;
			

			/** Instanciamos las clase Daos **/
			
			ConfiguracionDao configuracionDao = new ConfiguracionDao();
			
			/**Seteamos los valores en las listas**/
			List<Periodo> listaConfiguracion = configuracionDao.listaPeriodo(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getPeriodo());
			
	    
			/**Consultamos el total de registros segun criterio**/
			List<Periodo> listaConfiguracionTotal = configuracionDao.listaPeriodo(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getPeriodo());
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaConfiguracionTotal.size()));
	 	      
			/** Seteamos las clase ConfiguracionForm **/
	        objform.setLista(listaConfiguracion);
	        objform.setPaginas(paginas);
	        objform.setPagInicio(pagina);			
			//}
			
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
		public ActionForward mantenimientoPeriodo(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws ParseException {

			

			HttpSession sesion = request.getSession();			
			String mode = request.getParameter("mode");
			String msn="";
			
			
			/** Instantacia al ConfiguracionForm **/			
			ConfiguracionForm configuracionform = (ConfiguracionForm) form;
			
			/** Instantacia a la capa Dao **/
			
			List<Estado> listaEstado = Util.listaEstadoFiscal();
			
			GenericaDao genericaDao = new GenericaDao();
			List<Ejerciciofiscal> listaEjercicioFiscal = genericaDao.listaEntidadGenericaSinCodigo("Ejerciciofiscal");

		
			
			/**LLamamos al formulario mantenimientoConfiguracion.jsp para la insercion de datos **/
			if(mode.equals("I")){
				msn ="showEditPeriodo";
			}
			/**LLamamos al formulario mantenimientoConfiguracion.jsp para la insercion de datos **/
			if(mode.equals("U")){
				int id = Integer.parseInt(request.getParameter("id"));
				Periodo periodo= (Periodo)genericaDao.findEndidad(configuracionform.getPeriodo(), id);
				configuracionform.setPeriodo(periodo);
				configuracionform.setdFechaInicio(Fechas.fechaDDMMYY(periodo.getdFechaInicio()));
				configuracionform.setdFechaFin(Fechas.fechaDDMMYY(periodo.getdFechaFin()));
				configuracionform.setcEstadoCodigo(periodo.getcCodigoEstado());
				configuracionform.setiEjercicioFiscalId(periodo.getEjerciciofiscal().getiEjercicioFiscalId());
				msn ="showEditPeriodo";
			}
			
			/**LLamamos al formulario buscarMantenimientoPerfil.jsp para realizar la busqueda **/
			else if(mode.equals("F")){
				msn ="showFindPeriodo";
			}
			
				configuracionform.setMode(mode);
				sesion.setAttribute("listaEstado", listaEstado);
				sesion.setAttribute("listaEjercicioFiscal", listaEjercicioFiscal);

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
		public ActionForward iduPeriodo(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws ParseException {
			
			/** Inicializamos las variables **/ 
			String msn = "";
			boolean resultado = false;
		
			/** Instanciamos las clase ConfiguracionForm y ConfiguracionDao **/
			ConfiguracionForm pForm = (ConfiguracionForm) form;
			GenericaDao configuracionDao = new GenericaDao();
			Configuracion conf= pForm.getConf();
			
			
			Ejerciciofiscal objEje =pForm.getEjercicio();
			Periodo obj =pForm.getPeriodo();
			obj.setdFechaInicio(objEje.getdFechaInicio());			
			obj.setdFechaFin(objEje.getdFechaFin());
			
	        /** **/
			if (pForm.getMode().equals("I")) {								
				obj.setdFechaInserta(Fechas.getDate());
				obj.setcCodigoEstado(conf.getcEstadoCodigo());	
				resultado = configuracionDao.insertarUnaEndidad(obj);
				/** Insertamos los periodos para el Ejercicio Fiscal**/	
				
				
				
				
			} else if (pForm.getMode().equals("U")) {
				
				obj.setdFechaActualiza(Fechas.getDate());
				obj.setcCodigoEstado(conf.getcEstadoCodigo());
				
				resultado = configuracionDao.actualizarUnaEndidad(obj);
				
			}
			
				
			if (resultado == true) {
				msn = "msnOk";

			}
			else  {
				msn = "msnError";

			}
			/** llamamos a listar Configuracion **/
			//listaConfiguracion(mapping, pForm, request, response);
			
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
		public ActionForward listaImpuestos(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
            
			/***Validamos la session activa y logeada***/
			String msn = "";
			
			msn ="showListImpuestos";			    
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if(request.getParameter("pagina")!= null){
				 pagina = Integer.parseInt(request.getParameter("pagina"));
			}
			
			
			/** Instanciamos la Clase ConfiguracionForm **/
			ConfiguracionForm objform = (ConfiguracionForm) form;
			

			/** Instanciamos las clase Daos **/
			
			ConfiguracionDao configuracionDao = new ConfiguracionDao();
			
			/**Seteamos los valores en las listas**/
			List<Impuesto> listaConfiguracion = configuracionDao.listaImpuestos(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getImpuesto());
			
	    
			/**Consultamos el total de registros segun criterio**/
			List<Impuesto> listaConfiguracionTotal = configuracionDao.listaImpuestos(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getImpuesto());
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaConfiguracionTotal.size()));
	 	      
			/** Seteamos las clase ConfiguracionForm **/
	        objform.setLista(listaConfiguracion);
	        objform.setPaginas(paginas);
	        objform.setPagInicio(pagina);			
			//}
			
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
		public ActionForward mantenimientoImpuestos(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws ParseException {

			

			HttpSession sesion = request.getSession();			
			String mode = request.getParameter("mode");
			String msn="";
			
			
			/** Instantacia al ConfiguracionForm **/			
			ConfiguracionForm configuracionform = (ConfiguracionForm) form;
			
			/** Instantacia a la capa Dao **/
			EstadoDao estadoDao = new EstadoDao();
			List<Estado> listaEstado = estadoDao.listEstado();
			
			GenericaDao genericaDao = new GenericaDao();
			List<Tipodocumentogestion> listaAplicacion = Util.listaDocGestAplicado();

		
			
			/**LLamamos al formulario mantenimientoConfiguracion.jsp para la insercion de datos **/
			if(mode.equals("I")){
				msn ="showEditImpuestos";
			}
			/**LLamamos al formulario mantenimientoConfiguracion.jsp para la insercion de datos **/
			if(mode.equals("U")){
				int id = Integer.parseInt(request.getParameter("id"));
				Impuesto inpuesto= (Impuesto)genericaDao.findEndidad(configuracionform.getImpuesto(), id);
				configuracionform.setImpuesto(inpuesto);
				configuracionform.setcEstadoCodigo(inpuesto.getcCodigoEstado());
				configuracionform.setvAplicacionImpuesto(inpuesto.getvAplicacionImpuesto());
				
				msn ="showEditImpuestos";
			}
			
			
				configuracionform.setMode(mode);
				sesion.setAttribute("listaEstado", listaEstado);
				sesion.setAttribute("listaAplicacion", listaAplicacion);

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
		public ActionForward iduImpuestos(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws ParseException {
			
			/** Inicializamos las variables **/ 
			String msn = "";
			boolean resultado = false;
			HttpSession sesion = request.getSession();
			/** Instanciamos las clase ConfiguracionForm y ConfiguracionDao **/
			ConfiguracionForm pForm = (ConfiguracionForm) form;
			GenericaDao configuracionDao = new GenericaDao();
			Configuracion conf= pForm.getConf();
			Impuesto obj =pForm.getImpuesto();
			obj.setdFechaInserta(Fechas.getDate());
			obj.setcCodigoEstado(conf.getcEstadoCodigo());
	        /** **/
			if (pForm.getMode().equals("I")) {	
				resultado = configuracionDao.insertarUnaEndidad(obj);
				
				if(sesion.getAttribute("IGVCompras")!=null){
					if(pForm.getvAplicacionImpuesto().equals(Constantes.IGVCompra)){
						sesion.setAttribute("IGVCompras",pForm.getvPorcentaje());
					}
				}
				if(sesion.getAttribute("IGVVentas")!=null){
					if(pForm.getvAplicacionImpuesto().equals(Constantes.IGVVenta)){
						sesion.setAttribute("IGVVentas",pForm.getvPorcentaje());
					}
				}
					
			} else if (pForm.getMode().equals("U")) {		
			
				obj.setcCodigoEstado(conf.getcEstadoCodigo());				
				resultado = configuracionDao.actualizarUnaEndidad(obj);
				
				if(sesion.getAttribute("IGVCompras")!=null){
					if(pForm.getvAplicacionImpuesto().equals(Constantes.IGVCompra)){
						sesion.setAttribute("IGVCompras",pForm.getvPorcentaje());
					}
				}
				if(sesion.getAttribute("IGVVentas")!=null){
					if(pForm.getvAplicacionImpuesto().equals(Constantes.IGVVenta)){
						sesion.setAttribute("IGVVentas",pForm.getvPorcentaje());
					}
				}
				
			}
			
				
			if (resultado == true) {
				msn = "msnOk";

			}
			else  {
				msn = "msnError";

			}
			/** llamamos a listar Configuracion **/
			//listaConfiguracion(mapping, pForm, request, response);
			
			return mapping.findForward(msn);
		}
		
		
}
