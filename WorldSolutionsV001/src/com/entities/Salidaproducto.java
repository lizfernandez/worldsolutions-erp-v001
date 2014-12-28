package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the salidaproducto database table.
 * 
 */
@Entity
@Table(name="salidaproducto")
public class Salidaproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int iSalidaProductoId;

	@Column(length=2)
	private String cEstadoCodigo;

	@Column(nullable=false, length=1)
	private String cSalidaProductoAutorizado;

    @Temporal( TemporalType.DATE)
	private Date dFechaActualiza;

    @Temporal( TemporalType.DATE)
	private Date dFechaInserta;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date dSalidaProductoFecha;

	@Column(nullable=false)
	private int iCantidad;

	private int iUsuarioActualizaId;

	private int iUsuarioInsertaId;

	@Column(nullable=false, length=45)
	private String vSalidaProductoMotivo;

	//bi-directional many-to-one association to Producto
    @ManyToOne
	@JoinColumn(name="iProductoId", nullable=false)
	private Producto producto;

	//bi-directional many-to-one association to Proveedor
    @ManyToOne
	@JoinColumn(name="iProveedorId", nullable=false)
	private Proveedor proveedor;

    public Salidaproducto() {
    }

	public int getISalidaProductoId() {
		return this.iSalidaProductoId;
	}

	public void setISalidaProductoId(int iSalidaProductoId) {
		this.iSalidaProductoId = iSalidaProductoId;
	}

	public String getCEstadoCodigo() {
		return this.cEstadoCodigo;
	}

	public void setCEstadoCodigo(String cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}

	public String getCSalidaProductoAutorizado() {
		return this.cSalidaProductoAutorizado;
	}

	public void setCSalidaProductoAutorizado(String cSalidaProductoAutorizado) {
		this.cSalidaProductoAutorizado = cSalidaProductoAutorizado;
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

	public Date getDSalidaProductoFecha() {
		return this.dSalidaProductoFecha;
	}

	public void setDSalidaProductoFecha(Date dSalidaProductoFecha) {
		this.dSalidaProductoFecha = dSalidaProductoFecha;
	}

	public int getICantidad() {
		return this.iCantidad;
	}

	public void setICantidad(int iCantidad) {
		this.iCantidad = iCantidad;
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

	public String getVSalidaProductoMotivo() {
		return this.vSalidaProductoMotivo;
	}

	public void setVSalidaProductoMotivo(String vSalidaProductoMotivo) {
		this.vSalidaProductoMotivo = vSalidaProductoMotivo;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
}