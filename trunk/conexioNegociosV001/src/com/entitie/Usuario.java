package com.entitie;

import java.io.Serializable;
import javax.persistence.*;

import com.entities.vo.PerfilVo;
import com.entities.vo.PersonaVo;
import com.entities.vo.UsuarioVo;

import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iUsuarioId;

	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iPerfilId")	
	private Perfil perfil;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iPersonaId")
	private Persona persona;

	private BigInteger iUsuarioActualizaId;

	private BigInteger iUsuarioInsertaId;

	private String vContrasena;

	private String vIdentificador;

	private String vUsuario;

	public Usuario() {
	}

	public Usuario(UsuarioVo  usuario) {
		this.iUsuarioId = usuario.getiUsuarioId();
		this.cEstadoCodigo =usuario.getcEstadoCodigo();
		this.dFechaActualiza = usuario.getdFechaActualiza();
		this.dFechaInserta = usuario.getdFechaInserta();
		this.perfil = new Perfil(usuario.getPerfil());
		this.persona = new Persona(usuario.getPersona());
		this.iUsuarioActualizaId = usuario.getiUsuarioActualizaId();
		this.iUsuarioInsertaId = usuario.getiUsuarioInsertaId();
		this.vContrasena = usuario.getvContrasena();
		this.vIdentificador = usuario.getvIdentificador();
		this.vUsuario = usuario.getvUsuario();
	}
	/**
	 * @return the iUsuarioId
	 */
	public String getiUsuarioId() {
		return iUsuarioId;
	}

	/**
	 * @param iUsuarioId the iUsuarioId to set
	 */
	public void setiUsuarioId(String iUsuarioId) {
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
	public BigInteger getiUsuarioActualizaId() {
		return iUsuarioActualizaId;
	}

	/**
	 * @param iUsuarioActualizaId the iUsuarioActualizaId to set
	 */
	public void setiUsuarioActualizaId(BigInteger iUsuarioActualizaId) {
		this.iUsuarioActualizaId = iUsuarioActualizaId;
	}

	/**
	 * @return the iUsuarioInsertaId
	 */
	public BigInteger getiUsuarioInsertaId() {
		return iUsuarioInsertaId;
	}

	/**
	 * @param iUsuarioInsertaId the iUsuarioInsertaId to set
	 */
	public void setiUsuarioInsertaId(BigInteger iUsuarioInsertaId) {
		this.iUsuarioInsertaId = iUsuarioInsertaId;
	}

	/**
	 * @return the vContrasena
	 */
	public String getvContrasena() {
		return vContrasena;
	}

	/**
	 * @param vContrasena the vContrasena to set
	 */
	public void setvContrasena(String vContrasena) {
		this.vContrasena = vContrasena;
	}

	/**
	 * @return the vIdentificador
	 */
	public String getvIdentificador() {
		return vIdentificador;
	}

	/**
	 * @param vIdentificador the vIdentificador to set
	 */
	public void setvIdentificador(String vIdentificador) {
		this.vIdentificador = vIdentificador;
	}

	/**
	 * @return the vUsuario
	 */
	public String getvUsuario() {
		return vUsuario;
	}

	/**
	 * @param vUsuario the vUsuario to set
	 */
	public void setvUsuario(String vUsuario) {
		this.vUsuario = vUsuario;
	}

	/**
	 * @return the perfil
	 */
	public Perfil getPerfil() {
		return perfil;
	}

	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	

}