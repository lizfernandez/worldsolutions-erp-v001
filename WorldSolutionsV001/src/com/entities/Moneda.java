package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.entities.vo.MonedaVo;


/**
 * The persistent class for the moneda database table.
 * 
 */
@Entity
@Table(name="moneda")
public class Moneda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int iMonedaId;

	@Column(nullable=false, length=2)
	private String cEstadoCodigo;

	@Column(nullable=false, length=3)
	private String cModenaCodigo;

	@Column(nullable=false, length=45)
	private String vMonedaDescripcion;

    public Moneda() {
    }

	public Moneda(MonedaVo moneda) {
		
		this.iMonedaId = moneda.getiMonedaId();
		this.cEstadoCodigo = moneda.getcEstadoCodigo();
		this.cModenaCodigo = moneda.getcModenaCodigo();
		this.vMonedaDescripcion = moneda.getvMonedaDescripcion();
	}

	/**
	 * @return the iMonedaId
	 */
	public int getiMonedaId() {
		return iMonedaId;
	}

	/**
	 * @param iMonedaId the iMonedaId to set
	 */
	public void setiMonedaId(int iMonedaId) {
		this.iMonedaId = iMonedaId;
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
	 * @return the cModenaCodigo
	 */
	public String getcModenaCodigo() {
		return cModenaCodigo;
	}

	/**
	 * @param cModenaCodigo the cModenaCodigo to set
	 */
	public void setcModenaCodigo(String cModenaCodigo) {
		this.cModenaCodigo = cModenaCodigo;
	}

	/**
	 * @return the vMonedaDescripcion
	 */
	public String getvMonedaDescripcion() {
		return vMonedaDescripcion;
	}

	/**
	 * @param vMonedaDescripcion the vMonedaDescripcion to set
	 */
	public void setvMonedaDescripcion(String vMonedaDescripcion) {
		this.vMonedaDescripcion = vMonedaDescripcion;
	}

	
}