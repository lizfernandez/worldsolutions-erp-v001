package com.entitie;

import java.io.Serializable;
import javax.persistence.*;

import com.entities.vo.PromocioneVo;
import com.entities.vo.UsuarioVo;

import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the promociones database table.
 * 
 */
@Entity
@Table(name="promociones")
public class Promocione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iPromocionId;

	private String cAplicaDescuento;

	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaCaducidad;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private float fDescuento;

	private float fNuevoPrecio;

	private float fPrecio;

	private BigInteger iTotalGustos;

	private BigInteger iTotalVistos;

	private BigInteger iUsuarioActualiza;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iUsuarioId")	
	private Usuario usuario;

	private BigInteger iUsuarioInserta;

	private String vCondiciones;

	private String vDescripcion;

	private String vFoto;

	private String vNombre;

	public Promocione() {
	}

	
	
	public Promocione(PromocioneVo promociones) {
		this.iPromocionId = promociones.getiPromocionId();
		this.cAplicaDescuento = promociones.getcAplicaDescuento();
		this.cEstadoCodigo = promociones.getcEstadoCodigo();
		this.dFechaActualiza = promociones.getdFechaActualiza();
		this.dFechaCaducidad = promociones.getdFechaCaducidad();
		this.dFechaInserta = promociones.getdFechaInserta();
		this.fDescuento = promociones.getfDescuento();
		this.fNuevoPrecio = promociones.getfNuevoPrecio();
		this.fPrecio = promociones.getfPrecio();
		this.iTotalGustos = promociones.getiTotalGustos();
		this.iTotalVistos = promociones.getiTotalVistos();
		this.iUsuarioActualiza = promociones.getiUsuarioActualiza();
		this.usuario = new Usuario(promociones.getUsuario());
		this.iUsuarioInserta = promociones.getiUsuarioInserta();
		this.vCondiciones = promociones.getvCondiciones();
		this.vDescripcion = promociones.getvDescripcion();
		this.vFoto = promociones.getvFoto();
		this.vNombre = promociones.getvNombre();
	}



	/**
	 * @return the iPromocionId
	 */
	public String getiPromocionId() {
		return iPromocionId;
	}

	/**
	 * @param iPromocionId the iPromocionId to set
	 */
	public void setiPromocionId(String iPromocionId) {
		this.iPromocionId = iPromocionId;
	}

	/**
	 * @return the cAplicaDescuento
	 */
	public String getcAplicaDescuento() {
		return cAplicaDescuento;
	}

	/**
	 * @param cAplicaDescuento the cAplicaDescuento to set
	 */
	public void setcAplicaDescuento(String cAplicaDescuento) {
		this.cAplicaDescuento = cAplicaDescuento;
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
	 * @return the dFechaCaducidad
	 */
	public Date getdFechaCaducidad() {
		return dFechaCaducidad;
	}

	/**
	 * @param dFechaCaducidad the dFechaCaducidad to set
	 */
	public void setdFechaCaducidad(Date dFechaCaducidad) {
		this.dFechaCaducidad = dFechaCaducidad;
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
	 * @return the fDescuento
	 */
	public float getfDescuento() {
		return fDescuento;
	}

	/**
	 * @param fDescuento the fDescuento to set
	 */
	public void setfDescuento(float fDescuento) {
		this.fDescuento = fDescuento;
	}

	/**
	 * @return the fNuevoPrecio
	 */
	public float getfNuevoPrecio() {
		return fNuevoPrecio;
	}

	/**
	 * @param fNuevoPrecio the fNuevoPrecio to set
	 */
	public void setfNuevoPrecio(float fNuevoPrecio) {
		this.fNuevoPrecio = fNuevoPrecio;
	}

	/**
	 * @return the fPrecio
	 */
	public float getfPrecio() {
		return fPrecio;
	}

	/**
	 * @param fPrecio the fPrecio to set
	 */
	public void setfPrecio(float fPrecio) {
		this.fPrecio = fPrecio;
	}

	/**
	 * @return the iTotalGustos
	 */
	public BigInteger getiTotalGustos() {
		return iTotalGustos;
	}

	/**
	 * @param iTotalGustos the iTotalGustos to set
	 */
	public void setiTotalGustos(BigInteger iTotalGustos) {
		this.iTotalGustos = iTotalGustos;
	}

	/**
	 * @return the iTotalVistos
	 */
	public BigInteger getiTotalVistos() {
		return iTotalVistos;
	}

	/**
	 * @param iTotalVistos the iTotalVistos to set
	 */
	public void setiTotalVistos(BigInteger iTotalVistos) {
		this.iTotalVistos = iTotalVistos;
	}

	/**
	 * @return the iUsuarioActualiza
	 */
	public BigInteger getiUsuarioActualiza() {
		return iUsuarioActualiza;
	}

	/**
	 * @param iUsuarioActualiza the iUsuarioActualiza to set
	 */
	public void setiUsuarioActualiza(BigInteger iUsuarioActualiza) {
		this.iUsuarioActualiza = iUsuarioActualiza;
	}

	
	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the iUsuarioInserta
	 */
	public BigInteger getiUsuarioInserta() {
		return iUsuarioInserta;
	}

	/**
	 * @param iUsuarioInserta the iUsuarioInserta to set
	 */
	public void setiUsuarioInserta(BigInteger iUsuarioInserta) {
		this.iUsuarioInserta = iUsuarioInserta;
	}

	/**
	 * @return the vCondiciones
	 */
	public String getvCondiciones() {
		return vCondiciones;
	}

	/**
	 * @param vCondiciones the vCondiciones to set
	 */
	public void setvCondiciones(String vCondiciones) {
		this.vCondiciones = vCondiciones;
	}

	/**
	 * @return the vDescripcion
	 */
	public String getvDescripcion() {
		return vDescripcion;
	}

	/**
	 * @param vDescripcion the vDescripcion to set
	 */
	public void setvDescripcion(String vDescripcion) {
		this.vDescripcion = vDescripcion;
	}

	/**
	 * @return the vFoto
	 */
	public String getvFoto() {
		return vFoto;
	}

	/**
	 * @param vFoto the vFoto to set
	 */
	public void setvFoto(String vFoto) {
		this.vFoto = vFoto;
	}

	/**
	 * @return the vNombre
	 */
	public String getvNombre() {
		return vNombre;
	}

	/**
	 * @param vNombre the vNombre to set
	 */
	public void setvNombre(String vNombre) {
		this.vNombre = vNombre;
	}

	

}