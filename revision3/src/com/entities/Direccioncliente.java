package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the direccioncliente database table.
 * 
 */
@Entity
@Table(name="direccioncliente")
public class Direccioncliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idireccionClienteId;

	private String cEstadoCodigo;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private String iPoblacionId;

	private int iUsuarioActualizaId;

	private int iUsuarioInsertaId;

	private String vDireccion;

	private String vPrincipal;

	private String vReferencia;

	//bi-directional many-to-one association to Cliente
    @ManyToOne( cascade=CascadeType.REFRESH)
	@JoinColumn(name="iClienteId")
	private Cliente cliente;

    public Direccioncliente() {
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
	 * @return the vDireccion
	 */
	public String getvDireccion() {
		return vDireccion;
	}

	/**
	 * @param vDireccion the vDireccion to set
	 */
	public void setvDireccion(String vDireccion) {
		this.vDireccion = vDireccion;
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
	 * @return the vReferencia
	 */
	public String getvReferencia() {
		return vReferencia;
	}

	/**
	 * @param vReferencia the vReferencia to set
	 */
	public void setvReferencia(String vReferencia) {
		this.vReferencia = vReferencia;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((iPoblacionId == null) ? 0 : iPoblacionId.hashCode());
		result = prime * result
				+ ((vDireccion == null) ? 0 : vDireccion.hashCode());
		result = prime * result
				+ ((vReferencia == null) ? 0 : vReferencia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccioncliente other = (Direccioncliente) obj;
		if (iPoblacionId == null) {
			if (other.iPoblacionId != null)
				return false;
		} else if (!iPoblacionId.equals(other.iPoblacionId))
			return false;
		if (vDireccion == null) {
			if (other.vDireccion != null)
				return false;
		} else if (!vDireccion.equals(other.vDireccion))
			return false;
		if (vReferencia == null) {
			if (other.vReferencia != null)
				return false;
		} else if (!vReferencia.equals(other.vReferencia))
			return false;
		return true;
	}

	
	
}