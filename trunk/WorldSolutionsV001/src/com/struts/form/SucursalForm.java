package com.struts.form;


import java.util.List;

import org.apache.struts.action.ActionForm;

import com.entities.Sucursal;
import com.entities.Personal;


public class SucursalForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List lista;	
	Sucursal sucursal = new Sucursal();
    private String mode;
    private List paginas;
    private int pagInicio;
	/**
	 * @return the lista
	 */
	public List getLista() {
		return lista;
	}
	/**
	 * @param lista the lista to set
	 */
	public void setLista(List lista) {
		this.lista = lista;
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
	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * @return the paginas
	 */
	public List getPaginas() {
		return paginas;
	}
	/**
	 * @param paginas the paginas to set
	 */
	public void setPaginas(List paginas) {
		this.paginas = paginas;
	}
	/**
	 * @return the pagInicio
	 */
	public int getPagInicio() {
		return pagInicio;
	}
	/**
	 * @param pagInicio the pagInicio to set
	 */
	public void setPagInicio(int pagInicio) {
		this.pagInicio = pagInicio;
	}

	/**
	 * @return the iSucursalId
	 */
	public int getiSucursalId() {
		return sucursal.getiSucursalId();
	}

	/**
	 * @param iSucursalId the iSucursalId to set
	 */
	public void setiSucursalId(int iSucursalId) {
		sucursal.setiSucursalId(iSucursalId);
	}

	/**
	 * @return the cSucursalCodigo
	 */
	public String getcSucursalCodigo() {
		return sucursal.getcSucursalCodigo();
	}

	/**
	 * @param cSucursalCodigo the cSucursalCodigo to set
	 */
	public void setcSucursalCodigo(String cSucursalCodigo) {
		sucursal.setcSucursalCodigo(cSucursalCodigo);
	}

	/**
	 * @return the cEstadoCodigo
	 */
	public String getcEstadoCodigo() {
		return sucursal.getcEstadoCodigo();
	}

	/**
	 * @param cEstadoCodigo the cEstadoCodigo to set
	 */
	public void setcEstadoCodigo(String cEstadoCodigo) {
		sucursal.setcEstadoCodigo(cEstadoCodigo);
	}

	

	

	/**
	 * @return the vSucursalDireccion
	 */
	public String getvSucursalDireccion() {
		return sucursal.getvSucursalDireccion();
	}

	/**
	 * @param vSucursalDireccion the vSucursalDireccion to set
	 */
	public void setvSucursalDireccion(String vSucursalDireccion) {
		this.sucursal.setvSucursalDireccion(vSucursalDireccion);
	}

	

	/**
	 * @return the vSucursalTelefono
	 */
	public String getvSucursalTelefono() {
		return sucursal.getvSucursalTelefono();
	}

	/**
	 * @param vSucursalTelefono the vSucursalTelefono to set
	 */
	public void setvSucursalTelefono(String vSucursalTelefono) {
		this.sucursal.setvSucursalTelefono(vSucursalTelefono);
	}
	/**
	 * @return the vSucursalTelefono
	 */
	public String getvSucursalNombre() {
		return sucursal.getvSucursalNombre();
	}

	/**
	 * @param vSucursalTelefono the vSucursalTelefono to set
	 */
	public void setvSucursalNombre(String vSucursalNombre) {
		this.sucursal.setvSucursalNombre(vSucursalNombre);
	}

	

}
