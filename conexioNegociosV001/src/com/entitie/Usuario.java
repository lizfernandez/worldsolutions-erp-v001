package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iUsuarioId;

	private String cEstadoCodigo;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private BigInteger iPerfilId;

	private BigInteger iPersonaId;

	private BigInteger iUsuarioActualizaId;

	private BigInteger iUsuarioInsertaId;

	private String vContrasena;

	private String vIdentificador;

	private String vUsuario;

    public Usuario() {
    }

	public String getIUsuarioId() {
		return this.iUsuarioId;
	}

	public void setIUsuarioId(String iUsuarioId) {
		this.iUsuarioId = iUsuarioId;
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

	public BigInteger getIPerfilId() {
		return this.iPerfilId;
	}

	public void setIPerfilId(BigInteger iPerfilId) {
		this.iPerfilId = iPerfilId;
	}

	public BigInteger getIPersonaId() {
		return this.iPersonaId;
	}

	public void setIPersonaId(BigInteger iPersonaId) {
		this.iPersonaId = iPersonaId;
	}

	public BigInteger getIUsuarioActualizaId() {
		return this.iUsuarioActualizaId;
	}

	public void setIUsuarioActualizaId(BigInteger iUsuarioActualizaId) {
		this.iUsuarioActualizaId = iUsuarioActualizaId;
	}

	public BigInteger getIUsuarioInsertaId() {
		return this.iUsuarioInsertaId;
	}

	public void setIUsuarioInsertaId(BigInteger iUsuarioInsertaId) {
		this.iUsuarioInsertaId = iUsuarioInsertaId;
	}

	public String getVContrasena() {
		return this.vContrasena;
	}

	public void setVContrasena(String vContrasena) {
		this.vContrasena = vContrasena;
	}

	public String getVIdentificador() {
		return this.vIdentificador;
	}

	public void setVIdentificador(String vIdentificador) {
		this.vIdentificador = vIdentificador;
	}

	public String getVUsuario() {
		return this.vUsuario;
	}

	public void setVUsuario(String vUsuario) {
		this.vUsuario = vUsuario;
	}

}