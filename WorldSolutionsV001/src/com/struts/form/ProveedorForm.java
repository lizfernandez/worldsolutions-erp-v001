package com.struts.form;


import java.math.BigDecimal;

import java.util.List;

import org.apache.struts.action.ActionForm;


import com.entities.Estadocuentaproveedor;
import com.entities.Ingresoproducto;

import com.entities.Proveedor;

import com.entities.Salidaproducto;


public class ProveedorForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List lista;	
	Proveedor proveedor = new Proveedor();
    private String mode;
    private List paginas;
    private int pagInicio;
    private String vDepartamento;
    private String vProvincia;
    
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
	 * @return the proveedor
	 */
	public Proveedor getProveedor() {
		return proveedor;
	}
	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
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
	 * @return the iProveedorId
	 */
	public int getiProveedorId() {
		return proveedor.getiProveedorId();
	}

	/**
	 * @param iProveedorId the iProveedorId to set
	 */
	public void setiProveedorId(int iProveedorId) {
		proveedor.setiProveedorId(iProveedorId);
	}

	/**
	 * @return the cProveedorCodigo
	 */
	public String getcProveedorCodigo() {
		return proveedor.getcProveedorCodigo();
	}

	/**
	 * @param cProveedorCodigo the cProveedorCodigo to set
	 */
	public void setcProveedorCodigo(String cProveedorCodigo) {
		proveedor.setcProveedorCodigo(cProveedorCodigo);
	}

	/**
	 * @return the cEstadoCodigo
	 */
	public String getcEstadoCodigo() {
		return proveedor.getcEstadoCodigo();
	}

	/**
	 * @param cEstadoCodigo the cEstadoCodigo to set
	 */
	public void setcEstadoCodigo(String cEstadoCodigo) {
		proveedor.setcEstadoCodigo(cEstadoCodigo);
	}

	/*******************/
	
	
	/**
	 * @return the iPoblacionId
	 */
	public String getiPoblacionId() {
		return proveedor.getiPoblacionId();
	}

	/**
	 * @param iPoblacionId the iPoblacionId to set
	 */
	public void setiPoblacionId(String iPoblacionId) {
		this.proveedor.setiPoblacionId(iPoblacionId);
	}

	
	/**
	 * @return the vDepartamento
	 */
	public String getvDepartamento() {
	/*
		PoblacionDao poblacionDao = new PoblacionDao();	
		if(proveedor.getiPoblacionId()!="0"){
			vDepartamento =	(String.valueOf(proveedor.getiPoblacionId()).substring(0,2)+"0000");
			Poblacion  poblacion= poblacionDao.bucarPoblacion(vDepartamento);
			vDepartamento = poblacion.getcCodigo();
			
		}
		*/
		return vDepartamento;
	}
	/**
	 * @param vDepartamento the vDepartamento to set
	 */
	public void setvDepartamento(String vDepartamento) {
		this.vDepartamento = vDepartamento;
	}
	/**
	 * @return the vProvincia
	 */
	public String getvProvincia() {
		/*PoblacionDao poblacionDao = new PoblacionDao();	
		if(proveedor.getiPoblacionId()!="0"){
			vProvincia =	(String.valueOf(proveedor.getiPoblacionId()).substring(0,4)+"00");
			Poblacion  poblacion= poblacionDao.bucarPoblacion(vProvincia);
			vProvincia = poblacion.getcCodigo();
			
		}*/
		return vProvincia;
	}
	/**
	 * @param vProvincia the vProvincia to set
	 */
	public void setvProvincia(String vProvincia) {
		this.vProvincia = vProvincia;
	}
	/**
	 * @return the nProveedorNumeroDocumento
	 */
	public BigDecimal getnProveedorNumeroDocumento() {
		return proveedor.getnProveedorNumeroDocumento();
	}

	/**
	 * @param nProveedorNumeroDocumento the nProveedorNumeroDocumento to set
	 */
	public void setnProveedorNumeroDocumento(BigDecimal nProveedorNumeroDocumento) {
		this.proveedor.setnProveedorNumeroDocumento(nProveedorNumeroDocumento);
	}

	/**
	 * @return the vProveedorDireccion
	 */
	public String getvProveedorDireccion() {
		return proveedor.getvProveedorDireccion();
	}

	/**
	 * @param vProveedorDireccion the vProveedorDireccion to set
	 */
	public void setvProveedorDireccion(String vProveedorDireccion) {
		this.proveedor.setvProveedorDireccion(vProveedorDireccion);
	}

	/**
	 * @return the vProveedorRazonSocial
	 */
	public String getvProveedorRazonSocial() {
		return proveedor.getvProveedorRazonSocial();
	}

	/**
	 * @param vProveedorRazonSocial the vProveedorRazonSocial to set
	 */
	public void setvProveedorRazonSocial(String vProveedorRazonSocial) {
		this.proveedor.setvProveedorRazonSocial( vProveedorRazonSocial);
	}

	/**
	 * @return the vProveedorTelefono
	 */
	public String getvProveedorTelefono() {
		return proveedor.getvProveedorTelefono();
	}

	/**
	 * @param vProveedorTelefono the vProveedorTelefono to set
	 */
	public void setvProveedorTelefono(String vProveedorTelefono) {
		this.proveedor.setvProveedorTelefono( vProveedorTelefono);
	}

	/**
	 * @return the estadocuentaproveedors
	 */
	public List<Estadocuentaproveedor> getEstadocuentaproveedors() {
		return proveedor.getEstadocuentaproveedors();
	}

	/**
	 * @param estadocuentaproveedors the estadocuentaproveedors to set
	 */
	public void setEstadocuentaproveedors(List<Estadocuentaproveedor> estadocuentaproveedors) {
		this.proveedor.setEstadocuentaproveedors(estadocuentaproveedors);
	}

	/**
	 * @return the ingresoproductos
	 */
	public List<Ingresoproducto> getIngresoproductos() {
		return proveedor.getIngresoproductos();
	}

	/**
	 * @param ingresoproductos the ingresoproductos to set
	 */
	public void setIngresoproductos(List<Ingresoproducto> ingresoproductos) {
		this.proveedor.setIngresoproductos (ingresoproductos);
	}

	/**
	 * @return the salidaproductos
	 */
	public List<Salidaproducto> getSalidaproductos() {
		return proveedor.getSalidaproductos();
	}

	/**
	 * @param salidaproductos the salidaproductos to set
	 */
	public void setSalidaproductos(List<Salidaproducto> salidaproductos) {
		this.proveedor.setSalidaproductos ( salidaproductos);
	}

	

	

}
