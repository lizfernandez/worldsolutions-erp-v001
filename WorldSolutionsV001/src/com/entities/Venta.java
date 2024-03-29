package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.entities.vo.VentaVo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the venta database table.
 * 
 */
@Entity
@Table(name="venta")
public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int iVentaId;

	@Column(nullable=false, length=2)
	private String cEstadoCodigo;

	@Column(length=10)
	private String cVentaOrdenCompra;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaInserta;

    @Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dVentaFecha;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal fVentaGanancia;

	@Column(nullable=false)
	private float fVentaIGV;

	@Column(nullable=false)
	private float fVentaSubTotal;

	@Column(nullable=false)
	private float fVentaTotal;
	
	@Column(nullable=false)
	private float fVentaTotalReal;
	
	@Column(nullable=false)
	private int idireccionClienteId;

	private int iUsuarioActualizaId;

	@Column(nullable=false)
	private int iUsuarioInsertaId;

	@Column(nullable=false, length=50)
	private String nVentaNumero;

	@Column(length=11)
	private String nVentaRuc;

	@Column(nullable=false, length=50)
	private String vEstadoVenta;

	@Column(length=1)
	private String vPrincipal;

	@Column(length=120)
	private String vVentaPuntoLlegada;

	//bi-directional many-to-one association to Cuota
	@OneToMany(mappedBy="venta")
	private List<Cuota> cuotas;

	//bi-directional many-to-one association to Cliente
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="iClienteId", nullable=false)
	private Cliente cliente;

	//bi-directional many-to-one association to Formapago
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="iFormaPago", nullable=false)    
    private Formapago formaPago;
    
    @ManyToOne(fetch = FetchType.LAZY)
   	@JoinColumn(name="iTipoDocumentoId", nullable=false)          
	private Tipodocumentogestion  tipoDocumento;

	//bi-directional many-to-one association to Usuario
    @ManyToOne
	@JoinColumn(name="iUsuarioId", nullable=false)
	private Usuario usuario;
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iSucursalId", nullable=false)
	private Sucursal sucursal;

	//bi-directional many-to-one association to Ventadetalle
	@OneToMany(mappedBy="venta", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Ventadetalle> ventadetalles;
	
	@OneToMany(mappedBy="venta" ,cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Kardex> kardexs;
	

	//bi-directional many-to-one association to estadocuentacliente
	@OneToMany(mappedBy="venta", cascade = CascadeType.REFRESH, fetch=FetchType.LAZY) 
	private List<Estadocuentacliente> estadocuentaclientes;
	
	//bi-directional many-to-one association to Estadocuentaproveedor
	@OneToMany(mappedBy="venta", fetch=FetchType.EAGER,cascade = CascadeType.REFRESH) 
	private List<Letracliente> letracliente; 

	
	@Column(length=45)
	private String vEstadoDocumento;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dFechaTraslado;
	
    private int iNumeroDias;
	
	private int iNumeroLetras;
	
	@Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date dFechaProximoPago;
	
	private float fMontoAdelantado;	
	
	@Column(nullable=false)
	private float fDescuento;
    
	private  float fMontoPago;
	
	private float fTipoCambio;
	
	private float fMontoVuelto;
	
	private String vTipoPago;
	
	private String vTipoVenta;
	
	private int iPeriodoId;
	
	private float fDescClienteVenta;
	
	private String vIncluyeIGV;
	
	private String vPorcentajeIGV;
	
	private float fMontoPagoCredito;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iMedioPago1", nullable=false)
	private Mediopago medioPago1;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iMedioPago2", nullable=false)
	private Mediopago medioPago2;
	
    public Venta() {
    }

    
    
	public Venta(VentaVo ventaVo) {
		super();
		this.iVentaId = ventaVo.getiVentaId();
		this.cVentaOrdenCompra = ventaVo.getcVentaOrdenCompra();
		this.dVentaFecha = ventaVo.getdVentaFecha();
		this.fVentaGanancia = ventaVo.getfVentaGanancia();
		this.fVentaIGV = ventaVo.getfVentaIGV();
		this.fVentaSubTotal = ventaVo.getfVentaSubTotal();
		this.fVentaTotal = ventaVo.getfVentaTotal();
		this.fVentaTotalReal = ventaVo.getfVentaTotalReal();
		this.nVentaRuc = ventaVo.getnVentaRuc();
		this.vEstadoVenta = ventaVo.getvEstadoVenta();
		this.vVentaPuntoLlegada = ventaVo.getvVentaPuntoLlegada();
		this.formaPago = new Formapago(ventaVo.getFormaPago());
		this.tipoDocumento = new Tipodocumentogestion(ventaVo.getTipoDocumento());		
		this.vEstadoDocumento = ventaVo.getvEstadoDocumento();
		this.iNumeroDias = ventaVo.getiNumeroDias();
		this.iNumeroLetras = ventaVo.getiNumeroLetras();
		this.dFechaProximoPago = ventaVo.getdFechaProximoPago();
		this.fMontoAdelantado = ventaVo.getfMontoAdelantado();
		this.fDescuento = ventaVo.getfDescuento();
		this.fMontoPago = ventaVo.getfMontoPago();
		this.fTipoCambio = ventaVo.getfTipoCambio();
		this.fMontoVuelto = ventaVo.getfMontoVuelto();
		this.vTipoPago = ventaVo.getvTipoPago();
		this.vTipoVenta = ventaVo.getvTipoVenta();
		this.fDescClienteVenta = ventaVo.getfDescClienteVenta();
		this.vIncluyeIGV = ventaVo.getvIncluyeIGV();
		this.fMontoPagoCredito = ventaVo.getfMontoPagoCredito();
		if (ventaVo.getMedioPago1() != null) {
			this.medioPago1 = new Mediopago(ventaVo.getMedioPago1());
		}
		if (ventaVo.getMedioPago2() != null) {
			this.medioPago2 = new Mediopago(ventaVo.getMedioPago2());
		}
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
	public List<Cuota> getCuotas() {
		return cuotas;
	}

	/**
	 * @param cuotas the cuotas to set
	 */
	public void setCuotas(List<Cuota> cuotas) {
		this.cuotas = cuotas;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the formaPago
	 */
	public Formapago getFormaPago() {
		return formaPago;
	}

	/**
	 * @param formaPago the formaPago to set
	 */
	public void setFormaPago(Formapago formaPago) {
		this.formaPago = formaPago;
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
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the ventadetalles
	 */
	public List<Ventadetalle> getVentadetalles() {
		return ventadetalles;
	}

	/**
	 * @param ventadetalles the ventadetalles to set
	 */
	public void setVentadetalles(List<Ventadetalle> ventadetalles) {
		this.ventadetalles = ventadetalles;
	}

	/**
	 * @return the estadocuentaclientes
	 */
	public List<Estadocuentacliente> getEstadocuentaclientes() {
		return estadocuentaclientes;
	}

	/**
	 * @param estadocuentaclientes the estadocuentaclientes to set
	 */
	public void setEstadocuentaclientes(
			List<Estadocuentacliente> estadocuentaclientes) {
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
	public List<Kardex> getKardexs() {
		return kardexs;
	}

	/**
	 * @param kardexs the kardexs to set
	 */
	public void setKardexs(List<Kardex> kardexs) {
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
	public List<Letracliente> getLetracliente() {
		return letracliente;
	}

	/**
	 * @param letracliente the letracliente to set
	 */
	public void setLetracliente(List<Letracliente> letracliente) {
		this.letracliente = letracliente;
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

	/**
	 * @return the fMontoPago
	 */
	public float getfMontoPago() {
		return fMontoPago;
	}

	/**
	 * @param fMontoPago the fMontoPago to set
	 */
	public void setfMontoPago(float fMontoPago) {
		this.fMontoPago = fMontoPago;
	}

	/**
	 * @return the fTipoCambio
	 */
	public float getfTipoCambio() {
		return fTipoCambio;
	}

	/**
	 * @param fTipoCambio the fTipoCambio to set
	 */
	public void setfTipoCambio(float fTipoCambio) {
		this.fTipoCambio = fTipoCambio;
	}

	/**
	 * @return the fMontoVuelto
	 */
	public float getfMontoVuelto() {
		return fMontoVuelto;
	}

	/**
	 * @param fMontoVuelto the fMontoVuelto to set
	 */
	public void setfMontoVuelto(float fMontoVuelto) {
		this.fMontoVuelto = fMontoVuelto;
	}

	/**
	 * @return the vTipoPago
	 */
	public String getvTipoPago() {
		return vTipoPago;
	}

	/**
	 * @param vTipoPago the vTipoPago to set
	 */
	public void setvTipoPago(String vTipoPago) {
		this.vTipoPago = vTipoPago;
	}

	/**
	 * @return the fDescClienteVenta
	 */
	public float getfDescClienteVenta() {
		return fDescClienteVenta;
	}

	/**
	 * @param fDescClienteVenta the fDescClienteVenta to set
	 */
	public void setfDescClienteVenta(float fDescClienteVenta) {
		this.fDescClienteVenta = fDescClienteVenta;
	}

	/**
	 * @return the vIncluyeIGV
	 */
	public String getvIncluyeIGV() {
		return vIncluyeIGV;
	}

	/**
	 * @param vIncluyeIGV the vIncluyeIGV to set
	 */
	public void setvIncluyeIGV(String vIncluyeIGV) {
		this.vIncluyeIGV = vIncluyeIGV;
	}

	/**
	 * @return the vTipoVenta
	 */
	public String getvTipoVenta() {
		return vTipoVenta;
	}

	/**
	 * @param vTipoVenta the vTipoVenta to set
	 */
	public void setvTipoVenta(String vTipoVenta) {
		this.vTipoVenta = vTipoVenta;
	}

	/**
	 * @return the vPorcentajeIGV
	 */
	public String getvPorcentajeIGV() {
		return vPorcentajeIGV;
	}

	/**
	 * @param vPorcentajeIGV the vPorcentajeIGV to set
	 */
	public void setvPorcentajeIGV(String vPorcentajeIGV) {
		this.vPorcentajeIGV = vPorcentajeIGV;
	}

	/**
	 * @return the fMontoPagoCredito
	 */
	public float getfMontoPagoCredito() {
		return fMontoPagoCredito;
	}

	/**
	 * @param fMontoPagoCredito the fMontoPagoCredito to set
	 */
	public void setfMontoPagoCredito(float fMontoPagoCredito) {
		this.fMontoPagoCredito = fMontoPagoCredito;
	}

	/**
	 * @return the medioPago1
	 */
	public Mediopago getMedioPago1() {
		return medioPago1;
	}

	/**
	 * @param medioPago1 the medioPago1 to set
	 */
	public void setMedioPago1(Mediopago medioPago1) {
		this.medioPago1 = medioPago1;
	}

	/**
	 * @return the medioPago2
	 */
	public Mediopago getMedioPago2() {
		return medioPago2;
	}

	/**
	 * @param medioPago2 the medioPago2 to set
	 */
	public void setMedioPago2(Mediopago medioPago2) {
		this.medioPago2 = medioPago2;
	}

	
	
}