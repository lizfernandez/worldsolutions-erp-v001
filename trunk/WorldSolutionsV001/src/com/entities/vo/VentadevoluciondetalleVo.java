package com.entities.vo;

import java.io.Serializable;

import java.util.Date;

public class VentadevoluciondetalleVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iVentaDevolucionDetalleId;
	private String cEstadoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private int iVentaDevDetalleCantidad;
	private float fVentaDevDetallePrecio;
	private float fVentaDevDetalleTotal;
	private VentadevolucionVo ventadevolucion;
	private ProductoVo producto;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
    private float fDescuento;
    
    public VentadevoluciondetalleVo() {
    }

	/**
	 * @return the iVentaDevolucionDetalleId
	 */
	public int getiVentaDevolucionDetalleId() {
		return iVentaDevolucionDetalleId;
	}

	/**
	 * @param iVentaDevolucionDetalleId the iVentaDevolucionDetalleId to set
	 */
	public void setiVentaDevolucionDetalleId(int iVentaDevolucionDetalleId) {
		this.iVentaDevolucionDetalleId = iVentaDevolucionDetalleId;
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
	 * @return the iVentaDevDetalleCantidad
	 */
	public int getiVentaDevDetalleCantidad() {
		return iVentaDevDetalleCantidad;
	}

	/**
	 * @param iVentaDevDetalleCantidad the iVentaDevDetalleCantidad to set
	 */
	public void setiVentaDevDetalleCantidad(int iVentaDevDetalleCantidad) {
		this.iVentaDevDetalleCantidad = iVentaDevDetalleCantidad;
	}

	/**
	 * @return the fVentaDevDetallePrecio
	 */
	public float getfVentaDevDetallePrecio() {
		return fVentaDevDetallePrecio;
	}

	/**
	 * @param fVentaDevDetallePrecio the fVentaDevDetallePrecio to set
	 */
	public void setfVentaDevDetallePrecio(float fVentaDevDetallePrecio) {
		this.fVentaDevDetallePrecio = fVentaDevDetallePrecio;
	}

	/**
	 * @return the fVentaDevDetalleTotal
	 */
	public float getfVentaDevDetalleTotal() {
		return fVentaDevDetalleTotal;
	}

	/**
	 * @param fVentaDevDetalleTotal the fVentaDevDetalleTotal to set
	 */
	public void setfVentaDevDetalleTotal(float fVentaDevDetalleTotal) {
		this.fVentaDevDetalleTotal = fVentaDevDetalleTotal;
	}

	/**
	 * @return the ventadevolucion
	 */
	public VentadevolucionVo getVentadevolucion() {
		return ventadevolucion;
	}

	/**
	 * @param ventadevolucion the ventadevolucion to set
	 */
	public void setVentadevolucion(VentadevolucionVo ventadevolucion) {
		this.ventadevolucion = ventadevolucion;
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