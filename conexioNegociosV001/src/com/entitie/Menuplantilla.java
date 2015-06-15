package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the menuplantilla database table.
 * 
 */
@Entity
public class Menuplantilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iMenuPlantillaId;

	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private BigInteger iPlantillaId;

	private BigInteger iUsuarioActualiza;

	private BigInteger iUsuarioInserta;

	private String vAlineado;

	private String vColorFondoInf;

	private String vColorFondoSup;

	private String vColorLetra;

	private String vNombre;

	private String vPaginaDestino;

	public Menuplantilla() {
	}

	public String getIMenuPlantillaId() {
		return this.iMenuPlantillaId;
	}

	public void setIMenuPlantillaId(String iMenuPlantillaId) {
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

	public BigInteger getIPlantillaId() {
		return this.iPlantillaId;
	}

	public void setIPlantillaId(BigInteger iPlantillaId) {
		this.iPlantillaId = iPlantillaId;
	}

	public BigInteger getIUsuarioActualiza() {
		return this.iUsuarioActualiza;
	}

	public void setIUsuarioActualiza(BigInteger iUsuarioActualiza) {
		this.iUsuarioActualiza = iUsuarioActualiza;
	}

	public BigInteger getIUsuarioInserta() {
		return this.iUsuarioInserta;
	}

	public void setIUsuarioInserta(BigInteger iUsuarioInserta) {
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