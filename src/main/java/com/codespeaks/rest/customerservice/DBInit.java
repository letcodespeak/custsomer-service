package com.codespeaks.rest.customerservice;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.codespeaks.rest.customerservice.domain.Account;
import com.codespeaks.rest.customerservice.domain.Customer;
import com.codespeaks.rest.customerservice.repository.AccountRepository;
import com.codespeaks.rest.customerservice.repository.CustomerRepository;

public class DBInit implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public void run(String... args) throws Exception {
		   Customer  mattZhang = new Customer();
		   mattZhang.setCustomerName("Matt Zhang");
		   
		   Date dob = Date.from(LocalDate.of(1980, 03, 16).atStartOfDay(ZoneId.systemDefault()).toInstant());
		   
		   mattZhang.setDateofBirth(dob);
		   mattZhang.setPhoneNumber("+610452623758");
		   mattZhang = customerRepository.save(mattZhang);
		   
		   Account esaver = new Account();
		   esaver.setAccountNumber(10881061);
		   esaver.setBalance(8000.00);
		   Date openingDate = Date.from(LocalDate.of(2016, 05, 16).atStartOfDay(ZoneId.systemDefault()).toInstant());
		   esaver.setOpeningDate(openingDate);
		   esaver.setCustomer(mattZhang);
		   esaver.setAccountName("westpac esaver");
		   
		   accountRepository.save(esaver);
		   
		   
		   Account choice = new Account();
		   choice.setAccountNumber(10881069);
		   choice.setBalance(12000.00);
		   choice.setOpeningDate(openingDate);
		   choice.setCustomer(mattZhang);
		   choice.setAccountName("westpac choice");
		   
		   accountRepository.save(choice);
		   
		   
		   
           

	}

}
