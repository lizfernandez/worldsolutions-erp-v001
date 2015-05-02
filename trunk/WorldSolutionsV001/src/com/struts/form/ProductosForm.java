//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.1/xslt/JavaClass.xsl

package com.struts.form;



import java.util.Date;
import java.util.List;
import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import com.dao.CategoriaDao;
import com.dao.GenericaDao;
import com.dao.ProductoDao;
import com.entities.Categoria;

import com.entities.Almacen;
import com.entities.Moneda;
import com.entities.Produccion;
import com.entities.Producciondetalle;
import com.entities.Producto;
import com.entities.Productoalmacen;

import com.entities.Subcategoria;
import com.entities.Unidadmedida;


/** 
 * MyEclipse Struts
 * Creation date: 10-05-2004
 * 
 * XDoclet definition:
 * @struts:form name="productosForm"
 */
public class ProductosForm extends ActionForm {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List produc;
	private List producAlmacen;
	Producto producto = new Producto();
	Productoalmacen productoAlmacen = new Productoalmacen();
	Produccion produccion = new Produccion();
    private String mode;
    private List paginas; 
    private int pagInicio;
    int sizeIngresoproductodetalles;
    int sizeVentaDetalles;
    String dFechaInicio; // fecha del kardex
    String dFechaFin; // fecha del kardex
    private int iclasificacionId ;
    private FormFile foto;
    private int iPersonalId;
    private String cPersonalCodigo;
    private String vPersonalNombres;
    
    /**
	 * @return the paginas
	 */
	public List getPaginas() {
		return paginas;
	}

	/**
	 * @param paginas the paginas to set
	 */
	public void setPaginas(List paginas) {
		this.paginas = paginas;
	}


	/**
	 * @return the pagInicio
	 */
	public int getPagInicio() {
		return pagInicio;
	}

	/**
	 * @param pagInicio the pagInicio to set
	 */
	public void setPagInicio(int pagInicio) {
		this.pagInicio = pagInicio;
	}

	
	public String getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/**
	 * @return the produc
	 */
	public List getProduc() {
		return produc;
	}

	/**
	 * @param produc the produc to set
	 */
	public void setProduc(List produc) {
		this.produc = produc;
	}
    
	public ProductoDao getProductoDao(){
		ProductoDao produtodao= new ProductoDao();
		return produtodao;
	}

	public int getiProductoId() {
		return producto.getiProductoId();
	}

	public void setiProductoId(int iProductoId) {
		this.producto.setiProductoId(iProductoId);
	}

