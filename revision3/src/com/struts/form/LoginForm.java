package com.struts.form;


import java.util.List;

import org.apache.struts.action.ActionForm;

import com.entities.Ingresoproducto;
import com.entities.Letracliente;
import com.entities.Letraproveedor;
import com.entities.Perfil;
import com.entities.Personal;
import com.entities.Usuario;
import com.entities.Venta;


public class LoginForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Usuario usuario = new Usuario();
	Venta venta = new Venta();
	Ingresoproducto ingresoProducto = new Ingresoproducto();
	Letracliente letracliente = new Letracliente();
	Letraproveedor letraProveedor = new Letraproveedor();
	private List lista;	
	private String cPersonalCodigo;
	private String vPersonalNombres;
    private String nPersonalNumeroDocumento;
    private String mode;
    private String mensaje;
    private List paginas;
    private int pagInicio;

    /*****************************/
    /**producto stock maximo **/
    /*****************************/
    private List listaProductoMax;	
    private List paginasProductoMax;
    private int pagInicioProductoMax;
    
    /*****************************/
    /**estado de cuenta cliente **/
    /*****************************/
    private List listaDeudaCliente;	
    private List paginasDeudaCliente;
    private int pagInicioDeudaCliente;
	
    /************************************/
    /**estado de cuenta cliente letras **/
    /************************************/
    private List listaDeudaClienteLetra;	
    private List paginasDeudaClienteLetra;
    private int pagInicioDeudaClienteLetra;
    
    /*******************************/
    /**estado de cuenta proveedor **/
    /*******************************/
    /*****************************/
    private List listaDeudaProveedor;	
    private List paginasDeudaProveedor;
    private int pagInicioDeudaProveedor;
    
    /**************************************/
    /**estado de cuenta proveedor  letras**/
    /**************************************/
    private List listaDeudaProveedorLetra;	
    private List paginasDeudaProveedorLetra;
    private int pagInicioDeudaProveedorLetra;
    

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
	/**
	 * @return the venta
	 */
	public Venta getVenta() {
		return venta;
	}
	/**
	 * @param venta the venta to set
	 */
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	/**
	 * @return the listaDeudaCliente
	 */
	public List getListaDeudaCliente() {
		return listaDeudaCliente;
	}
	/**
	 * @param listaDeudaCliente the listaDeudaCliente to set
	 */
	public void setListaDeudaCliente(List listaDeudaCliente) {
		this.listaDeudaCliente = listaDeudaCliente;
	}
	/**
	 * @return the paginasDeudaCliente
	 */
	public List getPaginasDeudaCliente() {
		return paginasDeudaCliente;
	}
	/**
	 * @param paginasDeudaCliente the paginasDeudaCliente to set
	 */
	public void setPaginasDeudaCliente(List paginasDeudaCliente) {
		this.paginasDeudaCliente = paginasDeudaCliente;
	}
	/**
	 * @return the pagInicioDeudaCliente
	 */
	public int getPagInicioDeudaCliente() {
		return pagInicioDeudaCliente;
	}
	/**
	 * @param pagInicioDeudaCliente the pagInicioDeudaCliente to set
	 */
	public void setPagInicioDeudaCliente(int pagInicioDeudaCliente) {
		this.pagInicioDeudaCliente = pagInicioDeudaCliente;
	}
	/**
	 * @return the listaDeudaClienteLetra
	 */
	public List getListaDeudaClienteLetra() {
		return listaDeudaClienteLetra;
	}
	/**
	 * @param listaDeudaClienteLetra the listaDeudaClienteLetra to set
	 */
	public void setListaDeudaClienteLetra(List listaDeudaClienteLetra) {
		this.listaDeudaClienteLetra = listaDeudaClienteLetra;
	}
	/**
	 * @return the paginasDeudaClienteLetra
	 */
	public List getPaginasDeudaClienteLetra() {
		return paginasDeudaClienteLetra;
	}
	/**
	 * @param paginasDeudaClienteLetra the paginasDeudaClienteLetra to set
	 */
	public void setPaginasDeudaClienteLetra(List paginasDeudaClienteLetra) {
		this.paginasDeudaClienteLetra = paginasDeudaClienteLetra;
	}
	/**
	 * @return the pagInicioDeudaClienteLetra
	 */
	public int getPagInicioDeudaClienteLetra() {
		return pagInicioDeudaClienteLetra;
	}
	/**
	 * @param pagInicioDeudaClienteLetra the pagInicioDeudaClienteLetra to set
	 */
	public void setPagInicioDeudaClienteLetra(int pagInicioDeudaClienteLetra) {
		this.pagInicioDeudaClienteLetra = pagInicioDeudaClienteLetra;
	}
	/**
	 * @return the listaDeudaProveedor
	 */
	public List getListaDeudaProveedor() {
		return listaDeudaProveedor;
	}
	/**
	 * @param listaDeudaProveedor the listaDeudaProveedor to set
	 */
	public void setListaDeudaProveedor(List listaDeudaProveedor) {
		this.listaDeudaProveedor = listaDeudaProveedor;
	}
	/**
	 * @return the paginasDeudaProveedor
	 */
	public List getPaginasDeudaProveedor() {
		return paginasDeudaProveedor;
	}
	/**
	 * @param paginasDeudaProveedor the paginasDeudaProveedor to set
	 */
	public void setPaginasDeudaProveedor(List paginasDeudaProveedor) {
		this.paginasDeudaProveedor = paginasDeudaProveedor;
	}
	/**
	 * @return the pagInicioDeudaProveedor
	 */
	public int getPagInicioDeudaProveedor() {
		return pagInicioDeudaProveedor;
	}
	/**
	 * @param pagInicioDeudaProveedor the pagInicioDeudaProveedor to set
	 */
	public void setPagInicioDeudaProveedor(int pagInicioDeudaProveedor) {
		this.pagInicioDeudaProveedor = pagInicioDeudaProveedor;
	}
	/**
	 * @return the listaDeudaProveedorLetra
	 */
	public List getListaDeudaProveedorLetra() {
		return listaDeudaProveedorLetra;
	}
	/**
	 * @param listaDeudaProveedorLetra the listaDeudaProveedorLetra to set
	 */
	public void setListaDeudaProveedorLetra(List listaDeudaProveedorLetra) {
		this.listaDeudaProveedorLetra = listaDeudaProveedorLetra;
	}
	/**
	 * @return the paginasDeudaProveedorLetra
	 */
	public List getPaginasDeudaProveedorLetra() {
		return paginasDeudaProveedorLetra;
	}
	/**
	 * @param paginasDeudaProveedorLetra the paginasDeudaProveedorLetra to set
	 */
	public void setPaginasDeudaProveedorLetra(List paginasDeudaProveedorLetra) {
		this.paginasDeudaProveedorLetra = paginasDeudaProveedorLetra;
	}
	/**
	 * @return the pagInicioDeudaProveedorLetra
	 */
	public int getPagInicioDeudaProveedorLetra() {
		return pagInicioDeudaProveedorLetra;
	}
	/**
	 * @param pagInicioDeudaProveedorLetra the pagInicioDeudaProveedorLetra to set
	 */
	public void setPagInicioDeudaProveedorLetra(int pagInicioDeudaProveedorLetra) {
		this.pagInicioDeudaProveedorLetra = pagInicioDeudaProveedorLetra;
	}
	/**
	 * @return the ingresoProducto
	 */
	public Ingresoproducto getIngresoProducto() {
		return ingresoProducto;
	}
	/**
	 * @param ingresoProducto the ingresoProducto to set
	 */
	public void setIngresoProducto(Ingresoproducto ingresoProducto) {
		this.ingresoProducto = ingresoProducto;
	}
	/**
	 * @return the listaProductoMax
	 */
	public List getListaProductoMax() {
		return listaProductoMax;
	}
	/**
	 * @param listaProductoMax the listaProductoMax to set
	 */
	public void setListaProductoMax(List listaProductoMax) {
		this.listaProductoMax = listaProductoMax;
	}
	/**
	 * @return the paginasProductoMax
	 */
	public List getPaginasProductoMax() {
		return paginasProductoMax;
	}
	/**
	 * @param paginasProductoMax the paginasProductoMax to set
	 */
	public void setPaginasProductoMax(List paginasProductoMax) {
		this.paginasProductoMax = paginasProductoMax;
	}
	/**
	 * @return the pagInicioProductoMax
	 */
	public int getPagInicioProductoMax() {
		return pagInicioProductoMax;
	}
	/**
	 * @param pagInicioProductoMax the pagInicioProductoMax to set
	 */
	public void setPagInicioProductoMax(int pagInicioProductoMax) {
		this.pagInicioProductoMax = pagInicioProductoMax;
	}
	/**
	 * @return the letracliente
	 */
	public Letracliente getLetracliente() {
		return letracliente;
	}
	/**
	 * @param letracliente the letracliente to set
	 */
	public void setLetracliente(Letracliente letracliente) {
		this.letracliente = letracliente;
	}
	/**
	 * @return the letraProveedor
	 */
	public Letraproveedor getLetraProveedor() {
		return letraProveedor;
	}
	/**
	 * @param letraProveedor the letraProveedor to set
	 */
	public void setLetraProveedor(Letraproveedor letraProveedor) {
		this.letraProveedor = letraProveedor;
	}
	
	
	
}
