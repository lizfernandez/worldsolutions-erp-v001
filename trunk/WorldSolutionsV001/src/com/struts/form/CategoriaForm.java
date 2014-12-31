package com.struts.form;


import java.util.Date;
import java.util.List;
import org.apache.struts.action.ActionForm;
import com.entities.Categoria;
import com.entities.Clasificacioncategoria;
import com.entities.Subcategoria;




public class CategoriaForm extends ActionForm {
	private List lista;	
	Categoria categoria = new Categoria();
	Subcategoria subCategoria = new Subcategoria();
    private String mode;
    private List paginas;
    private int pagInicio;
    
    /***************************************** *****/
    /** Creamos atributos de entidades para evitar */
    /**  persistencias                             */
    /**********************************************/
     private int iClasificacionId;
    
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
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
	 * @return the iCategoriaId
	 */
	public int getiCategoriaId() {
		return categoria.getiCategoriaId();
	}

	/**
	 * @param iCategoriaId the iCategoriaId to set
	 */
	public void setiCategoriaId(int iCategoriaId) {
		categoria.setiCategoriaId(iCategoriaId);
	}

	/**
	 * @return the cCategoriaCodigo
	 */
	public String getcCategoriaCodigo() {
		return categoria.getcCategoriaCodigo();
	}

	/**
	 * @param cCategoriaCodigo the cCategoriaCodigo to set
	 */
	public void setcCategoriaCodigo(String cCategoriaCodigo) {
		categoria.setcCategoriaCodigo(cCategoriaCodigo);
	}

	/**
	 * @return the cEstadoCodigo
	 */
	public String getcEstadoCodigo() {
		String cEstadoCodigo = categoria.getcEstadoCodigo();
		if (cEstadoCodigo == null) {
			cEstadoCodigo = subCategoria.getcEstadoCodigo();
		}
		return cEstadoCodigo;
		
	}

	/**
	 * @param cEstadoCodigo the cEstadoCodigo to set
	 */
	public void setcEstadoCodigo(String cEstadoCodigo) {
		categoria.setcEstadoCodigo(cEstadoCodigo);
		subCategoria.setcEstadoCodigo(cEstadoCodigo);
	}

	

	/**
	 * @return the vCategoriaDescripcion
	 */
	public String getvCategoriaDescripcion() {
		return categoria.getvCategoriaDescripcion();
	}

	/**
	 * @param vCategoriaDescripcion the vCategoriaDescripcion to set
	 */
	public void setvCategoriaDescripcion(String vCategoriaDescripcion) {
		categoria.setvCategoriaDescripcion(vCategoriaDescripcion);
	}



	/**
	 * @return the clasificacion
	 */
	
	/**
	 * @return the iClasificacionId
	 */
	public int getiClasificacionId() {
		return iClasificacionId;
	}
	/**
	 * @param iClasificacionId the iClasificacionId to set
	 */
	public void setiClasificacionId(int iClasificacionId) {
		this.iClasificacionId = iClasificacionId;
	}
	
	
	/***************/
	/*SUB CATEGORIA*/
	/***************/
	/**
	 * @return the subCategoria
	 */
	public Subcategoria getSubCategoria() {
		return subCategoria;
	}
	
	/**
	 * @param subCategoria the subCategoria to set
	 */
	public void setSubCategoria(Subcategoria subCategoria) {
		this.subCategoria = subCategoria;
	}
	
	/**
	 * @return the iSubCategoriaId
	 */
	public int getiSubCategoriaId() {
		return subCategoria.getiSubCategoriaId();
	}

	/**
	 * @param iSubCategoriaId the iSubCategoriaId to set
	 */
	public void setiSubCategoriaId(int iSubCategoriaId) {
		this.subCategoria.setiSubCategoriaId(iSubCategoriaId);
	}

	

	/**
	 * @return the cSubCategoriaCodigo
	 */
	public String getcSubCategoriaCodigo() {
		return subCategoria.getcSubCategoriaCodigo();
	}

	/**
	 * @param cSubCategoriaCodigo the cSubCategoriaCodigo to set
	 */
	public void setcSubCategoriaCodigo(String cSubCategoriaCodigo) {
		this.subCategoria.setcSubCategoriaCodigo(cSubCategoriaCodigo);
	}

	/**
	 * @return the vSubCategoriaDescripcion
	 */
	public String getvSubCategoriaDescripcion() {
		return subCategoria.getvSubCategoriaDescripcion();
	}

	/**
	 * @param vSubCategoriaDescripcion the vSubCategoriaDescripcion to set
	 */
	public void setvSubCategoriaDescripcion(String vSubCategoriaDescripcion) {
		this.subCategoria.setvSubCategoriaDescripcion(vSubCategoriaDescripcion);
	}

}
