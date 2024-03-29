package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.entities.vo.ProductoalmacenVo;

import java.util.Date;


/**
 * The persistent class for the productoalmacen database table.
 * 
 */
@Entity
public class Productoalmacen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iProductoAlamcenId;

	private String cEstadoCodigo;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaInserta;
    @ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="iAlmacenId")
	private Almacen almacen;

	private int iProductoAlmStockTotal;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="iProductoId")
	private Producto producto;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iUMAlmacenId", nullable=false)
	private Unidadmedida unidadMedidaAlm;

	private int iUMBaseAlm;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iUMBaseAlmId", nullable=false)
	private Unidadmedida unidadBaseAlm;

	private int iUsuarioActualizaId;

	private int iUsuarioInsertaId;

    public Productoalmacen() {
    }

    
    
	public Productoalmacen(ProductoalmacenVo productoalmacenVo) {
		super();
		this.iProductoAlamcenId = productoalmacenVo.getiProductoAlamcenId();
		this.cEstadoCodigo = productoalmacenVo.getcEstadoCodigo();
		this.dFechaActualiza = productoalmacenVo.getdFechaActualiza();
		this.dFechaInserta = productoalmacenVo.getdFechaInserta();
		this.almacen = new Almacen(productoalmacenVo.getAlmacen());
		this.iProductoAlmStockTotal = productoalmacenVo.getiProductoAlmStockTotal();
		this.producto = new Producto(productoalmacenVo.getProducto());
		this.unidadMedidaAlm = new Unidadmedida(productoalmacenVo.getUnidadMedidaAlm());
		this.iUMBaseAlm = productoalmacenVo.getiUMBaseAlm();
		if(productoalmacenVo.getUnidadBaseAlm()!=null)
		this.unidadBaseAlm = new Unidadmedida(productoalmacenVo.getUnidadBaseAlm());
		this.iUsuarioActualizaId = productoalmacenVo.getiUsuarioActualizaId();
		this.iUsuarioInsertaId = productoalmacenVo.getiUsuarioInsertaId();
	}



	/**
	 * @return the iProductoAlamcenId
	 */
	public int getiProductoAlamcenId() {
		return iProductoAlamcenId;
	}

	/**
	 * @param iProductoAlamcenId the iProductoAlamcenId to set
	 */
	public void setiProductoAlamcenId(int iProductoAlamcenId) {
		this.iProductoAlamcenId = iProductoAlamcenId;
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
	 * @return the almacen
	 */
	public Almacen getAlmacen() {
		return almacen;
	}

	/**
	 * @param almacen the almacen to set
	 */
	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	/**
	 * @return the iProductoAlmStockTotal
	 */
	public int getiProductoAlmStockTotal() {
		return iProductoAlmStockTotal;
	}

	/**
	 * @param iProductoAlmStockTotal the iProductoAlmStockTotal to set
	 */
	public void setiProductoAlmStockTotal(int iProductoAlmStockTotal) {
		this.iProductoAlmStockTotal = iProductoAlmStockTotal;
	}

	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/**
	 * @return the unidadMedidaAlm
	 */
	public Unidadmedida getUnidadMedidaAlm() {
		return unidadMedidaAlm;
	}

	/**
	 * @param unidadMedidaAlm the unidadMedidaAlm to set
	 */
	public void setUnidadMedidaAlm(Unidadmedida unidadMedidaAlm) {
		this.unidadMedidaAlm = unidadMedidaAlm;
	}

	/**
	 * @return the iUMBaseAlm
	 */
	public int getiUMBaseAlm() {
		return iUMBaseAlm;
	}

	/**
	 * @param iUMBaseAlm the iUMBaseAlm to set
	 */
	public void setiUMBaseAlm(int iUMBaseAlm) {
		this.iUMBaseAlm = iUMBaseAlm;
	}



	/**
	 * @return the unidadBaseAlm
	 */
	public Unidadmedida getUnidadBaseAlm() {
		return unidadBaseAlm;
	}

	/**
	 * @param unidadBaseAlm the unidadBaseAlm to set
	 */
	public void setUnidadBaseAlm(Unidadmedida unidadBaseAlm) {
		this.unidadBaseAlm = unidadBaseAlm;
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

	
	

}