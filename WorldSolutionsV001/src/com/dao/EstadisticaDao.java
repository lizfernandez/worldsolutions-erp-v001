package com.dao;

import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.interfaces.dao.IEstadisticaDao;
import com.struts.form.EstadisticaForm;
import com.util.Fechas;

public class EstadisticaDao implements IEstadisticaDao {
	private static final String PERSISTENCE_UNIT_NAME = "Stuct12";
	private static EntityManagerFactory factory;
	

	@Override
	public List<Object[]> obtenerCompraEstadistica(EstadisticaForm objFom) throws ParseException {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();     
		Query q ;
		List<Object[]> listaEstadisticaGeneral = null ;		
		String sql= "";
		
		if(objFom.getCondicion()!=null){			
			if(objFom.getCondicion().equals("diario")){
				 sql= "SELECT DAYNAME(dIngresoProductoFecha) , SUM(fIngresoProductoTotal) AS Cantidad FROM ingresoproducto "+
	                    " WHERE WEEK(dIngresoProductoFecha)=WEEK(now())"+
	                     "   GROUP BY DAYNAME (dIngresoProductoFecha),WEEK(now()), year(now()) "+
	                      " ORDER BY (dIngresoProductoFecha) asc";
			}
			else if(objFom.getCondicion().equals("mensual") && objFom.getFechaInicio()=="" || objFom.getFechaFin()==""){
			sql= "SELECT MONTHNAME(dIngresoProductoFecha), SUM(fIngresoProductoTotal) AS Cantidad FROM ingresoproducto "+
				  "WHERE year(dIngresoProductoFecha)='"+objFom.getAnio()+"'"+
                   " GROUP BY  MONTHNAME(dIngresoProductoFecha) "+
				   " ORDER BY (dIngresoProductoFecha) asc";	
			}
			else if(objFom.getCondicion().equals("mensual") &&  objFom.getFechaInicio()!="" && objFom.getFechaFin()!=""){
					sql= "SELECT MONTHNAME(dIngresoProductoFecha), SUM(fIngresoProductoTotal) AS Cantidad FROM ingresoproducto "+
							  "WHERE year(dIngresoProductoFecha)='"+objFom.getAnio()+"'"+
							  " and dIngresoProductoFecha BETWEEN '"+Fechas.fechaYYMMDD(Fechas.fechaDate(objFom.getFechaInicio()))+"' and '"+Fechas.fechaYYMMDD(Fechas.fechaDate(objFom.getFechaFin()))+"'"+
			                  " GROUP BY  MONTHNAME(dIngresoProductoFecha) "+
							  " ORDER BY (dIngresoProductoFecha) asc";	
				}
			
		}
		
		
		System.out.println("sql ="+sql);
    	    q = em.createNativeQuery(sql);

    	    listaEstadisticaGeneral = q.getResultList(); 
    	    return listaEstadisticaGeneral;
	}

	@Override
	public List<Object[]> obtenerVentasEstadistica(EstadisticaForm objFom) throws ParseException {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();     
		Query q ;
		String sql="";
		List<Object[]> listaEstadisticaGeneral = null ;
		if(objFom.getCondicion()!=null){			
			if(objFom.getCondicion().equals("diario")){
				sql= "SELECT DAYNAME(dventaFecha) AS Gestores, SUM(fVentaTotal) AS Cantidad FROM venta "+
	                    "WHERE WEEK(dventaFecha)=WEEK(now())"+
	                    " GROUP BY DAYNAME (dventaFecha),WEEK(now()), year(now()) "+
	                    " ORDER BY (dventaFecha) asc";
			}
			else if(objFom.getCondicion().equals("mensual") && objFom.getFechaInicio()=="" || objFom.getFechaFin()==""){
			sql= "SELECT MONTHNAME(dventaFecha), SUM(fVentaTotal) AS Cantidad FROM venta "+
				  "WHERE year(dventaFecha)='"+objFom.getAnio()+"'"+
                  "GROUP BY  MONTHNAME(dventaFecha) "+
                  " ORDER BY (dventaFecha) asc";
			}
			else if(objFom.getCondicion().equals("mensual") &&  objFom.getFechaInicio()!="" && objFom.getFechaFin()!=""){
					sql= "SELECT MONTHNAME(dventaFecha), SUM(fVentaTotal) AS Cantidad FROM ingresoproducto "+
							  "WHERE year(dventaFecha)='"+objFom.getAnio()+"'"+
							  " and dventaFecha BETWEEN '"+Fechas.fechaYYMMDD(Fechas.fechaDate(objFom.getFechaInicio()))+"' and '"+Fechas.fechaYYMMDD(Fechas.fechaDate(objFom.getFechaFin()))+"'"+
			                  " GROUP BY  MONTHNAME(dventaFecha) "+
			                  " ORDER BY (dventaFecha) asc";	
				}
			
		}

	
    	    q = em.createNativeQuery(sql);

    	    listaEstadisticaGeneral = q.getResultList(); 
    	    return listaEstadisticaGeneral;
	}

