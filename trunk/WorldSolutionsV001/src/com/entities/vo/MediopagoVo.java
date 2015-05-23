package com.entities.vo;

import java.io.Serializable;

import com.entities.Mediopago;

public class MediopagoVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iMedioPagoId;
	private String cEstadoCodigo;
	private String cMedioPagoCodigo;
	private String vNombre;
	
	public MediopagoVo() {
		// TODO Auto-generated constructor stub
	}

	public MediopagoVo(Mediopago medioPago) {
		
		this.iMedioPagoId = medioPago.getiMedioPagoId();
		this.cEstadoCodigo = medioPago.getcEstadoCodigo();
		this.cMedioPagoCodigo = medioPago.getcMedioPagoCodigo();
		this.vNombre = medioPago.getvNombre();
	}

	public int getiMedioPagoId() {
		return iMedioPagoId;
	}

	public void setiMedioPagoId(int iMedioPagoId) {
		this.iMedioPagoId = iMedioPagoId;
	}

	public String getcEstadoCodigo() {
		return cEstadoCodigo;
	}

	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}

	public String getcMedioPagoCodigo() {
		return cMedioPagoCodigo;
	}

	public void setcMedioPagoCodigo(String cMedioPagoCodigo) {
		this.cMedioPagoCodigo = cMedioPagoCodigo;
	}

	public String getvNombre() {
		return vNombre;
	}

	public void setvNombre(String vNombre) {
		this.vNombre = vNombre;
	}
	
	
	
}
