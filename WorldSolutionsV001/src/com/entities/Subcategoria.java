package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the subcategoria database table.
 * 
 */
@Entity
public class Subcategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int iSubCategoriaId;

	private String cEstadoCodigo;

	private String cSubCategoriaCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;
	
	@ManyToOne(cascade= CascadeType.REFRESH)
	@JoinColumn(name="iCategoriaId", nullable=false)
	private Categoria categoria;

	private int iUsuarioActualizaId;

	private int iUsuarioInsertaId;

	private String vSubCategoriaDescripcion;

	public Subcategoria() {
	}

	/**
	 * @return the iSubCategoriaId
	 */
	public int getiSubCategoriaId() {
		return iSubCategoriaId;
	}

	/**
	 * @param iSubCategoriaId the iSubCategoriaId to set
	 */
	public void setiSubCategoriaId(int iSubCategoriaId) {
		this.iSubCategoriaId = iSubCategoriaId;
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
	 * @return the cSubCategoriaCodigo
	 */
	public String getcSubCategoriaCodigo() {
		return cSubCategoriaCodigo;
	}

	/**
	 * @param cSubCategoriaCodigo the cSubCategoriaCodigo to set
	 */
	public void setcSubCategoriaCodigo(String cSubCategoriaCodigo) {
		this.cSubCategoriaCodigo = cSubCategoriaCodigo;
	}

	/**
	 * @return the dFechaActualiza
	 */
	public Date getdFechaActualiza() {
		return dFechaActualiza;
	}

	/**
	 * @param dFechaActualiza the dFechaActualiza to set
	 */
	public void setdFechaActualiza(Date dFechaActualiza) {
		this.dFechaActualiza = dFechaActualiza;
	}

	/**
	 * @return the dFechaInserta
	 */
	public Date getdFechaInserta() {
		return dFechaInserta;
	}

	/**
	 * @param dFechaInserta the dFechaInserta to set
	 */
	public void setdFechaInserta(Date dFechaInserta) {
		this.dFechaInserta = dFechaInserta;
	}

	

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the iUsuarioActualizaId
	 */
	public int getiUsuarioActualizaId() {
		return iUsuarioActualizaId;
	}

	/**
	 * @param iUsuarioActualizaId the iUsuarioActualizaId to set
	 */
	public void setiUsuarioActualizaId(int iUsuarioActualizaId) {
		this.iUsuarioActualizaId = iUsuarioActualizaId;
	}

	/**
	 * @return the iUsuarioInsertaId
	 */
	public int getiUsuarioInsertaId() {
		return iUsuarioInsertaId;
	}

	/**
	 * @param iUsuarioInsertaId the iUsuarioInsertaId to set
	 */
	public void setiUsuarioInsertaId(int iUsuarioInsertaId) {
		this.iUsuarioInsertaId = iUsuarioInsertaId;
	}

	/**
	 * @return the vSubCategoriaDescripcion
	 */
	public String getvSubCategoriaDescripcion() {
		return vSubCategoriaDescripcion;
	}

	/**
	 * @param vSubCategoriaDescripcion the vSubCategoriaDescripcion to set
	 */
	public void setvSubCategoriaDescripcion(String vSubCategoriaDescripcion) {
		this.vSubCategoriaDescripcion = vSubCategoriaDescripcion;
	}

	
}