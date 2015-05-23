package com.entities.vo;

import java.util.Date;

import com.entities.Clasificacioncliente;

public class ClasificacionclienteVo {

	private int iClasificacionClienteId;
	private String cEstadoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private float fDescuento;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
	private String vNombre;

	public ClasificacionclienteVo() {
		// TODO Auto-generated constructor stub
	}

	
	
	public ClasificacionclienteVo(Clasificacioncliente clasificacioncliente) {
		super();
		this.iClasificacionClienteId = clasificacioncliente.getiClasificacionClienteId();
		this.cEstadoCodigo = clasificacioncliente.getcEstadoCodigo();
		this.dFechaActualiza = clasificacioncliente.getdFechaActualiza();
		this.dFechaInserta = clasificacioncliente.getdFechaInserta();
		this.fDescuento = clasificacioncliente.getfDescuento();
		this.iUsuarioActualizaId = clasificacioncliente.getiUsuarioActualizaId();
		this.iUsuarioInsertaId = clasificacioncliente.getiUsuarioInsertaId();
		this.vNombre = clasificacioncliente.getvNombre();
		
	}
	
	public int getiClasificacionClienteId() {
		return iClasificacionClienteId;
	}

	public void setiClasificacionClienteId(int iClasificacionClienteId) {
		this.iClasificacionClienteId = iClasificacionClienteId;
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

	public float getfDescuento() {
		return fDescuento;
	}

	public void setfDescuento(float fDescuento) {
		this.fDescuento = fDescuento;
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

	public String getvNombre() {
		return vNombre;
	}

	public void setvNombre(String vNombre) {
		this.vNombre = vNombre;
	}
	
	
	
}
