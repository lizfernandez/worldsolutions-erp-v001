package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the datoscontacto database table.
 * 
 */
@Entity
public class Datoscontacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iContactoId;

	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private BigInteger iUsuarioActualizaId;

	private BigInteger iUsuarioId;

	private BigInteger iUsuarioInsertaId;

	private String vDesContacto;

	private String vValorContacto;

	public Datoscontacto() {
	}

	public String getIContactoId() {
		return this.iContactoId;
	}

	public void setIContactoId(String iContactoId) {
		this.iContactoId = iContactoId;
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

	public String getVDesContacto() {
		return this.vDesContacto;
	}

	public void setVDesContacto(String vDesContacto) {
		this.vDesContacto = vDesContacto;
	}

	public String getVValorContacto() {
		return this.vValorContacto;
	}

	public void setVValorContacto(String vValorContacto) {
		this.vValorContacto = vValorContacto;
	}

}