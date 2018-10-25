package com.codespeaks.rest.service.customerservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.codespeaks.rest.service.customerservice.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
