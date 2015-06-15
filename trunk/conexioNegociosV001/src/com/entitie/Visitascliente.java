package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the visitascliente database table.
 * 
 */
@Entity
public class Visitascliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iVisitasId;

	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaProxVisita;

	private BigInteger iEmpresaId;

	private BigInteger iUsuarioActualiza;

	private BigInteger iUsuarioId;

	private BigInteger iUsuarioInserta;

	private String vComentario;

	public Visitascliente() {
	}

	public String getIVisitasId() {
		return this.iVisitasId;
	}

	public void setIVisitasId(String iVisitasId) {
		this.iVisitasId = iVisitasId;
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

	public Date getDFechaProxVisita() {
		return this.dFechaProxVisita;
	}

	public void setDFechaProxVisita(Date dFechaProxVisita) {
		this.dFechaProxVisita = dFechaProxVisita;
	}

	public BigInteger getIEmpresaId() {
		return this.iEmpresaId;
	}

	public void setIEmpresaId(BigInteger iEmpresaId) {
		this.iEmpresaId = iEmpresaId;
	}

	public BigInteger getIUsuarioActualiza() {
		return this.iUsuarioActualiza;
	}

	public void setIUsuarioActualiza(BigInteger iUsuarioActualiza) {
		this.iUsuarioActualiza = iUsuarioActualiza;
	}

	public BigInteger getIUsuarioId() {
		return this.iUsuarioId;
	}

	public void setIUsuarioId(BigInteger iUsuarioId) {
		this.iUsuarioId = iUsuarioId;
	}

	public BigInteger getIUsuarioInserta() {
		return this.iUsuarioInserta;
	}

	public void setIUsuarioInserta(BigInteger iUsuarioInserta) {
		this.iUsuarioInserta = iUsuarioInserta;
	}

	public String getVComentario() {
		return this.vComentario;
	}

	public void setVComentario(String vComentario) {
		this.vComentario = vComentario;
	}

}