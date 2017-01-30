package com.webModule.parenting.ParentingWebModule.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.webModule.parenting.ParentingWebModule.model.CustomerDetailVO;

@Component
public class RegistrationValidator implements Validator{
	
	@Autowired
	@Qualifier("emailValidator")
	EmailValidator emailValidator;

	

	public void validate(Object target, Errors errors) {

		CustomerDetailVO cust = (CustomerDetailVO) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "custName", "NotEmpty.custForm.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerVO.custEmail", "NotEmpty.custForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerVO.custPassword", "NotEmpty.custForm.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword","NotEmpty.custForm.confirmPassword");

		if(checkIfNotEmptyNotNull(cust.getCustomerVO().getCustEmail()) && !emailValidator.valid(cust.getCustomerVO().getCustEmail())){
			errors.rejectValue("customerVO.custEmail", "Pattern.custForm.email");
		}

		if (checkIfNotEmptyNotNull(cust.getCustomerVO().getCustPassword()) && !cust.getCustomerVO().getCustPassword().equals(cust.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "Diff.custform.confirmPassword");
		}
		
		if (checkIfNotEmptyNotNull(cust.getCustomerVO().getCustTelephone()) && !cust.getCustomerVO().getCustTelephone().matches("[0-9]+")) {
			errors.rejectValue("customerVO.custTelephone","NotNumber.custForm.Telephone");
		}
		
		if(checkIfNotEmptyNotNull(cust.getAddressVO().getPostal_code()) && !cust.getAddressVO().getPostal_code().matches("[0-9]+")){
			errors.rejectValue("addressVO.postal_code","NotNumber.custForm.PostalCode");
		}

	}
	
	public boolean supports(Class<?> clazz) {
		return CustomerDetailVO.class.equals(clazz);
	}

	public boolean checkIfNotEmptyNotNull(String value){
		if(value!=null && !value.isEmpty()){
			return true;
		}
		return false;
	}

}
