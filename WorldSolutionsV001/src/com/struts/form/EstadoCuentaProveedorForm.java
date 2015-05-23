package com.struts.form;



import java.math.BigDecimal;
import java.text.ParseException;

import java.util.Date;
import java.util.List;


import com.entities.Estadocuentaproveedor;
import com.entities.Formapago;
import com.entities.Ingresoproducto;
import com.entities.Letraproveedor;
import com.entities.Proveedor;
import com.entities.Tipodocumentogestion;
import com.util.Fechas;


public class EstadoCuentaProveedorForm extends IngresoProductoForm   {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List lista;	
	Estadocuentaproveedor estadoCuentaProveedor = new Estadocuentaproveedor();	
	Letraproveedor letraProveedor = new Letraproveedor();
    private String mode;
    private List paginas;
    private int pagInicio;
	private float montoTotal;
	private float pagoTotal;
	private int aplicarTodos;
	private String dFechaPagoLetra;
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
	 * @return the estadoCuentaProveedor
	 */
	public Estadocuentaproveedor getEstadoCuentaProveedor() {
		return estadoCuentaProveedor;
	}
	/**
	 * @param estadoCuentaProveedor the estadoCuentaProveedor to set
	 */
	public void setEstadoCuentaProveedor(Estadocuentaproveedor estadoCuentaProveedor) {
		this.estadoCuentaProveedor = estadoCuentaProveedor;
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
	 * @return the iEstadoCuentaProveedor
	 */
	public int getiEstadoCuentaProveedor() {
		return estadoCuentaProveedor.getiEstadoCuentaProveedor();
	}



	/**
	 * @param iEstadoCuentaProveedor the iEstadoCuentaProveedor to set
	 */
	public void setiEstadoCuentaProveedor(int iEstadoCuentaProveedor) {
		this.estadoCuentaProveedor.setiEstadoCuentaProveedor (iEstadoCuentaProveedor);
	}



	/**
	 * @return the cEstadoCodigo
	 */
	public String getcEstadoCodigo() {
		return estadoCuentaProveedor.getcEstadoCodigo();
	}

	/**
	 * @param cEstadoCodigo the cEstadoCodigo to set
	 */
	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.estadoCuentaProveedor.setcEstadoCodigo(cEstadoCodigo);
	}

	
	/**
	 * @return the dFechaPago
	 * @throws ParseException 
	 */
	public String getdFechaPago() {
		String fechaPago = "";
		fechaPago = Fechas.fechaDDMMYY(estadoCuentaProveedor.getdFechaPago());
		return fechaPago;
	}

	/**
	 * @param dFechaPago the dFechaPago to set
	 * @throws ParseException 
	 */
	public void setdFechaPago(String dFechaPago) throws ParseException {	
		
		 this.estadoCuentaProveedor.setdFechaPago(Fechas.fechaDate(dFechaPago)) ;
	}

	/**
	 * @return the fMontoPago
	 */
	public float getfMontoPago() {
		return estadoCuentaProveedor.getfMontoPago();
	}

	/**
	 * @param fMontoPago the fMontoPago to set
	 */
	public void setfMontoPago(float fMontoPago) {
		this.estadoCuentaProveedor.setfMontoPago(fMontoPago) ;
	}
	
	/**
	 * @return the iIngresoProductoId
	 */
	public int getiIngresoProductoId() {				
		return getIngresoproducto().getiIngresoProductoId();
	}

	/**
	 * @param iIngresoProductoId the iIngresoProductoId to set
	 */
	public void setiIngresoProductoId(int iIngresoProductoId) {
		Ingresoproducto ingresoProducto= getIngresoproducto();
		ingresoProducto.setiIngresoProductoId(iIngresoProductoId);
		this.estadoCuentaProveedor.setIngresoproducto(ingresoProducto);
		this.letraProveedor.setIngresoProducto(ingresoProducto);
	}
	/**
	 * @return the ingresoproducto
	 */
	public Ingresoproducto getIngresoproducto() {
		Ingresoproducto ingresoProducto = estadoCuentaProveedor.getIngresoproducto();
		if(ingresoProducto==null)
		  ingresoProducto = letraProveedor.getIngresoProducto();
		if(ingresoProducto==null)
			ingresoProducto = new Ingresoproducto();
		return ingresoProducto;
	}

