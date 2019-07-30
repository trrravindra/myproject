package com.lcl.erefill.core.vo;

import java.io.Serializable;
import java.util.Locale;

/**
 * @author vsha51
 */
public class TaxReceiptReportRequest implements Serializable {

	private static final long serialVersionUID = 4784415622086913449L;

	private String startDate;

	private String endDate;

	private String patientOID;

	private Boolean excludeMedication = Boolean.FALSE;

	private Locale locale;
	
	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the patientOID
	 */
	public String getPatientOID() {
		return patientOID;
	}

	/**
	 * @param patientOID
	 *            the patientOID to set
	 */
	public void setPatientOID(String patientOID) {
		this.patientOID = patientOID;
	}

	/**
	 * @return the excludeMedication
	 */
	public Boolean getExcludeMedication() {
		return excludeMedication;
	}

	/**
	 * @param excludeMedication
	 *            the excludeMedication to set
	 */
	public void setExcludeMedication(Boolean excludeMedication) {
		this.excludeMedication = excludeMedication;
	}
}
