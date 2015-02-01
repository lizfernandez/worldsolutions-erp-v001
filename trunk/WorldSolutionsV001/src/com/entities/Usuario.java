package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iUsuarioId;

	@Column(length=2)
	private String cEstadoCodigo;

	@Column(nullable=false, length=5)
	private String cUsuarioCodigo;

    @Temporal( TemporalType.DATE)
	private Date dFechaActualiza;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date dFechaInserta;

	private int iUsuarioActualizaId;

	@Column(nullable=false)
	private int iUsuarioInsertaId;

	@Column(nullable=false, length=20)
	private String vUsuarioLogin;

	@Column(nullable=false, length=10)
	private String vUsuarioPassword;

	//bi-directional many-to-one association to Session
	@OneToMany(mappedBy="usuario")
	private List<Session> sessions;

	//bi-directional many-to-one association to Perfil
    @ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="iPerfilId", nullable=false)
	private Perfil perfil;
/**/
	//bi-directional many-to-one association to Personal
    @ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="iPersonalId", nullable=false)
	private Personal personal;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="usuario")
	private List<Venta> ventas;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="iSucursalId", nullable=false)
	private Sucursal sucursal;

    public Usuario() {
    }

	

	/**
	 * @return the iUsuarioId
	 */
	public int getiUsuarioId() {
		return iUsuarioId;
	}



	/**
	 * @param iUsuarioId the iUsuarioId to set
	 */
	public void setiUsuarioId(int iUsuarioId) {
		this.iUsuarioId = iUsuarioId;
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
	 * @return the cUsuarioCodigo
	 */
	public String getcUsuarioCodigo() {
		return cUsuarioCodigo;
	}



	/**
	 * @param cUsuarioCodigo the cUsuarioCodigo to set
	 */
	public void setcUsuarioCodigo(String cUsuarioCodigo) {
		this.cUsuarioCodigo = cUsuarioCodigo;
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
	 * @return the vUsuarioLogin
	 */
	public String getvUsuarioLogin() {
		return vUsuarioLogin;
	}



	/**
	 * @param vUsuarioLogin the vUsuarioLogin to set
	 */
	public void setvUsuarioLogin(String vUsuarioLogin) {
		this.vUsuarioLogin = vUsuarioLogin;
	}



	/**
	 * @return the vUsuarioPassword
	 */
	public String getvUsuarioPassword() {
		return vUsuarioPassword;
	}



	/**
	 * @param vUsuarioPassword the vUsuarioPassword to set
	 */
	public void setvUsuarioPassword(String vUsuarioPassword) {
		this.vUsuarioPassword = vUsuarioPassword;
	}



	public List<Session> getSessions() {
		return this.sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
	
	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	/**/
	public Personal getPersonal() {
		return this.personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
	
	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
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