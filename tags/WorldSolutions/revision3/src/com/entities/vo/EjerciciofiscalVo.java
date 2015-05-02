package com.entities.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ejerciciofiscal database table.
 * 
 */

public class EjerciciofiscalVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iEjercicioFiscalId;
	private String cCodigoEstado;
	private Date dFechaActualiza;
	private Date dFechaFin;
	private Date dFechaInicio;
	private Date dFechaInserta;
	private int iUsuarioActualiza;
	private int iUsuarioInserta;
	private String vCodigoEjercicio;
	private String vNombreEjercicio;
	private List<PeriodoVo> periodos;

	public EjerciciofiscalVo() {
	}

	/**
	 * @return the iEjercicioFiscalId
	 */
	public int getiEjercicioFiscalId() {
		return iEjercicioFiscalId;
	}

	/**
	 * @param iEjercicioFiscalId the iEjercicioFiscalId to set
	 */
	public void setiEjercicioFiscalId(int iEjercicioFiscalId) {
		this.iEjercicioFiscalId = iEjercicioFiscalId;
	}

	/**
	 * @return the cCodigoEstado
	 */
	public String getcCodigoEstado() {
		return cCodigoEstado;
	}

	/**
	 * @param cCodigoEstado the cCodigoEstado to set
	 */
	public void setcCodigoEstado(String cCodigoEstado) {
		this.cCodigoEstado = cCodigoEstado;
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
	 * @return the dFechaFin
	 */
	public Date getdFechaFin() {
		return dFechaFin;
	}

	/**
	 * @param dFechaFin the dFechaFin to set
	 */
	public void setdFechaFin(Date dFechaFin) {
		this.dFechaFin = dFechaFin;
	}

	/**
	 * @return the dFechaInicio
	 */
	public Date getdFechaInicio() {
		return dFechaInicio;
	}

	/**
	 * @param dFechaInicio the dFechaInicio to set
	 */
	public void setdFechaInicio(Date dFechaInicio) {
		this.dFechaInicio = dFechaInicio;
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
	 * @return the iUsuarioActualiza
	 */
	public int getiUsuarioActualiza() {
		return iUsuarioActualiza;
	}

	/**
	 * @param iUsuarioActualiza the iUsuarioActualiza to set
	 */
	public void setiUsuarioActualiza(int iUsuarioActualiza) {
		this.iUsuarioActualiza = iUsuarioActualiza;
	}

	/**
	 * @return the iUsuarioInserta
	 */
	public int getiUsuarioInserta() {
		return iUsuarioInserta;
	}

	/**
	 * @param iUsuarioInserta the iUsuarioInserta to set
	 */
	public void setiUsuarioInserta(int iUsuarioInserta) {
		this.iUsuarioInserta = iUsuarioInserta;
	}

	/**
	 * @return the vCodigoEjercicio
	 */
	public String getvCodigoEjercicio() {
		return vCodigoEjercicio;
	}

	/**
	 * @param vCodigoEjercicio the vCodigoEjercicio to set
	 */
	public void setvCodigoEjercicio(String vCodigoEjercicio) {
		this.vCodigoEjercicio = vCodigoEjercicio;
	}

	/**
	 * @return the vNombreEjercicio
	 */
	public String getvNombreEjercicio() {
		return vNombreEjercicio;
	}

	/**
	 * @param vNombreEjercicio the vNombreEjercicio to set
	 */
	public void setvNombreEjercicio(String vNombreEjercicio) {
		this.vNombreEjercicio = vNombreEjercicio;
	}

	/**
	 * @return the periodos
	 */
	public List<PeriodoVo> getPeriodos() {
		return periodos;
	}

	/**
	 * @param periodos the periodos to set
	 */
	public void setPeriodos(List<PeriodoVo> periodos) {
		this.periodos = periodos;
	}
	
}