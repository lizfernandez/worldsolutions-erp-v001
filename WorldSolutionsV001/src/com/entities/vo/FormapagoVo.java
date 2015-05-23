package com.entities.vo;

import java.io.Serializable;

import com.entities.Formapago;

/**
 * The persistent class for the formapago database table.
 * 
 */

public class FormapagoVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iFormaPago;
	private String vFormaPagoDescripcion;

    public FormapagoVo() {
    }

	public FormapagoVo(Formapago formaPago) {
		
		this.iFormaPago = formaPago.getiFormaPago();
		this.vFormaPagoDescripcion = formaPago.getvFormaPagoDescripcion();
	}

	/**
	 * @return the iFormaPago
	 */
	public int getiFormaPago() {
		return iFormaPago;
	}

	/**
	 * @param iFormaPago the iFormaPago to set
	 */
	public void setiFormaPago(int iFormaPago) {
		this.iFormaPago = iFormaPago;
	}

	/**
	 * @return the vFormaPagoDescripcion
	 */
	public String getvFormaPagoDescripcion() {
		return vFormaPagoDescripcion;
	}

	/**
	 * @param vFormaPagoDescripcion the vFormaPagoDescripcion to set
	 */
	public void setvFormaPagoDescripcion(String vFormaPagoDescripcion) {
		this.vFormaPagoDescripcion = vFormaPagoDescripcion;
	}

	/**
	 * @return the ventas
	 *//*
	public List<Venta> getVentas() {
		return ventas;
	}

	*//**
	 * @param ventas the ventas to set
	 *//*
	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}*/

	
}