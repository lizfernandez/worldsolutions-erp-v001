package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the ventadevoluciondetalle database table.
 * 
 */
@Entity
public class Ventadevoluciondetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iVentaDevolucionDetalleId;

	private String cEstadoCodigo;

    @Temporal( TemporalType.DATE)
	private Date dFechaActualiza;

    @Temporal( TemporalType.DATE)
	private Date dFechaInserta;

	private int iVentaDevDetalleCantidad;

	private float fVentaDevDetallePrecio;

	private float fVentaDevDetalleTotal;
	
	@ManyToOne
	@JoinColumn(name="iVentaDevolucionId", nullable=false)
	private Ventadevolucion ventadevolucion;
	
	@ManyToOne
	@JoinColumn(name="iProductoId", nullable=false)
	private Producto producto;

	private int iUsuarioActualizaId;

	private int iUsuarioInsertaId;
    
    private float fDescuento;
    
    private int iSubCta;
    
    public Ventadevoluciondetalle() {
    }

	/**
	 * @return the iVentaDevolucionDetalleId
	 */
	public int getiVentaDevolucionDetalleId() {
		return iVentaDevolucionDetalleId;
	}

	/**
	 * @param iVentaDevolucionDetalleId the iVentaDevolucionDetalleId to set
	 */
	public void setiVentaDevolucionDetalleId(int iVentaDevolucionDetalleId) {
		this.iVentaDevolucionDetalleId = iVentaDevolucionDetalleId;
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
	 * @return the iVentaDevDetalleCantidad
	 */
	public int getiVentaDevDetalleCantidad() {
		return iVentaDevDetalleCantidad;
	}

	/**
	 * @param iVentaDevDetalleCantidad the iVentaDevDetalleCantidad to set
	 */
	public void setiVentaDevDetalleCantidad(int iVentaDevDetalleCantidad) {
		this.iVentaDevDetalleCantidad = iVentaDevDetalleCantidad;
	}

	/**
	 * @return the fVentaDevDetallePrecio
	 */
	public float getfVentaDevDetallePrecio() {
		return fVentaDevDetallePrecio;
	}

	/**
	 * @param fVentaDevDetallePrecio the fVentaDevDetallePrecio to set
	 */
	public void setfVentaDevDetallePrecio(float fVentaDevDetallePrecio) {
		this.fVentaDevDetallePrecio = fVentaDevDetallePrecio;
	}

	/**
	 * @return the fVentaDevDetalleTotal
	 */
	public float getfVentaDevDetalleTotal() {
		return fVentaDevDetalleTotal;
	}

	/**
	 * @param fVentaDevDetalleTotal the fVentaDevDetalleTotal to set
	 */
	public void setfVentaDevDetalleTotal(float fVentaDevDetalleTotal) {
		this.fVentaDevDetalleTotal = fVentaDevDetalleTotal;
	}

	/**
	 * @return the ventadevolucion
	 */
	public Ventadevolucion getVentadevolucion() {
		return ventadevolucion;
	}

	/**
	 * @param ventadevolucion the ventadevolucion to set
	 */
	public void setVentadevolucion(Ventadevolucion ventadevolucion) {
		this.ventadevolucion = ventadevolucion;
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