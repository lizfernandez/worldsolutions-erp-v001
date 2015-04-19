package com.struts.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
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

import com.dao.ClienteDao;
import com.dao.EstadoDao;
import com.dao.GenericaDao;
import com.dao.PoblacionDao;
import com.entities.Area;
import com.entities.Clasificacioncliente;
import com.entities.Cliente;
import com.entities.Direccioncliente;
import com.entities.Estado;
import com.entities.Poblacion;
import com.entities.Usuario;
import com.entities.Visitacliente;
import com.google.gson.Gson;
import com.struts.form.AreaForm;
import com.struts.form.ClienteForm;
import com.util.Constantes;
import com.util.Fechas;
import com.util.Paginacion;
import com.util.Util;

public class ClienteAction extends BaseAction {
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
		public ActionForward listaCliente(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException {

			/***Validamos la session activa y logeada***/
			String msn = "";
			/*HttpSession sesion = request.getSession();
			
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
		
			/** Instanciamos la Clase ClienteForm **/
			ClienteForm objform = (ClienteForm) form;
			

			/** Instanciamos las clase Daos **/
		
			ClienteDao clienteDao = new ClienteDao();
			
			/**Lista de personal en Modal Popup***/
			if(mode!=null && mode.equals("LP")){
				 msn ="showListPopup";
				
			}	
			else if(mode!=null && mode.equals("LPD")){
				
				int iClienteId = Integer.parseInt(request.getParameter("id"));
				objform.getCliente().setiClienteId(iClienteId);
					/**Lista de direcciones del cliente en Modal Popup***/
					
				 msn ="showListDireccionPopup";
			    }
			else{
				 
				/***Redirecionamos  al ***/
				 msn ="showList";
				
			}
			
			/**Seteamos los valores en las listas**/
			List<Cliente> listaCliente = clienteDao.listaCliente(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getCliente());
			
	    
			/**Consultamos el total de registros segun criterio**/
			List<Cliente> listaClienteTotal = clienteDao.listaCliente(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getCliente());
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaClienteTotal.size()));
	 	  			
			/** Seteamos las clase ClienteForm **/
	        objform.setLista(listaCliente);
	        objform.setPaginas(paginas);
	        objform.setPagInicio(pagina);
	       // }//else
			
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
		 * @throws IOException 
		 */
		
