package com.struts.form;


import java.util.List;

import org.apache.struts.action.ActionForm;

import com.entities.Ocupacion;


public class OcupacionForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List lista;	
	Ocupacion area = new Ocupacion();
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
	public Ocupacion getOcupacion() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setOcupacion(Ocupacion area) {
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
	 * @return the iOcupacionId
	 */
	public int getiOcupacionId() {
		return area.getiOcupacionId();
	}

	/**
	 * @param iOcupacionId the iOcupacionId to set
	 */
	public void setiOcupacionId(int iOcupacionId) {
		area.setiOcupacionId(iOcupacionId);
	}

	/**
	 * @return the cOcupacionCodigo
	 */
	public String getcOcupacionCodigo() {
		return area.getcOcupacionCodigo();
	}

	/**
	 * @param cOcupacionCodigo the cOcupacionCodigo to set
	 */
	public void setcOcupacionCodigo(String cOcupacionCodigo) {
		area.setcOcupacionCodigo(cOcupacionCodigo);
	}

	/**
	 * @return the cEstadoCodigo
	 */
	public String getcEstadoCodigo() {
		return area.getcEstadoCodigo();
	}

	/**
	 * @param cEstadoCodigo the cEstadoCodigo to set
	 */
	public void setcEstadoCodigo(String cEstadoCodigo) {
		area.setcEstadoCodigo(cEstadoCodigo);
	}

	

	/**
	 * @return the vOcupacionDescripcion
	 */
	public String getvOcupacionDescripcion() {
		return area.getvOcupacionDescripcion();
	}

	/**
	 * @param vOcupacionDescripcion the vOcupacionDescripcion to set
	 */
	public void setvOcupacionDescripcion(String vOcupacionDescripcion) {
		area.setvOcupacionDescripcion(vOcupacionDescripcion);
	}

	

}
