
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.manager.rxassystlib.EGenderTargeted;
import com.lcl.erefill.generated.telus.manager.rxassystlib.ELegalStatus;
import com.lcl.erefill.generated.telus.manager.rxassystlib.EServiceType;


/**
 * <p>Java class for Product complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Product">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Compounds" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}ProductCompounds"/>
 *         &lt;element name="DIN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DINPackSize" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Flavor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Form" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="GenderTargeted" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eGenderTargeted"/>
 *         &lt;element name="GenericName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Group" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="IncludedInInventoryMng" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Indivisible" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="LegalStatus" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eLegalStatus"/>
 *         &lt;element name="MultipleActiveIngredients" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PackDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PackSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PackSizeMeasureUnit" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Schedule" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="ServiceType" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eServiceType"/>
 *         &lt;element name="Sig" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SigDecoded" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Strength" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SubGroup" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="SupplierCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SupplierName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Product", propOrder = {
    "compounds",
    "din",
    "dinPackSize",
    "flavor",
    "form",
    "genderTargeted",
    "genericName",
    "group",
    "includedInInventoryMng",
    "indivisible",
    "legalStatus",
    "multipleActiveIngredients",
    "name",
    "packDescription",
    "packSize",
    "packSizeMeasureUnit",
    "schedule",
    "serviceType",
    "sig",
    "sigDecoded",
    "strength",
    "subGroup",
    "supplierCode",
    "supplierName"
})
public class Product {

    @XmlElement(name = "Compounds", required = true, nillable = true)
    protected ProductCompounds compounds;
    @XmlElement(name = "DIN", required = true, nillable = true)
    protected String din;
    @XmlElement(name = "DINPackSize")
    protected short dinPackSize;
    @XmlElement(name = "Flavor", required = true, nillable = true)
    protected String flavor;
    @XmlElement(name = "Form", required = true, nillable = true)
    protected String form;
    @XmlElement(name = "GenderTargeted", required = true)
    protected EGenderTargeted genderTargeted;
    @XmlElement(name = "GenericName", required = true, nillable = true)
    protected String genericName;
    @XmlElement(name = "Group")
    protected short group;
    @XmlElement(name = "IncludedInInventoryMng")
    protected boolean includedInInventoryMng;
    @XmlElement(name = "Indivisible")
    protected boolean indivisible;
    @XmlElement(name = "LegalStatus", required = true)
    protected ELegalStatus legalStatus;
    @XmlElement(name = "MultipleActiveIngredients")
    protected boolean multipleActiveIngredients;
    @XmlElement(name = "Name", required = true, nillable = true)
    protected String name;
    @XmlElement(name = "PackDescription", required = true, nillable = true)
    protected String packDescription;
    @XmlElement(name = "PackSize")
    protected int packSize;
    @XmlElement(name = "PackSizeMeasureUnit", required = true, nillable = true)
    protected String packSizeMeasureUnit;
    @XmlElement(name = "Schedule")
    protected short schedule;
    @XmlElement(name = "ServiceType", required = true)
    protected EServiceType serviceType;
    @XmlElement(name = "Sig", required = true, nillable = true)
    protected String sig;
    @XmlElement(name = "SigDecoded", required = true, nillable = true)
    protected String sigDecoded;
    @XmlElement(name = "Strength", required = true, nillable = true)
    protected String strength;
    @XmlElement(name = "SubGroup")
    protected short subGroup;
    @XmlElement(name = "SupplierCode", required = true, nillable = true)
    protected String supplierCode;
    @XmlElement(name = "SupplierName", required = true, nillable = true)
    protected String supplierName;

    /**
     * Gets the value of the compounds property.
     * 
     * @return
     *     possible object is
     *     {@link ProductCompounds }
     *     
     */
    public ProductCompounds getCompounds() {
        return compounds;
    }

    /**
     * Sets the value of the compounds property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductCompounds }
     *     
     */
    public void setCompounds(ProductCompounds value) {
        this.compounds = value;
    }

    /**
     * Gets the value of the din property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDIN() {
        return din;
    }

    /**
     * Sets the value of the din property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDIN(String value) {
        this.din = value;
    }

    /**
     * Gets the value of the dinPackSize property.
     * 
     */
    public short getDINPackSize() {
        return dinPackSize;
    }

    /**
     * Sets the value of the dinPackSize property.
     * 
     */
    public void setDINPackSize(short value) {
        this.dinPackSize = value;
    }

    /**
     * Gets the value of the flavor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * Sets the value of the flavor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlavor(String value) {
        this.flavor = value;
    }

    /**
     * Gets the value of the form property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForm() {
        return form;
    }

    /**
     * Sets the value of the form property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForm(String value) {
        this.form = value;
    }

    /**
     * Gets the value of the genderTargeted property.
     * 
     * @return
     *     possible object is
     *     {@link EGenderTargeted }
     *     
     */
    public EGenderTargeted getGenderTargeted() {
        return genderTargeted;
    }

    /**
     * Sets the value of the genderTargeted property.
     * 
     * @param value
     *     allowed object is
     *     {@link EGenderTargeted }
     *     
     */
    public void setGenderTargeted(EGenderTargeted value) {
        this.genderTargeted = value;
    }

    /**
     * Gets the value of the genericName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenericName() {
        return genericName;
    }

    /**
     * Sets the value of the genericName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenericName(String value) {
        this.genericName = value;
    }

    /**
     * Gets the value of the group property.
     * 
     */
    public short getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     */
    public void setGroup(short value) {
        this.group = value;
    }

    /**
     * Gets the value of the includedInInventoryMng property.
     * 
     */
    public boolean isIncludedInInventoryMng() {
        return includedInInventoryMng;
    }

    /**
     * Sets the value of the includedInInventoryMng property.
     * 
     */
    public void setIncludedInInventoryMng(boolean value) {
        this.includedInInventoryMng = value;
    }

    /**
     * Gets the value of the indivisible property.
     * 
     */
    public boolean isIndivisible() {
        return indivisible;
    }

    /**
     * Sets the value of the indivisible property.
     * 
     */
    public void setIndivisible(boolean value) {
        this.indivisible = value;
    }

    /**
     * Gets the value of the legalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ELegalStatus }
     *     
     */
    public ELegalStatus getLegalStatus() {
        return legalStatus;
    }

    /**
     * Sets the value of the legalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ELegalStatus }
     *     
     */
    public void setLegalStatus(ELegalStatus value) {
        this.legalStatus = value;
    }

    /**
     * Gets the value of the multipleActiveIngredients property.
     * 
     */
    public boolean isMultipleActiveIngredients() {
        return multipleActiveIngredients;
    }

    /**
     * Sets the value of the multipleActiveIngredients property.
     * 
     */
    public void setMultipleActiveIngredients(boolean value) {
        this.multipleActiveIngredients = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the packDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackDescription() {
        return packDescription;
    }

    /**
     * Sets the value of the packDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackDescription(String value) {
        this.packDescription = value;
    }

    /**
     * Gets the value of the packSize property.
     * 
     */
    public int getPackSize() {
        return packSize;
    }

    /**
     * Sets the value of the packSize property.
     * 
     */
    public void setPackSize(int value) {
        this.packSize = value;
    }

    /**
     * Gets the value of the packSizeMeasureUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackSizeMeasureUnit() {
        return packSizeMeasureUnit;
    }

    /**
     * Sets the value of the packSizeMeasureUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackSizeMeasureUnit(String value) {
        this.packSizeMeasureUnit = value;
    }

    /**
     * Gets the value of the schedule property.
     * 
     */
    public short getSchedule() {
        return schedule;
    }

    /**
     * Sets the value of the schedule property.
     * 
     */
    public void setSchedule(short value) {
        this.schedule = value;
    }

    /**
     * Gets the value of the serviceType property.
     * 
     * @return
     *     possible object is
     *     {@link EServiceType }
     *     
     */
    public EServiceType getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EServiceType }
     *     
     */
    public void setServiceType(EServiceType value) {
        this.serviceType = value;
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
     * Gets the value of the strength property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrength() {
        return strength;
    }

    /**
     * Sets the value of the strength property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrength(String value) {
        this.strength = value;
    }

    /**
     * Gets the value of the subGroup property.
     * 
     */
    public short getSubGroup() {
        return subGroup;
    }

    /**
     * Sets the value of the subGroup property.
     * 
     */
    public void setSubGroup(short value) {
        this.subGroup = value;
    }

    /**
     * Gets the value of the supplierCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplierCode() {
        return supplierCode;
    }

    /**
     * Sets the value of the supplierCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplierCode(String value) {
        this.supplierCode = value;
    }

    /**
     * Gets the value of the supplierName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * Sets the value of the supplierName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplierName(String value) {
        this.supplierName = value;
    }

}
