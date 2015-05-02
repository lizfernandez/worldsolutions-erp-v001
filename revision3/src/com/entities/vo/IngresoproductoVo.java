package com.entities.vo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ingresoproducto database table.
 * 
 */
public class IngresoproductoVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iIngresoProductoId;
	private String cEstadoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private Date dIngresoProductoFecha;
	private float fIngresoProductoIGV;
	private float fIngresoProductoSubTotal;
	private float fIngresoProductoTotal;
	private FormapagoVo formaPago;
	private SucursalVo sucursal;
	private int iUsuarioActualizaId;
	private UsuarioVo usuario;
	private int iUsuarioInsertaId;
	private String nIngresoProductoNumero;
	private String vPrincipal;
	private List<EstadocuentaproveedorVo> estadocuentaproveedors;
	private List<LetraproveedorVo> letraproveedor; 
	private ProveedorVo proveedor;
	private TipodocumentogestionVo tipodocumento;
	private List<IngresoproductodetalleVo> ingresoproductodetalles;
	private List<KardexVo> kardex;
	private String vEstadoDocumento;
	private String vIngresoProductoPuntoLlegada;
	private float fPercepcion;
	private int iNumeroDias;
	private int iNumeroLetras;
	private Date dFechaProximoPago;
	private float fMontoAdelantado;	
	private float fDescuento;
	private float fIngresoProductoTotalReal;
	private int iPeriodoId;

	public IngresoproductoVo() {
    }

	/**
	 * @return the iIngresoProductoId
	 */
	public int getiIngresoProductoId() {
		return iIngresoProductoId;
	}

	/**
	 * @param iIngresoProductoId the iIngresoProductoId to set
	 */
	public void setiIngresoProductoId(int iIngresoProductoId) {
		this.iIngresoProductoId = iIngresoProductoId;
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
	 * @return the dIngresoProductoFecha
	 */
	public Date getdIngresoProductoFecha() {
		return dIngresoProductoFecha;
	}

	/**
	 * @param dIngresoProductoFecha the dIngresoProductoFecha to set
	 */
	public void setdIngresoProductoFecha(Date dIngresoProductoFecha) {
		this.dIngresoProductoFecha = dIngresoProductoFecha;
	}

	/**
	 * @return the fIngresoProductoIGV
	 */
	public float getfIngresoProductoIGV() {
		return fIngresoProductoIGV;
	}

	/**
	 * @param fIngresoProductoIGV the fIngresoProductoIGV to set
	 */
	public void setfIngresoProductoIGV(float fIngresoProductoIGV) {
		this.fIngresoProductoIGV = fIngresoProductoIGV;
	}

	/**
	 * @return the fIngresoProductoSubTotal
	 */
	public float getfIngresoProductoSubTotal() {
		return fIngresoProductoSubTotal;
	}

	/**
	 * @param fIngresoProductoSubTotal the fIngresoProductoSubTotal to set
	 */
	public void setfIngresoProductoSubTotal(float fIngresoProductoSubTotal) {
		this.fIngresoProductoSubTotal = fIngresoProductoSubTotal;
	}

	/**
	 * @return the fIngresoProductoTotal
	 */
	public float getfIngresoProductoTotal() {
		return fIngresoProductoTotal;
	}

	/**
	 * @param fIngresoProductoTotal the fIngresoProductoTotal to set
	 */
	public void setfIngresoProductoTotal(float fIngresoProductoTotal) {
		this.fIngresoProductoTotal = fIngresoProductoTotal;
	}

	/**
	 * @return the formaPago
	 */
	public FormapagoVo getFormaPago() {
		return formaPago;
	}

	/**
	 * @param formaPago the formaPago to set
	 */
	public void setFormaPago(FormapagoVo formaPago) {
		this.formaPago = formaPago;
	}

	/**
	 * @return the sucursal
	 */
	public SucursalVo getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(SucursalVo sucursal) {
		this.sucursal = sucursal;
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
	 * @return the usuario
	 */
	public UsuarioVo getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(UsuarioVo usuario) {
		this.usuario = usuario;
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
	 * @return the nIngresoProductoNumero
	 */
	public String getnIngresoProductoNumero() {
		return nIngresoProductoNumero;
	}

	/**
	 * @param nIngresoProductoNumero the nIngresoProductoNumero to set
	 */
	public void setnIngresoProductoNumero(String nIngresoProductoNumero) {
		this.nIngresoProductoNumero = nIngresoProductoNumero;
	}

	/**
	 * @return the vPrincipal
	 */
	public String getvPrincipal() {
		return vPrincipal;
	}

	/**
	 * @param vPrincipal the vPrincipal to set
	 */
	public void setvPrincipal(String vPrincipal) {
		this.vPrincipal = vPrincipal;
	}

	/**
	 * @return the estadocuentaproveedors
	 */
	public List<EstadocuentaproveedorVo> getEstadocuentaproveedors() {
		return estadocuentaproveedors;
	}

	/**
	 * @param estadocuentaproveedors the estadocuentaproveedors to set
	 */
	public void setEstadocuentaproveedors(
			List<EstadocuentaproveedorVo> estadocuentaproveedors) {
		this.estadocuentaproveedors = estadocuentaproveedors;
	}

	/**
	 * @return the letraproveedor
	 */
	public List<LetraproveedorVo> getLetraproveedor() {
		return letraproveedor;
	}

	/**
	 * @param letraproveedor the letraproveedor to set
	 */
	public void setLetraproveedor(List<LetraproveedorVo> letraproveedor) {
		this.letraproveedor = letraproveedor;
	}

	/**
	 * @return the proveedor
	 */
	public ProveedorVo getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(ProveedorVo proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * @return the tipodocumento
	 */
	public TipodocumentogestionVo getTipodocumento() {
		return tipodocumento;
	}

	/**
	 * @param tipodocumento the tipodocumento to set
	 */
	public void setTipodocumento(TipodocumentogestionVo tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	/**
	 * @return the ingresoproductodetalles
	 */
	public List<IngresoproductodetalleVo> getIngresoproductodetalles() {
		return ingresoproductodetalles;
	}

	/**
	 * @param ingresoproductodetalles the ingresoproductodetalles to set
	 */
	public void setIngresoproductodetalles(
			List<IngresoproductodetalleVo> ingresoproductodetalles) {
		this.ingresoproductodetalles = ingresoproductodetalles;
	}

	/**
	 * @return the kardex
	 */
	public List<KardexVo> getKardex() {
		return kardex;
	}

	/**
	 * @param kardex the kardex to set
	 */
	public void setKardex(List<KardexVo> kardex) {
		this.kardex = kardex;
	}

	/**
	 * @return the vEstadoDocumento
	 */
	public String getvEstadoDocumento() {
		return vEstadoDocumento;
	}

	/**
	 * @param vEstadoDocumento the vEstadoDocumento to set
	 */
	public void setvEstadoDocumento(String vEstadoDocumento) {
		this.vEstadoDocumento = vEstadoDocumento;
	}

	/**
	 * @return the vIngresoProductoPuntoLlegada
	 */
	public String getvIngresoProductoPuntoLlegada() {
		return vIngresoProductoPuntoLlegada;
	}

	/**
	 * @param vIngresoProductoPuntoLlegada the vIngresoProductoPuntoLlegada to set
	 */
	public void setvIngresoProductoPuntoLlegada(String vIngresoProductoPuntoLlegada) {
		this.vIngresoProductoPuntoLlegada = vIngresoProductoPuntoLlegada;
	}

	/**
	 * @return the fPercepcion
	 */
	public float getfPercepcion() {
		return fPercepcion;
	}

	/**
	 * @param fPercepcion the fPercepcion to set
	 */
	public void setfPercepcion(float fPercepcion) {
		this.fPercepcion = fPercepcion;
	}

	/**
	 * @return the iNumeroDias
	 */
	public int getiNumeroDias() {
		return iNumeroDias;
	}

	/**
	 * @param iNumeroDias the iNumeroDias to set
	 */
	public void setiNumeroDias(int iNumeroDias) {
		this.iNumeroDias = iNumeroDias;
	}

	/**
	 * @return the iNumeroLetras
	 */
	public int getiNumeroLetras() {
		return iNumeroLetras;
	}

	/**
	 * @param iNumeroLetras the iNumeroLetras to set
	 */
	public void setiNumeroLetras(int iNumeroLetras) {
		this.iNumeroLetras = iNumeroLetras;
	}

	/**
	 * @return the dFechaProximoPago
	 */
	public Date getdFechaProximoPago() {
		return dFechaProximoPago;
	}

	/**
	 * @param dFechaProximoPago the dFechaProximoPago to set
	 */
	public void setdFechaProximoPago(Date dFechaProximoPago) {
		this.dFechaProximoPago = dFechaProximoPago;
	}

	/**
	 * @return the fMontoAdelantado
	 */
	public float getfMontoAdelantado() {
		return fMontoAdelantado;
	}

	/**
	 * @param fMontoAdelantado the fMontoAdelantado to set
	 */
	public void setfMontoAdelantado(float fMontoAdelantado) {
		this.fMontoAdelantado = fMontoAdelantado;
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
	 * @return the fIngresoProductoTotalReal
	 */
	public float getfIngresoProductoTotalReal() {
		return fIngresoProductoTotalReal;
	}

	/**
	 * @param fIngresoProductoTotalReal the fIngresoProductoTotalReal to set
	 */
	public void setfIngresoProductoTotalReal(float fIngresoProductoTotalReal) {
		this.fIngresoProductoTotalReal = fIngresoProductoTotalReal;
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


	
}