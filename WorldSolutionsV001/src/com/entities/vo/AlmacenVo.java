package com.entities.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.entities.Almacen;
import com.entities.Sucursal;

public class AlmacenVo implements Serializable {
	
	private int iAlmacenId;
	private String cEstadoCodigo;
	private String cAlmacenCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private SucursalVo sucursal;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
	private String vAlmacenDireccion;
	private String vAlmacenNombre;
	private String vAlmacenTelefono;
	
	public AlmacenVo() {
	}
	
	public AlmacenVo(Almacen almacen) {
		super();
		this.iAlmacenId = almacen.getiAlmacenId();
		this.cEstadoCodigo = almacen.getcEstadoCodigo();
		this.cAlmacenCodigo = almacen.getcAlmacenCodigo();
		this.dFechaActualiza = almacen.getdFechaActualiza();
		this.dFechaInserta = almacen.getdFechaInserta();
		this.sucursal = new SucursalVo(almacen.getSucursal());
		this.iUsuarioActualizaId = almacen.getiUsuarioActualizaId();
		this.iUsuarioInsertaId = almacen.getiUsuarioInsertaId();
		this.vAlmacenDireccion = almacen.getvAlmacenDireccion();
		this.vAlmacenNombre = almacen.getvAlmacenNombre();
		this.vAlmacenTelefono = almacen.getvAlmacenTelefono();
	}

	/**
	 * @return the iAlmacenId
	 */
	public int getiAlmacenId() {
		return iAlmacenId;
	}

	/**
	 * @param iAlmacenId the iAlmacenId to set
	 */
	public void setiAlmacenId(int iAlmacenId) {
		this.iAlmacenId = iAlmacenId;
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
	 * @return the cAlmacenCodigo
	 */
	public String getcAlmacenCodigo() {
		return cAlmacenCodigo;
	}

	/**
	 * @param cAlmacenCodigo the cAlmacenCodigo to set
	 */
	public void setcAlmacenCodigo(String cAlmacenCodigo) {
		this.cAlmacenCodigo = cAlmacenCodigo;
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
	 * @return the sucursal
	 */
	public SucursalVo getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(SucursalVo sucursal) {
		this.sucursal = sucursal;
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
	 * @return the vAlmacenDireccion
	 */
	public String getvAlmacenDireccion() {
		return vAlmacenDireccion;
	}

	/**
	 * @param vAlmacenDireccion the vAlmacenDireccion to set
	 */
	public void setvAlmacenDireccion(String vAlmacenDireccion) {
		this.vAlmacenDireccion = vAlmacenDireccion;
	}

	/**
	 * @return the vAlmacenNombre
	 */
	public String getvAlmacenNombre() {
		return vAlmacenNombre;
	}

	/**
	 * @param vAlmacenNombre the vAlmacenNombre to set
	 */
	public void setvAlmacenNombre(String vAlmacenNombre) {
		this.vAlmacenNombre = vAlmacenNombre;
	}

	/**
	 * @return the vAlmacenTelefono
	 */
	public String getvAlmacenTelefono() {
		return vAlmacenTelefono;
	}

	/**
	 * @param vAlmacenTelefono the vAlmacenTelefono to set
	 */
	public void setvAlmacenTelefono(String vAlmacenTelefono) {
		this.vAlmacenTelefono = vAlmacenTelefono;
	}
	
	
	
}
