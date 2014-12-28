package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the session database table.
 * 
 */
@Entity
@Table(name="session")
public class Session implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int iSessionId;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date dSessionFechaFinal;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date dSessionFechaInicio;

	@Column(nullable=false, length=45)
	private String vSessionIp;

	//bi-directional many-to-one association to Usuario
    @ManyToOne
	@JoinColumn(name="iUsuarioId", nullable=false)
	private Usuario usuario;

    public Session() {
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}