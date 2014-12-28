package com.struts.form;

import java.math.BigDecimal;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.entities.Cliente;
import com.entities.Direccioncliente;

public class ClienteForm extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List lista;	
	Cliente cliente = new Cliente();
    private String mode;
    private List paginas;
    private int pagInicio;
    private String vDepartamento;
    private String vProvincia;
    private String vDireccion;
    private String iPoblacionId;
    private String vPrincipal;
    private String vReferencia;
    /** visitas**/
    private String dFechaVisista;
    private String dFecaProxVisita;
    private String vProductoOfrecido;
    private float fPrecioPactado;
    private String vMotivoVisita;
    private String vObservacion;
    
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
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
	 * @return the vDepartamento
	 */
	public String getvDepartamento() {
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
		
		return vProvincia;
	}
	/**
	 * @param vProvincia the vProvincia to set
	 */
	public void setvProvincia(String vProvincia) {
		this.vProvincia = vProvincia;
	}
    

	/**
	 * @return the iClienteId
	 */
	public int getiClienteId() {
		return cliente.getiClienteId();
	}

	/**
	 * @param iClienteId the iClienteId to set
	 */
	public void setiClienteId(int iClienteId) {
		this.cliente.setiClienteId(iClienteId);
	}

	/**
	 * @return the cEstadoCodigo
	 */
	public String getcEstadoCodigo() {
		return cliente.getcEstadoCodigo();
	}

	/**
	 * @param cEstadoCodigo the cEstadoCodigo to set
	 */
	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.cliente.setcEstadoCodigo (cEstadoCodigo);
	}


	/**
	 * @return the nClienteNumeroDocumento
	 */
	public BigDecimal getnClienteNumeroDocumento() {
		return cliente.getnClienteNumeroDocumento();
	}

	/**
	 * @param nClienteNumeroDocumento the nClienteNumeroDocumento to set
	 */
	public void setnClienteNumeroDocumento(BigDecimal nClienteNumeroDocumento) {
		this.cliente.setnClienteNumeroDocumento (nClienteNumeroDocumento);
	}

	/**
	 * @return the nClienteTelefono
	 */
	public String getnClienteTelefono() {
		return cliente.getnClienteTelefono();
	}

	/**
	 * @param nClienteTelefono the nClienteTelefono to set
	 */
	public void setnClienteTelefono(String nClienteTelefono) {
		this.cliente.setnClienteTelefono(nClienteTelefono);
	}

	/**
	 * @return the vClienteCodigo
	 */
	public String getvClienteCodigo() {
		return cliente.getvClienteCodigo();
	}

	/**
	 * @param vClienteCodigo the vClienteCodigo to set
	 */
	public void setvClienteCodigo(String vClienteCodigo) {
		this.cliente.setvClienteCodigo ( vClienteCodigo);
	}

	/**
	 * @return the vClienteRazonSocial
	 */
	public String getvClienteRazonSocial() {
		return cliente.getvClienteRazonSocial();
	}

	/**
	 * @param vClienteRazonSocial the vClienteRazonSocial to set
	 */
	public void setvClienteRazonSocial(String vClienteRazonSocial) {
		this.cliente.setvClienteRazonSocial ( vClienteRazonSocial);
	}

	/**
	 * @return the direccionclientes
	 */
	public List<Direccioncliente> getDireccionclientes() {
		return cliente.getDireccionclientes();
	}

	/**
	 * @param direccionclientes the direccionclientes to set
	 */
	public void setDireccionclientes(List<Direccioncliente> direccionclientes) {
		this.cliente.setDireccionclientes(direccionclientes);
	}
	/**
	 * @return the vDireccion
	 */
	public String getvDireccion() {
		return vDireccion;
	}
	/**
	 * @param vDireccion the vDireccion to set
	 */
	public void setvDireccion(String vDireccion) {
		this.vDireccion = vDireccion;
	}
	/**
	 * @return the iPoblacionId
	 */
	public String getiPoblacionId() {
		return iPoblacionId;
	}
	/**
	 * @param iPoblacionId the iPoblacionId to set
	 */
	public void setiPoblacionId(String iPoblacionId) {
		this.iPoblacionId = iPoblacionId;
	}
	/**
	 * @return the vPrincipal
	 */
	public String getvPrincipal() {
		return vPrincipal;
	}
	/**
	 * @param vPrincipal the vPrincipal to set
	 */
	public void setvPrincipal(String vPrincipal) {
		this.vPrincipal = vPrincipal;
	}
	/**
	 * @return the vReferencia
	 */
	public String getvReferencia() {
		return vReferencia;
	}
	/**
	 * @param vReferencia the vReferencia to set
	 */
	public void setvReferencia(String vReferencia) {
		this.vReferencia = vReferencia;
	}
	
	/**
	 * @return the vNombreCliente
	 */
	public String getvNombreCliente() {
		return cliente.getvNombreCliente();
	}


	/**
	 * @param vNombreCliente the vNombreCliente to set
	 */
	public void setvNombreCliente(String vNombreCliente) {
		this.cliente.setvNombreCliente(vNombreCliente);
	}


	/**
	 * @return the vRubro
	 */
	public String getvRubro() {
		return cliente.getvRubro();
	}


	/**
	 * @param vRubro the vRubro to set
	 */
	public void setvRubro(String vRubro) {
		this.cliente.setvRubro(vRubro);
	}
	/**
	 * @return the dFechaVisista
	 */
	public String getdFechaVisista() {
		return dFechaVisista;
	}
	/**
	 * @param dFechaVisista the dFechaVisista to set
	 */
	public void setdFechaVisista(String dFechaVisista) {
		this.dFechaVisista = dFechaVisista;
	}
	/**
	 * @return the dFecaProxVisita
	 */
	public String getdFecaProxVisita() {
		return dFecaProxVisita;
	}
	/**
	 * @param dFecaProxVisita the dFecaProxVisita to set
	 */
	public void setdFecaProxVisita(String dFecaProxVisita) {
		this.dFecaProxVisita = dFecaProxVisita;
	}
	/**
	 * @return the vProductoOfrecido
	 */
	public String getvProductoOfrecido() {
		return vProductoOfrecido;
	}
	/**
	 * @param vProductoOfrecido the vProductoOfrecido to set
	 */
	public void setvProductoOfrecido(String vProductoOfrecido) {
		this.vProductoOfrecido = vProductoOfrecido;
	}
	/**
	 * @return the fPrecioPactado
	 */
	public float getfPrecioPactado() {
		return fPrecioPactado;
	}
	/**
	 * @param fPrecioPactado the fPrecioPactado to set
	 */
	public void setfPrecioPactado(float fPrecioPactado) {
		this.fPrecioPactado = fPrecioPactado;
	}
	/**
	 * @return the vMotivoVisita
	 */
	public String getvMotivoVisita() {
		return vMotivoVisita;
	}
	/**
	 * @param vMotivoVisita the vMotivoVisita to set
	 */
	public void setvMotivoVisita(String vMotivoVisita) {
		this.vMotivoVisita = vMotivoVisita;
	}
	/**
	 * @return the vObservacion
	 */
	public String getvObservacion() {
		return vObservacion;
	}
	/**
	 * @param vObservacion the vObservacion to set
	 */
	public void setvObservacion(String vObservacion) {
		this.vObservacion = vObservacion;
	}
	
	
}
