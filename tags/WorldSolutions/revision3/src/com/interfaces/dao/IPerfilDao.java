package com.interfaces.dao;

import java.util.List;

import com.entities.Perfil;
import com.entities.Permiso;

public interface IPerfilDao {
	public List<Perfil> listaPerfil(int pagInicio, int pagFin, Perfil perfil);
	public List<Permiso> listaPermiso(int pagInicio, int pagFin);
	public List<Permiso> listaFindPermiso(int iUsuarioId);
	public boolean callProcedurePermiso(int iUsuarioId, String vCodigoPermiso, int cantidad);
	public   void eliminarPermisos(int iEntidadId);
/*	public Perfil buscarPerfil(int iPerfilId);
	public boolean insertarPerfil(Perfil perfil);
	public boolean actualizarPerfil(Perfil perfil);
	public boolean eliminarPerfil(String iPerfilId);
*/	
}
