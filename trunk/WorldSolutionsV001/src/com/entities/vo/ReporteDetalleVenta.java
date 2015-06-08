package com.entities.vo;

import com.entities.Tipodocumentogestion;

public class ReporteDetalleVenta {

	private String tipoDocumento;
	private float totalVentaProducto;
	private float totalVentaServicios;
	private float totalVentaTarjeta;
	private float totalVentaCredito;
	
	public ReporteDetalleVenta(Tipodocumentogestion tipodocumentogestion) {
		tipoDocumento = tipodocumentogestion.getvTipoDocumentoDescripcion(); 
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
	 * @return the totalVentaProducto
	 */
	public float getTotalVentaProducto() {
		return totalVentaProducto;
	}

	/**
	 * @param totalVentaProducto the totalVentaProducto to set
	 */
	public void setTotalVentaProducto(float totalVentaProducto) {
		this.totalVentaProducto = totalVentaProducto;
	}

	/**
	 * @return the totalVentaServicios
	 */
	public float getTotalVentaServicios() {
		return totalVentaServicios;
	}

	/**
	 * @param totalVentaServicios the totalVentaServicios to set
	 */
	public void setTotalVentaServicios(float totalVentaServicios) {
		this.totalVentaServicios = totalVentaServicios;
	}

	/**
	 * @return the totalVentaTarjeta
	 */
	public float getTotalVentaTarjeta() {
		return totalVentaTarjeta;
	}

	/**
	 * @param totalVentaTarjeta the totalVentaTarjeta to set
	 */
	public void setTotalVentaTarjeta(float totalVentaTarjeta) {
		this.totalVentaTarjeta = totalVentaTarjeta;
	}

	/**
	 * @return the totalVentaCredito
	 */
	public float getTotalVentaCredito() {
		return totalVentaCredito;
	}

	/**
	 * @param totalVentaCredito the totalVentaCredito to set
	 */
	public void setTotalVentaCredito(float totalVentaCredito) {
		this.totalVentaCredito = totalVentaCredito;
	}

	public float getTotalVenta() {
		return totalVentaProducto + totalVentaServicios;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((tipoDocumento == null) ? 0 : tipoDocumento.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReporteDetalleVenta other = (ReporteDetalleVenta) obj;
		if (tipoDocumento == null) {
			if (other.tipoDocumento != null)
				return false;
		} else if (!tipoDocumento.equals(other.tipoDocumento))
			return false;
		return true;
	}
	
	
	
}
