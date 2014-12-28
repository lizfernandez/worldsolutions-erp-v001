package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@Table(name="empresa")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int iEmpresaId;

	@Column(nullable=false, length=2)
	private String cEstadoCodigo;

    @Temporal( TemporalType.DATE)
	private Date dFechaActualiza;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date dFechaInserta;

	private int iUsuarioActualizaId;

	@Column(nullable=false)
	private int iUsuarioInsertaId;

	@Column(nullable=false, precision=10)
	private BigDecimal nEmpresaRUC;

	@Column(nullable=false, length=45)
	private String vEmpresaDireccion;

	@Column(nullable=false, length=45)
	private String vEmpresaNombre;

	@Column(nullable=false, length=45)
	private String vEmpresaTelefono;

    public Empresa() {
    }

	public int getIEmpresaId() {
		return this.iEmpresaId;
	}

	public void setIEmpresaId(int iEmpresaId) {
		this.iEmpresaId = iEmpresaId;
	}

	public String getCEstadoCodigo() {
		return this.cEstadoCodigo;
	}

	public void setCEstadoCodigo(String cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}

	public Date getDFechaActualiza() {
		return this.dFechaActualiza;
	}

	public void setDFechaActualiza(Date dFechaActualiza) {
		this.dFechaActualiza = dFechaActualiza;
	}

	public Date getDFechaInserta() {
		return this.dFechaInserta;
	}

	public void setDFechaInserta(Date dFechaInserta) {
		this.dFechaInserta = dFechaInserta;
	}

	public int getIUsuarioActualizaId() {
		return this.iUsuarioActualizaId;
	}

	public void setIUsuarioActualizaId(int iUsuarioActualizaId) {
		this.iUsuarioActualizaId = iUsuarioActualizaId;
	}

	public int getIUsuarioInsertaId() {
		return this.iUsuarioInsertaId;
	}

	public void setIUsuarioInsertaId(int iUsuarioInsertaId) {
		this.iUsuarioInsertaId = iUsuarioInsertaId;
	}

	public BigDecimal getNEmpresaRUC() {
		return this.nEmpresaRUC;
	}

	public void setNEmpresaRUC(BigDecimal nEmpresaRUC) {
		this.nEmpresaRUC = nEmpresaRUC;
	}

	public String getVEmpresaDireccion() {
		return this.vEmpresaDireccion;
	}

	public void setVEmpresaDireccion(String vEmpresaDireccion) {
		this.vEmpresaDireccion = vEmpresaDireccion;
	}

	public String getVEmpresaNombre() {
		return this.vEmpresaNombre;
	}

	public void setVEmpresaNombre(String vEmpresaNombre) {
		this.vEmpresaNombre = vEmpresaNombre;
	}

	public String getVEmpresaTelefono() {
		return this.vEmpresaTelefono;
	}

	public void setVEmpresaTelefono(String vEmpresaTelefono) {
		this.vEmpresaTelefono = vEmpresaTelefono;
	}

}