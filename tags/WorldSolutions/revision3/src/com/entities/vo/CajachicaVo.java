package com.entities.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.entities.Cuenta;

public class CajachicaVo implements Serializable {
	
	private int iCajaChicaId;
	private String cEstadoCodigo;
    private Date dFechaActualiza;
	private Date dFechaInserta;
	private float fMonto;
	private String vTipoConcepto;	
	private String vConceptoGeneral;	
	private CuentaVo cuentaVo;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
    public CajachicaVo() {
    }
	/**
	 * @return the iCajaChicaId
	 */
	public int getiCajaChicaId() {
		return iCajaChicaId;
	}
	/**
	 * @param iCajaChicaId the iCajaChicaId to set
	 */
	public void setiCajaChicaId(int iCajaChicaId) {
		this.iCajaChicaId = iCajaChicaId;
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
	 * @return the cuentaVo
	 */
	public CuentaVo getCuentaVo() {
		return cuentaVo;
	}
	/**
	 * @param cuentaVo the cuentaVo to set
	 */
	public void setCuentaVo(CuentaVo cuentaVo) {
		this.cuentaVo = cuentaVo;
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
    
    
}
