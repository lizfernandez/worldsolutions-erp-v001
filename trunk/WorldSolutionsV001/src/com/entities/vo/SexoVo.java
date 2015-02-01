package com.entities.vo;

import java.io.Serializable;
import java.util.List;

public class SexoVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iSexoId;
	private String cSexoCodigo;
	private String vSexoDescripcion;
	private List<PersonalVo> personals;
	private String cEstadoCodigo;
	
    public SexoVo() {
    }

    
	public SexoVo(int iSexoId, String vSexoDescripcion) {
		super();
		this.iSexoId = iSexoId;
		this.vSexoDescripcion = vSexoDescripcion;
	}


	/**
	 * @return the iSexoId
	 */
	public int getiSexoId() {
		return iSexoId;
	}

	/**
	 * @param iSexoId the iSexoId to set
	 */
	public void setiSexoId(int iSexoId) {
		this.iSexoId = iSexoId;
	}

	/**
	 * @return the cSexoCodigo
	 */
	public String getcSexoCodigo() {
		return cSexoCodigo;
	}

	/**
	 * @param cSexoCodigo the cSexoCodigo to set
	 */
	public void setcSexoCodigo(String cSexoCodigo) {
		this.cSexoCodigo = cSexoCodigo;
	}

	/**
	 * @return the vSexoDescripcion
	 */
	public String getvSexoDescripcion() {
		return vSexoDescripcion;
	}

	/**
	 * @param vSexoDescripcion the vSexoDescripcion to set
	 */
	public void setvSexoDescripcion(String vSexoDescripcion) {
		this.vSexoDescripcion = vSexoDescripcion;
	}

	/**
	 * @return the personals
	 **/
	public List<PersonalVo> getPersonals() {
		return personals;
	}

	/**
	 * @param personals the personals to set
	 **/	 
	public void setPersonals(List<PersonalVo> personals) {
		this.personals = personals;
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

	
	
}