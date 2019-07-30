
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.manager.rxassystlib.EPharmacySearchField;
import com.lcl.erefill.generated.telus.manager.rxassystlib.ESearchType;


/**
 * <p>Java class for PharmacySearchElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PharmacySearchElement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchField" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}ePharmacySearchField"/>
 *         &lt;element name="SearchText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SearchType" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eSearchType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PharmacySearchElement", propOrder = {
    "searchField",
    "searchText",
    "searchType"
})
public class PharmacySearchElement {

    @XmlElement(name = "SearchField", required = true)
    protected EPharmacySearchField searchField;
    @XmlElement(name = "SearchText", required = true, nillable = true)
    protected String searchText;
    @XmlElement(name = "SearchType", required = true)
    protected ESearchType searchType;

    /**
     * Gets the value of the searchField property.
     * 
     * @return
     *     possible object is
     *     {@link EPharmacySearchField }
     *     
     */
    public EPharmacySearchField getSearchField() {
        return searchField;
    }

    /**
     * Sets the value of the searchField property.
     * 
     * @param value
     *     allowed object is
     *     {@link EPharmacySearchField }
     *     
     */
    public void setSearchField(EPharmacySearchField value) {
        this.searchField = value;
    }

    /**
     * Gets the value of the searchText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchText() {
        return searchText;
    }

    /**
     * Sets the value of the searchText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchText(String value) {
        this.searchText = value;
    }

    /**
     * Gets the value of the searchType property.
     * 
     * @return
     *     possible object is
     *     {@link ESearchType }
     *     
     */
    public ESearchType getSearchType() {
        return searchType;
    }

    /**
     * Sets the value of the searchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ESearchType }
     *     
     */
    public void setSearchType(ESearchType value) {
        this.searchType = value;
    }

}
