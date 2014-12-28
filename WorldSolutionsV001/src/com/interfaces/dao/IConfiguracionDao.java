package com.interfaces.dao;

import java.util.List;

import com.entities.Configuracion;
import com.entities.Ejerciciofiscal;
import com.entities.Impuesto;
import com.entities.Moneda;
import com.entities.Periodo;

public interface IConfiguracionDao {
	public List<Configuracion> listaConfiguracion(int pagInicio, int pagFin, Configuracion configuracion);
	
	public Configuracion buscarConfiguracion(String vConcepto);
    public Moneda buscarMoneda(String vConcepto);
    
    public List<Ejerciciofiscal> listaEjercicioFiscal(int pagInicio, int pagFin, Ejerciciofiscal ejerccio);
    public List<Periodo> listaPeriodo(int pagInicio, int pagFin, Periodo periodo);
    public List<Impuesto> listaImpuestos(int pagInicio, int pagFin, Impuesto impuesto);
    public Impuesto buscarImpuesto(String vConcepto);
        
	
}
