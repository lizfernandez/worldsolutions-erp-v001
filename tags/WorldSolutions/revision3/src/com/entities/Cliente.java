package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int iClienteId;

	@Column(length=2)
	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private int iUsuarioActualizaId;

	private int iUsuarioInsertaId;

	@Column(precision=10)
	private BigDecimal nClienteNumeroDocumento;

	@Column(length=50)
	private String nClienteTelefono;

	@Column(nullable=false, length=7)
	private String vClienteCodigo;

	@Column(nullable=false, length=100)
	private String vClienteRazonSocial;

	@Column(length=50)
	private String vNombreCliente;

	@Column(length=45)
	private String vRubro;
	
//bi-directional many-to-one association to Direccioncliente
	@OneToMany(mappedBy="cliente", fetch = FetchType.EAGER, cascade=CascadeType.PERSIST )
	private List<Direccioncliente> direccionclientes;
	
	//bi-directional many-to-one association to Estadocuentaproveedor
	@OneToMany(mappedBy="cliente")
	private List<Estadocuentacliente> estadocuentaclientes;
	
	//bi-directional many-to-one association to Estadocuentaproveedor
	@OneToMany(mappedBy="cliente", fetch = FetchType.EAGER, cascade=CascadeType.PERSIST )
	private List<Visitacliente> visitaCliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="iClasificacionClienteId", nullable=false)		
	private Clasificacioncliente clasificacion;
	
	private float fDescuento;
	
	
	public Cliente() {
	}


	/**
	 * @return the iClienteId
	 */
	public int getiClienteId() {
		return iClienteId;
	}


	/**
	 * @param iClienteId the iClienteId to set
	 */
	public void setiClienteId(int iClienteId) {
		this.iClienteId = iClienteId;
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
	 * @return the nClienteNumeroDocumento
	 */
	public BigDecimal getnClienteNumeroDocumento() {
		return nClienteNumeroDocumento;
	}


	/**
	 * @param nClienteNumeroDocumento the nClienteNumeroDocumento to set
	 */
	public void setnClienteNumeroDocumento(BigDecimal nClienteNumeroDocumento) {
		this.nClienteNumeroDocumento = nClienteNumeroDocumento;
	}


	/**
	 * @return the nClienteTelefono
	 */
	public String getnClienteTelefono() {
		return nClienteTelefono;
	}


	/**
	 * @param nClienteTelefono the nClienteTelefono to set
	 */
	public void setnClienteTelefono(String nClienteTelefono) {
		this.nClienteTelefono = nClienteTelefono;
	}


	/**
	 * @return the vClienteCodigo
	 */
	public String getvClienteCodigo() {
		return vClienteCodigo;
	}


	/**
	 * @param vClienteCodigo the vClienteCodigo to set
	 */
	public void setvClienteCodigo(String vClienteCodigo) {
		this.vClienteCodigo = vClienteCodigo;
	}


	/**
	 * @return the vClienteRazonSocial
	 */
	public String getvClienteRazonSocial() {
		return vClienteRazonSocial;
	}


	/**
	 * @param vClienteRazonSocial the vClienteRazonSocial to set
	 */
	public void setvClienteRazonSocial(String vClienteRazonSocial) {
		this.vClienteRazonSocial = vClienteRazonSocial;
	}


	/**
	 * @return the vNombreCliente
	 */
	public String getvNombreCliente() {
		return vNombreCliente;
	}


	/**
	 * @param vNombreCliente the vNombreCliente to set
	 */
	public void setvNombreCliente(String vNombreCliente) {
		this.vNombreCliente = vNombreCliente;
	}


	/**
	 * @return the vRubro
	 */
	public String getvRubro() {
		return vRubro;
	}


	/**
	 * @param vRubro the vRubro to set
	 */
	public void setvRubro(String vRubro) {
		this.vRubro = vRubro;
	}


	/**
	 * @return the direccionclientes
	 */
	public List<Direccioncliente> getDireccionclientes() {
		return direccionclientes;
	}


	/**
	 * @param direccionclientes the direccionclientes to set
	 */
	public void setDireccionclientes(List<Direccioncliente> direccionclientes) {
		this.direccionclientes = direccionclientes;
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
	 * @return the visitaCliente
	 */
	public List<Visitacliente> getVisitaCliente() {
		return visitaCliente;
	}


	/**
	 * @param visitaCliente the visitaCliente to set
	 */
	public void setVisitaCliente(List<Visitacliente> visitaCliente) {
		this.visitaCliente = visitaCliente;
	}


	/**
	 * @return the clasificacion
	 */
	public Clasificacioncliente getClasificacion() {
		return clasificacion;
	}


	/**
	 * @param clasificacion the clasificacion to set
	 */
	public void setClasificacion(Clasificacioncliente clasificacion) {
		this.clasificacion = clasificacion;
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


}