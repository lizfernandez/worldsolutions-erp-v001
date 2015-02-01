package com.entities;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the permisos database table.
 * 
 */
@Entity
@Table(name="permisos")

public class Permiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, name="idpermisos")
	@GeneratedValue(strategy=GenerationType.IDENTITY)		
	private int idpermisos;

	@Column(length=2)
	private String cEstado;

	@Column(length=3)
	private String vCodigoMenu;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="iUsuarioId")
	private Usuario usuario;

	public Permiso() {
	}

	/**
	 * @return the idpermisos
	 */
	public int getIdpermisos() {
		return idpermisos;
	}

	/**
	 * @param idpermisos the idpermisos to set
	 */
	public void setIdpermisos(int idpermisos) {
		this.idpermisos = idpermisos;
	}

	/**
	 * @return the cEstado
	 */
	public String getcEstado() {
		return cEstado;
	}

	/**
	 * @param cEstado the cEstado to set
	 */
	public void setcEstado(String cEstado) {
		this.cEstado = cEstado;
	}

	/**
	 * @return the vCodigoMenu
	 */
	public String getvCodigoMenu() {
		return vCodigoMenu;
	}

	/**
	 * @param vCodigoMenu the vCodigoMenu to set
	 */
	public void setvCodigoMenu(String vCodigoMenu) {
		this.vCodigoMenu = vCodigoMenu;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

}