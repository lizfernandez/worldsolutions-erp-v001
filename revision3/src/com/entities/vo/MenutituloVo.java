package com.entities.vo;

import java.io.Serializable;

import java.util.List;

public class MenutituloVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idmenuTitulo;
	private MenuVo menu ;
  	private List<MenuopcioneVo> menuopciones;
	private String vMenuTitulo;
	private String vCodigo;

	public MenutituloVo() {
	}

	/**
	 * @return the idmenuTitulo
	 */
	public int getIdmenuTitulo() {
		return idmenuTitulo;
	}

	/**
	 * @param idmenuTitulo the idmenuTitulo to set
	 */
	public void setIdmenuTitulo(int idmenuTitulo) {
		this.idmenuTitulo = idmenuTitulo;
	}

	/**
	 * @return the menu
	 */
	public MenuVo getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public void setMenu(MenuVo menu) {
		this.menu = menu;
	}

	/**
	 * @return the vMenuTitulo
	 */
	public String getvMenuTitulo() {
		return vMenuTitulo;
	}

	/**
	 * @param vMenuTitulo the vMenuTitulo to set
	 */
	public void setvMenuTitulo(String vMenuTitulo) {
		this.vMenuTitulo = vMenuTitulo;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the menuopciones
	 */
	public List<MenuopcioneVo> getMenuopciones() {
		return menuopciones;
	}

	/**
	 * @param menuopciones the menuopciones to set
	 */
	public void setMenuopciones(List<MenuopcioneVo> menuopciones) {
		this.menuopciones = menuopciones;
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