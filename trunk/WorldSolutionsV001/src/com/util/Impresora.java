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
	
	private String contenido;
	private DocPrintJob jobImpresora = null;
	private int longitudLinea = 40;
	
	public Impresora() {
		
		//Codigos para iniciar la impresion y abrir la caja registradora
		contenido = ""+ (char) 27 + (char) 112
				+ (char) 0
				+ (char) 10
				+ (char) 100;
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
		contenido += (char) 27+"m";
	}
	
	public void agregarLineaCentrada (String cadena) throws IllegalAccessException {
		validarDispositivo();
		int espacioCentrar = (longitudLinea - cadena.trim().length())/2;
		while (espacioCentrar > 0) {
			contenido += " ";
			espacioCentrar--;
		}
		contenido += cadena + "\n";
	}
	
	public void agregarLinea (String cadena) throws IllegalAccessException {
		validarDispositivo();
		contenido += cadena + "\n";
	}
	
	public void agregarSeparacion () throws IllegalAccessException {
		int contador = 0;
		while (contador < longitudLinea) {
			contenido += "-";
			contador++;
		}
		contenido += "\n";
	}
	
	public void agregarSaltoLinea (int cantidad) throws IllegalAccessException {
		validarDispositivo();
		int indice = 0;
		while (indice < cantidad) {
			contenido += "\n";
			indice++;
		}
	}
	
	private void validarDispositivo() throws IllegalAccessException {
		if (jobImpresora == null) {
			throw new IllegalAccessException("No se ha selecionado o no existe dispositivo de impresion");
		}
	}
	
	public void imprimirTicket() throws IOException {

		byte[] bytes = this.contenido.getBytes();
		
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
		
		contenido += Util.completarEspacioIzquierda(cadena, longitudLinea) + "\n";
	}

	@Override
	public String toString() {
		return contenido;
	}

	public void agregarTituloIzquierda(String titulo, int espacio, String descripcion) throws IllegalAccessException {
		validarDispositivo();
		int espacioTitulo = espacio - titulo.length();
		String linea = Util.completarEspacioDerecha(titulo, espacioTitulo) + ": " + descripcion;
		if (linea.length() > longitudLinea) {
			
			do {
				contenido += linea.substring(0, longitudLinea) + "\n";
				if (linea.length() > longitudLinea) {
					linea = linea.substring(longitudLinea);
				}
				
			} while (linea.length() > longitudLinea);
			
		}
		contenido += linea + "\n";
		
	}


	public void agregarTituloDerecha(String titulo, int espacio, String descripcion) throws IllegalAccessException {
		validarDispositivo();
		String lineaTitulo;
		int espacioTitulo = espacio - titulo.length();
		lineaTitulo = Util.completarEspacioDerecha(titulo, espacioTitulo) + ": " + descripcion;
		
		contenido += Util.completarEspacioIzquierda(lineaTitulo, longitudLinea) + "\n";
		
	}
	
	public void agregarLinea(Object[][] camposDetallesLinea) throws IllegalAccessException {
		StringBuilder lineaDetalle = new StringBuilder();
		String valor;
		int posicionInicial;
		int posicionFinal;
		int longitudMaxima;
		int tipo;
		int longitud = camposDetallesLinea.length;
		int indice = 0;
		while (indice < longitud) {

			valor = camposDetallesLinea[indice][0].toString();
			posicionInicial = Integer.parseInt(camposDetallesLinea[indice][1].toString());
			tipo = Integer.parseInt(camposDetallesLinea[indice][2].toString());
			indice++;
			
			if (indice < longitud) {
				posicionFinal = Integer.parseInt(camposDetallesLinea[indice][1].toString());
			} else {
				posicionFinal = longitudLinea;
			}
			longitudMaxima = posicionFinal - posicionInicial;
			
			if (valor.length() > longitudMaxima) {
				int espacioRestante = longitudLinea - posicionInicial;
				
				if (valor.length() > espacioRestante) {
					//Se crea el espacio del tap
					String tabulacion = Util.completarEspacioDerecha("", posicionInicial-3);
					String linea;
					System.out.println("Total : " + valor.length() + " Espacio : " + espacioRestante);
					linea = valor.substring(0, espacioRestante-1);
					valor = valor.substring(espacioRestante);
					
					lineaDetalle.append(linea).append("\r\n");
					lineaDetalle.append(tabulacion);
					longitudMaxima+=3;
					
				}
			}
			if (tipo > 0) {
				lineaDetalle.append(Util.completarEspacioDerecha(valor, longitudMaxima));
			} else {
				lineaDetalle.append(Util.completarEspacioIzquierda(valor, longitudMaxima));
			}
			
			
			
		}
		agregarLinea(lineaDetalle.toString());
		
	}

}
