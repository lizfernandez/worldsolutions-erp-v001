package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iPersonaId;

	private String cEstadoCodigo;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaInserta;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaNacimiento;

	private float fSueldo;

	private BigInteger iUsuarioActualizaId;

	private BigInteger iUsuarioInsertaId;

	private String vApellidos;

	private String vDireccionEnvio;

	private String vEmail;

	private String vNombres;

	private String vUbicacion;

    public Persona() {
    }

	public String getIPersonaId() {
		return this.iPersonaId;
	}

	public void setIPersonaId(String iPersonaId) {
		this.iPersonaId = iPersonaId;
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

	public Date getDFechaNacimiento() {
		return this.dFechaNacimiento;
	}

	public void setDFechaNacimiento(Date dFechaNacimiento) {
		this.dFechaNacimiento = dFechaNacimiento;
	}

	public float getFSueldo() {
		return this.fSueldo;
	}

	public void setFSueldo(float fSueldo) {
		this.fSueldo = fSueldo;
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

	public String getVApellidos() {
		return this.vApellidos;
	}

	public void setVApellidos(String vApellidos) {
		this.vApellidos = vApellidos;
	}

	public String getVDireccionEnvio() {
		return this.vDireccionEnvio;
	}

	public void setVDireccionEnvio(String vDireccionEnvio) {
		this.vDireccionEnvio = vDireccionEnvio;
	}

	public String getVEmail() {
		return this.vEmail;
	}

	public void setVEmail(String vEmail) {
		this.vEmail = vEmail;
	}

	public String getVNombres() {
		return this.vNombres;
	}

	public void setVNombres(String vNombres) {
		this.vNombres = vNombres;
	}

	public String getVUbicacion() {
		return this.vUbicacion;
	}

	public void setVUbicacion(String vUbicacion) {
		this.vUbicacion = vUbicacion;
	}

}