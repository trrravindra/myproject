
package com.lcl.erefill.generated.telus.operation.rxassystlib_contracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AutomatedRefills complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AutomatedRefills">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AutomatedRefill" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}AutomatedRefill" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AutomatedRefills", propOrder = {
    "automatedRefill"
})
public class AutomatedRefills {

    @XmlElement(name = "AutomatedRefill", nillable = true)
    protected List<AutomatedRefill> automatedRefill;

    /**
     * Gets the value of the automatedRefill property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the automatedRefill property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAutomatedRefill().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AutomatedRefill }
     * 
     * 
     */
    public List<AutomatedRefill> getAutomatedRefill() {
        if (automatedRefill == null) {
            automatedRefill = new ArrayList<AutomatedRefill>();
        }
        return this.automatedRefill;
    }

}
