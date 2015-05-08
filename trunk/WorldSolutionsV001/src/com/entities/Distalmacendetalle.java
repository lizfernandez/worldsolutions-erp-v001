package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the distalmacendetalle database table.
 * 
 */
@Entity
public class Distalmacendetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iDistAlmacenDetId;

	private String cEstadoCodigo;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaInserta;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaSalida;

	private float fTotal;

	private int iCantidad;
	@ManyToOne
	@JoinColumn(name="iDistAlmacenId", nullable=false)	
	private Distalmacen distAlmacen;
	@ManyToOne
	@JoinColumn(name="iProductoId", nullable=false)
	private Producto producto;

	private int iUsuarioActualizaId;

	private int iUsuarioInsertaId;

    public Distalmacendetalle() {
    }

	/**
	 * @return the iDistAlmacenDetId
	 */
	public int getiDistAlmacenDetId() {
		return iDistAlmacenDetId;
	}

	/**
	 * @param iDistAlmacenDetId the iDistAlmacenDetId to set
	 */
	public void setiDistAlmacenDetId(int iDistAlmacenDetId) {
		this.iDistAlmacenDetId = iDistAlmacenDetId;
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
	 * @return the dFechaSalida
	 */
	public Date getdFechaSalida() {
		return dFechaSalida;
	}

	/**
	 * @param dFechaSalida the dFechaSalida to set
	 */
	public void setdFechaSalida(Date dFechaSalida) {
		this.dFechaSalida = dFechaSalida;
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
	 * @return the distAlmacen
	 */
	public Distalmacen getDistAlmacen() {
		return distAlmacen;
	}

	/**
	 * @param distAlmacen the distAlmacen to set
	 */
	public void setDistAlmacen(Distalmacen distAlmacen) {
		this.distAlmacen = distAlmacen;
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

	

}