package com.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Fechas {

	 public static Date getDate()
	 {
		Date fechaActual = new Date();
		return fechaActual;
		 
	 }
	 public static Timestamp timestamp(){
		 Calendar calendar = Calendar.getInstance();
		 Date now = calendar.getTime();
		 Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		 return currentTimestamp;
	 }
	 public static String fechaDDMMYY(Date fecha){
		   String CadenaFecha ="";
		    SimpleDateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");	    	
	    	if(fecha!=null)
		      CadenaFecha = Formato.format(fecha);
	    	
	    	return CadenaFecha;
	 }
	 public static String fechaYYMMDD(Date fecha){
		   String CadenaFecha ="";
		    SimpleDateFormat Formato = new SimpleDateFormat("yyyy-MM-dd");	    	
	    	if(fecha!=null)
		      CadenaFecha = Formato.format(fecha);
	    	
	    	return CadenaFecha;
	 }
	 public static Date fechaDate(String date) throws ParseException{
		// DateTime myFecha = DateTime.ParseExact(stringFercha, "dd-MM-yyyy", null);

		// DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	     return df.parse(date);
	 }
	 
	 public static int anioActual(int anios){
		 Calendar anio = Calendar.getInstance();
		 // anio actal anio.get(Calendar.YEAR);
		 anio.add(Calendar.YEAR, anios);
		 //anio.getTime().getYear();
		 return anio.get(Calendar.YEAR);
	 }
	 public static int anioFecha(Date fecha){		
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		    return Integer.parseInt(dateFormat.format(fecha)); 
		   
	        
	 }

	 public static int mesFecha(Date fecha){		
		 SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
		 return Integer.parseInt(dateFormat.format(fecha)); 
	 }
	 public static Date sumarFechasDias(Date fecha, int dias) {
		 Calendar cal = Calendar.getInstance();
		 // anio actal anio.get(Calendar.YEAR);
		 cal.add(Calendar.DATE, dias);  
		 
	        return new Date(cal.getTimeInMillis());
	    }
	 public static int diasMes(int mes, int anio){	
	
	 int m;	 
	 if(mes==4|| mes==6||mes==9||mes==11){
	        m=30;
	    }else if(mes==2){
	       
	       // para cuando el año es bisiesto
	      if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))){//si el año es bisiesto es divisible entre 4 y 100 o 400
	           m=29;
	        }
	       
	     else{
	        m=28 ;//queda pendiente para año bisiesto
	     }

	   }else{//todos los demas meses
	       m=31; 
	   }
	 return m;
	 }

	 public static String fechaConFormato(String formato){
		   String CadenaFecha ="";
		    SimpleDateFormat Formato = new SimpleDateFormat(formato);	    	
		    CadenaFecha = Formato.format(getDate());
	    	
	    	return CadenaFecha;
	 }
}
