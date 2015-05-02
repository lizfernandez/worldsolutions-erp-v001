package com.entities.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estado database table.
 * 
 */

public class EstadoVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iEstadoId;
	private String cEstadoCodigo;
	private String vEstadoDescripcion;

    public EstadoVo() {
    }
    
    

	public EstadoVo(int iEstadoId, String vEstadoDescripcion) {
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