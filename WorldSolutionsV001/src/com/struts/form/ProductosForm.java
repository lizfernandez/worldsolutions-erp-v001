//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.1/xslt/JavaClass.xsl

package com.struts.form;



import java.text.ParseException;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import com.dao.ProductoDao;
import com.entities.Almacen;
import com.entities.Categoria;
import com.entities.Distalmacen;
import com.entities.Moneda;
import com.entities.Ordencompra;
import com.entities.Personal;
import com.entities.Produccion;
import com.entities.Producto;
import com.entities.Productoalmacen;
import com.entities.Proveedor;
import com.entities.Subcategoria;
import com.entities.Sucursal;
import com.entities.Unidadmedida;
import com.util.Fechas;


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
	private Distalmacen distAlmacen = new Distalmacen();
	private Ordencompra  ordenCompra = new Ordencompra() ;
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
    private String cPersonalCodigoRecep;
    private String vPersonalNombresRecep;
    private int iSucursalId;
    private int totalPrecios;
    private int totalProductosAlmacen;
    
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
			if(cEstadoCodigo==""){
				cEstadoCodigo= distAlmacen.getcEstadoCodigo();
			}
		}
		
		return cEstadoCodigo;
	}

	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.producto.setcEstadoCodigo(cEstadoCodigo);
		this.produccion.setcEstadoCodigo(cEstadoCodigo);
		this.distAlmacen.setcEstadoCodigo(cEstadoCodigo);
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
		this.producto.setCategoria(getProductoDao().findEndidad(Categoria.class, iCategoriaId));
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



	

	
	
	
	public int getiMonedaId() {		
		Moneda moneda = producto.getMoneda();
		int iMonedaId=0; 
		if(moneda!=null){
			iMonedaId= moneda.getiMonedaId(); 
		}
		return iMonedaId;
				
	}
	public void setiMonedaId(int iMonedaId) {		
		this.producto.setMoneda(getProductoDao().findEndidad(Moneda.class, iMonedaId));
		this.ordenCompra.setMoneda(getProductoDao().findEndidad(Moneda.class, iMonedaId));
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
		this.producto.setSubcategoria(getProductoDao().findEndidad(Subcategoria.class,iSubCategoriaId));
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

	
	public int getiUnidadMedidadId() {
		Unidadmedida unidadmedida =producto.getUnidadMedida();
		int iUnidadMedidadId=0;
		if(unidadmedida!=null){
			iUnidadMedidadId=unidadmedida.getiUnidadMedidaId();
		}
			return iUnidadMedidadId;
		
	}
	public void setiUnidadMedidadId(int iUnidadMedidadId) {
		if(iUnidadMedidadId>0){
		this.producto.setUnidadMedida(getProductoDao().findEndidad(Unidadmedida.class, iUnidadMedidadId));	
		}
		else{
			this.producto.setUnidadMedida(null);
		}
		
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
	 * @param umBase the umBase to set
	 */
	/*public void setUmBase(Unidadmedida umBase) {
		this.producto.setUmBase(umBase);
	}*/
	public int getiUMBaseId() {
		Unidadmedida unidadmedida =producto.getUmBase();
		int iUnidadMedidadId=0;
		if(unidadmedida!=null){
			iUnidadMedidadId=unidadmedida.getiUnidadMedidaId();
		}
			return iUnidadMedidadId;
		
	
	}
	public void setiUMBaseId(int iUnidadMedidadId) {
		if(iUnidadMedidadId>0){
		this.producto.setUmBase(getProductoDao().findEndidad(Unidadmedida.class, iUnidadMedidadId));	
		}
		else{
			this.producto.setUmBase(null);
		}
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
	

	/**
	 * @param umPedido the umPedido to set
	 */
	/*public void setUmPedido(Unidadmedida umPedido) {
		this.producto.setUmPedido(umPedido);
	}*/
	public int getiUMPedidoId() {
		Unidadmedida unidadmedida =producto.getUmPedido();
		int iUnidadMedidadId=0;
		if(unidadmedida!=null){
			iUnidadMedidadId=unidadmedida.getiUnidadMedidaId();
		}
			return iUnidadMedidadId;
	
	}
	public void setiUMPedidoId(int iUnidadMedidadId) {
		if(iUnidadMedidadId>0){
		this.producto.setUmPedido(getProductoDao().findEndidad(Unidadmedida.class, iUnidadMedidadId));	
		}
		else{
			this.producto.setUmPedido(null);	
		}
		//his.producto.setUnidadMedida(getProductoDao().findEndidad(getUnidadmedida(), iUnidadMedidadId));
	}
	/**
	 * @return the vUMSalida
	 */
	public int getiUMSalida() {
		return producto.getiUMSalida();
	}

	/**
	 * @param vUMSalida the vUMSalida to set
	 */
	public void setiUMSalida(int iUMSalida) {
		if(iUMSalida>0){
		this.producto.setiUMSalida(iUMSalida);	
		}
		
	}



	/**
	 * @param umSalida the umSalida to set
	 */

	public int getiUMSalidaId() {
		Unidadmedida unidadmedida =producto.getUmSalida();
		int iUnidadMedidadId=0;
		if(unidadmedida!=null){
			iUnidadMedidadId=unidadmedida.getiUnidadMedidaId();
		}
			return iUnidadMedidadId;
		
	
	}
	public void setiUMSalidaId(int iUnidadMedidadId) {
		if(iUnidadMedidadId>0){
		this.producto.setUmSalida(getProductoDao().findEndidad(Unidadmedida.class, iUnidadMedidadId));	
		}
		else{
			this.producto.setUmSalida(null);	
		}
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
		this.productoAlmacen.setAlmacen(getProductoDao().findEndidad(Almacen.class,iAlmacenId));
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

	public int getiUnidadMedidaAlmId() {
		Unidadmedida unidadmedida =productoAlmacen.getUnidadMedidaAlm();
		int iUnidadMedidadId=0;
		if(unidadmedida!=null){
			iUnidadMedidadId=unidadmedida.getiUnidadMedidaId();
		}
			return iUnidadMedidadId;
	
	}
	public void setiUnidadMedidaAlmId(int iUnidadMedidadId) {
		if(iUnidadMedidadId>0){
			this.productoAlmacen.setUnidadMedidaAlm(getProductoDao().findEndidad(Unidadmedida.class, iUnidadMedidadId));
		}
		else{
			this.productoAlmacen.setUnidadMedidaAlm(null);
		}
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

	public int getiUMBaseAlmId() {
		Unidadmedida unidadmedida =productoAlmacen.getUnidadBaseAlm();
		int iUnidadMedidadId=0;
		if(unidadmedida!=null){
			iUnidadMedidadId=unidadmedida.getiUnidadMedidaId();
		}
			return iUnidadMedidadId;
		
	
	}
	public void setiUMBaseAlmId(int iUnidadMedidadId) {
		if(iUnidadMedidadId>0){
		this.productoAlmacen.setUnidadBaseAlm(getProductoDao().findEndidad(Unidadmedida.class, iUnidadMedidadId));
		}
		else{
			this.productoAlmacen.setUnidadBaseAlm(null);	
		}
		//this.producto.setUnidadMedida(getProductoDao().findEndidad(getUnidadmedida(), iUnidadMedidadId));
	}

	/**
	 * @return the productoAlmacen
	 */
	public Productoalmacen getProductoAlmacen() {
		return productoAlmacen;
	}

	/**
	 * @param productoAlmacen the productoAlmacen to set
	 */
	public void setProductoAlmacen(Productoalmacen productoAlmacen) {
		this.productoAlmacen = productoAlmacen;
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

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/*****************************************/
	/**Distribucion de productos a almacenes**/
	/*****************************************/
	
	/**
	 * @return the distAlmacen
	 */
	public Distalmacen getDistAlmacen() {
		return distAlmacen;
	}

	/**
	 * @param distAlmacen the distAlmacen to set
	 */
	public void setDistAlmacen(Distalmacen distAlmacen) {
		this.distAlmacen = distAlmacen;
	}
	/**
	 * @return the iDistAlmacenId
	 */
	public int getiDistAlmacenId() {
		return distAlmacen.getiDistAlmacenId();
	}

	

	/**
	 * @param iDistAlmacenId the iDistAlmacenId to set
	 */
	public void setiDistAlmacenId(int iDistAlmacenId) {
		this.distAlmacen.setiDistAlmacenId(iDistAlmacenId);
	}


	

	/**
	 * @return the dFechaIngreso
	 */
	public String getdFechaIngreso() {
		String fecha = Fechas.fechaDDMMYY(distAlmacen.getdFechaIngreso());
		if(fecha==""){
			fecha=Fechas.fechaDDMMYY(Fechas.getDate());
		}
		return fecha;
	}

	/**
	 * @param dFechaIngreso the dFechaIngreso to set
	 * @throws ParseException 
	 */
	public void setdFechaIngreso(String dFechaIngreso) throws ParseException {
		this.distAlmacen.setdFechaIngreso(Fechas.fechaDate(dFechaIngreso));
	}

	
	/**
	 * @return the dFechaSalida
	 */
	public String getdFechaSalida() {
		String dFechaSalida =Fechas.fechaDDMMYY(distAlmacen.getdFechaSalida());
		if(dFechaSalida==""){
			dFechaSalida=Fechas.fechaDDMMYY(Fechas.getDate());
		}
		return dFechaSalida;
	}

	/**
	 * @param dFechaSalida the dFechaSalida to set
	 * @throws ParseException 
	 */
	public void setdFechaSalida(String dFechaSalida) throws ParseException {
		this.distAlmacen.setdFechaSalida(Fechas.fechaDate(dFechaSalida));
	}

	/**
	 * @return the fTotal
	 */
	public float getfTotal() {
		return distAlmacen.getfTotal();
	}

	/**
	 * @param fTotal the fTotal to set
	 */
	public void setfTotal(float fTotal) {
		this.distAlmacen.setfTotal(fTotal);
	}

	/**
	 * @return the almacenEntrada
	 */
	public Almacen getAlmacenEntrada() {
		Almacen almacen= distAlmacen.getAlmacenEntrada();
		if(almacen==null){
			almacen = new Almacen();
		}
		return almacen;
	}
	/**
	 * @return the almacenEntrada
	 */
	public int getiAlmacenEntradaId() {
		return getAlmacenEntrada().getiAlmacenId();
	}
	
	
	/**
	 * @param almacenEntrada the almacenEntrada to set
	 */
	public void setiAlmacenEntradaId(int almacenEntrada) {
		this.distAlmacen.setAlmacenEntrada(getProductoDao().findEndidad(Almacen.class,almacenEntrada)) ;
	}

	/**
	 * @return the almacenSalida
	 */
	public Almacen getAlmacenSalida() {
		Almacen almacenSalida= distAlmacen.getAlmacenSalida();
		if(almacenSalida==null){
			almacenSalida = new Almacen();
		}
		
		return almacenSalida;
	}

	

	/**
	 * @return the almacenEntrada
	 */
	public int getiAlmacenSalidaId() {
		return getAlmacenSalida().getiAlmacenId();
	}
	
	
	/**
	 * @param almacenEntrada the almacenEntrada to set
	 */
	public void setiAlmacenSalidaId(int almacenEntrada) {
		Almacen almacen= getProductoDao().findEndidadBD(Almacen.class, "sucursal.iSucursalId", almacenEntrada);
		this.distAlmacen.setAlmacenSalida(almacen) ;
	}
	

	/**
	 * @return the iUsuarioInsertaId
	 */
	public int getiUsuarioEntregaId() {
		Personal usuarioRecepcion= distAlmacen.getUsuatioEntrega();
		int iUsuarioRecepcionId =0;
		if(usuarioRecepcion!=null){
			iUsuarioRecepcionId= distAlmacen.getUsuatioEntrega().getiPersonalId();
		}
		return iUsuarioRecepcionId;
		
	}

	/**
	 * @param iUsuarioInsertaId the iUsuarioInsertaId to set
	 */
	public void setiUsuarioEntregaId(int iUsuarioEntregaId) {
		System.out.println("fs"+iUsuarioEntregaId);
		this.distAlmacen.setUsuatioEntrega(getProductoDao().findEndidad(Personal.class,iUsuarioEntregaId));
		System.out.println("fs"+iUsuarioEntregaId);
	}

	
	/**
	 * @return the iUsuarioInsertaId
	 */
	public int getiUsuarioRecepcionId() {
		Personal usuarioRecepcion= distAlmacen.getUsuarioRecepcion();
		int iUsuarioRecepcionId =0;
		if(usuarioRecepcion!=null){
			iUsuarioRecepcionId= distAlmacen.getUsuarioRecepcion().getiPersonalId();
		}
		return iUsuarioRecepcionId;
	}

	/**
	 * @param iUsuarioInsertaId the iUsuarioInsertaId to set
	 */
	public void setiUsuarioRecepcionId(int iUsuarioRecepcion) {
		this.distAlmacen.setUsuarioRecepcion(getProductoDao().findEndidad(Personal.class,iUsuarioRecepcion));
	}

	/**
	 * @return the vNroIngreso
	 */
	public String getvNroIngreso() {
		return distAlmacen.getvNroIngreso();
	}

	/**
	 * @param vNroIngreso the vNroIngreso to set
	 */
	public void setvNroIngreso(String vNroIngreso) {
		this.distAlmacen.setvNroIngreso(vNroIngreso);
	}

	/**
	 * @return the vNroSalida
	 */
	public String getvNroSalida() {
		return distAlmacen.getvNroSalida();
	}

	/**
	 * @param vNroSalida the vNroSalida to set
	 */
	public void setvNroSalida(String vNroSalida) {
		this.distAlmacen.setvNroSalida(vNroSalida);
	}

	/**
	 * @return the vObservacion
	 */
	public String getvObservacion() {
		return distAlmacen.getvObservacion();
	}

	/**
	 * @param vObservacion the vObservacion to set
	 */
	public void setvObservacion(String vObservacion) {
		this.distAlmacen.setvObservacion(vObservacion);
	}

	/**
	 * @return the vPuntoLlegada
	 */
	public String getvPuntoLlegada() {
		return distAlmacen.getvPuntoLlegada();
	}

	/**
	 * @param vPuntoLlegada the vPuntoLlegada to set
	 */
	public void setvPuntoLlegada(String vPuntoLlegada) {
		this.distAlmacen.setvPuntoLlegada(vPuntoLlegada) ;
	}

	/**
	 * @return the vPuntoSalida
	 */
	public String getvPuntoSalida() {
		return distAlmacen.getvPuntoSalida();
	}

	/**
	 * @param vPuntoSalida the vPuntoSalida to set
	 */
	public void setvPuntoSalida(String vPuntoSalida) {
		this.distAlmacen.setvPuntoSalida(vPuntoSalida);
	}

	/**********************/
	/**ORDENES DE COMPRAS**/
	/**********************/

	/**
	 * @return the ordenCompra
	 */
	public Ordencompra getOrdenCompra() {
		return ordenCompra;
	}

	/**
	 * @param ordenCompra the ordenCompra to set
	 */
	public void setOrdenCompra(Ordencompra ordenCompra) {
		this.ordenCompra = ordenCompra;
	}
	/**
	 * @return the iOrdenCompraId
	 */
	public int getiOrdenCompraId() {
		return ordenCompra.getiOrdenCompraId();
	}


	/**
	 * @param iOrdenCompraId the iOrdenCompraId to set
	 */
	public void setiOrdenCompraId(int iOrdenCompraId) {
		this.ordenCompra.setiOrdenCompraId(iOrdenCompraId);
	}

	/**
	 * @return the dFechaPedido
	 */
	public String getdFechaPedido() {
		String dFechaPedido = Fechas.fechaDDMMYY(ordenCompra.getdFechaPedido());
		return dFechaPedido;
	}

	/**
	 * @param dFechaPedido the dFechaPedido to set
	 * @throws ParseException 
	 */
	public void setdFechaPedido(String dFechaPedido) throws ParseException {
		this.ordenCompra.setdFechaPedido(Fechas.fechaDate(dFechaPedido));
	}

	/**
	 * @return the fDescuento
	 */
	public float getfDescuento() {
		return ordenCompra.getfDescuento();
	}

	/**
	 * @param fDescuento the fDescuento to set
	 */
	public void setfDescuento(float fDescuento) {
		this.ordenCompra.setfDescuento(fDescuento);
	}

	/**
	 * @return the fOrdenCompraIGV
	 */
	public float getfOrdenCompraIGV() {
		return ordenCompra.getfOrdenCompraIGV();
	}

	/**
	 * @param fOrdenCompraIGV the fOrdenCompraIGV to set
	 */
	public void setfOrdenCompraIGV(float fOrdenCompraIGV) {
		this.ordenCompra.setfOrdenCompraIGV(fOrdenCompraIGV);
	}

	/**
	 * @return the fOrdenCompraSubTotal
	 */
	public float getfOrdenCompraSubTotal() {
		return ordenCompra.getfOrdenCompraSubTotal();
	}

	/**
	 * @param fOrdenCompraSubTotal the fOrdenCompraSubTotal to set
	 */
	public void setfOrdenCompraSubTotal(float fOrdenCompraSubTotal) {
		this.ordenCompra.setfOrdenCompraSubTotal(fOrdenCompraSubTotal);
	}

	/**
	 * @return the fTipoCambio
	 */
	public float getfTipoCambio() {
		return ordenCompra.getfTipoCambio();
	}

	/**
	 * @param fTipoCambio the fTipoCambio to set
	 */
	public void setfTipoCambio(float fTipoCambio) {
		this.ordenCompra.setfTipoCambio(fTipoCambio);
	}

	/**
	 * @return the fTotal
	 */
	public float getfOrdenCompraTotal() {
		return ordenCompra.getfTotal();
	}

	/**
	 * @param fTotal the fTotal to set
	 */
	public void setfOrdenCompraTotal(float fTotal) {
		this.ordenCompra.setfTotal(fTotal);
	}

	

	/**
	 * @return the proveedor
	 */
	public Proveedor getProveedor() {
		Proveedor proveedor = ordenCompra.getProveedor();
		if(proveedor==null){
			proveedor = new Proveedor();
		}
		return proveedor;
	}
	/**
	 * @return the almacenEntrada
	 */
	public int getiProveedorId() {
		return getProveedor().getiProveedorId();
	}
	
	
	/**
	 * @param almacenEntrada the almacenEntrada to set
	 */
	public void setiProveedorId(int iProveedorId) {
		this.ordenCompra.setProveedor(getProductoDao().findEndidad(Proveedor.class,iProveedorId)) ;
	}
	

	/**
	 * @return the sucursal
	 */
	public Sucursal getSucursal() {
		Sucursal sucursal = ordenCompra.getSucursal();
		if(sucursal==null){
			sucursal= new Sucursal();
		}
		return sucursal;
	}

	/**
	 * @return the almacenEntrada
	 */
	public int getiSucursalOrdenId() {
		return getSucursal().getiSucursalId();
	}
	
	
	/**
	 * @param almacenEntrada the almacenEntrada to set
	 */
	public void setiSucursalOrdenId(int iProveedorId) {
		this.ordenCompra.setSucursal(getProductoDao().findEndidad(Sucursal.class,iProveedorId)) ;
	}


	/**
	 * @return the vEstadoDocumento
	 */
	public String getvEstadoDocumento() {
		return ordenCompra.getvEstadoDocumento();
	}

	/**
	 * @param vEstadoDocumento the vEstadoDocumento to set
	 */
	public void setvEstadoDocumento(String vEstadoDocumento) {
		this.ordenCompra.setvEstadoDocumento(vEstadoDocumento);
	}

	/**
	 * @return the vNroOrden
	 */
	public String getvNroOrden() {
		return ordenCompra.getvNroOrden();
	}

	/**
	 * @param vNroOrden the vNroOrden to set
	 */
	public void setvNroOrden(String vNroOrden) {
		this.ordenCompra.setvNroOrden(vNroOrden);
	}

	/**
	 * @return the cPersonalCodigoRecep
	 */
	public String getcPersonalCodigoRecep() {
		return cPersonalCodigoRecep;
	}

	/**
	 * @param cPersonalCodigoRecep the cPersonalCodigoRecep to set
	 */
	public void setcPersonalCodigoRecep(String cPersonalCodigoRecep) {
		this.cPersonalCodigoRecep = cPersonalCodigoRecep;
	}

	/**
	 * @return the vPersonalNombresRecep
	 */
	public String getvPersonalNombresRecep() {
		return vPersonalNombresRecep;
	}

	/**
	 * @param vPersonalNombresRecep the vPersonalNombresRecep to set
	 */
	public void setvPersonalNombresRecep(String vPersonalNombresRecep) {
		this.vPersonalNombresRecep = vPersonalNombresRecep;
	}

	/**
	 * @return the totalPrecios
	 */
	public int getTotalPrecios() {
		return totalPrecios;
	}

	/**
	 * @param totalPrecios the totalPrecios to set
	 */
	public void setTotalPrecios(int totalPrecios) {
		this.totalPrecios = totalPrecios;
	}

	/**
	 * @return the totalProductosAlmacen
	 */
	public int getTotalProductosAlmacen() {
		return totalProductosAlmacen;
	}

	/**
	 * @param totalProductosAlmacen the totalProductosAlmacen to set
	 */
	public void setTotalProductosAlmacen(int totalProductosAlmacen) {
		this.totalProductosAlmacen = totalProductosAlmacen;
	}

}