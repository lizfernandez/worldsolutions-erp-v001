package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the aulavirtual database table.
 * 
 */
@Entity
public class Aulavirtual implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iAulaVirtualId;

	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private BigInteger iUsuarioActualiza;

	private BigInteger iUsuarioInserta;

	private String vContenido;

	private String vEnlance;

	private String vTitulo;

	public Aulavirtual() {
	}

	public String getIAulaVirtualId() {
		return this.iAulaVirtualId;
	}

	public void setIAulaVirtualId(String iAulaVirtualId) {
		this.iAulaVirtualId = iAulaVirtualId;
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

	public String getVContenido() {
		return this.vContenido;
	}

	public void setVContenido(String vContenido) {
		this.vContenido = vContenido;
	}

	public String getVEnlance() {
		return this.vEnlance;
	}

	public void setVEnlance(String vEnlance) {
		this.vEnlance = vEnlance;
	}

	public String getVTitulo() {
		return this.vTitulo;
	}

	public void setVTitulo(String vTitulo) {
		this.vTitulo = vTitulo;
	}

}