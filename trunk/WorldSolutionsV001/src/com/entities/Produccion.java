package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the produccion database table.
 * 
 */
@Entity
@Table(name="produccion")
public class Produccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int iProduccionId;

	@Column(nullable=false, length=2)
	private String cEstadoCodigo;

	@Column(nullable=false)
	private float fManoObra;

	@Column(nullable=false)
	private float fOtros;

	@Column(nullable=false)
	private float fTotal;

	@Column(nullable=false)
	private float fTransporte;

	@Column(nullable=false)
	private int iCantidad;

    public Produccion() {
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