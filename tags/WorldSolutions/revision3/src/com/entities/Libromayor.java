package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the libromayor database table.
 * 
 */
@Entity
public class Libromayor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iLibroMayorId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="iCuentasId")	
	private Cuenta cuenta;
	
	private float fMontoDebe;

	private float fMontoHaber;
	

	private int iPeriodoId;

	public Libromayor() {
	}

	/**
	 * @return the iLibroMayorId
	 */
	public int getiLibroMayorId() {
		return iLibroMayorId;
	}

	/**
	 * @param iLibroMayorId the iLibroMayorId to set
	 */
	public void setiLibroMayorId(int iLibroMayorId) {
		this.iLibroMayorId = iLibroMayorId;
	}

	/**
	 * @return the fMontoDebe
	 */
	public float getfMontoDebe() {
		return fMontoDebe;
	}

	/**
	 * @param fMontoDebe the fMontoDebe to set
	 */
	public void setfMontoDebe(float fMontoDebe) {
		this.fMontoDebe = fMontoDebe;
	}

	/**
	 * @return the fMontoHaber
	 */
	public float getfMontoHaber() {
		return fMontoHaber;
	}

	/**
	 * @param fMontoHaber the fMontoHaber to set
	 */
	public void setfMontoHaber(float fMontoHaber) {
		this.fMontoHaber = fMontoHaber;
	}

	/**
	 * @return the cuenta
	 */
	public Cuenta getCuenta() {
		return cuenta;
	}

	/**
	 * @param cuenta the cuenta to set
	 */
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	/**
	 * @return the iPeriodoId
	 */
	public int getiPeriodoId() {
		return iPeriodoId;
	}

	/**
	 * @param iPeriodoId the iPeriodoId to set
	 */
	public void setiPeriodoId(int iPeriodoId) {
		this.iPeriodoId = iPeriodoId;
	}

	

	
}