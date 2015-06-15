package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the contratoempresa database table.
 * 
 */
@Entity
public class Contratoempresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iContratoEmpresaId;

	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaContrato;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaVencimiento;

	private float fComision;

	private BigInteger iEmpresaId;

	private BigInteger iTipoContratoId;

	private BigInteger iUsuarioActualizaId;

	private BigInteger iUsuarioInsertaId;

	private String vNroCuentaAbono;

	public Contratoempresa() {
	}

	public String getIContratoEmpresaId() {
		return this.iContratoEmpresaId;
	}

	public void setIContratoEmpresaId(String iContratoEmpresaId) {
		this.iContratoEmpresaId = iContratoEmpresaId;
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

	public Date getDFechaContrato() {
		return this.dFechaContrato;
	}

	public void setDFechaContrato(Date dFechaContrato) {
		this.dFechaContrato = dFechaContrato;
	}

	public Date getDFechaInserta() {
		return this.dFechaInserta;
	}

	public void setDFechaInserta(Date dFechaInserta) {
		this.dFechaInserta = dFechaInserta;
	}

	public Date getDFechaVencimiento() {
		return this.dFechaVencimiento;
	}

	public void setDFechaVencimiento(Date dFechaVencimiento) {
		this.dFechaVencimiento = dFechaVencimiento;
	}

	public float getFComision() {
		return this.fComision;
	}

	public void setFComision(float fComision) {
		this.fComision = fComision;
	}

	public BigInteger getIEmpresaId() {
		return this.iEmpresaId;
	}

	public void setIEmpresaId(BigInteger iEmpresaId) {
		this.iEmpresaId = iEmpresaId;
	}

	public BigInteger getITipoContratoId() {
		return this.iTipoContratoId;
	}

	public void setITipoContratoId(BigInteger iTipoContratoId) {
		this.iTipoContratoId = iTipoContratoId;
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

	public String getVNroCuentaAbono() {
		return this.vNroCuentaAbono;
	}

	public void setVNroCuentaAbono(String vNroCuentaAbono) {
		this.vNroCuentaAbono = vNroCuentaAbono;
	}

}