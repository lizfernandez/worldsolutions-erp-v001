package com.entities.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the elementocuentas database table.
 * 
 */

public class ElementocuentaVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iElementoCuentasId;
	private String vDescripcion;
	private String vElemento;

    public ElementocuentaVo() {
    }

	/**
	 * @return the iElementoCuentasId
	 */
	public int getiElementoCuentasId() {
		return iElementoCuentasId;
	}

	/**
	 * @param iElementoCuentasId the iElementoCuentasId to set
	 */
	public void setiElementoCuentasId(int iElementoCuentasId) {
		this.iElementoCuentasId = iElementoCuentasId;
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

	/**
	 * @return the vElemento
	 */
	public String getvElemento() {
		return vElemento;
	}

	/**
	 * @param vElemento the vElemento to set
	 */
	public void setvElemento(String vElemento) {
		this.vElemento = vElemento;
	}

	
}