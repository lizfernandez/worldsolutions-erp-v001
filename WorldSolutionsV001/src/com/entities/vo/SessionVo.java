package com.entities.vo;

import java.io.Serializable;

import java.util.Date;

public class SessionVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iSessionId;
	private Date dSessionFechaFinal;
	private Date dSessionFechaInicio;
	private String vSessionIp;
	private UsuarioVo usuario;

    public SessionVo() {
    }

	public int getISessionId() {
		return this.iSessionId;
	}

	public void setISessionId(int iSessionId) {
		this.iSessionId = iSessionId;
	}

	public Date getDSessionFechaFinal() {
		return this.dSessionFechaFinal;
	}

	public void setDSessionFechaFinal(Date dSessionFechaFinal) {
		this.dSessionFechaFinal = dSessionFechaFinal;
	}

	public Date getDSessionFechaInicio() {
		return this.dSessionFechaInicio;
	}

	public void setDSessionFechaInicio(Date dSessionFechaInicio) {
		this.dSessionFechaInicio = dSessionFechaInicio;
	}

	public String getVSessionIp() {
		return this.vSessionIp;
	}

	public void setVSessionIp(String vSessionIp) {
		this.vSessionIp = vSessionIp;
	}

	public UsuarioVo getUsuario() {
		return this.usuario;
	}

	public void setUsuario(UsuarioVo usuario) {
		this.usuario = usuario;
	}
	
}