package com.entities.vo;

import java.io.Serializable;

import com.entities.Clasificacioncategoria;


/**
 * The persistent class for the clasificacioncategoria database table.
 * 
 */

public class ClasificacioncategoriaVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iClasificacionId;
	private String cClasificacionCodigo;
	private String cEstadoCodigo;
	private String vClasificacionDescripcion;
    public ClasificacioncategoriaVo() {
    }

	public ClasificacioncategoriaVo(int iClasificacionId,
			String vClasificacionDescripcion) {
		super();
		this.iClasificacionId = iClasificacionId;
		this.vClasificacionDescripcion = vClasificacionDescripcion;
	}

	public ClasificacioncategoriaVo(Clasificacioncategoria clasificacionCategoria) {
		
		this.iClasificacionId = clasificacionCategoria.getiClasificacionId();
		this.cClasificacionCodigo = clasificacionCategoria.getcClasificacionCodigo();
		this.cEstadoCodigo = clasificacionCategoria.getcEstadoCodigo();
		this.vClasificacionDescripcion = clasificacionCategoria.getvClasificacionDescripcion();
	}

	/**
	 * @return the iClasificacionId
	 */
	public int getiClasificacionId() {
		return iClasificacionId;
	}

	/**
	 * @param iClasificacionId the iClasificacionId to set
	 */
	public void setiClasificacionId(int iClasificacionId) {
		this.iClasificacionId = iClasificacionId;
	}

	/**
	 * @return the cClasificacionCodigo
	 */
	public String getcClasificacionCodigo() {
		return cClasificacionCodigo;
	}

	/**
	 * @param cClasificacionCodigo the cClasificacionCodigo to set
	 */
	public void setcClasificacionCodigo(String cClasificacionCodigo) {
		this.cClasificacionCodigo = cClasificacionCodigo;
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

	/**
	 * @return the vClasificacionDescripcion
	 */
	public String getvClasificacionDescripcion() {
		return vClasificacionDescripcion;
	}

	/**
	 * @param vClasificacionDescripcion the vClasificacionDescripcion to set
	 */
	public void setvClasificacionDescripcion(String vClasificacionDescripcion) {
		this.vClasificacionDescripcion = vClasificacionDescripcion;
	}

	

}