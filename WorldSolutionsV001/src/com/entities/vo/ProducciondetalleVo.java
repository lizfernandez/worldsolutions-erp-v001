package com.entities.vo;

import java.io.Serializable;

public class ProducciondetalleVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iProduccionDetalleId;
	private String cEstadoCodigo;
	private float fTotal;
	private int iCantidad;
	private int iProduccionId;
	private int iProductoId;

	public ProducciondetalleVo() {
    }

	public int getIProduccionDetalleId() {
		return this.iProduccionDetalleId;
	}

	public void setIProduccionDetalleId(int iProduccionDetalleId) {
		this.iProduccionDetalleId = iProduccionDetalleId;
	}

	public String getCEstadoCodigo() {
		return this.cEstadoCodigo;
	}

	public void setCEstadoCodigo(String cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}

	public float getFTotal() {
		return this.fTotal;
	}

	public void setFTotal(float fTotal) {
		this.fTotal = fTotal;
	}

	public int getICantidad() {
		return this.iCantidad;
	}

	public void setICantidad(int iCantidad) {
		this.iCantidad = iCantidad;
	}

	public int getIProduccionId() {
		return this.iProduccionId;
	}

	public void setIProduccionId(int iProduccionId) {
		this.iProduccionId = iProduccionId;
	}

	public int getIProductoId() {
		return this.iProductoId;
	}

	public void setIProductoId(int iProductoId) {
		this.iProductoId = iProductoId;
	}

}