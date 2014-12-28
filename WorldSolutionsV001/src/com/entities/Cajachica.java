package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the cajachica database table.
 * 
 */
@Entity
public class Cajachica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iCajaChicaId;

	private String cEstadoCodigo;

    @Temporal( TemporalType.DATE)
	private Date dFechaActualiza;

    @Temporal( TemporalType.DATE)
	private Date dFechaInserta;

	private float fMonto;

	private String vTipoConcepto;
	
	private String vConceptoGeneral;
	
	//bi-directional many-to-one association to Area
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iCuentasId", nullable=false)	
	private Cuenta cuenta;

	private int iUsuarioActualizaId;

	private int iUsuarioInsertaId;



    public Cajachica() {
    }

	/**
	 * @return the iCajaChicaId
	 */
	public int getiCajaChicaId() {
		return iCajaChicaId;
	}

	/**
	 * @param iCajaChicaId the iCajaChicaId to set
	 */
	public void setiCajaChicaId(int iCajaChicaId) {
		this.iCajaChicaId = iCajaChicaId;
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
	 * @return the fMontoDebe
	 */
	public float getfMonto() {
		return fMonto;
	}

	/**
	 * @param fMontoDebe the fMontoDebe to set
	 */
	public void setfMonto(float fMonto) {
		this.fMonto = fMonto;
	}

	/**
	 * @return the fMontoHaber
	 */
	public String getvTipoConcepto() {
		return vTipoConcepto;
	}

	/**
	 * @param fMontoHaber the fMontoHaber to set
	 */
	public void setvTipoConcepto(String vTipoConcepto) {
		this.vTipoConcepto = vTipoConcepto;
	}

	
	/**
	 * @return the cuenta
	 */
	public Cuenta getCuenta() {
		return cuenta;
	}

	/**
	 * @param cuenta the cuenta to set
	 */
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
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
	 * @return the vConceptoGeneral
	 */
	public String getvConceptoGeneral() {
		return vConceptoGeneral;
	}

	/**
	 * @param vConceptoGeneral the vConceptoGeneral to set
	 */
	public void setvConceptoGeneral(String vConceptoGeneral) {
		this.vConceptoGeneral = vConceptoGeneral;
	}

	
}