
package com.lcl.erefill.generated.telus.report.rxassystlib_contracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lcl.erefill.generated.telus.report.rxassystlib_contracts package. 
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

    private final static QName _UserTokenToken_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "Token");
    private final static QName _Error_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Error", "Error");
    private final static QName _UserToken_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "UserToken");
    private final static QName _ReportName_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ReportName");
    private final static QName _StatisticResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "StatisticResult");
    private final static QName _ReportMonthlyData_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ReportMonthlyData");
    private final static QName _StatisticResults_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "StatisticResults");
    private final static QName _ReportInput_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ReportInput");
    private final static QName _ReportOperationSourceStat_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", "ReportOperationSourceStat");
    private final static QName _ErrorUserToken_QNAME = new QName("http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Error", "UserToken");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lcl.erefill.generated.telus.report.rxassystlib_contracts
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new Error();
    }

    /**
     * Create an instance of {@link StatisticResults }
     * 
     */
    public StatisticResults createStatisticResults() {
        return new StatisticResults();
    }

    /**
     * Create an instance of {@link ReportName }
     * 
     */
    public ReportName createReportName() {
        return new ReportName();
    }

    /**
     * Create an instance of {@link UserToken }
     * 
     */
    public UserToken createUserToken() {
        return new UserToken();
    }

    /**
     * Create an instance of {@link ReportInput }
     * 
     */
    public ReportInput createReportInput() {
        return new ReportInput();
    }

    /**
     * Create an instance of {@link ReportMonthlyData }
     * 
     */
    public ReportMonthlyData createReportMonthlyData() {
        return new ReportMonthlyData();
    }

    /**
     * Create an instance of {@link ReportOperationSourceStat }
     * 
     */
    public ReportOperationSourceStat createReportOperationSourceStat() {
        return new ReportOperationSourceStat();
    }

    /**
     * Create an instance of {@link StatisticResult }
     * 
     */
    public StatisticResult createStatisticResult() {
        return new StatisticResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "Token", scope = UserToken.class)
    public JAXBElement<byte[]> createUserTokenToken(byte[] value) {
        return new JAXBElement<byte[]>(_UserTokenToken_QNAME, byte[].class, UserToken.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Error }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Error", name = "Error")
    public JAXBElement<Error> createError(Error value) {
        return new JAXBElement<Error>(_Error_QNAME, Error.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "UserToken")
    public JAXBElement<UserToken> createUserToken(UserToken value) {
        return new JAXBElement<UserToken>(_UserToken_QNAME, UserToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ReportName")
    public JAXBElement<ReportName> createReportName(ReportName value) {
        return new JAXBElement<ReportName>(_ReportName_QNAME, ReportName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatisticResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "StatisticResult")
    public JAXBElement<StatisticResult> createStatisticResult(StatisticResult value) {
        return new JAXBElement<StatisticResult>(_StatisticResult_QNAME, StatisticResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportMonthlyData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ReportMonthlyData")
    public JAXBElement<ReportMonthlyData> createReportMonthlyData(ReportMonthlyData value) {
        return new JAXBElement<ReportMonthlyData>(_ReportMonthlyData_QNAME, ReportMonthlyData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatisticResults }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "StatisticResults")
    public JAXBElement<StatisticResults> createStatisticResults(StatisticResults value) {
        return new JAXBElement<StatisticResults>(_StatisticResults_QNAME, StatisticResults.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportInput }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ReportInput")
    public JAXBElement<ReportInput> createReportInput(ReportInput value) {
        return new JAXBElement<ReportInput>(_ReportInput_QNAME, ReportInput.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportOperationSourceStat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Data", name = "ReportOperationSourceStat")
    public JAXBElement<ReportOperationSourceStat> createReportOperationSourceStat(ReportOperationSourceStat value) {
        return new JAXBElement<ReportOperationSourceStat>(_ReportOperationSourceStat_QNAME, ReportOperationSourceStat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Error", name = "UserToken", scope = Error.class)
    public JAXBElement<UserToken> createErrorUserToken(UserToken value) {
        return new JAXBElement<UserToken>(_ErrorUserToken_QNAME, UserToken.class, Error.class, value);
    }

}
