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
	private BigInteger iComentarioId;

	private String cEstadoCodigo;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

    @Temporal( TemporalType.TIMESTAMP)
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

	/**
	 * @return the iComentarioId
	 */
	public BigInteger getiComentarioId() {
		return iComentarioId;
	}

	/**
	 * @param iComentarioId the iComentarioId to set
	 */
	public void setiComentarioId(BigInteger iComentarioId) {
		this.iComentarioId = iComentarioId;
	}

	/**
	 * @return the cEstadoCodigo
	 */
	public String getcEstadoCodigo() {
		return cEstadoCodigo;
	}

	/**
	 * @param cEstadoCodigo the cEstadoCodigo to set
	 */
	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}

	/**
	 * @return the dFechaActualiza
	 */
	public Date getdFechaActualiza() {
		return dFechaActualiza;
	}

	/**
	 * @param dFechaActualiza the dFechaActualiza to set
	 */
	public void setdFechaActualiza(Date dFechaActualiza) {
		this.dFechaActualiza = dFechaActualiza;
	}

	/**
	 * @return the dFechaInserta
	 */
	public Date getdFechaInserta() {
		return dFechaInserta;
	}

	/**
	 * @param dFechaInserta the dFechaInserta to set
	 */
	public void setdFechaInserta(Date dFechaInserta) {
		this.dFechaInserta = dFechaInserta;
	}

	/**
	 * @return the iEventoId
	 */
	public BigInteger getiEventoId() {
		return iEventoId;
	}

	/**
	 * @param iEventoId the iEventoId to set
	 */
	public void setiEventoId(BigInteger iEventoId) {
		this.iEventoId = iEventoId;
	}

	/**
	 * @return the iNoticiasId
	 */
	public BigInteger getiNoticiasId() {
		return iNoticiasId;
	}

	/**
	 * @param iNoticiasId the iNoticiasId to set
	 */
	public void setiNoticiasId(BigInteger iNoticiasId) {
		this.iNoticiasId = iNoticiasId;
	}

	/**
	 * @return the iUsuarioActualiza
	 */
	public BigInteger getiUsuarioActualiza() {
		return iUsuarioActualiza;
	}

	/**
	 * @param iUsuarioActualiza the iUsuarioActualiza to set
	 */
	public void setiUsuarioActualiza(BigInteger iUsuarioActualiza) {
		this.iUsuarioActualiza = iUsuarioActualiza;
	}

	/**
	 * @return the iUsuarioId
	 */
	public BigInteger getiUsuarioId() {
		return iUsuarioId;
	}

	/**
	 * @param iUsuarioId the iUsuarioId to set
	 */
	public void setiUsuarioId(BigInteger iUsuarioId) {
		this.iUsuarioId = iUsuarioId;
	}

	/**
	 * @return the iUsuarioInserta
	 */
	public BigInteger getiUsuarioInserta() {
		return iUsuarioInserta;
	}

	/**
	 * @param iUsuarioInserta the iUsuarioInserta to set
	 */
	public void setiUsuarioInserta(BigInteger iUsuarioInserta) {
		this.iUsuarioInserta = iUsuarioInserta;
	}

	/**
	 * @return the vComentario
	 */
	public String getvComentario() {
		return vComentario;
	}

	/**
	 * @param vComentario the vComentario to set
	 */
	public void setvComentario(String vComentario) {
		this.vComentario = vComentario;
	}

	/**
	 * @return the vEtiquetas
	 */
	public String getvEtiquetas() {
		return vEtiquetas;
	}

	/**
	 * @param vEtiquetas the vEtiquetas to set
	 */
	public void setvEtiquetas(String vEtiquetas) {
		this.vEtiquetas = vEtiquetas;
	}

	/**
	 * @return the vFoto
	 */
	public String getvFoto() {
		return vFoto;
	}

	/**
	 * @param vFoto the vFoto to set
	 */
	public void setvFoto(String vFoto) {
		this.vFoto = vFoto;
	}

	/**
	 * @return the vUbicacion
	 */
	public String getvUbicacion() {
		return vUbicacion;
	}

	/**
	 * @param vUbicacion the vUbicacion to set
	 */
	public void setvUbicacion(String vUbicacion) {
		this.vUbicacion = vUbicacion;
	}

	
}