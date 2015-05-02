package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cuentas database table.
 * 
 */
@Entity
@Table(name="cuentas")
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int iCuentasId;

	//bi-directional many-to-one association to Area
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iElementoCuentasId", nullable=false)	
	private Elementocuenta elementoCuenta ;

	private String vCodigo;

	private String vDescripcion;

    public Cuenta() {
    }

	/**
	 * @return the iCuentasId
	 */
	public int getiCuentasId() {
		return iCuentasId;
	}

	/**
	 * @param iCuentasId the iCuentasId to set
	 */
	public void setiCuentasId(int iCuentasId) {
		this.iCuentasId = iCuentasId;
	}

	
	/**
	 * @return the elementoCuenta
	 */
	public Elementocuenta getElementoCuenta() {
		return elementoCuenta;
	}

	/**
	 * @param elementoCuenta the elementoCuenta to set
	 */
	public void setElementoCuenta(Elementocuenta elementoCuenta) {
		this.elementoCuenta = elementoCuenta;
	}

	/**
	 * @return the vCodigo
	 */
	public String getvCodigo() {
		return vCodigo;
	}

	/**
	 * @param vCodigo the vCodigo to set
	 */
	public void setvCodigo(String vCodigo) {
		this.vCodigo = vCodigo;
	}

	/**
	 * @return the vDescripcion
	 */
	public String getvDescripcion() {
		return vDescripcion;
	}

	/**
	 * @param vDescripcion the vDescripcion to set
	 */
	public void setvDescripcion(String vDescripcion) {
		this.vDescripcion = vDescripcion;
	}

	
}