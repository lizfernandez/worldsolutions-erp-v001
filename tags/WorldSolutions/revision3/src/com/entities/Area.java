package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the area database table.
 * 
 */
@Entity
@Table(name="area")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int iAreaId;

	@Column(nullable=false, length=5)
	private String cAreaCodigo;

	@Column(nullable=false, length=2)
	private String cEstadoCodigo;

    @Temporal( TemporalType.TIMESTAMP )
	private Date dFechaActualiza;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date dFechaInserta;

	@Column(nullable=false)
	private int iUsuarioInsertaId;

	private int iUsuarioModificaId;

	@Column(nullable=false, length=45)
	private String vAreaDescripcion;

	//bi-directional many-to-one association to Personal
	@OneToMany(mappedBy="area")
	private List<Personal> personals;

    public Area() {
    }

	/**
	 * @return the iAreaId
	 */
	public int getiAreaId() {
		return iAreaId;
	}

	/**
	 * @param iAreaId the iAreaId to set
	 */
	public void setiAreaId(int iAreaId) {
		this.iAreaId = iAreaId;
	}

	/**
	 * @return the cAreaCodigo
	 */
	public String getcAreaCodigo() {
		return cAreaCodigo;
	}

	/**
	 * @param cAreaCodigo the cAreaCodigo to set
	 */
	public void setcAreaCodigo(String cAreaCodigo) {
		this.cAreaCodigo = cAreaCodigo;
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
	 * @return the vAreaDescripcion
	 */
	public String getvAreaDescripcion() {
		return vAreaDescripcion;
	}

	/**
	 * @param vAreaDescripcion the vAreaDescripcion to set
	 */
	public void setvAreaDescripcion(String vAreaDescripcion) {
		this.vAreaDescripcion = vAreaDescripcion;
	}

	/**
	 * @return the personals
	 */
	public List<Personal> getPersonals() {
		return personals;
	}

	/**
	 * @param personals the personals to set
	 */
	public void setPersonals(List<Personal> personals) {
		this.personals = personals;
	}

	
	
}