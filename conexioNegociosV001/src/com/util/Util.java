package com.util;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



import com.entitie.Configuracion;
import com.entitie.Estado;

import com.entitie.Perfil;



public class Util {
	
	/*public static List<Sexo> listaSexo(){
		List<Sexo> listaSexo = new ArrayList<Sexo>();	
		listaSexo.add(new Sexo(1,"FEMENINO"));
		listaSexo.add(new Sexo(2,"MASCULINO"));		
		return listaSexo;
	}*/
	/*public static List<Estado> listaEstadoFiscal(){
		List<Estado> listaSexo = new ArrayList<Estado>();	
		listaSexo.add(new Estado(1,"ABIERTO"));
		listaSexo.add(new Estado(2,"CERRADO"));		
		return listaSexo;
	}*/
	/* public static List<Tipodocumento> listaaDoc(){
		 List<Tipodocumento> listaDoc = new ArrayList<Tipodocumento>();	
		 listaDoc.add(new Tipodocumento(1,"D.N.I"));
		 listaDoc.add(new Tipodocumento(2,"LIBRETA MILITAR"));
		 listaDoc.add(new Tipodocumento(3,"DOC. PASAPORTE"));	
		 listaDoc.add(new Tipodocumento(5,"RUC"));	
	  return listaDoc; 
	 }*/
	/*
	 public static List<Tipodocumentogestion> listaDocGest(){
		 List<Tipodocumentogestion> listaDoc = new ArrayList<Tipodocumentogestion>();	
		 listaDoc.add(new Tipodocumentogestion(1,"FACTURA"));
		 listaDoc.add(new Tipodocumentogestion(2,"BOLETA"));
		 listaDoc.add(new Tipodocumentogestion(3,"NOTA"));	
		 listaDoc.add(new Tipodocumentogestion(5,"GUIA DE REMISION"));	
	  return listaDoc; 
	 }
	 public static List<Tipodocumentogestion> listaDocGestAplicado(){
		 List<Tipodocumentogestion> listaDoc = new ArrayList<Tipodocumentogestion>();	
		 listaDoc.add(new Tipodocumentogestion(1,"COMPRAS"));
		 listaDoc.add(new Tipodocumentogestion(2,"VENTAS"));
		
	  return listaDoc; 
	 }
     public static List<Configuracion> listaConfiguracion(){
    	 List<Configuracion> listaConf = new ArrayList<Configuracion>();
    	 listaConf.add(new Configuracion(3,"NRO FACTURA VENTA"));
    	 listaConf.add(new Configuracion(4,"NRO BOLETA VENTA"));
    	 listaConf.add(new Configuracion(5,"NRO NOTA VENTA"));
    	 listaConf.add(new Configuracion(6,"NRO GUIA REMISION VENTA"));
    	 listaConf.add(new Configuracion(7,"RUC DE EMPRESA"));
    	 listaConf.add(new Configuracion(8,"TIPO CAMBIO"));
    	 listaConf.add(new Configuracion(9,"TIPO MONEDA"));
    	 listaConf.add(new Configuracion(10,"DESC. SNP %"));
    	 listaConf.add(new Configuracion(11,"DESC. AFP %"));
    	 listaConf.add(new Configuracion(12,"DESC. P.S %"));
    	 listaConf.add(new Configuracion(13,"DESC. C.V %"));
    	 listaConf.add(new Configuracion(14,"APORT. ESSALUD %"));
    	 listaConf.add(new Configuracion(15,"APORT. I.E.S %"));
    	 return listaConf;
     }
	  
     public static List<Clasificacioncategoria> listaClasificacioncategoria(){
    	 
    	 List<Clasificacioncategoria> listSubcategoria= new ArrayList<Clasificacioncategoria>();
    	 listSubcategoria.add(new Clasificacioncategoria(1, "PRODUCTOS"));
    	 listSubcategoria.add(new Clasificacioncategoria(2, "MATERIA PRIMA"));
    	 listSubcategoria.add(new Clasificacioncategoria(3, "SUMINISTROS Y REPUESTOS"));
    	 listSubcategoria.add(new Clasificacioncategoria(4, "ENVASES Y EMBALAJES"));
    	 return listSubcategoria;
     }
     public static List<Estado> listaEstadoDocumento (){
    	 List<Estado> listaEstado = new ArrayList<Estado>();
    	 listaEstado.add(new Estado(1, "DEUDA"));
    	 listaEstado.add(new Estado(2, "CANCELADO"));
    	 listaEstado.add(new Estado(3, "DEVOLUCION TOTAL"));
    	 listaEstado.add(new Estado(4, "DEVOLUCION PARCIAL"));
    	 
    	 return listaEstado;
     }
     */
	public static  String armarWhereLike(Class<? extends Perfil > class1) {
		// TODO Auto-generated method stub
		System.out.println(" getDeclaredFields= "+class1.getDeclaredFields());
		Field[] a = class1.getDeclaredFields();
		Method[] b =class1.getDeclaredMethods();
		Method[] c =class1.getMethods();
		
		
		return null;
	}
	public static String dia(int day){
		String monthString;
        switch (day) {
 
            case 1:  monthString = "Domingo";
                     break;
            case 2:  monthString = "lunes";
                     break;
            case 3:  monthString = "Martes";
                     break;
            case 4:  monthString = "Miercoles";
                     break;
            case 5:  monthString = "Jueves";
                     break;
            case 6:  monthString = "Viernes";
                     break;
            case 7:  monthString = "Sabado";
                     break;          
            default: monthString = "Invalid month";
                     break;
        }
		return monthString;
	}
	public static String mes(int mes){
		String monthString;
        switch (mes) {
 
            case 1:  monthString = "Enero";
                     break;
            case 2:  monthString = "Febrero";
                     break;
            case 3:  monthString = "Marzo";
                     break;
            case 4:  monthString = "Abril";
                     break;
            case 5:  monthString = "Mayo";
                     break;
            case 6:  monthString = "Junio";
                     break;
            case 7:  monthString = "Julio";
                     break;  
            case 8:  monthString = "Agosto";
            		 break;  
            case 9:  monthString = "Septiembre";
            		 break;  
            case 10:  monthString = "Octubre";
            		 break;  
            case 11:  monthString = "Noviembre";
            		 break;  
            case 12: monthString = "Diciembre";
            		break;  
            default: monthString = "Invalid month";
                     break;
        }
		return monthString;
	}
	

	
	public static <E> E comparar(Object obj1, Object obj2) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException {

		/* System.out.println("type ="+obj2);
		 System.out.println("type getClass = "+obj2.getClass().getName());
		 */
		 E objOrigen =  (E) obj2;
		 E objDestino =  (E) obj1;
		 System.out.println(" E obj= "+objOrigen);
		/// type.get
		//Class obj = Class.forName(type);
		// Class obj =type;
		Field[] fields = objOrigen.getClass().getDeclaredFields();
		
		for (Field f : fields) {

			try {
				String fieldOrigen = f.getName();
				Field fDestino = objDestino.getClass().getDeclaredField(fieldOrigen);
				f.setAccessible(true);
				fDestino.setAccessible(true);
				Object fieldValue = f.get(objOrigen);
				/**/
				if (fieldValue != null) {
					System.out.println("name field =" + fieldOrigen);
					// System.out.println(" Object fieldType = "+f.getType());
					System.out.println("valor field origen= " + fieldValue.toString());
					System.out.println("valor field destino= " + fDestino.get(objDestino));

					if (!fieldValue.toString().equals("0") && !Constantes.CAMPO_SERAILIZABLE.equals(fieldOrigen)) {
						
					fDestino.set(objDestino, fieldValue);
					// f.getType().equals(int);
					}
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// f.set(objOrigen, fieldValue);
			// Field fdestino =

        }
       // E lita = (E) obj1;
		return objDestino;
		
	}
	public static Object emptyInstance(String type) {
        //Este metodo crea una instancia de Class con el tipo
        //de dato obtenido por parametro, y luego itera sobre
        //los Constructores de esta Clase para intentar
        //crear una Instancia en base a un Constructor Vacio
        Object obj = null;
        try {
            Class clazz = Class.forName(type);

            for (java.lang.reflect.Constructor con : clazz.getConstructors()) {
                if (con.getParameterTypes().length == 0) {
                    obj = con.newInstance();
                    break;
                }
            }
        } catch (Exception e) {
            return null;
        }

        return obj;
    }
}
