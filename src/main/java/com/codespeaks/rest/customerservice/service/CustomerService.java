package com.codespeaks.rest.customerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codespeaks.rest.customerservice.domain.Customer;
import com.codespeaks.rest.customerservice.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	

	
	

}
