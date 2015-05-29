package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the distalmacen database table.
 * 
 */
@Entity
public class Distalmacen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iDistAlmacenId;

	private String cEstadoCodigo;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaIngreso;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaInserta;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaSalida;

	private float fTotal;
	//bi-directional many-to-one association to Ingresoproducto
    @ManyToOne
	@JoinColumn(name="iAlmacenEntradaId", nullable=false)
	private Almacen almacenEntrada;
  //bi-directional many-to-one association to Ingresoproducto
    @ManyToOne
	@JoinColumn(name="iAlmacenSalidaId", nullable=false)
	private Almacen almacenSalida;
    
    @ManyToOne
  	@JoinColumn(name="iPeriodoId", nullable=false)
	private Periodo periodo;

	private int iUsuarioActualizaId;
	@ManyToOne
	@JoinColumn(name="iUsuarioEntregaId", nullable=false)
	private Personal usuatioEntrega;

	private int iUsuarioInsertaId;
	@ManyToOne
	@JoinColumn(name="iUsuarioRecepcionId", nullable=false)
	private Personal usuarioRecepcion;

	private String vNroIngreso;

	private String vNroSalida;

	private String vObservacion;

	private String vPuntoLlegada;

	private String vPuntoSalida;
	
	//bi-directional many-to-one association to Ingresoproductodetalle
	@OneToMany(mappedBy="distAlmacen" ,cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Distalmacendetalle> distAlmacendetalles;
	
	private int iTipoDocumentoId;
	
	private int iSucursalId;
	
    public Distalmacen() {
    }

	/**
	 * @return the iDistAlmacenId
	 */
	public int getiDistAlmacenId() {
		return iDistAlmacenId;
	}

	/**
	 * @param iDistAlmacenId the iDistAlmacenId to set
	 */
	public void setiDistAlmacenId(int iDistAlmacenId) {
		this.iDistAlmacenId = iDistAlmacenId;
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
	 * @return the dFechaIngreso
	 */
	public Date getdFechaIngreso() {
		return dFechaIngreso;
	}

	/**
	 * @param dFechaIngreso the dFechaIngreso to set
	 */
	public void setdFechaIngreso(Date dFechaIngreso) {
		this.dFechaIngreso = dFechaIngreso;
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
	 * @return the dFechaSalida
	 */
	public Date getdFechaSalida() {
		return dFechaSalida;
	}

	/**
	 * @param dFechaSalida the dFechaSalida to set
	 */
	public void setdFechaSalida(Date dFechaSalida) {
		this.dFechaSalida = dFechaSalida;
	}

	/**
	 * @return the fTotal
	 */
	public float getfTotal() {
		return fTotal;
	}

	/**
	 * @param fTotal the fTotal to set
	 */
	public void setfTotal(float fTotal) {
		this.fTotal = fTotal;
	}

	/**
	 * @return the almacenEntrada
	 */
	public Almacen getAlmacenEntrada() {
		return almacenEntrada;
	}

	/**
	 * @param almacenEntrada the almacenEntrada to set
	 */
	public void setAlmacenEntrada(Almacen almacenEntrada) {
		this.almacenEntrada = almacenEntrada;
	}

	/**
	 * @return the almacenSalida
	 */
	public Almacen getAlmacenSalida() {
		return almacenSalida;
	}

	/**
	 * @param almacenSalida the almacenSalida to set
	 */
	public void setAlmacenSalida(Almacen almacenSalida) {
		this.almacenSalida = almacenSalida;
	}

	/**
	 * @return the periodo
	 */
	public Periodo getPeriodo() {
		return periodo;
	}

	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
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
	 * @return the usuatioEntrega
	 */
	public Personal getUsuatioEntrega() {
		return usuatioEntrega;
	}

	/**
	 * @param usuatioEntrega the usuatioEntrega to set
	 */
	public void setUsuatioEntrega(Personal usuatioEntrega) {
		this.usuatioEntrega = usuatioEntrega;
	}

	/**
	 * @param usuarioRecepcion the usuarioRecepcion to set
	 */
	public void setUsuarioRecepcion(Personal usuarioRecepcion) {
		this.usuarioRecepcion = usuarioRecepcion;
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
	 * @return the usuarioRecepcion
	 */
	public Personal getUsuarioRecepcion() {
		return usuarioRecepcion;
	}

	/**
	 * @return the vNroIngreso
	 */
	public String getvNroIngreso() {
		return vNroIngreso;
	}

	/**
	 * @param vNroIngreso the vNroIngreso to set
	 */
	public void setvNroIngreso(String vNroIngreso) {
		this.vNroIngreso = vNroIngreso;
	}

	/**
	 * @return the vNroSalida
	 */
	public String getvNroSalida() {
		return vNroSalida;
	}

	/**
	 * @param vNroSalida the vNroSalida to set
	 */
	public void setvNroSalida(String vNroSalida) {
		this.vNroSalida = vNroSalida;
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

	/**
	 * @return the vPuntoLlegada
	 */
	public String getvPuntoLlegada() {
		return vPuntoLlegada;
	}

	/**
	 * @param vPuntoLlegada the vPuntoLlegada to set
	 */
	public void setvPuntoLlegada(String vPuntoLlegada) {
		this.vPuntoLlegada = vPuntoLlegada;
	}

	/**
	 * @return the vPuntoSalida
	 */
	public String getvPuntoSalida() {
		return vPuntoSalida;
	}

	/**
	 * @param vPuntoSalida the vPuntoSalida to set
	 */
	public void setvPuntoSalida(String vPuntoSalida) {
		this.vPuntoSalida = vPuntoSalida;
	}

	/**
	 * @return the distAlmacendetalles
	 */
	public List<Distalmacendetalle> getDistAlmacendetalles() {
		return distAlmacendetalles;
	}

	/**
	 * @param distAlmacendetalles the distAlmacendetalles to set
	 */
	public void setDistAlmacendetalles(List<Distalmacendetalle> distAlmacendetalles) {
		this.distAlmacendetalles = distAlmacendetalles;
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
	 * @return the iSucursalId
	 */
	public int getiSucursalId() {
		return iSucursalId;
	}

	/**
	 * @param iSucursalId the iSucursalId to set
	 */
	public void setiSucursalId(int iSucursalId) {
		this.iSucursalId = iSucursalId;
	}

	
}