		public ActionForward cambioClasificacion(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response) throws IOException{
			response.setContentType("text/json");
			
		  // Type collectionType = new TypeToken<Object>(){}.getType();
			
			Clasificacioncliente clasificacion = new Clasificacioncliente();
			int iClasificacion = Integer.parseInt(request.getParameter("iClasificacion"));
			
			GenericaDao genericoDao = new GenericaDao();
			clasificacion = genericoDao.findEndidad(clasificacion, iClasificacion);
			
			
			Gson gson = new Gson();			
		
			String jsonOutput = gson.toJson(clasificacion);
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
		public ActionForward mantenimientoCliente(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) {

			

			HttpSession sesion = request.getSession();			
			String mode = request.getParameter("mode");
			String msn="";
			
			
			
			/** Instantacia al ClienteForm **/			
			ClienteForm clienteform = (ClienteForm) form;
			
			/** Instantacia a la capa Dao **/
			EstadoDao estadoDao = new EstadoDao();
			GenericaDao clienteDao = new GenericaDao();			
			PoblacionDao poblacionDao = new PoblacionDao();

			/** llamado de los metodos de la clase dao **/

			
			List<Estado> listaEstado = estadoDao.listEstado();
			List<Clasificacioncliente> listaClasificacion = clienteDao.listaEntidadGenerica(new Clasificacioncliente());
			List<Poblacion> listaDepartamento = poblacionDao.listaDepartamento();
			List<Poblacion> listaProvincia = new ArrayList<Poblacion>();// codigo de provincia lima
			List<Poblacion> listaDistrito =  new ArrayList<Poblacion>();// codigo distrito lima
		

			
			/**LLamamos al formulario mantenimientoCliente.jsp para la insercion de datos **/
			if(mode.equals("I")){
				listaProvincia = poblacionDao.listaProvincia("14");// codigo de provincia lima
			    listaDistrito = poblacionDao.listaDistrito("1405");// codigo distrito lima
			    
			    clienteform.getCliente().setvClienteCodigo(clienteDao.callSPCalculoCodigo(clienteform.getCliente()));
			    if(listaClasificacion.size()>0){
			    	clienteform.getCliente().setfDescuento(listaClasificacion.get(0).getfDescuento());
			    }
			    

				msn ="showEdit";
			}
			
			/**LLamamos al formulario mantenimientoCliente.jsp para mostrar los datos del UPDATE **/
			/** Seteamos el clienteform la clase Cliente **/
			else if(mode.equals("U") || mode.equals("D")){
				
				int id = Integer.parseInt(request.getParameter("id"));
				Cliente cliente = clienteDao.findEndidad(clienteform.getCliente(),id);
				clienteform.setCliente(cliente);
				
				for(Direccioncliente direccion:cliente.getDireccionclientes()){
					if(direccion.getvPrincipal().equals(Constantes.vPrincipal))
					{
						listaProvincia = poblacionDao.listaProvincia(String.valueOf(direccion.getiPoblacionId()).substring(0,2));// codigo de provincia lima
					    listaDistrito = poblacionDao.listaDistrito(String.valueOf(direccion.getiPoblacionId()).substring(0,4));// codigo distrito lima
					   
					    /**Departamento seleccionado **/
					    Poblacion poblacionDe= poblacionDao.bucarPoblacion(String.valueOf(direccion.getiPoblacionId()).substring(0,2)+"0000");
						clienteform.setvDepartamento(poblacionDe.getcCodigo());
						
						/**Provincia seleccionado **/
						Poblacion poblacioPro= poblacionDao.bucarPoblacion(String.valueOf(direccion.getiPoblacionId()).substring(0,4)+"00");
						clienteform.setvProvincia(poblacioPro.getcCodigo())	;	/**/
						clienteform.setvPrincipal(direccion.getvPrincipal());
						clienteform.setvDireccion(direccion.getvDireccion());
						clienteform.setiPoblacionId(direccion.getiPoblacionId());
						
					}
					/*Visitacliente visitaCliente = cliente.getVisitaCliente().get(0);
					clienteform.setdFechaVisista(Fechas.fechaDDMMYY(visitaCliente.getdFechaVisista()));
					clienteform.setdFecaProxVisita(Fechas.fechaDDMMYY(visitaCliente.getdFecaProxVisita()));
					clienteform.setvProductoOfrecido(visitaCliente.getvProductoOfrecido());
					clienteform.setfPrecioPactado(visitaCliente.getfPrecioPactado());
					clienteform.setvMotivoVisita(visitaCliente.getvMotivoVisita());
					clienteform.setvObservacion(visitaCliente.getvObservacion());*/
				}
			  	
				msn ="showEdit";
				
			}
			/**LLamamos al formulario buscarMantenimientoPerfil.jsp para realizar la busqueda **/
			else if(mode.equals("F")){
				msn ="showFind";
			}
			
				clienteform.setMode(mode);

			/** Colocamos en session las listas **/

			sesion.setAttribute("listaEstado", listaEstado);
			sesion.setAttribute("listaClasificacion", listaClasificacion);
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
		 * @throws NoSuchFieldException 
		 * @throws IllegalAccessException 
		 * @throws ClassNotFoundException 
		 * @throws SecurityException 
		 * @throws IllegalArgumentException 
		 * @throws ParseException 
		 */
	public ActionForward iduCliente(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IllegalArgumentException, SecurityException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException, ParseException {

		/** Inicializamos las variables **/
		HttpSession sesion = request.getSession();
		String msn = "";
		String mode = request.getParameter("mode");
		String ids = request.getParameter("ids");
		boolean resultado = false;

		/** Instanciamos las clase ClienteForm y ClienteDao **/
		ClienteForm pForm = (ClienteForm) form;
		Cliente obj = pForm.getCliente();
		Usuario usu = (Usuario) sesion.getAttribute("Usuario");
		GenericaDao clienteDao = new GenericaDao();

		/** Creamos un objeto de direccion cliente **/

		Direccioncliente direccion = new Direccioncliente();

		List<Direccioncliente> listaDirec = new ArrayList<Direccioncliente>();
		List<Visitacliente> listavisitaCliente = new ArrayList<Visitacliente>();

		direccion.setvDireccion(pForm.getvDireccion());
		direccion.setiPoblacionId(pForm.getiPoblacionId());
		direccion.setvReferencia(pForm.getvReferencia());
		direccion.setvPrincipal(pForm.getvPrincipal());
		direccion.setcEstadoCodigo(pForm.getcEstadoCodigo());
		listaDirec.add(direccion);

		/** visitas clientes **/
		/*
		 * visitacliente.setdFechaVisista(Fechas.fechaDate(pForm.getdFechaVisista
		 * ())); visitacliente.setdFecaProxVisita(Fechas.fechaDate(pForm.
		 * getdFecaProxVisita()));
		 * visitacliente.setvProductoOfrecido(pForm.getvProductoOfrecido());
		 * visitacliente.setfPrecioPactado(pForm.getfPrecioPactado());
		 * visitacliente.setvMotivoVisita(pForm.getvMotivoVisita());
		 * visitacliente.setvObservacion(pForm.getvObservacion());
		 * visitacliente.setCliente(obj);
		 * visitacliente.setdFechaInserta(Fechas.getDate());
		 * listavisitaCliente.add(visitacliente);
		 */

		/** **/
		if (pForm.getMode().equals("I")) {
			obj.setdFechaInserta(Fechas.getDate());
			direccion.setCliente(obj);
			direccion.setdFechaInserta(Fechas.getDate());
			direccion.setiUsuarioInsertaId(usu.getiUsuarioId());
			obj.setDireccionclientes(listaDirec);
			obj.setVisitaCliente(listavisitaCliente);
			obj.setiUsuarioInsertaId(usu.getiUsuarioId());
			obj.setClasificacion(pForm.getClasifCliente());
			resultado = clienteDao.insertarUnaEndidad(obj);

		} else if (pForm.getMode().equals("U")) {

			/**** Iniciamos el begin transaction ****/
			EntityTransaction transaction = null;
			try {
				transaction = clienteDao.entityTransaction();
				transaction.begin();
	
				obj = clienteDao.findEndidad(pForm.getCliente(), pForm.getCliente().getiClienteId());
				List<Direccioncliente> listaDireccion = obj.getDireccionclientes();
	
				obj = Util.comparar(obj, pForm.getCliente());
	
				/*** preparamos la instancia para la actualizacion **/
				obj.setdFechaActualiza(Fechas.getDate());
				direccion.setiUsuarioActualizaId(usu.getiUsuarioId());
				direccion.setCliente(obj);
	
				String accionDireccion = "";
				
				if (listaDireccion.size() > 0) {
					// Se debe validar que si el cliente solo tiene una direccion y esta es modificada a secundaria no debera realizarse la modificacion
					if (listaDireccion.size() == 1 && !direccion.getvPrincipal().equals(Constantes.vPrincipal)) {
						Direccioncliente direccionActual = listaDireccion.get(0);
						if (!direccionActual.equals(direccion)) {
							accionDireccion = "I";
						} else {
							System.out.println("No se puede modificar la direccion principal a secundaria");
						}
						
					} else if (direccion.getvPrincipal().equals(Constantes.vPrincipal)) {
						accionDireccion = "I";
						for (Direccioncliente direccionss : listaDireccion) {
							if (direccionss.getvPrincipal().equals(Constantes.vPrincipal)) {
								direccion.setIdireccionClienteId(direccionss.getIdireccionClienteId());
								direccion.setiUsuarioInsertaId(direccionss.getiUsuarioInsertaId());
								direccion.setdFechaInserta(direccionss.getdFechaInserta());
								direccion.setvReferencia(direccionss.getvReferencia());
								accionDireccion = "U";
								break;
							}
						}
						// for
						/*** preparamos la instancia para la actualizacion ***/
					
					} else {
						accionDireccion = "I";
						/* Si es una direccion secundaria se deberá verificar si la direccion ya existe 
						 * para confirmar si s debe actualizar o inseryar una nueva direccion
						 * 
						 */
						for (Direccioncliente direccionss : listaDireccion) {
							if (direccion.getvDireccion().equals(direccionss.getvDireccion())) {
								direccion.setIdireccionClienteId(direccionss.getIdireccionClienteId());
								direccion.setiUsuarioInsertaId(direccionss.getiUsuarioInsertaId());
								direccion.setdFechaInserta(direccionss.getdFechaInserta());
								direccion.setvReferencia(direccionss.getvReferencia());
								accionDireccion = "U";
								break;
							}
						}
					}
					
				} else {
					accionDireccion = "I";
				}
				
				if (accionDireccion.equals("I")) {
	
					direccion.setiUsuarioInsertaId(usu.getiUsuarioId());
					direccion.setdFechaInserta(Fechas.getDate());
					clienteDao.persistEndidad(direccion);
					obj.getDireccionclientes().add(direccion);
					
				} else if (accionDireccion.equals("U")) {
					// Si el boolean es false se considera que la direccion ya existe y será modificada
	
					direccion.setdFechaActualiza(Fechas.getDate());
					clienteDao.mergeEndidad(direccion);
				}
	
				clienteDao.mergeEndidad(obj);
				/**** Realizamos el commit de los cambios **/
				resultado = clienteDao.commitEndidad(transaction);
			} catch (Exception e) {
				e.printStackTrace();
				clienteDao.limpiarInstancia();
			} finally {
				transaction = null;
			}
		} else if (mode.equals("D")) {
			EntityTransaction transaction = null;
			try {
				transaction = clienteDao.entityTransaction();
				transaction.begin();
				clienteDao.eliminarUnaEndidad(obj, "iClienteId", ids);
				resultado = clienteDao.commitEndidad(transaction);
			} catch (Exception ex) {
				ex.printStackTrace();
				clienteDao.limpiarInstancia();
			} finally {
				transaction = null;
			}
		}

		if (resultado == true) {
			msn = "msnOk";
		} else {
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
	 */
	public ActionForward listaClasifCliente(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		/***Validamos la session activa y logeada***/
		String msn = "";
		/*HttpSession sesion = request.getSession();
		
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
	
		/** Instanciamos la Clase ClienteForm **/
		ClienteForm objform = (ClienteForm) form;
		

		/** Instanciamos las clase Daos **/
	
		ClienteDao clienteDao = new ClienteDao();
		 
		/***Redirecionamos  al ***/
		msn ="showListClasifCliente";
	   /**Seteamos los valores en las listas**/
		List<Clasificacioncliente> listaCliente = clienteDao.listaClasificacionCliente(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getClasifCliente());
		
    
		/**Consultamos el total de registros segun criterio**/
		List<Clasificacioncliente> listaClienteTotal = clienteDao.listaClasificacionCliente(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getClasifCliente());
		
        /**Obtenemos el total del paginas***/
		List<Long> paginas = Paginacion.listPaginas((long)(listaClienteTotal.size()));
 	  			
		/** Seteamos las clase ClienteForm **/
        objform.setLista(listaCliente);
        objform.setPaginas(paginas);
        objform.setPagInicio(pagina);
       // }//else
		
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
	public ActionForward mantenimientoClasifCliente(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		

		HttpSession sesion = request.getSession();			
		String mode = request.getParameter("mode");
		String msn="";
		
		
		/** Instantacia al AreaForm **/			
		ClienteForm clienteform = (ClienteForm) form;
		
		/** Instantacia a la capa Dao **/
		EstadoDao estadoDao = new EstadoDao();
		GenericaDao genericaDao = new GenericaDao();

		/** llamado de los metodos de la clase dao **/

		List<Estado> listaEstado = estadoDao.listEstado();

		 
		/**LLamamos al formulario mantenimientoArea.jsp para la insercion de datos **/
		if(mode.equals("I")){
			msn ="showEditClasifCliente";
		}
		
		/**LLamamos al formulario mantenimientoArea.jsp para mostrar los datos del UPDATE **/
		/** Seteamos el areaform la clase Area **/
		else if(mode.equals("U") || mode.equals("D")){
			
			int id = Integer.parseInt(request.getParameter("id"));
			clienteform.setClasifCliente((Clasificacioncliente) genericaDao.findEndidad(clienteform.getClasifCliente(), id));
			msn ="showEditClasifCliente";
			
		}
		/**LLamamos al formulario buscarMantenimientoPerfil.jsp para realizar la busqueda **/
		else if(mode.equals("F")){
			msn ="showFindClasifCliente";
		}
		
		clienteform.setMode(mode);

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
	public ActionForward iduClasificacionCliente(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		
		/** Inicializamos las variables **/ 
		String msn = "";
		String mode = request.getParameter("mode");		
		String ids = request.getParameter("ids");		
		boolean resultado = false;
	
		/** Instanciamos las clase AreaForm y AreaDao **/
		ClienteForm pForm = (ClienteForm) form;
		Clasificacioncliente obj =pForm.getClasifCliente();
		
		GenericaDao areaDao = new GenericaDao();
		
		if (pForm.getMode().equals("I")) {
			
				obj.setdFechaInserta(Fechas.getDate());
				resultado = areaDao.insertarUnaEndidad(obj);
			
		} else if (pForm.getMode().equals("U")) {
			
				obj.setdFechaActualiza(Fechas.getDate());
				resultado = areaDao.actualizarUnaEndidad(obj);
			
		}
		else if (mode.equals("D")) {
			EntityTransaction transaccion;
			try {
			    transaccion = areaDao.entityTransaction();
			    transaccion.begin();
				areaDao.eliminarUnaEndidad(obj, "iClasificacionClienteId",ids);/**/
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

	@Override
	public Map<String, Object> cargarContenidoExportar(ActionForm form,
			HttpServletRequest request, String plantilla) throws ParseException {

		ClienteForm objform = (ClienteForm) form;
		ClienteDao clienteDao = new ClienteDao();
		Map<String, Object> beans = new HashMap<String, Object>();

		List<Cliente> clientes = clienteDao.listaCliente(0, 1000, objform.getCliente());
		if ("cliente".equals(plantilla)) {
			beans.put("clientes", clientes);
		
		}
		
		return beans;
	}
	@Override
	public void cargarContenidoImprimir(ActionForm form,
			HttpServletRequest request, PrintWriter ps, int id) {
	}
	
}
