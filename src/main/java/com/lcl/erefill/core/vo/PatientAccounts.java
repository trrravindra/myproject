package com.lcl.erefill.core.vo;

import java.util.ArrayList;
import java.util.List;



public class PatientAccounts {

    protected List<PatientAccount> patientAccount;
    
    public List<PatientAccount> getPatientAccount() {
        if (patientAccount == null) {
            patientAccount = new ArrayList<PatientAccount>();
        }
        return this.patientAccount;
    }
}
