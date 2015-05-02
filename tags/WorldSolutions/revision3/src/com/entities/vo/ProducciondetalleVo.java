package com.entities.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.entities.Personal;
import com.entities.Produccion;
import com.entities.Producto;

public class ProducciondetalleVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iProduccionDetalleId;
	private String cEstadoCodigo;
	private float fTotal;
	private int iCantidad;
	private int iProduccionId;
	private int iProductoId;	
	private float fCostoUni;
	private Personal personal;
    private Producto producto;
	private String vDescripcion;
	private Produccion produccion;
  	private float fDescuento;
    

	public ProducciondetalleVo() {
    }


	/**
	 * @return the iProduccionDetalleId
	 */
	public int getiProduccionDetalleId() {
		return iProduccionDetalleId;
	}


	/**
	 * @param iProduccionDetalleId the iProduccionDetalleId to set
	 */
	public void setiProduccionDetalleId(int iProduccionDetalleId) {
		this.iProduccionDetalleId = iProduccionDetalleId;
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
	 * @return the fTotal
	 */
	public float getfTotal() {
		return fTotal;
	}


	/**
	 * @param fTotal the fTotal to set
	 */
	public void setfTotal(float fTotal) {
		this.fTotal = fTotal;
	}


	/**
	 * @return the iCantidad
	 */
	public int getiCantidad() {
		return iCantidad;
	}


	/**
	 * @param iCantidad the iCantidad to set
	 */
	public void setiCantidad(int iCantidad) {
		this.iCantidad = iCantidad;
	}


	/**
	 * @return the iProduccionId
	 */
	public int getiProduccionId() {
		return iProduccionId;
	}


	/**
	 * @param iProduccionId the iProduccionId to set
	 */
	public void setiProduccionId(int iProduccionId) {
		this.iProduccionId = iProduccionId;
	}


	/**
	 * @return the iProductoId
	 */
	public int getiProductoId() {
		return iProductoId;
	}


	/**
	 * @param iProductoId the iProductoId to set
	 */
	public void setiProductoId(int iProductoId) {
		this.iProductoId = iProductoId;
	}


	/**
	 * @return the fCostoUni
	 */
	public float getfCostoUni() {
		return fCostoUni;
	}


	/**
	 * @param fCostoUni the fCostoUni to set
	 */
	public void setfCostoUni(float fCostoUni) {
		this.fCostoUni = fCostoUni;
	}


	/**
	 * @return the personal
	 */
	public Personal getPersonal() {
		return personal;
	}


	/**
	 * @param personal the personal to set
	 */
	public void setPersonal(Personal personal) {
		this.personal = personal;
	}


	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}


	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	/**
	 * @return the vDescripcion
	 */
	public String getvDescripcion() {
		return vDescripcion;
	}


	/**
	 * @param vDescripcion the vDescripcion to set
	 */
	public void setvDescripcion(String vDescripcion) {
		this.vDescripcion = vDescripcion;
	}


	/**
	 * @return the produccion
	 */
	public Produccion getProduccion() {
		return produccion;
	}


	/**
	 * @param produccion the produccion to set
	 */
	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}


	/**
	 * @return the fDescuento
	 */
	public float getfDescuento() {
		return fDescuento;
	}


	/**
	 * @param fDescuento the fDescuento to set
	 */
	public void setfDescuento(float fDescuento) {
		this.fDescuento = fDescuento;
	}


}