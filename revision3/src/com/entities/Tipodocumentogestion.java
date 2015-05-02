package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipodocumentogestion database table.
 * 
 */
@Entity
@Table(name="tipodocumentogestion")
public class Tipodocumentogestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int iTipoDocumentoGestionId;

	@Column(nullable=false, length=2)
	private String cTipoDocumentoGestionCodigo;

	@Column(nullable=false, length=45)
	private String vTipoDocumentoDescripcion;

    public Tipodocumentogestion() {
    }
    public Tipodocumentogestion(int iTipoDocumentoId, String vTipoDocuumentoDescripcion) {
		super();
		this.iTipoDocumentoGestionId = iTipoDocumentoId;
		this.vTipoDocumentoDescripcion = vTipoDocuumentoDescripcion;
	}
	/**
	 * @return the iTipoDocumentoGestionId
	 */
	public int getiTipoDocumentoGestionId() {
		return iTipoDocumentoGestionId;
	}
	/**
	 * @param iTipoDocumentoGestionId the iTipoDocumentoGestionId to set
	 */
	public void setiTipoDocumentoGestionId(int iTipoDocumentoGestionId) {
		this.iTipoDocumentoGestionId = iTipoDocumentoGestionId;
	}
	/**
	 * @return the cTipoDocumentoGestionCodigo
	 */
	public String getcTipoDocumentoGestionCodigo() {
		return cTipoDocumentoGestionCodigo;
	}
	/**
	 * @param cTipoDocumentoGestionCodigo the cTipoDocumentoGestionCodigo to set
	 */
	public void setcTipoDocumentoGestionCodigo(String cTipoDocumentoGestionCodigo) {
		this.cTipoDocumentoGestionCodigo = cTipoDocumentoGestionCodigo;
	}
	/**
	 * @return the vTipoDocumentoDescripcion
	 */
	public String getvTipoDocumentoDescripcion() {
		return vTipoDocumentoDescripcion;
	}
	/**
	 * @param vTipoDocumentoDescripcion the vTipoDocumentoDescripcion to set
	 */
	public void setvTipoDocumentoDescripcion(String vTipoDocumentoDescripcion) {
		this.vTipoDocumentoDescripcion = vTipoDocumentoDescripcion;
	}




}