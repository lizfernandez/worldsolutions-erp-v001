package com.entities.vo;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

public class UsuarioVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iUsuarioId;
	private String cEstadoCodigo;
	private String cUsuarioCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
	private String vUsuarioLogin;
	private String vUsuarioPassword;
	private List<SessionVo> sessions;
	private PerfilVo perfil;
	private PersonalVo personal;
	private List<VentaVo> ventas;

    public UsuarioVo() {
    }

	

	/**
	 * @return the iUsuarioId
	 */
	public int getiUsuarioId() {
		return iUsuarioId;
	}



	/**
	 * @param iUsuarioId the iUsuarioId to set
	 */
	public void setiUsuarioId(int iUsuarioId) {
		this.iUsuarioId = iUsuarioId;
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
	 * @return the cUsuarioCodigo
	 */
	public String getcUsuarioCodigo() {
		return cUsuarioCodigo;
	}



	/**
	 * @param cUsuarioCodigo the cUsuarioCodigo to set
	 */
	public void setcUsuarioCodigo(String cUsuarioCodigo) {
		this.cUsuarioCodigo = cUsuarioCodigo;
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
	 * @return the iUsuarioActualizaId
	 */
	public int getiUsuarioActualizaId() {
		return iUsuarioActualizaId;
	}



	/**
	 * @param iUsuarioActualizaId the iUsuarioActualizaId to set
	 */
	public void setiUsuarioActualizaId(int iUsuarioActualizaId) {
		this.iUsuarioActualizaId = iUsuarioActualizaId;
	}



	/**
	 * @return the iUsuarioInsertaId
	 */
	public int getiUsuarioInsertaId() {
		return iUsuarioInsertaId;
	}



	/**
	 * @param iUsuarioInsertaId the iUsuarioInsertaId to set
	 */
	public void setiUsuarioInsertaId(int iUsuarioInsertaId) {
		this.iUsuarioInsertaId = iUsuarioInsertaId;
	}



	/**
	 * @return the vUsuarioLogin
	 */
	public String getvUsuarioLogin() {
		return vUsuarioLogin;
	}



	/**
	 * @param vUsuarioLogin the vUsuarioLogin to set
	 */
	public void setvUsuarioLogin(String vUsuarioLogin) {
		this.vUsuarioLogin = vUsuarioLogin;
	}



	/**
	 * @return the vUsuarioPassword
	 */
	public String getvUsuarioPassword() {
		return vUsuarioPassword;
	}



	/**
	 * @param vUsuarioPassword the vUsuarioPassword to set
	 */
	public void setvUsuarioPassword(String vUsuarioPassword) {
		this.vUsuarioPassword = vUsuarioPassword;
	}



	public List<SessionVo> getSessions() {
		return this.sessions;
	}

	public void setSessions(List<SessionVo> sessions) {
		this.sessions = sessions;
	}
	
	public PerfilVo getPerfil() {
		return this.perfil;
	}

	public void setPerfil(PerfilVo perfil) {
		this.perfil = perfil;
	}
	/**/
	public PersonalVo getPersonal() {
		return this.personal;
	}

	public void setPersonal(PersonalVo personal) {
		this.personal = personal;
	}
	
	public List<VentaVo> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<VentaVo> ventas) {
		this.ventas = ventas;
	}
	
}