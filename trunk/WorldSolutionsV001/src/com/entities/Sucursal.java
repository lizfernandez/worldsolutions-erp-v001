package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.entities.vo.SucursalVo;

import java.util.Date;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@Table(name="sucursal")
public class Sucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int iSucursalId;
	
	private String cSucursalCodigo;
	
	@Column(nullable=false, length=2)
	private String cEstadoCodigo;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date dFechaInserta;

	private int iUsuarioActualizaId;

	@Column(nullable=false)
	private int iUsuarioInsertaId;

	
	@Column(nullable=false, length=45)
	private String vSucursalDireccion;

	@Column(nullable=false, length=45)
	private String vSucursalNombre;

	@Column(nullable=false, length=45)
	private String vSucursalTelefono;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="iEmpresaId", nullable=false)	
	private Empresa empresa ;
	
	public Sucursal() {
		
	}
	
	public Sucursal(SucursalVo sucursalVo) {
		this.iSucursalId = sucursalVo.getiSucursalId();
		this.cSucursalCodigo = sucursalVo.getcSucursalCodigo();
		this.cEstadoCodigo = sucursalVo.getcEstadoCodigo();
		this.dFechaActualiza = sucursalVo.getdFechaActualiza();
		this.dFechaInserta = sucursalVo.getdFechaInserta();
		this.iUsuarioActualizaId = sucursalVo.getiUsuarioActualizaId();
		this.iUsuarioInsertaId = sucursalVo.getiUsuarioInsertaId();
		this.vSucursalDireccion = sucursalVo.getvSucursalDireccion();
		this.vSucursalNombre = sucursalVo.getvSucursalNombre();
		this.vSucursalTelefono = sucursalVo.getvSucursalTelefono();
		if(sucursalVo.getEmpresa()!=null)
		this.empresa = new Empresa(sucursalVo.getEmpresa());
	}


	/**
	 * @return the iSucursalId
	 */
	public int getiSucursalId() {
		return iSucursalId;
	}

	/**
	 * @param iSucursalId the iSucursalId to set
	 */
	public void setiSucursalId(int iSucursalId) {
		this.iSucursalId = iSucursalId;
	}

	/**
	 * @return the cSucursalCodigo
	 */
	public String getcSucursalCodigo() {
		return cSucursalCodigo;
	}

	/**
	 * @param cSucursalCodigo the cSucursalCodigo to set
	 */
	public void setcSucursalCodigo(String cSucursalCodigo) {
		this.cSucursalCodigo = cSucursalCodigo;
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
	 * @return the vSucursalDireccion
	 */
	public String getvSucursalDireccion() {
		return vSucursalDireccion;
	}

	/**
	 * @param vSucursalDireccion the vSucursalDireccion to set
	 */
	public void setvSucursalDireccion(String vSucursalDireccion) {
		this.vSucursalDireccion = vSucursalDireccion;
	}

	/**
	 * @return the vSucursalNombre
	 */
	public String getvSucursalNombre() {
		return vSucursalNombre;
	}

	/**
	 * @param vSucursalNombre the vSucursalNombre to set
	 */
	public void setvSucursalNombre(String vSucursalNombre) {
		this.vSucursalNombre = vSucursalNombre;
	}

	/**
	 * @return the vSucursalTelefono
	 */
	public String getvSucursalTelefono() {
		return vSucursalTelefono;
	}

	/**
	 * @param vSucursalTelefono the vSucursalTelefono to set
	 */
	public void setvSucursalTelefono(String vSucursalTelefono) {
		this.vSucursalTelefono = vSucursalTelefono;
	}
	/**
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}
	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	

	

}