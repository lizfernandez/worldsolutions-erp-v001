package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cuota database table.
 * 
 */
@Entity
@Table(name="cuota")
public class Cuota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int iCuotaId;

	@Column(nullable=false, length=2)
	private String cEstadoCodigo;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date dCuotaFecha;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date dFechaInserta;

	@Column(nullable=false)
	private float fCuotaInteres;

	@Column(nullable=false)
	private float fCuotaMonto;

	@Column(nullable=false)
	private int iCuotaNumero;

	private int iUsuarioActualizaId;

	@Column(nullable=false)
	private int iUsuarioInsertaId;

	@Column(nullable=false, length=45)
	private String vCuotaDescripcion;

	//bi-directional many-to-one association to Venta
    @ManyToOne
	@JoinColumn(name="iVentaId", nullable=false)
	private Venta venta;

    public Cuota() {
    }

	public int getICuotaId() {
		return this.iCuotaId;
	}

	public void setICuotaId(int iCuotaId) {
		this.iCuotaId = iCuotaId;
	}

	public String getCEstadoCodigo() {
		return this.cEstadoCodigo;
	}

	public void setCEstadoCodigo(String cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}

	public Date getDCuotaFecha() {
		return this.dCuotaFecha;
	}

	public void setDCuotaFecha(Date dCuotaFecha) {
		this.dCuotaFecha = dCuotaFecha;
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

	public float getFCuotaInteres() {
		return this.fCuotaInteres;
	}

	public void setFCuotaInteres(float fCuotaInteres) {
		this.fCuotaInteres = fCuotaInteres;
	}

	public float getFCuotaMonto() {
		return this.fCuotaMonto;
	}

	public void setFCuotaMonto(float fCuotaMonto) {
		this.fCuotaMonto = fCuotaMonto;
	}

	public int getICuotaNumero() {
		return this.iCuotaNumero;
	}

	public void setICuotaNumero(int iCuotaNumero) {
		this.iCuotaNumero = iCuotaNumero;
	}

	public int getIUsuarioActualizaId() {
		return this.iUsuarioActualizaId;
	}

	public void setIUsuarioActualizaId(int iUsuarioActualizaId) {
		this.iUsuarioActualizaId = iUsuarioActualizaId;
	}

	public int getIUsuarioInsertaId() {
		return this.iUsuarioInsertaId;
	}

	public void setIUsuarioInsertaId(int iUsuarioInsertaId) {
		this.iUsuarioInsertaId = iUsuarioInsertaId;
	}

	public String getVCuotaDescripcion() {
		return this.vCuotaDescripcion;
	}

	public void setVCuotaDescripcion(String vCuotaDescripcion) {
		this.vCuotaDescripcion = vCuotaDescripcion;
	}

	public Venta getVenta() {
		return this.venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
}