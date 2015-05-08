package com.struts.form;


import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.dao.VentaDao;
import com.entities.Formapago;

import com.entities.Mediopago;
import com.entities.Venta;
import com.entities.Ventadetalle;

import com.entities.Cliente;

import com.entities.Tipodocumentogestion;
import com.entities.Ventadevolucion;
import com.util.Fechas;



public class VentaForm extends  ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List lista;	
	Venta venta = new Venta();
	Ventadevolucion ventaDev = new Ventadevolucion();
    private String mode;
    private String metodo;
    private List paginas;
    private int pagInicio;
	private float pagoTotal;
	private String vClienteDireccion;
	private String cPersonalCodigo;
	private String vPersonalNombres;
	private String vClasificacion;
	private int iclasificacionId;
	private String vImprimir;
	private String vTipoImpresion;
	private String vTextoImpresion;
	/*************************/
	/**SESIONES DE INPUESTOS**/
	/*************************/
	private String tipoMoneda;
	private String IGVVentas;
	private String identificador;	
	private int iSucursalId;
   
	
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
	 * @return the venta
	 */

	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
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

    public VentaDao ventaDao(){
    	VentaDao ventaDao = new VentaDao();
    	return ventaDao;
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
	 * @return the cEstadoCodigo
	 */
	public String getcEstadoCodigo() {
		return venta.getcEstadoCodigo();
	}

	/**
	 * @param cEstadoCodigo the cEstadoCodigo to set
	 */
	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.venta.setcEstadoCodigo ( cEstadoCodigo);
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
	 * @return the fVentaIGV
	 */
	public float getfVentaIGV() {
		return venta.getfVentaIGV();
	}

	/**
	 * @param fVentaIGV the fVentaIGV to set
	 */
	public void setfVentaIGV(float fVentaIGV) {
		this.venta.setfVentaIGV ( fVentaIGV);
	}

	/**
	 * @return the fVentaSubTotal
	 */
	public float getfVentaSubTotal() {
		return venta.getfVentaSubTotal();
	}

	/**
	 * @param fVentaSubTotal the fVentaSubTotal to set
	 */
	public void setfVentaSubTotal(float fVentaSubTotal) {
		this.venta.setfVentaSubTotal(fVentaSubTotal);
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
	 * @return the vPrincipal
	 */
	public String getvPrincipal() {
		return venta.getvPrincipal();
	}

	/**
	 * @param vPrincipal the vPrincipal to set
	 */
	public void setvPrincipal(String vPrincipal) {
		this.venta.setvPrincipal (vPrincipal);
	}
  
	
	/**
	 * @return the iClienteId
	 */
	public int getiClienteId() {		
		return getCliente().getiClienteId();
	}

	/**
	 * @param iClienteId the iClienteId to set
	 */
	public void setiClienteId(int iClienteId) {
		this.venta.setCliente(ventaDao().findEndidad(getCliente(), iClienteId));
		
	}
	
	
	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		Cliente cliente = venta.getCliente();
		if(cliente==null){
			cliente = new Cliente();
			venta.setCliente(cliente);			
		}
		return venta.getCliente();
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.venta.setCliente(cliente);
	}
	

	/**
	 * @return the cClienteCodigo
	 */
	public String getvClienteCodigo() {
				return  getCliente().getvClienteCodigo();
	}

	/**
	 * @param cClienteCodigo the cClienteCodigo to set
	 */
	public void setvClienteCodigo(String vClienteCodigo) {
		Cliente cliente =getCliente();
		cliente.setvClienteCodigo(vClienteCodigo);
		this.venta.setCliente(cliente);
	}
	
	/**
	 * @return the nClienteNumeroDocumento
	 */
	public BigDecimal getnClienteNumeroDocumento() {	
		return getCliente().getnClienteNumeroDocumento(); 
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
			return getCliente().getvClienteRazonSocial();
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
	 * @return the vClasificacion
	 */
	public String getvClasificacion() {
		return this.vClasificacion;
	}
	
	
	/**
	 * @param vClasificacion the vClasificacion to set
	 */
	public void setvClasificacion(String vClasificacion) {
		this.vClasificacion = vClasificacion;
	}
	/**
	 * @return the fDescuentoCliente
	 */
	public float getfDescuentoCliente() {
		return getCliente().getfDescuento();
	}
	
	/**
	 * @return the tipodocumento
	 */
	public int getiTipoDocumentoId() {    ;
		return  getTipoDocumento().getiTipoDocumentoGestionId();
	}

	/**
	 * @param tipodocumento the tipodocumento to set
	 */
	public void setiTipoDocumentoId(int iTipoDocumentoGestionId) {			
		this.venta.setTipoDocumento(ventaDao().findEndidad(getTipoDocumento(), iTipoDocumentoGestionId));
	}

	/**
	 * @return the ingresoproductodetalles
	 */
	public List<Ventadetalle> getVentadetalles() {
		return venta.getVentadetalles();
	}

	/**
	 * @param ingresoproductodetalles the ingresoproductodetalles to set
	 */
	public void setVentadetalles(List<Ventadetalle> ingresoproductodetalles) {
		this.venta.setVentadetalles(ingresoproductodetalles);
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
	 * @return the iFormaPagoId
	 */
	public int getiFormaPago() {
		return getFormaPago().getiFormaPago();
	}

	/**
	 * @param iFormaPagoId the iFormaPagoId to set
	 */
	public void setiFormaPago(int iFormaPagoId) {	
		this.venta.setFormaPago(ventaDao().findEndidad(getFormaPago(), iFormaPagoId));
	}
	

	/**
	 * @return the formaPago
	 */
	public Formapago getFormaPago(){
		Formapago formaPago = venta.getFormaPago();
		if(formaPago==null){
			formaPago= new Formapago();
			venta.setFormaPago(formaPago);
		}
		return venta.getFormaPago();
	}
	/**
	 * @param formaPago the formaPago to set
	 */
	public void setFormaPago(Formapago formaPago) {
		this.venta.setFormaPago(formaPago);
	}

	/**
	 * @return the tipoDocumento
	 */
	public Tipodocumentogestion getTipoDocumento() {
		Tipodocumentogestion Tipodocumentogestion = venta.getTipoDocumento();
		if(Tipodocumentogestion==null){
			Tipodocumentogestion = new Tipodocumentogestion();
			venta.setTipoDocumento(Tipodocumentogestion);
		} 
		return venta.getTipoDocumento();
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(Tipodocumentogestion tipoDocumento) {
		this.venta.setTipoDocumento(tipoDocumento);
	}
	

	/**
	 * @return the vVentaPuntoLlegada
	 */
	public String getvVentaPuntoLlegada() {
		return venta.getvVentaPuntoLlegada();
	}

	/**
	 * @param vVentaPuntoLlegada the vVentaPuntoLlegada to set
	 * @throws UnsupportedEncodingException 
	 */
	public void setvVentaPuntoLlegada(String vVentaPuntoLlegada) throws UnsupportedEncodingException {

		this.venta.setvVentaPuntoLlegada(new String(vVentaPuntoLlegada.getBytes("ISO-8859-1"), "UTF-8"));
	}
	
	/**
	 * @return the cVentaOrdenCompra
	 */
	public String getcVentaOrdenCompra() {
		return  venta.getcVentaOrdenCompra();
	}

	/**
	 * @param cVentaOrdenCompra the cVentaOrdenCompra to set
	 */
	public void setcVentaOrdenCompra(String cVentaOrdenCompra) {
		this.venta.setcVentaOrdenCompra(cVentaOrdenCompra);
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
	 * @return the dFechaTraslado
	 */
	public Date getdFechaTraslado() {
		return venta.getdFechaTraslado();
	}

	/**
	 * @param dFechaTraslado the dFechaTraslado to set
	 */
	public void setdFechaTraslado(Date dFechaTraslado) {
		this.venta.setdFechaTraslado(dFechaTraslado);
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
		return this.venta.getvEstadoDocumento();
	}

	/**
	 * @param vEstadoDocumento the vEstadoDocumento to set
	 */
	public void setvEstadoDocumento(String vEstadoDocumento) {
		this.venta.setvEstadoDocumento ( vEstadoDocumento);
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
	 * @return the ventaDev
	 */
	public Ventadevolucion getVentaDev() {
		return ventaDev;
	}
	/**
	 * @param ventaDev the ventaDev to set
	 */
	public void setVentaDev(Ventadevolucion ventaDev) {
		this.ventaDev = ventaDev;
	}

	/**
	 * @return the dVentaDevFecha
	 */
	public String getdVentaDevFecha() {
		String fechaVenta = "";
		if(ventaDev.getdVentaDevFecha()!=null)
			fechaVenta = Fechas.fechaDDMMYY(ventaDev.getdVentaDevFecha());
		else
			fechaVenta = Fechas.fechaDDMMYY(Fechas.getDate());
		return fechaVenta;
	
	}

	/**
	 * @param dVentaDevFecha the dVentaDevFecha to set
	 */
	public void setdVentaDevFecha(Date dVentaDevFecha) {
		this.ventaDev.setdVentaDevFecha(dVentaDevFecha);
	}

	/**
	 * @return the iVentaDevolucionId
	 */
	public int getiVentaDevolucionId() {
		return ventaDev.getiVentaDevolucionId();
	}

	/**
	 * @param iVentaDevolucionId the iVentaDevolucionId to set
	 */
	public void setiVentaDevolucionId(int iVentaDevolucionId) {
		this.ventaDev.setiVentaDevolucionId(iVentaDevolucionId);
	}

	/**
	 * @return the fVentaDev
	 */
	public float getfVentaDev() {
		return this.ventaDev.getfVentaDevTotal();
	}
	/**
	 * @param fVentaDev the fVentaDev to set
	 */
	public void setfVentaDev(float fVentaDev) {
		this.ventaDev.setfVentaDevTotal(fVentaDev);
	}

	/**
	 * @return the fVentaDevIGV
	 */
	public float getfVentaDevIGV() {
		return this.ventaDev.getfVentaDevIGV();
	}

	/**
	 * @param fVentaDevIGV the fVentaDevIGV to set
	 */
	public void setfVentaDevIGV(float fVentaDevIGV) {
		this.ventaDev.setfVentaDevIGV (fVentaDevIGV);
	}

	/**
	 * @return the fVentaDevSubTotal
	 */
	public float getfVentaDevSubTotal() {
		return this.ventaDev.getfVentaDevSubTotal();
	}

	/**
	 * @param fVentaDevSubTotal the fVentaDevSubTotal to set
	 */
	public void setfVentaDevSubTotal(float fVentaDevSubTotal) {
		System.out.println("dsf"+fVentaDevSubTotal);
		this.ventaDev.setfVentaDevSubTotal (fVentaDevSubTotal);
	}
	/**
	 * @return the metodo
	 */
	public String getMetodo() {
		return metodo;
	}
	/**
	 * @param metodo the metodo to set
	 */
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	/**
	 * @return the iNumeroDias
	 */
	public int getiNumeroDias() {
		return getVenta().getiNumeroDias();
	}

	/**
	 * @param iNumeroDias the iNumeroDias to set
	 */
	public void setiNumeroDias(int iNumeroDias) {
		this.getVenta().setiNumeroDias(iNumeroDias);
	}

	/**
	 * @return the iNumeroLetras
	 */
	public int getiNumeroLetras() {
		return getVenta().getiNumeroLetras();
	}

	/**
	 * @param iNumeroLetras the iNumeroLetras to set
	 */
	public void setiNumeroLetras(int iNumeroLetras) {
		this.getVenta().setiNumeroLetras(iNumeroLetras);
	}

	/**
	 * @return the dFechaProximoPago
	 */
	public String getdFechaProximoPago() {
		return Fechas.fechaDDMMYY(getVenta().getdFechaProximoPago());
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
		this.getVenta().setdFechaProximoPago(fecha);
	}

	/**
	 * @return the fMontoAdelantado
	 */
	public float getfMontoAdelantado() {
		return getVenta().getfMontoAdelantado();
	}

	/**
	 * @param fMontoAdelantado the fMontoAdelantado to set
	 */
	public void setfMontoAdelantado(float fMontoAdelantado) {
		this.getVenta().setfMontoAdelantado(fMontoAdelantado);
	}

	/**
	 * @return the fDescuento
	 */
	public float getfDescuento() {
		return getVenta().getfDescuento();
	}

	/**
	 * @param fDescuento the fDescuento to set
	 */
	public void setfDescuento(float fDescuento) {
		this.getVenta().setfDescuento(fDescuento);
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
	 * @return the iGVVentas
	 */
	public String getIGVVentas() {
		return IGVVentas;
	}
	/**
	 * @param iGVVentas the iGVVentas to set
	 */
	public void setIGVVentas(String iGVVentas) {
		IGVVentas = iGVVentas;
	}
	
	/**
	 * @return the fVentaTotalReal
	 */
	public float getfVentaTotalReal() {
		return getVenta().getfVentaTotalReal();
	}

	/**
	 * @param fVentaTotalReal the fVentaTotalReal to set
	 */
	public void setfVentaTotalReal(float fVentaTotalReal) {
		this.getVenta().setfVentaTotalReal(fVentaTotalReal);
	}
	
	/**
	 * @return the iPeriodoId
	 */
	public int getiPeriodoId() {
		return this.getVenta().getiPeriodoId();
	}

	/**
	 * @param iPeriodoId the iPeriodoId to set
	 */
	public void setiPeriodoId(int iPeriodoId) {
		this.getVenta().setiPeriodoId(iPeriodoId);
	}
	/**
	 * @return the fMontoPago
	 */
	public float getfMontoPago() {
		return getVenta().getfMontoPago();
	}

	/**
	 * @param fMontoPago the fMontoPago to set
	 */
	public void setfMontoPago(float fMontoPago) {
		this.getVenta().setfMontoPago(fMontoPago);
	}

	/**
	 * @return the fTipoCambio
	 */
	public float getfTipoCambio() {
		return getVenta().getfTipoCambio();
	}

	/**
	 * @param fTipoCambio the fTipoCambio to set
	 */
	public void setfTipoCambio(float fTipoCambio) {
		this.getVenta().setfTipoCambio(fTipoCambio);
	}

	/**
	 * @return the fMontoVuelto
	 */
	public float getfMontoVuelto() {
		return getVenta().getfMontoVuelto();
	}

	/**
	 * @param fMontoVuelto the fMontoVuelto to set
	 */
	public void setfMontoVuelto(float fMontoVuelto) {
		this.getVenta().setfMontoVuelto(fMontoVuelto);
	}

	/**
	 * @return the vTipoPago
	 */
	public String getvTipoPago() {
		return getVenta().getvTipoPago();
	}

	/**
	 * @param vTipoPago the vTipoPago to set
	 */
	public void setvTipoPago(String vTipoPago) {
		this.getVenta().setvTipoPago(vTipoPago);
	}
	/**
	 * @return the fDescClienteVenta
	 */
	public float getfDescClienteVenta() {
		return getVenta().getfDescClienteVenta();
	}

	/**
	 * @param fDescClienteVenta the fDescClienteVenta to set
	 */
	public void setfDescClienteVenta(float fDescClienteVenta) {
		this.getVenta().setfDescClienteVenta(fDescClienteVenta);
	}

	/**
	 * @return the vIncluyeIGV
	 */
	public String getvIncluyeIGV() {
		return this.getVenta().getvIncluyeIGV();
	}

	/**
	 * @param vIncluyeIGV the vIncluyeIGV to set
	 */
	public void setvIncluyeIGV(String vIncluyeIGV) {
		this.getVenta().setvIncluyeIGV(vIncluyeIGV);
	}

	/**
	 * @return the vTipoVenta
	 */
	public String getvTipoVenta() {
		return getVenta().getvTipoVenta();
	}

	/**
	 * @param vTipoVenta the vTipoVenta to set
	 */
	public void setvTipoVenta(String vTipoVenta) {
		this.getVenta().setvTipoVenta(vTipoVenta);
	}
	
	/**
	 * @return the nNroNotaCredito
	 */
	public String getnNroNotaCredito() {
		return ventaDev.getnNroNotaCredito();
	}


	/**
	 * @param nNroNotaCredito the nNroNotaCredito to set
	 */
	public void setnNroNotaCredito(String nNroNotaCredito) {
		this.ventaDev.setnNroNotaCredito(nNroNotaCredito);
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
	/**
	 * @return the identificador
	 */
	public String getIdentificador() {
		return identificador;
	}
	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	/**
	 * @return the fMontoPagoCredito
	 */
	public float getfMontoPagoCredito() {
		return venta.getfMontoPagoCredito();
	}

	/**
	 * @param fMontoPagoCredito the fMontoPagoCredito to set
	 */
	public void setfMontoPagoCredito(float fMontoPagoCredito) {
		this.venta.setfMontoPagoCredito(fMontoPagoCredito);
	}
	
	/**
	 * @return the medioPago1
	 */
	public Mediopago getMedioPago1() {
		Mediopago formaPago = getVenta().getMedioPago1();
		if(formaPago==null){
			formaPago= new Mediopago();
			venta.setMedioPago1(formaPago);
		}
		return venta.getMedioPago1();
	}
	/**
	 * @return the iFormaPagoId
	 */
	public int getiMedioPagoId1() {
		return getMedioPago1().getiMedioPagoId();
	}

	/**
	 * @param iFormaPagoId the iFormaPagoId to set
	 */
	public void setiMedioPagoId1(int iFormaPagoId) {	
		this.venta.setMedioPago1(ventaDao().findEndidad(getMedioPago1(), iFormaPagoId));
	}
	

	
	
	/**
	 * @return the medioPago1
	 */
	public Mediopago getMedioPago2() {
		Mediopago formaPago = getVenta().getMedioPago2();
		if(formaPago==null){
			formaPago= new Mediopago();
			venta.setMedioPago2(formaPago);
		}
		return venta.getMedioPago2();
	}
	/**
	 * @return the iFormaPagoId
	 */
	public int getiMedioPagoId2() {
		return getMedioPago2().getiMedioPagoId();
	}

	/**
	 * @param iFormaPagoId the iFormaPagoId to set
	 */
	public void setiMedioPagoId2(int iFormaPagoId) {	
		this.venta.setMedioPago2(ventaDao().findEndidad(getMedioPago2(), iFormaPagoId));
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
	
	public String getvTextoImpresion() {
		return vTextoImpresion;
	}
	
	public void setvTextoImpresion(String vTextoImpresion) {
		this.vTextoImpresion = vTextoImpresion;
	}

}
