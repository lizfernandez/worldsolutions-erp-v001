package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the almacen database table.
 * 
 */
@Entity
public class Almacen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iAlmacenId;

	private String cEstadoCodigo;

	private String cAlmacenCodigo;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaInserta;
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iSucursalId", nullable=false)	
	private Sucursal sucursal;

	private int iUsuarioActualizaId;

	private int iUsuarioInsertaId;

	private String vAlmacenDireccion;

	private String vAlmacenNombre;

	private String vAlmacenTelefono;

    public Almacen() {
    }

	/**
	 * @return the iAlmacenId
	 */
	public int getiAlmacenId() {
		return iAlmacenId;
	}

	/**
	 * @param iAlmacenId the iAlmacenId to set
	 */
	public void setiAlmacenId(int iAlmacenId) {
		this.iAlmacenId = iAlmacenId;
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
	 * @return the cAlmacenCodigo
	 */
	public String getcAlmacenCodigo() {
		return cAlmacenCodigo;
	}

	/**
	 * @param cAlmacenCodigo the cAlmacenCodigo to set
	 */
	public void setcAlmacenCodigo(String cAlmacenCodigo) {
		this.cAlmacenCodigo = cAlmacenCodigo;
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
	 * @return the vAlmacenDireccion
	 */
	public String getvAlmacenDireccion() {
		return vAlmacenDireccion;
	}

	/**
	 * @param vAlmacenDireccion the vAlmacenDireccion to set
	 */
	public void setvAlmacenDireccion(String vAlmacenDireccion) {
		this.vAlmacenDireccion = vAlmacenDireccion;
	}

	/**
	 * @return the vAlmacenNombre
	 */
	public String getvAlmacenNombre() {
		return vAlmacenNombre;
	}

	/**
	 * @param vAlmacenNombre the vAlmacenNombre to set
	 */
	public void setvAlmacenNombre(String vAlmacenNombre) {
		this.vAlmacenNombre = vAlmacenNombre;
	}

	/**
	 * @return the vAlmacenTelefono
	 */
	public String getvAlmacenTelefono() {
		return vAlmacenTelefono;
	}

	/**
	 * @param vAlmacenTelefono the vAlmacenTelefono to set
	 */
	public void setvAlmacenTelefono(String vAlmacenTelefono) {
		this.vAlmacenTelefono = vAlmacenTelefono;
	}


}