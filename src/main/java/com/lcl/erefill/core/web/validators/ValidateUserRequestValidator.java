package com.lcl.erefill.core.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lcl.erefill.core.vo.ValidateUserRequest;


/**
 * @author vsha51
 */
@Component
public class ValidateUserRequestValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return ValidateUserRequest.class.equals(clazz);
	}

	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_token", "session.expired.label");	
		
			
	}
}
