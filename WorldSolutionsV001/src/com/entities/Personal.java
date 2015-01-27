package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the personal database table.
 * 
 */
@Entity
@Table(name="personal")
public class Personal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int iPersonalId;

	@Column(length=2)
	private String cEstadoCodigo;

	@Column(nullable=false, length=5)
	private String cPersonalCodigo;

    @Temporal( TemporalType.DATE)
	private Date dFechaAcualiza;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date dFechaInserta;

	private int iUsuarioActualizaId;

	@Column(nullable=false)
	private int iUsuarioInsertaId;

	@Column(nullable=false, precision=10)
	private BigDecimal nPersonalNumeroDocumento;

	@Column(nullable=false, length=45)
	private String vPersonalApellidoMaterno;

	@Column(nullable=false, length=45)
	private String vPersonalApellidoPaterno;

	@Column(nullable=false, length=45)
	private String vPersonalNombres;

	//bi-directional many-to-one association to Area
    @ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="iAreaId", nullable=false)
	private Area area;
    
  //bi-directional many-to-one association to Area
    @ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="iOcupacionId", nullable=false)
	private Ocupacion ocupacion;
    
    private float fSueldo;

        
	//bi-directional many-to-one association to Sexo
    /*@ManyToOne
	@JoinColumn(name="iSexoId", nullable=false)*/
	private int iSexoId;

	//bi-directional many-to-one association to Tipodocumento
    @ManyToOne(fetch=FetchType.LAZY )
	@JoinColumn(name="iTipoDocumentoId", nullable=false)
	private Tipodocumento tipodocumento;
    
    

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="personal")
	private List<Usuario> usuarios;

    public Personal() {
    }

	/**
	 * @return the iPersonalId
	 */
	public int getiPersonalId() {
		return iPersonalId;
	}

	/**
	 * @param iPersonalId the iPersonalId to set
	 */
	public void setiPersonalId(int iPersonalId) {
		this.iPersonalId = iPersonalId;
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
	 * @return the cPersonalCodigo
	 */
	public String getcPersonalCodigo() {
		return cPersonalCodigo;
	}

	/**
	 * @param cPersonalCodigo the cPersonalCodigo to set
	 */
	public void setcPersonalCodigo(String cPersonalCodigo) {
		this.cPersonalCodigo = cPersonalCodigo;
	}

	/**
	 * @return the dFechaAcualiza
	 */
	public Date getdFechaAcualiza() {
		return dFechaAcualiza;
	}

	/**
	 * @param dFechaAcualiza the dFechaAcualiza to set
	 */
	public void setdFechaAcualiza(Date dFechaAcualiza) {
		this.dFechaAcualiza = dFechaAcualiza;
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
	 * @return the nPersonalNumeroDocumento
	 */
	public BigDecimal getnPersonalNumeroDocumento() {
		return nPersonalNumeroDocumento;
	}

	/**
	 * @param nPersonalNumeroDocumento the nPersonalNumeroDocumento to set
	 */
	public void setnPersonalNumeroDocumento(BigDecimal nPersonalNumeroDocumento) {
		this.nPersonalNumeroDocumento = nPersonalNumeroDocumento;
	}

	/**
	 * @return the vPersonalApellidoMaterno
	 */
	public String getvPersonalApellidoMaterno() {
		return vPersonalApellidoMaterno;
	}

	/**
	 * @param vPersonalApellidoMaterno the vPersonalApellidoMaterno to set
	 */
	public void setvPersonalApellidoMaterno(String vPersonalApellidoMaterno) {
		this.vPersonalApellidoMaterno = vPersonalApellidoMaterno;
	}

	/**
	 * @return the vPersonalApellidoPaterno
	 */
	public String getvPersonalApellidoPaterno() {
		return vPersonalApellidoPaterno;
	}

	/**
	 * @param vPersonalApellidoPaterno the vPersonalApellidoPaterno to set
	 */
	public void setvPersonalApellidoPaterno(String vPersonalApellidoPaterno) {
		this.vPersonalApellidoPaterno = vPersonalApellidoPaterno;
	}

	/**
	 * @return the vPersonalNombres
	 */
	public String getvPersonalNombres() {
		return vPersonalNombres;
	}

	/**
	 * @param vPersonalNombres the vPersonalNombres to set
	 */
	public void setvPersonalNombres(String vPersonalNombres) {
		this.vPersonalNombres = vPersonalNombres;
	}

	/**
	 * @return the area
	 */
	public Area getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(Area area) {
		this.area = area;
	}

	
	


	/**
	 * @return the sexo
	 */
	public int getiSexoId() {
		return iSexoId;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setiSexoId(int iSexoId) {
		this.iSexoId = iSexoId;
	}

	/**
	 * @return the tipodocumento
	 */
	public Tipodocumento getTipodocumento() {
		return tipodocumento;
	}

	/**
	 * @param tipodocumento the tipodocumento to set
	 */
	public void setTipodocumento(Tipodocumento tipodocumento) {
		this.tipodocumento = tipodocumento;
	}
	
	

	
	/**
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @return the ocupacion
	 */
	public Ocupacion getOcupacion() {
		return ocupacion;
	}

	/**
	 * @param ocupacion the ocupacion to set
	 */
	public void setOcupacion(Ocupacion ocupacion) {
		this.ocupacion = ocupacion;
	}

	/**
	 * @return the fSueldo
	 */
	public float getfSueldo() {
		return fSueldo;
	}

	/**
	 * @param fSueldo the fSueldo to set
	 */
	public void setfSueldo(float fSueldo) {
		this.fSueldo = fSueldo;
	}

	
}