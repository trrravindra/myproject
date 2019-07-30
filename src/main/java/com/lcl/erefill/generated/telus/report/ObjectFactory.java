
package com.lcl.erefill.generated.telus.report;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import com.lcl.erefill.generated.telus.report.microsoft_reporting_webforms_internal_soap_reportingservices2005.ArrayOfReportParameter;
import com.lcl.erefill.generated.telus.report.rxassystlib_contracts.ReportInput;
import com.lcl.erefill.generated.telus.report.rxassystlib_contracts.ReportName;
import com.lcl.erefill.generated.telus.report.rxassystlib_contracts.StatisticResults;
import com.lcl.erefill.generated.telus.report.rxassystlib_contracts.UserToken;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ReportParameter_QNAME = new QName("http://tempuri.org/", "ReportParameter");
    private final static QName _StatisticDateFrom_QNAME = new QName("http://tempuri.org/", "StatisticDateFrom");
    private final static QName _ReportInput_QNAME = new QName("http://tempuri.org/", "ReportInput");
    private final static QName _Content_QNAME = new QName("http://tempuri.org/", "Content");
    private final static QName _MimeType_QNAME = new QName("http://tempuri.org/", "MimeType");
    private final static QName _StatisticResults_QNAME = new QName("http://tempuri.org/", "StatisticResults");
    private final static QName _StatisticDateTo_QNAME = new QName("http://tempuri.org/", "StatisticDateTo");
    private final static QName _Extension_QNAME = new QName("http://tempuri.org/", "Extension");
    private final static QName _ReportName_QNAME = new QName("http://tempuri.org/", "ReportName");
    private final static QName _UserToken_QNAME = new QName("http://tempuri.org/", "UserToken");
    private final static QName _StatisticType_QNAME = new QName("http://tempuri.org/", "StatisticType");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfReportParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ReportParameter")
    public JAXBElement<ArrayOfReportParameter> createReportParameter(ArrayOfReportParameter value) {
        return new JAXBElement<ArrayOfReportParameter>(_ReportParameter_QNAME, ArrayOfReportParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "StatisticDateFrom")
    public JAXBElement<XMLGregorianCalendar> createStatisticDateFrom(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_StatisticDateFrom_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportInput }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ReportInput")
    public JAXBElement<ReportInput> createReportInput(ReportInput value) {
        return new JAXBElement<ReportInput>(_ReportInput_QNAME, ReportInput.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Content")
    public JAXBElement<byte[]> createContent(byte[] value) {
        return new JAXBElement<byte[]>(_Content_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "MimeType")
    public JAXBElement<String> createMimeType(String value) {
        return new JAXBElement<String>(_MimeType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatisticResults }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "StatisticResults")
    public JAXBElement<StatisticResults> createStatisticResults(StatisticResults value) {
        return new JAXBElement<StatisticResults>(_StatisticResults_QNAME, StatisticResults.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "StatisticDateTo")
    public JAXBElement<XMLGregorianCalendar> createStatisticDateTo(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_StatisticDateTo_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Extension")
    public JAXBElement<String> createExtension(String value) {
        return new JAXBElement<String>(_Extension_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ReportName")
    public JAXBElement<ReportName> createReportName(ReportName value) {
        return new JAXBElement<ReportName>(_ReportName_QNAME, ReportName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "UserToken")
    public JAXBElement<UserToken> createUserToken(UserToken value) {
        return new JAXBElement<UserToken>(_UserToken_QNAME, UserToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "StatisticType")
    public JAXBElement<Integer> createStatisticType(Integer value) {
        return new JAXBElement<Integer>(_StatisticType_QNAME, Integer.class, null, value);
    }

}
