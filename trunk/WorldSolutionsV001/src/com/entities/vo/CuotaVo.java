package com.entities.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cuota database table.
 * 
 */

public class CuotaVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iCuotaId;
	private String cEstadoCodigo;
	private Date dCuotaFecha;
	private Date dFechaActualiza;
	private Date dFechaInserta;	
	private float fCuotaInteres;
	private float fCuotaMonto;
	private int iCuotaNumero;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
	private String vCuotaDescripcion;

    public CuotaVo() {
    }

	public int getICuotaId() {
		return this.iCuotaId;
	}

	public void setICuotaId(int iCuotaId) {
		this.iCuotaId = iCuotaId;
	}

	public String getCEstadoCodigo() {
		return this.cEstadoCodigo;
	}

	public void setCEstadoCodigo(String cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}

	public Date getDCuotaFecha() {
		return this.dCuotaFecha;
	}

	public void setDCuotaFecha(Date dCuotaFecha) {
		this.dCuotaFecha = dCuotaFecha;
	}

	public Date getDFechaActualiza() {
		return this.dFechaActualiza;
	}

	public void setDFechaActualiza(Date dFechaActualiza) {
		this.dFechaActualiza = dFechaActualiza;
	}

	public Date getDFechaInserta() {
		return this.dFechaInserta;
	}

	public void setDFechaInserta(Date dFechaInserta) {
		this.dFechaInserta = dFechaInserta;
	}

	public float getFCuotaInteres() {
		return this.fCuotaInteres;
	}

	public void setFCuotaInteres(float fCuotaInteres) {
		this.fCuotaInteres = fCuotaInteres;
	}

	public float getFCuotaMonto() {
		return this.fCuotaMonto;
	}

	public void setFCuotaMonto(float fCuotaMonto) {
		this.fCuotaMonto = fCuotaMonto;
	}

	public int getICuotaNumero() {
		return this.iCuotaNumero;
	}

	public void setICuotaNumero(int iCuotaNumero) {
		this.iCuotaNumero = iCuotaNumero;
	}

	public int getIUsuarioActualizaId() {
		return this.iUsuarioActualizaId;
	}

	public void setIUsuarioActualizaId(int iUsuarioActualizaId) {
		this.iUsuarioActualizaId = iUsuarioActualizaId;
	}

	public int getIUsuarioInsertaId() {
		return this.iUsuarioInsertaId;
	}

	public void setIUsuarioInsertaId(int iUsuarioInsertaId) {
		this.iUsuarioInsertaId = iUsuarioInsertaId;
	}

	public String getVCuotaDescripcion() {
		return this.vCuotaDescripcion;
	}

	public void setVCuotaDescripcion(String vCuotaDescripcion) {
		this.vCuotaDescripcion = vCuotaDescripcion;
	}

	/**
	 * @return the iCuotaId
	 */
	public int getiCuotaId() {
		return iCuotaId;
	}

	/**
	 * @param iCuotaId the iCuotaId to set
	 */
	public void setiCuotaId(int iCuotaId) {
		this.iCuotaId = iCuotaId;
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
	 * @return the dCuotaFecha
	 */
	public Date getdCuotaFecha() {
		return dCuotaFecha;
	}

	/**
	 * @param dCuotaFecha the dCuotaFecha to set
	 */
	public void setdCuotaFecha(Date dCuotaFecha) {
		this.dCuotaFecha = dCuotaFecha;
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
	 * @return the fCuotaInteres
	 */
	public float getfCuotaInteres() {
		return fCuotaInteres;
	}

	/**
	 * @param fCuotaInteres the fCuotaInteres to set
	 */
	public void setfCuotaInteres(float fCuotaInteres) {
		this.fCuotaInteres = fCuotaInteres;
	}

	/**
	 * @return the fCuotaMonto
	 */
	public float getfCuotaMonto() {
		return fCuotaMonto;
	}

	/**
	 * @param fCuotaMonto the fCuotaMonto to set
	 */
	public void setfCuotaMonto(float fCuotaMonto) {
		this.fCuotaMonto = fCuotaMonto;
	}

	/**
	 * @return the iCuotaNumero
	 */
	public int getiCuotaNumero() {
		return iCuotaNumero;
	}

	/**
	 * @param iCuotaNumero the iCuotaNumero to set
	 */
	public void setiCuotaNumero(int iCuotaNumero) {
		this.iCuotaNumero = iCuotaNumero;
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
	 * @return the vCuotaDescripcion
	 */
	public String getvCuotaDescripcion() {
		return vCuotaDescripcion;
	}

	/**
	 * @param vCuotaDescripcion the vCuotaDescripcion to set
	 */
	public void setvCuotaDescripcion(String vCuotaDescripcion) {
		this.vCuotaDescripcion = vCuotaDescripcion;
	}
	
}