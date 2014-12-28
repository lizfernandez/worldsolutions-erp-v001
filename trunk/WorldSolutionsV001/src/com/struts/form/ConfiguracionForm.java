package com.struts.form;


import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.entities.Configuracion;
import com.entities.Ejerciciofiscal;
import com.entities.Impuesto;
import com.entities.Periodo;

import com.util.Fechas;



public class ConfiguracionForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List lista;	
	Configuracion conf = new Configuracion();
	Ejerciciofiscal ejercicio= new Ejerciciofiscal();
	Periodo periodo = new Periodo();
	Impuesto impuesto = new Impuesto();
    private String mode;
    private List paginas;
    private int pagInicio;
    
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
	 * @return the conf
	 */
	public Configuracion getConf() {
		return conf;
	}
	/**
	 * @param conf the conf to set
	 */
	public void setConf(Configuracion conf) {
		this.conf = conf;
	}
	
	/**
	 * @return the ejercicio
	 */
	public Ejerciciofiscal getEjercicio() {
		return ejercicio;
	}
	/**
	 * @param ejercicio the ejercicio to set
	 */
	public void setEjercicio(Ejerciciofiscal ejercicio) {
		this.ejercicio = ejercicio;
	}
	
	
	/**
	 * @return the periodo
	 */
	public Periodo getPeriodo() {
		return periodo;
	}
	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
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
	 * @return the iConfiguracionId
	 */
	public int getiConfiguracionId() {
		return conf.getiConfiguracionId();
	}

	/**
	 * @param iConfiguracionId the iConfiguracionId to set
	 */
	public void setiConfiguracionId(int iConfiguracionId) {
		this.conf.setiConfiguracionId(iConfiguracionId);
	}

	/**
	 * @return the cEstadoCodigo
	 */
	public String getcEstadoCodigo() {
		return conf.getcEstadoCodigo();
	}

	/**
	 * @param cEstadoCodigo the cEstadoCodigo to set
	 */
	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.conf.setcEstadoCodigo(cEstadoCodigo);
	}

	/**
	 * @return the dFechaInserta
	 */
	public Date getdFechaInserta() {
		return conf.getdFechaInserta();
	}

	/**
	 * @param dFechaInserta the dFechaInserta to set
	 */
	public void setdFechaInserta(Date dFechaInserta) {
		this.conf.setdFechaInserta(dFechaInserta) ;
	}

	/**
	 * @return the vConcepto
	 */
	public String getvConcepto() {
		return conf.getvConcepto();
	}

	/**
	 * @param vConcepto the vConcepto to set
	 */
	public void setvConcepto(String vConcepto) {
		this.conf.setvConcepto(vConcepto);
	}

	/**
	 * @return the vValor
	 */
	public String getvValor() {
		return conf.getvValor();
	}

	/**
	 * @param vValor the vValor to set
	 */
	public void setvValor(String vValor) {
		this.conf.setvValor(vValor) ;
	}
	
	/********************/
	/**Ejercicio Fiscal**/
	/********************/
	/**
	 * @return the iEjercicioFiscalId
	 */
	public int getiEjercicioFiscalId() {
		return getEjercicio().getiEjercicioFiscalId();
	}

	/**
	 * @param iEjercicioFiscalId the iEjercicioFiscalId to set
	 */
	public void setiEjercicioFiscalId(int iEjercicioFiscalId) {
		this.getEjercicio().setiEjercicioFiscalId(iEjercicioFiscalId);
	}

	/**
	 * @return the cCodigoEstado
	 */
	public String getcCodigoEstado() {
		return getEjercicio().getcCodigoEstado();
	}

	/**
	 * @param cCodigoEstado the cCodigoEstado to set
	 */
	public void setcCodigoEstado(String cCodigoEstado) {
		this.getEjercicio().setcCodigoEstado(cCodigoEstado);
	}
	

	
	/**
	 * @return the dFechaFin
	 */
	public String getdFechaFin() {
		return Fechas.fechaDDMMYY(getEjercicio().getdFechaFin());
	}

	/**
	 * @param dFechaFin the dFechaFin to set
	 * @throws ParseException 
	 */
	public void setdFechaFin(String dFechaFin) throws ParseException {
		this.getEjercicio().setdFechaFin(Fechas.fechaDate(dFechaFin));
	}

	/**
	 * @return the dFechaInicio
	 */
	public String getdFechaInicio() {
		return Fechas.fechaDDMMYY(getEjercicio().getdFechaInicio());
	}

	/**
	 * @param dFechaInicio the dFechaInicio to set
	 * @throws ParseException 
	 */
	public void setdFechaInicio(String dFechaInicio) throws ParseException {
		this.getEjercicio().setdFechaInicio(Fechas.fechaDate(dFechaInicio));
	}
	

	/**
	 * @return the vCodigoEjercicio
	 */
	public String getvCodigoEjercicio() {
		return getEjercicio().getvCodigoEjercicio();
	}

	/**
	 * @param vCodigoEjercicio the vCodigoEjercicio to set
	 */
	public void setvCodigoEjercicio(String vCodigoEjercicio) {
		this.getEjercicio().setvCodigoEjercicio(vCodigoEjercicio);
	}

	/**
	 * @return the vNombreEjercicio
	 */
	public String getvNombreEjercicio() {
		return getEjercicio().getvNombreEjercicio();
	}

	/**
	 * @param vNombreEjercicio the vNombreEjercicio to set
	 */
	public void setvNombreEjercicio(String vNombreEjercicio) {
		this.getEjercicio().setvNombreEjercicio(vNombreEjercicio);
	}
	
	
	/*********Periodo*********/
	
	

	/**
	 * @return the iPeriodoId
	 */
	public int getiPeriodoId() {
		return getPeriodo().getiPeriodoId();
	}

	/**
	 * @param iPeriodoId the iPeriodoId to set
	 */
	public void setiPeriodoId(int iPeriodoId) {
		this.getPeriodo().setiPeriodoId(iPeriodoId) ;
	}

	


	/**
	 * @return the vCodigoPeriodo
	 */
	public String getvCodigoPeriodo() {
		return getPeriodo().getvCodigoPeriodo();
	}

	/**
	 * @param vCodigoPeriodo the vCodigoPeriodo to set
	 */
	public void setvCodigoPeriodo(String vCodigoPeriodo) {
		this.getPeriodo().setvCodigoPeriodo(vCodigoPeriodo);
	}

	/**
	 * @return the vNombrePeriodo
	 */
	public String getvNombrePeriodo() {
		return getPeriodo().getvNombrePeriodo();
	}

	/**
	 * @param vNombrePeriodo the vNombrePeriodo to set
	 */
	public void setvNombrePeriodo(String vNombrePeriodo) {
		this.getPeriodo().setvNombrePeriodo(vNombrePeriodo) ;
	}
