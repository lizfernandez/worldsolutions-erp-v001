package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the estadocuentaproveedor database table.
 * 
 */
@Entity
@Table(name="estadocuentaproveedor")
public class Estadocuentaproveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int iEstadoCuentaProveedor;

	@Column(length=2)
	private String cEstadoCodigo;

    @Temporal( TemporalType.DATE)
	private Date dFechaInserta;

    @Temporal( TemporalType.DATE)
	private Date dFechaPago;

	@Column(nullable=false, precision=10, scale=2)
	private float fMontoPago;

	private int iUsuarioInsertaId;

	//bi-directional many-to-one association to Ingresoproducto
    @ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.REFRESH  )//, cascade=CascadeType.PERSIST
	@JoinColumn(name="iIngresoProductoId", nullable=false)
	private Ingresoproducto ingresoproducto;

	//bi-directional many-to-one association to Proveedor
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iProveedorId", nullable=false)
	private Proveedor proveedor;
    
    
    @Column(length=45)
    private String sVendedor;
    
    public Estadocuentaproveedor() {
    }

	

	/**
	 * @return the iEstadoCuentaProveedor
	 */
	public int getiEstadoCuentaProveedor() {
		return iEstadoCuentaProveedor;
	}



	/**
	 * @param iEstadoCuentaProveedor the iEstadoCuentaProveedor to set
	 */
	public void setiEstadoCuentaProveedor(int iEstadoCuentaProveedor) {
		this.iEstadoCuentaProveedor = iEstadoCuentaProveedor;
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
	 * @return the dFechaPago
	 */
	public Date getdFechaPago() {
		
		return dFechaPago;
	}

	/**
	 * @param dFechaPago the dFechaPago to set
	 */
	public void setdFechaPago(Date dFechaPago) {
		this.dFechaPago = dFechaPago;
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
	 * @return the ingresoproducto
	 */
	public Ingresoproducto getIngresoproducto() {
		return ingresoproducto;
	}

	/**
	 * @param ingresoproducto the ingresoproducto to set
	 */
	public void setIngresoproducto(Ingresoproducto ingresoproducto) {
		this.ingresoproducto = ingresoproducto;
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
	 * @return the sVendedor
	 */
	public String getsVendedor() {
		return sVendedor;
	}



	/**
	 * @param sVendedor the sVendedor to set
	 */
	public void setsVendedor(String sVendedor) {
		this.sVendedor = sVendedor;
	}

	
	
}