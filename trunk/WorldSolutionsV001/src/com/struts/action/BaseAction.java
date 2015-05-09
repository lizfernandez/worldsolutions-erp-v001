package com.struts.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import com.dao.IngresoProductoDao;
import com.dao.VentaDao;
import com.entities.Configuracion;
import com.entities.Estadocuentacliente;
import com.entities.Estadocuentaproveedor;
import com.entities.Ingresoproducto;
import com.entities.Usuario;
import com.entities.Venta;
import com.entities.vo.EstadoCuentaVo;
import com.util.Constantes;
import com.util.Fechas;
import com.util.Impresora;


public abstract class BaseAction  extends DispatchAction {

	protected List<EstadoCuentaVo> listarEstadoCuentaCliente(Venta venta, VentaDao ventaDao, int paginaInicio, int paginaFin) {

		List<EstadoCuentaVo> listaEstadoCuenta = new ArrayList<EstadoCuentaVo>();
		/** Accedemos al Dao **/
		List<Venta> listaVenta = ventaDao.listaEstadoCuentaPorCliente(paginaInicio, paginaFin, venta, 0);
		float montosTotales = 0;
		float pagosTotales = 0;
		float saldosTotales = 0;
		
		for (Venta obj : listaVenta) {
			float pagoTotal = 0;
			float saldoTotal = 0;
			EstadoCuentaVo estadoCuenta = new EstadoCuentaVo();

			estadoCuenta.setVenta(obj);
			if (obj.getEstadocuentaclientes().size() > 0) {

				for (Estadocuentacliente obje : obj.getEstadocuentaclientes()) {
					if (obje.getcEstadoCodigo().equals(Constantes.estadoActivo)) {
						pagoTotal += obje.getfMontoPago();
						pagosTotales += obje.getfMontoPago();
						// e.setEstadocuenta(obj.getEstadocuentaclientes());
					}
				} // for

			} // if

			saldoTotal = obj.getfVentaTotal() - pagoTotal;
			montosTotales += obj.getfVentaTotal();
			saldosTotales = (montosTotales - pagosTotales);
			estadoCuenta.setPagoTotal(pagoTotal);
			estadoCuenta.setSaldoTotal(saldoTotal);

			if (saldoTotal > 0) {
				listaEstadoCuenta.add(estadoCuenta);
			}

		}

		
		int indice = listaEstadoCuenta.size() - 1;
		if(indice >= 0){
			listaEstadoCuenta.get(indice).setMontosTotales(montosTotales);
			listaEstadoCuenta.get(indice).setPagosTotales(pagosTotales);
			listaEstadoCuenta.get(indice).setSaldosTotales(saldosTotales);
		}
		

		return listaEstadoCuenta;

	}
	
	protected List<EstadoCuentaVo> listaEstadoCuentaPorProveedor(Ingresoproducto ingresoProducto, IngresoProductoDao ingresoproductoDao, int paginaInicio, int paginaFin) {

		/** Seteamos los valores en las listas **/
		List<EstadoCuentaVo> listaEstadoCuenta = new ArrayList<EstadoCuentaVo>();

		/** Accedemos al Dao **/
		List<Ingresoproducto> listaIngresoproducto = ingresoproductoDao.listaEstadoCuentaPorProveedor(paginaInicio, paginaFin, ingresoProducto, 0);
		float montosTotales = 0;
		float pagosTotales = 0;
		float saldosTotales = 0;

		for (Ingresoproducto obj : listaIngresoproducto) {
			float pagoTotal = 0;
			float saldoTotal = 0;
			EstadoCuentaVo e = new EstadoCuentaVo();

			e.setIngresoProducto(obj);
			if (obj.getEstadocuentaproveedors().size() > 0) {

				for (Estadocuentaproveedor obje : obj.getEstadocuentaproveedors()) {
					if (obje.getcEstadoCodigo().equals(Constantes.estadoActivo)) {
						pagoTotal += obje.getfMontoPago();
						pagosTotales += obje.getfMontoPago();

						// listaEstaProve.add(pagoEsta);
					}
				} // for
				e.setEstadocuenta(obj.getEstadocuentaproveedors());
			} // if

			saldoTotal = obj.getfIngresoProductoTotal() - pagoTotal;
			montosTotales += obj.getfIngresoProductoTotal();
			saldosTotales = (montosTotales - pagosTotales);
			e.setPagoTotal(pagoTotal);
			e.setSaldoTotal(saldoTotal);
			
			if (saldoTotal > 0) {
				listaEstadoCuenta.add(e);
			}
		}
		
		int iUltimoRegistro = listaEstadoCuenta.size() - 1;
		if(iUltimoRegistro >= 0){
			listaEstadoCuenta.get(iUltimoRegistro).setMontosTotales(montosTotales);
			listaEstadoCuenta.get(iUltimoRegistro).setPagosTotales(pagosTotales);
			listaEstadoCuenta.get(iUltimoRegistro).setSaldosTotales(saldosTotales);
			
		}
		
		return listaEstadoCuenta;

	}
	
