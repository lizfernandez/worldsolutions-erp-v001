package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.entities.vo.ProductoVo;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@Table(name="producto")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int iProductoId;

	@Column(nullable=false, length=2)
	private String cEstadoCodigo;

	
	@Column(nullable=false, length=7)
	private String cProductoCodigo;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(nullable=true)
	private Date dFechaInserta;

	@Column(nullable=false)
	private float fProductoGanancia;
	

	@Column(nullable=false)
	private float fProductoGastosAdm;

	@Column(nullable=false)
	private float fProductoPrecioCompra;

	@Column(nullable=false)
	private float fProductoPrecioVenta;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="iCategoriaId", nullable=false)	
	private Categoria categoria;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iSubCategoriaId")	
	private Subcategoria subcategoria;
	private int iProductoStockTotal;
	 //bi-directional many-to-one association to Unidadmedida
	@OneToOne(fetch=FetchType.LAZY, optional=false, cascade=CascadeType.PERSIST)
	@JoinColumn(name="iUnidadMedidaId", nullable=true)
	private Unidadmedida unidadMedida;

	@Column(nullable=false)
	private int iProductoStockMaximo;

	@Column(nullable=false)
	private int iProductoStockMinimo;

	private int iUsuarioActualizaId;

	@Column(nullable=false)
	private int iUsuarioInsertaId;


	@Column(nullable=false, length=45)
	private String vProductoNombre;
	
	@Column(nullable=false)
	private float fProductoDescuento;
	
	@Column(nullable=false, length=45)
	private String vFoto;

	//bi-directional many-to-one association to Ingresoproductodetalle
	@OneToMany(mappedBy="producto", fetch=FetchType.LAZY,cascade = CascadeType.REFRESH)
	private List<Ingresoproductodetalle> ingresoproductodetalles;

	
   

	//bi-directional many-to-one association to Moneda
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iMonedaId", nullable=false)
	private Moneda moneda;
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iProduccionId", nullable=false)
	private Produccion produccion;
