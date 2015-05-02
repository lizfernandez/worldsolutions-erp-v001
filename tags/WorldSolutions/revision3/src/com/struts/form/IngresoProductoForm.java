package com.struts.form;


import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import org.apache.struts.action.ActionForm;

import com.dao.IngresoProductoDao;
import com.entities.Ingresoproductodevolucion;
import com.entities.Proveedor;
import com.entities.Formapago;
import com.entities.Ingresoproducto;
import com.entities.Ingresoproductodetalle;
import com.entities.Tipodocumento;

import com.entities.Tipodocumentogestion;
import com.util.Fechas;



public class IngresoProductoForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List lista;	
	Ingresoproducto ingresoProducto = new Ingresoproducto();
	Ingresoproductodevolucion ingresoProductoDev = new Ingresoproductodevolucion();
    private String mode;
    private List paginas;
    private int pagInicio;
	private float pagoTotal;
    private BigDecimal nProveedorNumeroDocumento;
    private String vProveedorRazonSocial;
    private String cProveedorCodigo;
    
	private String vProveedorDireccion;
	private String cPersonalCodigo;
	private String vPersonalNombres;
	private int iclasificacionId;
	private String vImprimir;
	private String vTipoImpresion;
	/*************************/
	/**SESIONES DE INPUESTOS**/
	/*************************/
	private String tipoMoneda;
	private String IGVCompra;
	private String IGVPercepcion;
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
	 * @return the ingresoProducto
	 */

	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
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

	public IngresoProductoDao ingresoProductoDao(){
		IngresoProductoDao ingresasoDao = new IngresoProductoDao();
		return ingresasoDao;
	}

	/**
	 * @return the cProveedorCodigo
	 */
	public String getcProveedorCodigo() {
		return getProveedor().getcProveedorCodigo();
	}

	/**
	 * @param cProveedorCodigo the cProveedorCodigo to set
	 */
	public void setcProveedorCodigo(String vProveedorCodigo) {
		this.cProveedorCodigo = vProveedorCodigo;
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
	 * @return the iIngresoProductoDevolucionId
	 */
	public int getiIngresoProductoDevolucionId() {
		return ingresoProductoDev.getiIngresoProductoDevolucionId();
	}

	/**
	 * @param iIngresoProductoDevolucionId the iIngresoProductoDevolucionId to set
	 */
	public void setiIngresoProductoDevolucionId(int iIngresoProductoDevolucionId) {
		this.ingresoProductoDev.setiIngresoProductoDevolucionId(iIngresoProductoDevolucionId);
	}
	/**
	 * @return the cEstadoCodigo
	 */
	public String getcEstadoCodigo() {
		return ingresoProducto.getcEstadoCodigo();
	}

	/**
	 * @param cEstadoCodigo the cEstadoCodigo to set
	 */
	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.ingresoProducto.setcEstadoCodigo ( cEstadoCodigo);
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
	
	public Formapago getFormapago(){
		Formapago formaPago = ingresoProducto.getFormaPago();
		
		if(formaPago==null)
			formaPago= new Formapago();
		return formaPago;
		
	}

	/**
	 * @return the iFormaPagoId
	 */
	public int getiFormaPago() {
		Formapago formaPago = getFormapago();	
		return formaPago.getiFormaPago();	
	}

	/**
	 * @param iFormaPagoId the iFormaPagoId to set
	 */
	public void setiFormaPago(int iFormaPagoId) {	
		this.ingresoProducto.setFormaPago(ingresoProductoDao().findEndidad(getFormapago(), iFormaPagoId));
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
		Proveedor proveedor= getProveedor();
		return proveedor.getiProveedorId();
	}

	/**
	 * @param iProveedorId the iProveedorId to set
	 */
	public void setiProveedorId(int iProveedorId) {			
		ingresoProducto.setProveedor(ingresoProductoDao().findEndidad(getProveedor(), iProveedorId));
	}
	
	
	/**
	 * @return the proveedor
	 */
	public Proveedor getProveedor() {
		Proveedor proveedor = ingresoProducto.getProveedor();
		if(proveedor==null){
			proveedor = new Proveedor();
			ingresoProducto.setProveedor(proveedor);
		}
		return ingresoProducto.getProveedor();
	}

	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(Proveedor proveedor) {		
		this.ingresoProducto.setProveedor(proveedor);
	}
	

	
	
	/**
	 * @return the nProveedorNumeroDocumento
	 */
	public BigDecimal getnProveedorNumeroDocumento() {	
		
		return getProveedor().getnProveedorNumeroDocumento(); 
	}

	/**
	 * @param nProveedorNumeroDocumento the nProveedorNumeroDocumento to set
	 */
	public void setnProveedorNumeroDocumento(BigDecimal nProveedorNumeroDocumento) {
		this.nProveedorNumeroDocumento = nProveedorNumeroDocumento;
	}


	/**
	 * @return the vProveedorRazonSocial
	 */
	public String getvProveedorRazonSocial() {
		return getProveedor().getvProveedorRazonSocial();
	}

	/**
	 * @param vProveedorRazonSocial the vProveedorRazonSocial to set
	 */
	public void setvProveedorRazonSocial(String vProveedorRazonSocial) {
		this.vProveedorRazonSocial = vProveedorRazonSocial;
	}
     
	public Tipodocumentogestion getTipodocumentogestion(){
		Tipodocumentogestion tipoDoc =  ingresoProducto.getTipodocumento();	
		if(tipoDoc==null)
			tipoDoc = new Tipodocumentogestion();
		return tipoDoc;
	}
	
	/**
	 * @return the tipodocumento
	 */
	public int getiTipoDocumentoId() {
	Tipodocumentogestion tipoDoc =  getTipodocumentogestion();
		return tipoDoc.getiTipoDocumentoGestionId();
	}

	/**
	 * @param tipodocumento the tipodocumento to set
	 */
	public void setiTipoDocumentoId(int iTipoDocumentoGestionId) {	
		this.ingresoProducto.setTipodocumento(ingresoProductoDao().findEndidad(getTipodocumentogestion(), iTipoDocumentoGestionId));
	}

	/**
	 * @return the ingresoproductodetalles
	 */
	public List<Ingresoproductodetalle> getIngresoproductodetalles() {
		return ingresoProducto.getIngresoproductodetalles();
	}

	/**
	 * @param ingresoproductodetalles the ingresoproductodetalles to set
	 */
	public void setIngresoproductodetalles(
			List<Ingresoproductodetalle> ingresoproductodetalles) {
		this.ingresoProducto.setIngresoproductodetalles(ingresoproductodetalles);
	}
	/**
	 * @return the pagoTotal
	 */
	public float getPagoTotal() {
		return pagoTotal;
	}
	/**
	 * @param pagoTotal the pagoTotal to set
	 */
	public void setPagoTotal(float pagoTotal) {
		this.pagoTotal = pagoTotal;
	}
	/**
	 * @return the vProveedorDireccion
	 */
	public String getvProveedorDireccion() {
		return vProveedorDireccion;
	}
	/**
	 * @param vProveedorDireccion the vProveedorDireccion to set
	 */
	public void setvProveedorDireccion(String vProveedorDireccion) {
		this.vProveedorDireccion = vProveedorDireccion;
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
	
	
	/**
	 * @return the vEstadoDocumento
	 */
	public String getvEstadoDocumento() {
		return ingresoProducto.getvEstadoDocumento();
	}

	/**
	 * @param vEstadoDocumento the vEstadoDocumento to set
	 */
	public void setvEstadoDocumento(String vEstadoDocumento) {
		this.ingresoProducto.setvEstadoDocumento (vEstadoDocumento);
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
	/**
	 * @return the ingresoProductoDev
	 */
	public Ingresoproductodevolucion getIngresoProductoDev() {
		return ingresoProductoDev;
	}
	/**
	 * @param ingresoProductoDev the ingresoProductoDev to set
	 */
	public void setIngresoProductoDev(Ingresoproductodevolucion ingresoProductoDev) {
		this.ingresoProductoDev = ingresoProductoDev;
	}
	

	/**
	 * @return the dIngresoProductoDevFecha
	 */
	public String getdIngresoProductoDevFecha() {
		String fechaIngresoProducto = "";
		if(ingresoProductoDev.getdIngresoProductoDevFecha()!=null)
			fechaIngresoProducto = Fechas.fechaDDMMYY(ingresoProductoDev.getdIngresoProductoDevFecha());
		else
			fechaIngresoProducto = Fechas.fechaDDMMYY(Fechas.getDate());
		return fechaIngresoProducto;
	
	}

	/**
	 * @param dIngresoProductoDevFecha the dIngresoProductoDevFecha to set
	 */
	public void setdIngresoProductoDevFecha(Date dIngresoProductoDevFecha) {
		this.ingresoProductoDev.setdIngresoProductoDevFecha(dIngresoProductoDevFecha);
	}

	
	/**
	 * @return the fIngresoProductoDev
	 */
	public float getfIngresoProductoDev() {
		return this.ingresoProductoDev.getfIngresoProductoDev();
	}

	/**
	 * @param fIngresoProductoDev the fIngresoProductoDev to set
	 */
	public void setfIngresoProductoDev(float fIngresoProductoDev) {
		this.ingresoProductoDev.setfIngresoProductoDev (fIngresoProductoDev);
	}

	/**
	 * @return the fIngresoProductoDevIGV
	 */
	public float getfIngresoProductoDevIGV() {
		return this.ingresoProductoDev.getfIngresoProductoDevIGV();
	}

	/**
	 * @param fIngresoProductoDevIGV the fIngresoProductoDevIGV to set
	 */
	public void setfIngresoProductoDevIGV(float fIngresoProductoDevIGV) {
		this.ingresoProductoDev.setfIngresoProductoDevIGV (fIngresoProductoDevIGV);
	}

	/**
	 * @return the fIngresoProductoDevSubTotal
	 */
	public float getfIngresoProductoDevSubTotal() {
		return this.ingresoProductoDev.getfIngresoProductoDevSubTotal();
	}

	/**
	 * @param fIngresoProductoDevSubTotal the fIngresoProductoDevSubTotal to set
	 */
	public void setfIngresoProductoDevSubTotal(float fIngresoProductoDevSubTotal) {
		
		this.ingresoProductoDev.setfIngresoProductoDevSubTotal (fIngresoProductoDevSubTotal);
	}
	
	/**
	 * @return the tipoMoneda
	 */
	public String getTipoMoneda() {
		return tipoMoneda;
	}
	/**
	 * @param tipoMoneda the tipoMoneda to set
	 */
	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}
	/**
	 * @return the iGVCompra
	 */
	public String getIGVCompra() {
		return IGVCompra;
	}
	/**
	 * @param iGVCompra the iGVCompra to set
	 */
	public void setIGVCompra(String iGVCompra) {
		IGVCompra = iGVCompra;
	}
	/**
	 * @return the fPercepcion
	 */
	public float getfPercepcion() {
		return getIngresoProducto().getfPercepcion();
	}

	/**
	 * @param fPercepcion the fPercepcion to set
	 */
	public void setfPercepcion(float fPercepcion) {
		this.getIngresoProducto().setfPercepcion(fPercepcion) ;
	}

	/**
	 * @return the iNumeroDias
	 */
	public int getiNumeroDias() {
		return getIngresoProducto().getiNumeroDias();
	}

	/**
	 * @param iNumeroDias the iNumeroDias to set
	 */
	public void setiNumeroDias(int iNumeroDias) {
		this.getIngresoProducto().setiNumeroDias(iNumeroDias) ;
	}

	/**
	 * @return the iNumeroLetras
	 */
	public int getiNumeroLetras() {
		return getIngresoProducto().getiNumeroLetras();
	}

	/**
	 * @param iNumeroLetras the iNumeroLetras to set
	 */
	public void setiNumeroLetras(int iNumeroLetras) {
		this.getIngresoProducto().setiNumeroLetras(iNumeroLetras);
	}

	/**
	 * @return the dFechaProximoPago
	 */
	public String getdFechaProximoPago() {
		return Fechas.fechaDDMMYY(getIngresoProducto().getdFechaProximoPago());
	}

	/**
	 * @param dFechaProximoPago the dFechaProximoPago to set
	 * @throws ParseException 
	 */
	public void setdFechaProximoPago(String dFechaProximoPago) throws ParseException {
		Date fecha = Fechas.getDate();		
		if(dFechaProximoPago!="")
				fecha =	Fechas.sumarFechasDias(Fechas.fechaDate(dFechaProximoPago), getiNumeroDias());
			else 
				fecha =Fechas.sumarFechasDias(fecha, getiNumeroDias());
		
	
		this.getIngresoProducto().setdFechaProximoPago(fecha) ;
	}

	/**
	 * @return the fMontoAdelantado
	 */
	public float getfMontoAdelantado() {
		return getIngresoProducto().getfMontoAdelantado();
	}

	/**
	 * @param fMontoAdelantado the fMontoAdelantado to set
	 */
	public void setfMontoAdelantado(float fMontoAdelantado) {
		this.getIngresoProducto().setfMontoAdelantado(fMontoAdelantado);
	}
	/**
	 * @return the iGVPercepcion
	 */
	public String getIGVPercepcion() {
		return IGVPercepcion;
	}
	/**
	 * @param iGVPercepcion the iGVPercepcion to set
	 */
	public void setIGVPercepcion(String iGVPercepcion) {
		IGVPercepcion = iGVPercepcion;
	}
	
	/**
	 * @return the fDescuento
	 */
	public float getfDescuento() {
		return getIngresoProducto().getfDescuento();
	}

	/**
	 * @param fDescuento the fDescuento to set
	 */
	public void setfDescuento(float fDescuento) {
		this.getIngresoProducto().setfDescuento(fDescuento);
	}
	/**
	 * @return the fIngresoProductoTotalReal
	 */
	public float getfIngresoProductoTotalReal() {
		return getIngresoProducto().getfIngresoProductoTotalReal();
	}

	/**
	 * @param fIngresoProductoTotalReal the fIngresoProductoTotalReal to set
	 */
	public void setfIngresoProductoTotalReal(float fIngresoProductoTotalReal) {
		this.getIngresoProducto().setfIngresoProductoTotalReal(fIngresoProductoTotalReal);
	}
	
	/**
	 * @return the iPeriodoId
	 */
	public int getiPeriodoId() {
		return this.getIngresoProducto().getiPeriodoId();
	}

	/**
	 * @param iPeriodoId the iPeriodoId to set
	 */
	public void setiPeriodoId(int iPeriodoId) {
		this.getIngresoProducto().setiPeriodoId(iPeriodoId);
	}
	/**
	 * @return the fMontoPago
	 */
	public float getfMontoPago() {
		return getIngresoProducto().getfMontoPago();
	}

	/**
	 * @param fMontoPago the fMontoPago to set
	 */
	public void setfMontoPago(float fMontoPago) {
		this.getIngresoProducto().setfMontoPago(fMontoPago);
	}

	/**
	 * @return the fTipoCambio
	 */
	public float getfTipoCambio() {
		return getIngresoProducto().getfTipoCambio();
	}

	/**
	 * @param fTipoCambio the fTipoCambio to set
	 */
	public void setfTipoCambio(float fTipoCambio) {
		this.getIngresoProducto().setfTipoCambio(fTipoCambio) ;
	}

	/**
	 * @return the fMontoVuelto
	 */
	public float getfMontoVuelto() {
		return getIngresoProducto().getfMontoVuelto();
	}

	/**
	 * @param fMontoVuelto the fMontoVuelto to set
	 */
	public void setfMontoVuelto(float fMontoVuelto) {
		this.getIngresoProducto().setfMontoVuelto(fMontoVuelto) ;
	}

	/**
	 * @return the vTipoPago
	 */
	public String getvTipoPago() {
		return getIngresoProducto().getvTipoPago();
	}

	/**
	 * @param vTipoPago the vTipoPago to set
	 */
	public void setvTipoPago(String vTipoPago) {
		this.getIngresoProducto().setvTipoPago(vTipoPago);
	}

	/**
	 * @return the vTipoCompra
	 */
	public String getvTipoCompra() {
		return getIngresoProducto().getvTipoCompra();
	}

	/**
	 * @param vTipoCompra the vTipoCompra to set
	 */
	public void setvTipoCompra(String vTipoCompra) {
		this.getIngresoProducto().setvTipoCompra(vTipoCompra);
	}

	/**
	 * @return the fDescProveedorCompra
	 */
	public float getfDescProveedorCompra() {
		return getIngresoProducto().getfDescProveedorCompra();
	}

	/**
	 * @param fDescProveedorCompra the fDescProveedorCompra to set
	 */
	public void setfDescProveedorCompra(float fDescProveedorCompra) {
		this.getIngresoProducto().setfDescProveedorCompra(fDescProveedorCompra);
	}

	/**
	 * @return the vIncluyeIGV
	 */
	public String getvIncluyeIGV() {
		return getIngresoProducto().getvIncluyeIGV();
	}

	/**
	 * @param vIncluyeIGV the vIncluyeIGV to set
	 */
	public void setvIncluyeIGV(String vIncluyeIGV) {
		this.getIngresoProducto().setvIncluyeIGV(vIncluyeIGV);
	}

	/**
	 * @return the nNroNotaDebito
	 */
	public String getnNroNotaDebito() {
		return getIngresoProductoDev().getnNroNotaDebito();
	}

	/**
	 * @param nNroNotaDebito the nNroNotaDebito to set
	 */
	public void setnNroNotaDebito(String nNroNotaDebito) {
		this.getIngresoProductoDev().setnNroNotaDebito(nNroNotaDebito);
	}
	/**
	 * @return the vImprimir
	 */
	public String getvImprimir() {
		return vImprimir;
	}
	/**
	 * @param vImprimir the vImprimir to set
	 */
	public void setvImprimir(String vImprimir) {
		this.vImprimir = vImprimir;
	}
	/**
	 * @return the vTipoImpresion
	 */
	public String getvTipoImpresion() {
		return vTipoImpresion;
	}
	/**
	 * @param vTipoImpresion the vTipoImpresion to set
	 */
	public void setvTipoImpresion(String vTipoImpresion) {
		this.vTipoImpresion = vTipoImpresion;
	}

	
}
