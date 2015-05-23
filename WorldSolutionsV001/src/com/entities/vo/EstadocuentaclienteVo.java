package com.entities.vo;

import java.io.Serializable;
import javax.persistence.*;

import com.entities.Estadocuentacliente;

import java.util.Date;


/**
 * The persistent class for the estadocuentacliente database table.
 * 
 */

public class EstadocuentaclienteVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iEstadoCuentaCliente;
	private String cEstadoCodigo;
	private Date dFechaInserta;
	private Date dFechaPago;
	private float fMontoPago;
	private int iUsuarioInsertaId;	
	private VentaVo venta;
	private ClienteVo cliente;
    
   

    public EstadocuentaclienteVo() {
    }

	
/*
	*//**
	 * @return the iVentaId
	 *//*
	public int getiVentaId() {
		return iVentaId;
	}



	*//**
	 * @param iVentaId the iVentaId to set
	 *//*
	public void setiVentaId(int iVentaId) {
		this.iVentaId = iVentaId;
	}

*/

	public EstadocuentaclienteVo(Estadocuentacliente estadocuentacliente) {
		this.iEstadoCuentaCliente = estadocuentacliente.getiEstadoCuentaCliente();
		this.cEstadoCodigo = estadocuentacliente.getcEstadoCodigo();
		this.dFechaInserta = estadocuentacliente.getdFechaInserta();
		this.dFechaPago = estadocuentacliente.getdFechaPago();
		this.fMontoPago = estadocuentacliente.getfMontoPago();
		this.iUsuarioInsertaId = estadocuentacliente.getiUsuarioInsertaId();
		this.venta = new VentaVo(estadocuentacliente.getVenta());
		this.cliente = new ClienteVo(estadocuentacliente.getCliente());
	
	}


	/**
	 * @return the iEstadoCuentaCliente
	 */
	public int getiEstadoCuentaCliente() {
		return iEstadoCuentaCliente;
	}



	/**
	 * @param iEstadoCuentaCliente the iEstadoCuentaCliente to set
	 */
	public void setiEstadoCuentaCliente(int iEstadoCuentaCliente) {
		this.iEstadoCuentaCliente = iEstadoCuentaCliente;
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

	

	

}