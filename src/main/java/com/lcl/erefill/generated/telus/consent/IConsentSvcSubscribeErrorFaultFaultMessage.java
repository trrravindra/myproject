
package com.lcl.erefill.generated.telus.consent;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.4
 * 2013-12-27T19:06:53.923+05:30
 * Generated source version: 2.7.4
 */

@WebFault(name = "Error", targetNamespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Error")
public class IConsentSvcSubscribeErrorFaultFaultMessage extends Exception {
    
    private com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.Error error;

    public IConsentSvcSubscribeErrorFaultFaultMessage() {
        super();
    }
    
    public IConsentSvcSubscribeErrorFaultFaultMessage(String message) {
        super(message);
    }
    
    public IConsentSvcSubscribeErrorFaultFaultMessage(String message, Throwable cause) {
        super(message, cause);
    }

    public IConsentSvcSubscribeErrorFaultFaultMessage(String message, com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.Error error) {
        super(message);
        this.error = error;
    }

    public IConsentSvcSubscribeErrorFaultFaultMessage(String message, com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.Error error, Throwable cause) {
        super(message, cause);
        this.error = error;
    }

    public com.lcl.erefill.generated.telus.consent.rxassystlib_contracts.Error getFaultInfo() {
        return this.error;
    }
}
