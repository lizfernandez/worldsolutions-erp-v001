
package com.entities.vo;

import java.io.Serializable;

import java.util.Date;

import com.entities.Ocupacion;

public class OcupacionVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iOcupacionId;
	private String cOcupacionCodigo;
	private String cEstadoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private int iUsuarioInserta;
	private int iUsuarioModifica;
	private String vOcupacionDescripcion;

    public OcupacionVo() {
    }

	public OcupacionVo(Ocupacion ocupacion) {
		this.iOcupacionId = ocupacion.getiOcupacionId();
		this.cOcupacionCodigo = ocupacion.getcOcupacionCodigo();
		this.cEstadoCodigo = ocupacion.getcEstadoCodigo();
		this.dFechaActualiza = ocupacion.getdFechaActualiza();
		this.dFechaInserta = ocupacion.getdFechaInserta();
		this.iUsuarioInserta = ocupacion.getiUsuarioInserta();
		this.iUsuarioModifica = ocupacion.getiUsuarioModifica();
		this.vOcupacionDescripcion = ocupacion.getvOcupacionDescripcion();
	}

	/**
	 * @return the iOcupacionId
	 */
	public int getiOcupacionId() {
		return iOcupacionId;
	}

	/**
	 * @param iOcupacionId the iOcupacionId to set
	 */
	public void setiOcupacionId(int iOcupacionId) {
		this.iOcupacionId = iOcupacionId;
	}

	/**
	 * @return the cOcupacionCodigo
	 */
	public String getcOcupacionCodigo() {
		return cOcupacionCodigo;
	}

	/**
	 * @param cOcupacionCodigo the cOcupacionCodigo to set
	 */
	public void setcOcupacionCodigo(String cOcupacionCodigo) {
		this.cOcupacionCodigo = cOcupacionCodigo;
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
	 * @return the iUsuarioModifica
	 */
	public int getiUsuarioModifica() {
		return iUsuarioModifica;
	}

	/**
	 * @param iUsuarioModifica the iUsuarioModifica to set
	 */
	public void setiUsuarioModifica(int iUsuarioModifica) {
		this.iUsuarioModifica = iUsuarioModifica;
	}

	/**
	 * @return the vOcupacionDescripcion
	 */
	public String getvOcupacionDescripcion() {
		return vOcupacionDescripcion;
	}

	/**
	 * @param vOcupacionDescripcion the vOcupacionDescripcion to set
	 */
	public void setvOcupacionDescripcion(String vOcupacionDescripcion) {
		this.vOcupacionDescripcion = vOcupacionDescripcion;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}