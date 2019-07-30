
package com.lcl.erefill.generated.telus.session.rxassystlib_contracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.lcl.erefill.generated.telus.session.rxassystlib.LogonAudit;


/**
 * <p>Java class for LogonAudits complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LogonAudits">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LogonAudit" type="{http://schemas.datacontract.org/2004/07/RxAssystLib}LogonAudit" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogonAudits", propOrder = {
    "logonAudit"
})
public class LogonAudits {

    @XmlElement(name = "LogonAudit", nillable = true)
    protected List<LogonAudit> logonAudit;

    /**
     * Gets the value of the logonAudit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logonAudit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogonAudit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogonAudit }
     * 
     * 
     */
    public List<LogonAudit> getLogonAudit() {
        if (logonAudit == null) {
            logonAudit = new ArrayList<LogonAudit>();
        }
        return this.logonAudit;
    }

}
