package com.entities.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.entities.Producto;
import com.entities.converter.KardexConverter;
import com.entities.converter.PreciosproductoConverter;

public class ProductoVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iProductoId;
	private String cEstadoCodigo;
	private String cProductoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private float fProductoGanancia;
	private float fProductoGastosAdm;
	private float fProductoPrecioCompra;
	private float fProductoPrecioVenta;
	private CategoriaVo categoria;
	private SubcategoriaVo subcategoria;
	private int iProductoStockTotal;
	private UnidadmedidaVo unidadMedida;
	private int iProductoStockMaximo;
	private int iProductoStockMinimo;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
	private String vProductoNombre;
	private float fProductoDescuento;
	private String vFoto;
	private MonedaVo moneda;
	private ProduccionVo produccion;
	private List<PreciosproductoVo> preciosproductodetallles;
	private int iUMBase;
	private UnidadmedidaVo umBase;
	private int iUMPedido;
	private UnidadmedidaVo umPedido;
	private int iUMSalida;
	private UnidadmedidaVo umSalida;
	
    public ProductoVo() {
    }

	public ProductoVo(Producto producto) {
		this.iProductoId = producto.getiProductoId();
		this.cEstadoCodigo = producto.getcEstadoCodigo();
		this.cProductoCodigo = producto.getcProductoCodigo();
		this.dFechaActualiza = producto.getdFechaActualiza();
		this.dFechaInserta = producto.getdFechaInserta();
		this.fProductoGanancia = producto.getfProductoGanancia();
		this.fProductoGastosAdm = producto.getfProductoGastosAdm();
		this.fProductoPrecioCompra = producto.getfProductoPrecioCompra();
		this.fProductoPrecioVenta = producto.getfProductoPrecioVenta();
		this.categoria = new CategoriaVo(producto.getCategoria());
		this.subcategoria = producto.getSubcategoria() != null ? new SubcategoriaVo(producto.getSubcategoria()) : null;
		this.iProductoStockTotal = producto.getiProductoStockTotal();
		if (producto.getUnidadMedida() != null) {
			this.unidadMedida = new UnidadmedidaVo(producto.getUnidadMedida());
		}
		this.iProductoStockMaximo = producto.getiProductoStockMaximo();
		this.iProductoStockMinimo = producto.getiProductoStockMinimo();
		this.iUsuarioActualizaId = producto.getiUsuarioActualizaId();
		this.iUsuarioInsertaId = producto.getiUsuarioInsertaId();
		this.vProductoNombre = producto.getvProductoNombre();
		this.fProductoDescuento = producto.getfProductoDescuento();
		this.vFoto = producto.getvFoto();
		this.moneda = producto.getMoneda()!= null?new MonedaVo(producto.getMoneda()) : null;
		this.produccion = producto.getProduccion() != null ? new ProduccionVo(producto.getProduccion()) : null; 
		this.preciosproductodetallles = PreciosproductoConverter.aListPreciosproductoVo(producto.getPreciosproductodetallles());
		this.iUMBase = producto.getiUMBase();
		this.umBase = producto.getUmBase()!=null ? new UnidadmedidaVo(producto.getUmBase()) : null;
		this.iUMPedido = producto.getiUMPedido();
		this.umPedido = producto.getUmPedido()!=null ? new UnidadmedidaVo(producto.getUmPedido()) : null;
		this.iUMSalida = producto.getiUMSalida();
		this.umSalida = producto.getUmSalida()!=null ? new UnidadmedidaVo(producto.getUmSalida()) : null;
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

	public float getfProductoGastosAdm() {
		return fProductoGastosAdm;
	}

	public void setfProductoGastosAdm(float fProductoGastosAdm) {
		this.fProductoGastosAdm = fProductoGastosAdm;
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

	public CategoriaVo getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaVo categoria) {
		this.categoria = categoria;
	}

	public SubcategoriaVo getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(SubcategoriaVo subcategoria) {
		this.subcategoria = subcategoria;
	}

	public int getiProductoStockTotal() {
		return iProductoStockTotal;
	}

	public void setiProductoStockTotal(int iProductoStockTotal) {
		this.iProductoStockTotal = iProductoStockTotal;
	}

	public UnidadmedidaVo getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(UnidadmedidaVo unidadMedida) {
		this.unidadMedida = unidadMedida;
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

	public float getfProductoDescuento() {
		return fProductoDescuento;
	}

	public void setfProductoDescuento(float fProductoDescuento) {
		this.fProductoDescuento = fProductoDescuento;
	}

	public String getvFoto() {
		return vFoto;
	}

	public void setvFoto(String vFoto) {
		this.vFoto = vFoto;
	}

	public MonedaVo getMoneda() {
		return moneda;
	}

	public void setMoneda(MonedaVo moneda) {
		this.moneda = moneda;
	}

	public ProduccionVo getProduccion() {
		return produccion;
	}

	public void setProduccion(ProduccionVo produccion) {
		this.produccion = produccion;
	}

	public List<PreciosproductoVo> getPreciosproductodetallles() {
		return preciosproductodetallles;
	}

	public void setPreciosproductodetallles(
			List<PreciosproductoVo> preciosproductodetallles) {
		this.preciosproductodetallles = preciosproductodetallles;
	}

	public int getiUMBase() {
		return iUMBase;
	}

	public void setiUMBase(int iUMBase) {
		this.iUMBase = iUMBase;
	}

	public UnidadmedidaVo getUmBase() {
		return umBase;
	}

	public void setUmBase(UnidadmedidaVo umBase) {
		this.umBase = umBase;
	}

	public int getiUMPedido() {
		return iUMPedido;
	}

	public void setiUMPedido(int iUMPedido) {
		this.iUMPedido = iUMPedido;
	}

	public UnidadmedidaVo getUmPedido() {
		return umPedido;
	}

	public void setUmPedido(UnidadmedidaVo umPedido) {
		this.umPedido = umPedido;
	}

	public int getiUMSalida() {
		return iUMSalida;
	}

	public void setiUMSalida(int iUMSalida) {
		this.iUMSalida = iUMSalida;
	}

	public UnidadmedidaVo getUmSalida() {
		return umSalida;
	}

	public void setUmSalida(UnidadmedidaVo umSalida) {
		this.umSalida = umSalida;
	}
	
}