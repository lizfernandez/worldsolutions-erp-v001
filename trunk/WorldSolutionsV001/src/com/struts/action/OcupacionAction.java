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
import com.dao.OcupacionDao;
import com.entities.Estado;
import com.entities.Ocupacion;
import com.struts.form.OcupacionForm;
import com.util.Fechas;
import com.util.Paginacion;

public class OcupacionAction extends DispatchAction {
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
		public ActionForward listaOcupacion(ActionMapping mapping, ActionForm form,
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
		
			
			
			/** Instanciamos la Clase OcupacionForm **/
			OcupacionForm objform = (OcupacionForm) form;
			

			/** Instanciamos las clase Daos **/
			
			OcupacionDao ocupacionDao = new OcupacionDao();
			
			/**Seteamos los valores en las listas**/
			List<Ocupacion> listaOcupacion = ocupacionDao.listaOcupacion(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getOcupacion());
			
	    
			/**Consultamos el total de registros segun criterio**/
			List<Ocupacion> listaOcupacionTotal = ocupacionDao.listaOcupacion(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getOcupacion());
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaOcupacionTotal.size()));
	 	      
			/** Seteamos las clase OcupacionForm **/
	        objform.setLista(listaOcupacion);
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
		public ActionForward mantenimientoOcupacion(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) {

			

			HttpSession sesion = request.getSession();			
			String mode = request.getParameter("mode");
			String msn="";
			
			
			/** Instantacia al OcupacionForm **/			
			OcupacionForm ocupacionform = (OcupacionForm) form;
			
			/** Instantacia a la capa Dao **/
			EstadoDao estadoDao = new EstadoDao();
			GenericaDao genericaDao = new GenericaDao();

			/** llamado de los metodos de la clase dao **/

			List<Estado> listaEstado = estadoDao.listEstado();

			 
			/**LLamamos al formulario mantenimientoOcupacion.jsp para la insercion de datos **/
			if(mode.equals("I")){
				
				String cOcupacionCodigo = genericaDao.callSPCalculoCodigo(ocupacionform.getOcupacion());
				ocupacionform.getOcupacion().setcOcupacionCodigo(cOcupacionCodigo);
				
				msn ="showEdit";
			}
			
			/**LLamamos al formulario mantenimientoOcupacion.jsp para mostrar los datos del UPDATE **/
			/** Seteamos el ocupacionform la clase Ocupacion **/
			else if(mode.equals("U") || mode.equals("D")){
				
				int id = Integer.parseInt(request.getParameter("id"));
				ocupacionform.setOcupacion((Ocupacion) genericaDao.findEndidad(ocupacionform.getOcupacion(), id));
				msn ="showEdit";
				
			}
			/**LLamamos al formulario buscarMantenimientoPerfil.jsp para realizar la busqueda **/
			else if(mode.equals("F")){
				msn ="showFind";
			}
			
				ocupacionform.setMode(mode);

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
		 */
		public ActionForward iduOcupacion(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) {
			
			/** Inicializamos las variables **/ 
			String msn = "";
			String mode = request.getParameter("mode");		
			String ids = request.getParameter("ids");		
			boolean resultado = false;
		
			/** Instanciamos las clase OcupacionForm y OcupacionDao **/
			OcupacionForm pForm = (OcupacionForm) form;
			Ocupacion obj =pForm.getOcupacion();
			
			GenericaDao ocupacionDao = new GenericaDao();
			
			if (pForm.getMode().equals("I")) {
				
					obj.setdFechaInserta(Fechas.getDate());
					resultado = ocupacionDao.insertarUnaEndidad(obj);
				
			} else if (pForm.getMode().equals("U")) {
				
					obj.setdFechaActualiza(Fechas.getDate());
					resultado = ocupacionDao.actualizarUnaEndidad(obj);
				
			}
			else if (mode.equals("D")) {
				    EntityTransaction transaction = ocupacionDao.entityTransaction();
				    transaction.begin();
					ocupacionDao.eliminarUnaEndidad(obj, "iOcupacionId",ids);/**/
					resultado = ocupacionDao.commitEndidad(transaction);
				
			}
				
			if (resultado == true) {
				msn = "msnOk";

			}
			else  {
				msn = "msnError";

			}
			/** llamamos a listar Ocupacion **/
			//listaOcupacion(mapping, pForm, request, response);
			
			return mapping.findForward(msn);
		}
}
