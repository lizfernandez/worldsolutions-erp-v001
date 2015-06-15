package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the compra database table.
 * 
 */
@Entity
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iCompraId;

	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private float fIgv;

	private float fSubTotal;

	private float fTotal;

	private int iTipoPagoId;

	private BigInteger iUsuarioActualizaId;

	private BigInteger iUsuarioClienteId;

	private BigInteger iUsuarioInsertaId;

	private BigInteger iUsuarioVendedorId;

	public Compra() {
	}

	public String getICompraId() {
		return this.iCompraId;
	}

	public void setICompraId(String iCompraId) {
		this.iCompraId = iCompraId;
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

	public float getFIgv() {
		return this.fIgv;
	}

	public void setFIgv(float fIgv) {
		this.fIgv = fIgv;
	}

	public float getFSubTotal() {
		return this.fSubTotal;
	}

	public void setFSubTotal(float fSubTotal) {
		this.fSubTotal = fSubTotal;
	}

	public float getFTotal() {
		return this.fTotal;
	}

	public void setFTotal(float fTotal) {
		this.fTotal = fTotal;
	}

	public int getITipoPagoId() {
		return this.iTipoPagoId;
	}

	public void setITipoPagoId(int iTipoPagoId) {
		this.iTipoPagoId = iTipoPagoId;
	}

	public BigInteger getIUsuarioActualizaId() {
		return this.iUsuarioActualizaId;
	}

	public void setIUsuarioActualizaId(BigInteger iUsuarioActualizaId) {
		this.iUsuarioActualizaId = iUsuarioActualizaId;
	}

	public BigInteger getIUsuarioClienteId() {
		return this.iUsuarioClienteId;
	}

	public void setIUsuarioClienteId(BigInteger iUsuarioClienteId) {
		this.iUsuarioClienteId = iUsuarioClienteId;
	}

	public BigInteger getIUsuarioInsertaId() {
		return this.iUsuarioInsertaId;
	}

	public void setIUsuarioInsertaId(BigInteger iUsuarioInsertaId) {
		this.iUsuarioInsertaId = iUsuarioInsertaId;
	}

	public BigInteger getIUsuarioVendedorId() {
		return this.iUsuarioVendedorId;
	}

	public void setIUsuarioVendedorId(BigInteger iUsuarioVendedorId) {
		this.iUsuarioVendedorId = iUsuarioVendedorId;
	}

}