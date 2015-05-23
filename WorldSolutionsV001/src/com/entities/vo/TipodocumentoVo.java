package com.entities.vo;

import java.io.Serializable;

import com.entities.Tipodocumento;

public class TipodocumentoVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iTipoDocumentoId;
	private String cTipoDocumentoCodigo;
	private String vGestion;
	private String vTipoDocuumentoDescripcion;
	private String cEstadoCodigo;

    public TipodocumentoVo() {
    	
    }
    
	public TipodocumentoVo(Tipodocumento tipodocumento) {
		this.iTipoDocumentoId = tipodocumento.getiTipoDocumentoId();
		this.vTipoDocuumentoDescripcion = tipodocumento.getvTipoDocuumentoDescripcion();
	}

	/**
	 * @return the iTipoDocumentoId
	 */
		public int getiTipoDocumentoId() {
		return iTipoDocumentoId;
	}

	/**
	 * @param iTipoDocumentoId the iTipoDocumentoId to set
	 */
	public void setiTipoDocumentoId(int iTipoDocumentoId) {
		this.iTipoDocumentoId = iTipoDocumentoId;
	}

	/**
	 * @return the cTipoDocumentoCodigo
	 */
	public String getcTipoDocumentoCodigo() {
		return cTipoDocumentoCodigo;
	}

	/**
	 * @param cTipoDocumentoCodigo the cTipoDocumentoCodigo to set
	 */
	public void setcTipoDocumentoCodigo(String cTipoDocumentoCodigo) {
		this.cTipoDocumentoCodigo = cTipoDocumentoCodigo;
	}

	/**
	 * @return the vGestion
	 */
	public String getvGestion() {
		return vGestion;
	}

	/**
	 * @param vGestion the vGestion to set
	 */
	public void setvGestion(String vGestion) {
		this.vGestion = vGestion;
	}

	/**
	 * @return the vTipoDocuumentoDescripcion
	 */
	public String getvTipoDocuumentoDescripcion() {
		return vTipoDocuumentoDescripcion;
	}

	/**
	 * @param vTipoDocuumentoDescripcion the vTipoDocuumentoDescripcion to set
	 */
	public void setvTipoDocuumentoDescripcion(String vTipoDocuumentoDescripcion) {
		this.vTipoDocuumentoDescripcion = vTipoDocuumentoDescripcion;
	}

	/**
	 * @return the ingresoproductos
	 *//*
	public List<Ingresoproducto> getIngresoproductos() {
		return ingresoproductos;
	}

	*//**
	 * @param ingresoproductos the ingresoproductos to set
	 *//*
	public void setIngresoproductos(List<Ingresoproducto> ingresoproductos) {
		this.ingresoproductos = ingresoproductos;
	}
*/
	/**
	 * @return the personals
	
	public List<Personal> getPersonals() {
		return personals;
	} */

	/**
	 * @param personals the personals to set
	 
	public void setPersonals(List<Personal> personals) {
		this.personals = personals;
	}*/

	/**
	 * @return the ventas
	 *//*
	public List<Venta> getVentas() {
		return ventas;
	}

	*//**
	 * @param ventas the ventas to set
	 *//*
	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}*/

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