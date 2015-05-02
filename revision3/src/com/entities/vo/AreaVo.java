package com.entities.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.entities.Personal;

public class AreaVo implements Serializable{

	
	private static final long serialVersionUID = 1L;	
	private int iAreaId;
	private String cAreaCodigo;
	private String cEstadoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private int iUsuarioInsertaId;
	private int iUsuarioModificaId;
	private String vAreaDescripcion;
	private List<PersonalVo> personals;

    public AreaVo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the iAreaId
	 */
	public int getiAreaId() {
		return iAreaId;
	}

	/**
	 * @param iAreaId the iAreaId to set
	 */
	public void setiAreaId(int iAreaId) {
		this.iAreaId = iAreaId;
	}

	/**
	 * @return the cAreaCodigo
	 */
	public String getcAreaCodigo() {
		return cAreaCodigo;
	}

	/**
	 * @param cAreaCodigo the cAreaCodigo to set
	 */
	public void setcAreaCodigo(String cAreaCodigo) {
		this.cAreaCodigo = cAreaCodigo;
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
	 * @return the iUsuarioModificaId
	 */
	public int getiUsuarioModificaId() {
		return iUsuarioModificaId;
	}

	/**
	 * @param iUsuarioModificaId the iUsuarioModificaId to set
	 */
	public void setiUsuarioModificaId(int iUsuarioModificaId) {
		this.iUsuarioModificaId = iUsuarioModificaId;
	}

	/**
	 * @return the vAreaDescripcion
	 */
	public String getvAreaDescripcion() {
		return vAreaDescripcion;
	}

	/**
	 * @param vAreaDescripcion the vAreaDescripcion to set
	 */
	public void setvAreaDescripcion(String vAreaDescripcion) {
		this.vAreaDescripcion = vAreaDescripcion;
	}

	/**
	 * @return the personals
	 */
	public List<PersonalVo> getPersonals() {
		return personals;
	}

	/**
	 * @param personals the personals to set
	 */
	public void setPersonals(List<PersonalVo> personals) {
		this.personals = personals;
	}
    
    
    
}
