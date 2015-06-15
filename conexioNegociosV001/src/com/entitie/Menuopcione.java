package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the menuopciones database table.
 * 
 */
@Entity
@Table(name="menuopciones")
public class Menuopcione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iMenuOpcionesId;

	@Temporal(TemporalType.DATE)
	private Date dFechaActualiza;

	@Temporal(TemporalType.DATE)
	private Date dFechaInserta;

	private String estadoCodigo;

	private int iMenuTituloId;

	private String vCodigo;

	private String vOpciones;

	public Menuopcione() {
	}

	public int getIMenuOpcionesId() {
		return this.iMenuOpcionesId;
	}

	public void setIMenuOpcionesId(int iMenuOpcionesId) {
		this.iMenuOpcionesId = iMenuOpcionesId;
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

	public int getIMenuTituloId() {
		return this.iMenuTituloId;
	}

	public void setIMenuTituloId(int iMenuTituloId) {
		this.iMenuTituloId = iMenuTituloId;
	}

	public String getVCodigo() {
		return this.vCodigo;
	}

	public void setVCodigo(String vCodigo) {
		this.vCodigo = vCodigo;
	}

	public String getVOpciones() {
		return this.vOpciones;
	}

	public void setVOpciones(String vOpciones) {
		this.vOpciones = vOpciones;
	}

}