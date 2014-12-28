package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the elementocuentas database table.
 * 
 */
@Entity
@Table(name="elementocuentas")
/*@NamedQuery(
        name="elementocuentas",
        query="SELECT c FROM Elementocuenta c"
)*/
public class Elementocuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iElementoCuentasId;

	private String vDescripcion;

	private String vElemento;

    public Elementocuenta() {
    }

	/**
	 * @return the iElementoCuentasId
	 */
	public int getiElementoCuentasId() {
		return iElementoCuentasId;
	}

	/**
	 * @param iElementoCuentasId the iElementoCuentasId to set
	 */
	public void setiElementoCuentasId(int iElementoCuentasId) {
		this.iElementoCuentasId = iElementoCuentasId;
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

	/**
	 * @return the vElemento
	 */
	public String getvElemento() {
		return vElemento;
	}

	/**
	 * @param vElemento the vElemento to set
	 */
	public void setvElemento(String vElemento) {
		this.vElemento = vElemento;
	}

	
}