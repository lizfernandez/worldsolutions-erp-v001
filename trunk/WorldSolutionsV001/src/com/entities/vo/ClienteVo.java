package com.entities.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.entities.Clasificacioncliente;
import com.entities.Cliente;
import com.entities.Direccioncliente;
import com.entities.Estadocuentacliente;
import com.entities.Visitacliente;
import com.entities.converter.ClienteConverter;


/**
 * The persistent class for the cliente database table.
 * 
 */

public class ClienteVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int iClienteId;
	private String cEstadoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
	private BigDecimal nClienteNumeroDocumento;
	private String nClienteTelefono;
	private String vClienteCodigo;
	private String vClienteRazonSocial;
	private String vNombreCliente;
	private String vRubro;
	private List<DireccionclienteVo> direccionclientes;
	private ClasificacionclienteVo clasificacion;
	private float fDescuento;

	public ClienteVo() {
	}


	public ClienteVo(Cliente cliente) {
		this.iClienteId = cliente.getiClienteId();
		this.cEstadoCodigo = cliente.getcEstadoCodigo();
		this.dFechaActualiza = cliente.getdFechaActualiza();
		this.dFechaInserta = cliente.getdFechaInserta();
		this.iUsuarioActualizaId = cliente.getiUsuarioActualizaId();
		this.iUsuarioInsertaId = cliente.getiUsuarioInsertaId();
		this.nClienteNumeroDocumento = cliente.getnClienteNumeroDocumento();
		this.nClienteTelefono = cliente.getnClienteTelefono();
		this.vClienteCodigo = cliente.getvClienteCodigo();
		this.vClienteRazonSocial = cliente.getvClienteRazonSocial();
		this.vNombreCliente = cliente.getvNombreCliente();
		this.vRubro = cliente.getvRubro();
		this.direccionclientes = ClienteConverter.aListDireccionVo(cliente.getDireccionclientes());
		this.clasificacion = new ClasificacionclienteVo(cliente.getClasificacion());
		this.fDescuento = cliente.getfDescuento();
	}


	/**
	 * @return the iClienteId
	 */
	public int getiClienteId() {
		return iClienteId;
	}


	/**
	 * @param iClienteId the iClienteId to set
	 */
	public void setiClienteId(int iClienteId) {
		this.iClienteId = iClienteId;
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
	 * @return the nClienteNumeroDocumento
	 */
	public BigDecimal getnClienteNumeroDocumento() {
		return nClienteNumeroDocumento;
	}


	/**
	 * @param nClienteNumeroDocumento the nClienteNumeroDocumento to set
	 */
	public void setnClienteNumeroDocumento(BigDecimal nClienteNumeroDocumento) {
		this.nClienteNumeroDocumento = nClienteNumeroDocumento;
	}


	/**
	 * @return the nClienteTelefono
	 */
	public String getnClienteTelefono() {
		return nClienteTelefono;
	}


	/**
	 * @param nClienteTelefono the nClienteTelefono to set
	 */
	public void setnClienteTelefono(String nClienteTelefono) {
		this.nClienteTelefono = nClienteTelefono;
	}


	/**
	 * @return the vClienteCodigo
	 */
	public String getvClienteCodigo() {
		return vClienteCodigo;
	}


	/**
	 * @param vClienteCodigo the vClienteCodigo to set
	 */
	public void setvClienteCodigo(String vClienteCodigo) {
		this.vClienteCodigo = vClienteCodigo;
	}


	/**
	 * @return the vClienteRazonSocial
	 */
	public String getvClienteRazonSocial() {
		return vClienteRazonSocial;
	}


	/**
	 * @param vClienteRazonSocial the vClienteRazonSocial to set
	 */
	public void setvClienteRazonSocial(String vClienteRazonSocial) {
		this.vClienteRazonSocial = vClienteRazonSocial;
	}


	/**
	 * @return the vNombreCliente
	 */
	public String getvNombreCliente() {
		return vNombreCliente;
	}


	/**
	 * @param vNombreCliente the vNombreCliente to set
	 */
	public void setvNombreCliente(String vNombreCliente) {
		this.vNombreCliente = vNombreCliente;
	}


	/**
	 * @return the vRubro
	 */
	public String getvRubro() {
		return vRubro;
	}


	/**
	 * @param vRubro the vRubro to set
	 */
	public void setvRubro(String vRubro) {
		this.vRubro = vRubro;
	}


	/**
	 * @return the direccionclientes
	 */
	public List<DireccionclienteVo> getDireccionclientes() {
		return direccionclientes;
	}


	/**
	 * @param direccionclientes the direccionclientes to set
	 */
	public void setDireccionclientes(List<DireccionclienteVo> direccionclientes) {
		this.direccionclientes = direccionclientes;
	}


	public ClasificacionclienteVo getClasificacion() {
		return clasificacion;
	}


	public void setClasificacion(ClasificacionclienteVo clasificacion) {
		this.clasificacion = clasificacion;
	}


	public float getfDescuento() {
		return fDescuento;
	}


	public void setfDescuento(float fDescuento) {
		this.fDescuento = fDescuento;
	}


}