package com.struts.action;

import java.io.IOException;
import java.io.PrintWriter;

import java.lang.reflect.InvocationTargetException;
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


import com.dao.EstadoDao;
import com.dao.GenericaDao;
import com.dao.PerfilDao;


import com.entities.Estado;

import com.entities.Menuopcione;
import com.entities.Perfil;
import com.entities.Permiso;

import com.entities.Usuario;
import com.google.gson.Gson;
import com.struts.form.PerfilForm;


import com.util.Constantes;
import com.util.Fechas;
import com.util.Paginacion;
import com.util.Util;

public class PerfilAction extends DispatchAction {
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
	public ActionForward listaPerfil(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		/***Validamos la session activa y logeada***/
		String msn = "";
		/*HttpSession sesion = request.getSession();
		
		if(sesion.getId()!=(sesion.getAttribute("id"))){
			response.sendRedirect("login.do?metodo=logout");				
		}
		else{*/
		
		String mode = request.getParameter("mode");
		int pagina = Paginacion.paginaInicial;
		int pagInicio = Paginacion.paginaInicial;
		if(request.getParameter("pagina")!= null){
			 pagina = Integer.parseInt(request.getParameter("pagina"));
		}
	
		/** Instanciamos la Clase PerfilForm **/
		PerfilForm perfilForm = (PerfilForm) form;
		

		/** Instanciamos las clase Daos **/
		PerfilDao perfilDao = new PerfilDao();
		
		/**Seteamos los valores en las listas**/
		List<Perfil> listaPerfil = perfilDao.listaPerfil(Paginacion.pagInicio(pagina),Paginacion.pagFin(),perfilForm.getPerfil());
		
    
		/**Consultamos el total de registros segun criterio**/
		List<Perfil> listaPerfilTotal = perfilDao.listaPerfil(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),perfilForm.getPerfil());
		
        /**Obtenemos el total del paginas***/
		List<Long> paginas = Paginacion.listPaginas((long)(listaPerfilTotal.size()));
 
		/**Lista de personal en Modal Popup***/
		if(mode!=null && mode.equals("P")){
			 msn ="showListPermiso";
			
		}
		else{
			 
			/***Redirecionamos  al ***/
			 msn ="showList";
			
		}
      
