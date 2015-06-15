package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iMenuId;

	@Temporal(TemporalType.DATE)
	private Date dFechaActualiza;

	@Temporal(TemporalType.DATE)
	private Date dFechaInserta;

	private String estadoCodigo;

	private String vCodigo;

	private String vMenu;

	public Menu() {
	}

	public int getIMenuId() {
		return this.iMenuId;
	}

	public void setIMenuId(int iMenuId) {
		this.iMenuId = iMenuId;
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

	public String getVCodigo() {
		return this.vCodigo;
	}

	public void setVCodigo(String vCodigo) {
		this.vCodigo = vCodigo;
	}

	public String getVMenu() {
		return this.vMenu;
	}

	public void setVMenu(String vMenu) {
		this.vMenu = vMenu;
	}

}