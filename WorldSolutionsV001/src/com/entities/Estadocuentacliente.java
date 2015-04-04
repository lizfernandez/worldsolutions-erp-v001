package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the estadocuentacliente database table.
 * 
 */
@Entity
@Table(name="estadocuentacliente")
public class Estadocuentacliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int iEstadoCuentaCliente;

	@Column(length=2)
	private String cEstadoCodigo;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaInserta;

    @Temporal( TemporalType.DATE)
	private Date dFechaPago;

	@Column(nullable=false, precision=10, scale=2)
	private float fMontoPago;


	private int iUsuarioInsertaId;
	
	//bi-directional many-to-one association to Ingresoproducto
    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name="iVentaId", nullable=false)
	private Venta venta;

    //private int iVentaId;
    
	//bi-directional many-to-one association to Proveedor
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iClienteId", nullable=false)
	private Cliente cliente;
    
   

    public Estadocuentacliente() {
    }

	
/*
	*//**
	 * @return the iVentaId
	 *//*
	public int getiVentaId() {
		return iVentaId;
	}



	*//**
	 * @param iVentaId the iVentaId to set
	 *//*
	public void setiVentaId(int iVentaId) {
		this.iVentaId = iVentaId;
	}

*/

	/**
	 * @return the iEstadoCuentaCliente
	 */
	public int getiEstadoCuentaCliente() {
		return iEstadoCuentaCliente;
	}



	/**
	 * @param iEstadoCuentaCliente the iEstadoCuentaCliente to set
	 */
	public void setiEstadoCuentaCliente(int iEstadoCuentaCliente) {
		this.iEstadoCuentaCliente = iEstadoCuentaCliente;
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
	 * @return the venta
	 */
	public Venta getVenta() {
		return venta;
	}



	/**
	 * @param venta the venta to set
	 */
	public void setVenta(Venta venta) {
		this.venta = venta;
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

	

	

}