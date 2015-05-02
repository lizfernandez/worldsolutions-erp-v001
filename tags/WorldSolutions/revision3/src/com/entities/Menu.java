package com.entities;

import java.io.Serializable;
import java.util.List;


import javax.persistence.*;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMenu;
	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="menu")
	private List<Menutitulo> menutitulo;
		
	private String vMenu;

	private String vCodigo;
	
	private String cEstadoCodigo;

	public Menu() {
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
	public List<Menutitulo> getMenutitulo() {
		return menutitulo;
	}

	/**
	 * @param menutitulo the menutitulo to set
	 */
	public void setMenutitulo(List<Menutitulo> menutitulo) {
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

	

}