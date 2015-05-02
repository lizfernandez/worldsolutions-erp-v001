package com.entities.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the estadocuentaproveedor database table.
 * 
 */

public class EstadocuentaproveedorVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iEstadoCuentaProveedor;
	private String cEstadoCodigo;
	private Date dFechaInserta;
	private Date dFechaPago;
	private float fMontoPago;
	private int iUsuarioInsertaId;
	private IngresoproductoVo ingresoproducto;
	private ProveedorVo proveedor;
    
    
    @Column(length=45)
    private String sVendedor;
    
    public EstadocuentaproveedorVo() {
    }

	

	/**
	 * @return the iEstadoCuentaProveedor
	 */
	public int getiEstadoCuentaProveedor() {
		return iEstadoCuentaProveedor;
	}



	/**
	 * @param iEstadoCuentaProveedor the iEstadoCuentaProveedor to set
	 */
	public void setiEstadoCuentaProveedor(int iEstadoCuentaProveedor) {
		this.iEstadoCuentaProveedor = iEstadoCuentaProveedor;
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
	 * @return the fMontoPago
	 */
	public float getfMontoPago() {
		return fMontoPago;
	}

	/**
	 * @param fMontoPago the fMontoPago to set
	 */
	public void setfMontoPago(float fMontoPago) {
		this.fMontoPago = fMontoPago;
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
	 * @return the ingresoproducto
	 */
	public IngresoproductoVo getIngresoproducto() {
		return ingresoproducto;
	}

	/**
	 * @param ingresoproducto the ingresoproducto to set
	 */
	public void setIngresoproducto(IngresoproductoVo ingresoproducto) {
		this.ingresoproducto = ingresoproducto;
	}

	



	/**
	 * @return the proveedor
	 */
	public ProveedorVo getProveedor() {
		return proveedor;
	}



	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(ProveedorVo proveedor) {
		this.proveedor = proveedor;
	}



	/**
	 * @return the sVendedor
	 */
	public String getsVendedor() {
		return sVendedor;
	}



	/**
	 * @param sVendedor the sVendedor to set
	 */
	public void setsVendedor(String sVendedor) {
		this.sVendedor = sVendedor;
	}

	
	
}