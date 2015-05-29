package com.entities.vo;

import java.io.Serializable;
import java.util.Date;

import com.entities.Sucursal;

public class SucursalVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iSucursalId;
	private String cSucursalCodigo;
	private String cEstadoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
	private String vSucursalDireccion;
	private String vSucursalNombre;
	private String vSucursalTelefono;
	private EmpresaVo empresa;
	
	public SucursalVo() {
		
	}
	public SucursalVo(Sucursal sucursal) {
		this.iSucursalId = sucursal.getiSucursalId();
		this.cSucursalCodigo = sucursal.getcSucursalCodigo();
		this.cEstadoCodigo = sucursal.getcEstadoCodigo();
		this.dFechaActualiza = sucursal.getdFechaActualiza();
		this.dFechaInserta = sucursal.getdFechaInserta();
		this.iUsuarioActualizaId = sucursal.getiUsuarioActualizaId();
		this.iUsuarioInsertaId = sucursal.getiUsuarioInsertaId();
		this.vSucursalDireccion = sucursal.getvSucursalDireccion();
		this.vSucursalNombre = sucursal.getvSucursalNombre();
		this.vSucursalTelefono = sucursal.getvSucursalTelefono();
	}
	/**
	 * @return the iSucursalId
	 */
	public int getiSucursalId() {
		return iSucursalId;
	}

	/**
	 * @param iSucursalId the iSucursalId to set
	 */
	public void setiSucursalId(int iSucursalId) {
		this.iSucursalId = iSucursalId;
	}

	/**
	 * @return the cSucursalCodigo
	 */
	public String getcSucursalCodigo() {
		return cSucursalCodigo;
	}

	/**
	 * @param cSucursalCodigo the cSucursalCodigo to set
	 */
	public void setcSucursalCodigo(String cSucursalCodigo) {
		this.cSucursalCodigo = cSucursalCodigo;
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
	 * @return the vSucursalDireccion
	 */
	public String getvSucursalDireccion() {
		return vSucursalDireccion;
	}

	/**
	 * @param vSucursalDireccion the vSucursalDireccion to set
	 */
	public void setvSucursalDireccion(String vSucursalDireccion) {
		this.vSucursalDireccion = vSucursalDireccion;
	}

	/**
	 * @return the vSucursalNombre
	 */
	public String getvSucursalNombre() {
		return vSucursalNombre;
	}

	/**
	 * @param vSucursalNombre the vSucursalNombre to set
	 */
	public void setvSucursalNombre(String vSucursalNombre) {
		this.vSucursalNombre = vSucursalNombre;
	}

	/**
	 * @return the vSucursalTelefono
	 */
	public String getvSucursalTelefono() {
		return vSucursalTelefono;
	}

	/**
	 * @param vSucursalTelefono the vSucursalTelefono to set
	 */
	public void setvSucursalTelefono(String vSucursalTelefono) {
		this.vSucursalTelefono = vSucursalTelefono;
	}
	/**
	 * @return the empresa
	 */
	public EmpresaVo getEmpresa() {
		return empresa;
	}
	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(EmpresaVo empresa) {
		this.empresa = empresa;
	}

	

}