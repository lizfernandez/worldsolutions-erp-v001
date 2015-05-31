package com.entities.vo;

import java.io.Serializable;
import java.util.Date;

import com.entities.Productoalmacen;

public class ProductoalmacenVo implements Serializable {

	private static final long serialVersionUID = -1L;

	private int iProductoAlamcenId;
	private String cEstadoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private AlmacenVo almacen;
	private int iProductoAlmStockTotal;
	private ProductoVo producto;
	private UnidadmedidaVo unidadMedidaAlm;
	private int iUMBaseAlm;
	private UnidadmedidaVo unidadBaseAlm;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
	
	public ProductoalmacenVo() {
		
	}
	
	public ProductoalmacenVo(Productoalmacen productoalmacen) {
		super();
		this.iProductoAlamcenId = productoalmacen.getiProductoAlamcenId();
		this.cEstadoCodigo = productoalmacen.getcEstadoCodigo();
		this.dFechaActualiza = productoalmacen.getdFechaActualiza();
		this.dFechaInserta = productoalmacen.getdFechaInserta();
		this.almacen = new AlmacenVo(productoalmacen.getAlmacen());
		this.iProductoAlmStockTotal = productoalmacen.getiProductoAlmStockTotal();
		this.producto = new ProductoVo(productoalmacen.getProducto());
		this.unidadMedidaAlm = new UnidadmedidaVo(productoalmacen.getUnidadMedidaAlm());
		this.iUMBaseAlm = productoalmacen.getiUMBaseAlm();
		this.unidadBaseAlm = productoalmacen.getUnidadBaseAlm()!= null?new UnidadmedidaVo(productoalmacen.getUnidadBaseAlm()):null;
		this.iUsuarioActualizaId = productoalmacen.getiUsuarioActualizaId();
		this.iUsuarioInsertaId = productoalmacen.getiUsuarioInsertaId();
	}
	public int getiProductoAlamcenId() {
		return iProductoAlamcenId;
	}
	public void setiProductoAlamcenId(int iProductoAlamcenId) {
		this.iProductoAlamcenId = iProductoAlamcenId;
	}
	public String getcEstadoCodigo() {
		return cEstadoCodigo;
	}
	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}
	public Date getdFechaActualiza() {
		return dFechaActualiza;
	}
	public void setdFechaActualiza(Date dFechaActualiza) {
		this.dFechaActualiza = dFechaActualiza;
	}
	public Date getdFechaInserta() {
		return dFechaInserta;
	}
	public void setdFechaInserta(Date dFechaInserta) {
		this.dFechaInserta = dFechaInserta;
	}
	public AlmacenVo getAlmacen() {
		return almacen;
	}
	public void setAlmacen(AlmacenVo almacen) {
		this.almacen = almacen;
	}
	public int getiProductoAlmStockTotal() {
		return iProductoAlmStockTotal;
	}
	public void setiProductoAlmStockTotal(int iProductoAlmStockTotal) {
		this.iProductoAlmStockTotal = iProductoAlmStockTotal;
	}
	public ProductoVo getProducto() {
		return producto;
	}
	public void setProducto(ProductoVo producto) {
		this.producto = producto;
	}
	public UnidadmedidaVo getUnidadMedidaAlm() {
		return unidadMedidaAlm;
	}
	public void setUnidadMedidaAlm(UnidadmedidaVo unidadMedidaAlm) {
		this.unidadMedidaAlm = unidadMedidaAlm;
	}
	public int getiUMBaseAlm() {
		return iUMBaseAlm;
	}
	public void setiUMBaseAlm(int iUMBaseAlm) {
		this.iUMBaseAlm = iUMBaseAlm;
	}
	public UnidadmedidaVo getUnidadBaseAlm() {
		return unidadBaseAlm;
	}
	public void setUnidadBaseAlm(UnidadmedidaVo unidadBaseAlm) {
		this.unidadBaseAlm = unidadBaseAlm;
	}
	public int getiUsuarioActualizaId() {
		return iUsuarioActualizaId;
	}
	public void setiUsuarioActualizaId(int iUsuarioActualizaId) {
		this.iUsuarioActualizaId = iUsuarioActualizaId;
	}
	public int getiUsuarioInsertaId() {
		return iUsuarioInsertaId;
	}
	public void setiUsuarioInsertaId(int iUsuarioInsertaId) {
		this.iUsuarioInsertaId = iUsuarioInsertaId;
	}

	
	
	
}
