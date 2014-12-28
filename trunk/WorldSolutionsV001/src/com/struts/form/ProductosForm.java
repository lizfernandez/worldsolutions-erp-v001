//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.1/xslt/JavaClass.xsl

package com.struts.form;



import java.util.List;
import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import com.dao.CategoriaDao;
import com.dao.GenericaDao;
import com.dao.ProductoDao;
import com.entities.Categoria;

import com.entities.Moneda;
import com.entities.Producto;

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
	Producto producto = new Producto();
    private String mode;
    private List paginas; 
    private int pagInicio;
    int sizeIngresoproductodetalles;
    int sizeVentaDetalles;
    String dFechaInicio; // fecha del kardex
    String dFechaFin; // fecha del kardex
    private int iclasificacionId ;
    private FormFile foto;
    
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
		return producto.getcEstadoCodigo();
	}

	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.producto.setcEstadoCodigo(cEstadoCodigo);
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
	

	public int getiProduccionId() {
		return producto.getiProduccionId();
	}

	public void setiProduccionId(int iProduccionId) {
		this.producto.setiProduccionId(iProduccionId);
	}

	public int getiProductoStockCantidad() {
		return producto.getiProductoStockCantidad();
	}

	public void setiProductoStockCantidad(int iProductoStockCantidad) {
		this.producto.setiProductoStockCantidad(iProductoStockCantidad);
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

	public int getiUsuarioActualizaId() {
		return producto.getiUsuarioActualizaId();
	}

	public void setiUsuarioActualizaId(int iUsuarioActualizaId) {
		this.producto.setiUsuarioActualizaId(iUsuarioActualizaId);
	}

	public int getiUsuarioInsertaId() {
		return producto.getiUsuarioInsertaId();
	}

	public void setiUsuarioInsertaId(int iUsuarioInsertaId) {
		this.producto.setiUsuarioInsertaId(iUsuarioInsertaId);
	}

	public String getvProductoCapacidad() {
		
		return producto.getvProductoCapacidad();
	}

	public void setvProductoCapacidad(String vProductoCapacidad) {
		this.producto.setvProductoCapacidad(vProductoCapacidad);
	}

	public String getvProductoNombre() {
		return producto.getvProductoNombre();
	}

	public void setvProductoNombre(String vProductoNombre) {
		this.producto.setvProductoNombre(vProductoNombre);
		
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

	/** Unidad de medida de Capacidad***/
	public int getiUnidadMedidadIdC() {
		
		return producto.getiUnidadMedidadIdC();
		
	}
	public void setiUnidadMedidadIdC(int iUnidadMedidadId) {
		this.producto.setiUnidadMedidadIdC(iUnidadMedidadId);
	}
	
	public String getvUnidadMedidaDescripcionC() {
		
		return producto.getvUnidadMedidaDescripcionC();
	}

	/**
	 * @param vUnidadMedidaDescripcionC the vUnidadMedidaDescripcionC to set
	 */
	public void setvUnidadMedidaDescripcionC(String vUnidadMedidaDescripcionC) {
		this.producto.setvUnidadMedidaDescripcionC(vUnidadMedidaDescripcionC);
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

	
	
}