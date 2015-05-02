package com.entities;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the sexo database table.
 * 
 */
@Entity
@Table(name="sexo")
public class Sexo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int iSexoId;

	@Column(nullable=false, length=1)
	private String cSexoCodigo;

	@Column(nullable=false, length=9)
	private String vSexoDescripcion;

	//bi-directional many-to-one association to Personal
	/*@OneToMany(mappedBy="sexo")
	private List<Personal> personals;
    */
	private String cEstadoCodigo;
	
    public Sexo() {
    }

    
	public Sexo(int iSexoId, String vSexoDescripcion) {
		super();
		this.iSexoId = iSexoId;
		this.vSexoDescripcion = vSexoDescripcion;
	}


	/**
	 * @return the iSexoId
	 */
	public int getiSexoId() {
		return iSexoId;
	}

	/**
	 * @param iSexoId the iSexoId to set
	 */
	public void setiSexoId(int iSexoId) {
		this.iSexoId = iSexoId;
	}

	/**
	 * @return the cSexoCodigo
	 */
	public String getcSexoCodigo() {
		return cSexoCodigo;
	}

	/**
	 * @param cSexoCodigo the cSexoCodigo to set
	 */
	public void setcSexoCodigo(String cSexoCodigo) {
		this.cSexoCodigo = cSexoCodigo;
	}

	/**
	 * @return the vSexoDescripcion
	 */
	public String getvSexoDescripcion() {
		return vSexoDescripcion;
	}

	/**
	 * @param vSexoDescripcion the vSexoDescripcion to set
	 */
	public void setvSexoDescripcion(String vSexoDescripcion) {
		this.vSexoDescripcion = vSexoDescripcion;
	}

	/**
	 * @return the personals
	 
	public List<Personal> getPersonals() {
		return personals;
	}
*/
	/**
	 * @param personals the personals to set
	 
	public void setPersonals(List<Personal> personals) {
		this.personals = personals;
	}
*/
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

	
	
}