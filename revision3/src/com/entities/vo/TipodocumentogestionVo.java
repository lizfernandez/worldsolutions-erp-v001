package com.entities.vo;

import java.io.Serializable;

public class TipodocumentogestionVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iTipoDocumentoGestionId;
	private String cTipoDocumentoGestionCodigo;
	private String vTipoDocumentoDescripcion;
	
    public TipodocumentogestionVo() {
    }
    public TipodocumentogestionVo(int iTipoDocumentoId, String vTipoDocuumentoDescripcion) {
		super();
		this.iTipoDocumentoGestionId = iTipoDocumentoId;
		this.vTipoDocumentoDescripcion = vTipoDocuumentoDescripcion;
	}
	/**
	 * @return the iTipoDocumentoGestionId
	 */
	public int getiTipoDocumentoGestionId() {
		return iTipoDocumentoGestionId;
	}
	/**
	 * @param iTipoDocumentoGestionId the iTipoDocumentoGestionId to set
	 */
	public void setiTipoDocumentoGestionId(int iTipoDocumentoGestionId) {
		this.iTipoDocumentoGestionId = iTipoDocumentoGestionId;
	}
	/**
	 * @return the cTipoDocumentoGestionCodigo
	 */
	public String getcTipoDocumentoGestionCodigo() {
		return cTipoDocumentoGestionCodigo;
	}
	/**
	 * @param cTipoDocumentoGestionCodigo the cTipoDocumentoGestionCodigo to set
	 */
	public void setcTipoDocumentoGestionCodigo(String cTipoDocumentoGestionCodigo) {
		this.cTipoDocumentoGestionCodigo = cTipoDocumentoGestionCodigo;
	}
	/**
	 * @return the vTipoDocumentoDescripcion
	 */
	public String getvTipoDocumentoDescripcion() {
		return vTipoDocumentoDescripcion;
	}
	/**
	 * @param vTipoDocumentoDescripcion the vTipoDocumentoDescripcion to set
	 */
	public void setvTipoDocumentoDescripcion(String vTipoDocumentoDescripcion) {
		this.vTipoDocumentoDescripcion = vTipoDocumentoDescripcion;
	}




}