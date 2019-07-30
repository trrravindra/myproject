
package com.lcl.erefill.generated.telus.profile.rxassystlib_contracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.lcl.erefill.generated.telus.profile.rxassystlib.EAbortedReason;
import com.lcl.erefill.generated.telus.profile.rxassystlib.EAttributeType;
import com.lcl.erefill.generated.telus.profile.rxassystlib.ECalendarType;
import com.lcl.erefill.generated.telus.profile.rxassystlib.EDeliveryStatus;
import com.lcl.erefill.generated.telus.profile.rxassystlib.EPackagingType;
import com.lcl.erefill.generated.telus.profile.rxassystlib.ERenewType;
import com.lcl.erefill.generated.telus.profile.rxassystlib.ERxType;


/**
 * <p>Java class for Prescription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Prescription">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Aborted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="AbortedDate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="AbortedReason" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eAbortedReason"/>
 *         &lt;element name="AccountNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AcquisitionCost" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="AmountPaidByPatient" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Attribute" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AttributeType" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eAttributeType"/>
 *         &lt;element name="CalendarType" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eCalendarType"/>
 *         &lt;element name="Chronic" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Comments" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Compound" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CompoundingFee" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CreationDate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="CurrentRepeat" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="DaysSupply" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Deferred" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="DeliveryDate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DeliveryStatus" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eDeliveryStatus"/>
 *         &lt;element name="DeliveryTime" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Discount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ExpirationDate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Fee" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Indication" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IndicationDecoded" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IndicationFreeText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Markup" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Narcotic" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="OID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OriginalNarcoticRxNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PRN" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PackagingType" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}ePackagingType"/>
 *         &lt;element name="Pharmacist" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}Pharmacist"/>
 *         &lt;element name="Pharmacy" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}Pharmacy"/>
 *         &lt;element name="Prescriber" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}Prescriber"/>
 *         &lt;element name="PrescriptionDisplay" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}PrescriptionDisplay" minOccurs="0"/>
 *         &lt;element name="Product" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}Product"/>
 *         &lt;element name="QuantityFilled" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="QuantityPrescribed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RemainingRepeats" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="RenewType" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eRenewType"/>
 *         &lt;element name="Repeats" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="RxDate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="RxNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RxType" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eRxType"/>
 *         &lt;element name="Sig" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SigDecoded" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SigFreeText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SpecialServicesFee" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ThirdParty1BilledAmount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ThirdParty2BilledAmount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ThirdParty3BilledAmount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Total" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TotalDaysSupply" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TotalQuantityFilled" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TotalQuantityPrescribed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TrxNumber" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UnitCost" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="UpCharge" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="WrittenDate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="AbortedDateV2" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="CreationDateV2" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ExpirationDateV2" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="DeliveryDateV2" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="RxDateV2" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="WrittenDateV2" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="OriginalPrescription" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}OriginalPrescription" minOccurs="0"/>
 *         &lt;element name="LastChangeDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Prescription", propOrder = {
    "aborted",
    "abortedDate",
    "abortedReason",
    "accountNumber",
    "acquisitionCost",
    "active",
    "amountPaidByPatient",
    "attribute",
    "attributeType",
    "calendarType",
    "chronic",
    "comments",
    "compound",
    "compoundingFee",
    "creationDate",
    "currentRepeat",
    "daysSupply",
    "deferred",
    "deliveryDate",
    "deliveryStatus",
    "deliveryTime",
    "discount",
    "expirationDate",
    "fee",
    "indication",
    "indicationDecoded",
    "indicationFreeText",
    "markup",
    "narcotic",
    "oid",
    "originalNarcoticRxNumber",
    "prn",
    "packagingType",
    "pharmacist",
    "pharmacy",
    "prescriber",
    "prescriptionDisplay",
    "product",
    "quantityFilled",
    "quantityPrescribed",
    "remainingRepeats",
    "renewType",
    "repeats",
    "rxDate",
    "rxNumber",
    "rxType",
    "sig",
    "sigDecoded",
    "sigFreeText",
    "specialServicesFee",
    "thirdParty1BilledAmount",
    "thirdParty2BilledAmount",
    "thirdParty3BilledAmount",
    "total",
    "totalDaysSupply",
    "totalQuantityFilled",
    "totalQuantityPrescribed",
    "trxNumber",
    "unitCost",
    "upCharge",
    "writtenDate",
    "abortedDateV2",
    "creationDateV2",
    "expirationDateV2",
    "deliveryDateV2",
    "rxDateV2",
    "writtenDateV2",
    "originalPrescription",
    "lastChangeDate"
})
@XmlSeeAlso({
    ProfilePrescription.class
})
public class Prescription {

    @XmlElement(name = "Aborted")
    protected boolean aborted;
    @XmlElement(name = "AbortedDate")
    protected Integer abortedDate;
    @XmlElement(name = "AbortedReason", required = true)
    protected EAbortedReason abortedReason;
    @XmlElement(name = "AccountNumber", required = true, nillable = true)
    protected String accountNumber;
    @XmlElement(name = "AcquisitionCost")
    protected int acquisitionCost;
    @XmlElement(name = "Active")
    protected boolean active;
    @XmlElement(name = "AmountPaidByPatient")
    protected int amountPaidByPatient;
    @XmlElement(name = "Attribute", required = true, nillable = true)
    protected String attribute;
    @XmlElement(name = "AttributeType", required = true)
    protected EAttributeType attributeType;
    @XmlElement(name = "CalendarType", required = true)
    protected ECalendarType calendarType;
    @XmlElement(name = "Chronic")
    protected boolean chronic;
    @XmlElement(name = "Comments", required = true, nillable = true)
    protected String comments;
    @XmlElement(name = "Compound")
    protected boolean compound;
    @XmlElement(name = "CompoundingFee")
    protected int compoundingFee;
    @XmlElement(name = "CreationDate")
    protected Integer creationDate;
    @XmlElement(name = "CurrentRepeat")
    protected short currentRepeat;
    @XmlElement(name = "DaysSupply")
    protected short daysSupply;
    @XmlElement(name = "Deferred")
    protected boolean deferred;
    @XmlElement(name = "DeliveryDate")
    protected Integer deliveryDate;
    @XmlElement(name = "DeliveryStatus", required = true)
    protected EDeliveryStatus deliveryStatus;
    @XmlElement(name = "DeliveryTime")
    protected Integer deliveryTime;
    @XmlElement(name = "Discount")
    protected int discount;
    @XmlElement(name = "ExpirationDate")
    protected Integer expirationDate;
    @XmlElement(name = "Fee")
    protected int fee;
    @XmlElement(name = "Indication", required = true, nillable = true)
    protected String indication;
    @XmlElement(name = "IndicationDecoded", required = true, nillable = true)
    protected String indicationDecoded;
    @XmlElement(name = "IndicationFreeText", required = true, nillable = true)
    protected String indicationFreeText;
    @XmlElement(name = "Markup")
    protected int markup;
    @XmlElement(name = "Narcotic")
    protected boolean narcotic;
    @XmlElement(name = "OID", required = true, nillable = true)
    protected String oid;
    @XmlElement(name = "OriginalNarcoticRxNumber", required = true, nillable = true)
    protected String originalNarcoticRxNumber;
    @XmlElement(name = "PRN")
    protected boolean prn;
    @XmlElement(name = "PackagingType", required = true)
    protected EPackagingType packagingType;
    @XmlElement(name = "Pharmacist", required = true, nillable = true)
    protected Pharmacist pharmacist;
    @XmlElement(name = "Pharmacy", required = true, nillable = true)
    protected Pharmacy pharmacy;
    @XmlElement(name = "Prescriber", required = true, nillable = true)
    protected Prescriber prescriber;
    @XmlElementRef(name = "PrescriptionDisplay", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<PrescriptionDisplay> prescriptionDisplay;
    @XmlElement(name = "Product", required = true, nillable = true)
    protected Product product;
    @XmlElement(name = "QuantityFilled")
    protected int quantityFilled;
    @XmlElement(name = "QuantityPrescribed")
    protected int quantityPrescribed;
    @XmlElement(name = "RemainingRepeats")
    protected short remainingRepeats;
    @XmlElement(name = "RenewType", required = true)
    protected ERenewType renewType;
    @XmlElement(name = "Repeats")
    protected short repeats;
    @XmlElement(name = "RxDate")
    protected Integer rxDate;
    @XmlElement(name = "RxNumber", required = true, nillable = true)
    protected String rxNumber;
    @XmlElement(name = "RxType", required = true)
    protected ERxType rxType;
    @XmlElement(name = "Sig", required = true, nillable = true)
    protected String sig;
    @XmlElement(name = "SigDecoded", required = true, nillable = true)
    protected String sigDecoded;
    @XmlElement(name = "SigFreeText", required = true, nillable = true)
    protected String sigFreeText;
    @XmlElement(name = "SpecialServicesFee")
    protected int specialServicesFee;
    @XmlElement(name = "ThirdParty1BilledAmount")
    protected int thirdParty1BilledAmount;
    @XmlElement(name = "ThirdParty2BilledAmount")
    protected int thirdParty2BilledAmount;
    @XmlElement(name = "ThirdParty3BilledAmount")
    protected int thirdParty3BilledAmount;
    @XmlElement(name = "Total")
    protected int total;
    @XmlElement(name = "TotalDaysSupply")
    protected int totalDaysSupply;
    @XmlElement(name = "TotalQuantityFilled")
    protected int totalQuantityFilled;
    @XmlElement(name = "TotalQuantityPrescribed")
    protected int totalQuantityPrescribed;
    @XmlElement(name = "TrxNumber")
    protected long trxNumber;
    @XmlElement(name = "UnitCost")
    protected int unitCost;
    @XmlElement(name = "UpCharge")
    protected int upCharge;
    @XmlElement(name = "WrittenDate")
    protected Integer writtenDate;
    @XmlElementRef(name = "AbortedDateV2", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> abortedDateV2;
    @XmlElementRef(name = "CreationDateV2", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> creationDateV2;
    @XmlElementRef(name = "ExpirationDateV2", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> expirationDateV2;
    @XmlElementRef(name = "DeliveryDateV2", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> deliveryDateV2;
    @XmlElement(name = "RxDateV2")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar rxDateV2;
    @XmlElementRef(name = "WrittenDateV2", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> writtenDateV2;
    @XmlElementRef(name = "OriginalPrescription", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<OriginalPrescription> originalPrescription;
    @XmlElementRef(name = "LastChangeDate", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> lastChangeDate;

    /**
     * Gets the value of the aborted property.
     * 
     */
    public boolean isAborted() {
        return aborted;
    }

    /**
     * Sets the value of the aborted property.
     * 
     */
    public void setAborted(boolean value) {
        this.aborted = value;
    }

    /**
     * Gets the value of the abortedDate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAbortedDate() {
        return abortedDate;
    }

    /**
     * Sets the value of the abortedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAbortedDate(Integer value) {
        this.abortedDate = value;
    }

    /**
     * Gets the value of the abortedReason property.
     * 
     * @return
     *     possible object is
     *     {@link EAbortedReason }
     *     
     */
    public EAbortedReason getAbortedReason() {
        return abortedReason;
    }

    /**
     * Sets the value of the abortedReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link EAbortedReason }
     *     
     */
    public void setAbortedReason(EAbortedReason value) {
        this.abortedReason = value;
    }

    /**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the acquisitionCost property.
     * 
     */
    public int getAcquisitionCost() {
        return acquisitionCost;
    }

    /**
     * Sets the value of the acquisitionCost property.
     * 
     */
    public void setAcquisitionCost(int value) {
        this.acquisitionCost = value;
    }

    /**
     * Gets the value of the active property.
     * 
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     */
    public void setActive(boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the amountPaidByPatient property.
     * 
     */
    public int getAmountPaidByPatient() {
        return amountPaidByPatient;
    }

    /**
     * Sets the value of the amountPaidByPatient property.
     * 
     */
    public void setAmountPaidByPatient(int value) {
        this.amountPaidByPatient = value;
    }

    /**
     * Gets the value of the attribute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttribute() {
        return attribute;
    }

    /**
     * Sets the value of the attribute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttribute(String value) {
        this.attribute = value;
    }

    /**
     * Gets the value of the attributeType property.
     * 
     * @return
     *     possible object is
     *     {@link EAttributeType }
     *     
     */
    public EAttributeType getAttributeType() {
        return attributeType;
    }

    /**
     * Sets the value of the attributeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EAttributeType }
     *     
     */
    public void setAttributeType(EAttributeType value) {
        this.attributeType = value;
    }

    /**
     * Gets the value of the calendarType property.
     * 
     * @return
     *     possible object is
     *     {@link ECalendarType }
     *     
     */
    public ECalendarType getCalendarType() {
        return calendarType;
    }

    /**
     * Sets the value of the calendarType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ECalendarType }
     *     
     */
    public void setCalendarType(ECalendarType value) {
        this.calendarType = value;
    }

    /**
     * Gets the value of the chronic property.
     * 
     */
    public boolean isChronic() {
        return chronic;
    }

    /**
     * Sets the value of the chronic property.
     * 
     */
    public void setChronic(boolean value) {
        this.chronic = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Gets the value of the compound property.
     * 
     */
    public boolean isCompound() {
        return compound;
    }

    /**
     * Sets the value of the compound property.
     * 
     */
    public void setCompound(boolean value) {
        this.compound = value;
    }

    /**
     * Gets the value of the compoundingFee property.
     * 
     */
    public int getCompoundingFee() {
        return compoundingFee;
    }

    /**
     * Sets the value of the compoundingFee property.
     * 
     */
    public void setCompoundingFee(int value) {
        this.compoundingFee = value;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCreationDate(Integer value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the currentRepeat property.
     * 
     */
    public short getCurrentRepeat() {
        return currentRepeat;
    }

    /**
     * Sets the value of the currentRepeat property.
     * 
     */
    public void setCurrentRepeat(short value) {
        this.currentRepeat = value;
    }

    /**
     * Gets the value of the daysSupply property.
     * 
     */
    public short getDaysSupply() {
        return daysSupply;
    }

    /**
     * Sets the value of the daysSupply property.
     * 
     */
    public void setDaysSupply(short value) {
        this.daysSupply = value;
    }

    /**
     * Gets the value of the deferred property.
     * 
     */
    public boolean isDeferred() {
        return deferred;
    }

    /**
     * Sets the value of the deferred property.
     * 
     */
    public void setDeferred(boolean value) {
        this.deferred = value;
    }

    /**
     * Gets the value of the deliveryDate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Sets the value of the deliveryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDeliveryDate(Integer value) {
        this.deliveryDate = value;
    }

    /**
     * Gets the value of the deliveryStatus property.
     * 
     * @return
     *     possible object is
     *     {@link EDeliveryStatus }
     *     
     */
    public EDeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    /**
     * Sets the value of the deliveryStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link EDeliveryStatus }
     *     
     */
    public void setDeliveryStatus(EDeliveryStatus value) {
        this.deliveryStatus = value;
    }

    /**
     * Gets the value of the deliveryTime property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * Sets the value of the deliveryTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDeliveryTime(Integer value) {
        this.deliveryTime = value;
    }

    /**
     * Gets the value of the discount property.
     * 
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * Sets the value of the discount property.
     * 
     */
    public void setDiscount(int value) {
        this.discount = value;
    }

    /**
     * Gets the value of the expirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the value of the expirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setExpirationDate(Integer value) {
        this.expirationDate = value;
    }

    /**
     * Gets the value of the fee property.
     * 
     */
    public int getFee() {
        return fee;
    }

    /**
     * Sets the value of the fee property.
     * 
     */
    public void setFee(int value) {
        this.fee = value;
    }

    /**
     * Gets the value of the indication property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndication() {
        return indication;
    }

    /**
     * Sets the value of the indication property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndication(String value) {
        this.indication = value;
    }

    /**
     * Gets the value of the indicationDecoded property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicationDecoded() {
        return indicationDecoded;
    }

    /**
     * Sets the value of the indicationDecoded property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicationDecoded(String value) {
        this.indicationDecoded = value;
    }

    /**
     * Gets the value of the indicationFreeText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicationFreeText() {
        return indicationFreeText;
    }

    /**
     * Sets the value of the indicationFreeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicationFreeText(String value) {
        this.indicationFreeText = value;
    }

    /**
     * Gets the value of the markup property.
     * 
     */
    public int getMarkup() {
        return markup;
    }

    /**
     * Sets the value of the markup property.
     * 
     */
    public void setMarkup(int value) {
        this.markup = value;
    }

    /**
     * Gets the value of the narcotic property.
     * 
     */
    public boolean isNarcotic() {
        return narcotic;
    }

    /**
     * Sets the value of the narcotic property.
     * 
     */
    public void setNarcotic(boolean value) {
        this.narcotic = value;
    }

    /**
     * Gets the value of the oid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOID() {
        return oid;
    }

    /**
     * Sets the value of the oid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOID(String value) {
        this.oid = value;
    }

    /**
     * Gets the value of the originalNarcoticRxNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalNarcoticRxNumber() {
        return originalNarcoticRxNumber;
    }

    /**
     * Sets the value of the originalNarcoticRxNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalNarcoticRxNumber(String value) {
        this.originalNarcoticRxNumber = value;
    }

    /**
     * Gets the value of the prn property.
     * 
     */
    public boolean isPRN() {
        return prn;
    }

    /**
     * Sets the value of the prn property.
     * 
     */
    public void setPRN(boolean value) {
        this.prn = value;
    }

    /**
     * Gets the value of the packagingType property.
     * 
     * @return
     *     possible object is
     *     {@link EPackagingType }
     *     
     */
    public EPackagingType getPackagingType() {
        return packagingType;
    }

    /**
     * Sets the value of the packagingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EPackagingType }
     *     
     */
    public void setPackagingType(EPackagingType value) {
        this.packagingType = value;
    }

    /**
     * Gets the value of the pharmacist property.
     * 
     * @return
     *     possible object is
     *     {@link Pharmacist }
     *     
     */
    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    /**
     * Sets the value of the pharmacist property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pharmacist }
     *     
     */
    public void setPharmacist(Pharmacist value) {
        this.pharmacist = value;
    }

    /**
     * Gets the value of the pharmacy property.
     * 
     * @return
     *     possible object is
     *     {@link Pharmacy }
     *     
     */
    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    /**
     * Sets the value of the pharmacy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pharmacy }
     *     
     */
    public void setPharmacy(Pharmacy value) {
        this.pharmacy = value;
    }

    /**
     * Gets the value of the prescriber property.
     * 
     * @return
     *     possible object is
     *     {@link Prescriber }
     *     
     */
    public Prescriber getPrescriber() {
        return prescriber;
    }

    /**
     * Sets the value of the prescriber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Prescriber }
     *     
     */
    public void setPrescriber(Prescriber value) {
        this.prescriber = value;
    }

    /**
     * Gets the value of the prescriptionDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PrescriptionDisplay }{@code >}
     *     
     */
    public JAXBElement<PrescriptionDisplay> getPrescriptionDisplay() {
        return prescriptionDisplay;
    }

    /**
     * Sets the value of the prescriptionDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PrescriptionDisplay }{@code >}
     *     
     */
    public void setPrescriptionDisplay(JAXBElement<PrescriptionDisplay> value) {
        this.prescriptionDisplay = value;
    }

    /**
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link Product }
     *     
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link Product }
     *     
     */
    public void setProduct(Product value) {
        this.product = value;
    }

    /**
     * Gets the value of the quantityFilled property.
     * 
     */
    public int getQuantityFilled() {
        return quantityFilled;
    }

    /**
     * Sets the value of the quantityFilled property.
     * 
     */
    public void setQuantityFilled(int value) {
        this.quantityFilled = value;
    }

    /**
     * Gets the value of the quantityPrescribed property.
     * 
     */
    public int getQuantityPrescribed() {
        return quantityPrescribed;
    }

    /**
     * Sets the value of the quantityPrescribed property.
     * 
     */
    public void setQuantityPrescribed(int value) {
        this.quantityPrescribed = value;
    }

    /**
     * Gets the value of the remainingRepeats property.
     * 
     */
    public short getRemainingRepeats() {
        return remainingRepeats;
    }

    /**
     * Sets the value of the remainingRepeats property.
     * 
     */
    public void setRemainingRepeats(short value) {
        this.remainingRepeats = value;
    }

    /**
     * Gets the value of the renewType property.
     * 
     * @return
     *     possible object is
     *     {@link ERenewType }
     *     
     */
    public ERenewType getRenewType() {
        return renewType;
    }

    /**
     * Sets the value of the renewType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ERenewType }
     *     
     */
    public void setRenewType(ERenewType value) {
        this.renewType = value;
    }

    /**
     * Gets the value of the repeats property.
     * 
     */
    public short getRepeats() {
        return repeats;
    }

    /**
     * Sets the value of the repeats property.
     * 
     */
    public void setRepeats(short value) {
        this.repeats = value;
    }

    /**
     * Gets the value of the rxDate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRxDate() {
        return rxDate;
    }

    /**
     * Sets the value of the rxDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRxDate(Integer value) {
        this.rxDate = value;
    }

    /**
     * Gets the value of the rxNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRxNumber() {
        return rxNumber;
    }

    /**
     * Sets the value of the rxNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRxNumber(String value) {
        this.rxNumber = value;
    }

    /**
     * Gets the value of the rxType property.
     * 
     * @return
     *     possible object is
     *     {@link ERxType }
     *     
     */
    public ERxType getRxType() {
        return rxType;
    }

    /**
     * Sets the value of the rxType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ERxType }
     *     
     */
    public void setRxType(ERxType value) {
        this.rxType = value;
    }

    /**
     * Gets the value of the sig property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSig() {
        return sig;
    }

    /**
     * Sets the value of the sig property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSig(String value) {
        this.sig = value;
    }

    /**
     * Gets the value of the sigDecoded property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSigDecoded() {
        return sigDecoded;
    }

    /**
     * Sets the value of the sigDecoded property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSigDecoded(String value) {
        this.sigDecoded = value;
    }

    /**
     * Gets the value of the sigFreeText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSigFreeText() {
        return sigFreeText;
    }

    /**
     * Sets the value of the sigFreeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSigFreeText(String value) {
        this.sigFreeText = value;
    }

    /**
     * Gets the value of the specialServicesFee property.
     * 
     */
    public int getSpecialServicesFee() {
        return specialServicesFee;
    }

    /**
     * Sets the value of the specialServicesFee property.
     * 
     */
    public void setSpecialServicesFee(int value) {
        this.specialServicesFee = value;
    }

    /**
     * Gets the value of the thirdParty1BilledAmount property.
     * 
     */
    public int getThirdParty1BilledAmount() {
        return thirdParty1BilledAmount;
    }

    /**
     * Sets the value of the thirdParty1BilledAmount property.
     * 
     */
    public void setThirdParty1BilledAmount(int value) {
        this.thirdParty1BilledAmount = value;
    }

    /**
     * Gets the value of the thirdParty2BilledAmount property.
     * 
     */
    public int getThirdParty2BilledAmount() {
        return thirdParty2BilledAmount;
    }

    /**
     * Sets the value of the thirdParty2BilledAmount property.
     * 
     */
    public void setThirdParty2BilledAmount(int value) {
        this.thirdParty2BilledAmount = value;
    }

    /**
     * Gets the value of the thirdParty3BilledAmount property.
     * 
     */
    public int getThirdParty3BilledAmount() {
        return thirdParty3BilledAmount;
    }

    /**
     * Sets the value of the thirdParty3BilledAmount property.
     * 
     */
    public void setThirdParty3BilledAmount(int value) {
        this.thirdParty3BilledAmount = value;
    }

    /**
     * Gets the value of the total property.
     * 
     */
    public int getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     */
    public void setTotal(int value) {
        this.total = value;
    }

    /**
     * Gets the value of the totalDaysSupply property.
     * 
     */
    public int getTotalDaysSupply() {
        return totalDaysSupply;
    }

    /**
     * Sets the value of the totalDaysSupply property.
     * 
     */
    public void setTotalDaysSupply(int value) {
        this.totalDaysSupply = value;
    }

    /**
     * Gets the value of the totalQuantityFilled property.
     * 
     */
    public int getTotalQuantityFilled() {
        return totalQuantityFilled;
    }

    /**
     * Sets the value of the totalQuantityFilled property.
     * 
     */
    public void setTotalQuantityFilled(int value) {
        this.totalQuantityFilled = value;
    }

    /**
     * Gets the value of the totalQuantityPrescribed property.
     * 
     */
    public int getTotalQuantityPrescribed() {
        return totalQuantityPrescribed;
    }

    /**
     * Sets the value of the totalQuantityPrescribed property.
     * 
     */
    public void setTotalQuantityPrescribed(int value) {
        this.totalQuantityPrescribed = value;
    }

    /**
     * Gets the value of the trxNumber property.
     * 
     */
    public long getTrxNumber() {
        return trxNumber;
    }

    /**
     * Sets the value of the trxNumber property.
     * 
     */
    public void setTrxNumber(long value) {
        this.trxNumber = value;
    }

    /**
     * Gets the value of the unitCost property.
     * 
     */
    public int getUnitCost() {
        return unitCost;
    }

    /**
     * Sets the value of the unitCost property.
     * 
     */
    public void setUnitCost(int value) {
        this.unitCost = value;
    }

    /**
     * Gets the value of the upCharge property.
     * 
     */
    public int getUpCharge() {
        return upCharge;
    }

    /**
     * Sets the value of the upCharge property.
     * 
     */
    public void setUpCharge(int value) {
        this.upCharge = value;
    }

    /**
     * Gets the value of the writtenDate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWrittenDate() {
        return writtenDate;
    }

    /**
     * Sets the value of the writtenDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWrittenDate(Integer value) {
        this.writtenDate = value;
    }

    /**
     * Gets the value of the abortedDateV2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getAbortedDateV2() {
        return abortedDateV2;
    }

    /**
     * Sets the value of the abortedDateV2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setAbortedDateV2(JAXBElement<XMLGregorianCalendar> value) {
        this.abortedDateV2 = value;
    }

    /**
     * Gets the value of the creationDateV2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getCreationDateV2() {
        return creationDateV2;
    }

    /**
     * Sets the value of the creationDateV2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setCreationDateV2(JAXBElement<XMLGregorianCalendar> value) {
        this.creationDateV2 = value;
    }

    /**
     * Gets the value of the expirationDateV2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getExpirationDateV2() {
        return expirationDateV2;
    }

    /**
     * Sets the value of the expirationDateV2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setExpirationDateV2(JAXBElement<XMLGregorianCalendar> value) {
        this.expirationDateV2 = value;
    }

    /**
     * Gets the value of the deliveryDateV2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDeliveryDateV2() {
        return deliveryDateV2;
    }

    /**
     * Sets the value of the deliveryDateV2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDeliveryDateV2(JAXBElement<XMLGregorianCalendar> value) {
        this.deliveryDateV2 = value;
    }

    /**
     * Gets the value of the rxDateV2 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRxDateV2() {
        return rxDateV2;
    }

    /**
     * Sets the value of the rxDateV2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRxDateV2(XMLGregorianCalendar value) {
        this.rxDateV2 = value;
    }

    /**
     * Gets the value of the writtenDateV2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getWrittenDateV2() {
        return writtenDateV2;
    }

    /**
     * Sets the value of the writtenDateV2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setWrittenDateV2(JAXBElement<XMLGregorianCalendar> value) {
        this.writtenDateV2 = value;
    }

    /**
     * Gets the value of the originalPrescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OriginalPrescription }{@code >}
     *     
     */
    public JAXBElement<OriginalPrescription> getOriginalPrescription() {
        return originalPrescription;
    }

    /**
     * Sets the value of the originalPrescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OriginalPrescription }{@code >}
     *     
     */
    public void setOriginalPrescription(JAXBElement<OriginalPrescription> value) {
        this.originalPrescription = value;
    }

    /**
     * Gets the value of the lastChangeDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getLastChangeDate() {
        return lastChangeDate;
    }

    /**
     * Sets the value of the lastChangeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setLastChangeDate(JAXBElement<XMLGregorianCalendar> value) {
        this.lastChangeDate = value;
    }

}
