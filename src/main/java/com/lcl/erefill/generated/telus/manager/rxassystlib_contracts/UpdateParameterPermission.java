
package com.lcl.erefill.generated.telus.manager.rxassystlib_contracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;

import com.lcl.erefill.generated.telus.manager.rxassystlib.EGroup;


/**
 * <p>Java class for UpdateParameterPermission complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateParameterPermission">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Group" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eGroup"/>
 *         &lt;element name="Name" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eParameterProperty"/>
 *         &lt;element name="Permissions" type="{http://schemas.datacontract.org/2004/07/RxAssystLib.Codes}eParameterAccess"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateParameterPermission", propOrder = {
    "group",
    "name",
    "permissions"
})
public class UpdateParameterPermission {

    @XmlElement(name = "Group", required = true)
    protected EGroup group;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlList
    @XmlElement(name = "Permissions", required = true)
    protected List<String> permissions;

    /**
     * Gets the value of the group property.
     * 
     * @return
     *     possible object is
     *     {@link EGroup }
     *     
     */
    public EGroup getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *     allowed object is
     *     {@link EGroup }
     *     
     */
    public void setGroup(EGroup value) {
        this.group = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the permissions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the permissions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPermissions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPermissions() {
        if (permissions == null) {
            permissions = new ArrayList<String>();
        }
        return this.permissions;
    }

}
