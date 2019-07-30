package com.lcl.erefill.core.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lcl.erefill.core.vo.ValidateSecurityAnswerRequest;


/**
 * @author vsha51
 */
@Component
public class SecurityAnswerRequestValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return ValidateSecurityAnswerRequest.class.equals(clazz);
	}

	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "answer", "security.ans.required.errMsg");
		if(errors.hasErrors()){
			return;
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "sys.errMsg");		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "choice", "sys.errMsg");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "question", "sys.errMsg");	
	}
}
