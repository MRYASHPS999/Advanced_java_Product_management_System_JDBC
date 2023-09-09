package com.product_management_system.controller;

import com.product_management_system.dto.Customer;

import com.product_management_system.service.CustomerService;


public class CustomerController {
	public static void main(String[] args) {
		
		
		Customer customer=new Customer();
		
		customer.setC_id(1);
		customer.setC_name("guruji");
		customer.setC_email("guruji@mail.com");
		customer.setPhone_no(1234567890);
		
		CustomerService customerService=new CustomerService();
		
		boolean c = customerService.getCustomerDataById(3);
		System.out.println(c);

		Customer c1 = customerService.getAllCustomerData(customer);
		System.out.println(c1);

		boolean res1 = customerService.updateCustomerById(4);
		System.out.println(res1);

		boolean res = customerService.deleteCustomerById(2);
		System.out.println(res);
		
		
	}

}