	/**
	 * @param ingresoproducto the ingresoproducto to set
	 */
	public void setIngresoproducto(Ingresoproducto ingresoproducto) {
		this.estadoCuentaProveedor.setIngresoproducto(ingresoproducto) ;
		this.letraProveedor.setIngresoProducto(ingresoproducto);
	}
	/**
	 * @return the nIngresoProductoNumero
	 */
	public String getnIngresoProductoNumero() {
		return getIngresoproducto().getnIngresoProductoNumero();
	}
	/**
	 * @param nIngresoProductoNumero the nIngresoProductoNumero to set
	 */
	public void setnIngresoProductoNumero(String nIngresoProductoNumero) {
		this.getIngresoproducto().setnIngresoProductoNumero(nIngresoProductoNumero);
	}
	/**
	 * @return the cProveedorCodigo
	 */
	public String getcProveedorCodigo() {
		return getProveedor().getcProveedorCodigo();
	}

	/**
	 * @return the vProveedorRazonSocial
	 */
	public String getvProveedorRazonSocial() {
		return getProveedor().getvProveedorRazonSocial();
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
		this.getProveedor().setnProveedorNumeroDocumento(nProveedorNumeroDocumento);
	}
	
	
	public Tipodocumentogestion getTipodocumentogestion(){
		Tipodocumentogestion tipoDoc = getIngresoproducto().getTipodocumento();	
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
		Tipodocumentogestion tipoDocumento = new Tipodocumentogestion();
		tipoDocumento.setiTipoDocumentoGestionId(iTipoDocumentoGestionId);
		this.getIngresoproducto().setTipodocumento(tipoDocumento);
	}
	/**
	 * @return the iProveedorId
	 */
	public int getiProveedorId() {
		Proveedor proveedor = estadoCuentaProveedor.getProveedor();
		if(proveedor==null)
			proveedor = letraProveedor.getProveedor();
		if(proveedor==null)
			proveedor = getProveedor();
		return proveedor.getiProveedorId();
	}

	/**
	 * @param iProveedorId the iProveedorId to set
	 */
	public void setiProveedorId(int iProveedorId) {
		Proveedor proveedor = getProveedor();
		proveedor.setiProveedorId(iProveedorId);
		this.estadoCuentaProveedor.setProveedor(proveedor) ;
		this.letraProveedor.setProveedor(proveedor) ;
	}
	/**
	 * @return the proveedor
	 */
	public Proveedor getProveedor() {
		Proveedor proveedor = estadoCuentaProveedor.getProveedor();
		if(proveedor==null)
		    proveedor =letraProveedor.getProveedor();		    
		if(proveedor==null)
			    proveedor = new Proveedor();
		return proveedor;
	}

	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(Proveedor proveedor) {
		this.estadoCuentaProveedor.setProveedor(proveedor);
	}
	/**
	 * @return the sVendedor
	 */
	public String getsVendedor() {
		return estadoCuentaProveedor.getsVendedor();
	}
	/**
	 * @param sVendedor the sVendedor to set
	 */
	public void setsVendedor(String sVendedor) {
		this.estadoCuentaProveedor.setsVendedor( sVendedor);
	}
	/**
	 * @return the montoTotal
	 */
	public float getMontoTotal() {
		return montoTotal;
	}
	/**
	 * @param montoTotal the montoTotal to set
	 */
	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
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
	 * @return the ingresoProducto
	 */
	/**********************/
	/*** Letra Proveedor */
	/*********************/
	/**
	 * @return the letraProveedor
	 */
	public Letraproveedor getLetraProveedor() {		
		return letraProveedor;
	}
	/**
	 * @param letraProveedor the letraProveedor to set
	 */
	public void setLetraProveedor(Letraproveedor letraProveedor) {
		this.letraProveedor = letraProveedor;
	}
	
	/**
	 * @return the iletraProveedorId
	 */
	public int getIletraProveedorId() {
		return letraProveedor.getIletraProveedorId();
	}

	/**
	 * @param iletraProveedorId the iletraProveedorId to set
	 */
	public void setIletraProveedorId(int iletraProveedorId) {
		this.letraProveedor.setIletraProveedorId(iletraProveedorId);
	}
	
	/**
	 * @return the dFechaGiro
	 */
	public String getdFechaGiro() {
		return Fechas.fechaDDMMYY(getLetraProveedor().getdFechaGiro());
	}

	/**
	 * @param dFechaGiro the dFechaGiro to set
	 * @throws ParseException 
	 */
	public void setdFechaGiro(String dFechaGiro) throws ParseException {
		this.letraProveedor.setdFechaGiro(Fechas.fechaDate(dFechaGiro));
	}


	/**
	 * @return the dFechaProrroga
	 */
	public String getdFechaProrroga() {
		return Fechas.fechaDDMMYY(getLetraProveedor().getdFechaProrroga());
	}

	/**
	 * @param dFechaProrroga the dFechaProrroga to set
	 * @throws ParseException 
	 */
	public void setdFechaProrroga(String dFechaProrroga) throws ParseException {
		this.letraProveedor.setdFechaProrroga(Fechas.fechaDate(dFechaProrroga));
	}

