
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.manager.rxassystloggerlib.SimpleError;


/**
 * <p>Java class for Error complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Error">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/RxAssystLoggerLib.Contracts}SimpleError">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}ErrorCodes" minOccurs="0"/>
 *         &lt;element name="UserToken" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}UserToken" minOccurs="0"/>
 *         &lt;element name="InternalErrorCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Error", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Error", propOrder = {
    "type",
    "userToken",
    "internalErrorCode"
})
public class Error
    extends SimpleError
{

    @XmlList
    @XmlElement(name = "Type")
    protected List<String> type;
    @XmlElementRef(name = "UserToken", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Error", type = JAXBElement.class)
    protected JAXBElement<UserToken> userToken;
    @XmlElement(name = "InternalErrorCode")
    protected Integer internalErrorCode;

    /**
     * Gets the value of the type property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the type property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getType() {
        if (type == null) {
            type = new ArrayList<String>();
        }
        return this.type;
    }

    /**
     * Gets the value of the userToken property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link UserToken }{@code >}
     *     
     */
    public JAXBElement<UserToken> getUserToken() {
        return userToken;
    }

    /**
     * Sets the value of the userToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link UserToken }{@code >}
     *     
     */
    public void setUserToken(JAXBElement<UserToken> value) {
        this.userToken = value;
    }

    /**
     * Gets the value of the internalErrorCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInternalErrorCode() {
        return internalErrorCode;
    }

    /**
     * Sets the value of the internalErrorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInternalErrorCode(Integer value) {
        this.internalErrorCode = value;
    }

}
