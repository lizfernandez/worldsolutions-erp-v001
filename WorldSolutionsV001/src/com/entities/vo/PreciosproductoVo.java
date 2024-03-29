package com.entities.vo;

import java.io.Serializable;

import java.util.Date;

import com.entities.Preciosproducto;

public class PreciosproductoVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iPreciosProductoId;
	private String cEstadoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private float fDescuento;
	private float fGanancia;
	private float fGastosAdm;
	private float fPrecioCompra;
	private float fPrecioVenta;
	private int iCantidadStock;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;

	public PreciosproductoVo() {
	}

	public PreciosproductoVo(Preciosproducto preciosproducto) {

		this.iPreciosProductoId = preciosproducto.getiPreciosProductoId();
		this.cEstadoCodigo = preciosproducto.getcEstadoCodigo();
		this.dFechaActualiza = preciosproducto.getdFechaActualiza();
		this.dFechaInserta = preciosproducto.getdFechaInserta();
		this.fDescuento = preciosproducto.getfDescuento();
		this.fGanancia = preciosproducto.getfGanancia();
		this.fPrecioCompra = preciosproducto.getfPrecioCompra();
		this.fPrecioVenta = preciosproducto.getfPrecioVenta();
		this.iCantidadStock = preciosproducto.getiCantidadStock();
		this.iUsuarioActualizaId = preciosproducto.getiUsuarioActualizaId();
		this.iUsuarioInsertaId = preciosproducto.getiUsuarioInsertaId();
	}

	/**
	 * @return the iPreciosProductoId
	 */
	public int getiPreciosProductoId() {
		return iPreciosProductoId;
	}

	/**
	 * @param iPreciosProductoId the iPreciosProductoId to set
	 */
	public void setiPreciosProductoId(int iPreciosProductoId) {
		this.iPreciosProductoId = iPreciosProductoId;
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

	/**
	 * @return the fGanancia
	 */
	public float getfGanancia() {
		return fGanancia;
	}

	/**
	 * @param fGanancia the fGanancia to set
	 */
	public void setfGanancia(float fGanancia) {
		this.fGanancia = fGanancia;
	}

	/**
	 * @return the fPrecioCompra
	 */
	public float getfPrecioCompra() {
		return fPrecioCompra;
	}

	/**
	 * @param fPrecioCompra the fPrecioCompra to set
	 */
	public void setfPrecioCompra(float fPrecioCompra) {
		this.fPrecioCompra = fPrecioCompra;
	}

	/**
	 * @return the fPrecioVenta
	 */
	public float getfPrecioVenta() {
		return fPrecioVenta;
	}

	/**
	 * @param fPrecioVenta the fPrecioVenta to set
	 */
	public void setfPrecioVenta(float fPrecioVenta) {
		this.fPrecioVenta = fPrecioVenta;
	}

	/**
	 * @return the iCantidadStock
	 */
	public int getiCantidadStock() {
		return iCantidadStock;
	}

	/**
	 * @param iCantidadStock the iCantidadStock to set
	 */
	public void setiCantidadStock(int iCantidadStock) {
		this.iCantidadStock = iCantidadStock;
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
	 * @return the fGastosAdm
	 */
	public float getfGastosAdm() {
		return fGastosAdm;
	}

	/**
	 * @param fGastosAdm the fGastosAdm to set
	 */
	public void setfGastosAdm(float fGastosAdm) {
		this.fGastosAdm = fGastosAdm;
	}

}