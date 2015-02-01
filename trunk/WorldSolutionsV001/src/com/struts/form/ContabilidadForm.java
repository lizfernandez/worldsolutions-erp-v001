package com.struts.form;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts.action.ActionForm;


import com.entities.Categoria;
import com.entities.Cliente;
import com.entities.Cuenta;
import com.entities.Elementocuenta;
import com.entities.Formapago;
import com.entities.Ingresoproducto;
import com.entities.Librodiario;
import com.entities.Moneda;
import com.entities.Personal;
import com.entities.Planilla;

import com.entities.Producto;
import com.entities.Proveedor;
import com.entities.Tipodocumentogestion;
import com.entities.Unidadmedida;
import com.entities.Venta;
import com.util.Fechas;


public class ContabilidadForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List lista;	
	Venta venta = new Venta();
	Ingresoproducto ingresoProducto = new Ingresoproducto();
	Producto producto = new Producto();	
	Librodiario librodiario = new Librodiario();
	Planilla planilla = new Planilla();
	private String vPersonalNombres;
	private String vOcupacionDescripcion;
    
    private String mode;
    private List paginas;
    private int pagInicio; 
    private String vClienteDireccion;
    private int iclasificacionId ;
    private String tipo;
    private int iCuentasId1;
    private int iCuentasId2;
    private int iCuentasId3;
    private int iCuentasId4;
    private int iCuentasId5;
    private double totalDebe;
    private double totalHaber;
    private double totalfMontoSaldoD;
	private double totalfMontoSaldoH;
	private double totalfMontoBalanceA;
	private double totalfMontoBalanceP;
    private double totalCompraVenta;
    private double subTotalCompraVenta; 
    private double igvCompraVenta; 
    private String igvActual;
    private String mes;
    
    

    
    
    
	/**
	 * @return the librodiario
	 */
	
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	/**
	 * @return the iCuentasId2
	 */
	public int getiCuentasId2() {
		return iCuentasId2;
	}
	/**
	 * @param iCuentasId2 the iCuentasId2 to set
	 */
	public void setiCuentasId2(int iCuentasId2) {
		this.iCuentasId2 = iCuentasId2;
	}
	/**
	 * @return the iCuentasId3
	 */
	public int getiCuentasId3() {
		return iCuentasId3;
	}
	/**
	 * @param iCuentasId3 the iCuentasId3 to set
	 */
	public void setiCuentasId3(int iCuentasId3) {
		this.iCuentasId3 = iCuentasId3;
	}
	/**
	 * @return the iCuentasId4
	 */
	public int getiCuentasId4() {
		return iCuentasId4;
	}
	/**
	 * @param iCuentasId4 the iCuentasId4 to set
	 */
	public void setiCuentasId4(int iCuentasId4) {
		this.iCuentasId4 = iCuentasId4;
	}
	/**
	 * @return the iCuentasId5
	 */
	public int getiCuentasId5() {
		return iCuentasId5;
	}
	/**
	 * @param iCuentasId5 the iCuentasId5 to set
	 */
	public void setiCuentasId5(int iCuentasId5) {
		this.iCuentasId5 = iCuentasId5;
	}
	/**
	 * @return the lista
	 */
	public List getLista() {
		return lista;
	}
	/**
	 * @param lista the lista to set
	 */
	public void setLista(List lista) {
		this.lista = lista;
	}
	
	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
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
	
	/**
	 * VENTA
	 **/	
	/**
	 * @return the venta
	 */
	public Venta getVenta() {
		return venta;
	}
	/**
	 * @param venta the venta to set
	 */
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	/**
	 * @return the iVentaId
	 */
	public int getiVentaId() {
		return venta.getiVentaId();
	}

	/**
	 * @param iVentaId the iVentaId to set
	 */
	public void setiVentaId(int iVentaId) {
		this.venta.setiVentaId ( iVentaId);
	}

	


	/**
	 * @return the dVentaFecha
	 */
	public String getdVentaFecha() {
		String fechaVenta = "";
		if(venta.getdVentaFecha()!=null)
		  fechaVenta = Fechas.fechaDDMMYY(venta.getdVentaFecha());
		else
			fechaVenta = Fechas.fechaDDMMYY(Fechas.getDate());
		return fechaVenta;
	}

	/**
	 * @param dVentaFecha the dVentaFecha to set
	 * @throws ParseException 
	 */
	public void setdVentaFecha(String dVentaFecha) throws ParseException {
		this.venta.setdVentaFecha (Fechas.fechaDate(dVentaFecha));
	}
	
	

	/**
	 * @return the dVentaFechaFin
	 */
	public String getdVentaFechaFin() {
		String dVentaFechaFin = "";
		dVentaFechaFin = Fechas.fechaDDMMYY(venta.getdFechaActualiza());
	
		return dVentaFechaFin;
	}
	/**
	 * @param dVentaFechaFin the dVentaFechaFin to set
	 * @throws ParseException 
	 */
	public void setdVentaFechaFin(String dVentaFechaFin) throws ParseException {
		this.venta.setdFechaActualiza(Fechas.fechaDate(dVentaFechaFin));
		
	}
	/**
	 * @return the fVentaTotal
	 */
	public float getfVentaTotal() {
		return venta.getfVentaTotal();
	}

	/**
	 * @param fVentaTotal the fVentaTotal to set
	 */
	public void setfVentaTotal(float fVentaTotal) {
		this.venta.setfVentaTotal ( fVentaTotal);
	}

	


	/**
	 * @return the nVentaNumero
	 */
	public String getnVentaNumero() {
		return venta.getnVentaNumero();
	}

	/**
	 * @param nVentaNumero the nVentaNumero to set
	 */
	public void setnVentaNumero(String nVentaNumero) {
		this.venta.setnVentaNumero ( nVentaNumero);
	}
	/**
	 * @return the vVentaPuntoLlegada
	 */
	public String getvVentaPuntoLlegada() {
		return venta.getvVentaPuntoLlegada();
	}

	/**
	 * @param vVentaPuntoLlegada the vVentaPuntoLlegada to set
	 */
	public void setvVentaPuntoLlegada(String vVentaPuntoLlegada) {
		this.venta.setvVentaPuntoLlegada(vVentaPuntoLlegada);
	}
	
	public Cliente getCliente(){
		Cliente cliente = venta.getCliente();		
		if(cliente!=null)
			cliente = new Cliente();
		
		return cliente;
				
	}
	/**
	 * @return the iClienteId
	 */
	public int getiClienteId() {
		return  getCliente().getiClienteId();
	}

	/**
	 * @param iClienteId the iClienteId to set
	 */
	public void setiClienteId(int iClienteId) {
		this.venta.getCliente().setiClienteId(iClienteId);
	}
	/**
	 * @return the cClienteCodigo
	 */
	public String getvClienteCodigo() {
		Cliente cliente = getCliente();		
		return cliente.getvClienteCodigo();
	}

	/**
	 * @param cClienteCodigo the cClienteCodigo to set
	 */
	public void setvClienteCodigo(String vClienteCodigo) {
		Cliente cliente = getCliente();
		cliente.setvClienteCodigo(vClienteCodigo);
		this.venta.setCliente(cliente);
	}
	/**
	 * @return the nClienteNumeroDocumento
	 */
	public BigDecimal getnClienteNumeroDocumento() {
		Cliente cliente = getCliente();
		return cliente.getnClienteNumeroDocumento(); 
		 
	}

	/**
	 * @param nClienteNumeroDocumento the nClienteNumeroDocumento to set
	 */
	public void setnClienteNumeroDocumento(BigDecimal nClienteNumeroDocumento) {
		Cliente cliente = getCliente();		
		cliente.setnClienteNumeroDocumento(nClienteNumeroDocumento);
		this.venta.setCliente(cliente);
	}

	

	/**
	 * @return the vClienteDireccion
	 */
	public String getvClienteDireccion() {
		return vClienteDireccion;
	}
	/**
	 * @param vClienteDireccion the vClienteDireccion to set
	 */
	public void setvClienteDireccion(String vClienteDireccion) {
		this.vClienteDireccion = vClienteDireccion;
	}
	/**
	 * @return the vClienteRazonSocial
	 */
	public String getvClienteRazonSocial() {
		Cliente cliente = getCliente();
		return cliente.getvClienteRazonSocial();
	
		 
	}

	/**
	 * @param vClienteRazonSocial the vClienteRazonSocial to set
	 */
	public void setvClienteRazonSocial(String vClienteRazonSocial) {
		Cliente cliente = getCliente();		
		cliente.setvClienteRazonSocial(vClienteRazonSocial);
		this.venta.setCliente(cliente);
	}

	/**
	 * @return the tipodocumento
	 */
	public int getiTipoDocumentoId() {
	Tipodocumentogestion tipoDoc =  venta.getTipoDocumento();	
		int iTipoDoceId = 0;
		if(tipoDoc!=null)
			iTipoDoceId = tipoDoc.getiTipoDocumentoGestionId();
		return iTipoDoceId;
	}

	/**
	 * @param tipodocumento the tipodocumento to set
	 */
	public void setiTipoDocumentoId(int iTipoDocumentoGestionId) {
		
		Tipodocumentogestion tipo = new Tipodocumentogestion();
		tipo.setiTipoDocumentoGestionId(iTipoDocumentoGestionId);
		
		this.venta.setTipoDocumento(tipo);
		this.ingresoProducto.setTipodocumento(tipo);
	}
	/**
	 * @return the iFormaPagoId
	 */
	public int getiFormaPago() {
		Formapago formaPago = venta.getFormaPago();
		 int iFormaPagoId = 0;
		 if(formaPago!=null)
			 iFormaPagoId = venta.getFormaPago().getiFormaPago();			
		return iFormaPagoId;
	}

	/**
	 * @param iFormaPagoId the iFormaPagoId to set
	 */
	public void setiFormaPago(int iFormaPagoId) {
		Formapago formaPago = new  Formapago();
		formaPago.setiFormaPago(iFormaPagoId);
		this.venta.setFormaPago(formaPago);
		this.ingresoProducto.setFormaPago(formaPago);
	}
	
	/**
	 * @return the vEstadoDocumento
	 */
	public String getvEstadoDocumento() {
		return this.venta.getvEstadoDocumento();
	}

	/**
	 * @param vEstadoDocumento the vEstadoDocumento to set
	 */
	public void setvEstadoDocumento(String vEstadoDocumento) {
		this.venta.setvEstadoDocumento ( vEstadoDocumento);
	}
	/**
	 * @return the ingresoProducto
	 */
	public Ingresoproducto getIngresoProducto() {
		return ingresoProducto;
	}
	/**
	 * @param ingresoProducto the ingresoProducto to set
	 */
	public void setIngresoProducto(Ingresoproducto ingresoProducto) {
		this.ingresoProducto = ingresoProducto;
	}
	
	
	/*********************/
	/**INGRESO PRODUCTO **/
	/*********************/
	/**
	 * @return the cProveedorCodigo
	 */
	public String getvProveedorCodigo() {
		Proveedor proveedor = ingresoProducto.getProveedor();
		String cProveedorCodigo="";
		if(proveedor!=null)
			cProveedorCodigo = proveedor.getcProveedorCodigo();
		return cProveedorCodigo;
	}

	/**
	 * @param cProveedorCodigo the cProveedorCodigo to set
	 */
	public void setvProveedorCodigo(String vProveedorCodigo) {
		Proveedor proveedor = new Proveedor();
		proveedor.setcProveedorCodigo(vProveedorCodigo);
		this.ingresoProducto.setProveedor(proveedor);
	}
	
	/**
	 * @return the vVentaPuntoLlegada
	 */
	public String getvIngresoProductoPuntoLlegada() {
		return ingresoProducto.getvIngresoProductoPuntoLlegada();
	}

	/**
	 * @param vVentaPuntoLlegada the vVentaPuntoLlegada to set
	 */
	public void setvIngresoProductoPuntoLlegada(String vVentaPuntoLlegada) {
		this.ingresoProducto.setvIngresoProductoPuntoLlegada(vVentaPuntoLlegada);
	}


	/**
	 * @return the iIngresoProductoId
	 */
	public int getiIngresoProductoId() {
		return ingresoProducto.getiIngresoProductoId();
	}

	/**
	 * @param iIngresoProductoId the iIngresoProductoId to set
	 */
	public void setiIngresoProductoId(int iIngresoProductoId) {
		this.ingresoProducto.setiIngresoProductoId ( iIngresoProductoId);
	}

	/**
	 * @return the cEstadoCodigo
	 */
	public String getcEstadoCodigo() {
		String cEstadoCodigo= "";
		List<String> listaEstadoCodigo = new ArrayList<String>();
		listaEstadoCodigo.add(ingresoProducto.getcEstadoCodigo());
		listaEstadoCodigo.add(planilla.getcEstadoCodigo());
		listaEstadoCodigo.add(librodiario.getcEstadoCodigo());
	
		
		for ( String lista:listaEstadoCodigo)	{
			if(lista!=null){
				cEstadoCodigo= lista;
			}
		}	
		
			
		return cEstadoCodigo;
	}

	/**
	 * @param cEstadoCodigo the cEstadoCodigo to set
	 */
	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.ingresoProducto.setcEstadoCodigo ( cEstadoCodigo);
		this.planilla.setcEstadoCodigo(cEstadoCodigo);
		
	}


	/**
	 * @return the dIngresoProductoFecha
	 */
	public String getdIngresoProductoFecha() {
		String fechaIngresoProducto = "";
		if(ingresoProducto.getdIngresoProductoFecha()!=null)
			fechaIngresoProducto = Fechas.fechaDDMMYY(ingresoProducto.getdIngresoProductoFecha());
		else
			fechaIngresoProducto = Fechas.fechaDDMMYY(Fechas.getDate());
		return fechaIngresoProducto;
	}

	/**
	 * @param dIngresoProductoFecha the dIngresoProductoFecha to set
	 * @throws ParseException 
	 */
	public void setdIngresoProductoFecha(String dIngresoProductoFecha) throws ParseException {
		this .ingresoProducto.setdIngresoProductoFecha (Fechas.fechaDate(dIngresoProductoFecha));
	}
	
	

	/**
	 * @return the dIngresoProductoFechaFin
	 */
	public String getdIngresoProductoFechaFin() {
		String dIngresoProductoFechaFin = "";
		dIngresoProductoFechaFin = Fechas.fechaDDMMYY(ingresoProducto.getdFechaActualiza());
	
		return dIngresoProductoFechaFin;
	}
	/**
	 * @param dIngresoProductoFechaFin the dIngresoProductoFechaFin to set
	 * @throws ParseException 
	 */
	public void setdIngresoProductoFechaFin(String dIngresoProductoFechaFin) throws ParseException {
		this .ingresoProducto.setdFechaActualiza(Fechas.fechaDate(dIngresoProductoFechaFin));
		
	}
	/**
	 * @return the fIngresoProductoIGV
	 */
	public float getfIngresoProductoIGV() {
		return ingresoProducto.getfIngresoProductoIGV();
	}

	/**
	 * @param fIngresoProductoIGV the fIngresoProductoIGV to set
	 */
	public void setfIngresoProductoIGV(float fIngresoProductoIGV) {
		this.ingresoProducto.setfIngresoProductoIGV ( fIngresoProductoIGV);
	}

	/**
	 * @return the fIngresoProductoSubTotal
	 */
	public float getfIngresoProductoSubTotal() {
		return ingresoProducto.getfIngresoProductoSubTotal();
	}

	/**
	 * @param fIngresoProductoSubTotal the fIngresoProductoSubTotal to set
	 */
	public void setfIngresoProductoSubTotal(float fIngresoProductoSubTotal) {
		this.ingresoProducto.setfIngresoProductoSubTotal (fIngresoProductoSubTotal);
	}

	/**
	 * @return the fIngresoProductoTotal
	 */
	public float getfIngresoProductoTotal() {
		return ingresoProducto.getfIngresoProductoTotal();
	}

	/**
	 * @param fIngresoProductoTotal the fIngresoProductoTotal to set
	 */
	public void setfIngresoProductoTotal(float fIngresoProductoTotal) {
		this.ingresoProducto.setfIngresoProductoTotal ( fIngresoProductoTotal);
	}

	

	/**
	 * @return the nIngresoProductoNumero
	 */
	public String getnIngresoProductoNumero() {
		return ingresoProducto.getnIngresoProductoNumero();
	}

	/**
	 * @param nIngresoProductoNumero the nIngresoProductoNumero to set
	 */
	public void setnIngresoProductoNumero(String nIngresoProductoNumero) {
		this.ingresoProducto.setnIngresoProductoNumero ( nIngresoProductoNumero);
	}

	/**
	 * @return the vPrincipal
	 */
	public String getvPrincipal() {
		return ingresoProducto.getvPrincipal();
	}

	/**
	 * @param vPrincipal the vPrincipal to set
	 */
	public void setvPrincipal(String vPrincipal) {
		this.ingresoProducto.setvPrincipal (vPrincipal);
	}

	/**
	 * @return the iProveedorId
	 */
	public int getiProveedorId() {
		Proveedor proveedor = ingresoProducto.getProveedor();
		int iProveedorId = 0;
		if(proveedor!=null)
			iProveedorId = proveedor.getiProveedorId();
		return iProveedorId;
	}

	/**
	 * @param iProveedorId the iProveedorId to set
	 */
	public void setiProveedorId(int iProveedorId) {
		this.ingresoProducto.getProveedor().setiProveedorId(iProveedorId);
	}
	
	
	/**
	 * @return the proveedor
	 */
	public Proveedor getProveedor() {
		return ingresoProducto.getProveedor();
	}

	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(Proveedor proveedor) {
		this.ingresoProducto.setProveedor(proveedor);
	}
	

	/**
	 * @return the cProveedorCodigo
	 */
	public String getcProveedorCodigo() {
		Proveedor proveedor = ingresoProducto.getProveedor();
		String cProveedorCodigo="";
		if(proveedor!=null)
			cProveedorCodigo = proveedor.getcProveedorCodigo();
		return cProveedorCodigo;
	}

	/**
	 * @param cProveedorCodigo the cProveedorCodigo to set
	 */
	public void setcProveedorCodigo(String cProveedorCodigo) {
		Proveedor proveedor =  new Proveedor();
		proveedor.setcProveedorCodigo(cProveedorCodigo);
		this.ingresoProducto.setProveedor(proveedor);
	}
	
	/**
	 * @return the nProveedorNumeroDocumento
	 */
	public BigDecimal getnProveedorNumeroDocumento() {
		Proveedor proveedor = ingresoProducto.getProveedor();
		BigDecimal nProveedorNumeroDocumento = null;
		if(proveedor!=null)
			nProveedorNumeroDocumento = proveedor.getnProveedorNumeroDocumento(); 
		return nProveedorNumeroDocumento; 
	}

	/**
	 * @param nProveedorNumeroDocumento the nProveedorNumeroDocumento to set
	 */
	public void setnProveedorNumeroDocumento(BigDecimal nProveedorNumeroDocumento) {
		Proveedor proveedor = ingresoProducto.getProveedor();//new Proveedor();
		if(proveedor==null)
			proveedor = new  Proveedor();
	       proveedor.setnProveedorNumeroDocumento (nProveedorNumeroDocumento);
		this.ingresoProducto.setProveedor(proveedor);
	}


	/**
	 * @return the vProveedorRazonSocial
	 */
	public String getvProveedorRazonSocial() {
		Proveedor proveedor = ingresoProducto.getProveedor();
		String vProveedorRazonSocial="";
		if(proveedor!=null)
			vProveedorRazonSocial = proveedor.getvProveedorRazonSocial();
	
		return vProveedorRazonSocial;
	}

	/**
	 * @param vProveedorRazonSocial the vProveedorRazonSocial to set
	 */
	public void setvProveedorRazonSocial(String vProveedorRazonSocial) {
		Proveedor proveedor = new Proveedor();
		if(ingresoProducto.getProveedor()!=null)
			proveedor = ingresoProducto.getProveedor();
		proveedor.setvProveedorRazonSocial (vProveedorRazonSocial);
		this.ingresoProducto.setProveedor(proveedor);
	}
	

	/*********************/
	/** ENTIDAD PRODUCTO */
	/*********************/
	
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

	public int getiCategoriaId() {
		int iCategoriaId=0;
		if(producto.getCategoria()!=null)
			iCategoriaId=producto.getCategoria().getiCategoriaId();
		return iCategoriaId;
	}

	public void setiCategoriaId(int iCategoriaId) {
		Categoria categoria = new Categoria();
		categoria.setiCategoriaId(iCategoriaId);		
		this.producto.setCategoria(categoria);
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

	
	/**/
/** Unidad de medida de cantidad***/
	public int getiUnidadMedidadId() {
		Unidadmedida unidadMedida = producto.getUnidadMedida();
		int   iUnidadMedidaId = 0;
		if(unidadMedida !=null)
		  {
			iUnidadMedidaId = unidadMedida.getiUnidadMedidaId();
		  }
			return iUnidadMedidaId;
		
	}
	public void setiUnidadMedidadId(int iUnidadMedidadId) {
		Unidadmedida unidadMedida = new Unidadmedida ();
		unidadMedida.setiUnidadMedidaId(iUnidadMedidadId);
		this.producto.setUnidadMedida(unidadMedida);
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
	public int getiMonedaId() {
		Moneda moneda = producto.getMoneda();
		int   iMonedaId = 0;
		if(moneda !=null)
		  {
			iMonedaId = moneda.getiMonedaId();
		  }
			return iMonedaId;
		
	}
	public void setiMonedaId(int iMonedaId) {
		Moneda moneda = new Moneda();
		moneda.setiMonedaId(iMonedaId);
		this.producto.setMoneda(moneda);
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
	
	/************************/
	/** ENTIDAD CAJA CHICA **/
	/************************/
	/**
	 * @return the iLibroDiarioId
	 */
	public int getiLibroDiarioId() {
		return librodiario.getiLibroDiarioId();
	}

	/**
	 * @param iLibroDiarioId the iLibroDiarioId to set
	 */
	public void setiLibroDiarioId(int iLibroDiarioId) {
		this.librodiario.setiLibroDiarioId (iLibroDiarioId);
	}

	

	/**
	 * @return the dFechaInserta
	 */
	public String getdFechaInserta() {
		String fechaVenta = Fechas.fechaDDMMYY(Fechas.getDate());
		if(librodiario.getdFechaInserta()!=null)
		  fechaVenta = Fechas.fechaDDMMYY(librodiario.getdFechaInserta());		
		return fechaVenta;
		
	}

	/**
	 * @param dFechaInserta the dFechaInserta to set
	 * @throws ParseException 
	 */
	public void setdFechaInserta(String dFechaInserta) throws ParseException {
		this.librodiario.setdFechaInserta(Fechas.fechaDate(dFechaInserta));
	}

	/**
	 * @return the fMontoDebe
	 */
	public float getfMonto() {
		return librodiario.getfMonto();
	}

	/**
	 * @param fMontoDebe the fMontoDebe to set
	 */
	public void setfMonto(float fMontoDebe) {
		this.librodiario.setfMonto(fMontoDebe);
	}
	
	
	
	/**
	 * @return the cuenta
	 */
	public Cuenta getCuenta() {
		Cuenta cuenta = new Cuenta();
		if(librodiario.getCuenta()!=null)
			cuenta= librodiario.getCuenta();
		return cuenta;
	}

	/**
	 * @param cuenta the cuenta to set
	 */
	public void setCuenta(Cuenta cuenta) {
		Cuenta cuentas = getCuenta();		
		this.librodiario.setCuenta(cuentas);
	}
	

	/**
	 * @return the elementoCuenta
	 */
	public Elementocuenta getElementoCuenta() {
		Elementocuenta elementoCuenta = new Elementocuenta();
		if(getCuenta().getElementoCuenta()!=null)
			elementoCuenta= getCuenta().getElementoCuenta();
		return elementoCuenta;
	}

	/**
	 * @param elementoCuenta the elementoCuenta to set
	 */
	public void setElementoCuenta(Elementocuenta elementoCuenta) {
		Elementocuenta elementoCuentas = getElementoCuenta();
	    this.getCuenta().setElementoCuenta(elementoCuentas);
	}

	/**
	 * @return the vCodigo
	 */
	public String getvCodigo() {
		Cuenta cuenta = getCuenta();
		return cuenta.getvCodigo();
	}

	/**
	 * @param vCodigo the vCodigo to set
	 */
	public void setvCodigo(String vCodigo) {
		Cuenta cuenta = getCuenta();
		cuenta.setvCodigo(vCodigo);		
		this.librodiario.setCuenta(cuenta);
	}
	/**
	 * @return the vCodigo
	 */
	public int getiCuentasId() {
		Cuenta cuenta = getCuenta();
		return cuenta.getiCuentasId();
	}

	/**
	 * @param vCodigo the vCodigo to set
	 */
	public void setiCuentasId(int iCuentasId) {
		Cuenta cuenta = getCuenta();
		cuenta.setiCuentasId(iCuentasId);		
		this.librodiario.setCuenta(cuenta);
	}
	/**
	 * @return the iElementoCuentasId
	 */
	public int getiElementoCuentasId() {		
		return getElementoCuenta().getiElementoCuentasId();
	}

	/**iElementoCuentasId
	 * @param iElementoCuentasId the iElementoCuentasId to set
	 */
	public void setiElementoCuentasId(int iElementoCuentasId) {		
		this.getElementoCuenta().setiElementoCuentasId(iElementoCuentasId);
	}
	/**
	 * @return the iCuentasId1
	 */
	public int getiCuentasId1() {
		return iCuentasId1;
	}
	/**
	 * @param iCuentasId1 the iCuentasId1 to set
	 */
	public void setiCuentasId1(int iCuentasId1) {
		this.iCuentasId1 = iCuentasId1;
	}
	/**
	 * @return the vConceptoGeneral
	 */
	public String getvConceptoGeneral() {
		return librodiario.getvConceptoGeneral();
	}
	/**
	 * @param vConceptoGeneral the vConceptoGeneral to set
	 */
	public void setvConceptoGeneral(String vConceptoGeneral) {
		librodiario.setvConceptoGeneral(vConceptoGeneral);
	}
	/**
	 * @return the librodiario
	 */
	public Librodiario getLibrodiario() {
		return librodiario;
	}
	/**
	 * @param librodiario the librodiario to set
	 */
	public void setLibrodiario(Librodiario librodiario) {
		this.librodiario = librodiario;
	}
	/**
	 * @return the totalDebe
	 */
	public double getTotalDebe() {
		return totalDebe;
	}
	/**
	 * @param totalDebe the totalDebe to set
	 */
	public void setTotalDebe(double totalDebe) {
		this.totalDebe = totalDebe;
	}
	/**
	 * @return the totalHaber
	 */
	public double getTotalHaber() {
		return totalHaber;
	}
	/**
	 * @param totalHaber the totalHaber to set
	 */
	public void setTotalHaber(double totalHaber) {
		this.totalHaber = totalHaber;
	}
	/**
	 * @return the mes
	 */
	public String getMes() {
		return mes;
	}
	/**
	 * @param mes the mes to set
	 */
	public void setMes(String mes) {
		this.mes = mes;
	}

	/**
	 * @return the cCajaBanco
	 */
	public String getcCajaBanco() {
		return librodiario.getcCajaBanco();
	}

	/**
	 * @param cCajaBanco the cCajaBanco to set
	 */
	public void setcCajaBanco(String cCajaBanco) {
		this.librodiario.setcCajaBanco(cCajaBanco);
	}
	/**
	 * @return the totalfMontoSaldoD
	 */
	public double getTotalfMontoSaldoD() {
		return totalfMontoSaldoD;
	}
	/**
	 * @param totalfMontoSaldoD the totalfMontoSaldoD to set
	 */
	public void setTotalfMontoSaldoD(double totalfMontoSaldoD) {
		this.totalfMontoSaldoD = totalfMontoSaldoD;
	}
	/**
	 * @return the totalfMontoSaldoH
	 */
	public double getTotalfMontoSaldoH() {
		return totalfMontoSaldoH;
	}
	/**
	 * @param totalfMontoSaldoH the totalfMontoSaldoH to set
	 */
	public void setTotalfMontoSaldoH(double totalfMontoSaldoH) {
		this.totalfMontoSaldoH = totalfMontoSaldoH;
	}
	/**
	 * @return the totalfMontoBalanceA
	 */
	public double getTotalfMontoBalanceA() {
		return totalfMontoBalanceA;
	}
	/**
	 * @param totalfMontoBalanceA the totalfMontoBalanceA to set
	 */
	public void setTotalfMontoBalanceA(double totalfMontoBalanceA) {
		this.totalfMontoBalanceA = totalfMontoBalanceA;
	}
	/**
	 * @return the totalfMontoBalanceP
	 */
	public double getTotalfMontoBalanceP() {
		return totalfMontoBalanceP;
	}
	/**
	 * @param totalfMontoBalanceP the totalfMontoBalanceP to set
	 */
	public void setTotalfMontoBalanceP(double totalfMontoBalanceP) {
		this.totalfMontoBalanceP = totalfMontoBalanceP;
	}
	/**
	 * @return the totalCompraVenta
	 */
	public double getTotalCompraVenta() {
		return totalCompraVenta;
	}
	/**
	 * @param totalCompraVenta the totalCompraVenta to set
	 */
	public void setTotalCompraVenta(double totalCompraVenta) {
		this.totalCompraVenta = totalCompraVenta;
	}
	
	
	/**
	 * @return the subTotalCompraVenta
	 */
	public double getSubTotalCompraVenta() {
		return subTotalCompraVenta;
	}
	/**
	 * @param subTotalCompraVenta the subTotalCompraVenta to set
	 */
	public void setSubTotalCompraVenta(double subTotalCompraVenta) {
		this.subTotalCompraVenta = subTotalCompraVenta;
	}
	/**
	 * @return the igvCompraVenta
	 */
	public double getIgvCompraVenta() {
		return igvCompraVenta;
	}
	/**
	 * @param igvCompraVenta the igvCompraVenta to set
	 */
	public void setIgvCompraVenta(double igvCompraVenta) {
		this.igvCompraVenta = igvCompraVenta;
	}
	/**
	 * @return the igvActual
	 */
	public String getIgvActual() {
		return igvActual;
	}
	/**
	 * @param igvActual the igvActual to set
	 */
	public void setIgvActual(String igvActual) {
		this.igvActual = igvActual;
	}

	
	/**
	 * @return the iPeriodoId
	 */
	public int getiPeriodoId() {
		int iPeriodoId= getIngresoProducto().getiPeriodoId();
		if(iPeriodoId<0){
			planilla.getiPeriodoId();
		}
		return iPeriodoId;
	}

	/**
	 * @param iPeriodoId the iPeriodoId to set
	 */
	public void setiPeriodoId(int iPeriodoId) {
		 
		this.getIngresoProducto().setiPeriodoId(iPeriodoId);
		this.planilla.setiPeriodoId(iPeriodoId);
	}
	
	/**
	 * @return the iPlanillaId
	 */
	public int getiPlanillaId() {
		return planilla.getiPlanillaId();
	}

	/**
	 * @param iPlanillaId the iPlanillaId to set
	 */
	public void setiPlanillaId(int iPlanillaId) {
		this.planilla.setiPlanillaId(iPlanillaId);
	}



	/**
	 * @return the fApoESSALUD
	 */
	public float getfApoESSALUD() {
		return planilla.getfApoESSALUD();
	}

	/**
	 * @param fApoESSALUD the fApoESSALUD to set
	 */
	public void setfApoESSALUD(float fApoESSALUD) {
		this.planilla.setfApoESSALUD(fApoESSALUD);
	}

	/**
	 * @return the fApoIES
	 */
	public float getfApoIES() {
		return planilla.getfApoIES();
	}

	/**
	 * @param fApoIES the fApoIES to set
	 */
	public void setfApoIES(float fApoIES) {
		this.planilla.setfApoIES(fApoIES);
	}

	/**
	 * @return the fAsignacionFamiliar
	 */
	public float getfAsignacionFamiliar() {
		return planilla.getfAsignacionFamiliar();
	}

	/**
	 * @param fAsignacionFamiliar the fAsignacionFamiliar to set
	 */
	public void setfAsignacionFamiliar(float fAsignacionFamiliar) {
		this.planilla.setfAsignacionFamiliar(fAsignacionFamiliar);
	}

	/**
	 * @return the fDesAFP
	 */
	public float getfDesAFP() {
		return planilla.getfDesAFP();
	}

	/**
	 * @param fDesAFP the fDesAFP to set
	 */
	public void setfDesAFP(float fDesAFP) {
		this.planilla.setfDesAFP(fDesAFP);
	}

	/**
	 * @return the fDesCV
	 */
	public float getfDesCV() {
		return planilla.getfDesCV();
	}

	/**
	 * @param fDesCV the fDesCV to set
	 */
	public void setfDesCV(float fDesCV) {
		this.planilla.setfDesCV(fDesCV);
	}

	/**
	 * @return the fDesPS
	 */
	public float getfDesPS() {
		return planilla.getfDesPS();
	}

	/**
	 * @param fDesPS the fDesPS to set
	 */
	public void setfDesPS(float fDesPS) {
		this.planilla.setfDesPS(fDesPS);
	}

	/**
	 * @return the fDesSNP
	 */
	public float getfDesSNP() {
		return planilla.getfDesSNP();
	}

	/**
	 * @param fDesSNP the fDesSNP to set
	 */
	public void setfDesSNP(float fDesSNP) {
		this.planilla.setfDesSNP(fDesSNP);
	}

	/**
	 * @return the fNetoPago
	 */
	public float getfNetoPago() {
		return planilla.getfNetoPago();
	}

	/**
	 * @param fNetoPago the fNetoPago to set
	 */
	public void setfNetoPago(float fNetoPago) {
		this.planilla.setfNetoPago(fNetoPago);
	}

	/**
	 * @return the fPorApoESSALUD
	 */
	public float getfPorApoESSALUD() {
		return planilla.getfPorApoESSALUD();
	}

	/**
	 * @param fPorApoESSALUD the fPorApoESSALUD to set
	 */
	public void setfPorApoESSALUD(float fPorApoESSALUD) {
		this.planilla.setfPorApoESSALUD(fPorApoESSALUD);
	}

	/**
	 * @return the fPorApoIES
	 */
	public float getfPorApoIES() {
		return planilla.getfPorApoIES();
	}

	/**
	 * @param fPorApoIES the fPorApoIES to set
	 */
	public void setfPorApoIES(float fPorApoIES) {
		this.planilla.setfPorApoIES(fPorApoIES);
	}

	/**
	 * @return the fPorDesAFP
	 */
	public float getfPorDesAFP() {
		return planilla.getfPorDesAFP();
	}

	/**
	 * @param fPorDesAFP the fPorDesAFP to set
	 */
	public void setfPorDesAFP(float fPorDesAFP) {
		this.planilla.setfPorDesAFP(fPorDesAFP);
	}

	/**
	 * @return the fPorDesCV
	 */
	public float getfPorDesCV() {
		return planilla.getfPorDesCV();
	}

	/**
	 * @param fPorDesCV the fPorDesCV to set
	 */
	public void setfPorDesCV(float fPorDesCV) {
		this.planilla.setfPorDesCV(fPorDesCV) ;
	}

	/**
	 * @return the fPorDesPS
	 */
	public float getfPorDesPS() {
		return planilla.getfPorDesPS();
	}

	/**
	 * @param fPorDesPS the fPorDesPS to set
	 */
	public void setfPorDesPS(float fPorDesPS) {
		this.planilla.setfPorDesPS(fPorDesPS);
	}

	/**
	 * @return the fPorDesSNP
	 */
	public float getfPorDesSNP() {
		return planilla.getfPorDesSNP();
	}

	/**
	 * @param fPorDesSNP the fPorDesSNP to set
	 */
	public void setfPorDesSNP(float fPorDesSNP) {
		this.planilla.setfPorDesSNP(fPorDesSNP);
	}

	/**
	 * @return the fSueldo
	 */
	public float getfSueldo() {
		return planilla.getfSueldo();
	}

	/**
	 * @param fSueldo the fSueldo to set
	 */
	public void setfSueldo(float fSueldo) {
		this.planilla.setfSueldo(fSueldo);
	}

	/**
	 * @return the fTotalAportes
	 */
	public float getfTotalAportes() {
		return planilla.getfTotalAportes();
	}

	/**
	 * @param fTotalAportes the fTotalAportes to set
	 */
	public void setfTotalAportes(float fTotalAportes) {
		this.planilla.setfTotalAportes(fTotalAportes);
	}

	/**
	 * @return the fTotalDescuento
	 */
	public float getfTotalDescuento() {
		return planilla.getfTotalDescuento();
	}

	/**
	 * @param fTotalDescuento the fTotalDescuento to set
	 */
	public void setfTotalDescuento(float fTotalDescuento) {
		this.planilla.setfTotalDescuento(fTotalDescuento);
	}

	/**
	 * @return the fTotalRemuneracion
	 */
	public float getfTotalRemuneracion() {
		return planilla.getfTotalRemuneracion();
	}

	/**
	 * @param fTotalRemuneracion the fTotalRemuneracion to set
	 */
	public void setfTotalRemuneracion(float fTotalRemuneracion) {
		this.planilla.setfTotalRemuneracion(fTotalRemuneracion);
	}

	
	public Personal getPersonal(){
		 Personal personal = planilla.getPersonal();
		 if(personal==null){
			 personal= new Personal();
			 planilla.setPersonal(personal);
		 }
		 return planilla.getPersonal();
	}

	public void setPersonal(Personal personal) {
		this.planilla.setPersonal(personal);
	}
	
	/**
	 * @return the cPersonalCodigo
	 */
	public String getcPersonalCodigo() {		 
		return getPersonal().getcPersonalCodigo();
	}

	/**
	 * @param cPersonalCodigo the cPersonalCodigo to set
	 */
	public void setcPersonalCodigo(String cPersonalCodigo) {
	}
	
   /**
	 * @return the vPersonalNombres
	 */
	public String getvPersonalNombres() {
		Personal personal = getPersonal();	
		if(personal.getvPersonalNombres()!=null){
			vPersonalNombres = personal.getvPersonalNombres()+" "+personal.getvPersonalApellidoPaterno();
		}
		return vPersonalNombres;
	}

	
	/**
	 * @param vPersonalNombres the vPersonalNombres to set
	 */
	public void setvPersonalNombres(String vPersonalNombres) {
		this.vPersonalNombres = vPersonalNombres;
	}
	
	/**
	 * @return the persona
	 */
	public int getiPersonalId() {
		return getPersonal().getiPersonalId();
	}

	/**
	 * @param persona the persona to set
	 */
	public void setiPersonalId(int iPersonalId) {
		Personal personal = getPersonal();//new Proveedor();
		if(personal==null)
			personal = new  Personal();
		   personal.setiPersonalId(iPersonalId);		
		this.planilla.setPersonal(personal);
	}
	
	
	/**
	 * @return the planilla
	 */
	public Planilla getPlanilla() {
		return planilla;
	}
	/**
	 * @param planilla the planilla to set
	 */
	public void setPlanilla(Planilla planilla) {
		this.planilla = planilla;
	}
	
	/**
	 * @return the vOcupacionDescripcion
	 */
	public String getvOcupacionDescripcion() {
		Personal personal = getPersonal();	
		if(personal.getOcupacion()!=null){
			vOcupacionDescripcion = personal.getOcupacion().getvOcupacionDescripcion();
		}
		return vOcupacionDescripcion;
	
	}

	/**
	 * @param vOcupacionDescripcion the vOcupacionDescripcion to set
	 */
	public void setvOcupacionDescripcion(String vOcupacionDescripcion) {
		this.vOcupacionDescripcion = vOcupacionDescripcion;
	}
	
}
