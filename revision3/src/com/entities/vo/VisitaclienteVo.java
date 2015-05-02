package com.entities.vo;

import java.io.Serializable;

import java.sql.Time;
import java.util.Date;

public class VisitaclienteVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iVisitaClienteId;
	private Date dFecaProxVisita;
	private Date  dFechaActualiza;
	private Date dFechaInserta;
	private Date dFechaVisista;
	private Time dHoraVisita;
	private float fPrecioPactado;
	private ClienteVo cliente;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
	private String vMotivoVisita;
	private String vObservacion;
	private String vProductoOfrecido;

	public VisitaclienteVo() {
	}

	/**
	 * @return the iVisitaClienteId
	 */
	public int getiVisitaClienteId() {
		return iVisitaClienteId;
	}

	/**
	 * @param iVisitaClienteId the iVisitaClienteId to set
	 */
	public void setiVisitaClienteId(int iVisitaClienteId) {
		this.iVisitaClienteId = iVisitaClienteId;
	}

	/**
	 * @return the dFecaProxVisita
	 */
	public Date getdFecaProxVisita() {
		return dFecaProxVisita;
	}

	/**
	 * @param dFecaProxVisita the dFecaProxVisita to set
	 */
	public void setdFecaProxVisita(Date dFecaProxVisita) {
		this.dFecaProxVisita = dFecaProxVisita;
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
	 * @return the dFechaVisista
	 */
	public Date getdFechaVisista() {
		return dFechaVisista;
	}

	/**
	 * @param dFechaVisista the dFechaVisista to set
	 */
	public void setdFechaVisista(Date dFechaVisista) {
		this.dFechaVisista = dFechaVisista;
	}

	/**
	 * @return the dHoraVisita
	 */
	public Time getdHoraVisita() {
		return dHoraVisita;
	}

	/**
	 * @param dHoraVisita the dHoraVisita to set
	 */
	public void setdHoraVisita(Time dHoraVisita) {
		this.dHoraVisita = dHoraVisita;
	}

	/**
	 * @return the fPrecioPactado
	 */
	public float getfPrecioPactado() {
		return fPrecioPactado;
	}

	/**
	 * @param fPrecioPactado the fPrecioPactado to set
	 */
	public void setfPrecioPactado(float fPrecioPactado) {
		this.fPrecioPactado = fPrecioPactado;
	}

	/**
	 * @return the cliente
	 */
	public ClienteVo getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(ClienteVo cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the iUsuarioActualizaId
	 */
	public int getiUsuarioActualizaId() {
		return iUsuarioActualizaId;
	}

	/**
	 * @param iUsuarioActualizaId the iUsuarioActualizaId to set
	 */
	public void setiUsuarioActualizaId(int iUsuarioActualizaId) {
		this.iUsuarioActualizaId = iUsuarioActualizaId;
	}

	/**
	 * @return the iUsuarioInsertaId
	 */
	public int getiUsuarioInsertaId() {
		return iUsuarioInsertaId;
	}

	/**
	 * @param iUsuarioInsertaId the iUsuarioInsertaId to set
	 */
	public void setiUsuarioInsertaId(int iUsuarioInsertaId) {
		this.iUsuarioInsertaId = iUsuarioInsertaId;
	}

	/**
	 * @return the vMotivoVisita
	 */
	public String getvMotivoVisita() {
		return vMotivoVisita;
	}

	/**
	 * @param vMotivoVisita the vMotivoVisita to set
	 */
	public void setvMotivoVisita(String vMotivoVisita) {
		this.vMotivoVisita = vMotivoVisita;
	}

	/**
	 * @return the vObservacion
	 */
	public String getvObservacion() {
		return vObservacion;
	}

	/**
	 * @param vObservacion the vObservacion to set
	 */
	public void setvObservacion(String vObservacion) {
		this.vObservacion = vObservacion;
	}

	/**
	 * @return the vProductoOfrecido
	 */
	public String getvProductoOfrecido() {
		return vProductoOfrecido;
	}

	/**
	 * @param vProductoOfrecido the vProductoOfrecido to set
	 */
	public void setvProductoOfrecido(String vProductoOfrecido) {
		this.vProductoOfrecido = vProductoOfrecido;
	}

	

}