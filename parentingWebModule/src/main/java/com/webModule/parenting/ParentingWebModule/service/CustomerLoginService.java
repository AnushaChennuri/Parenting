package com.webModule.parenting.ParentingWebModule.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.webModule.parenting.ParentingWebModule.model.CustomerDetailVO;
import com.webModule.parenting.ParentingWebModule.model.CustomerVO;

public class CustomerLoginService {
	
	private static RestTemplate restTemplate = new RestTemplate();
	
	public static  CustomerVO getEmployeeById(CustomerVO custVO)
	{
	    final String uri = "http://localhost:8080/parenting/checkCustomer/{username}/{password}";
	     
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("username", custVO.getCustEmail());
	    params.put("password",custVO.getCustPassword());
	     
	    //RestTemplate restTemplate = new RestTemplate();
	    CustomerVO result = restTemplate.getForObject(uri, CustomerVO.class, params);
	    
	    System.out.println(result);
	    return result;
	}
	
	public static  CustomerVO createCustomer(CustomerDetailVO customerDetailVO) throws Exception{
		
		final String uri = "http://localhost:8080/parenting/registerNewCustomer";
		CustomerVO result=null;
		try
		{
			result=restTemplate.postForObject(uri, customerDetailVO, CustomerVO.class);
			System.out.println(result);
		}catch(Exception e){
			//todo log the exception
			throw new Exception(e.getMessage());
		}
		
	    return result;
		
	}

}
