//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.0/xslt/JavaClass.xsl

package com.struts.action;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import com.dao.CategoriaDao;
import com.dao.EstadoDao;
import com.dao.GenericaDao;
import com.dao.KardexDao;
import com.dao.ProductoDao;
import com.dao.UnidadMedidaDao;
import com.entities.Categoria;
import com.entities.Clasificacioncategoria;
import com.entities.Cuenta;

import com.entities.Estado;
import com.entities.Librodiario;
import com.entities.Preciosproducto;
import com.entities.Subcategoria;

import com.entities.Kardex;
import com.entities.Moneda;

import com.entities.Producto;

import com.entities.Unidadmedida;
import com.entities.Usuario;
import com.google.gson.Gson;
import com.struts.form.ProductosForm;
import com.util.Constantes;
import com.util.Fechas;
import com.util.FormatosNumeros;
import com.util.Paginacion;
import com.util.Util;


/**

 * MyEclipse Struts Creation date: 11-03-2004
 * 
 * XDoclet definition:
 * 
 * @struts:action path="/bookList" name="bookListForm" input="/jsp/bookList.jsp"
 *                scope="request"
 * @struts:action-forward name="/jsp/bookList.jsp" path="/jsp/bookList.jsp"
 */
public class ProductosAction extends DispatchAction {

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
	 * @throws ParseException 
	 */
	public ActionForward listaProducto(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {

		/***Validamos la session activa y logeada***/
		String msn = "";
		HttpSession sesion = request.getSession();	
	
		/***Inicializamos variables***/
		String mode = request.getParameter("mode");
		int  iclasificacionId = Integer.parseInt(request.getParameter("iclasificacionId"));
		
		int pagina = Paginacion.paginaInicial;
		int pagInicio = Paginacion.paginaInicial;
		if(request.getParameter("pagina")!= null){
			 pagina = Integer.parseInt(request.getParameter("pagina"));
		}
	
		/** Instanciamos la Clase ProductoForm **/
		
		ProductosForm productosForm = (ProductosForm) form;
		
	
		/** Instanciamos las clase Daos **/
		
		ProductoDao productoDao = new ProductoDao();
		//Producto producto = new Producto();
		
		
		/**
		 * iclasificacionId:
		 * 1: Mercaderia
		 * 2: Materia Prima
		 * 3: Suministros y Repuestos
		 * 4: Envases y embalajes
		 * 
		 * ***/
		switch (iclasificacionId) {
		 
        case 1:  msn ="showList";
                 break;
        case 2:  msn ="showListMateriaPrima";
                 break;
        case 3:  msn ="showListSuministros";
                 break;
        case 4:  msn ="showListEnvases";
                 break;        
       
       } 
		
		/**Lista de productos en Modal Popup Ventas***/
		 if(mode!=null && mode.equals("LP") || mode!=null && mode.equals("LPC")){
			 UnidadMedidaDao unidadMedidaDao = new UnidadMedidaDao();
			 List<Clasificacioncategoria> listaSubcategoria = Util.listaClasificacioncategoria();			 
			 List<Unidadmedida> listaUnidadMedida = unidadMedidaDao.listaUnidadMedida();
			 
			 sesion.setAttribute("listaClasificacioncategoria",listaSubcategoria);
			 sesion.setAttribute("listaUnidadMedida",listaUnidadMedida);
			 productosForm.setIclasificacionId(iclasificacionId);
			 if(mode.equals("LP")){
				 /**Lista de productos de ventas***/
			    msn ="showListPopupProducto";}
			 if(mode.equals("LPC")){
				 /**Lista de productos de compras***/
				 msn ="showListPopupProductoCompra";}
			
		}
		
	
		/**Seteamos los valores en las listas**/
		List<Producto> listaProductos =  productoDao.listaProducto(Paginacion.pagInicio(pagina),Paginacion.pagFin(), productosForm.getProducto(),iclasificacionId);
		
		/**Consultamos el total de registros segun criterio**/
		List<Producto> listaPerfilTotal = productoDao.listaProducto(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(), productosForm.getProducto(),iclasificacionId);
		
        /**Obtenemos el total del paginas***/
		List<Long> paginas = Paginacion.listPaginas((long)(listaPerfilTotal.size()));
		
		
		 
		 /** Seteamos las clase ProductoForm **/
		productosForm.setProduc(listaProductos);
		productosForm.setPaginas(paginas);
		productosForm.setPagInicio(pagina);
		
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
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public ActionForward listaKardex(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {

		/***Validamos la session activa y logeada***/
		String msn = "";
		/*HttpSession sesion = request.getSession();
		
		if(sesion.getId()!=(sesion.getAttribute("id"))){
			response.sendRedirect("login.do?metodo=logout");				
		}
		else{*/
		
		/***Inicializamos variables***/
		String mode = request.getParameter("mode");
		
		String cInsumo="";
		int pagina = Paginacion.paginaInicial;
		int pagInicio = Paginacion.paginaInicial;
		if(request.getParameter("pagina")!= null){
			 pagina = Integer.parseInt(request.getParameter("pagina"));
		}
	    int iProductoId = Integer.parseInt(request.getParameter("id"));
		/** Instanciamos la Clase ProductoForm **/
		ProductosForm productosForm = (ProductosForm) form;
		Producto obj = productosForm.getProducto();

		/** Instanciamos las clase Daos **/
		GenericaDao productoDao = new GenericaDao();
		KardexDao kardexDao = new KardexDao();
	
		//Producto producto = new Producto();
		
		
		
		/**Lista de productos Movimiento de Kardex***/
		 if(mode!=null && mode.equals("Kardex")){
			
			/**Obtenemos el id del producto para ver el detalle del kardex **/
		    obj.setiProductoId(iProductoId);
		    if(productosForm.getdFechaInicio()!=null && productosForm.getdFechaFin()!=null){
		    obj.setdFechaInserta(Fechas.fechaDate(productosForm.getdFechaInicio()));
		    obj.setdFechaActualiza(Fechas.fechaDate(productosForm.getdFechaFin()));
		    }
		    msn ="showListPopupProductoKardex";
			
		}

		/**Seteamos los valores en las listas**/
		List<Kardex> listaProductos =  kardexDao.listaKardex(Paginacion.pagInicio(pagina),Paginacion.pagFin(), productosForm.getProducto(),cInsumo);
		
		/**Consultamos el total de registros segun criterio**/
		List<Kardex> listaPerfilTotal = kardexDao.listaKardex(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(), productosForm.getProducto(),cInsumo);
		
        /**Obtenemos el total del paginas***/
		List<Long> paginas = Paginacion.listPaginas((long)(listaPerfilTotal.size()));
		
		
		 
		 /** Seteamos las clase ProductoForm **/
		productosForm.setProduc(listaProductos);
		productosForm.setProducto(productoDao.findEndidad(obj,iProductoId));
		productosForm.setPaginas(paginas);
		productosForm.setPagInicio(pagina);
		
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
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws IllegalArgumentException 
	 */
	public ActionForward mantenimientoProducto(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IllegalArgumentException, SecurityException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException {

		/***Inicializamos variable***/
		HttpSession sesion = request.getSession();
		String mode = request.getParameter("mode");
		int iclasificacionId =Integer.parseInt(request.getParameter("iclasificacionId"));
		
		String msn="";

		/***Instancioamos ProductosForm form***/
		ProductosForm productoForm = (ProductosForm) form;
		Moneda moneda = new Moneda();
		Categoria categoria = new Categoria();
		Clasificacioncategoria clasificacioncategoria = new Clasificacioncategoria();
		clasificacioncategoria.setiClasificacionId(iclasificacionId);
		categoria.setClasificacionCategoria(clasificacioncategoria);
		
		/** Instantacia a la capa Dao **/
		CategoriaDao categoriaDao = new CategoriaDao();
		UnidadMedidaDao unidadMedidaDao = new UnidadMedidaDao();
		EstadoDao estadoDao = new EstadoDao();
		GenericaDao genericoDao = new GenericaDao();
		
		
		/** llamado de los metodos de la clase dao **/
		List<Categoria> listaCategoria = categoriaDao.listaCategoria(categoria);	
		List<Subcategoria> listaSubCategoria = categoriaDao.listaSubcategoria(listaCategoria.get(0).getiCategoriaId());
		List<Unidadmedida> listaUnidadMedida = unidadMedidaDao.listaUnidadMedida();
		List<Estado> listaEstado = estadoDao.listEstado();
		List<Moneda> listaMoneda = genericoDao.listaEntidadGenerica(moneda);
		List<Preciosproducto> listaPrecio = new ArrayList<Preciosproducto>();
		
		/**LLamamos al formulario mantenimientoProducto.jsp para la insercion de datos **/
		/**
		 * iclasificacionId:
		 * 1: Mercaderia
		 * 2: Materia Prima
		 * 3: Suministros y Repuestos
		 * 4: Envases y embalajes
		 * 
		 * ***/
		switch (iclasificacionId) {

		case 1:
			msn = "showEdit";
			break;
		case 2:
			msn = "showEditMateriaPrima";
			break;
		case 3:
			msn = "showEditSuministros";
			break;
		case 4:
			msn = "showEditEnvases";
			break;

		}
		
		if(mode.equals("I")){
			/** Obtenemos le codigo correlativo del producto **/
			productoForm.getProducto().setcProductoCodigo(genericoDao.callSPCalculoCodigo(productoForm.getProducto()));
		
		/**LLamamos al formulario mantenimientoProducto.jsp para mostrar los datos del UPDATE **/
		/** Seteamos el PerfilForm la clase Perfil **/
		} else if(mode.equals("U") || mode.equals("D")){
	    	
			int id = Integer.parseInt(request.getParameter("id"));
			Producto pro = genericoDao.findEndidad(productoForm.getProducto(),id);
			productoForm.setProducto(pro);
			productoForm.setSizeIngresoproductodetalles(productoForm.getProducto().getIngresoproductodetalles().size());
			productoForm.setSizeVentaDetalles(productoForm.getProducto().getVentadetalles().size());
			
			
			listaSubCategoria = categoriaDao.listaSubcategoria(productoForm.getProducto().getCategoria().getiCategoriaId());
			
			
			if(pro.getPreciosproductodetallles()!=null){
				if(pro.getPreciosproductodetallles().size()>0){
				 for(Preciosproducto precioPro: pro.getPreciosproductodetallles()){
					 Preciosproducto preciosproducto = new Preciosproducto();	
					 preciosproducto.setiCantidadStock(precioPro.getiCantidadStock());
					 preciosproducto.setfPrecioCompra(precioPro.getfPrecioCompra());
					 preciosproducto.setfGanancia(precioPro.getfGanancia());
					 preciosproducto.setfDescuento(precioPro.getfDescuento());
					 preciosproducto.setfPrecioVenta(precioPro.getfPrecioVenta());
					 preciosproducto.setdFechaInserta(precioPro.getdFechaInserta());
					 preciosproducto.setcEstadoCodigo(precioPro.getcEstadoCodigo());
					
					listaPrecio.add(preciosproducto);
					
				 }
				}
				
		    }
		productoForm.setProduc(listaPrecio);
		sesion.setAttribute("listaPrecioProducto",new ArrayList<Preciosproducto>());
			
			
		}
		/**LLamamos al formulario buscarMantenimientoProducto.jsp para realizar la busqueda **/
		else if(mode.equals("F")){
			/**
			 * iclasificacionId:
			 * 1: Mercaderia
			 * 2: Materia Prima
			 * 3: Suministros y Repuestos
			 * 4: Envases y embalajes
			 * 
			 * ***/
			switch (iclasificacionId) {
			 
	        case 1:  msn ="showFind";
	                 break;
	        case 2:  msn ="showFindMateriaPrima";
	                 break;
	        case 3:  msn ="showFindSuministros";
	                 break;
	        case 4:  msn ="showFindEnvases";
	                 break;        
	       
	       } 
		}		
		
		productoForm.setMode(mode);
		productoForm.setIclasificacionId(iclasificacionId);

		/** Colocamos en session las listas **/
		sesion.setAttribute("listaUnidadMedida", listaUnidadMedida);
		sesion.setAttribute("listaCategoria", listaCategoria);
		sesion.setAttribute("listaSubCategoria", listaSubCategoria);		
		sesion.setAttribute("listaMoneda", listaMoneda);		
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
	 * @throws IOException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws IllegalArgumentException 
	 */
	public ActionForward iduProducto(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException, IllegalArgumentException, SecurityException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
		
		
		/** Inicializamos las variables **/ 
		String msn = "";
		String mode = request.getParameter("mode");		
		String ids = request.getParameter("ids");	
		
		boolean resultado = false;
		
		HttpSession sesion = request.getSession();
		/** Instanciamos las clase ProductoForm y ProductoDao **/
		Usuario usu = (Usuario) sesion.getAttribute("Usuario");
		int iPeriodoId = (Integer) sesion.getAttribute("iPeriodoId");
		ProductosForm pForm = (ProductosForm) form;
		Producto pro = pForm.getProducto();
		
		GenericaDao productoDao = new GenericaDao();	
		KardexDao kardexDao = new KardexDao();
		List<Preciosproducto> listaPrecios = new ArrayList<Preciosproducto>();
		
		
		/*** Instanciamos transacion ***/
		productoDao.entityTransaction().begin();
		
		/**Cargamos Foto **/
		if(pForm.getFoto()!=null){
		FormFile fichero = pForm.getFoto();
		String tipoContenido = fichero.getContentType();
		String nombre = fichero.getFileName();
		int tamanho = fichero.getFileSize();
		String filePath = request.getRealPath("/").toString();
		

		if ((tamanho>0)&&(!nombre.equals(""))){
			pro.setvFoto(pro.getcProductoCodigo()+"-"+nombre);
			if(!nombre.equals("")){
	
			File ficheroACrear = new File(filePath + File.separator + "media" + File.separator + "fotos" + File.separator +pro.getvFoto());
			System.out.println(filePath+"    /media/fotos/" +"   "+ficheroACrear.getPath()+" "+request.getPathInfo()+ " " +request.getServletPath());
			if(!ficheroACrear.exists()){				
					ficheroACrear.createNewFile();
					FileOutputStream fileOutStream = new FileOutputStream(ficheroACrear);
					fileOutStream.write(fichero.getFileData());
					fileOutStream.flush();
					fileOutStream.close();
					
			}
			
		
			   
			  }
		}
		}
        /**Insertamos Datos del producto **/
		if (pForm.getMode().equals("I")) {			
			pro.setdFechaInserta(Fechas.getDate());
			pro.setiUsuarioInsertaId(usu.getiUsuarioId());
			productoDao.persistEndidad(pro);
			
			/**Insertamos la existencia de un producto en el Kardex**/
			Kardex  kardex = new Kardex();
			kardex.setProducto(pro);
			kardex.setdFecha(Fechas.getDate());
			kardex.setvConcepto(Constantes.conceptoExistencia);
			kardex.setiCantExistencia(pro.getiProductoStockCantidad());
			kardex.setfPuExistencia(pro.getfProductoPrecioCompra());
			kardex.setfTotalExistencia(kardex.getiCantExistencia()*kardex.getfPuExistencia());
			kardex.setiUsuarioInsertaId(usu.getiUsuarioId());
			kardex.setdFechaInserta(Fechas.getDate());
			kardex.setcEstadoCodigo(Constantes.estadoActivo);
			kardex.setiPeriodoId(iPeriodoId);
			//listaKardexs.add(kardex);
			//pro.setKardexs(listaKardexs);
			productoDao.persistEndidad(kardex);
			
			
			 
			/******************************************/
			/**Insertamos detalle de lista de precios**/
			/******************************************/
			Preciosproducto preciosProducto = new Preciosproducto();
			preciosProducto.setcEstadoCodigo(Constantes.estadoActivo);
			preciosProducto.setdFechaInserta(Fechas.getDate());
			preciosProducto.setfGanancia(pro.getfProductoGanancia());
			preciosProducto.setfPrecioCompra(pro.getfProductoPrecioCompra());
			preciosProducto.setfPrecioVenta(pro.getfProductoPrecioVenta());
			preciosProducto.setiCantidadStock(pro.getiProductoStockCantidad());
			preciosProducto.setProducto(pro);
			preciosProducto.setfDescuento(pro.getfProductoDescuento());
			preciosProducto.setiUsuarioInsertaId(usu.getiUsuarioId());
			listaPrecios.add(preciosProducto);
			pro.setPreciosproductodetallles(listaPrecios);
			//resultado = productoDao.insertarEndidad(preciosProducto);
			
			
			/**Insertamos en el libro Dirio la cuenta de Mercaredia 
			 * 20(Mercaderia) y
			 * 201(Almacem)
			 * id=57; 201: mercaderia/ Almacen**/			
			Cuenta cuenta =  new Cuenta();			
			Librodiario libroDiario = new Librodiario();
			libroDiario.setcEstadoCodigo(Constantes.estadoActivo);
			libroDiario.setCuenta(productoDao.findEndidad(cuenta, 57));
			libroDiario.setfMonto(kardex.getiCantExistencia()*kardex.getfPuExistencia());
			libroDiario.setvTipoConcepto(Constantes.debe);
			libroDiario.setvConceptoGeneral("MERCADERIA / ALmacen ");
			libroDiario.setdFechaInserta(Fechas.getDate());
			libroDiario.setiUsuarioInsertaId(usu.getiUsuarioId());
			libroDiario.setKardex(kardex);
			libroDiario.setiPeriodoId(iPeriodoId);
			productoDao.persistEndidad(libroDiario);
			
			/**Insertamos en el libro Dirio la cuenta de Mercaredia 
			 * 50(Capital) y 
			 * '212', '5', '50', 'CAPITAL'**/			
			cuenta =  new Cuenta();			
			libroDiario = new Librodiario();
			libroDiario.setcEstadoCodigo(Constantes.estadoActivo);
			libroDiario.setCuenta(productoDao.findEndidad(cuenta, 212));
			libroDiario.setfMonto(kardex.getiCantExistencia()*kardex.getfPuExistencia());
			libroDiario.setvTipoConcepto(Constantes.haber);
			libroDiario.setvConceptoGeneral("CAPITAL ");
			libroDiario.setdFechaInserta(Fechas.getDate());
			libroDiario.setiUsuarioInsertaId(usu.getiUsuarioId());
			libroDiario.setKardex(kardex);
			libroDiario.setiPeriodoId(iPeriodoId);
			
			 productoDao.persistEndidad(libroDiario);
			 resultado = productoDao.commitEndidad(productoDao.entityTransaction());
			// productoDao.refreshEndidad(pro);
			
		} 
	    /**Insertamos Datos del producto como Insumos **/
		if (pForm.getMode().equals("II")) {			
			pro.setdFechaInserta(Fechas.getDate());
			pro.setiUsuarioInsertaId(usu.getiUsuarioId());			
			productoDao.persistEndidad(pro);
		    resultado = productoDao.commitEndidad(productoDao.entityTransaction());
		    productoDao.refreshEndidad(pro);
			
		}
		/**Insertamos Datos del producto y de insumo **/		
		else if (pForm.getMode().equals("U") || pForm.getMode().equals("UI")) {	
			
		    pro =  productoDao.findEndidad(pro,pForm.getProducto().getiProductoId());
		    pro= Util.comparar(pro, pForm.getProducto());
			try {
				pro.setdFechaActualiza(Fechas.getDate());
				pro.setiUsuarioActualizaId(usu.getiUsuarioId());
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/**Actualizamos o agregamos precios del producto, como tambien actualizaremos la cantidad del producto**/
			List<Preciosproducto> listaPrecio = (List<Preciosproducto>) sesion.getAttribute("listaPrecioProducto");			
			if(listaPrecio.size()>0){
				pro.setPreciosproductodetallles(listaPrecio);
				int cantidadProducto = 0;
				float precioVenta = (float) 0.0;
				float precioCompra = (float) 0.0;
				float fGanancia = (float) 0.0;
				float fDescuento = (float) 0.0;
				int i=0;
				   /***********************************************************************************/
	      		   /***Actualizamos la cantidad del producto en stock, el precio de compra y venta*****/	 
	      		   /*** Segun metodologia FIFO- Primero en entrar, Primero en Salir                  **/
	      		   /***********************************************************************************/
				  
	      			for(Preciosproducto objpreciosProducto:pro.getPreciosproductodetallles()){
	      				 if(objpreciosProducto.getiCantidadStock()>0 && objpreciosProducto.getcEstadoCodigo().equals(Constantes.estadoActivo)){					      					  
	      					 cantidadProducto =    cantidadProducto + objpreciosProducto.getiCantidadStock();
	      					 if(i==0){
	      					 precioCompra = objpreciosProducto.getfPrecioCompra();
	      					 precioVenta = objpreciosProducto.getfPrecioVenta();
	      					 fGanancia = objpreciosProducto.getfGanancia();
	      					 fDescuento= objpreciosProducto.getfDescuento();
	      					 }
	      				 }
	      			}
	      			pro.setiProductoStockCantidad(cantidadProducto);
	      			pro.setfProductoPrecioVenta(FormatosNumeros.redondedoDecimal(precioVenta));
	      			pro.setfProductoGanancia(fGanancia);     		      		
	      			pro.setfProductoPrecioCompra(precioCompra);
	      			pro.setfProductoDescuento(fDescuento);
			
			}
			/**Actualizamos los valores de la existencia del Kardex **/
			/**si no existe ningun tipo de movimiento (Compras o ventas)**/
			if(pForm.getSizeIngresoproductodetalles()==0 && pForm.getSizeVentaDetalles()==0){
				int iKardexId=0;
				List<Kardex> kardex = kardexDao.buscarKardexProducto(pro.getiProductoId());
				iKardexId=kardex.get(0).getiKardexId();
				kardex.get(0).setiCantExistencia(pro.getiProductoStockCantidad());
				kardex.get(0).setfPuExistencia(pro.getfProductoPrecioCompra());
			    kardex.get(0).setfTotalExistencia(kardex.get(0).getiCantExistencia()*kardex.get(0).getfPuExistencia());
				kardex.get(0).setiUsuarioActualizaId(usu.getiUsuarioId());
				kardex.get(0).setdFechaActualiza(Fechas.getDate());
				
				productoDao.mergeEndidad(kardex.get(0));
								
				/**Actualizamos los valores de la existencias del libro diario la cuenta de Mercaredia **/
				
				List<Librodiario> librodiario= kardexDao.buscarLibroDiarioKardex(iKardexId);
				for(Librodiario listaLibros:librodiario ){
					/**
					 * 20(Mercaderia) y
					 * 201(Almacem)
					 * id=57; 201: mercaderia/ Almacen**/	
					
					
					/**Insertamos en el libro Dirio la cuenta de Mercaredia 
					 * 50(Capital) y 
					 * '212', '5', '50', 'CAPITAL'**/
					
					listaLibros.setfMonto(kardex.get(0).getfTotalExistencia());
					listaLibros.setiUsuarioActualizaId(usu.getiUsuarioId());
					listaLibros.setdFechaActualiza(Fechas.getDate());
					
					productoDao.mergeEndidad(listaLibros);
				}
				
			
			}
			
			 productoDao.mergeEndidad(pro);
			 resultado = productoDao.commitEndidad(productoDao.entityTransaction());
			 productoDao.refreshEndidad(pro);
		}
		 else if (mode.equals("D")) { 	        	
				productoDao.eliminarUnaEndidad(pro, "iProductoId", ids);/**/
				resultado = productoDao.commitEndidad(productoDao.entityTransaction());
			}
		
		if (resultado == true) {
			msn = "msnOk";

		}
		else  {
			msn = "msnError";

		}
		/** llamamos a listar producto **/
		//listaProducto(mapping, pForm, request, response);
		
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
		public ActionForward detalleListaPrecios(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response) throws IOException{
      
			response.setContentType("text/json");	
			HttpSession sesion = request.getSession();
			
			Gson gson = new Gson();			
			GenericaDao genericaDao = new GenericaDao();
			
			
			int iProductoId = Integer.parseInt(request.getParameter("iProductoId"));
			int iPrecioProductoId = Integer.parseInt(request.getParameter("iPrecioProductoId"));	
			int iCantidadStock = Integer.parseInt(request.getParameter("iCantidadStock"));
			float  fPrecioCompra = Float.parseFloat(request.getParameter("fPrecioCompra"));
			float  fGanancia = Float.parseFloat(request.getParameter("fGanancia"));
			float  fDescuento = Float.parseFloat(request.getParameter("fDescuento"));
			float  fPrecioVenta = Float.parseFloat(request.getParameter("fPrecioVenta"));
			String  cEstadoCodigoPrecio = request.getParameter("cEstadoCodigoPrecio");
			
			
			
			
			String mode = request.getParameter("mode");
			
			/** Instanciamos la Clase VentaForm **/
		

			
			List<Preciosproducto> lista = (List<Preciosproducto>) sesion.getAttribute("listaPrecioProducto");
			
			
			Producto producto = new Producto();			
			Preciosproducto precioProducto  = new Preciosproducto();
			
			if(mode.equals("I")){
				Producto productoBean = genericaDao.findEndidad(producto, iProductoId);
				lista = productoBean.getPreciosproductodetallles();
				producto.setiProductoId(iProductoId);
				/**valores por defecto**/
			
				precioProducto.setProducto(producto);
				precioProducto.setiCantidadStock(iCantidadStock);
				precioProducto.setfPrecioCompra(fPrecioCompra);
				precioProducto.setfPrecioVenta(fPrecioVenta);
				precioProducto.setfGanancia(fGanancia);
				precioProducto.setfDescuento(fDescuento);
				precioProducto.setcEstadoCodigo(cEstadoCodigoPrecio);
				precioProducto.setdFechaInserta(Fechas.getDate());
				lista.add(precioProducto);
				sesion.setAttribute("listaPrecioProducto", lista);
			}
		
			 if(mode.equals("U")){
				 //  lista = producto.getPreciosproductodetallles();
				  
						   lista.get(iPrecioProductoId).setiCantidadStock(iCantidadStock);
						   lista.get(iPrecioProductoId).setfPrecioCompra(fPrecioCompra);
						   lista.get(iPrecioProductoId).setfPrecioVenta((fPrecioVenta));
						   lista.get(iPrecioProductoId).setfGanancia(fGanancia);
						   lista.get(iPrecioProductoId).setfDescuento(fDescuento);
						   lista.get(iPrecioProductoId).setcEstadoCodigo(cEstadoCodigoPrecio);		
						   lista.get(iPrecioProductoId).setdFechaInserta(Fechas.getDate());
						   sesion.setAttribute("listaPrecioProducto", lista);				   
			}
	     
			String jsonOutput = gson.toJson(lista);
			
			
			//response.getWriter().write(json);
			
			PrintWriter pw;
			pw = response.getWriter();
		
			pw.write(jsonOutput);
		
			System.out.println( jsonOutput.toString() );
			
			pw.flush();
			pw.close();
				
			
			return null;
			
		}
	
}