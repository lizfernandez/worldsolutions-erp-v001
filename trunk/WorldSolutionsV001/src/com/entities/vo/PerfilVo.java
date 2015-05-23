package com.entities.vo;

import java.io.Serializable;

import java.util.Date;

import com.entities.Perfil;

public class PerfilVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int iPerfilId;
	private String cEstadoCodigo;
	private String cPerfilCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
	private String vPerfilDescripcion;
	private String cInventario;
	private String cProveedor;
	private String cClientes;
	private String cCompras;
	private String cVentas;
	private String cEstadisticas;
	private String cMantenimiento;

    public PerfilVo() {
    }

	public PerfilVo(Perfil perfil) {
		this.iPerfilId = perfil.getiPerfilId();
		this.cEstadoCodigo = perfil.getcEstadoCodigo();
		this.cPerfilCodigo = perfil.getcPerfilCodigo();
		this.dFechaActualiza = perfil.getdFechaActualiza();
		this.dFechaInserta = perfil.getdFechaInserta();
		this.iUsuarioActualizaId = perfil.getiUsuarioActualizaId();
		this.iUsuarioInsertaId = perfil.getiUsuarioInsertaId();
		this.vPerfilDescripcion = perfil.getvPerfilDescripcion();
		this.cInventario = perfil.getcInventario();
		this.cProveedor = perfil.getcProveedor();
		this.cClientes = perfil.getcClientes();
		this.cCompras = perfil.getcCompras();
		this.cVentas = perfil.getcVentas();
		this.cEstadisticas = perfil.getcEstadisticas();
		this.cMantenimiento = perfil.getcMantenimiento();
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