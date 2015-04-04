package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the letraproveedor database table.
 * 
 */
@Entity
public class Letraproveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iletraProveedorId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.DATE)
	private Date dFechaGiro;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dfechaInserta;

	@Temporal(TemporalType.DATE)
	private Date dFechaProrroga;

	@Temporal(TemporalType.DATE)
	private Date dFechaVencimiento;	
		//bi-directional many-to-one association to Cliente
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="iProveedorId", nullable=false)
	private Proveedor proveedor;

	private int iUsuarioActualizaId;

	private int iUsuarioInsertaId;

	private float nImporte;

	private int nNumeroLetra;

	private int nNumeroUnico;

	private String vEstadoLetra;
	
	//bi-directional many-to-one association to Cliente
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="iIngresoProductoId", nullable=false)	
	private Ingresoproducto ingresoProducto;
	
	private String cEstadoCodigo;
	
	private int nPlazoLetra;
	
	
	@Temporal(TemporalType.DATE)
	private Date dFechaPago;
	
	private float fImporteIntereses;

	public Letraproveedor() {
	}

	/**
	 * @return the iletraProveedorId
	 */
	public int getIletraProveedorId() {
		return iletraProveedorId;
	}

	/**
	 * @param iletraProveedorId the iletraProveedorId to set
	 */
	public void setIletraProveedorId(int iletraProveedorId) {
		this.iletraProveedorId = iletraProveedorId;
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
	 * @return the dfechaInserta
	 */
	public Date getDfechaInserta() {
		return dfechaInserta;
	}

	/**
	 * @param dfechaInserta the dfechaInserta to set
	 */
	public void setDfechaInserta(Date dfechaInserta) {
		this.dfechaInserta = dfechaInserta;
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
	 * @return the proveedor
	 */
	public Proveedor getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * @return the iUsuarioActualizaId
	 */
	public int getiUsuarioActualizaId() {
		return iUsuarioActualizaId;
	}

	/**
	 * @param iUsuarioActualizaId the iUsuarioActualizaId to set
	 */
	public void setiUsuarioActualizaId(int iUsuarioActualizaId) {
		this.iUsuarioActualizaId = iUsuarioActualizaId;
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
	public int getnNumeroUnico() {
		return nNumeroUnico;
	}

	/**
	 * @param nNumeroUnico the nNumeroUnico to set
	 */
	public void setnNumeroUnico(int nNumeroUnico) {
		this.nNumeroUnico = nNumeroUnico;
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

	
}