package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estado database table.
 * 
 */
@Entity
@Table(name="estado")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int iEstadoId;

	@Column(nullable=false, length=2)
	private String cEstadoCodigo;

	@Column(nullable=false, length=45)
	private String vEstadoDescripcion;

    public Estado() {
    }
    
    

	public Estado(int iEstadoId, String vEstadoDescripcion) {
		super();
		this.iEstadoId = iEstadoId;		
		this.vEstadoDescripcion = vEstadoDescripcion;
	}



	public int getiEstadoId() {
		return iEstadoId;
	}

	public void setiEstadoId(int iEstadoId) {
		this.iEstadoId = iEstadoId;
	}

	public String getcEstadoCodigo() {
		return cEstadoCodigo;
	}

	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}

	public String getvEstadoDescripcion() {
		return vEstadoDescripcion;
	}

	public void setvEstadoDescripcion(String vEstadoDescripcion) {
		this.vEstadoDescripcion = vEstadoDescripcion;
	}


}