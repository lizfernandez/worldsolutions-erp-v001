package com.entities.vo;

import java.io.Serializable;

public class ViaVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iViaId;
	private String vAbreviatura;
	private String vDescripcion;

    public ViaVo() {
    }

	public int getIViaId() {
		return this.iViaId;
	}

	public void setIViaId(int iViaId) {
		this.iViaId = iViaId;
	}

	public String getVAbreviatura() {
		return this.vAbreviatura;
	}

	public void setVAbreviatura(String vAbreviatura) {
		this.vAbreviatura = vAbreviatura;
	}

	public String getVDescripcion() {
		return this.vDescripcion;
	}

	public void setVDescripcion(String vDescripcion) {
		this.vDescripcion = vDescripcion;
	}

}