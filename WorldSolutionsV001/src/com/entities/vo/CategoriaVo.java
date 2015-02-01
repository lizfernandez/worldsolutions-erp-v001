package com.entities.vo;

import java.io.Serializable;

import java.util.Date;


/**
 * The persistent class for the categoria database table.
 * 
 */

public class CategoriaVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iCategoriaId;
	private String cCategoriaCodigo;
	private String cEstadoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
	private ClasificacioncategoriaVo clasificacionCategoria;
	private String vCategoriaDescripcion;

    public CategoriaVo() {
    }

	public int getiCategoriaId() {
		return iCategoriaId;
	}

	public void setiCategoriaId(int iCategoriaId) {
		this.iCategoriaId = iCategoriaId;
	}

	public String getcCategoriaCodigo() {
		return cCategoriaCodigo;
	}

	public void setcCategoriaCodigo(String cCategoriaCodigo) {
		this.cCategoriaCodigo = cCategoriaCodigo;
	}

	public String getcEstadoCodigo() {
		return cEstadoCodigo;
	}

	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}

	public Date getdFechaActualiza() {
		return dFechaActualiza;
	}

	public void setdFechaActualiza(Date dFechaActualiza) {
		this.dFechaActualiza = dFechaActualiza;
	}

	public Date getdFechaInserta() {
		return dFechaInserta;
	}

	public void setdFechaInserta(Date dFechaInserta) {
		this.dFechaInserta = dFechaInserta;
	}

	public int getiUsuarioActualizaId() {
		return iUsuarioActualizaId;
	}

	public void setiUsuarioActualizaId(int iUsuarioActualizaId) {
		this.iUsuarioActualizaId = iUsuarioActualizaId;
	}

	public int getiUsuarioInsertaId() {
		return iUsuarioInsertaId;
	}

	public void setiUsuarioInsertaId(int iUsuarioInsertaId) {
		this.iUsuarioInsertaId = iUsuarioInsertaId;
	}

	public String getvCategoriaDescripcion() {
		return vCategoriaDescripcion;
	}

	public void setvCategoriaDescripcion(String vCategoriaDescripcion) {
		this.vCategoriaDescripcion = vCategoriaDescripcion;
	}

	/**
	 * @return the clasificacionCategoria
	 */
	public ClasificacioncategoriaVo getClasificacionCategoria() {
		return clasificacionCategoria;
	}

	/**
	 * @param clasificacionCategoria the clasificacionCategoria to set
	 */
	public void setClasificacionCategoria(
			ClasificacioncategoriaVo clasificacionCategoria) {
		this.clasificacionCategoria = clasificacionCategoria;
	}


}