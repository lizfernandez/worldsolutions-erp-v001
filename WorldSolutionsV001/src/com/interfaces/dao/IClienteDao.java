package com.interfaces.dao;

import java.util.List;

import com.entities.Cliente;

public interface IClienteDao {
	public List<Cliente> listaCliente(int pagInicio, int pagFin, Cliente cliente);
	/*public Cliente buscarCliente(int iClienteId);
	public boolean insertarCliente(Cliente cliente);
	public boolean insertarDireccionCliente(Direccioncliente cliente);
	public boolean actualizarCliente(Cliente cliente);
	public boolean eliminarCliente(String iClienteId);
	public boolean actualizarDireccionCliente(Direccioncliente cliente);
	*/
}
