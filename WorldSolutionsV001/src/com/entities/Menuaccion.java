package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the menuaccion database table.
 * 
 */
@Entity
public class Menuaccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iMenuAccionId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idmenuOpciones", nullable=false)
	private Menuopcione menuopcione;

	private String vAccion;

	private String vCodigo;

    public Menuaccion() {
    }

	/**
	 * @return the iMenuAccionId
	 */
	public int getiMenuAccionId() {
		return iMenuAccionId;
	}

	/**
	 * @param iMenuAccionId the iMenuAccionId to set
	 */
	public void setiMenuAccionId(int iMenuAccionId) {
		this.iMenuAccionId = iMenuAccionId;
	}

	/**
	 * @return the menuopcione
	 */
	public Menuopcione getMenuopcione() {
		return menuopcione;
	}

	/**
	 * @param menuopcione the menuopcione to set
	 */
	public void setMenuopcione(Menuopcione menuopcione) {
		this.menuopcione = menuopcione;
	}

	/**
	 * @return the vAccion
	 */
	public String getvAccion() {
		return vAccion;
	}

	/**
	 * @param vAccion the vAccion to set
	 */
	public void setvAccion(String vAccion) {
		this.vAccion = vAccion;
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

	


}