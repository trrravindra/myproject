
package com.lcl.erefill.generated.telus.request.prescription.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eProfileReplicationOperation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eProfileReplicationOperation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="StopReplication"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eProfileReplicationOperation", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EProfileReplicationOperation {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("StopReplication")
    STOP_REPLICATION("StopReplication");
    private final String value;

    EProfileReplicationOperation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EProfileReplicationOperation fromValue(String v) {
        for (EProfileReplicationOperation c: EProfileReplicationOperation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