	/**
	 * @return the dFechaVencimiento
	 */
	public String getdFechaVencimiento() {
		return Fechas.fechaDDMMYY(getLetraProveedor().getdFechaVencimiento());
	}

	/**
	 * @param dFechaVencimiento the dFechaVencimiento to set
	 * @throws ParseException 
	 */
	public void setdFechaVencimiento(String dFechaVencimiento) throws ParseException {
		this.letraProveedor.setdFechaVencimiento(Fechas.fechaDate(dFechaVencimiento));
	}


	/**
	 * @return the nImporte
	 */
	public float getnImporte() {
		return letraProveedor.getnImporte();
	}

	/**
	 * @param nImporte the nImporte to set
	 */
	public void setnImporte(float nImporte) {
		this.letraProveedor.setnImporte(nImporte);
	}

	/**
	 * @return the nNumeroLetra
	 */
	public int getnNumeroLetra() {
		return letraProveedor.getnNumeroLetra();
	}

	/**
	 * @param nNumeroLetra the nNumeroLetra to set
	 */
	public void setnNumeroLetra(int nNumeroLetra) {
		this.letraProveedor.setnNumeroLetra(nNumeroLetra);
	}

	/**
	 * @return the nNumeroUnico
	 */
	public int getnNumeroUnico() {
		return letraProveedor.getnNumeroUnico();
	}

	/**
	 * @param nNumeroUnico the nNumeroUnico to set
	 */
	public void setnNumeroUnico(int nNumeroUnico) {
		this.letraProveedor.setnNumeroUnico(nNumeroUnico);
	}

	/**
	 * @return the vEstadoLetra
	 */
	public String getvEstadoLetra() {
		return letraProveedor.getvEstadoLetra();
	}

	/**
	 * @param vEstadoLetra the vEstadoLetra to set
	 */
	public void setvEstadoLetra(String vEstadoLetra) {
		this.letraProveedor.setvEstadoLetra(vEstadoLetra);
	}
	
	/**
	 * @return the cEstadoCodigo
	 */
	public String getcEstadoCodigoLetra() {
		return letraProveedor.getcEstadoCodigo();
	}

	/**
	 * @param cEstadoCodigo the cEstadoCodigo to set
	 */
	public void setcEstadoCodigoLetra(String cEstadoCodigo) {
		this.letraProveedor.setcEstadoCodigo(cEstadoCodigo);
	}
	/**
	 * @return the nPlazoLetra
	 */
	public int getnPlazoLetra() {
		return letraProveedor.getnPlazoLetra();
	}

	/**
	 * @param nPlazoLetra the nPlazoLetra to set
	 */
	public void setnPlazoLetra(int nPlazoLetra) {
		this.letraProveedor.setnPlazoLetra(nPlazoLetra);
	}
	/**
	 * @return the dFechaPago
	 */
	public String getdFechaPagoLetra() {
		return dFechaPagoLetra;
	}

	/**
	 * @param dFechaPago the dFechaPago to set
	 * @throws ParseException 
	 */
	public void setdFechaPagoLetra(String dFechaPago) throws ParseException {		
		this.dFechaPagoLetra=dFechaPago;
	}
	public Formapago getFormapago(){
		Formapago formaPago = getIngresoproducto().getFormaPago();		
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
		this.getIngresoproducto().setFormaPago(ingresoProductoDao().findEndidad(Formapago.class, iFormaPagoId));
	}
	
	/**
	 * @return the fIngresoProductoTotal
	 */
	public float getfIngresoProductoTotal() {
		return getIngresoproducto().getfIngresoProductoTotal();
	}
	
	/**
	 * @return the fImporteIntereses
	 */
	public float getfImporteIntereses() {
		return letraProveedor.getfImporteIntereses();
	}

	/**
	 * @param fImporteIntereses the fImporteIntereses to set
	 */
	public void setfImporteIntereses(float fImporteIntereses) {
		this.letraProveedor.setfImporteIntereses(fImporteIntereses);
	}
	/**
	 * @return the iNumeroLetras
	 */
	public int getiNumeroLetras() {
		return getIngresoproducto().getiNumeroLetras();
	}

	/**
	 * @param iNumeroLetras the iNumeroLetras to set
	 */
	public void setiNumeroLetras(int iNumeroLetras) {
		this.getIngresoproducto().setiNumeroLetras(iNumeroLetras);
	}
	/**
	 * @return the aplicarTodos
	 */
	public int getAplicarTodos() {
		return aplicarTodos;
	}
	/**
	 * @param aplicarTodos the aplicarTodos to set
	 */
	public void setAplicarTodos(int aplicarTodos) {
		this.aplicarTodos = aplicarTodos;
	}
	
	
	
}
