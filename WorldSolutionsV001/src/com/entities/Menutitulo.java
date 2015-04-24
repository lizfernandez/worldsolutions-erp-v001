package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the menutitulo database table.
 * 
 */
@Entity
public class Menutitulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmenuTitulo;
	
	
	//bi-directional many-to-one association to Proveedor
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idMenu", nullable=false)
	private Menu menu ;
    
  //bi-directional many-to-one association to Venta
  	@OneToMany(mappedBy="menutitulo")
  	private List<Menuopcione> menuopciones;

	private String vMenuTitulo;
	
	private String vCodigo;
	
	private String cEstadoCodigo;

	public Menutitulo() {
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
	public Menu getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public void setMenu(Menu menu) {
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
	public List<Menuopcione> getMenuopciones() {
		return menuopciones;
	}

	/**
	 * @param menuopciones the menuopciones to set
	 */
	public void setMenuopciones(List<Menuopcione> menuopciones) {
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