package com.struts.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityTransaction;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.dao.CategoriaDao;
import com.dao.ClasificacionCategoriaDao;
import com.dao.EstadoDao;
import com.dao.GenericaDao;
import com.entities.Categoria;
import com.entities.Clasificacioncategoria;
import com.entities.Estado;
import com.entities.Subcategoria;
import com.entities.Usuario;
import com.google.gson.Gson;
import com.struts.form.CategoriaForm;
import com.util.Fechas;
import com.util.Paginacion;
import com.util.Util;

public class CategoriaAction extends DispatchAction {
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
		public ActionForward listaCategoria(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
			/***Validamos la session activa y logeada***/
			String msn = "";
			/*HttpSession sesion = request.getSession();
			
			if(sesion.getId()!=(sesion.getAttribute("id"))){
				response.sendRedirect("login.do?metodo=logout");				
			}
			else{
				*/
			msn="showList";			
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if(request.getParameter("pagina")!= null){
				 pagina = Integer.parseInt(request.getParameter("pagina"));
			}
		
			/** Instanciamos la Clase CategoriaForm **/
			CategoriaForm objform = (CategoriaForm) form;
			
			Categoria categoria = objform.getCategoria();
			Clasificacioncategoria clasificacioncategoria = new Clasificacioncategoria();
			clasificacioncategoria.setiClasificacionId(objform.getiClasificacionId());
			
			categoria.setClasificacionCategoria(clasificacioncategoria);
			
			/** Instanciamos las clase Daos **/
			
			CategoriaDao categoriaDao = new CategoriaDao();
			
			/**Seteamos los valores en las listas**/
			List<Categoria> listaCategoria = categoriaDao.listaCategoria(Paginacion.pagInicio(pagina),Paginacion.pagFin(),categoria);
			
	    
			/**Consultamos el total de registros segun criterio**/
			List<Categoria> listaCategoriaTotal = categoriaDao.listaCategoria(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),categoria);
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaCategoriaTotal.size()));
	 	      
			/** Seteamos las clase CategoriaForm **/
	        objform.setLista(listaCategoria);
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
		public ActionForward mantenimientoCategoria(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) {

			

			HttpSession sesion = request.getSession();			
			String mode = request.getParameter("mode");
			String msn="";
			
			
			/** Instantacia al CategoriaForm **/			
			CategoriaForm categoriaform = (CategoriaForm) form;
			
			/** Instantacia a la capa Dao **/
			EstadoDao estadoDao = new EstadoDao();
			ClasificacionCategoriaDao clasificacionCategoriaDao = new ClasificacionCategoriaDao();
			GenericaDao categoriaDao = new GenericaDao();
			

			/** llamado de los metodos de la clase dao **/

			List<Estado> listaEstado = estadoDao.listEstado();
			List<Clasificacioncategoria> listaClasificacioncategoria = clasificacionCategoriaDao.listClasificacioncategorias();

			
			/**LLamamos al formulario mantenimientoCategoria.jsp para la insercion de datos **/
			if(mode.equals("I")){
				
				categoriaform.getCategoria().setcCategoriaCodigo(categoriaDao.callSPCalculoCodigo(categoriaform.getCategoria()));
				categoriaform.setiClasificacionId(listaClasificacioncategoria.get(0).getiClasificacionId());
				msn ="showEdit";
			}
			
			/**LLamamos al formulario mantenimientoCategoria.jsp para mostrar los datos del UPDATE **/
			/** Seteamos el categoriaform la clase Categoria **/
			else if(mode.equals("U") || mode.equals("D")){
				
				int id = Integer.parseInt(request.getParameter("id"));
				categoriaform.setCategoria(categoriaDao.findEndidad(categoriaform.getCategoria(),id));
				categoriaform.setiClasificacionId(categoriaform.getCategoria().getClasificacionCategoria().getiClasificacionId());
				msn ="showEdit";
				
			}
			/**LLamamos al formulario buscarMantenimientoPerfil.jsp para realizar la busqueda **/
			else if(mode.equals("F")){
				msn ="showFind";
			}
			
				categoriaform.setMode(mode);

			/** Colocamos en session las listas **/

			sesion.setAttribute("listaEstado", listaEstado);
			sesion.setAttribute("listaClasificacioncategoria",listaClasificacioncategoria);

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
		public ActionForward iduCategoria(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) {
			
			/** Inicializamos las variables **/ 
			String msn = "";
			String mode = request.getParameter("mode");		
			String ids = request.getParameter("ids");		
			boolean resultado = false;
		
			/** Instanciamos las clase CategoriaForm y CategoriaDao **/
			CategoriaForm pForm = (CategoriaForm) form;
			Categoria obj =pForm.getCategoria();
	
			
			GenericaDao categoriaDao = new GenericaDao();
			/****************************************/
			/** seteamos la entidades relacionadas **/
			/***************************************/
			 obj.setClasificacionCategoria(categoriaDao.findEndidad(new Clasificacioncategoria(), pForm.getiClasificacionId()));
			
	       
			if (pForm.getMode().equals("I")) {				
				obj.setdFechaInserta(Fechas.getDate());				
				resultado = categoriaDao.insertarUnaEndidad(obj);
				
			} else if (pForm.getMode().equals("U")) {
				 obj.setdFechaActualiza(Fechas.getDate());
				
				resultado = categoriaDao.actualizarUnaEndidad(obj);
				
			}
			else if (mode.equals("D")) { 
				EntityTransaction transaccion = categoriaDao.entityTransaction();
				transaccion.begin();
				categoriaDao.eliminarUnaEndidad(obj, "iCategoriaId",ids);/**/
				resultado = categoriaDao.commitEndidad(transaccion);
				}
				
			if (resultado == true) {
				msn = "msnOk";

			}
			else  {
				msn = "msnError";

			}
			/** llamamos a listar Categoria **/
			//listaCategoria(mapping, pForm, request, response);
			
			return mapping.findForward(msn);
		}
		/*****************/
		/**SUB CATEGORIA**/
		/*****************/
		
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
		public ActionForward listaSubCategoria(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException {
			/***Validamos la session activa y logeada***/
			String msn = "";
			
			msn="showListSubCategoria";			
			int pagina = Paginacion.paginaInicial;
			int pagInicio = Paginacion.paginaInicial;
			if(request.getParameter("pagina")!= null){
				 pagina = Integer.parseInt(request.getParameter("pagina"));
			}
		
			/** Instanciamos la Clase CategoriaForm **/
			CategoriaForm objform = (CategoriaForm) form;
			

			/** Instanciamos las clase Daos **/
			
			CategoriaDao categoriaDao = new CategoriaDao();
						
			/**Seteamos los valores en las listas**/
			List<Subcategoria> listaCategoria = categoriaDao.listaSubcategoria(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getSubCategoria());
			
	    
			/**Consultamos el total de registros segun criterio**/
			List<Subcategoria> listaCategoriaTotal = categoriaDao.listaSubcategoria(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getSubCategoria());
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaCategoriaTotal.size()));
	 	      
			/** Seteamos las clase CategoriaForm **/
	        objform.setLista(listaCategoria);
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
		public ActionForward mantenimientoSubCategoria(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) {

			

			HttpSession sesion = request.getSession();			
			String mode = request.getParameter("mode");
			String msn="";
			
			
			/** Instantacia al CategoriaForm **/			
			CategoriaForm categoriaform = (CategoriaForm) form;
			
			/** Instantacia a la capa Dao **/
			EstadoDao estadoDao = new EstadoDao();
			GenericaDao categoriaDao = new GenericaDao();

			/** llamado de los metodos de la clase dao **/

			List<Estado> listaEstado = estadoDao.listEstado();
			List<Categoria> listaCategoria = categoriaDao.listaEntidadGenerica(categoriaform.getCategoria());

			
			/**LLamamos al formulario mantenimientoCategoria.jsp para la insercion de datos **/
			if(mode.equals("I")){
				
				categoriaform.getSubCategoria().setcSubCategoriaCodigo(categoriaDao.callSPCalculoCodigo(categoriaform.getSubCategoria()));
				msn ="showEditSubCategoria";
			}
			
			/**LLamamos al formulario mantenimientoCategoria.jsp para mostrar los datos del UPDATE **/
			/** Seteamos el categoriaform la clase Categoria **/
			else if(mode.equals("U") || mode.equals("D")){
				
				int id = Integer.parseInt(request.getParameter("id"));
				categoriaform.setSubCategoria(categoriaDao.findEndidad(categoriaform.getSubCategoria(),id));
				categoriaform.setCategoria(categoriaform.getSubCategoria().getCategoria());
				msn ="showEditSubCategoria";
				
			}
			/**LLamamos al formulario buscarMantenimientoPerfil.jsp para realizar la busqueda **/
			else if(mode.equals("F")){
				msn ="showFindSubCategoria";
			}
			
				categoriaform.setMode(mode);

			/** Colocamos en session las listas **/

			sesion.setAttribute("listaEstado", listaEstado);
			sesion.setAttribute("listaCategoria",listaCategoria);

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
		 * @throws SecurityException 
		 * @throws IllegalAccessException 
		 * @throws IllegalArgumentException 
		 * @throws ClassNotFoundException 
		 */
		public ActionForward iduSubCategoria(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException {
			
			/** Inicializamos las variables **/ 
			String msn = "";
			String mode = request.getParameter("mode");		
			String ids = request.getParameter("ids");		
			boolean resultado = false;
		
			/** Instanciamos las clase CategoriaForm y CategoriaDao **/
			CategoriaForm pForm = (CategoriaForm) form;
			HttpSession sesion = request.getSession();
			/** Instanciamos las clase ProductoForm y ProductoDao **/
			Usuario usu = (Usuario) sesion.getAttribute("Usuario");
			
			GenericaDao categoriaDao = new GenericaDao();
			Subcategoria obj;
	        /** **/
			if (pForm.getMode().equals("I")) {			
				obj =pForm.getSubCategoria();
				obj.setCategoria(categoriaDao.findEndidad(new Categoria(), pForm.getiCategoriaId()));
				obj.setcEstadoCodigo(pForm.getcEstadoCodigo());
				obj.setdFechaInserta(Fechas.getDate());
				obj.setiUsuarioInsertaId(usu.getiUsuarioId());
				
				resultado = categoriaDao.insertarUnaEndidad(obj);
				
			} else if (pForm.getMode().equals("U")) {
				obj = categoriaDao.findEndidad(pForm.getSubCategoria(), pForm.getiSubCategoriaId());
				obj = Util.comparar(obj, pForm.getSubCategoria());

				obj.setCategoria(categoriaDao.findEndidad(new Categoria(), pForm.getiCategoriaId()));
				obj.setcEstadoCodigo(pForm.getcEstadoCodigo());
				obj.setdFechaActualiza(Fechas.getDate());
				obj.setiUsuarioActualizaId(usu.getiUsuarioId());
				resultado = categoriaDao.actualizarUnaEndidad(obj);
				
			}
			else if (mode.equals("D")) { 
				    EntityTransaction transaccion = categoriaDao.entityTransaction();
				    transaccion.begin();
					categoriaDao.eliminarUnaEndidad(new Subcategoria(), "iSubCategoriaId",ids);/**/
					resultado = categoriaDao.commitEndidad(transaccion);
				}
				
			if (resultado == true) {
				msn = "msnOk";

			}
			else  {
				msn = "msnError";

			}
			/** llamamos a listar Categoria **/
			//listaCategoria(mapping, pForm, request, response);
			
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
		public ActionForward cambioCategoria(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response) throws IOException{
			response.setContentType("text/json");
			
		  // Type collectionType = new TypeToken<Object>(){}.getType();
			
			
			List<Subcategoria> lista = new ArrayList<Subcategoria>();
			CategoriaDao categorriaDao = new CategoriaDao();
			
			int iCategoriaId = Integer.parseInt(request.getParameter("id"));			
			
	           lista = categorriaDao.listaSubcategoria(iCategoriaId);
	           
	        
			
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
		
	@SuppressWarnings("deprecation")
	public ActionForward exportarExcel(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws ParsePropertyException, InvalidFormatException, IOException {

		String plantilla = request.getParameter("plantilla");
		System.out.println("Plantilla solicitada [ " + plantilla + " ]");
		CategoriaForm objform = (CategoriaForm) form;
		
		
		String filePath = request.getRealPath("/").toString();
		String archivoPlantilla = filePath + File.separator + "plantillas"
				+ File.separator + "reportes" + File.separator
				+ "reporte-" + plantilla + ".xls";
		

		CategoriaDao categoriaDao = new CategoriaDao();
		Map<String, Object> beans = new HashMap<String, Object>();
		
		if ("categoria".equals(plantilla)) {
			List<Categoria> categorias = categoriaDao.listaCategoria(0, 1000, objform.getCategoria());
			beans.put("categorias", categorias);
			response.setHeader("content-disposition", "attachment;filename=reporte_categorias_" + Fechas.fechaConFormato("yyyyMMddHHmm") + ".xls");
		} else if ("sub-categoria".equals(plantilla)) {
			List<Subcategoria> subCategorias = categoriaDao.listaSubcategoria(0, 1000, objform.getSubCategoria());
			beans.put("subCategorias", subCategorias);
			
		}
		response.setHeader("content-disposition", "attachment;filename=reporte_" + plantilla + "_" + Fechas.fechaConFormato("yyyyMMddHHmm") + ".xls");
		
				
		response.setContentType("application/octet-stream");
		ServletOutputStream outputStream = response.getOutputStream();
		
		InputStream fis = new BufferedInputStream(new FileInputStream(archivoPlantilla));
		XLSTransformer transformer = new XLSTransformer();
		try {
			HSSFWorkbook workbook = (HSSFWorkbook) transformer.transformXLS(fis, beans);
			workbook.write(outputStream);
			fis.close();
			outputStream.flush();
			outputStream.close();
		} catch (ParsePropertyException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
		
}
