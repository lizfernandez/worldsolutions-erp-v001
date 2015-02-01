package com.entities.vo;

import java.io.Serializable;


/**
 * The persistent class for the mes database table.
 * 
 */

public class MeVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iMesId;

    public MeVo() {
    }

	public int getIMesId() {
		return this.iMesId;
	}

	public void setIMesId(int iMesId) {
		this.iMesId = iMesId;
	}

	public String getVMesDescripcion() {
		return this.vMesDescripcion;
	}

	public void setVMesDescripcion(String vMesDescripcion) {
		this.vMesDescripcion = vMesDescripcion;
	}

}