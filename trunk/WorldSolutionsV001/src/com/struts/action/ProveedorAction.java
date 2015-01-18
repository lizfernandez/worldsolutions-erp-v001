package com.struts.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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
import com.dao.PoblacionDao;
import com.dao.ProveedorDao;
import com.entities.Estado;
import com.entities.Poblacion;
import com.entities.Proveedor;
import com.entities.Usuario;
import com.google.gson.Gson;
import com.struts.form.ProveedorForm;
import com.util.Fechas;
import com.util.Paginacion;
import com.util.Util;

public class ProveedorAction extends DispatchAction {
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
		public ActionForward listaProveedor(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
			/***Validamos la session activa y logeada***/
	     	String msn = "";
		/*	HttpSession sesion = request.getSession();
			
			if(sesion.getId()!=(sesion.getAttribute("id"))){
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
		
			/** Instanciamos la Clase ProveedorForm **/
			ProveedorForm objform = (ProveedorForm) form;
			

			/** Instanciamos las clase Daos **/
		
			ProveedorDao proveedorDao = new ProveedorDao();
			
			/**Seteamos los valores en las listas**/
			List<Proveedor> listaProveedor = proveedorDao.listaProveedor(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getProveedor());
			
	    
			/**Consultamos el total de registros segun criterio**/
			List<Proveedor> listaProveedorTotal = proveedorDao.listaProveedor(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getProveedor());
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaProveedorTotal.size()));
	 	      
			
			 
			/**Lista de personal en Modal Popup***/
			if(mode!=null && mode.equals("LP")){
				 msn ="showListPopup";
				
			}
			else{
				 
				/***Redirecionamos  al ***/
				 msn ="showList";
				
			}
			
			/** Seteamos las clase ProveedorForm **/
	        objform.setLista(listaProveedor);
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
		 * @throws IOException 
		 */
		public ActionForward cambioPoblacion(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response) throws IOException{
			response.setContentType("text/json");
			
		  // Type collectionType = new TypeToken<Object>(){}.getType();
			
			
			List<Poblacion> lista = new ArrayList<Poblacion>();
			
			String tipo = request.getParameter("tipo");
			String poblacion =request.getParameter("poblacion");
			
			PoblacionDao poblacionDao = new PoblacionDao();
			
			/*List<Poblacion>  listaProvincia = genericaDao.listaPoblacion("15");
			List<Poblacion>  listaDistrito = genericaDao.listaPoblacion("1405");					
			*/
			if(tipo.equals("DEP")){
	           String codigoDepartamento = poblacion.substring(0,2);
	           
	           lista = poblacionDao.listaProvincia(codigoDepartamento);
	           
	        }
	        else{
	        	String codigoProvincia = poblacion.substring(0,4);
	        	lista = poblacionDao.listaDistrito(codigoProvincia);
	        	 /*for(Poblacion objeto:listaDistrito ){
		        	   lista.add(objeto);
		           }*/
	        }
			
			
			
			Gson gson = new Gson();			
		
			String jsonOutput = gson.toJson(lista);
			//Object[] listPersona2 = {gson.fromJson(jsonOutput,collectionType )};
			//Poblacion[] listPersona2 = {gson.fromJson(jsonOutput,collectionType )};
			//System.out.println("listPersona2 ="+listPersona2);
			
			
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
		public ActionForward mantenimientoProveedor(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) {

			

			HttpSession sesion = request.getSession();			
			String mode = request.getParameter("mode");
			String msn="";
			
			
			
			/** Instantacia al ProveedorForm **/			
			ProveedorForm proveedorform = (ProveedorForm) form;
			
			/** Instantacia a la capa Dao **/
			EstadoDao estadoDao = new EstadoDao();
			GenericaDao proveedorDao = new GenericaDao();			
			PoblacionDao poblacionDao = new PoblacionDao();

			/** llamado de los metodos de la clase dao **/

			
			List<Estado> listaEstado = estadoDao.listEstado();
			List<Poblacion> listaDepartamento = poblacionDao.listaDepartamento();
			List<Poblacion> listaProvincia = new ArrayList<Poblacion>();// codigo de provincia lima
			List<Poblacion> listaDistrito =  new ArrayList<Poblacion>();// codigo distrito lima
	

			
			/**LLamamos al formulario mantenimientoProveedor.jsp para la insercion de datos **/
			if(mode.equals("I")){
				listaProvincia = poblacionDao.listaProvincia("14");// codigo de provincia lima
			    listaDistrito = poblacionDao.listaDistrito("1405");// codigo distrito lima
			    proveedorform.getProveedor().setcProveedorCodigo(proveedorDao.callSPCalculoCodigo(proveedorform.getProveedor()));

				msn ="showEdit";
			}
			
			/**LLamamos al formulario mantenimientoProveedor.jsp para mostrar los datos del UPDATE **/
			/** Seteamos el proveedorform la clase Proveedor **/
			else if(mode.equals("U") || mode.equals("D")){
				
				int id = Integer.parseInt(request.getParameter("id"));
				proveedorform.setProveedor(proveedorDao.findEndidad(proveedorform.getProveedor(),id));
				listaProvincia = poblacionDao.listaProvincia(String.valueOf(proveedorform.getiPoblacionId()).substring(0,2));// codigo de provincia lima
			    listaDistrito = poblacionDao.listaDistrito(String.valueOf(proveedorform.getiPoblacionId()).substring(0,4));// codigo distrito lima
			   
			    /**Departamento seleccionado **/
				Poblacion poblacionDe= poblacionDao.bucarPoblacion(String.valueOf(proveedorform.getiPoblacionId()).substring(0,2)+"0000");
				proveedorform.setvDepartamento(poblacionDe.getcCodigo());
				
				/**Provincia seleccionado **/
				Poblacion poblacioPro= poblacionDao.bucarPoblacion(String.valueOf(proveedorform.getiPoblacionId()).substring(0,4)+"00");
				proveedorform.setvProvincia(poblacioPro.getcCodigo())	;
				/**/
				msn ="showEdit";
				
			}
			/**LLamamos al formulario buscarMantenimientoPerfil.jsp para realizar la busqueda **/
			else if(mode.equals("F")){
				msn ="showFind";
			}
			
				proveedorform.setMode(mode);

			/** Colocamos en session las listas **/

			sesion.setAttribute("listaEstado", listaEstado);
			sesion.setAttribute("listaDepartamento", listaDepartamento);
			sesion.setAttribute("listaProvincia", listaProvincia);
			sesion.setAttribute("listaDistrito", listaDistrito);

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
		public ActionForward iduProveedor(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)  throws IllegalArgumentException, SecurityException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException, ParseException {
			
			/** Inicializamos las variables **/ 
			String msn = "";
			String mode = request.getParameter("mode");		
			String ids = request.getParameter("ids");		
			boolean resultado = false;
		
			/** Instanciamos las clase ProveedorForm y ProveedorDao **/
			HttpSession sesion = request.getSession();
			ProveedorForm pForm = (ProveedorForm) form;
			Proveedor obj =pForm.getProveedor();
			GenericaDao proveedorDao = new GenericaDao();
			Usuario usu = (Usuario) sesion.getAttribute("Usuario");
			
			
	        /** **/
			if (pForm.getMode().equals("I")) {
				
				obj.setdFechaInserta(Fechas.getDate());
				obj.setiUsuarioInsertaId(usu.getiUsuarioId());
				resultado = proveedorDao.insertarUnaEndidad(obj);
				
			} else if (pForm.getMode().equals("U")) {
				//Proveedor obj =pForm.getProveedor();
				
				obj = proveedorDao.findEndidad(pForm.getProveedor(), pForm.getProveedor().getiProveedorId());
				obj = Util.comparar(obj, pForm.getProveedor());
				
				obj.setdFechaActualiza(Fechas.getDate());
				obj.setiUsuarioModificaId(usu.getiUsuarioId());
				resultado = proveedorDao.actualizarUnaEndidad(obj);
				
			}
			else if (mode.equals("D")) { 
					EntityTransaction transaccion = proveedorDao.entityTransaction();
					transaccion.begin();
					proveedorDao.eliminarUnaEndidad(obj, "iProveedorId", ids);/**/
					resultado =  proveedorDao.commitEndidad(transaccion);

					//proveedorDao.refreshEndidad(obj);
				}
				
			if (resultado == true) {
				msn = "msnOk";

			}
			else  {
				msn = "msnError";

			}
			/** llamamos a listar Proveedor **/
			//listaProveedor(mapping, pForm, request, response);
			
			return mapping.findForward(msn);
		}
}
