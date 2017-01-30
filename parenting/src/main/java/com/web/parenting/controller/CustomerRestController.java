package com.web.parenting.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.parenting.model.CustomerDetailVO;
import com.web.parenting.model.CustomerVO;
import com.web.parenting.service.CustomerServiceImpl;




@RestController
public class CustomerRestController {
	
	CustomerServiceImpl custService;
	
	@Autowired
	public CustomerRestController(CustomerServiceImpl custService){
		this.custService=custService;
	}
	
	@RequestMapping(value = "/checkCustomer/{custEmail}/{custPassword}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerVO> getUser(@PathVariable("custEmail") String custEmail,@PathVariable("custPassword") String custPass ) {
		//System.out.println("Fetching User with id " + id);
		CustomerVO customer = new CustomerVO();
		customer.setCustEmail(custEmail);
		customer.setCustPassword(custPass);
		//boolean custFound= custService.isCustomerExsist(customer);
		CustomerVO custDB=custService.isCustomerExsist(customer);
		if(null==custDB){
			System.out.println("User with custEmail " + custEmail + " not found");
			//return new ResponseEntity<CustomerVO>(custDB,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CustomerVO>(custDB, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/registerNewCustomer", method = RequestMethod.POST,  headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerVO> registerNewUser(@RequestBody CustomerDetailVO customerDetailVO) {
	    System.out.println("Request: "+customerDetailVO.getCustomerVO().getCustEmail());
	    CustomerVO customer=custService.insertNewCustomer(customerDetailVO);
	    return new ResponseEntity<CustomerVO>(customer, HttpStatus.OK);

	}

}
