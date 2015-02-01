package com.entities.vo;

import java.io.Serializable;

import java.util.List;

public class MenuVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idMenu;
	private List<MenutituloVo> menutitulo;
	private String vMenu;
	private String vCodigo;

	public MenuVo() {
	}

	/**
	 * @return the idMenu
	 */
	public int getIdMenu() {
		return idMenu;
	}

	/**
	 * @param idMenu the idMenu to set
	 */
	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}


	/**
	 * @return the vMenu
	 */
	public String getvMenu() {
		return vMenu;
	}

	/**
	 * @param vMenu the vMenu to set
	 */
	public void setvMenu(String vMenu) {
		this.vMenu = vMenu;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the menutitulo
	 */
	public List<MenutituloVo> getMenutitulo() {
		return menutitulo;
	}

	/**
	 * @param menutitulo the menutitulo to set
	 */
	public void setMenutitulo(List<MenutituloVo> menutitulo) {
		this.menutitulo = menutitulo;
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