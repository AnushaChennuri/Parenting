package com.webModule.parenting.ParentingWebModule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webModule.parenting.ParentingWebModule.model.CustomerVO;
import com.webModule.parenting.ParentingWebModule.service.CustomerLoginService;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("customerVO") CustomerVO customerVO) {
		if (customerVO != null && customerVO.getCustEmail() != null & customerVO.getCustPassword() != null) {
			CustomerVO cust=CustomerLoginService.getEmployeeById(customerVO);
			
			if (cust!=null && customerVO!=null && customerVO.getCustEmail().equals(cust.getCustEmail())) {
				model.addAttribute("msg", customerVO.getCustEmail());
				return "success";
			} else {
				model.addAttribute("error", "Invalid Details");
				return "login";
			}
		} else {
			model.addAttribute("error", "Please enter Details");
			return "login";
		}
	}
}
