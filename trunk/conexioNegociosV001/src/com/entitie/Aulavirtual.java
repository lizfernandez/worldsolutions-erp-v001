package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the aulavirtual database table.
 * 
 */
@Entity
public class Aulavirtual implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger iAulaVirtualId;

	private String cEstadoCodigo;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private BigInteger iUsuarioActualiza;

	private BigInteger iUsuarioInserta;

	private String vContenido;

	private String vEnlance;

	private String vTitulo;

    public Aulavirtual() {
    }

	/**
	 * @return the iAulaVirtualId
	 */
	public BigInteger getiAulaVirtualId() {
		return iAulaVirtualId;
	}

	/**
	 * @param iAulaVirtualId the iAulaVirtualId to set
	 */
	public void setiAulaVirtualId(BigInteger iAulaVirtualId) {
		this.iAulaVirtualId = iAulaVirtualId;
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
	 * @return the iUsuarioActualiza
	 */
	public BigInteger getiUsuarioActualiza() {
		return iUsuarioActualiza;
	}

	/**
	 * @param iUsuarioActualiza the iUsuarioActualiza to set
	 */
	public void setiUsuarioActualiza(BigInteger iUsuarioActualiza) {
		this.iUsuarioActualiza = iUsuarioActualiza;
	}

	/**
	 * @return the iUsuarioInserta
	 */
	public BigInteger getiUsuarioInserta() {
		return iUsuarioInserta;
	}

	/**
	 * @param iUsuarioInserta the iUsuarioInserta to set
	 */
	public void setiUsuarioInserta(BigInteger iUsuarioInserta) {
		this.iUsuarioInserta = iUsuarioInserta;
	}

	/**
	 * @return the vContenido
	 */
	public String getvContenido() {
		return vContenido;
	}

	/**
	 * @param vContenido the vContenido to set
	 */
	public void setvContenido(String vContenido) {
		this.vContenido = vContenido;
	}

	/**
	 * @return the vEnlance
	 */
	public String getvEnlance() {
		return vEnlance;
	}

	/**
	 * @param vEnlance the vEnlance to set
	 */
	public void setvEnlance(String vEnlance) {
		this.vEnlance = vEnlance;
	}

	/**
	 * @return the vTitulo
	 */
	public String getvTitulo() {
		return vTitulo;
	}

	/**
	 * @param vTitulo the vTitulo to set
	 */
	public void setvTitulo(String vTitulo) {
		this.vTitulo = vTitulo;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}