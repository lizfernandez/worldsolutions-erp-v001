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
import com.entities.Almacen;
import com.entities.Empresa;
import com.entities.Estado;
import com.entities.Sucursal;
import com.entities.Usuario;
import com.struts.form.EmpresaSucursalForm;
import com.util.Fechas;
import com.util.Paginacion;
import com.util.Util;

public class EmpresaSucursalAction extends DispatchAction {
	
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
			EmpresaSucursalForm objform = (EmpresaSucursalForm) form;
			

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
			EmpresaSucursalForm sucursalform = (EmpresaSucursalForm) form;
			
			/** Instantacia a la capa Dao **/
			EstadoDao estadoDao = new EstadoDao();
			GenericaDao genericaDao = new GenericaDao();

			/** llamado de los metodos de la clase dao **/

			List<Estado> listaEstado = estadoDao.listEstado();
			List<Empresa> listaEmpresa = genericaDao.listaEntidadGenerica(Empresa.class);

			 
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
				sucursalform.setSucursal((Sucursal) genericaDao.findEndidad(Sucursal.class, id));
				msn ="showEdit";
				
			}
			/**LLamamos al formulario buscarMantenimientoPerfil.jsp para realizar la busqueda **/
			else if(mode.equals("F")){
				msn ="showFind";
			}
			
				sucursalform.setMode(mode);

			/** Colocamos en session las listas **/

			sesion.setAttribute("listaEstado", listaEstado);
			sesion.setAttribute("listaEmpresa", listaEmpresa);
			

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
			HttpSession sesion = request.getSession();
			Usuario usu = (Usuario) sesion.getAttribute("Usuario");
			/** Instanciamos las clase SucursalForm y SucursalDao **/
			EmpresaSucursalForm pForm = (EmpresaSucursalForm) form;
			Sucursal obj =pForm.getSucursal();
			
			GenericaDao sucursalDao = new GenericaDao();
			
			if (pForm.getMode().equals("I")) {
				
					obj.setdFechaInserta(Fechas.getDate());
					obj.setiUsuarioInsertaId(usu.getiUsuarioId());
					resultado = sucursalDao.insertarUnaEndidad(obj);
				
			} else if (pForm.getMode().equals("U")) {
				  obj =  sucursalDao.findEndidad(Sucursal.class, pForm.getiSucursalId());
				  obj= Util.comparar(obj, pForm.getSucursal());
			      obj.setiUsuarioActualizaId(usu.getiUsuarioId());
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
		public ActionForward listaEmpresa(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
            
			/***Validamos la session activa y logeada***/
			String msn = "";
			/*HttpSession sesion = request.getSession();			
			if(sesion.getId()!=(sesion.getAttribute("id"))){
				response.sendRedirect("login.do?metodo=logout");				
			}
			else{*/
			    msn ="showEmpresaList";			    
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if(request.getParameter("pagina")!= null){
				 pagina = Integer.parseInt(request.getParameter("pagina"));
			}
		
			
			
			/** Instanciamos la Clase SucursalForm **/
			EmpresaSucursalForm objform = (EmpresaSucursalForm) form;
			

			/** Instanciamos las clase Daos **/
			
			SucursalDao sucursalDao = new SucursalDao();
			
			/**Seteamos los valores en las listas**/
			List<Empresa> listaEmpresa = sucursalDao.listaEmpresa(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getEmpresa());
			
	    
			/**Consultamos el total de registros segun criterio**/
			List<Empresa> listaEmpresaTotal = sucursalDao.listaEmpresa(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getEmpresa());
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaEmpresaTotal.size()));
	 	      
			/** Seteamos las clase SucursalForm **/
	        objform.setLista(listaEmpresa);
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
		public ActionForward mantenimientoEmpresa(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) {

			

			HttpSession sesion = request.getSession();			
			String mode = request.getParameter("mode");
			String msn="";
			
			
			/** Instantacia al SucursalForm **/			
			EmpresaSucursalForm sucursalform = (EmpresaSucursalForm) form;
			
			/** Instantacia a la capa Dao **/
			EstadoDao estadoDao = new EstadoDao();
			GenericaDao genericaDao = new GenericaDao();

			/** llamado de los metodos de la clase dao **/

			List<Estado> listaEstado = estadoDao.listEstado();

			 
			/**LLamamos al formulario mantenimientoSucursal.jsp para la insercion de datos **/
			if(mode.equals("I")){
				
				String cSucursalCodigo = genericaDao.callSPCalculoCodigo(sucursalform.getEmpresa());
				sucursalform.getEmpresa().setcEmpresaCodigo(cSucursalCodigo);
				
				msn ="showEmpresaEdit";
			}
			
			/**LLamamos al formulario mantenimientoSucursal.jsp para mostrar los datos del UPDATE **/
			/** Seteamos el sucursalform la clase Sucursal **/
			else if(mode.equals("U") || mode.equals("D")){
				
				int id = Integer.parseInt(request.getParameter("id"));
				sucursalform.setEmpresa((Empresa) genericaDao.findEndidad(Empresa.class, id));
				msn ="showEmpresaEdit";
				
			}
			/**LLamamos al formulario buscarMantenimientoPerfil.jsp para realizar la busqueda **/
			else if(mode.equals("F")){
				msn ="showEmpresaFind";
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
		public ActionForward iduEmpresa(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IllegalArgumentException, SecurityException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
			
			/** Inicializamos las variables **/ 
			String msn = "";
			String mode = request.getParameter("mode");		
			String ids = request.getParameter("ids");		
			boolean resultado = false;
			HttpSession sesion = request.getSession();
			Usuario usu = (Usuario) sesion.getAttribute("Usuario");
			/** Instanciamos las clase SucursalForm y SucursalDao **/
			EmpresaSucursalForm pForm = (EmpresaSucursalForm) form;
			Empresa obj =pForm.getEmpresa();
			
			GenericaDao sucursalDao = new GenericaDao();
			
			if (pForm.getMode().equals("I")) {
				
					obj.setdFechaInserta(Fechas.getDate());
					obj.setiUsuarioInsertaId(usu.getiUsuarioId());
		            obj.setvEmpresaNombre(Util.UTF8(pForm.getvEmpresaNombre()));
					resultado = sucursalDao.insertarUnaEndidad(obj);
				
			} else if (pForm.getMode().equals("U")) {
				  obj =  sucursalDao.findEndidad(Empresa.class, pForm.getiEmpresaId());
				  obj= Util.comparar(obj, pForm.getEmpresa());
			      obj.setiUsuarioActualizaId(usu.getiUsuarioId());
					obj.setdFechaActualiza(Fechas.getDate());
					resultado = sucursalDao.actualizarUnaEndidad(obj);
				
			}
			else if (mode.equals("D")) {
				EntityTransaction transaction;
				try {
				    transaction = sucursalDao.entityTransaction();
				    transaction.begin();
					sucursalDao.eliminarUnaEndidad(obj, "iEmpresaId",ids);/**/
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
		public ActionForward listaAlmacen(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
            
			/***Validamos la session activa y logeada***/
			String msn = "";
			/*HttpSession sesion = request.getSession();			
			if(sesion.getId()!=(sesion.getAttribute("id"))){
				response.sendRedirect("login.do?metodo=logout");				
			}
			else{*/
			    msn ="showAlmacenList";			    
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if(request.getParameter("pagina")!= null){
				 pagina = Integer.parseInt(request.getParameter("pagina"));
			}
		
			
			
			/** Instanciamos la Clase SucursalForm **/
			EmpresaSucursalForm objform = (EmpresaSucursalForm) form;
			

			/** Instanciamos las clase Daos **/
			
			SucursalDao sucursalDao = new SucursalDao();
			
			/**Seteamos los valores en las listas**/
			List<Almacen> listaAlmacen = sucursalDao.listaAlmacen(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getAlmacen());
			
	    
			/**Consultamos el total de registros segun criterio**/
			List<Almacen> listaEmpresaTotal = sucursalDao.listaAlmacen(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getAlmacen());
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaEmpresaTotal.size()));
	 	      
			/** Seteamos las clase SucursalForm **/
	        objform.setLista(listaAlmacen);
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
		public ActionForward mantenimientoAlmacen(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) {

			

			HttpSession sesion = request.getSession();			
			String mode = request.getParameter("mode");
			String msn="";
			
			
			/** Instantacia al SucursalForm **/			
			EmpresaSucursalForm sucursalform = (EmpresaSucursalForm) form;
			
			/** Instantacia a la capa Dao **/
			EstadoDao estadoDao = new EstadoDao();
			GenericaDao genericaDao = new GenericaDao();

			/** llamado de los metodos de la clase dao **/

			List<Estado> listaEstado = estadoDao.listEstado();
			
			List<Sucursal> listaSucursal = genericaDao.listaEntidadGenerica(Sucursal.class);
			 
			/**LLamamos al formulario mantenimientoSucursal.jsp para la insercion de datos **/
			if(mode.equals("I")){
				
				String cAlmacenCodigo = genericaDao.callSPCalculoCodigo(sucursalform.getAlmacen());
				sucursalform.getAlmacen().setcAlmacenCodigo(cAlmacenCodigo);
				
				msn ="showAlmacenEdit";
			}
			
			/**LLamamos al formulario mantenimientoSucursal.jsp para mostrar los datos del UPDATE **/
			/** Seteamos el sucursalform la clase Sucursal **/
			else if(mode.equals("U") || mode.equals("D")){
				
				int id = Integer.parseInt(request.getParameter("id"));
				sucursalform.setAlmacen((Almacen) genericaDao.findEndidad(Almacen.class, id));
				msn ="showAlmacenEdit";
				
			}
			/**LLamamos al formulario buscarMantenimientoPerfil.jsp para realizar la busqueda **/
			else if(mode.equals("F")){
				msn ="showAlmacenFind";
			}
			
				sucursalform.setMode(mode);

			/** Colocamos en session las listas **/

			sesion.setAttribute("listaEstado", listaEstado);
			sesion.setAttribute("listaSucursal", listaSucursal);

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
		public ActionForward iduAlmacen(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IllegalArgumentException, SecurityException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
			
			/** Inicializamos las variables **/ 
			String msn = "";
			String mode = request.getParameter("mode");		
			String ids = request.getParameter("ids");		
			boolean resultado = false;
			HttpSession sesion = request.getSession();
			Usuario usu = (Usuario) sesion.getAttribute("Usuario");
			/** Instanciamos las clase SucursalForm y SucursalDao **/
			EmpresaSucursalForm pForm = (EmpresaSucursalForm) form;
			Almacen obj =pForm.getAlmacen();
			
			GenericaDao sucursalDao = new GenericaDao();
			
			if (pForm.getMode().equals("I")) {
				
					obj.setdFechaInserta(Fechas.getDate());
					obj.setiUsuarioInsertaId(usu.getiUsuarioId());		            
					resultado = sucursalDao.insertarUnaEndidad(obj);
				
			} else if (pForm.getMode().equals("U")) {
				  obj =  sucursalDao.findEndidad(Almacen.class, pForm.getiAlmacenId());
				  obj= Util.comparar(obj, pForm.getAlmacen());
			      obj.setiUsuarioActualizaId(usu.getiUsuarioId());
					obj.setdFechaActualiza(Fechas.getDate());
					resultado = sucursalDao.actualizarUnaEndidad(obj);
				
			}
			else if (mode.equals("D")) {
				EntityTransaction transaction;
				try {
				    transaction = sucursalDao.entityTransaction();
				    transaction.begin();
					sucursalDao.eliminarUnaEndidad(obj, "iAlmacenId",ids);/**/
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
