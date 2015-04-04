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
import com.entities.Estadocuentacliente;
import com.entities.Estadocuentaproveedor;
import com.entities.Ingresoproducto;
import com.entities.Venta;
import com.entities.vo.EstadoCuentaVo;
import com.util.Constantes;
import com.util.Fechas;


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

		
		int i = listaEstadoCuenta.size() - 1;
		if(i>0){
			listaEstadoCuenta.get(i).setMontosTotales(montosTotales);
			listaEstadoCuenta.get(i).setPagosTotales(pagosTotales);
			listaEstadoCuenta.get(i).setSaldosTotales(saldosTotales);
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
		if(iUltimoRegistro>0){
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
	
}
