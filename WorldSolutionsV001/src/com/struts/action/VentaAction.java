package com.struts.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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

import com.dao.ContabilidadDao;
import com.dao.EstadoDao;
import com.dao.GenericaDao;
import com.dao.KardexDao;
import com.dao.VentaDao;
import com.entities.Cliente;
import com.entities.Direccioncliente;
import com.entities.Estado;
import com.entities.Formapago;
import com.entities.Kardex;
import com.entities.Mediopago;
import com.entities.Moneda;
import com.entities.Personal;
import com.entities.Preciosproducto;
import com.entities.Producto;
import com.entities.Tipodocumentogestion;
import com.entities.Unidadmedida;
import com.entities.Usuario;
import com.entities.Venta;
import com.entities.Ventadetalle;
import com.entities.Ventadevolucion;
import com.entities.Ventadevoluciondetalle;
import com.google.gson.Gson;
import com.struts.form.VentaForm;
import com.util.Constantes;
import com.util.Fechas;
import com.util.FormatosNumeros;
import com.util.Impresora;
import com.util.ImpresoraVO;
import com.util.Paginacion;
import com.util.Util;

public class VentaAction extends BaseAction {
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
	 * @throws ParseException
	 * @throws IOException
	 * @throws JRException
	 */
	public ActionForward listaVenta(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ParseException, IOException, JRException {

		/*** Validamos la session activa y logeada ***/
		// HttpSession sesion = request.getSession();
		String msn = "";
		/*
		 * if(sesion.getId()!=(sesion.getAttribute("id"))){
		 * response.sendRedirect("login.do?metodo=logout"); } else{
		 */
		/*** Inicializamos variables ***/
		int pagina = Paginacion.paginaInicial;
		int pagInicio = Paginacion.paginaInicial;
		if (request.getParameter("pagina") != null) {
			pagina = Integer.parseInt(request.getParameter("pagina"));
		}
		String mode = request.getParameter("mode");
		/** Seteamos los valores en las listas **/
		List<Venta> listaVenta = new ArrayList<Venta>();
		List<Venta> listaVentaTotal = new ArrayList<Venta>();
		List<Long> paginas = new ArrayList<Long>();

		/** Instanciamos la Clase VentaForm **/
		VentaForm objform = (VentaForm) form;

		/** Instanciamos las clase Daos **/
		VentaDao ventaDao = new VentaDao();

		HttpSession sesion = request.getSession();
		Usuario usu = (Usuario) sesion.getAttribute("Usuario");
		
		if (!Constantes.usuAdministrador.equals(usu.getPerfil()
				.getvPerfilDescripcion())) {
			objform.getVenta().setSucursal(usu.getSucursal());
		}

		/** Lista de personal en Modal Popup ***/
		if (mode != null) {

			if (mode.equals("pdf")) {
				reporteVenta(mapping, objform, request, response);
			}

			/** Lista de ventas en Modal Popup ventas ***/
			/**
			 * Lista de compras en Modal Popup compras LP: lista popup para
			 * devoluciones de ventas LPL: lista popup para cargar la factura la
			 * cual se generara la letra
			 ***/

			else if (mode != null && (mode.equals("LP") || mode.equals("LPL"))) {
				listaVenta = ventaDao.listaVenta(Paginacion.pagInicio(pagina),
						Paginacion.pagFin(), objform.getVenta());

				/** Consultamos el total de registros segun criterio **/
				listaVentaTotal = ventaDao.listaVenta(
						Paginacion.pagInicio(pagInicio),
						Paginacion.pagFinMax(), objform.getVenta());

				/** Obtenemos el total del paginas ***/
				paginas = Paginacion
						.listPaginas((long) (listaVentaTotal.size()));
				objform.setLista(listaVenta);

				msn = "showListPopupVentas";

			}

			/** Lista de ventas en el modulo de Contabilidad ***/
			else if (mode.equals("LContabilidad")) {
				listaVenta = ventaDao.listaVenta(Paginacion.pagInicio(pagina),
						Paginacion.pagFin(), objform.getVenta());

				/** Consultamos el total de registros segun criterio **/
				listaVentaTotal = ventaDao.listaVenta(
						Paginacion.pagInicio(pagInicio),
						Paginacion.pagFinMax(), objform.getVenta());

				/** Obtenemos el total del paginas ***/
				paginas = Paginacion
						.listPaginas((long) (listaVentaTotal.size()));
				objform.setLista(listaVenta);

				msn = "showListVentaContabilidad";

			}

		}// if mode != null

		else {

			listaVenta = ventaDao.listaVenta(Paginacion.pagInicio(pagina),
					Paginacion.pagFin(), objform.getVenta());

			/** Consultamos el total de registros segun criterio **/
			listaVentaTotal = ventaDao.listaVenta(
					Paginacion.pagInicio(pagInicio), Paginacion.pagFinMax(),
					objform.getVenta());

			/** Obtenemos el total del paginas ***/
			paginas = Paginacion.listPaginas((long) (listaVentaTotal.size()));

			objform.setLista(listaVenta);

			/*** Redirecionamos al ***/
			msn = "showList";

		}
		/** Seteamos las clase VentaForm **/

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
	 * @throws ParseException
	 * @throws IOException
	 */
	public ActionForward listaVentaDevolucion(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ParseException, IOException {

		/*** Validamos la session activa y logeada ***/
		String msn = "";

		/*** Inicializamos variables ***/

		int pagina = Paginacion.paginaInicial;
		int pagInicio = Paginacion.paginaInicial;
		if (request.getParameter("pagina") != null) {
			pagina = Integer.parseInt(request.getParameter("pagina"));
		}
		/** Seteamos los valores en las listas **/
		List<Ventadevolucion> listaVentaDevolucion = new ArrayList<Ventadevolucion>();
		List<Ventadevolucion> VentadevolucionTotal = new ArrayList<Ventadevolucion>();
		List<Long> paginas = new ArrayList<Long>();

		/** Instanciamos la Clase VentaForm **/
		VentaForm ventaform = (VentaForm) form;

		/** Instanciamos las clase Daos **/
		VentaDao ventaDao = new VentaDao();

		HttpSession sesion = request.getSession();
		Usuario usu = (Usuario) sesion.getAttribute("Usuario");
		if (!Constantes.usuAdministrador.equals(usu.getPerfil()
				.getvPerfilDescripcion())) {
			ventaform.getVenta().setSucursal(usu.getSucursal());
		}

		listaVentaDevolucion = ventaDao.listaVentaDevolucion(
				Paginacion.pagInicio(pagina), Paginacion.pagFin(),
				ventaform.getVenta());

		/** Consultamos el total de registros segun criterio **/
		VentadevolucionTotal = ventaDao.listaVentaDevolucion(
				Paginacion.pagInicio(pagInicio), Paginacion.pagFinMax(),
				ventaform.getVenta());

		/** Obtenemos el total del paginas ***/
		paginas = Paginacion.listPaginas((long) (VentadevolucionTotal.size()));

		ventaform.setLista(listaVentaDevolucion);

		/*** Redirecionamos al ***/
		msn = "showListVentaDevolucion";

		/** Seteamos las clase VentaForm **/

		ventaform.setPaginas(paginas);
		ventaform.setPagInicio(pagina);
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
	 */
	public ActionForward mantenimientoVentaDevolucion(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession sesion = request.getSession();
		String mode = request.getParameter("mode");
		String msn = "";

		/** Instantacia al VentaForm **/
		VentaForm ventaform = (VentaForm) form;

		/** Instantacia a la capa Dao **/
		VentaDao ventaDao = new VentaDao();

		/** llamado de los metodos de la clase dao **/

		List<Estado> listaEstado = ventaDao
				.listaEntidadGenericaSinCodigo("Estado");
		List<Ventadetalle> lista = new ArrayList<Ventadetalle>();
		List<Ventadetalle> listadev = new ArrayList<Ventadetalle>();
		List<Ventadevoluciondetalle> listadevOriginal = new ArrayList<Ventadevoluciondetalle>();
		List<Formapago> listaFormapago = ventaDao
				.listaEntidadGenericaSinCodigo("Formapago");
		List<Tipodocumentogestion> listaTipoDoc = ventaDao
				.listaEntidadGenericaSinCodigo("Tipodocumentogestion");
		List<Estado> listaEstadoDocumento = Util.listaEstadoDocumento();
		Moneda moneda = (Moneda) sesion.getAttribute("Moneda");
		ventaform.setTipoMoneda(moneda.getcModenaCodigo());
		ventaform.setIGVVentas(sesion.getAttribute("IGVVentas").toString());
		Usuario usu = (Usuario) sesion.getAttribute("Usuario");
		List<ImpresoraVO> listaImpresora = Impresora.listarImpresoras();
		// List<Tipodocumentogestion> listaDocumentoGestion =
		// Util.listaDocGest();
		/**
		 * LLamamos al formulario mantenimientoVenta.jsp para la insercion de
		 * datos
		 **/
		msn = "showEditVentaDevolucion";
		if (mode.equals("I")) {
			/*** LISTA DE DETALLE VENTA ***/
			sesion.removeAttribute("listaVentaDetalle");
			sesion.removeAttribute("listaVentaDetalleCompra");
			sesion.removeAttribute("listaVentaDetalleOriginal");
			ventaform.getVentaDev().setnNroNotaCredito(
					ventaDao.callSPNro_Documento(7, "ventaDevolucion",
							"nNroNotaCredito",usu.getSucursal().getiSucursalId()));

		}

		/**
		 * LLamamos al formulario mantenimientoVenta.jsp para mostrar los datos
		 * del UPDATE
		 **/
		/** Seteamos el ventaform la clase Venta **/
		else if (mode.equals("U")) {

			int id = Integer.parseInt(request.getParameter("id"));
			Ventadevolucion ventaDev = ventaDao.findEndidad(
					ventaform.getVentaDev(), id);
			ventaform.setVentaDev(ventaDev);
			ventaform.setVenta(ventaDev.getVenta());
			ventaform.setvClienteDireccion(ventaDev.getVenta().getCliente()
					.getDireccionclientes().get(0).getvDireccion());

			/*** COMPRAS FACTURA, BOLETA, NOTA DE PEDIDO ***/
			/*** LISTA DE DETALLE DE COMPRAS ***/
			sesion.removeAttribute("listaVentaDetalleCompra");
			/** Agregamos a la session el detalle de la devolucion ***/
			sesion.removeAttribute("listaVentaDetalle");
			sesion.removeAttribute("listaVentaDetalleOriginal");

			for (Ventadetalle e : ventaDev.getVenta().getVentadetalles()) {
				for (Ventadevoluciondetalle eobj : ventaDev
						.getVentadevoluciondetalles()) {
					if (e.getcEstadoCodigo().equals(Constantes.estadoActivo)
							&& e.getProducto()
									.getcProductoCodigo()
									.equals(eobj.getProducto()
											.getcProductoCodigo())) {

						Venta venta = new Venta();
						Ventadetalle ventaDetalle = new Ventadetalle();
						Cliente cliente = new Cliente();

						venta.setiVentaId(e.getVenta().getiVentaId());
						venta.setfVentaIGV(e.getVenta().getfVentaIGV());
						venta.setfVentaSubTotal(e.getVenta()
								.getfVentaSubTotal());
						venta.setfVentaTotal(e.getVenta().getfVentaTotal());
						venta.setdVentaFecha(e.getVenta().getdVentaFecha());
						venta.setnVentaNumero(e.getVenta().getnVentaNumero());
						venta.setvEstadoDocumento(e.getVenta()
								.getvEstadoDocumento());
						venta.setFormaPago(e.getVenta().getFormaPago());
						venta.setTipoDocumento(e.getVenta().getTipoDocumento());

						cliente.setiClienteId(e.getVenta().getCliente()
								.getiClienteId());
						cliente.setvClienteRazonSocial(e.getVenta()
								.getCliente().getvClienteRazonSocial());
						cliente.setvNombreCliente(e.getVenta().getCliente()
								.getvNombreCliente());
						cliente.setvClienteCodigo(e.getVenta().getCliente()
								.getvClienteCodigo());

						venta.setCliente(cliente);

						ventaDetalle.setVenta(venta);

						ventaDetalle.setcEstadoCodigo(Constantes.estadoActivo);
						ventaDetalle.setiVentaDetalleCantidad(e
								.getiVentaDetalleCantidad());
						ventaDetalle.setfVentaDetallePrecio(e
								.getfVentaDetallePrecio());
						ventaDetalle.setfVentaDetalleTotal(e
								.getfVentaDetalleTotal());
						ventaDetalle.setfDescuento(e.getfDescuento());

						Producto productoBean = new Producto();

						productoBean.setiProductoId(e.getProducto()
								.getiProductoId());
						productoBean.setcProductoCodigo(e.getProducto()
								.getcProductoCodigo());
						productoBean.setvProductoNombre(e.getProducto()
								.getvProductoNombre());
						productoBean.setUnidadMedida(e.getProducto()
								.getUnidadMedida());
						productoBean.setiUMBase(e.getProducto().getiUMBase());
						productoBean.setfProductoPrecioVenta(e.getProducto()
								.getfProductoPrecioVenta());
						productoBean.setfProductoPrecioCompra(e.getProducto()
								.getfProductoPrecioCompra());

						ventaDetalle.setProducto(productoBean);

						lista.add(ventaDetalle);

						/**
						 * agregamos a la listadev el detalle de la devolucion
						 * de los productos
						 **/
						venta = new Venta();
						ventaDetalle = new Ventadetalle();

						venta.setiVentaId(eobj.getVentadevolucion().getVenta()
								.getiVentaId());
						venta.setfVentaIGV(eobj.getVentadevolucion().getVenta()
								.getfVentaIGV());
						venta.setfVentaSubTotal(eobj.getVentadevolucion()
								.getVenta().getfVentaSubTotal());
						venta.setfVentaTotal(eobj.getVentadevolucion()
								.getVenta().getfVentaTotal());
						venta.setdVentaFecha(eobj.getVentadevolucion()
								.getVenta().getdVentaFecha());
						venta.setnVentaNumero(eobj.getVentadevolucion()
								.getVenta().getnVentaNumero());
						venta.setvEstadoDocumento(eobj.getVentadevolucion()
								.getVenta().getvEstadoDocumento());
						venta.setFormaPago(eobj.getVentadevolucion().getVenta()
								.getFormaPago());
						venta.setTipoDocumento(eobj.getVentadevolucion()
								.getVenta().getTipoDocumento());
						venta.setCliente(cliente);

						ventaDetalle.setVenta(venta);

						productoBean = new Producto();

						productoBean.setiProductoId(eobj.getProducto()
								.getiProductoId());
						productoBean.setcProductoCodigo(eobj.getProducto()
								.getcProductoCodigo());
						productoBean.setvProductoNombre(eobj.getProducto()
								.getvProductoNombre());
						productoBean.setUnidadMedida(eobj.getProducto()
								.getUnidadMedida());
						productoBean
								.setiUMBase(eobj.getProducto().getiUMBase());
						productoBean.setfProductoPrecioVenta(eobj.getProducto()
								.getfProductoPrecioVenta());
						productoBean.setfProductoPrecioCompra(eobj
								.getProducto().getfProductoPrecioCompra());

						ventaDetalle.setProducto(productoBean);

						ventaDetalle.setProducto(productoBean);
						ventaDetalle.setfVentaDetallePrecio(eobj
								.getfVentaDevDetallePrecio());
						ventaDetalle.setfVentaDetalleTotal(eobj
								.getfVentaDevDetalleTotal());
						ventaDetalle.setiVentaDetalleCantidad(eobj
								.getiVentaDevDetalleCantidad());
						ventaDetalle.setiVentaDetalleId(eobj
								.getiVentaDevolucionDetalleId());
						ventaDetalle.setcEstadoCodigo(eobj.getcEstadoCodigo());
						ventaDetalle.setfDescuento(eobj.getfDescuento());

						listadev.add(ventaDetalle);
						listadevOriginal.add(eobj);

					}// if
				}// for
			}// for

			ventaform.setVenta(ventaDev.getVenta());
			sesion.setAttribute("listaVentaDetalleCompra", lista);
			sesion.setAttribute("listaVentaDetalle", listadev);
			sesion.setAttribute("listaVentaDetalleOriginal", listadevOriginal);

			ventaform.setVentaDev(ventaDev);

		}
		/**
		 * LLamamos al formulario buscarMantenimientoPerfil.jsp para realizar la
		 * busqueda
		 **/
		else if (mode.equals("F")) {

			msn = "showFindDevolucionVenta";

		}

		ventaform.setMode(mode);

		/** Colocamos en session las listas **/

		sesion.setAttribute("listaEstado", listaEstado);
		sesion.setAttribute("listaFormapago", listaFormapago);
		sesion.setAttribute("listaTipoDoc", listaTipoDoc);
		sesion.setAttribute("listaEstadoDocumento", listaEstadoDocumento);
		sesion.setAttribute("listaImpresora", listaImpresora);

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
	public ActionForward detalleVenta(ActionMapping mapping, ActionForm form,
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
		/** Instanciamos la Clase VentaForm **/

		List<Ventadetalle> lista = (List<Ventadetalle>) sesion.getAttribute("listaVentaDetalle");

		String identificador = request.getParameter("identificador");

		Producto productoBean = new Producto();
		Ventadetalle ventadetalle = new Ventadetalle();
		/** Iniciamos instacia de transacion **/
		//

		try {

			if (mode.equals("I")) {
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
				int iPersonalId = Integer.parseInt(request
						.getParameter("iPersonalId"));

				Producto producto = productoDao.findEndidad(productoBean,
						iProductoId);

				productoBean.setiProductoId(producto.getiProductoId());
				productoBean.setcProductoCodigo(producto.getcProductoCodigo());
				productoBean.setvProductoNombre(producto.getvProductoNombre());

				productoBean.setUnidadMedida(producto.getUnidadMedida());
				productoBean.setiUMBase(producto.getiUMBase());
				productoBean.setfProductoPrecioVenta(producto
						.getfProductoPrecioVenta());
				productoBean.setiProductoStockTotal(producto
						.getiProductoStockTotal());
				productoBean.setfProductoPrecioCompra(fPrecioCompra);

				ventadetalle.setProducto(productoBean);
				ventadetalle.setfVentaDetallePrecio(fPrecioVenta);
				ventadetalle.setiVentaDetalleCantidad(iCantidad);
				ventadetalle.setfVentaDetalleTotal(fTotal);
				ventadetalle.setfDescuento(fDescuento);
				ventadetalle.setdFechaInserta(Fechas.getDate());
				ventadetalle.setiUsuarioInsertaId(usu.getiUsuarioId());
				ventadetalle.setcEstadoCodigo(Constantes.estadoActivo);
				ventadetalle.setvIdentificadorSession(identificador);
				/*
				 * Venta venta=new Venta(); venta.setiVentaId((int)
				 * (Math.random() * 10.0)); ventadetalle.setVenta(venta);
				 */
				if (iPersonalId > 0) {
					Personal personalBean = new Personal();
					Personal personal = new Personal();
					personal = productoDao.findEndidad(personal, iPersonalId);
					personalBean.setiPersonalId(personal.getiPersonalId());
					personalBean.setvPersonalNombres(personal
							.getvPersonalNombres());
					personalBean.setvPersonalApellidoPaterno(personal
							.getvPersonalApellidoPaterno());

					ventadetalle.setPersonal(personalBean);
				}

				lista.add(ventadetalle);
				sesion.setAttribute("listaVentaDetalle", lista);
				// ventaDao.persistEndidad(ventadetalle);
				// ventaDao.commitEndidad(entityTransaction);
			}
			if (mode.equals("D")) {
				if (lista.get(iProductoId).getcEstadoCodigo()
						.equals(Constantes.estadoActivo) && lista.get(iProductoId).getvIdentificadorSession().equals(identificador))
					lista.get(iProductoId).setcEstadoCodigo(
							Constantes.estadoInactivo);
				else
					lista.get(iProductoId).setcEstadoCodigo(
							Constantes.estadoActivo);

				sesion.setAttribute("listaVentaDetalle", lista);
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

				lista.get(iProductoId).setfVentaDetallePrecio(fPrecioVenta);
				lista.get(iProductoId).setfVentaDetalleTotal(
						(fPrecioVentaFinal * iCantidad));
				lista.get(iProductoId).setiVentaDetalleCantidad(iCantidad);
				lista.get(iProductoId).setfDescuento(fDescuento);

				// sesion.setAttribute("listaVentaDetalle", lista);

			}
			/***
			 * consultamos el detalle de la compra para hacer la devolucion de
			 * la compra ID= Insercion de devolucion de compras
			 **/
			if (mode.equals("ID")) {
				sesion.removeAttribute("listaVentaDetalle");
				lista = new ArrayList<Ventadetalle>();
				List<Ventadetalle> listas = ventaDao
						.buscarVentaDetalle(iProductoId);
				for (Ventadetalle e : listas) {

					Venta venta = new Venta();
					Ventadetalle ventaDetalle = new Ventadetalle();
					Cliente cliente = new Cliente();

					venta.setiVentaId(e.getVenta().getiVentaId());
					venta.setfVentaIGV(e.getVenta().getfVentaIGV());
					venta.setfVentaSubTotal(e.getVenta().getfVentaSubTotal());
					venta.setfVentaTotal(e.getVenta().getfVentaTotal());
					venta.setdVentaFecha(e.getVenta().getdVentaFecha());
					venta.setnVentaNumero(e.getVenta().getnVentaNumero());
					venta.setvEstadoDocumento(e.getVenta()
							.getvEstadoDocumento());
					venta.setFormaPago(e.getVenta().getFormaPago());
					venta.setTipoDocumento(e.getVenta().getTipoDocumento());

					cliente.setiClienteId(e.getVenta().getCliente()
							.getiClienteId());
					cliente.setvClienteRazonSocial(e.getVenta().getCliente()
							.getvClienteRazonSocial());
					cliente.setvNombreCliente(e.getVenta().getCliente()
							.getvNombreCliente());
					cliente.setvClienteCodigo(e.getVenta().getCliente()
							.getvClienteCodigo());
					cliente.setnClienteNumeroDocumento(e.getVenta()
							.getCliente().getnClienteNumeroDocumento());

					venta.setCliente(cliente);

					ventaDetalle.setVenta(venta);

					ventaDetalle.setcEstadoCodigo(Constantes.estadoActivo);
					ventaDetalle.setiVentaDetalleCantidad(e
							.getiVentaDetalleCantidad());
					ventaDetalle.setfVentaDetallePrecio(e
							.getfVentaDetallePrecio());
					ventaDetalle.setfVentaDetalleTotal(e
							.getfVentaDetalleTotal());
					ventaDetalle.setfDescuento(e.getfDescuento());
					productoBean = new Producto();

					productoBean.setiProductoId(e.getProducto()
							.getiProductoId());
					productoBean.setcProductoCodigo(e.getProducto()
							.getcProductoCodigo());
					productoBean.setvProductoNombre(e.getProducto()
							.getvProductoNombre());
					productoBean.setUnidadMedida(e.getProducto()
							.getUnidadMedida());
					productoBean.setiUMBase(e.getProducto().getiUMBase());
					productoBean.setfProductoPrecioVenta(e.getProducto()
							.getfProductoPrecioVenta());
					productoBean.setfProductoPrecioCompra(e.getProducto()
							.getfProductoPrecioCompra());

					ventaDetalle.setProducto(productoBean);

					lista.add(ventaDetalle);
				}
				sesion.setAttribute("listaVentaDetalle", lista);
				// sesion.setAttribute("listaVentaDetalleDevol", lista);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			ventaDao.limpiarInstancia();
		}

		String jsonOutput = gson.toJson(lista);

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
	public ActionForward obtenerCodigoVenta(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		response.setContentType("text/json");
		HttpSession sesion = request.getSession();

		Gson gson = new Gson();
		GenericaDao productoDao = new GenericaDao();
		VentaDao ventaDao = new VentaDao();
		Usuario usu = (Usuario) sesion.getAttribute("Usuario");
		int iTipoDocumentoId = Integer.parseInt(request
				.getParameter("iTipoDocumentoId"));

		/** Instanciamos la Clase VentaForm **/

		String nuevoCodigo = ventaDao.callSPNro_Documento(iTipoDocumentoId,
				"venta", "nVentaNumero",usu.getSucursal().getiSucursalId());
		List<String> list = new ArrayList<String>();
		list.add(nuevoCodigo);

		String jsonOutput = gson.toJson(list);

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
	 */
	public ActionForward mantenimientoVenta(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession sesion = request.getSession();
		String mode = request.getParameter("mode");
		String msn = "";

		/** Instantacia al VentaForm **/
		VentaForm ventaform = (VentaForm) form;

		/** Instantacia a la capa Dao **/
		EstadoDao estadoDao = new EstadoDao();
		GenericaDao genericaDao = new GenericaDao();
		VentaDao ventaDao = new VentaDao();
		Usuario usu = (Usuario) sesion.getAttribute("Usuario");
		Moneda moneda = (Moneda) sesion.getAttribute("Moneda");
		float tipoCambio = Float.parseFloat((String) sesion
				.getAttribute("TipoCambio"));

		/** llamado de los metodos de la clase dao **/

		List<Estado> listaEstado = estadoDao.listEstado();
		List<Formapago> listaFormapago = genericaDao
				.listaEntidadGenericaSinCodigo("Formapago");
		List<Mediopago> listamedioPago = genericaDao
				.listaEntidadGenericaSinCodigo("Mediopago");
		List<Ventadetalle> lista = new ArrayList<Ventadetalle>();
		List<Tipodocumentogestion> listaTipoDoc = genericaDao
				.listaEntidadGenericaSinCodigo("Tipodocumentogestion");
		List<ImpresoraVO> listaImpresora = Impresora.listarImpresoras();

		/**
		 * LLamamos al formulario mantenimientoVenta.jsp para la insercion de
		 * datos
		 **/
		if (mode.equals("I")) {
			String tipoDocumento = request.getParameter("idTipoDocumento");
			ventaform.setTipoMoneda(moneda.getcModenaCodigo());
			ventaform.setIGVVentas(sesion.getAttribute("IGVVentas").toString());
			ventaform.setiSucursalId(usu.getSucursal().getiSucursalId());

			ventaform.setiTipoDocumentoId(Integer.parseInt(tipoDocumento));
			ventaform
					.setcPersonalCodigo(usu.getPersonal().getcPersonalCodigo());
			ventaform.setvPersonalNombres(usu.getPersonal()
					.getvPersonalNombres()
					+ " "
					+ usu.getPersonal().getvPersonalApellidoPaterno());
			ventaform.setIclasificacionId(Integer.parseInt(request
					.getParameter("iclasificacionId")));

			ventaform.setfTipoCambio(tipoCambio);
			// :1 : factura.
			ventaform.getVenta().setnVentaNumero(
					ventaDao.callSPNro_Documento(1, "venta", "nVentaNumero",usu.getSucursal().getiSucursalId()));

			/*** LISTA DE DETALLE VENTA ***/
			sesion.removeAttribute("listaVentaDetalle");

			if (sesion.getAttribute("listaVentaDetalle") == null) {
				sesion.setAttribute("listaVentaDetalle", lista);
			}

			/*
			 * if(tipoDocumento.equals("1")) msn = "showEditFactura";
			 * if(tipoDocumento.equals("3")) msn = "showEditFactura";
			 * if(tipoDocumento.equals("7")) msn = "showEditNotaDebito";
			 * if(tipoDocumento.equals("4")) msn = "showEditGuiaRemision";
			 * if(tipoDocumento.equals("5"))
			 */
			msn = "showEditFactura";

			// msn = "showEdit";

		} else if (mode.equals("IE")) {

			msn = "showEstadoCuenta";
			// 1:factura:
			ventaform.getVenta().setnVentaNumero(
					ventaDao.callSPNro_Documento(1, "venta", "nVentaNumero",usu.getSucursal().getiSucursalId()));
		}

		/**
		 * LLamamos al formulario mantenimientoVenta.jsp para mostrar los datos
		 * del UPDATE
		 **/
		/** Seteamos el ventaform la clase Venta **/
		/**
		 * U:actualiza venta UE: actualiza estado Cuenta ED: Visualizar Venta
		 * **/
		else if (mode.equals("U") || mode.equals("UE") || mode.equals("ED")) {

			int id = Integer.parseInt(request.getParameter("id"));
			String tipoDocumento = request.getParameter("idTipoDocumento");
			Venta venta = ventaDao.findEndidad(ventaform.getVenta(), id);

			ventaform.setvClasificacion(venta.getCliente().getClasificacion()
					.getvNombre());
			ventaform.setVenta(venta);
			ventaform.setTipoMoneda(venta.getvTipoVenta());
			ventaform.setIGVVentas(venta.getvPorcentajeIGV());

			if (mode.equals("UE")) {

				/*** INGRESO DE VENTAS MEDIANTE EL ESTADO DE CUENTA DEL CLIENTE ***/

				ventaform.setPagoTotal(Float.parseFloat(request
						.getParameter("pagoTotal")));
				ventaform.setvClienteDireccion(venta.getCliente()
						.getDireccionclientes().get(0).getvDireccion());

				msn = "showEstadoCuenta";

				// Ingreso Estado cuenta Cliente a la tabla Ingreso Producto
				// (Compras)

			} else {

				/*** VENTAS FACTURA, BOLETA, NOTA DE PEDIDO ***/
				/*** LISTA DE DETALLE VENTA ***/
				sesion.removeAttribute("listaVentaDetalle");
				for (Ventadetalle obj : venta.getVentadetalles()) {
					if (obj.getcEstadoCodigo().equals(Constantes.estadoActivo)) {
						Ventadetalle ventaDetalle = new Ventadetalle();
						Producto productoBean = new Producto();
						Personal personal = new Personal();
						productoBean.setiProductoId(obj.getProducto()
								.getiProductoId());
						productoBean.setcProductoCodigo(obj.getProducto()
								.getcProductoCodigo());
						productoBean.setvProductoNombre(obj.getProducto()
								.getvProductoNombre());

						if (obj.getProducto().getUmBase() == null)
							productoBean.setUmBase(new Unidadmedida());

						if (obj.getProducto().getUmBase() == null)
							productoBean.setUmPedido(new Unidadmedida());
						if (obj.getProducto().getUmBase() == null)
							productoBean.setUmSalida(new Unidadmedida());

						if (obj.getProducto().getUnidadMedida() != null) {
							productoBean.setUnidadMedida(obj.getProducto()
									.getUnidadMedida());
						} else {
							productoBean.setUnidadMedida(new Unidadmedida());
							personal.setvPersonalNombres(obj.getPersonal()
									.getvPersonalNombres());
							personal.setvPersonalApellidoPaterno(obj
									.getPersonal()
									.getvPersonalApellidoPaterno());
						}
						productoBean.setiUMBase(obj.getProducto().getiUMBase());
						productoBean.setfProductoPrecioVenta(obj.getProducto()
								.getfProductoPrecioVenta());
						productoBean.setiProductoStockTotal(obj.getProducto()
								.getiProductoStockTotal());
						productoBean.setfProductoPrecioCompra(obj.getProducto()
								.getfProductoPrecioCompra());

						ventaDetalle.setProducto(productoBean);
						ventaDetalle.setPersonal(personal);

						ventaDetalle.setiVentaDetalleId(obj
								.getiVentaDetalleId());
						ventaDetalle.setcEstadoCodigo(obj.getcEstadoCodigo());
						ventaDetalle.setfVentaDetallePrecio(obj
								.getfVentaDetallePrecio());
						ventaDetalle.setfVentaDetalleTotal(obj
								.getfVentaDetalleTotal());
						ventaDetalle.setiVentaDetalleCantidad(obj
								.getiVentaDetalleCantidad());
						ventaDetalle.setfDescuento(obj.getfDescuento());

						lista.add(ventaDetalle);
					}
				}

				sesion.setAttribute("listaVentaDetalle", lista);
				ventaform.setvClienteDireccion(venta.getCliente()
						.getDireccionclientes().get(0).getvDireccion());
				ventaform.setiTipoDocumentoId(Integer.parseInt(tipoDocumento));
				ventaform.setVenta(venta);
				ventaform.setcPersonalCodigo(venta.getUsuario().getPersonal()
						.getcPersonalCodigo());
				ventaform.setvPersonalNombres(venta.getUsuario().getPersonal()
						.getvPersonalNombres()
						+ " "
						+ venta.getUsuario().getPersonal()
								.getvPersonalApellidoPaterno());

				/*
				 * if(tipoDocumento.equals("1")) msn = "showEditFactura";
				 * if(tipoDocumento.equals("2")) msn = "showEditBoleta";
				 * if(tipoDocumento.equals("3")) msn = "showEditNotaDebito";
				 * if(tipoDocumento.equals("4")) msn = "showEditGuiaRemision";
				 * if(tipoDocumento.equals("5"))
				 */
				msn = "showEditFactura";
			}

		}
		/**
		 * LLamamos al formulario buscarMantenimientoVenta.jsp para realizar la
		 * busqueda metodoBusqueda: se determina el metodo a lista; listaVenta:
		 **/
		else if (mode.equals("F")) {
			msn = "showFind";
		}
		/**
		 * LLamamos al formulario buscarMantenimientoVenta.jsp para realizar la
		 * busqueda
		 **/

		ventaform.setMode(mode);

		/** Colocamos en session las listas **/

		sesion.setAttribute("listaEstado", listaEstado);
		sesion.setAttribute("listaFormapago", listaFormapago);
		sesion.setAttribute("listamedioPago", listamedioPago);
		sesion.setAttribute("listaImpresora", listaImpresora);

		sesion.setAttribute("listaTipoDoc", listaTipoDoc);

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
	public ActionForward iduVenta(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IllegalArgumentException, SecurityException,
			ClassNotFoundException, IllegalAccessException,
			NoSuchFieldException, ParseException {

		/** Inicializamos las variables **/
		String msn = "";
		String mode = request.getParameter("mode");
		String ids = request.getParameter("ids");
		HttpSession sesion = request.getSession();
		boolean resultado = false;
		int cantidadProducto = 0, cantidadProductoActual = 0;

		/** Instanciamos las clase VentaForm y VentaDao **/
		VentaForm pForm = (VentaForm) form;
		Usuario usu = (Usuario) sesion.getAttribute("Usuario");
		int iPeriodoId = (Integer) sesion.getAttribute("iPeriodoId");

		VentaDao ventaDao = new VentaDao();
		ContabilidadDao contabilidadDao = new ContabilidadDao();
		KardexDao kardexDao = new KardexDao();
		List<Ventadetalle> ventadetalles = new ArrayList<Ventadetalle>();
		List<Kardex> listaKadex = new ArrayList<Kardex>();
		List<Kardex> listaKadexActivo = new ArrayList<Kardex>();

		Venta obj = pForm.getVenta();
		Date fecha = Fechas.getDate();
		if (obj.getFormaPago() != null)
			fecha = (obj.getFormaPago().getiFormaPago() == 3 ? Fechas
					.fechaDate("30/" + (Fechas.mesFecha(fecha) + 1) + "/"
							+ Fechas.anioFecha(fecha)) : obj
					.getdFechaProximoPago());
		obj.setdFechaProximoPago(fecha);

		/** Iniciamos instacia de transacion **/
		EntityTransaction entityTransaction;

		try {
			String nVentaNumero = null;
			if (pForm.getMode().equals("I") || pForm.getMode().equals("IE")) {
				nVentaNumero = ventaDao.callSPNro_Documento(obj.getTipoDocumento().getiTipoDocumentoGestionId(), "venta", "nVentaNumero",usu.getSucursal().getiSucursalId());
			}
			
			entityTransaction = ventaDao.entityTransaction();
			entityTransaction.begin();
			if (pForm.getMode().equals("I") || pForm.getMode().equals("IE")) {

				/*** Informacion de la Venta ****/
				obj.setdFechaInserta(Fechas.getDate());
				obj.setvPrincipal(Constantes.vPrincipal);
				obj.setcEstadoCodigo(Constantes.estadoActivo);
				obj.setfVentaGanancia(BigDecimal.valueOf(0));
				obj.setvEstadoVenta(pForm.getvEstadoDocumento());
				obj.setIdireccionClienteId(pForm.getiClienteId());
				obj.setUsuario(usu);
				obj.setiPeriodoId(iPeriodoId);
				obj.setSucursal(usu.getSucursal());
				obj.setvPorcentajeIGV(sesion.getAttribute("IGVVentas").toString());
				obj.setnVentaNumero(nVentaNumero);

				/**** Informacion de detalle venta ****/

				// Ventadetalle ventaDetalle = new Ventadetalle();

				if (sesion.getAttribute("listaVentaDetalle") != null) {
					for (Ventadetalle ventaDetalle : (List<Ventadetalle>) sesion
							.getAttribute("listaVentaDetalle")) {

						if (ventaDetalle.getcEstadoCodigo().equals(
								Constantes.estadoActivo)
								&& ventaDetalle.getvIdentificadorSession()
										.equals(pForm.getIdentificador())) {
							ventaDetalle.setVenta(obj);
							ventaDetalle.setdFechaInserta(Fechas.getDate());
							ventaDetalle.setiUsuarioInsertaId(usu
									.getiUsuarioId());

							Producto producto = ventaDao.findEndidad(
									ventaDetalle.getProducto(), ventaDetalle
											.getProducto().getiProductoId());

							/*******************************************/
							/** Insertamos detalle de lista de precios **/
							/** Si cantidad ingresada es menor q la **/
							/** cantidad el precio de la lista **/
							/*******************************************/
							int iCantidad = 0;
							int cantAsignado = 0;
							int asignado = 0;
							for (Preciosproducto preciosProducto : producto
									.getPreciosproductodetallles()) {
								if (preciosProducto.getfPrecioCompra() == ventaDetalle
										.getProducto()
										.getfProductoPrecioCompra()) {
									iCantidad = preciosProducto
											.getiCantidadStock()
											- ventaDetalle
													.getiVentaDetalleCantidad();

									Kardex kardex = new Kardex();
									kardex.setProducto(producto);
									kardex.setVenta(obj);
									kardex.setdFecha(Fechas.getDate());
									kardex.setvConcepto(Constantes.conceptoVenta
											+ ventaDao
													.findEndidad(
															pForm.getTipoDocumento(),
															pForm.getiTipoDocumentoId())
													.getvTipoDocumentoDescripcion()
											+ Constantes.nro
											+ obj.getnVentaNumero());
									kardex.setiCantExistencia(preciosProducto
											.getiCantidadStock());
									kardex.setfPuExistencia(preciosProducto
											.getfPrecioCompra());
									kardex.setfTotalExistencia(kardex
											.getiCantExistencia()
											* kardex.getfPuExistencia());
									kardex.setiPeriodoId(iPeriodoId);
									kardex.setdFechaInserta(Fechas.getDate());
									kardex.setcEstadoCodigo(Constantes.estadoActivo);

									if (preciosProducto.getiCantidadStock() > 0) {
										if (iCantidad < 0) {
											/***
											 * Agregamos al Kardex el movimiento
											 * de los productos
											 ***/
											kardex.setiCantVenta(preciosProducto
													.getiCantidadStock());
											kardex.setfPuVenta(preciosProducto
													.getfPrecioCompra());
											kardex.setfTotalVenta(kardex
													.getiCantVenta()
													* kardex.getfPuVenta());
											kardex.setiCantExistencia(0);
											kardex.setfPuExistencia(ventaDetalle
													.getProducto()
													.getfProductoPrecioCompra());
											kardex.setfTotalExistencia(0);
											kardex.setcEstadoCodigo(Constantes.estadoInactivo);

											/**************************/
											/** reducimos el stock a 0 */
											preciosProducto
													.setiCantidadStock(0);

										}// if
										else {
											kardex.setiCantVenta(preciosProducto
													.getiCantidadStock()
													- iCantidad);
											kardex.setfPuVenta(preciosProducto
													.getfPrecioCompra());
											kardex.setfTotalVenta(kardex
													.getiCantVenta()
													* kardex.getfPuVenta());
											kardex.setiCantExistencia(iCantidad);
											kardex.setfPuExistencia(preciosProducto
													.getfPrecioCompra());
											kardex.setfTotalExistencia(kardex
													.getiCantExistencia()
													* kardex.getfPuExistencia());
											kardex.setiUsuarioInsertaId(usu
													.getiUsuarioId());

											/*** Agregamos en la lista kardex ****/
											// listaKardex.add(kardex);

											/***
											 * Actualizamos la cantidad restante
											 * en el stock
											 **/
											preciosProducto
													.setiCantidadStock(iCantidad);
											/** Actualizamos el producto */
											producto.setiProductoStockTotal(producto
													.getiProductoStockTotal()
													- ventaDetalle
															.getiVentaDetalleCantidad());
											producto.setfProductoDescuento(preciosProducto
													.getfDescuento());
											producto.setfProductoGanancia(preciosProducto
													.getfGanancia());
											producto.setfProductoPrecioVenta(preciosProducto
													.getfPrecioVenta());
											producto.setfProductoPrecioCompra(preciosProducto
													.getfPrecioCompra());
											asignado = 1;

										}// else
										cantAsignado = preciosProducto
												.getiCantidadStock();
									}// fin if
										// ventaDao.persistEndidad(kardex);
										// producto.getKardexs().add(kardex);
									listaKadex.add(kardex);

								}// if
							}// for

							/***********************************************************************************/
							/***
							 * Actualizamos la cantidad del producto en stock,
							 * el precio de compra y venta
							 *****/
							/***
							 * Segun metodologia FIFO- Primero en entrar,
							 * Primero en Salir
							 **/
							/***
							 * Si la cantidad ingresada es manor que el stock de
							 * la lista de precios /
							 ***********************************************************************************/
							int i = 0;
							for (Preciosproducto objpreciosProducto : producto
									.getPreciosproductodetallles()) {
								if (objpreciosProducto.getiCantidadStock() > 0
										&& objpreciosProducto
												.getiCantidadStock() != cantAsignado) {
									/***
									 * Agregamos al Kardex el movimiento de los
									 * productos
									 ***/
									Kardex kardex = new Kardex();
									kardex.setProducto(producto);
									kardex.setVenta(obj);
									kardex.setvConcepto(Constantes.conceptoz
											+ i);
									kardex.setdFecha(Fechas.getDate());
									kardex.setiCantExistencia(objpreciosProducto
											.getiCantidadStock());
									kardex.setfPuExistencia(objpreciosProducto
											.getfPrecioCompra());
									kardex.setfTotalExistencia(kardex
											.getiCantExistencia()
											* kardex.getfPuExistencia());
									kardex.setiPeriodoId(iPeriodoId);
									kardex.setdFechaInserta(Fechas.getDate());
									kardex.setcEstadoCodigo(Constantes.estadoActivo);

									if (asignado == 0) {
										/**
										 * Reducimos la cantidad en la lista de
										 * precios en orden asc.
										 **/
										iCantidad = objpreciosProducto
												.getiCantidadStock()
												+ iCantidad;

										if (iCantidad <= 0) {

											kardex.setiCantVenta(objpreciosProducto
													.getiCantidadStock());
											kardex.setfPuVenta(objpreciosProducto
													.getfPrecioCompra());
											kardex.setfTotalVenta(kardex
													.getiCantVenta()
													* kardex.getfPuVenta());
											kardex.setiCantExistencia(0);
											kardex.setfPuExistencia(objpreciosProducto
													.getfPrecioCompra());
											kardex.setfTotalExistencia(0);
											kardex.setiUsuarioInsertaId(usu
													.getiUsuarioId());
											kardex.setcEstadoCodigo(Constantes.estadoInactivo);

											/*** Agregamos en la lista kardex ****/
											// listaKardex.add(kardex);

											/**************************/
											/** reducimos el stock a 0 */
											objpreciosProducto
													.setiCantidadStock(0);

										} else {
											kardex.setiCantVenta(objpreciosProducto
													.getiCantidadStock()
													- iCantidad);
											kardex.setfPuVenta(objpreciosProducto
													.getfPrecioCompra());
											kardex.setfTotalVenta(kardex
													.getiCantVenta()
													* kardex.getfPuVenta());
											kardex.setiCantExistencia(iCantidad);
											kardex.setfPuExistencia(objpreciosProducto
													.getfPrecioCompra());
											kardex.setfTotalExistencia(kardex
													.getiCantExistencia()
													* kardex.getfPuExistencia());
											kardex.setiUsuarioInsertaId(usu
													.getiUsuarioId());

											asignado = 1;
											/*** Agregamos en la lista kardex ****/
											// listaKardex.add(kardex);

											/***
											 * Actualizamos la cantidad restante
											 * en el stock
											 **/
											objpreciosProducto
													.setiCantidadStock(iCantidad);
											/** Actualizamos el producto */
											producto.setiProductoStockTotal(producto
													.getiProductoStockTotal()
													- ventaDetalle
															.getiVentaDetalleCantidad());
											producto.setfProductoDescuento(objpreciosProducto
													.getfDescuento());
											producto.setfProductoGanancia(objpreciosProducto
													.getfGanancia());
											producto.setfProductoPrecioVenta(objpreciosProducto
													.getfPrecioVenta());
											producto.setfProductoPrecioCompra(objpreciosProducto
													.getfPrecioCompra());

										}// else

									}// if cantidad manor a cero
										// ventaDao.persistEndidad(kardex); //
										// ventaDao.p//ersistEndgetKardexs().add(kardex)
									listaKadex.add(kardex);

								}// / if
								i++;
							}// for
							for (Kardex objKar : kardexDao
									.buscarKardexProducto(producto
											.getiProductoId())) {
								objKar.setcEstadoCodigo(Constantes.estadoInactivo);
								ventaDao.mergeEndidad(objKar);
							}

							producto.setKardexs(listaKadex);
							ventaDao.persistEndidad(producto);
							/***
							 * Agregamos las actualizaciones en la lista
							 * ventadetalles
							 ****/
							ventadetalles.add(ventaDetalle);

						}// if
							// ventadetalles = producto.getVentadetalles();

					}// for

					obj.setVentadetalles(ventadetalles);
					// obj.setKardexs(listaKardex);
				}// if
				if (pForm.getMode().equals("IE")) {
					obj.setfVentaIGV(0);
					obj.setfVentaSubTotal(0);
					obj.setIdireccionClienteId(0);
					obj.setvPrincipal(Constantes.vnPrincipal);
				}

				sesion.removeAttribute("listaProducto");

				ventaDao.persistEndidad(obj);
				resultado = ventaDao.commitEndidad(entityTransaction);
				if (resultado == true) {
					int idVentaId = obj.getiVentaId();
					int nNumeroLetra = 1;
					entityTransaction = ventaDao.entityTransaction();
					entityTransaction.begin();
					contabilidadDao.callVentaContabilidad(idVentaId, fecha,
							pForm.getfMontoAdelantado(), usu.getiUsuarioId(),
							pForm.getiNumeroLetras(), pForm.getiNumeroDias(),
							pForm.getMode(), iPeriodoId, nNumeroLetra, pForm
									.getFormaPago().getiFormaPago());
					resultado = ventaDao.commitEndidad(entityTransaction);

				}

				ventaDao.refreshEndidad(obj);
				if (pForm.getvImprimir().equals("SI")) {
					imprimir(mapping, pForm, request, response);
				}

			} else if (pForm.getMode().equals("U")
					|| pForm.getMode().equals("UE")) {

				Venta obj1 = ventaDao.findEndidad(pForm.getVenta(), pForm
						.getVenta().getiVentaId());
				obj1 = Util.comparar(obj1, pForm.getVenta());// pForm.getVenta();

				/*
				 * if(pForm.getMode().equals("U")){ int i= 0; int iCantidad=0;
				 * int cantAsignado =0; int asignado =0; int cantKardex=0;
				 * 
				 * List<Ventadetalle> list = (List<Ventadetalle>)
				 * sesion.getAttribute("listaVentaDetalle");
				 * 
				 * for(Ventadetalle ventaDetalle:list){ Producto producto =
				 * ventaDao.findEndidad(ventaDetalle.getProducto(),
				 * ventaDetalle.getProducto().getiProductoId());
				 * 
				 * if(ventaDetalle.getiVentaDetalleId()==0 &&
				 * ventaDetalle.getcEstadoCodigo
				 * ().equals(Constantes.estadoActivo)){
				 * 
				 * ventaDetalle.setVenta(obj1);
				 * ventaDetalle.setcEstadoCodigo(Constantes.estadoActivo);
				 * ventaDetalle.setdFechaActualiza(Fechas.getDate());
				 * ventaDetalle.setiUsuarioActualizaId(usu.getiUsuarioId());
				 * ventaDetalle.setdFechaInserta(obj1.getdFechaInserta());
				 *//*******************************************/
				/*
										*//** Insertamos detalle de lista de precios **/
				/*
							     	    *//** Si cantidad ingresada es menor q la **/
				/*
							     	    *//** cantidad el precio de la lista **/
				/*			     	     
										*//*******************************************/
				/*
				 * 
				 * for(Preciosproducto
				 * preciosProducto:producto.getPreciosproductodetallles()){
				 * if(preciosProducto
				 * .getfPrecioCompra()==ventaDetalle.getProducto
				 * ().getfProductoPrecioCompra()) {
				 * iCantidad=preciosProducto.getiCantidadStock
				 * ()-ventaDetalle.getiVentaDetalleCantidad();
				 * 
				 * Kardex kardex = new Kardex(); kardex.setProducto(producto);
				 * kardex.setVenta(obj); kardex.setdFecha(Fechas.getDate());
				 * kardex
				 * .setvConcepto(Constantes.conceptoVenta+ventaDao.findEndidad
				 * (pForm.getTipoDocumento(),
				 * pForm.getiTipoDocumentoId()).getvTipoDocumentoDescripcion
				 * ()+Constantes.nro+obj.getnVentaNumero());
				 * kardex.setiCantExistencia
				 * (preciosProducto.getiCantidadStock());
				 * kardex.setfPuExistencia(preciosProducto.getfPrecioCompra());
				 * kardex
				 * .setfTotalExistencia(kardex.getiCantExistencia()*kardex.
				 * getfPuExistencia()); kardex.setiPeriodoId(iPeriodoId);
				 * kardex.setdFechaInserta(Fechas.getDate());
				 * kardex.setcEstadoCodigo(Constantes.estadoActivo);
				 * 
				 * if(preciosProducto.getiCantidadStock()>0){ if(iCantidad<0){
				 *//*** Agregamos al Kardex el movimiento de los productos ***/
				/*
				 * kardex.setiCantVenta(preciosProducto.getiCantidadStock());
				 * kardex.setfPuVenta(preciosProducto.getfPrecioCompra());
				 * kardex
				 * .setfTotalVenta(kardex.getiCantVenta()*kardex.getfPuVenta());
				 * kardex.setiCantExistencia(0);
				 * kardex.setfPuExistencia(ventaDetalle
				 * .getProducto().getfProductoPrecioCompra());
				 * kardex.setfTotalExistencia(0);
				 * kardex.setcEstadoCodigo(Constantes.estadoInactivo);
				 *//**************************/
				/*
								 		              		*//** reducimos el stock a 0 */
				/*
				 * preciosProducto.setiCantidadStock(0);
				 * 
				 * }// if else{
				 * kardex.setiCantVenta(preciosProducto.getiCantidadStock
				 * ()-iCantidad);
				 * kardex.setfPuVenta(preciosProducto.getfPrecioCompra());
				 * kardex
				 * .setfTotalVenta(kardex.getiCantVenta()*kardex.getfPuVenta());
				 * kardex.setiCantExistencia(iCantidad);
				 * kardex.setfPuExistencia(preciosProducto.getfPrecioCompra());
				 * kardex
				 * .setfTotalExistencia(kardex.getiCantExistencia()*kardex.
				 * getfPuExistencia());
				 * kardex.setiUsuarioInsertaId(usu.getiUsuarioId());
				 *//*** Agregamos en la lista kardex ****/
				/*
				 * //listaKardex.add(kardex);
				 *//*** Actualizamos la cantidad restante en el stock **/
				/*
				 * preciosProducto.setiCantidadStock(iCantidad);
				 *//** Actualizamos el producto */
				/*
				 * producto.setiProductoStockTotal(producto.getiProductoStockTotal
				 * ()-ventaDetalle.getiVentaDetalleCantidad());
				 * producto.setfProductoDescuento
				 * (preciosProducto.getfDescuento());
				 * producto.setfProductoGanancia
				 * (preciosProducto.getfGanancia());
				 * producto.setfProductoPrecioVenta
				 * (preciosProducto.getfPrecioVenta());
				 * producto.setfProductoPrecioCompra
				 * (preciosProducto.getfPrecioCompra()); asignado=1;
				 * 
				 * 
				 * }// else cantAsignado = preciosProducto.getiCantidadStock();
				 * }// fin if //ventaDao.persistEndidad(kardex);
				 * //producto.getKardexs().add(kardex); listaKadex.add(kardex);
				 * 
				 * }// if }// for
				 *//***********************************************************************************/
				/*
						      			  *//***
				 * Actualizamos la cantidad del producto en stock, el precio
				 * de compra y venta
				 *****/
				/*	 
						      			  *//***
				 * Segun metodologia FIFO- Primero en entrar, Primero en Salir
				 **/
				/*
								      	  *//***
				 * Si la cantidad ingresada es manor que el stock de la lista
				 * de precios /
				 ***********************************************************************************/
				/*
				 * int i1=0; for(Preciosproducto
				 * objpreciosProducto:producto.getPreciosproductodetallles()){
				 * if(objpreciosProducto.getiCantidadStock()>0 &&
				 * objpreciosProducto.getiCantidadStock()!=cantAsignado ){
				 *//*** Agregamos al Kardex el movimiento de los productos ***/
				/*
				 * Kardex kardex = new Kardex(); kardex.setProducto(producto);
				 * kardex.setVenta(obj);
				 * kardex.setvConcepto(Constantes.conceptoz+i1);
				 * kardex.setdFecha(Fechas.getDate());
				 * kardex.setiCantExistencia(
				 * objpreciosProducto.getiCantidadStock());
				 * kardex.setfPuExistencia
				 * (objpreciosProducto.getfPrecioCompra());
				 * kardex.setfTotalExistencia
				 * (kardex.getiCantExistencia()*kardex.getfPuExistencia());
				 * kardex.setiPeriodoId(iPeriodoId);
				 * kardex.setdFechaInserta(Fechas.getDate());
				 * kardex.setcEstadoCodigo(Constantes.estadoActivo);
				 * 
				 * 
				 * if(asignado==0){
				 *//** Reducimos la cantidad en la lista de precios en orden asc. **/
				/*
				 * iCantidad=objpreciosProducto.getiCantidadStock()+iCantidad;
				 * 
				 * if(iCantidad<=0){
				 * 
				 * kardex.setiCantVenta(objpreciosProducto.getiCantidadStock());
				 * kardex.setfPuVenta(objpreciosProducto.getfPrecioCompra());
				 * kardex
				 * .setfTotalVenta(kardex.getiCantVenta()*kardex.getfPuVenta());
				 * kardex.setiCantExistencia(0);
				 * kardex.setfPuExistencia(objpreciosProducto
				 * .getfPrecioCompra()); kardex.setfTotalExistencia(0);
				 * kardex.setiUsuarioInsertaId(usu.getiUsuarioId());
				 * kardex.setcEstadoCodigo(Constantes.estadoInactivo);
				 *//*** Agregamos en la lista kardex ****/
				/*
				 * //listaKardex.add(kardex);
				 *//**************************/
				/*
							 		              		*//** reducimos el stock a 0 */
				/*
				 * objpreciosProducto.setiCantidadStock(0);
				 * 
				 * } else{
				 * kardex.setiCantVenta(objpreciosProducto.getiCantidadStock
				 * ()-iCantidad);
				 * kardex.setfPuVenta(objpreciosProducto.getfPrecioCompra());
				 * kardex
				 * .setfTotalVenta(kardex.getiCantVenta()*kardex.getfPuVenta());
				 * kardex.setiCantExistencia(iCantidad);
				 * kardex.setfPuExistencia(
				 * objpreciosProducto.getfPrecioCompra());
				 * kardex.setfTotalExistencia
				 * (kardex.getiCantExistencia()*kardex.getfPuExistencia());
				 * kardex.setiUsuarioInsertaId(usu.getiUsuarioId());
				 * 
				 * asignado=1;
				 *//*** Agregamos en la lista kardex ****/
				/*
				 * //listaKardex.add(kardex);
				 *//*** Actualizamos la cantidad restante en el stock **/
				/*
				 * objpreciosProducto.setiCantidadStock(iCantidad);
				 *//** Actualizamos el producto */
				/*
				 * producto.setiProductoStockTotal(producto.getiProductoStockTotal
				 * ()-ventaDetalle.getiVentaDetalleCantidad());
				 * producto.setfProductoDescuento
				 * (objpreciosProducto.getfDescuento());
				 * producto.setfProductoGanancia
				 * (objpreciosProducto.getfGanancia());
				 * producto.setfProductoPrecioVenta
				 * (objpreciosProducto.getfPrecioVenta());
				 * producto.setfProductoPrecioCompra
				 * (objpreciosProducto.getfPrecioCompra());
				 * 
				 * }// else
				 * 
				 * }// if cantidad manor a cero
				 * //ventaDao.persistEndidad(kardex); //
				 * ventaDao.p//ersistEndgetKardexs().add(kardex)
				 * listaKadex.add(kardex);
				 * 
				 * 
				 * 
				 * }/// if i1++; }// for for(Kardex
				 * objKar:kardexDao.buscarKardexProducto
				 * (producto.getiProductoId())){
				 * objKar.setcEstadoCodigo(Constantes.estadoInactivo);
				 * ventaDao.mergeEndidad(objKar); }
				 * 
				 * producto.setKardexs(listaKadex);
				 * ventaDao.persistEndidad(producto);
				 * 
				 * obj1.getVentadetalles().add(ventaDetalle); }// fin nuevo
				 * producto.
				 * 
				 * else{
				 *//***
				 * Actualizamos la cantidad del producto en stock, el precio
				 * de compra y de venta
				 *****/
				/*
				 * if(ventaDetalle.getcEstadoCodigo().equals(Constantes.estadoActivo
				 * )){
				 * 
				 * if(ventaDetalle.getiVentaDetalleCantidad()!=obj1.getVentadetalles
				 * ().get(i).getiVentaDetalleCantidad()){
				 * 
				 * cantidadProductoActual =
				 * ventaDetalle.getiVentaDetalleCantidad
				 * ()-obj1.getVentadetalles().get(i).getiVentaDetalleCantidad();
				 * cantidadProducto =
				 * obj1.getVentadetalles().get(i).getProducto(
				 * ).getiProductoStockTotal() - cantidadProductoActual;
				 *//**************************/
				/*
			 		              		*//** reducimos el stock a 0 */
				/*
				 * producto.setiProductoStockTotal(cantidadProducto) ;
				 *//*** Agregamos al Kardex el movimiento de los productos ***/
				/*
				 * if(cantidadProductoActual<0){
				 * Collections.sort(obj1.getKardexs(), new Comparator<Kardex>(){
				 * public int compare(Kardex p1, Kardex p2) { // return new
				 * Integer(p1.getiKardexId()).compareTo(new
				 * Integer(p2.getiKardexId())); return
				 * p2.getvConcepto().compareTo(p1.getvConcepto()); } });
				 * for(Kardex objKardex:obj1.getKardexs()){
				 * if(objKardex.getiCantVenta()>0){
				 *//** Actualizamos el Kardex **/
				/*
				 * objKardex.setdFechaActualiza(Fechas.getDate());
				 * objKardex.setiUsuarioActualizaId(usu.getiUsuarioId());
				 * cantKardex=cantidadProductoActual; cantidadProductoActual =
				 * objKardex.getiCantVenta()+cantidadProductoActual;
				 * if(cantidadProductoActual<0) {
				 * 
				 * for(Preciosproducto
				 * objpreciosProducto:producto.getPreciosproductodetallles()){
				 * if(objKardex.getfPuExistencia()==objpreciosProducto.
				 * getfPrecioCompra()){
				 * objpreciosProducto.setiCantidadStock(objKardex
				 * .getiCantExistencia()+objKardex.getiCantVenta());
				 * ventaDao.mergeEndidad(objpreciosProducto); } }
				 * objKardex.setiCantExistencia
				 * (objKardex.getiCantExistencia()+objKardex.getiCantVenta());
				 * objKardex.setfPuExistencia(objKardex.getfPuExistencia());
				 * objKardex
				 * .setfTotalExistencia(objKardex.getfPuExistencia()*objKardex
				 * .getiCantExistencia()); objKardex.setfPuVenta(0);
				 * objKardex.setiCantVenta(0); objKardex.setfTotalVenta(0);
				 * 
				 * 
				 * } else{ for(Preciosproducto
				 * objpreciosProducto:producto.getPreciosproductodetallles()){
				 * if(objKardex.getfPuExistencia()==objpreciosProducto.
				 * getfPrecioCompra()){
				 * objpreciosProducto.setiCantidadStock(objKardex
				 * .getiCantVenta()-cantidadProductoActual);
				 * ventaDao.mergeEndidad(objpreciosProducto); } }
				 * objKardex.setiCantExistencia
				 * (objKardex.getiCantVenta()-cantidadProductoActual);
				 * objKardex.setfPuExistencia(objKardex.getfPuExistencia());
				 * objKardex
				 * .setfTotalExistencia(objKardex.getfPuExistencia()*objKardex
				 * .getiCantExistencia());
				 * objKardex.setfPuVenta(objKardex.getfPuVenta());
				 * objKardex.setiCantVenta(cantidadProductoActual);
				 * objKardex.setfTotalVenta
				 * (objKardex.getfPuExistencia()*objKardex.getfPuExistencia());
				 * 
				 * 
				 * break; }
				 * 
				 * }// if }// for } else{ Collections.sort(obj1.getKardexs(),
				 * new Comparator<Kardex>(){ public int compare(Kardex p1,
				 * Kardex p2) { return
				 * p1.getvConcepto().compareTo(p2.getvConcepto()); } });
				 * 
				 * for(Kardex objKardex:obj1.getKardexs()){
				 * if(objKardex.getiCantExistencia()>0){
				 *//** Actualizamos el Kardex **/
				/*
				 * objKardex.setdFechaActualiza(Fechas.getDate());
				 * objKardex.setiUsuarioActualizaId(usu.getiUsuarioId());
				 * cantKardex=cantidadProductoActual; cantidadProductoActual =
				 * objKardex.getiCantExistencia()-cantidadProductoActual;
				 * if(cantidadProductoActual<0) { for(Preciosproducto
				 * objpreciosProducto:producto.getPreciosproductodetallles()){
				 * if(objKardex.getfPuExistencia()==objpreciosProducto.
				 * getfPrecioCompra()){ objpreciosProducto.setiCantidadStock(0);
				 * ventaDao.mergeEndidad(objpreciosProducto); } }
				 * objKardex.setfPuVenta(objKardex.getfPuVenta());
				 * objKardex.setiCantVenta
				 * (objKardex.getiCantExistencia()+objKardex.getiCantVenta());
				 * objKardex
				 * .setfTotalVenta(objKardex.getfPuExistencia()*objKardex
				 * .getiCantExistencia()); objKardex.setiCantExistencia(0);
				 * objKardex.setfPuExistencia(objKardex.getfPuExistencia());
				 * objKardex
				 * .setfTotalExistencia(objKardex.getfPuExistencia()*objKardex
				 * .getiCantExistencia());
				 * 
				 * 
				 * cantidadProductoActual=cantidadProductoActual*-1;
				 * 
				 * } else{ for(Preciosproducto
				 * objpreciosProducto:producto.getPreciosproductodetallles()){
				 * if(objKardex.getfPuExistencia()==objpreciosProducto.
				 * getfPrecioCompra()){
				 * objpreciosProducto.setiCantidadStock(cantidadProductoActual);
				 * ventaDao.mergeEndidad(objpreciosProducto); } }
				 * objKardex.setfPuVenta(objKardex.getfPuVenta());
				 * objKardex.setiCantVenta
				 * (objKardex.getiCantVenta()+cantKardex);
				 * objKardex.setfTotalVenta
				 * (objKardex.getfPuExistencia()*objKardex.getfPuVenta());
				 * objKardex.setiCantExistencia(cantidadProductoActual);
				 * objKardex.setfPuExistencia(objKardex.getfPuExistencia());
				 * objKardex
				 * .setfTotalExistencia(objKardex.getfPuExistencia()*objKardex
				 * .getiCantExistencia());
				 * 
				 * break; }
				 * 
				 * 
				 * }// if }// for }
				 * 
				 * 
				 * }// if diferentes }// if producto activo. else{
				 *//******************************************/
				/*
											*//** Insertamos detalle de lista de precios **/
				/*
											*//******************************************/
				/*
				 * for(Preciosproducto
				 * preciosProducto:obj1.getVentadetalles().get
				 * (i).getProducto().getPreciosproductodetallles()){
				 * if(preciosProducto
				 * .getfPrecioCompra()==obj1.getVentadetalles()
				 * .get(i).getProducto().getfProductoPrecioCompra()) {
				 * cantidadProducto = preciosProducto.getiCantidadStock() +
				 * ventaDetalle.getiVentaDetalleCantidad();
				 * preciosProducto.setiCantidadStock(cantidadProducto);
				 * producto.
				 * setiProductoStockTotal(producto.getiProductoStockTotal()+
				 * ventaDetalle.getiVentaDetalleCantidad());
				 * ventaDao.mergeEndidad(preciosProducto); break;
				 * 
				 * } } }
				 *//*******************************************/
				/*
									  *//*** Actualizamos los valores del producto */
				/*
									  *//*******************************************/
				/*
				 * 
				 * ventaDetalle.setProducto(producto);
				 * 
				 * obj1.getVentadetalles().get(i).setdFechaActualiza(Fechas.getDate
				 * ());
				 * obj1.getVentadetalles().get(i).setiUsuarioActualizaId(usu
				 * .getiUsuarioId());
				 * obj1.getVentadetalles().get(i).setfVentaDetallePrecio
				 * (ventaDetalle.getfVentaDetallePrecio());
				 * obj1.getVentadetalles
				 * ().get(i).setfVentaDetalleTotal(ventaDetalle
				 * .getfVentaDetalleTotal());
				 * obj1.getVentadetalles().get(i).setfDescuento
				 * (ventaDetalle.getfDescuento());
				 * obj1.getVentadetalles().get(i)
				 * .setiVentaDetalleCantidad(ventaDetalle
				 * .getiVentaDetalleCantidad());
				 * obj1.getVentadetalles().get(i).setProducto
				 * (ventaDetalle.getProducto());
				 * obj1.getVentadetalles().get(i).setcEstadoCodigo
				 * (ventaDetalle.getcEstadoCodigo());
				 * 
				 * 
				 * }//else i++; } // for
				 * 
				 * 
				 * }
				 * 
				 * ventaDao.mergeEndidad(obj1); resultado =
				 * ventaDao.commitEndidad(entityTransaction);
				 * if(resultado==true){ int idVentaId=obj1.getiVentaId(); int
				 * nNumeroLetra=1; entityTransaction =
				 * ventaDao.entityTransaction(); entityTransaction.begin();
				 * contabilidadDao.callVentaContabilidad(idVentaId,fecha,
				 * pForm.getfMontoAdelantado(), usu.getiUsuarioId(),
				 * pForm.getiNumeroLetras(),
				 * pForm.getiNumeroDias(),pForm.getMode
				 * (),iPeriodoId,nNumeroLetra,
				 * obj1.getFormaPago().getiFormaPago()); resultado =
				 * ventaDao.commitEndidad(entityTransaction); }
				 * 
				 * ventaDao.refreshEndidad(obj1);
				 */
				ventaDao.mergeEndidad(obj1);
				resultado = ventaDao.commitEndidad(entityTransaction);
				if (pForm.getvImprimir().equals("SI")) {
					imprimir(mapping, pForm, request, response);
				}

			} // / fin actualizacion.
			else if (mode.equals("D")) {

				ventaDao.eliminarUnaEndidad(pForm.getVenta(), "iVentaId", ids);/**/
				resultado = ventaDao.commitEndidad(entityTransaction);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
			ventaDao.limpiarInstancia();
		} finally {
			entityTransaction = null;
		}

		if (resultado == true) {
			msn = "msnOk";

		} else {
			msn = "msnError";

		}
		/** llamamos a listar Venta **/
		// listaVenta(mapping, pForm, request, response);

		return mapping.findForward(msn);
	}

	public ActionForward reporteVenta(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ParseException, IOException, JRException {

		VentaDao ventaDao = new VentaDao();
		/** Instanciamos la Clase VentaForm **/
		VentaForm objform = (VentaForm) form;

		String id = (request.getParameter("id"));
		String tipoDocumento = request.getParameter("idTipoDocumento");
		String reportPath = "";

		HttpServletRequestWrapper srw = new HttpServletRequestWrapper(request);
		Map param = new HashMap();
		param.put("fechaActual", Fechas.getDate());

		if (id != null) {
			objform.setiVentaId(Integer.parseInt(id));
			if (tipoDocumento.equals("1"))
				reportPath = srw
						.getRealPath("/ventas/reportes/reportFactura.jasper");

			if (tipoDocumento.equals("2"))
				reportPath = srw
						.getRealPath("/ventas/reportes/reportBoleta.jasper");

			if (tipoDocumento.equals("3"))
				reportPath = srw
						.getRealPath("/ventas/reportes/reportNotaDebito.jasper");

			if (tipoDocumento.equals("4"))
				reportPath = srw
						.getRealPath("/ventas/reportes/reportGuiaRemision.jasper");

			if (tipoDocumento.equals("5"))
				reportPath = srw
						.getRealPath("/ventas/reportes/reportPedido.jasper");
		} else {
			reportPath = srw
					.getRealPath("/ventas/reportes/reportVentas1.jasper");

		}

		List<Venta> listOfShoppingCart = ventaDao.listaVenta(0, 10000,
				objform.getVenta());
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
				listOfShoppingCart);

		JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath,
				param, beanCollectionDataSource);
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.addHeader("Content-disposition",
				"attachment; filename=report.pdf");
		ServletOutputStream servletOutputStream = httpServletResponse
				.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint,
				servletOutputStream);

		servletOutputStream.flush();
		servletOutputStream.close();

		return null;

	}

	/*
	 * @param form
	 * 
	 * @param request
	 * 
	 * @param response
	 * 
	 * @return
	 * 
	 * @throws ParseException
	 * 
	 * @throws IllegalArgumentException
	 * 
	 * @throws SecurityException
	 * 
	 * @throws ClassNotFoundException
	 * 
	 * @throws IllegalAccessException
	 * 
	 * @throws NoSuchFieldException
	 */

	public ActionForward iduVentaDevolucion(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ParseException,
			IllegalArgumentException, SecurityException,
			ClassNotFoundException, IllegalAccessException,
			NoSuchFieldException {

		/** Inicializamos las variables **/
		String msn = "";

		boolean resultado = false;
		int cantidadProducto = 0, cantidadProductoActual = 0;
		float precioProducto = (float) 0.0;
		HttpSession sesion = request.getSession();

		/** Instanciamos las clase VentaForm y VentaDao **/
		VentaForm pForm = (VentaForm) form;
		VentaDao ventaDao = new VentaDao();
		ContabilidadDao contabilidadDao = new ContabilidadDao();
		KardexDao kardexDao = new KardexDao();
		Usuario usu = (Usuario) sesion.getAttribute("Usuario");
		int iPeriodoId = (Integer) sesion.getAttribute("iPeriodoId");

		Ventadevolucion obj = pForm.getVentaDev();
		Venta objVenta = new Venta();
		List<Ventadevoluciondetalle> ingresoproductodevoluciondetalles = new ArrayList<Ventadevoluciondetalle>();
		List<Ventadevoluciondetalle> listaDetalle = new ArrayList<Ventadevoluciondetalle>();
		List<Kardex> listaKardex = new ArrayList<Kardex>();
		List<Kardex> listaKardexActivo = new ArrayList<Kardex>();

		/*** Informacion de la devolcuion de compra ****/
		obj.setdVentaDevFecha(Fechas.fechaDate(pForm.getdVentaDevFecha()));
		EntityTransaction entityTransaction;

		try {
			entityTransaction = ventaDao.entityTransaction();
			entityTransaction.begin();
			/** **/
			if (pForm.getMode().equals("I")) {
				obj.setdFechaInserta(Fechas.getDate());
				obj.setiUsuarioInsertaId(usu.getiUsuarioId());
				obj.setcEstadoCodigo(Constantes.estadoActivo);
				obj.setTipoDocumento(Util.listaDocGest().get(2));/*
																 * get(2)= 7:
																 * NOTA DE
																 * CREDITO *
																 */

				/**** Informacion de detalle compra ****/
				if (sesion.getAttribute("listaVentaDetalle") != null) {
					for (Ventadetalle ingresoDetalle : (List<Ventadetalle>) sesion.getAttribute("listaVentaDetalle")) {

						if (ingresoDetalle.getcEstadoCodigo().equals(
								Constantes.estadoActivo)) {
							/** Actualizamos el estado de la Compra **/
							// Ventadetalle ingresoDetalle;
							objVenta = ventaDao.findEndidad(ingresoDetalle
									.getVenta(), ingresoDetalle.getVenta()
									.getiVentaId());
							objVenta.setvEstadoDocumento(pForm
									.getvEstadoDocumento());

							Ventadevoluciondetalle objDetalle = new Ventadevoluciondetalle();
							obj.setVenta(objVenta);

							objDetalle.setVentadevolucion(obj);
							objDetalle
									.setProducto(ingresoDetalle.getProducto());
							objDetalle.setfVentaDevDetallePrecio(ingresoDetalle
									.getfVentaDetallePrecio());
							objDetalle
									.setiVentaDevDetalleCantidad(ingresoDetalle
											.getiVentaDetalleCantidad());
							objDetalle.setfVentaDevDetalleTotal(ingresoDetalle
									.getfVentaDetalleTotal());
							objDetalle.setdFechaInserta(Fechas.getDate());
							objDetalle.setcEstadoCodigo(ingresoDetalle
									.getcEstadoCodigo());
							objDetalle.setfDescuento(ingresoDetalle
									.getfDescuento());

							ingresoproductodevoluciondetalles.add(objDetalle);

							Producto producto = ventaDao.findEndidad(
									ingresoDetalle.getProducto(),
									ingresoDetalle.getProducto()
											.getiProductoId());

							/***********************************************************************************/
							/***
							 * Actualizamos la cantidad del producto en stock,
							 * el precio de compra y venta
							 *****/
							/***
							 * Segun metodologia FIFO- Primero en entrar,
							 * Primero en Salir
							 **/
							/***
							 * Si la cantidad ingresada es manor que el stock de
							 * la lista de precios /
							 ***********************************************************************************/
							int iCantidad = 0;
							int i = 0;
							int asignado = 0;

							cantidadProductoActual = ingresoDetalle
									.getiVentaDetalleCantidad();
							producto.setiProductoStockTotal(producto
									.getiProductoStockTotal()
									+ ingresoDetalle.getiVentaDetalleCantidad());

							Collections.sort(objVenta.getKardexs(),
									new Comparator<Kardex>() {
										public int compare(Kardex p1, Kardex p2) {
											// return new
											// Integer(p1.getiKardexId()).compareTo(new
											// Integer(p2.getiKardexId()));
											return p1.getvConcepto().compareTo(
													p2.getvConcepto());
										}
									});
							for (Kardex objKardex : objVenta.getKardexs()) {

								/** Actualizamos el Kardex **/
								Kardex kardex = new Kardex();
								kardex.setProducto(producto);
								kardex.setVentadevolucion(obj);
								kardex.setdFecha(Fechas.getDate());
								kardex.setvConcepto(Constantes.conceptoz + i);
								kardex.setiCantExistencia(objKardex
										.getiCantExistencia());
								kardex.setfPuExistencia(objKardex
										.getfPuExistencia());
								kardex.setfTotalExistencia(kardex
										.getiCantExistencia()
										* kardex.getfPuExistencia());
								kardex.setdFechaInserta(Fechas.getDate());
								kardex.setiUsuarioInsertaId(usu.getiUsuarioId());
								kardex.setcEstadoCodigo(Constantes.estadoActivo);
								if (i == 0)
									kardex.setvConcepto(Constantes.conceptoDevVenta
											+ ventaDao
													.findEndidad(
															pForm.getTipoDocumento(),
															pForm.getiTipoDocumentoId())
													.getvTipoDocumentoDescripcion()
											+ Constantes.nro
											+ objVenta.getnVentaNumero());
								iCantidad = cantidadProductoActual;
								cantidadProductoActual = objKardex
										.getiCantVenta()
										- cantidadProductoActual;
								if (asignado == 0
										&& objKardex.getiCantVenta() > 0) {
									if (cantidadProductoActual <= 0) {

										for (Preciosproducto objpreciosProducto : producto
												.getPreciosproductodetallles()) {
											if (objKardex.getfPuExistencia() == objpreciosProducto
													.getfPrecioCompra()) {
												objpreciosProducto
														.setiCantidadStock(objKardex
																.getiCantExistencia()
																+ objKardex
																		.getiCantVenta());
												ventaDao.mergeEndidad(objpreciosProducto);
											}
										}
										kardex.setiCantExistencia(objKardex
												.getiCantExistencia()
												+ objKardex.getiCantVenta());
										kardex.setfPuExistencia(objKardex
												.getfPuExistencia());
										kardex.setfTotalExistencia(objKardex
												.getfPuExistencia()
												* objKardex
														.getiCantExistencia());
										kardex.setiCantIngresoProducto(objKardex
												.getiCantVenta());
										kardex.setfPuIngresoProducto(objKardex
												.getfPuExistencia());
										kardex.setfTotalngresoProducto(kardex
												.getiCantIngresoProducto()
												* kardex.getfPuIngresoProducto());
										cantidadProductoActual = cantidadProductoActual
												* -1;

									} else {
										for (Preciosproducto objpreciosProducto : producto
												.getPreciosproductodetallles()) {
											if (objKardex.getfPuExistencia() == objpreciosProducto
													.getfPrecioCompra()) {
												objpreciosProducto
														.setiCantidadStock(objKardex
																.getiCantExistencia()
																+ iCantidad);
												ventaDao.mergeEndidad(objpreciosProducto);
											}
										}
										kardex.setiCantExistencia(objKardex
												.getiCantExistencia()
												+ iCantidad);
										kardex.setfPuExistencia(objKardex
												.getfPuExistencia());
										kardex.setfTotalExistencia(objKardex
												.getfPuExistencia()
												* objKardex
														.getiCantExistencia());
										kardex.setiCantIngresoProducto(iCantidad);
										kardex.setfPuIngresoProducto(objKardex
												.getfPuExistencia());
										kardex.setfTotalngresoProducto(kardex
												.getiCantIngresoProducto()
												* kardex.getfPuIngresoProducto());
										asignado = 1;

									}// if asignado

								}// if
								listaKardex.add(kardex);
								i++;
							}// for
							// for(Kardex
							// oKardex:kardexDao.buscarKardexProducto(producto.getiProductoId())){
							// oKardex.setcEstadoCodigo(Constantes.estadoInactivo);
							// }
							producto.setKardexs(listaKardex);

							ventaDao.persistEndidad(producto);
						}// if activo
					} // for
					obj.setVentadevoluciondetalles(ingresoproductodevoluciondetalles);
				}// / no null
				ventaDao.mergeEndidad(objVenta);
				ventaDao.persistEndidad(obj);
				resultado = ventaDao.commitEndidad(entityTransaction);

				if (resultado == true) {
					int iVentaDevolucionId = obj.getiVentaDevolucionId();
					ventaDao.entityTransaction().begin();
					contabilidadDao.callDevVentaContabilidad(
							iVentaDevolucionId, usu.getiUsuarioId(), pForm
									.getMode(), obj.getVenta()
									.getvEstadoDocumento(), iPeriodoId);
					resultado = ventaDao.commitEndidad(ventaDao
							.entityTransaction());
				}
				ventaDao.refreshEndidad(obj);
				// ventaDao.refreshEndidad(objVenta);
				if (pForm.getvImprimir().equals("SI")) {
					imprimir(mapping, pForm, request, response);
				}
			}
			if (pForm.getMode().equals("U")) {
				obj = ventaDao.findEndidad(pForm.getVentaDev(), pForm
						.getVentaDev().getiVentaDevolucionId());
				// obj= Util.comparar(obj,
				// pForm.getVentaDev());//pForm.getVenta();

				obj.setdFechaActualiza(Fechas.getDate());
				obj.setiUsuarioActualizaId(usu.getiUsuarioId());
				obj.setcEstadoCodigo(Constantes.estadoActivo);

				/**** Informacion de detalle compra ****/
				listaDetalle = (List<Ventadevoluciondetalle>) sesion.getAttribute("listaVentaDetalleOriginal");
				if (sesion.getAttribute("listaVentaDetalle") != null) {
					for (Ventadetalle ventaDetalle : (List<Ventadetalle>) sesion.getAttribute("listaVentaDetalle")) {
						objVenta = ventaDao.findEndidad(ventaDetalle.getVenta(), ventaDetalle.getVenta().getiVentaId());

						/***
						 * Actualizamos la cantidad del producto en stock, el
						 * precio de compra y venta
						 *****/
						int i = 0;
						for (Ventadevoluciondetalle ingresoDetalles : listaDetalle) { // ingresoDetalle.getcEstadoCodigo().equals(Constantes.estadoActivo)
																						// &&

							if (ventaDetalle.getProducto().getcProductoCodigo().equals(ingresoDetalles.getProducto().getcProductoCodigo())) {

								Producto producto = ventaDao.findEndidad(ingresoDetalles.getProducto(),ingresoDetalles.getProducto().getiProductoId());

								/***
								 * Actualizamos la cantidad del producto en
								 * stock, el precio de compra y de venta
								 *****/
								if (ventaDetalle.getcEstadoCodigo().equals(
										Constantes.estadoActivo)) {

									if (ventaDetalle.getiVentaDetalleCantidad() != objVenta
											.getVentadetalles().get(i)
											.getiVentaDetalleCantidad()) {

										cantidadProductoActual = ventaDetalle
												.getiVentaDetalleCantidad()
												- objVenta
														.getVentadetalles()
														.get(i)
														.getiVentaDetalleCantidad();
										cantidadProducto = objVenta
												.getVentadetalles().get(i)
												.getProducto()
												.getiProductoStockTotal()
												- cantidadProductoActual;

										/**************************/
										/** reducimos el stock a 0 */
										producto.setiProductoStockTotal(cantidadProducto);

										int cantKardex;
										/***
										 * Agregamos al Kardex el movimiento de
										 * los productos
										 ***/
										if (cantidadProductoActual < 0) {
											Collections.sort(obj.getKardexs(),
													new Comparator<Kardex>() {
														public int compare(
																Kardex p1,
																Kardex p2) {
															// return new
															// Integer(p1.getiKardexId()).compareTo(new
															// Integer(p2.getiKardexId()));
															return p1
																	.getvConcepto()
																	.compareTo(
																			p2.getvConcepto());
														}
													});
											for (Kardex objKardex : obj
													.getKardexs()) {
												if (objKardex
														.getiCantIngresoProducto() > 0) {
													/** Actualizamos el Kardex **/
													objKardex
															.setdFechaActualiza(Fechas
																	.getDate());
													objKardex
															.setiUsuarioActualizaId(usu
																	.getiUsuarioId());
													cantKardex = cantidadProductoActual;
													cantidadProductoActual = objKardex
															.getiCantIngresoProducto()
															+ cantidadProductoActual;
													if (cantidadProductoActual < 0) {

														for (Preciosproducto objpreciosProducto : producto
																.getPreciosproductodetallles()) {
															if (objKardex
																	.getfPuExistencia() == objpreciosProducto
																	.getfPrecioCompra()) {
																objpreciosProducto
																		.setiCantidadStock(objKardex
																				.getiCantExistencia()
																				+ objKardex
																						.getiCantVenta());
																ventaDao.mergeEndidad(objpreciosProducto);
															}
														}
														objKardex
																.setiCantExistencia(objKardex
																		.getiCantExistencia()
																		+ objKardex
																				.getiCantVenta());
														objKardex
																.setfPuExistencia(objKardex
																		.getfPuExistencia());
														objKardex
																.setfTotalExistencia(objKardex
																		.getfPuExistencia()
																		* objKardex
																				.getiCantExistencia());
														objKardex
																.setiCantIngresoProducto(0);
														objKardex
																.setfPuIngresoProducto(0);
														objKardex
																.setfTotalngresoProducto(0);

													} else {
														for (Preciosproducto objpreciosProducto : producto
																.getPreciosproductodetallles()) {
															if (objKardex
																	.getfPuExistencia() == objpreciosProducto
																	.getfPrecioCompra()) {
																objpreciosProducto
																		.setiCantidadStock(objKardex
																				.getiCantVenta()
																				- cantidadProductoActual);
																ventaDao.mergeEndidad(objpreciosProducto);
															}
														}
														objKardex
																.setiCantExistencia(objKardex
																		.getiCantVenta()
																		- cantidadProductoActual);
														objKardex
																.setfPuExistencia(objKardex
																		.getfPuExistencia());
														objKardex
																.setfTotalExistencia(objKardex
																		.getfPuExistencia()
																		* objKardex
																				.getiCantExistencia());
														objKardex
																.setiCantIngresoProducto(cantidadProductoActual);
														objKardex
																.setfPuIngresoProducto(objKardex
																		.getfPuExistencia());
														objKardex
																.setfTotalngresoProducto(objKardex
																		.getfPuExistencia()
																		* objKardex
																				.getfPuExistencia());

														break;
													}

												}// if
												ventaDao.mergeEndidad(objKardex);
											}// for
										} else {
											Collections.sort(obj.getKardexs(),
													new Comparator<Kardex>() {
														public int compare(
																Kardex p1,
																Kardex p2) {
															return p1
																	.getvConcepto()
																	.compareTo(
																			p2.getvConcepto());
														}
													});

											for (Kardex objKardex : obj
													.getKardexs()) {
												if (objKardex
														.getiCantExistencia() > 0) {
													/** Actualizamos el Kardex **/
													objKardex
															.setdFechaActualiza(Fechas
																	.getDate());
													objKardex
															.setiUsuarioActualizaId(usu
																	.getiUsuarioId());
													cantKardex = cantidadProductoActual;
													cantidadProductoActual = objKardex
															.getiCantExistencia()
															- cantidadProductoActual;
													if (cantidadProductoActual < 0) {
														for (Preciosproducto objpreciosProducto : producto
																.getPreciosproductodetallles()) {
															if (objKardex
																	.getfPuExistencia() == objpreciosProducto
																	.getfPrecioCompra()) {
																objpreciosProducto
																		.setiCantidadStock(0);
																ventaDao.mergeEndidad(objpreciosProducto);
															}
														}
														objKardex
																.setfPuVenta(objKardex
																		.getfPuVenta());
														objKardex
																.setiCantVenta(objKardex
																		.getiCantExistencia()
																		+ objKardex
																				.getiCantVenta());
														objKardex
																.setfTotalVenta(objKardex
																		.getfPuExistencia()
																		* objKardex
																				.getiCantExistencia());
														objKardex
																.setiCantExistencia(0);
														objKardex
																.setfPuExistencia(objKardex
																		.getfPuExistencia());
														objKardex
																.setfTotalExistencia(objKardex
																		.getfPuExistencia()
																		* objKardex
																				.getiCantExistencia());

														cantidadProductoActual = cantidadProductoActual
																* -1;

													} else {
														for (Preciosproducto objpreciosProducto : producto
																.getPreciosproductodetallles()) {
															if (objKardex
																	.getfPuExistencia() == objpreciosProducto
																	.getfPrecioCompra()) {
																objpreciosProducto
																		.setiCantidadStock(cantidadProductoActual);
																ventaDao.mergeEndidad(objpreciosProducto);
															}
														}
														objKardex
																.setfPuVenta(objKardex
																		.getfPuVenta());
														objKardex
																.setiCantVenta(objKardex
																		.getiCantVenta()
																		+ cantKardex);
														objKardex
																.setfTotalVenta(objKardex
																		.getfPuExistencia()
																		* objKardex
																				.getfPuVenta());
														objKardex
																.setiCantExistencia(cantidadProductoActual);
														objKardex
																.setfPuExistencia(objKardex
																		.getfPuExistencia());
														objKardex
																.setfTotalExistencia(objKardex
																		.getfPuExistencia()
																		* objKardex
																				.getiCantExistencia());

														break;
													}

												}// if
												ventaDao.mergeEndidad(objKardex);
											}// for
										}

									}// if diferentes
								}// if producto activo.
								else {
									/******************************************/
									/** Insertamos detalle de lista de precios **/
									/******************************************/
									for (Preciosproducto preciosProducto : producto
											.getPreciosproductodetallles()) {
										if (preciosProducto.getfPrecioCompra() == objVenta
												.getVentadetalles().get(i)
												.getProducto()
												.getfProductoPrecioCompra()) {
											cantidadProducto = preciosProducto
													.getiCantidadStock()
													+ ventaDetalle
															.getiVentaDetalleCantidad();
											preciosProducto
													.setiCantidadStock(cantidadProducto);
											ventaDao.mergeEndidad(preciosProducto);
											break;

										}
									}
								}

								/*******************************************/
								/*** Actualizamos los valores del producto */
								/*******************************************/

								ventaDetalle.setProducto(producto);

							}// if
							i++;
						}// for

						/****/
						/** Actualizamos el estado de la Compra **/

						objVenta.setvEstadoDocumento(pForm
								.getvEstadoDocumento());

						Ventadevoluciondetalle objDetalle = new Ventadevoluciondetalle();
						obj.setVenta(objVenta);

						objDetalle.setiVentaDevolucionDetalleId(ventaDetalle
								.getiVentaDetalleId());
						objDetalle.setVentadevolucion(obj);
						objDetalle.setProducto(ventaDetalle.getProducto());
						objDetalle.setfVentaDevDetallePrecio(ventaDetalle
								.getfVentaDetallePrecio());
						objDetalle.setiVentaDevDetalleCantidad(ventaDetalle
								.getiVentaDetalleCantidad());
						objDetalle.setfVentaDevDetalleTotal(ventaDetalle
								.getfVentaDetalleTotal());
						objDetalle.setdFechaInserta(Fechas.getDate());
						objDetalle.setcEstadoCodigo(ventaDetalle
								.getcEstadoCodigo());

						ingresoproductodevoluciondetalles.add(objDetalle);

					}
					obj.setVentadevoluciondetalles(ingresoproductodevoluciondetalles);
				}

				ventaDao.mergeEndidad(obj);
				ventaDao.mergeEndidad(objVenta);

				resultado = ventaDao.commitEndidad(entityTransaction);
				/*
				 * if(resultado==true){ int
				 * iVentaDevolucionId=obj.getiVentaDevolucionId();
				 * ventaDao.entityTransaction().begin();
				 * contabilidadDao.callDevVentaContabilidad(iVentaDevolucionId,
				 * usu.getiUsuarioId(), pForm.getMode(), iPeriodoId); resultado
				 * = ventaDao.commitEndidad(entityTransaction); }
				 * ventaDao.refreshEndidad(obj);
				 */
				if (pForm.getvImprimir().equals("SI")) {
					imprimir(mapping, pForm, request, response);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			entityTransaction = null;
		}

		if (resultado == true) {
			msn = "msnOk";

		} else {
			msn = "msnError";

		}
		return mapping.findForward(msn);
	}

	@Override
	public Map<String, Object> cargarContenidoExportar(ActionForm form,
			HttpServletRequest request, String plantilla) throws ParseException {

		VentaForm objform = (VentaForm) form;
		VentaDao ventaDao = new VentaDao();

		Map<String, Object> beans = new HashMap<String, Object>();
		if ("venta".equals(plantilla)) {
			List<Venta> ventas = ventaDao.listaVenta(0, 1000,
					objform.getVenta());
			beans.put("ventas", ventas);

		} else if ("venta-devolucion".equals(plantilla)) {
			List<Ventadevolucion> listaVentaDevolucion = ventaDao
					.listaVentaDevolucion(0, 1000, objform.getVenta());
			beans.put("devolucionVentas", listaVentaDevolucion);
		}

		return beans;
	}

	@Override
	public void cargarContenidoImprimir(ActionForm form,
			HttpServletRequest request, Impresora impresora,
			ActionMapping mapping, HttpServletResponse response)
			throws IllegalAccessException, IOException,
			IllegalArgumentException, SecurityException,
			ClassNotFoundException, NoSuchFieldException, ParseException {

		VentaDao ventaDao = new VentaDao();
		// int id = Integer.parseInt(request.getParameter("id"));
		// String tipoImpresion = request.getParameter("tipoImpresion");
		VentaForm ventaForm = (VentaForm) form;
		Venta venta = null;
		
		impresora.asignarDispositivo(ventaForm.getImpresoraID());
		
		if (ventaForm.getvTipoImpresion().equals("venta")) {
			/*
			 * if (id == 0) {
			 * 
			 * ventaForm.setMode("I"); iduVenta(mapping, form, request,
			 * response); venta = ventaDao.findEndidadBD(new Venta(),
			 * "iVentaId", ventaForm.getVenta().getiVentaId()); } else {
			 */
			venta = ventaDao.findEndidadBD(new Venta(), "iVentaId", ventaForm.getVenta().getiVentaId());

			// }
			impresora.agregarLineaCentrada(venta.getTipoDocumento().getvTipoDocumentoDescripcion()
					+ " ELECTRONICO: " + venta.getnVentaNumero());
			impresora.agregarLinea("FECHA EMISION: " + Fechas.fechaConFormato("dd/MM/yyyy HH:mm:SS"));
			impresora.agregarTituloIzquierda("VENDEDOR", 8, venta.getUsuario().getPersonal().getvPersonalApellidoPaterno()
					+ " " + venta.getUsuario().getPersonal().getvPersonalApellidoMaterno()
					+ ", " + venta.getUsuario().getPersonal().getvPersonalNombres());

			impresora.agregarSeparacion();

			impresora.agregarTituloIzquierda("CLIENTE SR(A)", 8, venta.getCliente().getvClienteRazonSocial());
			impresora.agregarTituloIzquierda("RUC/DNI", 8, venta.getCliente().getnClienteNumeroDocumento().toString());

			for (Direccioncliente direccioncliente : venta.getCliente().getDireccionclientes()) {
				if ("1".equals(direccioncliente.getvPrincipal())) {
					impresora.agregarTituloIzquierda("DIRECCION", 8, direccioncliente.getvDireccion());
				}
			}

			impresora.agregarSeparacion();
			impresora.agregarCabeceraDetalleProducto("CODIGO", "DESCRIPCION", "CANT", "P.UNIT", "IMPORTE");
			impresora.agregarSeparacion();

			// aqui recorro mis productos y los imprimo
			for (Ventadetalle ventadetalle : venta.getVentadetalles()) {
				impresora.agregarDetalleProducto(ventadetalle.getProducto().getcProductoCodigo(),
													ventadetalle.getProducto().getvProductoNombre(),
													ventadetalle.getiVentaDetalleCantidad(),
													ventadetalle.getfVentaDetallePrecio(), 
													ventadetalle.getfVentaDetalleTotal());

			}

			impresora.agregarSeparacion();
			// Descuentos
			impresora.agregarTituloDerecha("TOTAL", 0, venta.getvTipoVenta() + 
					Util.completarEspacioIzquierda(FormatosNumeros.FormatoDecimalMoneda(venta.getfVentaTotalReal()), 11));
			impresora.agregarTituloDerecha("DESCUENTO", 0, venta.getvTipoVenta()+ 
					Util.completarEspacioIzquierda("-"+ FormatosNumeros.FormatoDecimalMoneda(venta.getfDescuento()), 11));
			impresora.agregarTituloDerecha("DSCTO CLIENTE", 0, venta.getvTipoVenta() + 
					Util.completarEspacioIzquierda("-" + FormatosNumeros.FormatoDecimalMoneda(venta.getfDescClienteVenta()), 11));

			impresora.agregarTituloDerecha("SUBTOTAL", 0, venta.getvTipoVenta() + 
					Util.completarEspacioIzquierda(FormatosNumeros.FormatoDecimalMoneda(venta.getfVentaSubTotal()), 11));
			impresora.agregarTituloDerecha("IGV", 0, venta.getvTipoVenta() + 
					Util.completarEspacioIzquierda(FormatosNumeros.FormatoDecimalMoneda(venta.getfVentaIGV()), 11));
			impresora.agregarTituloDerecha("TOTAL FINAL", 0, venta.getvTipoVenta() + 
					Util.completarEspacioIzquierda(FormatosNumeros.FormatoDecimalMoneda(venta.getfVentaTotal()), 11));

			impresora.agregarSeparacion();

			impresora.agregarTituloDerecha("PAGO", 0, venta.getvTipoPago() + 
					Util.completarEspacioIzquierda(FormatosNumeros.FormatoDecimalMoneda(venta.getfMontoPago()), 11));
			impresora.agregarTituloDerecha("VUELTO", 0, venta.getvTipoPago() + 
					Util.completarEspacioIzquierda(FormatosNumeros.FormatoDecimalMoneda(venta.getfMontoVuelto()), 11));

		} else if (ventaForm.getvTipoImpresion().equals("ventaDevolucion")) {
			
			Ventadevolucion ventaDev = ventaDao.findEndidadBD(
					new Ventadevolucion(), "iVentaDevolucionId", ventaForm
							.getVentaDev().getiVentaDevolucionId());

			impresora.agregarLineaCentrada(ventaDev.getTipoDocumento()
					.getvTipoDocumentoDescripcion()
					+ " ELECTRONICO: "
					+ ventaDev.getVenta().getnVentaNumero());
			impresora.agregarLinea("FECHA EMISION: "
					+ Fechas.fechaConFormato("dd/MM/yyyy HH:mm:SS"));
			impresora.agregarTituloIzquierda("VENDEDOR", 8, ventaDev.getVenta()
					.getUsuario().getPersonal().getvPersonalApellidoPaterno()
					+ " "
					+ ventaDev.getVenta().getUsuario().getPersonal()
							.getvPersonalApellidoMaterno()
					+ ", "
					+ ventaDev.getVenta().getUsuario().getPersonal()
							.getvPersonalNombres());
			impresora.agregarSeparacion();

			impresora.agregarTituloIzquierda("CLIENTE SR(A)", 8, ventaDev
					.getVenta().getCliente().getvClienteRazonSocial());
			impresora.agregarTituloIzquierda("RUC/DNI", 8, ventaDev.getVenta()
					.getCliente().getnClienteNumeroDocumento().toString());

			for (Direccioncliente direccioncliente : ventaDev.getVenta()
					.getCliente().getDireccionclientes()) {
				if ("1".equals(direccioncliente.getvPrincipal())) {
					impresora.agregarTituloIzquierda("DIRECCION", 8,
							direccioncliente.getvDireccion());
				}
			}

			impresora.agregarSeparacion();
			impresora.agregarCabeceraDetalleProducto("CODIGO", "DESCRIPCION", "CANT", "P.UNIT", "IMPORTE");
			impresora.agregarSeparacion();

			// aqui recorro mis productos y los imprimo
			for (Ventadevoluciondetalle ventadetalle : ventaDev.getVentadevoluciondetalles()) {
				
				impresora.agregarDetalleProducto(ventadetalle.getProducto().getcProductoCodigo(), 
												ventadetalle.getProducto().getvProductoNombre(), 
												ventadetalle.getiVentaDevDetalleCantidad(),
												ventadetalle.getfVentaDevDetallePrecio(), 
												ventadetalle.getfVentaDevDetalleTotal());

			}

			impresora.agregarSeparacion();
			// Descuentos
			impresora.agregarTituloDerecha(
					"SUBTOTAL",
					0,
					ventaDev.getVenta().getvTipoVenta()
							+ Util.completarEspacioIzquierda(FormatosNumeros
									.FormatoDecimalMoneda(ventaDev
											.getfVentaDevSubTotal()), 11));
			impresora.agregarTituloDerecha(
					"IGV",
					0,
					ventaDev.getVenta().getvTipoVenta()
							+ Util.completarEspacioIzquierda(FormatosNumeros
									.FormatoDecimalMoneda(ventaDev
											.getfVentaDevIGV()), 11));
			impresora.agregarTituloDerecha(
					"TOTAL FINAL",
					0,
					ventaDev.getVenta().getvTipoVenta()
							+ Util.completarEspacioIzquierda(FormatosNumeros
									.FormatoDecimalMoneda(ventaDev
											.getfVentaDevTotal()), 11));
			impresora.agregarSeparacion();
			impresora.agregarTituloIzquierda("NOTA CREDITO", 8,
					ventaDev.getnNroNotaCredito()
							+ " POR LA DEVOLUCION DE LA MERCADERIA "
							+ ventaDev.getVenta().getTipoDocumento()
									.getvTipoDocumentoDescripcion() + ": "
							+ ventaDev.getVenta().getnVentaNumero());

		} else if (ventaForm.getvTipoImpresion().equals("arqueoIndividual")) {

			generarArqueo(request, impresora);
			
		}
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
	public ActionForward verArqueoVendedor(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		VentaForm ventaForm = (VentaForm) form;
		String msn = "showArqueo";
		List<ImpresoraVO> listaImpresora = Impresora.listarImpresoras();
		Impresora impresora = new Impresora();
		
		generarArqueo(request, impresora);
		HttpSession sesion = request.getSession();
		ventaForm.setvTextoImpresion(impresora.toString());
		sesion.setAttribute("listaImpresora", listaImpresora);
		return mapping.findForward(msn);
	}
	
	private void generarArqueo(HttpServletRequest request, Impresora impresora) {
		HttpSession sesion = request.getSession();
		Usuario usuario = (Usuario) sesion.getAttribute("Usuario");
		VentaDao ventaDao = new VentaDao();
		Venta venta = new Venta();
		venta.setUsuario(usuario);
		venta.setdVentaFecha(Fechas.getDate());
		List<Venta> detalleArqueoVentas = ventaDao.listaVenta(0, 1000, venta);
		int contadorVentas = 0;
		double totalVenta = 0;
		
		impresora.agregarLineaCentrada("* ARQUEO INDIVIDUAL *");
		impresora.agregarSaltoLinea(1);
		impresora.agregarTituloIzquierda("FECHA Y HORA", 10, Fechas.fechaFormato(venta.getdVentaFecha(), "dd-MM-yyyy HH:mm:ss"));
		impresora.agregarTituloIzquierda("CAJERO", 10, usuario.getPersonal().getvPersonalApellidoPaterno() + " " + usuario.getPersonal().getvPersonalApellidoMaterno() + " " + usuario.getPersonal().getvPersonalNombres());
		
		List<String> listaMedioPago = new ArrayList<String>();
		List<Double> listaTotalPorMedioPago = new ArrayList<Double>();
		List<String> listaMedioPagoDol = new ArrayList<String>();			
		List<Double> listaTotalPorMedioPagoDol = new ArrayList<Double>();
		
		GenericaDao dao = new GenericaDao();
		List<Mediopago> listaMP = dao.listaEntidadGenericaSinCodigo("Mediopago");
		
		for (Mediopago mediopago : listaMP) {
			listaMedioPago.add(mediopago.getvNombre() + " SOLES");
			listaTotalPorMedioPago.add(0.0);
			listaMedioPagoDol.add(mediopago.getvNombre() +" DOLARES");
			listaTotalPorMedioPagoDol.add(0.0);
		}
		
		List<String> listaHora = new ArrayList<String>();
		List<Double> listaTotalPorHora = new ArrayList<Double>();
		
		if (detalleArqueoVentas != null && detalleArqueoVentas.size() > 0) {
			
			double totalMedioPago;
			int indice = -1;
			SimpleDateFormat format = new SimpleDateFormat("HH");
			for (Venta arqueoVenta : detalleArqueoVentas) {
				contadorVentas++;
				
				if ("S/.".equals(arqueoVenta.getvTipoPago())) {
					
					if (arqueoVenta.getfMontoPago() > 0) {
						indice = arqueoVenta.getMedioPago1().getiMedioPagoId() - 1;

						totalMedioPago = listaTotalPorMedioPago.get(indice) + arqueoVenta.getfMontoPago() - arqueoVenta.getfMontoVuelto();
						
						listaTotalPorMedioPago.set(indice, totalMedioPago);
					}

					if (arqueoVenta.getfMontoPagoCredito() > 0) {
						indice = arqueoVenta.getMedioPago2().getiMedioPagoId() - 1;

						totalMedioPago = listaTotalPorMedioPago.get(indice) + arqueoVenta.getfMontoPagoCredito();
						
						listaTotalPorMedioPago.set(indice, totalMedioPago);
					}
					
				}
					
				if ("$".equals(arqueoVenta.getvTipoPago())) {
					if (arqueoVenta.getfMontoPago() > 0) {
						indice = arqueoVenta.getMedioPago1().getiMedioPagoId() - 1;

						totalMedioPago = listaTotalPorMedioPagoDol.get(indice) + arqueoVenta.getfMontoPago() - arqueoVenta.getfMontoVuelto();
						
						listaTotalPorMedioPagoDol.set(indice, totalMedioPago);
					}

					if (arqueoVenta.getfMontoPagoCredito() > 0) {
						indice = arqueoVenta.getMedioPago2().getiMedioPagoId() - 1;

						totalMedioPago = listaTotalPorMedioPagoDol.get(indice) + arqueoVenta.getfMontoPagoCredito() - arqueoVenta.getfMontoVuelto();
						
						listaTotalPorMedioPagoDol.set(indice, totalMedioPago);
					}
					
				}


				String textoHora = format.format(arqueoVenta.getdFechaInserta());
				indice = listaHora.indexOf(textoHora);
				if (indice < 0) {
					indice = listaTotalPorHora.size();
					listaHora.add(textoHora);
					listaTotalPorHora.add(0.0);
					
				}
				
				totalVenta += arqueoVenta.getfVentaTotal();
				totalMedioPago = listaTotalPorHora.get(indice) + arqueoVenta.getfVentaTotal();
				
				listaTotalPorHora.set(indice, totalMedioPago);
				
			}
			
			impresora.agregarSeparacion();
			impresora.agregarLinea(new Object[][]{
				{"ARQUEO POR MOVIMIENTO", 0, 1},
				{FormatosNumeros.FormatoDecimalMoneda(totalVenta), 30, -1}
			});
			
			impresora.agregarSeparacion();
			
			impresora.agregarLinea(new Object[][]{
				{"VENTAS", 0, 1},
				{" ---> (" + contadorVentas +")", 15, 1},
				{FormatosNumeros.FormatoDecimalMoneda(totalVenta), 30, -1}
			});
			impresora.agregarSaltoLinea(1);
			impresora.agregarLineaDerecha("--------- VENTA DETALLADA ---------");
			indice = 0;
			String medioPago;
			for (double montoAcumuladoTipoPago : listaTotalPorMedioPago) {
				if (montoAcumuladoTipoPago > 0) {
					medioPago = listaMedioPago.get(indice);
					impresora.agregarLinea(new Object[][]{
							{"", 0, 1},
							{medioPago, 5, 1},
							{FormatosNumeros.FormatoDecimalMoneda(montoAcumuladoTipoPago), 30, -1}
						});
					
				}
				indice++;
			}
			indice = 0;
			for (double montoAcumuladoTipoPago : listaTotalPorMedioPagoDol) {
				if (montoAcumuladoTipoPago > 0) {
					medioPago = listaMedioPagoDol.get(indice);
					impresora.agregarLinea(new Object[][]{
							{"", 0, 1},
							{medioPago, 5, 1},
							{FormatosNumeros.FormatoDecimalMoneda(montoAcumuladoTipoPago), 30, -1}
						});
					
				}
				indice++;
			}
			
			impresora.agregarSaltoLinea(1);
			impresora.agregarSeparacion();
			impresora.agregarLinea(new Object[][]{
				{"ARQUEO POR HORA", 0, 1},
				{FormatosNumeros.FormatoDecimalMoneda(totalVenta), 30, -1}
			});
			
			impresora.agregarSeparacion();
			indice = 0;
			String textoHora;
			for (double montoAcumuladoHora : listaTotalPorHora) {
				if (montoAcumuladoHora > 0) {
					textoHora = listaHora.get(indice);
					impresora.agregarLinea(new Object[][]{
							{textoHora + ":00", 0, 1},
							{FormatosNumeros.FormatoDecimalMoneda(montoAcumuladoHora), 30, -1}
						});
					
				}
				indice++;
			}
			
			
			
		}
		
	}
	
}