package com.struts.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


import com.dao.AreaDao;
import com.dao.PersonalDao;
import com.dao.EstadoDao;
import com.dao.GenericaDao;
import com.entities.Area;

import com.entities.Ocupacion;
import com.entities.Personal;
import com.entities.Estado;

import com.struts.form.PersonalForm;
import com.util.Fechas;
import com.util.Paginacion;
import com.util.Util;

public class PersonalAction extends DispatchAction {
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
	public ActionForward listaPersonal(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		/***Validamos la session activa y logeada***/
		String msn = "";
		/*HttpSession sesion = request.getSession();
		
		if(sesion.getId()!=(sesion.getAttribute("id"))){
			response.sendRedirect("login.do?metodo=logout");				
		}
		else{
				*/	
		/***Inicializamos variables***/
		String mode = request.getParameter("mode");
		int pagina = Paginacion.paginaInicial;
		int pagInicio = Paginacion.paginaInicial;
		if(request.getParameter("pagina")!= null){
			 pagina = Integer.parseInt(request.getParameter("pagina"));
		}
		
		List<Long> paginas = new ArrayList<Long>();
		
		/** Instanciamos la Clase PersonalForm **/
		PersonalForm objform = (PersonalForm) form;
		

		/** Instanciamos las clase Daos **/
		
		PersonalDao personalDao = new PersonalDao();
			
		
		/**Seteamos los valores en las listas**/
		List<Personal> listaPersonal = personalDao.listaPersonal(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getPersonal());

		/**Consultamos el total de registros segun criterio**/
		List<Personal> listaPerfilTotal = personalDao.listaPersonal(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getPersonal());
		
        /**Obtenemos el total del paginas***/
		 paginas = Paginacion.listPaginas((long)(listaPerfilTotal.size()));
		
		 
		/**Lista de personal en Modal Popup***/
		if(mode!=null && mode.equals("LP")){
			 msn ="showListPopup";
			
		}
		else{
			 
			/***Redirecionamos  al ***/
			 msn ="showList";
			
		}
       
		/** Seteamos las clase PersonalForm **/
        objform.setLista(listaPersonal);
        objform.setPaginas(paginas);
        objform.setPagInicio(pagina);
     //   }// else
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
	public ActionForward mantenimientoPersonal(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession sesion = request.getSession();
		String mode = request.getParameter("mode");
		String msn="";
		
        /**Instancia PersonalForm **/
		PersonalForm personalForm = (PersonalForm) form;
		Area area = new Area();
		
		
		/** Instantacia a la capa Dao **/
		EstadoDao estadoDao = new EstadoDao();
		AreaDao areaDao = new AreaDao();
		GenericaDao personalDao = new GenericaDao();		

		/** llamado de los metodos de la clase dao **/

		List<Estado> listaEstado = estadoDao.listEstado();
		List<Area> listaArea = areaDao.listaArea(0, 0, area);
		List<Ocupacion> listaOcupacion = personalDao.listaEntidadGenerica(new Ocupacion());

		/**LLamamos al formulario mantenimientoPersonal.jsp para la insercion de datos **/
		if(mode.equals("I")){
			personalForm.getPersonal().setcPersonalCodigo(personalDao.callSPCalculoCodigo(personalForm.getPersonal()));
			msn ="showEdit";
		}
		
		/**LLamamos al formulario mantenimientoPersonal.jsp para mostrar los datos del UPDATE **/
		/** Seteamos el PerfilForm la clase Perfil **/
		else if(mode.equals("U") || mode.equals("D")){
			
			int id = Integer.parseInt(request.getParameter("id"));
			personalForm.setPersonal(personalDao.findEndidad(personalForm.getPersonal(),id));
			msn ="showEdit";
			
		}
		/**LLamamos al formulario buscarMantenimientoPersonal.jsp para realizar la busqueda **/
		else if(mode.equals("F")){
			msn ="showFind";
		}
		personalForm.setMode(mode);
	//	objform.setiTipoDocumentoId(new Tipodocumento());

		/** Colocamos en session las listas **/

		sesion.setAttribute("listaEstado", listaEstado);
		sesion.setAttribute("listaOcupacion", listaOcupacion);
		sesion.setAttribute("listaArea", listaArea);
		sesion.setAttribute("listaDoc", Util.listaaDoc());
		sesion.setAttribute("listaSex", Util.listaSexo());

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
	public ActionForward iduPersonal(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		/** Inicializamos las variables **/ 
		String msn = "";
		String mode = request.getParameter("mode");		
		String ids = request.getParameter("ids");		
		boolean resultado = false;
		
		/** Instanciamos las clase PersonalForm y PersonalDao **/
		PersonalForm pForm = (PersonalForm) form;
		Personal obj =pForm.getPersonal();
		GenericaDao personalDao = new GenericaDao();
		
		/**Insertamos datos del perfil **/
		if (pForm.getMode().equals("I")) {			
			obj.setdFechaInserta(Fechas.getDate());
			resultado = personalDao.insertarUnaEndidad(obj);
			
		} else if (pForm.getMode().equals("U")) {
			obj.setdFechaAcualiza(Fechas.getDate());
			resultado = personalDao.actualizarUnaEndidad(obj);
			
		}
       else if (mode.equals("D")) { 
    	   EntityTransaction transaction = personalDao.entityTransaction();
    	   transaction.begin();
    	   personalDao.eliminarUnaEndidad(obj, "iPersonalId",ids);/**/
		   resultado = personalDao.commitEndidad(transaction);
		}
		
		if (resultado == true) {
			msn = "msnOk";

		}		
		else  {
			msn = "msnError";

		}		
				
				/** llamamos a listar Perfil **/
				//listaPerfil(mapping, pForm, request, response);
				
				return mapping.findForward(msn);
	}
}
