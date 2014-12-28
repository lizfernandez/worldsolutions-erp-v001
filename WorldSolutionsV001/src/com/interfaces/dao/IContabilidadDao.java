package com.interfaces.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.entities.Cajachica;
import com.entities.Cuenta;
import com.entities.Elementocuenta;
import com.entities.Ingresoproducto;
import com.entities.Librodiario;
import com.entities.Libromayor;
import com.entities.vo.LibroDiarioVo;


public interface IContabilidadDao {
	public List<Elementocuenta> listaElementoCuenta(String iElementoCuentasId);
	public List<Cuenta> listaPartida(int iElementoCuentasId);
	public List<Cuenta> listaSubPartida(String vCodigo);
	public List<Cuenta> listaSubPartidaCodigo(String vCodigo);
	
	public Cuenta bucarCuenta(String vCodigo);
	public List<Librodiario> listaCajaChica(int pagInicio, int pagFin, Librodiario Librodiario, int iPeriodoId);
	public List<Librodiario> listaCuentas(int pagInicio, int pagFin, Librodiario libroDiario, int iPeriodoId);
	public List<Librodiario> listaLibroDiario(int pagInicio, int pagFin, Librodiario libroDiario, int iPeriodoId);
	public List<Libromayor> listaLibroMayor(int pagInicio, int pagFin, Librodiario libroDiario, int iPeriodoId) throws ParseException;
	public List<Librodiario> listaBalanceGeneral(int pagInicio, int pagFin, Librodiario libroDiario, int iPeriodoId);
	
	public void callCompraContabilidad(int iIngresoProductoId, Date fechaProximoPago,float fMontoAdelantado, int xiUsuarioId, int numeroLetras, int xnumeroDias, String mode, int iPeriodoId, int numeroLetra);
	public void callDevCompraContabilidad(int iIngresoProductoId, int xiUsuarioId, String mode, int iPeriodoId);
	public void callVentaContabilidad(int iVentaId, Date fechaProximoPago,float fMontoAdelantado, int xiUsuarioId, int numeroLetras, int xnumeroDias, String mode, int iPeriodoId,int nNumeroLetra);
	public void callDevVentaContabilidad(int iVentaId, int xiUsuarioId, String mode, int iPeriodoId);
	
}
