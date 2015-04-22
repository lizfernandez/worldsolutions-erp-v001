package com.util;

import java.io.IOException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;



/**
 * clase modificada con el fin de imprimir el ticket de una venta.
 * 
 * @author DiegoEnrique
 *
 */
public class Impresora {
	
	private StringBuilder contenido;
	private DocPrintJob jobImpresora = null;
	
	public Impresora() {
		contenido = new StringBuilder();
		
		//Codigos para iniciar la impresion y abrir la caja registradora
		contenido.append((char) 27);
		contenido.append((char) 112);
		contenido.append((char) 0);
		contenido.append((char) 10);
		contenido.append((char) 100);
	}
		
	public void seleccionarDispositivo(String nombreDispositivo) throws IllegalAccessException{
		PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null); // nos da el array de los servicios de impresion

		if (services.length > 0) {
			for (int i = 0; i < services.length; i++) {
				if (services[i].getName().equals(nombreDispositivo)) {
					jobImpresora = services[i].createPrintJob();
				}
			}
		}
		if (jobImpresora == null) {
			throw new IllegalAccessException("No se encontro el dipositivo [ " + nombreDispositivo + " ]");
		}
		
	}
	
	public void cortarImpresion() throws IllegalAccessException {
		validarDispositivo();
		agregarSaltoLinea(5);
		contenido.append((char) 27).append("m");
	}
	
	public void agregarLinea (String... cadenas) throws IllegalAccessException {
		validarDispositivo();
		if (cadenas != null && cadenas.length > 0) {
			for (String cadena : cadenas) {
				contenido.append(cadena);
			}
		}
		contenido.append("\n");
	}
	
	public void agregarSeparacion () throws IllegalAccessException {
		agregarLinea("=============================");
	}
	
	public void agregarSaltoLinea (int cantidad) throws IllegalAccessException {
		validarDispositivo();
		int indice = 0;
		while (indice < cantidad) {
			agregarLinea();
			indice++;
		}
	}
	
	private void validarDispositivo() throws IllegalAccessException {
		if (jobImpresora == null) {
			throw new IllegalAccessException("No se ha selecionado o no existe dispositivo de impresion");
		}
	}
	
	public void imprimirTicket() throws IOException {

		byte[] bytes = this.contenido.toString().getBytes();
		
		DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
		DocAttributeSet das = new HashDocAttributeSet();

		Doc doc = new SimpleDoc(bytes, flavor, das);

		try {
			jobImpresora.print(doc, null);

		} catch (PrintException ex) {
			ex.printStackTrace();
			
		} finally {
			flavor = null;
			das = null;
			doc = null;
		}
		
	}
	
	@Override
	public String toString() {
		return contenido.toString();
	}
	
}
