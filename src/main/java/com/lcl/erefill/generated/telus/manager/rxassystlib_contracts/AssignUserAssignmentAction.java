
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.manager.rxassystlib.EAssignmentAction;


/**
 * <p>Java class for AssignUserAssignmentAction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssignUserAssignmentAction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AssignmentAction" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eAssignmentAction"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssignUserAssignmentAction", propOrder = {
    "assignmentAction"
})
public class AssignUserAssignmentAction {

    @XmlElement(name = "AssignmentAction", required = true)
    protected EAssignmentAction assignmentAction;

    /**
     * Gets the value of the assignmentAction property.
     * 
     * @return
     *     possible object is
     *     {@link EAssignmentAction }
     *     
     */
    public EAssignmentAction getAssignmentAction() {
        return assignmentAction;
    }

    /**
     * Sets the value of the assignmentAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link EAssignmentAction }
     *     
     */
    public void setAssignmentAction(EAssignmentAction value) {
        this.assignmentAction = value;
    }

}
