package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the periodo database table.
 * 
 */
@Entity
public class Periodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int iPeriodoId;

	private String cCodigoEstado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.DATE)
	private Date dFechaFin;

	@Temporal(TemporalType.DATE)
	private Date dFechaInicio;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private int iUsuarioActualiza;

	private int iUsuarioInserta;

	private String vCodigoPeriodo;

	private String vNombrePeriodo;

	//bi-directional many-to-one association to Ejerciciofiscal
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iEjercicioFiscalId")
	private Ejerciciofiscal ejerciciofiscal;

	public Periodo() {
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
	 * @return the cCodigoEstado
	 */
	public String getcCodigoEstado() {
		return cCodigoEstado;
	}

	/**
	 * @param cCodigoEstado the cCodigoEstado to set
	 */
	public void setcCodigoEstado(String cCodigoEstado) {
		this.cCodigoEstado = cCodigoEstado;
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
	 * @return the dFechaFin
	 */
	public Date getdFechaFin() {
		return dFechaFin;
	}

	/**
	 * @param dFechaFin the dFechaFin to set
	 */
	public void setdFechaFin(Date dFechaFin) {
		this.dFechaFin = dFechaFin;
	}

	/**
	 * @return the dFechaInicio
	 */
	public Date getdFechaInicio() {
		return dFechaInicio;
	}

	/**
	 * @param dFechaInicio the dFechaInicio to set
	 */
	public void setdFechaInicio(Date dFechaInicio) {
		this.dFechaInicio = dFechaInicio;
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
	 * @return the vCodigoPeriodo
	 */
	public String getvCodigoPeriodo() {
		return vCodigoPeriodo;
	}

	/**
	 * @param vCodigoPeriodo the vCodigoPeriodo to set
	 */
	public void setvCodigoPeriodo(String vCodigoPeriodo) {
		this.vCodigoPeriodo = vCodigoPeriodo;
	}

	/**
	 * @return the vNombrePeriodo
	 */
	public String getvNombrePeriodo() {
		return vNombrePeriodo;
	}

	/**
	 * @param vNombrePeriodo the vNombrePeriodo to set
	 */
	public void setvNombrePeriodo(String vNombrePeriodo) {
		this.vNombrePeriodo = vNombrePeriodo;
	}

	/**
	 * @return the ejerciciofiscal
	 */
	public Ejerciciofiscal getEjerciciofiscal() {
		return ejerciciofiscal;
	}

	/**
	 * @param ejerciciofiscal the ejerciciofiscal to set
	 */
	public void setEjerciciofiscal(Ejerciciofiscal ejerciciofiscal) {
		this.ejerciciofiscal = ejerciciofiscal;
	}

	

	
}