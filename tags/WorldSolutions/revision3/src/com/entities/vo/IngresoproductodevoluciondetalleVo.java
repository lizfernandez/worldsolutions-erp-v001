package com.entities.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the ingresoproductodevoluciondetalle database table.
 * 
 */

public class IngresoproductodevoluciondetalleVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iIngresoProductoDevolucionDetalleId;
	private String cEstadoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private float fIngresoProductoDevDetallePrecio;
	private float fIngresoProductoDevDetalleTotal;
	private int iIngresoProductoDevDetalleCantidad;
	private IngresoproductodevolucionVo ingresoproductodevolucion;
	private ProductoVo producto ;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
	private float fDescuento;
	
    public IngresoproductodevoluciondetalleVo() {
    }

	/**
	 * @return the iIngresoProductoDevolucionDetalleId
	 */
	public int getiIngresoProductoDevolucionDetalleId() {
		return iIngresoProductoDevolucionDetalleId;
	}

	/**
	 * @param iIngresoProductoDevolucionDetalleId the iIngresoProductoDevolucionDetalleId to set
	 */
	public void setiIngresoProductoDevolucionDetalleId(
			int iIngresoProductoDevolucionDetalleId) {
		this.iIngresoProductoDevolucionDetalleId = iIngresoProductoDevolucionDetalleId;
	}

	/**
	 * @return the cEstadoCodigo
	 */
	public String getcEstadoCodigo() {
		return cEstadoCodigo;
	}

	/**
	 * @param cEstadoCodigo the cEstadoCodigo to set
	 */
	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}

	/**
	 * @return the dFechaActualiza
	 */
	public Date getdFechaActualiza() {
		return dFechaActualiza;
	}

	/**
	 * @param dFechaActualiza the dFechaActualiza to set
	 */
	public void setdFechaActualiza(Date dFechaActualiza) {
		this.dFechaActualiza = dFechaActualiza;
	}

	/**
	 * @return the dFechaInserta
	 */
	public Date getdFechaInserta() {
		return dFechaInserta;
	}

	/**
	 * @param dFechaInserta the dFechaInserta to set
	 */
	public void setdFechaInserta(Date dFechaInserta) {
		this.dFechaInserta = dFechaInserta;
	}

	/**
	 * @return the fIngresoProductoDevDetallePrecio
	 */
	public float getfIngresoProductoDevDetallePrecio() {
		return fIngresoProductoDevDetallePrecio;
	}

	/**
	 * @param fIngresoProductoDevDetallePrecio the fIngresoProductoDevDetallePrecio to set
	 */
	public void setfIngresoProductoDevDetallePrecio(
			float fIngresoProductoDevDetallePrecio) {
		this.fIngresoProductoDevDetallePrecio = fIngresoProductoDevDetallePrecio;
	}

	/**
	 * @return the fIngresoProductoDevDetalleTotal
	 */
	public float getfIngresoProductoDevDetalleTotal() {
		return fIngresoProductoDevDetalleTotal;
	}

	/**
	 * @param fIngresoProductoDevDetalleTotal the fIngresoProductoDevDetalleTotal to set
	 */
	public void setfIngresoProductoDevDetalleTotal(
			float fIngresoProductoDevDetalleTotal) {
		this.fIngresoProductoDevDetalleTotal = fIngresoProductoDevDetalleTotal;
	}

	/**
	 * @return the iIngresoProductoDevDetalleCantidad
	 */
	public int getiIngresoProductoDevDetalleCantidad() {
		return iIngresoProductoDevDetalleCantidad;
	}

	/**
	 * @param iIngresoProductoDevDetalleCantidad the iIngresoProductoDevDetalleCantidad to set
	 */
	public void setiIngresoProductoDevDetalleCantidad(
			int iIngresoProductoDevDetalleCantidad) {
		this.iIngresoProductoDevDetalleCantidad = iIngresoProductoDevDetalleCantidad;
	}

	

	/**
	 * @return the ingresoproductodevolucion
	 */
	public IngresoproductodevolucionVo getIngresoproductodevolucion() {
		return ingresoproductodevolucion;
	}

	/**
	 * @param ingresoproductodevolucion the ingresoproductodevolucion to set
	 */
	public void setIngresoproductodevolucion(
			IngresoproductodevolucionVo ingresoproductodevolucion) {
		this.ingresoproductodevolucion = ingresoproductodevolucion;
	}

	/**
	 * @return the producto
	 */
	public ProductoVo getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(ProductoVo producto) {
		this.producto = producto;
	}

	/**
	 * @return the iUsuarioActualizaId
	 */
	public int getiUsuarioActualizaId() {
		return iUsuarioActualizaId;
	}

	/**
	 * @param iUsuarioActualizaId the iUsuarioActualizaId to set
	 */
	public void setiUsuarioActualizaId(int iUsuarioActualizaId) {
		this.iUsuarioActualizaId = iUsuarioActualizaId;
	}

	/**
	 * @return the iUsuarioInsertaId
	 */
	public int getiUsuarioInsertaId() {
		return iUsuarioInsertaId;
	}

	/**
	 * @param iUsuarioInsertaId the iUsuarioInsertaId to set
	 */
	public void setiUsuarioInsertaId(int iUsuarioInsertaId) {
		this.iUsuarioInsertaId = iUsuarioInsertaId;
	}

	/**
	 * @return the fDescuento
	 */
	public float getfDescuento() {
		return fDescuento;
	}

	/**
	 * @param fDescuento the fDescuento to set
	 */
	public void setfDescuento(float fDescuento) {
		this.fDescuento = fDescuento;
	}

	

}