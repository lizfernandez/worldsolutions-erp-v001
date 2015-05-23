package com.entities.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.entities.Produccion;

public class ProduccionVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int iProduccionId;
	private String cEstadoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private float fCostoTotal;
	private float fCostoUni;
	private int iCantidad;
	private int iUsuarioActualiza;
	private int iUsuarioInsertaId;
    private float fOtrosCostos;
	private List<ProducciondetalleVo> produccionDetalle;
	

    public ProduccionVo() {
    }

	public ProduccionVo(Produccion produccion) {
		
		this.iProduccionId = produccion.getiProduccionId();
		this.cEstadoCodigo = produccion.getcEstadoCodigo();
		this.dFechaActualiza = produccion.getdFechaActualiza();
		this.dFechaInserta = produccion.getdFechaInserta();
		this.fCostoTotal = produccion.getfCostoTotal();
		this.fCostoUni = produccion.getfCostoUni();
		this.iCantidad = produccion.getiCantidad();
		this.iUsuarioActualiza = produccion.getiUsuarioActualiza();
		this.iUsuarioInsertaId = produccion.getiUsuarioInsertaId();
		this.fOtrosCostos = produccion.getfOtrosCostos();
		//this.produccionDetalle = produccion.getProduccionDetalle();
	}

	public int getiProduccionId() {
		return iProduccionId;
	}

	public void setiProduccionId(int iProduccionId) {
		this.iProduccionId = iProduccionId;
	}

	public String getcEstadoCodigo() {
		return cEstadoCodigo;
	}

	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}

	public Date getdFechaActualiza() {
		return dFechaActualiza;
	}

	public void setdFechaActualiza(Date dFechaActualiza) {
		this.dFechaActualiza = dFechaActualiza;
	}

	public Date getdFechaInserta() {
		return dFechaInserta;
	}

	public void setdFechaInserta(Date dFechaInserta) {
		this.dFechaInserta = dFechaInserta;
	}

	public float getfCostoTotal() {
		return fCostoTotal;
	}

	public void setfCostoTotal(float fCostoTotal) {
		this.fCostoTotal = fCostoTotal;
	}

	public float getfCostoUni() {
		return fCostoUni;
	}

	public void setfCostoUni(float fCostoUni) {
		this.fCostoUni = fCostoUni;
	}

	public int getiCantidad() {
		return iCantidad;
	}

	public void setiCantidad(int iCantidad) {
		this.iCantidad = iCantidad;
	}

	public int getiUsuarioActualiza() {
		return iUsuarioActualiza;
	}

	public void setiUsuarioActualiza(int iUsuarioActualiza) {
		this.iUsuarioActualiza = iUsuarioActualiza;
	}

	public int getiUsuarioInsertaId() {
		return iUsuarioInsertaId;
	}

	public void setiUsuarioInsertaId(int iUsuarioInsertaId) {
		this.iUsuarioInsertaId = iUsuarioInsertaId;
	}

	public float getfOtrosCostos() {
		return fOtrosCostos;
	}

	public void setfOtrosCostos(float fOtrosCostos) {
		this.fOtrosCostos = fOtrosCostos;
	}

	public List<ProducciondetalleVo> getProduccionDetalle() {
		return produccionDetalle;
	}

	public void setProduccionDetalle(List<ProducciondetalleVo> produccionDetalle) {
		this.produccionDetalle = produccionDetalle;
	}

}