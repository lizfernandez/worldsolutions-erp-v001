package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the menutitulo database table.
 * 
 */
@Entity
public class Menutitulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iMenuTituloId;

	@Temporal(TemporalType.DATE)
	private Date dFechaActualiza;

	@Temporal(TemporalType.DATE)
	private Date dFechaInserta;

	private String estadoCodigo;

	private int iMenuId;

	private String vCodigo;

	private String vMenuTitulo;

	public Menutitulo() {
	}

	public int getIMenuTituloId() {
		return this.iMenuTituloId;
	}

	public void setIMenuTituloId(int iMenuTituloId) {
		this.iMenuTituloId = iMenuTituloId;
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

	public int getIMenuId() {
		return this.iMenuId;
	}

	public void setIMenuId(int iMenuId) {
		this.iMenuId = iMenuId;
	}

	public String getVCodigo() {
		return this.vCodigo;
	}

	public void setVCodigo(String vCodigo) {
		this.vCodigo = vCodigo;
	}

	public String getVMenuTitulo() {
		return this.vMenuTitulo;
	}

	public void setVMenuTitulo(String vMenuTitulo) {
		this.vMenuTitulo = vMenuTitulo;
	}

}