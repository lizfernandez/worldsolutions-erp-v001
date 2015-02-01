package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ingresoproducto database table.
 * 
 */
@Entity
@Table(name="ingresoproducto")
public class Ingresoproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int iIngresoProductoId;

	@Column(nullable=false, length=2)
	private String cEstadoCodigo;

    @Temporal( TemporalType.DATE)
	private Date dFechaActualiza;

    @Temporal( TemporalType.DATE)
	private Date dFechaInserta;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date dIngresoProductoFecha;

	private float fIngresoProductoIGV;

	private float fIngresoProductoSubTotal;

	@Column(nullable=false)
	private float fIngresoProductoTotal;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iFormaPagoId", nullable=false)
	private Formapago formaPago;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iSucursalId", nullable=false)
	private Sucursal sucursal;
	
	
	//private int iFormaPagoId;

	private int iUsuarioActualizaId;

	//bi-directional many-to-one association to Usuario
    @ManyToOne
	@JoinColumn(name="iUsuarioInsertaId", nullable=false)
	private Usuario usuario;
    
	/*@Column(nullable=false)
	private int iUsuarioInsertaId;
*/
	@Column(nullable=false, length=25)
	private String nIngresoProductoNumero;

	@Column(length=1)
	private String vPrincipal;

	//bi-directional many-to-one association to Estadocuentaproveedor
	@OneToMany(mappedBy="ingresoproducto", fetch=FetchType.EAGER, cascade = CascadeType.REFRESH) 
	private List<Estadocuentaproveedor> estadocuentaproveedors;
	
	//bi-directional many-to-one association to Estadocuentaproveedor
	@OneToMany(mappedBy="ingresoProducto", fetch=FetchType.EAGER,cascade = CascadeType.REFRESH) 
	private List<Letraproveedor> letraproveedor; 


	//bi-directional many-to-one association to Proveedor
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iProveedorId", nullable=false)
	private Proveedor proveedor;

	//bi-directional many-to-one association to Tipodocumento
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iTipoDocumentoId", nullable=false)
	private Tipodocumentogestion tipodocumento;
    
 /*   @Column(nullable=false)
    private int iTipoDocumentoId;
*/
	//bi-directional many-to-one association to Ingresoproductodetalle
	@OneToMany(mappedBy="ingresoproducto" ,cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Ingresoproductodetalle> ingresoproductodetalles;
	
	@OneToMany(mappedBy="ingresoProducto" ,cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Kardex> kardex;
	
	
	@Column(length=45)
	private String vEstadoDocumento;

	
	@Column(length=45)
	private String vIngresoProductoPuntoLlegada;
	
	
	private float fPercepcion;
	
	private int iNumeroDias;
	
	private int iNumeroLetras;
	
	@Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date dFechaProximoPago;
	
	private float fMontoAdelantado;	
	
	@Column(nullable=false)
	private float fDescuento;
	
	@Column(nullable=false)
	private float fIngresoProductoTotalReal;
	
	private int iPeriodoId;
	
    public Ingresoproducto() {
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
/*
	*//**
	 * @return the iFormaPagoId
	 *//*
	public int getiFormaPagoId() {
		return iFormaPagoId;
	}

	*//**
	 * @param iFormaPagoId the iFormaPagoId to set
	 *//*
	public void setiFormaPagoId(int iFormaPagoId) {
		this.iFormaPagoId = iFormaPagoId;
	}*/

	
	
	/**
	 * @return the iUsuarioActualizaId
	 */
	public int getiUsuarioActualizaId() {
		return iUsuarioActualizaId;
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
	 * @param iUsuarioActualizaId the iUsuarioActualizaId to set
	 */
	public void setiUsuarioActualizaId(int iUsuarioActualizaId) {
		this.iUsuarioActualizaId = iUsuarioActualizaId;
	}

	/**
	 * @return the iUsuarioInsertaId
	 *//*
	public int getiUsuarioInsertaId() {
		return iUsuarioInsertaId;
	}

	*//**
	 * @param iUsuarioInsertaId the iUsuarioInsertaId to set
	 *//*
	public void setiUsuarioInsertaId(int iUsuarioInsertaId) {
		this.iUsuarioInsertaId = iUsuarioInsertaId;
	}
*/
	
	

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
	public List<Estadocuentaproveedor> getEstadocuentaproveedors() {
		return estadocuentaproveedors;
	}

	/**
	 * @param estadocuentaproveedors the estadocuentaproveedors to set
	 */
	public void setEstadocuentaproveedors(
			List<Estadocuentaproveedor> estadocuentaproveedors) {
		this.estadocuentaproveedors = estadocuentaproveedors;
	}

	/**
	 * @return the proveedor
	 */
	public Proveedor getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	
/**
	 * @return the iTipoDocumentoId
	 *//*
	public int getiTipoDocumentoId() {
		return iTipoDocumentoId;
	}

	*//**
	 * @param iTipoDocumentoId the iTipoDocumentoId to set
	 *//*
	public void setiTipoDocumentoId(int iTipoDocumentoId) {
		
		this.iTipoDocumentoId = iTipoDocumentoId;
	}
*/
	
	/**
	 * @return the tipodocumento
	 */
	public Tipodocumentogestion getTipodocumento() {
		return tipodocumento;
	}

	/**
	 * @param tipodocumento the tipodocumento to set
	 */
	public void setTipodocumento(Tipodocumentogestion tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	/**
	 * @return the ingresoproductodetalles
	 */
	public List<Ingresoproductodetalle> getIngresoproductodetalles() {
		return ingresoproductodetalles;
	}

	/**
	 * @param ingresoproductodetalles the ingresoproductodetalles to set
	 */
	public void setIngresoproductodetalles(
			List<Ingresoproductodetalle> ingresoproductodetalles) {
		this.ingresoproductodetalles = ingresoproductodetalles;
	}

	
	/**
	 * @return the kardex
	 */
	public List<Kardex> getKardex() {
		return kardex;
	}

	/**
	 * @param kardex the kardex to set
	 */
	public void setKardex(List<Kardex> kardex) {
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

	/**
	 * @return the letraproveedor
	 */
	public List<Letraproveedor> getLetraproveedor() {
		return letraproveedor;
	}

	/**
	 * @param letraproveedor the letraproveedor to set
	 */
	public void setLetraproveedor(List<Letraproveedor> letraproveedor) {
		this.letraproveedor = letraproveedor;
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