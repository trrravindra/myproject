package com.lcl.erefill.core.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lcl.erefill.core.vo.ChangePassword;


/**
 * @author vsha51
 */
@Component
public class ChangePasswordRequestValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return ChangePassword.class.equals(clazz);
	}

	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newpassword", "my.account.new.password.required.errMsg");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmpassword", "my.account.conf.password.required.errMsg");		
	}
}
