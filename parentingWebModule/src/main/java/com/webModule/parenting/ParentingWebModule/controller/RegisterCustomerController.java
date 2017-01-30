package com.webModule.parenting.ParentingWebModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webModule.parenting.ParentingWebModule.model.CustomerDetailVO;
import com.webModule.parenting.ParentingWebModule.model.CustomerVO;
import com.webModule.parenting.ParentingWebModule.service.CustomerLoginService;
import com.webModule.parenting.ParentingWebModule.validator.RegistrationValidator;

@Controller
public class RegisterCustomerController {
	
	@Autowired
	RegistrationValidator registrationValidator;
	
	public void setRegistrationValidator(RegistrationValidator registrationValidator) {
		this.registrationValidator = registrationValidator;
	}

	@RequestMapping(value = "/registerCustomer", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter your to details to register");
		model.addAttribute("customerDetailVO", new CustomerDetailVO());
		return "registerCustomer";
	}
	
	
	@RequestMapping(value = "/registerCustomer",method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("customerDetailVO")  CustomerDetailVO customerDetailVO, BindingResult result) {
		CustomerVO cust;
		registrationValidator.validate(customerDetailVO, result);
		if (result.hasErrors()) {
			
			return "registerCustomer";
		}
		try {
			cust = CustomerLoginService.createCustomer(customerDetailVO);
			System.out.println(cust.getCustEmail());
			model.addAttribute("success", " There Customer has been Successfully Registered. Please login");
			model.addAttribute("isSucessfull", new Boolean(true));
		} catch (Exception e) {
			// TODO add logging information
			e.printStackTrace();
			model.addAttribute("error", " There is an internal issue in registering the customer.");
		}
		
		return "registerCustomer";
	}
		
}
