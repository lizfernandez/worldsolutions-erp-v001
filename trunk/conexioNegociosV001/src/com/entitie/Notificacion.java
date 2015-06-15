package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the notificacion database table.
 * 
 */
@Entity
public class Notificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iNotificacionId;

	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private BigInteger iNoticiaId;

	private BigInteger iTipoNotificacionId;

	private BigInteger iUsuarioActualiza;

	private BigInteger iUsuarioDestId;

	private BigInteger iUsuarioInserta;

	private BigInteger iUsuarioOrigId;

	public Notificacion() {
	}

	public String getINotificacionId() {
		return this.iNotificacionId;
	}

	public void setINotificacionId(String iNotificacionId) {
		this.iNotificacionId = iNotificacionId;
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

	public BigInteger getINoticiaId() {
		return this.iNoticiaId;
	}

	public void setINoticiaId(BigInteger iNoticiaId) {
		this.iNoticiaId = iNoticiaId;
	}

	public BigInteger getITipoNotificacionId() {
		return this.iTipoNotificacionId;
	}

	public void setITipoNotificacionId(BigInteger iTipoNotificacionId) {
		this.iTipoNotificacionId = iTipoNotificacionId;
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