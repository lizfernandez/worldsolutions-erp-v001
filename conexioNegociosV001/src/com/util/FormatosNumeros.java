package com.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class FormatosNumeros {
	

	public static String FormatoDecimalMoneda(Double numero){
		String cadenaDecimal ="";
		
		
		
		//DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		DecimalFormatSymbols simbolos = DecimalFormatSymbols.getInstance(Locale.ENGLISH);
	  /*  simbolo.setDecimalSeparator('.');
	    simbolo.setGroupingSeparator(',');*/
	    DecimalFormat formateador = new DecimalFormat("###,##0.00",simbolos);
	
        if(numero!=null)
        	cadenaDecimal = formateador.format ((numero));
		//Este daria a la salida 1,000
       
		
		return cadenaDecimal;
	}
	
	public static String FormatoDecimalMonedaDif(Double numero1, Double numero2){
	
	   String cadenaDecimal ="";
	   Double diferencia =0.0;
	   if(numero2!=null)
		   diferencia = numero1 - numero2;
	   else
		   diferencia = numero1 - 0.0;
		   
	   
	    DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
	    simbolo.setDecimalSeparator('.');
	    simbolo.setGroupingSeparator(',');
	    DecimalFormat formateador = new DecimalFormat("###,##0.00",simbolo);
			
     
        cadenaDecimal = formateador.format (diferencia);
		//Este daria a la salida 1,000
		
		return cadenaDecimal;
	}
	public static String FormatoDecimalMonedaSum(Double numero1, Double numero2){
		
		   String cadenaDecimal ="";
		   Double suma =0.0;		  
		   suma = numero1 + numero2;
		 	   
		   
		    DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
		    simbolo.setGroupingSeparator(',');
		    DecimalFormat formateador = new DecimalFormat("###,###.00",simbolo);
				
	     
	        cadenaDecimal = formateador.format (suma);
			//Este daria a la salida 1,000
			
			return cadenaDecimal;
		}
	public static Double redondedoDecimal(Double numero1){
		return Math.rint(numero1*100)/100;
	}
	public static float redondedoDecimal(Float numero1){
		return (float) (Math.rint(numero1*100)/100);
	}
}
