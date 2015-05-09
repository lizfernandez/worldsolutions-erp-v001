package com.util;

import javax.print.DocPrintJob;

/**
 * @author DiegoEnrique
 *
 */
public class ImpresoraVO {

	private String impresoraID;
	private String impresoraNombre;
	private DocPrintJob jobImpresora;
	
	public ImpresoraVO() {
		
	}
	
	public String getImpresoraID() {
		return impresoraID;
	}
	public void setImpresoraID(String impresoraID) {
		this.impresoraID = impresoraID;
	}
	public String getImpresoraNombre() {
		return impresoraNombre;
	}
	public void setImpresoraNombre(String impresoraNombre) {
		this.impresoraNombre = impresoraNombre;
	}
	public DocPrintJob getJobImpresora() {
		return jobImpresora;
	}
	public void setJobImpresora(DocPrintJob jobImpresora) {
		this.jobImpresora = jobImpresora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((impresoraID == null) ? 0 : impresoraID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImpresoraVO other = (ImpresoraVO) obj;
		if (impresoraID == null) {
			if (other.impresoraID != null)
				return false;
		} else if (!impresoraID.equals(other.impresoraID))
			return false;
		return true;
	}
	
}
