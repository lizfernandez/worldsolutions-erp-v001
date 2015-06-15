package com.entitie;

import java.util.Date;



public class Productos {
	private static final long serialVersionUID = 1L;

	private String iProductoId;
	private boolean cEstadoCodigo;
	private String cProductoCodigo;
	private Date dFechaActualiza;
	private int dFechaInserta;
	private float fProductoGanancia;
	private float fProductoPrecioCompra;
	private float fProductoPrecioVenta;
	private int iProductoStockCantidad;
	private int iProductoStockMaximo;
	private int iProductoStockMinimo;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
	private String vProductoCapacidad;
	private String vProductoNombre;
	private float fProductoDescuento;
	private String vFoto;
	private int iUnidadMedidadIdC;
	private String vUnidadMedidaDescripcionC;

    public Productos() {
    }
    public Productos(String id,String nombre,int fecha, String color, float precio, boolean estado) {
    	this.iProductoId=id;
    	this.vProductoNombre=nombre;
    	this.dFechaInserta=fecha;
    	this.vProductoCapacidad=color;
    	this.fProductoPrecioVenta= precio;
    	this.cEstadoCodigo=estado;
    	
    	
    }
    
	/**
	 * @return the iProductoId
	 */
	public String getiProductoId() {
		return iProductoId;
	}

	/**
	 * @param iProductoId the iProductoId to set
	 */
	public void setiProductoId(String iProductoId) {
		this.iProductoId = iProductoId;
	}

	/**
	 * @return the cEstadoCodigo
	 */
	public boolean getcEstadoCodigo() {
		return cEstadoCodigo;
	}

	/**
	 * @param cEstadoCodigo the cEstadoCodigo to set
	 */
	public void setcEstadoCodigo(boolean cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}

	/**
	 * @return the cProductoCodigo
	 */
	public String getcProductoCodigo() {
		return cProductoCodigo;
	}

	/**
	 * @param cProductoCodigo the cProductoCodigo to set
	 */
	public void setcProductoCodigo(String cProductoCodigo) {
		this.cProductoCodigo = cProductoCodigo;
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
	public int getdFechaInserta() {
		return dFechaInserta;
	}

	/**
	 * @param dFechaInserta the dFechaInserta to set
	 */
	public void setdFechaInserta(int dFechaInserta) {
		this.dFechaInserta = dFechaInserta;
	}

	/**
	 * @return the fProductoGanancia
	 */
	public float getfProductoGanancia() {
		return fProductoGanancia;
	}

	/**
	 * @param fProductoGanancia the fProductoGanancia to set
	 */
	public void setfProductoGanancia(float fProductoGanancia) {
		this.fProductoGanancia = fProductoGanancia;
	}

	/**
	 * @return the fProductoPrecioCompra
	 */
	public float getfProductoPrecioCompra() {
		return fProductoPrecioCompra;
	}

	/**
	 * @param fProductoPrecioCompra the fProductoPrecioCompra to set
	 */
	public void setfProductoPrecioCompra(float fProductoPrecioCompra) {
		this.fProductoPrecioCompra = fProductoPrecioCompra;
	}

	/**
	 * @return the fProductoPrecioVenta
	 */
	public float getfProductoPrecioVenta() {
		return fProductoPrecioVenta;
	}

	/**
	 * @param fProductoPrecioVenta the fProductoPrecioVenta to set
	 */
	public void setfProductoPrecioVenta(float fProductoPrecioVenta) {
		this.fProductoPrecioVenta = fProductoPrecioVenta;
	}

	/**
	 * @return the iProductoStockCantidad
	 */
	public int getiProductoStockCantidad() {
		return iProductoStockCantidad;
	}

	/**
	 * @param iProductoStockCantidad the iProductoStockCantidad to set
	 */
	public void setiProductoStockCantidad(int iProductoStockCantidad) {
		this.iProductoStockCantidad = iProductoStockCantidad;
	}

	/**
	 * @return the iProductoStockMaximo
	 */
	public int getiProductoStockMaximo() {
		return iProductoStockMaximo;
	}

	/**
	 * @param iProductoStockMaximo the iProductoStockMaximo to set
	 */
	public void setiProductoStockMaximo(int iProductoStockMaximo) {
		this.iProductoStockMaximo = iProductoStockMaximo;
	}

	/**
	 * @return the iProductoStockMinimo
	 */
	public int getiProductoStockMinimo() {
		return iProductoStockMinimo;
	}

	/**
	 * @param iProductoStockMinimo the iProductoStockMinimo to set
	 */
	public void setiProductoStockMinimo(int iProductoStockMinimo) {
		this.iProductoStockMinimo = iProductoStockMinimo;
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
	 * @return the vProductoCapacidad
	 */
	public String getvProductoCapacidad() {
		return vProductoCapacidad;
	}

	/**
	 * @param vProductoCapacidad the vProductoCapacidad to set
	 */
	public void setvProductoCapacidad(String vProductoCapacidad) {
		this.vProductoCapacidad = vProductoCapacidad;
	}

	/**
	 * @return the vProductoNombre
	 */
	public String getvProductoNombre() {
		return vProductoNombre;
	}

	/**
	 * @param vProductoNombre the vProductoNombre to set
	 */
	public void setvProductoNombre(String vProductoNombre) {
		this.vProductoNombre = vProductoNombre;
	}

	/**
	 * @return the fProductoDescuento
	 */
	public float getfProductoDescuento() {
		return fProductoDescuento;
	}

	/**
	 * @param fProductoDescuento the fProductoDescuento to set
	 */
	public void setfProductoDescuento(float fProductoDescuento) {
		this.fProductoDescuento = fProductoDescuento;
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
	 * @return the iUnidadMedidadIdC
	 */
	public int getiUnidadMedidadIdC() {
		return iUnidadMedidadIdC;
	}

	/**
	 * @param iUnidadMedidadIdC the iUnidadMedidadIdC to set
	 */
	public void setiUnidadMedidadIdC(int iUnidadMedidadIdC) {
		this.iUnidadMedidadIdC = iUnidadMedidadIdC;
	}

	/**
	 * @return the vUnidadMedidaDescripcionC
	 */
	public String getvUnidadMedidaDescripcionC() {
		return vUnidadMedidaDescripcionC;
	}

	/**
	 * @param vUnidadMedidaDescripcionC the vUnidadMedidaDescripcionC to set
	 */
	public void setvUnidadMedidaDescripcionC(String vUnidadMedidaDescripcionC) {
		this.vUnidadMedidaDescripcionC = vUnidadMedidaDescripcionC;
	}

	

}
