package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ingresoproductodevolucion database table.
 * 
 */
@Entity
public class Ingresoproductodevolucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iIngresoProductoDevolucionId;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaInserta;

    @Temporal( TemporalType.DATE)
	private Date dIngresoProductoDevFecha;

	private float fIngresoProductoDev;

	private float fIngresoProductoDevIGV;

	private float fIngresoProductoDevSubTotal;
	
	//bi-directional many-to-one association to Proveedor
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iIngresoProductoId", nullable=false)
	private Ingresoproducto ingresoProducto ;
   
	//bi-directional many-to-one association to Ingresoproductodetalle
	@OneToMany(mappedBy="ingresoproductodevolucion" ,cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Ingresoproductodevoluciondetalle> ingresoproductodevoluciondetalles;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="iTipoDocumentoId", nullable=false)          
	private Tipodocumentogestion  tipoDocumento;

	private int iUsuarioActualizaId;

	private int iUsuarioInsertaId;

	private String vEstadoCodigo;
	
	private int iPeriodoId;
	
	private float fDescuento;
	
	private String nNroNotaDebito;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="iSucursalId", nullable=false)
	private Sucursal sucursal;
	
    public Ingresoproductodevolucion() {
    }

	/**
	 * @return the iIngresoProductoDevolucionId
	 */
	public int getiIngresoProductoDevolucionId() {
		return iIngresoProductoDevolucionId;
	}

	/**
	 * @param iIngresoProductoDevolucionId the iIngresoProductoDevolucionId to set
	 */
	public void setiIngresoProductoDevolucionId(int iIngresoProductoDevolucionId) {
		this.iIngresoProductoDevolucionId = iIngresoProductoDevolucionId;
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
	 * @return the dIngresoProductoDevFecha
	 */
	public Date getdIngresoProductoDevFecha() {
		return dIngresoProductoDevFecha;
	}

	/**
	 * @param dIngresoProductoDevFecha the dIngresoProductoDevFecha to set
	 */
	public void setdIngresoProductoDevFecha(Date dIngresoProductoDevFecha) {
		this.dIngresoProductoDevFecha = dIngresoProductoDevFecha;
	}

	/**
	 * @return the fIngresoProductoDev
	 */
	public float getfIngresoProductoDev() {
		return fIngresoProductoDev;
	}

	/**
	 * @param fIngresoProductoDev the fIngresoProductoDev to set
	 */
	public void setfIngresoProductoDev(float fIngresoProductoDev) {
		this.fIngresoProductoDev = fIngresoProductoDev;
	}

	/**
	 * @return the fIngresoProductoDevIGV
	 */
	public float getfIngresoProductoDevIGV() {
		return fIngresoProductoDevIGV;
	}

	/**
	 * @param fIngresoProductoDevIGV the fIngresoProductoDevIGV to set
	 */
	public void setfIngresoProductoDevIGV(float fIngresoProductoDevIGV) {
		this.fIngresoProductoDevIGV = fIngresoProductoDevIGV;
	}

	/**
	 * @return the fIngresoProductoDevSubTotal
	 */
	public float getfIngresoProductoDevSubTotal() {
		return fIngresoProductoDevSubTotal;
	}

	/**
	 * @param fIngresoProductoDevSubTotal the fIngresoProductoDevSubTotal to set
	 */
	public void setfIngresoProductoDevSubTotal(float fIngresoProductoDevSubTotal) {
		this.fIngresoProductoDevSubTotal = fIngresoProductoDevSubTotal;
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
	 * @return the vEstadoCodigo
	 */
	public String getvEstadoCodigo() {
		return vEstadoCodigo;
	}

	/**
	 * @param vEstadoCodigo the vEstadoCodigo to set
	 */
	public void setvEstadoCodigo(String vEstadoCodigo) {
		this.vEstadoCodigo = vEstadoCodigo;
	}

	/**
	 * @return the ingresoproductodevoluciondetalles
	 */
	public List<Ingresoproductodevoluciondetalle> getIngresoproductodevoluciondetalles() {
		return ingresoproductodevoluciondetalles;
	}

	/**
	 * @param ingresoproductodevoluciondetalles the ingresoproductodevoluciondetalles to set
	 */
	public void setIngresoproductodevoluciondetalles(
			List<Ingresoproductodevoluciondetalle> ingresoproductodevoluciondetalles) {
		this.ingresoproductodevoluciondetalles = ingresoproductodevoluciondetalles;
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
	 * @return the nNroNotaDebito
	 */
	public String getnNroNotaDebito() {
		return nNroNotaDebito;
	}

	/**
	 * @param nNroNotaDebito the nNroNotaDebito to set
	 */
	public void setnNroNotaDebito(String nNroNotaDebito) {
		this.nNroNotaDebito = nNroNotaDebito;
	}

	/**
	 * @return the tipoDocumento
	 */
	public Tipodocumentogestion getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(Tipodocumentogestion tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return the sucursal
	 */
	public Sucursal getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	
}