package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the menuopciones database table.
 * 
 */
@Entity
@Table(name="menuopciones")
public class Menuopcione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmenuOpciones;
	
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idMenutitulo", nullable=false)
	private Menutitulo menutitulo ;

	private String vOpciones;
	
	private String vCodigo;

	public Menuopcione() {
	}

	/**
	 * @return the idmenuOpciones
	 */
	public int getIdmenuOpciones() {
		return idmenuOpciones;
	}

	/**
	 * @param idmenuOpciones the idmenuOpciones to set
	 */
	public void setIdmenuOpciones(int idmenuOpciones) {
		this.idmenuOpciones = idmenuOpciones;
	}

	/**
	 * @return the menutitulo
	 */
	public Menutitulo getMenutitulo() {
		return menutitulo;
	}

	/**
	 * @param menutitulo the menutitulo to set
	 */
	public void setMenutitulo(Menutitulo menutitulo) {
		this.menutitulo = menutitulo;
	}

	/**
	 * @return the vOpciones
	 */
	public String getvOpciones() {
		return vOpciones;
	}

	/**
	 * @param vOpciones the vOpciones to set
	 */
	public void setvOpciones(String vOpciones) {
		this.vOpciones = vOpciones;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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