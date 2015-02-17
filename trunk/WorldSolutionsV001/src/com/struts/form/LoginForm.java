package com.struts.form;


import java.util.List;

import org.apache.struts.action.ActionForm;

import com.entities.Perfil;
import com.entities.Personal;
import com.entities.Usuario;


public class LoginForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Usuario usuario = new Usuario();
	private List lista;	
	private String cPersonalCodigo;
	private String vPersonalNombres;
    private String nPersonalNumeroDocumento;
    private String mode;
    private String mensaje;
    private List paginas;
    private int pagInicio;
	
    

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

	
	public Personal getPersonal() {
		Personal personal = usuario.getPersonal();
		   if(personal==null){
			   personal = new Personal();
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
		return getPersonal().getcPersonalCodigo();
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
			vPersonalNombres = personal.getvPersonalNombres()+" "+personal.getvPersonalApellidoPaterno();
		return vPersonalNombres;
	}

	
	/**
	 * @param vPersonalNombres the vPersonalNombres to set
	 */
	public void setvPersonalNombres(String vPersonalNombres) {
		this.vPersonalNombres = vPersonalNombres;
	}
	
	/**
	 * @return the nPersonalNumeroDocumento
	 */
	public String getnPersonalNumeroDocumento() {
		return nPersonalNumeroDocumento;
	}

	/**
	 * @param nPersonalNumeroDocumento the nPersonalNumeroDocumento to set
	 */
	public void setnPersonalNumeroDocumento(String nPersonalNumeroDocumento) {
		this.nPersonalNumeroDocumento=nPersonalNumeroDocumento;
	}
	
	/**
	 * @return the iPerfilId
	 */
	public int getiPersonalId() {
		return  getPersonal().getiPersonalId();
		
	}

	/**
	 * @param iPerfilId the iPerfilId to set
	 */
	public void setiPersonalId(int iPersonalId) {     
		this.getPersonal().setiPersonalId(iPersonalId);
				
	}
	
	public Perfil getPerfil(){
		Perfil perfil= usuario.getPerfil();
		if(perfil==null){
			perfil= new Perfil();
			usuario.setPerfil(perfil);
		}
		return usuario.getPerfil();
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
	
	

	
	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
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
	
	
	
}
