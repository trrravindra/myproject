
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PatientAssigned complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PatientAssigned">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}Patient">
 *       &lt;sequence>
 *         &lt;element name="AssignmentEntity" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data}AssignmentEntity"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PatientAssigned", propOrder = {
    "assignmentEntity"
})
public class PatientAssigned
    extends Patient
{

    @XmlElement(name = "AssignmentEntity", required = true, nillable = true)
    protected AssignmentEntity assignmentEntity;

    /**
     * Gets the value of the assignmentEntity property.
     * 
     * @return
     *     possible object is
     *     {@link AssignmentEntity }
     *     
     */
    public AssignmentEntity getAssignmentEntity() {
        return assignmentEntity;
    }

    /**
     * Sets the value of the assignmentEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssignmentEntity }
     *     
     */
    public void setAssignmentEntity(AssignmentEntity value) {
        this.assignmentEntity = value;
    }

}
