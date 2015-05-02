package com.interfaces.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.entities.Periodo;
public interface CopyOfIGenerica {
	
	public EntityManager getInstancia();
	public EntityTransaction entityTransaction();
	public <E> Long totalLista(E entidad);
	public <G> List<G> listaEntidadGenerica(G entidad);
	public <G> List<G> listaEntidadGenericaSinCodigo(String entidad);
	public <G> List<G> listaEntidadPaginada(String sentencia, int pagInicio, int pagFin);
	public <E> E findEndidad(E entidad, int iEntidadId);
	public <E> void persistEndidad(E entidad);
	public <E> boolean insertarUnaEndidad(E entidad);
	public <E> boolean actualizarUnaEndidad(E entidad);
	public <E> void mergeEndidad(E entidad);
	public <E> void eliminarUnaEndidad(E entidad, String sEntidadId, String iEntidadId);
	public <E> String callSPCalculoCodigo(E entidad);
	public int  callSPPeriodoActual();
	public <E> void refreshEndidad(E entidad);
	public boolean commitEndidad(EntityTransaction ext);
	
	
	

}