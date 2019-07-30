
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.manager.rxassystlib.EAssignmentStatus;


/**
 * <p>Java class for UserAccountsAssignmentStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserAccountsAssignmentStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AssignmentStatus" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eAssignmentStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserAccountsAssignmentStatus", propOrder = {
    "assignmentStatus"
})
public class UserAccountsAssignmentStatus {

    @XmlElement(name = "AssignmentStatus")
    protected EAssignmentStatus assignmentStatus;

    /**
     * Gets the value of the assignmentStatus property.
     * 
     * @return
     *     possible object is
     *     {@link EAssignmentStatus }
     *     
     */
    public EAssignmentStatus getAssignmentStatus() {
        return assignmentStatus;
    }

    /**
     * Sets the value of the assignmentStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link EAssignmentStatus }
     *     
     */
    public void setAssignmentStatus(EAssignmentStatus value) {
        this.assignmentStatus = value;
    }

}
