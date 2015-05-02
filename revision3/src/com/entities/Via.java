package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the via database table.
 * 
 */
@Entity
@Table(name="via")
public class Via implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int iViaId;

	@Column(length=5)
	private String vAbreviatura;

	@Column(length=45)
	private String vDescripcion;

    public Via() {
    }

	public int getIViaId() {
		return this.iViaId;
	}

	public void setIViaId(int iViaId) {
		this.iViaId = iViaId;
	}

	public String getVAbreviatura() {
		return this.vAbreviatura;
	}

	public void setVAbreviatura(String vAbreviatura) {
		this.vAbreviatura = vAbreviatura;
	}

	public String getVDescripcion() {
		return this.vDescripcion;
	}

	public void setVDescripcion(String vDescripcion) {
		this.vDescripcion = vDescripcion;
	}

}