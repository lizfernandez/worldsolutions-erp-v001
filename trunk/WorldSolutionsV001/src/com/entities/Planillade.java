package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the planillades database table.
 * 
 */
@Entity
@Table(name="planillades")
public class Planillade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iPlanillaDesId;

	private String cCodigoPlanillaDes;

	private String cEstadoCodigo;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private float fPorcentaje;

	private int iUsuarioActualiza;

	private int iUsuarioInserta;

	private String vNombrePlanillaDes;

    public Planillade() {
    }

	/**
	 * @return the iPlanillaDesId
	 */
	public int getiPlanillaDesId() {
		return iPlanillaDesId;
	}

	/**
	 * @param iPlanillaDesId the iPlanillaDesId to set
	 */
	public void setiPlanillaDesId(int iPlanillaDesId) {
		this.iPlanillaDesId = iPlanillaDesId;
	}

	/**
	 * @return the cCodigoPlanillaDes
	 */
	public String getcCodigoPlanillaDes() {
		return cCodigoPlanillaDes;
	}

	/**
	 * @param cCodigoPlanillaDes the cCodigoPlanillaDes to set
	 */
	public void setcCodigoPlanillaDes(String cCodigoPlanillaDes) {
		this.cCodigoPlanillaDes = cCodigoPlanillaDes;
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
	 * @return the fPorcentaje
	 */
	public float getfPorcentaje() {
		return fPorcentaje;
	}

	/**
	 * @param fPorcentaje the fPorcentaje to set
	 */
	public void setfPorcentaje(float fPorcentaje) {
		this.fPorcentaje = fPorcentaje;
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

	/**
	 * @return the vNombrePlanillaDes
	 */
	public String getvNombrePlanillaDes() {
		return vNombrePlanillaDes;
	}

	/**
	 * @param vNombrePlanillaDes the vNombrePlanillaDes to set
	 */
	public void setvNombrePlanillaDes(String vNombrePlanillaDes) {
		this.vNombrePlanillaDes = vNombrePlanillaDes;
	}

	
}