package com.struts.action;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dao.ConfiguracionDao;
import com.dao.EstadoCuentaClienteDao;
import com.dao.GenericaDao;
import com.dao.IngresoProductoDao;
import com.dao.PerfilDao;
import com.dao.ProductoDao;
import com.dao.UsuarioDao;
import com.dao.VentaDao;
import com.entities.Configuracion;
import com.entities.Impuesto;
import com.entities.Letracliente;
import com.entities.Letraproveedor;
import com.entities.Permiso;
import com.entities.Producto;
import com.entities.Usuario;
import com.entities.vo.EstadisticaVo;
import com.entities.vo.EstadoCuentaVo;
import com.struts.form.LoginForm;
import com.util.Constantes;
import com.util.Fechas;
import com.util.Impresora;
import com.util.Paginacion;

public class LoginAction extends BaseAction {
	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		String msn="";
		HttpSession sesion = request.getSession();	
		sesion.removeAttribute("Usuario");
		sesion.removeAttribute("Fecha");
		sesion.removeAttribute("id");
		sesion.removeAttribute("listaMisPermisoUsuario");
		sesion.removeAttribute("Moneda");
		sesion.removeAttribute("TipoCambio");
		sesion.removeAttribute("IGVCompras");
		sesion.removeAttribute("IGVPercepcion");
		sesion.removeAttribute("IGVVentas");
		sesion.removeAttribute("iPeriodoId");
		sesion.removeAttribute("nombreImpresora");
		
		
		
		/** Instanciamos la Clase LoginForm **/
		LoginForm objform = (LoginForm) form;
		List<Usuario> usuario = new ArrayList<Usuario>();
		List<Permiso> listapermiso = new ArrayList<Permiso>();
		
	/** Instanciamos la Clase ProductoForm **/
			
		UsuarioDao usuarioDao = new UsuarioDao();
		PerfilDao perfilDao = new PerfilDao();
	    GenericaDao genericaDao = new GenericaDao();
		List<EstadisticaVo> listaAnio = new ArrayList<EstadisticaVo>();
		int j=0;
		usuario= usuarioDao.login(objform.getvUsuarioLogin(), objform.getvUsuarioPassword(),"");

		if (usuario != null && usuario.size() > 0) {

			listapermiso = perfilDao.listaFindPermiso(usuario.get(0)
					.getiUsuarioId());

			if (listapermiso != null && listapermiso.size() > 0) {
				

				ConfiguracionDao configuracionDao = new ConfiguracionDao();
				Configuracion confi = configuracionDao
						.buscarConfiguracion(Constantes.tipoMoneda);
				Configuracion tipoCambio = configuracionDao
						.buscarConfiguracion(Constantes.tipoCambio);
				Impuesto impuestoVenta = configuracionDao
						.buscarImpuesto(Constantes.IGVVenta);
				Impuesto impuestoCompras = configuracionDao
						.buscarImpuesto(Constantes.IGVCompra);
				Impuesto impuestoPercepciones = configuracionDao
						.buscarImpuesto(Constantes.IGVPercepcion);
				Configuracion nombreImpresora = configuracionDao
						.buscarConfiguracion(Constantes.nombreImpresora);
				
				int iPeriodoId = genericaDao.callSPPeriodoActual();

				
				sesion.setAttribute("Usuario", usuario.get(0));
				sesion.setAttribute("Fecha",
						Fechas.fechaDDMMYY((Fechas.getDate())));
				sesion.setAttribute("id", sesion.getId());

				sesion.setAttribute("Moneda",
						configuracionDao.buscarMoneda(confi.getvValor()));
				sesion.setAttribute("TipoCambio", tipoCambio.getvValor());
				sesion.setAttribute("IGVCompras",
						impuestoCompras.getvPorcentaje());
				sesion.setAttribute("IGVPercepcion",
						impuestoPercepciones.getvPorcentaje());
				sesion.setAttribute("IGVVentas", impuestoVenta.getvPorcentaje());
				sesion.setAttribute("iPeriodoId", iPeriodoId);
				sesion.setAttribute("nombreImpresora", nombreImpresora);
				// sesion.setAttribute("listaMenu",
				// genericaDao.listaEntidadGenericaSinCodigo("Menu"));
				List<String> listaMisPersmisos = new ArrayList<String>();
				for (Permiso lista : listapermiso) {
					listaMisPersmisos.add(lista.getvCodigoMenu());

				}

				sesion.setAttribute("listaMisPermisoUsuario", listaMisPersmisos);

				/***
				 * determinamos la lista de años para visualizar las
				 * estadisticas del modulo estadistica
				 **/
				for (int i = -2; i <= 0; i++) {
					EstadisticaVo e = new EstadisticaVo();
					e.setAnio(Fechas.anioActual(j));
					listaAnio.add(e);
					j--;
				}
				sesion.setAttribute("listaAnio", listaAnio);
				/***
				 * Seteamos la localidad para dar formato a los numeros 2,000.00
				 ****/
				sesion.setAttribute("Localidad", new Locale("en", "US"));

				return home(mapping, objform, request, response);

			} else {
				objform.setMensaje("No se le han asignado permisos, Consulte con su Administrador ");

			}
		} else {
			objform.setMensaje("Usuario o Clave son incorrectos");

		}
		objform.setMode("m_mensaje");
		msn = "login";

