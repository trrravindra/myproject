package com.lcl.erefill.core.business;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.lcl.erefill.core.common.entity.DataCarrier;
import com.lcl.erefill.core.vo.ConsentVO;
import com.lcl.erefill.core.vo.ERefillSession;
import com.lcl.erefill.core.vo.ISession;


/*****
 * 
 * @author gpunno
 * version 1.0
 */

@Component
public interface IManagedAccountDelegate {
	public ConsentVO getConsent(DataCarrier dto, ERefillSession session);
	public DataCarrier grantAccess(DataCarrier dto, ERefillSession session);
	public void revokeAccess(DataCarrier dto, ERefillSession session);
	public void familyManagerAssignAccept(DataCarrier dto, ERefillSession session);
	public void familyManagerAssignDecline(DataCarrier dto, ERefillSession session);
	public Map<String,Object> getManagedAccountDetails(ISession iSession) throws Exception;
	public DataCarrier setupCustodianForMinor(DataCarrier dto,ERefillSession session);
	public String getPatientOID(ERefillSession session, String username);
	/**
	 * @param erefillSession
	 * @return
	 */
	public int getMinorAge(ERefillSession erefillSession);
}