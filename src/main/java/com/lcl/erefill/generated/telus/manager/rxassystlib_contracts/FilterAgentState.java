
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.manager.rxassystlib.EFilterAgentState;


/**
 * <p>Java class for FilterAgentState complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilterAgentState">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="State" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eFilterAgentState" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilterAgentState", propOrder = {
    "state"
})
public class FilterAgentState {

    @XmlElement(name = "State")
    protected EFilterAgentState state;

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link EFilterAgentState }
     *     
     */
    public EFilterAgentState getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link EFilterAgentState }
     *     
     */
    public void setState(EFilterAgentState value) {
        this.state = value;
    }

}