/*
	//bi-directional many-to-one association to Salidaproducto
	@OneToMany(mappedBy="producto",fetch=FetchType.LAZY)
	private List<Salidaproducto> salidaproductos;
*/
	//bi-directional many-to-one association to Ventadetalle
	@OneToMany(mappedBy="producto",fetch=FetchType.LAZY)
	private List<Ventadetalle> ventadetalles;
	
	//bi-directional many-to-one association to kardex
	@OneToMany(mappedBy="producto", fetch=FetchType.LAZY, cascade= CascadeType.ALL )
	private List<Kardex> kardexs;
	
	//bi-directional many-to-one association to listaPrecios
	@OneToMany(mappedBy="producto", fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Preciosproducto> preciosproductodetallles;
	
	//bi-directional many-to-one association to listaPrecios
	@OneToMany(mappedBy="producto", fetch=FetchType.EAGER,cascade = CascadeType.ALL )
	private List<Productoalmacen> productoAlmacendetallles;
	
	
	//bi-directional many-to-one association to Ingresoproducto
	@OneToMany(mappedBy="producto")
	private List<Ingresoproductodetalle> ingresoproductodetalle;
	
	private int iUMBase;

	//bi-directional many-to-one association to Unidadmedida
	@OneToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="iUMBaseId", nullable=true)
	private Unidadmedida umBase;

	private int iUMPedido;

	//bi-directional many-to-one association to Unidadmedida
	@OneToOne(fetch=FetchType.LAZY, optional=false )
	@JoinColumn(name="iUMPedidoId", nullable=true)
	private Unidadmedida umPedido;

	private int iUMSalida;

	//bi-directional many-to-one association to Unidadmedida
	@OneToOne(fetch=FetchType.LAZY, optional=false )
	@JoinColumn(name="iUMSalidaId", nullable=true)
	private Unidadmedida umSalida;


	
    public Producto() {
    }

	public Producto(ProductoVo producto) {
		this.iProductoId = producto.getiProductoId();
		this.cEstadoCodigo = producto.getcEstadoCodigo();
		this.cProductoCodigo = producto.getcProductoCodigo();
		this.dFechaActualiza = producto.getdFechaActualiza();
		this.dFechaInserta = producto.getdFechaInserta();
		this.fProductoGanancia = producto.getfProductoGanancia();
		this.fProductoGastosAdm = producto.getfProductoGastosAdm();
		this.fProductoPrecioCompra = producto.getfProductoPrecioCompra();
		this.fProductoPrecioVenta = producto.getfProductoPrecioVenta();
		
		this.categoria =producto.getCategoria()!=null ?  new Categoria(producto.getCategoria()):null;
		this.subcategoria = producto.getSubcategoria() != null ? new Subcategoria(producto.getSubcategoria()) : null;
		
		this.iProductoStockTotal = producto.getiProductoStockTotal();
		this.unidadMedida = producto.getUnidadMedida() != null ? new Unidadmedida(producto.getUnidadMedida()) : null;
		this.iProductoStockMaximo = producto.getiProductoStockMaximo();
		this.iProductoStockMinimo = producto.getiProductoStockMinimo();
		this.iUsuarioActualizaId = producto.getiUsuarioActualizaId();
		this.iUsuarioInsertaId = producto.getiUsuarioInsertaId();
		this.vProductoNombre = producto.getvProductoNombre();
		this.fProductoDescuento = producto.getfProductoDescuento();
		this.vFoto = producto.getvFoto();
		this.moneda = producto.getMoneda()!= null ? new Moneda(producto.getMoneda()) : null;
		this.produccion = producto.getProduccion() != null ? new Produccion(producto.getProduccion()): null;
		this.iUMBase = producto.getiUMBase();
		this.umBase = producto.getUmBase() != null ? new Unidadmedida(producto.getUmBase()) : null;
		this.iUMPedido = producto.getiUMPedido();
		this.umPedido = producto.getUmPedido() != null ? new Unidadmedida(producto.getUmPedido()) : null;
		this.iUMSalida = producto.getiUMSalida();
		this.umSalida = producto.getUmSalida() != null ? new Unidadmedida(producto.getUmSalida()) : null;
	}

	public int getiProductoId() {
		return iProductoId;
	}

	public void setiProductoId(int iProductoId) {
		this.iProductoId = iProductoId;
	}

	public String getcEstadoCodigo() {
		return cEstadoCodigo;
	}

	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}


	public String getcProductoCodigo() {
		return cProductoCodigo;
	}

	public void setcProductoCodigo(String cProductoCodigo) {
		this.cProductoCodigo = cProductoCodigo;
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

	public float getfProductoGanancia() {
		return fProductoGanancia;
	}

	public void setfProductoGanancia(float fProductoGanancia) {
		this.fProductoGanancia = fProductoGanancia;
	}

	public float getfProductoPrecioCompra() {
		return fProductoPrecioCompra;
	}

	public void setfProductoPrecioCompra(float fProductoPrecioCompra) {
		this.fProductoPrecioCompra = fProductoPrecioCompra;
	}

	public float getfProductoPrecioVenta() {
		return fProductoPrecioVenta;
	}

	public void setfProductoPrecioVenta(float fProductoPrecioVenta) {
		this.fProductoPrecioVenta = fProductoPrecioVenta;
	}

	/*public int getiCategoriaId() {
		return iCategoriaId;
	}

	public void setiCategoriaId(int iCategoriaId) {
		this.iCategoriaId = iCategoriaId;
	}
*/
	
	

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	
	

	/**
	 * @return the moneda
	 */
	public Moneda getMoneda() {
		return moneda;
	}

	/**
	 * @param moneda the moneda to set
	 */
	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public int getiProductoStockMaximo() {
		return iProductoStockMaximo;
	}

	public void setiProductoStockMaximo(int iProductoStockMaximo) {
		this.iProductoStockMaximo = iProductoStockMaximo;
	}

	public int getiProductoStockMinimo() {
		return iProductoStockMinimo;
	}

	public void setiProductoStockMinimo(int iProductoStockMinimo) {
		this.iProductoStockMinimo = iProductoStockMinimo;
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

	

	

	

	public String getvProductoNombre() {
		return vProductoNombre;
	}

	public void setvProductoNombre(String vProductoNombre) {
		this.vProductoNombre = vProductoNombre;
	}

	public List<Ingresoproductodetalle> getIngresoproductodetalles() {
		return ingresoproductodetalles;
	}

	public void setIngresoproductodetalles(
			List<Ingresoproductodetalle> ingresoproductodetalles) {
		this.ingresoproductodetalles = ingresoproductodetalles;
	}

	
	

	/*public List<Salidaproducto> getSalidaproductos() {
		return salidaproductos;
	}

	public void setSalidaproductos(List<Salidaproducto> salidaproductos) {
		this.salidaproductos = salidaproductos;
	}
*/
	public List<Ventadetalle> getVentadetalles() {
		return ventadetalles;
	}

	public void setVentadetalles(List<Ventadetalle> ventadetalles) {
		this.ventadetalles = ventadetalles;
	}

	/**
	 * @return the kardexs
	 */
	public List<Kardex> getKardexs() {
		return kardexs;
	}

	/**
	 * @param kardexs the kardexs to set
	 */
	public void setKardexs(List<Kardex> kardexs) {
		this.kardexs = kardexs;
	}

	/**
	 * @return the subcategoria
	 */
	public Subcategoria getSubcategoria() {
		return subcategoria;
	}

	/**
	 * @param subcategoria the subcategoria to set
	 */
	public void setSubcategoria(Subcategoria subcategoria) {
		this.subcategoria = subcategoria;
	}

	
	/**
	 * @return the preciosproductodetallles
	 */
	public List<Preciosproducto> getPreciosproductodetallles() {
		return preciosproductodetallles;
	}

	/**
	 * @param preciosproductodetallles the preciosproductodetallles to set
	 */
	public void setPreciosproductodetallles(
			List<Preciosproducto> preciosproductodetallles) {
		this.preciosproductodetallles = preciosproductodetallles;
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
	 * @return the ingresoproductodetalle
	 */
	public List<Ingresoproductodetalle> getIngresoproductodetalle() {
		return ingresoproductodetalle;
	}

	/**
	 * @param ingresoproductodetalle the ingresoproductodetalle to set
	 */
	public void setIngresoproductodetalle(
			List<Ingresoproductodetalle> ingresoproductodetalle) {
		this.ingresoproductodetalle = ingresoproductodetalle;
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
	 * @return the produccion
	 */
	public Produccion getProduccion() {
		return produccion;
	}

	/**
	 * @param produccion the produccion to set
	 */
	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}

	/**
	 * @return the productoAlmacendetallles
	 */
	public List<Productoalmacen> getProductoAlmacendetallles() {
		return productoAlmacendetallles;
	}

	/**
	 * @param productoAlmacendetallles the productoAlmacendetallles to set
	 */
	public void setProductoAlmacendetallles(List<Productoalmacen> productoAlmacendetallles) {
		this.productoAlmacendetallles = productoAlmacendetallles;
	}

	/**
	 * @return the fProductoGastosAdm
	 */
	public float getfProductoGastosAdm() {
		return fProductoGastosAdm;
	}

	/**
	 * @param fProductoGastosAdm the fProductoGastosAdm to set
	 */
	public void setfProductoGastosAdm(float fProductoGastosAdm) {
		this.fProductoGastosAdm = fProductoGastosAdm;
	}

	/**
	 * @return the iProductoStockTotal
	 */
	public int getiProductoStockTotal() {
		return iProductoStockTotal;
	}

	/**
	 * @param iProductoStockTotal the iProductoStockTotal to set
	 */
	public void setiProductoStockTotal(int iProductoStockTotal) {
		this.iProductoStockTotal = iProductoStockTotal;
	}

	/**
	 * @return the unidadMedida
	 */
	public Unidadmedida getUnidadMedida() {
		return unidadMedida;
	}

	/**
	 * @param unidadMedida the unidadMedida to set
	 */
	public void setUnidadMedida(Unidadmedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	/**
	 * @return the iUMBase
	 */
	public int getiUMBase() {
		return iUMBase;
	}

	/**
	 * @param iUMBase the iUMBase to set
	 */
	public void setiUMBase(int iUMBase) {
		this.iUMBase = iUMBase;
	}

	/**
	 * @return the umBase
	 */
	public Unidadmedida getUmBase() {
		return umBase;
	}

	/**
	 * @param umBase the umBase to set
	 */
	public void setUmBase(Unidadmedida umBase) {
		this.umBase = umBase;
	}

	/**
	 * @return the iUMPedido
	 */
	public int getiUMPedido() {
		return iUMPedido;
	}

	/**
	 * @param iUMPedido the iUMPedido to set
	 */
	public void setiUMPedido(int iUMPedido) {
		this.iUMPedido = iUMPedido;
	}

	/**
	 * @return the umPedido
	 */
	public Unidadmedida getUmPedido() {
		return umPedido;
	}

	/**
	 * @param umPedido the umPedido to set
	 */
	public void setUmPedido(Unidadmedida umPedido) {
		this.umPedido = umPedido;
	}

	

	/**
	 * @return the iUMSalida
	 */
	public int getiUMSalida() {
		return iUMSalida;
	}

	/**
	 * @param iUMSalida the iUMSalida to set
	 */
	public void setiUMSalida(int iUMSalida) {
		this.iUMSalida = iUMSalida;
	}

	/**
	 * @return the umSalida
	 */
	public Unidadmedida getUmSalida() {
		return umSalida;
	}

	/**
	 * @param umSalida the umSalida to set
	 */
	public void setUmSalida(Unidadmedida umSalida) {
		this.umSalida = umSalida;
	}

	
	
}