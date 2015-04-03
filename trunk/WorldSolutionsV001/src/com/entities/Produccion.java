package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the produccion database table.
 * 
 */
@Entity
public class Produccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iProduccionId;

	private String cEstadoCodigo;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private float fCostoTotal;

	private float fCostoUni;

	private int iCantidad;

	private int iUsuarioActualiza;

	private int iUsuarioInsertaId;

    private float fOtrosCostos;
    
	//bi-directional many-to-one association to Produccion
	@OneToMany(mappedBy="produccion", fetch=FetchType.EAGER)
	private List<Producciondetalle> produccionDetalle;
	
	//bi-directional many-to-one association to Produccion
	@OneToMany(mappedBy="produccion",fetch=FetchType.EAGER)
	private List<Producto> producto;
	
	

	private String vDescripcion;
    public Produccion() {
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
	 * @return the dFechaActualiza
	 */
	public Date getdFechaActualiza() {
		return dFechaActualiza;
	}

	/**
	 * @param dFechaActualiza the dFechaActualiza to set
	 */
	public void setdFechaActualiza(Date dFechaActualiza) {
		this.dFechaActualiza = dFechaActualiza;
	}

	/**
	 * @return the dFechaInserta
	 */
	public Date getdFechaInserta() {
		return dFechaInserta;
	}

	/**
	 * @param dFechaInserta the dFechaInserta to set
	 */
	public void setdFechaInserta(Date dFechaInserta) {
		this.dFechaInserta = dFechaInserta;
	}

	/**
	 * @return the fCostoTotal
	 */
	public float getfCostoTotal() {
		return fCostoTotal;
	}

	/**
	 * @param fCostoTotal the fCostoTotal to set
	 */
	public void setfCostoTotal(float fCostoTotal) {
		this.fCostoTotal = fCostoTotal;
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
	 * @return the iUsuarioActualiza
	 */
	public int getiUsuarioActualiza() {
		return iUsuarioActualiza;
	}

	/**
	 * @param iUsuarioActualiza the iUsuarioActualiza to set
	 */
	public void setiUsuarioActualiza(int iUsuarioActualiza) {
		this.iUsuarioActualiza = iUsuarioActualiza;
	}

	/**
	 * @return the iUsuarioInsertaId
	 */
	public int getiUsuarioInsertaId() {
		return iUsuarioInsertaId;
	}

	/**
	 * @param iUsuarioInsertaId the iUsuarioInsertaId to set
	 */
	public void setiUsuarioInsertaId(int iUsuarioInsertaId) {
		this.iUsuarioInsertaId = iUsuarioInsertaId;
	}

	/**
	 * @return the produccionDetalle
	 */
	public List<Producciondetalle> getProduccionDetalle() {
		return produccionDetalle;
	}

	/**
	 * @param produccionDetalle the produccionDetalle to set
	 */
	public void setProduccionDetalle(List<Producciondetalle> produccionDetalle) {
		this.produccionDetalle = produccionDetalle;
	}

	/**
	 * @return the fOtrosCostos
	 */
	public float getfOtrosCostos() {
		return fOtrosCostos;
	}

	/**
	 * @param fOtrosCostos the fOtrosCostos to set
	 */
	public void setfOtrosCostos(float fOtrosCostos) {
		this.fOtrosCostos = fOtrosCostos;
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
	 * @return the producto
	 */
	public List<Producto> getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}

	
}