package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the producciondetalle database table.
 * 
 */
@Entity
public class Producciondetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iProduccionDetalleId;

	private String cEstadoCodigo;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private float fCostoUni;

	private float fTotal;

	private int iCantidad;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iPersonalId", nullable=false)
	private Personal personal;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iProductoId", nullable=false)
	private Producto producto;

	private int iUsuarioActualizaId;

	private int iUsuarioInsertaId;

	private String vDescripcion;
	//bi-directional many-to-one association to Tipodocumento
    @ManyToOne(fetch=FetchType.LAZY )
	@JoinColumn(name="iProduccionId", nullable=false)
	private Produccion produccion;
    
    @Column(nullable=false)
	private float fDescuento;
    
    public Producciondetalle() {
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
	 * @return the iUsuarioActualizaId
	 */
	public int getiUsuarioActualizaId() {
		return iUsuarioActualizaId;
	}


	/**
	 * @param iUsuarioActualizaId the iUsuarioActualizaId to set
	 */
	public void setiUsuarioActualizaId(int iUsuarioActualizaId) {
		this.iUsuarioActualizaId = iUsuarioActualizaId;
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