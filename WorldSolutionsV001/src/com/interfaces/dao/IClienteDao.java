package com.interfaces.dao;

import java.util.List;

import com.entities.Clasificacioncliente;
import com.entities.Cliente;

public interface IClienteDao {
	public List<Cliente> listaCliente(int pagInicio, int pagFin, Cliente cliente);
	public List<Clasificacioncliente> listaClasificacionCliente(int pagInicio, int pagFin, Clasificacioncliente clasifcliente);
	
}
