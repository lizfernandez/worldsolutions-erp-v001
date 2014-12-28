package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;



/**
 * The persistent class for the perfil database table.
 * 
 */
@Entity
@Table(name="perfil")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int iPerfilId;

	@Column(nullable=false, length=2)
	private String cEstadoCodigo;

	@Column(nullable=false, length=5)
	private String cPerfilCodigo;

    @Temporal( TemporalType.DATE)
	private Date dFechaActualiza;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date dFechaInserta;

	private int iUsuarioActualizaId;

	@Column(nullable=false)
	private int iUsuarioInsertaId;

	@Column(nullable=false, length=45)
	private String vPerfilDescripcion;

	@Column(length=2)
	private String cInventario;
	
	@Column(length=2)
	private String cProveedor;
	
	@Column(length=2)
	private String cClientes;
	
	@Column(length=2)
	private String cCompras;
	
	@Column(length=2)
	private String cVentas;
	
	@Column(length=2)
	private String cEstadisticas;
	
	@Column(length=2)
	private String cMantenimiento;

	//bi-directional many-to-one association to Usuario
	/*@OneToMany(mappedBy="perfil")
	private List<Usuario> usuarios;
*/
    public Perfil() {
    }

	/**
	 * @return the iPerfilId
	 */
	public int getiPerfilId() {
		return iPerfilId;
	}

	/**
	 * @param iPerfilId the iPerfilId to set
	 */
	public void setiPerfilId(int iPerfilId) {
		this.iPerfilId = iPerfilId;
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
	 * @return the cPerfilCodigo
	 */
	public String getcPerfilCodigo() {
		return cPerfilCodigo;
	}

	/**
	 * @param cPerfilCodigo the cPerfilCodigo to set
	 */
	public void setcPerfilCodigo(String cPerfilCodigo) {
		this.cPerfilCodigo = cPerfilCodigo;
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
	 * @return the vPerfilDescripcion
	 */
	public String getvPerfilDescripcion() {
		return vPerfilDescripcion;
	}

	/**
	 * @param vPerfilDescripcion the vPerfilDescripcion to set
	 */
	public void setvPerfilDescripcion(String vPerfilDescripcion) {
		this.vPerfilDescripcion = vPerfilDescripcion;
	}

	/**
	 * @return the cInventario
	 */
	public String getcInventario() {
		return cInventario;
	}

	/**
	 * @param cInventario the cInventario to set
	 */
	public void setcInventario(String cInventario) {
		this.cInventario = cInventario;
	}

	/**
	 * @return the cProveedor
	 */
	public String getcProveedor() {
		return cProveedor;
	}

	/**
	 * @param cProveedor the cProveedor to set
	 */
	public void setcProveedor(String cProveedor) {
		this.cProveedor = cProveedor;
	}

	/**
	 * @return the cClientes
	 */
	public String getcClientes() {
		return cClientes;
	}

	/**
	 * @param cClientes the cClientes to set
	 */
	public void setcClientes(String cClientes) {
		this.cClientes = cClientes;
	}

	/**
	 * @return the cCompras
	 */
	public String getcCompras() {
		return cCompras;
	}

	/**
	 * @param cCompras the cCompras to set
	 */
	public void setcCompras(String cCompras) {
		this.cCompras = cCompras;
	}

	/**
	 * @return the cVentas
	 */
	public String getcVentas() {
		return cVentas;
	}

	/**
	 * @param cVentas the cVentas to set
	 */
	public void setcVentas(String cVentas) {
		this.cVentas = cVentas;
	}

	/**
	 * @return the cEstadisticas
	 */
	public String getcEstadisticas() {
		return cEstadisticas;
	}

	/**
	 * @param cEstadisticas the cEstadisticas to set
	 */
	public void setcEstadisticas(String cEstadisticas) {
		this.cEstadisticas = cEstadisticas;
	}

	/**
	 * @return the cMantenimiento
	 */
	public String getcMantenimiento() {
		return cMantenimiento;
	}

	/**
	 * @param cMantenimiento the cMantenimiento to set
	 */
	public void setcMantenimiento(String cMantenimiento) {
		this.cMantenimiento = cMantenimiento;
	}

	

	
	
}