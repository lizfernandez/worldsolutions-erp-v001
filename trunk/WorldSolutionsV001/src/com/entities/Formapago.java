package com.entities;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the formapago database table.
 * 
 */
@Entity
@Table(name="formapago")
public class Formapago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int iFormaPago;

	@Column(nullable=false, length=45)
	private String vFormaPagoDescripcion;

	//bi-directional many-to-one association to Venta
	//@OneToMany(mappedBy="formapago")
	//private List<Venta> ventas;

    public Formapago() {
    }

	/**
	 * @return the iFormaPago
	 */
	public int getiFormaPago() {
		return iFormaPago;
	}

	/**
	 * @param iFormaPago the iFormaPago to set
	 */
	public void setiFormaPago(int iFormaPago) {
		this.iFormaPago = iFormaPago;
	}

	/**
	 * @return the vFormaPagoDescripcion
	 */
	public String getvFormaPagoDescripcion() {
		return vFormaPagoDescripcion;
	}

	/**
	 * @param vFormaPagoDescripcion the vFormaPagoDescripcion to set
	 */
	public void setvFormaPagoDescripcion(String vFormaPagoDescripcion) {
		this.vFormaPagoDescripcion = vFormaPagoDescripcion;
	}

	/**
	 * @return the ventas
	 *//*
	public List<Venta> getVentas() {
		return ventas;
	}

	*//**
	 * @param ventas the ventas to set
	 *//*
	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}*/

	
}