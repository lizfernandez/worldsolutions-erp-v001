package com.entities.vo;

public class PagoEstadoCuentaVo {
private int iEstadoCuenta;
private String fechaPago;
private String montoPago;
private String vendedor;



/**
 * @return the iEstadoCuenta
 */
public int getiEstadoCuenta() {
	return iEstadoCuenta;
}
/**
 * @param iEstadoCuenta the iEstadoCuenta to set
 */
public void setiEstadoCuenta(int iEstadoCuenta) {
	this.iEstadoCuenta = iEstadoCuenta;
}
/**
 * @return the fechaPago
 */
public String getFechaPago() {
	return fechaPago;
}
/**
 * @param fechaPago the fechaPago to set
 */
public void setFechaPago(String fechaPago) {
	this.fechaPago = fechaPago;
}
/**
 * @return the montoPago
 */
public String getMontoPago() {
	return montoPago;
}
/**
 * @param montoPago the montoPago to set
 */
public void setMontoPago(String montoPago) {
	this.montoPago = montoPago;
}
/**
 * @return the vendedor
 */
public String getVendedor() {
	return vendedor;
}
/**
 * @param vendedor the vendedor to set
 */
public void setVendedor(String vendedor) {
	this.vendedor = vendedor;
}



}
