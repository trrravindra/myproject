
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.manager.rxassystlib.EEventMessageState;


/**
 * <p>Java class for EventMessageState complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EventMessageState">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="State" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eEventMessageState"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventMessageState", propOrder = {
    "state"
})
public class EventMessageState {

    @XmlElement(name = "State", required = true)
    protected EEventMessageState state;

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link EEventMessageState }
     *     
     */
    public EEventMessageState getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link EEventMessageState }
     *     
     */
    public void setState(EEventMessageState value) {
        this.state = value;
    }

}
