package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the clasificacioncategoria database table.
 * 
 */
@Entity
@Table(name="Clasificacioncategoria")
public class Clasificacioncategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int iClasificacionId;

	private String cClasificacionCodigo;

	private String cEstadoCodigo;

	private String vClasificacionDescripcion;

    public Clasificacioncategoria() {
    }

	public Clasificacioncategoria(int iClasificacionId,
			String vClasificacionDescripcion) {
		super();
		this.iClasificacionId = iClasificacionId;
		this.vClasificacionDescripcion = vClasificacionDescripcion;
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