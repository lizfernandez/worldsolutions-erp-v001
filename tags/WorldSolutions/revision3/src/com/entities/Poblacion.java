package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the poblacion database table.
 * 
 */
@Entity
@Table(name="poblacion")
public class Poblacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int iPoblacionId;

	@Column(nullable=false, length=7)
	private String cCodigo;

	@Column(nullable=false, length=50)
	private String vDescripcion;
    
    public Poblacion() {
    }

	/**
	 * @return the iPoblacionId
	 */
	public int getiPoblacionId() {
		return iPoblacionId;
	}

	/**
	 * @param iPoblacionId the iPoblacionId to set
	 */
	public void setiPoblacionId(int iPoblacionId) {
		this.iPoblacionId = iPoblacionId;
	}

	
	
	/**
	 * @return the cCodigo
	 */
	public String getcCodigo() {
		return cCodigo;
	}

	/**
	 * @param cCodigo the cCodigo to set
	 */
	public void setcCodigo(String cCodigo) {
		this.cCodigo = cCodigo;
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