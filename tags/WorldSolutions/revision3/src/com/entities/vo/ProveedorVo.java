package com.entities.vo;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ProveedorVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iProveedorId;
	private String cEstadoCodigo;
	private String cProveedorCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private String iPoblacionId;
	private int iUsuarioInsertaId;
	private int iUsuarioModificaId;
	private BigDecimal nProveedorNumeroDocumento;
	private String vProveedorDireccion;
	private String vProveedorRazonSocial;
	private String vProveedorTelefono;
	private List<EstadocuentaproveedorVo> estadocuentaproveedors;
	private List<IngresoproductoVo> ingresoproductos;
	private List<SalidaproductoVo> salidaproductos;

    public ProveedorVo() {
    }

	/**
	 * @return the iProveedorId
	 */
	public int getiProveedorId() {
		return iProveedorId;
	}

	/**
	 * @param iProveedorId the iProveedorId to set
	 */
	public void setiProveedorId(int iProveedorId) {
		this.iProveedorId = iProveedorId;
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
	 * @return the cProveedorCodigo
	 */
	public String getcProveedorCodigo() {
		return cProveedorCodigo;
	}

	/**
	 * @param cProveedorCodigo the cProveedorCodigo to set
	 */
	public void setcProveedorCodigo(String cProveedorCodigo) {
		this.cProveedorCodigo = cProveedorCodigo;
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
	 * @return the iPoblacionId
	 */
	public String getiPoblacionId() {
		return iPoblacionId;
	
	}
	/**
	 * @param iPoblacionId the iPoblacionId to set
	 */
	public void setiPoblacionId(String iPoblacionId) {
		this.iPoblacionId = iPoblacionId;
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
	 * @return the nProveedorNumeroDocumento
	 */
	public BigDecimal getnProveedorNumeroDocumento() {
		return nProveedorNumeroDocumento;
	}

	/**
	 * @param nProveedorNumeroDocumento the nProveedorNumeroDocumento to set
	 */
	public void setnProveedorNumeroDocumento(BigDecimal nProveedorNumeroDocumento) {
		this.nProveedorNumeroDocumento = nProveedorNumeroDocumento;
	}

	/**
	 * @return the vProveedorDireccion
	 */
	public String getvProveedorDireccion() {
		return vProveedorDireccion;
	}

	/**
	 * @param vProveedorDireccion the vProveedorDireccion to set
	 */
	public void setvProveedorDireccion(String vProveedorDireccion) {
		this.vProveedorDireccion = vProveedorDireccion;
	}

	/**
	 * @return the vProveedorRazonSocial
	 */
	public String getvProveedorRazonSocial() {
		return vProveedorRazonSocial;
	}

	/**
	 * @param vProveedorRazonSocial the vProveedorRazonSocial to set
	 */
	public void setvProveedorRazonSocial(String vProveedorRazonSocial) {
		this.vProveedorRazonSocial = vProveedorRazonSocial;
	}

	/**
	 * @return the vProveedorTelefono
	 */
	public String getvProveedorTelefono() {
		return vProveedorTelefono;
	}

	/**
	 * @param vProveedorTelefono the vProveedorTelefono to set
	 */
	public void setvProveedorTelefono(String vProveedorTelefono) {
		this.vProveedorTelefono = vProveedorTelefono;
	}

	/**
	 * @return the estadocuentaproveedors
	 */
	public List<EstadocuentaproveedorVo> getEstadocuentaproveedors() {
		return estadocuentaproveedors;
	}

	/**
	 * @param estadocuentaproveedors the estadocuentaproveedors to set
	 */
	public void setEstadocuentaproveedors(
			List<EstadocuentaproveedorVo> estadocuentaproveedors) {
		this.estadocuentaproveedors = estadocuentaproveedors;
	}

	/**
	 * @return the ingresoproductos
	 */
	public List<IngresoproductoVo> getIngresoproductos() {
		return ingresoproductos;
	}

	/**
	 * @param ingresoproductos the ingresoproductos to set
	 */
	public void setIngresoproductos(List<IngresoproductoVo> ingresoproductos) {
		this.ingresoproductos = ingresoproductos;
	}

	/**
	 * @return the salidaproductos
	 */
	public List<SalidaproductoVo> getSalidaproductos() {
		return salidaproductos;
	}

	/**
	 * @param salidaproductos the salidaproductos to set
	 */
	public void setSalidaproductos(List<SalidaproductoVo> salidaproductos) {
		this.salidaproductos = salidaproductos;
	}
}

	