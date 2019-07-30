
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.lcl.erefill.generated.telus.manager.rxassystlib.EFamilyManagerAssignRequestState;


/**
 * <p>Java class for FamilyManagerPatientRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FamilyManagerPatientRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IsRequestor" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RequestsState" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eFamilyManagerAssignRequestState"/>
 *         &lt;element name="StateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FamilyManagerPatientRequest", propOrder = {
    "email",
    "firstName",
    "isRequestor",
    "lastName",
    "requestsState",
    "stateDate",
    "userName",
    "description"
})
public class FamilyManagerPatientRequest {

    @XmlElement(name = "Email", required = true, nillable = true)
    protected String email;
    @XmlElement(name = "FirstName", required = true, nillable = true)
    protected String firstName;
    @XmlElement(name = "IsRequestor")
    protected boolean isRequestor;
    @XmlElement(name = "LastName", required = true, nillable = true)
    protected String lastName;
    @XmlElement(name = "RequestsState", required = true)
    protected EFamilyManagerAssignRequestState requestsState;
    @XmlElement(name = "StateDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar stateDate;
    @XmlElement(name = "UserName", required = true, nillable = true)
    protected String userName;
    @XmlElementRef(name = "Description", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", type = JAXBElement.class)
    protected JAXBElement<String> description;

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the isRequestor property.
     * 
     */
    public boolean isIsRequestor() {
        return isRequestor;
    }

    /**
     * Sets the value of the isRequestor property.
     * 
     */
    public void setIsRequestor(boolean value) {
        this.isRequestor = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the requestsState property.
     * 
     * @return
     *     possible object is
     *     {@link EFamilyManagerAssignRequestState }
     *     
     */
    public EFamilyManagerAssignRequestState getRequestsState() {
        return requestsState;
    }

    /**
     * Sets the value of the requestsState property.
     * 
     * @param value
     *     allowed object is
     *     {@link EFamilyManagerAssignRequestState }
     *     
     */
    public void setRequestsState(EFamilyManagerAssignRequestState value) {
        this.requestsState = value;
    }

    /**
     * Gets the value of the stateDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStateDate() {
        return stateDate;
    }

    /**
     * Sets the value of the stateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStateDate(XMLGregorianCalendar value) {
        this.stateDate = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescription(JAXBElement<String> value) {
        this.description = value;
    }

}
