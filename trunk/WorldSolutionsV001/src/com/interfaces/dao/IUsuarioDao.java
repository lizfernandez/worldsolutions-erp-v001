package com.interfaces.dao;

import java.util.List;

import com.entities.Usuario;

public interface IUsuarioDao {
	public List<Usuario> listaUsuario(int pagInicio, int pagFin, Usuario Usuario);
/*	public Usuario buscarUsuario(int iUsuarioId);
	public boolean insertarUsuario(Usuario Usuario);
	public boolean actualizarUsuario(Usuario Usuario);
	public boolean eliminarUsuario(String iUsuarioId);
*/	public List<Usuario> login(String usuario, String pass,String dni);

}