	@SuppressWarnings("deprecation")
	public ActionForward exportarExcel(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws ParsePropertyException, InvalidFormatException, IOException, ParseException {

		String plantilla = request.getParameter("plantilla");
		System.out.println("Plantilla solicitada [ " + plantilla + " ]");
		
		String filePath = request.getRealPath("/").toString();
		String archivoPlantilla = filePath + File.separator + "plantillas" + File.separator + "reportes" + File.separator + "reporte-" + plantilla + ".xls";
			
		Map<String, Object> beans = cargarContenidoExportar(form, request, plantilla);
		
		response.setHeader("content-disposition", "attachment;filename=reporte_" + plantilla + "_" + Fechas.fechaConFormato("yyyyMMddHHmm") + ".xls");
		response.setContentType("application/octet-stream");
		ServletOutputStream outputStream = response.getOutputStream();
		
		InputStream fis = new BufferedInputStream(new FileInputStream(archivoPlantilla));
		XLSTransformer transformer = new XLSTransformer();
		try {
			HSSFWorkbook workbook = (HSSFWorkbook) transformer.transformXLS(fis, beans);
			workbook.write(outputStream);
			fis.close();
			
		} catch (ParsePropertyException e) {
			throw e;
			
		} catch (IOException e) {
			throw e;
			
		} finally {
			try {
				outputStream.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				outputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	public abstract Map<String, Object> cargarContenidoExportar(ActionForm form, HttpServletRequest request, String plantilla) throws ParseException;
	
	public abstract void cargarContenidoImprimir (ActionForm form, HttpServletRequest request, Impresora impresora, ActionMapping mapping, HttpServletResponse response) throws IllegalAccessException, IOException, IllegalArgumentException, SecurityException, ClassNotFoundException, NoSuchFieldException, ParseException;

	public ActionForward imprimir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, IOException, IllegalArgumentException, SecurityException, ClassNotFoundException, NoSuchFieldException, ParseException {

		Impresora impresora;
        HttpSession sesion = request.getSession();
        boolean omitirPieBoleta = "true".equals(request.getParameter("omitirPieBoleta"));
		try {
			impresora = new Impresora();

  			Usuario usu = (Usuario) sesion.getAttribute("Usuario");
            impresora.agregarLineaCentrada(usu.getSucursal().getEmpresa().getvEmpresaNombre());
    		impresora.agregarLineaCentrada("RUC: "+usu.getSucursal().getEmpresa().getvEmpresaRuc());
    		impresora.agregarLineaCentrada(usu.getSucursal().getEmpresa().getvEmpresaDireccion());
    		impresora.agregarLineaCentrada(usu.getSucursal().getvSucursalNombre());
    		impresora.agregarLineaCentrada(usu.getSucursal().getvSucursalDireccion());
    		
    		
    		cargarContenidoImprimir(form,  request, impresora, mapping, response);
	        
    		if (!omitirPieBoleta) {
	    		impresora.agregarSeparacion();
	    		impresora.agregarSaltoLinea(1);
	    		impresora.agregarLineaCentrada("NO SE ACEPTAN CAMBIOS NI DEVOLUCIONES");
	    		impresora.agregarLineaCentrada("GRACIAS POR SU COMPRA");
	    		impresora.agregarLineaCentrada("v1.0.0 - USUARIO: " + usu.getvUsuarioLogin() + " - CAJA");
    		}
    		
    		impresora.agregarSaltoLinea(10);
    		
    		impresora.cortarImpresion();
    		//System.out.println(impresora.toString());
    		impresora.imprimirTicket();
			
		} finally {
			impresora = null;
			sesion = null;
		}
		
		return null;
	}
}
