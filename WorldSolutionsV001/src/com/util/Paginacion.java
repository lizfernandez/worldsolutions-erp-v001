package com.util;

import java.util.ArrayList;
import java.util.List;

public class Paginacion {
	
	public static int paginado=12;
	public static int paginaInicial = 1;
	public static int paginaMax = 1000;
	
	 public static int pagInicio(int pagina) {
		 int inicio=(pagina-1)*paginado;
	   return inicio ;
	 }
	  public static int pagFin() {
		 // int fin=(pagina)*Constantes.paginado;
		  int fin=paginado;
	   return fin ;

	 }
	  public static int pagFinMax() {
			 // int fin=(pagina)*Constantes.paginado;
			  int fin=paginaMax;
	return fin ;

		 }
	  public static int totalPagina(Long totalReg) {
	       int total= (int) ((double)(totalReg/paginado)+(double)1);
		 return total;
	 }
     public static List<Long>  listPaginas(Long totalPaginas)  {
    	 List<Long> paginas =  new ArrayList<Long>();
    	 for(int i=1;i<=totalPagina((totalPaginas));i++){
    		 paginas.add((long) i);
    	 }
    	 //paginas.add((long) paginas.size());
    	 System.out.println(" lsta pagina "+paginas.size());
    	 return paginas;
     }
}
