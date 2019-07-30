
package com.lcl.erefill.generated.telus.manager;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.7
 * 2013-12-20T14:34:47.201+05:30
 * Generated source version: 2.7.7
 */

@WebFault(name = "Error", targetNamespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Error")
public class IManagerSvcGetParametersPermissionErrorFaultFaultMessage extends Exception {
    
    private com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.Error error;

    public IManagerSvcGetParametersPermissionErrorFaultFaultMessage() {
        super();
    }
    
    public IManagerSvcGetParametersPermissionErrorFaultFaultMessage(String message) {
        super(message);
    }
    
    public IManagerSvcGetParametersPermissionErrorFaultFaultMessage(String message, Throwable cause) {
        super(message, cause);
    }

    public IManagerSvcGetParametersPermissionErrorFaultFaultMessage(String message, com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.Error error) {
        super(message);
        this.error = error;
    }

    public IManagerSvcGetParametersPermissionErrorFaultFaultMessage(String message, com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.Error error, Throwable cause) {
        super(message, cause);
        this.error = error;
    }

    public com.lcl.erefill.generated.telus.manager.rxassystlib_contracts.Error getFaultInfo() {
        return this.error;
    }
}
