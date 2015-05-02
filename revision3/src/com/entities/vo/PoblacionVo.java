package com.entities.vo;

import java.io.Serializable;

public class PoblacionVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iPoblacionId;
	private String cCodigo;
	private String vDescripcion;
    
    public PoblacionVo() {
    }

	/**
	 * @return the iPoblacionId
	 */
	public int getiPoblacionId() {
		return iPoblacionId;
	}

	/**
	 * @param iPoblacionId the iPoblacionId to set
	 */
	public void setiPoblacionId(int iPoblacionId) {
		this.iPoblacionId = iPoblacionId;
	}

	
	
	/**
	 * @return the cCodigo
	 */
	public String getcCodigo() {
		return cCodigo;
	}

	/**
	 * @param cCodigo the cCodigo to set
	 */
	public void setcCodigo(String cCodigo) {
		this.cCodigo = cCodigo;
	}

	/**
	 * @return the vDescripcion
	 */
	public String getvDescripcion() {
		return vDescripcion;
	}

	/**
	 * @param vDescripcion the vDescripcion to set
	 */
	public void setvDescripcion(String vDescripcion) {
		this.vDescripcion = vDescripcion;
	}

	

}