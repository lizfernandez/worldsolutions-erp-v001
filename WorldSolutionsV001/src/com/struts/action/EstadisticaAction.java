package com.struts.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


import com.dao.EstadisticaDao;
import com.entities.vo.EstadisticaVo;
import com.google.gson.Gson;

import com.struts.form.EstadisticaForm;

import com.util.Constantes;
import com.util.FormatosNumeros;

public class EstadisticaAction extends DispatchAction {
	// --------------------------------------------------------- Instance
	// Variables
	// --------------------------------------------------------- Methods

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws IOException
	 */
	public ActionForward estadisticaGeneral(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		/*** Validamos la session activa y logeada ***/
		String msn = "";
		/*
		 * HttpSession sesion = request.getSession();
		 * 
		 * if(sesion.getId()!=(sesion.getAttribute("id"))){
		 * response.sendRedirect("login.do?metodo=logout"); } else{
		 */
		String mode = request.getParameter("mode");
		EstadisticaForm objFom = (EstadisticaForm) form;

		if (mode.equals("GE")) {// estaditica general

			if (objFom.getCondicion() == null)
				objFom.setCondicion("diario");
			msn = "showEstadisticaGeneral";
		}
		if (mode.equals("CO")) {// estaditica Compras

			if (objFom.getCondicion() == null)
				objFom.setCondicion("diario");
			msn = "showEstadisticaCompras";
		}
		if (mode.equals("VE")) {// estaditica Ventas

			if (objFom.getCondicion() == null)
				objFom.setCondicion("diario");
			msn = "showEstadisticaVentas";
		}
		if (mode.equals("CL")) {// estaditica Clientes

		/*	if (objFom.getCondicion() == null)
				objFom.setCondicion("diario");*/
			msn = "showEstadisticaClientes";
		}
		if (mode.equals("PR")) {// estaditica Proveedores

			if (objFom.getCondicion() == null)
				objFom.setCondicion("diario");
			msn = "showEstadisticaProveedores";
		}
		// }
		return mapping.findForward(msn);
	}

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws ParseException
	 */
	public ActionForward jsonEstadisticaCompra(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ParseException {
		response.setContentType("text/json");

		List<EstadisticaVo> lista = new ArrayList<EstadisticaVo>();
		List<Object[]> listaEstadistica = new ArrayList<Object[]>();
	

		EstadisticaDao estadisticaDao = new EstadisticaDao();
		EstadisticaForm objFom = (EstadisticaForm) form;
		listaEstadistica = estadisticaDao.obtenerCompraEstadistica(objFom);

		for (Object[] obj : listaEstadistica) {
			EstadisticaVo obs = new EstadisticaVo();
			obs.setDia(obj[0].toString());
			obs.setCantidad(FormatosNumeros.redondedoDecimal(Double
					.parseDouble(obj[1].toString())));
			lista.add(obs);
		}

		Gson gson = new Gson();

		String jsonOutput = gson.toJson(lista);

		PrintWriter pw;
		pw = response.getWriter();
		pw.write(jsonOutput);
		System.out.println(jsonOutput.toString());
		pw.flush();
		pw.close();

		return null;

	}
	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws ParseException
	 */
	public ActionForward jsonEstadisticaProductosCompra(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ParseException {
		response.setContentType("text/json");

		List<EstadisticaVo> lista = new ArrayList<EstadisticaVo>();
		List<Object[]> listaEstadistica = new ArrayList<Object[]>();
	

		EstadisticaDao estadisticaDao = new EstadisticaDao();
		EstadisticaForm objFom = (EstadisticaForm) form;
		
		String tipoCompra = request.getParameter("tipoCompra");
		if(tipoCompra.equals(Constantes.proMax)){
			listaEstadistica = estadisticaDao.obtenerCompraEstadistica(objFom);
		}
		if(tipoCompra.equals(Constantes.proMes)){
			listaEstadistica = estadisticaDao.obtenerCompraEstadistica(objFom);
		}

		for (Object[] obj : listaEstadistica) {
			EstadisticaVo obs = new EstadisticaVo();
			obs.setDia(obj[0].toString());
			obs.setCantidad(FormatosNumeros.redondedoDecimal(Double
					.parseDouble(obj[1].toString())));
			lista.add(obs);
		}

		Gson gson = new Gson();

		String jsonOutput = gson.toJson(lista);

		PrintWriter pw;
		pw = response.getWriter();
		pw.write(jsonOutput);
		System.out.println(jsonOutput.toString());
		pw.flush();
		pw.close();

		return null;

	}

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws ParseException
	 */
	public ActionForward jsonEstadisticaVenta(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ParseException {
		response.setContentType("text/json");

		// Type collectionType = new TypeToken<Object>(){}.getType();

		List<EstadisticaVo> lista = new ArrayList<EstadisticaVo>();
		List<Object[]> listaEstadistica = new ArrayList<Object[]>();
		EstadisticaForm objFom = (EstadisticaForm) form;
		EstadisticaDao estadisticaDao = new EstadisticaDao();

		listaEstadistica = estadisticaDao.obtenerVentasEstadistica(objFom);
		// setLocale(request, new Locale("es"));
		for (Object[] obj : listaEstadistica) {
			EstadisticaVo obs = new EstadisticaVo();
			obs.setDia(obj[0].toString());
			obs.setCantidad(FormatosNumeros.redondedoDecimal(Double
					.parseDouble(obj[1].toString())));
			lista.add(obs);
		}

		Gson gson = new Gson();

		String jsonOutput = gson.toJson(lista);
		// Object[] listPersona2 = {gson.fromJson(jsonOutput,collectionType )};
		// Poblacion[] listPersona2 = {gson.fromJson(jsonOutput,collectionType
		// )};
		// System.out.println("listPersona2 ="+listPersona2);

		PrintWriter pw;
		pw = response.getWriter();
		pw.write(jsonOutput);
		System.out.println(jsonOutput.toString());
		pw.flush();
		pw.close();

		return null;

	}

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws ParseException
	 */
	public ActionForward jsonEstadisticaMejoresClientes(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ParseException {
		response.setContentType("text/json");

		// Type collectionType = new TypeToken<Object>(){}.getType();
		String condicion = request.getParameter("condicion");
		List<EstadisticaVo> lista = new ArrayList<EstadisticaVo>();
		List<Object[]> listaEstadistica = new ArrayList<Object[]>();

		EstadisticaForm objFom = (EstadisticaForm) form;
		objFom.setCondicion(condicion);
		objFom.setFechaInicio("");
		objFom.setFechaFin("");
		EstadisticaDao estadisticaDao = new EstadisticaDao();

		listaEstadistica = estadisticaDao.obtenerEstadisticaMejoresClientes(objFom);

		for (Object[] obj : listaEstadistica) {
			EstadisticaVo obs = new EstadisticaVo();
			
			obs.setDia(obj[0].toString());
			obs.setNombre(obj[1].toString());
			obs.setCantidad(FormatosNumeros.redondedoDecimal(Double
					.parseDouble(obj[2].toString())));
			lista.add(obs);
		}

		Gson gson = new Gson();

		String jsonOutput = gson.toJson(lista);
		// Object[] listPersona2 = {gson.fromJson(jsonOutput,collectionType )};
		// Poblacion[] listPersona2 = {gson.fromJson(jsonOutput,collectionType
		// )};
		// System.out.println("listPersona2 ="+listPersona2);

		PrintWriter pw;
		pw = response.getWriter();
		pw.write(jsonOutput);
		System.out.println(jsonOutput.toString());
		pw.flush();
		pw.close();

		return null;

	}
	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws ParseException 
	 */
public ActionForward jsonEstadisticaUtilidades(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException{
response.setContentType("text/json");

// Type collectionType = new TypeToken<Object>(){}.getType();


List<EstadisticaVo> lista = new ArrayList<EstadisticaVo>();
List<Object[]>  listaEstadistica= new ArrayList<Object[]>();

EstadisticaForm objFom =  (EstadisticaForm)form;			
EstadisticaDao estadisticaDao = new EstadisticaDao();			
   
listaEstadistica = estadisticaDao.obtenerUtilidadesEstadistica(objFom);
   
for(Object[] obj:listaEstadistica){
	EstadisticaVo obs= new EstadisticaVo();
	obs.setDia(obj[0].toString());
	obs.setCantidad(FormatosNumeros.redondedoDecimal(Double.parseDouble(obj[1].toString())));
	lista.add(obs);
}


Gson gson = new Gson();			

String jsonOutput = gson.toJson(lista);
//Object[] listPersona2 = {gson.fromJson(jsonOutput,collectionType )};
//Poblacion[] listPersona2 = {gson.fromJson(jsonOutput,collectionType )};
//System.out.println("listPersona2 ="+listPersona2);


PrintWriter pw;
pw = response.getWriter();
pw.write(jsonOutput);
System.out.println( jsonOutput.toString() );
pw.flush();
pw.close();
	

return null;

}
}
