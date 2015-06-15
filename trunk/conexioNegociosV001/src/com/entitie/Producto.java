package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iProductoId;

	private String cAplicaDescuento;

	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private float fDescuento;

	private float fPrecio;

	private BigInteger iCategoriaId;

	private BigInteger iTotalGustos;

	private BigInteger iTotalVistos;

	private BigInteger iUsuarioActualiza;

	private BigInteger iUsuarioInserta;

	private String vDescripcion;

	private String vFoto;

	private String vNombre;

	public Producto() {
	}

	public String getIProductoId() {
		return this.iProductoId;
	}

	public void setIProductoId(String iProductoId) {
		this.iProductoId = iProductoId;
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

	public float getFPrecio() {
		return this.fPrecio;
	}

	public void setFPrecio(float fPrecio) {
		this.fPrecio = fPrecio;
	}

	public BigInteger getICategoriaId() {
		return this.iCategoriaId;
	}

	public void setICategoriaId(BigInteger iCategoriaId) {
		this.iCategoriaId = iCategoriaId;
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

	public BigInteger getIUsuarioInserta() {
		return this.iUsuarioInserta;
	}

	public void setIUsuarioInserta(BigInteger iUsuarioInserta) {
		this.iUsuarioInserta = iUsuarioInserta;
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