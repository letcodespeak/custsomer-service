package com.codespeaks.rest.service.customerservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.codespeaks.rest.service.customerservice.domain.Account;
import com.codespeaks.rest.service.customerservice.domain.Customer;
import com.codespeaks.rest.service.customerservice.exception.ResourceNotFoundException;
import com.codespeaks.rest.service.customerservice.repository.AccountRepository;
import com.codespeaks.rest.service.customerservice.repository.CustomerRepository;

@RestController
public class AccountController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@PostMapping(value = "/customers/{customerId}/accounts")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Account save(@PathVariable Integer customerId,@RequestBody Account  account) {
		return customerRepository.findById(customerId).map(customer -> {
			account.setCustomer(customer);
			return accountRepository.save(account);
			
		}).orElseThrow(() -> new ResourceNotFoundException("Customer [customerId="+customerId+"] can't be found"));

	 }
	
	@GetMapping(value = "/customers/{customerId}/accounts") 
	 public Page<Account> all (@PathVariable Integer customerId,Pageable pageable){ 
              return accountRepository.findByCustomerCustomerId(customerId, pageable);
	 } 
	
	@DeleteMapping(value = "/customers/{customerId}/accounts/{accountId}")
	public ResponseEntity<?> deleteAccount(@PathVariable Integer customerId,@PathVariable Integer accountId){

		if (!customerRepository.existsById(customerId)) {
			throw new ResourceNotFoundException("Customer [customerId="+customerId+"] can't be found");
		}
		
		return accountRepository.findById(accountId).map(account ->{
			   accountRepository.delete(account);
			   return ResponseEntity.ok().build();
		       }).orElseThrow(() -> new ResourceNotFoundException("Account [accountId="+accountId+"] can't be found"));
		
		

	}
	
	@PutMapping(value = "/customers/{customerId}/accounts/{accountId}")
	public ResponseEntity<Account> updateAccount(@PathVariable Integer customerId,@PathVariable Integer accountId,@RequestBody Account newAccount){

		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer [customerId="+customerId+"] can't be found"));
		
		return accountRepository.findById(accountId).map(account ->{
			   newAccount.setCustomer(customer);
			   accountRepository.save(newAccount);
			   return ResponseEntity.ok(newAccount);
		       }).orElseThrow(() -> new ResourceNotFoundException("Account [accountId="+accountId+"] can't be found"));

		
	}

}
