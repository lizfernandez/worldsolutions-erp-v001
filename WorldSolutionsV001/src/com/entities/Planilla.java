package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the planilla database table.
 * 
 */
@Entity
public class Planilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iPlanillaId;

	private String cEstadoCodigo;

	private Timestamp dFechaActualiza;

	private Timestamp dFechaInserta;

	private float fApoESSALUD;

	private float fApoIES;

	private float fAsignacionFamiliar;

	private float fDesAFP;

	private float fDesCV;

	private float fDesPS;

	private float fDesSNP;

	private float fNetoPago;

	private float fPorApoESSALUD;

	private float fPorApoIES;

	private float fPorDesAFP;

	private float fPorDesCV;

	private float fPorDesPS;

	private float fPorDesSNP;

	private float fSueldo;

	private float fTotalAportes;

	private float fTotalDescuento;

	private float fTotalRemuneracion;
	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="iPersonalId", nullable=false)
	
	private Personal personal;

	private int iPeriodoId;

	private int iUsuarioActualiza;

	private int iUsuarioInserta;

    public Planilla() {
    }

	/**
	 * @return the iPlanillaId
	 */
	public int getiPlanillaId() {
		return iPlanillaId;
	}

	/**
	 * @param iPlanillaId the iPlanillaId to set
	 */
	public void setiPlanillaId(int iPlanillaId) {
		this.iPlanillaId = iPlanillaId;
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
	public Timestamp getdFechaActualiza() {
		return dFechaActualiza;
	}

	/**
	 * @param dFechaActualiza the dFechaActualiza to set
	 */
	public void setdFechaActualiza(Timestamp dFechaActualiza) {
		this.dFechaActualiza = dFechaActualiza;
	}

	/**
	 * @return the dFechaInserta
	 */
	public Timestamp getdFechaInserta() {
		return dFechaInserta;
	}

	/**
	 * @param dFechaInserta the dFechaInserta to set
	 */
	public void setdFechaInserta(Timestamp dFechaInserta) {
		this.dFechaInserta = dFechaInserta;
	}

	/**
	 * @return the fApoESSALUD
	 */
	public float getfApoESSALUD() {
		return fApoESSALUD;
	}

	/**
	 * @param fApoESSALUD the fApoESSALUD to set
	 */
	public void setfApoESSALUD(float fApoESSALUD) {
		this.fApoESSALUD = fApoESSALUD;
	}

	/**
	 * @return the fApoIES
	 */
	public float getfApoIES() {
		return fApoIES;
	}

	/**
	 * @param fApoIES the fApoIES to set
	 */
	public void setfApoIES(float fApoIES) {
		this.fApoIES = fApoIES;
	}

	/**
	 * @return the fAsignacionFamiliar
	 */
	public float getfAsignacionFamiliar() {
		return fAsignacionFamiliar;
	}

	/**
	 * @param fAsignacionFamiliar the fAsignacionFamiliar to set
	 */
	public void setfAsignacionFamiliar(float fAsignacionFamiliar) {
		this.fAsignacionFamiliar = fAsignacionFamiliar;
	}

	/**
	 * @return the fDesAFP
	 */
	public float getfDesAFP() {
		return fDesAFP;
	}

	/**
	 * @param fDesAFP the fDesAFP to set
	 */
	public void setfDesAFP(float fDesAFP) {
		this.fDesAFP = fDesAFP;
	}

	/**
	 * @return the fDesCV
	 */
	public float getfDesCV() {
		return fDesCV;
	}

	/**
	 * @param fDesCV the fDesCV to set
	 */
	public void setfDesCV(float fDesCV) {
		this.fDesCV = fDesCV;
	}

	/**
	 * @return the fDesPS
	 */
	public float getfDesPS() {
		return fDesPS;
	}

	/**
	 * @param fDesPS the fDesPS to set
	 */
	public void setfDesPS(float fDesPS) {
		this.fDesPS = fDesPS;
	}

	/**
	 * @return the fDesSNP
	 */
	public float getfDesSNP() {
		return fDesSNP;
	}

	/**
	 * @param fDesSNP the fDesSNP to set
	 */
	public void setfDesSNP(float fDesSNP) {
		this.fDesSNP = fDesSNP;
	}

	/**
	 * @return the fNetoPago
	 */
	public float getfNetoPago() {
		return fNetoPago;
	}

	/**
	 * @param fNetoPago the fNetoPago to set
	 */
	public void setfNetoPago(float fNetoPago) {
		this.fNetoPago = fNetoPago;
	}

	/**
	 * @return the fPorApoESSALUD
	 */
	public float getfPorApoESSALUD() {
		return fPorApoESSALUD;
	}

	/**
	 * @param fPorApoESSALUD the fPorApoESSALUD to set
	 */
	public void setfPorApoESSALUD(float fPorApoESSALUD) {
		this.fPorApoESSALUD = fPorApoESSALUD;
	}

	/**
	 * @return the fPorApoIES
	 */
	public float getfPorApoIES() {
		return fPorApoIES;
	}

	/**
	 * @param fPorApoIES the fPorApoIES to set
	 */
	public void setfPorApoIES(float fPorApoIES) {
		this.fPorApoIES = fPorApoIES;
	}

	/**
	 * @return the fPorDesAFP
	 */
	public float getfPorDesAFP() {
		return fPorDesAFP;
	}

	/**
	 * @param fPorDesAFP the fPorDesAFP to set
	 */
	public void setfPorDesAFP(float fPorDesAFP) {
		this.fPorDesAFP = fPorDesAFP;
	}

	/**
	 * @return the fPorDesCV
	 */
	public float getfPorDesCV() {
		return fPorDesCV;
	}

	/**
	 * @param fPorDesCV the fPorDesCV to set
	 */
	public void setfPorDesCV(float fPorDesCV) {
		this.fPorDesCV = fPorDesCV;
	}

	/**
	 * @return the fPorDesPS
	 */
	public float getfPorDesPS() {
		return fPorDesPS;
	}

	/**
	 * @param fPorDesPS the fPorDesPS to set
	 */
	public void setfPorDesPS(float fPorDesPS) {
		this.fPorDesPS = fPorDesPS;
	}

	/**
	 * @return the fPorDesSNP
	 */
	public float getfPorDesSNP() {
		return fPorDesSNP;
	}

	/**
	 * @param fPorDesSNP the fPorDesSNP to set
	 */
	public void setfPorDesSNP(float fPorDesSNP) {
		this.fPorDesSNP = fPorDesSNP;
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
	 * @return the fTotalAportes
	 */
	public float getfTotalAportes() {
		return fTotalAportes;
	}

	/**
	 * @param fTotalAportes the fTotalAportes to set
	 */
	public void setfTotalAportes(float fTotalAportes) {
		this.fTotalAportes = fTotalAportes;
	}

	/**
	 * @return the fTotalDescuento
	 */
	public float getfTotalDescuento() {
		return fTotalDescuento;
	}

	/**
	 * @param fTotalDescuento the fTotalDescuento to set
	 */
	public void setfTotalDescuento(float fTotalDescuento) {
		this.fTotalDescuento = fTotalDescuento;
	}

	/**
	 * @return the fTotalRemuneracion
	 */
	public float getfTotalRemuneracion() {
		return fTotalRemuneracion;
	}

	/**
	 * @param fTotalRemuneracion the fTotalRemuneracion to set
	 */
	public void setfTotalRemuneracion(float fTotalRemuneracion) {
		this.fTotalRemuneracion = fTotalRemuneracion;
	}

	/**
	 * @return the persona
	 */
	public Personal getPersonal() {
		return personal;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersonal(Personal persona) {
		this.personal = persona;
	}

	/**
	 * @return the iPeriodoId
	 */
	public int getiPeriodoId() {
		return iPeriodoId;
	}

	/**
	 * @param iPeriodoId the iPeriodoId to set
	 */
	public void setiPeriodoId(int iPeriodoId) {
		this.iPeriodoId = iPeriodoId;
	}

	/**
	 * @return the iUsuarioActualiza
	 */
	public int getiUsuarioActualiza() {
		return iUsuarioActualiza;
	}

	/**
	 * @param iUsuarioActualiza the iUsuarioActualiza to set
	 */
	public void setiUsuarioActualiza(int iUsuarioActualiza) {
		this.iUsuarioActualiza = iUsuarioActualiza;
	}

	/**
	 * @return the iUsuarioInserta
	 */
	public int getiUsuarioInserta() {
		return iUsuarioInserta;
	}

	/**
	 * @param iUsuarioInserta the iUsuarioInserta to set
	 */
	public void setiUsuarioInserta(int iUsuarioInserta) {
		this.iUsuarioInserta = iUsuarioInserta;
	}

	
}