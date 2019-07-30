package com.lcl.erefill.core.common.telus.response;

import com.lcl.erefill.core.common.entity.UserToken;
import com.lcl.erefill.generated.telus.session.rxassystlib.LogOnDetail;

public class LogOnUserResponse extends UserToken{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LogOnDetail logOnDetail;
	
	public LogOnDetail getLogOnDetail() {
		return logOnDetail;
	}
	public void setLogOnDetail(LogOnDetail logOnDetail) {
		this.logOnDetail = logOnDetail;
	}

}
