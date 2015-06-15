package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the seguridad database table.
 * 
 */
@Entity
public class Seguridad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iSeguridadId;

	@Temporal(TemporalType.DATE)
	private Date dFechaActualiza;

	@Temporal(TemporalType.DATE)
	private Date dFechaInserta;

	private String estadoCodigo;

	private int iUsuarioId;

	private String vCodigo;

	public Seguridad() {
	}

	public int getISeguridadId() {
		return this.iSeguridadId;
	}

	public void setISeguridadId(int iSeguridadId) {
		this.iSeguridadId = iSeguridadId;
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

	public String getEstadoCodigo() {
		return this.estadoCodigo;
	}

	public void setEstadoCodigo(String estadoCodigo) {
		this.estadoCodigo = estadoCodigo;
	}

	public int getIUsuarioId() {
		return this.iUsuarioId;
	}

	public void setIUsuarioId(int iUsuarioId) {
		this.iUsuarioId = iUsuarioId;
	}

	public String getVCodigo() {
		return this.vCodigo;
	}

	public void setVCodigo(String vCodigo) {
		this.vCodigo = vCodigo;
	}

}