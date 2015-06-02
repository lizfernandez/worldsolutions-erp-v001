package com.struts.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.dao.PersonalDao;
import com.entities.Area;
import com.entities.Ocupacion;
import com.entities.Personal;
import com.entities.Tipodocumento;
import com.entities.Usuario;

public class PersonalForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List lista;	
	Personal personal = new Personal();
    private String mode;
    private List paginas;
    private int pagInicio;
    
    public PersonalDao getPersonalDao(){
    	PersonalDao produtodao= new PersonalDao();
		return produtodao;
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
	 * @return the personal
	 */
	public Personal getPersonal() {
		return personal;
	}
	/**
	 * @param personal the personal to set
	 */
	public void setPersonal(Personal personal) {
		this.personal = personal;
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
	 * @return the ipersonalId
	 */
	public int getiPersonalId() {
		return personal.getiPersonalId();
	}

	/**
	 * @param ipersonalId the ipersonalId to set
	 */
	public void setiPersonalId(int ipersonalId) {
		personal.setiPersonalId(ipersonalId);
	}

	/**
	 * @return the cEstadoCodigo
	 */
	public String getcEstadoCodigo() {
		return personal.getcEstadoCodigo();
	}

	/**
	 * @param cEstadoCodigo the cEstadoCodigo to set
	 */
	public void setcEstadoCodigo(String cEstadoCodigo) {
		personal.setcEstadoCodigo(cEstadoCodigo);
	}

	/**
	 * @return the cpersonalCodigo
	 */
	public String getcPersonalCodigo() {
		return personal.getcPersonalCodigo();
	}

	/**
	 * @param cpersonalCodigo the cpersonalCodigo to set
	 */
	public void setcPersonalCodigo(String cpersonalCodigo) {
		personal.setcPersonalCodigo(cpersonalCodigo);
	}

	
	/**
	 * @return the npersonalNumeroDocumento
	 */
	public BigDecimal getnPersonalNumeroDocumento() {
		return personal.getnPersonalNumeroDocumento();
	}

	/**
	 * @param npersonalNumeroDocumento the npersonalNumeroDocumento to set
	 */
	public void setnPersonalNumeroDocumento(BigDecimal npersonalNumeroDocumento) {
		personal.setnPersonalNumeroDocumento(npersonalNumeroDocumento);
	}

	/**
	 * @return the vpersonalApellidoMaterno
	 */
	public String getvPersonalApellidoMaterno() {
		return personal.getvPersonalApellidoMaterno();
	}

	/**
	 * @param vpersonalApellidoMaterno the vpersonalApellidoMaterno to set
	 */
	public void setvPersonalApellidoMaterno(String vpersonalApellidoMaterno) {
		personal.setvPersonalApellidoMaterno(vpersonalApellidoMaterno);
	}

	/**
	 * @return the vpersonalApellidoPaterno
	 */
	public String getvPersonalApellidoPaterno() {
		return personal.getvPersonalApellidoPaterno();
	}

	/**
	 * @param vpersonalApellidoPaterno the vpersonalApellidoPaterno to set
	 */
	public void setvPersonalApellidoPaterno(String vpersonalApellidoPaterno) {
		personal.setvPersonalApellidoPaterno(vpersonalApellidoPaterno);
	}

	/**
	 * @return the vpersonalNombres
	 */
	public String getvPersonalNombres() {
		return personal.getvPersonalNombres();
	}

	/**
	 * @param vpersonalNombres the vpersonalNombres to set
	 */
	public void setvPersonalNombres(String vpersonalNombres) {
		personal.setvPersonalNombres(vpersonalNombres);
	}

	/**
	 * @return the area
	 
	*/
	public Area getArea(){
		Area area = personal.getArea();
		 if(area==null){
			 area = new Area();
			 personal.setArea(area);
		 }
		return personal.getArea();
		
	}
	public int getiAreaId()
	{ 	return getArea().getiAreaId();
	}
	
	public void setiAreaId (int iAreaId)	{  
		Area area= getArea();
		area.setiAreaId(iAreaId);
		this.personal.setArea(area);
	}
	/**
	 * @return the sexo
	 */
	public int getiSexoId() {		
		return personal.getiSexoId();
		
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setiSexoId(int iSexoId) {
		this.personal.setiSexoId(iSexoId);
	}
	 
	public Tipodocumento getTipodocumento(){
		Tipodocumento tipodocumento = personal.getTipodocumento();
		 if(tipodocumento==null){
			 tipodocumento = new Tipodocumento();
			 personal.setTipodocumento(tipodocumento);
		 }
		 return personal.getTipodocumento();
	}

	/**
	 * @return the tipodocumento
	 */
	public int getiTipoDocumentoId() {		
			return getTipodocumento().getiTipoDocumentoId();
		
	}

	/**
	 * @param tipodocumento the tipodocumento to set
	 */
	public void setiTipoDocumentoId(int iTipoDocumentoId) {
	//	Tipodocumento tipo= getTipodocumento();
		//tipo.setiTipoDocumentoId(iTipoDocumentoId);
		this.personal.setTipodocumento(getPersonalDao().findEndidad(Tipodocumento.class, iTipoDocumentoId));
		
	}

	/**
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios() {
		return personal.getUsuarios();
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		personal.setUsuarios(usuarios);
	}

	public Ocupacion getOcupacion(){
		Ocupacion ocupacion = personal.getOcupacion();
		 if(ocupacion==null){
			 ocupacion = new Ocupacion();
			 personal.setOcupacion(ocupacion);
		 }
		 return personal.getOcupacion();
	}
	public int getiOcupacionId() {	
		return getOcupacion().getiOcupacionId();
	}

	/**
	 * @param ocupacion the ocupacion to set
	 */
	public void setiOcupacionId(int iOcupacionId) {
		Ocupacion ocupacion= getOcupacion();
		ocupacion.setiOcupacionId(iOcupacionId);
		this.personal.setOcupacion(ocupacion);
	}

	/**
	 * @return the fSueldo
	 */
	public float getfSueldo() {
		return personal.getfSueldo();
	}

	/**
	 * @param fSueldo the fSueldo to set
	 */
	public void setfSueldo(float fSueldo) {
		this.personal.setfSueldo(fSueldo);
	}
    
}
