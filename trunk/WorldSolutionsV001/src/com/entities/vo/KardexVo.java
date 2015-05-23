package com.entities.vo;

import java.io.Serializable;
import java.util.Date;

import com.entities.Kardex;


/**
 * The persistent class for the kardex database table.
 * 
 */
public class KardexVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iKardexId;
	private String cEstadoCodigo;
	private Date dFecha;
	private Date dFechaActualiza;
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
	private IngresoproductoVo ingresoProducto;
	private ProductoVo producto;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
	private VentaVo venta;
	private VentadevolucionVo ventadevolucion;
	private int iPeriodoId;
	private String vConcepto;
	
    public KardexVo() {
    }
	
    public KardexVo(Kardex kardex) {
	
		this.iKardexId = kardex.getiKardexId();
		this.cEstadoCodigo = kardex.getcEstadoCodigo();
		this.dFecha = kardex.getdFecha();
		this.dFechaActualiza = kardex.getdFechaActualiza();
		this.dFechaInserta = kardex.getdFechaInserta();
		this.fPuExistencia = kardex.getfPuExistencia();
		this.fPuIngresoProducto = kardex.getfPuIngresoProducto();
		this.fPuVenta = kardex.getfPuVenta();
		this.fTotalExistencia = kardex.getfTotalExistencia();
		this.fTotalngresoProducto = kardex.getfTotalngresoProducto();
		this.fTotalVenta = kardex.getfTotalVenta();
		this.iCantExistencia = kardex.getiCantExistencia();
		this.iCantIngresoProducto = kardex.getiCantIngresoProducto();
		this.iCantVenta = kardex.getiCantVenta();
		if (kardex.getIngresoProducto() != null) {
			//this.ingresoProducto = new IngresoproductoVo(kardex.getIngresoProducto());
		}
		
		this.producto = new ProductoVo( kardex.getProducto());
		
		this.iUsuarioActualizaId = kardex.getiUsuarioActualizaId();
		this.iUsuarioInsertaId = kardex.getiUsuarioInsertaId();
		if (kardex.getVenta() != null) {
			this.venta = new VentaVo(kardex.getVenta());
		}
		if (kardex.getVentadevolucion()!= null ) {
			//this.ventadevolucion = new VentadevolucionVo(kardex.getVentadevolucion());
		}
		
		this.iPeriodoId = kardex.getiPeriodoId();
		this.vConcepto = kardex.getvConcepto();
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
	public IngresoproductoVo getIngresoProducto() {
		return ingresoProducto;
	}
	/**
	 * @param ingresoProducto the ingresoProducto to set
	 */
	public void setIngresoProducto(IngresoproductoVo ingresoProducto) {
		this.ingresoProducto = ingresoProducto;
	}
	/**
	 * @return the producto
	 */
	public ProductoVo getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(ProductoVo producto) {
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
	public VentaVo getVenta() {
		return venta;
	}
	/**
	 * @param venta the venta to set
	 */
	public void setVenta(VentaVo venta) {
		this.venta = venta;
	}
	/**
	 * @return the ventadevolucion
	 */
	public VentadevolucionVo getVentadevolucion() {
		return ventadevolucion;
	}
	/**
	 * @param ventadevolucion the ventadevolucion to set
	 */
	public void setVentadevolucion(VentadevolucionVo ventadevolucion) {
		this.ventadevolucion = ventadevolucion;
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

	
}