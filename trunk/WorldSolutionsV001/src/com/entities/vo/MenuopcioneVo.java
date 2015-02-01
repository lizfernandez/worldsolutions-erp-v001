package com.entities.vo;

import java.io.Serializable;

public class MenuopcioneVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idmenuOpciones;
	private MenutituloVo menutitulo ;
	private String vOpciones;
	private String vCodigo;

	public MenuopcioneVo() {
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
	public MenutituloVo getMenutitulo() {
		return menutitulo;
	}

	/**
	 * @param menutitulo the menutitulo to set
	 */
	public void setMenutitulo(MenutituloVo menutitulo) {
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