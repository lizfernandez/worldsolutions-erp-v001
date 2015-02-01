package com.entities.vo;

import java.io.Serializable;

public class PermisoVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idpermisos;
	private String cEstado;
	private String vCodigoMenu;
	private UsuarioVo usuario;

	public PermisoVo() {
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
	public UsuarioVo getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(UsuarioVo usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}