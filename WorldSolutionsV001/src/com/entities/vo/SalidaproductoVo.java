package com.entities.vo;

import java.io.Serializable;

import java.util.Date;

public class SalidaproductoVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iSalidaProductoId;
	private String cEstadoCodigo;
	private String cSalidaProductoAutorizado;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private Date dSalidaProductoFecha;
	private int iCantidad;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
	private String vSalidaProductoMotivo;
	private ProductoVo producto;
	private ProveedorVo proveedor;

    public SalidaproductoVo() {
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

	public ProductoVo getProducto() {
		return this.producto;
	}

	public void setProducto(ProductoVo producto) {
		this.producto = producto;
	}
	
	public ProveedorVo getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(ProveedorVo proveedor) {
		this.proveedor = proveedor;
	}
	
}