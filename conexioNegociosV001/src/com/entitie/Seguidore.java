package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the seguidores database table.
 * 
 */
@Entity
@Table(name="seguidores")
public class Seguidore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iSeguidorId;

	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private BigInteger iUsuarioActualiza;

	private BigInteger iUsuarioDestId;

	private BigInteger iUsuarioInserta;

	private BigInteger iUsuarioOrigId;

	public Seguidore() {
	}

	public String getISeguidorId() {
		return this.iSeguidorId;
	}

	public void setISeguidorId(String iSeguidorId) {
		this.iSeguidorId = iSeguidorId;
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

	public BigInteger getIUsuarioActualiza() {
		return this.iUsuarioActualiza;
	}

	public void setIUsuarioActualiza(BigInteger iUsuarioActualiza) {
		this.iUsuarioActualiza = iUsuarioActualiza;
	}

	public BigInteger getIUsuarioDestId() {
		return this.iUsuarioDestId;
	}

	public void setIUsuarioDestId(BigInteger iUsuarioDestId) {
		this.iUsuarioDestId = iUsuarioDestId;
	}

	public BigInteger getIUsuarioInserta() {
		return this.iUsuarioInserta;
	}

	public void setIUsuarioInserta(BigInteger iUsuarioInserta) {
		this.iUsuarioInserta = iUsuarioInserta;
	}

	public BigInteger getIUsuarioOrigId() {
		return this.iUsuarioOrigId;
	}

	public void setIUsuarioOrigId(BigInteger iUsuarioOrigId) {
		this.iUsuarioOrigId = iUsuarioOrigId;
	}

}