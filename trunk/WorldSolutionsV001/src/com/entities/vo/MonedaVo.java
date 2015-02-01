package com.entities.vo;

import java.io.Serializable;

public class MonedaVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iMonedaId;
	private String cEstadoCodigo;
	private String cModenaCodigo;
	private String vMonedaDescripcion;

    public MonedaVo() {
    }

	/**
	 * @return the iMonedaId
	 */
	public int getiMonedaId() {
		return iMonedaId;
	}

	/**
	 * @param iMonedaId the iMonedaId to set
	 */
	public void setiMonedaId(int iMonedaId) {
		this.iMonedaId = iMonedaId;
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
	 * @return the cModenaCodigo
	 */
	public String getcModenaCodigo() {
		return cModenaCodigo;
	}

	/**
	 * @param cModenaCodigo the cModenaCodigo to set
	 */
	public void setcModenaCodigo(String cModenaCodigo) {
		this.cModenaCodigo = cModenaCodigo;
	}

	/**
	 * @return the vMonedaDescripcion
	 */
	public String getvMonedaDescripcion() {
		return vMonedaDescripcion;
	}

	/**
	 * @param vMonedaDescripcion the vMonedaDescripcion to set
	 */
	public void setvMonedaDescripcion(String vMonedaDescripcion) {
		this.vMonedaDescripcion = vMonedaDescripcion;
	}

	
}