import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dao.ProductoDao;
import com.entities.Producto;
import com.util.Constantes;
import com.util.Fechas;





public class prueba {
	//	private static final String PERSISTENCE_UNIT_NAME = "Stuct12";
	//	private static EntityManagerFactory factory;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> listaFechas = new ArrayList<String>();
		List<Float> listaTotalDia = new ArrayList<Float>();
		Date fechaInicio = new Date();
		Date fechaFin = Fechas.sumarFechasDias(fechaInicio, 0);
		
		String fechaInicioStr = Fechas.fechaFormato(fechaInicio, Constantes.formatoFechaDia).toUpperCase();
		String fechaFinStr = Fechas.fechaFormato(fechaFin, Constantes.formatoFechaDia).toUpperCase();
				
		System.out.println(fechaInicioStr);
		System.out.println(fechaFinStr);
		
//		listaFechas.add(fechaInicioStr);
		if (!fechaInicioStr.equals(fechaFinStr)) {
			String proximaFecha = fechaInicioStr;
//			listaFechas.add(proximaFecha);
//			System.out.println(proximaFecha);
//			System.out.println("Validacion: " + proximaFecha.equals(fechaFinStr));
//			
//			if (!proximaFecha.equals(fechaFinStr)) {
				
				System.out.println("Validacion 2: " + proximaFecha.equals(fechaFin));
				int indice = 1;
				while (!proximaFecha.equals(fechaFinStr)) {
					listaFechas.add(proximaFecha);
					proximaFecha = Fechas.fechaFormato(Fechas.sumarFechasDias(fechaInicio, indice), Constantes.formatoFechaDia).toUpperCase();
					indice++;
					System.out.println("Proxima fecha: " + proximaFecha);
					
				}
				listaFechas.add(fechaFinStr);
				
//			}
		} else {
			listaFechas.add(fechaInicioStr);
		}

		
		System.out.println("lista: " + Arrays.toString(listaFechas.toArray()));
	}
	

}
