package com.entities.vo;

import java.util.ArrayList;
import java.util.List;

import com.entities.Personal;
import com.entities.Sucursal;

public class ServicioPersonalVo {

	private PersonalVo personal;;
	private List<DetalleServicioSucursalVo> detalleServicioSucursalVo;
	
	public ServicioPersonalVo(Personal personal, List<String> fechas, List<Sucursal> listaSucursales) {
		this.personal = personal == null ? null : new PersonalVo(personal);
		this.detalleServicioSucursalVo = new ArrayList<DetalleServicioSucursalVo>();
		for (Sucursal sucursal : listaSucursales) {
			this.detalleServicioSucursalVo.add(new DetalleServicioSucursalVo(sucursal, fechas));
			
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
				+ ((personal == null) ? 0 : personal.hashCode());
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
		ServicioPersonalVo other = (ServicioPersonalVo) obj;
		if (personal == null) {
			if (other.personal != null)
				return false;
		} else if (!personal.equals(other.personal))
			return false;
		return true;
	}


	/**
	 * @return the personal
	 */
	public PersonalVo getPersonal() {
		return personal;
	}

	/**
	 * @param personal the personal to set
	 */
	public void setPersonal(PersonalVo personal) {
		this.personal = personal;
	}

	/**
	 * @return the totalNeto
	 */
	public float getTotalNeto() {
		float totalNeto = 0;
		if (detalleServicioSucursalVo.size() > 0) {
			
			for (DetalleServicioSucursalVo detalle : detalleServicioSucursalVo) {
				totalNeto += detalle.getTotalSucursal();
			}
		}
		return totalNeto;
	}

	/**
	 * @return the procentaje
	 */
	public float getPorcentaje() {
		float totalCosto = 0;
		if (detalleServicioSucursalVo.size() > 0) {
			
			for (DetalleServicioSucursalVo detalle : detalleServicioSucursalVo) {
				totalCosto += detalle.getTotalCostoSucursal();
			}
		}
		return totalCosto;
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
	public void setDetalleServicioSucursalVo(
			List<DetalleServicioSucursalVo> detalleServicioSucursalVo) {
		this.detalleServicioSucursalVo = detalleServicioSucursalVo;
	}
	
}
