package com.lcl.erefill.generated.telus.manager;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

/**
 * This class was generated by Apache CXF 2.7.7
 * 2013-12-20T14:34:47.389+05:30
 * Generated source version: 2.7.7
 * 
 */
@WebServiceClient(name = "RxAssyst", 
                  wsdlLocation = "META-INF/wsdl/manager/ManagerSvc.wsdl",
                  targetNamespace = "http://tempuri.org/") 
public class RxAssyst extends Service {

    public final static URL WSDL_LOCATION = null;

    public final static QName SERVICE = new QName("http://tempuri.org/", "RxAssyst");
    public final static QName RxAssystManagerEndPoint = new QName("http://tempuri.org/", "RxAssystManagerEndPoint");
    /*static {
        URL url = null;
        try {
            url = new URL("http://dev.rxassyst.com/BlackBoxloblaws/1_1_0/Manager/RxAssyst.svc?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(RxAssyst.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://dev.rxassyst.com/BlackBoxloblaws/1_1_0/Manager/RxAssyst.svc?wsdl");
        }
        WSDL_LOCATION = url;
    }*/

    public RxAssyst(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public RxAssyst(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RxAssyst() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns IManagerSvc
     */
    @WebEndpoint(name = "RxAssystManagerEndPoint")
    public IManagerSvc getRxAssystManagerEndPoint() {
        return super.getPort(RxAssystManagerEndPoint, IManagerSvc.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IManagerSvc
     */
    @WebEndpoint(name = "RxAssystManagerEndPoint")
    public IManagerSvc getRxAssystManagerEndPoint(WebServiceFeature... features) {
        return super.getPort(RxAssystManagerEndPoint, IManagerSvc.class, features);
    }

}
