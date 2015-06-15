package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the plantillausuario database table.
 * 
 */
@Entity
public class Plantillausuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iPlantillaUsuarioId;

	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private float fPrecio;

	private BigInteger iPlantillaId;

	private BigInteger iUsuarioActualizaId;

	private BigInteger iUsuarioId;

	private BigInteger iUsuarioInsertaId;

	private String vNombrePlantilla;

	public Plantillausuario() {
	}

	public String getIPlantillaUsuarioId() {
		return this.iPlantillaUsuarioId;
	}

	public void setIPlantillaUsuarioId(String iPlantillaUsuarioId) {
		this.iPlantillaUsuarioId = iPlantillaUsuarioId;
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

	public float getFPrecio() {
		return this.fPrecio;
	}

	public void setFPrecio(float fPrecio) {
		this.fPrecio = fPrecio;
	}

	public BigInteger getIPlantillaId() {
		return this.iPlantillaId;
	}

	public void setIPlantillaId(BigInteger iPlantillaId) {
		this.iPlantillaId = iPlantillaId;
	}

	public BigInteger getIUsuarioActualizaId() {
		return this.iUsuarioActualizaId;
	}

	public void setIUsuarioActualizaId(BigInteger iUsuarioActualizaId) {
		this.iUsuarioActualizaId = iUsuarioActualizaId;
	}

	public BigInteger getIUsuarioId() {
		return this.iUsuarioId;
	}

	public void setIUsuarioId(BigInteger iUsuarioId) {
		this.iUsuarioId = iUsuarioId;
	}

	public BigInteger getIUsuarioInsertaId() {
		return this.iUsuarioInsertaId;
	}

	public void setIUsuarioInsertaId(BigInteger iUsuarioInsertaId) {
		this.iUsuarioInsertaId = iUsuarioInsertaId;
	}

	public String getVNombrePlantilla() {
		return this.vNombrePlantilla;
	}

	public void setVNombrePlantilla(String vNombrePlantilla) {
		this.vNombrePlantilla = vNombrePlantilla;
	}

}