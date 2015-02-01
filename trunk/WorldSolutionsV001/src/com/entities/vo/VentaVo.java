package com.entities.vo;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class VentaVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iVentaId;
	private String cEstadoCodigo;
	private String cVentaOrdenCompra;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private Date dVentaFecha;
	private BigDecimal fVentaGanancia;
	private float fVentaIGV;
	private float fVentaSubTotal;
	private float fVentaTotal;
	private float fVentaTotalReal;
	private int idireccionClienteId;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
	private String nVentaNumero;
	private String nVentaRuc;
	private String vEstadoVenta;
	private String vPrincipal;
	private String vVentaPuntoLlegada;
	private List<CuotaVo> cuotas;
	private ClienteVo cliente;
    private FormapagoVo formaPago;
	private TipodocumentogestionVo  tipoDocumento;
	private UsuarioVo usuario;
	private List<VentadetalleVo> ventadetalles;
	private List<KardexVo> kardexs;
	private List<EstadocuentaclienteVo> estadocuentaclientes;
	private List<LetraclienteVo> letracliente; 
	private String vEstadoDocumento;
	private Date dFechaTraslado;
    private int iNumeroDias;
	private int iNumeroLetras;
	private Date dFechaProximoPago;
	private float fMontoAdelantado;	
	private float fDescuento;
	private int iPeriodoId;
	
    public VentaVo() {
    }

	/**
	 * @return the iVentaId
	 */
	public int getiVentaId() {
		return iVentaId;
	}

	/**
	 * @param iVentaId the iVentaId to set
	 */
	public void setiVentaId(int iVentaId) {
		this.iVentaId = iVentaId;
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
	 * @return the cVentaOrdenCompra
	 */
	public String getcVentaOrdenCompra() {
		return cVentaOrdenCompra;
	}

	/**
	 * @param cVentaOrdenCompra the cVentaOrdenCompra to set
	 */
	public void setcVentaOrdenCompra(String cVentaOrdenCompra) {
		this.cVentaOrdenCompra = cVentaOrdenCompra;
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
	 * @return the dVentaFecha
	 */
	public Date getdVentaFecha() {
		return dVentaFecha;
	}

	/**
	 * @param dVentaFecha the dVentaFecha to set
	 */
	public void setdVentaFecha(Date dVentaFecha) {
		this.dVentaFecha = dVentaFecha;
	}

	/**
	 * @return the fVentaGanancia
	 */
	public BigDecimal getfVentaGanancia() {
		return fVentaGanancia;
	}

	/**
	 * @param fVentaGanancia the fVentaGanancia to set
	 */
	public void setfVentaGanancia(BigDecimal fVentaGanancia) {
		this.fVentaGanancia = fVentaGanancia;
	}

	/**
	 * @return the fVentaIGV
	 */
	public float getfVentaIGV() {
		return fVentaIGV;
	}

	/**
	 * @param fVentaIGV the fVentaIGV to set
	 */
	public void setfVentaIGV(float fVentaIGV) {
		this.fVentaIGV = fVentaIGV;
	}

	/**
	 * @return the fVentaSubTotal
	 */
	public float getfVentaSubTotal() {
		return fVentaSubTotal;
	}

	/**
	 * @param fVentaSubTotal the fVentaSubTotal to set
	 */
	public void setfVentaSubTotal(float fVentaSubTotal) {
		this.fVentaSubTotal = fVentaSubTotal;
	}

	/**
	 * @return the fVentaTotal
	 */
	public float getfVentaTotal() {
		return fVentaTotal;
	}

	/**
	 * @param fVentaTotal the fVentaTotal to set
	 */
	public void setfVentaTotal(float fVentaTotal) {
		this.fVentaTotal = fVentaTotal;
	}

	/**
	 * @return the idireccionClienteId
	 */
	public int getIdireccionClienteId() {
		return idireccionClienteId;
	}

	/**
	 * @param idireccionClienteId the idireccionClienteId to set
	 */
	public void setIdireccionClienteId(int idireccionClienteId) {
		this.idireccionClienteId = idireccionClienteId;
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
	 * @return the nVentaNumero
	 */
	public String getnVentaNumero() {
		return nVentaNumero;
	}

	/**
	 * @param nVentaNumero the nVentaNumero to set
	 */
	public void setnVentaNumero(String nVentaNumero) {
		this.nVentaNumero = nVentaNumero;
	}

	/**
	 * @return the nVentaRuc
	 */
	public String getnVentaRuc() {
		return nVentaRuc;
	}

	/**
	 * @param nVentaRuc the nVentaRuc to set
	 */
	public void setnVentaRuc(String nVentaRuc) {
		this.nVentaRuc = nVentaRuc;
	}

	/**
	 * @return the vEstadoVenta
	 */
	public String getvEstadoVenta() {
		return vEstadoVenta;
	}

	/**
	 * @param vEstadoVenta the vEstadoVenta to set
	 */
	public void setvEstadoVenta(String vEstadoVenta) {
		this.vEstadoVenta = vEstadoVenta;
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
	 * @return the vVentaPuntoLlegada
	 */
	public String getvVentaPuntoLlegada() {
		return vVentaPuntoLlegada;
	}

	/**
	 * @param vVentaPuntoLlegada the vVentaPuntoLlegada to set
	 */
	public void setvVentaPuntoLlegada(String vVentaPuntoLlegada) {
		this.vVentaPuntoLlegada = vVentaPuntoLlegada;
	}

	/**
	 * @return the cuotas
	 */
	public List<CuotaVo> getCuotas() {
		return cuotas;
	}

	/**
	 * @param cuotas the cuotas to set
	 */
	public void setCuotas(List<CuotaVo> cuotas) {
		this.cuotas = cuotas;
	}

	/**
	 * @return the cliente
	 */
	public ClienteVo getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(ClienteVo cliente) {
		this.cliente = cliente;
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
	 * @return the tipoDocumento
	 */
	public TipodocumentogestionVo getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(TipodocumentogestionVo tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
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
	 * @return the ventadetalles
	 */
	public List<VentadetalleVo> getVentadetalles() {
		return ventadetalles;
	}

	/**
	 * @param ventadetalles the ventadetalles to set
	 */
	public void setVentadetalles(List<VentadetalleVo> ventadetalles) {
		this.ventadetalles = ventadetalles;
	}

	/**
	 * @return the estadocuentaclientes
	 */
	public List<EstadocuentaclienteVo> getEstadocuentaclientes() {
		return estadocuentaclientes;
	}

	/**
	 * @param estadocuentaclientes the estadocuentaclientes to set
	 */
	public void setEstadocuentaclientes(
			List<EstadocuentaclienteVo> estadocuentaclientes) {
		this.estadocuentaclientes = estadocuentaclientes;
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
	 * @return the dFechaTraslado
	 */
	public Date getdFechaTraslado() {
		return dFechaTraslado;
	}

	/**
	 * @param dFechaTraslado the dFechaTraslado to set
	 */
	public void setdFechaTraslado(Date dFechaTraslado) {
		this.dFechaTraslado = dFechaTraslado;
	}

	/**
	 * @return the kardexs
	 */
	public List<KardexVo> getKardexs() {
		return kardexs;
	}

	/**
	 * @param kardexs the kardexs to set
	 */
	public void setKardexs(List<KardexVo> kardexs) {
		this.kardexs = kardexs;
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
	 * @return the fVentaTotalReal
	 */
	public float getfVentaTotalReal() {
		return fVentaTotalReal;
	}

	/**
	 * @param fVentaTotalReal the fVentaTotalReal to set
	 */
	public void setfVentaTotalReal(float fVentaTotalReal) {
		this.fVentaTotalReal = fVentaTotalReal;
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
	 * @return the letracliente
	 */
	public List<LetraclienteVo> getLetracliente() {
		return letracliente;
	}

	/**
	 * @param letracliente the letracliente to set
	 */
	public void setLetracliente(List<LetraclienteVo> letracliente) {
		this.letracliente = letracliente;
	}

	
	
}