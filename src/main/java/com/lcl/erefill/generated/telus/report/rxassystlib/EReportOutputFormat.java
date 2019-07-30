
package com.lcl.erefill.generated.telus.report.rxassystlib;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eReportOutputFormat.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eReportOutputFormat">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="XML"/>
 *     &lt;enumeration value="CSV"/>
 *     &lt;enumeration value="PDF"/>
 *     &lt;enumeration value="MHTML"/>
 *     &lt;enumeration value="EXCEL"/>
 *     &lt;enumeration value="WORD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eReportOutputFormat", namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Codes")
@XmlEnum
public enum EReportOutputFormat {

    XML,
    CSV,
    PDF,
    MHTML,
    EXCEL,
    WORD;

    public String value() {
        return name();
    }

    public static EReportOutputFormat fromValue(String v) {
        return valueOf(v);
    }

}
