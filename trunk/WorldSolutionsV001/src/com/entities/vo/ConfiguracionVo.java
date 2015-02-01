package com.entities.vo;

import java.io.Serializable;

import java.util.Date;


/**
 * The persistent class for the configuracion database table.
 * 
 */

public class ConfiguracionVo implements Serializable {
	private static final long serialVersionUID = 1L;
    private int iConfiguracionId;
	private String cEstadoCodigo;    
	private Date dFechaInserta;
	private String vConcepto;
	private String vValor;

    public ConfiguracionVo() {
    }
    
    

	public ConfiguracionVo(int iConfiguracionId, String vConcepto) {
		super();
		this.iConfiguracionId = iConfiguracionId;
		this.vConcepto = vConcepto;
	}



	/**
	 * @return the iConfiguracionId
	 */
	public int getiConfiguracionId() {
		return iConfiguracionId;
	}

	/**
	 * @param iConfiguracionId the iConfiguracionId to set
	 */
	public void setiConfiguracionId(int iConfiguracionId) {
		this.iConfiguracionId = iConfiguracionId;
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
	 * @return the vConcepto
	 */
	public String getvConcepto() {
		return vConcepto;
	}

	/**
	 * @param vConcepto the vConcepto to set
	 */
	public void setvConcepto(String vConcepto) {
		this.vConcepto = vConcepto;
	}

	/**
	 * @return the vValor
	 */
	public String getvValor() {
		return vValor;
	}

	/**
	 * @param vValor the vValor to set
	 */
	public void setvValor(String vValor) {
		this.vValor = vValor;
	}

	
}