/** Impuestos **/
	/**
	 * @return the impuesto
	 */
	public Impuesto getImpuesto() {
		return impuesto;
	}
	/**
	 * @param impuesto the impuesto to set
	 */
	public void setImpuesto(Impuesto impuesto) {
		this.impuesto = impuesto;
	}
	
	
	/**
	 * @return the iImpuestosId
	 */
	public int getiImpuestosId() {
		return getImpuesto().getiImpuestosId();
	}

	/**
	 * @param iImpuestosId the iImpuestosId to set
	 */
	public void setiImpuestosId(int iImpuestosId) {
		this.getImpuesto().setiImpuestosId(iImpuestosId);
	}

	

	/**
	 * @return the vAplicacionImpuesto
	 */
	public String getvAplicacionImpuesto() {
		return getImpuesto().getvAplicacionImpuesto();
	}

	/**
	 * @param vAplicacionImpuesto the vAplicacionImpuesto to set
	 */
	public void setvAplicacionImpuesto(String vAplicacionImpuesto) {
		this.getImpuesto().setvAplicacionImpuesto(vAplicacionImpuesto);
	}

	/**
	 * @return the vNombreImpuesto
	 */
	public String getvNombreImpuesto() {
		return getImpuesto().getvNombreImpuesto();
	}

	/**
	 * @param vNombreImpuesto the vNombreImpuesto to set
	 */
	public void setvNombreImpuesto(String vNombreImpuesto) {
		this.getImpuesto().setvNombreImpuesto(vNombreImpuesto);
	}

	/**
	 * @return the vPorcentaje
	 */
	public String getvPorcentaje() {
		return getImpuesto().getvPorcentaje();
	}

	/**
	 * @param vPorcentaje the vPorcentaje to set
	 */
	public void setvPorcentaje(String vPorcentaje) {
		this.getImpuesto().setvPorcentaje(vPorcentaje);
	}

}
