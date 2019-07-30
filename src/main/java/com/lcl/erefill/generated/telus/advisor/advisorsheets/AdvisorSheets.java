package com.lcl.erefill.generated.telus.advisor.advisorsheets;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.4
 * 2015-04-24T16:18:11.979+05:30
 * Generated source version: 2.7.4
 * 
 */
@WebServiceClient(name = "AdvisorSheets", 
                  wsdlLocation = "http://dev.rxassyst.com/BlackBoxloblaws/1_1_0/Advisor/AdvisorSheets.svc?wsdl",
                  targetNamespace = "http://tempuri.org/") 
public class AdvisorSheets extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://tempuri.org/", "AdvisorSheets");
    public final static QName BasicHttpBindingIAdvisorSheetsSvc = new QName("http://tempuri.org/", "BasicHttpBinding_IAdvisorSheetsSvc");
    static {
        URL url = null;
        try {
            url = new URL("http://dev.rxassyst.com/BlackBoxloblaws/1_1_0/Advisor/AdvisorSheets.svc?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(AdvisorSheets.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://dev.rxassyst.com/BlackBoxloblaws/1_1_0/Advisor/AdvisorSheets.svc?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public AdvisorSheets(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public AdvisorSheets(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AdvisorSheets() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns IAdvisorSheetsSvc
     */
    @WebEndpoint(name = "BasicHttpBinding_IAdvisorSheetsSvc")
    public IAdvisorSheetsSvc getBasicHttpBindingIAdvisorSheetsSvc() {
        return super.getPort(BasicHttpBindingIAdvisorSheetsSvc, IAdvisorSheetsSvc.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IAdvisorSheetsSvc
     */
    @WebEndpoint(name = "BasicHttpBinding_IAdvisorSheetsSvc")
    public IAdvisorSheetsSvc getBasicHttpBindingIAdvisorSheetsSvc(WebServiceFeature... features) {
        return super.getPort(BasicHttpBindingIAdvisorSheetsSvc, IAdvisorSheetsSvc.class, features);
    }

}
