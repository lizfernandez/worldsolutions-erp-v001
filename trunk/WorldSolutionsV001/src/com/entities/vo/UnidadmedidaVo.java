package com.entities.vo;

import java.io.Serializable;

import com.entities.Unidadmedida;

public class UnidadmedidaVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iUnidadMedidaId;
	private String cEstadoCodigo;
	private String cUnidadMedidaCodigo;
	private String vUnidadMedidaDescripcion;

    public UnidadmedidaVo() {
    }

	public UnidadmedidaVo(Unidadmedida unidadMedida) {
		
		this.iUnidadMedidaId = unidadMedida.getiUnidadMedidaId();
		this.cEstadoCodigo = unidadMedida.getcEstadoCodigo();
		this.cUnidadMedidaCodigo = unidadMedida.getcUnidadMedidaCodigo();
		this.vUnidadMedidaDescripcion = unidadMedida.getvUnidadMedidaDescripcion();
	}

	public int getiUnidadMedidaId() {
		return iUnidadMedidaId;
	}

	public void setiUnidadMedidaId(int iUnidadMedidaId) {
		this.iUnidadMedidaId = iUnidadMedidaId;
	}

	public String getcEstadoCodigo() {
		return cEstadoCodigo;
	}

	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}

	public String getcUnidadMedidaCodigo() {
		return cUnidadMedidaCodigo;
	}

	public void setcUnidadMedidaCodigo(String cUnidadMedidaCodigo) {
		this.cUnidadMedidaCodigo = cUnidadMedidaCodigo;
	}

	public String getvUnidadMedidaDescripcion() {
		return vUnidadMedidaDescripcion;
	}

	public void setvUnidadMedidaDescripcion(String vUnidadMedidaDescripcion) {
		this.vUnidadMedidaDescripcion = vUnidadMedidaDescripcion;
	}
	
}