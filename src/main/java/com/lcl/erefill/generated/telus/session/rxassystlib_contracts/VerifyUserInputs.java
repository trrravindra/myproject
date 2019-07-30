
package com.lcl.erefill.generated.telus.session.rxassystlib_contracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VerifyUserInputs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VerifyUserInputs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VerifyUserInput" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}VerifyUserInput" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VerifyUserInputs", propOrder = {
    "verifyUserInput"
})
public class VerifyUserInputs {

    @XmlElement(name = "VerifyUserInput", nillable = true)
    protected List<VerifyUserInput> verifyUserInput;

    /**
     * Gets the value of the verifyUserInput property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the verifyUserInput property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVerifyUserInput().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VerifyUserInput }
     * 
     * 
     */
    public List<VerifyUserInput> getVerifyUserInput() {
        if (verifyUserInput == null) {
            verifyUserInput = new ArrayList<VerifyUserInput>();
        }
        return this.verifyUserInput;
    }

}
