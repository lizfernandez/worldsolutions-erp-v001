package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the compradetalle database table.
 * 
 */
@Entity
public class Compradetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iCompraDetalleId;

	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private float fDescuento;

	private float fPrecio;

	private float fTotal;

	private int iCantidad;

	private BigInteger iCompraId;

	private BigInteger iProductoId;

	private BigInteger iUsuarioActualizaId;

	private BigInteger iUsuarioInsertaId;

	public Compradetalle() {
	}

	public String getICompraDetalleId() {
		return this.iCompraDetalleId;
	}

	public void setICompraDetalleId(String iCompraDetalleId) {
		this.iCompraDetalleId = iCompraDetalleId;
	}

	public String getCEstadoCodigo() {
		return this.cEstadoCodigo;
	}

	public void setCEstadoCodigo(String cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}

	public Date getDFechaActualiza() {
		return this.dFechaActualiza;
	}

	public void setDFechaActualiza(Date dFechaActualiza) {
		this.dFechaActualiza = dFechaActualiza;
	}

	public Date getDFechaInserta() {
		return this.dFechaInserta;
	}

	public void setDFechaInserta(Date dFechaInserta) {
		this.dFechaInserta = dFechaInserta;
	}

	public float getFDescuento() {
		return this.fDescuento;
	}

	public void setFDescuento(float fDescuento) {
		this.fDescuento = fDescuento;
	}

	public float getFPrecio() {
		return this.fPrecio;
	}

	public void setFPrecio(float fPrecio) {
		this.fPrecio = fPrecio;
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

	public BigInteger getICompraId() {
		return this.iCompraId;
	}

	public void setICompraId(BigInteger iCompraId) {
		this.iCompraId = iCompraId;
	}

	public BigInteger getIProductoId() {
		return this.iProductoId;
	}

	public void setIProductoId(BigInteger iProductoId) {
		this.iProductoId = iProductoId;
	}

	public BigInteger getIUsuarioActualizaId() {
		return this.iUsuarioActualizaId;
	}

	public void setIUsuarioActualizaId(BigInteger iUsuarioActualizaId) {
		this.iUsuarioActualizaId = iUsuarioActualizaId;
	}

	public BigInteger getIUsuarioInsertaId() {
		return this.iUsuarioInsertaId;
	}

	public void setIUsuarioInsertaId(BigInteger iUsuarioInsertaId) {
		this.iUsuarioInsertaId = iUsuarioInsertaId;
	}

}