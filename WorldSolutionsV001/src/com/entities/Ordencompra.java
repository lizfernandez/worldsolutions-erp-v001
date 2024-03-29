package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ordencompra database table.
 * 
 */
@Entity
public class Ordencompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iOrdenCompraId;

	private String cEstadoCodigo;

    @Temporal( TemporalType.DATE)
	private Date dFechaActualiza;

    @Temporal( TemporalType.DATE)
	private Date dFechaInserta;

    @Temporal( TemporalType.DATE)
	private Date dFechaPedido;

	private float fDescuento;

	private float fOrdenCompraIGV;

	private float fOrdenCompraSubTotal;

	private float fTipoCambio;

	private float fTotal;
	@ManyToOne
	@JoinColumn(name="iMonedaId", nullable=false)	
	private Moneda moneda;
	
	@ManyToOne
	@JoinColumn(name="iPeriodoId", nullable=false)		
	private Periodo periodo;
	
	@ManyToOne
	@JoinColumn(name="iProveedorId", nullable=false)
	private Proveedor proveedor;

	@ManyToOne
	@JoinColumn(name="iSucursalId", nullable=false)
	private Sucursal sucursal;

	@ManyToOne
	@JoinColumn(name="iTipoDocumentoId", nullable=false)
	private Tipodocumentogestion tipoDocumento;

	private int iUsuarioActualizaId;
	@ManyToOne
	@JoinColumn(name="iUsuarioInsertaId", nullable=false)
	private Usuario usuario;

	private String vEstadoDocumento;

	private String vNroOrden;
	
	@OneToMany(mappedBy="ordenCompra" ,cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Ordencompradetalle> ordenCompradetalles;
	

    public Ordencompra() {
    }

	/**
	 * @return the iOrdenCompraId
	 */
	public int getiOrdenCompraId() {
		return iOrdenCompraId;
	}

	/**
	 * @param iOrdenCompraId the iOrdenCompraId to set
	 */
	public void setiOrdenCompraId(int iOrdenCompraId) {
		this.iOrdenCompraId = iOrdenCompraId;
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
	 * @return the dFechaPedido
	 */
	public Date getdFechaPedido() {
		return dFechaPedido;
	}

	/**
	 * @param dFechaPedido the dFechaPedido to set
	 */
	public void setdFechaPedido(Date dFechaPedido) {
		this.dFechaPedido = dFechaPedido;
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
	 * @return the fOrdenCompraIGV
	 */
	public float getfOrdenCompraIGV() {
		return fOrdenCompraIGV;
	}

	/**
	 * @param fOrdenCompraIGV the fOrdenCompraIGV to set
	 */
	public void setfOrdenCompraIGV(float fOrdenCompraIGV) {
		this.fOrdenCompraIGV = fOrdenCompraIGV;
	}

	/**
	 * @return the fOrdenCompraSubTotal
	 */
	public float getfOrdenCompraSubTotal() {
		return fOrdenCompraSubTotal;
	}

	/**
	 * @param fOrdenCompraSubTotal the fOrdenCompraSubTotal to set
	 */
	public void setfOrdenCompraSubTotal(float fOrdenCompraSubTotal) {
		this.fOrdenCompraSubTotal = fOrdenCompraSubTotal;
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
	 * @return the fTotal
	 */
	public float getfTotal() {
		return fTotal;
	}

	/**
	 * @param fTotal the fTotal to set
	 */
	public void setfTotal(float fTotal) {
		this.fTotal = fTotal;
	}

	/**
	 * @return the moneda
	 */
	public Moneda getMoneda() {
		return moneda;
	}

	/**
	 * @param moneda the moneda to set
	 */
	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	/**
	 * @return the periodo
	 */
	public Periodo getPeriodo() {
		return periodo;
	}

	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
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
	 * @return the vNroOrden
	 */
	public String getvNroOrden() {
		return vNroOrden;
	}

	/**
	 * @param vNroOrden the vNroOrden to set
	 */
	public void setvNroOrden(String vNroOrden) {
		this.vNroOrden = vNroOrden;
	}

	/**
	 * @return the ordenCompradetalles
	 */
	public List<Ordencompradetalle> getOrdenCompradetalles() {
		return ordenCompradetalles;
	}

	/**
	 * @param ordenCompradetalles the ordenCompradetalles to set
	 */
	public void setOrdenCompradetalles(List<Ordencompradetalle> ordenCompradetalles) {
		this.ordenCompradetalles = ordenCompradetalles;
	}

	

}