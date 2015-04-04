package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ventadevolucion database table.
 * 
 */
@Entity
public class Ventadevolucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iVentaDevolucionId;

	private String cEstadoCodigo;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaInserta;

    @Temporal( TemporalType.DATE)
	private Date dVentaDevFecha;

	private float fVentaDevIGV;

	private float fVentaDevSubTotal;

	private float fVentaDevTotal;

	private int iUsuarioActualizaId;

	private int iUsuarioInsertaId;
	//bi-directional many-to-one association to Proveedor
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iVentaId", nullable=false)
	private Venta venta;
    
  //bi-directional many-to-one association to Ingresoproductodetalle
  	@OneToMany(mappedBy="ventadevolucion" ,cascade = CascadeType.ALL, fetch=FetchType.EAGER)
  	private List<Ventadevoluciondetalle> ventadevoluciondetalles;
  	
  	@OneToMany(mappedBy="ventadevolucion" ,cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Kardex> kardexs;
  	
    private int iPeriodoId;
    
    private float fDescuento;
    public Ventadevolucion() {
    }


	/**
	 * @return the iVentaDevolucionId
	 */
	public int getiVentaDevolucionId() {
		return iVentaDevolucionId;
	}


	/**
	 * @param iVentaDevolucionId the iVentaDevolucionId to set
	 */
	public void setiVentaDevolucionId(int iVentaDevolucionId) {
		this.iVentaDevolucionId = iVentaDevolucionId;
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
	 * @return the dVentaDevFecha
	 */
	public Date getdVentaDevFecha() {
		return dVentaDevFecha;
	}


	/**
	 * @param dVentaDevFecha the dVentaDevFecha to set
	 */
	public void setdVentaDevFecha(Date dVentaDevFecha) {
		this.dVentaDevFecha = dVentaDevFecha;
	}


	/**
	 * @return the fVentaDevIGV
	 */
	public float getfVentaDevIGV() {
		return fVentaDevIGV;
	}


	/**
	 * @param fVentaDevIGV the fVentaDevIGV to set
	 */
	public void setfVentaDevIGV(float fVentaDevIGV) {
		this.fVentaDevIGV = fVentaDevIGV;
	}


	/**
	 * @return the fVentaDevSubTotal
	 */
	public float getfVentaDevSubTotal() {
		return fVentaDevSubTotal;
	}


	/**
	 * @param fVentaDevSubTotal the fVentaDevSubTotal to set
	 */
	public void setfVentaDevSubTotal(float fVentaDevSubTotal) {
		this.fVentaDevSubTotal = fVentaDevSubTotal;
	}


	/**
	 * @return the fVentaDevTotal
	 */
	public float getfVentaDevTotal() {
		return fVentaDevTotal;
	}


	/**
	 * @param fVentaDevTotal the fVentaDevTotal to set
	 */
	public void setfVentaDevTotal(float fVentaDevTotal) {
		this.fVentaDevTotal = fVentaDevTotal;
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
	 * @return the ventadevoluciondetalles
	 */
	public List<Ventadevoluciondetalle> getVentadevoluciondetalles() {
		return ventadevoluciondetalles;
	}


	/**
	 * @param ventadevoluciondetalles the ventadevoluciondetalles to set
	 */
	public void setVentadevoluciondetalles(
			List<Ventadevoluciondetalle> ventadevoluciondetalles) {
		this.ventadevoluciondetalles = ventadevoluciondetalles;
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
	 * @return the kardexs
	 */
	public List<Kardex> getKardexs() {
		return kardexs;
	}


	/**
	 * @param kardexs the kardexs to set
	 */
	public void setKardexs(List<Kardex> kardexs) {
		this.kardexs = kardexs;
	}
	
	
  
}