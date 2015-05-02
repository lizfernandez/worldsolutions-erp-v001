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

public class Ticket {

	// Ticket attribute content
	private String contentTicket = "::"
			+ (char) 27
			+ (char) 112
			+ (char) 0
			+ (char) 10
			+ (char) 100
			+ "ACCESORIOS {{nameLocal}}::\n"
			+ "Periban. Mich. {{dateTime}}\n"
			+
			// "EXPEDIDO EN: {{expedition}}\n"+
			"Emiliano Zapata Col. Centro \n"
			+ "=============================\n"
			+
			// "Periban. Mich. {{dateTime}}\n"+
			// "RFC: XAXX010101000\n"+
			// "Caja # {{box}} \n"+
			"Ticket # {{ticket}}\n"
			+ "LE ATENDIO: {{cajero}}\n"
			+
			// "{{dateTime}}\n"+
			"=============================\n"
			+ "{{items}}\n"
			+ "=============================\n"
			+ "SUBTOTAL: {{subTotal}}\n"
			+ "IVA: {{tax}}\n"
			+ "Ññ ñÑÑTOTAL: {{total}}\n\n"
			+
			// "RECIBIDO: {{recibo}}\n"+
			// "CAMBIO: {{change}}\n\n"+
			"=============================\n" + "GRACIAS POR SU COMPRA…\n"
			+ "ESPERAMOS SU VISITA NUEVAMENTE\n" + "\t::{{nameLocal}}::\n"
			+ "\n" + "\n\n\n "
			+ (char) 27+"m"
			;

	// El constructor que setea los valores a la instancia
	Ticket(String nameLocal, String expedition, String box, String ticket,
			String caissier, String dateTime, String items, String subTotal,
			String tax, String total) {
		this.contentTicket = this.contentTicket.replace("{{nameLocal}}",
				nameLocal);
		this.contentTicket = this.contentTicket.replace("{{expedition}}",
				expedition);
		this.contentTicket = this.contentTicket.replace("{{box}}", box);
		this.contentTicket = this.contentTicket.replace("{{ticket}}", ticket);
		this.contentTicket = this.contentTicket.replace("{{cajero}}", caissier);
		this.contentTicket = this.contentTicket.replace("{{dateTime}}",
				dateTime);
		this.contentTicket = this.contentTicket.replace("{{items}}", items);
		this.contentTicket = this.contentTicket.replace("{{subTotal}}",
				subTotal);
		this.contentTicket = this.contentTicket.replace("{{tax}}", tax);
		this.contentTicket = this.contentTicket.replace("{{total}}", total);
	}

	public void print() throws IOException {

		PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null); // nos da el array de los servicios de impresion

		// Creamos un arreglo de tipo byte
		// y le agregamos el string convertido (cuerpo del ticket) a bytes tal
		// como
		// lo maneja la impresora(mas bien ticketera :p)
		byte[] bytes = this.contentTicket.getBytes();
		//InputStream is = new ByteArrayInputStream(bytes);
		
		// Especificamos el tipo de dato a imprimir
		// Tipo: bytes; Subtipo: autodetectado
		DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;

		DocAttributeSet das = new HashDocAttributeSet();

		Doc doc = new SimpleDoc(bytes, flavor, das);
		
		
		// Creamos un trabajo de impresión
		DocPrintJob job = null;
		if (services.length > 0) {
			for (int i = 0; i < services.length; i++) {
				if (services[i].getName().equals("BIXOLON SRP-270")) {// aqui
																		// escribimos/elegimos
																		// la
																		// impresora
																		// por
																		// la
																		// que
																		// queremos
																		// imprimir
					job = services[i].createPrintJob();// System.out.println(i+": "+services[i].getName());
				}
			}
		}

		// Imprimimos dentro de un try obligatoriamente
		try {
			job.print(doc, null);

		} catch (PrintException ex) {
			System.out.println(ex);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Ticket ticket = new Ticket("Locallll 2", "expedicion", "box-3333", "000999", "caissier-1", "19-04-15", "items", "200", "20", "220");
		//ticket.print();
		System.out.println(ticket.contentTicket);
		
	}
	

}