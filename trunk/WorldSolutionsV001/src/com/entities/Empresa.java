package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iEmpresaId;

	private String cEmpresaCodigo;

	private String cEstadoCodigo;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private int iUsuarioActualizaId;

	private int iUsuarioInsertaId;

	private String vEmpresaDireccion;

	private String vEmpresaNombre;

	private String vEmpresaRuc;

    public Empresa() {
    }

	/**
	 * @return the iEmpresaId
	 */
	public int getiEmpresaId() {
		return iEmpresaId;
	}

	/**
	 * @param iEmpresaId the iEmpresaId to set
	 */
	public void setiEmpresaId(int iEmpresaId) {
		this.iEmpresaId = iEmpresaId;
	}

	/**
	 * @return the cEmpresaCodigo
	 */
	public String getcEmpresaCodigo() {
		return cEmpresaCodigo;
	}

	/**
	 * @param cEmpresaCodigo the cEmpresaCodigo to set
	 */
	public void setcEmpresaCodigo(String cEmpresaCodigo) {
		this.cEmpresaCodigo = cEmpresaCodigo;
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
	 * @return the vEmpresaDireccion
	 */
	public String getvEmpresaDireccion() {
		return vEmpresaDireccion;
	}

	/**
	 * @param vEmpresaDireccion the vEmpresaDireccion to set
	 */
	public void setvEmpresaDireccion(String vEmpresaDireccion) {
		this.vEmpresaDireccion = vEmpresaDireccion;
	}

	/**
	 * @return the vEmpresaNombre
	 */
	public String getvEmpresaNombre() {
		return vEmpresaNombre;
	}

	/**
	 * @param vEmpresaNombre the vEmpresaNombre to set
	 */
	public void setvEmpresaNombre(String vEmpresaNombre) {
		this.vEmpresaNombre = vEmpresaNombre;
	}

	/**
	 * @return the vEmpresaRuc
	 */
	public String getvEmpresaRuc() {
		return vEmpresaRuc;
	}

	/**
	 * @param vEmpresaRuc the vEmpresaRuc to set
	 */
	public void setvEmpresaRuc(String vEmpresaRuc) {
		this.vEmpresaRuc = vEmpresaRuc;
	}

	

}