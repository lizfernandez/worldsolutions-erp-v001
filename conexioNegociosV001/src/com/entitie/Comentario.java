package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the comentario database table.
 * 
 */
@Entity
public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iComentarioId;

	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private BigInteger iEventoId;

	private BigInteger iNoticiasId;

	private BigInteger iUsuarioActualiza;

	private BigInteger iUsuarioId;

	private BigInteger iUsuarioInserta;

	private String vComentario;

	private String vEtiquetas;

	private String vFoto;

	private String vUbicacion;

	public Comentario() {
	}

	public String getIComentarioId() {
		return this.iComentarioId;
	}

	public void setIComentarioId(String iComentarioId) {
		this.iComentarioId = iComentarioId;
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

	public BigInteger getIEventoId() {
		return this.iEventoId;
	}

	public void setIEventoId(BigInteger iEventoId) {
		this.iEventoId = iEventoId;
	}

	public BigInteger getINoticiasId() {
		return this.iNoticiasId;
	}

	public void setINoticiasId(BigInteger iNoticiasId) {
		this.iNoticiasId = iNoticiasId;
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

	public String getVComentario() {
		return this.vComentario;
	}

	public void setVComentario(String vComentario) {
		this.vComentario = vComentario;
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

	public String getVUbicacion() {
		return this.vUbicacion;
	}

	public void setVUbicacion(String vUbicacion) {
		this.vUbicacion = vUbicacion;
	}

}