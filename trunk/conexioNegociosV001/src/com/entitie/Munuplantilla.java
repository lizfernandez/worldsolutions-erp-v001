package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the munuplantilla database table.
 * 
 */
@Entity
public class Munuplantilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iMenuPlantillaId;

	private String cEstadoCodigo;

    @Temporal( TemporalType.DATE)
	private Date dFechaActualiza;

    @Temporal( TemporalType.DATE)
	private Date dFechaInserta;

	private int iPlantillaId;

	private int iUsuarioActualiza;

	private int iUsuarioInserta;

	private String vAlineado;

	private String vColorFondoInf;

	private String vColorFondoSup;

	private String vColorLetra;

	private String vNombre;

	private String vPaginaDestino;

    public Munuplantilla() {
    }

	public int getIMenuPlantillaId() {
		return this.iMenuPlantillaId;
	}

	public void setIMenuPlantillaId(int iMenuPlantillaId) {
		this.iMenuPlantillaId = iMenuPlantillaId;
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

	public int getIPlantillaId() {
		return this.iPlantillaId;
	}

	public void setIPlantillaId(int iPlantillaId) {
		this.iPlantillaId = iPlantillaId;
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

	public String getVAlineado() {
		return this.vAlineado;
	}

	public void setVAlineado(String vAlineado) {
		this.vAlineado = vAlineado;
	}

	public String getVColorFondoInf() {
		return this.vColorFondoInf;
	}

	public void setVColorFondoInf(String vColorFondoInf) {
		this.vColorFondoInf = vColorFondoInf;
	}

	public String getVColorFondoSup() {
		return this.vColorFondoSup;
	}

	public void setVColorFondoSup(String vColorFondoSup) {
		this.vColorFondoSup = vColorFondoSup;
	}

	public String getVColorLetra() {
		return this.vColorLetra;
	}

	public void setVColorLetra(String vColorLetra) {
		this.vColorLetra = vColorLetra;
	}

	public String getVNombre() {
		return this.vNombre;
	}

	public void setVNombre(String vNombre) {
		this.vNombre = vNombre;
	}

	public String getVPaginaDestino() {
		return this.vPaginaDestino;
	}

	public void setVPaginaDestino(String vPaginaDestino) {
		this.vPaginaDestino = vPaginaDestino;
	}

}