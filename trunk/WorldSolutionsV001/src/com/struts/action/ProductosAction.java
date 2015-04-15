//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.0/xslt/JavaClass.xsl

package com.struts.action;

import java.io.File;
import java.io.FileOutputStream;
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
import com.entities.Kardex;
import com.entities.Librodiario;
import com.entities.Moneda;
import com.entities.Personal;
import com.entities.Preciosproducto;
import com.entities.Produccion;
import com.entities.Producciondetalle;
import com.entities.Producto;
import com.entities.Subcategoria;
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
public class ProductosAction extends BaseAction {

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
        case 5:  msn ="showListServicios";
        	     break; 
       
       } 
		
		/**Lista de productos en Modal Popup Ventas***/
		/**LP=  lista de productos para ventas  **/
		/**LPC= lista de productos para compras **/
		/**LPS= lista de productos de servicios **/
		/**LPP= lista de productos de produccion **/
		 if(mode!=null && mode.equals("LP") || mode!=null && mode.equals("LPC") || mode!=null && mode.equals("LPS") 
				 || mode!=null && mode.equals("LPP")|| mode!=null && mode.equals("LPSP") || mode!=null && mode.equals("LPPU")){
			 UnidadMedidaDao unidadMedidaDao = new UnidadMedidaDao();
			 //Aqui se debera cambiar el método para solo cargar las categorias de los productos que son validos para vender.
			 List<Clasificacioncategoria> listaSubcategoria = productoDao.listaEntidadGenerica(new Clasificacioncategoria());		 
			 List<Unidadmedida> listaUnidadMedida = unidadMedidaDao.listaUnidadMedida();
			 
			 sesion.setAttribute("listaClasificacioncategoria",listaSubcategoria);
			 sesion.setAttribute("listaUnidadMedida",listaUnidadMedida);
			 productosForm.setIclasificacionId(iclasificacionId);
			 if(mode.equals("LP")){
				 /**Lista de productos de ventas***/
			    msn ="showListPopupProducto";}			 
			 
			 if(mode.equals("LPS")){
				 /**Lista de productos de para servicios***/
			    msn ="showListPopupServicios";}
			 if(mode.equals("LPC")){
				 /**Lista de productos de compras***/
				 msn ="showListPopupProductoCompra";}
			 if(mode.equals("LPP")){
				 /**Lista de productos para generar la produccion***/
				 msn ="showListPopupProductoProduccion";}
			 if(mode.equals("LPPU")){
				 /**Lista de productos existenta***/
				 msn ="showListPopupProductoExitProduccion";}
			
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
			if (productosForm.getdFechaInicio() != null && productosForm.getdFechaFin() != null) {
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
		
		List<Unidadmedida> listaUnidadMedida = unidadMedidaDao.listaUnidadMedida();
		List<Estado> listaEstado = estadoDao.listEstado();
		List<Moneda> listaMoneda = genericoDao.listaEntidadGenerica(moneda);
		List<Preciosproducto> listaPrecio = new ArrayList<Preciosproducto>();
		List<Subcategoria> listaSubCategoria = new ArrayList<Subcategoria>();
		 if(listaCategoria.size()>0){
			 listaSubCategoria = categoriaDao.listaSubcategoria(listaCategoria.get(0).getiCategoriaId());
		 }
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
		case 5:
			msn = "showEditServicios";
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
	        case 5:  msn ="showFindServicios";
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
		
		/**Cargamos Foto **/
		if (pForm.getFoto() != null) {
			FormFile fichero = pForm.getFoto();
			String nombre = fichero.getFileName();
			int tamanho = fichero.getFileSize();
			@SuppressWarnings("deprecation")
			String filePath = request.getRealPath("/").toString();

			if ((tamanho > 0) && (!nombre.equals(""))) {
				pro.setvFoto(pro.getcProductoCodigo() + "-" + nombre);
				if (!nombre.equals("")) {

					File ficheroACrear = new File(filePath + File.separator
							+ "media" + File.separator + "fotos"
							+ File.separator + pro.getvFoto());
					System.out.println(filePath + "    /media/fotos/" + "   "
							+ ficheroACrear.getPath() + " "
							+ request.getPathInfo() + " "
							+ request.getServletPath());
					if (!ficheroACrear.exists()) {
						ficheroACrear.createNewFile();
						FileOutputStream fileOutStream = new FileOutputStream(ficheroACrear);
						fileOutStream.write(fichero.getFileData());
						fileOutStream.flush();
						fileOutStream.close();

					}

				}
			}
		}
		EntityTransaction transaccion;
		try {
			transaccion = productoDao.entityTransaction();
			transaccion.begin();
			/** Insertamos Datos del producto **/
			if (pForm.getMode().equals("I")) {
				/** Se crea el registro del nuevo producto **/
				pro.setdFechaInserta(Fechas.getDate());
				pro.setiUsuarioInsertaId(usu.getiUsuarioId());
				productoDao.persistEndidad(pro);

				/** Insertamos la existencia de un producto en el Kardex **/
				Kardex kardex = new Kardex();
				kardex.setProducto(pro);
				kardex.setdFecha(Fechas.getDate());
				kardex.setvConcepto(Constantes.conceptoExistencia);
				kardex.setiCantExistencia(pro.getiProductoStockCantidad());
				kardex.setfPuExistencia(pro.getfProductoPrecioCompra());
				kardex.setfTotalExistencia(kardex.getiCantExistencia() * kardex.getfPuExistencia());
				kardex.setiUsuarioInsertaId(usu.getiUsuarioId());
				kardex.setdFechaInserta(Fechas.getDate());
				kardex.setcEstadoCodigo(Constantes.estadoActivo);
				kardex.setiPeriodoId(iPeriodoId);
				// listaKardexs.add(kardex);
				// pro.setKardexs(listaKardexs);
				productoDao.persistEndidad(kardex);

				/******************************************/
				/** Insertamos detalle de lista de precios **/
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
				// resultado = productoDao.insertarEndidad(preciosProducto);

				/**
				 * Insertamos en el libro Dirio la cuenta de Mercaredia
				 * 20(Mercaderia) y 201(Almacem) id=57; 201: mercaderia/ Almacen
				 **/
				Cuenta cuenta = new Cuenta();
				Librodiario libroDiario = new Librodiario();
				libroDiario.setcEstadoCodigo(Constantes.estadoActivo);
				libroDiario.setCuenta(productoDao.findEndidad(cuenta, 57));
				libroDiario.setfMonto(kardex.getiCantExistencia() * kardex.getfPuExistencia());
				libroDiario.setvTipoConcepto(Constantes.debe);
				libroDiario.setvConceptoGeneral("MERCADERIA / Almacen ");
				libroDiario.setdFechaInserta(Fechas.getDate());
				libroDiario.setiUsuarioInsertaId(usu.getiUsuarioId());
				libroDiario.setKardex(kardex);
				libroDiario.setiPeriodoId(iPeriodoId);
				productoDao.persistEndidad(libroDiario);

				/**
				 * Insertamos en el libro Dirio la cuenta de Mercaredia
				 * 50(Capital) y '212', '5', '50', 'CAPITAL'
				 **/
				cuenta = new Cuenta();
				libroDiario = new Librodiario();
				libroDiario.setcEstadoCodigo(Constantes.estadoActivo);
				libroDiario.setCuenta(productoDao.findEndidad(cuenta, 212));
				libroDiario.setfMonto(kardex.getiCantExistencia() * kardex.getfPuExistencia());
				libroDiario.setvTipoConcepto(Constantes.haber);
				libroDiario.setvConceptoGeneral("CAPITAL ");
				libroDiario.setdFechaInserta(Fechas.getDate());
				libroDiario.setiUsuarioInsertaId(usu.getiUsuarioId());
				libroDiario.setKardex(kardex);
				libroDiario.setiPeriodoId(iPeriodoId);

				productoDao.persistEndidad(libroDiario);
				resultado = productoDao.commitEndidad(transaccion);
				
				// productoDao.refreshEndidad(pro);

			}
			/** Insertamos Datos del producto como Insumos **/
			if (pForm.getMode().equals("II")) {
				pro.setdFechaInserta(Fechas.getDate());
				pro.setiUsuarioInsertaId(usu.getiUsuarioId());
				productoDao.persistEndidad(pro);
				resultado = productoDao.commitEndidad(transaccion);
				productoDao.refreshEndidad(pro);

			}
			/** Insertamos Datos del producto y de insumo **/
			else if (pForm.getMode().equals("U") || pForm.getMode().equals("UI")) {

				pro = productoDao.findEndidad(pro, pForm.getProducto().getiProductoId());
				pro = Util.comparar(pro, pForm.getProducto());			
				pro.setdFechaActualiza(Fechas.getDate());
				pro.setiUsuarioActualizaId(usu.getiUsuarioId());
			

				/**
				 * Actualizamos o agregamos precios del producto, como tambien
				 * actualizaremos la cantidad del producto
				 **/
				@SuppressWarnings("unchecked")
				List<Preciosproducto> listaPrecio = (List<Preciosproducto>) sesion.getAttribute("listaPrecioProducto");
				
				if (listaPrecio.size() > 0) {
					pro.setPreciosproductodetallles(listaPrecio);
					int cantidadProducto = 0;
					float precioVenta = (float) 0.0;
					float precioCompra = (float) 0.0;
					float fGanancia = (float) 0.0;
					float fDescuento = (float) 0.0;
					int i = 0;
					/***********************************************************************************/
					/***
					 * Actualizamos la cantidad del producto en stock, el precio
					 * de compra y venta
					 *****/
					/***
					 * Segun metodologia FIFO- Primero en entrar, Primero en
					 * Salir
					 **/
					/***********************************************************************************/

					for (Preciosproducto objpreciosProducto : pro.getPreciosproductodetallles()) {
						if (objpreciosProducto.getiCantidadStock() > 0 && objpreciosProducto.getcEstadoCodigo().equals(Constantes.estadoActivo)) {
							
							cantidadProducto = cantidadProducto + objpreciosProducto.getiCantidadStock();
							if (i == 0) {
								precioCompra = objpreciosProducto.getfPrecioCompra();
								precioVenta = objpreciosProducto.getfPrecioVenta();
								fGanancia = objpreciosProducto.getfGanancia();
								fDescuento = objpreciosProducto.getfDescuento();
							}
						}
					}
					pro.setiProductoStockCantidad(cantidadProducto);
					pro.setfProductoPrecioVenta(FormatosNumeros.redondedoDecimal(precioVenta));
					pro.setfProductoGanancia(fGanancia);
					pro.setfProductoPrecioCompra(precioCompra);
					pro.setfProductoDescuento(fDescuento);

				}
				/** Actualizamos los valores de la existencia del Kardex **/
				/** si no existe ningun tipo de movimiento (Compras o ventas) **/
				if (pForm.getSizeIngresoproductodetalles() == 0 && pForm.getSizeVentaDetalles() == 0) {
					
					int iKardexId = 0;
					List<Kardex> kardex = kardexDao.buscarKardexProducto(pro.getiProductoId());
					iKardexId = kardex.get(0).getiKardexId();
					kardex.get(0).setiCantExistencia(pro.getiProductoStockCantidad());
					kardex.get(0).setfPuExistencia(pro.getfProductoPrecioCompra());
					kardex.get(0).setfTotalExistencia(kardex.get(0).getiCantExistencia() * kardex.get(0).getfPuExistencia());
					kardex.get(0).setiUsuarioActualizaId(usu.getiUsuarioId());
					kardex.get(0).setdFechaActualiza(Fechas.getDate());

					productoDao.mergeEndidad(kardex.get(0));

					/**
					 * Actualizamos los valores de la existencias del libro
					 * diario la cuenta de Mercaredia
					 **/

					List<Librodiario> librodiario = kardexDao.buscarLibroDiarioKardex(iKardexId);
					for (Librodiario listaLibros : librodiario) {
						/**
						 * 20(Mercaderia) y 201(Almacem) id=57; 201: mercaderia/
						 * Almacen
						 **/

						/**
						 * Insertamos en el libro Dirio la cuenta de Mercaredia
						 * 50(Capital) y '212', '5', '50', 'CAPITAL'
						 **/

						listaLibros.setfMonto(kardex.get(0).getfTotalExistencia());
						listaLibros.setiUsuarioActualizaId(usu.getiUsuarioId());
						listaLibros.setdFechaActualiza(Fechas.getDate());

						productoDao.mergeEndidad(listaLibros);
					}

				}

				productoDao.mergeEndidad(pro);
				resultado = productoDao.commitEndidad(transaccion);
				//productoDao.refreshEndidad(pro);
			} else if (mode.equals("D")) {
				productoDao.eliminarUnaEndidad(pro, "iProductoId", ids);/**/
				resultado = productoDao.commitEndidad(transaccion);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			productoDao.limpiarInstancia();
		}
		finally {
			transaccion = null;
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
		@SuppressWarnings("unchecked")
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
		public ActionForward listaProduccion(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {

			/***Validamos la session activa y logeada***/
			String msn = "";
			HttpSession sesion = request.getSession();	
		
			/***Inicializamos variables***/
			String mode = request.getParameter("mode");
			//int  iclasificacionId = Integer.parseInt(request.getParameter("iclasificacionId"));
			
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
			
			
			
		
			/**Seteamos los valores en las listas**/
			List<Produccion> listaProducccion =  productoDao.listaProduccion(Paginacion.pagInicio(pagina),Paginacion.pagFin(), productosForm.getProduccion());
			
			/**Consultamos el total de registros segun criterio**/
			List<Produccion> listaProducccionTotal =  productoDao.listaProduccion(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(), productosForm.getProduccion());
			
	        /**Obtenemos el total del paginas***/
			List<Long> paginas = Paginacion.listPaginas((long)(listaProducccionTotal.size()));
			
			
			 
			 /** Seteamos las clase ProductoForm **/
			productosForm.setProduc(listaProducccion);
			productosForm.setPaginas(paginas);
			productosForm.setPagInicio(pagina);
			
			msn="showListProduccion";
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
		public ActionForward mantenimientoProduccion(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws IllegalArgumentException, SecurityException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException {

			/***Inicializamos variable***/
			HttpSession sesion = request.getSession();
			String mode = request.getParameter("mode");
		//	int iclasificacionId =Integer.parseInt(request.getParameter("iclasificacionId"));
			
			String msn="";

			/***Instancioamos ProductosForm form***/
			ProductosForm productoForm = (ProductosForm) form;
			Moneda moneda = new Moneda();
				
			/** Instantacia a la capa Dao **/
			CategoriaDao categoriaDao = new CategoriaDao();
			UnidadMedidaDao unidadMedidaDao = new UnidadMedidaDao();
			EstadoDao estadoDao = new EstadoDao();
			GenericaDao genericoDao = new GenericaDao();
			
			
			/** llamado de los metodos de la clase dao **/
			List<Categoria> listaCategoria = categoriaDao.listaEntidadGenerica(new Categoria());	
			List<Subcategoria> listaSubCategoria = categoriaDao.listaSubcategoria(listaCategoria.get(0).getiCategoriaId());
			List<Unidadmedida> listaUnidadMedida = unidadMedidaDao.listaUnidadMedida();
			List<Estado> listaEstado = estadoDao.listEstado();
			List<Moneda> listaMoneda = genericoDao.listaEntidadGenerica(moneda);
			List<Preciosproducto> listaPrecio = new ArrayList<Preciosproducto>();
			List<Producciondetalle> listaProduccion = new ArrayList<Producciondetalle>();
			
			
			msn = "showEditProduccion";
				
			
			if(mode.equals("I")){
				/** Obtenemos le codigo correlativo del producto **/
				productoForm.getProducto().setcProductoCodigo(genericoDao.callSPCalculoCodigo(productoForm.getProducto()));
				/***LISTA DE DETALLE VENTA***/
				sesion.removeAttribute("listaProduccionDetalle");
				if(sesion.getAttribute("listaProduccionDetalle")==null){				
					 sesion.setAttribute("listaProduccionDetalle", listaProduccion);
                 }
			
			/**LLamamos al formulario mantenimientoProducto.jsp para mostrar los datos del UPDATE **/
			/** Seteamos el PerfilForm la clase Perfil **/
			} else if(mode.equals("U") || mode.equals("D")){
		    	
				int id = Integer.parseInt(request.getParameter("id"));
				Produccion produccion = genericoDao.findEndidad(productoForm.getProduccion(),id);
				productoForm.setProduccion(produccion);
				
				
				for(Producciondetalle produce:produccion.getProduccionDetalle()){
					Producto pro = new Producto();
					Personal pers = new Personal();
					Produccion produc= new Produccion();
					Producciondetalle prodetalle= new Producciondetalle();
					prodetalle.setiProduccionDetalleId(produce.getiProduccionDetalleId());
					prodetalle.setvDescripcion(produce.getvDescripcion());
					prodetalle.setcEstadoCodigo(produce.getcEstadoCodigo());
					prodetalle.setfCostoUni(produce.getfCostoUni());
					prodetalle.setfDescuento(produce.getfDescuento());
					prodetalle.setfTotal(produce.getfTotal());
					prodetalle.setiCantidad(produce.getiCantidad());
					
					produc.setcEstadoCodigo(produce.getProduccion().getcEstadoCodigo());
					produc.setfCostoTotal(produce.getProduccion().getfCostoTotal());
					produc.setfCostoUni(produce.getProduccion().getfCostoUni());
					produc.setfOtrosCostos(produce.getProduccion().getfOtrosCostos());
					produc.setiCantidad(produce.getProduccion().getiCantidad());
					produc.setiProduccionId(produce.getProduccion().getiProduccionId());
					
					prodetalle.setProduccion(produc);
					
					pro.setCategoria(produce.getProducto().getCategoria());
					pro.setcProductoCodigo(produce.getProducto().getcProductoCodigo());
					pro.setfProductoDescuento(produce.getProducto().getfProductoDescuento());
					pro.setfProductoPrecioCompra(produce.getProducto().getfProductoPrecioCompra());
					pro.setiProductoId(produce.getProducto().getiProductoId());
					pro.setiProductoStockCantidad(produce.getProducto().getiProductoStockCantidad());
					pro.setMoneda(produce.getProducto().getMoneda());
					pro.setUnidadMedida(produce.getProducto().getUnidadMedida());
					pro.setvProductoNombre(produce.getProducto().getvProductoNombre());
					
					prodetalle.setProducto(pro);
					if(produce.getPersonal()!=null){
						pers.setcPersonalCodigo(produce.getPersonal().getcPersonalCodigo());
						pers.setiPersonalId(produce.getPersonal().getiPersonalId());
						pers.setvPersonalNombres(produce.getPersonal().getvPersonalNombres());
						pers.setvPersonalApellidoPaterno(produce.getPersonal().getvPersonalApellidoPaterno());
						pers.setvPersonalApellidoMaterno(produce.getPersonal().getvPersonalApellidoMaterno());
						prodetalle.setPersonal(pers);
					}
					
					
					
					listaProduccion.add(prodetalle);
				}
				
				sesion.setAttribute("listaProduccionDetalle", listaProduccion);
				
				
				
				
				Producto pro = genericoDao.findEndidad(productoForm.getProducto(),produccion.getProducto().get(0).getiProductoId());
				productoForm.setProducto(pro);
				productoForm.setSizeIngresoproductodetalles(productoForm.getProducto().getIngresoproductodetalles().size());
				productoForm.setSizeVentaDetalles(productoForm.getProducto().getVentadetalles().size());
				
				
				listaSubCategoria = categoriaDao.listaSubcategoria(pro.getCategoria().getiCategoriaId());
				
				
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
				 msn ="showFindProduccion";
	                    
		       
		        
			}		
			
			productoForm.setMode(mode);
		

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
		@SuppressWarnings({ "unchecked", "deprecation" })
		public ActionForward iduProduccion(ActionMapping mapping, ActionForm form,
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
			Produccion produBean = pForm.getProduccion();
			
			GenericaDao productoDao = new GenericaDao();	
			KardexDao kardexDao = new KardexDao();
			List<Preciosproducto> listaPrecios = new ArrayList<Preciosproducto>();
			List<Producciondetalle> listaProduccion= new ArrayList<Producciondetalle>();
			List<Kardex> listaKadex = new ArrayList<Kardex>();
			EntityTransaction transaccion = null;
			
			try {
				
			
			/*** Instanciamos transacion ***/
				transaccion = productoDao.entityTransaction();
			transaccion.begin();
			
			/**Cargamos Foto **/
			if(pForm.getFoto()!=null){
			FormFile fichero = pForm.getFoto();
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
				
				/******************************************/
				/**Insertamos la gestion de la produccion**/
				/******************************************/
				produBean.setdFechaInserta(Fechas.getDate());
				produBean.setiUsuarioInsertaId(usu.getiUsuarioId());
				productoDao.persistEndidad(produBean);
				
				/***********************************/
				/** Registro de producto**/
				/***********************************/			
				pro.setProduccion(produBean);			
				pro.setdFechaInserta(Fechas.getDate());
				pro.setiUsuarioInsertaId(usu.getiUsuarioId());
				productoDao.persistEndidad(pro);
				
				/***********************************/
				/** Registro de produccion detalle**/
				/***********************************/
				listaProduccion = (List<Producciondetalle>) sesion.getAttribute("listaProduccionDetalle");	
				for(Producciondetalle prodeta:listaProduccion){
					if(prodeta.getcEstadoCodigo().equals(Constantes.estadoActivo)){
				
					prodeta.setProduccion(produBean);
					productoDao.persistEndidad(prodeta);
					
					/*****************************************/
					/** Reducimos el stock de los materiales**/
					/*****************************************/
					int cantidad;
					Producto material= new Producto();
					    material= productoDao.findEndidad(material, prodeta.getProducto().getiProductoId()) ;
					    cantidad= material.getiProductoStockCantidad()-prodeta.getiCantidad();
					    material.setiProductoStockCantidad(cantidad); 
					    productoDao.mergeEndidad(material);
					}
					
				}
				
				
					
				/***********************************/
				/** Registro de producto**/
				/***********************************/			
				pro.setProduccion(produBean);			
				pro.setdFechaInserta(Fechas.getDate());
				pro.setiUsuarioInsertaId(usu.getiUsuarioId());
				productoDao.persistEndidad(pro);
				
				/**Insertamos la existencia de un producto en el Kardex**/
				Kardex  kardex = new Kardex();
				kardex.setProducto(pro);
				kardex.setdFecha(Fechas.getDate());
				kardex.setvConcepto(Constantes.conceptoProduccion);
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
				
						
				 productoDao.persistEndidad(libroDiario);
				 resultado = productoDao.commitEndidad(transaccion);
				// productoDao.refreshEndidad(pro);
				
			} 
		    /**Insertamos Datos del producto como Insumos **/
			if (pForm.getMode().equals("II")) {			
				pro.setdFechaInserta(Fechas.getDate());
				pro.setiUsuarioInsertaId(usu.getiUsuarioId());			
				productoDao.persistEndidad(pro);
			    resultado = productoDao.commitEndidad(transaccion);
			    productoDao.refreshEndidad(pro);
				
			}
			/**Insertamos Datos del producto y de insumo **/		
			else if (pForm.getMode().equals("U") || pForm.getMode().equals("UI")) {	
				
				/******************************************/
				/**Insertamos la gestion de la produccion**/
				/******************************************/
				Produccion produccion= new Produccion();
				produccion =  productoDao.findEndidad(produccion,produBean.getiProduccionId());
				produccion= Util.comparar(produccion, produBean);
				produccion.setdFechaActualiza(Fechas.getDate());
				produccion.setiUsuarioActualiza(usu.getiUsuarioId());
				
				productoDao.mergeEndidad(produccion);
				
				/***********************************/
				/** Registro de producto**/
				/***********************************/		
				 pro =  productoDao.findEndidad(pro,pForm.getProducto().getiProductoId());
				 pro= Util.comparar(pro, pForm.getProducto());				
				 pro.setdFechaActualiza(Fechas.getDate());
				 pro.setiUsuarioActualizaId(usu.getiUsuarioId());
				 
				 productoDao.mergeEndidad(pro);
				
				/***********************************/
				/** Registro de produccion detalle**/
				/***********************************/
				listaProduccion = (List<Producciondetalle>) sesion.getAttribute("listaProduccionDetalle");
			    Producciondetalle proDeOriginal= new Producciondetalle();
			    Producto material= new Producto();
			    int cantidad;
			    
				for(Producciondetalle prodeta:listaProduccion){
					if(prodeta.getcEstadoCodigo().equals(Constantes.estadoActivo)){
				
				
					
					/*****************************************/
					/** Reducimos el stock de los materiales**/
					/*****************************************/
					    
					    material= productoDao.findEndidad(material, prodeta.getProducto().getiProductoId()) ;					    
					   
					    if(prodeta.getiProduccionDetalleId()>0){
					    	/// exite producto  en el detalle original y se cambia la cantidad
					    	proDeOriginal= productoDao.findEndidadBD(proDeOriginal,"iProduccionDetalleId", prodeta.getiProduccionDetalleId());
					    	cantidad= proDeOriginal.getiCantidad()-prodeta.getiCantidad()+material.getiProductoStockCantidad();
					    }
					    else{
					    	// cuando se agrega nueva materia prima
					    	cantidad= material.getiProductoStockCantidad()-prodeta.getiCantidad();
					    }
					    material.setiProductoStockCantidad(cantidad); 
					  
					}
					
					if(prodeta.getiProduccionDetalleId()>0 && prodeta.getcEstadoCodigo().equals(Constantes.estadoInactivo)){
						cantidad= material.getiProductoStockCantidad()+prodeta.getiCantidad();
					}
					/// actualizamos cantidad
					  productoDao.mergeEndidad(material);						
						prodeta.setProduccion(produccion);
						productoDao.mergeEndidad(prodeta);
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
				 resultado = productoDao.commitEndidad(transaccion);
				 productoDao.refreshEndidad(pro);
			}
			 else if (mode.equals("D")) { 	        	
					productoDao.eliminarUnaEndidad(pro, "iProductoId", ids);/**/
					resultado = productoDao.commitEndidad(transaccion);
				}
			
			if (resultado == true) {
				msn = "msnOk";

			}
			else  {
				msn = "msnError";

			}
			} catch (Exception ex) {
				ex.printStackTrace();
				productoDao.limpiarInstancia();
				//transaccion = null;
				
			}finally {
				
				transaccion= null;
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
			@SuppressWarnings("unchecked")
			public ActionForward detalleProduccion(ActionMapping mapping, ActionForm form,
						HttpServletRequest request, HttpServletResponse response) throws IOException{
	      
				response.setContentType("text/json");	
				HttpSession sesion = request.getSession();
				
				Gson gson = new Gson();			
				GenericaDao genericaDao = new GenericaDao();
				int iProductoId = Integer.parseInt(request.getParameter("id"));
				String mode = request.getParameter("mode");
				
				/** Instanciamos la Clase VentaForm **/
			
				
				List<Producciondetalle> lista = (List<Producciondetalle>) sesion.getAttribute("listaProduccionDetalle");
				
				
				Producto productoBean= new Producto();			
				Producciondetalle producciondetalle  = new Producciondetalle();
				if(mode.equals("U")){
					
					    int iCantidad = Integer.parseInt(request.getParameter("iCantidad"));					    
						float fPrecioCompra = Float.parseFloat(request.getParameter("fPrecioCompra"));	
						float fDescuento = Float.parseFloat(request.getParameter("fDescuento"));					
						float fPrecioCompraFinal = (fPrecioCompra-fPrecioCompra*fDescuento/100);
						
				
					   lista.get(iProductoId).setfCostoUni(fPrecioCompra);
					   lista.get(iProductoId).setfTotal((iCantidad*fPrecioCompraFinal));
					   lista.get(iProductoId).setiCantidad(iCantidad);
					  
				
					   
				
					   sesion.setAttribute("listaIngresoProductoDetalle", lista);
					   
				}
				if(mode.equals("I")){
					
					int iCantidad = Integer.parseInt(request.getParameter("iCantidad"));	
					float fPrecioCompra = Float.parseFloat(request.getParameter("fPrecioCompra"));	
					float fDescuento = Float.parseFloat(request.getParameter("fDescuento"));
					float fGanancia = Float.parseFloat(request.getParameter("fGanancia"));					
					float fPrecioVenta = Float.parseFloat(request.getParameter("fPrecioVenta"));
					float fTotal = Float.parseFloat(request.getParameter("fTotal"));
					int iPersonalId = Integer.parseInt(request.getParameter("iPersonalId"));
					
					Producto producto  = genericaDao.findEndidad(productoBean,iProductoId);	
					
					productoBean.setiProductoId(producto.getiProductoId());
					productoBean.setcProductoCodigo(producto.getcProductoCodigo());
					productoBean.setvProductoNombre(producto.getvProductoNombre());
					productoBean.setUnidadMedida(producto.getUnidadMedida());
					productoBean.setvProductoCapacidad(producto.getvProductoCapacidad());
					productoBean.setfProductoGanancia(fGanancia);
					productoBean.setfProductoPrecioVenta(fPrecioVenta);
					productoBean.setiProductoStockCantidad(producto.getiProductoStockCantidad());
					producciondetalle.setvDescripcion(productoBean.getvProductoNombre());
					
					if(iPersonalId>0){
						Personal personalBean= new Personal();
						Personal personal= new Personal();
						personal=genericaDao.findEndidad(personal,iPersonalId);	
						personalBean.setiPersonalId(personal.getiPersonalId());
						personalBean.setvPersonalNombres(personal.getvPersonalNombres());
						personalBean.setvPersonalApellidoPaterno(personal.getvPersonalApellidoPaterno());
						producciondetalle.setvDescripcion(personalBean.getvPersonalNombres()+" "+personalBean.getvPersonalApellidoPaterno());
						
						producciondetalle.setPersonal(personalBean);
					}
					
					producciondetalle.setProducto(productoBean);
					producciondetalle.setcEstadoCodigo(Constantes.estadoActivo);
					producciondetalle.setiCantidad(iCantidad);
					producciondetalle.setfCostoUni(fPrecioCompra);
					producciondetalle.setfTotal(fTotal);
					producciondetalle.setfDescuento(fDescuento);
					
				
					
					lista.add(producciondetalle);
					sesion.setAttribute("listaProduccionDetalle", lista);
				}
				 if(mode.equals("D")){
					 //  lista.remove(iProductoId);
					 if(lista.get(iProductoId).getcEstadoCodigo().equals(Constantes.estadoActivo))
						 lista.get(iProductoId).setcEstadoCodigo(Constantes.estadoInactivo);
					 else
						 lista.get(iProductoId).setcEstadoCodigo(Constantes.estadoActivo);
					   
					   sesion.setAttribute("listaProduccionDetalle", lista);
					   
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


			@Override
			public Map<String, Object> cargarContenidoExportar(ActionForm form,
					HttpServletRequest request, String plantilla) throws ParseException {

			ProductosForm objform = (ProductosForm) form;
			Producto obj = objform.getProducto();
			
			ProductoDao productoDao = new ProductoDao();
			KardexDao kardexDao = new KardexDao();  
			
			Map<String, Object> beans = new HashMap<String, Object>();
			List<Producto> productos = null;
			List<Kardex> listaKardex = null;
			if (!"producto-kardex".equals(plantilla)) {
				int  iclasificacionId = Integer.parseInt(request.getParameter("iclasificacionId"));
				productos = productoDao.listaProducto(0, 1000, obj, iclasificacionId);
			} else {
				int iProductoId = Integer.parseInt(request.getParameter("id"));
				String cInsumo = "";
				obj.setiProductoId(iProductoId);
				if (objform.getdFechaInicio() != null && objform.getdFechaFin() != null) {
					obj.setdFechaInserta(Fechas.fechaDate(objform.getdFechaInicio()));
					obj.setdFechaActualiza(Fechas.fechaDate(objform.getdFechaFin()));
				}
				listaKardex =  kardexDao.listaKardex(0,1000, obj,cInsumo);
				obj = productoDao.findEndidad(obj,iProductoId);
			}
			
			if ("producto".equals(plantilla)) {
				beans.put("productos", productos);
			
			} else if ("materia-prima".equals(plantilla)) {
				beans.put("matPrimas", productos);
			
			} else if ("suministros".equals(plantilla)) {
				beans.put("suministros", productos);
			
			} else if ("envases".equals(plantilla)) {
				beans.put("envases", productos);
				
			} else if ("producto-kardex".equals(plantilla)) {
				beans.put("listakardex", listaKardex);
				beans.put("producto", obj);
				
			} else if ("servicio".equals(plantilla)) {
				beans.put("servicios", productos);
				
			}
			
			return beans;
		
		}
			
}