package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mediopago database table.
 * 
 */
@Entity
public class Mediopago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iMedioPagoId;

	private String cEstadoCodigo;

	private String cMedioPagoCodigo;

	private String vNombre;

    public Mediopago() {
    }

	/**
	 * @return the iMedioPagoId
	 */
	public int getiMedioPagoId() {
		return iMedioPagoId;
	}

	/**
	 * @param iMedioPagoId the iMedioPagoId to set
	 */
	public void setiMedioPagoId(int iMedioPagoId) {
		this.iMedioPagoId = iMedioPagoId;
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
	 * @return the cMedioPagoCodigo
	 */
	public String getcMedioPagoCodigo() {
		return cMedioPagoCodigo;
	}

	/**
	 * @param cMedioPagoCodigo the cMedioPagoCodigo to set
	 */
	public void setcMedioPagoCodigo(String cMedioPagoCodigo) {
		this.cMedioPagoCodigo = cMedioPagoCodigo;
	}

	/**
	 * @return the vNombre
	 */
	public String getvNombre() {
		return vNombre;
	}

	/**
	 * @param vNombre the vNombre to set
	 */
	public void setvNombre(String vNombre) {
		this.vNombre = vNombre;
	}



}