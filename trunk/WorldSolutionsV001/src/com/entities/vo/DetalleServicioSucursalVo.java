package com.entities.vo;

import java.util.ArrayList;
import java.util.List;

import com.entities.Sucursal;

public class DetalleServicioSucursalVo {

	private SucursalVo sucursal;
	private List<DetalleServicioDiarioVo> detalleServicioDiarioVo;
	
	public DetalleServicioSucursalVo(Sucursal sucursal, List<String> fechas) {
		this.sucursal = sucursal == null ? null : new SucursalVo(sucursal);
		this.detalleServicioDiarioVo = new ArrayList<DetalleServicioDiarioVo>();
		for (String fecha : fechas) {
			this.detalleServicioDiarioVo.add(new DetalleServicioDiarioVo(fecha));
			
		}
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
	public float getTotalSucursal() {
		float totalSucursal = 0;
		for (DetalleServicioDiarioVo detalle : detalleServicioDiarioVo) {
			totalSucursal = totalSucursal + detalle.getTotalServicio();
		}
		return totalSucursal;
	}

	/**
	 * @return the totalServicioSucursal
	 */
	public float getTotalCostoSucursal() {
		float totalSucursal = 0;
		for (DetalleServicioDiarioVo detalle : detalleServicioDiarioVo) {
			totalSucursal = totalSucursal + detalle.getTotalCostoServicio();
		}
		return totalSucursal;
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

	/**
	 * @return the detalleServicioDiarioVo
	 */
	public List<DetalleServicioDiarioVo> getDetalleServicioDiarioVo() {
		return detalleServicioDiarioVo;
	}

	/**
	 * @param detalleServicioDiarioVo the detalleServicioDiarioVo to set
	 */
	public void setDetalleServicioDiarioVo(List<DetalleServicioDiarioVo> detalleServicioDiarioVo) {
		this.detalleServicioDiarioVo = detalleServicioDiarioVo;
	}
	
	public int totalSucursales() {
		return detalleServicioDiarioVo.size();
	}
	
}
