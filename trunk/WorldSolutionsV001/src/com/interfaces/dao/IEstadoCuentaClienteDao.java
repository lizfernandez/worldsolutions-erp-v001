package com.interfaces.dao;

import java.util.List;

import com.entities.Estadocuentacliente;
import com.entities.Letracliente;
import com.entities.Letraproveedor;

public interface IEstadoCuentaClienteDao {
	public List<Estadocuentacliente> listaEstadocuentacliente(int pagInicio, int pagFin, Estadocuentacliente estadoCuentaProveedor);
    public List<Object[]> listaVenta(int pagInicio, int pagFin, Estadocuentacliente estadocuentacliente);
    public List<Letracliente> listaLetraCliente(int pagInicio, int pagFin, Letracliente letraCliente);
}
