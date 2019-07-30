
package com.lcl.erefill.generated.telus.operation;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.4
 * 2015-04-27T10:13:38.347+05:30
 * Generated source version: 2.7.4
 */

@WebFault(name = "Error", targetNamespace = "http://schemas.datacontract.org/2004/07/RxAssystLib.Contracts.Error")
public class IOperationSvcGetExpectedRefillReminderErrorFaultFaultMessage extends Exception {
    
    private com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.Error error;

    public IOperationSvcGetExpectedRefillReminderErrorFaultFaultMessage() {
        super();
    }
    
    public IOperationSvcGetExpectedRefillReminderErrorFaultFaultMessage(String message) {
        super(message);
    }
    
    public IOperationSvcGetExpectedRefillReminderErrorFaultFaultMessage(String message, Throwable cause) {
        super(message, cause);
    }

    public IOperationSvcGetExpectedRefillReminderErrorFaultFaultMessage(String message, com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.Error error) {
        super(message);
        this.error = error;
    }

    public IOperationSvcGetExpectedRefillReminderErrorFaultFaultMessage(String message, com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.Error error, Throwable cause) {
        super(message, cause);
        this.error = error;
    }

    public com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.Error getFaultInfo() {
        return this.error;
    }
}
