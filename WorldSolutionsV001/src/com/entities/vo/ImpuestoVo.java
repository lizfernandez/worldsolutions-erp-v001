package com.entities.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the impuestos database table.
 * 
 */

public class ImpuestoVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iImpuestosId;
	private String cCodigoEstado;
	private Date dFechaInserta;
	private int iUsuarioInserta;
	private String vAplicacionImpuesto;
	private String vNombreImpuesto;
	private String vPorcentaje;
	public ImpuestoVo() {
	}

	/**
	 * @return the iImpuestosId
	 */
	public int getiImpuestosId() {
		return iImpuestosId;
	}

	/**
	 * @param iImpuestosId the iImpuestosId to set
	 */
	public void setiImpuestosId(int iImpuestosId) {
		this.iImpuestosId = iImpuestosId;
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
	 * @return the vAplicacionImpuesto
	 */
	public String getvAplicacionImpuesto() {
		return vAplicacionImpuesto;
	}

	/**
	 * @param vAplicacionImpuesto the vAplicacionImpuesto to set
	 */
	public void setvAplicacionImpuesto(String vAplicacionImpuesto) {
		this.vAplicacionImpuesto = vAplicacionImpuesto;
	}

	/**
	 * @return the vNombreImpuesto
	 */
	public String getvNombreImpuesto() {
		return vNombreImpuesto;
	}

	/**
	 * @param vNombreImpuesto the vNombreImpuesto to set
	 */
	public void setvNombreImpuesto(String vNombreImpuesto) {
		this.vNombreImpuesto = vNombreImpuesto;
	}

	/**
	 * @return the vPorcentaje
	 */
	public String getvPorcentaje() {
		return vPorcentaje;
	}

	/**
	 * @param vPorcentaje the vPorcentaje to set
	 */
	public void setvPorcentaje(String vPorcentaje) {
		this.vPorcentaje = vPorcentaje;
	}

	

}