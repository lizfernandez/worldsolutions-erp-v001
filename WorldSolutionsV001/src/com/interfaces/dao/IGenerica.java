package com.interfaces.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public interface IGenerica {
	
	public EntityManager getInstancia();
	public EntityTransaction entityTransaction();
	public <E> Long totalLista(E entidad);
	public <G> List<G> listaEntidadGenerica(Class<G> entidad);
	public <G> List<G> listaEntidadGenericaSinCodigo(String entidad);
	public <G> List<G> listaEntidadPaginada(String sentencia, int pagInicio, int pagFin);
//	public <E> E findEndidad(E entidad, int iEntidadId);
//	public <E> E findEndidadBD(E entidad, String siEntidadId , int iEntidadId);
	public <E> E findEndidad(Class<E> entidad, int iEntidadId);
	public <E> E findEndidadBD(Class<E> entidad, String siEntidadId , int iEntidadId);
	
	public <E> void persistEndidad(E entidad);
	public <E> boolean insertarUnaEndidad(E entidad);
	public <E> boolean actualizarUnaEndidad(E entidad);
	public <E> void mergeEndidad(E entidad);
	public <E> void eliminarUnaEndidad(E entidad, String sEntidadId, String iEntidadId);
	
	public <E> String callSPCalculoCodigo(E entidad);
	public int  callSPPeriodoActual();
	public <E> void refreshEndidad(E entidad);
	public boolean commitEndidad(EntityTransaction ext);
	public void revertirCambios(EntityTransaction ext);
	public String  callSPNro_Documento(int iTipoDocumentoId,String tabla, String campoTablaNumeroDoc,int iSucursalId);
	
	
	

}