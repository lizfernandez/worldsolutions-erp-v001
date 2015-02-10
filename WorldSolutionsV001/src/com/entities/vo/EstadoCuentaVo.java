package com.entities.vo;

import java.io.Serializable;
import java.util.List;

import com.entities.Ingresoproducto;
import com.entities.Venta;

public class EstadoCuentaVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idClienteProveedor;
	private int idDocumento;
	private String cProveedorCodigo;
	private String nombreClienteProveedor;
	private String totalDocumentos;
	private String primerFechaEmision;
	private String ultFechaPagos;
	private float montoTotal;
	private float pagoTotal;
	private float saldoTotal;
	private String cCodigoEstado;
	private float montosTotales;
	private float pagosTotales;
	private float saldosTotales;
	private String vPrincipal;
	
	private String formaPago;
	private String tipoDocumento;
	private int idTipoDocumento;
	private String numeroDocumento;
	private List  estadocuenta;
	
	private Venta venta;
	private Ingresoproducto ingresoProducto;
	
	
	
	/**
	 * @return the venta
	 */
	public Venta getVenta() {
		return venta;
	}
	/**
	 * @param venta the venta to set
	 */
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	
	/**
	 * @return the ingresoProducto
	 */
	public Ingresoproducto getIngresoProducto() {
		return ingresoProducto;
	}
	/**
	 * @param ingresoProducto the ingresoProducto to set
	 */
	public void setIngresoProducto(Ingresoproducto ingresoProducto) {
		this.ingresoProducto = ingresoProducto;
	}
	/**
	 * @return the idClienteProveedor
	 */
	public int getIdClienteProveedor() {
		return idClienteProveedor;
	}
	/**
	 * @param idClienteProveedor the idClienteProveedor to set
	 */
	public void setIdClienteProveedor(int idClienteProveedor) {
		this.idClienteProveedor = idClienteProveedor;
	}
	
	
	/**
	 * @return the idDocumeento
	 */
	public int getIdDocumento() {
		return idDocumento;
	}
	/**
	 * @param idDocumeento the idDocumeento to set
	 */
	public void setIdDocumento(int idDocumeento) {
		this.idDocumento = idDocumeento;
	}
	/**
	 * @return the cProveedorCodigo
	 */
	public String getcProveedorCodigo() {
		return cProveedorCodigo;
	}
	/**
	 * @param cProveedorCodigo the cProveedorCodigo to set
	 */
	public void setcProveedorCodigo(String cProveedorCodigo) {
		this.cProveedorCodigo = cProveedorCodigo;
	}
	/**
	 * @return the nombreClienteProveedor
	 */
	public String getNombreClienteProveedor() {
		return nombreClienteProveedor;
	}
	/**
	 * @param nombreClienteProveedor the nombreClienteProveedor to set
	 */
	public void setNombreClienteProveedor(String nombreClienteProveedor) {
		this.nombreClienteProveedor = nombreClienteProveedor;
	}
	/**
	 * @return the totalDocumentos
	 */
	public String getTotalDocumentos() {
		return totalDocumentos;
	}
	/**
	 * @param totalDocumentos the totalDocumentos to set
	 */
	public void setTotalDocumentos(String totalDocumentos) {
		this.totalDocumentos = totalDocumentos;
	}
	/**
	 * @return the primerFechaEmision
	 */
	public String getPrimerFechaEmision() {
		return primerFechaEmision;
	}
	/**
	 * @param primerFechaEmision the primerFechaEmision to set
	 */
	public void setPrimerFechaEmision(String primerFechaEmision) {
		this.primerFechaEmision = primerFechaEmision;
	}
	/**
	 * @return the ultFechaPagos
	 */
	public String getUltFechaPagos() {
		return ultFechaPagos;
	}
	/**
	 * @param ultFechaPagos the ultFechaPagos to set
	 */
	public void setUltFechaPagos(String ultFechaPagos) {
		this.ultFechaPagos = ultFechaPagos;
	}
	/**
	 * @return the montoTotal
	 */
	public float getMontoTotal() {
		return montoTotal;
	}
	/**
	 * @param montoTotal the montoTotal to set
	 */
	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}
	/**
	 * @return the pagoTotal
	 */
	public float getPagoTotal() {
		return pagoTotal;
	}
	/**
	 * @param pagoTotal the pagoTotal to set
	 */
	public void setPagoTotal(float pagoTotal) {
		this.pagoTotal = pagoTotal;
	}
	/**
	 * @return the saldoTotal
	 */
	public float getSaldoTotal() {
		return saldoTotal;
	}
	/**
	 * @param saldoTotal the saldoTotal to set
	 */
	public void setSaldoTotal(float saldoTotal) {
		this.saldoTotal = saldoTotal;
	}
	
	
	
	/**
	 * @return the montosTotales
	 */
	public float getMontosTotales() {
		return montosTotales;
	}
	/**
	 * @param montosTotales the montosTotales to set
	 */
	public void setMontosTotales(float montosTotales) {
		this.montosTotales = montosTotales;
	}
	/**
	 * @return the pagosTotales
	 */
	public float getPagosTotales() {
		return pagosTotales;
	}
	/**
	 * @param pagosTotales the pagosTotales to set
	 */
	public void setPagosTotales(float pagosTotales) {
		this.pagosTotales = pagosTotales;
	}
	/**
	 * @return the saldosTotales
	 */
	public float getSaldosTotales() {
		return saldosTotales;
	}
	/**
	 * @param saldosTotales the saldosTotales to set
	 */
	public void setSaldosTotales(float saldosTotales) {
		this.saldosTotales = saldosTotales;
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
	 * @return the formaPago
	 */
	public String getFormaPago() {
		return formaPago;
	}
	/**
	 * @param formaPago the formaPago to set
	 */
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	/**
	 * @return the tipoDocumento
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	
	/**
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	/**
	 * @return the estadocuenta
	 */
	public List getEstadocuenta() {
		return estadocuenta;
	}
	/**
	 * @param estadocuenta the estadocuenta to set
	 */
	public void setEstadocuenta(List estadocuenta) {
		this.estadocuenta = estadocuenta;
	}
	
	
	/**
	 * @return the vPrincipal
	 */
	public String getvPrincipal() {
		return vPrincipal;
	}

	/**
	 * @param vPrincipal the vPrincipal to set
	 */
	public void setvPrincipal(String vPrincipal) {
		this.vPrincipal = vPrincipal;
	}
	/**
	 * @return the idTipoDocumento
	 */
	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}
	/**
	 * @param idTipoDocumento the idTipoDocumento to set
	 */
	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	

}
