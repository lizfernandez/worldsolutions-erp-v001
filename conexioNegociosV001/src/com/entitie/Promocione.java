package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the promociones database table.
 * 
 */
@Entity
@Table(name="promociones")
public class Promocione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iPromocionId;

	private String cAplicaDescuento;

	private String cEstadoCodigo;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaCaducidad;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private float fDescuento;

	private float fNuevoPrecio;

	private float fPrecio;

	private BigInteger iTotalGustos;

	private BigInteger iTotalVistos;

	private BigInteger iUsuarioActualiza;

	private BigInteger iUsuarioId;

	private BigInteger iUsuarioInserta;

	private String vCondiciones;

	private String vDescripcion;

	private String vFoto;

	private String vNombre;

    public Promocione() {
    }

	public String getIPromocionId() {
		return this.iPromocionId;
	}

	public void setIPromocionId(String iPromocionId) {
		this.iPromocionId = iPromocionId;
	}

	public String getCAplicaDescuento() {
		return this.cAplicaDescuento;
	}

	public void setCAplicaDescuento(String cAplicaDescuento) {
		this.cAplicaDescuento = cAplicaDescuento;
	}

	public String getCEstadoCodigo() {
		return this.cEstadoCodigo;
	}

	public void setCEstadoCodigo(String cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}

	public Date getDFechaActualiza() {
		return this.dFechaActualiza;
	}

	public void setDFechaActualiza(Date dFechaActualiza) {
		this.dFechaActualiza = dFechaActualiza;
	}

	public Date getDFechaCaducidad() {
		return this.dFechaCaducidad;
	}

	public void setDFechaCaducidad(Date dFechaCaducidad) {
		this.dFechaCaducidad = dFechaCaducidad;
	}

	public Date getDFechaInserta() {
		return this.dFechaInserta;
	}

	public void setDFechaInserta(Date dFechaInserta) {
		this.dFechaInserta = dFechaInserta;
	}

	public float getFDescuento() {
		return this.fDescuento;
	}

	public void setFDescuento(float fDescuento) {
		this.fDescuento = fDescuento;
	}

	public float getFNuevoPrecio() {
		return this.fNuevoPrecio;
	}

	public void setFNuevoPrecio(float fNuevoPrecio) {
		this.fNuevoPrecio = fNuevoPrecio;
	}

	public float getFPrecio() {
		return this.fPrecio;
	}

	public void setFPrecio(float fPrecio) {
		this.fPrecio = fPrecio;
	}

	public BigInteger getITotalGustos() {
		return this.iTotalGustos;
	}

	public void setITotalGustos(BigInteger iTotalGustos) {
		this.iTotalGustos = iTotalGustos;
	}

	public BigInteger getITotalVistos() {
		return this.iTotalVistos;
	}

	public void setITotalVistos(BigInteger iTotalVistos) {
		this.iTotalVistos = iTotalVistos;
	}

	public BigInteger getIUsuarioActualiza() {
		return this.iUsuarioActualiza;
	}

	public void setIUsuarioActualiza(BigInteger iUsuarioActualiza) {
		this.iUsuarioActualiza = iUsuarioActualiza;
	}

	public BigInteger getIUsuarioId() {
		return this.iUsuarioId;
	}

	public void setIUsuarioId(BigInteger iUsuarioId) {
		this.iUsuarioId = iUsuarioId;
	}

	public BigInteger getIUsuarioInserta() {
		return this.iUsuarioInserta;
	}

	public void setIUsuarioInserta(BigInteger iUsuarioInserta) {
		this.iUsuarioInserta = iUsuarioInserta;
	}

	public String getVCondiciones() {
		return this.vCondiciones;
	}

	public void setVCondiciones(String vCondiciones) {
		this.vCondiciones = vCondiciones;
	}

	public String getVDescripcion() {
		return this.vDescripcion;
	}

	public void setVDescripcion(String vDescripcion) {
		this.vDescripcion = vDescripcion;
	}

	public String getVFoto() {
		return this.vFoto;
	}

	public void setVFoto(String vFoto) {
		this.vFoto = vFoto;
	}

	public String getVNombre() {
		return this.vNombre;
	}

	public void setVNombre(String vNombre) {
		this.vNombre = vNombre;
	}

}