		return mapping.findForward(msn);
	}
	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward home(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		String msn="";
		HttpSession sesion = request.getSession();	
		int pagina = Paginacion.paginaInicial;
		int pagInicio = Paginacion.paginaInicial;
		if(request.getParameter("pagina")!= null){
			 pagina = Integer.parseInt(request.getParameter("pagina"));
		}
	/** Instanciamos la Clase ProductoForm **/

		/** Instanciamos la Clase LoginForm **/
		LoginForm objform = (LoginForm) form;
		ProductoDao productoDao = new ProductoDao();
		EstadoCuentaClienteDao letraClienteDao = new EstadoCuentaClienteDao();
		VentaDao ventaDao = new VentaDao();
		IngresoProductoDao ingresoProductoDao = new IngresoProductoDao();
		
		
		Usuario usu = (Usuario) sesion.getAttribute("Usuario");	
		if(usu!=null){
			
			if(usu.getPerfil().getvPerfilDescripcion().equals(Constantes.usuAdministrador)){
				
				/******************************************/
				/** LISTADO DE PRODUCTOS CON STOCK MINIMO**/
				/****************************************/
				List<Producto> listaProducto = productoDao.listaProductoStockMinimo(Paginacion.pagInicio(pagina),Paginacion.pagFin(),1);
				
				/**Consultamos el total de registros segun criterio**/
				List<Producto> listaProductoTotal = productoDao.listaProductoStockMinimo(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),1);
				
		        /**Obtenemos el total del paginas***/
				List<Long> paginas = Paginacion.listPaginas((long)(listaProductoTotal.size()));
				
				 /** Seteamos las clase ProductoForm **/
				objform.setLista(listaProducto);
				objform.setPaginas(paginas);
				objform.setPagInicio(pagina);
				

				/******************************************/
				/** LISTADO DE PRODUCTOS CON STOCK MAXIMO**/
				/****************************************/
				List<Producto> listaProductoMax = new ArrayList<Producto>();
				List<Producto> listaPerfilTotalMax  = new ArrayList<Producto>();
				
				listaProductoMax = productoDao.listaProductoStockMaximo(Paginacion.pagInicio(pagina),Paginacion.pagFin(),1);
				
				/**Consultamos el total de registros segun criterio**/
				 listaPerfilTotalMax = productoDao.listaProductoStockMaximo(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),1);
				
		        /**Obtenemos el total del paginas***/
				List<Long> paginasMax = Paginacion.listPaginas((long)(listaPerfilTotalMax.size()));
				
				 /** Seteamos las clase ProductoForm **/
				objform.setListaProductoMax(listaProductoMax);
				objform.setPaginasProductoMax(paginasMax);
				objform.setPagInicioProductoMax(pagina);
				
				/**********************************/
				/** LISTADO DE DEUDA DE CLIENTES **/
				/**********************************/				
				List<EstadoCuentaVo> listaDeudaCliente = listarEstadoCuentaCliente(objform.getVenta(), ventaDao, Paginacion.pagInicio(pagina), Paginacion.pagFin());
				List<EstadoCuentaVo> listaDeudaClienteTotal = listarEstadoCuentaCliente(objform.getVenta(), ventaDao, Paginacion.pagInicio(pagina), Paginacion.pagFinMax());
				List<Long> paginasDeudaCliente = Paginacion.listPaginas((long)(listaDeudaClienteTotal.size()));
				 
				 /** Seteamos las clase ProductoForm **/
				objform.setListaDeudaCliente(listaDeudaCliente);
				objform.setPaginasDeudaCliente(paginasDeudaCliente);
				objform.setPagInicioDeudaCliente(pagina);
				
				/**********************************/
				/** LISTADO DE DEUDA DE CLIENTES LETRA   **/
				/**********************************/				
				List<Letracliente> listaLetraCliente =letraClienteDao.listaLetraCliente(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getLetracliente());
				List<Letracliente> listaLetraClienteTotal = letraClienteDao.listaLetraCliente(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getLetracliente());
				List<Long> paginasLetraCliente= Paginacion.listPaginas((long)(listaLetraClienteTotal.size()));
				 
				 /** Seteamos las clase ProductoForm **/
				objform.setListaDeudaClienteLetra(listaLetraCliente);
				objform.setPaginasDeudaClienteLetra(paginasLetraCliente);
				objform.setPagInicioDeudaClienteLetra(pagina);
				
				
				/**********************************/
				/** LISTADO DE DEUDA DE PROVEEDORES **/
				/**********************************/				
				List<EstadoCuentaVo> listaDeudaProveedor = listaEstadoCuentaPorProveedor(objform.getIngresoProducto(), ingresoProductoDao, Paginacion.pagInicio(pagina), Paginacion.pagFin());
				List<EstadoCuentaVo> listaDeudaProveedorTotal = listaEstadoCuentaPorProveedor(objform.getIngresoProducto(), ingresoProductoDao, Paginacion.pagInicio(pagina), Paginacion.pagFinMax());
				List<Long> paginasDeudaProveedor = Paginacion.listPaginas((long)(listaDeudaProveedorTotal.size()));
				
				 /** Seteamos las clase ProductoForm **/
				objform.setListaDeudaProveedor(listaDeudaProveedor);
				objform.setPaginasDeudaProveedor(paginasDeudaProveedor);
				objform.setPagInicioDeudaProveedor(pagina);
				

				/*************************************/
				/** LISTADO DE DEUDA DE PROVEEDORES LETRA **/
				/*************************************/				
			
			
		    	List<Letraproveedor> listaLetraProveedor = ingresoProductoDao.listaLetraProveedor(Paginacion.pagInicio(pagina),Paginacion.pagFin(),objform.getLetraProveedor());
				List<Letraproveedor> listaLetraTotal = ingresoProductoDao.listaLetraProveedor(Paginacion.pagInicio(pagInicio),Paginacion.pagFinMax(),objform.getLetraProveedor());
				List<Long> paginasLetra = Paginacion.listPaginas((long)(listaLetraTotal.size()));
			
				 /** Seteamos las clase ProductoForm **/
				objform.setListaDeudaProveedorLetra(listaLetraProveedor);
				objform.setPaginasDeudaProveedorLetra(paginasLetra);
				objform.setPagInicioDeudaProveedorLetra(pagina);
			
				
				
				msn="bienvenidoAdmin";
			}else{
				msn="bienvenidoUser";
			}
					
					
		}	
		else{
			 msn="login";
		}
				
		return mapping.findForward(msn);
	}
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		String msn="";
		HttpSession sesion = request.getSession();		
		sesion.removeAttribute("Usuario");
		msn="login";
			
		return mapping.findForward(msn);
	}
	public ActionForward restablecer(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		/** Instanciamos la Clase LoginForm **/
		LoginForm objform = (LoginForm) form;
		String msn="";
		
		
		List<Usuario> usuario = new ArrayList<Usuario>();	
		UsuarioDao usuariosDao = new UsuarioDao();
		
		
		if(objform.getvUsuarioLogin()!=null){
			usuario= usuariosDao.login(objform.getvUsuarioLogin(), objform.getvUsuarioPassword(),objform.getnPersonalNumeroDocumento().toString());
			if(usuario.size()>0){
				/****Actualizamos la clave ***/
				Usuario obju = usuario.get(0);
				obju.setvUsuarioPassword(objform.getvUsuarioPassword());
				usuariosDao.actualizarUnaEndidad(obju);
				
				msn = "login"; 
				objform.setvUsuarioLogin("");
				objform.setvUsuarioPassword("");
				objform.setMensaje("Ingrese la nueva clave");
				objform.setMode("m_advertencia");
			}
			else{
				msn = "restablecer"; 
				objform.setMensaje("Los datos ingresados son incorrectos");
			}
			
		}	
		else{
			msn = "restablecer"; 
	    }
		 return mapping.findForward(msn);
	}
	@Override
	public Map<String, Object> cargarContenidoExportar(ActionForm form,
			HttpServletRequest request, String plantilla) throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cargarContenidoImprimir(ActionForm form,
			HttpServletRequest request, Impresora impresora,
			ActionMapping mapping, HttpServletResponse response)
			throws IllegalAccessException, IOException,
			IllegalArgumentException, SecurityException,
			ClassNotFoundException, NoSuchFieldException, ParseException {
		// TODO Auto-generated method stub
		
	}
	

}
