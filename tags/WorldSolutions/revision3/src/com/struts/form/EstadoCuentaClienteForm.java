package com.struts.form;



import java.text.ParseException;

import java.util.Date;
import java.util.List;

import com.entities.Estadocuentacliente;
import com.entities.Formapago;
import com.entities.Letracliente;
import com.entities.Venta;
import com.entities.Cliente;
import com.util.Fechas;


public class EstadoCuentaClienteForm extends VentaForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List lista;	
	Estadocuentacliente estadoCuentaCliente = new Estadocuentacliente();
	Letracliente letracliente = new Letracliente();
    private String mode;
    private List paginas;
    private int pagInicio;
	private float montoTotal;
	private float pagoTotal;
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
	 * @return the estadoCuentaCliente
	 */
	public Estadocuentacliente getEstadoCuentaCliente() {
		return estadoCuentaCliente;
	}
	/**
	 * @param estadoCuentaCliente the estadoCuentaCliente to set
	 */
	public void setEstadoCuentaCliente(Estadocuentacliente estadoCuentaCliente) {
		this.estadoCuentaCliente = estadoCuentaCliente;
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
	 * @return the iEstadoCuentaCliente
	 */
	public int getiEstadoCuentaCliente() {
		return estadoCuentaCliente.getiEstadoCuentaCliente();
	}



	/**
	 * @param iEstadoCuentaCliente the iEstadoCuentaCliente to set
	 */
	public void setiEstadoCuentaCliente(int iEstadoCuentaCliente) {
		this.estadoCuentaCliente.setiEstadoCuentaCliente (iEstadoCuentaCliente);
	}



	/**
	 * @return the cEstadoCodigo
	 */
	public String getcEstadoCodigo() {
		String cEstadoCodigo = "";
		cEstadoCodigo=estadoCuentaCliente.getcEstadoCodigo();
		if(cEstadoCodigo=="")
			cEstadoCodigo=letracliente.getcEstadoCodigo();
		return cEstadoCodigo;
	}

	/**
	 * @param cEstadoCodigo the cEstadoCodigo to set
	 */
	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.estadoCuentaCliente.setcEstadoCodigo(cEstadoCodigo);
		this.letracliente.setcEstadoCodigo(cEstadoCodigo);
	}

	
	/**
	 * @return the dFechaPago
	 * @throws ParseException 
	 */
	public String getdFechaPago() {
		String fechaPago = "";
		fechaPago = Fechas.fechaDDMMYY(estadoCuentaCliente.getdFechaPago());
		fechaPago = Fechas.fechaDDMMYY(letracliente.getdFechaPago());
		return fechaPago;
	}

	/**
	 * @param dFechaPago the dFechaPago to set
	 * @throws ParseException 
	 */
	public void setdFechaPago(String dFechaPago) throws ParseException {
		Date fechaPago = null;
		if(dFechaPago!="")
			fechaPago=Fechas.fechaDate(dFechaPago);
		this.estadoCuentaCliente.setdFechaPago(fechaPago) ;
		this.letracliente.setdFechaPago(fechaPago);
	}

	/**
	 * @return the fMontoPago
	 */
	public float getfMontoPago() {
		return estadoCuentaCliente.getfMontoPago();
	}

	/**
	 * @param fMontoPago the fMontoPago to set
	 */
	public void setfMontoPago(float fMontoPago) {
		this.estadoCuentaCliente.setfMontoPago(fMontoPago) ;
	}
	/**
	 * @return the venta
	 */
	public Venta getVenta() {
		Venta venta = estadoCuentaCliente.getVenta();
		if(venta==null)
			venta= letracliente.getVenta();
		if(venta==null)
			venta = new Venta();
		return venta;
	}

	/**
	 * @param venta the venta to set
	 */
	public void setVenta(Venta venta) {
		this.letracliente.setVenta(venta);
		this.estadoCuentaCliente.setVenta(venta);
	}
	/**
	 * @return the iVentaId
	 */
	public int getiVentaId() {
		Venta venta = getVenta();
		return venta.getiVentaId();
	}

	/**
	 * @param iVentaId the iVentaId to set
	 */
	public void setiVentaId(int iVentaId) {
		Venta venta = getVenta();	
		venta.setiVentaId(iVentaId);
		this.letracliente.setVenta(venta);
		this.estadoCuentaCliente.setVenta(venta);
		
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
		Cliente cliente= getCliente();
		cliente.setiClienteId(iClienteId);
		this.estadoCuentaCliente.setCliente(cliente) ;
		this.letracliente.setCliente(cliente);
	}
	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		Cliente cliente = estadoCuentaCliente.getCliente();
		if(cliente==null)
			cliente = letracliente.getCliente();
		if(cliente==null)
			 cliente= new Cliente();
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.estadoCuentaCliente.setCliente(cliente);
		this.letracliente.setCliente(cliente);
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
	

	/*******************/
	/** Letra cliente */
	/******************/
	/**
	 * @return the letracliente
	 */
	public Letracliente getLetracliente() {
		return letracliente;
	}
	/**
	 * @param letracliente the letracliente to set
	 */
	public void setLetracliente(Letracliente letracliente) {
		this.letracliente = letracliente;
	}
	
	/**
	 * @return the iLetraClienteId
	 */
	public int getiLetraClienteId() {
		return letracliente.getiLetraClienteId();
	}

	/**
	 * @param iLetraClienteId the iLetraClienteId to set
	 */
	public void setiLetraClienteId(int iLetraClienteId) {
		this.letracliente.setiLetraClienteId(iLetraClienteId);
	}

	/**
	 * @return the dFechaGiro
	 */
	public String getdFechaGiro() {
		String dFechaGiro = "";
		dFechaGiro=Fechas.fechaDDMMYY(letracliente.getdFechaGiro());
		return dFechaGiro;
	}

	/**
	 * @param dFechaGiro the dFechaGiro to set
	 * @throws ParseException 
	 */
	public void setdFechaGiro(String dFechaGiro) throws ParseException {
		this.letracliente.setdFechaGiro(Fechas.fechaDate(dFechaGiro));
	}
	