		/** Seteamos las clase PerfilForm **/
        perfilForm.setLista(listaPerfil);
        perfilForm.setPaginas(paginas);
        perfilForm.setPagInicio(pagina);
     //  }// else
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
	public ActionForward listaPermisos(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		/***Validamos la session activa y logeada***/
		String msn = "";
		
		HttpSession sesion = request.getSession();
		
		int pagina = Paginacion.paginaInicial;
		int pagInicio = Paginacion.paginaInicial;
		if(request.getParameter("pagina")!= null){
			 pagina = Integer.parseInt(request.getParameter("pagina"));
		}
	
		/** Instanciamos la Clase PerfilForm **/
		PerfilForm perfilForm = (PerfilForm) form;
		

		/** Instanciamos las clase Daos **/
		GenericaDao genericaDao = new GenericaDao();
		PerfilDao perfilDao = new PerfilDao();
		
		
		/**Seteamos los valores en las listas**/
		List<Permiso> listaUsuarioPermiso= new ArrayList<Permiso>();
		List<Usuario> listaUsuarios= new ArrayList<Usuario>();
		List<Menuopcione> listaMenu = genericaDao.listaEntidadGenericaSinCodigo("Menu");
		
		
		
		List<Permiso> listaPermisoBD = perfilDao.listaPermiso(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax());
		List<Usuario> listaUsuario = genericaDao.listaEntidadGenerica(new Usuario());
		listaUsuarios = genericaDao.listaEntidadGenerica(new Usuario());
	    msn ="showListPermiso";
			
	    
	    /**Consultamos el total de registros segun criterio**/
		List<Permiso> listaPerfilTotal = perfilDao.listaPermiso(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax());
		
        /**Obtenemos el total del paginas***/
		List<Long> paginas = Paginacion.listPaginas((long)(listaPerfilTotal.size()));
  
		/**guardamos en una lista los usuario que tienen permiso en el sistema
		 * para ello recorremos los usuarios de la tabla permisos y los comparamos con
		 * los usuarios de la tabla usuarios**/
	    
	    for(Usuario usu:listaUsuario){
	    { for(Permiso per:listaPermisoBD)	
	    		if(usu.equals(per.getUsuario())){
	    			listaUsuarioPermiso.add(per);
	    			listaUsuarios.remove(usu);
	    		}
	    		
	    	}	    
	    }
      
	    
		/** Seteamos las clase PerfilForm **/
	    perfilForm.setLista(listaMenu);
        perfilForm.setListaPermiso(listaPermisoBD);
        perfilForm.setListaUsuarioPermiso(listaUsuarioPermiso);
        perfilForm.setListaUsuario(listaUsuarios);
     
        perfilForm.setPaginas(paginas);
        perfilForm.setPagInicio(pagina);
        
        
        

        
     //  }// else
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
	public ActionForward listaPermisoUsuario(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/json");
		
	  // Type collectionType = new TypeToken<Object>(){}.getType();
		
		
		List<Permiso> lista = new ArrayList<Permiso>();
		
		String iUsuarioId = request.getParameter("iUsuarioId");
		PerfilDao perfilDao = new PerfilDao();
		List<String> listaPermiso = new ArrayList<String>();
		
		lista = perfilDao.listaFindPermiso(Integer.parseInt(iUsuarioId));
		for(Permiso per: lista){
			if(!per.getvCodigoMenu().equals(""))
			{ listaPermiso.add(per.getvCodigoMenu());
			}
		}
		Gson gson = new Gson();	
		String jsonOutput = gson.toJson(listaPermiso);
		
		
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
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public ActionForward mantenimientoPerfil(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IllegalAccessException, InvocationTargetException {

		HttpSession sesion = request.getSession();
		
		PerfilForm perfilForm = (PerfilForm) form;
		Perfil obj = perfilForm.getPerfil();
		String mode = request.getParameter("mode");
		String msn="";
				

		/** Instantacia a la capa Dao **/
		EstadoDao estadoDao = new EstadoDao();
		GenericaDao perfilDao = new GenericaDao();

		/** llamado de los metodos de la clase dao **/

		List<Estado> listaEstado = estadoDao.listEstado();
       
		/**LLamamos al formulario mantenimientoPerfil.jsp para la insercion de datos **/
		if(mode.equals("I")){
			perfilForm.getPerfil().setcPerfilCodigo(perfilDao.callSPCalculoCodigo(perfilForm.getPerfil()));
			msn ="showEdit";
		}
		
		/**LLamamos al formulario mantenimientoPerfil.jsp para mostrar los datos del UPDATE **/
		/** Seteamos el PerfilForm la clase Perfil **/
		else if(mode.equals("U") || mode.equals("D")){
			
			int id = Integer.parseInt(request.getParameter("id"));
			Perfil perfil = perfilDao.findEndidad(obj,id);
			System.out.println("perfilDao.buscarPerfil(id) ="+perfil);
		//	PerfilForm(perfilDao.buscarPerfil(id));r
			
			perfilForm.setPerfil(perfil);
			msn ="showEdit";
			
		}
		/**LLamamos al formulario buscarMantenimientoPerfil.jsp para realizar la busqueda **/
		else if(mode.equals("F")){
			msn ="showFind";
		}
		
		perfilForm.setMode(mode);

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
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalArgumentException 
	 */
	public ActionForward iduPerfil(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, InvocationTargetException, IllegalArgumentException, ClassNotFoundException {
		
		/** Inicializamos las variables **/ 
		String msn = "";
		String mode = request.getParameter("mode");		
		String ids = request.getParameter("ids");
		String vCodigoPermiso=request.getParameter("vCodigoPermiso");
		String iUsuarioId=request.getParameter("iUsuarioId");
		HttpSession sesion = request.getSession();
		Usuario usu = (Usuario) sesion.getAttribute("Usuario");
		boolean resultado = false;
		
		/** Instanciamos las clase PerfilForm y PerfilDao **/
		PerfilForm pForm = (PerfilForm) form;
		Perfil obj = pForm.getPerfil();		
		GenericaDao perfilDao = new GenericaDao();
		PerfilDao objPerfildao = new PerfilDao();
		
		
        /**Insertamos datos del perfil **/
		if (pForm.getMode().equals("I")) {
			obj.setdFechaInserta(Fechas.getDate());
			obj.setiUsuarioInsertaId(usu.getiUsuarioId());
			resultado = perfilDao.insertarUnaEndidad(obj);
			
		} else if (pForm.getMode().equals("U")) {
		     obj = perfilDao.findEndidad(obj,pForm.getiPerfilId());
			
			try {
				obj.setdFechaActualiza(Fechas.getDate());
				obj.setiUsuarioActualizaId(usu.getiUsuarioId());
				obj = Util.comparar(obj,pForm.getPerfil());
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			resultado = perfilDao.actualizarUnaEndidad(obj);
			
		}
	  else if (mode.equals("UP")) { // actualizamos Permisos.
		  EntityTransaction transaction;
		  try {
			  transaction = objPerfildao.entityTransaction();
	    	   transaction.begin();
		  String arr[] = vCodigoPermiso.split("-") ; 
		  objPerfildao.eliminarPermisos(Integer.parseInt(iUsuarioId));
		   resultado = objPerfildao.commitEndidad(transaction);
		   for(int i=0;i<arr.length;i++){
		       if(!arr[i].equals("")){
		    	   /*Permiso per = new Permiso();
		    	   per.setcEstado(Constantes.estadoActivo);
		    	   per.setUsuario(usu);
		    	   per.setvCodigoMenu(arr[i]);
		    	   objPerfildao.persistEndidad(per);
		    	  */
		    	   resultado = objPerfildao.callProcedurePermiso(Integer.parseInt(iUsuarioId), arr[i], arr.length);
		       }
		       
		  }
		
		  }catch (Exception e) {
		 e.printStackTrace();
 		   objPerfildao.limpiarInstancia();
 	   } finally {
 		   transaction = null;
 	   }
		 
	    //  resultado = objPerfildao.callProcedurePermiso(Integer.parseInt(iUsuarioId), vCodigoPermiso, arr.length);	 
	  	
		}
       else if (mode.equals("D")) {  
    	   EntityTransaction transaction;
    	   try {
	    	   transaction = objPerfildao.entityTransaction();
	    	   transaction.begin();
	    	   perfilDao.eliminarUnaEndidad(obj, "iPerfilId", ids);/**/
	    	   resultado = objPerfildao.commitEndidad(transaction);
    	   } catch (Exception ex) {
    		   ex.printStackTrace();
    		   objPerfildao.limpiarInstancia();
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
		
		/** llamamos a listar Perfil **/
		//listaPerfil(mapping, pForm, request, response);
		
		return mapping.findForward(msn);
	}
}
