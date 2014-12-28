package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the producciondetalle database table.
 * 
 */
@Entity
@Table(name="producciondetalle")
public class Producciondetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int iProduccionDetalleId;

	@Column(nullable=false, length=2)
	private String cEstadoCodigo;

	@Column(nullable=false)
	private float fTotal;

	@Column(nullable=false)
	private int iCantidad;

	@Column(nullable=false)
	private int iProduccionId;

	@Column(nullable=false)
	private int iProductoId;

    public Producciondetalle() {
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