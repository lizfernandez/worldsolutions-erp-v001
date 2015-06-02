package com.entities.vo;

import java.util.ArrayList;
import java.util.List;

import com.entities.Personal;

public class ServicioPersonalVo {

	private PersonalVo personal;
	private float totalNeto;
	private float procentaje;
	private List<DetalleServicioPersonalVo> detalleServicioPersonalVo;
	
	public ServicioPersonalVo(Personal personal) {
		this.personal = personal == null ? null : new PersonalVo(personal);
		this.detalleServicioPersonalVo = new ArrayList<DetalleServicioPersonalVo>();
	
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
		return totalNeto;
	}

	/**
	 * @param totalNeto the totalNeto to set
	 */
	public void setTotalNeto(float totalNeto) {
		this.totalNeto = totalNeto;
	}

	/**
	 * @return the procentaje
	 */
	public float getProcentaje() {
		return procentaje;
	}

	/**
	 * @param procentaje the procentaje to set
	 */
	public void setProcentaje(float procentaje) {
		this.procentaje = procentaje;
	}

	/**
	 * @return the detalleServicioPersonalVo
	 */
	public List<DetalleServicioPersonalVo> getDetalleServicioPersonalVo() {
		return detalleServicioPersonalVo;
	}

	/**
	 * @param detalleServicioPersonalVo the detalleServicioPersonalVo to set
	 */
	public void setDetalleServicioPersonalVo(List<DetalleServicioPersonalVo> detalleServicioPersonalVo) {
		this.detalleServicioPersonalVo = detalleServicioPersonalVo;
	}
	
	
	
}
