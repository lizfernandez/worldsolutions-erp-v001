package com.entities.vo;

import java.io.Serializable;

public class EstadisticaVo implements Serializable {	
   private static final long serialVersionUID = 1L;
   private String dia;
   private double cantidad;
   private int anio;
   private String nombre;

/**
 * @return the dia
 */
public String getDia() {
	return dia;
}
/**
 * @param dia the dia to set
 */
public void setDia(String dia) {
	this.dia = dia;
}
/**
 * @return the cantidad
 */
public double getCantidad() {
	return cantidad;
}
/**
 * @param cantidad the cantidad to set
 */
public void setCantidad(double cantidad) {
	this.cantidad = cantidad;
}
/**
 * @return the anio
 */
public int getAnio() {
	return anio;
}
/**
 * @param anio the anio to set
 */
public void setAnio(int anio) {
	this.anio = anio;
}
/**
 * @return the nombre
 */
public String getNombre() {
	return nombre;
}
/**
 * @param nombre the nombre to set
 */
public void setNombre(String nombre) {
	this.nombre = nombre;
}

   
   
}
