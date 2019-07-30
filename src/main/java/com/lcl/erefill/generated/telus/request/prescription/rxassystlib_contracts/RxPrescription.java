
package com.lcl.erefill.generated.telus.request.prescription.rxassystlib_contracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.lcl.erefill.generated.telus.request.prescription.rxassystlib.ERxPrescriptionState;


/**
 * <p>Java class for RxPrescription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RxPrescription">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Aborted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Comments" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DaysSupply" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="ExpirationDate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="LastState" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eRxPrescriptionState"/>
 *         &lt;element name="LastStateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Narcotic" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="OID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PRN" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ProductDin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProductForm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProductStrength" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QuantityFilled" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="QuantityPrescribed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Repeats" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="RxDate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="RxNewPrescription" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}RxPrescription"/>
 *         &lt;element name="RxNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SigDecoded" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Total" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TrxNumber" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RxDateV2" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ExpirationDateV2" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Restrictions" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}PrescriptionRestrictions" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RxPrescription", propOrder = {
    "aborted",
    "comments",
    "daysSupply",
    "expirationDate",
    "lastState",
    "lastStateDate",
    "narcotic",
    "oid",
    "prn",
    "productDin",
    "productForm",
    "productName",
    "productStrength",
    "quantityFilled",
    "quantityPrescribed",
    "repeats",
    "rxDate",
    "rxNewPrescription",
    "rxNumber",
    "sigDecoded",
    "total",
    "trxNumber",
    "rxDateV2",
    "expirationDateV2",
    "restrictions"
})
public class RxPrescription {

    @XmlElement(name = "Aborted")
    protected boolean aborted;
    @XmlElement(name = "Comments", required = true, nillable = true)
    protected String comments;
    @XmlElement(name = "DaysSupply")
    protected short daysSupply;
    @XmlElement(name = "ExpirationDate")
    protected Integer expirationDate;
    @XmlElement(name = "LastState", required = true)
    protected ERxPrescriptionState lastState;
    @XmlElement(name = "LastStateDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastStateDate;
    @XmlElement(name = "Narcotic")
    protected boolean narcotic;
    @XmlElement(name = "OID", required = true, nillable = true)
    protected String oid;
    @XmlElement(name = "PRN")
    protected boolean prn;
    @XmlElement(name = "ProductDin", required = true, nillable = true)
    protected String productDin;
    @XmlElementRef(name = "ProductForm", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<String> productForm;
    @XmlElement(name = "ProductName", required = true, nillable = true)
    protected String productName;
    @XmlElementRef(name = "ProductStrength", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<String> productStrength;
    @XmlElement(name = "QuantityFilled")
    protected int quantityFilled;
    @XmlElement(name = "QuantityPrescribed")
    protected int quantityPrescribed;
    @XmlElement(name = "Repeats")
    protected short repeats;
    @XmlElement(name = "RxDate")
    protected Integer rxDate;
    @XmlElement(name = "RxNewPrescription", required = true, nillable = true)
    protected RxPrescription rxNewPrescription;
    @XmlElement(name = "RxNumber", required = true, nillable = true)
    protected String rxNumber;
    @XmlElementRef(name = "SigDecoded", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<String> sigDecoded;
    @XmlElement(name = "Total")
    protected int total;
    @XmlElement(name = "TrxNumber")
    protected long trxNumber;
    @XmlElement(name = "RxDateV2")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar rxDateV2;
    @XmlElementRef(name = "ExpirationDateV2", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> expirationDateV2;
    @XmlElementRef(name = "Restrictions", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<PrescriptionRestrictions> restrictions;

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
     * Gets the value of the lastState property.
     * 
     * @return
     *     possible object is
     *     {@link ERxPrescriptionState }
     *     
     */
    public ERxPrescriptionState getLastState() {
        return lastState;
    }

    /**
     * Sets the value of the lastState property.
     * 
     * @param value
     *     allowed object is
     *     {@link ERxPrescriptionState }
     *     
     */
    public void setLastState(ERxPrescriptionState value) {
        this.lastState = value;
    }

    /**
     * Gets the value of the lastStateDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastStateDate() {
        return lastStateDate;
    }

    /**
     * Sets the value of the lastStateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastStateDate(XMLGregorianCalendar value) {
        this.lastStateDate = value;
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
     * Gets the value of the productDin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductDin() {
        return productDin;
    }

    /**
     * Sets the value of the productDin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductDin(String value) {
        this.productDin = value;
    }

    /**
     * Gets the value of the productForm property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProductForm() {
        return productForm;
    }

    /**
     * Sets the value of the productForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProductForm(JAXBElement<String> value) {
        this.productForm = value;
    }

    /**
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * Gets the value of the productStrength property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProductStrength() {
        return productStrength;
    }

    /**
     * Sets the value of the productStrength property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProductStrength(JAXBElement<String> value) {
        this.productStrength = value;
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
     * Gets the value of the rxNewPrescription property.
     * 
     * @return
     *     possible object is
     *     {@link RxPrescription }
     *     
     */
    public RxPrescription getRxNewPrescription() {
        return rxNewPrescription;
    }

    /**
     * Sets the value of the rxNewPrescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link RxPrescription }
     *     
     */
    public void setRxNewPrescription(RxPrescription value) {
        this.rxNewPrescription = value;
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
     * Gets the value of the sigDecoded property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSigDecoded() {
        return sigDecoded;
    }

    /**
     * Sets the value of the sigDecoded property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSigDecoded(JAXBElement<String> value) {
        this.sigDecoded = value;
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
     * Gets the value of the restrictions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PrescriptionRestrictions }{@code >}
     *     
     */
    public JAXBElement<PrescriptionRestrictions> getRestrictions() {
        return restrictions;
    }

    /**
     * Sets the value of the restrictions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PrescriptionRestrictions }{@code >}
     *     
     */
    public void setRestrictions(JAXBElement<PrescriptionRestrictions> value) {
        this.restrictions = value;
    }

}
