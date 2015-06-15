package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the menuaccion database table.
 * 
 */
@Entity
public class Menuaccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iMenuAccionId;

	@Temporal(TemporalType.DATE)
	private Date dFechaActualiza;

	@Temporal(TemporalType.DATE)
	private Date dFechaInserta;

	private String estadoCodigo;

	private int iMenuOpcionesId;

	private String vAccion;

	private String vCodigo;

	public Menuaccion() {
	}

	public int getIMenuAccionId() {
		return this.iMenuAccionId;
	}

	public void setIMenuAccionId(int iMenuAccionId) {
		this.iMenuAccionId = iMenuAccionId;
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

	public int getIMenuOpcionesId() {
		return this.iMenuOpcionesId;
	}

	public void setIMenuOpcionesId(int iMenuOpcionesId) {
		this.iMenuOpcionesId = iMenuOpcionesId;
	}

	public String getVAccion() {
		return this.vAccion;
	}

	public void setVAccion(String vAccion) {
		this.vAccion = vAccion;
	}

	public String getVCodigo() {
		return this.vCodigo;
	}

	public void setVCodigo(String vCodigo) {
		this.vCodigo = vCodigo;
	}

}