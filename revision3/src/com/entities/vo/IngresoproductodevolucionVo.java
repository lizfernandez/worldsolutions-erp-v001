package com.entities.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ingresoproductodevolucion database table.
 * 
 */
public class IngresoproductodevolucionVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iIngresoProductoDevolucionId;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private Date dIngresoProductoDevFecha;
	private float fIngresoProductoDev;
	private float fIngresoProductoDevIGV;
	private float fIngresoProductoDevSubTotal;
	private IngresoproductoVo ingresoProducto ;
	private List<IngresoproductodevoluciondetalleVo> ingresoproductodevoluciondetalles;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
	private String vEstadoCodigo;
	private int iPeriodoId;
	private float fDescuento;

	public IngresoproductodevolucionVo() {
    }

	/**
	 * @return the iIngresoProductoDevolucionId
	 */
	public int getiIngresoProductoDevolucionId() {
		return iIngresoProductoDevolucionId;
	}

	/**
	 * @param iIngresoProductoDevolucionId the iIngresoProductoDevolucionId to set
	 */
	public void setiIngresoProductoDevolucionId(int iIngresoProductoDevolucionId) {
		this.iIngresoProductoDevolucionId = iIngresoProductoDevolucionId;
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
	 * @return the dIngresoProductoDevFecha
	 */
	public Date getdIngresoProductoDevFecha() {
		return dIngresoProductoDevFecha;
	}

	/**
	 * @param dIngresoProductoDevFecha the dIngresoProductoDevFecha to set
	 */
	public void setdIngresoProductoDevFecha(Date dIngresoProductoDevFecha) {
		this.dIngresoProductoDevFecha = dIngresoProductoDevFecha;
	}

	/**
	 * @return the fIngresoProductoDev
	 */
	public float getfIngresoProductoDev() {
		return fIngresoProductoDev;
	}

	/**
	 * @param fIngresoProductoDev the fIngresoProductoDev to set
	 */
	public void setfIngresoProductoDev(float fIngresoProductoDev) {
		this.fIngresoProductoDev = fIngresoProductoDev;
	}

	/**
	 * @return the fIngresoProductoDevIGV
	 */
	public float getfIngresoProductoDevIGV() {
		return fIngresoProductoDevIGV;
	}

	/**
	 * @param fIngresoProductoDevIGV the fIngresoProductoDevIGV to set
	 */
	public void setfIngresoProductoDevIGV(float fIngresoProductoDevIGV) {
		this.fIngresoProductoDevIGV = fIngresoProductoDevIGV;
	}

	/**
	 * @return the fIngresoProductoDevSubTotal
	 */
	public float getfIngresoProductoDevSubTotal() {
		return fIngresoProductoDevSubTotal;
	}

	/**
	 * @param fIngresoProductoDevSubTotal the fIngresoProductoDevSubTotal to set
	 */
	public void setfIngresoProductoDevSubTotal(float fIngresoProductoDevSubTotal) {
		this.fIngresoProductoDevSubTotal = fIngresoProductoDevSubTotal;
	}

	/**
	 * @return the ingresoProducto
	 */
	public IngresoproductoVo getIngresoProducto() {
		return ingresoProducto;
	}

	/**
	 * @param ingresoProducto the ingresoProducto to set
	 */
	public void setIngresoProducto(IngresoproductoVo ingresoProducto) {
		this.ingresoProducto = ingresoProducto;
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
	 * @return the vEstadoCodigo
	 */
	public String getvEstadoCodigo() {
		return vEstadoCodigo;
	}

	/**
	 * @param vEstadoCodigo the vEstadoCodigo to set
	 */
	public void setvEstadoCodigo(String vEstadoCodigo) {
		this.vEstadoCodigo = vEstadoCodigo;
	}

	/**
	 * @return the ingresoproductodevoluciondetalles
	 */
	public List<IngresoproductodevoluciondetalleVo> getIngresoproductodevoluciondetalles() {
		return ingresoproductodevoluciondetalles;
	}

	/**
	 * @param ingresoproductodevoluciondetalles the ingresoproductodevoluciondetalles to set
	 */
	public void setIngresoproductodevoluciondetalles(
			List<IngresoproductodevoluciondetalleVo> ingresoproductodevoluciondetalles) {
		this.ingresoproductodevoluciondetalles = ingresoproductodevoluciondetalles;
	}

	/**
	 * @return the iPeriodoId
	 */
	public int getiPeriodoId() {
		return iPeriodoId;
	}

	/**
	 * @param iPeriodoId the iPeriodoId to set
	 */
	public void setiPeriodoId(int iPeriodoId) {
		this.iPeriodoId = iPeriodoId;
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