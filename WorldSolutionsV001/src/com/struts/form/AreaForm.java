package com.struts.form;


import java.util.List;

import org.apache.struts.action.ActionForm;

import com.entities.Area;
import com.entities.Personal;
import com.entities.Unidadmedida;


public class AreaForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List lista;	
	Area area = new Area();	
	Unidadmedida unidaMedida = new Unidadmedida();
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
	public Area getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(Area area) {
		this.area = area;
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
	 * @return the iAreaId
	 */
	public int getiAreaId() {
		return area.getiAreaId();
	}

	/**
	 * @param iAreaId the iAreaId to set
	 */
	public void setiAreaId(int iAreaId) {
		area.setiAreaId(iAreaId);
	}

	/**
	 * @return the cAreaCodigo
	 */
	public String getcAreaCodigo() {
		return area.getcAreaCodigo();
	}

	/**
	 * @param cAreaCodigo the cAreaCodigo to set
	 */
	public void setcAreaCodigo(String cAreaCodigo) {
		area.setcAreaCodigo(cAreaCodigo);
	}

	/**
	 * @return the cEstadoCodigo
	 */
	public String getcEstadoCodigo() {
		String cEstadoCodig= area.getcEstadoCodigo();
		if(cEstadoCodig=="")
			cEstadoCodig=unidaMedida.getcEstadoCodigo();
		return cEstadoCodig;
		
	}

	/**
	 * @param cEstadoCodigo the cEstadoCodigo to set
	 */
	public void setcEstadoCodigo(String cEstadoCodigo) {
		area.setcEstadoCodigo(cEstadoCodigo);
		unidaMedida.setcEstadoCodigo(cEstadoCodigo);
	}

	

	/**
	 * @return the vAreaDescripcion
	 */
	public String getvAreaDescripcion() {
		return area.getvAreaDescripcion();
	}

	/**
	 * @param vAreaDescripcion the vAreaDescripcion to set
	 */
	public void setvAreaDescripcion(String vAreaDescripcion) {
		area.setvAreaDescripcion(vAreaDescripcion);
	}
	/**
	 * @return the unidaMedida
	 */
	public Unidadmedida getUnidaMedida() {
		return unidaMedida;
	}
	/**
	 * @param unidaMedida the unidaMedida to set
	 */
	public void setUnidaMedida(Unidadmedida unidaMedida) {
		this.unidaMedida = unidaMedida;
	}
	public int getiUnidadMedidaId() {
		return unidaMedida.getiUnidadMedidaId();
	}

	public void setiUnidadMedidaId(int iUnidadMedidaId) {
		this.unidaMedida.setiUnidadMedidaId(iUnidadMedidaId) ;
	}

	

	public String getcUnidadMedidaCodigo() {
		return unidaMedida.getcUnidadMedidaCodigo();
	}

	public void setcUnidadMedidaCodigo(String cUnidadMedidaCodigo) {
		this.unidaMedida.setcUnidadMedidaCodigo(cUnidadMedidaCodigo) ;
	}

	public String getvUnidadMedidaDescripcion() {
		return unidaMedida.getvUnidadMedidaDescripcion();
	}

	public void setvUnidadMedidaDescripcion(String vUnidadMedidaDescripcion) {
		this.unidaMedida.setvUnidadMedidaDescripcion(vUnidadMedidaDescripcion);
	}
	

}
