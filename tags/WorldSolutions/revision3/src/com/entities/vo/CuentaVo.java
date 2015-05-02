package com.entities.vo;

import java.io.Serializable;


/**
 * The persistent class for the cuentas database table.
 * 
 */

public class CuentaVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iCuentasId;
	private ElementocuentaVo elementoCuenta ;
	private String vCodigo;
	private String vDescripcion;

    public CuentaVo() {
    }

	/**
	 * @return the iCuentasId
	 */
	public int getiCuentasId() {
		return iCuentasId;
	}

	/**
	 * @param iCuentasId the iCuentasId to set
	 */
	public void setiCuentasId(int iCuentasId) {
		this.iCuentasId = iCuentasId;
	}

	
	/**
	 * @return the elementoCuenta
	 */
	public ElementocuentaVo getElementoCuenta() {
		return elementoCuenta;
	}

	/**
	 * @param elementoCuenta the elementoCuenta to set
	 */
	public void setElementoCuenta(ElementocuentaVo elementoCuenta) {
		this.elementoCuenta = elementoCuenta;
	}

	/**
	 * @return the vCodigo
	 */
	public String getvCodigo() {
		return vCodigo;
	}

	/**
	 * @param vCodigo the vCodigo to set
	 */
	public void setvCodigo(String vCodigo) {
		this.vCodigo = vCodigo;
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