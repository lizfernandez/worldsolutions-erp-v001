package com.struts.form;


import java.util.List;

import org.apache.struts.action.ActionForm;

import com.entities.Perfil;
import com.entities.Personal;
import com.entities.Session;
import com.entities.Usuario;


public class UsuarioForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List lista;	
	Usuario usuario = new Usuario();
	private String cPersonalCodigo;
	private String vPersonalNombres;
    private String mode;
    private List paginas;
    private int pagInicio;
	/**
	 * @return the lista
	 */
	public List getLista() {
		return lista;
	}
	/**
	 * @param lista the lista to set
	 */
	public void setLista(List lista) {
		this.lista = lista;
	}
	/**
	 * @return the area
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	/**
	 * @param area the area to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * @return the paginas
	 */
	public List getPaginas() {
		return paginas;
	}
	/**
	 * @param paginas the paginas to set
	 */
	public void setPaginas(List paginas) {
		this.paginas = paginas;
	}
	/**
	 * @return the pagInicio
	 */
	public int getPagInicio() {
		return pagInicio;
	}
	/**
	 * @param pagInicio the pagInicio to set
	 */
	public void setPagInicio(int pagInicio) {
		this.pagInicio = pagInicio;
	}



	/**
	 * @return the iUsuarioId
	 */
	public int getiUsuarioId() {
		return usuario.getiUsuarioId();
	}



	/**
	 * @param iUsuarioId the iUsuarioId to set
	 */
	public void setiUsuarioId(int iUsuarioId) {
		this.usuario.setiUsuarioId(iUsuarioId);
	}



	/**
	 * @return the cEstadoCodigo
	 */
	public String getcEstadoCodigo() {
		return usuario.getcEstadoCodigo();
	}



	/**
	 * @param cEstadoCodigo the cEstadoCodigo to set
	 */
	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.usuario.setcEstadoCodigo(cEstadoCodigo);
	}



	/**
	 * @return the cUsuarioCodigo
	 */
	public String getcUsuarioCodigo() {
		return usuario.getcUsuarioCodigo();
	}



	/**
	 * @param cUsuarioCodigo the cUsuarioCodigo to set
	 */
	public void setcUsuarioCodigo(String cUsuarioCodigo) {
		this.usuario.setcUsuarioCodigo(cUsuarioCodigo) ;
	}


	/**
	 * @return the vUsuarioLogin
	 */
	public String getvUsuarioLogin() {
		return usuario.getvUsuarioLogin();
	}



	/**
	 * @param vUsuarioLogin the vUsuarioLogin to set
	 */
	public void setvUsuarioLogin(String vUsuarioLogin) {
		this.usuario.setvUsuarioLogin(vUsuarioLogin);
	}



	/**
	 * @return the vUsuarioPassword
	 */
	public String getvUsuarioPassword() {
		return usuario.getvUsuarioPassword();
	}



	/**
	 * @param vUsuarioPassword the vUsuarioPassword to set
	 */
	public void setvUsuarioPassword(String vUsuarioPassword) {
		this.usuario.setvUsuarioPassword(vUsuarioPassword);
	}


	public List<Session> getSessions() {
		return  usuario.getSessions();
	}

	public void setSessions(List<Session> sessions) {
		this.usuario.setSessions(sessions);
	}
	
	
	public Personal getPersonal(){
		 Personal personal = usuario.getPersonal();
		 if(personal==null){
			 personal= new Personal();
			 usuario.setPersonal(personal);
		 }
		 return usuario.getPersonal();
	}

	public void setPersonal(Personal personal) {
		this.usuario.setPersonal(personal);
	}
	
	/**
	 * @return the cPersonalCodigo
	 */
	public String getcPersonalCodigo() {		 
		return cPersonalCodigo=getPersonal().getcPersonalCodigo();
	}

	/**
	 * @param cPersonalCodigo the cPersonalCodigo to set
	 */
	public void setcPersonalCodigo(String cPersonalCodigo) {
		this.cPersonalCodigo = cPersonalCodigo;
	}
	
    /**
	 * @return the vPersonalNombres
	 */
	public String getvPersonalNombres() {
		Personal personal = getPersonal();	
		if(personal.getvPersonalNombres()!=null){
			vPersonalNombres = personal.getvPersonalNombres()+" "+personal.getvPersonalApellidoPaterno();
		}
		return vPersonalNombres;
	}

	
	/**
	 * @param vPersonalNombres the vPersonalNombres to set
	 */
	public void setvPersonalNombres(String vPersonalNombres) {
		this.vPersonalNombres = vPersonalNombres;
	}
	
	/**
	 * @return the iPerfilId
	 */
	public int getiPersonalId() {
		Personal personal =getPersonal();
       return personal.getiPersonalId();
		
	}
    
	/**
	 * @param iPerfilId the iPerfilId to set
	 */
	public void setiPersonalId(int iPersonalId) {
        Personal personal = getPersonal();
        personal.setiPersonalId(iPersonalId);
		this.usuario.setPersonal(personal);
				
	}

	
	/**
	 * @return the iPerfilId
	 */
	public int getiPerfilId() {	
			return getPerfil().getiPerfilId();
		
	}

	/**
	 * @param iPerfilId the iPerfilId to set
	 */
	public void setiPerfilId(int iPerfilId) {
        Perfil perfil = getPerfil();
        perfil.setiPerfilId(iPerfilId);
		this.usuario.setPerfil(perfil);
	}
	
	public Perfil getPerfil() {
		Perfil perfil = usuario.getPerfil();
		if(perfil==null){
			perfil = new Perfil();
			usuario.setPerfil(perfil);
		}
		return usuario.getPerfil();
	}

	public void setPerfil(Perfil perfil) {
		this.usuario.setPerfil(perfil);
	}
	
	
	
}
