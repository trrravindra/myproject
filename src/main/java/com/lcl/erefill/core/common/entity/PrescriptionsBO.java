package com.lcl.erefill.core.common.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * 
 * @author gpunno Version 1.0
 */

public class PrescriptionsBO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(PrescriptionsBO.class);

	private Locale locale;
	private int quantityFilled;
	private int refillRemaining;
	private short daysSupply;
	private boolean narcotic;
	private boolean controlled;
	private boolean refillAllowed;
	private boolean requiredETA;
	private boolean noRefill;
	private String eRestriction;
	private String lastState;
	private String rxNumber;
	private String name;
	private String genericName;
	private String strength;
	private String lastFilledDate;
	private String histLastFillDate;
	private String estimatedFillDate;
	private String estimatedFillDateEn;
	private String prescriberFirstName;
	private String prescriberLastName;
	private String sigDecoded;
	private String narcoticNote;
	private String prescOID;
	private String DIN;
	private String OID;
	private String estMedicationFillDate;
	private String lastMedicationFillDate;
	private String prescriptionDisplayExpirationDate;
	private Integer prescriptionDisplayRemainingQuantity;
	private Integer prescriptionDisplayRemainingRepeats;
	private String originalOID;
	private String remainigRefills; //Added as part 99 refill logic implementation
	private String expirationDate; //Added as part 99 refill logic implementation
	private String remainingQuantity; //Added as part 99 refill logic implementation
	private int rxDate;
	private int automatedRefillAllowed;
	private int refillReminderAllowed;
	private String nextExpectedDate;
	private String operationalEventOid;
	
	public void setRxDate(int rxDate) {
		this.rxDate = rxDate;
	}
	public int getRxDate() {
		return rxDate;
	}

	/**
	 * @return the controlled
	 */
	public boolean isControlled() {
		return controlled;
	}

	/**
	 * @param controlled the controlled to set
	 */
	public void setControlled(boolean controlled) {
		this.controlled = controlled;
	}

	/**
	 * @return the noRefill
	 */
	public boolean isNoRefill() {
		return noRefill;
	}

	/**
	 * @param noRefill the noRefill to set
	 */
	public void setNoRefill(boolean noRefill) {
		this.noRefill = noRefill;
	}

	/**
	 * @return the remainigRefills
	 */
	public String getRemainigRefills() {
		return remainigRefills;
	}

	/**
	 * @param remainigRefills the remainigRefills to set
	 */
	public void setRemainigRefills(String remainigRefills) {
		this.remainigRefills = remainigRefills;
	}

	/**
	 * @return the expirationDate
	 */
	public String getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * @return the remainingQuantity
	 */
	public String getRemainingQuantity() {
		return remainingQuantity;
	}

	/**
	 * @param remainingQuantity the remainingQuantity to set
	 */
	public void setRemainingQuantity(String remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}

	/**
	 * @return the medNameComp
	 */
	public static Comparator<PrescriptionsBO> getMedNameComp() {
		return medNameComp;
	}

	/**
	 * @param medNameComp the medNameComp to set
	 */
	public static void setMedNameComp(Comparator<PrescriptionsBO> medNameComp) {
		PrescriptionsBO.medNameComp = medNameComp;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the originalOID
	 */
	public String getOriginalOID() {
		return originalOID;
	}

	/**
	 * @param originalOID the originalOID to set
	 */
	public void setOriginalOID(String originalOID) {
		this.originalOID = originalOID;
	}

	public String getPrescriptionDisplayExpirationDate() {
		return prescriptionDisplayExpirationDate;
	}

	public void setPrescriptionDisplayExpirationDate(
			String prescriptionDisplayExpirationDate) {
		this.prescriptionDisplayExpirationDate = prescriptionDisplayExpirationDate;
	}

	public Integer getPrescriptionDisplayRemainingQuantity() {
		return prescriptionDisplayRemainingQuantity;
	}

	public void setPrescriptionDisplayRemainingQuantity(
			Integer prescriptionDisplayRemainingQuantity) {
		this.prescriptionDisplayRemainingQuantity = prescriptionDisplayRemainingQuantity;
	}

	public Integer getPrescriptionDisplayRemainingRepeats() {
		return prescriptionDisplayRemainingRepeats;
	}

	public void setPrescriptionDisplayRemainingRepeats(
			Integer prescriptionDisplayRemainingRepeats) {
		this.prescriptionDisplayRemainingRepeats = prescriptionDisplayRemainingRepeats;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	public String getEstMedicationFillDate() {
		return estMedicationFillDate;
	}

	public void setEstMedicationFillDate(String estMedicationFillDate) {
		this.estMedicationFillDate = estMedicationFillDate;
	}

	public String getLastMedicationFillDate() {
		return lastMedicationFillDate;
	}

	public void setLastMedicationFillDate(String lastMedicationFillDate) {
		this.lastMedicationFillDate = lastMedicationFillDate;
	}

	public String getOID() {
		return OID;
	}

	public void setOID(String oID) {
		OID = oID;
	}

	public static Comparator<PrescriptionsBO> medNameComp = new Comparator<PrescriptionsBO>() {
		public int compare(PrescriptionsBO presc1, PrescriptionsBO presc2) {
			String prescName1 = null;
			String prescName2 = null;
			if(null != presc1.getName() && null != presc2.getName()) {
				prescName1 = presc1.getName().toUpperCase();
				prescName2 = presc2.getName().toUpperCase();
				return prescName1.compareTo(prescName2);
			} else {
				return 0;
			}
		}
	};
	
	public static Comparator<PrescriptionsBO> getLastFilledComp(final String strFormat, final Locale locale) {
		Comparator<PrescriptionsBO> retComp = new Comparator<PrescriptionsBO>() {
			public int compare(PrescriptionsBO presc1, PrescriptionsBO presc2) {
				String lastFill1 = presc1.getLastFilledDate();
				String lastFill2 = presc2.getLastFilledDate();
				Date dtLastFill1 = null;
				Date dtLastFill2 = null;
				SimpleDateFormat sdf = new SimpleDateFormat(strFormat, locale);
				if(null != lastFill1 && null != lastFill2) {
					try {
						dtLastFill1 = sdf.parse(lastFill1);
						dtLastFill2 = sdf.parse(lastFill2);
					} catch (ParseException parseExe) {
						log.error(parseExe.getMessage() + parseExe);					
					}
					return dtLastFill1.compareTo(dtLastFill2);
				} else {
					return 0;
				}
			}
		};
		
		return retComp;
	}
	
	public static Comparator<PrescriptionsBO> getNextFilledComp(final String strFormat, final Locale locale) {
		Comparator<PrescriptionsBO> retComp = new Comparator<PrescriptionsBO>() {
			public int compare(PrescriptionsBO presc1, PrescriptionsBO presc2) {
				String nxtFill1 = presc1.getEstimatedFillDate().toUpperCase();
				String nxtFill2 = presc2.getEstimatedFillDate().toUpperCase();
				Date dtNextFill1 = null;
				Date dtNextFill2 = null;
				SimpleDateFormat sdf = new SimpleDateFormat(strFormat, locale);
				if(null != nxtFill1 && null != nxtFill2) {
					try {
						dtNextFill1 = sdf.parse(nxtFill1);
						dtNextFill2 = sdf.parse(nxtFill2);
					} catch (ParseException parseExe) {
						log.error(parseExe.getMessage()+" "+ parseExe);
					}
					return dtNextFill1.compareTo(dtNextFill2);
				} else {
					return 0;
				}
			}
		};
		
		return retComp;
	}
	
	public boolean isNarcotic() {
		return narcotic;
	}

	public void setNarcotic(boolean narcotic) {
		this.narcotic = narcotic;
	}
	
	public boolean isRefillAllowed() {
		return refillAllowed;
	}

	public void setRefillAllowed(boolean refillAllowed) {
		this.refillAllowed = refillAllowed;
	}

	public boolean isRequiredETA() {
		return requiredETA;
	}

	public void setRequiredETA(boolean requiredETA) {
		this.requiredETA = requiredETA;
	}
	
	public String geteRestriction() {
		return eRestriction;
	}

	public void seteRestriction(String eRestriction) {
		this.eRestriction = eRestriction;
	}

	public String getEstimatedFillDate() {
		return estimatedFillDate;
	}

	public void setEstimatedFillDate(String estimatedFillDate) {
		this.estimatedFillDate = estimatedFillDate;
	}

	public String getRxNumber() {
		return rxNumber;
	}

	public void setRxNumber(String rxNumber) {
		this.rxNumber = rxNumber;
	}

	public String getLastFilledDate() {
		return lastFilledDate;
	}

	public void setLastFilledDate(String lastFilledDate) {
		this.lastFilledDate = lastFilledDate;
	}
	
	public String getHistLastFillDate() {
		return histLastFillDate;
	}
	
	public void setHistLastFillDate(String histLastFillDate) {
		this.histLastFillDate = histLastFillDate;
	}

	public int getQuantityFilled() {
		return quantityFilled;
	}

	public void setQuantityFilled(int quantityFilled) {
		this.quantityFilled = quantityFilled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public String getPrescriberFirstName() {
		return prescriberFirstName;
	}

	public int getRefillRemaining() {
		return refillRemaining;
	}

	public void setRefillRemaining(int refillRemaining) {
		this.refillRemaining = refillRemaining;
	}

	public void setPrescriberFirstName(String prescriberFirstName) {
		this.prescriberFirstName = prescriberFirstName;
	}

	public String getPrescriberLastName() {
		return prescriberLastName;
	}

	public void setPrescriberLastName(String prescriberLastName) {
		this.prescriberLastName = prescriberLastName;
	}

	public String getSigDecoded() {
		return sigDecoded;
	}

	public void setSigDecoded(String sigDecoded) {
		this.sigDecoded = sigDecoded;
	}

	public short getDaysSupply() {
		return daysSupply;
	}

	public void setDaysSupply(short daysSupply) {
		this.daysSupply = daysSupply;
	}
	
	public String getNarcoticNote() {
		return narcoticNote;
	}

	public void setNarcoticNote(String narcoticNote) {
		this.narcoticNote = narcoticNote;
	}
	
	public String getPrescOID() {
		return prescOID;
	}

	public void setPrescOID(String prescOID) {
		this.prescOID = prescOID;
	}
	
	public String getDIN() {
		return DIN;
	}

	public void setDIN(String dIN) {
		DIN = dIN;
	}

	public String getLastState() {
		return lastState;
	}

	public void setLastState(String lastState) {
		this.lastState = lastState;
	}
	public int getAutomatedRefillAllowed() {
		return automatedRefillAllowed;
	}
	public void setAutomatedRefillAllowed(int automatedRefillAllowed) {
		this.automatedRefillAllowed = automatedRefillAllowed;
	}
	public int getRefillReminderAllowed() {
		return refillReminderAllowed;
	}
	public void setRefillReminderAllowed(int refillReminderAllowed) {
		this.refillReminderAllowed = refillReminderAllowed;
	}
	public String getNextExpectedDate() {
		return nextExpectedDate;
	}
	public void setNextExpectedDate(String nextExpectedDate) {
		this.nextExpectedDate = nextExpectedDate;
	}
	public String getOperationalEventOid() {
		return operationalEventOid;
	}
	public void setOperationalEventOid(String operationalEventOid) {
		this.operationalEventOid = operationalEventOid;
	}
	public String getEstimatedFillDateEn() {
		return estimatedFillDateEn;
	}
	public void setEstimatedFillDateEn(String estimatedFillDateEn) {
		this.estimatedFillDateEn = estimatedFillDateEn;
	}
	
}
