
package com.lcl.erefill.generated.telus.report.microsoft_reporting_webforms_internal_soap_reportingservices2005;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lcl.erefill.generated.telus.report.microsoft_reporting_webforms_internal_soap_reportingservices2005 package. 
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

    private final static QName _ParameterTypeEnum_QNAME = new QName("http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution", "ParameterTypeEnum");
    private final static QName _ValidValue_QNAME = new QName("http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution", "ValidValue");
    private final static QName _ArrayOfParameterValue_QNAME = new QName("http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution", "ArrayOfParameterValue");
    private final static QName _ParameterValueOrFieldReference_QNAME = new QName("http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution", "ParameterValueOrFieldReference");
    private final static QName _ParameterValue_QNAME = new QName("http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution", "ParameterValue");
    private final static QName _ArrayOfValidValue_QNAME = new QName("http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution", "ArrayOfValidValue");
    private final static QName _ArrayOfReportParameter_QNAME = new QName("http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution", "ArrayOfReportParameter");
    private final static QName _ParameterStateEnum_QNAME = new QName("http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution", "ParameterStateEnum");
    private final static QName _ReportParameter_QNAME = new QName("http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution", "ReportParameter");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lcl.erefill.generated.telus.report.microsoft_reporting_webforms_internal_soap_reportingservices2005
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidValue }
     * 
     */
    public ValidValue createValidValue() {
        return new ValidValue();
    }

    /**
     * Create an instance of {@link ArrayOfValidValue }
     * 
     */
    public ArrayOfValidValue createArrayOfValidValue() {
        return new ArrayOfValidValue();
    }

    /**
     * Create an instance of {@link ReportParameter }
     * 
     */
    public ReportParameter createReportParameter() {
        return new ReportParameter();
    }

    /**
     * Create an instance of {@link ParameterValue }
     * 
     */
    public ParameterValue createParameterValue() {
        return new ParameterValue();
    }

    /**
     * Create an instance of {@link ArrayOfParameterValue }
     * 
     */
    public ArrayOfParameterValue createArrayOfParameterValue() {
        return new ArrayOfParameterValue();
    }

    /**
     * Create an instance of {@link ArrayOfReportParameter }
     * 
     */
    public ArrayOfReportParameter createArrayOfReportParameter() {
        return new ArrayOfReportParameter();
    }

    /**
     * Create an instance of {@link ParameterValueOrFieldReference }
     * 
     */
    public ParameterValueOrFieldReference createParameterValueOrFieldReference() {
        return new ParameterValueOrFieldReference();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParameterTypeEnum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution", name = "ParameterTypeEnum")
    public JAXBElement<ParameterTypeEnum> createParameterTypeEnum(ParameterTypeEnum value) {
        return new JAXBElement<ParameterTypeEnum>(_ParameterTypeEnum_QNAME, ParameterTypeEnum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution", name = "ValidValue")
    public JAXBElement<ValidValue> createValidValue(ValidValue value) {
        return new JAXBElement<ValidValue>(_ValidValue_QNAME, ValidValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfParameterValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution", name = "ArrayOfParameterValue")
    public JAXBElement<ArrayOfParameterValue> createArrayOfParameterValue(ArrayOfParameterValue value) {
        return new JAXBElement<ArrayOfParameterValue>(_ArrayOfParameterValue_QNAME, ArrayOfParameterValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParameterValueOrFieldReference }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution", name = "ParameterValueOrFieldReference")
    public JAXBElement<ParameterValueOrFieldReference> createParameterValueOrFieldReference(ParameterValueOrFieldReference value) {
        return new JAXBElement<ParameterValueOrFieldReference>(_ParameterValueOrFieldReference_QNAME, ParameterValueOrFieldReference.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParameterValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution", name = "ParameterValue")
    public JAXBElement<ParameterValue> createParameterValue(ParameterValue value) {
        return new JAXBElement<ParameterValue>(_ParameterValue_QNAME, ParameterValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfValidValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution", name = "ArrayOfValidValue")
    public JAXBElement<ArrayOfValidValue> createArrayOfValidValue(ArrayOfValidValue value) {
        return new JAXBElement<ArrayOfValidValue>(_ArrayOfValidValue_QNAME, ArrayOfValidValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfReportParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution", name = "ArrayOfReportParameter")
    public JAXBElement<ArrayOfReportParameter> createArrayOfReportParameter(ArrayOfReportParameter value) {
        return new JAXBElement<ArrayOfReportParameter>(_ArrayOfReportParameter_QNAME, ArrayOfReportParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParameterStateEnum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution", name = "ParameterStateEnum")
    public JAXBElement<ParameterStateEnum> createParameterStateEnum(ParameterStateEnum value) {
        return new JAXBElement<ParameterStateEnum>(_ParameterStateEnum_QNAME, ParameterStateEnum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Microsoft.Reporting.WebForms.Internal.Soap.ReportingServices2005.Execution", name = "ReportParameter")
    public JAXBElement<ReportParameter> createReportParameter(ReportParameter value) {
        return new JAXBElement<ReportParameter>(_ReportParameter_QNAME, ReportParameter.class, null, value);
    }

}
