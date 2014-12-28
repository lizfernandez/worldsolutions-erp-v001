package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the kardex database table.
 * 
 */
@Entity
@Table(name="Kardex")
public class Kardex implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int iKardexId;

	private String cEstadoCodigo;

    @Temporal( TemporalType.DATE)
	private Date dFecha;

    @Temporal( TemporalType.DATE)
	private Date dFechaActualiza;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dFechaInserta;

	private float fPuExistencia;

	private float fPuIngresoProducto;

	private float fPuVenta;

	private float fTotalExistencia;

	private float fTotalngresoProducto;

	private float fTotalVenta;

	private int iCantExistencia;

	private int iCantIngresoProducto;

	private int iCantVenta;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch=FetchType.LAZY)
	@JoinColumn(name="iIngresoProductoId", nullable=false)
	private Ingresoproducto ingresoProducto ;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch=FetchType.LAZY)
	@JoinColumn(name="iProductoId", nullable=false )
	private Producto producto;

	private int iUsuarioActualizaId;

	private int iUsuarioInsertaId;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch=FetchType.LAZY)
	@JoinColumn(name="iVentaId", nullable=false)	
	private Venta venta;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch=FetchType.LAZY)
	@JoinColumn(name="iVentaDevolucionId", nullable=false)	
	private Ventadevolucion ventadevolucion;
	
		
	private int iPeriodoId;
	
	private String vConcepto;

    public Kardex() {
    }

	/**
	 * @return the iKardexId
	 */
	public int getiKardexId() {
		return iKardexId;
	}

	/**
	 * @param iKardexId the iKardexId to set
	 */
	public void setiKardexId(int iKardexId) {
		this.iKardexId = iKardexId;
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
	 * @return the dFecha
	 */
	public Date getdFecha() {
		return dFecha;
	}

	/**
	 * @param dFecha the dFecha to set
	 */
	public void setdFecha(Date dFecha) {
		this.dFecha = dFecha;
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
	 * @return the fPuExistencia
	 */
	public float getfPuExistencia() {
		return fPuExistencia;
	}

	/**
	 * @param fPuExistencia the fPuExistencia to set
	 */
	public void setfPuExistencia(float fPuExistencia) {
		this.fPuExistencia = fPuExistencia;
	}

	/**
	 * @return the fPuIngresoProducto
	 */
	public float getfPuIngresoProducto() {
		return fPuIngresoProducto;
	}

	/**
	 * @param fPuIngresoProducto the fPuIngresoProducto to set
	 */
	public void setfPuIngresoProducto(float fPuIngresoProducto) {
		this.fPuIngresoProducto = fPuIngresoProducto;
	}

	/**
	 * @return the fPuVenta
	 */
	public float getfPuVenta() {
		return fPuVenta;
	}

	/**
	 * @param fPuVenta the fPuVenta to set
	 */
	public void setfPuVenta(float fPuVenta) {
		this.fPuVenta = fPuVenta;
	}

	/**
	 * @return the fTotalExistencia
	 */
	public float getfTotalExistencia() {
		return fTotalExistencia;
	}

	/**
	 * @param fTotalExistencia the fTotalExistencia to set
	 */
	public void setfTotalExistencia(float fTotalExistencia) {
		this.fTotalExistencia = fTotalExistencia;
	}

	/**
	 * @return the fTotalngresoProducto
	 */
	public float getfTotalngresoProducto() {
		return fTotalngresoProducto;
	}

	/**
	 * @param fTotalngresoProducto the fTotalngresoProducto to set
	 */
	public void setfTotalngresoProducto(float fTotalngresoProducto) {
		this.fTotalngresoProducto = fTotalngresoProducto;
	}

	/**
	 * @return the fTotalVenta
	 */
	public float getfTotalVenta() {
		return fTotalVenta;
	}

	/**
	 * @param fTotalVenta the fTotalVenta to set
	 */
	public void setfTotalVenta(float fTotalVenta) {
		this.fTotalVenta = fTotalVenta;
	}

	/**
	 * @return the iCantExistencia
	 */
	public int getiCantExistencia() {
		return iCantExistencia;
	}

	/**
	 * @param iCantExistencia the iCantExistencia to set
	 */
	public void setiCantExistencia(int iCantExistencia) {
		this.iCantExistencia = iCantExistencia;
	}

	/**
	 * @return the iCantIngresoProducto
	 */
	public int getiCantIngresoProducto() {
		return iCantIngresoProducto;
	}

	/**
	 * @param iCantIngresoProducto the iCantIngresoProducto to set
	 */
	public void setiCantIngresoProducto(int iCantIngresoProducto) {
		this.iCantIngresoProducto = iCantIngresoProducto;
	}

	/**
	 * @return the iCantVenta
	 */
	public int getiCantVenta() {
		return iCantVenta;
	}

	/**
	 * @param iCantVenta the iCantVenta to set
	 */
	public void setiCantVenta(int iCantVenta) {
		this.iCantVenta = iCantVenta;
	}

	/**
	 * @return the ingresoProducto
	 */
	public Ingresoproducto getIngresoProducto() {
		return ingresoProducto;
	}

	/**
	 * @param ingresoProducto the ingresoProducto to set
	 */
	public void setIngresoProducto(Ingresoproducto ingresoProducto) {
		this.ingresoProducto = ingresoProducto;
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
	 * @return the vConcepto
	 */
	public String getvConcepto() {
		return vConcepto;
	}


	

	/**
	 * @param vConcepto the vConcepto to set
	 */
	public void setvConcepto(String vConcepto) {
		this.vConcepto = vConcepto;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the iPeriodoId
	 */
	public int getiPeriodoId() {
		return iPeriodoId;
	}

	/**
	 * @param iPeriodoId the iPeriodoId to set
	 */
	public void setiPeriodoId(int iPeriodoId) {
		this.iPeriodoId = iPeriodoId;
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

	

}