	public String getcEstadoCodigo() {
		String cEstadoCodigo=producto.getcEstadoCodigo();
		if(cEstadoCodigo==""){
			cEstadoCodigo= produccion.getcEstadoCodigo();
		}
		
		return cEstadoCodigo;
	}

	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.producto.setcEstadoCodigo(cEstadoCodigo);
		this.produccion.setcEstadoCodigo(cEstadoCodigo);
	}


	public String getcProductoCodigo() {
		return producto.getcProductoCodigo();
	}

	public void setcProductoCodigo(String cProductoCodigo) {
		this.producto.setcProductoCodigo(cProductoCodigo);
	}

	
	public float getfProductoGanancia() {
		return producto.getfProductoGanancia();
	}

	public void setfProductoGanancia(float fProductoGanancia) {
		this.producto.setfProductoGanancia(fProductoGanancia);
	}

	public float getfProductoPrecioCompra() {
		return producto.getfProductoPrecioCompra();
	}

	public void setfProductoPrecioCompra(float fProductoPrecioCompra) {
		this.producto.setfProductoPrecioCompra(fProductoPrecioCompra);
	}

	public float getfProductoPrecioVenta() {
		return producto.getfProductoPrecioVenta();
	}

	public void setfProductoPrecioVenta(float fProductoPrecioVenta) {
		this.producto.setfProductoPrecioVenta(fProductoPrecioVenta);
	}
    
	public Categoria getCategoria(){
		Categoria categoria =producto.getCategoria();
		if(categoria==null){
			categoria = new Categoria();
			producto.setCategoria(categoria);
		}
		return producto.getCategoria();
	}
	 
	public int getiCategoriaId() {		
		return getCategoria().getiCategoriaId();
	}
   
	public void setiCategoriaId(int iCategoriaId) {		
		this.producto.setCategoria(getProductoDao().findEndidad(getCategoria(), iCategoriaId));
	}


	public int getiProductoStockMaximo() {
		return producto.getiProductoStockMaximo();
	}

	public void setiProductoStockMaximo(int iProductoStockMaximo) {
		this.producto.setiProductoStockMaximo(iProductoStockMaximo);
	}

	public int getiProductoStockMinimo() {
		return producto.getiProductoStockMinimo();
	}

	public void setiProductoStockMinimo(int iProductoStockMinimo) {
		this.producto.setiProductoStockMinimo(iProductoStockMinimo);
	}

	

	public String getvProductoNombre() {
		return producto.getvProductoNombre();
	}

	public void setvProductoNombre(String vProductoNombre) {
		this.producto.setvProductoNombre(vProductoNombre);
		
	}



	

	
	
	/***Moneda iMonedaId ***/
	public Moneda getMoneda(){
		Moneda moneda = producto.getMoneda();
		if(moneda==null){
			 moneda = new Moneda();
			 producto.setMoneda(moneda);
		}
		return producto.getMoneda();
	}
	public int getiMonedaId() {		
			return getMoneda().getiMonedaId();		
	}
	public void setiMonedaId(int iMonedaId) {		
		this.producto.setMoneda(getProductoDao().findEndidad(getMoneda(), iMonedaId));
	}	
	/**
	 * @return the sizeIngresoproductodetalles
	 */
	public int getSizeIngresoproductodetalles() {
		return sizeIngresoproductodetalles;
	}

	/**
	 * @param sizeIngresoproductodetalles the sizeIngresoproductodetalles to set
	 */
	public void setSizeIngresoproductodetalles(int sizeIngresoproductodetalles) {
		this.sizeIngresoproductodetalles = sizeIngresoproductodetalles;
	}

	/**
	 * @return the sizeVentaDetalles
	 */
	public int getSizeVentaDetalles() {
		return sizeVentaDetalles;
	}

	/**
	 * @param sizeVentaDetalles the sizeVentaDetalles to set
	 */
	public void setSizeVentaDetalles(int sizeVentaDetalles) {
		this.sizeVentaDetalles = sizeVentaDetalles;
	}

	/**
	 * @return the dFechaInicio
	 */
	public String getdFechaInicio() {
		return dFechaInicio;
	}

	/**
	 * @param dFechaInicio the dFechaInicio to set
	 */
	public void setdFechaInicio(String dFechaInicio) {
		this.dFechaInicio = dFechaInicio;
	}

	/**
	 * @return the dFechaFin
	 */
	public String getdFechaFin() {
		return dFechaFin;
	}

	/**
	 * @param dFechaFin the dFechaFin to set
	 */
	public void setdFechaFin(String dFechaFin) {
		this.dFechaFin = dFechaFin;
	}

	/**
	 * @return the iclasificacionId
	 */
	public int getIclasificacionId() {
		return iclasificacionId;
	}

	/**
	 * @param iclasificacionId the iclasificacionId to set
	 */
	public void setIclasificacionId(int iclasificacionId) {
		this.iclasificacionId = iclasificacionId;
	}

	public Subcategoria getSubcategoria(){
		Subcategoria subCategoria = producto.getSubcategoria();
		if(subCategoria==null){
			subCategoria = new Subcategoria();
		    producto.setSubcategoria(subCategoria);
		}
		    
		return producto.getSubcategoria();
	}
	
	
	/**
	 * @return the iSubCategoriaId
	 */
	public int getiSubCategoriaId() {		
		return getSubcategoria().getiSubCategoriaId();
	}

	/**
	 * @param iSubCategoriaId the iSubCategoriaId to set
	 */
	public void setiSubCategoriaId(int iSubCategoriaId) {
		this.producto.setSubcategoria(getProductoDao().findEndidad(getSubcategoria(),iSubCategoriaId));
	}

	/**
	 * @return the foto
	 */
	public FormFile getFoto() {
		return foto;
	}

	/**
	 * @param foto the foto to set
	 */
	public void setFoto(FormFile foto) {
		this.foto = foto;
	}

	/**
	 * @return the vFoto
	 */
	public String getvFoto() {
		return getProducto().getvFoto();
	}

	/**
	 * @param vFoto the vFoto to set
	 */
	public void setvFoto(String vFoto) {
		this.getProducto().setvFoto(vFoto);
	}
	/**
	 * @return the fProductoDescuento
	 */
	public float getfProductoDescuento() {
		return getProducto().getfProductoDescuento();
	}

	/**
	 * @param fProductoDescuento the fProductoDescuento to set
	 */
	public void setfProductoDescuento(float fProductoDescuento) {
		this.getProducto().setfProductoDescuento(fProductoDescuento);
	}

	/**
	 * @return the iPersonalId
	 */
	public int getiPersonalId() {
		return iPersonalId;
	}

	/**
	 * @param iPersonalId the iPersonalId to set
	 */
	public void setiPersonalId(int iPersonalId) {
		this.iPersonalId = iPersonalId;
	}

	/**
	 * @return the cPersonalCodigo
	 */
	public String getcPersonalCodigo() {
		return cPersonalCodigo;
	}

	/**
	 * @param cPersonalCodigo the cPersonalCodigo to set
	 */
	public void setcPersonalCodigo(String cPersonalCodigo) {
		this.cPersonalCodigo = cPersonalCodigo;
	}

	/**
	 * @return the vPersonalNombres
	 */
	public String getvPersonalNombres() {
		return vPersonalNombres;
	}

	/**
	 * @param vPersonalNombres the vPersonalNombres to set
	 */
	public void setvPersonalNombres(String vPersonalNombres) {
		this.vPersonalNombres = vPersonalNombres;
	}

	

	/******************************/
	/** GESTION DE LA PRODUCCION **/
	/******************************/
	
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
	 * @return the iProduccionId
	 */
	public int getiProduccionId() {
		return produccion.getiProduccionId();
	}

	/**
	 * @param iProduccionId the iProduccionId to set
	 */
	public void setiProduccionId(int iProduccionId) {
		this.produccion.setiProduccionId(iProduccionId);
	}

	

	/**
	 * @return the fCostoTotal
	 */
	public float getfCostoTotal() {
		return produccion.getfCostoTotal();
	}

	/**
	 * @param fCostoTotal the fCostoTotal to set
	 */
	public void setfCostoTotal(float fCostoTotal) {
		this.produccion.setfCostoTotal(fCostoTotal);
	}

	/**
	 * @return the fCostoUni
	 */
	public float getfCostoUni() {
		return produccion.getfCostoUni();
	}

	/**
	 * @param fCostoUni the fCostoUni to set
	 */
	public void setfCostoUni(float fCostoUni) {
		this.produccion.setfCostoUni(fCostoUni);
	}

	/**
	 * @return the iCantidad
	 */
	public int getiCantidad() {
		return produccion.getiCantidad();
	}

	/**
	 * @param iCantidad the iCantidad to set
	 */
	public void setiCantidad(int iCantidad) {
		this.produccion.setiCantidad(iCantidad);
	}

	
	/**
	 * @return the fOtrosCostos
	 */
	public float getfOtrosCostos() {
		return produccion.getfOtrosCostos();
	}

	/**
	 * @param fOtrosCostos the fOtrosCostos to set
	 */
	public void setfOtrosCostos(float fOtrosCostos) {
		this.produccion.setfOtrosCostos(fOtrosCostos);
	}
	/**
	 * @return the vDescripcion
	 */
	public String getvDescripcion() {
		return produccion.getvDescripcion();
	}

	/**
	 * @param vDescripcion the vDescripcion to set
	 */
	public void setvDescripcion(String vDescripcion) {
		this.produccion.setvDescripcion(vDescripcion);
	}
	/**
	 * @return the fProductoGastosAdm
	 */
	public float getfProductoGastosAdm() {
		return producto.getfProductoGastosAdm();
	}

	/**
	 * @param fProductoGastosAdm the fProductoGastosAdm to set
	 */
	public void setfProductoGastosAdm(float fProductoGastosAdm) {
		this.producto.setfProductoGastosAdm(fProductoGastosAdm);
	}

	/**
	 * @return the iProductoStockTotal
	 */
	public int getiProductoStockTotal() {
		return producto.getiProductoStockTotal();
	}

	/**
	 * @param iProductoStockTotal the iProductoStockTotal to set
	 */
	public void setiProductoStockTotal(int iProductoStockTotal) {
		this.producto.setiProductoStockTotal(iProductoStockTotal);
	}

	public Unidadmedida getUnidadmedida(){
		Unidadmedida unidadmedida =producto.getUnidadMedida();
		if(unidadmedida==null){
			unidadmedida= new Unidadmedida();
			producto.setUnidadMedida(unidadmedida);
		}
		return producto.getUnidadMedida();
	}
	public int getiUnidadMedidadId() {
			return getUnidadmedida().getiUnidadMedidaId();
		
	}
	public void setiUnidadMedidadId(int iUnidadMedidadId) {
		this.producto.setUnidadMedida(getProductoDao().findEndidad(getUnidadmedida(), iUnidadMedidadId));
	}
	/**
	 * @return the iUMBase
	 */
	public int getiUMBase() {
		return producto.getiUMBase();
	}

	/**
	 * @param iUMBase the iUMBase to set
	 */
	public void setiUMBase(int iUMBase) {
		this.producto.setiUMBase(iUMBase);
	}

	/**
	 * @return the umBase
	 */
	public Unidadmedida getUmBase() {
		Unidadmedida unidadmedida =producto.getUmBase();
		if(unidadmedida==null){
			unidadmedida= new Unidadmedida();
			producto.setUmBase(unidadmedida);
		}		
		return producto.getUmBase();
	}

	/**
	 * @param umBase the umBase to set
	 */
	/*public void setUmBase(Unidadmedida umBase) {
		this.producto.setUmBase(umBase);
	}*/
	public int getiUMBaseId() {
		return getUmBase().getiUnidadMedidaId();
	
	}
	public void setiUMBaseId(int iUnidadMedidadId) {
		this.producto.setUmBase(getProductoDao().findEndidad(getUnidadmedida(), iUnidadMedidadId));
		//this.producto.setUnidadMedida(getProductoDao().findEndidad(getUnidadmedida(), iUnidadMedidadId));
	}

	/**
	 * @return the iUMPedido
	 */
	public int getiUMPedido() {
		return producto.getiUMPedido();
	}

	/**
	 * @param iUMPedido the iUMPedido to set
	 */
	public void setiUMPedido(int iUMPedido) {
		this.producto.setiUMPedido(iUMPedido);
	}

	/**
	 * @return the umPedido
	 */
	public Unidadmedida getUmPedido() {
		Unidadmedida unidadmedida =producto.getUmPedido();
		if(unidadmedida==null){
			unidadmedida= new Unidadmedida();
			producto.setUmPedido(unidadmedida);
		}
		return producto.getUmPedido();
	}

	/**
	 * @param umPedido the umPedido to set
	 */
	/*public void setUmPedido(Unidadmedida umPedido) {
		this.producto.setUmPedido(umPedido);
	}*/
	public int getiUMPedidoId() {
		return getUmPedido().getiUnidadMedidaId();
	
	}
	public void setiUMPedidoId(int iUnidadMedidadId) {
		this.producto.setUmPedido(getProductoDao().findEndidad(getUnidadmedida(), iUnidadMedidadId));
		//his.producto.setUnidadMedida(getProductoDao().findEndidad(getUnidadmedida(), iUnidadMedidadId));
	}
	/**
	 * @return the vUMSalida
	 */
	public String getvUMSalida() {
		return producto.getvUMSalida();
	}

	/**
	 * @param vUMSalida the vUMSalida to set
	 */
	public void setvUMSalida(String vUMSalida) {
		this.producto.setvUMSalida(vUMSalida);
	}

	/**
	 * @return the umSalida
	 */
	public Unidadmedida getUmSalida() {
		Unidadmedida unidadmedida =producto.getUmSalida();
		if(unidadmedida==null){
			unidadmedida= new Unidadmedida();
			producto.setUmSalida(unidadmedida);
		}
		return producto.getUmSalida();
	}

	/**
	 * @param umSalida the umSalida to set
	 */
	public void setUmSalida(Unidadmedida umSalida) {
		this.setUmSalida(umSalida);
	}
	public int getiUMSalidaId() {
		return getUmSalida().getiUnidadMedidaId();
	
	}
	public void setiUMSalidaId(int iUnidadMedidadId) {
		this.producto.setUmSalida(getProductoDao().findEndidad(getUnidadmedida(), iUnidadMedidadId));
		//this.producto.setUnidadMedida(getProductoDao().findEndidad(getUnidadmedida(), iUnidadMedidadId));
	}

	/**
	 * @return the producAlmacen
	 */
	public List getProducAlmacen() {
		return producAlmacen;
	}

	/**
	 * @param producAlmacen the producAlmacen to set
	 */
	public void setProducAlmacen(List producAlmacen) {
		this.producAlmacen = producAlmacen;
	
	}
	/**PRODUCTO ALMACEN */
	/**
	 * @return the iProductoAlamcenId
	 */
	public int getiProductoAlamcenId() {
		return productoAlmacen.getiProductoAlamcenId();
	}

	/**
	 * @param iProductoAlamcenId the iProductoAlamcenId to set
	 */
	public void setiProductoAlamcenId(int iProductoAlamcenId) {
		this.productoAlmacen.setiProductoAlamcenId(iProductoAlamcenId);
	}	

	/**
	 * @return the almacen
	 */
	/**
	 * @return the umPedido
	 */

	public Almacen getAlmacen() {
		Almacen almacen =productoAlmacen.getAlmacen();
		if(almacen==null){
			almacen= new Almacen();
			productoAlmacen.setAlmacen(almacen);
		}
		return productoAlmacen.getAlmacen();
	}

	/**
	 * @return the iAlmacenId
	 */
	public int getiAlmacenId() {		
		return getAlmacen().getiAlmacenId();
	}

	/**
	 * @param iAlmacenId the iAlmacenId to set
	 */
	public void setiAlmacenId(int iAlmacenId) {
		this.productoAlmacen.setAlmacen(getProductoDao().findEndidad(getAlmacen(),iAlmacenId));
	}

	/**
	 * @return the iProductoAlmStockTotal
	 */
	public int getiProductoAlmStockTotal() {
		return productoAlmacen.getiProductoAlmStockTotal();
	}

	/**
	 * @param iProductoAlmStockTotal the iProductoAlmStockTotal to set
	 */
	public void setiProductoAlmStockTotal(int iProductoAlmStockTotal) {
		this.productoAlmacen.setiProductoAlmStockTotal(iProductoAlmStockTotal);
	}



	/**
	 * @return the unidadMedidaAlm
	 */
	public Unidadmedida getUnidadMedidaAlm() {
		Unidadmedida unidad =productoAlmacen.getUnidadMedidaAlm();
		if(unidad==null){
			unidad= new Unidadmedida();
			productoAlmacen.setUnidadMedidaAlm(unidad);
		}
		return productoAlmacen.getUnidadMedidaAlm();
	}
	public int getiUnidadMedidaAlmId() {
		return getUnidadMedidaAlm().getiUnidadMedidaId();
	
	}
	public void setiUnidadMedidaAlmId(int iUnidadMedidadId) {
		this.productoAlmacen.setUnidadMedidaAlm(getProductoDao().findEndidad(getUnidadmedida(), iUnidadMedidadId));
		//this.producto.setUnidadMedida(getProductoDao().findEndidad(getUnidadmedida(), iUnidadMedidadId));
	}
	

	/**
	 * @return the iUMBaseAlm
	 */
	public int getiUMBaseAlm() {
		return productoAlmacen.getiUMBaseAlm();
	}

	/**
	 * @param iUMBaseAlm the iUMBaseAlm to set
	 */
	public void setiUMBaseAlm(int iUMBaseAlm) {
		this.productoAlmacen.setiUMBaseAlm(iUMBaseAlm);
	}

	/**
	 * @return the iUMBaseAlmId
	 */
	public Unidadmedida unidadBaseAlm() {
		Unidadmedida unidad =productoAlmacen.getUnidadBaseAlm();
		if(unidad==null){
			unidad= new Unidadmedida();
			productoAlmacen.setUnidadBaseAlm(unidad);
		}
		return productoAlmacen.getUnidadBaseAlm();
	}
	public int getiUMBaseAlmId() {
		return unidadBaseAlm().getiUnidadMedidaId();
	
	}
	public void setiUMBaseAlmId(int iUnidadMedidadId) {
		this.productoAlmacen.setUnidadBaseAlm(getProductoDao().findEndidad(getUnidadmedida(), iUnidadMedidadId));
		//this.producto.setUnidadMedida(getProductoDao().findEndidad(getUnidadmedida(), iUnidadMedidadId));
	}
	
}