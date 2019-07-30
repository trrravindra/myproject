
package com.lcl.erefill.generated.telus.advisor.advisorsheets.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.lcl.erefill.generated.telus.advisor.advisorsheets.rxassystlib.ELanguage;


/**
 * <p>Java class for CounsellingSheetLanguage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CounsellingSheetLanguage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Language" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eLanguage" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CounsellingSheetLanguage", propOrder = {
    "language"
})
public class CounsellingSheetLanguage {

    @XmlElement(name = "Language")
    protected ELanguage language;

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link ELanguage }
     *     
     */
    public ELanguage getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link ELanguage }
     *     
     */
    public void setLanguage(ELanguage value) {
        this.language = value;
    }

}
