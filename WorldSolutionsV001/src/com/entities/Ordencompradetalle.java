package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the ordencompradetalle database table.
 * 
 */
@Entity
public class Ordencompradetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iOrdenCompraDetalleId;

	private String cEstadoCodigo;

    @Temporal( TemporalType.DATE)
	private Date dFechaActualiza;

    @Temporal( TemporalType.DATE)
	private Date dFechaInserta;

	private float fDescuento;

	private float fPrecio;

	private float fTotal;

	private int iCantidad;
	@ManyToOne
	@JoinColumn(name="iOrdenCompraId", nullable=false)
	private Ordencompra ordenCompra;

	@ManyToOne
	@JoinColumn(name="iProductoId", nullable=false)	
	private Producto producto;

	private int iUsuarioActualizaId;

	private int iUsuarioInsertaId;

    public Ordencompradetalle() {
    }

	/**
	 * @return the iOrdenCompraDetalleId
	 */
	public int getiOrdenCompraDetalleId() {
		return iOrdenCompraDetalleId;
	}

	/**
	 * @param iOrdenCompraDetalleId the iOrdenCompraDetalleId to set
	 */
	public void setiOrdenCompraDetalleId(int iOrdenCompraDetalleId) {
		this.iOrdenCompraDetalleId = iOrdenCompraDetalleId;
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

	/**
	 * @return the fPrecio
	 */
	public float getfPrecio() {
		return fPrecio;
	}

	/**
	 * @param fPrecio the fPrecio to set
	 */
	public void setfPrecio(float fPrecio) {
		this.fPrecio = fPrecio;
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
	 * @return the ordenCompra
	 */
	public Ordencompra getOrdenCompra() {
		return ordenCompra;
	}

	/**
	 * @param ordenCompra the ordenCompra to set
	 */
	public void setOrdenCompra(Ordencompra ordenCompra) {
		this.ordenCompra = ordenCompra;
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