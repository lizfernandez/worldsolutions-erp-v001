package com.entities.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.entities.Personal;

public class PersonalVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iPersonalId;
	private String cEstadoCodigo;
	private String cPersonalCodigo;
	private Date dFechaAcualiza;
	private Date dFechaInserta;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
	private BigDecimal nPersonalNumeroDocumento;
	private String vPersonalApellidoMaterno;
	private String vPersonalApellidoPaterno;
	private String vPersonalNombres;
	private AreaVo area;
	private OcupacionVo ocupacion;
    private float fSueldo;
	private int iSexoId;
	private TipodocumentoVo tipodocumento;

    public PersonalVo() {
    }

	public PersonalVo(Personal personal) {
		this.iPersonalId = personal.getiPersonalId();
		this.cEstadoCodigo = personal.getcEstadoCodigo();
		this.cPersonalCodigo = personal.getcPersonalCodigo();
		this.dFechaAcualiza = personal.getdFechaAcualiza();
		this.dFechaInserta = personal.getdFechaInserta();
		this.iUsuarioActualizaId = personal.getiUsuarioActualizaId();
		this.iUsuarioInsertaId = personal.getiUsuarioInsertaId();
		this.nPersonalNumeroDocumento = personal.getnPersonalNumeroDocumento();
		this.vPersonalApellidoMaterno = personal.getvPersonalApellidoMaterno();
		this.vPersonalApellidoPaterno = personal.getvPersonalApellidoPaterno();
		this.vPersonalNombres = personal.getvPersonalNombres();
		this.area = new AreaVo(personal.getArea());
		this.ocupacion = new OcupacionVo(personal.getOcupacion());
		this.fSueldo = personal.getfSueldo();
		this.iSexoId = personal.getiSexoId();
		this.tipodocumento = new TipodocumentoVo(personal.getTipodocumento());
	}

	/**
	 * @return the iPersonalId
	 */
	public int getiPersonalId() {
		return iPersonalId;
	}

	/**
	 * @param iPersonalId the iPersonalId to set
	 */
	public void setiPersonalId(int iPersonalId) {
		this.iPersonalId = iPersonalId;
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
	 * @return the cPersonalCodigo
	 */
	public String getcPersonalCodigo() {
		return cPersonalCodigo;
	}

	/**
	 * @param cPersonalCodigo the cPersonalCodigo to set
	 */
	public void setcPersonalCodigo(String cPersonalCodigo) {
		this.cPersonalCodigo = cPersonalCodigo;
	}

	/**
	 * @return the dFechaAcualiza
	 */
	public Date getdFechaAcualiza() {
		return dFechaAcualiza;
	}

	/**
	 * @param dFechaAcualiza the dFechaAcualiza to set
	 */
	public void setdFechaAcualiza(Date dFechaAcualiza) {
		this.dFechaAcualiza = dFechaAcualiza;
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
	 * @return the nPersonalNumeroDocumento
	 */
	public BigDecimal getnPersonalNumeroDocumento() {
		return nPersonalNumeroDocumento;
	}

	/**
	 * @param nPersonalNumeroDocumento the nPersonalNumeroDocumento to set
	 */
	public void setnPersonalNumeroDocumento(BigDecimal nPersonalNumeroDocumento) {
		this.nPersonalNumeroDocumento = nPersonalNumeroDocumento;
	}

	/**
	 * @return the vPersonalApellidoMaterno
	 */
	public String getvPersonalApellidoMaterno() {
		return vPersonalApellidoMaterno;
	}

	/**
	 * @param vPersonalApellidoMaterno the vPersonalApellidoMaterno to set
	 */
	public void setvPersonalApellidoMaterno(String vPersonalApellidoMaterno) {
		this.vPersonalApellidoMaterno = vPersonalApellidoMaterno;
	}

	/**
	 * @return the vPersonalApellidoPaterno
	 */
	public String getvPersonalApellidoPaterno() {
		return vPersonalApellidoPaterno;
	}

	/**
	 * @param vPersonalApellidoPaterno the vPersonalApellidoPaterno to set
	 */
	public void setvPersonalApellidoPaterno(String vPersonalApellidoPaterno) {
		this.vPersonalApellidoPaterno = vPersonalApellidoPaterno;
	}

	/**
	 * @return the vPersonalNombres
	 */
	public String getvPersonalNombres() {
		return vPersonalNombres;
	}

	/**
	 * @param vPersonalNombres the vPersonalNombres to set
	 */
	public void setvPersonalNombres(String vPersonalNombres) {
		this.vPersonalNombres = vPersonalNombres;
	}

	/**
	 * @return the area
	 */
	public AreaVo getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(AreaVo area) {
		this.area = area;
	}

	
	


	/**
	 * @return the sexo
	 */
	public int getiSexoId() {
		return iSexoId;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setiSexoId(int iSexoId) {
		this.iSexoId = iSexoId;
	}

	/**
	 * @return the tipodocumento
	 */
	public TipodocumentoVo getTipodocumento() {
		return tipodocumento;
	}

	/**
	 * @param tipodocumento the tipodocumento to set
	 */
	public void setTipodocumento(TipodocumentoVo tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	/**
	 * @return the ocupacion
	 */
	public OcupacionVo getOcupacion() {
		return ocupacion;
	}

	/**
	 * @param ocupacion the ocupacion to set
	 */
	public void setOcupacion(OcupacionVo ocupacion) {
		this.ocupacion = ocupacion;
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

	
}