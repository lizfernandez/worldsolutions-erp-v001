package com.util;

import java.io.PrintWriter;

public class Imprimir {
	
	
	public static void Dibuja_Linea(PrintWriter ps) {
	        try {
	            ps.println("----------------------------------------");
	        } catch (Exception e) {
	            System.out.print(e);
	        }
	    }

	//para cortar el papel de mi ticketera
	 public static void cortar(PrintWriter ps) {

	        try {
	            char[] ESC_CUT_PAPER = new char[]{0x1B, 'm'};
	            ps.write(ESC_CUT_PAPER);

	        } catch (Exception e) {
	            System.out.print(e);
	        }
	    }

	 public static void correr(int fin, PrintWriter pw) {
	        try {
	            int i = 0;
	            for (i = 1; i <= fin; i++) {
	                pw.println("");
	            }
	        } catch (Exception e) {
	            System.out.print(e);
	        }
	    }

	    public static void setFormato(double formato, PrintWriter pw) {
	        try {
	            char[] ESC_CUT_PAPER = new char[]{0x1B, '!', (char) formato};
	            pw.write(ESC_CUT_PAPER);

	        } catch (Exception e) {
	            System.out.print(e);
	        }
	    }

	// para el color de mi ticketera
	    public static void setRojo(PrintWriter pw) {
	        try {
	            char[] ESC_CUT_PAPER = new char[]{0x1B, 'r', 1};
	            pw.write(ESC_CUT_PAPER);
	        } catch (Exception e) {
	            System.out.print(e);
	        }
	    }

	    public static void setNegro(PrintWriter pw) {
	        try {
	            char[] ESC_CUT_PAPER = new char[]{0x1B, 'r', 0};
	            pw.write(ESC_CUT_PAPER);

	        } catch (Exception e) {
	            System.out.print(e);
	        }
	    }
}
