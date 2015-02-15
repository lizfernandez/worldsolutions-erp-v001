package com.struts.action;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.dao.EstadoDao;
import com.dao.GenericaDao;
import com.dao.SucursalDao;
import com.entities.Estado;
import com.entities.Sucursal;
import com.struts.form.SucursalForm;
import com.util.Fechas;
import com.util.Paginacion;
import com.util.Util;

public class SucursalAction extends DispatchAction {
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
		public ActionForward listaSucursal(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
            
			/***Validamos la session activa y logeada***/
			String msn = "";
			/*HttpSession sesion = request.getSession();			
			if(sesion.getId()!=(sesion.getAttribute("id"))){
				response.sendRedirect("login.do?metodo=logout");				
			}
			else{*/
			    msn ="showList";			    
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if(request.getParameter("pagina")!= null){
				 pagina = Integer.parseInt(request.getParameter("pagina"));
			}
		
			
			
			/** Instanciamos la Clase SucursalForm **/
			SucursalForm objform = (SucursalForm) form;
			

			/** Instanciamos las clase Daos **/
			
			SucursalDao sucursalDao = new SucursalDao();
			
			/**Seteamos los valores en las listas**/
			List<Sucursal> listaSucursal = sucursalDao.listaSucursal(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getSucursal());
			
	    
			/**Consultamos el total de registros segun criterio**/
			List<Sucursal> listaSucursalTotal = sucursalDao.listaSucursal(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getSucursal());
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaSucursalTotal.size()));
	 	      
			/** Seteamos las clase SucursalForm **/
	        objform.setLista(listaSucursal);
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
		public ActionForward mantenimientoSucursal(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) {

			

			HttpSession sesion = request.getSession();			
			String mode = request.getParameter("mode");
			String msn="";
			
			
			/** Instantacia al SucursalForm **/			
			SucursalForm sucursalform = (SucursalForm) form;
			
			/** Instantacia a la capa Dao **/
			EstadoDao estadoDao = new EstadoDao();
			GenericaDao genericaDao = new GenericaDao();

			/** llamado de los metodos de la clase dao **/

			List<Estado> listaEstado = estadoDao.listEstado();

			 
			/**LLamamos al formulario mantenimientoSucursal.jsp para la insercion de datos **/
			if(mode.equals("I")){
				
				String cSucursalCodigo = genericaDao.callSPCalculoCodigo(sucursalform.getSucursal());
				sucursalform.getSucursal().setcSucursalCodigo(cSucursalCodigo);
				
				msn ="showEdit";
			}
			
			/**LLamamos al formulario mantenimientoSucursal.jsp para mostrar los datos del UPDATE **/
			/** Seteamos el sucursalform la clase Sucursal **/
			else if(mode.equals("U") || mode.equals("D")){
				
				int id = Integer.parseInt(request.getParameter("id"));
				sucursalform.setSucursal((Sucursal) genericaDao.findEndidad(sucursalform.getSucursal(), id));
				msn ="showEdit";
				
			}
			/**LLamamos al formulario buscarMantenimientoPerfil.jsp para realizar la busqueda **/
			else if(mode.equals("F")){
				msn ="showFind";
			}
			
				sucursalform.setMode(mode);

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
		public ActionForward iduSucursal(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IllegalArgumentException, SecurityException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
			
			/** Inicializamos las variables **/ 
			String msn = "";
			String mode = request.getParameter("mode");		
			String ids = request.getParameter("ids");		
			boolean resultado = false;
		
			/** Instanciamos las clase SucursalForm y SucursalDao **/
			SucursalForm pForm = (SucursalForm) form;
			Sucursal obj =pForm.getSucursal();
			
			GenericaDao sucursalDao = new GenericaDao();
			
			if (pForm.getMode().equals("I")) {
				
					obj.setdFechaInserta(Fechas.getDate());
					resultado = sucursalDao.insertarUnaEndidad(obj);
				
			} else if (pForm.getMode().equals("U")) {
				  obj =  sucursalDao.findEndidad(obj,pForm.getiSucursalId());
				  obj= Util.comparar(obj, pForm.getSucursal());
			
					obj.setdFechaActualiza(Fechas.getDate());
					resultado = sucursalDao.actualizarUnaEndidad(obj);
				
			}
			else if (mode.equals("D")) {
				EntityTransaction transaction;
				try {
				    transaction = sucursalDao.entityTransaction();
				    transaction.begin();
					sucursalDao.eliminarUnaEndidad(obj, "iSucursalId",ids);/**/
					resultado = sucursalDao.commitEndidad(transaction);
			    } catch (Exception ex) {
			    	ex.printStackTrace();
			    } finally {
			    	transaction = null;
			    }
			}
				
			if (resultado == true) {
				msn = "msnOk";

			}
			else  {
				msn = "msnError";

			}
			/** llamamos a listar Sucursal **/
			//listaSucursal(mapping, pForm, request, response);
			
			return mapping.findForward(msn);
		}
}
