package com.entities.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the letracliente database table.
 * 
 */

public class LetraclienteVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iLetraClienteId;
	private String cEstadoCodigo;
	private Date dFechaActualiza;
	private Date dFechaGiro;
	private Date dFechaInserta;
	private Date dFechaPago;
	private Date dFechaProrroga;
	private Date dFechaVencimiento;
	private float fImporteIntereses;
	private ClienteVo cliente;
	private int iEmpresaId;
	private int iUsuarioInsertaId;
	private VentaVo venta;
	private float nImporte;
	private int nNumeroLetra;
	private String nNumeroUnico;
	private int nPlazoLetra;
	private String nRefGirador;
	private String vEstadoLetra;
	private String vImporteLetras;
	private String vLugarGiro;

	public LetraclienteVo() {
	}

	/**
	 * @return the iLetraClienteId
	 */
	public int getiLetraClienteId() {
		return iLetraClienteId;
	}

	/**
	 * @param iLetraClienteId the iLetraClienteId to set
	 */
	public void setiLetraClienteId(int iLetraClienteId) {
		this.iLetraClienteId = iLetraClienteId;
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
	 * @return the dFechaGiro
	 */
	public Date getdFechaGiro() {
		return dFechaGiro;
	}

	/**
	 * @param dFechaGiro the dFechaGiro to set
	 */
	public void setdFechaGiro(Date dFechaGiro) {
		this.dFechaGiro = dFechaGiro;
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
	 * @return the dFechaPago
	 */
	public Date getdFechaPago() {
		return dFechaPago;
	}

	/**
	 * @param dFechaPago the dFechaPago to set
	 */
	public void setdFechaPago(Date dFechaPago) {
		this.dFechaPago = dFechaPago;
	}

	/**
	 * @return the dFechaProrroga
	 */
	public Date getdFechaProrroga() {
		return dFechaProrroga;
	}

	/**
	 * @param dFechaProrroga the dFechaProrroga to set
	 */
	public void setdFechaProrroga(Date dFechaProrroga) {
		this.dFechaProrroga = dFechaProrroga;
	}

	/**
	 * @return the dFechaVencimiento
	 */
	public Date getdFechaVencimiento() {
		return dFechaVencimiento;
	}

	/**
	 * @param dFechaVencimiento the dFechaVencimiento to set
	 */
	public void setdFechaVencimiento(Date dFechaVencimiento) {
		this.dFechaVencimiento = dFechaVencimiento;
	}

	/**
	 * @return the fImporteIntereses
	 */
	public float getfImporteIntereses() {
		return fImporteIntereses;
	}

	/**
	 * @param fImporteIntereses the fImporteIntereses to set
	 */
	public void setfImporteIntereses(float fImporteIntereses) {
		this.fImporteIntereses = fImporteIntereses;
	}

	/**
	 * @return the cliente
	 */
	public ClienteVo getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(ClienteVo cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the iEmpresaId
	 */
	public int getiEmpresaId() {
		return iEmpresaId;
	}

	/**
	 * @param iEmpresaId the iEmpresaId to set
	 */
	public void setiEmpresaId(int iEmpresaId) {
		this.iEmpresaId = iEmpresaId;
	}

	/**
	 * @return the iUsuarioInsertaId
	 */
	public int getiUsuarioInsertaId() {
		return iUsuarioInsertaId;
	}

	/**
	 * @param iUsuarioInsertaId the iUsuarioInsertaId to set
	 */
	public void setiUsuarioInsertaId(int iUsuarioInsertaId) {
		this.iUsuarioInsertaId = iUsuarioInsertaId;
	}

	
	/**
	 * @return the venta
	 */
	public VentaVo getVenta() {
		return venta;
	}

	/**
	 * @param venta the venta to set
	 */
	public void setVenta(VentaVo venta) {
		this.venta = venta;
	}

	/**
	 * @return the nImporte
	 */
	public float getnImporte() {
		return nImporte;
	}

	/**
	 * @param nImporte the nImporte to set
	 */
	public void setnImporte(float nImporte) {
		this.nImporte = nImporte;
	}

	/**
	 * @return the nNumeroLetra
	 */
	public int getnNumeroLetra() {
		return nNumeroLetra;
	}

	/**
	 * @param nNumeroLetra the nNumeroLetra to set
	 */
	public void setnNumeroLetra(int nNumeroLetra) {
		this.nNumeroLetra = nNumeroLetra;
	}

	/**
	 * @return the nNumeroUnico
	 */
	public String getnNumeroUnico() {
		return nNumeroUnico;
	}

	/**
	 * @param nNumeroUnico the nNumeroUnico to set
	 */
	public void setnNumeroUnico(String nNumeroUnico) {
		this.nNumeroUnico = nNumeroUnico;
	}

	/**
	 * @return the nPlazoLetra
	 */
	public int getnPlazoLetra() {
		return nPlazoLetra;
	}

	/**
	 * @param nPlazoLetra the nPlazoLetra to set
	 */
	public void setnPlazoLetra(int nPlazoLetra) {
		this.nPlazoLetra = nPlazoLetra;
	}

	/**
	 * @return the nRefGirador
	 */
	public String getnRefGirador() {
		return nRefGirador;
	}

	/**
	 * @param nRefGirador the nRefGirador to set
	 */
	public void setnRefGirador(String nRefGirador) {
		this.nRefGirador = nRefGirador;
	}

	/**
	 * @return the vEstadoLetra
	 */
	public String getvEstadoLetra() {
		return vEstadoLetra;
	}

	/**
	 * @param vEstadoLetra the vEstadoLetra to set
	 */
	public void setvEstadoLetra(String vEstadoLetra) {
		this.vEstadoLetra = vEstadoLetra;
	}

	/**
	 * @return the vImporteLetras
	 */
	public String getvImporteLetras() {
		return vImporteLetras;
	}

	/**
	 * @param vImporteLetras the vImporteLetras to set
	 */
	public void setvImporteLetras(String vImporteLetras) {
		this.vImporteLetras = vImporteLetras;
	}

	/**
	 * @return the vLugarGiro
	 */
	public String getvLugarGiro() {
		return vLugarGiro;
	}

	/**
	 * @param vLugarGiro the vLugarGiro to set
	 */
	public void setvLugarGiro(String vLugarGiro) {
		this.vLugarGiro = vLugarGiro;
	}

	

}