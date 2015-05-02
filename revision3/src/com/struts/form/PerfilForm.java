package com.struts.form;



import java.util.List;

import org.apache.struts.action.ActionForm;

import com.entities.Perfil;



public class PerfilForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List lista;
	private List listaPermiso;	
	private List listaUsuarioPermiso;	
	private List listaUsuario;	
	Perfil perfil= new Perfil();
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
	 * @return the perfil
	 */
	public Perfil getPerfil() {
	
		return this.perfil;
	}
	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(Perfil perfil) {
			
		this.perfil = perfil;
	 
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
	 * @return the iPerfilId
	 */
	public int getiPerfilId() {
		return perfil.getiPerfilId();
	}

	/**
	 * @param iPerfilId the iPerfilId to set
	 */
	public void setiPerfilId(int iPerfilId) {
		
		perfil.setiPerfilId(iPerfilId);
	}

	/**
	 * @return the cEstadoCodigo
	 */
	public String getcEstadoCodigo() {
		return perfil.getcEstadoCodigo();
	}

	/**
	 * @param cEstadoCodigo the cEstadoCodigo to set
	 */
	public void setcEstadoCodigo(String cEstadoCodigo) {
		perfil.setcEstadoCodigo(cEstadoCodigo);
	}

	/**
	 * @return the cPerfilCodigo
	 */
	public String getcPerfilCodigo() {
		return perfil.getcPerfilCodigo();
	}

	/**
	 * @param cPerfilCodigo the cPerfilCodigo to set
	 */
	public void setcPerfilCodigo(String cPerfilCodigo) {
		this.perfil.setcPerfilCodigo(cPerfilCodigo);
	}

	

	/**
	 * @return the vPerfilDescripcion
	 */
	public String getvPerfilDescripcion() {
		return perfil.getvPerfilDescripcion();
	}

	/**
	 * @param vPerfilDescripcion the vPerfilDescripcion to set
	 */
	public void setvPerfilDescripcion(String vPerfilDescripcion) {
		
		this.perfil.setvPerfilDescripcion(vPerfilDescripcion);
	}

	/**
	 * @return the cInventario
	 */
	public String getcInventario() {
		return perfil.getcInventario();
	}

	/**
	 * @param cInventario the cInventario to set
	 */
	public void setcInventario(String cInventario) {
		this.perfil.setcInventario(cInventario);
	}

	/**
	 * @return the cProveedor
	 */
	public String getcProveedor() {
		return perfil.getcProveedor();
	}

	/**
	 * @param cProveedor the cProveedor to set
	 */
	public void setcProveedor(String cProveedor) {
		this.perfil.setcProveedor(cProveedor);
	}

	/**
	 * @return the cClientes
	 */
	public String getcClientes() {
		return perfil.getcClientes();
	}

	/**
	 * @param cClientes the cClientes to set
	 */
	public void setcClientes(String cClientes) {
		this.perfil.setcClientes(cClientes);
	}

	/**
	 * @return the cCompras
	 */
	public String getcCompras() {
		return perfil.getcCompras();
	}

	/**
	 * @param cCompras the cCompras to set
	 */
	public void setcCompras(String cCompras) {
		this.perfil.setcCompras(cCompras);
	}

	/**
	 * @return the cVentas
	 */
	public String getcVentas() {
		return perfil.getcVentas();
	}

	/**
	 * @param cVentas the cVentas to set
	 */
	public void setcVentas(String cVentas) {
		this.perfil.setcVentas(cVentas);
	}

	/**
	 * @return the cEstadisticas
	 */
	public String getcEstadisticas() {
		return perfil.getcEstadisticas();
	}

	/**
	 * @param cEstadisticas the cEstadisticas to set
	 */
	public void setcEstadisticas(String cEstadisticas) {
		this.perfil.setcEstadisticas(cEstadisticas);
	}

	/**
	 * @return the cMantenimiento
	 */
	public String getcMantenimiento() {
		return perfil.getcMantenimiento();
	}

	/**
	 * @param cMantenimiento the cMantenimiento to set
	 */
	public void setcMantenimiento(String cMantenimiento) {
		this.perfil.setcMantenimiento(cMantenimiento);
	}
	/**
	 * @return the listaPermiso
	 */
	public List getListaPermiso() {
		return listaPermiso;
	}
	/**
	 * @param listaPermiso the listaPermiso to set
	 */
	public void setListaPermiso(List listaPermiso) {
		this.listaPermiso = listaPermiso;
	}
	/**
	 * @return the listaUsuario
	 */
	public List getListaUsuario() {
		return listaUsuario;
	}
	/**
	 * @param listaUsuario the listaUsuario to set
	 */
	public void setListaUsuario(List listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	/**
	 * @return the listaUsuarioPermiso
	 */
	public List getListaUsuarioPermiso() {
		return listaUsuarioPermiso;
	}
	/**
	 * @param listaUsuarioPermiso the listaUsuarioPermiso to set
	 */
	public void setListaUsuarioPermiso(List listaUsuarioPermiso) {
		this.listaUsuarioPermiso = listaUsuarioPermiso;
	}

	

	/**
	 * @return the usuarios
	
	public List<Usuario> getUsuarios() {
		return perfil.getUsuarios();
	} */

	/**
	 * @param usuarios the usuarios to set
	
	public void setUsuarios(List<Usuario> usuarios) {
		perfil.setUsuarios(usuarios);
	} */
    
}
