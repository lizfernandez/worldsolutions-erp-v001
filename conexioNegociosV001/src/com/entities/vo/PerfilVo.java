package com.entities.vo;

import java.math.BigInteger;
import java.util.Date;

import com.entitie.Perfil;

public class PerfilVo {
	private static final long serialVersionUID = 1L;

	private String iPerfilId;
	private String cEstadoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private BigInteger iUsuarioActualizaId;
	private BigInteger iUsuarioInsertaId;
	private String vNombre;

	public PerfilVo() {
	}
	
	

	public PerfilVo(Perfil perfil) {
		this.iPerfilId = perfil.getiPerfilId();
		this.cEstadoCodigo = perfil.getcEstadoCodigo();
		this.dFechaActualiza = perfil.getdFechaActualiza();
		this.dFechaInserta = perfil.getdFechaInserta();
		this.iUsuarioActualizaId = perfil.getiUsuarioActualizaId();
		this.iUsuarioInsertaId = perfil.getiUsuarioInsertaId();
		this.vNombre = perfil.getvNombre();
	}



	/**
	 * @return the iPerfilId
	 */
	public String getiPerfilId() {
		return iPerfilId;
	}

	/**
	 * @param iPerfilId the iPerfilId to set
	 */
	public void setiPerfilId(String iPerfilId) {
		this.iPerfilId = iPerfilId;
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
	 * @return the vNombre
	 */
	public String getvNombre() {
		return vNombre;
	}

	/**
	 * @param vNombre the vNombre to set
	 */
	public void setvNombre(String vNombre) {
		this.vNombre = vNombre;
	}

	
}
