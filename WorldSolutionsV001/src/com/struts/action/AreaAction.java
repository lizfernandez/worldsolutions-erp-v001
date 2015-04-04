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
import com.dao.AreaDao;
import com.entities.Estado;
import com.entities.Area;
import com.entities.Usuario;
import com.struts.form.AreaForm;
import com.util.Fechas;
import com.util.Paginacion;

public class AreaAction extends DispatchAction {
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
		public ActionForward listaArea(ActionMapping mapping, ActionForm form,
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
		
			
			
			/** Instanciamos la Clase AreaForm **/
			AreaForm objform = (AreaForm) form;
			

			/** Instanciamos las clase Daos **/
			
			AreaDao areaDao = new AreaDao();
			
			/**Seteamos los valores en las listas**/
			List<Area> listaArea = areaDao.listaArea(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getArea());
			
	    
			/**Consultamos el total de registros segun criterio**/
			List<Area> listaAreaTotal = areaDao.listaArea(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getArea());
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaAreaTotal.size()));
	 	      
			/** Seteamos las clase AreaForm **/
	        objform.setLista(listaArea);
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
		public ActionForward mantenimientoArea(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) {

			

			HttpSession sesion = request.getSession();			
			String mode = request.getParameter("mode");
			String msn="";
			
			
			/** Instantacia al AreaForm **/			
			AreaForm areaform = (AreaForm) form;
			
			/** Instantacia a la capa Dao **/
			EstadoDao estadoDao = new EstadoDao();
			GenericaDao genericaDao = new GenericaDao();

			/** llamado de los metodos de la clase dao **/

			List<Estado> listaEstado = estadoDao.listEstado();

			 
			/**LLamamos al formulario mantenimientoArea.jsp para la insercion de datos **/
			if(mode.equals("I")){
				
				String cAreaCodigo = genericaDao.callSPCalculoCodigo(areaform.getArea());
				areaform.getArea().setcAreaCodigo(cAreaCodigo);
				
				msn ="showEdit";
			}
			
			/**LLamamos al formulario mantenimientoArea.jsp para mostrar los datos del UPDATE **/
			/** Seteamos el areaform la clase Area **/
			else if(mode.equals("U") || mode.equals("D")){
				
				int id = Integer.parseInt(request.getParameter("id"));
				areaform.setArea((Area) genericaDao.findEndidad(areaform.getArea(), id));
				msn ="showEdit";
				
			}
			/**LLamamos al formulario buscarMantenimientoPerfil.jsp para realizar la busqueda **/
			else if(mode.equals("F")){
				msn ="showFind";
			}
			
				areaform.setMode(mode);

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
		public ActionForward iduArea(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
			
			/** Inicializamos las variables **/ 
			String msn = "";
			String mode = request.getParameter("mode");		
			String ids = request.getParameter("ids");		
			boolean resultado = false;
			HttpSession sesion = request.getSession();
			Usuario usu = (Usuario) sesion.getAttribute("Usuario");
			/** Instanciamos las clase AreaForm y AreaDao **/
			AreaForm pForm = (AreaForm) form;
			Area obj =pForm.getArea();
			
			GenericaDao areaDao = new GenericaDao();
			
			if (pForm.getMode().equals("I")) {
				
					obj.setdFechaInserta(Fechas.getDate());
					obj.setiUsuarioInsertaId(usu.getiUsuarioId());
					resultado = areaDao.insertarUnaEndidad(obj);
				
			} else if (pForm.getMode().equals("U")) {
				
					obj.setdFechaActualiza(Fechas.getDate());
					obj.setiUsuarioModificaId(usu.getiUsuarioId());
					resultado = areaDao.actualizarUnaEndidad(obj);
				
			}
			else if (mode.equals("D")) {
				EntityTransaction transaccion = null;
				try {
				    transaccion = areaDao.entityTransaction();
				    transaccion.begin();
					areaDao.eliminarUnaEndidad(obj, "iAreaId",ids);/**/
					resultado = areaDao.commitEndidad(transaccion);
				} catch (Exception e) {
					e.printStackTrace();
					areaDao.limpiarInstancia();
				} finally {
					transaccion = null;
				}
			}
				
			if (resultado == true) {
				msn = "msnOk";

			}
			else  {
				msn = "msnError";

			}
			/** llamamos a listar Area **/
			//listaArea(mapping, pForm, request, response);
			
			return mapping.findForward(msn);
		}
}
