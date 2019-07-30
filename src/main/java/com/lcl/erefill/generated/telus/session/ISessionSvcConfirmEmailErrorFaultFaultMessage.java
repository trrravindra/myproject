
package com.lcl.erefill.generated.telus.session;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.5
 * 2015-12-10T17:37:00.495+05:30
 * Generated source version: 2.7.5
 */

@WebFault(name = "Error", targetNamespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Error")
public class ISessionSvcConfirmEmailErrorFaultFaultMessage extends Exception {
    
    private com.lcl.erefill.generated.telus.session.rxassystlib_contracts.Error error;

    public ISessionSvcConfirmEmailErrorFaultFaultMessage() {
        super();
    }
    
    public ISessionSvcConfirmEmailErrorFaultFaultMessage(String message) {
        super(message);
    }
    
    public ISessionSvcConfirmEmailErrorFaultFaultMessage(String message, Throwable cause) {
        super(message, cause);
    }

    public ISessionSvcConfirmEmailErrorFaultFaultMessage(String message, com.lcl.erefill.generated.telus.session.rxassystlib_contracts.Error error) {
        super(message);
        this.error = error;
    }

    public ISessionSvcConfirmEmailErrorFaultFaultMessage(String message, com.lcl.erefill.generated.telus.session.rxassystlib_contracts.Error error, Throwable cause) {
        super(message, cause);
        this.error = error;
    }

    public com.lcl.erefill.generated.telus.session.rxassystlib_contracts.Error getFaultInfo() {
        return this.error;
    }
}
