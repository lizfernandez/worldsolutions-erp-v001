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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


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

    @Temporal( TemporalType.DATE)
	private Date dFechaActualiza;

    @Temporal( TemporalType.DATE)
	@Column(nullable=true)
	private Date dFechaInserta;

	@Column(nullable=false)
	private float fProductoGanancia;

	@Column(nullable=false)
	private float fProductoPrecioCompra;

	@Column(nullable=false)
	private float fProductoPrecioVenta;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iCategoriaId", nullable=false)	
	private Categoria categoria;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iSubCategoriaId")	
	private Subcategoria subcategoria;

	

	@Column(nullable=false)
	private int iProductoStockCantidad;

	@Column(nullable=false)
	private int iProductoStockMaximo;

	@Column(nullable=false)
	private int iProductoStockMinimo;

	private int iUsuarioActualizaId;

	@Column(nullable=false)
	private int iUsuarioInsertaId;

	@Column(nullable=false, length=11)
	private String vProductoCapacidad;

	@Column(nullable=false, length=45)
	private String vProductoNombre;
	
	@Column(nullable=false)
	private float fProductoDescuento;
	
	@Column(nullable=false, length=45)
	private String vFoto;

	//bi-directional many-to-one association to Ingresoproductodetalle
	@OneToMany(mappedBy="producto", fetch=FetchType.LAZY,cascade = CascadeType.REFRESH)
	private List<Ingresoproductodetalle> ingresoproductodetalles;

	//bi-directional many-to-one association to Unidadmedida
    @ManyToOne
	@JoinColumn(name="iUnidadMedidadId", nullable=false)
	private Unidadmedida unidadMedida;
    
  //bi-directional many-to-one association to Unidadmedida
    
	private int iUnidadMedidadIdC;
	
	private String vUnidadMedidaDescripcionC;
    
   

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
	@OneToMany(mappedBy="producto", fetch=FetchType.EAGER, cascade= CascadeType.ALL )
	private List<Kardex> kardexs;
	
	//bi-directional many-to-one association to listaPrecios
	@OneToMany(mappedBy="producto", fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Preciosproducto> preciosproductodetallles;
	
	//bi-directional many-to-one association to Ingresoproducto
	@OneToMany(mappedBy="producto")
	private List<Ingresoproductodetalle> ingresoproductodetalle;
	
	

    public Producto() {
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
      * @return the vUnidadMedidaDescripcionC
	  */
	public String getvUnidadMedidaDescripcionC() {
		/*UnidadMedidaDao dao = new UnidadMedidaDao();
		String vUnidadMedidaDescripcion ="nn";
		if(this.iUnidadMedidadIdC>0){
			Unidadmedida unidadmedida = dao.buscarUnidadMedida(this.iUnidadMedidadIdC);
			vUnidadMedidaDescripcion =unidadmedida.getvUnidadMedidaDescripcion();
		}
		*/
		return vUnidadMedidaDescripcionC;
	}

	/**
	 * @param vUnidadMedidaDescripcionC the vUnidadMedidaDescripcionC to set
	 */
	public void setvUnidadMedidaDescripcionC(String vUnidadMedidaDescripcionC) {
		this.vUnidadMedidaDescripcionC = vUnidadMedidaDescripcionC;
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

	

	/**
	 * @return the iProductoCapacidad
	 */
	public String getvProductoCapacidad() {
		return vProductoCapacidad;
	}

	/**
	 * @param iProductoCapacidad the iProductoCapacidad to set
	 */
	public void setvProductoCapacidad(String vProductoCapacidad) {
		this.vProductoCapacidad = vProductoCapacidad;
	}

	/**
	 * @return the unidadMedidaC
	 */
	public int getiUnidadMedidadIdC() {
		return iUnidadMedidadIdC;
	}

	/**
	 * @param unidadMedidaC the unidadMedidaC to set
	 */
	public void setiUnidadMedidadIdC(int iUnidadMedidadIdC) {
		this.iUnidadMedidadIdC = iUnidadMedidadIdC;
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

	
	
}