package com.entities.vo;

import java.io.Serializable;
import java.util.Date;

import com.entities.Ventadetalle;

public class VentadetalleVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iVentaDetalleId;
	private String cEstadoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private float fVentaDetallePrecio;
	private float fVentaDetalleTotal;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
	private int iVentaDetalleCantidad;
	private ProductoVo producto;
	private float fDescuento;
    private PersonalVo personal;    
    private int iSubCta;
    private String vIdentificadorSession;
	private float fVentaDetalleCosto;
    
    public VentadetalleVo() {
    }

	public VentadetalleVo(Ventadetalle ventadetalle) {
		this.iVentaDetalleId = ventadetalle.getiVentaDetalleId();
		this.cEstadoCodigo = ventadetalle.getcEstadoCodigo();
		this.dFechaActualiza = ventadetalle.getdFechaActualiza();
		this.dFechaInserta = ventadetalle.getdFechaInserta();
		this.fVentaDetallePrecio = ventadetalle.getfVentaDetallePrecio();
		this.fVentaDetalleTotal = ventadetalle.getfVentaDetalleTotal();
		this.iUsuarioActualizaId = ventadetalle.getiUsuarioActualizaId();
		this.iUsuarioInsertaId = ventadetalle.getiUsuarioInsertaId();
		this.iVentaDetalleCantidad = ventadetalle.getiVentaDetalleCantidad();
		this.producto = ventadetalle.getProducto() != null ? new ProductoVo(ventadetalle.getProducto()) : null;
		this.fDescuento = ventadetalle.getfDescuento();
		this.personal = ventadetalle.getPersonal()!= null ? new PersonalVo(ventadetalle.getPersonal()) : null;
		this.iSubCta = ventadetalle.getiSubCta();
		this.vIdentificadorSession = ventadetalle.getvIdentificadorSession();
		this.fVentaDetalleCosto = ventadetalle.getfVentaDetalleCosto();
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

	public PersonalVo getPersonal() {
		return personal;
	}

	public void setPersonal(PersonalVo personal) {
		this.personal = personal;
	}

	public int getiSubCta() {
		return iSubCta;
	}

	public void setiSubCta(int iSubCta) {
		this.iSubCta = iSubCta;
	}

	public String getvIdentificadorSession() {
		return vIdentificadorSession;
	}

	public void setvIdentificadorSession(String vIdentificadorSession) {
		this.vIdentificadorSession = vIdentificadorSession;
	}

	/**
	 * @return the fVentaDetalleCosto
	 */
	public float getfVentaDetalleCosto() {
		return fVentaDetalleCosto;
	}

	/**
	 * @param fVentaDetalleCosto the fVentaDetalleCosto to set
	 */
	public void setfVentaDetalleCosto(float fVentaDetalleCosto) {
		this.fVentaDetalleCosto = fVentaDetalleCosto;
	}
	
}