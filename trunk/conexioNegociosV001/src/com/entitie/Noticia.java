package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the noticia database table.
 * 
 */
@Entity
public class Noticia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iNoticiaId;

	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private BigInteger iUsuarioActualiza;

	private BigInteger iUsuarioId;

	private BigInteger iUsuarioInserta;

	private String vEtiquetas;

	private String vFoto;

	private String vPublicacion;

	private String vUbicacion;

	public Noticia() {
	}

	public String getINoticiaId() {
		return this.iNoticiaId;
	}

	public void setINoticiaId(String iNoticiaId) {
		this.iNoticiaId = iNoticiaId;
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

	public BigInteger getIUsuarioId() {
		return this.iUsuarioId;
	}

	public void setIUsuarioId(BigInteger iUsuarioId) {
		this.iUsuarioId = iUsuarioId;
	}

	public BigInteger getIUsuarioInserta() {
		return this.iUsuarioInserta;
	}

	public void setIUsuarioInserta(BigInteger iUsuarioInserta) {
		this.iUsuarioInserta = iUsuarioInserta;
	}

	public String getVEtiquetas() {
		return this.vEtiquetas;
	}

	public void setVEtiquetas(String vEtiquetas) {
		this.vEtiquetas = vEtiquetas;
	}

	public String getVFoto() {
		return this.vFoto;
	}

	public void setVFoto(String vFoto) {
		this.vFoto = vFoto;
	}

	public String getVPublicacion() {
		return this.vPublicacion;
	}

	public void setVPublicacion(String vPublicacion) {
		this.vPublicacion = vPublicacion;
	}

	public String getVUbicacion() {
		return this.vUbicacion;
	}

	public void setVUbicacion(String vUbicacion) {
		this.vUbicacion = vUbicacion;
	}

}