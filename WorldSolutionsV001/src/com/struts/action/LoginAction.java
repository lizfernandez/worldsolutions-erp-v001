package com.struts.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.dao.ConfiguracionDao;
import com.dao.GenericaDao;
import com.dao.PerfilDao;
import com.dao.UsuarioDao;
import com.entities.Configuracion;
import com.entities.Impuesto;

import com.entities.Permiso;
import com.entities.Usuario;
import com.entities.vo.EstadisticaVo;
import com.struts.form.LoginForm;
import com.util.Constantes;
import com.util.Fechas;

public class LoginAction extends DispatchAction {
	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		String msn="";
		HttpSession sesion = request.getSession();	
		sesion.removeAttribute("Usuario");
		sesion.removeAttribute("Fecha");
		sesion.removeAttribute("id");
		sesion.removeAttribute("listaMisPermisoUsuario");
		sesion.removeAttribute("Moneda");
		sesion.removeAttribute("TipoCambio");
		sesion.removeAttribute("IGVCompras");
		sesion.removeAttribute("IGVPercepcion");
		sesion.removeAttribute("IGVVentas");
		sesion.removeAttribute("iPeriodoId");
		
		
		
		/** Instanciamos la Clase LoginForm **/
		LoginForm objform = (LoginForm) form;
		List<Usuario> usuario = new ArrayList<Usuario>();
		List<Permiso> listapermiso = new ArrayList<Permiso>();
		
		
		UsuarioDao usuarioDao = new UsuarioDao();
		PerfilDao perfilDao = new PerfilDao();
	    GenericaDao genericaDao = new GenericaDao();
		List<EstadisticaVo> listaAnio = new ArrayList<EstadisticaVo>();
		int j=0;
		usuario= usuarioDao.login(objform.getvUsuarioLogin(), objform.getvUsuarioPassword(),"");
		listapermiso = perfilDao.listaFindPermiso(usuario.get(0).getiUsuarioId());
		
		ConfiguracionDao configuracionDao = new ConfiguracionDao();
		Configuracion confi = configuracionDao.buscarConfiguracion(Constantes.tipoMoneda);
		Configuracion tipoCambio = configuracionDao.buscarConfiguracion(Constantes.tipoCambio);
		Impuesto impuestoVenta=configuracionDao.buscarImpuesto(Constantes.IGVVenta);
		Impuesto impuestoCompras=configuracionDao.buscarImpuesto(Constantes.IGVCompra);
		Impuesto impuestoPercepciones=configuracionDao.buscarImpuesto(Constantes.IGVPercepcion);
		
		int iPeriodoId =  genericaDao.callSPPeriodoActual();

				
		if(usuario.size()>0 && listapermiso.size()>0){				
			    
				sesion.setAttribute("Usuario", usuario.get(0));			
				sesion.setAttribute("Fecha",Fechas.fechaDDMMYY((Fechas.getDate())));
				sesion.setAttribute("id", sesion.getId());
					
				sesion.setAttribute("Moneda", configuracionDao.buscarMoneda(confi.getvValor()));
				sesion.setAttribute("TipoCambio", tipoCambio.getvValor());
				sesion.setAttribute("IGVCompras",impuestoCompras.getvPorcentaje());
				sesion.setAttribute("IGVPercepcion",impuestoPercepciones.getvPorcentaje());
				sesion.setAttribute("IGVVentas", impuestoVenta.getvPorcentaje());
				sesion.setAttribute("iPeriodoId", iPeriodoId);
				//sesion.setAttribute("listaMenu",  genericaDao.listaEntidadGenericaSinCodigo("Menu"));
				List<String> listaMisPersmisos = new ArrayList<String>();
				for(Permiso lista:listapermiso){
					listaMisPersmisos.add(lista.getvCodigoMenu());
					
				}
				
				sesion.setAttribute("listaMisPermisoUsuario", listaMisPersmisos);
								
				/***determinamos la lista de años para visualizar las estadisticas del modulo estadistica**/
				for(int i=-2;i<=0;i++){
				    EstadisticaVo e = new EstadisticaVo();
					e.setAnio(Fechas.anioActual(j));
					listaAnio.add(e);
					j--;
				}				
				sesion.setAttribute("listaAnio", listaAnio);				
				/***Seteamos la localidad para dar formato a los numeros 2,000.00****/
				sesion.setAttribute("Localidad",new Locale("en", "US"));
				
					msn="bienvenido";
				
			}	
			else{
				if(listapermiso.size()==0){
					objform.setMensaje("No se le han asignado permisos, Consulte con su Administrador ");
					
						
				}else{
					 objform.setMensaje("Usuario o Clave son incorrectos");
					 
				}
				    objform.setMode("m_mensaje");				
			        msn="login";
			}
				
		return mapping.findForward(msn);
	}
	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward home(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		String msn="";
		HttpSession sesion = request.getSession();		
				
		if(sesion.getAttribute("Usuario")!=null){
					msn="bienvenido";
			}	
			else{
				 msn="login";
			}
				
		return mapping.findForward(msn);
	}
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
		String msn="";
		HttpSession sesion = request.getSession();		
		sesion.removeAttribute("Usuario");
		msn="login";
			
		return mapping.findForward(msn);
	}
	public ActionForward restablecer(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		/** Instanciamos la Clase LoginForm **/
		LoginForm objform = (LoginForm) form;
		String msn="";
		
		
		List<Usuario> usuario = new ArrayList<Usuario>();	
		UsuarioDao usuariosDao = new UsuarioDao();
		
		
		if(objform.getvUsuarioLogin()!=null){
			usuario= usuariosDao.login(objform.getvUsuarioLogin(), objform.getvUsuarioPassword(),objform.getnPersonalNumeroDocumento().toString());
			if(usuario.size()>0){
				/****Actualizamos la clave ***/
				Usuario obju = usuario.get(0);
				obju.setvUsuarioPassword(objform.getvUsuarioPassword());
				usuariosDao.actualizarUnaEndidad(obju);
				
				msn = "login"; 
				objform.setvUsuarioLogin("");
				objform.setvUsuarioPassword("");
				objform.setMensaje("Ingrese la nueva clave");
				objform.setMode("m_advertencia");
			}
			else{
				msn = "restablecer"; 
				objform.setMensaje("Los datos ingresados son incorrectos");
			}
			
		}	
		else{
			msn = "restablecer"; 
	    }
		 return mapping.findForward(msn);
	}
	
	

}
