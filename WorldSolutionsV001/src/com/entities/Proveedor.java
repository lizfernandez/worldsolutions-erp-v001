package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the proveedor database table.
 * 
 */
@Entity
@Table(name="proveedor")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int iProveedorId;

	@Column(nullable=false, length=2)
	private String cEstadoCodigo;

	@Column(nullable=false, length=5)
	private String cProveedorCodigo;

    @Temporal( TemporalType.DATE)
	private Date dFechaActualiza;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date dFechaInserta;

	@Column(nullable=false, length=7)
	private String iPoblacionId;
 
    
	@Column(nullable=false)
	private int iUsuarioInsertaId;

	private int iUsuarioModificaId;

	@Column(nullable=false, precision=10)
	private BigDecimal nProveedorNumeroDocumento;

	@Column(nullable=false, length=45)
	private String vProveedorDireccion;

	@Column(length=100)
	private String vProveedorRazonSocial;

	@Column(length=45)
	private String vProveedorTelefono;

	//bi-directional many-to-one association to Estadocuentaproveedor
	@OneToMany(mappedBy="proveedor")
	private List<Estadocuentaproveedor> estadocuentaproveedors;

	//bi-directional many-to-one association to Ingresoproducto
	@OneToMany(mappedBy="proveedor")
	private List<Ingresoproducto> ingresoproductos;

	//bi-directional many-to-one association to Salidaproducto
	@OneToMany(mappedBy="proveedor")
	private List<Salidaproducto> salidaproductos;

    public Proveedor() {
    }

	/**
	 * @return the iProveedorId
	 */
	public int getiProveedorId() {
		return iProveedorId;
	}

	/**
	 * @param iProveedorId the iProveedorId to set
	 */
	public void setiProveedorId(int iProveedorId) {
		this.iProveedorId = iProveedorId;
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
	 * @return the cProveedorCodigo
	 */
	public String getcProveedorCodigo() {
		return cProveedorCodigo;
	}

	/**
	 * @param cProveedorCodigo the cProveedorCodigo to set
	 */
	public void setcProveedorCodigo(String cProveedorCodigo) {
		this.cProveedorCodigo = cProveedorCodigo;
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
	 * @return the iPoblacionId
	 */
	public String getiPoblacionId() {
		return iPoblacionId;
	
	}
	/**
	 * @param iPoblacionId the iPoblacionId to set
	 */
	public void setiPoblacionId(String iPoblacionId) {
		this.iPoblacionId = iPoblacionId;
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
	 * @return the iUsuarioModificaId
	 */
	public int getiUsuarioModificaId() {
		return iUsuarioModificaId;
	}

	/**
	 * @param iUsuarioModificaId the iUsuarioModificaId to set
	 */
	public void setiUsuarioModificaId(int iUsuarioModificaId) {
		this.iUsuarioModificaId = iUsuarioModificaId;
	}

	/**
	 * @return the nProveedorNumeroDocumento
	 */
	public BigDecimal getnProveedorNumeroDocumento() {
		return nProveedorNumeroDocumento;
	}

	/**
	 * @param nProveedorNumeroDocumento the nProveedorNumeroDocumento to set
	 */
	public void setnProveedorNumeroDocumento(BigDecimal nProveedorNumeroDocumento) {
		this.nProveedorNumeroDocumento = nProveedorNumeroDocumento;
	}

	/**
	 * @return the vProveedorDireccion
	 */
	public String getvProveedorDireccion() {
		return vProveedorDireccion;
	}

	/**
	 * @param vProveedorDireccion the vProveedorDireccion to set
	 */
	public void setvProveedorDireccion(String vProveedorDireccion) {
		this.vProveedorDireccion = vProveedorDireccion;
	}

	/**
	 * @return the vProveedorRazonSocial
	 */
	public String getvProveedorRazonSocial() {
		return vProveedorRazonSocial;
	}

	/**
	 * @param vProveedorRazonSocial the vProveedorRazonSocial to set
	 */
	public void setvProveedorRazonSocial(String vProveedorRazonSocial) {
		this.vProveedorRazonSocial = vProveedorRazonSocial;
	}

	/**
	 * @return the vProveedorTelefono
	 */
	public String getvProveedorTelefono() {
		return vProveedorTelefono;
	}

	/**
	 * @param vProveedorTelefono the vProveedorTelefono to set
	 */
	public void setvProveedorTelefono(String vProveedorTelefono) {
		this.vProveedorTelefono = vProveedorTelefono;
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
	 * @return the ingresoproductos
	 */
	public List<Ingresoproducto> getIngresoproductos() {
		return ingresoproductos;
	}

	/**
	 * @param ingresoproductos the ingresoproductos to set
	 */
	public void setIngresoproductos(List<Ingresoproducto> ingresoproductos) {
		this.ingresoproductos = ingresoproductos;
	}

	/**
	 * @return the salidaproductos
	 */
	public List<Salidaproducto> getSalidaproductos() {
		return salidaproductos;
	}

	/**
	 * @param salidaproductos the salidaproductos to set
	 */
	public void setSalidaproductos(List<Salidaproducto> salidaproductos) {
		this.salidaproductos = salidaproductos;
	}
}

	