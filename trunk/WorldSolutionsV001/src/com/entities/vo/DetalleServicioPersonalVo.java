package com.entities.vo;

import java.util.ArrayList;
import java.util.List;

import com.entities.Sucursal;

public class DetalleServicioPersonalVo {

	private String fechaServicio;
	private float totalServicio;
	private List<DetalleServicioSucursalVo> detalleServicioSucursalVo;
	
	public DetalleServicioPersonalVo(String fechaServicio, List<Sucursal> listaSucursales) {
		this.fechaServicio = fechaServicio;
		this.detalleServicioSucursalVo = new ArrayList<DetalleServicioSucursalVo>();
		for (Sucursal sucursal : listaSucursales) {
			this.detalleServicioSucursalVo.add(new DetalleServicioSucursalVo(sucursal));
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fechaServicio == null) ? 0 : fechaServicio.hashCode());
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
		DetalleServicioPersonalVo other = (DetalleServicioPersonalVo) obj;
		if (fechaServicio == null) {
			if (other.fechaServicio != null)
				return false;
		} else if (!fechaServicio.equals(other.fechaServicio))
			return false;
		return true;
	}

	/**
	 * @return the fechaServicio
	 */
	public String getFechaServicio() {
		return fechaServicio;
	}

	/**
	 * @param fechaServicio the fechaServicio to set
	 */
	public void setFechaServicio(String fechaServicio) {
		this.fechaServicio = fechaServicio;
	}

	/**
	 * @return the totalServicio
	 */
	public float getTotalServicio() {
		totalServicio = 0;
		if (detalleServicioSucursalVo.size() > 0) {
			for (DetalleServicioSucursalVo detalle : detalleServicioSucursalVo) {
				totalServicio += detalle.getTotalServicioSucursal();
			}
		}
		return totalServicio;
	}

	/**
	 * @return the detalleServicioSucursalVo
	 */
	public List<DetalleServicioSucursalVo> getDetalleServicioSucursalVo() {
		return detalleServicioSucursalVo;
	}

	/**
	 * @param detalleServicioSucursalVo the detalleServicioSucursalVo to set
	 */
	public void setDetalleServicioSucursalVo(List<DetalleServicioSucursalVo> detalleServicioSucursalVo) {
		this.detalleServicioSucursalVo = detalleServicioSucursalVo;
	}
	
	
	
}
