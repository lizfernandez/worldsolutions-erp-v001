//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.0/xslt/JavaClass.xsl

package com.struts.action;

import java.io.ByteArrayOutputStream;
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
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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
import com.dao.VentaDao;
import com.entities.Almacen;
import com.entities.Categoria;
import com.entities.Clasificacioncategoria;
import com.entities.Cuenta;
import com.entities.Distalmacen;
import com.entities.Distalmacendetalle;
import com.entities.Estado;
import com.entities.Kardex;
import com.entities.Librodiario;
import com.entities.Moneda;
import com.entities.Ordencompra;
import com.entities.Ordencompradetalle;
import com.entities.Periodo;
import com.entities.Personal;
import com.entities.Preciosproducto;
import com.entities.Produccion;
import com.entities.Producciondetalle;
import com.entities.Producto;
import com.entities.Productoalmacen;
import com.entities.Subcategoria;
import com.entities.Sucursal;
import com.entities.Unidadmedida;
import com.entities.Usuario;
import com.entities.Venta;
import com.entities.Ventadetalle;
import com.entities.converter.PreciosproductoConverter;
import com.entities.vo.AlmacenVo;
import com.entities.vo.PreciosproductoVo;
import com.entities.vo.ProductoVo;
import com.entities.vo.ProductoalmacenVo;
import com.entities.vo.UnidadmedidaVo;
import com.entities.vo.VentadetalleVo;
import com.google.gson.Gson;
import com.interfaces.dao.IProductoDao;
import com.struts.form.ProductosForm;
import com.struts.form.VentaForm;
import com.util.Constantes;
import com.util.Fechas;
import com.util.FormatosNumeros;
import com.util.Impresora;
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
		 if(mode!=null && mode.equals("LP") || mode!=null && mode.equals("LPC") 
				 || mode!=null && mode.equals("LPS") || mode!=null && mode.equals("LPP") 
				 || mode!=null && mode.equals("LPSP") || mode!=null && mode.equals("LPPU") 
				 || mode!=null && mode.equals("LPA")){
			 
			 UnidadMedidaDao unidadMedidaDao = new UnidadMedidaDao();
			 //Aqui se debera cambiar el método para solo cargar las categorias de los productos que son validos para vender.
			 List<Clasificacioncategoria> listaSubcategoria = productoDao.listaEntidadGenerica(Clasificacioncategoria.class);		 
			 List<Unidadmedida> listaUnidadMedida = unidadMedidaDao.listaUnidadMedida();
			 List<Sucursal> listaSucursal = unidadMedidaDao.listaEntidadGenerica(Sucursal.class);
			 Usuario usu = (Usuario) sesion.getAttribute("Usuario");
			 
			 sesion.setAttribute("listaClasificacioncategoria",listaSubcategoria);
			 sesion.setAttribute("listaUnidadMedida",listaUnidadMedida);
			 sesion.setAttribute("listaSucursal",listaSucursal);
			 productosForm.setIclasificacionId(iclasificacionId);
			 String iSucursalId = request.getParameter("iSucursalId");
				
			if (iSucursalId == null) {
				if (!usu.getPerfil().getvPerfilDescripcion().equals(Constantes.usuAdministrador)) {
					productosForm.setiSucursalId(usu.getSucursal().getiSucursalId());
					
				} else {
					productosForm.setiSucursalId(Integer.parseInt(iSucursalId));
				}
			}
			
			 if(mode.equals("LP")){
				if (usu.getPerfil().getvPerfilDescripcion().equals(Constantes.usuAdministrador)) {
					/** Lista de productos de ventas ***/
					msn = "showListPopupProductoAdm";
				} else {
					msn = "showListPopupProducto";
				}
			 } 
			 
			 if(mode.equals("LPS")){
				 /**Lista de productos de para servicios***/
			    msn ="showListPopupServicios";}
			 if(mode.equals("LPC")){
				 /**Lista de productos de compras***/
				 msn ="showListPopupProductoCompra";}
			 if(mode.equals("LPP")){
				 /**Lista de productos para generar la produccion***/
				 msn ="showListPopupProductoProduccion";}
			 if(mode.equals("LPSP")){
				 /**Lista de productos para generar la produccion***/
				 msn ="showListPopupServiciosProduccion";}
			 if(mode.equals("LPPU")){
				 /**Lista de productos existenta***/
				 msn ="showListPopupProductoExitProduccion";}
			 if(mode.equals("LPA")){
				 /**Lista de movimientos almacen***/
				 msn ="showListPopupProductoAlmacen";}
			
		}
		
	
		/**Seteamos los valores en las listas**/
		
		List<Producto> listaEntidad;
		
		if (iclasificacionId != 5) {
			listaEntidad = productoDao.listaProducto(Paginacion.pagInicio(pagina),Paginacion.pagFin(), productosForm.getProducto(),iclasificacionId,productosForm.getiSucursalId());
		} else {
			listaEntidad = productoDao.listaProducto(Paginacion.pagInicio(pagina),Paginacion.pagFin(), productosForm.getProducto(), iclasificacionId, 0);
		}
		
		List<ProductoVo> listaProductos = new ArrayList<ProductoVo>(); 
		if (listaEntidad.size() > 0) {
			ProductoVo productoVo;
			for (Producto producto : listaEntidad) {
				List<Productoalmacen> listaProductoAlmacen = producto.getProductoAlmacendetallles();
				productoVo = new ProductoVo(producto);
				if (listaProductoAlmacen != null) {
					if (iclasificacionId != 5) {
						for (Productoalmacen productoalmacen : listaProductoAlmacen) {
							
							if (productoalmacen.getAlmacen().getSucursal().getiSucursalId() == productosForm.getiSucursalId()) {
								System.out.println("Agregando Almacen [ " + productoalmacen.getiProductoAlamcenId() + " ] Stock [ " + productoalmacen.getiProductoAlmStockTotal() + " ]");
								productoVo.setStockSucursal(productoalmacen.getiProductoAlmStockTotal());
								productoVo.setiProductoalmacenId(productoalmacen.getiProductoAlamcenId());
								
							}	
						}
						
					} else {
						productoVo.setStockSucursal(producto.getiProductoStockTotal());
						productoVo.setiProductoalmacenId(0);
						
					}
										
				}
				listaProductos.add(productoVo);
				
			}
			
		}
		
		/**Consultamos el total de registros segun criterio**/
		List<Producto> listaPerfilTotal = productoDao.listaProducto(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(), productosForm.getProducto(),iclasificacionId,productosForm.getiSucursalId());
		
        /**Obtenemos el total del paginas***/
		List<Long> paginas = Paginacion.listPaginas((long)(listaPerfilTotal.size()));
