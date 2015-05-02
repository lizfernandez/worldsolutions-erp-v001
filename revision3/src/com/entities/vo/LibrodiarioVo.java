package com.entities.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the librodiario database table.
 * 
 */
public class LibrodiarioVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iLibroDiarioId;
	private String cEstadoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private float fMonto;
	private KardexVo kardex;
	private CuentaVo cuenta;
	private int iIngresoProductoId;
	private VentaVo venta;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
	private String vConceptoGeneral;
	private String vTipoConcepto;
	private String vNumeroAsiento;
	private int iPeriodoId;
	private String cCajaBanco;

	public LibrodiarioVo() {
	}

	/**
	 * @return the iLibroDiarioId
	 */
	public int getiLibroDiarioId() {
		return iLibroDiarioId;
	}

	/**
	 * @param iLibroDiarioId the iLibroDiarioId to set
	 */
	public void setiLibroDiarioId(int iLibroDiarioId) {
		this.iLibroDiarioId = iLibroDiarioId;
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
	 * @return the fMonto
	 */
	public float getfMonto() {
		return fMonto;
	}

	/**
	 * @param fMonto the fMonto to set
	 */
	public void setfMonto(float fMonto) {
		this.fMonto = fMonto;
	}

	
	

	/**
	 * @return the cuenta
	 */
	public CuentaVo getCuenta() {
		return cuenta;
	}

	/**
	 * @param cuenta the cuenta to set
	 */
	public void setCuenta(CuentaVo cuenta) {
		this.cuenta = cuenta;
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
	 * @return the vConceptoGeneral
	 */
	public String getvConceptoGeneral() {
		return vConceptoGeneral;
	}

	/**
	 * @param vConceptoGeneral the vConceptoGeneral to set
	 */
	public void setvConceptoGeneral(String vConceptoGeneral) {
		this.vConceptoGeneral = vConceptoGeneral;
	}

	/**
	 * @return the vTipoConcepto
	 */
	public String getvTipoConcepto() {
		return vTipoConcepto;
	}

	/**
	 * @param vTipoConcepto the vTipoConcepto to set
	 */
	public void setvTipoConcepto(String vTipoConcepto) {
		this.vTipoConcepto = vTipoConcepto;
	}

	/**
	 * @return the kardex
	 */
	public KardexVo getKardex() {
		return kardex;
	}

	/**
	 * @param kardex the kardex to set
	 */
	public void setKardex(KardexVo kardex) {
		this.kardex = kardex;
	}

	
	/**
	 * @return the iIngresoProductoId
	 */
	public int getiIngresoProductoId() {
		return iIngresoProductoId;
	}

	/**
	 * @param iIngresoProductoId the iIngresoProductoId to set
	 */
	public void setiIngresoProductoId(int iIngresoProductoId) {
		this.iIngresoProductoId = iIngresoProductoId;
	}

	

	/**
	 * @return the venta
	 */
	public VentaVo getVenta() {
		return venta;
	}

	/**
	 * @param venta the venta to set
	 */
	public void setVenta(VentaVo venta) {
		this.venta = venta;
	}

	/**
	 * @return the vNumeroAsiento
	 */
	public String getvNumeroAsiento() {
		return vNumeroAsiento;
	}

	/**
	 * @param vNumeroAsiento the vNumeroAsiento to set
	 */
	public void setvNumeroAsiento(String vNumeroAsiento) {
		this.vNumeroAsiento = vNumeroAsiento;
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
	 * @return the cCajaBanco
	 */
	public String getcCajaBanco() {
		return cCajaBanco;
	}

	/**
	 * @param cCajaBanco the cCajaBanco to set
	 */
	public void setcCajaBanco(String cCajaBanco) {
		this.cCajaBanco = cCajaBanco;
	}

	
	
	

	
}