package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the seccionplantilla database table.
 * 
 */
@Entity
public class Seccionplantilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iSeccionPlantillaId;

	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private BigInteger iPlantillaId;

	private BigInteger iTipoSeccionId;

	private BigInteger iUsuarioActualiza;

	private BigInteger iUsuarioInserta;

	private String vAlineado;

	private String vColorBorde;

	private String vColorCabeceraInf;

	private String vColorCabeceraSup;

	private String vColorFondo;

	private String vDescripcion;

	private String vFoto;

	private String vNombre;

	private String vPaginaDestino;

	private String vTipoAnimacion;

	private String vTitulo;

	public Seccionplantilla() {
	}

	public String getISeccionPlantillaId() {
		return this.iSeccionPlantillaId;
	}

	public void setISeccionPlantillaId(String iSeccionPlantillaId) {
		this.iSeccionPlantillaId = iSeccionPlantillaId;
	}

	public String getCEstadoCodigo() {
		return this.cEstadoCodigo;
	}

	public void setCEstadoCodigo(String cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}

	public Date getDFechaActualiza() {
		return this.dFechaActualiza;
	}

	public void setDFechaActualiza(Date dFechaActualiza) {
		this.dFechaActualiza = dFechaActualiza;
	}

	public Date getDFechaInserta() {
		return this.dFechaInserta;
	}

	public void setDFechaInserta(Date dFechaInserta) {
		this.dFechaInserta = dFechaInserta;
	}

	public BigInteger getIPlantillaId() {
		return this.iPlantillaId;
	}

	public void setIPlantillaId(BigInteger iPlantillaId) {
		this.iPlantillaId = iPlantillaId;
	}

	public BigInteger getITipoSeccionId() {
		return this.iTipoSeccionId;
	}

	public void setITipoSeccionId(BigInteger iTipoSeccionId) {
		this.iTipoSeccionId = iTipoSeccionId;
	}

	public BigInteger getIUsuarioActualiza() {
		return this.iUsuarioActualiza;
	}

	public void setIUsuarioActualiza(BigInteger iUsuarioActualiza) {
		this.iUsuarioActualiza = iUsuarioActualiza;
	}

	public BigInteger getIUsuarioInserta() {
		return this.iUsuarioInserta;
	}

	public void setIUsuarioInserta(BigInteger iUsuarioInserta) {
		this.iUsuarioInserta = iUsuarioInserta;
	}

	public String getVAlineado() {
		return this.vAlineado;
	}

	public void setVAlineado(String vAlineado) {
		this.vAlineado = vAlineado;
	}

	public String getVColorBorde() {
		return this.vColorBorde;
	}

	public void setVColorBorde(String vColorBorde) {
		this.vColorBorde = vColorBorde;
	}

	public String getVColorCabeceraInf() {
		return this.vColorCabeceraInf;
	}

	public void setVColorCabeceraInf(String vColorCabeceraInf) {
		this.vColorCabeceraInf = vColorCabeceraInf;
	}

	public String getVColorCabeceraSup() {
		return this.vColorCabeceraSup;
	}

	public void setVColorCabeceraSup(String vColorCabeceraSup) {
		this.vColorCabeceraSup = vColorCabeceraSup;
	}

	public String getVColorFondo() {
		return this.vColorFondo;
	}

	public void setVColorFondo(String vColorFondo) {
		this.vColorFondo = vColorFondo;
	}

	public String getVDescripcion() {
		return this.vDescripcion;
	}

	public void setVDescripcion(String vDescripcion) {
		this.vDescripcion = vDescripcion;
	}

	public String getVFoto() {
		return this.vFoto;
	}

	public void setVFoto(String vFoto) {
		this.vFoto = vFoto;
	}

	public String getVNombre() {
		return this.vNombre;
	}

	public void setVNombre(String vNombre) {
		this.vNombre = vNombre;
	}

	public String getVPaginaDestino() {
		return this.vPaginaDestino;
	}

	public void setVPaginaDestino(String vPaginaDestino) {
		this.vPaginaDestino = vPaginaDestino;
	}

	public String getVTipoAnimacion() {
		return this.vTipoAnimacion;
	}

	public void setVTipoAnimacion(String vTipoAnimacion) {
		this.vTipoAnimacion = vTipoAnimacion;
	}

	public String getVTitulo() {
		return this.vTitulo;
	}

	public void setVTitulo(String vTitulo) {
		this.vTitulo = vTitulo;
	}

}