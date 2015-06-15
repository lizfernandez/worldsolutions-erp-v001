package com.entities.vo;

import java.math.BigInteger;
import java.util.Date;

import com.entitie.Persona;

public class PersonaVo {
	private static final long serialVersionUID = 1L;

	private String iPersonaId;
	private String cEstadoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private Date dFechaNacimiento;
	private float fSueldo;
	private BigInteger iUsuarioActualizaId;
	private BigInteger iUsuarioInsertaId;
	private String vApellidos;
	private String vDireccionEnvio;
	private String vEmail;
	private String vNombres;
	private String vUbicacion;

	public PersonaVo() {
	}

	
	public PersonaVo(Persona persona) {
		super();
		this.iPersonaId = persona.getiPersonaId();
		this.cEstadoCodigo = persona.getcEstadoCodigo();
		this.dFechaActualiza = persona.getdFechaActualiza();
		this.dFechaInserta = persona.getdFechaInserta();
		this.dFechaNacimiento = persona.getdFechaNacimiento();
		this.fSueldo = persona.getfSueldo();
		this.iUsuarioActualizaId = persona.getiUsuarioActualizaId();
		this.iUsuarioInsertaId = persona.getiUsuarioInsertaId();
		this.vApellidos = persona.getvApellidos();
		this.vDireccionEnvio = persona.getvDireccionEnvio();
		this.vEmail = persona.getvEmail();
		this.vNombres = persona.getvNombres();
		this.vUbicacion = persona.getvUbicacion();
	}


	/**
	 * @return the iPersonaId
	 */
	public String getiPersonaId() {
		return iPersonaId;
	}

	/**
	 * @param iPersonaId the iPersonaId to set
	 */
	public void setiPersonaId(String iPersonaId) {
		this.iPersonaId = iPersonaId;
	}

	/**
	 * @return the cEstadoCodigo
	 */
	public String getcEstadoCodigo() {
		return cEstadoCodigo;
	}

	/**
	 * @param cEstadoCodigo the cEstadoCodigo to set
	 */
	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}

	/**
	 * @return the dFechaActualiza
	 */
	public Date getdFechaActualiza() {
		return dFechaActualiza;
	}

	/**
	 * @param dFechaActualiza the dFechaActualiza to set
	 */
	public void setdFechaActualiza(Date dFechaActualiza) {
		this.dFechaActualiza = dFechaActualiza;
	}

	/**
	 * @return the dFechaInserta
	 */
	public Date getdFechaInserta() {
		return dFechaInserta;
	}

	/**
	 * @param dFechaInserta the dFechaInserta to set
	 */
	public void setdFechaInserta(Date dFechaInserta) {
		this.dFechaInserta = dFechaInserta;
	}

	/**
	 * @return the dFechaNacimiento
	 */
	public Date getdFechaNacimiento() {
		return dFechaNacimiento;
	}

	/**
	 * @param dFechaNacimiento the dFechaNacimiento to set
	 */
	public void setdFechaNacimiento(Date dFechaNacimiento) {
		this.dFechaNacimiento = dFechaNacimiento;
	}

	/**
	 * @return the fSueldo
	 */
	public float getfSueldo() {
		return fSueldo;
	}

	/**
	 * @param fSueldo the fSueldo to set
	 */
	public void setfSueldo(float fSueldo) {
		this.fSueldo = fSueldo;
	}

	/**
	 * @return the iUsuarioActualizaId
	 */
	public BigInteger getiUsuarioActualizaId() {
		return iUsuarioActualizaId;
	}

	/**
	 * @param iUsuarioActualizaId the iUsuarioActualizaId to set
	 */
	public void setiUsuarioActualizaId(BigInteger iUsuarioActualizaId) {
		this.iUsuarioActualizaId = iUsuarioActualizaId;
	}

	/**
	 * @return the iUsuarioInsertaId
	 */
	public BigInteger getiUsuarioInsertaId() {
		return iUsuarioInsertaId;
	}

	/**
	 * @param iUsuarioInsertaId the iUsuarioInsertaId to set
	 */
	public void setiUsuarioInsertaId(BigInteger iUsuarioInsertaId) {
		this.iUsuarioInsertaId = iUsuarioInsertaId;
	}

	/**
	 * @return the vApellidos
	 */
	public String getvApellidos() {
		return vApellidos;
	}

	/**
	 * @param vApellidos the vApellidos to set
	 */
	public void setvApellidos(String vApellidos) {
		this.vApellidos = vApellidos;
	}

	/**
	 * @return the vDireccionEnvio
	 */
	public String getvDireccionEnvio() {
		return vDireccionEnvio;
	}

	/**
	 * @param vDireccionEnvio the vDireccionEnvio to set
	 */
	public void setvDireccionEnvio(String vDireccionEnvio) {
		this.vDireccionEnvio = vDireccionEnvio;
	}

	/**
	 * @return the vEmail
	 */
	public String getvEmail() {
		return vEmail;
	}

	/**
	 * @param vEmail the vEmail to set
	 */
	public void setvEmail(String vEmail) {
		this.vEmail = vEmail;
	}

	/**
	 * @return the vNombres
	 */
	public String getvNombres() {
		return vNombres;
	}

	/**
	 * @param vNombres the vNombres to set
	 */
	public void setvNombres(String vNombres) {
		this.vNombres = vNombres;
	}

	/**
	 * @return the vUbicacion
	 */
	public String getvUbicacion() {
		return vUbicacion;
	}

	/**
	 * @param vUbicacion the vUbicacion to set
	 */
	public void setvUbicacion(String vUbicacion) {
		this.vUbicacion = vUbicacion;
	}
}
