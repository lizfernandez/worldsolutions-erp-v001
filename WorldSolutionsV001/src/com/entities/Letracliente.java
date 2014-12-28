package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the letracliente database table.
 * 
 */
@Entity
public class Letracliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iLetraClienteId;

	private String cEstadoCodigo;

	@Temporal(TemporalType.DATE)
	private Date dFechaActualiza;

	@Temporal(TemporalType.DATE)
	private Date dFechaGiro;

	@Temporal(TemporalType.DATE)
	private Date dFechaInserta;

	@Temporal(TemporalType.DATE)
	private Date dFechaPago;

	@Temporal(TemporalType.DATE)
	private Date dFechaProrroga;

	@Temporal(TemporalType.DATE)
	private Date dFechaVencimiento;

	private float fImporteIntereses;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="iClienteId", nullable=false)		
	private Cliente cliente;

	private int iEmpresaId;

	private int iUsuarioInsertaId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="iVentaId", nullable=false)	
	private Venta venta;

	private float nImporte;

	private int nNumeroLetra;

	private String nNumeroUnico;

	private int nPlazoLetra;

	private String nRefGirador;

	private String vEstadoLetra;

	private String vImporteLetras;

	private String vLugarGiro;

	public Letracliente() {
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
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
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