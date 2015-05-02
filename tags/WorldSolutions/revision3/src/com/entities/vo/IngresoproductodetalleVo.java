package com.entities.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the ingresoproductodetalle database table.
 * 
 */
public class IngresoproductodetalleVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iIngresoProductoDetalleId;
	private String cEstadoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private float fIngresoProductoDetallePrecio;
	private float fIngresoProductoDetalleTotal;
	private int iIngresoProductoDetalleCantidad;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
	private IngresoproductoVo ingresoproducto;
	private ProductoVo producto;
	private float fDescuento;
   
    

    public IngresoproductodetalleVo() {
    }

	/**
	 * @return the iIngresoProductoDetalleId
	 */
	public int getiIngresoProductoDetalleId() {
		return iIngresoProductoDetalleId;
	}

	/**
	 * @param iIngresoProductoDetalleId the iIngresoProductoDetalleId to set
	 */
	public void setiIngresoProductoDetalleId(int iIngresoProductoDetalleId) {
		this.iIngresoProductoDetalleId = iIngresoProductoDetalleId;
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
	 * @return the fIngresoProductoDetallePrecio
	 */
	public float getfIngresoProductoDetallePrecio() {
		return fIngresoProductoDetallePrecio;
	}

	/**
	 * @param fIngresoProductoDetallePrecio the fIngresoProductoDetallePrecio to set
	 */
	public void setfIngresoProductoDetallePrecio(float fIngresoProductoDetallePrecio) {
		this.fIngresoProductoDetallePrecio = fIngresoProductoDetallePrecio;
	}

	/**
	 * @return the fIngresoProductoDetalleTotal
	 */
	public float getfIngresoProductoDetalleTotal() {
		return fIngresoProductoDetalleTotal;
	}

	/**
	 * @param fIngresoProductoDetalleTotal the fIngresoProductoDetalleTotal to set
	 */
	public void setfIngresoProductoDetalleTotal(float fIngresoProductoDetalleTotal) {
		this.fIngresoProductoDetalleTotal = fIngresoProductoDetalleTotal;
	}

	/**
	 * @return the iIngresoProductoDetalleCantidad
	 */
	public int getiIngresoProductoDetalleCantidad() {
		return iIngresoProductoDetalleCantidad;
	}

	/**
	 * @param iIngresoProductoDetalleCantidad the iIngresoProductoDetalleCantidad to set
	 */
	public void setiIngresoProductoDetalleCantidad(
			int iIngresoProductoDetalleCantidad) {
		this.iIngresoProductoDetalleCantidad = iIngresoProductoDetalleCantidad;
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
	 * @return the ingresoproducto
	 */
	public IngresoproductoVo getIngresoproducto() {
		return ingresoproducto;
	}

	/**
	 * @param ingresoproducto the ingresoproducto to set
	 */
	public void setIngresoproducto(IngresoproductoVo ingresoproducto) {
		this.ingresoproducto = ingresoproducto;
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