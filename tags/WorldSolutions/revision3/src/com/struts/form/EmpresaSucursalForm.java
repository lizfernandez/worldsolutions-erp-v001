package com.struts.form;


import java.util.Date;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.entities.Empresa;
import com.entities.Sucursal;
import com.entities.Personal;


public class EmpresaSucursalForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List lista;	
	Sucursal sucursal = new Sucursal();
	Empresa empresa = new Empresa();
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
		String cEstadoCodigo=empresa.getcEmpresaCodigo();
		if(cEstadoCodigo==""){
			cEstadoCodigo= sucursal.getcEstadoCodigo();
		}
		return cEstadoCodigo;
		
	}

	/**
	 * @param cEstadoCodigo the cEstadoCodigo to set
	 */
	public void setcEstadoCodigo(String cEstadoCodigo) {
		sucursal.setcEstadoCodigo(cEstadoCodigo);
		empresa.setcEstadoCodigo(cEstadoCodigo);
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
	/**
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}
	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
		this.sucursal.setEmpresa(empresa);
	}

	/**
	 * @return the iEmpresaId
	 */
	public int getiEmpresaId() {
		int iEmpresaId = getEmpresa().getiEmpresaId();
		if(iEmpresaId==0){
			if(sucursal.getEmpresa()!=null){
				sucursal.setEmpresa(getEmpresa());
				iEmpresaId= sucursal.getEmpresa().getiEmpresaId();
			}
			else{
				iEmpresaId= 0;
			}
		 }
		return iEmpresaId;
	}

	/**
	 * @param iEmpresaId the iEmpresaId to set
	 */
	public void setiEmpresaId(int iEmpresaId) {
		this.getEmpresa().setiEmpresaId(iEmpresaId);
		this.getSucursal().setEmpresa(getEmpresa());
	}

	/**
	 * @return the cEmpresaCodigo
	 */
	public String getcEmpresaCodigo() {
		return getEmpresa().getcEmpresaCodigo();
	}

	/**
	 * @param cEmpresaCodigo the cEmpresaCodigo to set
	 */
	public void setcEmpresaCodigo(String cEmpresaCodigo) {
		this.getEmpresa().setcEmpresaCodigo(cEmpresaCodigo);
	}


	

	/**
	 * @return the vEmpresaDireccion
	 */
	public String getvEmpresaDireccion() {
		return getEmpresa().getvEmpresaDireccion();
	}

	/**
	 * @param vEmpresaDireccion the vEmpresaDireccion to set
	 */
	public void setvEmpresaDireccion(String vEmpresaDireccion) {
		this.getEmpresa().setvEmpresaDireccion(vEmpresaDireccion);
	}

	/**
	 * @return the vEmpresaNombre
	 */
	public String getvEmpresaNombre() {
		return getEmpresa().getvEmpresaNombre();
	}

	/**
	 * @param vEmpresaNombre the vEmpresaNombre to set
	 */
	public void setvEmpresaNombre(String vEmpresaNombre) {
		this.getEmpresa().setvEmpresaNombre(vEmpresaNombre);
	}

	/**
	 * @return the vEmpresaRuc
	 */
	public String getvEmpresaRuc() {
		return getEmpresa().getvEmpresaRuc();
	}

	/**
	 * @param vEmpresaRuc the vEmpresaRuc to set
	 */
	public void setvEmpresaRuc(String vEmpresaRuc) {
		this.getEmpresa().setvEmpresaRuc(vEmpresaRuc);
	}
	

}