/*	*//**
	 * @return the dFechaProrroga
	 *//*
	public String getdFechaProrroga() {
	
		return dFechaProrroga;
	}

	/**
	 * @param dFechaProrroga the dFechaProrroga to set
	 
	public void setdFechaProrroga(Date dFechaProrroga) {
		this.dFechaProrroga = dFechaProrroga;
	}
*/
	/**
	 * @return the dFechaVencimiento
	 */
	public String getdFechaVencimiento() {
		String dFechaVencimiento ="";
		dFechaVencimiento= Fechas.fechaDDMMYY(letracliente.getdFechaVencimiento());
		return dFechaVencimiento;
	}

	/**
	 * @param dFechaVencimiento the dFechaVencimiento to set
	 * @throws ParseException 
	 */
	public void setdFechaVencimiento(String dFechaVencimiento) throws ParseException {
		this.letracliente.setdFechaVencimiento(Fechas.fechaDate(dFechaVencimiento));
	}

	/**
	 * @return the fImporteIntereses
	 */
	public float getfImporteIntereses() {
		return letracliente.getfImporteIntereses();
	}

	/**
	 * @param fImporteIntereses the fImporteIntereses to set
	 */
	public void setfImporteIntereses(float fImporteIntereses) {
		this.letracliente.setfImporteIntereses(fImporteIntereses);
	}

	

	/**
	 * @return the iEmpresaId
	 *//*
	public int getiEmpresaId() {
		return iEmpresaId;
	}

	*//**
	 * @param iEmpresaId the iEmpresaId to set
	 *//*
	public void setiEmpresaId(int iEmpresaId) {
		this.iEmpresaId = iEmpresaId;
	}
*/
	

	

	/**
	 * @return the nImporte
	 */
	public float getnImporte() {
		return letracliente.getnImporte();
	}

	/**
	 * @param nImporte the nImporte to set
	 */
	public void setnImporte(float nImporte) {
		this.letracliente.setnImporte(nImporte);
	}

	/**
	 * @return the nNumeroLetra
	 */
	public int getnNumeroLetra() {
		return letracliente.getnNumeroLetra();
	}

	/**
	 * @param nNumeroLetra the nNumeroLetra to set
	 */
	public void setnNumeroLetra(int nNumeroLetra) {
		this.letracliente.setnNumeroLetra(nNumeroLetra);
	}

	/**
	 * @return the nNumeroUnico
	 */
	public String getnNumeroUnico() {
		return letracliente.getnNumeroUnico();
	}

	/**
	 * @param nNumeroUnico the nNumeroUnico to set
	 */
	public void setnNumeroUnico(String nNumeroUnico) {
		this.letracliente.setnNumeroUnico(nNumeroUnico);
	}

	/**
	 * @return the nPlazoLetra
	 */
	public int getnPlazoLetra() {
		return letracliente.getnPlazoLetra();
	}

	/**
	 * @param nPlazoLetra the nPlazoLetra to set
	 */
	public void setnPlazoLetra(int nPlazoLetra) {
		this.letracliente.setnPlazoLetra(nPlazoLetra);
	}

	/**
	 * @return the nRefGirador
	 *//*
	public String getnRefGirador() {
		return nRefGirador;
	}

	*//**
	 * @param nRefGirador the nRefGirador to set
	 *//*
	public void setnRefGirador(String nRefGirador) {
		this.nRefGirador = nRefGirador;
	}*/

	/**
	 * @return the vEstadoLetra
	 */
	public String getvEstadoLetra() {
		return letracliente.getvEstadoLetra();
	}

	/**
	 * @param vEstadoLetra the vEstadoLetra to set
	 */
	public void setvEstadoLetra(String vEstadoLetra) {
		this.letracliente.setvEstadoLetra(vEstadoLetra);
	}

	/**
	 * @return the vImporteLetras
	 */
	public String getvImporteLetras() {
		return letracliente.getvImporteLetras();
	}

	/**
	 * @param vImporteLetras the vImporteLetras to set
	 */
	public void setvImporteLetras(String vImporteLetras) {
		this.letracliente.setvImporteLetras(vImporteLetras);
	}

	/**
	 * @return the vLugarGiro
	 */
	public String getvLugarGiro() {
		return letracliente.getvLugarGiro();
	}

	/**
	 * @param vLugarGiro the vLugarGiro to set
	 */
	public void setvLugarGiro(String vLugarGiro) {
		this.letracliente.setvLugarGiro(vLugarGiro);
	}

	/**
	 * @return the nVentaNumero
	 */
	public String getnVentaNumero() {
		return getVenta().getnVentaNumero();
	}

	/**
	 * @param nVentaNumero the nVentaNumero to set
	 */
	public void setnVentaNumero(String nVentaNumero) {
		this.getVenta().setnVentaNumero(nVentaNumero);
	}

	/**
	 * @return the fVentaTotal
	 */
	public float getfVentaTotal() {
		return getVenta().getfVentaTotal();
	}

	/**
	 * @param fVentaTotal the fVentaTotal to set
	 */
	public void setfVentaTotal(float fVentaTotal) {
		this.getVenta().setfVentaTotal(fVentaTotal);
	}
	

    
}