	@Override
	public List<Object[]> obtenerUtilidadesEstadistica(EstadisticaForm objFom) throws ParseException {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();     
		Query q ;
		List<Object[]> listaEstadisticaGeneral = null ;
		String sql="";
		if(objFom.getCondicion()!=null){			
			if(objFom.getCondicion().equals("diario")){
				 sql= "SELECT DAYNAME(dventaFecha), (SUM(fVentaTotal)-SUM(fIngresoProductoTotal)) AS Cantidad FROM venta,ingresoproducto "+
		                    "    WHERE WEEK(dventaFecha)=WEEK(now()) and WEEK(dIngresoProductoFecha)=WEEK(now()) "+
		                     "    and(DAYOFWEEK(dventaFecha)=DAYOFWEEK(dIngresoProductoFecha))"+
		                     "   GROUP BY DAYNAME (dventaFecha),WEEK(now()), year(now()) " +
			                    " ORDER BY (dventaFecha) asc";
			}
			else if(objFom.getCondicion().equals("mensual") && objFom.getFechaInicio()=="" || objFom.getFechaFin()==""){
				sql= "SELECT MONTHNAME(dventaFecha) AS Gestores, (SUM(fVentaTotal)-SUM(fIngresoProductoTotal)) AS Cantidad  FROM venta,ingresoproducto "+
                        " WHERE year(dventaFecha)='"+objFom.getAnio()+"'"+
                        " and(MONTHNAME(dventaFecha)=MONTHNAME(dIngresoProductoFecha)) "+
                        "  GROUP BY  MONTHNAME(dventaFecha)" +
	                    " ORDER BY (dventaFecha) asc";	
			}
			else if(objFom.getCondicion().equals("mensual") &&  objFom.getFechaInicio()!="" && objFom.getFechaFin()!=""){
				sql= "SELECT MONTHNAME(dventaFecha) AS Gestores, (SUM(fVentaTotal)-SUM(fIngresoProductoTotal)) AS Cantidad  FROM venta,ingresoproducto "+
                        " WHERE year(dventaFecha)='"+objFom.getAnio()+"'"+
                        " and dventaFecha BETWEEN '"+Fechas.fechaYYMMDD(Fechas.fechaDate(objFom.getFechaInicio()))+"' and '"+Fechas.fechaYYMMDD(Fechas.fechaDate(objFom.getFechaFin()))+"'"+
                        " and(MONTHNAME(dventaFecha)=MONTHNAME(dIngresoProductoFecha)) "+
                        "  GROUP BY  MONTHNAME(dventaFecha)" +
	                    " ORDER BY (dventaFecha) asc";	
				
					}
			
		}

    	    q = em.createNativeQuery(sql);

    	    listaEstadisticaGeneral = q.getResultList(); 
    	    return listaEstadisticaGeneral;
	}

	@Override
	public List<Object[]> obtenerEstadisticaMejoresClientes(
			EstadisticaForm objFom) throws ParseException {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();     
		Query q ;
		String sql="";
		List<Object[]> listaEstadisticaGeneral = null ;
		if(objFom.getCondicion()!=null){			
			if(objFom.getCondicion().equals("diario")){
				sql= "SELECT  DAYNAME(v.dventaFecha),LEFT(c.vClienteRazonSocial, 12), SUM(v.fVentaTotal) AS Cantidad "+
                     " FROM venta v inner join Cliente c on (v.iClienteId= c.iClienteId) "+
	                 " WHERE WEEK(v.dventaFecha)= WEEK(now()) "+
	                  " GROUP BY c.vClienteRazonSocial, DAYNAME(v.dventaFecha),WEEK(now()), year(now()) "+
                      " ORDER BY Cantidad DESC "+
                      " LIMIT 0, 10;  ";
			}
			else if(objFom.getCondicion().equals("mensual") && objFom.getFechaInicio()=="" || objFom.getFechaFin()==""){
				sql= "	SELECT MONTHNAME(v.dventaFecha),LEFT(c.vClienteRazonSocial, 12), SUM(v.fVentaTotal) AS Cantidad "+
				  " FROM venta v inner join Cliente c on (v.iClienteId= c.iClienteId)"+
					"                    WHERE year(v.dventaFecha)= '"+objFom.getAnio()+"'"+
					 "                    GROUP BY c.vClienteRazonSocial,MONTHNAME(v.dventaFecha)"+
				      "                 ORDER BY v.dventaFecha asc";
				/*sql= "SELECT MONTHNAME(dventaFecha), SUM(fVentaTotal) AS Cantidad FROM venta "+
				  "WHERE year(dventaFecha)='"+objFom.getAnio()+"'"+
                  "GROUP BY  MONTHNAME(dventaFecha) ";	*/
			}
			else if(objFom.getCondicion().equals("mensual") &&  objFom.getFechaInicio()!="" && objFom.getFechaFin()!=""){
					sql= "SELECT MONTHNAME(dventaFecha), SUM(fVentaTotal) AS Cantidad FROM ingresoproducto "+
							  "WHERE year(dventaFecha)='"+objFom.getAnio()+"'"+
							  " and dventaFecha BETWEEN '"+Fechas.fechaYYMMDD(Fechas.fechaDate(objFom.getFechaInicio()))+"' and '"+Fechas.fechaYYMMDD(Fechas.fechaDate(objFom.getFechaFin()))+"'"+
			                  " GROUP BY  MONTHNAME(dventaFecha) ";	
				}
			
		}

	
    	    q = em.createNativeQuery(sql);

    	    listaEstadisticaGeneral = q.getResultList(); 
    	    return listaEstadisticaGeneral;
	}

	@Override
	public List<Object[]> obtenerEstadisticaClientesDeudores(
			EstadisticaForm objFom) throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}

}
