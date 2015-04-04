package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the ventadetalle database table.
 * 
 */
@Entity
@Table(name="ventadetalle")
public class Ventadetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int iVentaDetalleId;

	@Column(nullable=false, length=2)
	private String cEstadoCodigo;

    @Temporal( TemporalType.DATE)
	private Date dFechaActualiza;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date dFechaInserta;

	@Column(nullable=false)
	private float fVentaDetallePrecio;

	@Column(nullable=false)
	private float fVentaDetalleTotal;

	private int iUsuarioActualizaId;

	@Column(nullable=false)
	private int iUsuarioInsertaId;

	@Column(nullable=false)
	private int iVentaDetalleCantidad;

	//bi-directional many-to-one association to Producto
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name="iProductoId", nullable=false)
	private Producto producto;

	//bi-directional many-to-one association to Venta
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="iVentaId", nullable=false)
	private Venta venta;
    
    @Column(nullable=false)
	private float fDescuento;
    
    //bi-directional many-to-one association to Venta
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="iPersonalId", nullable=false)	
    private Personal personal;
    
    private int iSubCta;
    
    public Ventadetalle() {
    }

	/**
	 * @return the iVentaDetalleId
	 */
	public int getiVentaDetalleId() {
		return iVentaDetalleId;
	}

	/**
	 * @param iVentaDetalleId the iVentaDetalleId to set
	 */
	public void setiVentaDetalleId(int iVentaDetalleId) {
		this.iVentaDetalleId = iVentaDetalleId;
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
	 * @return the fVentaDetallePrecio
	 */
	public float getfVentaDetallePrecio() {
		return fVentaDetallePrecio;
	}

	/**
	 * @param fVentaDetallePrecio the fVentaDetallePrecio to set
	 */
	public void setfVentaDetallePrecio(float fVentaDetallePrecio) {
		this.fVentaDetallePrecio = fVentaDetallePrecio;
	}

	/**
	 * @return the fVentaDetalleTotal
	 */
	public float getfVentaDetalleTotal() {
		return fVentaDetalleTotal;
	}

	/**
	 * @param fVentaDetalleTotal the fVentaDetalleTotal to set
	 */
	public void setfVentaDetalleTotal(float fVentaDetalleTotal) {
		this.fVentaDetalleTotal = fVentaDetalleTotal;
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
	 * @return the iVentaDetalleCantidad
	 */
	public int getiVentaDetalleCantidad() {
		return iVentaDetalleCantidad;
	}

	/**
	 * @param iVentaDetalleCantidad the iVentaDetalleCantidad to set
	 */
	public void setiVentaDetalleCantidad(int iVentaDetalleCantidad) {
		this.iVentaDetalleCantidad = iVentaDetalleCantidad;
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
	 * @return the venta
	 */
	public Venta getVenta() {
		return venta;
	}

	/**
	 * @param venta the venta to set
	 */
	public void setVenta(Venta venta) {
		this.venta = venta;
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
	 * @return the iSubCta
	 */
	public int getiSubCta() {
		return iSubCta;
	}

	/**
	 * @param iSubCta the iSubCta to set
	 */
	public void setiSubCta(int iSubCta) {
		this.iSubCta = iSubCta;
	}

	

	
	
}