//		for(Producto pro:listaProductos){
//			    if(pro.getUmBase()==null)
//				pro.setUmBase(new Unidadmedida());
//				
//				if(pro.getUmBase()==null)
//				pro.setUmPedido(new Unidadmedida());
//				if(pro.getUmBase()==null)
//				pro.setUmSalida(new Unidadmedida());
//			
//		}
		
		 
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
		productosForm.setProducto(productoDao.findEndidad(Producto.class,iProductoId));
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
	public ActionForward listaDistAlmacen(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {

		/***Validamos la session activa y logeada***/
		
		/*HttpSession sesion = request.getSession();
		
		if(sesion.getId()!=(sesion.getAttribute("id"))){
			response.sendRedirect("login.do?metodo=logout");				
		}
		else{*/
		String msn = "";
		/***Inicializamos variables***/
		String mode = request.getParameter("mode");
		if(mode!=null && mode.equals("LP")){
			 msn = "showListPopupDistAlmacen";
		}
		else{
			 msn = "showListDistAlmacen";
			
		}
		int pagina = Paginacion.paginaInicial;
		int pagInicio = Paginacion.paginaInicial;
		if(request.getParameter("pagina")!= null){
			 pagina = Integer.parseInt(request.getParameter("pagina"));
		}
	   /** Instanciamos la Clase ProductoForm **/
		ProductosForm productosForm = (ProductosForm) form;
		Producto obj = productosForm.getProducto();

		/** Instanciamos las clase Daos **/
		ProductoDao productoDao = new ProductoDao();
	
	
		/**Seteamos los valores en las listas**/
		List<Distalmacen> listaProductos =  productoDao.listaDistAlmacen(Paginacion.pagInicio(pagina),Paginacion.pagFin(), productosForm.getDistAlmacen());
		
		/**Consultamos el total de registros segun criterio**/
		List<Distalmacen> listaPerfilTotal = productoDao.listaDistAlmacen(Paginacion.pagInicio(pagina),Paginacion.pagFinMax(), productosForm.getDistAlmacen());
		
        /**Obtenemos el total del paginas***/
		List<Long> paginas = Paginacion.listPaginas((long)(listaPerfilTotal.size()));
        /**Obtenemos el total del paginas***/
		 
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
//		Moneda moneda = new Moneda();
		Categoria categoria = new Categoria();
		Clasificacioncategoria clasificacioncategoria = new Clasificacioncategoria();
		clasificacioncategoria.setiClasificacionId(iclasificacionId);
		categoria.setClasificacionCategoria(clasificacioncategoria);
		
		/** Instantacia a la capa Dao **/
		CategoriaDao categoriaDao = new CategoriaDao();
		ProductoDao productoDao = new ProductoDao();
		UnidadMedidaDao unidadMedidaDao = new UnidadMedidaDao();
		EstadoDao estadoDao = new EstadoDao();
		GenericaDao genericoDao = new GenericaDao();
		
		
		/** llamado de los metodos de la clase dao **/
		List<Categoria> listaCategoria = categoriaDao.listaCategoria(categoria);	
		
		List<Unidadmedida> listaUnidadMedida = unidadMedidaDao.listaUnidadMedida();
		List<Estado> listaEstado = estadoDao.listEstado();
		List<Moneda> listaMoneda = genericoDao.listaEntidadGenerica(Moneda.class);
		List<ProductoalmacenVo> listaProduAlma= new ArrayList<ProductoalmacenVo>();
		List<Producto> listaServicio = productoDao.listaProducto(Paginacion.pagInicio(1),Paginacion.pagFinMax(), productoForm.getProducto(),5,productoForm.getiSucursalId());
		
		List<PreciosproductoVo> listaPrecio = new ArrayList<PreciosproductoVo>();
		
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
//			if (iclasificacionId != 5) {
//				for (Almacen alm : listalmAlmacen) {
//					Productoalmacen pro = new Productoalmacen();
//					pro.setAlmacen(alm);
//					listaProduAlma.add(pro);
//					productoForm.setProducAlmacen(listaProduAlma);
//
//				}
//			}
			
		
		/**LLamamos al formulario mantenimientoProducto.jsp para mostrar los datos del UPDATE **/
		/** Seteamos el PerfilForm la clase Perfil **/
		} else if(mode.equals("U") || mode.equals("D")){
	    	
			int id = Integer.parseInt(request.getParameter("id"));
			Producto pro = genericoDao.findEndidad(Producto.class, id);
			productoForm.setProducto(pro);
			productoForm.setSizeIngresoproductodetalles(productoForm.getProducto().getIngresoproductodetalles().size());
			productoForm.setSizeVentaDetalles(productoForm.getProducto().getVentadetalles().size());
			
			
			listaSubCategoria = categoriaDao.listaSubcategoria(productoForm.getProducto().getCategoria().getiCategoriaId());
			
			
			if (iclasificacionId != 5) {
				List<Almacen> almacen = categoriaDao.listaEntidadGenerica(Almacen.class);

				boolean registrado = false;
				for (Almacen alma : almacen) {
					registrado = false;
					if (pro.getProductoAlmacendetallles().size() > 0) {
						for (Productoalmacen productoalmacen : pro.getProductoAlmacendetallles()) {
							if (alma.getiAlmacenId() == productoalmacen.getAlmacen().getiAlmacenId()) {
								ProductoalmacenVo productoAlmacen = new ProductoalmacenVo(productoalmacen);
								listaProduAlma.add(productoAlmacen);
								registrado = true;
							}
						}
					
					}
					if (!registrado) {
						ProductoalmacenVo productoAlmacen = new ProductoalmacenVo();
						AlmacenVo almacenVo = new AlmacenVo(alma);
						productoAlmacen.setAlmacen(almacenVo);
						productoAlmacen.setProducto(new ProductoVo(pro));
						productoAlmacen.setcEstadoCodigo(Constantes.estadoActivo);
						listaProduAlma.add(productoAlmacen);
					}
					
				}				
				  

				if (pro.getPreciosproductodetallles() != null) {
					if (pro.getPreciosproductodetallles().size() > 0) {
						for (Preciosproducto precioPro : pro.getPreciosproductodetallles()) {
							PreciosproductoVo preciosproducto = new PreciosproductoVo(precioPro);

							listaPrecio.add(preciosproducto);

						}
					}

				}
			}

			productoForm.setTotalPrecios(listaPrecio.size());
			productoForm.setTotalProductosAlmacen(listaProduAlma.size());
			productoForm.setProduc(listaPrecio);
			productoForm.setProducAlmacen(listaProduAlma);
	//		productoForm.setProducAlmacen(listaProduAlma);
			
			sesion.setAttribute("listaPrecioProducto",listaPrecio);
			sesion.setAttribute("listaProductoAlmacen",listaProduAlma);
			
			
				
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
	//	productoForm.setProducAlmacen(listaProduAlma);

		/** Colocamos en session las listas **/
		sesion.setAttribute("listaUnidadMedida", listaUnidadMedida);
		sesion.setAttribute("listaCategoria", listaCategoria);
		sesion.setAttribute("listaSubCategoria", listaSubCategoria);		
		sesion.setAttribute("listaMoneda", listaMoneda);		
		sesion.setAttribute("listaEstado", listaEstado);
		sesion.setAttribute("listaServicio",listaServicio);

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
		Producto producto = pForm.getProducto();
		
		GenericaDao productoDao = new GenericaDao();
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
				producto.setvFoto(producto.getcProductoCodigo() + "-" + nombre);
				if (!nombre.equals("")) {

					File ficheroACrear = new File(filePath + File.separator + "media" + File.separator + "fotos" + File.separator + producto.getvFoto());
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
				producto.setdFechaInserta(Fechas.getDate());
				producto.setiUsuarioInsertaId(usu.getiUsuarioId());
			
				if (producto.getUmBase() != null) {
					if (producto.getUmBase().getiUnidadMedidaId() == 0) {
						producto.setUmBase(null);
					}
				}
				
				if (producto.getUmPedido() != null) {
					if (producto.getUmPedido().getiUnidadMedidaId() == 0) {
						producto.setUmPedido(null);
					}
				}
				
				if (producto.getCategoria().getClasificacionCategoria().getvClasificacionDescripcion().equals(Constantes.categoriaServicios)) {
					producto.setiUMBase(1);
					producto.setUmBase(productoDao.findEndidadBD(Unidadmedida.class, "iUnidadMedidaId", 9));
					producto.setUnidadMedida(producto.getUmBase());
				}
				
				productoDao.persistEndidad(producto);

				if (!producto.getCategoria().getClasificacionCategoria().getvClasificacionDescripcion().equals(Constantes.categoriaServicios)) {
					
					/** Insertamos la existencia de un producto en el Kardex **/
					Kardex kardex = new Kardex();
					kardex.setProducto(producto);
					kardex.setdFecha(Fechas.getDate());
					kardex.setvConcepto(Constantes.conceptoExistencia);
					kardex.setiCantExistencia(producto.getiProductoStockTotal());
					kardex.setfPuExistencia(producto.getfProductoPrecioCompra());
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
					preciosProducto.setfGanancia(producto.getfProductoGanancia());
					preciosProducto.setfGastosAdm(producto.getfProductoGastosAdm());
					preciosProducto.setfPrecioCompra(producto.getfProductoPrecioCompra());
					preciosProducto.setfPrecioVenta(producto.getfProductoPrecioVenta());
					preciosProducto.setiCantidadStock(producto.getiProductoStockTotal());
					preciosProducto.setProducto(producto);
					preciosProducto.setfDescuento(producto.getfProductoDescuento());
					preciosProducto.setiUsuarioInsertaId(usu.getiUsuarioId());
					listaPrecios.add(preciosProducto);
					producto.setPreciosproductodetallles(listaPrecios);
					
					
					
					/*****************************************************/
					/*** ingresamos el listado de productos por almacen***/
					/*****************************************************/
					List<Productoalmacen> lista = (List<Productoalmacen>) sesion.getAttribute("listaProductoAlmacen");
					
					producto.setProductoAlmacendetallles(lista);
					// resultado = productoDao.insertarEndidad(preciosProducto);
	
					/**
					 * Insertamos en el libro Dirio la cuenta de Mercaredia
					 * 20(Mercaderia) y 201(Almacem) id=57; 201: mercaderia/ Almacen
					 **/
					Librodiario libroDiario = new Librodiario();
					libroDiario.setcEstadoCodigo(Constantes.estadoActivo);
					libroDiario.setCuenta(productoDao.findEndidad(Cuenta.class, 57));
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
					libroDiario = new Librodiario();
					libroDiario.setcEstadoCodigo(Constantes.estadoActivo);
					libroDiario.setCuenta(productoDao.findEndidad(Cuenta.class, 212));
					libroDiario.setfMonto(kardex.getiCantExistencia() * kardex.getfPuExistencia());
					libroDiario.setvTipoConcepto(Constantes.haber);
					libroDiario.setvConceptoGeneral("CAPITAL ");
					libroDiario.setdFechaInserta(Fechas.getDate());
					libroDiario.setiUsuarioInsertaId(usu.getiUsuarioId());
					libroDiario.setKardex(kardex);
					libroDiario.setiPeriodoId(iPeriodoId);
	
					productoDao.persistEndidad(libroDiario);
				
				}
				
				//	pro.setiProductoStockTotal(CantidadStocktotal);				
			    resultado = productoDao.commitEndidad(transaccion);
					
					
			} else 
			/** Insertamos Datos del producto como Insumos **/
			if (pForm.getMode().equals("II")) {
				producto.setdFechaInserta(Fechas.getDate());
				producto.setiUsuarioInsertaId(usu.getiUsuarioId());
				
				if (producto.getCategoria().getClasificacionCategoria().getvClasificacionDescripcion().equals(Constantes.categoriaServicios)) {
					producto.setiUMBase(1);
					producto.setUmBase(productoDao.findEndidadBD(Unidadmedida.class, "iUnidadMedidaId", 9));
					producto.setUnidadMedida(producto.getUmBase());
				}
				
				productoDao.persistEndidad(producto);
				resultado = productoDao.commitEndidad(transaccion);
				productoDao.refreshEndidad(producto);

			}
			/** Insertamos Datos del producto y de insumo **/
			else if (pForm.getMode().equals("U") || pForm.getMode().equals("UI")) {

				producto = productoDao.findEndidad(Producto.class, pForm.getProducto().getiProductoId());
				producto = Util.comparar(producto, pForm.getProducto());			
				producto.setdFechaActualiza(Fechas.getDate());
				producto.setiUsuarioActualizaId(usu.getiUsuarioId());
				if (producto.getCategoria().getClasificacionCategoria().getvClasificacionDescripcion().equals(Constantes.categoriaServicios)) {
					producto.setiUMBase(1);
					producto.setUmBase(productoDao.findEndidadBD(Unidadmedida.class, "iUnidadMedidaId", 9));
					producto.setUnidadMedida(producto.getUmBase());
				}
				if (producto.getUmBase() != null) {
					if (producto.getUmBase().getiUnidadMedidaId() == 0) {
						producto.setUmBase(null);
					}
				}
				if (producto.getUmPedido() != null) {
					if (producto.getUmPedido().getiUnidadMedidaId() == 0) {
						producto.setUmPedido(null);
					}
				}
				if (producto.getUmSalida() != null) {
					if (producto.getUmSalida().getiUnidadMedidaId() == 0) {
						producto.setUmSalida(null);
					}
				}
				
				if (!producto.getCategoria().getClasificacionCategoria().getvClasificacionDescripcion().equals(Constantes.categoriaServicios)) {
					/**
					 * Actualizamos o agregamos precios del producto, como tambien
					 * actualizaremos la cantidad del producto
					 **/
					@SuppressWarnings("unchecked")
					List<PreciosproductoVo> listaPrecio = (List<PreciosproductoVo>) sesion.getAttribute("listaPrecioProducto");
					
					if (listaPrecio.size() > 0) {
						producto.setPreciosproductodetallles(PreciosproductoConverter.aListEntidad(listaPrecio, producto));
						int cantidadProducto = 0;
						float precioVenta = 0;
						float precioCompra = 0;
						float fGanancia = 0;
						float fGastoAdm = 0;
						float fDescuento = 0;
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
	
						for (Preciosproducto objpreciosProducto : producto.getPreciosproductodetallles()) {
							if (objpreciosProducto.getiCantidadStock() > 0 && objpreciosProducto.getcEstadoCodigo().equals(Constantes.estadoActivo)) {
								
								cantidadProducto = producto.getiProductoStockTotal();
								if (i == 0) {
									precioCompra = objpreciosProducto.getfPrecioCompra();
									precioVenta = objpreciosProducto.getfPrecioVenta();
									fGanancia = objpreciosProducto.getfGanancia();
									fGastoAdm = objpreciosProducto.getfGastosAdm();
									fDescuento = objpreciosProducto.getfDescuento();
									
								}
							}
						}
						producto.setiProductoStockTotal(cantidadProducto);
					
	               
					}
					/*****************************************************/
					/*** ingresamos el listado de productos por almacen***/
					/*****************************************************/
					@SuppressWarnings("unchecked")
					List<ProductoalmacenVo> lista = (List<ProductoalmacenVo>) sesion.getAttribute("listaProductoAlmacen");
					if (lista != null && lista.size() > 0) {
						List<Productoalmacen> listaEntidad =  new ArrayList<Productoalmacen>();
					    for(ProductoalmacenVo productoAlmacenVo : lista){
					    	if (productoAlmacenVo.getiProductoAlmStockTotal() > 0) {
						    	Productoalmacen prodAlmacen = new Productoalmacen(productoAlmacenVo);
						    	listaEntidad.add(prodAlmacen);
					    	}
					    }
						producto.setProductoAlmacendetallles(listaEntidad);
					}
					/** Actualizamos los valores de la existencia del Kardex **/
					/** si no existe ningun tipo de movimiento (Compras o ventas) **/
					if (pForm.getSizeIngresoproductodetalles() == 0 && pForm.getSizeVentaDetalles() == 0) {
						
						List<Kardex> kardex = producto.getKardexs();
						kardex.get(0).setiCantExistencia(producto.getiProductoStockTotal());
						kardex.get(0).setfPuExistencia(producto.getfProductoPrecioCompra());
						kardex.get(0).setfTotalExistencia(kardex.get(0).getiCantExistencia() * kardex.get(0).getfPuExistencia());
						kardex.get(0).setiUsuarioActualizaId(usu.getiUsuarioId());
						kardex.get(0).setdFechaActualiza(Fechas.getDate());
	
						productoDao.mergeEndidad(kardex.get(0));
	
						/**
						 * Actualizamos los valores de la existencias del libro
						 * diario la cuenta de Mercaredia
						 **/
	
						List<Librodiario> librodiario = kardex.get(0).getLibroDiarios();
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
				}
				productoDao.mergeEndidad(producto);
				resultado = productoDao.commitEndidad(transaccion);
				//productoDao.refreshEndidad(pro);
			} else if (mode.equals("D")) {
				productoDao.eliminarUnaEndidad(producto, "iProductoId", ids);/**/
				resultado = productoDao.commitEndidad(transaccion);
			}
			sesion.removeAttribute("listaProductoAlmacen");
			
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
			float fGastosAdm = Float.parseFloat(request.getParameter("fGastosAdm"));
			float  fDescuento = Float.parseFloat(request.getParameter("fDescuento"));
			float  fPrecioVenta = Float.parseFloat(request.getParameter("fPrecioVenta"));
			String  cEstadoCodigoPrecio = request.getParameter("cEstadoCodigoPrecio");
			
			String mode = request.getParameter("mode");
			
			/** Instanciamos la Clase VentaForm **/
					
			List<PreciosproductoVo> lista = (List<PreciosproductoVo>) sesion.getAttribute("listaPrecioProducto");
			
//			Producto producto = new Producto();			
			PreciosproductoVo precioProducto;
			
			if(mode.equals("I")){
//				Producto productoBean = genericaDao.findEndidad(Producto.class, iProductoId);
//				lista = PreciosproductoConverter.aListPreciosproductoVo(productoBean.getPreciosproductodetallles());
//				producto.setiProductoId(iProductoId);
				/**valores por defecto**/
			
				//precioProducto.setProducto(producto);
				precioProducto = new PreciosproductoVo();
				precioProducto.setiCantidadStock(iCantidadStock);
				precioProducto.setfPrecioCompra(fPrecioCompra);
				precioProducto.setfPrecioVenta(fPrecioVenta);
				precioProducto.setfGanancia(fGanancia);
				precioProducto.setfGastosAdm(fGastosAdm);
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
			   lista.get(iPrecioProductoId).setfGastosAdm(fGastosAdm);
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
		 */
			@SuppressWarnings("unchecked")
			public ActionForward detalleProductoAlmacen(ActionMapping mapping, ActionForm form,
						HttpServletRequest request, HttpServletResponse response) throws IOException{
	      
				response.setContentType("text/json");	
				HttpSession sesion = request.getSession();
				
				Gson gson = new Gson();			
//				GenericaDao genericaDao = new GenericaDao();
//				ProductosForm productoForm = (ProductosForm) form;
				
				int iProductoId = Integer.parseInt(request.getParameter("iProductoId"));
				int i = Integer.parseInt(request.getParameter("i"));
				int iAlmacenId = Integer.parseInt(request.getParameter("iAlmacenId"));
				int iProductoAlmacenId = Integer.parseInt(request.getParameter("iProductoAlmacenId"));	
				int iProductoAlmStockTotal = Integer.parseInt(request.getParameter("iProductoAlmStockTotal"));
				int iUnidadMedidaAlmId = Integer.parseInt(request.getParameter("iUnidadMedidaAlmId"));
//				int iUMBaseAlm = Integer.parseInt(request.getParameter("iUMBaseAlm"));
//				int iUMBaseAlmId = Integer.parseInt(request.getParameter("iUMBaseAlmId"));
				
				
				
				
				String mode = request.getParameter("mode");
				
				/** Instanciamos la Clase VentaForm **/
			

				
				List<ProductoalmacenVo> lista = (List<ProductoalmacenVo>) sesion.getAttribute("listaProductoAlmacen");
				
				
			//	ProductoVo producto = new ProductoVo();		
				ProductoDao productodao= new ProductoDao();
				
				ProductoalmacenVo productoAlmacen  = new ProductoalmacenVo();
				Producto productBean = productodao.findEndidad(Producto.class, iProductoId);
				
				if(mode.equals("I")){
					//Producto productoBean = genericaDao.findEndidad(producto, iProductoId);
					//lista = productoBean.getProductoAlmacendetallles();
					if(lista==null){
					lista = new ArrayList<ProductoalmacenVo>();
					
					/**valores por defecto**/
				
					productoAlmacen.setiProductoAlmStockTotal(iProductoAlmStockTotal);
					productoAlmacen.setAlmacen(new AlmacenVo(productodao.findEndidad(Almacen.class, iAlmacenId)));
//					productoAlmacen.setiUMBaseAlm(iUMBaseAlm);
//					productoAlmacen.setUnidadBaseAlm(new UnidadmedidaVo( productodao.findEndidad(Unidadmedida.class, iUMBaseAlmId)));
					productoAlmacen.setUnidadMedidaAlm(new UnidadmedidaVo( productodao.findEndidad(Unidadmedida.class, iUnidadMedidaAlmId)));
					productoAlmacen.setdFechaInserta(Fechas.getDate());
					productoAlmacen.setcEstadoCodigo(Constantes.estadoActivo);
					productoAlmacen.setProducto(new ProductoVo(productBean));
					lista.add(productoAlmacen);
					}else{
						
						lista.get(i).setiProductoAlmStockTotal(iProductoAlmStockTotal);
						lista.get(i).setAlmacen(new AlmacenVo(productodao.findEndidad(Almacen.class, iAlmacenId)));
//						lista.get(i).setiUMBaseAlm(iUMBaseAlm);
//						lista.get(i).setUnidadBaseAlm(new UnidadmedidaVo(productodao.findEndidad(Unidadmedida.class, iUMBaseAlmId)));
						lista.get(i).setUnidadMedidaAlm(new UnidadmedidaVo( productodao.findEndidad(Unidadmedida.class, iUnidadMedidaAlmId)));
						lista.get(i).setdFechaInserta(Fechas.getDate());
						lista.get(i).setProducto(new ProductoVo(productBean));
						lista.get(i).setcEstadoCodigo(Constantes.estadoActivo);
					}
					//productoForm.setProducAlmacen(lista);
				sesion.setAttribute("listaProductoAlmacen", lista);
				}
			
				 if(mode.equals("U")){
					 //  lista = producto.getPreciosproductodetallles();
					  
							   lista.get(i).setiProductoAlmStockTotal(iProductoAlmStockTotal);
//							   lista.get(i).setiUMBaseAlm(iUMBaseAlm);
							   lista.get(i).setProducto(new ProductoVo(productBean));
//							   lista.get(i).setUnidadBaseAlm(new UnidadmedidaVo(productodao.findEndidad(Unidadmedida.class, iUMBaseAlmId)));
							   lista.get(i).setUnidadMedidaAlm(new UnidadmedidaVo( productodao.findEndidad(Unidadmedida.class, iUnidadMedidaAlmId)));
							   lista.get(i).setiProductoAlamcenId(iProductoAlmacenId);
							   lista.get(i).setdFechaInserta(Fechas.getDate());
							   lista.get(i).setcEstadoCodigo(Constantes.estadoActivo);
							//   productoForm.setProducAlmacen(lista);
							   
							   sesion.setAttribute("listaProductoAlmacen", lista);				   
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
			boolean errorCarga = false;
			
			/** llamado de los metodos de la clase dao **/
			List<Categoria> listaCategoria = categoriaDao.listaEntidadGenerica(Categoria.class);
			if (listaCategoria.size() == 0) {
				errorCarga = true;
			}
			
			List<Subcategoria> listaSubCategoria = categoriaDao.listaSubcategoria(listaCategoria.get(0).getiCategoriaId());

			if (listaSubCategoria.size() == 0) {
				errorCarga = true;
			}
			
			List<Unidadmedida> listaUnidadMedida = unidadMedidaDao.listaUnidadMedida();

			if (listaUnidadMedida.size() == 0) {
				errorCarga = true;
			}
			
			List<Estado> listaEstado = estadoDao.listEstado();

			if (listaEstado.size() == 0) {
				errorCarga = true;
			}
			
			List<Moneda> listaMoneda = genericoDao.listaEntidadGenerica(Moneda.class);

			if (listaMoneda.size() == 0) {
				errorCarga = true;
			}
			
			if (errorCarga) {
				msn = "msnError";
				
			} else {
				msn = "showEditProduccion";
				
				List<Preciosproducto> listaPrecio = new ArrayList<Preciosproducto>();
				List<Producciondetalle> listaProduccion = new ArrayList<Producciondetalle>();
				
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
					Produccion produccion = genericoDao.findEndidad(Produccion.class,id);
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
						pro.setiProductoStockTotal(produce.getProducto().getiProductoStockTotal());
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
					
					
					
					
					Producto pro = genericoDao.findEndidad(Producto.class, produccion.getProducto().get(0).getiProductoId());
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
		 * @throws NoSuchFieldException 
		 * @throws IllegalAccessException 
		 * @throws ClassNotFoundException 
		 * @throws SecurityException 
		 * @throws IllegalArgumentException 
		 */
		public ActionForward mantenimientoDistAlmacen(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws IllegalArgumentException, SecurityException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException {

			/***Inicializamos variable***/
			HttpSession sesion = request.getSession();
			String mode = request.getParameter("mode");
				
			String msn="";

			/***Instancioamos ProductosForm form***/
			ProductosForm productoForm = (ProductosForm) form;		
				
			/** Instantacia a la capa Dao **/
			EstadoDao estadoDao = new EstadoDao();
			GenericaDao genericoDao = new GenericaDao();
			ProductoDao productoDao = new ProductoDao();
			
			List<Estado> listaEstado = estadoDao.listEstado();
			List<Almacen> listaAlmacen = genericoDao.listaEntidadGenerica(Almacen.class);
			
				
				
			List<Distalmacendetalle> listaProduccion = new ArrayList<Distalmacendetalle>();
			List<Distalmacendetalle> listaDistribucionSalida = new ArrayList<Distalmacendetalle>();
				Usuario usu = (Usuario) sesion.getAttribute("Usuario");
				
		    if(mode.equals("IE")|| mode.equals("UE")){
		    	msn = "showEditDistAlmacenEntrada";	
		    }
		    if(mode.equals("IS")|| mode.equals("US")){
		    	msn = "showEditDistAlmacenSalida";	
		    }
			/**
			 * IE: insercion de entrada
			 * IS: insercion de salida.
			 * */	
			if(mode.equals("IE")|| mode.equals("IS")){
					/** Obtenemos le codigo correlativo del producto **/
					productoForm.getDistAlmacen().setvNroSalida(genericoDao.callSPNro_Documento(14, "DistAlmacen", "vNroSalida",usu.getSucursal().getiSucursalId()));
					productoForm.getDistAlmacen().setvNroIngreso(genericoDao.callSPNro_Documento(15, "DistAlmacen", "vNroIngreso",usu.getSucursal().getiSucursalId()));
					
					/***LISTA DE DETALLE VENTA***/
					sesion.removeAttribute("listaDistAlmacenDetalle");
					if(sesion.getAttribute("listaDistAlmacenDetalle")==null){				
						 sesion.setAttribute("listaDistAlmacenDetalle", listaProduccion);
	                 }
					if(listaAlmacen.size()>0){
						productoForm.setvPuntoLlegada(listaAlmacen.get(0).getSucursal().getvSucursalDireccion());
						productoForm.setvPuntoSalida(listaAlmacen.get(0).getSucursal().getvSucursalDireccion());	
					}
					
					
				/**LLamamos al formulario mantenimientoProducto.jsp para mostrar los datos del UPDATE **/
				/** Seteamos el PerfilForm la clase Perfil **/
				} else if(mode.equals("UE") ||mode.equals("US") || mode.equals("D")){
				
					int id = Integer.parseInt(request.getParameter("id"));
					Distalmacen distAlamcen = genericoDao.findEndidad(Distalmacen.class,id);
					productoForm.setDistAlmacen(distAlamcen);
					Personal perSalida = genericoDao.findEndidad(Personal.class,distAlamcen.getUsuatioEntrega().getiPersonalId());
					productoForm.setcPersonalCodigo(perSalida.getcPersonalCodigo());
					productoForm.setvPersonalNombres(perSalida.getvPersonalNombres()+perSalida.getvPersonalApellidoPaterno());
				
					Personal perEntrada = genericoDao.findEndidad(Personal.class,distAlamcen.getUsuarioRecepcion().getiPersonalId());
					productoForm.setcPersonalCodigoRecep(perEntrada.getcPersonalCodigo());
					productoForm.setvPersonalNombresRecep(perEntrada.getvPersonalNombres()+perSalida.getvPersonalApellidoPaterno());
					
					
					for(Distalmacendetalle produce:distAlamcen.getDistAlmacendetalles()){
						Producto pro = new Producto();
						
						Distalmacen produc= new Distalmacen();
						Distalmacendetalle prodetalle= new Distalmacendetalle();
						prodetalle.setiDistAlmacenDetId(produce.getiDistAlmacenDetId());						
						prodetalle.setcEstadoCodigo(produce.getcEstadoCodigo());						
						prodetalle.setfTotal(produce.getfTotal());
						prodetalle.setiCantidad(produce.getiCantidad());
						
						produc.setcEstadoCodigo(produce.getDistAlmacen().getcEstadoCodigo());
						produc.setfTotal(produce.getDistAlmacen().getfTotal());
						produc.setAlmacenEntrada(produce.getDistAlmacen().getAlmacenEntrada());
						produc.setAlmacenSalida(produce.getDistAlmacen().getAlmacenSalida());
						produc.setdFechaIngreso(produce.getDistAlmacen().getdFechaIngreso());
						produc.setiDistAlmacenId(produce.getDistAlmacen().getiDistAlmacenId());
						produc.setdFechaSalida(produce.getDistAlmacen().getdFechaSalida());
						produc.setUsuarioRecepcion(produce.getDistAlmacen().getUsuarioRecepcion());
						produc.setUsuatioEntrega(produce.getDistAlmacen().getUsuatioEntrega());

							produc.setvNroIngreso(produce.getDistAlmacen().getvNroIngreso());
						
						produc.setvNroSalida(produce.getDistAlmacen().getvNroSalida());
						produc.setvObservacion(produce.getDistAlmacen().getvObservacion());
						produc.setvPuntoLlegada(produce.getDistAlmacen().getvPuntoLlegada());
						produc.setvPuntoSalida(produce.getDistAlmacen().getvPuntoSalida());
						
						
						prodetalle.setDistAlmacen(produc);
						
						pro.setCategoria(produce.getProducto().getCategoria());
						pro.setcProductoCodigo(produce.getProducto().getcProductoCodigo());
						pro.setfProductoDescuento(produce.getProducto().getfProductoDescuento());
						pro.setfProductoPrecioCompra(produce.getProducto().getfProductoPrecioCompra());
						pro.setfProductoPrecioVenta(produce.getProducto().getfProductoPrecioVenta());
						pro.setiProductoId(produce.getProducto().getiProductoId());
						pro.setiProductoStockTotal(produce.getProducto().getiProductoStockTotal());
						pro.setMoneda(produce.getProducto().getMoneda());
						pro.setUnidadMedida(produce.getProducto().getUnidadMedida());
						pro.setvProductoNombre(produce.getProducto().getvProductoNombre());
						
						prodetalle.setProducto(pro);
						
						
						
						
						listaProduccion.add(prodetalle);
					
					}
					sesion.setAttribute("listaDistAlmacenDetalle", listaProduccion);
					
				    List<Distalmacen>	listaDistAlmSalida = productoDao.listaDistAlmacenvNroSalida(productoForm.getDistAlmacen().getvNroSalida());
					if(listaDistAlmSalida.size()>0 ){
						for(Distalmacen distAlmacen:listaDistAlmSalida){
							if(distAlmacen.getvNroIngreso()==null){
						for(Distalmacendetalle produce:distAlmacen.getDistAlmacendetalles()){
							
							Producto pro = new Producto();
							
							Distalmacen produc= new Distalmacen();
							Distalmacendetalle prodetalle= new Distalmacendetalle();
							prodetalle.setiDistAlmacenDetId(produce.getiDistAlmacenDetId());						
							prodetalle.setcEstadoCodigo(produce.getcEstadoCodigo());						
							prodetalle.setfTotal(produce.getfTotal());
							prodetalle.setiCantidad(produce.getiCantidad());
							
							produc.setcEstadoCodigo(produce.getDistAlmacen().getcEstadoCodigo());
							produc.setfTotal(produce.getDistAlmacen().getfTotal());
							produc.setAlmacenEntrada(produce.getDistAlmacen().getAlmacenEntrada());
							produc.setAlmacenSalida(produce.getDistAlmacen().getAlmacenSalida());
							produc.setdFechaIngreso(produce.getDistAlmacen().getdFechaIngreso());
							produc.setiDistAlmacenId(produce.getDistAlmacen().getiDistAlmacenId());
							produc.setdFechaSalida(produce.getDistAlmacen().getdFechaSalida());
							produc.setUsuarioRecepcion(produce.getDistAlmacen().getUsuarioRecepcion());
							produc.setUsuatioEntrega(produce.getDistAlmacen().getUsuatioEntrega());

								produc.setvNroIngreso(produce.getDistAlmacen().getvNroIngreso());
							
							produc.setvNroSalida(produce.getDistAlmacen().getvNroSalida());
							produc.setvObservacion(produce.getDistAlmacen().getvObservacion());
							produc.setvPuntoLlegada(produce.getDistAlmacen().getvPuntoLlegada());
							produc.setvPuntoSalida(produce.getDistAlmacen().getvPuntoSalida());
							
							
							prodetalle.setDistAlmacen(produc);
							
							pro.setCategoria(produce.getProducto().getCategoria());
							pro.setcProductoCodigo(produce.getProducto().getcProductoCodigo());
							pro.setfProductoDescuento(produce.getProducto().getfProductoDescuento());
							pro.setfProductoPrecioCompra(produce.getProducto().getfProductoPrecioCompra());
							pro.setfProductoPrecioVenta(produce.getProducto().getfProductoPrecioVenta());
							pro.setiProductoId(produce.getProducto().getiProductoId());
							pro.setiProductoStockTotal(produce.getProducto().getiProductoStockTotal());
							pro.setMoneda(produce.getProducto().getMoneda());
							pro.setUnidadMedida(produce.getProducto().getUnidadMedida());
							pro.setvProductoNombre(produce.getProducto().getvProductoNombre());
							
							prodetalle.setProducto(pro);
							
							
							
							
							listaDistribucionSalida.add(prodetalle);
						
						}
					}
						}
						}
				    sesion.setAttribute("listaDistAlmacenDetalleSalida", listaDistribucionSalida);
					
					
				}
				/**LLamamos al formulario buscarMantenimientoProducto.jsp para realizar la busqueda **/
				else if(mode.equals("F")){
					 msn ="showFindDistAlmacen";
		                    
			       
			        
				}		
				
				productoForm.setMode(mode);
			
	
					sesion.setAttribute("listaEstado", listaEstado);
					sesion.setAttribute("listaAlmacen", listaAlmacen);

			
			
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
		public ActionForward mantenimientoOrdenCompra(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws IllegalArgumentException, SecurityException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException {

			/***Inicializamos variable***/
			HttpSession sesion = request.getSession();
			String mode = request.getParameter("mode");
				
			String msn="";

			/***Instancioamos ProductosForm form***/
			ProductosForm productoForm = (ProductosForm) form;		
				
			/** Instantacia a la capa Dao **/
			EstadoDao estadoDao = new EstadoDao();
			GenericaDao genericoDao = new GenericaDao();
			
			List<Estado> listaEstado = estadoDao.listEstado();
			msn = "showEditOrdenCompra";
				
				
				List<Distalmacendetalle> listaProduccion = new ArrayList<Distalmacendetalle>();
				
				if(mode.equals("I")){
					/** Obtenemos le codigo correlativo del producto **/
					productoForm.getProducto().setcProductoCodigo(genericoDao.callSPCalculoCodigo(productoForm.getProducto()));
					/***LISTA DE DETALLE VENTA***/
					sesion.removeAttribute("listaDistAlmacenDetalle");
					if(sesion.getAttribute("listaDistAlmacenDetalle")==null){				
						 sesion.setAttribute("listaDistAlmacenDetalle", listaProduccion);
	                 }
				
				/**LLamamos al formulario mantenimientoProducto.jsp para mostrar los datos del UPDATE **/
				/** Seteamos el PerfilForm la clase Perfil **/
				} else if(mode.equals("U") || mode.equals("D")){
			    	
					int id = Integer.parseInt(request.getParameter("id"));
					Distalmacen distAlamcen = genericoDao.findEndidad(Distalmacen.class,id);
					productoForm.setDistAlmacen(distAlamcen);
					
					
					for(Distalmacendetalle produce:distAlamcen.getDistAlmacendetalles()){
						Producto pro = new Producto();
						
						Distalmacen produc= new Distalmacen();
						Distalmacendetalle prodetalle= new Distalmacendetalle();
						prodetalle.setiDistAlmacenDetId(produce.getiDistAlmacenDetId());						
						prodetalle.setcEstadoCodigo(produce.getcEstadoCodigo());						
						prodetalle.setfTotal(produce.getfTotal());
						prodetalle.setiCantidad(produce.getiCantidad());
						
						produc.setcEstadoCodigo(produce.getDistAlmacen().getcEstadoCodigo());
						produc.setfTotal(produce.getDistAlmacen().getfTotal());
						produc.setAlmacenEntrada(produce.getDistAlmacen().getAlmacenEntrada());
						produc.setAlmacenSalida(produce.getDistAlmacen().getAlmacenSalida());
						produc.setdFechaIngreso(produce.getDistAlmacen().getdFechaIngreso());
						produc.setiDistAlmacenId(produce.getDistAlmacen().getiDistAlmacenId());
						produc.setdFechaSalida(produce.getDistAlmacen().getdFechaSalida());
						produc.setUsuarioRecepcion(produce.getDistAlmacen().getUsuarioRecepcion());
						produc.setUsuatioEntrega(produce.getDistAlmacen().getUsuatioEntrega());
						produc.setvNroIngreso(produce.getDistAlmacen().getvNroIngreso());
						produc.setvNroSalida(produce.getDistAlmacen().getvNroSalida());
						produc.setvObservacion(produce.getDistAlmacen().getvObservacion());
						produc.setvPuntoLlegada(produce.getDistAlmacen().getvPuntoLlegada());
						produc.setvPuntoSalida(produce.getDistAlmacen().getvPuntoSalida());
						
						
						prodetalle.setDistAlmacen(produc);
						
						pro.setCategoria(produce.getProducto().getCategoria());
						pro.setcProductoCodigo(produce.getProducto().getcProductoCodigo());
						pro.setfProductoDescuento(produce.getProducto().getfProductoDescuento());
						pro.setfProductoPrecioCompra(produce.getProducto().getfProductoPrecioCompra());
						pro.setiProductoId(produce.getProducto().getiProductoId());
						pro.setiProductoStockTotal(produce.getProducto().getiProductoStockTotal());
						pro.setMoneda(produce.getProducto().getMoneda());
						pro.setUnidadMedida(produce.getProducto().getUnidadMedida());
						pro.setvProductoNombre(produce.getProducto().getvProductoNombre());
						
						prodetalle.setProducto(pro);
						
						
						
						
						listaProduccion.add(prodetalle);
					
					}
					sesion.setAttribute("listaDistAlmacenDetalle", listaProduccion);
					
					
				}
				/**LLamamos al formulario buscarMantenimientoProducto.jsp para realizar la busqueda **/
				else if(mode.equals("F")){
					 msn ="showFindOrdenCompra";
		                    
			       
			        
				}		
				
				productoForm.setMode(mode);
			
	
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
				if(pro.getUmPedido()!=null){
					if(pro.getUmPedido().getiUnidadMedidaId()==0){
	            	   pro.setUmPedido(null);
	               }
				}
	               if(pro.getUmSalida()!=null){
	            	   if(pro.getUmSalida().getiUnidadMedidaId()==0){
	            	   pro.setUmSalida(null);
	               }
	               }
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
					    material= productoDao.findEndidad(Producto.class, prodeta.getProducto().getiProductoId()) ;
					    cantidad= material.getiProductoStockTotal()-prodeta.getiCantidad();
					    material.setiProductoStockTotal(cantidad); 
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
				kardex.setiCantExistencia(pro.getiProductoStockTotal());
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
				preciosProducto.setiCantidadStock(pro.getiProductoStockTotal());
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
				Librodiario libroDiario = new Librodiario();
				libroDiario.setcEstadoCodigo(Constantes.estadoActivo);
				libroDiario.setCuenta(productoDao.findEndidad(Cuenta.class, 57));
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
				produccion =  productoDao.findEndidad(Produccion.class ,produBean.getiProduccionId());
				produccion= Util.comparar(produccion, produBean);
				produccion.setdFechaActualiza(Fechas.getDate());
				produccion.setiUsuarioActualiza(usu.getiUsuarioId());
				
				productoDao.mergeEndidad(produccion);
				
				/***********************************/
				/** Registro de producto**/
				/***********************************/		
				 pro =  productoDao.findEndidad(Producto.class, pForm.getProducto().getiProductoId());
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
					    
					    material= productoDao.findEndidad(Producto.class, prodeta.getProducto().getiProductoId()) ;					    
					   
					    if(prodeta.getiProduccionDetalleId()>0){
					    	/// exite producto  en el detalle original y se cambia la cantidad
					    	proDeOriginal= productoDao.findEndidadBD(Producciondetalle.class,"iProduccionDetalleId", prodeta.getiProduccionDetalleId());
					    	cantidad= proDeOriginal.getiCantidad()-prodeta.getiCantidad()+material.getiProductoStockTotal();
					    }
					    else{
					    	// cuando se agrega nueva materia prima
					    	cantidad= material.getiProductoStockTotal()-prodeta.getiCantidad();
					    }
					    material.setiProductoStockTotal(cantidad); 
					  
					}
					
					if(prodeta.getiProduccionDetalleId()>0 && prodeta.getcEstadoCodigo().equals(Constantes.estadoInactivo)){
						cantidad= material.getiProductoStockTotal()+prodeta.getiCantidad();
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
		      			pro.setiProductoStockTotal(cantidadProducto);
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
					kardex.get(0).setiCantExistencia(pro.getiProductoStockTotal());
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
				if(pro.getUmPedido()!=null){
					if(pro.getUmPedido().getiUnidadMedidaId()==0){
	            	   pro.setUmPedido(null);
	               }
				}
	               if(pro.getUmSalida()!=null){
	            	   if(pro.getUmSalida().getiUnidadMedidaId()==0){
	            	   pro.setUmSalida(null);
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
		 * @throws NoSuchFieldException 
		 * @throws IllegalAccessException 
		 * @throws ClassNotFoundException 
		 * @throws SecurityException 
		 * @throws IllegalArgumentException 
		 */
		@SuppressWarnings({ "unchecked", "deprecation" })
		public ActionForward iduDistAlmacen(ActionMapping mapping, ActionForm form,
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
			Distalmacen DistBean = pForm.getDistAlmacen();
			
			GenericaDao productoDao = new GenericaDao();
			ProductoDao productoDaos = new ProductoDao();	
			KardexDao kardexDao = new KardexDao();
			List<Preciosproducto> listaPrecios = new ArrayList<Preciosproducto>();
			List<Distalmacendetalle> listaDistDetalle= new ArrayList<Distalmacendetalle>();
			List<Kardex> listaKadex = new ArrayList<Kardex>();
			EntityTransaction transaccion = null;
			
			try {
				
			
			/*** Instanciamos transacion ***/
				transaccion = productoDao.entityTransaction();
			transaccion.begin();
			
            /***
             * IE: INSERCION DE ENTRADA.
             * IS: INSERCION DE SALIDA
             */
	        /**Insertamos Datos del producto **/
			if (pForm.getMode().equals("IE")||pForm.getMode().equals("IS")) {	
				
				/******************************************/
				/**Insertamos la gestion de la produccion**/
				/******************************************/
				DistBean.setdFechaInserta(Fechas.getDate());
				DistBean.setiUsuarioInsertaId(usu.getiUsuarioId());
				DistBean.setiSucursalId(usu.getSucursal().getiSucursalId());
				//14: documento de almacen de salida.
				DistBean.setiTipoDocumentoId(14);
				DistBean.setPeriodo(productoDao.findEndidad(Periodo.class,iPeriodoId));
				DistBean.setcEstadoCodigo(Constantes.estadoActivo);
				/*DistBean.setUsuarioRecepcion(productoDao.findEndidad(Usuario.class,pForm.getiUsuarioRecepcionId()));
				DistBean.setUsuatioEntrega(productoDao.findEndidad(Usuario.class,pForm.getiUsuarioEntregaId()));
				*/
				productoDao.persistEndidad(DistBean);
				
				
				
				/***********************************/
				/** Registro de produccion detalle**/
				/***********************************/
				listaDistDetalle = (List<Distalmacendetalle>) sesion.getAttribute("listaDistAlmacenDetalle");	
				
				for(Distalmacendetalle prodeta:listaDistDetalle){
					if(prodeta.getcEstadoCodigo().equals(Constantes.estadoActivo)){
				
					prodeta.setDistAlmacen(DistBean);
					productoDao.persistEndidad(prodeta);
					
					/*****************************************/
					/** sumamos  el stock de los materiales**/
					/*****************************************/
					int cantidad = 0;
					
					    
					   // if(material!=null){
					    	if(pForm.getMode().equals("IS")){
					    	Productoalmacen material=  productoDaos.obtenerProductoAlmacen(prodeta.getProducto().getiProductoId(),DistBean.getAlmacenSalida().getiAlmacenId()) ;
					    	cantidad= material.getiProductoAlmStockTotal()-prodeta.getiCantidad();
					    	material.setiProductoAlmStockTotal(cantidad);
						   
						    productoDao.mergeEndidad(material);
					    	}
					    	if(pForm.getMode().equals("IE")){
					    	Productoalmacen material=  productoDaos.obtenerProductoAlmacen(prodeta.getProducto().getiProductoId(),DistBean.getAlmacenEntrada().getiAlmacenId()) ;
					    	cantidad= material.getiProductoAlmStockTotal()+prodeta.getiCantidad();
					    	material.setiProductoAlmStockTotal(cantidad);
						    
						    productoDao.mergeEndidad(material);
					    	}
					    		
					  /*  }
					    else{
					    	 material=  new Productoalmacen();
					    	 material.setcEstadoCodigo(Constantes.estadoActivo);
					    	 material.setdFechaInserta(Fechas.getDate());
					    	 material.setProducto(prodeta.getProducto());
					    	 material.setAlmacen(DistBean.getAlmacenEntrada());
					    	 material.setiProductoAlmStockTotal(prodeta.getiCantidad());
					    	 material.setiUsuarioInsertaId(usu.getiUsuarioId());
					    	 material.setUnidadMedidaAlm(prodeta.getProducto().getUnidadMedida());
					    	 material.setUnidadBaseAlm(prodeta.getProducto().getUmBase());
					    	 material.setiUMBaseAlm(prodeta.getProducto().getiUMBase());
					    	 productoDao.persistEndidad(material);
					    }
					    */
					}
					
				}
				
				/**Insertamos la existencia de un producto en el Kardex**/
				/*Kardex  kardex = new Kardex();
				kardex.setProducto(pro);
				kardex.setdFecha(Fechas.getDate());
				kardex.setvConcepto(Constantes.conceptoDistribucion);
				kardex.setiCantExistencia(pro.getiProductoStockTotal());
				kardex.setfPuExistencia(pro.getfProductoPrecioCompra());
				kardex.setfTotalExistencia(kardex.getiCantExistencia()*kardex.getfPuExistencia());
				kardex.setiUsuarioInsertaId(usu.getiUsuarioId());
				kardex.setdFechaInserta(Fechas.getDate());
				kardex.setcEstadoCodigo(Constantes.estadoActivo);
				kardex.setiPeriodoId(iPeriodoId);*/
				//listaKardexs.add(kardex);
				//pro.setKardexs(listaKardexs);
				//productoDao.persistEndidad(kardex);
				
				
				 
					/**Insertamos en el libro Dirio la cuenta de Mercaredia 
				 * 20(Mercaderia) y
				 * 201(Almacem)
				 * id=57; 201: mercaderia/ Almacen**/			
				/*Librodiario libroDiario = new Librodiario();
				libroDiario.setcEstadoCodigo(Constantes.estadoActivo);
				libroDiario.setCuenta(productoDao.findEndidad(Cuenta.class, 57));
				libroDiario.setfMonto(kardex.getiCantExistencia()*kardex.getfPuExistencia());
				libroDiario.setvTipoConcepto(Constantes.debe);
				libroDiario.setvConceptoGeneral("MERCADERIA / ALmacen ");
				libroDiario.setdFechaInserta(Fechas.getDate());
				libroDiario.setiUsuarioInsertaId(usu.getiUsuarioId());
				libroDiario.setKardex(kardex);
				libroDiario.setiPeriodoId(iPeriodoId);
				productoDao.persistEndidad(libroDiario);
				*/
						
				
				 resultado = productoDao.commitEndidad(transaccion);
				// productoDao.refreshEndidad(pro);
				if(pForm.getvImprimir().equals("SI")){
					reporte(mapping, pForm, request, response);
					resultado=true;
					
				}
			} 
		    /**Insertamos Datos del producto como Insumos **/
			if (pForm.getMode().equals("II")) {			
				pro.setdFechaInserta(Fechas.getDate());
				pro.setiUsuarioInsertaId(usu.getiUsuarioId());			
				productoDao.persistEndidad(pro);
			    resultado = productoDao.commitEndidad(transaccion);
			    productoDao.refreshEndidad(pro);
				
			}
			/***
             * UE: INSERCION DE ENTRADA.
             * US: INSERCION DE SALIDA
             */
			/**Insertamos Datos del producto y de insumo **/		
			else if (pForm.getMode().equals("UE") || pForm.getMode().equals("US")) {	
				
				/******************************************/
				/**Insertamos la gestion de la produccion**/
				/******************************************/
				Distalmacen distAlmacen= new Distalmacen();
				distAlmacen =  productoDao.findEndidad(Distalmacen.class,DistBean.getiDistAlmacenId());
				distAlmacen= Util.comparar(distAlmacen, DistBean);
				distAlmacen.setdFechaActualiza(Fechas.getDate());
				distAlmacen.setiUsuarioActualizaId(usu.getiUsuarioId());
				
				productoDao.mergeEndidad(distAlmacen);
				
				
				/***********************************/
				/** Registro de produccion detalle**/
				/***********************************/
				 
				listaDistDetalle = (List<Distalmacendetalle>) sesion.getAttribute("listaDistAlmacenDetalle");
				Distalmacendetalle proDeOriginal= new Distalmacendetalle();
			    Producto material= new Producto();
			    int cantidad;
			    
				for(Distalmacendetalle prodeta:listaDistDetalle){
					if(prodeta.getcEstadoCodigo().equals(Constantes.estadoActivo)){
				
				
					
					/*****************************************/
					/** Reducimos el stock de los materiales**/
					/*****************************************/
					    
					    material= productoDao.findEndidad(Producto.class, prodeta.getProducto().getiProductoId()) ;					    
					   
					    if(prodeta.getiDistAlmacenDetId()>0){
					    	/// exite producto  en el detalle original y se cambia la cantidad
					    	proDeOriginal= productoDao.findEndidadBD(Distalmacendetalle.class,"iDistAlmacenDetId", prodeta.getiDistAlmacenDetId());
					    	cantidad= proDeOriginal.getiCantidad()-prodeta.getiCantidad()+material.getiProductoStockTotal();
					    }
					    else{
					    	// cuando se agrega nueva materia prima
					    	cantidad= material.getiProductoStockTotal()-prodeta.getiCantidad();
					    }
					    material.setiProductoStockTotal(cantidad); 
					  
					}
					
					if(prodeta.getiDistAlmacenDetId()>0 && prodeta.getcEstadoCodigo().equals(Constantes.estadoInactivo)){
						cantidad= material.getiProductoStockTotal()+prodeta.getiCantidad();
					}
					/// actualizamos cantidad
					  productoDao.mergeEndidad(material);						
						prodeta.setDistAlmacen(distAlmacen);
						productoDao.mergeEndidad(prodeta);
				}
			
			   
				
				
				/*
				*//**Actualizamos los valores de la existencia del Kardex **//*
				*//**si no existe ningun tipo de movimiento (Compras o ventas)**//*
				if(pForm.getSizeIngresoproductodetalles()==0 && pForm.getSizeVentaDetalles()==0){
					int iKardexId=0;
					List<Kardex> kardex = kardexDao.buscarKardexProducto(pro.getiProductoId());
					iKardexId=kardex.get(0).getiKardexId();
					kardex.get(0).setiCantExistencia(pro.getiProductoStockTotal());
					kardex.get(0).setfPuExistencia(pro.getfProductoPrecioCompra());
				    kardex.get(0).setfTotalExistencia(kardex.get(0).getiCantExistencia()*kardex.get(0).getfPuExistencia());
					kardex.get(0).setiUsuarioActualizaId(usu.getiUsuarioId());
					kardex.get(0).setdFechaActualiza(Fechas.getDate());
					
					productoDao.mergeEndidad(kardex.get(0));
									
					*//**Actualizamos los valores de la existencias del libro diario la cuenta de Mercaredia **//*
					
					List<Librodiario> librodiario= kardexDao.buscarLibroDiarioKardex(iKardexId);
					for(Librodiario listaLibros:librodiario ){
						*//**
						 * 20(Mercaderia) y
						 * 201(Almacem)
						 * id=57; 201: mercaderia/ Almacen**//*	
						
						
						*//**Insertamos en el libro Dirio la cuenta de Mercaredia 
						 * 50(Capital) y 
						 * '212', '5', '50', 'CAPITAL'**//*
						
						listaLibros.setfMonto(kardex.get(0).getfTotalExistencia());
						listaLibros.setiUsuarioActualizaId(usu.getiUsuarioId());
						listaLibros.setdFechaActualiza(Fechas.getDate());
						
						productoDao.mergeEndidad(listaLibros);
					}
					
				
				}*/
				
				 productoDao.mergeEndidad(distAlmacen);
				 resultado = productoDao.commitEndidad(transaccion);
				 
				 if(pForm.getvImprimir().equals("SI")){
						reporte(mapping, pForm, request, response);
						resultado=true;
					}

				 
			}
			 else if (mode.equals("D")) { 	        	
					productoDao.eliminarUnaEndidad(DistBean, "iDistAlmacenDetId", ids);/**/
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
		 * @throws NoSuchFieldException 
		 * @throws IllegalAccessException 
		 * @throws ClassNotFoundException 
		 * @throws SecurityException 
		 * @throws IllegalArgumentException 
		 */
		@SuppressWarnings({ "unchecked", "deprecation" })
		public ActionForward iduOrdenCompra(ActionMapping mapping, ActionForm form,
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
					    material= productoDao.findEndidad(Producto.class, prodeta.getProducto().getiProductoId()) ;
					    cantidad= material.getiProductoStockTotal()-prodeta.getiCantidad();
					    material.setiProductoStockTotal(cantidad); 
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
				kardex.setiCantExistencia(pro.getiProductoStockTotal());
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
				preciosProducto.setiCantidadStock(pro.getiProductoStockTotal());
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
				Librodiario libroDiario = new Librodiario();
				libroDiario.setcEstadoCodigo(Constantes.estadoActivo);
				libroDiario.setCuenta(productoDao.findEndidad(Cuenta.class, 57));
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
				produccion =  productoDao.findEndidad(Produccion.class,produBean.getiProduccionId());
				produccion= Util.comparar(produccion, produBean);
				produccion.setdFechaActualiza(Fechas.getDate());
				produccion.setiUsuarioActualiza(usu.getiUsuarioId());
				
				productoDao.mergeEndidad(produccion);
				
				/***********************************/
				/** Registro de producto**/
				/***********************************/		
				 pro =  productoDao.findEndidad(Producto.class,pForm.getProducto().getiProductoId());
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
					    
					    material= productoDao.findEndidad(Producto.class, prodeta.getProducto().getiProductoId()) ;					    
					   
					    if(prodeta.getiProduccionDetalleId()>0){
					    	/// exite producto  en el detalle original y se cambia la cantidad
					    	proDeOriginal= productoDao.findEndidadBD(Producciondetalle.class,"iProduccionDetalleId", prodeta.getiProduccionDetalleId());
					    	cantidad= proDeOriginal.getiCantidad()-prodeta.getiCantidad()+material.getiProductoStockTotal();
					    }
					    else{
					    	// cuando se agrega nueva materia prima
					    	cantidad= material.getiProductoStockTotal()-prodeta.getiCantidad();
					    }
					    material.setiProductoStockTotal(cantidad); 
					  
					}
					
					if(prodeta.getiProduccionDetalleId()>0 && prodeta.getcEstadoCodigo().equals(Constantes.estadoInactivo)){
						cantidad= material.getiProductoStockTotal()+prodeta.getiCantidad();
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
		      			pro.setiProductoStockTotal(cantidadProducto);
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
					kardex.get(0).setiCantExistencia(pro.getiProductoStockTotal());
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
					
					Producto producto  = genericaDao.findEndidad(Producto.class,iProductoId);	
					
					productoBean.setiProductoId(producto.getiProductoId());
					productoBean.setcProductoCodigo(producto.getcProductoCodigo());
					productoBean.setvProductoNombre(producto.getvProductoNombre());
					productoBean.setUnidadMedida(producto.getUnidadMedida());
					//productoBean.setiUMPedido(producto.getiUMPedido());
					productoBean.setfProductoGanancia(fGanancia);
					productoBean.setfProductoPrecioVenta(fPrecioVenta);
					productoBean.setiProductoStockTotal(producto.getiProductoStockTotal());
					producciondetalle.setvDescripcion(productoBean.getvProductoNombre());
					
					if(iPersonalId>0){
						Personal personalBean= new Personal();
						Personal personal= new Personal();
						personal=genericaDao.findEndidad(Personal.class,iPersonalId);	
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
				List<Produccion> listaProducccion = null;
				if ("producto-kardex".equals(plantilla)) {

					int iProductoId = Integer.parseInt(request.getParameter("id"));
					String cInsumo = "";
					obj.setiProductoId(iProductoId);
					if (objform.getdFechaInicio() != null
							&& objform.getdFechaFin() != null) {
						obj.setdFechaInserta(Fechas.fechaDate(objform.getdFechaInicio()));
						obj.setdFechaActualiza(Fechas.fechaDate(objform.getdFechaFin()));
					}
					listaKardex = kardexDao.listaKardex(0, 1000, obj, cInsumo);
					obj = productoDao.findEndidad(Producto.class, iProductoId);
					
				} else if ("produccion".equals(plantilla)) {
					listaProducccion =  productoDao.listaProduccion(0,100, objform.getProduccion());
				} else {
					int iclasificacionId = Integer.parseInt(request.getParameter("iclasificacionId"));
					productos = productoDao.listaProducto(0, 1000, obj, iclasificacionId,0);
					
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

				} else if ("produccion".equals(plantilla)) {
					beans.put("productosInternos", listaProducccion);
				}

				return beans;

			}
			
			@Override
			public void cargarContenidoImprimir(ActionForm form,
					HttpServletRequest request, Impresora impresora,
					ActionMapping mapping, HttpServletResponse response)
					throws IllegalAccessException, IOException,
					IllegalArgumentException, SecurityException,
					ClassNotFoundException, NoSuchFieldException,
					ParseException {
				// TODO Auto-generated method stub
				
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
			public ActionForward detalleAlmacen(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response)
					throws IOException {

				response.setContentType("text/json");
				HttpSession sesion = request.getSession();

				Gson gson = new Gson();
				GenericaDao productoDao = new GenericaDao();
				VentaDao ventaDao = new VentaDao();
				int iProductoId = Integer.parseInt(request.getParameter("id"));
				String mode = request.getParameter("mode");
				Usuario usu = (Usuario) sesion.getAttribute("Usuario");
				int iPeriodoId = (Integer) sesion.getAttribute("iPeriodoId");
				String tipo=request.getParameter("tipo");
				/** Instanciamos la Clase VentaForm **/
				Producto productoBean = new Producto();
				List<Distalmacendetalle> listaAlmacen = (List<Distalmacendetalle>) sesion
								.getAttribute("listaDistAlmacenDetalle");		
				/*List<Ordencompradetalle> listaOrdenCompra = (List<Ordencompradetalle>) sesion
								.getAttribute("listaOrdenCompraDetalle");
				*/	
						
						
					
				
				/** Iniciamos instacia de transacion **/
				//

				try {

					if (mode.equals("I")) {
						Distalmacendetalle almacenDetalle = new Distalmacendetalle();
						Ordencompradetalle ordeCompraDetalle = new Ordencompradetalle();
						// lista = new ArrayList<Ventadetalle>();
						int iCantidad = Integer.parseInt(request
								.getParameter("iCantidad"));
						float fDescuento = Float.parseFloat(request
								.getParameter("fDescuento"));
						float fPrecioVenta = Float.parseFloat(request
								.getParameter("fPrecioVenta"));
						float fPrecioCompra = Float.parseFloat(request
								.getParameter("fPrecioCompra"));
						float fTotal = Float.parseFloat(request.getParameter("fTotal"));
						
						Producto producto = productoDao.findEndidad(Producto.class, iProductoId);

						productoBean.setiProductoId(producto.getiProductoId());
						productoBean.setcProductoCodigo(producto.getcProductoCodigo());
						productoBean.setvProductoNombre(producto.getvProductoNombre());

						productoBean.setUnidadMedida(producto.getUnidadMedida());
						productoBean.setiUMBase(producto.getiUMBase());
						productoBean.setUmBase(producto.getUmBase());
						productoBean.setiUMPedido(producto.getiUMPedido());
						productoBean.setUmPedido(producto.getUmPedido());
						productoBean.setiUMSalida(producto.getiUMSalida());
						productoBean.setUmSalida(producto.getUmSalida());
						productoBean.setfProductoPrecioVenta(producto
								.getfProductoPrecioVenta());
						productoBean.setiProductoStockTotal(producto
								.getiProductoStockTotal());
						productoBean.setfProductoPrecioCompra(fPrecioCompra);
						productoBean.setfProductoDescuento(fDescuento);

						almacenDetalle.setProducto(productoBean);
						almacenDetalle.setfTotal(fTotal);
						almacenDetalle.setfPrecioUnitario(fPrecioVenta);
						almacenDetalle.setiCantidad(iCantidad);
						almacenDetalle.setfTotal(fTotal);
						almacenDetalle.setdFechaInserta(Fechas.getDate());
						almacenDetalle.setiUsuarioInsertaId(usu.getiUsuarioId());
						almacenDetalle.setcEstadoCodigo(Constantes.estadoActivo);
						
						
						ordeCompraDetalle.setProducto(productoBean);
						ordeCompraDetalle.setfTotal(fTotal);
						ordeCompraDetalle.setfPrecioUnitario(fPrecioVenta);
						ordeCompraDetalle.setiCantidad(iCantidad);
						ordeCompraDetalle.setfTotal(fTotal);
						ordeCompraDetalle.setdFechaInserta(Fechas.getDate());
						ordeCompraDetalle.setiUsuarioInsertaId(usu.getiUsuarioId());
						ordeCompraDetalle.setcEstadoCodigo(Constantes.estadoActivo);
						

						listaAlmacen.add(almacenDetalle);
					/*	listaOrdenCompra.add(ordeCompraDetalle);*/
						sesion.setAttribute("listaDistAlmacenDetalle", listaAlmacen);
						// ventaDao.persistEndidad(ventadetalle);
						// ventaDao.commitEndidad(entityTransaction);
					}
					if (mode.equals("D")) {
						if (listaAlmacen.get(iProductoId).getcEstadoCodigo()
								.equals(Constantes.estadoActivo))
							listaAlmacen.get(iProductoId).setcEstadoCodigo(
									Constantes.estadoInactivo);
						else
							listaAlmacen.get(iProductoId).setcEstadoCodigo(
									Constantes.estadoActivo);

						sesion.setAttribute("listaDistAlmacenDetalle", listaAlmacen);
						// ventaDao.mergeEndidad(lista.get(iProductoId));
						// ventaDao.commitEndidad(entityTransaction);
					}
					if (mode.equals("U")) {
						int iCantidad = Integer.parseInt(request
								.getParameter("iCantidad"));
						float fDescuento = Float.parseFloat(request
								.getParameter("fDescuento"));
						float fPrecioVenta = Float.parseFloat(request
								.getParameter("fPrecioVenta"));
						float fPrecioVentaFinal = (fPrecioVenta - fPrecioVenta
								* fDescuento / 100);

						listaAlmacen.get(iProductoId).setfPrecioUnitario(fPrecioVenta);
						listaAlmacen.get(iProductoId).setfTotal(
								(fPrecioVentaFinal * iCantidad));
						listaAlmacen.get(iProductoId).setiCantidad(iCantidad);
						

						// sesion.setAttribute("listaVentaDetalle", lista);

					}
					if(mode.equals("ID")) {
						/***
						 * iProductoId: iDistAlmacenId
						 */
						sesion.removeAttribute("listaDistAlmacenDetalle");
						listaAlmacen = new ArrayList<Distalmacendetalle>();
						Distalmacen disAlmacen = productoDao.findEndidad(Distalmacen.class, iProductoId);
						
						for(Distalmacendetalle detalleAlmacen: disAlmacen.getDistAlmacendetalles()){
							Distalmacendetalle almacenDetalle = new Distalmacendetalle();
							productoBean = new Producto();
							Distalmacen alma = new Distalmacen();
							almacenDetalle.setiDistAlmacenDetId(detalleAlmacen.getiDistAlmacenDetId());
							almacenDetalle.setcEstadoCodigo(detalleAlmacen.getcEstadoCodigo());
							almacenDetalle.setdFechaSalida(detalleAlmacen.getdFechaSalida());
							almacenDetalle.setfPrecioUnitario(detalleAlmacen.getfPrecioUnitario());
							almacenDetalle.setfTotal(detalleAlmacen.getfTotal());
							almacenDetalle.setiCantidad(detalleAlmacen.getiCantidad());
							alma.setiDistAlmacenId(disAlmacen.getiDistAlmacenId());
							alma.setAlmacenSalida(disAlmacen.getAlmacenSalida());
							alma.setAlmacenEntrada(disAlmacen.getAlmacenEntrada());
							alma.setdFechaSalida(disAlmacen.getdFechaSalida());
							alma.setvNroSalida(disAlmacen.getvNroSalida());
							alma.setvPuntoSalida(disAlmacen.getvPuntoSalida());
							alma.setvPuntoLlegada(disAlmacen.getvPuntoLlegada());
							alma.setvObservacion(disAlmacen.getvObservacion());
							Personal personalEntrega = new Personal();
							Personal personalRecepcion = new Personal();
							personalEntrega.setiPersonalId(disAlmacen.getUsuatioEntrega().getiPersonalId());
							personalEntrega.setcPersonalCodigo(disAlmacen.getUsuatioEntrega().getcPersonalCodigo());
							personalEntrega.setvPersonalNombres(disAlmacen.getUsuatioEntrega().getvPersonalNombres());
							personalEntrega.setvPersonalApellidoPaterno(disAlmacen.getUsuatioEntrega().getvPersonalApellidoPaterno());
							
							personalRecepcion.setiPersonalId(disAlmacen.getUsuarioRecepcion().getiPersonalId());
							personalRecepcion.setcPersonalCodigo(disAlmacen.getUsuarioRecepcion().getcPersonalCodigo());
							personalRecepcion.setvPersonalNombres(disAlmacen.getUsuarioRecepcion().getvPersonalNombres());
							personalRecepcion.setvPersonalApellidoPaterno(disAlmacen.getUsuarioRecepcion().getvPersonalApellidoPaterno());
							
							alma.setUsuatioEntrega(personalEntrega);
							alma.setUsuarioRecepcion(personalRecepcion);
							alma.setfTotal(disAlmacen.getfTotal());
							almacenDetalle.setDistAlmacen(alma);
							
							
							productoBean.setiProductoId(detalleAlmacen.getProducto().getiProductoId());
							productoBean.setvProductoNombre(detalleAlmacen.getProducto().getvProductoNombre());
							productoBean.setcProductoCodigo(detalleAlmacen.getProducto().getcProductoCodigo());
							productoBean.setUnidadMedida(detalleAlmacen.getProducto().getUnidadMedida());
							productoBean.setfProductoDescuento(detalleAlmacen.getProducto().getfProductoDescuento());
							productoBean.setfProductoPrecioVenta(detalleAlmacen.getProducto().getfProductoPrecioVenta());
							productoBean.setiProductoStockTotal(detalleAlmacen.getProducto().getiProductoStockTotal());
							
							almacenDetalle.setProducto(productoBean);
							listaAlmacen.add(almacenDetalle);
						}
						sesion.setAttribute("listaDistAlmacenDetalle", listaAlmacen);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					ventaDao.limpiarInstancia();
				}

				String jsonOutput = gson.toJson(listaAlmacen);

				// response.getWriter().write(json);

				PrintWriter pw;
				pw = response.getWriter();
				pw.write(jsonOutput);
				System.out.println(jsonOutput.toString());
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
				@SuppressWarnings("unchecked")
				public ActionForward json(ActionMapping mapping, ActionForm form,
							HttpServletRequest request, HttpServletResponse response) throws IOException{
		      
					response.setContentType("text/json");	
								
					Gson gson = new Gson();			
					GenericaDao genericaDao = new GenericaDao();
					int id = Integer.parseInt(request.getParameter("id"));
					String mode = request.getParameter("mode");
					String jsonOutput = "";
					
				
					if(mode.equals("almacen")){
						Almacen lista=genericaDao.findEndidadBD(Almacen.class, "iAlmacenId", id);
						jsonOutput = gson.toJson(lista);
					}
					if(mode.equals("servicio")){
						Producto listas=genericaDao.findEndidadBD(Producto.class, "iProductoId", id);
						ProductoVo lista = new ProductoVo();
						lista.setfProductoPrecioVenta(listas.getfProductoPrecioVenta());
						jsonOutput = gson.toJson(lista);
					}
					
			     
					
					
					
					//response.getWriter().write(json);
					
					PrintWriter pw;
					pw = response.getWriter();
				
					pw.write(jsonOutput);
				
					System.out.println( jsonOutput.toString() );
					
					pw.flush();
					pw.close();
						
					
					return null;
					
				}
				@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
				public ActionForward reporte(ActionMapping mapping, ActionForm form,
						HttpServletRequest request, HttpServletResponse response)
						throws ParseException, IOException, JRException {

					ProductoDao ventaDao = new ProductoDao();
					/** Instanciamos la Clase VentaForm **/
					ProductosForm objform = (ProductosForm) form;

					String id = (request.getParameter("id"));
					String tipo = request.getParameter("tipo");
					String reportPath = "";

					HttpServletRequestWrapper srw = new HttpServletRequestWrapper(request);
					Map param = new HashMap();
					param.put("fechaActual", Fechas.getDate());

					reportPath = srw.getRealPath("/inventario/distribucionAlmacen/reportes/reportDistSalida.jasper");

						
					List<Distalmacen> listOfShoppingCart = ventaDao.listaDistAlmacen(0, 10000,
							objform.getDistAlmacen());
					JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
							listOfShoppingCart);

					JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath,param, beanCollectionDataSource);
					HttpServletResponse httpServletResponse = (HttpServletResponse) response;
					httpServletResponse.addHeader("Content-disposition","attachment; filename=reportDistribucion.pdf");
					ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint,servletOutputStream);

                    ByteArrayOutputStream baos =new ByteArrayOutputStream();
                    baos.writeTo(servletOutputStream);

					servletOutputStream.flush();
					servletOutputStream.close();

					return null;

				}
}