package com.struts.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.dao.EstadoDao;
import com.dao.GenericaDao;
import com.dao.PerfilDao;
import com.dao.UsuarioDao;
import com.entities.Estado;
import com.entities.Perfil;
import com.entities.Usuario;
import com.struts.form.UsuarioForm;
import com.util.Fechas;
import com.util.Paginacion;

public class UsuarioAction extends DispatchAction {
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
		public ActionForward listaUsuario(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
			/***Validamos la session activa y logeada***/
			String msn = "";
			/*	HttpSession sesion = request.getSession();
			
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
		
			/** Instanciamos la Clase UsuarioForm **/
			UsuarioForm objform = (UsuarioForm) form;
			

			/** Instanciamos las clase Daos **/
			
			UsuarioDao UsuarioDao = new UsuarioDao();
			
			/**Seteamos los valores en las listas**/
			List<Usuario> listaUsuario = UsuarioDao.listaUsuario(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getUsuario());
			
	    
			/**Consultamos el total de registros segun criterio**/
			List<Usuario> listaUsuarioTotal = UsuarioDao.listaUsuario(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getUsuario());
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaUsuarioTotal.size()));
	 	      
			/** Seteamos las clase UsuarioForm **/
	        objform.setLista(listaUsuario);
	        objform.setPaginas(paginas);
	        objform.setPagInicio(pagina);
	        
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
		public ActionForward mantenimientoUsuario(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) {

			

			HttpSession sesion = request.getSession();			
			String mode = request.getParameter("mode");
			String msn="";
			
			
			/** Instantacia al UsuarioForm **/			
			UsuarioForm Usuarioform = (UsuarioForm) form;
			Perfil perfil = new Perfil();
			
			/** Instantacia a la capa Dao **/
			EstadoDao estadoDao = new EstadoDao();
			GenericaDao UsuarioDao = new GenericaDao();
			PerfilDao perfilDao = new PerfilDao();

			/** llamado de los metodos de la clase dao **/

			List<Estado> listaEstado = estadoDao.listEstado();
			List<Perfil> listaPerfil = perfilDao.listaPerfil(0, 0, perfil);

			
			/**LLamamos al formulario mantenimientoUsuario.jsp para la insercion de datos **/
			if(mode.equals("I")){
				Usuarioform.getUsuario().setcUsuarioCodigo(UsuarioDao.callSPCalculoCodigo(Usuarioform.getUsuario()));
				msn ="showEdit";
			}
			
			/**LLamamos al formulario mantenimientoUsuario.jsp para mostrar los datos del UPDATE **/
			/** Seteamos el Usuarioform la clase Usuario **/
			else if(mode.equals("U") || mode.equals("D")){				
				int id = Integer.parseInt(request.getParameter("id"));
				Usuarioform.setUsuario(UsuarioDao.findEndidad(Usuarioform.getUsuario(),id));
				msn ="showEdit";
				
			}
			/**LLamamos al formulario buscarMantenimientoUsuario.jsp para realizar la busqueda **/
			else if(mode.equals("F")){
				msn ="showFind";
			}
			
				Usuarioform.setMode(mode);

			/** Colocamos en session las listas **/

			sesion.setAttribute("listaPerfil", listaPerfil);
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
		public ActionForward iduUsuario(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) {
			
			/** Inicializamos las variables **/ 
			String msn = "";
			String mode = request.getParameter("mode");		
			String ids = request.getParameter("ids");		
			boolean resultado = false;
		
			/** Instanciamos las clase UsuarioForm y UsuarioDao **/
			UsuarioForm pForm = (UsuarioForm) form;
			Usuario obj =pForm.getUsuario();
			GenericaDao usuarioDao = new GenericaDao();
			
			
	        /** **/
			if (pForm.getMode().equals("I")) {
				
				obj.setdFechaInserta(Fechas.getDate());
				resultado = usuarioDao.insertarUnaEndidad(obj);
				
			} else if (pForm.getMode().equals("U")) {
				//Usuario obj =pForm.getUsuario();
				obj.setdFechaActualiza(Fechas.getDate());
				resultado = usuarioDao.actualizarUnaEndidad(obj);
				
			}
			else if (mode.equals("D")) { 		        	
					 usuarioDao.eliminarUnaEndidad(obj, "iUsuarioId", ids);/**/
					 resultado = usuarioDao.commitEndidad(usuarioDao.entityTransaction());
				}
				
			if (resultado == true) {
				msn = "msnOk";

			}
			else  {
				msn = "msnError";

			}
			/** llamamos a listar Usuario **/
			//listaUsuario(mapping, pForm, request, response);
			
			return mapping.findForward(msn);
		}
}
