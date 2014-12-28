package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mes database table.
 * 
 */
@Entity
@Table(name="mes")
public class Me implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int iMesId;

	@Column(nullable=false, length=45)
	private String vMesDescripcion;

    public Me() {
    }

	public int getIMesId() {
		return this.iMesId;
	}

	public void setIMesId(int iMesId) {
		this.iMesId = iMesId;
	}

	public String getVMesDescripcion() {
		return this.vMesDescripcion;
	}

	public void setVMesDescripcion(String vMesDescripcion) {
		this.vMesDescripcion = vMesDescripcion;
	}

}