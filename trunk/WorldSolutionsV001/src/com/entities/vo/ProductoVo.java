package com.entities.vo;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import com.entities.Ingresoproductodetalle;

public class ProductoVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iProductoId;
	private String cEstadoCodigo;
	private String cProductoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private float fProductoGanancia;
	private float fProductoPrecioCompra;
	private float fProductoPrecioVenta;
	private CategoriaVo categoria;
	private SubcategoriaVo subcategoria;
	private int iProduccionId;
	private int iProductoStockTotal;
	private int iProductoStockMaximo;
	private int iProductoStockMinimo;
	private int iUsuarioActualizaId;
	private int iUsuarioInsertaId;
	private String iUMPedido;
	private String vProductoNombre;
	private float fProductoDescuento;
	private String vFoto;
	private List<IngresoproductodetalleVo> ingresoproductodetalles;
	private UnidadmedidaVo unidadMedida;
	private int iUMBase;
	private String vUnidadMedidaDescripcionC;
	private MonedaVo moneda;
	private List<VentadetalleVo> ventadetalles;
	private List<KardexVo> kardexs;
	private List<PreciosproductoVo> preciosproductodetallles;
	private List<IngresoproductodetalleVo> ingresoproductodetalle;

    public ProductoVo() {
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
	
	public int getiProduccionId() {
		return iProduccionId;
	}

	/**
	 * @return the categoria
	 */
	public CategoriaVo getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(CategoriaVo categoria) {
		this.categoria = categoria;
	}

	public void setiProduccionId(int iProduccionId) {
		this.iProduccionId = iProduccionId;
	}
	
	 /**
      * @return the vUnidadMedidaDescripcionC
	  */
	public String getvUnidadMedidaDescripcionC() {
		/*UnidadMedidaDao dao = new UnidadMedidaDao();
		String vUnidadMedidaDescripcion ="nn";
		if(this.iUMBase>0){
			Unidadmedida unidadmedida = dao.buscarUnidadMedida(this.iUMBase);
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
	 * @return the moneda
	 */
	public MonedaVo getMoneda() {
		return moneda;
	}

	/**
	 * @param moneda the moneda to set
	 */
	public void setMoneda(MonedaVo moneda) {
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
	public String getiUMPedido() {
		return iUMPedido;
	}

	/**
	 * @param iProductoCapacidad the iProductoCapacidad to set
	 */
	public void setiUMPedido(String iUMPedido) {
		this.iUMPedido = iUMPedido;
	}

	/**
	 * @return the unidadMedidaC
	 */
	public int getiUMBase() {
		return iUMBase;
	}

	/**
	 * @param unidadMedidaC the unidadMedidaC to set
	 */
	public void setiUMBase(int iUMBase) {
		this.iUMBase = iUMBase;
	}

	public String getvProductoNombre() {
		return vProductoNombre;
	}

	public void setvProductoNombre(String vProductoNombre) {
		this.vProductoNombre = vProductoNombre;
	}

	public List<IngresoproductodetalleVo> getIngresoproductodetalles() {
		return ingresoproductodetalles;
	}

	public void setIngresoproductodetalles(
			List<IngresoproductodetalleVo> ingresoproductodetalles) {
		this.ingresoproductodetalles = ingresoproductodetalles;
	}

	
	/**
	 * @return the unidadMedida
	 */
	public UnidadmedidaVo getUnidadMedida() {
		return unidadMedida;
	}

	/**
	 * @param unidadMedida the unidadMedida to set
	 */
	public void setUnidadMedida(UnidadmedidaVo unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	/*public List<Salidaproducto> getSalidaproductos() {
		return salidaproductos;
	}

	public void setSalidaproductos(List<Salidaproducto> salidaproductos) {
		this.salidaproductos = salidaproductos;
	}
*/
	public List<VentadetalleVo> getVentadetalles() {
		return ventadetalles;
	}

	public void setVentadetalles(List<VentadetalleVo> ventadetalles) {
		this.ventadetalles = ventadetalles;
	}

	/**
	 * @return the kardexs
	 */
	public List<KardexVo> getKardexs() {
		return kardexs;
	}

	/**
	 * @param kardexs the kardexs to set
	 */
	public void setKardexs(List<KardexVo> kardexs) {
		this.kardexs = kardexs;
	}

	/**
	 * @return the subcategoria
	 */
	public SubcategoriaVo getSubcategoria() {
		return subcategoria;
	}
	/**
	 * @param subcategoria the subcategoria to set
	 */
	public void setSubcategoria(SubcategoriaVo subcategoria) {
		this.subcategoria = subcategoria;
	}

	
	/**
	 * @return the preciosproductodetallles
	 */
	public List<PreciosproductoVo> getPreciosproductodetallles() {
		return preciosproductodetallles;
	}

	/**
	 * @param preciosproductodetallles the preciosproductodetallles to set
	 */
	public void setPreciosproductodetallles(
			List<PreciosproductoVo> preciosproductodetallles) {
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
	public List<IngresoproductodetalleVo> getIngresoproductodetalle() {
		return ingresoproductodetalle;
	}

	/**
	 * @param ingresoproductodetalle the ingresoproductodetalle to set
	 */
	public void setIngresoproductodetalle(
			List<IngresoproductodetalleVo> ingresoproductodetalle) {
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

	
	
}