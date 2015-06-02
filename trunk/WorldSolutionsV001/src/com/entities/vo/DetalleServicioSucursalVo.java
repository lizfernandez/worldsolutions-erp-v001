package com.entities.vo;

import com.entities.Sucursal;

public class DetalleServicioSucursalVo {

	private SucursalVo sucursal;
	private float totalServicioSucursal;
	
	public DetalleServicioSucursalVo(Sucursal sucursal) {
		this.sucursal = sucursal == null ? null : new SucursalVo(sucursal);
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
	 * @return the totalServicioSucursal
	 */
	public float getTotalServicioSucursal() {
		return totalServicioSucursal;
	}

	/**
	 * @param totalServicioSucursal the totalServicioSucursal to set
	 */
	public void setTotalServicioSucursal(float totalServicioSucursal) {
		this.totalServicioSucursal = totalServicioSucursal;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sucursal == null) ? 0 : sucursal.hashCode());
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
		DetalleServicioSucursalVo other = (DetalleServicioSucursalVo) obj;
		if (sucursal == null) {
			if (other.sucursal != null)
				return false;
		} else if (!sucursal.equals(other.sucursal))
			return false;
		return true;
	}
	
}
