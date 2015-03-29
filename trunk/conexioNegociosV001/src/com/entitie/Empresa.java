package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iEmpresaId;

	private String cEstadoCodigo;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private BigInteger iUsuarioActualizaId;

	private BigInteger iUsuarioId;

	private BigInteger iUsuarioInsertaId;

	private String vDireccionEnvio;

	private String vRazonSocial;

	private String vRuc;

	private String vUbicacion;

	private String vUbigeo;

    public Empresa() {
    }

	public String getIEmpresaId() {
		return this.iEmpresaId;
	}

	public void setIEmpresaId(String iEmpresaId) {
		this.iEmpresaId = iEmpresaId;
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

	public String getVDireccionEnvio() {
		return this.vDireccionEnvio;
	}

	public void setVDireccionEnvio(String vDireccionEnvio) {
		this.vDireccionEnvio = vDireccionEnvio;
	}

	public String getVRazonSocial() {
		return this.vRazonSocial;
	}

	public void setVRazonSocial(String vRazonSocial) {
		this.vRazonSocial = vRazonSocial;
	}

	public String getVRuc() {
		return this.vRuc;
	}

	public void setVRuc(String vRuc) {
		this.vRuc = vRuc;
	}

	public String getVUbicacion() {
		return this.vUbicacion;
	}

	public void setVUbicacion(String vUbicacion) {
		this.vUbicacion = vUbicacion;
	}

	public String getVUbigeo() {
		return this.vUbigeo;
	}

	public void setVUbigeo(String vUbigeo) {
		this.vUbigeo = vUbigeo;
	}

}