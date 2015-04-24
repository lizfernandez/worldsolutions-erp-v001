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
	private int longitudLlinea = 42;
	
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
	
	public void agregarLineaCentrada (String cadena) throws IllegalAccessException {
		validarDispositivo();
		int espacioCentrar = (longitudLlinea - cadena.trim().length())/2;
		while (espacioCentrar > 0) {
			contenido.append(" ");
			espacioCentrar--;
		}
		contenido.append(cadena);
		contenido.append("\n");
	}
	
	public void agregarLinea (String cadena) throws IllegalAccessException {
		validarDispositivo();
		contenido.append(cadena);
		contenido.append("\n");
	}
	
	public void agregarSeparacion () throws IllegalAccessException {
		int contador = 0;
		while (contador < longitudLlinea) {
			contenido.append("-");
			contador++;
		}
		contenido.append("\n");
	}
	
	public void agregarSaltoLinea (int cantidad) throws IllegalAccessException {
		validarDispositivo();
		int indice = 0;
		while (indice < cantidad) {
			contenido.append("\n");
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
	
	public void agregarLineaDerecha(String cadena) throws IllegalAccessException {
		validarDispositivo();
		int espacioCentrar = longitudLlinea - cadena.trim().length();
		while (espacioCentrar > 0) {
			contenido.append(" ");
			espacioCentrar--;
		}
		contenido.append(cadena);
		contenido.append("\n");
	}

	@Override
	public String toString() {
		return contenido.toString();
	}

	public void agregarLinea(String titulo, int espacio, String descripcion) throws IllegalAccessException {
		validarDispositivo();
		int espacioTitulo = espacio - titulo.length();
		
		contenido.append(titulo);
		while (espacioTitulo > 0) {
			contenido.append(" ");
			espacioTitulo--;
		}
		contenido.append(": ").append(descripcion).append("\n");
	}

	public void agregarLinea(Object[][] camposDetallesLinea) throws IllegalAccessException {
		StringBuilder lineaDetalle = new StringBuilder();
		String valor;
		int posicion;
		int posicionFinal;
		int longitudMaxima;
		int tipo;
		int longitud = camposDetallesLinea.length;
		int indice = 0;
		while (indice < longitud) {

			valor = camposDetallesLinea[indice][0].toString();
			posicion = Integer.parseInt(camposDetallesLinea[indice][1].toString());
			tipo = Integer.parseInt(camposDetallesLinea[indice][2].toString());
			indice++;
			
			if (indice < longitud) {
				posicionFinal = Integer.parseInt(camposDetallesLinea[indice][1].toString());
			} else {
				posicionFinal = longitudLlinea;
			}
			longitudMaxima = posicionFinal - posicion;
			if (tipo > 0) {
				lineaDetalle.append(Util.completarEspacioDerecha(valor, longitudMaxima));
			} else {
				lineaDetalle.append(Util.completarEspacioIzquierda(valor, longitudMaxima));
			}
			
		}
		agregarLinea(lineaDetalle.toString());
		
	}

}
