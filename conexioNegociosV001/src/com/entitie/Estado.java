package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the estado database table.
 * 
 */
@Entity
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iEstadoId;

	private String cEstadoCodigo;

	private int cNombre;

	@Temporal(TemporalType.DATE)
	private Date dFechaActualiza;

	@Temporal(TemporalType.DATE)
	private Date dFechaInserta;

	private int iUsuarioActualiza;

	private int iUsuarioInserta;

	private int vDescripcion;

	public Estado() {
	}

	public int getIEstadoId() {
		return this.iEstadoId;
	}

	public void setIEstadoId(int iEstadoId) {
		this.iEstadoId = iEstadoId;
	}

	public String getCEstadoCodigo() {
		return this.cEstadoCodigo;
	}

	public void setCEstadoCodigo(String cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}

	public int getCNombre() {
		return this.cNombre;
	}

	public void setCNombre(int cNombre) {
		this.cNombre = cNombre;
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

	public int getIUsuarioActualiza() {
		return this.iUsuarioActualiza;
	}

	public void setIUsuarioActualiza(int iUsuarioActualiza) {
		this.iUsuarioActualiza = iUsuarioActualiza;
	}

	public int getIUsuarioInserta() {
		return this.iUsuarioInserta;
	}

	public void setIUsuarioInserta(int iUsuarioInserta) {
		this.iUsuarioInserta = iUsuarioInserta;
	}

	public int getVDescripcion() {
		return this.vDescripcion;
	}

	public void setVDescripcion(int vDescripcion) {
		this.vDescripcion = vDescripcion;
	}

}