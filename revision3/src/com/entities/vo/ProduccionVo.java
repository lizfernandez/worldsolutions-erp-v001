package com.entities.vo;

import java.io.Serializable;

public class ProduccionVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iProduccionId;
	private String cEstadoCodigo;
	private float fManoObra;
	private float fOtros;
	private float fTotal;
	private float fTransporte;
	private int iCantidad;

    public ProduccionVo() {
    }

	public int getIProduccionId() {
		return this.iProduccionId;
	}

	public void setIProduccionId(int iProduccionId) {
		this.iProduccionId = iProduccionId;
	}

	public String getCEstadoCodigo() {
		return this.cEstadoCodigo;
	}

	public void setCEstadoCodigo(String cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}

	public float getFManoObra() {
		return this.fManoObra;
	}

	public void setFManoObra(float fManoObra) {
		this.fManoObra = fManoObra;
	}

	public float getFOtros() {
		return this.fOtros;
	}

	public void setFOtros(float fOtros) {
		this.fOtros = fOtros;
	}

	public float getFTotal() {
		return this.fTotal;
	}

	public void setFTotal(float fTotal) {
		this.fTotal = fTotal;
	}

	public float getFTransporte() {
		return this.fTransporte;
	}

	public void setFTransporte(float fTransporte) {
		this.fTransporte = fTransporte;
	}

	public int getICantidad() {
		return this.iCantidad;
	}

	public void setICantidad(int iCantidad) {
		this.iCantidad = iCantidad;
	}

}