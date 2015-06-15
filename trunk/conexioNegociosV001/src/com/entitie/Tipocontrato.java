package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the tipocontrato database table.
 * 
 */
@Entity
public class Tipocontrato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iTipoContratoId;

	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private BigInteger iUsuarioActualizaId;

	private BigInteger iUsuarioInsertaId;

	private String vNombre;

	public Tipocontrato() {
	}

	public String getITipoContratoId() {
		return this.iTipoContratoId;
	}

	public void setITipoContratoId(String iTipoContratoId) {
		this.iTipoContratoId = iTipoContratoId;
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

	public BigInteger getIUsuarioActualizaId() {
		return this.iUsuarioActualizaId;
	}

	public void setIUsuarioActualizaId(BigInteger iUsuarioActualizaId) {
		this.iUsuarioActualizaId = iUsuarioActualizaId;
	}

	public BigInteger getIUsuarioInsertaId() {
		return this.iUsuarioInsertaId;
	}

	public void setIUsuarioInsertaId(BigInteger iUsuarioInsertaId) {
		this.iUsuarioInsertaId = iUsuarioInsertaId;
	}

	public String getVNombre() {
		return this.vNombre;
	}

	public void setVNombre(String vNombre) {
		this.vNombre = vNombre;
	}

}