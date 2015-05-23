package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.entities.vo.TipodocumentoVo;

/**
 * The persistent class for the tipodocumento database table.
 * 
 */
@Entity
@Table(name="tipodocumento")
public class Tipodocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(unique=true, nullable=true)
	private int iTipoDocumentoId;

	@Column(nullable=false, length=2)
	private String cTipoDocumentoCodigo;

	@Column(length=1)
	private String vGestion;

	@Column(nullable=false, length=45)
	private String vTipoDocuumentoDescripcion;

	//bi-directional many-to-one association to Ingresoproducto
	/*@OneToMany(mappedBy="tipodocumento")
	private List<Ingresoproducto> ingresoproductos;
*/
	//bi-directional many-to-one association to Personal
	/*@OneToMany(mappedBy="tipodocumento")
	private List<Personal> personals;
*/
	/*//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="tipodocumento")
	private List<Venta> ventas;
	*/
	private String cEstadoCodigo;

    public Tipodocumento() {
    	
    }
    
    

	public Tipodocumento(int iTipoDocumentoId, String vTipoDocuumentoDescripcion) {
		super();
		this.iTipoDocumentoId = iTipoDocumentoId;
		this.vTipoDocuumentoDescripcion = vTipoDocuumentoDescripcion;
	}



	public Tipodocumento(TipodocumentoVo tipodocumento) {
		this.iTipoDocumentoId = tipodocumento.getiTipoDocumentoId();
		this.vTipoDocuumentoDescripcion = tipodocumento.getvTipoDocuumentoDescripcion();
	}



	/**
	 * @return the iTipoDocumentoId
	 */
		public int getiTipoDocumentoId() {
		return iTipoDocumentoId;
	}

	/**
	 * @param iTipoDocumentoId the iTipoDocumentoId to set
	 */
	public void setiTipoDocumentoId(int iTipoDocumentoId) {
		this.iTipoDocumentoId = iTipoDocumentoId;
	}

	/**
	 * @return the cTipoDocumentoCodigo
	 */
	public String getcTipoDocumentoCodigo() {
		return cTipoDocumentoCodigo;
	}

	/**
	 * @param cTipoDocumentoCodigo the cTipoDocumentoCodigo to set
	 */
	public void setcTipoDocumentoCodigo(String cTipoDocumentoCodigo) {
		this.cTipoDocumentoCodigo = cTipoDocumentoCodigo;
	}

	/**
	 * @return the vGestion
	 */
	public String getvGestion() {
		return vGestion;
	}

	/**
	 * @param vGestion the vGestion to set
	 */
	public void setvGestion(String vGestion) {
		this.vGestion = vGestion;
	}

	/**
	 * @return the vTipoDocuumentoDescripcion
	 */
	public String getvTipoDocuumentoDescripcion() {
		return vTipoDocuumentoDescripcion;
	}

	/**
	 * @param vTipoDocuumentoDescripcion the vTipoDocuumentoDescripcion to set
	 */
	public void setvTipoDocuumentoDescripcion(String vTipoDocuumentoDescripcion) {
		this.vTipoDocuumentoDescripcion = vTipoDocuumentoDescripcion;
	}

	/**
	 * @return the ingresoproductos
	 *//*
	public List<Ingresoproducto> getIngresoproductos() {
		return ingresoproductos;
	}

	*//**
	 * @param ingresoproductos the ingresoproductos to set
	 *//*
	public void setIngresoproductos(List<Ingresoproducto> ingresoproductos) {
		this.ingresoproductos = ingresoproductos;
	}
*/
	/**
	 * @return the personals
	
	public List<Personal> getPersonals() {
		return personals;
	} */

	/**
	 * @param personals the personals to set
	 
	public void setPersonals(List<Personal> personals) {
		this.personals = personals;
	}*/

	/**
	 * @return the ventas
	 *//*
	public List<Venta> getVentas() {
		return ventas;
	}

	*//**
	 * @param ventas the ventas to set
	 *//*
	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}*/

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