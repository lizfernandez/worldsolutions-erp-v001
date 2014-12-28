package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int iCategoriaId;

	@Column(nullable=false, length=5)
	private String cCategoriaCodigo;

	@Column(nullable=false, length=2)
	private String cEstadoCodigo;

    @Temporal( TemporalType.DATE)
	private Date dFechaActualiza;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date dFechaInserta;

	private int iUsuarioActualizaId;

	@Column(nullable=false)
	private int iUsuarioInsertaId;
	
	@ManyToOne(cascade= CascadeType.REFRESH)
	@JoinColumn(name="iClasificacionId", nullable=false)
	private Clasificacioncategoria clasificacionCategoria;
	
	@Column(nullable=false, length=45)
	private String vCategoriaDescripcion;

    public Categoria() {
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
	public Clasificacioncategoria getClasificacionCategoria() {
		return clasificacionCategoria;
	}

	/**
	 * @param clasificacionCategoria the clasificacionCategoria to set
	 */
	public void setClasificacionCategoria(
			Clasificacioncategoria clasificacionCategoria) {
		this.clasificacionCategoria = clasificacionCategoria;
	}


}