package com.entities.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.entities.Venta;
import com.entities.converter.VentaConverter;

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
	private String vPrincipal;
	private String vVentaPuntoLlegada;
	private ClienteVo cliente;
    private FormapagoVo formaPago;
	private TipodocumentogestionVo tipoDocumento;
	private UsuarioVo usuario;
	private SucursalVo sucursal;
	private List<VentadetalleVo> ventadetalles;
	private List<KardexVo> kardexs;
	private String vEstadoDocumento;
	private Date dFechaTraslado;
    private int iNumeroDias;
	private int iNumeroLetras;
	private Date dFechaProximoPago;
	private float fMontoAdelantado;	
	private float fDescuento;
	private float fMontoPago;
	private float fTipoCambio;
	private float fMontoVuelto;
	private String vTipoPago;
	private String vTipoVenta;
	private int iPeriodoId;
	private float fDescClienteVenta;
	private String vIncluyeIGV;
	private String vPorcentajeIGV;
	private float fMontoPagoCredito;
	private MediopagoVo medioPago1;
	private MediopagoVo medioPago2;
	private String vEstadoVenta;

	public VentaVo(Venta venta) {

		this.iVentaId = venta.getiVentaId();
		this.cEstadoCodigo = venta.getcEstadoCodigo();
		this.cVentaOrdenCompra = venta.getcVentaOrdenCompra();
		this.dFechaActualiza = venta.getdFechaActualiza();
		this.dFechaInserta = venta.getdFechaInserta();
		this.dVentaFecha = venta.getdVentaFecha();
		this.fVentaGanancia = venta.getfVentaGanancia();
		this.fVentaIGV = venta.getfVentaIGV();
		this.fVentaSubTotal = venta.getfVentaSubTotal();
		this.fVentaTotal = venta.getfVentaTotal();
		this.fVentaTotalReal = venta.getfVentaTotalReal();
		this.idireccionClienteId = venta.getIdireccionClienteId();
		this.iUsuarioActualizaId = venta.getiUsuarioActualizaId();
		this.iUsuarioInsertaId = venta.getiUsuarioInsertaId();
		this.nVentaNumero = venta.getnVentaNumero();
		this.nVentaRuc = venta.getnVentaRuc();
		this.vEstadoVenta = venta.getvEstadoVenta();
		this.vPrincipal = venta.getvPrincipal();
		this.vVentaPuntoLlegada = venta.getvVentaPuntoLlegada();
		this.cliente = new ClienteVo(venta.getCliente());
		this.formaPago = new FormapagoVo(venta.getFormaPago());
		this.tipoDocumento = new TipodocumentogestionVo(venta.getTipoDocumento());
		this.usuario = new UsuarioVo(venta.getUsuario());
		this.sucursal = new SucursalVo(venta.getSucursal());
		this.ventadetalles = VentaConverter.aListVentadetalleVo(venta.getVentadetalles());
//		this.kardexs = KardexConverter.aListKardexVo(venta.getKardexs());
		this.vEstadoDocumento = venta.getvEstadoDocumento();
		this.dFechaTraslado = venta.getdFechaTraslado();
		this.iNumeroDias = venta.getiNumeroDias();
		this.iNumeroLetras = venta.getiNumeroLetras();
		this.dFechaProximoPago = venta.getdFechaProximoPago();
		this.fMontoAdelantado = venta.getfMontoAdelantado();
		this.fDescuento = venta.getfDescuento();
		this.fMontoPago = venta.getfMontoPago();
		this.fTipoCambio = venta.getfTipoCambio();
		this.fMontoVuelto = venta.getfMontoVuelto();
		this.vTipoPago = venta.getvTipoPago();
		this.vTipoVenta = venta.getvTipoVenta();
		this.iPeriodoId = venta.getiPeriodoId();
		this.fDescClienteVenta = venta.getfDescClienteVenta();
		this.vIncluyeIGV = venta.getvIncluyeIGV();
		this.vPorcentajeIGV = venta.getvPorcentajeIGV();
		this.fMontoPagoCredito = venta.getfMontoPagoCredito();
		this.medioPago1 = venta.getMedioPago1() != null ? new MediopagoVo(venta.getMedioPago1()):null;
		this.medioPago2 = venta.getMedioPago1() != null ? new MediopagoVo(venta.getMedioPago2()):null;
	}



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

	public SucursalVo getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalVo sucursal) {
		this.sucursal = sucursal;
	}

	public float getfMontoPago() {
		return fMontoPago;
	}

	public void setfMontoPago(float fMontoPago) {
		this.fMontoPago = fMontoPago;
	}

	public float getfTipoCambio() {
		return fTipoCambio;
	}

	public void setfTipoCambio(float fTipoCambio) {
		this.fTipoCambio = fTipoCambio;
	}

	public float getfMontoVuelto() {
		return fMontoVuelto;
	}

	public void setfMontoVuelto(float fMontoVuelto) {
		this.fMontoVuelto = fMontoVuelto;
	}

	public String getvTipoPago() {
		return vTipoPago;
	}

	public void setvTipoPago(String vTipoPago) {
		this.vTipoPago = vTipoPago;
	}

	public String getvTipoVenta() {
		return vTipoVenta;
	}

	public void setvTipoVenta(String vTipoVenta) {
		this.vTipoVenta = vTipoVenta;
	}

	public float getfDescClienteVenta() {
		return fDescClienteVenta;
	}

	public void setfDescClienteVenta(float fDescClienteVenta) {
		this.fDescClienteVenta = fDescClienteVenta;
	}

	public String getvIncluyeIGV() {
		return vIncluyeIGV;
	}

	public void setvIncluyeIGV(String vIncluyeIGV) {
		this.vIncluyeIGV = vIncluyeIGV;
	}

	public String getvPorcentajeIGV() {
		return vPorcentajeIGV;
	}

	public void setvPorcentajeIGV(String vPorcentajeIGV) {
		this.vPorcentajeIGV = vPorcentajeIGV;
	}

	public float getfMontoPagoCredito() {
		return fMontoPagoCredito;
	}

	public void setfMontoPagoCredito(float fMontoPagoCredito) {
		this.fMontoPagoCredito = fMontoPagoCredito;
	}

	public MediopagoVo getMedioPago1() {
		return medioPago1;
	}

	public void setMedioPago1(MediopagoVo medioPago1) {
		this.medioPago1 = medioPago1;
	}

	public MediopagoVo getMedioPago2() {
		return medioPago2;
	}

	public void setMedioPago2(MediopagoVo medioPago2) {
		this.medioPago2 = medioPago2;
	}
	
	
}